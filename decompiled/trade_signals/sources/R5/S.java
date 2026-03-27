package R5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class S implements U {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Collection f7219a;

    public S(Collection packageFragments) {
        AbstractC2304t.f(packageFragments, "packageFragments");
        this.f7219a = packageFragments;
    }

    public static final q6.c f(N it) {
        AbstractC2304t.f(it, "it");
        return it.e();
    }

    public static final boolean g(q6.c cVar, q6.c it) {
        AbstractC2304t.f(it, "it");
        return !it.c() && AbstractC2304t.b(it.d(), cVar);
    }

    @Override // R5.U
    public boolean a(q6.c fqName) {
        AbstractC2304t.f(fqName, "fqName");
        Collection collection = this.f7219a;
        if ((collection instanceof Collection) && collection.isEmpty()) {
            return true;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (AbstractC2304t.b(((N) it.next()).e(), fqName)) {
                return false;
            }
        }
        return true;
    }

    @Override // R5.U
    public void b(q6.c fqName, Collection packageFragments) {
        AbstractC2304t.f(fqName, "fqName");
        AbstractC2304t.f(packageFragments, "packageFragments");
        for (Object obj : this.f7219a) {
            if (AbstractC2304t.b(((N) obj).e(), fqName)) {
                packageFragments.add(obj);
            }
        }
    }

    @Override // R5.O
    public List c(q6.c fqName) {
        AbstractC2304t.f(fqName, "fqName");
        Collection collection = this.f7219a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (AbstractC2304t.b(((N) obj).e(), fqName)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // R5.O
    public Collection v(q6.c fqName, B5.k nameFilter) {
        AbstractC2304t.f(fqName, "fqName");
        AbstractC2304t.f(nameFilter, "nameFilter");
        return U6.r.J(U6.r.u(U6.r.B(p5.z.P(this.f7219a), P.f7217a), new Q(fqName)));
    }
}
