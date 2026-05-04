package ca;

import aa.n2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g0 implements r9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e0 f3775a;

    public g0(e0 e0Var) {
        this.f3775a = e0Var;
    }

    public static g0 a(e0 e0Var) {
        return new g0(e0Var);
    }

    public static n2 c(e0 e0Var) {
        return (n2) r9.d.e(e0Var.c());
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public n2 get() {
        return c(this.f3775a);
    }
}
