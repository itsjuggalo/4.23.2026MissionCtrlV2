package com.google.firebase.remoteconfig.internal;

import android.content.SharedPreferences;
import android.util.Log;
import b4.s;
import b4.u;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Date f15884f = new Date(-1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Date f15885g = new Date(-1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f15886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f15887b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f15888c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f15889d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f15890e = new Object();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Date f15892b;

        public a(int i8, Date date) {
            this.f15891a = i8;
            this.f15892b = date;
        }

        public Date a() {
            return this.f15892b;
        }

        public int b() {
            return this.f15891a;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Date f15894b;

        public b(int i8, Date date) {
            this.f15893a = i8;
            this.f15894b = date;
        }

        public Date a() {
            return this.f15894b;
        }

        public int b() {
            return this.f15893a;
        }
    }

    public e(SharedPreferences sharedPreferences) {
        this.f15886a = sharedPreferences;
    }

    public a a() {
        a aVar;
        synchronized (this.f15888c) {
            aVar = new a(this.f15886a.getInt("num_failed_fetches", 0), new Date(this.f15886a.getLong("backoff_end_time_in_millis", -1L)));
        }
        return aVar;
    }

    public Map b() {
        try {
            JSONObject jSONObject = new JSONObject(this.f15886a.getString("customSignals", "{}"));
            HashMap map = new HashMap();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.optString(next));
            }
            return map;
        } catch (JSONException unused) {
            return new HashMap();
        }
    }

    public long c() {
        return this.f15886a.getLong("fetch_timeout_in_seconds", 60L);
    }

    public s d() {
        f fVarA;
        synchronized (this.f15887b) {
            long j8 = this.f15886a.getLong("last_fetch_time_in_millis", -1L);
            int i8 = this.f15886a.getInt("last_fetch_status", 0);
            fVarA = f.d().c(i8).d(j8).b(new u.b().d(this.f15886a.getLong("fetch_timeout_in_seconds", 60L)).e(this.f15886a.getLong("minimum_fetch_interval_in_seconds", c.f15842j)).c()).a();
        }
        return fVarA;
    }

    public String e() {
        return this.f15886a.getString("last_fetch_etag", null);
    }

    public Date f() {
        return new Date(this.f15886a.getLong("last_fetch_time_in_millis", -1L));
    }

    public long g() {
        return this.f15886a.getLong("last_template_version", 0L);
    }

    public long h() {
        return this.f15886a.getLong("minimum_fetch_interval_in_seconds", c.f15842j);
    }

    public b i() {
        b bVar;
        synchronized (this.f15889d) {
            bVar = new b(this.f15886a.getInt("num_failed_realtime_streams", 0), new Date(this.f15886a.getLong("realtime_backoff_end_time_in_millis", -1L)));
        }
        return bVar;
    }

    public void j() {
        l(0, f15885g);
    }

    public void k() {
        r(0, f15885g);
    }

    public void l(int i8, Date date) {
        synchronized (this.f15888c) {
            this.f15886a.edit().putInt("num_failed_fetches", i8).putLong("backoff_end_time_in_millis", date.getTime()).apply();
        }
    }

    public void m(u uVar) {
        synchronized (this.f15887b) {
            this.f15886a.edit().putLong("fetch_timeout_in_seconds", uVar.a()).putLong("minimum_fetch_interval_in_seconds", uVar.b()).commit();
        }
    }

    public void n(Map map) {
        synchronized (this.f15890e) {
            try {
                Map mapB = b();
                boolean z7 = false;
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    String str2 = (String) entry.getValue();
                    if (str.length() <= 250 && (str2 == null || str2.length() <= 500)) {
                        boolean z8 = true;
                        if (str2 != null) {
                            z7 |= !Objects.equals(mapB.put(str, str2), str2);
                        } else {
                            if (mapB.remove(str) == null) {
                                z8 = false;
                            }
                            z7 |= z8;
                        }
                    }
                    Log.w("FirebaseRemoteConfig", String.format("Invalid custom signal: Custom signal keys must be %d characters or less, and values must be %d characters or less.", 250, 500));
                    return;
                }
                if (z7) {
                    if (mapB.size() > 100) {
                        Log.w("FirebaseRemoteConfig", String.format("Invalid custom signal: Too many custom signals provided. The maximum allowed is %d.", 100));
                        return;
                    }
                    this.f15886a.edit().putString("customSignals", new JSONObject(mapB).toString()).commit();
                    Log.d("FirebaseRemoteConfig", "Keys of updated custom signals: " + b().keySet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void o(String str) {
        synchronized (this.f15887b) {
            this.f15886a.edit().putString("last_fetch_etag", str).apply();
        }
    }

    public void p(long j8) {
        synchronized (this.f15887b) {
            this.f15886a.edit().putLong("last_template_version", j8).apply();
        }
    }

    public void q(Date date) {
        synchronized (this.f15889d) {
            this.f15886a.edit().putLong("realtime_backoff_end_time_in_millis", date.getTime()).apply();
        }
    }

    public void r(int i8, Date date) {
        synchronized (this.f15889d) {
            this.f15886a.edit().putInt("num_failed_realtime_streams", i8).putLong("realtime_backoff_end_time_in_millis", date.getTime()).apply();
        }
    }

    public void s() {
        synchronized (this.f15887b) {
            this.f15886a.edit().putInt("last_fetch_status", 1).apply();
        }
    }

    public void t(Date date) {
        synchronized (this.f15887b) {
            this.f15886a.edit().putInt("last_fetch_status", -1).putLong("last_fetch_time_in_millis", date.getTime()).apply();
        }
    }

    public void u() {
        synchronized (this.f15887b) {
            this.f15886a.edit().putInt("last_fetch_status", 2).apply();
        }
    }
}
