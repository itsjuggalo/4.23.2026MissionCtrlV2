package b6;

import F5.C0548f;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: renamed from: b6.g0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1070g0 extends I {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f9062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f9063d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public C0548f f9064e;

    public static /* synthetic */ void C0(AbstractC1070g0 abstractC1070g0, boolean z7, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
        }
        if ((i7 & 1) != 0) {
            z7 = false;
        }
        abstractC1070g0.B0(z7);
    }

    public static /* synthetic */ void H0(AbstractC1070g0 abstractC1070g0, boolean z7, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i7 & 1) != 0) {
            z7 = false;
        }
        abstractC1070g0.G0(z7);
    }

    public final void B0(boolean z7) {
        long jD0 = this.f9062c - D0(z7);
        this.f9062c = jD0;
        if (jD0 <= 0 && this.f9063d) {
            shutdown();
        }
    }

    public final long D0(boolean z7) {
        return z7 ? 4294967296L : 1L;
    }

    public final void E0(Y y7) {
        C0548f c0548f = this.f9064e;
        if (c0548f == null) {
            c0548f = new C0548f();
            this.f9064e = c0548f;
        }
        c0548f.addLast(y7);
    }

    public long F0() {
        C0548f c0548f = this.f9064e;
        return (c0548f == null || c0548f.isEmpty()) ? Long.MAX_VALUE : 0L;
    }

    public final void G0(boolean z7) {
        this.f9062c += D0(z7);
        if (z7) {
            return;
        }
        this.f9063d = true;
    }

    public final boolean I0() {
        return this.f9062c >= D0(true);
    }

    public final boolean J0() {
        C0548f c0548f = this.f9064e;
        if (c0548f != null) {
            return c0548f.isEmpty();
        }
        return true;
    }

    public abstract long K0();

    public final boolean L0() throws IllegalAccessException, InvocationTargetException {
        Y y7;
        C0548f c0548f = this.f9064e;
        if (c0548f == null || (y7 = (Y) c0548f.r()) == null) {
            return false;
        }
        y7.run();
        return true;
    }

    public boolean M0() {
        return false;
    }

    public abstract void shutdown();
}
