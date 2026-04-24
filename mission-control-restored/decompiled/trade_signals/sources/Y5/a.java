package Y5;

import R5.InterfaceC0848e;
import R5.N;
import Z5.b;
import Z5.c;
import kotlin.jvm.internal.AbstractC2304t;
import q6.f;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static final void a(c cVar, b from, InterfaceC0848e scopeOwner, f name) {
        AbstractC2304t.f(cVar, "<this>");
        AbstractC2304t.f(from, "from");
        AbstractC2304t.f(scopeOwner, "scopeOwner");
        AbstractC2304t.f(name, "name");
        if (cVar == c.a.f9769a) {
            return;
        }
        from.a();
    }

    public static final void b(c cVar, b from, N scopeOwner, f name) {
        AbstractC2304t.f(cVar, "<this>");
        AbstractC2304t.f(from, "from");
        AbstractC2304t.f(scopeOwner, "scopeOwner");
        AbstractC2304t.f(name, "name");
        String strA = scopeOwner.e().a();
        String strB = name.b();
        AbstractC2304t.e(strB, "asString(...)");
        c(cVar, from, strA, strB);
    }

    public static final void c(c cVar, b from, String packageFqName, String name) {
        AbstractC2304t.f(cVar, "<this>");
        AbstractC2304t.f(from, "from");
        AbstractC2304t.f(packageFqName, "packageFqName");
        AbstractC2304t.f(name, "name");
        if (cVar == c.a.f9769a) {
            return;
        }
        from.a();
    }
}
