package ca;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class s0 implements r9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r0 f3802a;

    public s0(r0 r0Var) {
        this.f3802a = r0Var;
    }

    public static s0 a(r0 r0Var) {
        return new s0(r0Var);
    }

    public static da.a c(r0 r0Var) {
        return (da.a) r9.d.e(r0Var.a());
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public da.a get() {
        return c(this.f3802a);
    }
}
