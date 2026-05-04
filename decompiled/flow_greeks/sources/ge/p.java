package ge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class p implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f10569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f10570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pd.k f10571c;

    public p(h delegate, boolean z10, pd.k fqNameFilter) {
        t.f(delegate, "delegate");
        t.f(fqNameFilter, "fqNameFilter");
        this.f10569a = delegate;
        this.f10570b = z10;
        this.f10571c = fqNameFilter;
    }

    @Override // ge.h
    public boolean E(ef.c fqName) {
        t.f(fqName, "fqName");
        if (((Boolean) this.f10571c.invoke(fqName)).booleanValue()) {
            return this.f10569a.E(fqName);
        }
        return false;
    }

    public final boolean a(c cVar) {
        ef.c cVarE = cVar.e();
        return cVarE != null && ((Boolean) this.f10571c.invoke(cVarE)).booleanValue();
    }

    @Override // ge.h
    public c b(ef.c fqName) {
        t.f(fqName, "fqName");
        if (((Boolean) this.f10571c.invoke(fqName)).booleanValue()) {
            return this.f10569a.b(fqName);
        }
        return null;
    }

    @Override // ge.h
    public boolean isEmpty() {
        boolean z10;
        h hVar = this.f10569a;
        if ((hVar instanceof Collection) && ((Collection) hVar).isEmpty()) {
            z10 = false;
        } else {
            Iterator it = hVar.iterator();
            while (it.hasNext()) {
                if (a((c) it.next())) {
                    z10 = true;
                    break;
                }
            }
            z10 = false;
        }
        return this.f10570b ? !z10 : z10;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        h hVar = this.f10569a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : hVar) {
            if (a((c) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList.iterator();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public p(h delegate, pd.k fqNameFilter) {
        this(delegate, false, fqNameFilter);
        t.f(delegate, "delegate");
        t.f(fqNameFilter, "fqNameFilter");
    }
}
