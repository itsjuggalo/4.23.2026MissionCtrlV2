package r5;

import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: r5.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2603t implements Comparable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f22799d = new b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f22800e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f22801f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f22802g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f22803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f22804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f22805c;

    /* JADX INFO: renamed from: r5.t$b */
    public static class b extends c {
        public b() {
        }

        @Override // r5.C2603t.c
        public long a() {
            return System.nanoTime();
        }
    }

    /* JADX INFO: renamed from: r5.t$c */
    public static abstract class c {
        public abstract long a();
    }

    static {
        long nanos = TimeUnit.DAYS.toNanos(36500L);
        f22800e = nanos;
        f22801f = -nanos;
        f22802g = TimeUnit.SECONDS.toNanos(1L);
    }

    public C2603t(c cVar, long j7, boolean z7) {
        this(cVar, cVar.a(), j7, z7);
    }

    public static C2603t a(long j7, TimeUnit timeUnit) {
        return b(j7, timeUnit, f22799d);
    }

    public static C2603t b(long j7, TimeUnit timeUnit, c cVar) {
        c(timeUnit, "units");
        return new C2603t(cVar, timeUnit.toNanos(j7), true);
    }

    public static Object c(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(String.valueOf(obj2));
    }

    public static c j() {
        return f22799d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2603t)) {
            return false;
        }
        C2603t c2603t = (C2603t) obj;
        c cVar = this.f22803a;
        if (cVar != null ? cVar == c2603t.f22803a : c2603t.f22803a == null) {
            return this.f22804b == c2603t.f22804b;
        }
        return false;
    }

    public final void h(C2603t c2603t) {
        if (this.f22803a == c2603t.f22803a) {
            return;
        }
        throw new AssertionError("Tickers (" + this.f22803a + " and " + c2603t.f22803a + ") don't match. Custom Ticker should only be used in tests!");
    }

    public int hashCode() {
        return Arrays.asList(this.f22803a, Long.valueOf(this.f22804b)).hashCode();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int compareTo(C2603t c2603t) {
        h(c2603t);
        long j7 = this.f22804b - c2603t.f22804b;
        if (j7 < 0) {
            return -1;
        }
        return j7 > 0 ? 1 : 0;
    }

    public boolean k(C2603t c2603t) {
        h(c2603t);
        return this.f22804b - c2603t.f22804b < 0;
    }

    public boolean l() {
        if (!this.f22805c) {
            if (this.f22804b - this.f22803a.a() > 0) {
                return false;
            }
            this.f22805c = true;
        }
        return true;
    }

    public C2603t m(C2603t c2603t) {
        h(c2603t);
        return k(c2603t) ? this : c2603t;
    }

    public long n(TimeUnit timeUnit) {
        long jA = this.f22803a.a();
        if (!this.f22805c && this.f22804b - jA <= 0) {
            this.f22805c = true;
        }
        return timeUnit.convert(this.f22804b - jA, TimeUnit.NANOSECONDS);
    }

    public String toString() {
        long jN = n(TimeUnit.NANOSECONDS);
        long jAbs = Math.abs(jN);
        long j7 = f22802g;
        long j8 = jAbs / j7;
        long jAbs2 = Math.abs(jN) % j7;
        StringBuilder sb = new StringBuilder();
        if (jN < 0) {
            sb.append('-');
        }
        sb.append(j8);
        if (jAbs2 > 0) {
            sb.append(String.format(Locale.US, ".%09d", Long.valueOf(jAbs2)));
        }
        sb.append("s from now");
        if (this.f22803a != f22799d) {
            sb.append(" (ticker=" + this.f22803a + ")");
        }
        return sb.toString();
    }

    public C2603t(c cVar, long j7, long j8, boolean z7) {
        this.f22803a = cVar;
        long jMin = Math.min(f22800e, Math.max(f22801f, j8));
        this.f22804b = j7 + jMin;
        this.f22805c = z7 && jMin <= 0;
    }
}
