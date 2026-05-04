package jf;

import dd.a0;
import fe.b;
import fe.d0;
import fe.g1;
import fe.l1;
import fe.n0;
import java.util.Collection;
import jf.o;
import xf.u1;
import yf.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f14323a = new g();

    public static /* synthetic */ boolean f(g gVar, fe.a aVar, fe.a aVar2, boolean z10, boolean z11, boolean z12, yf.g gVar2, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z11 = true;
        }
        boolean z13 = z11;
        if ((i10 & 16) != 0) {
            z12 = false;
        }
        return gVar.e(aVar, aVar2, z10, z13, z12, gVar2);
    }

    public static final boolean g(fe.m mVar, fe.m mVar2) {
        return false;
    }

    public static final boolean h(boolean z10, fe.a aVar, fe.a aVar2, u1 c12, u1 c22) {
        kotlin.jvm.internal.t.f(c12, "c1");
        kotlin.jvm.internal.t.f(c22, "c2");
        if (kotlin.jvm.internal.t.b(c12, c22)) {
            return true;
        }
        fe.h hVarB = c12.b();
        fe.h hVarB2 = c22.b();
        if ((hVarB instanceof l1) && (hVarB2 instanceof l1)) {
            return f14323a.n((l1) hVarB, (l1) hVarB2, z10, new f(aVar, aVar2));
        }
        return false;
    }

    public static final boolean i(fe.a aVar, fe.a aVar2, fe.m mVar, fe.m mVar2) {
        return kotlin.jvm.internal.t.b(mVar, aVar) && kotlin.jvm.internal.t.b(mVar2, aVar2);
    }

    public static /* synthetic */ boolean l(g gVar, fe.m mVar, fe.m mVar2, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z11 = true;
        }
        return gVar.k(mVar, mVar2, z10, z11);
    }

    public static /* synthetic */ boolean o(g gVar, l1 l1Var, l1 l1Var2, boolean z10, pd.o oVar, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            oVar = c.f14316a;
        }
        return gVar.n(l1Var, l1Var2, z10, oVar);
    }

    public static final boolean p(fe.m mVar, fe.m mVar2) {
        return false;
    }

    public final boolean e(fe.a a10, fe.a b10, boolean z10, boolean z11, boolean z12, yf.g kotlinTypeRefiner) {
        kotlin.jvm.internal.t.f(a10, "a");
        kotlin.jvm.internal.t.f(b10, "b");
        kotlin.jvm.internal.t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        if (kotlin.jvm.internal.t.b(a10, b10)) {
            return true;
        }
        if (!kotlin.jvm.internal.t.b(a10.getName(), b10.getName())) {
            return false;
        }
        if (z11 && (a10 instanceof d0) && (b10 instanceof d0) && ((d0) a10).N() != ((d0) b10).N()) {
            return false;
        }
        if ((kotlin.jvm.internal.t.b(a10.b(), b10.b()) && (!z10 || !kotlin.jvm.internal.t.b(r(a10), r(b10)))) || i.E(a10) || i.E(b10) || !q(a10, b10, d.f14317a, z10)) {
            return false;
        }
        o oVarI = o.i(kotlinTypeRefiner, new e(z10, a10, b10));
        kotlin.jvm.internal.t.e(oVarI, "create(...)");
        o.i.a aVarC = oVarI.E(a10, b10, null, !z12).c();
        o.i.a aVar = o.i.a.OVERRIDABLE;
        return aVarC == aVar && oVarI.E(b10, a10, null, z12 ^ true).c() == aVar;
    }

    public final boolean j(fe.e eVar, fe.e eVar2) {
        return kotlin.jvm.internal.t.b(eVar.k(), eVar2.k());
    }

    public final boolean k(fe.m mVar, fe.m mVar2, boolean z10, boolean z11) {
        return ((mVar instanceof fe.e) && (mVar2 instanceof fe.e)) ? j((fe.e) mVar, (fe.e) mVar2) : ((mVar instanceof l1) && (mVar2 instanceof l1)) ? o(this, (l1) mVar, (l1) mVar2, z10, null, 8, null) : ((mVar instanceof fe.a) && (mVar2 instanceof fe.a)) ? f(this, (fe.a) mVar, (fe.a) mVar2, z10, z11, false, g.a.f25404a, 16, null) : ((mVar instanceof n0) && (mVar2 instanceof n0)) ? kotlin.jvm.internal.t.b(((n0) mVar).e(), ((n0) mVar2).e()) : kotlin.jvm.internal.t.b(mVar, mVar2);
    }

    public final boolean m(l1 a10, l1 b10, boolean z10) {
        kotlin.jvm.internal.t.f(a10, "a");
        kotlin.jvm.internal.t.f(b10, "b");
        return o(this, a10, b10, z10, null, 8, null);
    }

    public final boolean n(l1 a10, l1 b10, boolean z10, pd.o equivalentCallables) {
        kotlin.jvm.internal.t.f(a10, "a");
        kotlin.jvm.internal.t.f(b10, "b");
        kotlin.jvm.internal.t.f(equivalentCallables, "equivalentCallables");
        if (kotlin.jvm.internal.t.b(a10, b10)) {
            return true;
        }
        return !kotlin.jvm.internal.t.b(a10.b(), b10.b()) && q(a10, b10, equivalentCallables, z10) && a10.getIndex() == b10.getIndex();
    }

    public final boolean q(fe.m mVar, fe.m mVar2, pd.o oVar, boolean z10) {
        fe.m mVarB = mVar.b();
        fe.m mVarB2 = mVar2.b();
        return ((mVarB instanceof fe.b) || (mVarB2 instanceof fe.b)) ? ((Boolean) oVar.invoke(mVarB, mVarB2)).booleanValue() : l(this, mVarB, mVarB2, z10, false, 8, null);
    }

    public final g1 r(fe.a aVar) {
        while (aVar instanceof fe.b) {
            fe.b bVar = (fe.b) aVar;
            if (bVar.h() != b.a.FAKE_OVERRIDE) {
                break;
            }
            Collection collectionF = bVar.f();
            kotlin.jvm.internal.t.e(collectionF, "getOverriddenDescriptors(...)");
            aVar = (fe.b) a0.w0(collectionF);
            if (aVar == null) {
                return null;
            }
        }
        return aVar.j();
    }
}
