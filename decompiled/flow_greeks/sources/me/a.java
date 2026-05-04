package me;

import ef.f;
import fe.e;
import fe.n0;
import kotlin.jvm.internal.t;
import ne.b;
import ne.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static final void a(c cVar, b from, e scopeOwner, f name) {
        t.f(cVar, "<this>");
        t.f(from, "from");
        t.f(scopeOwner, "scopeOwner");
        t.f(name, "name");
        if (cVar == c.a.f17033a) {
            return;
        }
        from.a();
    }

    public static final void b(c cVar, b from, n0 scopeOwner, f name) {
        t.f(cVar, "<this>");
        t.f(from, "from");
        t.f(scopeOwner, "scopeOwner");
        t.f(name, "name");
        String strA = scopeOwner.e().a();
        String strB = name.b();
        t.e(strB, "asString(...)");
        c(cVar, from, strA, strB);
    }

    public static final void c(c cVar, b from, String packageFqName, String name) {
        t.f(cVar, "<this>");
        t.f(from, "from");
        t.f(packageFqName, "packageFqName");
        t.f(name, "name");
        if (cVar == c.a.f17033a) {
            return;
        }
        from.a();
    }
}
