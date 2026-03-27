package e6;

import R5.InterfaceC0848e;
import R5.InterfaceC0851h;
import R5.InterfaceC0852i;
import j6.InterfaceC2260x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2592n;

/* JADX INFO: renamed from: e6.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1704f implements B6.k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ I5.m[] f17279f = {kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(C1704f.class, "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", 0))};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d6.k f17280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C1677D f17281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C1680G f17282d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final H6.i f17283e;

    public C1704f(d6.k c8, h6.u jPackage, C1677D packageFragment) {
        AbstractC2304t.f(c8, "c");
        AbstractC2304t.f(jPackage, "jPackage");
        AbstractC2304t.f(packageFragment, "packageFragment");
        this.f17280b = c8;
        this.f17281c = packageFragment;
        this.f17282d = new C1680G(c8, jPackage, packageFragment);
        this.f17283e = c8.e().e(new C1703e(this));
    }

    public static final B6.k[] k(C1704f c1704f) {
        Collection collectionValues = c1704f.f17281c.P0().values();
        ArrayList arrayList = new ArrayList();
        Iterator it = collectionValues.iterator();
        while (it.hasNext()) {
            B6.k kVarC = c1704f.f17280b.a().b().c(c1704f.f17281c, (InterfaceC2260x) it.next());
            if (kVarC != null) {
                arrayList.add(kVarC);
            }
        }
        return (B6.k[]) R6.a.b(arrayList).toArray(new B6.k[0]);
    }

    @Override // B6.k
    public Collection a(q6.f name, Z5.b location) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(location, "location");
        l(name, location);
        C1680G c1680g = this.f17282d;
        B6.k[] kVarArrJ = j();
        Collection collectionA = c1680g.a(name, location);
        for (B6.k kVar : kVarArrJ) {
            collectionA = R6.a.a(collectionA, kVar.a(name, location));
        }
        return collectionA == null ? p5.S.d() : collectionA;
    }

    @Override // B6.k
    public Set b() {
        B6.k[] kVarArrJ = j();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (B6.k kVar : kVarArrJ) {
            p5.v.x(linkedHashSet, kVar.b());
        }
        linkedHashSet.addAll(this.f17282d.b());
        return linkedHashSet;
    }

    @Override // B6.k
    public Set c() {
        B6.k[] kVarArrJ = j();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (B6.k kVar : kVarArrJ) {
            p5.v.x(linkedHashSet, kVar.c());
        }
        linkedHashSet.addAll(this.f17282d.c());
        return linkedHashSet;
    }

    @Override // B6.k
    public Collection d(q6.f name, Z5.b location) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(location, "location");
        l(name, location);
        C1680G c1680g = this.f17282d;
        B6.k[] kVarArrJ = j();
        Collection collectionD = c1680g.d(name, location);
        for (B6.k kVar : kVarArrJ) {
            collectionD = R6.a.a(collectionD, kVar.d(name, location));
        }
        return collectionD == null ? p5.S.d() : collectionD;
    }

    @Override // B6.n
    public InterfaceC0851h e(q6.f name, Z5.b location) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(location, "location");
        l(name, location);
        InterfaceC0848e interfaceC0848eE = this.f17282d.e(name, location);
        if (interfaceC0848eE != null) {
            return interfaceC0848eE;
        }
        InterfaceC0851h interfaceC0851h = null;
        for (B6.k kVar : j()) {
            InterfaceC0851h interfaceC0851hE = kVar.e(name, location);
            if (interfaceC0851hE != null) {
                if (!(interfaceC0851hE instanceof InterfaceC0852i) || !((R5.D) interfaceC0851hE).L()) {
                    return interfaceC0851hE;
                }
                if (interfaceC0851h == null) {
                    interfaceC0851h = interfaceC0851hE;
                }
            }
        }
        return interfaceC0851h;
    }

    @Override // B6.k
    public Set f() {
        Set setA = B6.m.a(AbstractC2592n.s(j()));
        if (setA == null) {
            return null;
        }
        setA.addAll(this.f17282d.f());
        return setA;
    }

    @Override // B6.n
    public Collection g(B6.d kindFilter, B5.k nameFilter) {
        AbstractC2304t.f(kindFilter, "kindFilter");
        AbstractC2304t.f(nameFilter, "nameFilter");
        C1680G c1680g = this.f17282d;
        B6.k[] kVarArrJ = j();
        Collection collectionG = c1680g.g(kindFilter, nameFilter);
        for (B6.k kVar : kVarArrJ) {
            collectionG = R6.a.a(collectionG, kVar.g(kindFilter, nameFilter));
        }
        return collectionG == null ? p5.S.d() : collectionG;
    }

    public final C1680G i() {
        return this.f17282d;
    }

    public final B6.k[] j() {
        return (B6.k[]) H6.m.a(this.f17283e, this, f17279f[0]);
    }

    public void l(q6.f name, Z5.b location) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(location, "location");
        Y5.a.b(this.f17280b.a().l(), location, this.f17281c, name);
    }

    public String toString() {
        return "scope for " + this.f17281c;
    }
}
