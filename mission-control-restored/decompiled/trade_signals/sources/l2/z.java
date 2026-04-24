package l2;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class z implements InterfaceC2324h, InterfaceC2323g, InterfaceC2321e, K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f20596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2319c f20597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final P f20598c;

    public z(Executor executor, InterfaceC2319c interfaceC2319c, P p8) {
        this.f20596a = executor;
        this.f20597b = interfaceC2319c;
        this.f20598c = p8;
    }

    @Override // l2.InterfaceC2321e
    public final void a() {
        this.f20598c.t();
    }

    @Override // l2.K
    public final void b(AbstractC2328l abstractC2328l) {
        this.f20596a.execute(new y(this, abstractC2328l));
    }

    @Override // l2.InterfaceC2323g
    public final void onFailure(Exception exc) {
        this.f20598c.r(exc);
    }

    @Override // l2.InterfaceC2324h
    public final void onSuccess(Object obj) {
        this.f20598c.s(obj);
    }
}
