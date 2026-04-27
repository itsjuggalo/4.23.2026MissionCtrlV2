package t5;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import t5.InterfaceC2681j;

/* JADX INFO: loaded from: classes2.dex */
public final class F implements InterfaceC2681j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Random f23445a = new Random();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f23446b = TimeUnit.SECONDS.toNanos(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f23447c = TimeUnit.MINUTES.toNanos(2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f23448d = 1.6d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f23449e = 0.2d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f23450f = this.f23446b;

    public static final class a implements InterfaceC2681j.a {
        @Override // t5.InterfaceC2681j.a
        public InterfaceC2681j get() {
            return new F();
        }
    }

    @Override // t5.InterfaceC2681j
    public long a() {
        long j7 = this.f23450f;
        double d7 = j7;
        this.f23450f = Math.min((long) (this.f23448d * d7), this.f23447c);
        double d8 = this.f23449e;
        return j7 + b((-d8) * d7, d8 * d7);
    }

    public final long b(double d7, double d8) {
        H2.m.d(d8 >= d7);
        return (long) ((this.f23445a.nextDouble() * (d8 - d7)) + d7);
    }
}
