package qf;

import java.util.Collection;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements k {
    @Override // qf.k
    public Collection a(ef.f name, ne.b location) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        return i().a(name, location);
    }

    @Override // qf.k
    public Set b() {
        return i().b();
    }

    @Override // qf.k
    public Collection c(ef.f name, ne.b location) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        return i().c(name, location);
    }

    @Override // qf.k
    public Set d() {
        return i().d();
    }

    @Override // qf.n
    public fe.h e(ef.f name, ne.b location) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        return i().e(name, location);
    }

    @Override // qf.k
    public Set f() {
        return i().f();
    }

    @Override // qf.n
    public Collection g(d kindFilter, pd.k nameFilter) {
        kotlin.jvm.internal.t.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.t.f(nameFilter, "nameFilter");
        return i().g(kindFilter, nameFilter);
    }

    public final k h() {
        if (!(i() instanceof a)) {
            return i();
        }
        k kVarI = i();
        kotlin.jvm.internal.t.d(kVarI, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.AbstractScopeAdapter");
        return ((a) kVarI).h();
    }

    public abstract k i();
}
