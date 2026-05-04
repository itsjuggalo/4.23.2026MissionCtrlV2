package xa;

import ua.w0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class n implements wa.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f24777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f24778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bd.a f24779c;

    public n(bd.a aVar, bd.a aVar2, bd.a aVar3) {
        this.f24777a = aVar;
        this.f24778b = aVar2;
        this.f24779c = aVar3;
    }

    public static n a(bd.a aVar, bd.a aVar2, bd.a aVar3) {
        return new n(aVar, aVar2, aVar3);
    }

    public static m c(gd.i iVar, w0 w0Var, l1.i iVar2) {
        return new m(iVar, w0Var, iVar2);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public m get() {
        return c((gd.i) this.f24777a.get(), (w0) this.f24778b.get(), (l1.i) this.f24779c.get());
    }
}
