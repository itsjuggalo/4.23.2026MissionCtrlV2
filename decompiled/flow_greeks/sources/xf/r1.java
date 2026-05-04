package xf;

import xf.p1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r1 {
    public static final q1 a(q1 q1Var, ge.h newAnnotations) {
        q1 q1VarV;
        kotlin.jvm.internal.t.f(q1Var, "<this>");
        kotlin.jvm.internal.t.f(newAnnotations, "newAnnotations");
        if (t.a(q1Var) == newAnnotations) {
            return q1Var;
        }
        s sVarB = t.b(q1Var);
        if (sVarB != null && (q1VarV = q1Var.v(sVarB)) != null) {
            q1Var = q1VarV;
        }
        return (newAnnotations.iterator().hasNext() || !newAnnotations.isEmpty()) ? q1Var.u(new s(newAnnotations)) : q1Var;
    }

    public static final q1 b(ge.h hVar) {
        kotlin.jvm.internal.t.f(hVar, "<this>");
        return p1.a.a(x.f25092a, hVar, null, null, 6, null);
    }
}
