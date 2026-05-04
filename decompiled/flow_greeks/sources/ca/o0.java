package ca;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class o0 implements r9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n0 f3793a;

    public o0(n0 n0Var) {
        this.f3793a = n0Var;
    }

    public static o0 a(n0 n0Var) {
        return new o0(n0Var);
    }

    public static cc.r c(n0 n0Var) {
        return (cc.r) r9.d.e(n0Var.a());
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public cc.r get() {
        return c(this.f3793a);
    }
}
