package B6;

import R5.InterfaceC0851h;
import java.util.Collection;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements k {
    @Override // B6.k
    public Collection a(q6.f name, Z5.b location) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(location, "location");
        return i().a(name, location);
    }

    @Override // B6.k
    public Set b() {
        return i().b();
    }

    @Override // B6.k
    public Set c() {
        return i().c();
    }

    @Override // B6.k
    public Collection d(q6.f name, Z5.b location) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(location, "location");
        return i().d(name, location);
    }

    @Override // B6.n
    public InterfaceC0851h e(q6.f name, Z5.b location) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(location, "location");
        return i().e(name, location);
    }

    @Override // B6.k
    public Set f() {
        return i().f();
    }

    @Override // B6.n
    public Collection g(d kindFilter, B5.k nameFilter) {
        AbstractC2304t.f(kindFilter, "kindFilter");
        AbstractC2304t.f(nameFilter, "nameFilter");
        return i().g(kindFilter, nameFilter);
    }

    public final k h() {
        if (!(i() instanceof a)) {
            return i();
        }
        k kVarI = i();
        AbstractC2304t.d(kVarI, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.AbstractScopeAdapter");
        return ((a) kVarI).h();
    }

    public abstract k i();
}
