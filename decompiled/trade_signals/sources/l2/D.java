package l2;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class D implements K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f20542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f20543b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InterfaceC2322f f20544c;

    public D(Executor executor, InterfaceC2322f interfaceC2322f) {
        this.f20542a = executor;
        this.f20544c = interfaceC2322f;
    }

    @Override // l2.K
    public final void b(AbstractC2328l abstractC2328l) {
        synchronized (this.f20543b) {
            try {
                if (this.f20544c == null) {
                    return;
                }
                this.f20542a.execute(new C(this, abstractC2328l));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
