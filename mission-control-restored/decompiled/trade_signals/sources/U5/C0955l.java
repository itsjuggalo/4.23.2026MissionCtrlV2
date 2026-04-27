package U5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: U5.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0955l implements R5.U {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f8334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8335b;

    public C0955l(List providers, String debugName) {
        AbstractC2304t.f(providers, "providers");
        AbstractC2304t.f(debugName, "debugName");
        this.f8334a = providers;
        this.f8335b = debugName;
        providers.size();
        p5.z.K0(providers).size();
    }

    @Override // R5.U
    public boolean a(q6.c fqName) {
        AbstractC2304t.f(fqName, "fqName");
        List list = this.f8334a;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!R5.T.b((R5.O) it.next(), fqName)) {
                return false;
            }
        }
        return true;
    }

    @Override // R5.U
    public void b(q6.c fqName, Collection packageFragments) {
        AbstractC2304t.f(fqName, "fqName");
        AbstractC2304t.f(packageFragments, "packageFragments");
        Iterator it = this.f8334a.iterator();
        while (it.hasNext()) {
            R5.T.a((R5.O) it.next(), fqName, packageFragments);
        }
    }

    @Override // R5.O
    public List c(q6.c fqName) {
        AbstractC2304t.f(fqName, "fqName");
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f8334a.iterator();
        while (it.hasNext()) {
            R5.T.a((R5.O) it.next(), fqName, arrayList);
        }
        return p5.z.G0(arrayList);
    }

    public String toString() {
        return this.f8335b;
    }

    @Override // R5.O
    public Collection v(q6.c fqName, B5.k nameFilter) {
        AbstractC2304t.f(fqName, "fqName");
        AbstractC2304t.f(nameFilter, "nameFilter");
        HashSet hashSet = new HashSet();
        Iterator it = this.f8334a.iterator();
        while (it.hasNext()) {
            hashSet.addAll(((R5.O) it.next()).v(fqName, nameFilter));
        }
        return hashSet;
    }
}
