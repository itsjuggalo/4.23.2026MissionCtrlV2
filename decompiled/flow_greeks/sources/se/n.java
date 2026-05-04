package se;

import fe.e1;
import fe.j1;
import fe.l1;
import fe.m0;
import fe.p1;
import fe.w1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import xf.c2;
import xf.h2;
import xf.m2;
import xf.q1;
import xf.u1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class n extends ie.j implements qe.c {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final a f20280y = new a(null);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Set f20281z = dd.u0.h("equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final re.k f20282i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ve.g f20283j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final fe.e f20284k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final re.k f20285l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final cd.k f20286m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final fe.f f20287n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final fe.e0 f20288o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final w1 f20289p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f20290q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final b f20291r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final z f20292s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final e1 f20293t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final qf.g f20294u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final z0 f20295v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ge.h f20296w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final wf.i f20297x;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class b extends xf.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final wf.i f20298d;

        public b() {
            super(n.this.f20285l.e());
            this.f20298d = n.this.f20285l.e().e(new o(n.this));
        }

        public static final List M(n nVar) {
            return p1.g(nVar);
        }

        @Override // xf.v, xf.u1
        /* JADX INFO: renamed from: I */
        public fe.e b() {
            return n.this;
        }

        public final xf.r0 K() {
            ef.c cVarB;
            ArrayList arrayList;
            ef.c cVarL = L();
            if (cVarL == null || cVarL.c() || !cVarL.h(ce.o.f3972z)) {
                cVarL = null;
            }
            if (cVarL == null) {
                cVarB = oe.r.f18056a.b(nf.e.o(n.this));
                if (cVarB == null) {
                    return null;
                }
            } else {
                cVarB = cVarL;
            }
            fe.e eVarB = nf.e.B(n.this.f20285l.d(), cVarB, ne.d.f17052s);
            if (eVarB == null) {
                return null;
            }
            int size = eVarB.k().getParameters().size();
            List parameters = n.this.k().getParameters();
            kotlin.jvm.internal.t.e(parameters, "getParameters(...)");
            int size2 = parameters.size();
            if (size2 == size) {
                arrayList = new ArrayList(dd.s.u(parameters, 10));
                Iterator it = parameters.iterator();
                while (it.hasNext()) {
                    arrayList.add(new c2(m2.f25015e, ((l1) it.next()).s()));
                }
            } else {
                if (size2 != 1 || size <= 1 || cVarL != null) {
                    return null;
                }
                c2 c2Var = new c2(m2.f25015e, ((l1) dd.a0.v0(parameters)).s());
                vd.g gVar = new vd.g(1, size);
                ArrayList arrayList2 = new ArrayList(dd.s.u(gVar, 10));
                Iterator it2 = gVar.iterator();
                while (it2.hasNext()) {
                    ((dd.j0) it2).nextInt();
                    arrayList2.add(c2Var);
                }
                arrayList = arrayList2;
            }
            return xf.u0.h(q1.f25042b.k(), eVarB, arrayList);
        }

        public final ef.c L() {
            String str;
            ge.h annotations = n.this.getAnnotations();
            ef.c PURELY_IMPLEMENTS_ANNOTATION = oe.i0.f17998r;
            kotlin.jvm.internal.t.e(PURELY_IMPLEMENTS_ANNOTATION, "PURELY_IMPLEMENTS_ANNOTATION");
            ge.c cVarB = annotations.b(PURELY_IMPLEMENTS_ANNOTATION);
            if (cVarB == null) {
                return null;
            }
            Object objW0 = dd.a0.w0(cVarB.a().values());
            lf.x xVar = objW0 instanceof lf.x ? (lf.x) objW0 : null;
            if (xVar == null || (str = (String) xVar.b()) == null || !ef.e.e(str)) {
                return null;
            }
            return new ef.c(str);
        }

        @Override // xf.u1
        public boolean d() {
            return true;
        }

        @Override // xf.u1
        public List getParameters() {
            return (List) this.f20298d.invoke();
        }

        @Override // xf.p
        public Collection r() {
            Collection collectionC = n.this.S0().c();
            ArrayList arrayList = new ArrayList(collectionC.size());
            ArrayList<ve.x> arrayList2 = new ArrayList(0);
            xf.r0 r0VarK = K();
            Iterator it = collectionC.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ve.j jVar = (ve.j) it.next();
                xf.r0 r0VarQ = n.this.f20285l.a().r().q(n.this.f20285l.g().p(jVar, te.b.b(h2.f24978a, false, false, null, 7, null)), n.this.f20285l);
                if (r0VarQ.N0().b() instanceof m0.b) {
                    arrayList2.add(jVar);
                }
                if (!kotlin.jvm.internal.t.b(r0VarQ.N0(), r0VarK != null ? r0VarK.N0() : null) && !ce.i.c0(r0VarQ)) {
                    arrayList.add(r0VarQ);
                }
            }
            fe.e eVar = n.this.f20284k;
            hg.a.a(arrayList, eVar != null ? ee.y.a(eVar, n.this).c().p(eVar.s(), m2.f25015e) : null);
            hg.a.a(arrayList, r0VarK);
            if (!arrayList2.isEmpty()) {
                tf.w wVarC = n.this.f20285l.a().c();
                fe.e eVarB = b();
                ArrayList arrayList3 = new ArrayList(dd.s.u(arrayList2, 10));
                for (ve.x xVar : arrayList2) {
                    kotlin.jvm.internal.t.d(xVar, "null cannot be cast to non-null type org.jetbrains.kotlin.load.java.structure.JavaClassifierType");
                    arrayList3.add(((ve.j) xVar).p());
                }
                wVarC.b(eVarB, arrayList3);
            }
            return !arrayList.isEmpty() ? dd.a0.I0(arrayList) : dd.q.e(n.this.f20285l.d().p().i());
        }

        public String toString() {
            String strB = n.this.getName().b();
            kotlin.jvm.internal.t.e(strB, "asString(...)");
            return strB;
        }

        @Override // xf.p
        public j1 v() {
            return n.this.f20285l.a().v();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return fd.a.a(nf.e.o((fe.e) obj).a(), nf.e.o((fe.e) obj2).a());
        }
    }

    public /* synthetic */ n(re.k kVar, fe.m mVar, ve.g gVar, fe.e eVar, int i10, kotlin.jvm.internal.k kVar2) {
        this(kVar, mVar, gVar, (i10 & 8) != 0 ? null : eVar);
    }

    public static final List Q0(n nVar) {
        List<ve.y> typeParameters = nVar.f20283j.getTypeParameters();
        ArrayList arrayList = new ArrayList(dd.s.u(typeParameters, 10));
        for (ve.y yVar : typeParameters) {
            l1 l1VarA = nVar.f20285l.f().a(yVar);
            if (l1VarA == null) {
                throw new AssertionError("Parameter " + yVar + " surely belongs to class " + nVar.f20283j + ", so it must be resolved");
            }
            arrayList.add(l1VarA);
        }
        return arrayList;
    }

    public static final List W0(n nVar) {
        ef.b bVarN = nf.e.n(nVar);
        if (bVarN != null) {
            return nVar.f20282i.a().f().a(bVarN);
        }
        return null;
    }

    public static final z X0(n nVar, yf.g it) {
        kotlin.jvm.internal.t.f(it, "it");
        return new z(nVar.f20285l, nVar, nVar.f20283j, nVar.f20284k != null, nVar.f20292s);
    }

    @Override // fe.e
    public boolean E() {
        return false;
    }

    @Override // fe.d0
    public boolean E0() {
        return false;
    }

    @Override // fe.e
    public boolean H0() {
        return false;
    }

    @Override // fe.e
    public Collection K() {
        if (this.f20288o != fe.e0.f9462c) {
            return dd.r.k();
        }
        te.a aVarB = te.b.b(h2.f24979b, false, false, null, 7, null);
        jg.h hVarM = this.f20283j.M();
        ArrayList arrayList = new ArrayList();
        Iterator it = hVarM.iterator();
        while (it.hasNext()) {
            fe.h hVarB = this.f20285l.g().p((ve.j) it.next(), aVarB).N0().b();
            fe.e eVar = hVarB instanceof fe.e ? (fe.e) hVarB : null;
            if (eVar != null) {
                arrayList.add(eVar);
            }
        }
        return dd.a0.A0(arrayList, new c());
    }

    @Override // fe.d0
    public boolean N() {
        return false;
    }

    @Override // fe.i
    public boolean P() {
        return this.f20290q;
    }

    public final n P0(pe.j javaResolverCache, fe.e eVar) {
        kotlin.jvm.internal.t.f(javaResolverCache, "javaResolverCache");
        re.k kVar = this.f20285l;
        re.k kVarM = re.c.m(kVar, kVar.a().x(javaResolverCache));
        fe.m mVarB = b();
        kotlin.jvm.internal.t.e(mVarB, "getContainingDeclaration(...)");
        return new n(kVarM, mVarB, this.f20283j, eVar);
    }

    @Override // fe.e
    /* JADX INFO: renamed from: R0, reason: merged with bridge method [inline-methods] */
    public List m() {
        return (List) this.f20292s.a1().invoke();
    }

    @Override // fe.e
    public fe.d S() {
        return null;
    }

    public final ve.g S0() {
        return this.f20283j;
    }

    @Override // fe.e
    public qf.k T() {
        return this.f20295v;
    }

    public final List T0() {
        return (List) this.f20286m.getValue();
    }

    @Override // ie.a, fe.e
    /* JADX INFO: renamed from: U0, reason: merged with bridge method [inline-methods] */
    public z D0() {
        qf.k kVarD0 = super.D0();
        kotlin.jvm.internal.t.d(kVarD0, "null cannot be cast to non-null type org.jetbrains.kotlin.load.java.lazy.descriptors.LazyJavaClassMemberScope");
        return (z) kVarD0;
    }

    @Override // fe.e
    public fe.e V() {
        return null;
    }

    @Override // ie.z
    /* JADX INFO: renamed from: V0, reason: merged with bridge method [inline-methods] */
    public z I(yf.g kotlinTypeRefiner) {
        kotlin.jvm.internal.t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return (z) this.f20293t.c(kotlinTypeRefiner);
    }

    @Override // ge.a
    public ge.h getAnnotations() {
        return this.f20296w;
    }

    @Override // fe.e, fe.d0, fe.q
    public fe.u getVisibility() {
        if (!kotlin.jvm.internal.t.b(this.f20289p, fe.t.f9507a) || this.f20283j.k() != null) {
            return oe.u0.d(this.f20289p);
        }
        fe.u uVar = oe.y.f18105a;
        kotlin.jvm.internal.t.c(uVar);
        return uVar;
    }

    @Override // fe.e
    public fe.f h() {
        return this.f20287n;
    }

    @Override // fe.e
    public boolean isInline() {
        return false;
    }

    @Override // fe.h
    public u1 k() {
        return this.f20291r;
    }

    @Override // fe.e, fe.d0
    public fe.e0 l() {
        return this.f20288o;
    }

    @Override // fe.e
    public boolean n() {
        return false;
    }

    public String toString() {
        return "Lazy Java class " + nf.e.p(this);
    }

    @Override // fe.e, fe.i
    public List v() {
        return (List) this.f20297x.invoke();
    }

    @Override // ie.a, fe.e
    public qf.k x0() {
        return this.f20294u;
    }

    @Override // fe.e
    public boolean y() {
        return false;
    }

    @Override // fe.e
    public fe.q1 y0() {
        return null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(re.k outerContext, fe.m containingDeclaration, ve.g jClass, fe.e eVar) {
        fe.e0 e0VarA;
        super(outerContext.e(), containingDeclaration, jClass.getName(), outerContext.a().t().a(jClass), false);
        kotlin.jvm.internal.t.f(outerContext, "outerContext");
        kotlin.jvm.internal.t.f(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.t.f(jClass, "jClass");
        this.f20282i = outerContext;
        this.f20283j = jClass;
        this.f20284k = eVar;
        re.k kVarF = re.c.f(outerContext, this, jClass, 0, 4, null);
        this.f20285l = kVarF;
        kVarF.a().h().d(jClass, this);
        jClass.H();
        this.f20286m = cd.l.b(new k(this));
        this.f20287n = jClass.q() ? fe.f.f9477f : jClass.G() ? fe.f.f9474c : jClass.A() ? fe.f.f9475d : fe.f.f9473b;
        if (jClass.q() || jClass.A()) {
            e0VarA = fe.e0.f9461b;
        } else {
            e0VarA = fe.e0.f9460a.a(jClass.D(), jClass.D() || jClass.isAbstract() || jClass.G(), !jClass.isFinal());
        }
        this.f20288o = e0VarA;
        this.f20289p = jClass.getVisibility();
        this.f20290q = (jClass.k() == null || jClass.P()) ? false : true;
        this.f20291r = new b();
        z zVar = new z(kVarF, this, jClass, eVar != null, null, 16, null);
        this.f20292s = zVar;
        this.f20293t = e1.f9467e.a(this, kVarF.e(), kVarF.a().k().d(), new l(this));
        this.f20294u = new qf.g(zVar);
        this.f20295v = new z0(kVarF, jClass, this);
        this.f20296w = re.h.a(kVarF, jClass);
        this.f20297x = kVarF.e().e(new m(this));
    }
}
