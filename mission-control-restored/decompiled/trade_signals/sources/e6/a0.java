package e6;

import R5.InterfaceC0848e;
import R5.InterfaceC0851h;
import R5.g0;
import S6.b;
import b6.AbstractC1225a;
import c6.AbstractC1264h;
import c6.InterfaceC1259c;
import h6.InterfaceC1898g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2470H;
import p5.AbstractC2594p;
import p5.AbstractC2595q;
import u6.AbstractC2793h;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 extends b0 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final InterfaceC1898g f17264n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final InterfaceC1259c f17265o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(d6.k c8, InterfaceC1898g jClass, InterfaceC1259c ownerDescriptor) {
        super(c8);
        AbstractC2304t.f(c8, "c");
        AbstractC2304t.f(jClass, "jClass");
        AbstractC2304t.f(ownerDescriptor, "ownerDescriptor");
        this.f17264n = jClass;
        this.f17265o = ownerDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m0(h6.q it) {
        AbstractC2304t.f(it, "it");
        return it.Q();
    }

    public static final Collection n0(q6.f fVar, B6.k it) {
        AbstractC2304t.f(it, "it");
        return it.a(fVar, Z5.d.f9784o);
    }

    public static final Collection o0(B6.k it) {
        AbstractC2304t.f(it, "it");
        return it.c();
    }

    public static final Iterable q0(InterfaceC0848e interfaceC0848e) {
        Collection collectionR = interfaceC0848e.l().r();
        AbstractC2304t.e(collectionR, "getSupertypes(...)");
        return U6.r.r(U6.r.C(p5.z.P(collectionR), C1698Z.f17262a));
    }

    public static final InterfaceC0848e r0(I6.S s8) {
        InterfaceC0851h interfaceC0851hS = s8.O0().s();
        if (interfaceC0851hS instanceof InterfaceC0848e) {
            return (InterfaceC0848e) interfaceC0851hS;
        }
        return null;
    }

    @Override // e6.AbstractC1693U
    public void B(Collection result, q6.f name) {
        g0 g0VarH;
        String str;
        AbstractC2304t.f(result, "result");
        AbstractC2304t.f(name, "name");
        Collection collectionE = AbstractC1225a.e(name, u0(name, R()), result, R(), L().a().c(), L().a().k().a());
        AbstractC2304t.e(collectionE, "resolveOverridesForStaticMembers(...)");
        result.addAll(collectionE);
        if (this.f17264n.z()) {
            if (AbstractC2304t.b(name, O5.o.f6100f)) {
                g0VarH = AbstractC2793h.g(R());
                str = "createEnumValueOfMethod(...)";
            } else {
                if (!AbstractC2304t.b(name, O5.o.f6098d)) {
                    return;
                }
                g0VarH = AbstractC2793h.h(R());
                str = "createEnumValuesMethod(...)";
            }
            AbstractC2304t.e(g0VarH, str);
            result.add(g0VarH);
        }
    }

    @Override // e6.b0, e6.AbstractC1693U
    public void C(q6.f name, Collection result) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(result, "result");
        Set setP0 = p0(R(), new LinkedHashSet(), new C1696X(name));
        if (!result.isEmpty()) {
            Collection collectionE = AbstractC1225a.e(name, setP0, result, R(), L().a().c(), L().a().k().a());
            AbstractC2304t.e(collectionE, "resolveOverridesForStaticMembers(...)");
            result.addAll(collectionE);
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : setP0) {
                R5.Z zT0 = t0((R5.Z) obj);
                Object arrayList = linkedHashMap.get(zT0);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(zT0, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                Collection collectionE2 = AbstractC1225a.e(name, (Collection) ((Map.Entry) it.next()).getValue(), result, R(), L().a().c(), L().a().k().a());
                AbstractC2304t.e(collectionE2, "resolveOverridesForStaticMembers(...)");
                p5.v.x(arrayList2, collectionE2);
            }
            result.addAll(arrayList2);
        }
        if (this.f17264n.z() && AbstractC2304t.b(name, O5.o.f6099e)) {
            S6.a.a(result, AbstractC2793h.f(R()));
        }
    }

    @Override // e6.AbstractC1693U
    public Set D(B6.d kindFilter, B5.k kVar) {
        AbstractC2304t.f(kindFilter, "kindFilter");
        Set setJ0 = p5.z.J0(((InterfaceC1701c) N().invoke()).f());
        p0(R(), setJ0, C1695W.f17259a);
        if (this.f17264n.z()) {
            setJ0.add(O5.o.f6099e);
        }
        return setJ0;
    }

    @Override // B6.l, B6.n
    public InterfaceC0851h e(q6.f name, Z5.b location) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(location, "location");
        return null;
    }

    @Override // e6.AbstractC1693U
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public C1700b z() {
        return new C1700b(this.f17264n, C1694V.f17258a);
    }

    public final Set p0(InterfaceC0848e interfaceC0848e, Set set, B5.k kVar) {
        S6.b.b(AbstractC2594p.e(interfaceC0848e), C1697Y.f17261a, new a(interfaceC0848e, set, kVar));
        return set;
    }

    @Override // e6.AbstractC1693U
    /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
    public InterfaceC1259c R() {
        return this.f17265o;
    }

    public final R5.Z t0(R5.Z z7) {
        if (z7.i().a()) {
            return z7;
        }
        Collection<R5.Z> collectionF = z7.f();
        AbstractC2304t.e(collectionF, "getOverriddenDescriptors(...)");
        ArrayList arrayList = new ArrayList(p5.r.s(collectionF, 10));
        for (R5.Z z8 : collectionF) {
            AbstractC2304t.c(z8);
            arrayList.add(t0(z8));
        }
        return (R5.Z) p5.z.u0(p5.z.R(arrayList));
    }

    public final Set u0(q6.f fVar, InterfaceC0848e interfaceC0848e) {
        a0 a0VarB = AbstractC1264h.b(interfaceC0848e);
        return a0VarB == null ? p5.S.d() : p5.z.K0(a0VarB.d(fVar, Z5.d.f9784o));
    }

    @Override // e6.AbstractC1693U
    public Set v(B6.d kindFilter, B5.k kVar) {
        AbstractC2304t.f(kindFilter, "kindFilter");
        return p5.S.d();
    }

    @Override // e6.AbstractC1693U
    public Set x(B6.d kindFilter, B5.k kVar) {
        AbstractC2304t.f(kindFilter, "kindFilter");
        Set setJ0 = p5.z.J0(((InterfaceC1701c) N().invoke()).a());
        a0 a0VarB = AbstractC1264h.b(R());
        Set setB = a0VarB != null ? a0VarB.b() : null;
        if (setB == null) {
            setB = p5.S.d();
        }
        setJ0.addAll(setB);
        if (this.f17264n.z()) {
            setJ0.addAll(AbstractC2595q.l(O5.o.f6100f, O5.o.f6098d));
        }
        setJ0.addAll(L().a().w().h(R(), L()));
        return setJ0;
    }

    @Override // e6.AbstractC1693U
    public void y(Collection result, q6.f name) {
        AbstractC2304t.f(result, "result");
        AbstractC2304t.f(name, "name");
        L().a().w().e(R(), name, result, L());
    }

    public static final class a extends b.AbstractC0110b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0848e f17266a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Set f17267b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ B5.k f17268c;

        public a(InterfaceC0848e interfaceC0848e, Set set, B5.k kVar) {
            this.f17266a = interfaceC0848e;
            this.f17267b = set;
            this.f17268c = kVar;
        }

        @Override // S6.b.d
        public /* bridge */ /* synthetic */ Object a() {
            e();
            return C2470H.f21956a;
        }

        @Override // S6.b.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean c(InterfaceC0848e current) {
            AbstractC2304t.f(current, "current");
            if (current == this.f17266a) {
                return true;
            }
            B6.k kVarT = current.T();
            AbstractC2304t.e(kVarT, "getStaticScope(...)");
            if (!(kVarT instanceof b0)) {
                return true;
            }
            this.f17267b.addAll((Collection) this.f17268c.invoke(kVarT));
            return false;
        }

        public void e() {
        }
    }
}
