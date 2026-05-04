package tb;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import tb.j;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f0 implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Random f21229a = new Random();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f21230b = TimeUnit.SECONDS.toNanos(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f21231c = TimeUnit.MINUTES.toNanos(2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f21232d = 1.6d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f21233e = 0.2d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f21234f = this.f21230b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements j.a {
        @Override // tb.j.a
        public j get() {
            return new f0();
        }
    }

    @Override // tb.j
    public long a() {
        long j10 = this.f21234f;
        double d10 = j10;
        this.f21234f = Math.min((long) (this.f21232d * d10), this.f21231c);
        double d11 = this.f21233e;
        return j10 + b((-d11) * d10, d11 * d10);
    }

    public final long b(double d10, double d11) {
        p6.n.d(d11 >= d10);
        return (long) ((this.f21229a.nextDouble() * (d11 - d10)) + d10);
    }
}
