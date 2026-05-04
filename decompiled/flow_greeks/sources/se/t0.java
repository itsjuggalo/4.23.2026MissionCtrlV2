package se;

import fe.f1;
import fe.l1;
import fe.t1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import qf.c;
import xf.h2;
import xf.i2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class t0 extends qf.l {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ wd.m[] f20315m = {kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(t0.class, "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(t0.class, "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(t0.class, "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;", 0))};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final re.k f20316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t0 f20317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final wf.i f20318d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final wf.i f20319e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final wf.g f20320f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final wf.h f20321g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final wf.g f20322h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final wf.i f20323i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final wf.i f20324j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final wf.i f20325k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final wf.g f20326l;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xf.r0 f20327a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final xf.r0 f20328b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f20329c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f20330d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f20331e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List f20332f;

        public a(xf.r0 returnType, xf.r0 r0Var, List valueParameters, List typeParameters, boolean z10, List errors) {
            kotlin.jvm.internal.t.f(returnType, "returnType");
            kotlin.jvm.internal.t.f(valueParameters, "valueParameters");
            kotlin.jvm.internal.t.f(typeParameters, "typeParameters");
            kotlin.jvm.internal.t.f(errors, "errors");
            this.f20327a = returnType;
            this.f20328b = r0Var;
            this.f20329c = valueParameters;
            this.f20330d = typeParameters;
            this.f20331e = z10;
            this.f20332f = errors;
        }

        public final List a() {
            return this.f20332f;
        }

        public final boolean b() {
            return this.f20331e;
        }

        public final xf.r0 c() {
            return this.f20328b;
        }

        public final xf.r0 d() {
            return this.f20327a;
        }

        public final List e() {
            return this.f20330d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.jvm.internal.t.b(this.f20327a, aVar.f20327a) && kotlin.jvm.internal.t.b(this.f20328b, aVar.f20328b) && kotlin.jvm.internal.t.b(this.f20329c, aVar.f20329c) && kotlin.jvm.internal.t.b(this.f20330d, aVar.f20330d) && this.f20331e == aVar.f20331e && kotlin.jvm.internal.t.b(this.f20332f, aVar.f20332f);
        }

        public final List f() {
            return this.f20329c;
        }

        public int hashCode() {
            int iHashCode = this.f20327a.hashCode() * 31;
            xf.r0 r0Var = this.f20328b;
            return ((((((((iHashCode + (r0Var == null ? 0 : r0Var.hashCode())) * 31) + this.f20329c.hashCode()) * 31) + this.f20330d.hashCode()) * 31) + Boolean.hashCode(this.f20331e)) * 31) + this.f20332f.hashCode();
        }

        public String toString() {
            return "MethodSignatureData(returnType=" + this.f20327a + ", receiverType=" + this.f20328b + ", valueParameters=" + this.f20329c + ", typeParameters=" + this.f20330d + ", hasStableParameterNames=" + this.f20331e + ", errors=" + this.f20332f + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f20333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f20334b;

        public b(List descriptors, boolean z10) {
            kotlin.jvm.internal.t.f(descriptors, "descriptors");
            this.f20333a = descriptors;
            this.f20334b = z10;
        }

        public final List a() {
            return this.f20333a;
        }

        public final boolean b() {
            return this.f20334b;
        }
    }

    public /* synthetic */ t0(re.k kVar, t0 t0Var, int i10, kotlin.jvm.internal.k kVar2) {
        this(kVar, (i10 & 2) != 0 ? null : t0Var);
    }

    public static final fe.y0 F(t0 t0Var, ef.f name) {
        kotlin.jvm.internal.t.f(name, "name");
        t0 t0Var2 = t0Var.f20317c;
        if (t0Var2 != null) {
            return (fe.y0) t0Var2.f20321g.invoke(name);
        }
        ve.n nVarD = ((c) t0Var.f20319e.invoke()).d(name);
        if (nVarD == null || nVarD.F()) {
            return null;
        }
        return t0Var.a0(nVarD);
    }

    public static final Collection G(t0 t0Var, ef.f name) {
        kotlin.jvm.internal.t.f(name, "name");
        t0 t0Var2 = t0Var.f20317c;
        if (t0Var2 != null) {
            return (Collection) t0Var2.f20320f.invoke(name);
        }
        ArrayList arrayList = new ArrayList();
        for (ve.r rVar : ((c) t0Var.f20319e.invoke()).e(name)) {
            qe.e eVarZ = t0Var.Z(rVar);
            if (t0Var.V(eVarZ)) {
                t0Var.f20316b.a().h().b(rVar, eVarZ);
                arrayList.add(eVarZ);
            }
        }
        t0Var.y(arrayList, name);
        return arrayList;
    }

    public static final c H(t0 t0Var) {
        return t0Var.z();
    }

    public static final Set I(t0 t0Var) {
        return t0Var.x(qf.d.f19065v, null);
    }

    public static final Collection J(t0 t0Var, ef.f name) {
        kotlin.jvm.internal.t.f(name, "name");
        LinkedHashSet linkedHashSet = new LinkedHashSet((Collection) t0Var.f20320f.invoke(name));
        t0Var.e0(linkedHashSet);
        t0Var.B(linkedHashSet, name);
        return dd.a0.I0(t0Var.f20316b.a().r().p(t0Var.f20316b, linkedHashSet));
    }

    public static final List W(t0 t0Var, ef.f name) {
        kotlin.jvm.internal.t.f(name, "name");
        ArrayList arrayList = new ArrayList();
        hg.a.a(arrayList, t0Var.f20321g.invoke(name));
        t0Var.C(name, arrayList);
        return jf.i.t(t0Var.R()) ? dd.a0.I0(arrayList) : dd.a0.I0(t0Var.f20316b.a().r().p(t0Var.f20316b, arrayList));
    }

    public static final Set X(t0 t0Var) {
        return t0Var.D(qf.d.f19066w, null);
    }

    public static final wf.j b0(t0 t0Var, ve.n nVar, kotlin.jvm.internal.m0 m0Var) {
        return t0Var.f20316b.e().g(new j0(t0Var, nVar, m0Var));
    }

    public static final lf.g c0(t0 t0Var, ve.n nVar, kotlin.jvm.internal.m0 m0Var) {
        return t0Var.f20316b.a().g().a(nVar, (fe.y0) m0Var.f14947a);
    }

    public static final fe.a f0(f1 selectMostSpecificInEachOverridableGroup) {
        kotlin.jvm.internal.t.f(selectMostSpecificInEachOverridableGroup, "$this$selectMostSpecificInEachOverridableGroup");
        return selectMostSpecificInEachOverridableGroup;
    }

    public static final Collection t(t0 t0Var) {
        return t0Var.w(qf.d.f19058o, qf.k.f19084a.c());
    }

    public static final Set u(t0 t0Var) {
        return t0Var.v(qf.d.f19063t, null);
    }

    public final xf.r0 A(ve.r method, re.k c10) {
        kotlin.jvm.internal.t.f(method, "method");
        kotlin.jvm.internal.t.f(c10, "c");
        return c10.g().p(method.getReturnType(), te.b.b(h2.f24979b, method.O().q(), false, null, 6, null));
    }

    public abstract void B(Collection collection, ef.f fVar);

    public abstract void C(ef.f fVar, Collection collection);

    public abstract Set D(qf.d dVar, pd.k kVar);

    public final ie.k0 E(ve.n nVar) {
        qe.f fVarF1 = qe.f.f1(R(), re.h.a(this.f20316b, nVar), fe.e0.f9461b, oe.u0.d(nVar.getVisibility()), !nVar.isFinal(), nVar.getName(), this.f20316b.a().t().a(nVar), U(nVar));
        kotlin.jvm.internal.t.e(fVarF1, "create(...)");
        return fVarF1;
    }

    public final wf.i K() {
        return this.f20318d;
    }

    public final re.k L() {
        return this.f20316b;
    }

    public final Set M() {
        return (Set) wf.m.a(this.f20325k, this, f20315m[2]);
    }

    public final wf.i N() {
        return this.f20319e;
    }

    public abstract fe.b1 O();

    public final Set P() {
        return (Set) wf.m.a(this.f20323i, this, f20315m[0]);
    }

    public final t0 Q() {
        return this.f20317c;
    }

    public abstract fe.m R();

    public final Set S() {
        return (Set) wf.m.a(this.f20324j, this, f20315m[1]);
    }

    public final xf.r0 T(ve.n nVar) {
        xf.r0 r0VarP = this.f20316b.g().p(nVar.getType(), te.b.b(h2.f24979b, false, false, null, 7, null));
        if ((!ce.i.t0(r0VarP) && !ce.i.w0(r0VarP)) || !U(nVar) || !nVar.N()) {
            return r0VarP;
        }
        xf.r0 r0VarN = i2.n(r0VarP);
        kotlin.jvm.internal.t.e(r0VarN, "makeNotNullable(...)");
        return r0VarN;
    }

    public final boolean U(ve.n nVar) {
        return nVar.isFinal() && nVar.P();
    }

    public boolean V(qe.e eVar) {
        kotlin.jvm.internal.t.f(eVar, "<this>");
        return true;
    }

    public abstract a Y(ve.r rVar, List list, xf.r0 r0Var, List list2);

    public final qe.e Z(ve.r method) {
        kotlin.jvm.internal.t.f(method, "method");
        qe.e eVarP1 = qe.e.p1(R(), re.h.a(this.f20316b, method), method.getName(), this.f20316b.a().t().a(method), ((c) this.f20319e.invoke()).b(method.getName()) != null && method.i().isEmpty());
        kotlin.jvm.internal.t.e(eVarP1, "createJavaMethod(...)");
        re.k kVarI = re.c.i(this.f20316b, eVarP1, method, 0, 4, null);
        List typeParameters = method.getTypeParameters();
        List arrayList = new ArrayList(dd.s.u(typeParameters, 10));
        Iterator it = typeParameters.iterator();
        while (it.hasNext()) {
            l1 l1VarA = kVarI.f().a((ve.y) it.next());
            kotlin.jvm.internal.t.c(l1VarA);
            arrayList.add(l1VarA);
        }
        b bVarD0 = d0(kVarI, eVarP1, method.i());
        a aVarY = Y(method, arrayList, A(method, kVarI), bVarD0.a());
        xf.r0 r0VarC = aVarY.c();
        eVarP1.o1(r0VarC != null ? jf.h.i(eVarP1, r0VarC, ge.h.L.b()) : null, O(), dd.r.k(), aVarY.e(), aVarY.f(), aVarY.d(), fe.e0.f9460a.a(false, method.isAbstract(), !method.isFinal()), oe.u0.d(method.getVisibility()), aVarY.c() != null ? dd.n0.e(cd.w.a(qe.e.G, dd.a0.Z(bVarD0.a()))) : dd.o0.h());
        eVarP1.s1(aVarY.b(), bVarD0.b());
        if (!aVarY.a().isEmpty()) {
            kVarI.a().s().b(eVarP1, aVarY.a());
        }
        return eVarP1;
    }

    @Override // qf.l, qf.k
    public Collection a(ef.f name, ne.b location) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        return !d().contains(name) ? dd.r.k() : (Collection) this.f20326l.invoke(name);
    }

    public final fe.y0 a0(ve.n nVar) {
        kotlin.jvm.internal.m0 m0Var = new kotlin.jvm.internal.m0();
        ie.k0 k0VarE = E(nVar);
        m0Var.f14947a = k0VarE;
        k0VarE.V0(null, null, null, null);
        ((ie.k0) m0Var.f14947a).b1(T(nVar), dd.r.k(), O(), null, dd.r.k());
        fe.m mVarR = R();
        fe.e eVar = mVarR instanceof fe.e ? (fe.e) mVarR : null;
        if (eVar != null) {
            m0Var.f14947a = this.f20316b.a().w().d(eVar, (ie.k0) m0Var.f14947a, this.f20316b);
        }
        Object obj = m0Var.f14947a;
        if (jf.i.K((t1) obj, ((ie.k0) obj).getType())) {
            ((ie.k0) m0Var.f14947a).L0(new i0(this, nVar, m0Var));
        }
        this.f20316b.a().h().e(nVar, (fe.y0) m0Var.f14947a);
        return (fe.y0) m0Var.f14947a;
    }

    @Override // qf.l, qf.k
    public Set b() {
        return P();
    }

    @Override // qf.l, qf.k
    public Collection c(ef.f name, ne.b location) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        return !b().contains(name) ? dd.r.k() : (Collection) this.f20322h.invoke(name);
    }

    @Override // qf.l, qf.k
    public Set d() {
        return S();
    }

    public final b d0(re.k c10, fe.z zVar, List jValueParameters) {
        cd.q qVarA;
        ef.f name;
        kotlin.jvm.internal.t.f(c10, "c");
        fe.z function = zVar;
        kotlin.jvm.internal.t.f(function, "function");
        kotlin.jvm.internal.t.f(jValueParameters, "jValueParameters");
        Iterable<dd.g0> iterableQ0 = dd.a0.Q0(jValueParameters);
        ArrayList arrayList = new ArrayList(dd.s.u(iterableQ0, 10));
        boolean z10 = false;
        for (dd.g0 g0Var : iterableQ0) {
            int iA = g0Var.a();
            ve.b0 b0Var = (ve.b0) g0Var.b();
            ge.h hVarA = re.h.a(c10, b0Var);
            te.a aVarB = te.b.b(h2.f24979b, false, false, null, 7, null);
            if (b0Var.a()) {
                ve.x type = b0Var.getType();
                ve.f fVar = type instanceof ve.f ? (ve.f) type : null;
                if (fVar == null) {
                    throw new AssertionError("Vararg parameter should be an array: " + b0Var);
                }
                xf.r0 r0VarL = c10.g().l(fVar, aVarB, true);
                qVarA = cd.w.a(r0VarL, c10.d().p().k(r0VarL));
            } else {
                qVarA = cd.w.a(c10.g().p(b0Var.getType(), aVarB), null);
            }
            xf.r0 r0Var = (xf.r0) qVarA.a();
            xf.r0 r0Var2 = (xf.r0) qVarA.b();
            if (kotlin.jvm.internal.t.b(function.getName().b(), "equals") && jValueParameters.size() == 1 && kotlin.jvm.internal.t.b(c10.d().p().J(), r0Var)) {
                name = ef.f.k("other");
            } else {
                name = b0Var.getName();
                if (name == null) {
                    z10 = true;
                }
                if (name == null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append('p');
                    sb2.append(iA);
                    name = ef.f.k(sb2.toString());
                    kotlin.jvm.internal.t.e(name, "identifier(...)");
                }
            }
            boolean z11 = z10;
            kotlin.jvm.internal.t.c(name);
            arrayList.add(new ie.u0(function, null, iA, hVarA, name, r0Var, false, false, false, r0Var2, c10.a().t().a(b0Var)));
            function = zVar;
            z10 = z11;
        }
        return new b(dd.a0.I0(arrayList), z10);
    }

    public final void e0(Set set) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : set) {
            String strC = xe.c0.c((f1) obj, false, false, 2, null);
            Object arrayList = linkedHashMap.get(strC);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(strC, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        for (List list : linkedHashMap.values()) {
            if (list.size() != 1) {
                Collection collectionB = jf.r.b(list, s0.f20312a);
                set.removeAll(list);
                set.addAll(collectionB);
            }
        }
    }

    @Override // qf.l, qf.k
    public Set f() {
        return M();
    }

    @Override // qf.l, qf.n
    public Collection g(qf.d kindFilter, pd.k nameFilter) {
        kotlin.jvm.internal.t.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.t.f(nameFilter, "nameFilter");
        return (Collection) this.f20318d.invoke();
    }

    public String toString() {
        return "Lazy scope for " + R();
    }

    public abstract Set v(qf.d dVar, pd.k kVar);

    public final List w(qf.d kindFilter, pd.k nameFilter) {
        kotlin.jvm.internal.t.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.t.f(nameFilter, "nameFilter");
        ne.d dVar = ne.d.f17046m;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (kindFilter.a(qf.d.f19046c.c())) {
            for (ef.f fVar : v(kindFilter, nameFilter)) {
                if (((Boolean) nameFilter.invoke(fVar)).booleanValue()) {
                    hg.a.a(linkedHashSet, e(fVar, dVar));
                }
            }
        }
        if (kindFilter.a(qf.d.f19046c.d()) && !kindFilter.l().contains(c.a.f19043a)) {
            for (ef.f fVar2 : x(kindFilter, nameFilter)) {
                if (((Boolean) nameFilter.invoke(fVar2)).booleanValue()) {
                    linkedHashSet.addAll(c(fVar2, dVar));
                }
            }
        }
        if (kindFilter.a(qf.d.f19046c.i()) && !kindFilter.l().contains(c.a.f19043a)) {
            for (ef.f fVar3 : D(kindFilter, nameFilter)) {
                if (((Boolean) nameFilter.invoke(fVar3)).booleanValue()) {
                    linkedHashSet.addAll(a(fVar3, dVar));
                }
            }
        }
        return dd.a0.I0(linkedHashSet);
    }

    public abstract Set x(qf.d dVar, pd.k kVar);

    public void y(Collection result, ef.f name) {
        kotlin.jvm.internal.t.f(result, "result");
        kotlin.jvm.internal.t.f(name, "name");
    }

    public abstract c z();

    public t0(re.k c10, t0 t0Var) {
        kotlin.jvm.internal.t.f(c10, "c");
        this.f20316b = c10;
        this.f20317c = t0Var;
        this.f20318d = c10.e().d(new h0(this), dd.r.k());
        this.f20319e = c10.e().e(new k0(this));
        this.f20320f = c10.e().i(new l0(this));
        this.f20321g = c10.e().h(new m0(this));
        this.f20322h = c10.e().i(new n0(this));
        this.f20323i = c10.e().e(new o0(this));
        this.f20324j = c10.e().e(new p0(this));
        this.f20325k = c10.e().e(new q0(this));
        this.f20326l = c10.e().i(new r0(this));
    }
}
