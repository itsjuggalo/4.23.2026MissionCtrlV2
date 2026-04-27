package l2;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class F implements K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f20547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f20548b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InterfaceC2323g f20549c;

    public F(Executor executor, InterfaceC2323g interfaceC2323g) {
        this.f20547a = executor;
        this.f20549c = interfaceC2323g;
    }

    @Override // l2.K
    public final void b(AbstractC2328l abstractC2328l) {
        if (abstractC2328l.o() || abstractC2328l.m()) {
            return;
        }
        synchronized (this.f20548b) {
            try {
                if (this.f20549c == null) {
                    return;
                }
                this.f20547a.execute(new E(this, abstractC2328l));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
