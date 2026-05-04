package xf;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import xf.t1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f24969a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f24970b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f24972b;

        static {
            int[] iArr = new int[bg.t.values().length];
            try {
                iArr[bg.t.f3359d.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[bg.t.f3358c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[bg.t.f3357b.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f24971a = iArr;
            int[] iArr2 = new int[t1.b.values().length];
            try {
                iArr2[t1.b.f25068a.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[t1.b.f25069b.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[t1.b.f25070c.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            f24972b = iArr2;
        }
    }

    public static final boolean d(bg.p pVar, bg.j jVar) {
        bg.i iVarH;
        bg.j jVarZ0;
        return (jVar instanceof bg.d) && (iVarH = pVar.H(pVar.q0(pVar.x((bg.d) jVar)))) != null && (jVarZ0 = pVar.z0(iVarH)) != null && pVar.I(jVarZ0);
    }

    public static final boolean e(bg.p pVar, bg.j jVar) {
        bg.n nVarF = pVar.f(jVar);
        if (!(nVarF instanceof bg.h)) {
            return false;
        }
        Collection collectionA0 = pVar.a0(nVarF);
        if (collectionA0 != null && collectionA0.isEmpty()) {
            return false;
        }
        Iterator it = collectionA0.iterator();
        while (it.hasNext()) {
            bg.j jVarH = pVar.h((bg.i) it.next());
            if (jVarH != null && pVar.I(jVarH)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean f(bg.p pVar, bg.j jVar) {
        return pVar.I(jVar) || d(pVar, jVar);
    }

    public static final boolean g(bg.p pVar, t1 t1Var, bg.j jVar, bg.j jVar2, boolean z10) {
        t1 t1Var2;
        bg.j jVar3;
        Collection<bg.i> collectionZ = pVar.Z(jVar);
        if (collectionZ != null && collectionZ.isEmpty()) {
            return false;
        }
        for (bg.i iVar : collectionZ) {
            if (kotlin.jvm.internal.t.b(pVar.B(iVar), pVar.f(jVar2))) {
                return true;
            }
            if (z10) {
                t1Var2 = t1Var;
                jVar3 = jVar2;
                if (v(f24969a, t1Var2, jVar3, iVar, false, 8, null)) {
                    return true;
                }
            } else {
                t1Var2 = t1Var;
                jVar3 = jVar2;
            }
            t1Var = t1Var2;
            jVar2 = jVar3;
        }
        return false;
    }

    public static /* synthetic */ boolean v(g gVar, t1 t1Var, bg.i iVar, bg.i iVar2, boolean z10, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        return gVar.u(t1Var, iVar, iVar2, z10);
    }

    public static final cd.h0 x(Collection collection, t1 t1Var, bg.p pVar, bg.j jVar, t1.a runForkingPoint) {
        kotlin.jvm.internal.t.f(runForkingPoint, "$this$runForkingPoint");
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            runForkingPoint.a(new f(t1Var, pVar, (bg.j) it.next(), jVar));
        }
        return cd.h0.f3852a;
    }

    public static final boolean y(t1 t1Var, bg.p pVar, bg.j jVar, bg.j jVar2) {
        return f24969a.s(t1Var, pVar.I0(jVar), jVar2);
    }

    public final List A(t1 t1Var, List list) {
        int i10;
        bg.p pVarJ = t1Var.j();
        if (list.size() >= 2) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                bg.l lVarI0 = pVarJ.I0((bg.j) obj);
                int iV = pVarJ.v(lVarI0);
                while (true) {
                    if (i10 >= iV) {
                        arrayList.add(obj);
                        break;
                    }
                    bg.i iVarH = pVarJ.H(pVarJ.G(lVarI0, i10));
                    i10 = (iVarH != null ? pVarJ.k0(iVarH) : null) == null ? i10 + 1 : 0;
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
        }
        return list;
    }

    public final Boolean c(t1 t1Var, bg.j jVar, bg.j jVar2) {
        bg.p pVarJ = t1Var.j();
        if (!pVarJ.I(jVar) && !pVarJ.I(jVar2)) {
            return null;
        }
        if (f(pVarJ, jVar) && f(pVarJ, jVar2)) {
            return Boolean.TRUE;
        }
        if (pVarJ.I(jVar)) {
            if (g(pVarJ, t1Var, jVar, jVar2, false)) {
                return Boolean.TRUE;
            }
        } else if (pVarJ.I(jVar2) && (e(pVarJ, jVar) || g(pVarJ, t1Var, jVar2, jVar, true))) {
            return Boolean.TRUE;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Boolean h(xf.t1 r13, bg.j r14, bg.j r15) {
        /*
            Method dump skipped, instruction units count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: xf.g.h(xf.t1, bg.j, bg.j):java.lang.Boolean");
    }

    public final List i(t1 t1Var, bg.j jVar, bg.n nVar) {
        t1.c cVarF;
        bg.p pVarJ = t1Var.j();
        List listL0 = pVarJ.l0(jVar, nVar);
        if (listL0 != null) {
            return listL0;
        }
        if (!pVarJ.C0(nVar) && pVarJ.A(jVar)) {
            return dd.r.k();
        }
        if (pVarJ.g0(nVar)) {
            if (!pVarJ.K(pVarJ.f(jVar), nVar)) {
                return dd.r.k();
            }
            bg.j jVarK = pVarJ.k(jVar, bg.b.f3351a);
            if (jVarK != null) {
                jVar = jVarK;
            }
            return dd.q.e(jVar);
        }
        hg.k kVar = new hg.k();
        t1Var.k();
        ArrayDeque arrayDequeH = t1Var.h();
        kotlin.jvm.internal.t.c(arrayDequeH);
        Set setI = t1Var.i();
        kotlin.jvm.internal.t.c(setI);
        arrayDequeH.push(jVar);
        while (!arrayDequeH.isEmpty()) {
            bg.j jVar2 = (bg.j) arrayDequeH.pop();
            kotlin.jvm.internal.t.c(jVar2);
            if (setI.add(jVar2)) {
                bg.j jVarK2 = pVarJ.k(jVar2, bg.b.f3351a);
                if (jVarK2 == null) {
                    jVarK2 = jVar2;
                }
                if (pVarJ.K(pVarJ.f(jVarK2), nVar)) {
                    kVar.add(jVarK2);
                    cVarF = t1.c.C0460c.f25074a;
                } else {
                    cVarF = pVarJ.y0(jVarK2) == 0 ? t1.c.b.f25073a : t1Var.j().F(jVarK2);
                }
                if (kotlin.jvm.internal.t.b(cVarF, t1.c.C0460c.f25074a)) {
                    cVarF = null;
                }
                if (cVarF != null) {
                    bg.p pVarJ2 = t1Var.j();
                    Iterator it = pVarJ2.a0(pVarJ2.f(jVar2)).iterator();
                    while (it.hasNext()) {
                        arrayDequeH.add(cVarF.a(t1Var, (bg.i) it.next()));
                    }
                }
            }
        }
        t1Var.e();
        return kVar;
    }

    public final List j(t1 t1Var, bg.j jVar, bg.n nVar) {
        return A(t1Var, i(t1Var, jVar, nVar));
    }

    public final boolean k(t1 t1Var, bg.i iVar, bg.i iVar2, boolean z10) {
        bg.p pVarJ = t1Var.j();
        bg.i iVarO = t1Var.o(t1Var.p(iVar));
        bg.i iVarO2 = t1Var.o(t1Var.p(iVar2));
        g gVar = f24969a;
        Boolean boolH = gVar.h(t1Var, pVarJ.m(iVarO), pVarJ.z0(iVarO2));
        if (boolH == null) {
            Boolean boolC = t1Var.c(iVarO, iVarO2, z10);
            return boolC != null ? boolC.booleanValue() : gVar.w(t1Var, pVarJ.m(iVarO), pVarJ.z0(iVarO2));
        }
        boolean zBooleanValue = boolH.booleanValue();
        t1Var.c(iVarO, iVarO2, z10);
        return zBooleanValue;
    }

    public final bg.t l(bg.t declared, bg.t useSite) {
        kotlin.jvm.internal.t.f(declared, "declared");
        kotlin.jvm.internal.t.f(useSite, "useSite");
        bg.t tVar = bg.t.f3359d;
        if (declared == tVar) {
            return useSite;
        }
        if (useSite == tVar || declared == useSite) {
            return declared;
        }
        return null;
    }

    public final boolean m(t1 state, bg.i a10, bg.i b10) {
        kotlin.jvm.internal.t.f(state, "state");
        kotlin.jvm.internal.t.f(a10, "a");
        kotlin.jvm.internal.t.f(b10, "b");
        bg.p pVarJ = state.j();
        if (a10 == b10) {
            return true;
        }
        g gVar = f24969a;
        if (gVar.q(pVarJ, a10) && gVar.q(pVarJ, b10)) {
            bg.i iVarO = state.o(state.p(a10));
            bg.i iVarO2 = state.o(state.p(b10));
            bg.j jVarM = pVarJ.m(iVarO);
            if (!pVarJ.K(pVarJ.B(iVarO), pVarJ.B(iVarO2))) {
                return false;
            }
            if (pVarJ.y0(jVarM) == 0) {
                return pVarJ.b0(iVarO) || pVarJ.b0(iVarO2) || pVarJ.n(jVarM) == pVarJ.n(pVarJ.m(iVarO2));
            }
        }
        return v(gVar, state, a10, b10, false, 8, null) && v(gVar, state, b10, a10, false, 8, null);
    }

    public final List n(t1 state, bg.j subType, bg.n superConstructor) {
        t1.c cVar;
        kotlin.jvm.internal.t.f(state, "state");
        kotlin.jvm.internal.t.f(subType, "subType");
        kotlin.jvm.internal.t.f(superConstructor, "superConstructor");
        bg.p pVarJ = state.j();
        if (pVarJ.A(subType)) {
            return f24969a.j(state, subType, superConstructor);
        }
        if (!pVarJ.C0(superConstructor) && !pVarJ.o0(superConstructor)) {
            return f24969a.i(state, subType, superConstructor);
        }
        hg.k<bg.j> kVar = new hg.k();
        state.k();
        ArrayDeque arrayDequeH = state.h();
        kotlin.jvm.internal.t.c(arrayDequeH);
        Set setI = state.i();
        kotlin.jvm.internal.t.c(setI);
        arrayDequeH.push(subType);
        while (!arrayDequeH.isEmpty()) {
            bg.j jVar = (bg.j) arrayDequeH.pop();
            kotlin.jvm.internal.t.c(jVar);
            if (setI.add(jVar)) {
                if (pVarJ.A(jVar)) {
                    kVar.add(jVar);
                    cVar = t1.c.C0460c.f25074a;
                } else {
                    cVar = t1.c.b.f25073a;
                }
                if (kotlin.jvm.internal.t.b(cVar, t1.c.C0460c.f25074a)) {
                    cVar = null;
                }
                if (cVar != null) {
                    bg.p pVarJ2 = state.j();
                    Iterator it = pVarJ2.a0(pVarJ2.f(jVar)).iterator();
                    while (it.hasNext()) {
                        arrayDequeH.add(cVar.a(state, (bg.i) it.next()));
                    }
                }
            }
        }
        state.e();
        ArrayList arrayList = new ArrayList();
        for (bg.j jVar2 : kVar) {
            g gVar = f24969a;
            kotlin.jvm.internal.t.c(jVar2);
            dd.w.z(arrayList, gVar.j(state, jVar2, superConstructor));
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005a, code lost:
    
        return r7.E(r7.B(r8), r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final bg.o o(bg.p r7, bg.i r8, bg.i r9) {
        /*
            r6 = this;
            int r0 = r7.y0(r8)
            r1 = 0
            r2 = r1
        L6:
            r3 = 0
            if (r2 >= r0) goto L5e
            bg.m r4 = r7.S(r8, r2)
            boolean r5 = r7.c(r4)
            if (r5 != 0) goto L14
            r3 = r4
        L14:
            if (r3 == 0) goto L5b
            bg.i r3 = r7.H(r3)
            if (r3 != 0) goto L1d
            goto L5b
        L1d:
            bg.j r4 = r7.m(r3)
            boolean r4 = r7.o(r4)
            if (r4 == 0) goto L33
            bg.j r4 = r7.m(r9)
            boolean r4 = r7.o(r4)
            if (r4 == 0) goto L33
            r4 = 1
            goto L34
        L33:
            r4 = r1
        L34:
            boolean r5 = kotlin.jvm.internal.t.b(r3, r9)
            if (r5 != 0) goto L52
            if (r4 == 0) goto L4b
            bg.n r4 = r7.B(r3)
            bg.n r5 = r7.B(r9)
            boolean r4 = kotlin.jvm.internal.t.b(r4, r5)
            if (r4 == 0) goto L4b
            goto L52
        L4b:
            bg.o r3 = r6.o(r7, r3, r9)
            if (r3 == 0) goto L5b
            return r3
        L52:
            bg.n r8 = r7.B(r8)
            bg.o r7 = r7.E(r8, r2)
            return r7
        L5b:
            int r2 = r2 + 1
            goto L6
        L5e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: xf.g.o(bg.p, bg.i, bg.i):bg.o");
    }

    public final boolean p(t1 t1Var, bg.j jVar) {
        bg.p pVarJ = t1Var.j();
        bg.n nVarF = pVarJ.f(jVar);
        if (pVarJ.C0(nVarF)) {
            return pVarJ.n0(nVarF);
        }
        if (pVarJ.n0(pVarJ.f(jVar))) {
            return true;
        }
        t1Var.k();
        ArrayDeque arrayDequeH = t1Var.h();
        kotlin.jvm.internal.t.c(arrayDequeH);
        Set setI = t1Var.i();
        kotlin.jvm.internal.t.c(setI);
        arrayDequeH.push(jVar);
        while (!arrayDequeH.isEmpty()) {
            bg.j jVar2 = (bg.j) arrayDequeH.pop();
            kotlin.jvm.internal.t.c(jVar2);
            if (setI.add(jVar2)) {
                t1.c cVar = pVarJ.A(jVar2) ? t1.c.C0460c.f25074a : t1.c.b.f25073a;
                if (kotlin.jvm.internal.t.b(cVar, t1.c.C0460c.f25074a)) {
                    cVar = null;
                }
                if (cVar == null) {
                    continue;
                } else {
                    bg.p pVarJ2 = t1Var.j();
                    Iterator it = pVarJ2.a0(pVarJ2.f(jVar2)).iterator();
                    while (it.hasNext()) {
                        bg.j jVarA = cVar.a(t1Var, (bg.i) it.next());
                        if (pVarJ.n0(pVarJ.f(jVarA))) {
                            t1Var.e();
                            return true;
                        }
                        arrayDequeH.add(jVarA);
                    }
                }
            }
        }
        t1Var.e();
        return false;
    }

    public final boolean q(bg.p pVar, bg.i iVar) {
        return (!pVar.e0(pVar.B(iVar)) || pVar.D(iVar) || pVar.Y(iVar) || pVar.l(iVar) || pVar.f0(iVar)) ? false : true;
    }

    public final boolean r(bg.p pVar, bg.j jVar, bg.j jVar2) {
        if (pVar.f(jVar) != pVar.f(jVar2)) {
            return false;
        }
        if (pVar.p(jVar) || !pVar.p(jVar2)) {
            return !pVar.n(jVar) || pVar.n(jVar2);
        }
        return false;
    }

    public final boolean s(t1 t1Var, bg.l capturedSubArguments, bg.j superType) {
        boolean zM;
        t1 t1Var2 = t1Var;
        kotlin.jvm.internal.t.f(t1Var2, "<this>");
        kotlin.jvm.internal.t.f(capturedSubArguments, "capturedSubArguments");
        kotlin.jvm.internal.t.f(superType, "superType");
        bg.p pVarJ = t1Var2.j();
        bg.n nVarF = pVarJ.f(superType);
        int iV = pVarJ.v(capturedSubArguments);
        int iL = pVarJ.L(nVarF);
        if (iV != iL || iV != pVarJ.y0(superType)) {
            return false;
        }
        for (int i10 = 0; i10 < iL; i10++) {
            bg.m mVarS = pVarJ.S(superType, i10);
            bg.i iVarH = pVarJ.H(mVarS);
            if (iVarH != null) {
                bg.m mVarG = pVarJ.G(capturedSubArguments, i10);
                pVarJ.T(mVarG);
                bg.t tVar = bg.t.f3359d;
                bg.i iVarH2 = pVarJ.H(mVarG);
                kotlin.jvm.internal.t.c(iVarH2);
                g gVar = f24969a;
                bg.t tVarL = gVar.l(pVarJ.A0(pVarJ.E(nVarF, i10)), pVarJ.T(mVarS));
                if (tVarL == null) {
                    return t1Var2.m();
                }
                if (tVarL != tVar || (!gVar.z(pVarJ, iVarH2, iVarH, nVarF) && !gVar.z(pVarJ, iVarH, iVarH2, nVarF))) {
                    if (t1Var2.f25063g > 100) {
                        throw new IllegalStateException(("Arguments depth is too high. Some related argument: " + iVarH2).toString());
                    }
                    t1Var2.f25063g++;
                    int i11 = a.f24971a[tVarL.ordinal()];
                    if (i11 == 1) {
                        zM = gVar.m(t1Var2, iVarH2, iVarH);
                    } else if (i11 == 2) {
                        t1Var2 = t1Var;
                        zM = v(gVar, t1Var2, iVarH2, iVarH, false, 8, null);
                    } else {
                        if (i11 != 3) {
                            throw new cd.o();
                        }
                        zM = v(gVar, t1Var2, iVarH, iVarH2, false, 8, null);
                        t1Var2 = t1Var;
                    }
                    t1Var2.f25063g--;
                    if (!zM) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public final boolean t(t1 state, bg.i subType, bg.i superType) {
        kotlin.jvm.internal.t.f(state, "state");
        kotlin.jvm.internal.t.f(subType, "subType");
        kotlin.jvm.internal.t.f(superType, "superType");
        return v(this, state, subType, superType, false, 8, null);
    }

    public final boolean u(t1 state, bg.i subType, bg.i superType, boolean z10) {
        kotlin.jvm.internal.t.f(state, "state");
        kotlin.jvm.internal.t.f(subType, "subType");
        kotlin.jvm.internal.t.f(superType, "superType");
        if (subType == superType) {
            return true;
        }
        if (state.f(subType, superType)) {
            return k(state, subType, superType, z10);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean w(xf.t1 r18, bg.j r19, bg.j r20) {
        /*
            Method dump skipped, instruction units count: 438
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: xf.g.w(xf.t1, bg.j, bg.j):boolean");
    }

    public final boolean z(bg.p pVar, bg.i iVar, bg.i iVar2, bg.n nVar) {
        bg.j jVarH = pVar.h(iVar);
        if (jVarH instanceof bg.d) {
            bg.d dVar = (bg.d) jVarH;
            if (pVar.M(dVar) || !pVar.c(pVar.q0(pVar.x(dVar))) || pVar.s(dVar) != bg.b.f3351a) {
                return false;
            }
            pVar.B(iVar2);
        }
        return false;
    }
}
