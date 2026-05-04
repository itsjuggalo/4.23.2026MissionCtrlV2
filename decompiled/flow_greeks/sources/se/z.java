package se;

import fe.f1;
import fe.s1;
import fe.z;
import hg.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jf.o;
import oe.t0;
import oe.u;
import pe.o;
import se.t0;
import we.l1;
import xf.h2;
import xf.i2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class z extends t0 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final fe.e f20346n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ve.g f20347o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f20348p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final wf.i f20349q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final wf.i f20350r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final wf.i f20351s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final wf.i f20352t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final wf.h f20353u;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a extends kotlin.jvm.internal.q implements pd.k {
        public a(Object obj) {
            super(1, obj, z.class, "searchMethodsByNameWithoutBuiltinMagic", "searchMethodsByNameWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;", 0);
        }

        @Override // pd.k
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public final Collection invoke(ef.f p02) {
            kotlin.jvm.internal.t.f(p02, "p0");
            return ((z) this.receiver).q1(p02);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class b extends kotlin.jvm.internal.q implements pd.k {
        public b(Object obj) {
            super(1, obj, z.class, "searchMethodsInSupertypesWithoutBuiltinMagic", "searchMethodsInSupertypesWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;", 0);
        }

        @Override // pd.k
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public final Collection invoke(ef.f p02) {
            kotlin.jvm.internal.t.f(p02, "p0");
            return ((z) this.receiver).r1(p02);
        }
    }

    public /* synthetic */ z(re.k kVar, fe.e eVar, ve.g gVar, boolean z10, z zVar, int i10, kotlin.jvm.internal.k kVar2) {
        this(kVar, eVar, gVar, z10, (i10 & 16) != 0 ? null : zVar);
    }

    public static final Collection A0(z zVar, ef.f it) {
        kotlin.jvm.internal.t.f(it, "it");
        return zVar.q1(it);
    }

    public static final Collection B0(z zVar, ef.f it) {
        kotlin.jvm.internal.t.f(it, "it");
        return zVar.r1(it);
    }

    public static final List D0(z zVar, re.k kVar) {
        Collection collectionM = zVar.f20347o.m();
        ArrayList arrayList = new ArrayList(collectionM.size());
        Iterator it = collectionM.iterator();
        while (it.hasNext()) {
            arrayList.add(zVar.o1((ve.k) it.next()));
        }
        if (zVar.f20347o.s()) {
            fe.d dVarG0 = zVar.G0();
            String strC = xe.c0.c(dVarG0, false, false, 2, null);
            if (arrayList.isEmpty()) {
                arrayList.add(dVarG0);
                kVar.a().h().a(zVar.f20347o, dVarG0);
            } else {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    if (kotlin.jvm.internal.t.b(xe.c0.c((fe.d) it2.next(), false, false, 2, null), strC)) {
                        break;
                    }
                }
                arrayList.add(dVarG0);
                kVar.a().h().a(zVar.f20347o, dVarG0);
            }
        }
        kVar.a().w().h(zVar.R(), arrayList, kVar);
        l1 l1VarR = kVar.a().r();
        boolean zIsEmpty = arrayList.isEmpty();
        List listO = arrayList;
        if (zIsEmpty) {
            listO = dd.r.o(zVar.F0());
        }
        return dd.a0.I0(l1VarR.p(kVar, listO));
    }

    public static /* synthetic */ qe.f L0(z zVar, ve.r rVar, xf.r0 r0Var, fe.e0 e0Var, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            r0Var = null;
        }
        return zVar.K0(rVar, r0Var, e0Var);
    }

    public static final Map U0(z zVar) {
        Collection collectionC = zVar.f20347o.C();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionC) {
            if (((ve.n) obj).F()) {
                arrayList.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(vd.l.b(dd.n0.d(dd.s.u(arrayList, 10)), 16));
        for (Object obj2 : arrayList) {
            linkedHashMap.put(((ve.n) obj2).getName(), obj2);
        }
        return linkedHashMap;
    }

    public static final Set Y0(re.k kVar, z zVar) {
        return dd.a0.N0(kVar.a().w().e(zVar.R(), kVar));
    }

    public static final Collection g1(f1 f1Var, z zVar, ef.f accessorName) {
        kotlin.jvm.internal.t.f(accessorName, "accessorName");
        return kotlin.jvm.internal.t.b(f1Var.getName(), accessorName) ? dd.q.e(f1Var) : dd.a0.s0(zVar.q1(accessorName), zVar.r1(accessorName));
    }

    public static final Set h1(z zVar) {
        return dd.a0.N0(zVar.f20347o.J());
    }

    public static final fe.e i1(z zVar, re.k kVar, ef.f name) {
        kotlin.jvm.internal.t.f(name, "name");
        if (((Set) zVar.f20350r.invoke()).contains(name)) {
            oe.u uVarD = kVar.a().d();
            ef.b bVarN = nf.e.n(zVar.R());
            kotlin.jvm.internal.t.c(bVarN);
            ve.g gVarC = uVarD.c(new u.a(bVarN.d(name), null, zVar.f20347o, 2, null));
            if (gVarC == null) {
                return null;
            }
            n nVar = new n(kVar, zVar.R(), gVarC, null, 8, null);
            kVar.a().e().a(nVar);
            return nVar;
        }
        if (!((Set) zVar.f20351s.invoke()).contains(name)) {
            ve.n nVar2 = (ve.n) ((Map) zVar.f20352t.invoke()).get(name);
            if (nVar2 == null) {
                return null;
            }
            return ie.q.L0(kVar.e(), zVar.R(), name, kVar.e().e(new y(zVar)), re.h.a(kVar, nVar2), kVar.a().t().a(nVar2));
        }
        List listC = dd.q.c();
        kVar.a().w().f(zVar.R(), name, listC, kVar);
        List listA = dd.q.a(listC);
        int size = listA.size();
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return (fe.e) dd.a0.v0(listA);
        }
        throw new IllegalStateException(("Multiple classes with same name are generated: " + listA).toString());
    }

    public static final Set j1(z zVar) {
        return dd.v0.l(zVar.b(), zVar.d());
    }

    public static final boolean z0(ve.q it) {
        kotlin.jvm.internal.t.f(it, "it");
        return !it.P();
    }

    @Override // se.t0
    public void B(Collection result, ef.f name) {
        kotlin.jvm.internal.t.f(result, "result");
        kotlin.jvm.internal.t.f(name, "name");
        Set setB1 = b1(name);
        if (!oe.t0.f18060a.k(name) && !oe.i.f17980o.n(name)) {
            if (setB1 == null || !setB1.isEmpty()) {
                Iterator it = setB1.iterator();
                while (it.hasNext()) {
                    if (((fe.z) it.next()).isSuspend()) {
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : setB1) {
                if (f1((f1) obj)) {
                    arrayList.add(obj);
                }
            }
            t0(result, name, arrayList, false);
            return;
        }
        hg.l lVarA = hg.l.f11443c.a();
        Collection collectionD = pe.a.d(name, setB1, dd.r.k(), R(), tf.w.f22065a, L().a().k().a());
        kotlin.jvm.internal.t.e(collectionD, "resolveOverridesForNonStaticMembers(...)");
        u0(name, result, collectionD, result, new a(this));
        u0(name, result, collectionD, lVarA, new b(this));
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : setB1) {
            if (f1((f1) obj2)) {
                arrayList2.add(obj2);
            }
        }
        t0(result, name, dd.a0.s0(arrayList2, lVarA), true);
    }

    @Override // se.t0
    public void C(ef.f name, Collection result) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(result, "result");
        if (this.f20347o.q()) {
            w0(name, result);
        }
        Set setD1 = d1(name);
        if (setD1.isEmpty()) {
            return;
        }
        l.b bVar = hg.l.f11443c;
        hg.l lVarA = bVar.a();
        hg.l lVarA2 = bVar.a();
        v0(setD1, result, lVarA, new w(this));
        v0(dd.v0.j(setD1, lVarA), lVarA2, null, new x(this));
        Collection collectionD = pe.a.d(name, dd.v0.l(setD1, lVarA2), result, R(), L().a().c(), L().a().k().a());
        kotlin.jvm.internal.t.e(collectionD, "resolveOverridesForNonStaticMembers(...)");
        result.addAll(collectionD);
    }

    public final Collection C0() {
        if (!this.f20348p) {
            return L().a().k().d().g(R());
        }
        Collection collectionC = R().k().c();
        kotlin.jvm.internal.t.e(collectionC, "getSupertypes(...)");
        return collectionC;
    }

    @Override // se.t0
    public Set D(qf.d kindFilter, pd.k kVar) {
        kotlin.jvm.internal.t.f(kindFilter, "kindFilter");
        if (this.f20347o.q()) {
            return b();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(((c) N().invoke()).f());
        Collection collectionC = R().k().c();
        kotlin.jvm.internal.t.e(collectionC, "getSupertypes(...)");
        Iterator it = collectionC.iterator();
        while (it.hasNext()) {
            dd.w.z(linkedHashSet, ((xf.r0) it.next()).q().d());
        }
        return linkedHashSet;
    }

    public final List E0(ie.i iVar) {
        ie.i iVar2;
        cd.q qVar;
        Collection collectionL = this.f20347o.L();
        ArrayList arrayList = new ArrayList(collectionL.size());
        te.a aVarB = te.b.b(h2.f24979b, true, false, null, 6, null);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : collectionL) {
            if (kotlin.jvm.internal.t.b(((ve.r) obj).getName(), oe.i0.f17983c)) {
                arrayList2.add(obj);
            } else {
                arrayList3.add(obj);
            }
        }
        cd.q qVar2 = new cd.q(arrayList2, arrayList3);
        List list = (List) qVar2.a();
        List<ve.r> list2 = (List) qVar2.b();
        list.size();
        ve.r rVar = (ve.r) dd.a0.b0(list);
        if (rVar != null) {
            ve.x returnType = rVar.getReturnType();
            if (returnType instanceof ve.f) {
                ve.f fVar = (ve.f) returnType;
                qVar = new cd.q(L().g().l(fVar, aVarB, true), L().g().p(fVar.o(), aVarB));
            } else {
                qVar = new cd.q(L().g().p(returnType, aVarB), null);
            }
            xf.r0 r0Var = (xf.r0) qVar.a();
            xf.r0 r0Var2 = (xf.r0) qVar.b();
            iVar2 = iVar;
            s0(arrayList, iVar2, 0, rVar, r0Var, r0Var2);
        } else {
            iVar2 = iVar;
        }
        int i10 = 0;
        int i11 = rVar == null ? 0 : 1;
        for (ve.r rVar2 : list2) {
            s0(arrayList, iVar2, i10 + i11, rVar2, L().g().p(rVar2.getReturnType(), aVarB), null);
            i10++;
        }
        return arrayList;
    }

    public final fe.d F0() {
        boolean zQ = this.f20347o.q();
        if ((this.f20347o.G() || !this.f20347o.t()) && !zQ) {
            return null;
        }
        fe.e eVarR = R();
        qe.b bVarT1 = qe.b.t1(eVarR, ge.h.L.b(), true, L().a().t().a(this.f20347o));
        kotlin.jvm.internal.t.e(bVarT1, "createJavaConstructor(...)");
        List listE0 = zQ ? E0(bVarT1) : Collections.EMPTY_LIST;
        bVarT1.Z0(false);
        bVarT1.q1(listE0, Z0(eVarR));
        bVarT1.Y0(true);
        bVarT1.g1(eVarR.s());
        L().a().h().a(this.f20347o, bVarT1);
        return bVarT1;
    }

    public final fe.d G0() {
        fe.e eVarR = R();
        qe.b bVarT1 = qe.b.t1(eVarR, ge.h.L.b(), true, L().a().t().a(this.f20347o));
        kotlin.jvm.internal.t.e(bVarT1, "createJavaConstructor(...)");
        List listM0 = M0(bVarT1);
        bVarT1.Z0(false);
        bVarT1.q1(listM0, Z0(eVarR));
        bVarT1.Y0(false);
        bVarT1.g1(eVarR.s());
        return bVarT1;
    }

    public final f1 H0(f1 f1Var, fe.a aVar, Collection collection) {
        if (collection != null && collection.isEmpty()) {
            return f1Var;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            f1 f1Var2 = (f1) it.next();
            if (!kotlin.jvm.internal.t.b(f1Var, f1Var2) && f1Var2.d0() == null && Q0(f1Var2, aVar)) {
                fe.z zVarBuild = f1Var.u().o().build();
                kotlin.jvm.internal.t.c(zVarBuild);
                return (f1) zVarBuild;
            }
        }
        return f1Var;
    }

    public final f1 I0(fe.z zVar, pd.k kVar) {
        Object next;
        ef.f name = zVar.getName();
        kotlin.jvm.internal.t.e(name, "getName(...)");
        Iterator it = ((Iterable) kVar.invoke(name)).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (e1((f1) next, zVar)) {
                break;
            }
        }
        f1 f1Var = (f1) next;
        if (f1Var == null) {
            return null;
        }
        z.a aVarU = f1Var.u();
        List listI = zVar.i();
        kotlin.jvm.internal.t.e(listI, "getValueParameters(...)");
        ArrayList arrayList = new ArrayList(dd.s.u(listI, 10));
        Iterator it2 = listI.iterator();
        while (it2.hasNext()) {
            arrayList.add(((s1) it2.next()).getType());
        }
        List listI2 = f1Var.i();
        kotlin.jvm.internal.t.e(listI2, "getValueParameters(...)");
        aVarU.b(qe.h.a(arrayList, listI2, zVar));
        aVarU.t();
        aVarU.e();
        aVarU.q(qe.e.H, Boolean.TRUE);
        return (f1) aVarU.build();
    }

    public final qe.f J0(fe.y0 y0Var, pd.k kVar) {
        f1 f1VarX0;
        ie.m0 m0VarM = null;
        if (!P0(y0Var, kVar)) {
            return null;
        }
        f1 f1VarW0 = W0(y0Var, kVar);
        kotlin.jvm.internal.t.c(f1VarW0);
        if (y0Var.i0()) {
            f1VarX0 = X0(y0Var, kVar);
            kotlin.jvm.internal.t.c(f1VarX0);
        } else {
            f1VarX0 = null;
        }
        if (f1VarX0 != null) {
            f1VarX0.l();
            f1VarW0.l();
        }
        qe.d dVar = new qe.d(R(), f1VarW0, f1VarX0, y0Var);
        xf.r0 returnType = f1VarW0.getReturnType();
        kotlin.jvm.internal.t.c(returnType);
        dVar.b1(returnType, dd.r.k(), O(), null, dd.r.k());
        ie.l0 l0VarK = jf.h.k(dVar, f1VarW0.getAnnotations(), false, false, false, f1VarW0.j());
        l0VarK.M0(f1VarW0);
        l0VarK.P0(dVar.getType());
        kotlin.jvm.internal.t.e(l0VarK, "apply(...)");
        if (f1VarX0 != null) {
            List listI = f1VarX0.i();
            kotlin.jvm.internal.t.e(listI, "getValueParameters(...)");
            s1 s1Var = (s1) dd.a0.b0(listI);
            if (s1Var == null) {
                throw new AssertionError("No parameter found for " + f1VarX0);
            }
            m0VarM = jf.h.m(dVar, f1VarX0.getAnnotations(), s1Var.getAnnotations(), false, false, false, f1VarX0.getVisibility(), f1VarX0.j());
            m0VarM.M0(f1VarX0);
        }
        dVar.U0(l0VarK, m0VarM);
        return dVar;
    }

    public final qe.f K0(ve.r rVar, xf.r0 r0Var, fe.e0 e0Var) {
        qe.f fVar;
        z zVar;
        xf.r0 r0VarA;
        qe.f fVarF1 = qe.f.f1(R(), re.h.a(L(), rVar), e0Var, oe.u0.d(rVar.getVisibility()), false, rVar.getName(), L().a().t().a(rVar), false);
        kotlin.jvm.internal.t.e(fVarF1, "create(...)");
        ie.l0 l0VarD = jf.h.d(fVarF1, ge.h.L.b());
        kotlin.jvm.internal.t.e(l0VarD, "createDefaultGetter(...)");
        fVarF1.U0(l0VarD, null);
        if (r0Var == null) {
            re.k kVarI = re.c.i(L(), fVarF1, rVar, 0, 4, null);
            fVar = fVarF1;
            zVar = this;
            r0VarA = zVar.A(rVar, kVarI);
        } else {
            fVar = fVarF1;
            zVar = this;
            r0VarA = r0Var;
        }
        fVar.b1(r0VarA, dd.r.k(), zVar.O(), null, dd.r.k());
        l0VarD.P0(r0VarA);
        return fVar;
    }

    public final List M0(ie.i iVar) {
        Collection collectionL = this.f20347o.l();
        ArrayList arrayList = new ArrayList(collectionL.size());
        te.a aVarB = te.b.b(h2.f24979b, false, false, null, 6, null);
        Iterator it = collectionL.iterator();
        int i10 = 0;
        while (true) {
            int i11 = i10;
            if (!it.hasNext()) {
                return arrayList;
            }
            i10 = i11 + 1;
            ve.w wVar = (ve.w) it.next();
            xf.r0 r0VarP = L().g().p(wVar.getType(), aVarB);
            arrayList.add(new ie.u0(iVar, null, i11, ge.h.L.b(), wVar.getName(), r0VarP, false, false, false, wVar.a() ? L().a().m().p().k(r0VarP) : null, L().a().t().a(wVar)));
        }
    }

    public final f1 N0(f1 f1Var, ef.f fVar) {
        z.a aVarU = f1Var.u();
        aVarU.j(fVar);
        aVarU.t();
        aVarU.e();
        fe.z zVarBuild = aVarU.build();
        kotlin.jvm.internal.t.c(zVarBuild);
        return (f1) zVarBuild;
    }

    @Override // se.t0
    public fe.b1 O() {
        return jf.i.l(R());
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final fe.f1 O0(fe.f1 r6) {
        /*
            r5 = this;
            java.util.List r0 = r6.i()
            java.lang.String r1 = "getValueParameters(...)"
            kotlin.jvm.internal.t.e(r0, r1)
            java.lang.Object r0 = dd.a0.m0(r0)
            fe.s1 r0 = (fe.s1) r0
            r2 = 0
            if (r0 == 0) goto L7d
            xf.r0 r3 = r0.getType()
            xf.u1 r3 = r3.N0()
            fe.h r3 = r3.b()
            if (r3 == 0) goto L35
            ef.d r3 = nf.e.p(r3)
            if (r3 == 0) goto L35
            boolean r4 = r3.f()
            if (r4 == 0) goto L2d
            goto L2e
        L2d:
            r3 = r2
        L2e:
            if (r3 == 0) goto L35
            ef.c r3 = r3.m()
            goto L36
        L35:
            r3 = r2
        L36:
            ef.c r4 = ce.o.f3968v
            boolean r3 = kotlin.jvm.internal.t.b(r3, r4)
            if (r3 == 0) goto L3f
            goto L40
        L3f:
            r0 = r2
        L40:
            if (r0 != 0) goto L43
            goto L7d
        L43:
            fe.z$a r2 = r6.u()
            java.util.List r6 = r6.i()
            kotlin.jvm.internal.t.e(r6, r1)
            r1 = 1
            java.util.List r6 = dd.a0.U(r6, r1)
            fe.z$a r6 = r2.b(r6)
            xf.r0 r0 = r0.getType()
            java.util.List r0 = r0.L0()
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            xf.a2 r0 = (xf.a2) r0
            xf.r0 r0 = r0.getType()
            fe.z$a r6 = r6.g(r0)
            fe.z r6 = r6.build()
            fe.f1 r6 = (fe.f1) r6
            r0 = r6
            ie.o0 r0 = (ie.o0) r0
            if (r0 == 0) goto L7c
            r0.h1(r1)
        L7c:
            return r6
        L7d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: se.z.O0(fe.f1):fe.f1");
    }

    public final boolean P0(fe.y0 y0Var, pd.k kVar) {
        if (d.a(y0Var)) {
            return false;
        }
        f1 f1VarW0 = W0(y0Var, kVar);
        f1 f1VarX0 = X0(y0Var, kVar);
        if (f1VarW0 == null) {
            return false;
        }
        if (y0Var.i0()) {
            return f1VarX0 != null && f1VarX0.l() == f1VarW0.l();
        }
        return true;
    }

    public final boolean Q0(fe.a aVar, fe.a aVar2) {
        o.i.a aVarC = jf.o.f14337f.F(aVar2, aVar, true).c();
        kotlin.jvm.internal.t.e(aVarC, "getResult(...)");
        return aVarC == o.i.a.OVERRIDABLE && !oe.z.f18109a.a(aVar2, aVar);
    }

    public final boolean R0(f1 f1Var) {
        t0.a aVar = oe.t0.f18060a;
        ef.f name = f1Var.getName();
        kotlin.jvm.internal.t.e(name, "getName(...)");
        ef.f fVarB = aVar.b(name);
        if (fVarB == null) {
            return false;
        }
        Set setB1 = b1(fVarB);
        ArrayList arrayList = new ArrayList();
        for (Object obj : setB1) {
            if (oe.s0.d((f1) obj)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        f1 f1VarN0 = N0(f1Var, fVarB);
        if (arrayList.isEmpty()) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (S0((f1) it.next(), f1VarN0)) {
                return true;
            }
        }
        return false;
    }

    public final boolean S0(f1 f1Var, fe.z zVar) {
        if (oe.f.f17966o.m(f1Var)) {
            zVar = zVar.a();
        }
        kotlin.jvm.internal.t.c(zVar);
        return Q0(zVar, f1Var);
    }

    public final boolean T0(f1 f1Var) {
        f1 f1VarO0 = O0(f1Var);
        if (f1VarO0 == null) {
            return false;
        }
        ef.f name = f1Var.getName();
        kotlin.jvm.internal.t.e(name, "getName(...)");
        Set<f1> setB1 = b1(name);
        if (setB1 != null && setB1.isEmpty()) {
            return false;
        }
        for (f1 f1Var2 : setB1) {
            if (f1Var2.isSuspend() && Q0(f1VarO0, f1Var2)) {
                return true;
            }
        }
        return false;
    }

    @Override // se.t0
    public boolean V(qe.e eVar) {
        kotlin.jvm.internal.t.f(eVar, "<this>");
        if (this.f20347o.q()) {
            return false;
        }
        return f1(eVar);
    }

    public final f1 V0(fe.y0 y0Var, String str, pd.k kVar) {
        f1 f1Var;
        ef.f fVarK = ef.f.k(str);
        kotlin.jvm.internal.t.e(fVarK, "identifier(...)");
        Iterator it = ((Iterable) kVar.invoke(fVarK)).iterator();
        do {
            f1Var = null;
            if (!it.hasNext()) {
                break;
            }
            f1 f1Var2 = (f1) it.next();
            if (f1Var2.i().size() == 0) {
                yf.e eVar = yf.e.f25402a;
                xf.r0 returnType = f1Var2.getReturnType();
                if (returnType == null ? false : eVar.c(returnType, y0Var.getType())) {
                    f1Var = f1Var2;
                }
            }
        } while (f1Var == null);
        return f1Var;
    }

    public final f1 W0(fe.y0 y0Var, pd.k kVar) {
        fe.z0 z0VarD = y0Var.d();
        fe.z0 z0Var = z0VarD != null ? (fe.z0) oe.s0.g(z0VarD) : null;
        String strB = z0Var != null ? oe.m.f18040a.b(z0Var) : null;
        if (strB != null && !oe.s0.l(R(), z0Var)) {
            return V0(y0Var, strB, kVar);
        }
        String strB2 = y0Var.getName().b();
        kotlin.jvm.internal.t.e(strB2, "asString(...)");
        return V0(y0Var, oe.h0.b(strB2), kVar);
    }

    public final f1 X0(fe.y0 y0Var, pd.k kVar) {
        f1 f1Var;
        xf.r0 returnType;
        String strB = y0Var.getName().b();
        kotlin.jvm.internal.t.e(strB, "asString(...)");
        ef.f fVarK = ef.f.k(oe.h0.e(strB));
        kotlin.jvm.internal.t.e(fVarK, "identifier(...)");
        Iterator it = ((Iterable) kVar.invoke(fVarK)).iterator();
        do {
            f1Var = null;
            if (!it.hasNext()) {
                break;
            }
            f1 f1Var2 = (f1) it.next();
            if (f1Var2.i().size() == 1 && (returnType = f1Var2.getReturnType()) != null && ce.i.D0(returnType)) {
                yf.e eVar = yf.e.f25402a;
                List listI = f1Var2.i();
                kotlin.jvm.internal.t.e(listI, "getValueParameters(...)");
                if (eVar.b(((s1) dd.a0.v0(listI)).getType(), y0Var.getType())) {
                    f1Var = f1Var2;
                }
            }
        } while (f1Var == null);
        return f1Var;
    }

    @Override // se.t0
    public t0.a Y(ve.r method, List methodTypeParameters, xf.r0 returnType, List valueParameters) {
        kotlin.jvm.internal.t.f(method, "method");
        kotlin.jvm.internal.t.f(methodTypeParameters, "methodTypeParameters");
        kotlin.jvm.internal.t.f(returnType, "returnType");
        kotlin.jvm.internal.t.f(valueParameters, "valueParameters");
        o.b bVarA = L().a().s().a(method, R(), returnType, null, valueParameters, methodTypeParameters);
        kotlin.jvm.internal.t.e(bVarA, "resolvePropagatedSignature(...)");
        xf.r0 r0VarD = bVarA.d();
        kotlin.jvm.internal.t.e(r0VarD, "getReturnType(...)");
        xf.r0 r0VarC = bVarA.c();
        List listF = bVarA.f();
        kotlin.jvm.internal.t.e(listF, "getValueParameters(...)");
        List listE = bVarA.e();
        kotlin.jvm.internal.t.e(listE, "getTypeParameters(...)");
        boolean zG = bVarA.g();
        List listB = bVarA.b();
        kotlin.jvm.internal.t.e(listB, "getErrors(...)");
        return new t0.a(r0VarD, r0VarC, listF, listE, zG, listB);
    }

    public final fe.u Z0(fe.e eVar) {
        fe.u visibility = eVar.getVisibility();
        kotlin.jvm.internal.t.e(visibility, "getVisibility(...)");
        if (!kotlin.jvm.internal.t.b(visibility, oe.y.f18106b)) {
            return visibility;
        }
        fe.u PROTECTED_AND_PACKAGE = oe.y.f18107c;
        kotlin.jvm.internal.t.e(PROTECTED_AND_PACKAGE, "PROTECTED_AND_PACKAGE");
        return PROTECTED_AND_PACKAGE;
    }

    @Override // se.t0, qf.l, qf.k
    public Collection a(ef.f name, ne.b location) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        n1(name, location);
        return super.a(name, location);
    }

    public final wf.i a1() {
        return this.f20349q;
    }

    public final Set b1(ef.f fVar) {
        Collection collectionC0 = C0();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = collectionC0.iterator();
        while (it.hasNext()) {
            dd.w.z(linkedHashSet, ((xf.r0) it.next()).q().c(fVar, ne.d.f17048o));
        }
        return linkedHashSet;
    }

    @Override // se.t0, qf.l, qf.k
    public Collection c(ef.f name, ne.b location) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        n1(name, location);
        return super.c(name, location);
    }

    @Override // se.t0
    /* JADX INFO: renamed from: c1, reason: merged with bridge method [inline-methods] */
    public fe.e R() {
        return this.f20346n;
    }

    public final Set d1(ef.f fVar) {
        Collection collectionC0 = C0();
        ArrayList arrayList = new ArrayList();
        Iterator it = collectionC0.iterator();
        while (it.hasNext()) {
            Collection collectionA = ((xf.r0) it.next()).q().a(fVar, ne.d.f17048o);
            ArrayList arrayList2 = new ArrayList(dd.s.u(collectionA, 10));
            Iterator it2 = collectionA.iterator();
            while (it2.hasNext()) {
                arrayList2.add((fe.y0) it2.next());
            }
            dd.w.z(arrayList, arrayList2);
        }
        return dd.a0.N0(arrayList);
    }

    @Override // qf.l, qf.n
    public fe.h e(ef.f name, ne.b location) {
        wf.h hVar;
        fe.e eVar;
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        n1(name, location);
        z zVar = (z) Q();
        return (zVar == null || (hVar = zVar.f20353u) == null || (eVar = (fe.e) hVar.invoke(name)) == null) ? (fe.h) this.f20353u.invoke(name) : eVar;
    }

    public final boolean e1(f1 f1Var, fe.z zVar) {
        String strC = xe.c0.c(f1Var, false, false, 2, null);
        fe.z zVarA = zVar.a();
        kotlin.jvm.internal.t.e(zVarA, "getOriginal(...)");
        return kotlin.jvm.internal.t.b(strC, xe.c0.c(zVarA, false, false, 2, null)) && !Q0(f1Var, zVar);
    }

    public final boolean f1(f1 f1Var) {
        ef.f name = f1Var.getName();
        kotlin.jvm.internal.t.e(name, "getName(...)");
        List listA = oe.n0.a(name);
        if (listA == null || !listA.isEmpty()) {
            Iterator it = listA.iterator();
            while (it.hasNext()) {
                Set<fe.y0> setD1 = d1((ef.f) it.next());
                if (setD1 == null || !setD1.isEmpty()) {
                    for (fe.y0 y0Var : setD1) {
                        if (P0(y0Var, new v(f1Var, this))) {
                            if (!y0Var.i0()) {
                                String strB = f1Var.getName().b();
                                kotlin.jvm.internal.t.e(strB, "asString(...)");
                                if (!oe.h0.d(strB)) {
                                }
                            }
                            return false;
                        }
                    }
                }
            }
        }
        return (R0(f1Var) || s1(f1Var) || T0(f1Var)) ? false : true;
    }

    public final f1 k1(f1 f1Var, pd.k kVar, Collection collection) {
        f1 f1VarI0;
        fe.z zVarL = oe.i.l(f1Var);
        if (zVarL != null && (f1VarI0 = I0(zVarL, kVar)) != null) {
            if (!f1(f1VarI0)) {
                f1VarI0 = null;
            }
            if (f1VarI0 != null) {
                return H0(f1VarI0, zVarL, collection);
            }
        }
        return null;
    }

    public final f1 l1(f1 f1Var, pd.k kVar, ef.f fVar, Collection collection) {
        f1 f1Var2 = (f1) oe.s0.g(f1Var);
        if (f1Var2 == null) {
            return null;
        }
        String strE = oe.s0.e(f1Var2);
        kotlin.jvm.internal.t.c(strE);
        ef.f fVarK = ef.f.k(strE);
        kotlin.jvm.internal.t.e(fVarK, "identifier(...)");
        Iterator it = ((Collection) kVar.invoke(fVarK)).iterator();
        while (it.hasNext()) {
            f1 f1VarN0 = N0((f1) it.next(), fVar);
            if (S0(f1Var2, f1VarN0)) {
                return H0(f1VarN0, f1Var2, collection);
            }
        }
        return null;
    }

    public final f1 m1(f1 f1Var, pd.k kVar) {
        if (!f1Var.isSuspend()) {
            return null;
        }
        ef.f name = f1Var.getName();
        kotlin.jvm.internal.t.e(name, "getName(...)");
        Iterator it = ((Iterable) kVar.invoke(name)).iterator();
        while (it.hasNext()) {
            f1 f1VarO0 = O0((f1) it.next());
            if (f1VarO0 == null || !Q0(f1VarO0, f1Var)) {
                f1VarO0 = null;
            }
            if (f1VarO0 != null) {
                return f1VarO0;
            }
        }
        return null;
    }

    public void n1(ef.f name, ne.b location) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        me.a.a(L().a().l(), location, R(), name);
    }

    public final qe.b o1(ve.k kVar) {
        fe.e eVarR = R();
        qe.b bVarT1 = qe.b.t1(eVarR, re.h.a(L(), kVar), false, L().a().t().a(kVar));
        kotlin.jvm.internal.t.e(bVarT1, "createJavaConstructor(...)");
        re.k kVarH = re.c.h(L(), bVarT1, kVar, eVarR.v().size());
        t0.b bVarD0 = d0(kVarH, bVarT1, kVar.i());
        List listV = eVarR.v();
        kotlin.jvm.internal.t.e(listV, "getDeclaredTypeParameters(...)");
        List typeParameters = kVar.getTypeParameters();
        ArrayList arrayList = new ArrayList(dd.s.u(typeParameters, 10));
        Iterator it = typeParameters.iterator();
        while (it.hasNext()) {
            fe.l1 l1VarA = kVarH.f().a((ve.y) it.next());
            kotlin.jvm.internal.t.c(l1VarA);
            arrayList.add(l1VarA);
        }
        bVarT1.r1(bVarD0.a(), oe.u0.d(kVar.getVisibility()), dd.a0.s0(listV, arrayList));
        bVarT1.Y0(false);
        bVarT1.Z0(bVarD0.b());
        bVarT1.g1(eVarR.s());
        kVarH.a().h().a(kVar, bVarT1);
        return bVarT1;
    }

    public final qe.e p1(ve.w wVar) {
        qe.e eVarP1 = qe.e.p1(R(), re.h.a(L(), wVar), wVar.getName(), L().a().t().a(wVar), true);
        kotlin.jvm.internal.t.e(eVarP1, "createJavaMethod(...)");
        eVarP1.o1(null, O(), dd.r.k(), dd.r.k(), dd.r.k(), L().g().p(wVar.getType(), te.b.b(h2.f24979b, false, false, null, 6, null)), fe.e0.f9460a.a(false, false, true), fe.t.f9511e, null);
        eVarP1.s1(false, false);
        L().a().h().b(wVar, eVarP1);
        return eVarP1;
    }

    public final Collection q1(ef.f fVar) {
        Collection collectionE = ((c) N().invoke()).e(fVar);
        ArrayList arrayList = new ArrayList(dd.s.u(collectionE, 10));
        Iterator it = collectionE.iterator();
        while (it.hasNext()) {
            arrayList.add(Z((ve.r) it.next()));
        }
        return arrayList;
    }

    public final Collection r1(ef.f fVar) {
        Set setB1 = b1(fVar);
        ArrayList arrayList = new ArrayList();
        for (Object obj : setB1) {
            f1 f1Var = (f1) obj;
            if (!oe.s0.d(f1Var) && oe.i.l(f1Var) == null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final void s0(List list, fe.l lVar, int i10, ve.r rVar, xf.r0 r0Var, xf.r0 r0Var2) {
        ge.h hVarB = ge.h.L.b();
        ef.f name = rVar.getName();
        xf.r0 r0VarN = i2.n(r0Var);
        kotlin.jvm.internal.t.e(r0VarN, "makeNotNullable(...)");
        list.add(new ie.u0(lVar, null, i10, hVarB, name, r0VarN, rVar.K(), false, false, r0Var2 != null ? i2.n(r0Var2) : null, L().a().t().a(rVar)));
    }

    public final boolean s1(f1 f1Var) {
        oe.i iVar = oe.i.f17980o;
        ef.f name = f1Var.getName();
        kotlin.jvm.internal.t.e(name, "getName(...)");
        if (!iVar.n(name)) {
            return false;
        }
        ef.f name2 = f1Var.getName();
        kotlin.jvm.internal.t.e(name2, "getName(...)");
        Set setB1 = b1(name2);
        ArrayList arrayList = new ArrayList();
        Iterator it = setB1.iterator();
        while (it.hasNext()) {
            fe.z zVarL = oe.i.l((f1) it.next());
            if (zVarL != null) {
                arrayList.add(zVarL);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (e1(f1Var, (fe.z) it2.next())) {
                return true;
            }
        }
        return false;
    }

    public final void t0(Collection collection, ef.f fVar, Collection collection2, boolean z10) {
        Collection<f1> collectionD = pe.a.d(fVar, collection2, collection, R(), L().a().c(), L().a().k().a());
        kotlin.jvm.internal.t.e(collectionD, "resolveOverridesForNonStaticMembers(...)");
        if (!z10) {
            collection.addAll(collectionD);
            return;
        }
        List listS0 = dd.a0.s0(collection, collectionD);
        ArrayList arrayList = new ArrayList(dd.s.u(collectionD, 10));
        for (f1 f1VarH0 : collectionD) {
            f1 f1Var = (f1) oe.s0.j(f1VarH0);
            if (f1Var == null) {
                kotlin.jvm.internal.t.c(f1VarH0);
            } else {
                kotlin.jvm.internal.t.c(f1VarH0);
                f1VarH0 = H0(f1VarH0, f1Var, listS0);
            }
            arrayList.add(f1VarH0);
        }
        collection.addAll(arrayList);
    }

    @Override // se.t0
    public String toString() {
        return "Lazy Java member scope for " + this.f20347o.e();
    }

    public final void u0(ef.f fVar, Collection collection, Collection collection2, Collection collection3, pd.k kVar) {
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            f1 f1Var = (f1) it.next();
            hg.a.a(collection3, l1(f1Var, kVar, fVar, collection));
            hg.a.a(collection3, k1(f1Var, kVar, collection));
            hg.a.a(collection3, m1(f1Var, kVar));
        }
    }

    @Override // se.t0
    public Set v(qf.d kindFilter, pd.k kVar) {
        kotlin.jvm.internal.t.f(kindFilter, "kindFilter");
        return dd.v0.l((Set) this.f20350r.invoke(), ((Map) this.f20352t.invoke()).keySet());
    }

    public final void v0(Set set, Collection collection, Set set2, pd.k kVar) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            fe.y0 y0Var = (fe.y0) it.next();
            qe.f fVarJ0 = J0(y0Var, kVar);
            if (fVarJ0 != null) {
                collection.add(fVarJ0);
                if (set2 != null) {
                    set2.add(y0Var);
                    return;
                }
                return;
            }
        }
    }

    public final void w0(ef.f fVar, Collection collection) {
        ve.r rVar = (ve.r) dd.a0.w0(((c) N().invoke()).e(fVar));
        if (rVar == null) {
            return;
        }
        collection.add(L0(this, rVar, null, fe.e0.f9461b, 2, null));
    }

    @Override // se.t0
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public LinkedHashSet x(qf.d kindFilter, pd.k kVar) {
        kotlin.jvm.internal.t.f(kindFilter, "kindFilter");
        Collection collectionC = R().k().c();
        kotlin.jvm.internal.t.e(collectionC, "getSupertypes(...)");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = collectionC.iterator();
        while (it.hasNext()) {
            dd.w.z(linkedHashSet, ((xf.r0) it.next()).q().b());
        }
        linkedHashSet.addAll(((c) N().invoke()).a());
        linkedHashSet.addAll(((c) N().invoke()).c());
        linkedHashSet.addAll(v(kindFilter, kVar));
        linkedHashSet.addAll(L().a().w().a(R(), L()));
        return linkedHashSet;
    }

    @Override // se.t0
    public void y(Collection result, ef.f name) {
        kotlin.jvm.internal.t.f(result, "result");
        kotlin.jvm.internal.t.f(name, "name");
        if (this.f20347o.s() && ((c) N().invoke()).b(name) != null) {
            if (result.isEmpty()) {
                ve.w wVarB = ((c) N().invoke()).b(name);
                kotlin.jvm.internal.t.c(wVarB);
                result.add(p1(wVarB));
            } else {
                Iterator it = result.iterator();
                while (it.hasNext()) {
                    if (((f1) it.next()).i().isEmpty()) {
                        break;
                    }
                }
                ve.w wVarB2 = ((c) N().invoke()).b(name);
                kotlin.jvm.internal.t.c(wVarB2);
                result.add(p1(wVarB2));
            }
        }
        L().a().w().b(R(), name, result, L());
    }

    @Override // se.t0
    /* JADX INFO: renamed from: y0, reason: merged with bridge method [inline-methods] */
    public se.b z() {
        return new se.b(this.f20347o, u.f20335a);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(re.k c10, fe.e ownerDescriptor, ve.g jClass, boolean z10, z zVar) {
        super(c10, zVar);
        kotlin.jvm.internal.t.f(c10, "c");
        kotlin.jvm.internal.t.f(ownerDescriptor, "ownerDescriptor");
        kotlin.jvm.internal.t.f(jClass, "jClass");
        this.f20346n = ownerDescriptor;
        this.f20347o = jClass;
        this.f20348p = z10;
        this.f20349q = c10.e().e(new p(this, c10));
        this.f20350r = c10.e().e(new q(this));
        this.f20351s = c10.e().e(new r(c10, this));
        this.f20352t = c10.e().e(new s(this));
        this.f20353u = c10.e().h(new t(this, c10));
    }
}
