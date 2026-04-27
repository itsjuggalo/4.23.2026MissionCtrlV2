package M2;

import K2.AbstractC0354b;
import K2.AbstractC0363k;
import K2.C0355c;

/* JADX INFO: renamed from: M2.o0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0437o0 extends AbstractC0354b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0445t f2533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final K2.a0 f2534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final K2.Z f2535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0355c f2536d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f2538f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AbstractC0363k[] f2539g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public r f2541i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2542j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public C f2543k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f2540h = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final K2.r f2537e = K2.r.e();

    /* JADX INFO: renamed from: M2.o0$a */
    public interface a {
        void a();
    }

    public C0437o0(InterfaceC0445t interfaceC0445t, K2.a0 a0Var, K2.Z z4, C0355c c0355c, a aVar, AbstractC0363k[] abstractC0363kArr) {
        this.f2533a = interfaceC0445t;
        this.f2534b = a0Var;
        this.f2535c = z4;
        this.f2536d = c0355c;
        this.f2538f = aVar;
        this.f2539g = abstractC0363kArr;
    }

    @Override // K2.AbstractC0354b.a
    public void a(K2.Z z4) {
        Z1.m.u(!this.f2542j, "apply() or fail() already called");
        Z1.m.o(z4, "headers");
        this.f2535c.m(z4);
        K2.r rVarB = this.f2537e.b();
        try {
            r rVarC = this.f2533a.c(this.f2534b, this.f2535c, this.f2536d, this.f2539g);
            this.f2537e.f(rVarB);
            c(rVarC);
        } catch (Throwable th) {
            this.f2537e.f(rVarB);
            throw th;
        }
    }

    @Override // K2.AbstractC0354b.a
    public void b(K2.l0 l0Var) {
        Z1.m.e(!l0Var.o(), "Cannot fail with OK status");
        Z1.m.u(!this.f2542j, "apply() or fail() already called");
        c(new G(S.o(l0Var), this.f2539g));
    }

    public final void c(r rVar) {
        boolean z4;
        Z1.m.u(!this.f2542j, "already finalized");
        this.f2542j = true;
        synchronized (this.f2540h) {
            try {
                if (this.f2541i == null) {
                    this.f2541i = rVar;
                    z4 = true;
                } else {
                    z4 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z4) {
            this.f2538f.a();
            return;
        }
        Z1.m.u(this.f2543k != null, "delayedStream is null");
        Runnable runnableY = this.f2543k.y(rVar);
        if (runnableY != null) {
            runnableY.run();
        }
        this.f2538f.a();
    }

    public r d() {
        synchronized (this.f2540h) {
            try {
                r rVar = this.f2541i;
                if (rVar != null) {
                    return rVar;
                }
                C c4 = new C();
                this.f2543k = c4;
                this.f2541i = c4;
                return c4;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
