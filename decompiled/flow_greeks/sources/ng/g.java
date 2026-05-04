package ng;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Thread f17131d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i1 f17132e;

    public g(gd.i iVar, Thread thread, i1 i1Var) {
        super(iVar, true, true);
        this.f17131d = thread;
        this.f17132e = i1Var;
    }

    public final Object O0() throws Throwable {
        c.a();
        try {
            i1 i1Var = this.f17132e;
            if (i1Var != null) {
                i1.k0(i1Var, false, 1, null);
            }
            while (!Thread.interrupted()) {
                try {
                    i1 i1Var2 = this.f17132e;
                    long jN0 = i1Var2 != null ? i1Var2.n0() : Long.MAX_VALUE;
                    if (isCompleted()) {
                        i1 i1Var3 = this.f17132e;
                        if (i1Var3 != null) {
                            i1.f0(i1Var3, false, 1, null);
                        }
                        c.a();
                        Object objH = f2.h(Z());
                        c0 c0Var = objH instanceof c0 ? (c0) objH : null;
                        if (c0Var == null) {
                            return objH;
                        }
                        throw c0Var.f17078a;
                    }
                    c.a();
                    LockSupport.parkNanos(this, jN0);
                } catch (Throwable th) {
                    i1 i1Var4 = this.f17132e;
                    if (i1Var4 != null) {
                        i1.f0(i1Var4, false, 1, null);
                    }
                    throw th;
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            A(interruptedException);
            throw interruptedException;
        } catch (Throwable th2) {
            c.a();
            throw th2;
        }
    }

    @Override // ng.e2
    public boolean g0() {
        return true;
    }

    @Override // ng.e2
    public void x(Object obj) {
        if (kotlin.jvm.internal.t.b(Thread.currentThread(), this.f17131d)) {
            return;
        }
        Thread thread = this.f17131d;
        c.a();
        LockSupport.unpark(thread);
    }
}
