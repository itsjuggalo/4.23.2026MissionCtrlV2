package I6;

import I6.u0;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2470H;
import o5.C2487o;
import p5.AbstractC2594p;
import p5.AbstractC2595q;

/* JADX INFO: renamed from: I6.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0618g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0618g f4423a = new C0618g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f4424b;

    /* JADX INFO: renamed from: I6.g$a */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4425a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f4426b;

        static {
            int[] iArr = new int[M6.t.values().length];
            try {
                iArr[M6.t.f5440d.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[M6.t.f5439c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[M6.t.f5438b.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f4425a = iArr;
            int[] iArr2 = new int[u0.b.values().length];
            try {
                iArr2[u0.b.f4479a.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[u0.b.f4480b.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[u0.b.f4481c.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            f4426b = iArr2;
        }
    }

    public static final boolean d(M6.p pVar, M6.j jVar) {
        M6.i iVarL;
        M6.j jVarW0;
        return (jVar instanceof M6.d) && (iVarL = pVar.L(pVar.m(pVar.i0((M6.d) jVar)))) != null && (jVarW0 = pVar.w0(iVarL)) != null && pVar.o(jVarW0);
    }

    public static final boolean e(M6.p pVar, M6.j jVar) {
        M6.n nVarA = pVar.a(jVar);
        if (nVarA instanceof M6.h) {
            Collection collectionI = pVar.I(nVarA);
            if (!(collectionI instanceof Collection) || !collectionI.isEmpty()) {
                Iterator it = collectionI.iterator();
                while (it.hasNext()) {
                    M6.j jVarB = pVar.b((M6.i) it.next());
                    if (jVarB != null && pVar.o(jVarB)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final boolean f(M6.p pVar, M6.j jVar) {
        return pVar.o(jVar) || d(pVar, jVar);
    }

    public static final boolean g(M6.p pVar, u0 u0Var, M6.j jVar, M6.j jVar2, boolean z7) {
        Collection<M6.i> collectionV0 = pVar.v0(jVar);
        if ((collectionV0 instanceof Collection) && collectionV0.isEmpty()) {
            return false;
        }
        for (M6.i iVar : collectionV0) {
            if (AbstractC2304t.b(pVar.J(iVar), pVar.a(jVar2)) || (z7 && v(f4423a, u0Var, jVar2, iVar, false, 8, null))) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean v(C0618g c0618g, u0 u0Var, M6.i iVar, M6.i iVar2, boolean z7, int i8, Object obj) {
        if ((i8 & 8) != 0) {
            z7 = false;
        }
        return c0618g.u(u0Var, iVar, iVar2, z7);
    }

    public static final C2470H x(Collection collection, u0 u0Var, M6.p pVar, M6.j jVar, u0.a runForkingPoint) {
        AbstractC2304t.f(runForkingPoint, "$this$runForkingPoint");
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            runForkingPoint.a(new C0616f(u0Var, pVar, (M6.j) it.next(), jVar));
        }
        return C2470H.f21956a;
    }

    public static final boolean y(u0 u0Var, M6.p pVar, M6.j jVar, M6.j jVar2) {
        return f4423a.s(u0Var, pVar.S(jVar), jVar2);
    }

    public final List A(u0 u0Var, List list) {
        int i8;
        M6.p pVarJ = u0Var.j();
        if (list.size() < 2) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            M6.l lVarS = pVarJ.S((M6.j) obj);
            int iC = pVarJ.C(lVarS);
            while (true) {
                if (i8 >= iC) {
                    arrayList.add(obj);
                    break;
                }
                M6.i iVarL = pVarJ.L(pVarJ.p(lVarS, i8));
                i8 = (iVarL != null ? pVarJ.A(iVarL) : null) == null ? i8 + 1 : 0;
            }
        }
        return arrayList.isEmpty() ^ true ? arrayList : list;
    }

    public final Boolean c(u0 u0Var, M6.j jVar, M6.j jVar2) {
        M6.p pVarJ = u0Var.j();
        if (!pVarJ.o(jVar) && !pVarJ.o(jVar2)) {
            return null;
        }
        if (f(pVarJ, jVar) && f(pVarJ, jVar2)) {
            return Boolean.TRUE;
        }
        if (pVarJ.o(jVar)) {
            if (g(pVarJ, u0Var, jVar, jVar2, false)) {
                return Boolean.TRUE;
            }
        } else if (pVarJ.o(jVar2) && (e(pVarJ, jVar) || g(pVarJ, u0Var, jVar2, jVar, true))) {
            return Boolean.TRUE;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Boolean h(I6.u0 r15, M6.j r16, M6.j r17) {
        /*
            Method dump skipped, instruction units count: 365
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: I6.C0618g.h(I6.u0, M6.j, M6.j):java.lang.Boolean");
    }

    public final List i(u0 u0Var, M6.j jVar, M6.n nVar) {
        u0.c cVarL0;
        M6.p pVarJ = u0Var.j();
        List listE = pVarJ.E(jVar, nVar);
        if (listE != null) {
            return listE;
        }
        if (!pVarJ.P(nVar) && pVarJ.E0(jVar)) {
            return AbstractC2595q.i();
        }
        if (pVarJ.j0(nVar)) {
            if (!pVarJ.Q(pVarJ.a(jVar), nVar)) {
                return AbstractC2595q.i();
            }
            M6.j jVarU0 = pVarJ.u0(jVar, M6.b.f5432a);
            if (jVarU0 != null) {
                jVar = jVarU0;
            }
            return AbstractC2594p.e(jVar);
        }
        S6.k kVar = new S6.k();
        u0Var.k();
        ArrayDeque arrayDequeH = u0Var.h();
        AbstractC2304t.c(arrayDequeH);
        Set setI = u0Var.i();
        AbstractC2304t.c(setI);
        arrayDequeH.push(jVar);
        while (!arrayDequeH.isEmpty()) {
            M6.j jVar2 = (M6.j) arrayDequeH.pop();
            AbstractC2304t.c(jVar2);
            if (setI.add(jVar2)) {
                M6.j jVarU02 = pVarJ.u0(jVar2, M6.b.f5432a);
                if (jVarU02 == null) {
                    jVarU02 = jVar2;
                }
                if (pVarJ.Q(pVarJ.a(jVarU02), nVar)) {
                    kVar.add(jVarU02);
                    cVarL0 = u0.c.C0055c.f4485a;
                } else {
                    cVarL0 = pVarJ.F(jVarU02) == 0 ? u0.c.b.f4484a : u0Var.j().l0(jVarU02);
                }
                if (!(!AbstractC2304t.b(cVarL0, u0.c.C0055c.f4485a))) {
                    cVarL0 = null;
                }
                if (cVarL0 != null) {
                    M6.p pVarJ2 = u0Var.j();
                    Iterator it = pVarJ2.I(pVarJ2.a(jVar2)).iterator();
                    while (it.hasNext()) {
                        arrayDequeH.add(cVarL0.a(u0Var, (M6.i) it.next()));
                    }
                }
            }
        }
        u0Var.e();
        return kVar;
    }

    public final List j(u0 u0Var, M6.j jVar, M6.n nVar) {
        return A(u0Var, i(u0Var, jVar, nVar));
    }

    public final boolean k(u0 u0Var, M6.i iVar, M6.i iVar2, boolean z7) {
        M6.p pVarJ = u0Var.j();
        M6.i iVarO = u0Var.o(u0Var.p(iVar));
        M6.i iVarO2 = u0Var.o(u0Var.p(iVar2));
        C0618g c0618g = f4423a;
        Boolean boolH = c0618g.h(u0Var, pVarJ.H0(iVarO), pVarJ.w0(iVarO2));
        if (boolH == null) {
            Boolean boolC = u0Var.c(iVarO, iVarO2, z7);
            return boolC != null ? boolC.booleanValue() : c0618g.w(u0Var, pVarJ.H0(iVarO), pVarJ.w0(iVarO2));
        }
        boolean zBooleanValue = boolH.booleanValue();
        u0Var.c(iVarO, iVarO2, z7);
        return zBooleanValue;
    }

    public final M6.t l(M6.t declared, M6.t useSite) {
        AbstractC2304t.f(declared, "declared");
        AbstractC2304t.f(useSite, "useSite");
        M6.t tVar = M6.t.f5440d;
        if (declared == tVar) {
            return useSite;
        }
        if (useSite == tVar || declared == useSite) {
            return declared;
        }
        return null;
    }

    public final boolean m(u0 state, M6.i a8, M6.i b8) {
        AbstractC2304t.f(state, "state");
        AbstractC2304t.f(a8, "a");
        AbstractC2304t.f(b8, "b");
        M6.p pVarJ = state.j();
        if (a8 == b8) {
            return true;
        }
        C0618g c0618g = f4423a;
        if (c0618g.q(pVarJ, a8) && c0618g.q(pVarJ, b8)) {
            M6.i iVarO = state.o(state.p(a8));
            M6.i iVarO2 = state.o(state.p(b8));
            M6.j jVarH0 = pVarJ.H0(iVarO);
            if (!pVarJ.Q(pVarJ.J(iVarO), pVarJ.J(iVarO2))) {
                return false;
            }
            if (pVarJ.F(jVarH0) == 0) {
                return pVarJ.r(iVarO) || pVarJ.r(iVarO2) || pVarJ.a0(jVarH0) == pVarJ.a0(pVarJ.H0(iVarO2));
            }
        }
        return v(c0618g, state, a8, b8, false, 8, null) && v(c0618g, state, b8, a8, false, 8, null);
    }

    public final List n(u0 state, M6.j subType, M6.n superConstructor) {
        u0.c cVar;
        AbstractC2304t.f(state, "state");
        AbstractC2304t.f(subType, "subType");
        AbstractC2304t.f(superConstructor, "superConstructor");
        M6.p pVarJ = state.j();
        if (pVarJ.E0(subType)) {
            return f4423a.j(state, subType, superConstructor);
        }
        if (!pVarJ.P(superConstructor) && !pVarJ.x(superConstructor)) {
            return f4423a.i(state, subType, superConstructor);
        }
        S6.k<M6.j> kVar = new S6.k();
        state.k();
        ArrayDeque arrayDequeH = state.h();
        AbstractC2304t.c(arrayDequeH);
        Set setI = state.i();
        AbstractC2304t.c(setI);
        arrayDequeH.push(subType);
        while (!arrayDequeH.isEmpty()) {
            M6.j jVar = (M6.j) arrayDequeH.pop();
            AbstractC2304t.c(jVar);
            if (setI.add(jVar)) {
                if (pVarJ.E0(jVar)) {
                    kVar.add(jVar);
                    cVar = u0.c.C0055c.f4485a;
                } else {
                    cVar = u0.c.b.f4484a;
                }
                if (!(!AbstractC2304t.b(cVar, u0.c.C0055c.f4485a))) {
                    cVar = null;
                }
                if (cVar != null) {
                    M6.p pVarJ2 = state.j();
                    Iterator it = pVarJ2.I(pVarJ2.a(jVar)).iterator();
                    while (it.hasNext()) {
                        arrayDequeH.add(cVar.a(state, (M6.i) it.next()));
                    }
                }
            }
        }
        state.e();
        ArrayList arrayList = new ArrayList();
        for (M6.j jVar2 : kVar) {
            C0618g c0618g = f4423a;
            AbstractC2304t.c(jVar2);
            p5.v.x(arrayList, c0618g.j(state, jVar2, superConstructor));
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005b, code lost:
    
        return r8.k(r8.J(r9), r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final M6.o o(M6.p r8, M6.i r9, M6.i r10) {
        /*
            r7 = this;
            int r0 = r8.F(r9)
            r1 = 0
            r2 = r1
        L6:
            r3 = 0
            if (r2 >= r0) goto L5f
            M6.m r4 = r8.B(r9, r2)
            boolean r5 = r8.f(r4)
            r6 = 1
            r5 = r5 ^ r6
            if (r5 == 0) goto L16
            r3 = r4
        L16:
            if (r3 == 0) goto L5c
            M6.i r3 = r8.L(r3)
            if (r3 != 0) goto L1f
            goto L5c
        L1f:
            M6.j r4 = r8.H0(r3)
            boolean r4 = r8.B0(r4)
            if (r4 == 0) goto L34
            M6.j r4 = r8.H0(r10)
            boolean r4 = r8.B0(r4)
            if (r4 == 0) goto L34
            goto L35
        L34:
            r6 = r1
        L35:
            boolean r4 = kotlin.jvm.internal.AbstractC2304t.b(r3, r10)
            if (r4 != 0) goto L53
            if (r6 == 0) goto L4c
            M6.n r4 = r8.J(r3)
            M6.n r5 = r8.J(r10)
            boolean r4 = kotlin.jvm.internal.AbstractC2304t.b(r4, r5)
            if (r4 == 0) goto L4c
            goto L53
        L4c:
            M6.o r3 = r7.o(r8, r3, r10)
            if (r3 == 0) goto L5c
            return r3
        L53:
            M6.n r9 = r8.J(r9)
            M6.o r8 = r8.k(r9, r2)
            return r8
        L5c:
            int r2 = r2 + 1
            goto L6
        L5f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: I6.C0618g.o(M6.p, M6.i, M6.i):M6.o");
    }

    public final boolean p(u0 u0Var, M6.j jVar) {
        M6.p pVarJ = u0Var.j();
        M6.n nVarA = pVarJ.a(jVar);
        if (pVarJ.P(nVarA)) {
            return pVarJ.w(nVarA);
        }
        if (pVarJ.w(pVarJ.a(jVar))) {
            return true;
        }
        u0Var.k();
        ArrayDeque arrayDequeH = u0Var.h();
        AbstractC2304t.c(arrayDequeH);
        Set setI = u0Var.i();
        AbstractC2304t.c(setI);
        arrayDequeH.push(jVar);
        while (!arrayDequeH.isEmpty()) {
            M6.j jVar2 = (M6.j) arrayDequeH.pop();
            AbstractC2304t.c(jVar2);
            if (setI.add(jVar2)) {
                u0.c cVar = pVarJ.E0(jVar2) ? u0.c.C0055c.f4485a : u0.c.b.f4484a;
                if (!(!AbstractC2304t.b(cVar, u0.c.C0055c.f4485a))) {
                    cVar = null;
                }
                if (cVar == null) {
                    continue;
                } else {
                    M6.p pVarJ2 = u0Var.j();
                    Iterator it = pVarJ2.I(pVarJ2.a(jVar2)).iterator();
                    while (it.hasNext()) {
                        M6.j jVarA = cVar.a(u0Var, (M6.i) it.next());
                        if (pVarJ.w(pVarJ.a(jVarA))) {
                            u0Var.e();
                            return true;
                        }
                        arrayDequeH.add(jVarA);
                    }
                }
            }
        }
        u0Var.e();
        return false;
    }

    public final boolean q(M6.p pVar, M6.i iVar) {
        return (!pVar.m0(pVar.J(iVar)) || pVar.D0(iVar) || pVar.n(iVar) || pVar.V(iVar) || pVar.i(iVar)) ? false : true;
    }

    public final boolean r(M6.p pVar, M6.j jVar, M6.j jVar2) {
        if (pVar.a(jVar) != pVar.a(jVar2)) {
            return false;
        }
        if (pVar.R(jVar) || !pVar.R(jVar2)) {
            return !pVar.a0(jVar) || pVar.a0(jVar2);
        }
        return false;
    }

    public final boolean s(u0 u0Var, M6.l capturedSubArguments, M6.j superType) {
        boolean zM;
        int i8;
        Object obj;
        boolean z7;
        C0618g c0618g;
        u0 u0Var2;
        M6.i iVar;
        AbstractC2304t.f(u0Var, "<this>");
        AbstractC2304t.f(capturedSubArguments, "capturedSubArguments");
        AbstractC2304t.f(superType, "superType");
        M6.p pVarJ = u0Var.j();
        M6.n nVarA = pVarJ.a(superType);
        int iC = pVarJ.C(capturedSubArguments);
        int iM = pVarJ.M(nVarA);
        if (iC != iM || iC != pVarJ.F(superType)) {
            return false;
        }
        for (int i9 = 0; i9 < iM; i9++) {
            M6.m mVarB = pVarJ.B(superType, i9);
            M6.i iVarL = pVarJ.L(mVarB);
            if (iVarL != null) {
                M6.m mVarP = pVarJ.p(capturedSubArguments, i9);
                pVarJ.T(mVarP);
                M6.t tVar = M6.t.f5440d;
                M6.i iVarL2 = pVarJ.L(mVarP);
                AbstractC2304t.c(iVarL2);
                C0618g c0618g2 = f4423a;
                M6.t tVarL = c0618g2.l(pVarJ.Z(pVarJ.k(nVarA, i9)), pVarJ.T(mVarB));
                if (tVarL == null) {
                    return u0Var.m();
                }
                if (tVarL != tVar || (!c0618g2.z(pVarJ, iVarL2, iVarL, nVarA) && !c0618g2.z(pVarJ, iVarL, iVarL2, nVarA))) {
                    if (u0Var.f4474g > 100) {
                        throw new IllegalStateException(("Arguments depth is too high. Some related argument: " + iVarL2).toString());
                    }
                    u0Var.f4474g++;
                    int i10 = a.f4425a[tVarL.ordinal()];
                    if (i10 != 1) {
                        if (i10 == 2) {
                            i8 = 8;
                            obj = null;
                            z7 = false;
                            c0618g = c0618g2;
                            u0Var2 = u0Var;
                            iVar = iVarL2;
                        } else {
                            if (i10 != 3) {
                                throw new C2487o();
                            }
                            i8 = 8;
                            obj = null;
                            z7 = false;
                            c0618g = c0618g2;
                            u0Var2 = u0Var;
                            iVar = iVarL;
                            iVarL = iVarL2;
                        }
                        zM = v(c0618g, u0Var2, iVar, iVarL, z7, i8, obj);
                    } else {
                        zM = c0618g2.m(u0Var, iVarL2, iVarL);
                    }
                    u0Var.f4474g--;
                    if (!zM) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public final boolean t(u0 state, M6.i subType, M6.i superType) {
        AbstractC2304t.f(state, "state");
        AbstractC2304t.f(subType, "subType");
        AbstractC2304t.f(superType, "superType");
        return v(this, state, subType, superType, false, 8, null);
    }

    public final boolean u(u0 state, M6.i subType, M6.i superType, boolean z7) {
        AbstractC2304t.f(state, "state");
        AbstractC2304t.f(subType, "subType");
        AbstractC2304t.f(superType, "superType");
        if (subType == superType) {
            return true;
        }
        if (state.f(subType, superType)) {
            return k(state, subType, superType, z7);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean w(I6.u0 r18, M6.j r19, M6.j r20) {
        /*
            Method dump skipped, instruction units count: 434
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: I6.C0618g.w(I6.u0, M6.j, M6.j):boolean");
    }

    public final boolean z(M6.p pVar, M6.i iVar, M6.i iVar2, M6.n nVar) {
        M6.j jVarB = pVar.b(iVar);
        if (jVarB instanceof M6.d) {
            M6.d dVar = (M6.d) jVarB;
            if (pVar.b0(dVar) || !pVar.f(pVar.m(pVar.i0(dVar))) || pVar.q0(dVar) != M6.b.f5432a) {
                return false;
            }
            pVar.J(iVar2);
        }
        return false;
    }
}
