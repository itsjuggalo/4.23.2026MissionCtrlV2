package ca;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f0 implements r9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e0 f3773a;

    public f0(e0 e0Var) {
        this.f3773a = e0Var;
    }

    public static f0 a(e0 e0Var) {
        return new f0(e0Var);
    }

    public static hc.a c(e0 e0Var) {
        return (hc.a) r9.d.e(e0Var.b());
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public hc.a get() {
        return c(this.f3773a);
    }
}
