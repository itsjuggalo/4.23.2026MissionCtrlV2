package xf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l0 {
    public static final i0 a(r0 r0Var) {
        kotlin.jvm.internal.t.f(r0Var, "<this>");
        l2 l2VarQ0 = r0Var.Q0();
        kotlin.jvm.internal.t.d(l2VarQ0, "null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
        return (i0) l2VarQ0;
    }

    public static final boolean b(r0 r0Var) {
        kotlin.jvm.internal.t.f(r0Var, "<this>");
        return r0Var.Q0() instanceof i0;
    }

    public static final c1 c(r0 r0Var) {
        kotlin.jvm.internal.t.f(r0Var, "<this>");
        l2 l2VarQ0 = r0Var.Q0();
        if (l2VarQ0 instanceof i0) {
            return ((i0) l2VarQ0).V0();
        }
        if (l2VarQ0 instanceof c1) {
            return (c1) l2VarQ0;
        }
        throw new cd.o();
    }

    public static final c1 d(r0 r0Var) {
        kotlin.jvm.internal.t.f(r0Var, "<this>");
        l2 l2VarQ0 = r0Var.Q0();
        if (l2VarQ0 instanceof i0) {
            return ((i0) l2VarQ0).W0();
        }
        if (l2VarQ0 instanceof c1) {
            return (c1) l2VarQ0;
        }
        throw new cd.o();
    }
}
