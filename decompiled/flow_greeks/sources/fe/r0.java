package fe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class r0 implements t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Collection f9506a;

    public r0(Collection packageFragments) {
        kotlin.jvm.internal.t.f(packageFragments, "packageFragments");
        this.f9506a = packageFragments;
    }

    public static final ef.c f(n0 it) {
        kotlin.jvm.internal.t.f(it, "it");
        return it.e();
    }

    public static final boolean g(ef.c cVar, ef.c it) {
        kotlin.jvm.internal.t.f(it, "it");
        return !it.c() && kotlin.jvm.internal.t.b(it.d(), cVar);
    }

    @Override // fe.t0
    public boolean a(ef.c fqName) {
        kotlin.jvm.internal.t.f(fqName, "fqName");
        Collection collection = this.f9506a;
        if (collection != null && collection.isEmpty()) {
            return true;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.t.b(((n0) it.next()).e(), fqName)) {
                return false;
            }
        }
        return true;
    }

    @Override // fe.t0
    public void b(ef.c fqName, Collection packageFragments) {
        kotlin.jvm.internal.t.f(fqName, "fqName");
        kotlin.jvm.internal.t.f(packageFragments, "packageFragments");
        for (Object obj : this.f9506a) {
            if (kotlin.jvm.internal.t.b(((n0) obj).e(), fqName)) {
                packageFragments.add(obj);
            }
        }
    }

    @Override // fe.o0
    public List c(ef.c fqName) {
        kotlin.jvm.internal.t.f(fqName, "fqName");
        Collection collection = this.f9506a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (kotlin.jvm.internal.t.b(((n0) obj).e(), fqName)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // fe.o0
    public Collection t(ef.c fqName, pd.k nameFilter) {
        kotlin.jvm.internal.t.f(fqName, "fqName");
        kotlin.jvm.internal.t.f(nameFilter, "nameFilter");
        return jg.t.M(jg.t.x(jg.t.E(dd.a0.Q(this.f9506a), p0.f9503a), new q0(fqName)));
    }
}
