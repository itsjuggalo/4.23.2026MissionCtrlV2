package l2;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class B implements K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f20537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f20538b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InterfaceC2321e f20539c;

    public B(Executor executor, InterfaceC2321e interfaceC2321e) {
        this.f20537a = executor;
        this.f20539c = interfaceC2321e;
    }

    @Override // l2.K
    public final void b(AbstractC2328l abstractC2328l) {
        if (abstractC2328l.m()) {
            synchronized (this.f20538b) {
                try {
                    if (this.f20539c == null) {
                        return;
                    }
                    this.f20537a.execute(new RunnableC2316A(this));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
