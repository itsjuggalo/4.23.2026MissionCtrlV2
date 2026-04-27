package b3;

import java.util.Set;

/* JADX INFO: renamed from: b3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC0987d {
    default Object a(Class cls) {
        return e(C0982E.b(cls));
    }

    N3.a b(C0982E c0982e);

    default Set c(C0982E c0982e) {
        return (Set) g(c0982e).get();
    }

    default N3.b d(Class cls) {
        return h(C0982E.b(cls));
    }

    default Object e(C0982E c0982e) {
        N3.b bVarH = h(c0982e);
        if (bVarH == null) {
            return null;
        }
        return bVarH.get();
    }

    default Set f(Class cls) {
        return c(C0982E.b(cls));
    }

    N3.b g(C0982E c0982e);

    N3.b h(C0982E c0982e);

    default N3.a i(Class cls) {
        return b(C0982E.b(cls));
    }
}
