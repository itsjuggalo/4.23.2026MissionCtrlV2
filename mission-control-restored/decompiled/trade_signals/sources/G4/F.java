package G4;

import G4.InterfaceC0534j;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes2.dex */
public final class F implements InterfaceC0534j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Random f2482a = new Random();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f2483b = TimeUnit.SECONDS.toNanos(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f2484c = TimeUnit.MINUTES.toNanos(2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f2485d = 1.6d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f2486e = 0.2d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f2487f = this.f2483b;

    public static final class a implements InterfaceC0534j.a {
        @Override // G4.InterfaceC0534j.a
        public InterfaceC0534j get() {
            return new F();
        }
    }

    @Override // G4.InterfaceC0534j
    public long a() {
        long j8 = this.f2487f;
        double d8 = j8;
        this.f2487f = Math.min((long) (this.f2485d * d8), this.f2484c);
        double d9 = this.f2486e;
        return j8 + b((-d9) * d8, d9 * d8);
    }

    public final long b(double d8, double d9) {
        AbstractC2848n.d(d9 >= d8);
        return (long) ((this.f2482a.nextDouble() * (d9 - d8)) + d8);
    }
}
