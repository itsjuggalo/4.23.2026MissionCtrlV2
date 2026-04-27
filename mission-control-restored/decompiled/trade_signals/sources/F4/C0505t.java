package F4;

import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: F4.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0505t implements Comparable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f1897d = new b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f1898e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f1899f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f1900g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f1901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f1903c;

    /* JADX INFO: renamed from: F4.t$b */
    public static class b extends c {
        public b() {
        }

        @Override // F4.C0505t.c
        public long a() {
            return System.nanoTime();
        }
    }

    /* JADX INFO: renamed from: F4.t$c */
    public static abstract class c {
        public abstract long a();
    }

    static {
        long nanos = TimeUnit.DAYS.toNanos(36500L);
        f1898e = nanos;
        f1899f = -nanos;
        f1900g = TimeUnit.SECONDS.toNanos(1L);
    }

    public C0505t(c cVar, long j8, long j9, boolean z7) {
        this.f1901a = cVar;
        long jMin = Math.min(f1898e, Math.max(f1899f, j9));
        this.f1902b = j8 + jMin;
        this.f1903c = z7 && jMin <= 0;
    }

    public static C0505t a(long j8, TimeUnit timeUnit) {
        return b(j8, timeUnit, f1897d);
    }

    public static C0505t b(long j8, TimeUnit timeUnit, c cVar) {
        g(timeUnit, "units");
        return new C0505t(cVar, timeUnit.toNanos(j8), true);
    }

    public static Object g(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(String.valueOf(obj2));
    }

    public static c l() {
        return f1897d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0505t)) {
            return false;
        }
        C0505t c0505t = (C0505t) obj;
        c cVar = this.f1901a;
        if (cVar != null ? cVar == c0505t.f1901a : c0505t.f1901a == null) {
            return this.f1902b == c0505t.f1902b;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.asList(this.f1901a, Long.valueOf(this.f1902b)).hashCode();
    }

    public final void i(C0505t c0505t) {
        if (this.f1901a == c0505t.f1901a) {
            return;
        }
        throw new AssertionError("Tickers (" + this.f1901a + " and " + c0505t.f1901a + ") don't match. Custom Ticker should only be used in tests!");
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public int compareTo(C0505t c0505t) {
        i(c0505t);
        long j8 = this.f1902b - c0505t.f1902b;
        if (j8 < 0) {
            return -1;
        }
        return j8 > 0 ? 1 : 0;
    }

    public boolean m(C0505t c0505t) {
        i(c0505t);
        return this.f1902b - c0505t.f1902b < 0;
    }

    public boolean n() {
        if (!this.f1903c) {
            if (this.f1902b - this.f1901a.a() > 0) {
                return false;
            }
            this.f1903c = true;
        }
        return true;
    }

    public C0505t q(C0505t c0505t) {
        i(c0505t);
        return m(c0505t) ? this : c0505t;
    }

    public long r(TimeUnit timeUnit) {
        long jA = this.f1901a.a();
        if (!this.f1903c && this.f1902b - jA <= 0) {
            this.f1903c = true;
        }
        return timeUnit.convert(this.f1902b - jA, TimeUnit.NANOSECONDS);
    }

    public String toString() {
        long jR = r(TimeUnit.NANOSECONDS);
        long jAbs = Math.abs(jR);
        long j8 = f1900g;
        long j9 = jAbs / j8;
        long jAbs2 = Math.abs(jR) % j8;
        StringBuilder sb = new StringBuilder();
        if (jR < 0) {
            sb.append('-');
        }
        sb.append(j9);
        if (jAbs2 > 0) {
            sb.append(String.format(Locale.US, ".%09d", Long.valueOf(jAbs2)));
        }
        sb.append("s from now");
        if (this.f1901a != f1897d) {
            sb.append(" (ticker=" + this.f1901a + ")");
        }
        return sb.toString();
    }

    public C0505t(c cVar, long j8, boolean z7) {
        this(cVar, cVar.a(), j8, z7);
    }
}
