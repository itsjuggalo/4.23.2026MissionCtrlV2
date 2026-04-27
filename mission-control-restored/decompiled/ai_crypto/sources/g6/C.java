package g6;

import b6.L0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public abstract class C extends AbstractC1645e implements L0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f14268d = AtomicIntegerFieldUpdater.newUpdater(C.class, "cleanedAndPointers");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f14269c;
    private volatile int cleanedAndPointers;

    public C(long j7, C c7, int i7) {
        super(c7);
        this.f14269c = j7;
        this.cleanedAndPointers = i7 << 16;
    }

    @Override // g6.AbstractC1645e
    public boolean h() {
        return f14268d.get(this) == n() && !i();
    }

    public final boolean m() {
        return f14268d.addAndGet(this, -65536) == n() && !i();
    }

    public abstract int n();

    public abstract void o(int i7, Throwable th, H5.g gVar);

    public final void p() {
        if (f14268d.incrementAndGet(this) == n()) {
            k();
        }
    }

    public final boolean q() {
        int i7;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f14268d;
        do {
            i7 = atomicIntegerFieldUpdater.get(this);
            if (i7 == n() && !i()) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i7, 65536 + i7));
        return true;
    }
}
