package Y6;

import d7.AbstractC1651l;
import p5.C2587i;

/* JADX INFO: renamed from: Y6.e0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1002e0 extends I {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f9660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f9661d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public C2587i f9662e;

    public static /* synthetic */ void A0(AbstractC1002e0 abstractC1002e0, boolean z7, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
        }
        if ((i8 & 1) != 0) {
            z7 = false;
        }
        abstractC1002e0.z0(z7);
    }

    public static /* synthetic */ void F0(AbstractC1002e0 abstractC1002e0, boolean z7, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i8 & 1) != 0) {
            z7 = false;
        }
        abstractC1002e0.E0(z7);
    }

    public final long B0(boolean z7) {
        return z7 ? 4294967296L : 1L;
    }

    public final void C0(Y y7) {
        C2587i c2587i = this.f9662e;
        if (c2587i == null) {
            c2587i = new C2587i();
            this.f9662e = c2587i;
        }
        c2587i.addLast(y7);
    }

    public long D0() {
        C2587i c2587i = this.f9662e;
        return (c2587i == null || c2587i.isEmpty()) ? Long.MAX_VALUE : 0L;
    }

    public final void E0(boolean z7) {
        this.f9660c += B0(z7);
        if (z7) {
            return;
        }
        this.f9661d = true;
    }

    public final boolean G0() {
        return this.f9660c >= B0(true);
    }

    public final boolean H0() {
        C2587i c2587i = this.f9662e;
        if (c2587i != null) {
            return c2587i.isEmpty();
        }
        return true;
    }

    public abstract long I0();

    public final boolean J0() {
        Y y7;
        C2587i c2587i = this.f9662e;
        if (c2587i == null || (y7 = (Y) c2587i.K()) == null) {
            return false;
        }
        y7.run();
        return true;
    }

    public boolean K0() {
        return false;
    }

    public abstract void shutdown();

    @Override // Y6.I
    public final I x0(int i8, String str) {
        AbstractC1651l.a(i8);
        return AbstractC1651l.b(this, str);
    }

    public final void z0(boolean z7) {
        long jB0 = this.f9660c - B0(z7);
        this.f9660c = jB0;
        if (jB0 <= 0 && this.f9661d) {
            shutdown();
        }
    }
}
