package sg;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import ng.m2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a0 extends b implements m2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f20377d = AtomicIntegerFieldUpdater.newUpdater(a0.class, "cleanedAndPointers$volatile");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f20378c;
    private volatile /* synthetic */ int cleanedAndPointers$volatile;

    public a0(long j10, a0 a0Var, int i10) {
        super(a0Var);
        this.f20378c = j10;
        this.cleanedAndPointers$volatile = i10 << 16;
    }

    @Override // sg.b
    public boolean k() {
        return f20377d.get(this) == r() && !l();
    }

    public final boolean p() {
        return f20377d.addAndGet(this, -65536) == r() && !l();
    }

    public abstract int r();

    public abstract void s(int i10, Throwable th, gd.i iVar);

    public final void t() {
        if (f20377d.incrementAndGet(this) == r()) {
            n();
        }
    }

    public final boolean u() {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f20377d;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 == r() && !l()) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, 65536 + i10));
        return true;
    }
}
