package l2;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class x implements K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f20591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2319c f20592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final P f20593c;

    public x(Executor executor, InterfaceC2319c interfaceC2319c, P p8) {
        this.f20591a = executor;
        this.f20592b = interfaceC2319c;
        this.f20593c = p8;
    }

    @Override // l2.K
    public final void b(AbstractC2328l abstractC2328l) {
        this.f20591a.execute(new w(this, abstractC2328l));
    }
}
