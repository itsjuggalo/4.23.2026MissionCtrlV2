package oe;

import fe.f1;
import fe.x0;
import fe.y0;
import xf.c1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class s0 {
    public static final boolean d(fe.b bVar) {
        kotlin.jvm.internal.t.f(bVar, "<this>");
        return g(bVar) != null;
    }

    public static final String e(fe.b callableMemberDescriptor) {
        fe.b bVarW;
        ef.f fVarJ;
        kotlin.jvm.internal.t.f(callableMemberDescriptor, "callableMemberDescriptor");
        fe.b bVarF = f(callableMemberDescriptor);
        if (bVarF != null && (bVarW = nf.e.w(bVarF)) != null) {
            if (bVarW instanceof y0) {
                return m.f18040a.b(bVarW);
            }
            if ((bVarW instanceof f1) && (fVarJ = f.f17966o.j((f1) bVarW)) != null) {
                return fVarJ.b();
            }
        }
        return null;
    }

    public static final fe.b f(fe.b bVar) {
        if (ce.i.h0(bVar)) {
            return g(bVar);
        }
        return null;
    }

    public static final fe.b g(fe.b bVar) {
        kotlin.jvm.internal.t.f(bVar, "<this>");
        if (!t0.f18060a.g().contains(bVar.getName()) && !j.f18004a.d().contains(nf.e.w(bVar).getName())) {
            return null;
        }
        if ((bVar instanceof y0) || (bVar instanceof x0)) {
            return nf.e.i(bVar, false, p0.f18053a, 1, null);
        }
        if (bVar instanceof f1) {
            return nf.e.i(bVar, false, q0.f18055a, 1, null);
        }
        return null;
    }

    public static final boolean h(fe.b it) {
        kotlin.jvm.internal.t.f(it, "it");
        return m.f18040a.d(nf.e.w(it));
    }

    public static final boolean i(fe.b it) {
        kotlin.jvm.internal.t.f(it, "it");
        return f.f17966o.k((f1) it);
    }

    public static final fe.b j(fe.b bVar) {
        kotlin.jvm.internal.t.f(bVar, "<this>");
        fe.b bVarG = g(bVar);
        if (bVarG != null) {
            return bVarG;
        }
        i iVar = i.f17980o;
        ef.f name = bVar.getName();
        kotlin.jvm.internal.t.e(name, "getName(...)");
        if (iVar.n(name)) {
            return nf.e.i(bVar, false, r0.f18059a, 1, null);
        }
        return null;
    }

    public static final boolean k(fe.b it) {
        kotlin.jvm.internal.t.f(it, "it");
        return ce.i.h0(it) && i.o(it) != null;
    }

    public static final boolean l(fe.e eVar, fe.a specialCallableDescriptor) {
        kotlin.jvm.internal.t.f(eVar, "<this>");
        kotlin.jvm.internal.t.f(specialCallableDescriptor, "specialCallableDescriptor");
        fe.m mVarB = specialCallableDescriptor.b();
        kotlin.jvm.internal.t.d(mVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        c1 c1VarS = ((fe.e) mVarB).s();
        kotlin.jvm.internal.t.e(c1VarS, "getDefaultType(...)");
        for (fe.e eVarS = jf.i.s(eVar); eVarS != null; eVarS = jf.i.s(eVarS)) {
            if (!(eVarS instanceof qe.c) && yf.w.b(eVarS.s(), c1VarS) != null) {
                return !ce.i.h0(eVarS);
            }
        }
        return false;
    }

    public static final boolean m(fe.b bVar) {
        kotlin.jvm.internal.t.f(bVar, "<this>");
        return nf.e.w(bVar).b() instanceof qe.c;
    }

    public static final boolean n(fe.b bVar) {
        kotlin.jvm.internal.t.f(bVar, "<this>");
        return m(bVar) || ce.i.h0(bVar);
    }
}
