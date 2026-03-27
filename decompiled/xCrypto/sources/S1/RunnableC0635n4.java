package S1;

import java.util.Objects;

/* JADX INFO: renamed from: S1.n4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0635n4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f4774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0540b5 f4775b;

    public RunnableC0635n4(C0540b5 c0540b5, boolean z4) {
        this.f4774a = z4;
        Objects.requireNonNull(c0540b5);
        this.f4775b = c0540b5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0540b5 c0540b5 = this.f4775b;
        C0658q3 c0658q3 = c0540b5.f4245a;
        boolean zG = c0658q3.g();
        boolean zD = c0658q3.d();
        boolean z4 = this.f4774a;
        c0658q3.P(z4);
        if (zD == z4) {
            c0658q3.a().w().b("Default data collection state already set to", Boolean.valueOf(z4));
        }
        if (c0658q3.g() == zG || c0658q3.g() != c0658q3.d()) {
            c0658q3.a().t().c("Default data collection is different than actual status", Boolean.valueOf(z4), Boolean.valueOf(zG));
        }
        c0540b5.X();
    }
}
