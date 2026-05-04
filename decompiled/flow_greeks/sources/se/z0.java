package se;

import fe.f1;
import hg.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class z0 extends a1 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ve.g f20354n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final qe.c f20355o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z0(re.k c10, ve.g jClass, qe.c ownerDescriptor) {
        super(c10);
        kotlin.jvm.internal.t.f(c10, "c");
        kotlin.jvm.internal.t.f(jClass, "jClass");
        kotlin.jvm.internal.t.f(ownerDescriptor, "ownerDescriptor");
        this.f20354n = jClass;
        this.f20355o = ownerDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m0(ve.q it) {
        kotlin.jvm.internal.t.f(it, "it");
        return it.P();
    }

    public static final Collection n0(ef.f fVar, qf.k it) {
        kotlin.jvm.internal.t.f(it, "it");
        return it.a(fVar, ne.d.f17048o);
    }

    public static final Collection o0(qf.k it) {
        kotlin.jvm.internal.t.f(it, "it");
        return it.d();
    }

    public static final Iterable q0(fe.e eVar) {
        Collection collectionC = eVar.k().c();
        kotlin.jvm.internal.t.e(collectionC, "getSupertypes(...)");
        return jg.t.u(jg.t.F(dd.a0.Q(collectionC), y0.f20345a));
    }

    public static final fe.e r0(xf.r0 r0Var) {
        fe.h hVarB = r0Var.N0().b();
        if (hVarB instanceof fe.e) {
            return (fe.e) hVarB;
        }
        return null;
    }

    @Override // se.t0
    public void B(Collection result, ef.f name) {
        kotlin.jvm.internal.t.f(result, "result");
        kotlin.jvm.internal.t.f(name, "name");
        Collection collectionE = pe.a.e(name, u0(name, R()), result, R(), L().a().c(), L().a().k().a());
        kotlin.jvm.internal.t.e(collectionE, "resolveOverridesForStaticMembers(...)");
        result.addAll(collectionE);
        if (this.f20354n.A()) {
            if (kotlin.jvm.internal.t.b(name, ce.o.f3952f)) {
                f1 f1VarG = jf.h.g(R());
                kotlin.jvm.internal.t.e(f1VarG, "createEnumValueOfMethod(...)");
                result.add(f1VarG);
            } else if (kotlin.jvm.internal.t.b(name, ce.o.f3950d)) {
                f1 f1VarH = jf.h.h(R());
                kotlin.jvm.internal.t.e(f1VarH, "createEnumValuesMethod(...)");
                result.add(f1VarH);
            }
        }
    }

    @Override // se.a1, se.t0
    public void C(ef.f name, Collection result) {
        ef.f fVar;
        Collection collection;
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(result, "result");
        Set setP0 = p0(R(), new LinkedHashSet(), new w0(name));
        if (result.isEmpty()) {
            fVar = name;
            collection = result;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : setP0) {
                fe.y0 y0VarT0 = t0((fe.y0) obj);
                Object arrayList = linkedHashMap.get(y0VarT0);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(y0VarT0, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                Collection collectionE = pe.a.e(fVar, (Collection) ((Map.Entry) it.next()).getValue(), collection, R(), L().a().c(), L().a().k().a());
                kotlin.jvm.internal.t.e(collectionE, "resolveOverridesForStaticMembers(...)");
                dd.w.z(arrayList2, collectionE);
            }
            collection.addAll(arrayList2);
        } else {
            Collection collectionE2 = pe.a.e(name, setP0, result, R(), L().a().c(), L().a().k().a());
            fVar = name;
            collection = result;
            kotlin.jvm.internal.t.e(collectionE2, "resolveOverridesForStaticMembers(...)");
            collection.addAll(collectionE2);
        }
        if (this.f20354n.A() && kotlin.jvm.internal.t.b(fVar, ce.o.f3951e)) {
            hg.a.a(collection, jf.h.f(R()));
        }
    }

    @Override // se.t0
    public Set D(qf.d kindFilter, pd.k kVar) {
        kotlin.jvm.internal.t.f(kindFilter, "kindFilter");
        Set setM0 = dd.a0.M0(((c) N().invoke()).f());
        p0(R(), setM0, v0.f20339a);
        if (this.f20354n.A()) {
            setM0.add(ce.o.f3951e);
        }
        return setM0;
    }

    @Override // qf.l, qf.n
    public fe.h e(ef.f name, ne.b location) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        return null;
    }

    @Override // se.t0
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public b z() {
        return new b(this.f20354n, u0.f20336a);
    }

    public final Set p0(fe.e eVar, Set set, pd.k kVar) {
        hg.b.b(dd.q.e(eVar), x0.f20343a, new a(eVar, set, kVar));
        return set;
    }

    @Override // se.t0
    /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
    public qe.c R() {
        return this.f20355o;
    }

    public final fe.y0 t0(fe.y0 y0Var) {
        if (y0Var.h().a()) {
            return y0Var;
        }
        Collection<fe.y0> collectionF = y0Var.f();
        kotlin.jvm.internal.t.e(collectionF, "getOverriddenDescriptors(...)");
        ArrayList arrayList = new ArrayList(dd.s.u(collectionF, 10));
        for (fe.y0 y0Var2 : collectionF) {
            kotlin.jvm.internal.t.c(y0Var2);
            arrayList.add(t0(y0Var2));
        }
        return (fe.y0) dd.a0.v0(dd.a0.S(arrayList));
    }

    public final Set u0(ef.f fVar, fe.e eVar) {
        z0 z0VarB = qe.h.b(eVar);
        return z0VarB == null ? dd.u0.d() : dd.a0.N0(z0VarB.c(fVar, ne.d.f17048o));
    }

    @Override // se.t0
    public Set v(qf.d kindFilter, pd.k kVar) {
        kotlin.jvm.internal.t.f(kindFilter, "kindFilter");
        return dd.u0.d();
    }

    @Override // se.t0
    public Set x(qf.d kindFilter, pd.k kVar) {
        kotlin.jvm.internal.t.f(kindFilter, "kindFilter");
        Set setM0 = dd.a0.M0(((c) N().invoke()).a());
        z0 z0VarB = qe.h.b(R());
        Set setB = z0VarB != null ? z0VarB.b() : null;
        if (setB == null) {
            setB = dd.u0.d();
        }
        setM0.addAll(setB);
        if (this.f20354n.A()) {
            setM0.addAll(dd.r.n(ce.o.f3952f, ce.o.f3950d));
        }
        setM0.addAll(L().a().w().g(R(), L()));
        return setM0;
    }

    @Override // se.t0
    public void y(Collection result, ef.f name) {
        kotlin.jvm.internal.t.f(result, "result");
        kotlin.jvm.internal.t.f(name, "name");
        L().a().w().c(R(), name, result, L());
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends b.AbstractC0212b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ fe.e f20356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Set f20357b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ pd.k f20358c;

        public a(fe.e eVar, Set set, pd.k kVar) {
            this.f20356a = eVar;
            this.f20357b = set;
            this.f20358c = kVar;
        }

        @Override // hg.b.d
        public /* bridge */ /* synthetic */ Object a() {
            e();
            return cd.h0.f3852a;
        }

        @Override // hg.b.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean c(fe.e current) {
            kotlin.jvm.internal.t.f(current, "current");
            if (current == this.f20356a) {
                return true;
            }
            qf.k kVarT = current.T();
            kotlin.jvm.internal.t.e(kVarT, "getStaticScope(...)");
            if (!(kVarT instanceof a1)) {
                return true;
            }
            this.f20357b.addAll((Collection) this.f20358c.invoke(kVarT));
            return false;
        }

        public void e() {
        }
    }
}
