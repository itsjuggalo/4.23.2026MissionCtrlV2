package xf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class n2 extends r0 {
    public n2() {
        super(null);
    }

    @Override // xf.r0
    public List L0() {
        return R0().L0();
    }

    @Override // xf.r0
    public q1 M0() {
        return R0().M0();
    }

    @Override // xf.r0
    public u1 N0() {
        return R0().N0();
    }

    @Override // xf.r0
    public boolean O0() {
        return R0().O0();
    }

    @Override // xf.r0
    public final l2 Q0() {
        r0 r0VarR0 = R0();
        while (r0VarR0 instanceof n2) {
            r0VarR0 = ((n2) r0VarR0).R0();
        }
        kotlin.jvm.internal.t.d(r0VarR0, "null cannot be cast to non-null type org.jetbrains.kotlin.types.UnwrappedType");
        return (l2) r0VarR0;
    }

    public abstract r0 R0();

    public abstract boolean S0();

    @Override // xf.r0
    public qf.k q() {
        return R0().q();
    }

    public String toString() {
        return S0() ? R0().toString() : "<Not computed yet>";
    }
}
