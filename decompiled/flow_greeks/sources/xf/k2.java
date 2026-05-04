package xf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k2 {
    /* JADX WARN: Multi-variable type inference failed */
    public static final r0 a(r0 r0Var) {
        kotlin.jvm.internal.t.f(r0Var, "<this>");
        if (r0Var instanceof j2) {
            return ((j2) r0Var).I();
        }
        return null;
    }

    public static final l2 b(l2 l2Var, r0 origin) {
        kotlin.jvm.internal.t.f(l2Var, "<this>");
        kotlin.jvm.internal.t.f(origin, "origin");
        return d(l2Var, a(origin));
    }

    public static final l2 c(l2 l2Var, r0 origin, pd.k transform) {
        kotlin.jvm.internal.t.f(l2Var, "<this>");
        kotlin.jvm.internal.t.f(origin, "origin");
        kotlin.jvm.internal.t.f(transform, "transform");
        r0 r0VarA = a(origin);
        return d(l2Var, r0VarA != null ? (r0) transform.invoke(r0VarA) : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final l2 d(l2 l2Var, r0 r0Var) {
        kotlin.jvm.internal.t.f(l2Var, "<this>");
        if (l2Var instanceof j2) {
            return d(((j2) l2Var).F0(), r0Var);
        }
        if (r0Var == null || kotlin.jvm.internal.t.b(r0Var, l2Var)) {
            return l2Var;
        }
        if (l2Var instanceof c1) {
            return new f1((c1) l2Var, r0Var);
        }
        if (l2Var instanceof i0) {
            return new k0((i0) l2Var, r0Var);
        }
        throw new cd.o();
    }
}
