package ie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class l implements fe.t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f12400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12401b;

    public l(List providers, String debugName) {
        kotlin.jvm.internal.t.f(providers, "providers");
        kotlin.jvm.internal.t.f(debugName, "debugName");
        this.f12400a = providers;
        this.f12401b = debugName;
        providers.size();
        dd.a0.N0(providers).size();
    }

    @Override // fe.t0
    public boolean a(ef.c fqName) {
        kotlin.jvm.internal.t.f(fqName, "fqName");
        List list = this.f12400a;
        if (list != null && list.isEmpty()) {
            return true;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!fe.s0.b((fe.o0) it.next(), fqName)) {
                return false;
            }
        }
        return true;
    }

    @Override // fe.t0
    public void b(ef.c fqName, Collection packageFragments) {
        kotlin.jvm.internal.t.f(fqName, "fqName");
        kotlin.jvm.internal.t.f(packageFragments, "packageFragments");
        Iterator it = this.f12400a.iterator();
        while (it.hasNext()) {
            fe.s0.a((fe.o0) it.next(), fqName, packageFragments);
        }
    }

    @Override // fe.o0
    public List c(ef.c fqName) {
        kotlin.jvm.internal.t.f(fqName, "fqName");
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f12400a.iterator();
        while (it.hasNext()) {
            fe.s0.a((fe.o0) it.next(), fqName, arrayList);
        }
        return dd.a0.I0(arrayList);
    }

    @Override // fe.o0
    public Collection t(ef.c fqName, pd.k nameFilter) {
        kotlin.jvm.internal.t.f(fqName, "fqName");
        kotlin.jvm.internal.t.f(nameFilter, "nameFilter");
        HashSet hashSet = new HashSet();
        Iterator it = this.f12400a.iterator();
        while (it.hasNext()) {
            hashSet.addAll(((fe.o0) it.next()).t(fqName, nameFilter));
        }
        return hashSet;
    }

    public String toString() {
        return this.f12401b;
    }
}
