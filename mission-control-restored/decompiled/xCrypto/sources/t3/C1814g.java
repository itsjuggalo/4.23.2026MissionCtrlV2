package t3;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: renamed from: t3.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1814g extends AbstractC1802a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Thread f15002d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AbstractC1815g0 f15003e;

    public C1814g(Z2.i iVar, Thread thread, AbstractC1815g0 abstractC1815g0) {
        super(iVar, true, true);
        this.f15002d = thread;
        this.f15003e = abstractC1815g0;
    }

    public final Object O0() throws Throwable {
        AbstractC1806c.a();
        try {
            AbstractC1815g0 abstractC1815g0 = this.f15003e;
            if (abstractC1815g0 != null) {
                AbstractC1815g0.m0(abstractC1815g0, false, 1, null);
            }
            while (!Thread.interrupted()) {
                try {
                    AbstractC1815g0 abstractC1815g02 = this.f15003e;
                    long jP0 = abstractC1815g02 != null ? abstractC1815g02.p0() : Long.MAX_VALUE;
                    if (isCompleted()) {
                        AbstractC1815g0 abstractC1815g03 = this.f15003e;
                        if (abstractC1815g03 != null) {
                            AbstractC1815g0.h0(abstractC1815g03, false, 1, null);
                        }
                        AbstractC1806c.a();
                        Object objH = F0.h(b0());
                        C c4 = objH instanceof C ? (C) objH : null;
                        if (c4 == null) {
                            return objH;
                        }
                        throw c4.f14907a;
                    }
                    AbstractC1806c.a();
                    LockSupport.parkNanos(this, jP0);
                } catch (Throwable th) {
                    AbstractC1815g0 abstractC1815g04 = this.f15003e;
                    if (abstractC1815g04 != null) {
                        AbstractC1815g0.h0(abstractC1815g04, false, 1, null);
                    }
                    throw th;
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            C(interruptedException);
            throw interruptedException;
        } catch (Throwable th2) {
            AbstractC1806c.a();
            throw th2;
        }
    }

    @Override // t3.E0
    public boolean f0() {
        return true;
    }

    @Override // t3.E0
    public void y(Object obj) {
        if (kotlin.jvm.internal.r.b(Thread.currentThread(), this.f15002d)) {
            return;
        }
        Thread thread = this.f15002d;
        AbstractC1806c.a();
        LockSupport.unpark(thread);
    }
}
