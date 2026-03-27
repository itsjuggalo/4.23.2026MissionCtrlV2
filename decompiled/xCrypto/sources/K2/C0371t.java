package K2;

import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: K2.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0371t implements Comparable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f1309d = new b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f1310e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f1311f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f1312g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f1313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f1315c;

    /* JADX INFO: renamed from: K2.t$b */
    public static class b extends c {
        public b() {
        }

        @Override // K2.C0371t.c
        public long a() {
            return System.nanoTime();
        }
    }

    /* JADX INFO: renamed from: K2.t$c */
    public static abstract class c {
        public abstract long a();
    }

    static {
        long nanos = TimeUnit.DAYS.toNanos(36500L);
        f1310e = nanos;
        f1311f = -nanos;
        f1312g = TimeUnit.SECONDS.toNanos(1L);
    }

    public C0371t(c cVar, long j4, boolean z4) {
        this(cVar, cVar.a(), j4, z4);
    }

    public static C0371t a(long j4, TimeUnit timeUnit) {
        return c(j4, timeUnit, f1309d);
    }

    public static C0371t c(long j4, TimeUnit timeUnit, c cVar) {
        g(timeUnit, "units");
        return new C0371t(cVar, timeUnit.toNanos(j4), true);
    }

    public static Object g(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(String.valueOf(obj2));
    }

    public static c k() {
        return f1309d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0371t)) {
            return false;
        }
        C0371t c0371t = (C0371t) obj;
        c cVar = this.f1313a;
        if (cVar != null ? cVar == c0371t.f1313a : c0371t.f1313a == null) {
            return this.f1314b == c0371t.f1314b;
        }
        return false;
    }

    public final void h(C0371t c0371t) {
        if (this.f1313a == c0371t.f1313a) {
            return;
        }
        throw new AssertionError("Tickers (" + this.f1313a + " and " + c0371t.f1313a + ") don't match. Custom Ticker should only be used in tests!");
    }

    public int hashCode() {
        return Arrays.asList(this.f1313a, Long.valueOf(this.f1314b)).hashCode();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int compareTo(C0371t c0371t) {
        h(c0371t);
        long j4 = this.f1314b - c0371t.f1314b;
        if (j4 < 0) {
            return -1;
        }
        return j4 > 0 ? 1 : 0;
    }

    public boolean l(C0371t c0371t) {
        h(c0371t);
        return this.f1314b - c0371t.f1314b < 0;
    }

    public boolean m() {
        if (!this.f1315c) {
            if (this.f1314b - this.f1313a.a() > 0) {
                return false;
            }
            this.f1315c = true;
        }
        return true;
    }

    public C0371t n(C0371t c0371t) {
        h(c0371t);
        return l(c0371t) ? this : c0371t;
    }

    public long o(TimeUnit timeUnit) {
        long jA = this.f1313a.a();
        if (!this.f1315c && this.f1314b - jA <= 0) {
            this.f1315c = true;
        }
        return timeUnit.convert(this.f1314b - jA, TimeUnit.NANOSECONDS);
    }

    public String toString() {
        long jO = o(TimeUnit.NANOSECONDS);
        long jAbs = Math.abs(jO);
        long j4 = f1312g;
        long j5 = jAbs / j4;
        long jAbs2 = Math.abs(jO) % j4;
        StringBuilder sb = new StringBuilder();
        if (jO < 0) {
            sb.append('-');
        }
        sb.append(j5);
        if (jAbs2 > 0) {
            sb.append(String.format(Locale.US, ".%09d", Long.valueOf(jAbs2)));
        }
        sb.append("s from now");
        if (this.f1313a != f1309d) {
            sb.append(" (ticker=" + this.f1313a + ")");
        }
        return sb.toString();
    }

    public C0371t(c cVar, long j4, long j5, boolean z4) {
        this.f1313a = cVar;
        long jMin = Math.min(f1310e, Math.max(f1311f, j5));
        this.f1314b = j4 + jMin;
        this.f1315c = z4 && jMin <= 0;
    }
}
