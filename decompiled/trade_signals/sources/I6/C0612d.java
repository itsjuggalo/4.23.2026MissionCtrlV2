package I6;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: I6.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0612d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0612d f4408a = new C0612d();

    public final boolean a(M6.p pVar, M6.j jVar, M6.j jVar2) {
        if (pVar.F(jVar) != pVar.F(jVar2) || pVar.a0(jVar) != pVar.a0(jVar2) || pVar.R(jVar) != pVar.R(jVar2) || !pVar.Q(pVar.a(jVar), pVar.a(jVar2))) {
            return false;
        }
        if (pVar.u(jVar, jVar2)) {
            return true;
        }
        int iF = pVar.F(jVar);
        for (int i8 = 0; i8 < iF; i8++) {
            M6.m mVarB = pVar.B(jVar, i8);
            M6.m mVarB2 = pVar.B(jVar2, i8);
            if (pVar.f(mVarB) != pVar.f(mVarB2)) {
                return false;
            }
            if (!pVar.f(mVarB)) {
                if (pVar.T(mVarB) != pVar.T(mVarB2)) {
                    return false;
                }
                M6.i iVarL = pVar.L(mVarB);
                AbstractC2304t.c(iVarL);
                M6.i iVarL2 = pVar.L(mVarB2);
                AbstractC2304t.c(iVarL2);
                if (!c(pVar, iVarL, iVarL2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean b(M6.p context, M6.i a8, M6.i b8) {
        AbstractC2304t.f(context, "context");
        AbstractC2304t.f(a8, "a");
        AbstractC2304t.f(b8, "b");
        return c(context, a8, b8);
    }

    public final boolean c(M6.p pVar, M6.i iVar, M6.i iVar2) {
        if (iVar == iVar2) {
            return true;
        }
        M6.j jVarB = pVar.b(iVar);
        M6.j jVarB2 = pVar.b(iVar2);
        if (jVarB != null && jVarB2 != null) {
            return a(pVar, jVarB, jVarB2);
        }
        M6.g gVarA = pVar.A(iVar);
        M6.g gVarA2 = pVar.A(iVar2);
        if (gVarA == null || gVarA2 == null) {
            return false;
        }
        return a(pVar, pVar.d(gVarA), pVar.d(gVarA2)) && a(pVar, pVar.c(gVarA), pVar.c(gVarA2));
    }
}
