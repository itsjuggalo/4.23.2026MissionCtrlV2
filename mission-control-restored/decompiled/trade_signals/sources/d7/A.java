package d7;

import Y6.H0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import s5.InterfaceC2711i;

/* JADX INFO: loaded from: classes2.dex */
public abstract class A extends AbstractC1641b implements H0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f17023d = AtomicIntegerFieldUpdater.newUpdater(A.class, "cleanedAndPointers$volatile");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f17024c;
    private volatile /* synthetic */ int cleanedAndPointers$volatile;

    public A(long j8, A a8, int i8) {
        super(a8);
        this.f17024c = j8;
        this.cleanedAndPointers$volatile = i8 << 16;
    }

    @Override // d7.AbstractC1641b
    public boolean k() {
        return f17023d.get(this) == r() && !l();
    }

    public final boolean p() {
        return f17023d.addAndGet(this, -65536) == r() && !l();
    }

    public abstract int r();

    public abstract void s(int i8, Throwable th, InterfaceC2711i interfaceC2711i);

    public final void t() {
        if (f17023d.incrementAndGet(this) == r()) {
            n();
        }
    }

    public final boolean u() {
        int i8;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f17023d;
        do {
            i8 = atomicIntegerFieldUpdater.get(this);
            if (i8 == r() && !l()) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i8, 65536 + i8));
        return true;
    }
}
