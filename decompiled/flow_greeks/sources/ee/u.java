package ee;

import dd.a0;
import dd.u0;
import ee.k;
import fe.b;
import fe.e0;
import fe.f1;
import fe.g1;
import fe.h0;
import fe.s1;
import fe.z;
import hg.b;
import hg.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import jf.o;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m0;
import kotlin.jvm.internal.n0;
import qf.k;
import tf.l0;
import xe.b0;
import xe.c0;
import xe.f0;
import xf.c1;
import xf.f2;
import xf.r0;
import xf.x0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class u implements he.a, he.c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ wd.m[] f8741i = {n0.g(new g0(u.class, "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;", 0)), n0.g(new g0(u.class, "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;", 0)), n0.g(new g0(u.class, "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h0 f8742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ee.d f8743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final wf.i f8744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r0 f8745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final wf.i f8746e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final wf.a f8747f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final wf.i f8748g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final wf.g f8749h;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8750a = new a("HIDDEN", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f8751b = new a("VISIBLE", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f8752c = new a("DEPRECATED_LIST_METHODS", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f8753d = new a("NOT_CONSIDERED", 3);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f8754e = new a("DROP", 4);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ a[] f8755f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ jd.a f8756g;

        static {
            a[] aVarArrA = a();
            f8755f = aVarArrA;
            f8756g = jd.b.a(aVarArrA);
        }

        public a(String str, int i10) {
        }

        public static final /* synthetic */ a[] a() {
            return new a[]{f8750a, f8751b, f8752c, f8753d, f8754e};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f8755f.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8757a;

        static {
            int[] iArr = new int[a.values().length];
            try {
                iArr[a.f8750a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[a.f8752c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[a.f8753d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[a.f8754e.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[a.f8751b.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f8757a = iArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends ie.h0 {
        public c(h0 h0Var, ef.c cVar) {
            super(h0Var, cVar);
        }

        @Override // fe.n0
        /* JADX INFO: renamed from: F0, reason: merged with bridge method [inline-methods] */
        public k.b q() {
            return k.b.f19087b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends b.AbstractC0212b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f8758a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ m0 f8759b;

        public d(String str, m0 m0Var) {
            this.f8758a = str;
            this.f8759b = m0Var;
        }

        @Override // hg.b.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean c(fe.e javaClassDescriptor) {
            kotlin.jvm.internal.t.f(javaClassDescriptor, "javaClassDescriptor");
            String strA = b0.a(f0.f24840a, javaClassDescriptor, this.f8758a);
            x xVar = x.f8763a;
            if (xVar.f().contains(strA)) {
                this.f8759b.f14947a = a.f8750a;
            } else if (xVar.i().contains(strA)) {
                this.f8759b.f14947a = a.f8751b;
            } else if (xVar.c().contains(strA)) {
                this.f8759b.f14947a = a.f8752c;
            } else if (xVar.d().contains(strA)) {
                this.f8759b.f14947a = a.f8754e;
            }
            return this.f8759b.f14947a == null;
        }

        @Override // hg.b.d
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public a a() {
            a aVar = (a) this.f8759b.f14947a;
            return aVar == null ? a.f8753d : aVar;
        }
    }

    public u(h0 moduleDescriptor, wf.n storageManager, Function0 settingsComputation) {
        kotlin.jvm.internal.t.f(moduleDescriptor, "moduleDescriptor");
        kotlin.jvm.internal.t.f(storageManager, "storageManager");
        kotlin.jvm.internal.t.f(settingsComputation, "settingsComputation");
        this.f8742a = moduleDescriptor;
        this.f8743b = ee.d.f8701a;
        this.f8744c = storageManager.e(settingsComputation);
        this.f8745d = q(storageManager);
        this.f8746e = storageManager.e(new l(this, storageManager));
        this.f8747f = storageManager.c();
        this.f8748g = storageManager.e(new m(this));
        this.f8749h = storageManager.i(new n(this));
    }

    public static final Iterable B(u uVar, fe.e eVar) {
        Collection collectionC = eVar.k().c();
        kotlin.jvm.internal.t.e(collectionC, "getSupertypes(...)");
        ArrayList arrayList = new ArrayList();
        Iterator it = collectionC.iterator();
        while (it.hasNext()) {
            fe.h hVarB = ((r0) it.next()).N0().b();
            fe.e eVarZ = null;
            fe.h hVarA = hVarB != null ? hVarB.a() : null;
            fe.e eVar2 = hVarA instanceof fe.e ? (fe.e) hVarA : null;
            if (eVar2 != null && (eVarZ = uVar.z(eVar2)) == null) {
                eVarZ = eVar2;
            }
            if (eVarZ != null) {
                arrayList.add(eVarZ);
            }
        }
        return arrayList;
    }

    public static final Iterable F(fe.b bVar) {
        return bVar.a().f();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Boolean G(ee.u r2, fe.b r3) {
        /*
            fe.b$a r0 = r3.h()
            fe.b$a r1 = fe.b.a.DECLARATION
            if (r0 != r1) goto L1d
            ee.d r2 = r2.f8743b
            fe.m r3 = r3.b()
            java.lang.String r0 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor"
            kotlin.jvm.internal.t.d(r3, r0)
            fe.e r3 = (fe.e) r3
            boolean r2 = r2.c(r3)
            if (r2 == 0) goto L1d
            r2 = 1
            goto L1e
        L1d:
            r2 = 0
        L1e:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.u.G(ee.u, fe.b):java.lang.Boolean");
    }

    public static final ge.h I(u uVar) {
        return ge.h.L.a(dd.q.e(ge.g.c(uVar.f8742a.p(), "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version", null, null, true, 6, null)));
    }

    public static final c1 o(u uVar, wf.n nVar) {
        return fe.y.d(uVar.D().a(), g.f8705d.a(), new fe.m0(nVar, uVar.D().a())).s();
    }

    public static final r0 r(u uVar) {
        c1 c1VarI = uVar.f8742a.p().i();
        kotlin.jvm.internal.t.e(c1VarI, "getAnyType(...)");
        return c1VarI;
    }

    public static final ge.h s(u uVar, cd.q qVar) {
        kotlin.jvm.internal.t.f(qVar, "<destruct>");
        String str = (String) qVar.a();
        String str2 = (String) qVar.b();
        return ge.h.L.a(dd.q.e(ge.g.b(uVar.f8742a.p(), '\'' + str + "()' member of List is redundant in Kotlin and might be removed soon. Please use '" + str2 + "()' stdlib extension instead", str2 + "()", "HIDDEN", false)));
    }

    public static final fe.e u(se.n nVar, fe.e eVar) {
        pe.j EMPTY = pe.j.f18605a;
        kotlin.jvm.internal.t.e(EMPTY, "EMPTY");
        return nVar.P0(EMPTY, eVar);
    }

    public static final boolean w(fe.l lVar, f2 f2Var, fe.l lVar2) {
        return jf.o.x(lVar, lVar2.c(f2Var)) == o.i.a.OVERRIDABLE;
    }

    public static final Collection x(ef.f fVar, qf.k it) {
        kotlin.jvm.internal.t.f(it, "it");
        return it.c(fVar, ne.d.f17037d);
    }

    public final a A(z zVar) {
        fe.m mVarB = zVar.b();
        kotlin.jvm.internal.t.d(mVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        Object objB = hg.b.b(dd.q.e((fe.e) mVarB), new t(this), new d(c0.c(zVar, false, false, 3, null), new m0()));
        kotlin.jvm.internal.t.e(objB, "dfs(...)");
        return (a) objB;
    }

    public final ge.h C() {
        return (ge.h) wf.m.a(this.f8748g, this, f8741i[2]);
    }

    public final k.b D() {
        return (k.b) wf.m.a(this.f8744c, this, f8741i[0]);
    }

    public final boolean E(f1 f1Var, boolean z10) {
        fe.m mVarB = f1Var.b();
        kotlin.jvm.internal.t.d(mVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        String strC = c0.c(f1Var, false, false, 3, null);
        if (z10 ^ x.f8763a.g().contains(b0.a(f0.f24840a, (fe.e) mVarB, strC))) {
            return true;
        }
        Boolean boolE = hg.b.e(dd.q.e(f1Var), r.f8738a, new s(this));
        kotlin.jvm.internal.t.e(boolE, "ifAny(...)");
        return boolE.booleanValue();
    }

    public final boolean H(fe.l lVar, fe.e eVar) {
        if (lVar.i().size() != 1) {
            return false;
        }
        List listI = lVar.i();
        kotlin.jvm.internal.t.e(listI, "getValueParameters(...)");
        fe.h hVarB = ((s1) a0.v0(listI)).getType().N0().b();
        return kotlin.jvm.internal.t.b(hVarB != null ? nf.e.p(hVarB) : null, nf.e.p(eVar));
    }

    @Override // he.c
    public boolean a(fe.e classDescriptor, f1 functionDescriptor) {
        kotlin.jvm.internal.t.f(classDescriptor, "classDescriptor");
        kotlin.jvm.internal.t.f(functionDescriptor, "functionDescriptor");
        se.n nVarZ = z(classDescriptor);
        if (nVarZ == null || !functionDescriptor.getAnnotations().E(he.d.a())) {
            return true;
        }
        if (!D().b()) {
            return false;
        }
        String strC = c0.c(functionDescriptor, false, false, 3, null);
        se.z zVarU0 = nVarZ.D0();
        ef.f name = functionDescriptor.getName();
        kotlin.jvm.internal.t.e(name, "getName(...)");
        Collection collectionC = zVarU0.c(name, ne.d.f17037d);
        if (collectionC != null && collectionC.isEmpty()) {
            return false;
        }
        Iterator it = collectionC.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.t.b(c0.c((f1) it.next(), false, false, 3, null), strC)) {
                return true;
            }
        }
        return false;
    }

    @Override // he.a
    public Collection b(fe.e classDescriptor) {
        kotlin.jvm.internal.t.f(classDescriptor, "classDescriptor");
        if (classDescriptor.h() != fe.f.f9473b || !D().b()) {
            return dd.r.k();
        }
        se.n nVarZ = z(classDescriptor);
        if (nVarZ == null) {
            return dd.r.k();
        }
        fe.e eVarF = ee.d.f(this.f8743b, nf.e.o(nVarZ), ee.b.f8679h.a(), null, 4, null);
        if (eVarF == null) {
            return dd.r.k();
        }
        f2 f2VarC = y.a(eVarF, nVarZ).c();
        List listR0 = nVarZ.m();
        ArrayList<fe.d> arrayList = new ArrayList();
        for (Object obj : listR0) {
            fe.d dVar = (fe.d) obj;
            if (dVar.getVisibility().d()) {
                Collection<fe.d> collectionM = eVarF.m();
                kotlin.jvm.internal.t.e(collectionM, "getConstructors(...)");
                if (collectionM == null || !collectionM.isEmpty()) {
                    for (fe.d dVar2 : collectionM) {
                        kotlin.jvm.internal.t.c(dVar2);
                        if (w(dVar2, f2VarC, dVar)) {
                            break;
                        }
                    }
                }
                if (!H(dVar, classDescriptor) && !ce.i.l0(dVar) && !x.f8763a.e().contains(b0.a(f0.f24840a, nVarZ, c0.c(dVar, false, false, 3, null)))) {
                    arrayList.add(obj);
                }
            }
        }
        ArrayList arrayList2 = new ArrayList(dd.s.u(arrayList, 10));
        for (fe.d dVar3 : arrayList) {
            z.a aVarU = dVar3.u();
            aVarU.p(classDescriptor);
            aVarU.g(classDescriptor.s());
            aVarU.e();
            aVarU.k(f2VarC.j());
            if (!x.f8763a.h().contains(b0.a(f0.f24840a, nVarZ, c0.c(dVar3, false, false, 3, null)))) {
                aVarU.n(C());
            }
            z zVarBuild = aVarU.build();
            kotlin.jvm.internal.t.d(zVarBuild, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
            arrayList2.add((fe.d) zVarBuild);
        }
        return arrayList2;
    }

    @Override // he.a
    public Collection d(ef.f name, fe.e classDescriptor) {
        ge.h hVar;
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(classDescriptor, "classDescriptor");
        if (kotlin.jvm.internal.t.b(name, ee.a.f8677e.a()) && (classDescriptor instanceof vf.m) && ce.i.e0(classDescriptor)) {
            vf.m mVar = (vf.m) classDescriptor;
            List listH0 = mVar.e1().H0();
            kotlin.jvm.internal.t.e(listH0, "getFunctionList(...)");
            if (listH0 == null || !listH0.isEmpty()) {
                Iterator it = listH0.iterator();
                while (it.hasNext()) {
                    if (kotlin.jvm.internal.t.b(l0.b(mVar.d1().g(), ((ze.i) it.next()).d0()), ee.a.f8677e.a())) {
                        return dd.r.k();
                    }
                }
            }
            return dd.q.e(p(mVar, (f1) a0.u0(v().q().c(name, ne.d.f17037d))));
        }
        if (!D().b()) {
            return dd.r.k();
        }
        Collection<f1> collectionT = t(classDescriptor, new p(name));
        ArrayList arrayList = new ArrayList();
        for (f1 f1Var : collectionT) {
            fe.m mVarB = f1Var.b();
            kotlin.jvm.internal.t.d(mVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            z zVarC = f1Var.c(y.a((fe.e) mVarB, classDescriptor).c());
            kotlin.jvm.internal.t.d(zVarC, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor");
            z.a aVarU = ((f1) zVarC).u();
            aVarU.p(classDescriptor);
            aVarU.f(classDescriptor.J0());
            aVarU.e();
            int i10 = b.f8757a[A(f1Var).ordinal()];
            f1 f1Var2 = null;
            if (i10 != 1) {
                if (i10 == 2) {
                    ef.f name2 = f1Var.getName();
                    if (kotlin.jvm.internal.t.b(name2, v.f8760a)) {
                        hVar = (ge.h) this.f8749h.invoke(cd.w.a(f1Var.getName().b(), "first"));
                    } else {
                        if (!kotlin.jvm.internal.t.b(name2, v.f8761b)) {
                            throw new IllegalStateException(("Unexpected name: " + f1Var.getName()).toString());
                        }
                        hVar = (ge.h) this.f8749h.invoke(cd.w.a(f1Var.getName().b(), "last"));
                    }
                    aVarU.n(hVar);
                } else if (i10 == 3) {
                    aVarU.n(C());
                } else if (i10 != 4) {
                    if (i10 != 5) {
                        throw new cd.o();
                    }
                    cd.h0 h0Var = cd.h0.f3852a;
                }
                z zVarBuild = aVarU.build();
                kotlin.jvm.internal.t.c(zVarBuild);
                f1Var2 = (f1) zVarBuild;
            } else if (!fe.f0.a(classDescriptor)) {
                aVarU.h();
                z zVarBuild2 = aVarU.build();
                kotlin.jvm.internal.t.c(zVarBuild2);
                f1Var2 = (f1) zVarBuild2;
            }
            if (f1Var2 != null) {
                arrayList.add(f1Var2);
            }
        }
        return arrayList;
    }

    @Override // he.a
    public Collection e(fe.e classDescriptor) {
        kotlin.jvm.internal.t.f(classDescriptor, "classDescriptor");
        ef.d dVarP = nf.e.p(classDescriptor);
        x xVar = x.f8763a;
        return xVar.j(dVarP) ? dd.r.n(v(), this.f8745d) : xVar.k(dVarP) ? dd.q.e(this.f8745d) : dd.r.k();
    }

    public final f1 p(vf.m mVar, f1 f1Var) {
        z.a aVarU = f1Var.u();
        aVarU.p(mVar);
        aVarU.d(fe.t.f9511e);
        aVarU.g(mVar.s());
        aVarU.f(mVar.J0());
        z zVarBuild = aVarU.build();
        kotlin.jvm.internal.t.c(zVarBuild);
        return (f1) zVarBuild;
    }

    public final r0 q(wf.n nVar) {
        ie.k kVar = new ie.k(new c(this.f8742a, new ef.c("java.io")), ef.f.k("Serializable"), e0.f9464e, fe.f.f9474c, dd.q.e(new x0(nVar, new o(this))), g1.f9483a, false, nVar);
        kVar.K0(k.b.f19087b, u0.d(), null);
        c1 c1VarS = kVar.s();
        kotlin.jvm.internal.t.e(c1VarS, "getDefaultType(...)");
        return c1VarS;
    }

    public final Collection t(fe.e eVar, pd.k kVar) {
        se.n nVarZ = z(eVar);
        if (nVarZ == null) {
            return dd.r.k();
        }
        Collection collectionG = this.f8743b.g(nf.e.o(nVarZ), ee.b.f8679h.a());
        fe.e eVar2 = (fe.e) a0.l0(collectionG);
        if (eVar2 == null) {
            return dd.r.k();
        }
        l.b bVar = hg.l.f11443c;
        ArrayList arrayList = new ArrayList(dd.s.u(collectionG, 10));
        Iterator it = collectionG.iterator();
        while (it.hasNext()) {
            arrayList.add(nf.e.o((fe.e) it.next()));
        }
        hg.l lVarB = bVar.b(arrayList);
        boolean zC = this.f8743b.c(eVar);
        qf.k kVarD0 = ((fe.e) this.f8747f.a(nf.e.o(nVarZ), new q(nVarZ, eVar2))).D0();
        kotlin.jvm.internal.t.e(kVarD0, "getUnsubstitutedMemberScope(...)");
        Iterable iterable = (Iterable) kVar.invoke(kVarD0);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : iterable) {
            f1 f1Var = (f1) obj;
            if (f1Var.h() == b.a.DECLARATION && f1Var.getVisibility().d() && !ce.i.l0(f1Var)) {
                Collection collectionF = f1Var.f();
                kotlin.jvm.internal.t.e(collectionF, "getOverriddenDescriptors(...)");
                if (collectionF == null || !collectionF.isEmpty()) {
                    Iterator it2 = collectionF.iterator();
                    while (it2.hasNext()) {
                        fe.m mVarB = ((z) it2.next()).b();
                        kotlin.jvm.internal.t.e(mVarB, "getContainingDeclaration(...)");
                        if (lVarB.contains(nf.e.o(mVarB))) {
                            break;
                        }
                    }
                }
                if (!E(f1Var, zC)) {
                    arrayList2.add(obj);
                }
            }
        }
        return arrayList2;
    }

    public final c1 v() {
        return (c1) wf.m.a(this.f8746e, this, f8741i[1]);
    }

    @Override // he.a
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public Set c(fe.e classDescriptor) {
        se.z zVarU0;
        Set setB;
        kotlin.jvm.internal.t.f(classDescriptor, "classDescriptor");
        if (!D().b()) {
            return u0.d();
        }
        se.n nVarZ = z(classDescriptor);
        return (nVarZ == null || (zVarU0 = nVarZ.D0()) == null || (setB = zVarU0.b()) == null) ? u0.d() : setB;
    }

    public final se.n z(fe.e eVar) {
        ef.b bVarN;
        ef.c cVarA;
        if (ce.i.b0(eVar) || !ce.i.C0(eVar)) {
            return null;
        }
        ef.d dVarP = nf.e.p(eVar);
        if (dVarP.f() && (bVarN = ee.c.f8681a.n(dVarP)) != null && (cVarA = bVarN.a()) != null) {
            fe.e eVarD = fe.s.d(D().a(), cVarA, ne.d.f17037d);
            if (eVarD instanceof se.n) {
                return (se.n) eVarD;
            }
        }
        return null;
    }
}
