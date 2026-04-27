package w4;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class R1 extends W1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicIntegerFieldUpdater f11057c;

    public R1(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
        this.f11057c = atomicIntegerFieldUpdater;
    }

    @Override // w4.W1
    public final boolean r(T1 t12) {
        return this.f11057c.compareAndSet(t12, 0, -1);
    }

    @Override // w4.W1
    public final void s(T1 t12) {
        this.f11057c.set(t12, 0);
    }
}
