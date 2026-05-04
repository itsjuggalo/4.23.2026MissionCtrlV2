package se;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import oe.u;
import qf.d;
import se.c;
import xe.v;
import ye.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g0 extends a1 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ve.u f20247n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final d0 f20248o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final wf.j f20249p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final wf.h f20250q;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ef.f f20251a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ve.g f20252b;

        public a(ef.f name, ve.g gVar) {
            kotlin.jvm.internal.t.f(name, "name");
            this.f20251a = name;
            this.f20252b = gVar;
        }

        public final ve.g a() {
            return this.f20252b;
        }

        public final ef.f b() {
            return this.f20251a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && kotlin.jvm.internal.t.b(this.f20251a, ((a) obj).f20251a);
        }

        public int hashCode() {
            return this.f20251a.hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class b {

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final fe.e f20253a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(fe.e descriptor) {
                super(null);
                kotlin.jvm.internal.t.f(descriptor, "descriptor");
                this.f20253a = descriptor;
            }

            public final fe.e a() {
                return this.f20253a;
            }
        }

        /* JADX INFO: renamed from: se.g0$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0360b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0360b f20254a = new C0360b();

            public C0360b() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class c extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f20255a = new c();

            public c() {
                super(null);
            }
        }

        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        public b() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(re.k c10, ve.u jPackage, d0 ownerDescriptor) {
        super(c10);
        kotlin.jvm.internal.t.f(c10, "c");
        kotlin.jvm.internal.t.f(jPackage, "jPackage");
        kotlin.jvm.internal.t.f(ownerDescriptor, "ownerDescriptor");
        this.f20247n = jPackage;
        this.f20248o = ownerDescriptor;
        this.f20249p = c10.e().g(new e0(c10, this));
        this.f20250q = c10.e().h(new f0(this, c10));
    }

    public static final fe.e i0(g0 g0Var, re.k kVar, a request) {
        kotlin.jvm.internal.t.f(request, "request");
        ef.b bVar = new ef.b(g0Var.R().e(), request.b());
        v.a aVarB = request.a() != null ? kVar.a().j().b(request.a(), g0Var.m0()) : kVar.a().j().a(bVar, g0Var.m0());
        xe.x xVarA = aVarB != null ? aVarB.a() : null;
        ef.b bVarG = xVarA != null ? xVarA.g() : null;
        if (bVarG != null && (bVarG.j() || bVarG.i())) {
            return null;
        }
        b bVarP0 = g0Var.p0(xVarA);
        if (bVarP0 instanceof b.a) {
            return ((b.a) bVarP0).a();
        }
        if (bVarP0 instanceof b.c) {
            return null;
        }
        if (!(bVarP0 instanceof b.C0360b)) {
            throw new cd.o();
        }
        ve.g gVarA = request.a();
        if (gVarA == null) {
            gVarA = kVar.a().d().c(new u.a(bVar, null, null, 4, null));
        }
        ve.g gVar = gVarA;
        if ((gVar != null ? gVar.H() : null) != ve.d0.f23407b) {
            ef.c cVarE = gVar != null ? gVar.e() : null;
            if (cVarE == null || cVarE.c() || !kotlin.jvm.internal.t.b(cVarE.d(), g0Var.R().e())) {
                return null;
            }
            n nVar = new n(kVar, g0Var.R(), gVar, null, 8, null);
            kVar.a().e().a(nVar);
            return nVar;
        }
        throw new IllegalStateException("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: " + gVar + "\nClassId: " + bVar + "\nfindKotlinClass(JavaClass) = " + xe.w.b(kVar.a().j(), gVar, g0Var.m0()) + "\nfindKotlinClass(ClassId) = " + xe.w.a(kVar.a().j(), bVar, g0Var.m0()) + '\n');
    }

    public static final Set o0(re.k kVar, g0 g0Var) {
        return kVar.a().d().a(g0Var.R().e());
    }

    @Override // se.t0
    public void B(Collection result, ef.f name) {
        kotlin.jvm.internal.t.f(result, "result");
        kotlin.jvm.internal.t.f(name, "name");
    }

    @Override // se.t0
    public Set D(qf.d kindFilter, pd.k kVar) {
        kotlin.jvm.internal.t.f(kindFilter, "kindFilter");
        return dd.u0.d();
    }

    @Override // se.t0, qf.l, qf.k
    public Collection a(ef.f name, ne.b location) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        return dd.r.k();
    }

    @Override // se.t0, qf.l, qf.n
    public Collection g(qf.d kindFilter, pd.k nameFilter) {
        kotlin.jvm.internal.t.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.t.f(nameFilter, "nameFilter");
        d.a aVar = qf.d.f19046c;
        if (!kindFilter.a(aVar.e() | aVar.c())) {
            return dd.r.k();
        }
        Iterable iterable = (Iterable) K().invoke();
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            fe.m mVar = (fe.m) obj;
            if (mVar instanceof fe.e) {
                ef.f name = ((fe.e) mVar).getName();
                kotlin.jvm.internal.t.e(name, "getName(...)");
                if (((Boolean) nameFilter.invoke(name)).booleanValue()) {
                    arrayList.add(obj);
                }
            }
        }
        return arrayList;
    }

    public final fe.e j0(ef.f fVar, ve.g gVar) {
        if (!ef.h.f8800a.a(fVar)) {
            return null;
        }
        Set set = (Set) this.f20249p.invoke();
        if (gVar != null || set == null || set.contains(fVar.b())) {
            return (fe.e) this.f20250q.invoke(new a(fVar, gVar));
        }
        return null;
    }

    public final fe.e k0(ve.g javaClass) {
        kotlin.jvm.internal.t.f(javaClass, "javaClass");
        return j0(javaClass.getName(), javaClass);
    }

    @Override // qf.l, qf.n
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public fe.e e(ef.f name, ne.b location) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        return j0(name, null);
    }

    public final df.e m0() {
        return hg.c.a(L().a().b().f().g());
    }

    @Override // se.t0
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public d0 R() {
        return this.f20248o;
    }

    public final b p0(xe.x xVar) {
        if (xVar == null) {
            return b.C0360b.f20254a;
        }
        if (xVar.b().c() != a.EnumC0469a.f25372e) {
            return b.c.f20255a;
        }
        fe.e eVarN = L().a().b().n(xVar);
        return eVarN != null ? new b.a(eVarN) : b.C0360b.f20254a;
    }

    @Override // se.t0
    public Set v(qf.d kindFilter, pd.k kVar) {
        kotlin.jvm.internal.t.f(kindFilter, "kindFilter");
        if (!kindFilter.a(qf.d.f19046c.e())) {
            return dd.u0.d();
        }
        Set set = (Set) this.f20249p.invoke();
        if (set != null) {
            HashSet hashSet = new HashSet();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                hashSet.add(ef.f.k((String) it.next()));
            }
            return hashSet;
        }
        ve.u uVar = this.f20247n;
        if (kVar == null) {
            kVar = hg.j.k();
        }
        Collection<ve.g> collectionH = uVar.h(kVar);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (ve.g gVar : collectionH) {
            ef.f name = gVar.H() == ve.d0.f23406a ? null : gVar.getName();
            if (name != null) {
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // se.t0
    public Set x(qf.d kindFilter, pd.k kVar) {
        kotlin.jvm.internal.t.f(kindFilter, "kindFilter");
        return dd.u0.d();
    }

    @Override // se.t0
    public c z() {
        return c.a.f20224a;
    }
}
