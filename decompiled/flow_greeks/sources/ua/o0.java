package ua;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class o0 implements wa.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f22634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f22635b;

    public o0(bd.a aVar, bd.a aVar2) {
        this.f22634a = aVar;
        this.f22635b = aVar2;
    }

    public static o0 a(bd.a aVar, bd.a aVar2) {
        return new o0(aVar, aVar2);
    }

    public static n0 c(w0 w0Var, y0 y0Var) {
        return new n0(w0Var, y0Var);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public n0 get() {
        return c((w0) this.f22634a.get(), (y0) this.f22635b.get());
    }
}
