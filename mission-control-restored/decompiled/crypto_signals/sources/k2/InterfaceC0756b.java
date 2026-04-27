package k2;

import java.util.Set;

/* JADX INFO: renamed from: k2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC0756b {
    default Object a(C0769o c0769o) {
        X2.b bVarG = g(c0769o);
        if (bVarG == null) {
            return null;
        }
        return bVarG.get();
    }

    default Object b(Class cls) {
        return a(C0769o.a(cls));
    }

    default Set c(C0769o c0769o) {
        return (Set) d(c0769o).get();
    }

    X2.b d(C0769o c0769o);

    C0767m e(C0769o c0769o);

    default X2.b f(Class cls) {
        return g(C0769o.a(cls));
    }

    X2.b g(C0769o c0769o);

    default C0767m h(Class cls) {
        return e(C0769o.a(cls));
    }
}
