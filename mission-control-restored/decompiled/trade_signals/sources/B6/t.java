package B6;

import B6.n;
import I6.E0;
import I6.G0;
import R5.InterfaceC0851h;
import R5.InterfaceC0856m;
import R5.j0;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2484l;
import o5.InterfaceC2483k;
import v6.AbstractC2881e;

/* JADX INFO: loaded from: classes2.dex */
public final class t implements k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2483k f230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final G0 f231d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map f232e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final InterfaceC2483k f233f;

    public t(k workerScope, G0 givenSubstitutor) {
        AbstractC2304t.f(workerScope, "workerScope");
        AbstractC2304t.f(givenSubstitutor, "givenSubstitutor");
        this.f229b = workerScope;
        this.f230c = AbstractC2484l.a(new r(givenSubstitutor));
        E0 e0J = givenSubstitutor.j();
        AbstractC2304t.e(e0J, "getSubstitution(...)");
        this.f231d = AbstractC2881e.h(e0J, false, 1, null).c();
        this.f233f = AbstractC2484l.a(new s(this));
    }

    public static final Collection h(t tVar) {
        return tVar.m(n.a.a(tVar.f229b, null, null, 3, null));
    }

    public static final G0 n(G0 g02) {
        return g02.j().c();
    }

    @Override // B6.k
    public Collection a(q6.f name, Z5.b location) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(location, "location");
        return m(this.f229b.a(name, location));
    }

    @Override // B6.k
    public Set b() {
        return this.f229b.b();
    }

    @Override // B6.k
    public Set c() {
        return this.f229b.c();
    }

    @Override // B6.k
    public Collection d(q6.f name, Z5.b location) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(location, "location");
        return m(this.f229b.d(name, location));
    }

    @Override // B6.n
    public InterfaceC0851h e(q6.f name, Z5.b location) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(location, "location");
        InterfaceC0851h interfaceC0851hE = this.f229b.e(name, location);
        if (interfaceC0851hE != null) {
            return (InterfaceC0851h) l(interfaceC0851hE);
        }
        return null;
    }

    @Override // B6.k
    public Set f() {
        return this.f229b.f();
    }

    @Override // B6.n
    public Collection g(d kindFilter, B5.k nameFilter) {
        AbstractC2304t.f(kindFilter, "kindFilter");
        AbstractC2304t.f(nameFilter, "nameFilter");
        return k();
    }

    public final Collection k() {
        return (Collection) this.f233f.getValue();
    }

    public final InterfaceC0856m l(InterfaceC0856m interfaceC0856m) {
        if (this.f231d.k()) {
            return interfaceC0856m;
        }
        if (this.f232e == null) {
            this.f232e = new HashMap();
        }
        Map map = this.f232e;
        AbstractC2304t.c(map);
        Object objC = map.get(interfaceC0856m);
        if (objC == null) {
            if (!(interfaceC0856m instanceof j0)) {
                throw new IllegalStateException(("Unknown descriptor in scope: " + interfaceC0856m).toString());
            }
            objC = ((j0) interfaceC0856m).c(this.f231d);
            if (objC == null) {
                throw new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + interfaceC0856m + " substitution fails");
            }
            map.put(interfaceC0856m, objC);
        }
        InterfaceC0856m interfaceC0856m2 = (InterfaceC0856m) objC;
        AbstractC2304t.d(interfaceC0856m2, "null cannot be cast to non-null type D of org.jetbrains.kotlin.resolve.scopes.SubstitutingScope.substitute");
        return interfaceC0856m2;
    }

    public final Collection m(Collection collection) {
        if (this.f231d.k() || collection.isEmpty()) {
            return collection;
        }
        LinkedHashSet linkedHashSetG = S6.a.g(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            linkedHashSetG.add(l((InterfaceC0856m) it.next()));
        }
        return linkedHashSetG;
    }
}
