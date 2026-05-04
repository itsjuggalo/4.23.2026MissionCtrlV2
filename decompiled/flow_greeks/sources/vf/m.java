package vf;

import bf.h;
import dd.v0;
import fe.e1;
import fe.f1;
import fe.g1;
import fe.j1;
import fe.m0;
import fe.p1;
import fe.q1;
import fe.s1;
import fe.y0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import qf.k;
import qf.n;
import tf.n0;
import tf.w0;
import xf.c1;
import xf.u1;
import ze.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends ie.a implements fe.m {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ze.c f23437f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final bf.a f23438g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final g1 f23439h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ef.b f23440i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final fe.e0 f23441j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final fe.u f23442k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final fe.f f23443l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final tf.p f23444m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f23445n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final qf.l f23446o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final b f23447p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final e1 f23448q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final c f23449r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final fe.m f23450s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final wf.j f23451t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final wf.i f23452u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final wf.j f23453v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final wf.i f23454w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final wf.j f23455x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final n0.a f23456y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ge.h f23457z;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class b extends xf.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final wf.i f23463d;

        public b() {
            super(m.this.d1().h());
            this.f23463d = m.this.d1().h().e(new n(m.this));
        }

        public static final List L(m mVar) {
            return p1.g(mVar);
        }

        @Override // xf.v, xf.u1
        /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public m b() {
            return m.this;
        }

        @Override // xf.u1
        public boolean d() {
            return true;
        }

        @Override // xf.u1
        public List getParameters() {
            return (List) this.f23463d.invoke();
        }

        @Override // xf.p
        public Collection r() {
            String strB;
            ef.c cVarA;
            List listO = bf.f.o(m.this.e1(), m.this.d1().j());
            m mVar = m.this;
            ArrayList arrayList = new ArrayList(dd.s.u(listO, 10));
            Iterator it = listO.iterator();
            while (it.hasNext()) {
                arrayList.add(mVar.d1().i().u((ze.q) it.next()));
            }
            List listS0 = dd.a0.s0(arrayList, m.this.d1().c().c().e(m.this));
            ArrayList<m0.b> arrayList2 = new ArrayList();
            Iterator it2 = listS0.iterator();
            while (it2.hasNext()) {
                fe.h hVarB = ((xf.r0) it2.next()).N0().b();
                m0.b bVar = hVarB instanceof m0.b ? (m0.b) hVarB : null;
                if (bVar != null) {
                    arrayList2.add(bVar);
                }
            }
            if (!arrayList2.isEmpty()) {
                tf.w wVarJ = m.this.d1().c().j();
                m mVar2 = m.this;
                ArrayList arrayList3 = new ArrayList(dd.s.u(arrayList2, 10));
                for (m0.b bVar2 : arrayList2) {
                    ef.b bVarN = nf.e.n(bVar2);
                    if (bVarN == null || (cVarA = bVarN.a()) == null || (strB = cVarA.a()) == null) {
                        strB = bVar2.getName().b();
                        kotlin.jvm.internal.t.e(strB, "asString(...)");
                    }
                    arrayList3.add(strB);
                }
                wVarJ.b(mVar2, arrayList3);
            }
            return dd.a0.I0(listS0);
        }

        public String toString() {
            String string = m.this.getName().toString();
            kotlin.jvm.internal.t.e(string, "toString(...)");
            return string;
        }

        @Override // xf.p
        public j1 v() {
            return j1.a.f9488a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map f23465a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final wf.h f23466b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final wf.i f23467c;

        public c() {
            List listC0 = m.this.e1().C0();
            kotlin.jvm.internal.t.e(listC0, "getEnumEntryList(...)");
            LinkedHashMap linkedHashMap = new LinkedHashMap(vd.l.b(dd.n0.d(dd.s.u(listC0, 10)), 16));
            for (Object obj : listC0) {
                linkedHashMap.put(tf.l0.b(m.this.d1().g(), ((ze.g) obj).F()), obj);
            }
            this.f23465a = linkedHashMap;
            this.f23466b = m.this.d1().h().h(new o(this, m.this));
            this.f23467c = m.this.d1().h().e(new p(this));
        }

        public static final fe.e f(c cVar, m mVar, ef.f name) {
            kotlin.jvm.internal.t.f(name, "name");
            ze.g gVar = (ze.g) cVar.f23465a.get(name);
            if (gVar != null) {
                return ie.q.L0(mVar.d1().h(), mVar, name, cVar.f23467c, new vf.a(mVar.d1().h(), new q(mVar, gVar)), g1.f9483a);
            }
            return null;
        }

        public static final List g(m mVar, ze.g gVar) {
            return dd.a0.I0(mVar.d1().c().d().c(mVar.i1(), gVar));
        }

        public static final Set h(c cVar) {
            return cVar.e();
        }

        public final Collection d() {
            Set setKeySet = this.f23465a.keySet();
            ArrayList arrayList = new ArrayList();
            Iterator it = setKeySet.iterator();
            while (it.hasNext()) {
                fe.e eVarI = i((ef.f) it.next());
                if (eVarI != null) {
                    arrayList.add(eVarI);
                }
            }
            return arrayList;
        }

        public final Set e() {
            HashSet hashSet = new HashSet();
            Iterator it = m.this.k().c().iterator();
            while (it.hasNext()) {
                for (fe.m mVar : n.a.a(((xf.r0) it.next()).q(), null, null, 3, null)) {
                    if ((mVar instanceof f1) || (mVar instanceof y0)) {
                        hashSet.add(((fe.b) mVar).getName());
                    }
                }
            }
            List listH0 = m.this.e1().H0();
            kotlin.jvm.internal.t.e(listH0, "getFunctionList(...)");
            m mVar2 = m.this;
            Iterator it2 = listH0.iterator();
            while (it2.hasNext()) {
                hashSet.add(tf.l0.b(mVar2.d1().g(), ((ze.i) it2.next()).d0()));
            }
            List listV0 = m.this.e1().V0();
            kotlin.jvm.internal.t.e(listV0, "getPropertyList(...)");
            m mVar3 = m.this;
            Iterator it3 = listV0.iterator();
            while (it3.hasNext()) {
                hashSet.add(tf.l0.b(mVar3.d1().g(), ((ze.n) it3.next()).c0()));
            }
            return v0.l(hashSet, hashSet);
        }

        public final fe.e i(ef.f name) {
            kotlin.jvm.internal.t.f(name, "name");
            return (fe.e) this.f23466b.invoke(name);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class d extends kotlin.jvm.internal.a implements pd.k {
        public d(Object obj) {
            super(1, obj, w0.class, "simpleType", "simpleType(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Type;Z)Lorg/jetbrains/kotlin/types/SimpleType;", 0);
        }

        @Override // pd.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c1 invoke(ze.q p02) {
            kotlin.jvm.internal.t.f(p02, "p0");
            return w0.q((w0) this.f14923a, p02, false, 2, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class e extends kotlin.jvm.internal.q implements pd.k {
        public e(Object obj) {
            super(1, obj, m.class, "getValueClassPropertyType", "getValueClassPropertyType(Lorg/jetbrains/kotlin/name/Name;)Lorg/jetbrains/kotlin/types/SimpleType;", 0);
        }

        @Override // pd.k
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public final c1 invoke(ef.f p02) {
            kotlin.jvm.internal.t.f(p02, "p0");
            return ((m) this.receiver).j1(p02);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class f extends kotlin.jvm.internal.q implements pd.k {
        public f(Object obj) {
            super(1, obj, a.class, "<init>", "<init>(Lorg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor;Lorg/jetbrains/kotlin/types/checker/KotlinTypeRefiner;)V", 0);
        }

        @Override // pd.k
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public final a invoke(yf.g p02) {
            kotlin.jvm.internal.t.f(p02, "p0");
            return new a((m) this.receiver, p02);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(tf.p outerContext, ze.c classProto, bf.c nameResolver, bf.a metadataVersion, g1 sourceElement) {
        qf.l qVar;
        super(outerContext.h(), tf.l0.a(nameResolver, classProto.E0()).h());
        kotlin.jvm.internal.t.f(outerContext, "outerContext");
        kotlin.jvm.internal.t.f(classProto, "classProto");
        kotlin.jvm.internal.t.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.t.f(metadataVersion, "metadataVersion");
        kotlin.jvm.internal.t.f(sourceElement, "sourceElement");
        this.f23437f = classProto;
        this.f23438g = metadataVersion;
        this.f23439h = sourceElement;
        this.f23440i = tf.l0.a(nameResolver, classProto.E0());
        tf.o0 o0Var = tf.o0.f22025a;
        this.f23441j = o0Var.b((ze.k) bf.b.f3319e.d(classProto.D0()));
        this.f23442k = tf.p0.a(o0Var, (ze.x) bf.b.f3318d.d(classProto.D0()));
        fe.f fVarA = o0Var.a((c.EnumC0494c) bf.b.f3320f.d(classProto.D0()));
        this.f23443l = fVarA;
        List listG1 = classProto.g1();
        kotlin.jvm.internal.t.e(listG1, "getTypeParameterList(...)");
        ze.t tVarH1 = classProto.h1();
        kotlin.jvm.internal.t.e(tVarH1, "getTypeTable(...)");
        bf.g gVar = new bf.g(tVarH1);
        h.a aVar = bf.h.f3348b;
        ze.w wVarJ1 = classProto.j1();
        kotlin.jvm.internal.t.e(wVarJ1, "getVersionRequirementTable(...)");
        tf.p pVarA = outerContext.a(this, listG1, nameResolver, gVar, aVar.a(wVarJ1), metadataVersion);
        this.f23444m = pVarA;
        Boolean boolD = bf.b.f3327m.d(classProto.D0());
        kotlin.jvm.internal.t.e(boolD, "get(...)");
        boolean zBooleanValue = boolD.booleanValue();
        this.f23445n = zBooleanValue;
        fe.f fVar = fe.f.f9475d;
        if (fVarA == fVar) {
            qVar = new qf.q(pVarA.h(), this, zBooleanValue || kotlin.jvm.internal.t.b(pVarA.c().i().a(), Boolean.TRUE));
        } else {
            qVar = k.b.f19087b;
        }
        this.f23446o = qVar;
        this.f23447p = new b();
        this.f23448q = e1.f9467e.a(this, pVarA.h(), pVarA.c().n().d(), new f(this));
        this.f23449r = fVarA == fVar ? new c() : null;
        fe.m mVarE = outerContext.e();
        this.f23450s = mVarE;
        this.f23451t = pVarA.h().g(new vf.d(this));
        this.f23452u = pVarA.h().e(new vf.e(this));
        this.f23453v = pVarA.h().g(new vf.f(this));
        this.f23454w = pVarA.h().e(new g(this));
        this.f23455x = pVarA.h().g(new h(this));
        bf.c cVarG = pVarA.g();
        bf.g gVarJ = pVarA.j();
        m mVar = mVarE instanceof m ? (m) mVarE : null;
        this.f23456y = new n0.a(classProto, cVarG, gVarJ, sourceElement, mVar != null ? mVar.f23456y : null);
        this.f23457z = !bf.b.f3317c.d(classProto.D0()).booleanValue() ? ge.h.L.b() : new s0(pVarA.h(), new i(this));
    }

    public static final List U0(m mVar) {
        return dd.a0.I0(mVar.f23444m.c().d().e(mVar.f23456y));
    }

    public static final fe.e V0(m mVar) {
        return mVar.W0();
    }

    public static final Collection c1(m mVar) {
        return mVar.X0();
    }

    public static final fe.d l1(m mVar) {
        return mVar.Y0();
    }

    public static final Collection m1(m mVar) {
        return mVar.a1();
    }

    public static final q1 n1(m mVar) {
        return mVar.b1();
    }

    @Override // fe.e
    public boolean E() {
        Boolean boolD = bf.b.f3326l.d(this.f23437f.D0());
        kotlin.jvm.internal.t.e(boolD, "get(...)");
        return boolD.booleanValue();
    }

    @Override // fe.d0
    public boolean E0() {
        return false;
    }

    @Override // ie.a, fe.e
    public List G0() {
        List listB = bf.f.b(this.f23437f, this.f23444m.j());
        ArrayList arrayList = new ArrayList(dd.s.u(listB, 10));
        Iterator it = listB.iterator();
        while (it.hasNext()) {
            arrayList.add(new ie.n0(J0(), new rf.b(this, this.f23444m.i().u((ze.q) it.next()), null, null), ge.h.L.b()));
        }
        return arrayList;
    }

    @Override // fe.e
    public boolean H0() {
        Boolean boolD = bf.b.f3322h.d(this.f23437f.D0());
        kotlin.jvm.internal.t.e(boolD, "get(...)");
        return boolD.booleanValue();
    }

    @Override // ie.z
    public qf.k I(yf.g kotlinTypeRefiner) {
        kotlin.jvm.internal.t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.f23448q.c(kotlinTypeRefiner);
    }

    @Override // fe.e
    public Collection K() {
        return (Collection) this.f23454w.invoke();
    }

    @Override // fe.d0
    public boolean N() {
        Boolean boolD = bf.b.f3324j.d(this.f23437f.D0());
        kotlin.jvm.internal.t.e(boolD, "get(...)");
        return boolD.booleanValue();
    }

    @Override // fe.i
    public boolean P() {
        Boolean boolD = bf.b.f3321g.d(this.f23437f.D0());
        kotlin.jvm.internal.t.e(boolD, "get(...)");
        return boolD.booleanValue();
    }

    @Override // fe.e
    public fe.d S() {
        return (fe.d) this.f23451t.invoke();
    }

    @Override // fe.e
    public fe.e V() {
        return (fe.e) this.f23453v.invoke();
    }

    public final fe.e W0() {
        if (!this.f23437f.k1()) {
            return null;
        }
        fe.h hVarE = f1().e(tf.l0.b(this.f23444m.g(), this.f23437f.q0()), ne.d.f17051r);
        if (hVarE instanceof fe.e) {
            return (fe.e) hVarE;
        }
        return null;
    }

    public final Collection X0() {
        return dd.a0.s0(dd.a0.s0(Z0(), dd.r.o(S())), this.f23444m.c().c().b(this));
    }

    public final fe.d Y0() {
        Object next;
        if (this.f23443l.b()) {
            ie.i iVarL = jf.h.l(this, g1.f9483a);
            iVarL.g1(s());
            return iVarL;
        }
        List listT0 = this.f23437f.t0();
        kotlin.jvm.internal.t.e(listT0, "getConstructorList(...)");
        Iterator it = listT0.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!bf.b.f3328n.d(((ze.d) next).J()).booleanValue()) {
                break;
            }
        }
        ze.d dVar = (ze.d) next;
        if (dVar != null) {
            return this.f23444m.f().r(dVar, true);
        }
        return null;
    }

    public final List Z0() {
        List listT0 = this.f23437f.t0();
        kotlin.jvm.internal.t.e(listT0, "getConstructorList(...)");
        ArrayList<ze.d> arrayList = new ArrayList();
        for (Object obj : listT0) {
            Boolean boolD = bf.b.f3328n.d(((ze.d) obj).J());
            kotlin.jvm.internal.t.e(boolD, "get(...)");
            if (boolD.booleanValue()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(dd.s.u(arrayList, 10));
        for (ze.d dVar : arrayList) {
            tf.k0 k0VarF = this.f23444m.f();
            kotlin.jvm.internal.t.c(dVar);
            arrayList2.add(k0VarF.r(dVar, false));
        }
        return arrayList2;
    }

    public final Collection a1() {
        if (this.f23441j != fe.e0.f9462c) {
            return dd.r.k();
        }
        List<Integer> listW0 = this.f23437f.W0();
        kotlin.jvm.internal.t.c(listW0);
        if (listW0.isEmpty()) {
            return jf.a.f14314a.a(this, false);
        }
        ArrayList arrayList = new ArrayList();
        for (Integer num : listW0) {
            tf.n nVarC = this.f23444m.c();
            bf.c cVarG = this.f23444m.g();
            kotlin.jvm.internal.t.c(num);
            fe.e eVarB = nVarC.b(tf.l0.a(cVarG, num.intValue()));
            if (eVarB != null) {
                arrayList.add(eVarB);
            }
        }
        return arrayList;
    }

    @Override // fe.e, fe.n, fe.m
    public fe.m b() {
        return this.f23450s;
    }

    public final q1 b1() {
        if (!isInline() && !n()) {
            return null;
        }
        q1 q1VarA = tf.y0.a(this.f23437f, this.f23444m.g(), this.f23444m.j(), new d(this.f23444m.i()), new e(this));
        if (q1VarA != null) {
            return q1VarA;
        }
        if (this.f23438g.c(1, 5, 1)) {
            return null;
        }
        fe.d dVarS = S();
        if (dVarS == null) {
            throw new IllegalStateException(("Inline class has no primary constructor: " + this).toString());
        }
        List listI = dVarS.i();
        kotlin.jvm.internal.t.e(listI, "getValueParameters(...)");
        ef.f name = ((s1) dd.a0.Z(listI)).getName();
        kotlin.jvm.internal.t.e(name, "getName(...)");
        c1 c1VarJ1 = j1(name);
        if (c1VarJ1 != null) {
            return new fe.a0(name, c1VarJ1);
        }
        throw new IllegalStateException(("Value class has no underlying property: " + this).toString());
    }

    public final tf.p d1() {
        return this.f23444m;
    }

    public final ze.c e1() {
        return this.f23437f;
    }

    public final a f1() {
        return (a) this.f23448q.c(this.f23444m.c().n().d());
    }

    public final bf.a g1() {
        return this.f23438g;
    }

    @Override // ge.a
    public ge.h getAnnotations() {
        return this.f23457z;
    }

    @Override // fe.e, fe.d0, fe.q
    public fe.u getVisibility() {
        return this.f23442k;
    }

    @Override // fe.e
    public fe.f h() {
        return this.f23443l;
    }

    @Override // fe.e
    /* JADX INFO: renamed from: h1, reason: merged with bridge method [inline-methods] */
    public qf.l T() {
        return this.f23446o;
    }

    public final n0.a i1() {
        return this.f23456y;
    }

    @Override // fe.d0
    public boolean isExternal() {
        Boolean boolD = bf.b.f3323i.d(this.f23437f.D0());
        kotlin.jvm.internal.t.e(boolD, "get(...)");
        return boolD.booleanValue();
    }

    @Override // fe.e
    public boolean isInline() {
        return bf.b.f3325k.d(this.f23437f.D0()).booleanValue() && this.f23438g.e(1, 4, 1);
    }

    @Override // fe.p
    public g1 j() {
        return this.f23439h;
    }

    public final c1 j1(ef.f fVar) {
        Iterator it = f1().a(fVar, ne.d.f17051r).iterator();
        boolean z10 = false;
        Object obj = null;
        while (true) {
            if (!it.hasNext()) {
                if (!z10) {
                    break;
                }
            } else {
                Object next = it.next();
                if (((y0) next).k0() == null) {
                    if (z10) {
                        break;
                    }
                    z10 = true;
                    obj = next;
                }
            }
        }
        obj = null;
        y0 y0Var = (y0) obj;
        return (c1) (y0Var != null ? y0Var.getType() : null);
    }

    @Override // fe.h
    public u1 k() {
        return this.f23447p;
    }

    public final boolean k1(ef.f name) {
        kotlin.jvm.internal.t.f(name, "name");
        return f1().t().contains(name);
    }

    @Override // fe.e, fe.d0
    public fe.e0 l() {
        return this.f23441j;
    }

    @Override // fe.e
    public Collection m() {
        return (Collection) this.f23452u.invoke();
    }

    @Override // fe.e
    public boolean n() {
        return bf.b.f3325k.d(this.f23437f.D0()).booleanValue() && this.f23438g.c(1, 4, 2);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("deserialized ");
        sb2.append(N() ? "expect " : "");
        sb2.append("class ");
        sb2.append(getName());
        return sb2.toString();
    }

    @Override // fe.e, fe.i
    public List v() {
        return this.f23444m.i().m();
    }

    @Override // fe.e
    public boolean y() {
        return bf.b.f3320f.d(this.f23437f.D0()) == c.EnumC0494c.COMPANION_OBJECT;
    }

    @Override // fe.e
    public q1 y0() {
        return (q1) this.f23455x.invoke();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class a extends w {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final yf.g f23458g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final wf.i f23459h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final wf.i f23460i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ m f23461j;

        /* JADX INFO: renamed from: vf.m$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0406a extends jf.m {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ List f23462a;

            public C0406a(List list) {
                this.f23462a = list;
            }

            @Override // jf.n
            public void a(fe.b fakeOverride) {
                kotlin.jvm.internal.t.f(fakeOverride, "fakeOverride");
                jf.o.K(fakeOverride, null);
                this.f23462a.add(fakeOverride);
            }

            @Override // jf.m
            public void e(fe.b fromSuper, fe.b fromCurrent) {
                kotlin.jvm.internal.t.f(fromSuper, "fromSuper");
                kotlin.jvm.internal.t.f(fromCurrent, "fromCurrent");
                if (fromCurrent instanceof ie.s) {
                    ((ie.s) fromCurrent).U0(fe.v.f9524a, fromSuper);
                }
            }
        }

        public a(m mVar, yf.g kotlinTypeRefiner) {
            kotlin.jvm.internal.t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
            this.f23461j = mVar;
            tf.p pVarD1 = mVar.d1();
            List listH0 = mVar.e1().H0();
            kotlin.jvm.internal.t.e(listH0, "getFunctionList(...)");
            List listV0 = mVar.e1().V0();
            kotlin.jvm.internal.t.e(listV0, "getPropertyList(...)");
            List listD1 = mVar.e1().d1();
            kotlin.jvm.internal.t.e(listD1, "getTypeAliasList(...)");
            List listS0 = mVar.e1().S0();
            kotlin.jvm.internal.t.e(listS0, "getNestedClassNameList(...)");
            bf.c cVarG = mVar.d1().g();
            ArrayList arrayList = new ArrayList(dd.s.u(listS0, 10));
            Iterator it = listS0.iterator();
            while (it.hasNext()) {
                arrayList.add(tf.l0.b(cVarG, ((Number) it.next()).intValue()));
            }
            super(pVarD1, listH0, listV0, listD1, new j(arrayList));
            this.f23458g = kotlinTypeRefiner;
            this.f23459h = s().h().e(new k(this));
            this.f23460i = s().h().e(new l(this));
        }

        public static final Collection F(a aVar) {
            return aVar.m(qf.d.f19058o, qf.k.f19084a.c(), ne.d.f17046m);
        }

        public static final Collection J(a aVar) {
            return aVar.f23458g.g(aVar.H());
        }

        @Override // vf.w
        public boolean A(f1 function) {
            kotlin.jvm.internal.t.f(function, "function");
            return s().c().t().a(this.f23461j, function);
        }

        public final void G(ef.f fVar, Collection collection, List list) {
            s().c().n().a().v(fVar, collection, new ArrayList(list), H(), new C0406a(list));
        }

        public final m H() {
            return this.f23461j;
        }

        public void I(ef.f name, ne.b location) {
            kotlin.jvm.internal.t.f(name, "name");
            kotlin.jvm.internal.t.f(location, "location");
            me.a.a(s().c().p(), location, H(), name);
        }

        @Override // vf.w, qf.l, qf.k
        public Collection a(ef.f name, ne.b location) {
            kotlin.jvm.internal.t.f(name, "name");
            kotlin.jvm.internal.t.f(location, "location");
            I(name, location);
            return super.a(name, location);
        }

        @Override // vf.w, qf.l, qf.k
        public Collection c(ef.f name, ne.b location) {
            kotlin.jvm.internal.t.f(name, "name");
            kotlin.jvm.internal.t.f(location, "location");
            I(name, location);
            return super.c(name, location);
        }

        @Override // vf.w, qf.l, qf.n
        public fe.h e(ef.f name, ne.b location) {
            fe.e eVarI;
            kotlin.jvm.internal.t.f(name, "name");
            kotlin.jvm.internal.t.f(location, "location");
            I(name, location);
            c cVar = H().f23449r;
            return (cVar == null || (eVarI = cVar.i(name)) == null) ? super.e(name, location) : eVarI;
        }

        @Override // qf.l, qf.n
        public Collection g(qf.d kindFilter, pd.k nameFilter) {
            kotlin.jvm.internal.t.f(kindFilter, "kindFilter");
            kotlin.jvm.internal.t.f(nameFilter, "nameFilter");
            return (Collection) this.f23459h.invoke();
        }

        @Override // vf.w
        public void j(Collection result, pd.k nameFilter) {
            kotlin.jvm.internal.t.f(result, "result");
            kotlin.jvm.internal.t.f(nameFilter, "nameFilter");
            c cVar = H().f23449r;
            Collection collectionD = cVar != null ? cVar.d() : null;
            if (collectionD == null) {
                collectionD = dd.r.k();
            }
            result.addAll(collectionD);
        }

        @Override // vf.w
        public void n(ef.f name, List functions) {
            kotlin.jvm.internal.t.f(name, "name");
            kotlin.jvm.internal.t.f(functions, "functions");
            ArrayList arrayList = new ArrayList();
            Iterator it = ((Collection) this.f23460i.invoke()).iterator();
            while (it.hasNext()) {
                arrayList.addAll(((xf.r0) it.next()).q().c(name, ne.d.f17045l));
            }
            functions.addAll(s().c().c().d(name, this.f23461j));
            G(name, arrayList, functions);
        }

        @Override // vf.w
        public void o(ef.f name, List descriptors) {
            kotlin.jvm.internal.t.f(name, "name");
            kotlin.jvm.internal.t.f(descriptors, "descriptors");
            ArrayList arrayList = new ArrayList();
            Iterator it = ((Collection) this.f23460i.invoke()).iterator();
            while (it.hasNext()) {
                arrayList.addAll(((xf.r0) it.next()).q().a(name, ne.d.f17045l));
            }
            G(name, arrayList, descriptors);
        }

        @Override // vf.w
        public ef.b p(ef.f name) {
            kotlin.jvm.internal.t.f(name, "name");
            return this.f23461j.f23440i.d(name);
        }

        @Override // vf.w
        public Set v() {
            List listC = H().f23447p.c();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it = listC.iterator();
            while (it.hasNext()) {
                Set setF = ((xf.r0) it.next()).q().f();
                if (setF == null) {
                    return null;
                }
                dd.w.z(linkedHashSet, setF);
            }
            return linkedHashSet;
        }

        @Override // vf.w
        public Set w() {
            List listC = H().f23447p.c();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it = listC.iterator();
            while (it.hasNext()) {
                dd.w.z(linkedHashSet, ((xf.r0) it.next()).q().b());
            }
            linkedHashSet.addAll(s().c().c().c(this.f23461j));
            return linkedHashSet;
        }

        @Override // vf.w
        public Set x() {
            List listC = H().f23447p.c();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it = listC.iterator();
            while (it.hasNext()) {
                dd.w.z(linkedHashSet, ((xf.r0) it.next()).q().d());
            }
            return linkedHashSet;
        }

        public static final List B(List list) {
            return list;
        }
    }
}
