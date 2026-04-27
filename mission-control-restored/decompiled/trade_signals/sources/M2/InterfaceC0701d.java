package M2;

import java.util.Set;

/* JADX INFO: renamed from: M2.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC0701d {
    S3.a a(E e8);

    default Set b(E e8) {
        return (Set) e(e8).get();
    }

    default S3.b c(Class cls) {
        return f(E.b(cls));
    }

    default Object d(E e8) {
        S3.b bVarF = f(e8);
        if (bVarF == null) {
            return null;
        }
        return bVarF.get();
    }

    S3.b e(E e8);

    S3.b f(E e8);

    default Set g(Class cls) {
        return b(E.b(cls));
    }

    default Object get(Class cls) {
        return d(E.b(cls));
    }

    default S3.a h(Class cls) {
        return a(E.b(cls));
    }
}
