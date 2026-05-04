package ng;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class y0 extends sg.z {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f17197e = AtomicIntegerFieldUpdater.newUpdater(y0.class, "_decision$volatile");
    private volatile /* synthetic */ int _decision$volatile;

    public y0(gd.i iVar, gd.e eVar) {
        super(iVar, eVar);
    }

    @Override // sg.z, ng.a
    public void K0(Object obj) {
        if (Q0()) {
            return;
        }
        sg.i.b(hd.b.c(this.f20435d), e0.a(obj, this.f20435d));
    }

    public final Object O0() {
        if (R0()) {
            return hd.c.f();
        }
        Object objH = f2.h(Z());
        if (objH instanceof c0) {
            throw ((c0) objH).f17078a;
        }
        return objH;
    }

    public final boolean Q0() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f17197e;
        do {
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 != 0) {
                if (i10 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!f17197e.compareAndSet(this, 0, 2));
        return true;
    }

    public final boolean R0() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f17197e;
        do {
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 != 0) {
                if (i10 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended");
            }
        } while (!f17197e.compareAndSet(this, 0, 1));
        return true;
    }

    @Override // sg.z, ng.e2
    public void x(Object obj) {
        K0(obj);
    }
}
