package zf;

import dd.r;
import dd.t0;
import dd.u0;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class g implements qf.k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f26475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f26476c;

    public g(h kind, String... formatParams) {
        t.f(kind, "kind");
        t.f(formatParams, "formatParams");
        this.f26475b = kind;
        String strB = kind.b();
        Object[] objArrCopyOf = Arrays.copyOf(formatParams, formatParams.length);
        String str = String.format(strB, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        t.e(str, "format(...)");
        this.f26476c = str;
    }

    @Override // qf.k
    public Set b() {
        return u0.d();
    }

    @Override // qf.k
    public Set d() {
        return u0.d();
    }

    @Override // qf.n
    public fe.h e(ef.f name, ne.b location) {
        t.f(name, "name");
        t.f(location, "location");
        String str = String.format(b.f26456b.b(), Arrays.copyOf(new Object[]{name}, 1));
        t.e(str, "format(...)");
        ef.f fVarO = ef.f.o(str);
        t.e(fVarO, "special(...)");
        return new a(fVarO);
    }

    @Override // qf.k
    public Set f() {
        return u0.d();
    }

    @Override // qf.n
    public Collection g(qf.d kindFilter, pd.k nameFilter) {
        t.f(kindFilter, "kindFilter");
        t.f(nameFilter, "nameFilter");
        return r.k();
    }

    @Override // qf.k
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public Set c(ef.f name, ne.b location) {
        t.f(name, "name");
        t.f(location, "location");
        return t0.c(new c(l.f26552a.h()));
    }

    @Override // qf.k
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public Set a(ef.f name, ne.b location) {
        t.f(name, "name");
        t.f(location, "location");
        return l.f26552a.j();
    }

    public final String j() {
        return this.f26476c;
    }

    public String toString() {
        return "ErrorScope{" + this.f26476c + '}';
    }
}
