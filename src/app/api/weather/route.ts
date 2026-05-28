import { NextResponse } from 'next/server';

export const dynamic = 'force-dynamic';

// OWM Current Weather API 2.5 — free tier, no daily cap concern
// One Call 4.0 quota (900/day) is NOT consumed by this endpoint.
// Docs: https://openweathermap.org/current

const DAILY_CAP = 900;
let _usageDate = '';
let _usageCount = 0;

function checkAndIncrement(): boolean {
  const today = new Date().toISOString().slice(0, 10);
  if (_usageDate !== today) { _usageDate = today; _usageCount = 0; }
  if (_usageCount >= DAILY_CAP) return false;
  _usageCount++;
  return true;
}

function getOwmKey(): string {
  return process.env.OPENWEATHERMAP_API_KEY || '';
}

const WEATHER_ICONS: Record<string, string> = {
  'thunderstorm': '⛈️', 'drizzle': '🌦️',
  'light rain': '🌦️', 'moderate rain': '🌧️', 'heavy': '🌧️',
  'snow': '❄️', 'sleet': '🌨️', 'mist': '🌫️', 'fog': '🌫️', 'haze': '🌫️',
  'smoke': '🌫️', 'dust': '🌫️', 'sand': '🌫️', 'ash': '🌋', 'squall': '💨', 'tornado': '🌪️',
  'clear sky': '☀️', 'few clouds': '🌤️', 'scattered clouds': '⛅',
  'broken clouds': '☁️', 'overcast clouds': '☁️',
};

function weatherIcon(desc: string): string {
  const lower = desc.toLowerCase();
  for (const [k, v] of Object.entries(WEATHER_ICONS)) {
    if (lower.includes(k)) return v;
  }
  return '🌡️';
}

function windDirection(deg: number): string {
  const dirs = ['N','NE','E','SE','S','SW','W','NW'];
  return dirs[Math.round(deg / 45) % 8];
}

export async function GET(req: Request) {
  const key = getOwmKey();
  if (!key) return NextResponse.json({ error: 'OWM key not configured' }, { status: 503 });

  if (!checkAndIncrement()) {
    return NextResponse.json({ error: 'OWM daily cap reached (900/day)' }, { status: 429 });
  }

  const url = new URL(req.url);
  const zip = url.searchParams.get('zip') || '34689';
  const lat = url.searchParams.get('lat');
  const lon = url.searchParams.get('lon');

  // Build location param: prefer explicit lat/lon, fall back to zip
  const locationParam = (lat && lon)
    ? `lat=${lat}&lon=${lon}`
    : `zip=${zip},US`;

  try {
    const res = await fetch(
      `https://api.openweathermap.org/data/2.5/weather?${locationParam}&appid=${key}&units=imperial`,
      { signal: AbortSignal.timeout(8000), cache: 'no-store' }
    );

    if (!res.ok) {
      const err = await res.json().catch(() => ({}));
      _usageCount = Math.max(0, _usageCount - 1);
      return NextResponse.json({ error: err?.message || `OWM ${res.status}` }, { status: res.status });
    }

    const d = await res.json();
    const main = d.main ?? {};
    const wind = d.wind ?? {};
    const weather = d.weather?.[0] ?? {};
    const clouds = d.clouds ?? {};
    const sys = d.sys ?? {};
    const rain = d.rain?.['1h'] ?? 0;
    const snow = d.snow?.['1h'] ?? 0;

    return NextResponse.json({
      city: d.name,
      country: sys.country,
      zip: (!lat && !lon) ? zip : undefined,
      lat: d.coord?.lat,
      lon: d.coord?.lon,
      timezone_offset: d.timezone,

      temp_f: main.temp,
      feels_like_f: main.feels_like,
      temp_min_f: main.temp_min,
      temp_max_f: main.temp_max,

      description: weather.description ?? '',
      icon: weatherIcon(weather.description ?? ''),
      weather_id: weather.id,
      weather_main: weather.main,

      humidity: main.humidity,
      pressure_hpa: main.pressure,
      visibility_m: d.visibility,

      wind_mph: wind.speed,
      wind_gust_mph: wind.gust,
      wind_deg: wind.deg,
      wind_dir: wind.deg != null ? windDirection(wind.deg) : null,

      clouds_pct: clouds.all,
      rain_1h_mm: rain,
      snow_1h_mm: snow,

      sunrise: sys.sunrise,
      sunset: sys.sunset,

      usage_today: _usageCount,
      usage_cap: DAILY_CAP,
      source: 'openweathermap-2.5',
      timestamp: new Date().toISOString(),
    });
  } catch (e: any) {
    _usageCount = Math.max(0, _usageCount - 1);
    return NextResponse.json({ error: e?.message || 'fetch failed' }, { status: 500 });
  }
}
