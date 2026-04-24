package K6;

import R5.InterfaceC0851h;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends g {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(h kind, String... formatParams) {
        super(kind, (String[]) Arrays.copyOf(formatParams, formatParams.length));
        AbstractC2304t.f(kind, "kind");
        AbstractC2304t.f(formatParams, "formatParams");
    }

    @Override // K6.g, B6.k
    public Set b() {
        throw new IllegalStateException();
    }

    @Override // K6.g, B6.k
    public Set c() {
        throw new IllegalStateException();
    }

    @Override // K6.g, B6.n
    public InterfaceC0851h e(q6.f name, Z5.b location) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(location, "location");
        throw new IllegalStateException(j() + ", required name: " + name);
    }

    @Override // K6.g, B6.k
    public Set f() {
        throw new IllegalStateException();
    }

    @Override // K6.g, B6.n
    public Collection g(B6.d kindFilter, B5.k nameFilter) {
        AbstractC2304t.f(kindFilter, "kindFilter");
        AbstractC2304t.f(nameFilter, "nameFilter");
        throw new IllegalStateException(j());
    }

    @Override // K6.g, B6.k
    /* JADX INFO: renamed from: h */
    public Set d(q6.f name, Z5.b location) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(location, "location");
        throw new IllegalStateException(j() + ", required name: " + name);
    }

    @Override // K6.g, B6.k
    /* JADX INFO: renamed from: i */
    public Set a(q6.f name, Z5.b location) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(location, "location");
        throw new IllegalStateException(j() + ", required name: " + name);
    }

    @Override // K6.g
    public String toString() {
        return "ThrowingScope{" + j() + '}';
    }
}
