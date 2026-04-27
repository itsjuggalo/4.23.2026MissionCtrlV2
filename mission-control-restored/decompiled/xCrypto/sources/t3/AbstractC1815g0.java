package t3;

import X2.C0760g;
import java.lang.reflect.InvocationTargetException;
import y3.AbstractC1960n;

/* JADX INFO: renamed from: t3.g0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1815g0 extends I {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f15004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f15005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public C0760g f15006e;

    public static /* synthetic */ void h0(AbstractC1815g0 abstractC1815g0, boolean z4, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
        }
        if ((i4 & 1) != 0) {
            z4 = false;
        }
        abstractC1815g0.g0(z4);
    }

    public static /* synthetic */ void m0(AbstractC1815g0 abstractC1815g0, boolean z4, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i4 & 1) != 0) {
            z4 = false;
        }
        abstractC1815g0.l0(z4);
    }

    @Override // t3.I
    public final I f0(int i4) {
        AbstractC1960n.a(i4);
        return this;
    }

    public final void g0(boolean z4) {
        long jI0 = this.f15004c - i0(z4);
        this.f15004c = jI0;
        if (jI0 <= 0 && this.f15005d) {
            shutdown();
        }
    }

    public final long i0(boolean z4) {
        return z4 ? 4294967296L : 1L;
    }

    public final void j0(Y y4) {
        C0760g c0760g = this.f15006e;
        if (c0760g == null) {
            c0760g = new C0760g();
            this.f15006e = c0760g;
        }
        c0760g.addLast(y4);
    }

    public long k0() {
        C0760g c0760g = this.f15006e;
        return (c0760g == null || c0760g.isEmpty()) ? Long.MAX_VALUE : 0L;
    }

    public final void l0(boolean z4) {
        this.f15004c += i0(z4);
        if (z4) {
            return;
        }
        this.f15005d = true;
    }

    public final boolean n0() {
        return this.f15004c >= i0(true);
    }

    public final boolean o0() {
        C0760g c0760g = this.f15006e;
        if (c0760g != null) {
            return c0760g.isEmpty();
        }
        return true;
    }

    public abstract long p0();

    public final boolean q0() throws IllegalAccessException, InvocationTargetException {
        Y y4;
        C0760g c0760g = this.f15006e;
        if (c0760g == null || (y4 = (Y) c0760g.t()) == null) {
            return false;
        }
        y4.run();
        return true;
    }

    public boolean r0() {
        return false;
    }

    public abstract void shutdown();
}
