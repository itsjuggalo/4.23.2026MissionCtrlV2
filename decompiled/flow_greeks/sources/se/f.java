package se;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements qf.k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ wd.m[] f20239f = {kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(f.class, "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", 0))};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final re.k f20240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d0 f20241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g0 f20242d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final wf.i f20243e;

    public f(re.k c10, ve.u jPackage, d0 packageFragment) {
        kotlin.jvm.internal.t.f(c10, "c");
        kotlin.jvm.internal.t.f(jPackage, "jPackage");
        kotlin.jvm.internal.t.f(packageFragment, "packageFragment");
        this.f20240b = c10;
        this.f20241c = packageFragment;
        this.f20242d = new g0(c10, jPackage, packageFragment);
        this.f20243e = c10.e().e(new e(this));
    }

    public static final qf.k[] k(f fVar) {
        Collection collectionValues = fVar.f20241c.O0().values();
        ArrayList arrayList = new ArrayList();
        Iterator it = collectionValues.iterator();
        while (it.hasNext()) {
            qf.k kVarC = fVar.f20240b.a().b().c(fVar.f20241c, (xe.x) it.next());
            if (kVarC != null) {
                arrayList.add(kVarC);
            }
        }
        return (qf.k[]) gg.a.b(arrayList).toArray(new qf.k[0]);
    }

    @Override // qf.k
    public Collection a(ef.f name, ne.b location) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        l(name, location);
        g0 g0Var = this.f20242d;
        qf.k[] kVarArrJ = j();
        Collection collectionA = g0Var.a(name, location);
        for (qf.k kVar : kVarArrJ) {
            collectionA = gg.a.a(collectionA, kVar.a(name, location));
        }
        return collectionA == null ? dd.u0.d() : collectionA;
    }

    @Override // qf.k
    public Set b() {
        qf.k[] kVarArrJ = j();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (qf.k kVar : kVarArrJ) {
            dd.w.z(linkedHashSet, kVar.b());
        }
        linkedHashSet.addAll(this.f20242d.b());
        return linkedHashSet;
    }

    @Override // qf.k
    public Collection c(ef.f name, ne.b location) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        l(name, location);
        g0 g0Var = this.f20242d;
        qf.k[] kVarArrJ = j();
        Collection collectionC = g0Var.c(name, location);
        for (qf.k kVar : kVarArrJ) {
            collectionC = gg.a.a(collectionC, kVar.c(name, location));
        }
        return collectionC == null ? dd.u0.d() : collectionC;
    }

    @Override // qf.k
    public Set d() {
        qf.k[] kVarArrJ = j();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (qf.k kVar : kVarArrJ) {
            dd.w.z(linkedHashSet, kVar.d());
        }
        linkedHashSet.addAll(this.f20242d.d());
        return linkedHashSet;
    }

    @Override // qf.n
    public fe.h e(ef.f name, ne.b location) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        l(name, location);
        fe.e eVarE = this.f20242d.e(name, location);
        if (eVarE != null) {
            return eVarE;
        }
        fe.h hVar = null;
        for (qf.k kVar : j()) {
            fe.h hVarE = kVar.e(name, location);
            if (hVarE != null) {
                if (!(hVarE instanceof fe.i) || !((fe.d0) hVarE).N()) {
                    return hVarE;
                }
                if (hVar == null) {
                    hVar = hVarE;
                }
            }
        }
        return hVar;
    }

    @Override // qf.k
    public Set f() {
        Set setA = qf.m.a(dd.n.s(j()));
        if (setA == null) {
            return null;
        }
        setA.addAll(this.f20242d.f());
        return setA;
    }

    @Override // qf.n
    public Collection g(qf.d kindFilter, pd.k nameFilter) {
        kotlin.jvm.internal.t.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.t.f(nameFilter, "nameFilter");
        g0 g0Var = this.f20242d;
        qf.k[] kVarArrJ = j();
        Collection collectionG = g0Var.g(kindFilter, nameFilter);
        for (qf.k kVar : kVarArrJ) {
            collectionG = gg.a.a(collectionG, kVar.g(kindFilter, nameFilter));
        }
        return collectionG == null ? dd.u0.d() : collectionG;
    }

    public final g0 i() {
        return this.f20242d;
    }

    public final qf.k[] j() {
        return (qf.k[]) wf.m.a(this.f20243e, this, f20239f[0]);
    }

    public void l(ef.f name, ne.b location) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        me.a.b(this.f20240b.a().l(), location, this.f20241c, name);
    }

    public String toString() {
        return "scope for " + this.f20241c;
    }
}
