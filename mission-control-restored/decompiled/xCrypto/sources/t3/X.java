package t3;

import a3.AbstractC0786b;
import a3.AbstractC0787c;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import y3.AbstractC1957k;

/* JADX INFO: loaded from: classes3.dex */
public final class X extends y3.B {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f14970e = AtomicIntegerFieldUpdater.newUpdater(X.class, "_decision");
    private volatile int _decision;

    public X(Z2.i iVar, Z2.e eVar) {
        super(iVar, eVar);
    }

    @Override // y3.B, t3.AbstractC1802a
    public void K0(Object obj) {
        if (P0()) {
            return;
        }
        AbstractC1957k.c(AbstractC0786b.c(this.f15953d), G.a(obj, this.f15953d), null, 2, null);
    }

    public final Object O0() {
        if (Q0()) {
            return AbstractC0787c.e();
        }
        Object objH = F0.h(b0());
        if (objH instanceof C) {
            throw ((C) objH).f14907a;
        }
        return objH;
    }

    public final boolean P0() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f14970e;
        do {
            int i4 = atomicIntegerFieldUpdater.get(this);
            if (i4 != 0) {
                if (i4 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!f14970e.compareAndSet(this, 0, 2));
        return true;
    }

    public final boolean Q0() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f14970e;
        do {
            int i4 = atomicIntegerFieldUpdater.get(this);
            if (i4 != 0) {
                if (i4 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended");
            }
        } while (!f14970e.compareAndSet(this, 0, 1));
        return true;
    }

    @Override // y3.B, t3.E0
    public void y(Object obj) {
        K0(obj);
    }
}
