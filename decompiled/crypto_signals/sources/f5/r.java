package f5;

import a5.s0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public abstract class r extends b implements s0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6530d = AtomicIntegerFieldUpdater.newUpdater(r.class, "cleanedAndPointers$volatile");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f6531c;
    private volatile /* synthetic */ int cleanedAndPointers$volatile;

    public r(long j4, r rVar, int i) {
        super(rVar);
        this.f6531c = j4;
        this.cleanedAndPointers$volatile = i << 16;
    }

    @Override // f5.b
    public final boolean d() {
        return f6530d.get(this) == g() && c() != null;
    }

    public final boolean f() {
        return f6530d.addAndGet(this, -65536) == g() && c() != null;
    }

    public abstract int g();

    public abstract void h(int i, I4.i iVar);

    public final void i() {
        if (f6530d.incrementAndGet(this) == g()) {
            e();
        }
    }

    public final boolean j() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i;
        do {
            atomicIntegerFieldUpdater = f6530d;
            i = atomicIntegerFieldUpdater.get(this);
            if (i == g() && c() != null) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 65536 + i));
        return true;
    }
}
