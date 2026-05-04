package ua;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g0 implements wa.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f22581a;

    public g0(bd.a aVar) {
        this.f22581a = aVar;
    }

    public static g0 a(bd.a aVar) {
        return new g0(aVar);
    }

    public static f0 c(n0 n0Var) {
        return new f0(n0Var);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public f0 get() {
        return c((n0) this.f22581a.get());
    }
}
