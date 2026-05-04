package tb;

import rb.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class n1 extends b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f21546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final rb.z0 f21547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final rb.y0 f21548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final rb.c f21549d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f21551f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final rb.k[] f21552g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public r f21554i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f21555j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public c0 f21556k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f21553h = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final rb.r f21550e = rb.r.e();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {
        void onComplete();
    }

    public n1(t tVar, rb.z0 z0Var, rb.y0 y0Var, rb.c cVar, a aVar, rb.k[] kVarArr) {
        this.f21546a = tVar;
        this.f21547b = z0Var;
        this.f21548c = y0Var;
        this.f21549d = cVar;
        this.f21551f = aVar;
        this.f21552g = kVarArr;
    }

    @Override // rb.b.a
    public void a(rb.y0 y0Var) {
        p6.n.u(!this.f21555j, "apply() or fail() already called");
        p6.n.o(y0Var, "headers");
        this.f21548c.m(y0Var);
        rb.r rVarB = this.f21550e.b();
        try {
            r rVarG = this.f21546a.g(this.f21547b, this.f21548c, this.f21549d, this.f21552g);
            this.f21550e.f(rVarB);
            c(rVarG);
        } catch (Throwable th) {
            this.f21550e.f(rVarB);
            throw th;
        }
    }

    @Override // rb.b.a
    public void b(rb.k1 k1Var) {
        p6.n.e(!k1Var.p(), "Cannot fail with OK status");
        p6.n.u(!this.f21555j, "apply() or fail() already called");
        c(new g0(r0.o(k1Var), this.f21552g));
    }

    public final void c(r rVar) {
        boolean z10;
        p6.n.u(!this.f21555j, "already finalized");
        this.f21555j = true;
        synchronized (this.f21553h) {
            try {
                if (this.f21554i == null) {
                    this.f21554i = rVar;
                    z10 = true;
                } else {
                    z10 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z10) {
            this.f21551f.onComplete();
            return;
        }
        p6.n.u(this.f21556k != null, "delayedStream is null");
        Runnable runnableW = this.f21556k.w(rVar);
        if (runnableW != null) {
            runnableW.run();
        }
        this.f21551f.onComplete();
    }

    public r d() {
        synchronized (this.f21553h) {
            try {
                r rVar = this.f21554i;
                if (rVar != null) {
                    return rVar;
                }
                c0 c0Var = new c0();
                this.f21556k = c0Var;
                this.f21554i = c0Var;
                return c0Var;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
