package ce;

import dd.a0;
import fe.e0;
import fe.g1;
import fe.t;
import ie.g0;
import ie.t0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xf.a2;
import xf.c1;
import xf.m2;
import xf.q1;
import xf.r0;
import xf.u0;
import xf.u1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g0 f4025a;

    static {
        ie.p pVar = new ie.p(zf.l.f26552a.i(), o.f3965s);
        fe.f fVar = fe.f.f9474c;
        ef.f fVarF = o.f3968v.f();
        g1 g1Var = g1.f9483a;
        wf.n nVar = wf.f.f24060e;
        g0 g0Var = new g0(pVar, fVar, false, false, fVarF, g1Var, nVar);
        g0Var.M0(e0.f9464e);
        g0Var.O0(t.f9511e);
        g0Var.N0(dd.q.e(t0.R0(g0Var, ge.h.L.b(), false, m2.f25016f, ef.f.k("T"), 0, nVar)));
        g0Var.K0();
        f4025a = g0Var;
    }

    public static final c1 a(r0 suspendFunType) {
        kotlin.jvm.internal.t.f(suspendFunType, "suspendFunType");
        h.r(suspendFunType);
        i iVarN = cg.d.n(suspendFunType);
        ge.h annotations = suspendFunType.getAnnotations();
        r0 r0VarK = h.k(suspendFunType);
        List listE = h.e(suspendFunType);
        List listM = h.m(suspendFunType);
        ArrayList arrayList = new ArrayList(dd.s.u(listM, 10));
        Iterator it = listM.iterator();
        while (it.hasNext()) {
            arrayList.add(((a2) it.next()).getType());
        }
        q1 q1VarK = q1.f25042b.k();
        u1 u1VarK = f4025a.k();
        kotlin.jvm.internal.t.e(u1VarK, "getTypeConstructor(...)");
        List listT0 = a0.t0(arrayList, u0.k(q1VarK, u1VarK, dd.q.e(cg.d.d(h.l(suspendFunType))), false, null, 16, null));
        c1 c1VarJ = cg.d.n(suspendFunType).J();
        kotlin.jvm.internal.t.e(c1VarJ, "getNullableAnyType(...)");
        return h.b(iVarN, annotations, r0VarK, listE, listT0, null, c1VarJ, (128 & 128) != 0 ? false : false).R0(suspendFunType.O0());
    }
}
