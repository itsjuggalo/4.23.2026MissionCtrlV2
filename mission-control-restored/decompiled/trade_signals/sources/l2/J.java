package l2;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class J implements InterfaceC2324h, InterfaceC2323g, InterfaceC2321e, K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f20557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2327k f20558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final P f20559c;

    public J(Executor executor, InterfaceC2327k interfaceC2327k, P p8) {
        this.f20557a = executor;
        this.f20558b = interfaceC2327k;
        this.f20559c = p8;
    }

    @Override // l2.InterfaceC2321e
    public final void a() {
        this.f20559c.t();
    }

    @Override // l2.K
    public final void b(AbstractC2328l abstractC2328l) {
        this.f20557a.execute(new I(this, abstractC2328l));
    }

    @Override // l2.InterfaceC2323g
    public final void onFailure(Exception exc) {
        this.f20559c.r(exc);
    }

    @Override // l2.InterfaceC2324h
    public final void onSuccess(Object obj) {
        this.f20559c.s(obj);
    }
}
