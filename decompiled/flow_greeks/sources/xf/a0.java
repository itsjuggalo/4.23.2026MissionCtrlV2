package xf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a0 extends c1 {
    @Override // xf.r0
    public List L0() {
        return W0().L0();
    }

    @Override // xf.r0
    public q1 M0() {
        return W0().M0();
    }

    @Override // xf.r0
    public u1 N0() {
        return W0().N0();
    }

    @Override // xf.r0
    public boolean O0() {
        return W0().O0();
    }

    public abstract c1 W0();

    @Override // xf.l2
    public c1 X0(yf.g kotlinTypeRefiner) {
        kotlin.jvm.internal.t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        r0 r0VarA = kotlinTypeRefiner.a(W0());
        kotlin.jvm.internal.t.d(r0VarA, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return Y0((c1) r0VarA);
    }

    public abstract a0 Y0(c1 c1Var);

    @Override // xf.r0
    public qf.k q() {
        return W0().q();
    }
}
