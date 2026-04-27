package e6;

import B6.d;
import R5.InterfaceC0848e;
import R5.InterfaceC0856m;
import a6.InterfaceC1097u;
import e6.InterfaceC1701c;
import h6.EnumC1891D;
import h6.InterfaceC1898g;
import j6.AbstractC2259w;
import j6.InterfaceC2258v;
import j6.InterfaceC2260x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import k6.C2284a;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2487o;
import p5.AbstractC2595q;
import p6.C2602e;

/* JADX INFO: renamed from: e6.G, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1680G extends b0 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final h6.u f17213n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final C1677D f17214o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final H6.j f17215p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final H6.h f17216q;

    /* JADX INFO: renamed from: e6.G$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q6.f f17217a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InterfaceC1898g f17218b;

        public a(q6.f name, InterfaceC1898g interfaceC1898g) {
            AbstractC2304t.f(name, "name");
            this.f17217a = name;
            this.f17218b = interfaceC1898g;
        }

        public final InterfaceC1898g a() {
            return this.f17218b;
        }

        public final q6.f b() {
            return this.f17217a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && AbstractC2304t.b(this.f17217a, ((a) obj).f17217a);
        }

        public int hashCode() {
            return this.f17217a.hashCode();
        }
    }

    /* JADX INFO: renamed from: e6.G$b */
    public static abstract class b {

        /* JADX INFO: renamed from: e6.G$b$a */
        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final InterfaceC0848e f17219a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(InterfaceC0848e descriptor) {
                super(null);
                AbstractC2304t.f(descriptor, "descriptor");
                this.f17219a = descriptor;
            }

            public final InterfaceC0848e a() {
                return this.f17219a;
            }
        }

        /* JADX INFO: renamed from: e6.G$b$b, reason: collision with other inner class name */
        public static final class C0297b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0297b f17220a = new C0297b();

            public C0297b() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: e6.G$b$c */
        public static final class c extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f17221a = new c();

            public c() {
                super(null);
            }
        }

        public b() {
        }

        public /* synthetic */ b(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1680G(d6.k c8, h6.u jPackage, C1677D ownerDescriptor) {
        super(c8);
        AbstractC2304t.f(c8, "c");
        AbstractC2304t.f(jPackage, "jPackage");
        AbstractC2304t.f(ownerDescriptor, "ownerDescriptor");
        this.f17213n = jPackage;
        this.f17214o = ownerDescriptor;
        this.f17215p = c8.e().h(new C1678E(c8, this));
        this.f17216q = c8.e().d(new C1679F(this, c8));
    }

    public static final InterfaceC0848e i0(C1680G c1680g, d6.k kVar, a request) {
        AbstractC2304t.f(request, "request");
        q6.b bVar = new q6.b(c1680g.R().e(), request.b());
        InterfaceC2258v.a aVarB = request.a() != null ? kVar.a().j().b(request.a(), c1680g.m0()) : kVar.a().j().c(bVar, c1680g.m0());
        InterfaceC2260x interfaceC2260xA = aVarB != null ? aVarB.a() : null;
        q6.b bVarD = interfaceC2260xA != null ? interfaceC2260xA.d() : null;
        if (bVarD != null && (bVarD.j() || bVarD.i())) {
            return null;
        }
        b bVarP0 = c1680g.p0(interfaceC2260xA);
        if (bVarP0 instanceof b.a) {
            return ((b.a) bVarP0).a();
        }
        if (bVarP0 instanceof b.c) {
            return null;
        }
        if (!(bVarP0 instanceof b.C0297b)) {
            throw new C2487o();
        }
        InterfaceC1898g interfaceC1898gA = request.a();
        if (interfaceC1898gA == null) {
            interfaceC1898gA = kVar.a().d().a(new InterfaceC1097u.a(bVar, null, null, 4, null));
        }
        InterfaceC1898g interfaceC1898g = interfaceC1898gA;
        if ((interfaceC1898g != null ? interfaceC1898g.I() : null) != EnumC1891D.f18711b) {
            q6.c cVarE = interfaceC1898g != null ? interfaceC1898g.e() : null;
            if (cVarE == null || cVarE.c() || !AbstractC2304t.b(cVarE.d(), c1680g.R().e())) {
                return null;
            }
            C1712n c1712n = new C1712n(kVar, c1680g.R(), interfaceC1898g, null, 8, null);
            kVar.a().e().a(c1712n);
            return c1712n;
        }
        throw new IllegalStateException("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: " + interfaceC1898g + "\nClassId: " + bVar + "\nfindKotlinClass(JavaClass) = " + AbstractC2259w.a(kVar.a().j(), interfaceC1898g, c1680g.m0()) + "\nfindKotlinClass(ClassId) = " + AbstractC2259w.b(kVar.a().j(), bVar, c1680g.m0()) + '\n');
    }

    public static final Set o0(d6.k kVar, C1680G c1680g) {
        return kVar.a().d().b(c1680g.R().e());
    }

    @Override // e6.AbstractC1693U
    public void B(Collection result, q6.f name) {
        AbstractC2304t.f(result, "result");
        AbstractC2304t.f(name, "name");
    }

    @Override // e6.AbstractC1693U
    public Set D(B6.d kindFilter, B5.k kVar) {
        AbstractC2304t.f(kindFilter, "kindFilter");
        return p5.S.d();
    }

    @Override // e6.AbstractC1693U, B6.l, B6.k
    public Collection a(q6.f name, Z5.b location) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(location, "location");
        return AbstractC2595q.i();
    }

    @Override // e6.AbstractC1693U, B6.l, B6.n
    public Collection g(B6.d kindFilter, B5.k nameFilter) {
        AbstractC2304t.f(kindFilter, "kindFilter");
        AbstractC2304t.f(nameFilter, "nameFilter");
        d.a aVar = B6.d.f178c;
        if (!kindFilter.a(aVar.e() | aVar.c())) {
            return AbstractC2595q.i();
        }
        Iterable iterable = (Iterable) K().invoke();
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            InterfaceC0856m interfaceC0856m = (InterfaceC0856m) obj;
            if (interfaceC0856m instanceof InterfaceC0848e) {
                q6.f name = ((InterfaceC0848e) interfaceC0856m).getName();
                AbstractC2304t.e(name, "getName(...)");
                if (((Boolean) nameFilter.invoke(name)).booleanValue()) {
                    arrayList.add(obj);
                }
            }
        }
        return arrayList;
    }

    public final InterfaceC0848e j0(q6.f fVar, InterfaceC1898g interfaceC1898g) {
        if (!q6.h.f22676a.a(fVar)) {
            return null;
        }
        Set set = (Set) this.f17215p.invoke();
        if (interfaceC1898g != null || set == null || set.contains(fVar.b())) {
            return (InterfaceC0848e) this.f17216q.invoke(new a(fVar, interfaceC1898g));
        }
        return null;
    }

    public final InterfaceC0848e k0(InterfaceC1898g javaClass) {
        AbstractC2304t.f(javaClass, "javaClass");
        return j0(javaClass.getName(), javaClass);
    }

    @Override // B6.l, B6.n
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public InterfaceC0848e e(q6.f name, Z5.b location) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(location, "location");
        return j0(name, null);
    }

    public final C2602e m0() {
        return S6.c.a(L().a().b().f().g());
    }

    @Override // e6.AbstractC1693U
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public C1677D R() {
        return this.f17214o;
    }

    public final b p0(InterfaceC2260x interfaceC2260x) {
        if (interfaceC2260x != null) {
            if (interfaceC2260x.b().c() != C2284a.EnumC0339a.f20424e) {
                return b.c.f17221a;
            }
            InterfaceC0848e interfaceC0848eN = L().a().b().n(interfaceC2260x);
            if (interfaceC0848eN != null) {
                return new b.a(interfaceC0848eN);
            }
        }
        return b.C0297b.f17220a;
    }

    @Override // e6.AbstractC1693U
    public Set v(B6.d kindFilter, B5.k kVar) {
        AbstractC2304t.f(kindFilter, "kindFilter");
        if (!kindFilter.a(B6.d.f178c.e())) {
            return p5.S.d();
        }
        Set set = (Set) this.f17215p.invoke();
        if (set != null) {
            HashSet hashSet = new HashSet();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                hashSet.add(q6.f.l((String) it.next()));
            }
            return hashSet;
        }
        h6.u uVar = this.f17213n;
        if (kVar == null) {
            kVar = S6.j.k();
        }
        Collection<InterfaceC1898g> collectionG = uVar.G(kVar);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (InterfaceC1898g interfaceC1898g : collectionG) {
            q6.f name = interfaceC1898g.I() == EnumC1891D.f18710a ? null : interfaceC1898g.getName();
            if (name != null) {
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // e6.AbstractC1693U
    public Set x(B6.d kindFilter, B5.k kVar) {
        AbstractC2304t.f(kindFilter, "kindFilter");
        return p5.S.d();
    }

    @Override // e6.AbstractC1693U
    public InterfaceC1701c z() {
        return InterfaceC1701c.a.f17275a;
    }
}
