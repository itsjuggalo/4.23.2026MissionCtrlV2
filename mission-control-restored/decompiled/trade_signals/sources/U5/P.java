package U5;

import B6.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes2.dex */
public class P extends B6.l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final R5.H f8266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q6.c f8267c;

    public P(R5.H moduleDescriptor, q6.c fqName) {
        AbstractC2304t.f(moduleDescriptor, "moduleDescriptor");
        AbstractC2304t.f(fqName, "fqName");
        this.f8266b = moduleDescriptor;
        this.f8267c = fqName;
    }

    @Override // B6.l, B6.k
    public Set f() {
        return p5.S.d();
    }

    @Override // B6.l, B6.n
    public Collection g(B6.d kindFilter, B5.k nameFilter) {
        AbstractC2304t.f(kindFilter, "kindFilter");
        AbstractC2304t.f(nameFilter, "nameFilter");
        if (!kindFilter.a(B6.d.f178c.f())) {
            return AbstractC2595q.i();
        }
        if (this.f8267c.c() && kindFilter.l().contains(c.b.f177a)) {
            return AbstractC2595q.i();
        }
        Collection collectionV = this.f8266b.v(this.f8267c, nameFilter);
        ArrayList arrayList = new ArrayList(collectionV.size());
        Iterator it = collectionV.iterator();
        while (it.hasNext()) {
            q6.f fVarF = ((q6.c) it.next()).f();
            if (((Boolean) nameFilter.invoke(fVarF)).booleanValue()) {
                S6.a.a(arrayList, h(fVarF));
            }
        }
        return arrayList;
    }

    public final R5.V h(q6.f name) {
        AbstractC2304t.f(name, "name");
        if (name.m()) {
            return null;
        }
        R5.V vU0 = this.f8266b.u0(this.f8267c.b(name));
        if (vU0.isEmpty()) {
            return null;
        }
        return vU0;
    }

    public String toString() {
        return "subpackages of " + this.f8267c + " from " + this.f8266b;
    }
}
