package zd;

import gf.i;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import qf.n;
import ye.a;
import zd.c1;
import zd.z2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class w0 extends c1 implements wd.d, x0, w2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Class f25866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final cd.k f25867e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class a extends c1.b {

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final /* synthetic */ wd.m[] f25868w = {kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(a.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(a.class, "annotations", "getAnnotations()Ljava/util/List;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(a.class, "simpleName", "getSimpleName()Ljava/lang/String;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(a.class, "qualifiedName", "getQualifiedName()Ljava/lang/String;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(a.class, "constructors", "getConstructors()Ljava/util/Collection;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(a.class, "nestedClasses", "getNestedClasses()Ljava/util/Collection;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(a.class, "typeParameters", "getTypeParameters()Ljava/util/List;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(a.class, "supertypes", "getSupertypes()Ljava/util/List;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(a.class, "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(a.class, "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(a.class, "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(a.class, "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(a.class, "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(a.class, "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(a.class, "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(a.class, "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(a.class, "allMembers", "getAllMembers()Ljava/util/Collection;", 0))};

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final z2.a f25869d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final z2.a f25870e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final z2.a f25871f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final z2.a f25872g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final z2.a f25873h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final z2.a f25874i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final cd.k f25875j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final z2.a f25876k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final z2.a f25877l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final z2.a f25878m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final z2.a f25879n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final z2.a f25880o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final z2.a f25881p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final z2.a f25882q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final z2.a f25883r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final z2.a f25884s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final z2.a f25885t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final z2.a f25886u;

        public a() {
            super();
            this.f25869d = z2.c(new c0(w0.this));
            this.f25870e = z2.c(new n0(this));
            this.f25871f = z2.c(new o0(w0.this, this));
            this.f25872g = z2.c(new p0(w0.this));
            this.f25873h = z2.c(new q0(w0.this));
            this.f25874i = z2.c(new r0(this));
            this.f25875j = cd.l.a(cd.n.f3864b, new s0(this, w0.this));
            this.f25876k = z2.c(new t0(this, w0.this));
            this.f25877l = z2.c(new u0(this, w0.this));
            this.f25878m = z2.c(new v0(this));
            this.f25879n = z2.c(new d0(w0.this));
            this.f25880o = z2.c(new e0(w0.this));
            this.f25881p = z2.c(new f0(w0.this));
            this.f25882q = z2.c(new g0(w0.this));
            this.f25883r = z2.c(new h0(this));
            this.f25884s = z2.c(new i0(this));
            this.f25885t = z2.c(new j0(this));
            this.f25886u = z2.c(new k0(this));
        }

        public static final List A(a aVar) {
            return i3.e(aVar.L());
        }

        public static final List C(w0 w0Var) {
            Collection collectionF = w0Var.F();
            ArrayList arrayList = new ArrayList(dd.s.u(collectionF, 10));
            Iterator it = collectionF.iterator();
            while (it.hasNext()) {
                arrayList.add(new h1(w0Var, (fe.l) it.next()));
            }
            return arrayList;
        }

        public static final List D(a aVar) {
            return dd.a0.s0(aVar.J(), aVar.K());
        }

        public static final Collection E(w0 w0Var) {
            return w0Var.I(w0Var.Z(), c1.d.f25696a);
        }

        public static final Collection F(w0 w0Var) {
            return w0Var.I(w0Var.a0(), c1.d.f25696a);
        }

        public static final fe.e G(w0 w0Var) {
            ef.b bVarW = w0Var.W();
            ke.k kVarB = ((a) w0Var.X().getValue()).b();
            fe.e eVarB = (bVarW.i() && w0Var.e().isAnnotationPresent(Metadata.class)) ? kVarB.a().b(bVarW) : fe.y.b(kVarB.b(), bVarW);
            return eVarB == null ? w0Var.U(bVarW, kVarB) : eVarB;
        }

        public static final Collection Q(w0 w0Var) {
            return w0Var.I(w0Var.Z(), c1.d.f25697b);
        }

        public static final Collection R(w0 w0Var) {
            return w0Var.I(w0Var.a0(), c1.d.f25697b);
        }

        public static final List S(a aVar) {
            Collection collectionA = n.a.a(aVar.L().x0(), null, null, 3, null);
            ArrayList<fe.m> arrayList = new ArrayList();
            for (Object obj : collectionA) {
                if (!jf.i.B((fe.m) obj)) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (fe.m mVar : arrayList) {
                fe.e eVar = mVar instanceof fe.e ? (fe.e) mVar : null;
                Class clsQ = eVar != null ? i3.q(eVar) : null;
                w0 w0Var = clsQ != null ? new w0(clsQ) : null;
                if (w0Var != null) {
                    arrayList2.add(w0Var);
                }
            }
            return arrayList2;
        }

        public static final Object T(a aVar, w0 w0Var) throws IllegalAccessException {
            fe.e eVarL = aVar.L();
            if (eVarL.h() != fe.f.f9478g) {
                return null;
            }
            Object obj = ((!eVarL.y() || ce.e.a(ce.d.f3895a, eVarL)) ? w0Var.e().getDeclaredField("INSTANCE") : w0Var.e().getEnclosingClass().getDeclaredField(eVarL.getName().b())).get(null);
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.KClassImpl");
            return obj;
        }

        public static final String U(w0 w0Var) {
            if (w0Var.e().isAnonymousClass()) {
                return null;
            }
            ef.b bVarW = w0Var.W();
            if (bVarW.i()) {
                return null;
            }
            return bVarW.a().a();
        }

        public static final List V(a aVar) {
            Collection<fe.e> collectionK = aVar.L().K();
            kotlin.jvm.internal.t.e(collectionK, "getSealedSubclasses(...)");
            ArrayList arrayList = new ArrayList();
            for (fe.e eVar : collectionK) {
                kotlin.jvm.internal.t.d(eVar, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                Class clsQ = i3.q(eVar);
                w0 w0Var = clsQ != null ? new w0(clsQ) : null;
                if (w0Var != null) {
                    arrayList.add(w0Var);
                }
            }
            return arrayList;
        }

        public static final String W(w0 w0Var, a aVar) {
            if (w0Var.e().isAnonymousClass()) {
                return null;
            }
            ef.b bVarW = w0Var.W();
            if (bVarW.i()) {
                return aVar.B(w0Var.e());
            }
            String strB = bVarW.h().b();
            kotlin.jvm.internal.t.e(strB, "asString(...)");
            return strB;
        }

        public static final List X(a aVar, w0 w0Var) {
            Collection<xf.r0> collectionC = aVar.L().k().c();
            kotlin.jvm.internal.t.e(collectionC, "getSupertypes(...)");
            ArrayList arrayList = new ArrayList(collectionC.size());
            for (xf.r0 r0Var : collectionC) {
                kotlin.jvm.internal.t.c(r0Var);
                arrayList.add(new t2(r0Var, new l0(r0Var, aVar, w0Var)));
            }
            if (!ce.i.v0(aVar.L())) {
                if (arrayList.isEmpty()) {
                    xf.c1 c1VarI = nf.e.m(aVar.L()).i();
                    kotlin.jvm.internal.t.e(c1VarI, "getAnyType(...)");
                    arrayList.add(new t2(c1VarI, m0.f25782a));
                } else {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        fe.f fVarH = jf.i.e(((t2) it.next()).x()).h();
                        kotlin.jvm.internal.t.e(fVarH, "getKind(...)");
                        if (fVarH != fe.f.f9474c && fVarH != fe.f.f9477f) {
                            break;
                        }
                    }
                    xf.c1 c1VarI2 = nf.e.m(aVar.L()).i();
                    kotlin.jvm.internal.t.e(c1VarI2, "getAnyType(...)");
                    arrayList.add(new t2(c1VarI2, m0.f25782a));
                }
            }
            return hg.a.c(arrayList);
        }

        public static final Type Y(xf.r0 r0Var, a aVar, w0 w0Var) {
            fe.h hVarB = r0Var.N0().b();
            if (!(hVarB instanceof fe.e)) {
                throw new x2("Supertype not a class: " + hVarB);
            }
            Class clsQ = i3.q((fe.e) hVarB);
            if (clsQ == null) {
                throw new x2("Unsupported superclass of " + aVar + ": " + hVarB);
            }
            if (kotlin.jvm.internal.t.b(w0Var.e().getSuperclass(), clsQ)) {
                Type genericSuperclass = w0Var.e().getGenericSuperclass();
                kotlin.jvm.internal.t.c(genericSuperclass);
                return genericSuperclass;
            }
            Class<?>[] interfaces = w0Var.e().getInterfaces();
            kotlin.jvm.internal.t.e(interfaces, "getInterfaces(...)");
            int iM = dd.n.M(interfaces, clsQ);
            if (iM >= 0) {
                Type type = w0Var.e().getGenericInterfaces()[iM];
                kotlin.jvm.internal.t.c(type);
                return type;
            }
            throw new x2("No superclass of " + aVar + " in Java reflection for " + hVarB);
        }

        public static final Type Z() {
            return Object.class;
        }

        public static final List a0(a aVar, w0 w0Var) {
            List<fe.l1> listV = aVar.L().v();
            kotlin.jvm.internal.t.e(listV, "getDeclaredTypeParameters(...)");
            ArrayList arrayList = new ArrayList(dd.s.u(listV, 10));
            for (fe.l1 l1Var : listV) {
                kotlin.jvm.internal.t.c(l1Var);
                arrayList.add(new v2(w0Var, l1Var));
            }
            return arrayList;
        }

        public static final List x(a aVar) {
            return dd.a0.s0(aVar.H(), aVar.I());
        }

        public static final List y(a aVar) {
            return dd.a0.s0(aVar.J(), aVar.M());
        }

        public static final List z(a aVar) {
            return dd.a0.s0(aVar.K(), aVar.N());
        }

        public final String B(Class cls) {
            String simpleName = cls.getSimpleName();
            Method enclosingMethod = cls.getEnclosingMethod();
            if (enclosingMethod != null) {
                kotlin.jvm.internal.t.c(simpleName);
                return kg.c0.P0(simpleName, enclosingMethod.getName() + '$', null, 2, null);
            }
            Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
            if (enclosingConstructor == null) {
                kotlin.jvm.internal.t.c(simpleName);
                return kg.c0.O0(simpleName, '$', null, 2, null);
            }
            kotlin.jvm.internal.t.c(simpleName);
            return kg.c0.P0(simpleName, enclosingConstructor.getName() + '$', null, 2, null);
        }

        public final Collection H() {
            Object objB = this.f25883r.b(this, f25868w[13]);
            kotlin.jvm.internal.t.e(objB, "getValue(...)");
            return (Collection) objB;
        }

        public final Collection I() {
            Object objB = this.f25884s.b(this, f25868w[14]);
            kotlin.jvm.internal.t.e(objB, "getValue(...)");
            return (Collection) objB;
        }

        public final Collection J() {
            Object objB = this.f25879n.b(this, f25868w[9]);
            kotlin.jvm.internal.t.e(objB, "getValue(...)");
            return (Collection) objB;
        }

        public final Collection K() {
            Object objB = this.f25880o.b(this, f25868w[10]);
            kotlin.jvm.internal.t.e(objB, "getValue(...)");
            return (Collection) objB;
        }

        public final fe.e L() {
            Object objB = this.f25869d.b(this, f25868w[0]);
            kotlin.jvm.internal.t.e(objB, "getValue(...)");
            return (fe.e) objB;
        }

        public final Collection M() {
            Object objB = this.f25881p.b(this, f25868w[11]);
            kotlin.jvm.internal.t.e(objB, "getValue(...)");
            return (Collection) objB;
        }

        public final Collection N() {
            Object objB = this.f25882q.b(this, f25868w[12]);
            kotlin.jvm.internal.t.e(objB, "getValue(...)");
            return (Collection) objB;
        }

        public final String O() {
            return (String) this.f25872g.b(this, f25868w[3]);
        }

        public final String P() {
            return (String) this.f25871f.b(this, f25868w[2]);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25888a;

        static {
            int[] iArr = new int[a.EnumC0469a.values().length];
            try {
                iArr[a.EnumC0469a.f25373f.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[a.EnumC0469a.f25375h.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[a.EnumC0469a.f25376i.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[a.EnumC0469a.f25374g.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[a.EnumC0469a.f25371d.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[a.EnumC0469a.f25372e.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f25888a = iArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends qf.f {
        public c(ie.k kVar, wf.n nVar) {
            super(nVar, kVar);
        }

        @Override // qf.f
        public List j() {
            return dd.r.k();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class d extends kotlin.jvm.internal.q implements pd.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f25889a = new d();

        public d() {
            super(2, tf.k0.class, "loadProperty", "loadProperty(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;)Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", 0);
        }

        @Override // pd.o
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public final fe.y0 invoke(tf.k0 p02, ze.n p12) {
            kotlin.jvm.internal.t.f(p02, "p0");
            kotlin.jvm.internal.t.f(p12, "p1");
            return p02.u(p12);
        }
    }

    public w0(Class jClass) {
        kotlin.jvm.internal.t.f(jClass, "jClass");
        this.f25866d = jClass;
        this.f25867e = cd.l.a(cd.n.f3864b, new b0(this));
    }

    public static final a V(w0 w0Var) {
        return w0Var.new a();
    }

    @Override // zd.c1
    public Collection F() {
        fe.e descriptor = getDescriptor();
        if (descriptor.h() == fe.f.f9474c || descriptor.h() == fe.f.f9478g) {
            return dd.r.k();
        }
        Collection collectionM = descriptor.m();
        kotlin.jvm.internal.t.e(collectionM, "getConstructors(...)");
        return collectionM;
    }

    @Override // zd.c1
    public Collection G(ef.f name) {
        kotlin.jvm.internal.t.f(name, "name");
        qf.k kVarZ = Z();
        ne.d dVar = ne.d.f17041h;
        return dd.a0.s0(kVarZ.c(name, dVar), a0().c(name, dVar));
    }

    @Override // zd.c1
    public fe.y0 H(int i10) {
        Class<?> declaringClass;
        if (kotlin.jvm.internal.t.b(e().getSimpleName(), "DefaultImpls") && (declaringClass = e().getDeclaringClass()) != null && declaringClass.isInterface()) {
            wd.d dVarE = od.a.e(declaringClass);
            kotlin.jvm.internal.t.d(dVarE, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
            return ((w0) dVarE).H(i10);
        }
        fe.e descriptor = getDescriptor();
        vf.m mVar = descriptor instanceof vf.m ? (vf.m) descriptor : null;
        if (mVar != null) {
            ze.c cVarE1 = mVar.e1();
            i.f classLocalVariable = cf.a.f4059j;
            kotlin.jvm.internal.t.e(classLocalVariable, "classLocalVariable");
            ze.n nVar = (ze.n) bf.e.b(cVarE1, classLocalVariable, i10);
            if (nVar != null) {
                return (fe.y0) i3.h(e(), nVar, mVar.d1().g(), mVar.d1().j(), mVar.g1(), d.f25889a);
            }
        }
        return null;
    }

    @Override // zd.c1
    public Collection K(ef.f name) {
        kotlin.jvm.internal.t.f(name, "name");
        qf.k kVarZ = Z();
        ne.d dVar = ne.d.f17041h;
        return dd.a0.s0(kVarZ.a(name, dVar), a0().a(name, dVar));
    }

    public final fe.e T(ef.b bVar, ke.k kVar) {
        ie.k kVar2 = new ie.k(new ie.p(kVar.b(), bVar.f()), bVar.h(), fe.e0.f9461b, fe.f.f9473b, dd.q.e(kVar.b().p().h().s()), fe.g1.f9483a, false, kVar.a().u());
        kVar2.K0(new c(kVar2, kVar.a().u()), dd.u0.d(), null);
        return kVar2;
    }

    public final fe.e U(ef.b bVar, ke.k kVar) {
        ye.a aVarB;
        if (e().isSynthetic()) {
            return T(bVar, kVar);
        }
        ke.f fVarA = ke.f.f14831c.a(e());
        a.EnumC0469a enumC0469aC = (fVarA == null || (aVarB = fVarA.b()) == null) ? null : aVarB.c();
        switch (enumC0469aC == null ? -1 : b.f25888a[enumC0469aC.ordinal()]) {
            case -1:
            case 6:
                throw new x2("Unresolved class: " + e() + " (kind = " + enumC0469aC + ')');
            case 0:
            default:
                throw new cd.o();
            case 1:
            case 2:
            case 3:
            case 4:
                return T(bVar, kVar);
            case 5:
                throw new x2("Unknown class: " + e() + " (kind = " + enumC0469aC + ')');
        }
    }

    public final ef.b W() {
        return e3.f25716a.c(e());
    }

    public final cd.k X() {
        return this.f25867e;
    }

    @Override // zd.x0
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public fe.e getDescriptor() {
        return ((a) this.f25867e.getValue()).L();
    }

    public final qf.k Z() {
        return getDescriptor().s().q();
    }

    public final qf.k a0() {
        qf.k kVarT = getDescriptor().T();
        kotlin.jvm.internal.t.e(kVarT, "getStaticScope(...)");
        return kVarT;
    }

    @Override // wd.d
    public String b() {
        return ((a) this.f25867e.getValue()).O();
    }

    @Override // wd.d
    public String c() {
        return ((a) this.f25867e.getValue()).P();
    }

    @Override // kotlin.jvm.internal.h
    public Class e() {
        return this.f25866d;
    }

    public boolean equals(Object obj) {
        return (obj instanceof w0) && kotlin.jvm.internal.t.b(od.a.c(this), od.a.c((wd.d) obj));
    }

    public int hashCode() {
        return od.a.c(this).hashCode();
    }

    @Override // wd.d
    public boolean l(Object obj) {
        Integer numG = le.f.g(e());
        if (numG != null) {
            return kotlin.jvm.internal.t0.g(obj, numG.intValue());
        }
        Class clsK = le.f.k(e());
        if (clsK == null) {
            clsK = e();
        }
        return clsK.isInstance(obj);
    }

    @Override // wd.d
    public boolean n() {
        return getDescriptor().n();
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("class ");
        ef.b bVarW = W();
        ef.c cVarF = bVarW.f();
        if (cVarF.c()) {
            str = "";
        } else {
            str = cVarF.a() + com.amazon.a.a.o.c.a.b.f4610a;
        }
        sb2.append(str + kg.z.E(bVarW.g().a(), com.amazon.a.a.o.c.a.b.f4610a, '$', false, 4, null));
        return sb2.toString();
    }
}
