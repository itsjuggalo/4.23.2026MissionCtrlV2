package zf;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends g {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(h kind, String... formatParams) {
        super(kind, (String[]) Arrays.copyOf(formatParams, formatParams.length));
        t.f(kind, "kind");
        t.f(formatParams, "formatParams");
    }

    @Override // zf.g, qf.k
    public Set b() {
        throw new IllegalStateException();
    }

    @Override // zf.g, qf.k
    public Set d() {
        throw new IllegalStateException();
    }

    @Override // zf.g, qf.n
    public fe.h e(ef.f name, ne.b location) {
        t.f(name, "name");
        t.f(location, "location");
        throw new IllegalStateException(j() + ", required name: " + name);
    }

    @Override // zf.g, qf.k
    public Set f() {
        throw new IllegalStateException();
    }

    @Override // zf.g, qf.n
    public Collection g(qf.d kindFilter, pd.k nameFilter) {
        t.f(kindFilter, "kindFilter");
        t.f(nameFilter, "nameFilter");
        throw new IllegalStateException(j());
    }

    @Override // zf.g, qf.k
    /* JADX INFO: renamed from: h */
    public Set c(ef.f name, ne.b location) {
        t.f(name, "name");
        t.f(location, "location");
        throw new IllegalStateException(j() + ", required name: " + name);
    }

    @Override // zf.g, qf.k
    /* JADX INFO: renamed from: i */
    public Set a(ef.f name, ne.b location) {
        t.f(name, "name");
        t.f(location, "location");
        throw new IllegalStateException(j() + ", required name: " + name);
    }

    @Override // zf.g
    public String toString() {
        return "ThrowingScope{" + j() + '}';
    }
}
