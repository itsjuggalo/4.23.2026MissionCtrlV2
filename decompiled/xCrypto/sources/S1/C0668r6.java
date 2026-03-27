package S1;

import java.util.Objects;

/* JADX INFO: renamed from: S1.r6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0668r6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RunnableC0661q6 f4904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0708w6 f4905b;

    public C0668r6(C0708w6 c0708w6) {
        Objects.requireNonNull(c0708w6);
        this.f4905b = c0708w6;
    }

    public final void a() {
        C0708w6 c0708w6 = this.f4905b;
        c0708w6.h();
        RunnableC0661q6 runnableC0661q6 = this.f4904a;
        if (runnableC0661q6 != null) {
            c0708w6.t().removeCallbacks(runnableC0661q6);
        }
        C0658q3 c0658q3 = c0708w6.f4245a;
        c0658q3.x().f4198t.b(false);
        c0708w6.o(false);
        if (c0658q3.w().H(null, AbstractC0569f2.f4543U0)) {
            C0658q3 c0658q32 = c0708w6.f4245a;
            if (c0658q32.B().u0()) {
                c0658q3.a().w().a("Retrying trigger URI registration in foreground");
                c0658q32.B().w0();
            }
        }
    }

    public final void b(long j4) {
        C0708w6 c0708w6 = this.f4905b;
        this.f4904a = new RunnableC0661q6(this, c0708w6.f4245a.f().currentTimeMillis(), j4);
        c0708w6.t().postDelayed(this.f4904a, 2000L);
    }
}
