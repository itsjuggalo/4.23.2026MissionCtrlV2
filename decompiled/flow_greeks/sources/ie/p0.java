package ie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import qf.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class p0 extends qf.l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final fe.h0 f12411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ef.c f12412c;

    public p0(fe.h0 moduleDescriptor, ef.c fqName) {
        kotlin.jvm.internal.t.f(moduleDescriptor, "moduleDescriptor");
        kotlin.jvm.internal.t.f(fqName, "fqName");
        this.f12411b = moduleDescriptor;
        this.f12412c = fqName;
    }

    @Override // qf.l, qf.k
    public Set f() {
        return dd.u0.d();
    }

    @Override // qf.l, qf.n
    public Collection g(qf.d kindFilter, pd.k nameFilter) {
        kotlin.jvm.internal.t.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.t.f(nameFilter, "nameFilter");
        if (!kindFilter.a(qf.d.f19046c.f())) {
            return dd.r.k();
        }
        if (this.f12412c.c() && kindFilter.l().contains(c.b.f19045a)) {
            return dd.r.k();
        }
        Collection collectionT = this.f12411b.t(this.f12412c, nameFilter);
        ArrayList arrayList = new ArrayList(collectionT.size());
        Iterator it = collectionT.iterator();
        while (it.hasNext()) {
            ef.f fVarF = ((ef.c) it.next()).f();
            if (((Boolean) nameFilter.invoke(fVarF)).booleanValue()) {
                hg.a.a(arrayList, h(fVarF));
            }
        }
        return arrayList;
    }

    public final fe.u0 h(ef.f name) {
        kotlin.jvm.internal.t.f(name, "name");
        if (name.l()) {
            return null;
        }
        fe.u0 u0VarI0 = this.f12411b.I0(this.f12412c.b(name));
        if (u0VarI0.isEmpty()) {
            return null;
        }
        return u0VarI0;
    }

    public String toString() {
        return "subpackages of " + this.f12412c + " from " + this.f12411b;
    }
}
