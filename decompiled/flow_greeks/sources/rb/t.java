package rb;

import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class t implements Comparable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f19718d = new b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f19719e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f19720f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f19721g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f19722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f19723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f19724c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b extends c {
        public b() {
        }

        @Override // rb.t.c
        public long a() {
            return System.nanoTime();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class c {
        public abstract long a();
    }

    static {
        long nanos = TimeUnit.DAYS.toNanos(36500L);
        f19719e = nanos;
        f19720f = -nanos;
        f19721g = TimeUnit.SECONDS.toNanos(1L);
    }

    public t(c cVar, long j10, boolean z10) {
        this(cVar, cVar.a(), j10, z10);
    }

    public static t a(long j10, TimeUnit timeUnit) {
        return b(j10, timeUnit, f19718d);
    }

    public static t b(long j10, TimeUnit timeUnit, c cVar) {
        c(timeUnit, "units");
        return new t(cVar, timeUnit.toNanos(j10), true);
    }

    public static Object c(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(String.valueOf(obj2));
    }

    public static c k() {
        return f19718d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        c cVar = this.f19722a;
        if (cVar != null ? cVar == tVar.f19722a : tVar.f19722a == null) {
            return this.f19723b == tVar.f19723b;
        }
        return false;
    }

    public final void h(t tVar) {
        if (this.f19722a == tVar.f19722a) {
            return;
        }
        throw new AssertionError("Tickers (" + this.f19722a + " and " + tVar.f19722a + ") don't match. Custom Ticker should only be used in tests!");
    }

    public int hashCode() {
        return Arrays.asList(this.f19722a, Long.valueOf(this.f19723b)).hashCode();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int compareTo(t tVar) {
        h(tVar);
        long j10 = this.f19723b - tVar.f19723b;
        if (j10 < 0) {
            return -1;
        }
        return j10 > 0 ? 1 : 0;
    }

    public boolean l(t tVar) {
        h(tVar);
        return this.f19723b - tVar.f19723b < 0;
    }

    public boolean m() {
        if (!this.f19724c) {
            if (this.f19723b - this.f19722a.a() > 0) {
                return false;
            }
            this.f19724c = true;
        }
        return true;
    }

    public t o(t tVar) {
        h(tVar);
        return l(tVar) ? this : tVar;
    }

    public long q(TimeUnit timeUnit) {
        long jA = this.f19722a.a();
        if (!this.f19724c && this.f19723b - jA <= 0) {
            this.f19724c = true;
        }
        return timeUnit.convert(this.f19723b - jA, TimeUnit.NANOSECONDS);
    }

    public String toString() {
        long jQ = q(TimeUnit.NANOSECONDS);
        long jAbs = Math.abs(jQ);
        long j10 = f19721g;
        long j11 = jAbs / j10;
        long jAbs2 = Math.abs(jQ) % j10;
        StringBuilder sb2 = new StringBuilder();
        if (jQ < 0) {
            sb2.append('-');
        }
        sb2.append(j11);
        if (jAbs2 > 0) {
            sb2.append(String.format(Locale.US, ".%09d", Long.valueOf(jAbs2)));
        }
        sb2.append("s from now");
        if (this.f19722a != f19718d) {
            sb2.append(" (ticker=" + this.f19722a + ")");
        }
        return sb2.toString();
    }

    public t(c cVar, long j10, long j11, boolean z10) {
        this.f19722a = cVar;
        long jMin = Math.min(f19719e, Math.max(f19720f, j11));
        this.f19723b = j10 + jMin;
        this.f19724c = z10 && jMin <= 0;
    }
}
