package we;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import xf.i2;
import xf.l2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f24003a;

    public l1(g typeEnhancement) {
        kotlin.jvm.internal.t.f(typeEnhancement, "typeEnhancement");
        this.f24003a = typeEnhancement;
    }

    public static final Boolean g(l2 l2Var) {
        fe.h hVarB = l2Var.N0().b();
        if (hVarB == null) {
            return Boolean.FALSE;
        }
        ef.f name = hVarB.getName();
        ee.c cVar = ee.c.f8681a;
        return Boolean.valueOf(kotlin.jvm.internal.t.b(name, cVar.h().f()) && kotlin.jvm.internal.t.b(nf.e.k(hVarB), cVar.h()));
    }

    public static /* synthetic */ xf.r0 j(l1 l1Var, fe.b bVar, ge.a aVar, boolean z10, re.k kVar, oe.c cVar, q1 q1Var, boolean z11, pd.k kVar2, int i10, Object obj) {
        return l1Var.h(bVar, aVar, z10, kVar, cVar, q1Var, (i10 & 32) != 0 ? false : z11, kVar2);
    }

    public static /* synthetic */ xf.r0 k(l1 l1Var, n1 n1Var, xf.r0 r0Var, List list, q1 q1Var, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            q1Var = null;
        }
        q1 q1Var2 = q1Var;
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        return l1Var.i(n1Var, r0Var, list, q1Var2, z10);
    }

    public static final xf.r0 m(fe.b it) {
        kotlin.jvm.internal.t.f(it, "it");
        xf.r0 returnType = it.getReturnType();
        kotlin.jvm.internal.t.c(returnType);
        return returnType;
    }

    public static final xf.r0 n(fe.b it) {
        kotlin.jvm.internal.t.f(it, "it");
        fe.b1 b1VarK0 = it.k0();
        kotlin.jvm.internal.t.c(b1VarK0);
        xf.r0 type = b1VarK0.getType();
        kotlin.jvm.internal.t.e(type, "getType(...)");
        return type;
    }

    public static final xf.r0 o(fe.s1 s1Var, fe.b it) {
        kotlin.jvm.internal.t.f(it, "it");
        xf.r0 type = ((fe.s1) it.i().get(s1Var.getIndex())).getType();
        kotlin.jvm.internal.t.e(type, "getType(...)");
        return type;
    }

    public static final boolean s(l2 it) {
        kotlin.jvm.internal.t.f(it, "it");
        return it instanceof xf.b1;
    }

    public final boolean f(xf.r0 r0Var) {
        return i2.c(r0Var, k1.f23998a);
    }

    public final xf.r0 h(fe.b bVar, ge.a aVar, boolean z10, re.k kVar, oe.c cVar, q1 q1Var, boolean z11, pd.k kVar2) {
        n1 n1Var = new n1(aVar, z10, kVar, cVar, false, 16, null);
        xf.r0 r0Var = (xf.r0) kVar2.invoke(bVar);
        Collection<fe.b> collectionF = bVar.f();
        kotlin.jvm.internal.t.e(collectionF, "getOverriddenDescriptors(...)");
        ArrayList arrayList = new ArrayList(dd.s.u(collectionF, 10));
        for (fe.b bVar2 : collectionF) {
            kotlin.jvm.internal.t.c(bVar2);
            arrayList.add((xf.r0) kVar2.invoke(bVar2));
        }
        return i(n1Var, r0Var, arrayList, q1Var, z11);
    }

    public final xf.r0 i(n1 n1Var, xf.r0 r0Var, List list, q1 q1Var, boolean z10) {
        return this.f24003a.a(r0Var, n1Var.d(r0Var, list, q1Var, z10), n1Var.z());
    }

    /* JADX WARN: Code restructure failed: missing block: B:131:0x021a, code lost:
    
        if (r3 == null) goto L133;
     */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01f4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final fe.b l(fe.b r18, re.k r19) {
        /*
            Method dump skipped, instruction units count: 636
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: we.l1.l(fe.b, re.k):fe.b");
    }

    public final Collection p(re.k c10, Collection platformSignatures) {
        kotlin.jvm.internal.t.f(c10, "c");
        kotlin.jvm.internal.t.f(platformSignatures, "platformSignatures");
        ArrayList arrayList = new ArrayList(dd.s.u(platformSignatures, 10));
        Iterator it = platformSignatures.iterator();
        while (it.hasNext()) {
            arrayList.add(l((fe.b) it.next(), c10));
        }
        return arrayList;
    }

    public final xf.r0 q(xf.r0 type, re.k context) {
        kotlin.jvm.internal.t.f(type, "type");
        kotlin.jvm.internal.t.f(context, "context");
        xf.r0 r0VarK = k(this, new n1(null, false, context, oe.c.f17947e, true), type, dd.r.k(), null, false, 12, null);
        return r0VarK == null ? type : r0VarK;
    }

    public final List r(fe.l1 typeParameter, List bounds, re.k context) {
        xf.r0 r0Var;
        xf.r0 r0VarK;
        kotlin.jvm.internal.t.f(typeParameter, "typeParameter");
        kotlin.jvm.internal.t.f(bounds, "bounds");
        kotlin.jvm.internal.t.f(context, "context");
        ArrayList arrayList = new ArrayList(dd.s.u(bounds, 10));
        Iterator it = bounds.iterator();
        while (it.hasNext()) {
            xf.r0 r0Var2 = (xf.r0) it.next();
            if (cg.d.e(r0Var2, j1.f23991a)) {
                r0Var = r0Var2;
            } else {
                r0Var = r0Var2;
                r0VarK = k(this, new n1(typeParameter, false, context, oe.c.f17948f, false, 16, null), r0Var, dd.r.k(), null, false, 12, null);
                if (r0VarK == null) {
                }
                arrayList.add(r0VarK);
            }
            r0VarK = r0Var;
            arrayList.add(r0VarK);
        }
        return arrayList;
    }

    public final xf.r0 t(fe.b bVar, fe.s1 s1Var, re.k kVar, q1 q1Var, boolean z10, pd.k kVar2) {
        re.k kVarK;
        return h(bVar, s1Var, false, (s1Var == null || (kVarK = re.c.k(kVar, s1Var.getAnnotations())) == null) ? kVar : kVarK, oe.c.f17945c, q1Var, z10, kVar2);
    }

    public final ge.h u(fe.b bVar, re.k kVar) {
        fe.h hVarA = fe.s.a(bVar);
        if (hVarA == null) {
            return bVar.getAnnotations();
        }
        se.n nVar = hVarA instanceof se.n ? (se.n) hVarA : null;
        List listT0 = nVar != null ? nVar.T0() : null;
        if (listT0 == null || listT0.isEmpty()) {
            return bVar.getAnnotations();
        }
        ArrayList arrayList = new ArrayList(dd.s.u(listT0, 10));
        Iterator it = listT0.iterator();
        while (it.hasNext()) {
            arrayList.add(new se.j(kVar, (ve.a) it.next(), true));
        }
        return ge.h.L.a(dd.a0.q0(bVar.getAnnotations(), arrayList));
    }
}
