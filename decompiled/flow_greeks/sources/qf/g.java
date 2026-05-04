package qf;

import fe.k1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f19080b;

    public g(k workerScope) {
        kotlin.jvm.internal.t.f(workerScope, "workerScope");
        this.f19080b = workerScope;
    }

    @Override // qf.l, qf.k
    public Set b() {
        return this.f19080b.b();
    }

    @Override // qf.l, qf.k
    public Set d() {
        return this.f19080b.d();
    }

    @Override // qf.l, qf.n
    public fe.h e(ef.f name, ne.b location) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        fe.h hVarE = this.f19080b.e(name, location);
        if (hVarE != null) {
            fe.e eVar = hVarE instanceof fe.e ? (fe.e) hVarE : null;
            if (eVar != null) {
                return eVar;
            }
            if (hVarE instanceof k1) {
                return (k1) hVarE;
            }
        }
        return null;
    }

    @Override // qf.l, qf.k
    public Set f() {
        return this.f19080b.f();
    }

    @Override // qf.l, qf.n
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public List g(d kindFilter, pd.k nameFilter) {
        kotlin.jvm.internal.t.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.t.f(nameFilter, "nameFilter");
        d dVarN = kindFilter.n(d.f19046c.c());
        if (dVarN == null) {
            return dd.r.k();
        }
        Collection collectionG = this.f19080b.g(dVarN, nameFilter);
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionG) {
            if (obj instanceof fe.i) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public String toString() {
        return "Classes from " + this.f19080b;
    }
}
