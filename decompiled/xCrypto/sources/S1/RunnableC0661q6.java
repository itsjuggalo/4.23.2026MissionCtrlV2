package S1;

import java.util.Objects;

/* JADX INFO: renamed from: S1.q6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0661q6 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0668r6 f4890c;

    public RunnableC0661q6(C0668r6 c0668r6, long j4, long j5) {
        Objects.requireNonNull(c0668r6);
        this.f4890c = c0668r6;
        this.f4888a = j4;
        this.f4889b = j5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4890c.f4905b.f4245a.b().t(new Runnable() { // from class: S1.p6
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                RunnableC0661q6 runnableC0661q6 = this.f4831a;
                C0708w6 c0708w6 = runnableC0661q6.f4890c.f4905b;
                c0708w6.h();
                C0658q3 c0658q3 = c0708w6.f4245a;
                c0658q3.a().v().a("Application going to the background");
                c0658q3.x().f4198t.b(true);
                c0708w6.o(true);
                if (!c0658q3.w().N()) {
                    long j4 = runnableC0661q6.f4889b;
                    C0684t6 c0684t6 = c0708w6.f5022f;
                    c0684t6.d(false, false, j4);
                    c0684t6.b(j4);
                }
                c0658q3.a().u().b("Application backgrounded at: timestamp_millis", Long.valueOf(runnableC0661q6.f4888a));
                C0658q3 c0658q32 = c0708w6.f4245a;
                C0540b5 c0540b5B = c0658q32.B();
                c0540b5B.h();
                C0658q3 c0658q33 = c0540b5B.f4245a;
                c0540b5B.j();
                C0565e6 c0565e6J = c0658q33.J();
                c0565e6J.h();
                c0565e6J.j();
                if (!c0565e6J.y() || c0565e6J.f4245a.C().W() >= 242600) {
                    c0658q33.J().t();
                }
                if (c0658q3.w().H(null, AbstractC0569f2.f4531O0)) {
                    long jD = c0658q3.C().P(c0658q3.e().getPackageName(), c0658q3.w().R()) ? 1000L : c0658q3.w().D(c0658q3.e().getPackageName(), AbstractC0569f2.f4510E);
                    c0658q3.a().w().b("[sgtm] Scheduling batch upload with minimum latency in millis", Long.valueOf(jD));
                    c0658q32.N().o(jD);
                }
            }
        });
    }
}
