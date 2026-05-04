package xf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f24939a = new d();

    public final boolean a(bg.p pVar, bg.j jVar, bg.j jVar2) {
        if (pVar.y0(jVar) != pVar.y0(jVar2) || pVar.n(jVar) != pVar.n(jVar2) || pVar.p(jVar) != pVar.p(jVar2) || !pVar.K(pVar.f(jVar), pVar.f(jVar2))) {
            return false;
        }
        if (pVar.u(jVar, jVar2)) {
            return true;
        }
        int iY0 = pVar.y0(jVar);
        for (int i10 = 0; i10 < iY0; i10++) {
            bg.m mVarS = pVar.S(jVar, i10);
            bg.m mVarS2 = pVar.S(jVar2, i10);
            if (pVar.c(mVarS) != pVar.c(mVarS2)) {
                return false;
            }
            if (!pVar.c(mVarS)) {
                if (pVar.T(mVarS) != pVar.T(mVarS2)) {
                    return false;
                }
                bg.i iVarH = pVar.H(mVarS);
                kotlin.jvm.internal.t.c(iVarH);
                bg.i iVarH2 = pVar.H(mVarS2);
                kotlin.jvm.internal.t.c(iVarH2);
                if (!c(pVar, iVarH, iVarH2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean b(bg.p context, bg.i a10, bg.i b10) {
        kotlin.jvm.internal.t.f(context, "context");
        kotlin.jvm.internal.t.f(a10, "a");
        kotlin.jvm.internal.t.f(b10, "b");
        return c(context, a10, b10);
    }

    public final boolean c(bg.p pVar, bg.i iVar, bg.i iVar2) {
        if (iVar == iVar2) {
            return true;
        }
        bg.j jVarH = pVar.h(iVar);
        bg.j jVarH2 = pVar.h(iVar2);
        if (jVarH != null && jVarH2 != null) {
            return a(pVar, jVarH, jVarH2);
        }
        bg.g gVarK0 = pVar.k0(iVar);
        bg.g gVarK02 = pVar.k0(iVar2);
        return gVarK0 != null && gVarK02 != null && a(pVar, pVar.d(gVarK0), pVar.d(gVarK02)) && a(pVar, pVar.e(gVarK0), pVar.e(gVarK02));
    }
}
