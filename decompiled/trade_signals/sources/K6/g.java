package K6;

import R5.InterfaceC0851h;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2595q;
import p5.Q;
import p5.S;

/* JADX INFO: loaded from: classes2.dex */
public class g implements B6.k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f4800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4801c;

    public g(h kind, String... formatParams) {
        AbstractC2304t.f(kind, "kind");
        AbstractC2304t.f(formatParams, "formatParams");
        this.f4800b = kind;
        String strB = kind.b();
        Object[] objArrCopyOf = Arrays.copyOf(formatParams, formatParams.length);
        String str = String.format(strB, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        AbstractC2304t.e(str, "format(...)");
        this.f4801c = str;
    }

    @Override // B6.k
    public Set b() {
        return S.d();
    }

    @Override // B6.k
    public Set c() {
        return S.d();
    }

    @Override // B6.n
    public InterfaceC0851h e(q6.f name, Z5.b location) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(location, "location");
        String str = String.format(b.f4781b.b(), Arrays.copyOf(new Object[]{name}, 1));
        AbstractC2304t.e(str, "format(...)");
        q6.f fVarQ = q6.f.q(str);
        AbstractC2304t.e(fVarQ, "special(...)");
        return new a(fVarQ);
    }

    @Override // B6.k
    public Set f() {
        return S.d();
    }

    @Override // B6.n
    public Collection g(B6.d kindFilter, B5.k nameFilter) {
        AbstractC2304t.f(kindFilter, "kindFilter");
        AbstractC2304t.f(nameFilter, "nameFilter");
        return AbstractC2595q.i();
    }

    @Override // B6.k
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public Set d(q6.f name, Z5.b location) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(location, "location");
        return Q.c(new c(l.f4913a.h()));
    }

    @Override // B6.k
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public Set a(q6.f name, Z5.b location) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(location, "location");
        return l.f4913a.j();
    }

    public final String j() {
        return this.f4801c;
    }

    public String toString() {
        return "ErrorScope{" + this.f4801c + '}';
    }
}
