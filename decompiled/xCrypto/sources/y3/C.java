package y3;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import t3.L0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class C extends AbstractC1951e implements L0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f15954d = AtomicIntegerFieldUpdater.newUpdater(C.class, "cleanedAndPointers");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f15955c;
    private volatile int cleanedAndPointers;

    public C(long j4, C c4, int i4) {
        super(c4);
        this.f15955c = j4;
        this.cleanedAndPointers = i4 << 16;
    }

    @Override // y3.AbstractC1951e
    public boolean h() {
        return f15954d.get(this) == n() && !i();
    }

    public final boolean m() {
        return f15954d.addAndGet(this, -65536) == n() && !i();
    }

    public abstract int n();

    public abstract void o(int i4, Throwable th, Z2.i iVar);

    public final void p() {
        if (f15954d.incrementAndGet(this) == n()) {
            k();
        }
    }

    public final boolean q() {
        int i4;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f15954d;
        do {
            i4 = atomicIntegerFieldUpdater.get(this);
            if (i4 == n() && !i()) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i4, 65536 + i4));
        return true;
    }
}
