package we;

import xf.i2;
import xf.k2;
import xf.l2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends xf.a0 implements xf.z0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xf.c1 f23989b;

    public j(xf.c1 delegate) {
        kotlin.jvm.internal.t.f(delegate, "delegate");
        this.f23989b = delegate;
    }

    @Override // xf.a0, xf.r0
    public boolean O0() {
        return false;
    }

    @Override // xf.l2
    /* JADX INFO: renamed from: U0 */
    public xf.c1 R0(boolean z10) {
        return z10 ? W0().R0(true) : this;
    }

    @Override // xf.a0
    public xf.c1 W0() {
        return this.f23989b;
    }

    public final xf.c1 Z0(xf.c1 c1Var) {
        xf.c1 c1VarR0 = c1Var.R0(false);
        return !cg.d.y(c1Var) ? c1VarR0 : new j(c1VarR0);
    }

    @Override // xf.c1
    /* JADX INFO: renamed from: a1, reason: merged with bridge method [inline-methods] */
    public j T0(xf.q1 newAttributes) {
        kotlin.jvm.internal.t.f(newAttributes, "newAttributes");
        return new j(W0().T0(newAttributes));
    }

    @Override // xf.a0
    /* JADX INFO: renamed from: b1, reason: merged with bridge method [inline-methods] */
    public j Y0(xf.c1 delegate) {
        kotlin.jvm.internal.t.f(delegate, "delegate");
        return new j(delegate);
    }

    @Override // xf.w
    public xf.r0 w(xf.r0 replacement) {
        kotlin.jvm.internal.t.f(replacement, "replacement");
        l2 l2VarQ0 = replacement.Q0();
        if (!cg.d.y(l2VarQ0) && !i2.l(l2VarQ0)) {
            return l2VarQ0;
        }
        if (l2VarQ0 instanceof xf.c1) {
            return Z0((xf.c1) l2VarQ0);
        }
        if (!(l2VarQ0 instanceof xf.i0)) {
            throw new cd.o();
        }
        xf.i0 i0Var = (xf.i0) l2VarQ0;
        return k2.d(xf.u0.e(Z0(i0Var.V0()), Z0(i0Var.W0())), k2.a(l2VarQ0));
    }

    @Override // xf.w
    public boolean z0() {
        return true;
    }
}
