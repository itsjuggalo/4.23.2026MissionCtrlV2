package fe;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class y {
    public static final e b(h0 h0Var, ef.b classId) {
        kotlin.jvm.internal.t.f(h0Var, "<this>");
        kotlin.jvm.internal.t.f(classId, "classId");
        h hVarC = c(h0Var, classId);
        if (hVarC instanceof e) {
            return (e) hVarC;
        }
        return null;
    }

    public static final h c(h0 h0Var, ef.b classId) {
        kotlin.jvm.internal.t.f(h0Var, "<this>");
        kotlin.jvm.internal.t.f(classId, "classId");
        h0 h0VarA = jf.s.a(h0Var);
        if (h0VarA == null) {
            u0 u0VarI0 = h0Var.I0(classId.f());
            List listE = classId.g().e();
            h hVarE = u0VarI0.q().e((ef.f) dd.a0.Z(listE), ne.d.f17051r);
            if (hVarE == null) {
                return null;
            }
            for (ef.f fVar : listE.subList(1, listE.size())) {
                if (!(hVarE instanceof e)) {
                    return null;
                }
                h hVarE2 = ((e) hVarE).x0().e(fVar, ne.d.f17051r);
                hVarE = hVarE2 instanceof e ? (e) hVarE2 : null;
                if (hVarE == null) {
                    return null;
                }
            }
            return hVarE;
        }
        u0 u0VarI02 = h0VarA.I0(classId.f());
        List listE2 = classId.g().e();
        h hVarE3 = u0VarI02.q().e((ef.f) dd.a0.Z(listE2), ne.d.f17051r);
        if (hVarE3 == null) {
            hVarE3 = null;
            break;
        }
        for (ef.f fVar2 : listE2.subList(1, listE2.size())) {
            if (hVarE3 instanceof e) {
                h hVarE4 = ((e) hVarE3).x0().e(fVar2, ne.d.f17051r);
                hVarE3 = hVarE4 instanceof e ? (e) hVarE4 : null;
                if (hVarE3 != null) {
                }
            }
            hVarE3 = null;
        }
        if (hVarE3 != null) {
            return hVarE3;
        }
        u0 u0VarI03 = h0Var.I0(classId.f());
        List listE3 = classId.g().e();
        h hVarE5 = u0VarI03.q().e((ef.f) dd.a0.Z(listE3), ne.d.f17051r);
        if (hVarE5 == null) {
            return null;
        }
        for (ef.f fVar3 : listE3.subList(1, listE3.size())) {
            if (!(hVarE5 instanceof e)) {
                return null;
            }
            h hVarE6 = ((e) hVarE5).x0().e(fVar3, ne.d.f17051r);
            hVarE5 = hVarE6 instanceof e ? (e) hVarE6 : null;
            if (hVarE5 == null) {
                return null;
            }
        }
        return hVarE5;
    }

    public static final e d(h0 h0Var, ef.b classId, m0 notFoundClasses) {
        kotlin.jvm.internal.t.f(h0Var, "<this>");
        kotlin.jvm.internal.t.f(classId, "classId");
        kotlin.jvm.internal.t.f(notFoundClasses, "notFoundClasses");
        e eVarB = b(h0Var, classId);
        return eVarB != null ? eVarB : notFoundClasses.d(classId, jg.t.M(jg.t.E(jg.q.n(classId, new kotlin.jvm.internal.g0() { // from class: fe.y.a
            @Override // kotlin.jvm.internal.g0, wd.o
            public Object get(Object obj) {
                return ((ef.b) obj).e();
            }
        }), x.f9542a)));
    }

    public static final int e(ef.b it) {
        kotlin.jvm.internal.t.f(it, "it");
        return 0;
    }

    public static final k1 f(h0 h0Var, ef.b classId) {
        kotlin.jvm.internal.t.f(h0Var, "<this>");
        kotlin.jvm.internal.t.f(classId, "classId");
        h hVarC = c(h0Var, classId);
        if (hVarC instanceof k1) {
            return (k1) hVarC;
        }
        return null;
    }
}
