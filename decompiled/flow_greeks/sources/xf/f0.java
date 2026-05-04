package xf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f0 {
    public static /* synthetic */ a2 b(f0 f0Var, fe.l1 l1Var, g0 g0Var, z1 z1Var, r0 r0Var, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: computeProjection");
        }
        if ((i10 & 8) != 0) {
            r0Var = z1Var.e(l1Var, g0Var);
        }
        return f0Var.a(l1Var, g0Var, z1Var, r0Var);
    }

    public a2 a(fe.l1 parameter, g0 typeAttr, z1 typeParameterUpperBoundEraser, r0 erasedUpperBound) {
        kotlin.jvm.internal.t.f(parameter, "parameter");
        kotlin.jvm.internal.t.f(typeAttr, "typeAttr");
        kotlin.jvm.internal.t.f(typeParameterUpperBoundEraser, "typeParameterUpperBoundEraser");
        kotlin.jvm.internal.t.f(erasedUpperBound, "erasedUpperBound");
        return new c2(m2.f25017g, erasedUpperBound);
    }
}
