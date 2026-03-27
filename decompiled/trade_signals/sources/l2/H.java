package l2;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class H implements K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f20552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f20553b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InterfaceC2324h f20554c;

    public H(Executor executor, InterfaceC2324h interfaceC2324h) {
        this.f20552a = executor;
        this.f20554c = interfaceC2324h;
    }

    @Override // l2.K
    public final void b(AbstractC2328l abstractC2328l) {
        if (abstractC2328l.o()) {
            synchronized (this.f20553b) {
                try {
                    if (this.f20554c == null) {
                        return;
                    }
                    this.f20552a.execute(new G(this, abstractC2328l));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
