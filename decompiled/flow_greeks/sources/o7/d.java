package o7;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public interface d {
    fa.a a(e0 e0Var);

    default fa.b b(Class cls) {
        return d(e0.b(cls));
    }

    default Set c(Class cls) {
        return e(e0.b(cls));
    }

    fa.b d(e0 e0Var);

    default Set e(e0 e0Var) {
        return (Set) g(e0Var).get();
    }

    default Object f(e0 e0Var) {
        fa.b bVarD = d(e0Var);
        if (bVarD == null) {
            return null;
        }
        return bVarD.get();
    }

    fa.b g(e0 e0Var);

    default Object get(Class cls) {
        return f(e0.b(cls));
    }

    default fa.a h(Class cls) {
        return a(e0.b(cls));
    }
}
