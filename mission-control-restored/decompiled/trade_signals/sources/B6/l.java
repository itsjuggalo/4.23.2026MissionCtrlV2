package B6;

import R5.InterfaceC0851h;
import R5.g0;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l implements k {
    @Override // B6.k
    public Collection a(q6.f name, Z5.b location) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(location, "location");
        return AbstractC2595q.i();
    }

    @Override // B6.k
    public Set b() {
        Collection collectionG = g(d.f197v, S6.j.k());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : collectionG) {
            if (obj instanceof g0) {
                q6.f name = ((g0) obj).getName();
                AbstractC2304t.e(name, "getName(...)");
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // B6.k
    public Set c() {
        Collection collectionG = g(d.f198w, S6.j.k());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : collectionG) {
            if (obj instanceof g0) {
                q6.f name = ((g0) obj).getName();
                AbstractC2304t.e(name, "getName(...)");
                linkedHashSet.add(name);
            }
        }
        return linkedHashSet;
    }

    @Override // B6.k
    public Collection d(q6.f name, Z5.b location) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(location, "location");
        return AbstractC2595q.i();
    }

    @Override // B6.n
    public InterfaceC0851h e(q6.f name, Z5.b location) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(location, "location");
        return null;
    }

    @Override // B6.k
    public Set f() {
        return null;
    }

    @Override // B6.n
    public Collection g(d kindFilter, B5.k nameFilter) {
        AbstractC2304t.f(kindFilter, "kindFilter");
        AbstractC2304t.f(nameFilter, "nameFilter");
        return AbstractC2595q.i();
    }
}
