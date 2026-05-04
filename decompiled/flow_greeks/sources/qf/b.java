package qf;

import dd.u0;
import fe.d0;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import qf.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f19040d = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k[] f19042c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final k a(String debugName, Iterable scopes) {
            kotlin.jvm.internal.t.f(debugName, "debugName");
            kotlin.jvm.internal.t.f(scopes, "scopes");
            hg.k kVar = new hg.k();
            Iterator it = scopes.iterator();
            while (it.hasNext()) {
                k kVar2 = (k) it.next();
                if (kVar2 != k.b.f19087b) {
                    if (kVar2 instanceof b) {
                        dd.w.A(kVar, ((b) kVar2).f19042c);
                    } else {
                        kVar.add(kVar2);
                    }
                }
            }
            return b(debugName, kVar);
        }

        public final k b(String debugName, List scopes) {
            kotlin.jvm.internal.t.f(debugName, "debugName");
            kotlin.jvm.internal.t.f(scopes, "scopes");
            int size = scopes.size();
            return size != 0 ? size != 1 ? new b(debugName, (k[]) scopes.toArray(new k[0]), null) : (k) scopes.get(0) : k.b.f19087b;
        }

        public a() {
        }
    }

    public /* synthetic */ b(String str, k[] kVarArr, kotlin.jvm.internal.k kVar) {
        this(str, kVarArr);
    }

    @Override // qf.k
    public Collection a(ef.f name, ne.b location) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        k[] kVarArr = this.f19042c;
        int length = kVarArr.length;
        if (length == 0) {
            return dd.r.k();
        }
        if (length == 1) {
            return kVarArr[0].a(name, location);
        }
        Collection collectionA = null;
        for (k kVar : kVarArr) {
            collectionA = gg.a.a(collectionA, kVar.a(name, location));
        }
        return collectionA == null ? u0.d() : collectionA;
    }

    @Override // qf.k
    public Set b() {
        k[] kVarArr = this.f19042c;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (k kVar : kVarArr) {
            dd.w.z(linkedHashSet, kVar.b());
        }
        return linkedHashSet;
    }

    @Override // qf.k
    public Collection c(ef.f name, ne.b location) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        k[] kVarArr = this.f19042c;
        int length = kVarArr.length;
        if (length == 0) {
            return dd.r.k();
        }
        if (length == 1) {
            return kVarArr[0].c(name, location);
        }
        Collection collectionA = null;
        for (k kVar : kVarArr) {
            collectionA = gg.a.a(collectionA, kVar.c(name, location));
        }
        return collectionA == null ? u0.d() : collectionA;
    }

    @Override // qf.k
    public Set d() {
        k[] kVarArr = this.f19042c;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (k kVar : kVarArr) {
            dd.w.z(linkedHashSet, kVar.d());
        }
        return linkedHashSet;
    }

    @Override // qf.n
    public fe.h e(ef.f name, ne.b location) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        fe.h hVar = null;
        for (k kVar : this.f19042c) {
            fe.h hVarE = kVar.e(name, location);
            if (hVarE != null) {
                if (!(hVarE instanceof fe.i) || !((d0) hVarE).N()) {
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
        return m.a(dd.n.s(this.f19042c));
    }

    @Override // qf.n
    public Collection g(d kindFilter, pd.k nameFilter) {
        kotlin.jvm.internal.t.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.t.f(nameFilter, "nameFilter");
        k[] kVarArr = this.f19042c;
        int length = kVarArr.length;
        if (length == 0) {
            return dd.r.k();
        }
        if (length == 1) {
            return kVarArr[0].g(kindFilter, nameFilter);
        }
        Collection collectionA = null;
        for (k kVar : kVarArr) {
            collectionA = gg.a.a(collectionA, kVar.g(kindFilter, nameFilter));
        }
        return collectionA == null ? u0.d() : collectionA;
    }

    public String toString() {
        return this.f19041b;
    }

    public b(String str, k[] kVarArr) {
        this.f19041b = str;
        this.f19042c = kVarArr;
    }
}
