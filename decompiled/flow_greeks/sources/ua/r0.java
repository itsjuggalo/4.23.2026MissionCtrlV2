package ua;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class r0 implements wa.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f22646a;

    public r0(bd.a aVar) {
        this.f22646a = aVar;
    }

    public static r0 a(bd.a aVar) {
        return new r0(aVar);
    }

    public static q0 c(s0 s0Var) {
        return new q0(s0Var);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public q0 get() {
        return c((s0) this.f22646a.get());
    }
}
