package u4;

import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: u4.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1234p implements Comparable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C1226h f10471d = new C1226h(3);
    public static final long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f10472f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f10473k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1226h f10474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f10475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f10476c;

    static {
        long nanos = TimeUnit.DAYS.toNanos(36500L);
        e = nanos;
        f10472f = -nanos;
        f10473k = TimeUnit.SECONDS.toNanos(1L);
    }

    public C1234p(long j4) {
        C1226h c1226h = f10471d;
        long jNanoTime = System.nanoTime();
        this.f10474a = c1226h;
        long jMin = Math.min(e, Math.max(f10472f, j4));
        this.f10475b = jNanoTime + jMin;
        this.f10476c = jMin <= 0;
    }

    public final boolean a() {
        if (!this.f10476c) {
            long j4 = this.f10475b;
            this.f10474a.getClass();
            if (j4 - System.nanoTime() > 0) {
                return false;
            }
            this.f10476c = true;
        }
        return true;
    }

    public final long b() {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        this.f10474a.getClass();
        long jNanoTime = System.nanoTime();
        if (!this.f10476c && this.f10475b - jNanoTime <= 0) {
            this.f10476c = true;
        }
        return timeUnit.convert(this.f10475b - jNanoTime, timeUnit);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        C1234p c1234p = (C1234p) obj;
        C1226h c1226h = c1234p.f10474a;
        C1226h c1226h2 = this.f10474a;
        if (c1226h2 == c1226h) {
            long j4 = this.f10475b - c1234p.f10475b;
            if (j4 < 0) {
                return -1;
            }
            return j4 > 0 ? 1 : 0;
        }
        throw new AssertionError("Tickers (" + c1226h2 + " and " + c1234p.f10474a + ") don't match. Custom Ticker should only be used in tests!");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1234p)) {
            return false;
        }
        C1234p c1234p = (C1234p) obj;
        C1226h c1226h = this.f10474a;
        if (c1226h != null ? c1226h == c1234p.f10474a : c1234p.f10474a == null) {
            return this.f10475b == c1234p.f10475b;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.asList(this.f10474a, Long.valueOf(this.f10475b)).hashCode();
    }

    public final String toString() {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        long jB = b();
        long jAbs = Math.abs(jB);
        long j4 = f10473k;
        long j6 = jAbs / j4;
        long jAbs2 = Math.abs(jB) % j4;
        StringBuilder sb = new StringBuilder();
        if (jB < 0) {
            sb.append('-');
        }
        sb.append(j6);
        if (jAbs2 > 0) {
            sb.append(String.format(Locale.US, ".%09d", Long.valueOf(jAbs2)));
        }
        sb.append("s from now");
        C1226h c1226h = f10471d;
        C1226h c1226h2 = this.f10474a;
        if (c1226h2 != c1226h) {
            sb.append(" (ticker=" + c1226h2 + ")");
        }
        return sb.toString();
    }
}
