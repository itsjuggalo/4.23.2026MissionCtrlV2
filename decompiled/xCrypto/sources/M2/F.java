package M2;

import M2.InterfaceC0426j;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class F implements InterfaceC0426j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Random f1894a = new Random();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f1895b = TimeUnit.SECONDS.toNanos(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f1896c = TimeUnit.MINUTES.toNanos(2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f1897d = 1.6d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f1898e = 0.2d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f1899f = this.f1895b;

    public static final class a implements InterfaceC0426j.a {
        @Override // M2.InterfaceC0426j.a
        public InterfaceC0426j get() {
            return new F();
        }
    }

    @Override // M2.InterfaceC0426j
    public long a() {
        long j4 = this.f1899f;
        double d4 = j4;
        this.f1899f = Math.min((long) (this.f1897d * d4), this.f1896c);
        double d5 = this.f1898e;
        return j4 + b((-d5) * d4, d5 * d4);
    }

    public final long b(double d4, double d5) {
        Z1.m.d(d5 >= d4);
        return (long) ((this.f1894a.nextDouble() * (d5 - d4)) + d4);
    }
}
