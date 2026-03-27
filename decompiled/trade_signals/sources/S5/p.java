package S5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class p implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f7676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f7677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final B5.k f7678c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public p(h delegate, B5.k fqNameFilter) {
        this(delegate, false, fqNameFilter);
        AbstractC2304t.f(delegate, "delegate");
        AbstractC2304t.f(fqNameFilter, "fqNameFilter");
    }

    public final boolean a(c cVar) {
        q6.c cVarE = cVar.e();
        return cVarE != null && ((Boolean) this.f7678c.invoke(cVarE)).booleanValue();
    }

    @Override // S5.h
    public c b(q6.c fqName) {
        AbstractC2304t.f(fqName, "fqName");
        if (((Boolean) this.f7678c.invoke(fqName)).booleanValue()) {
            return this.f7676a.b(fqName);
        }
        return null;
    }

    @Override // S5.h
    public boolean isEmpty() {
        boolean z7;
        h hVar = this.f7676a;
        if ((hVar instanceof Collection) && ((Collection) hVar).isEmpty()) {
            z7 = false;
        } else {
            Iterator it = hVar.iterator();
            while (it.hasNext()) {
                if (a((c) it.next())) {
                    z7 = true;
                    break;
                }
            }
            z7 = false;
        }
        return this.f7677b ? !z7 : z7;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        h hVar = this.f7676a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : hVar) {
            if (a((c) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList.iterator();
    }

    @Override // S5.h
    public boolean r(q6.c fqName) {
        AbstractC2304t.f(fqName, "fqName");
        if (((Boolean) this.f7678c.invoke(fqName)).booleanValue()) {
            return this.f7676a.r(fqName);
        }
        return false;
    }

    public p(h delegate, boolean z7, B5.k fqNameFilter) {
        AbstractC2304t.f(delegate, "delegate");
        AbstractC2304t.f(fqNameFilter, "fqNameFilter");
        this.f7676a = delegate;
        this.f7677b = z7;
        this.f7678c = fqNameFilter;
    }
}
