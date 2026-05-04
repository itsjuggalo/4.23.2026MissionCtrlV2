package xf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e2 {
    public static final c1 a(r0 r0Var) {
        kotlin.jvm.internal.t.f(r0Var, "<this>");
        l2 l2VarQ0 = r0Var.Q0();
        c1 c1Var = l2VarQ0 instanceof c1 ? (c1) l2VarQ0 : null;
        if (c1Var != null) {
            return c1Var;
        }
        throw new IllegalStateException(("This is should be simple type: " + r0Var).toString());
    }

    public static final r0 b(r0 r0Var, List newArguments, ge.h newAnnotations) {
        kotlin.jvm.internal.t.f(r0Var, "<this>");
        kotlin.jvm.internal.t.f(newArguments, "newArguments");
        kotlin.jvm.internal.t.f(newAnnotations, "newAnnotations");
        return e(r0Var, newArguments, newAnnotations, null, 4, null);
    }

    public static final r0 c(r0 r0Var, List newArguments, ge.h newAnnotations, List newArgumentsForUpperBound) {
        kotlin.jvm.internal.t.f(r0Var, "<this>");
        kotlin.jvm.internal.t.f(newArguments, "newArguments");
        kotlin.jvm.internal.t.f(newAnnotations, "newAnnotations");
        kotlin.jvm.internal.t.f(newArgumentsForUpperBound, "newArgumentsForUpperBound");
        if ((newArguments.isEmpty() || newArguments == r0Var.L0()) && newAnnotations == r0Var.getAnnotations()) {
            return r0Var;
        }
        q1 q1VarM0 = r0Var.M0();
        if ((newAnnotations instanceof ge.p) && ((ge.p) newAnnotations).isEmpty()) {
            newAnnotations = ge.h.L.b();
        }
        q1 q1VarA = r1.a(q1VarM0, newAnnotations);
        l2 l2VarQ0 = r0Var.Q0();
        if (l2VarQ0 instanceof i0) {
            i0 i0Var = (i0) l2VarQ0;
            return u0.e(d(i0Var.V0(), newArguments, q1VarA), d(i0Var.W0(), newArgumentsForUpperBound, q1VarA));
        }
        if (l2VarQ0 instanceof c1) {
            return d((c1) l2VarQ0, newArguments, q1VarA);
        }
        throw new cd.o();
    }

    public static final c1 d(c1 c1Var, List newArguments, q1 newAttributes) {
        kotlin.jvm.internal.t.f(c1Var, "<this>");
        kotlin.jvm.internal.t.f(newArguments, "newArguments");
        kotlin.jvm.internal.t.f(newAttributes, "newAttributes");
        return (newArguments.isEmpty() && newAttributes == c1Var.M0()) ? c1Var : newArguments.isEmpty() ? c1Var.T0(newAttributes) : c1Var instanceof zf.i ? ((zf.i) c1Var).Z0(newArguments) : u0.k(newAttributes, c1Var.N0(), newArguments, c1Var.O0(), null, 16, null);
    }

    public static /* synthetic */ r0 e(r0 r0Var, List list, ge.h hVar, List list2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = r0Var.L0();
        }
        if ((i10 & 2) != 0) {
            hVar = r0Var.getAnnotations();
        }
        if ((i10 & 4) != 0) {
            list2 = list;
        }
        return c(r0Var, list, hVar, list2);
    }

    public static /* synthetic */ c1 f(c1 c1Var, List list, q1 q1Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = c1Var.L0();
        }
        if ((i10 & 2) != 0) {
            q1Var = c1Var.M0();
        }
        return d(c1Var, list, q1Var);
    }
}
