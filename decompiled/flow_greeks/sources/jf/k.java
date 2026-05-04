package jf;

import fe.a0;
import fe.i0;
import fe.q1;
import fe.t1;
import fe.y0;
import fe.z0;
import xf.c1;
import xf.f2;
import xf.m2;
import xf.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ef.c f14333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ef.b f14334b;

    static {
        ef.c cVar = new ef.c("kotlin.jvm.JvmInline");
        f14333a = cVar;
        f14334b = ef.b.f8779d.c(cVar);
    }

    public static final boolean a(fe.a aVar) {
        kotlin.jvm.internal.t.f(aVar, "<this>");
        if (!(aVar instanceof z0)) {
            return false;
        }
        y0 y0VarB0 = ((z0) aVar).B0();
        kotlin.jvm.internal.t.e(y0VarB0, "getCorrespondingProperty(...)");
        return f(y0VarB0);
    }

    public static final boolean b(fe.m mVar) {
        kotlin.jvm.internal.t.f(mVar, "<this>");
        return (mVar instanceof fe.e) && (((fe.e) mVar).y0() instanceof a0);
    }

    public static final boolean c(r0 r0Var) {
        kotlin.jvm.internal.t.f(r0Var, "<this>");
        fe.h hVarB = r0Var.N0().b();
        if (hVarB != null) {
            return b(hVarB);
        }
        return false;
    }

    public static final boolean d(fe.m mVar) {
        kotlin.jvm.internal.t.f(mVar, "<this>");
        return (mVar instanceof fe.e) && (((fe.e) mVar).y0() instanceof i0);
    }

    public static final boolean e(t1 t1Var) {
        a0 a0VarQ;
        kotlin.jvm.internal.t.f(t1Var, "<this>");
        if (t1Var.k0() != null) {
            return false;
        }
        fe.m mVarB = t1Var.b();
        ef.f fVarC = null;
        fe.e eVar = mVarB instanceof fe.e ? (fe.e) mVarB : null;
        if (eVar != null && (a0VarQ = nf.e.q(eVar)) != null) {
            fVarC = a0VarQ.c();
        }
        return kotlin.jvm.internal.t.b(fVarC, t1Var.getName());
    }

    public static final boolean f(t1 t1Var) {
        q1 q1VarY0;
        kotlin.jvm.internal.t.f(t1Var, "<this>");
        if (t1Var.k0() != null) {
            return false;
        }
        fe.m mVarB = t1Var.b();
        fe.e eVar = mVarB instanceof fe.e ? (fe.e) mVarB : null;
        if (eVar == null || (q1VarY0 = eVar.y0()) == null) {
            return false;
        }
        ef.f name = t1Var.getName();
        kotlin.jvm.internal.t.e(name, "getName(...)");
        return q1VarY0.a(name);
    }

    public static final boolean g(fe.m mVar) {
        kotlin.jvm.internal.t.f(mVar, "<this>");
        return b(mVar) || d(mVar);
    }

    public static final boolean h(r0 r0Var) {
        kotlin.jvm.internal.t.f(r0Var, "<this>");
        fe.h hVarB = r0Var.N0().b();
        if (hVarB != null) {
            return g(hVarB);
        }
        return false;
    }

    public static final boolean i(r0 r0Var) {
        kotlin.jvm.internal.t.f(r0Var, "<this>");
        fe.h hVarB = r0Var.N0().b();
        return (hVarB == null || !d(hVarB) || yf.s.f25429a.D0(r0Var)) ? false : true;
    }

    public static final r0 j(r0 r0Var) {
        kotlin.jvm.internal.t.f(r0Var, "<this>");
        r0 r0VarK = k(r0Var);
        if (r0VarK != null) {
            return f2.f(r0Var).p(r0VarK, m2.f25015e);
        }
        return null;
    }

    public static final r0 k(r0 r0Var) {
        a0 a0VarQ;
        kotlin.jvm.internal.t.f(r0Var, "<this>");
        fe.h hVarB = r0Var.N0().b();
        fe.e eVar = hVarB instanceof fe.e ? (fe.e) hVarB : null;
        if (eVar == null || (a0VarQ = nf.e.q(eVar)) == null) {
            return null;
        }
        return (c1) a0VarQ.d();
    }
}
