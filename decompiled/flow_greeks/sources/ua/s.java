package ua;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class s implements wa.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f22647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f22648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bd.a f22649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final bd.a f22650d;

    public s(bd.a aVar, bd.a aVar2, bd.a aVar3, bd.a aVar4) {
        this.f22647a = aVar;
        this.f22648b = aVar2;
        this.f22649c = aVar3;
        this.f22650d = aVar4;
    }

    public static s a(bd.a aVar, bd.a aVar2, bd.a aVar3, bd.a aVar4) {
        return new s(aVar, aVar2, aVar3, aVar4);
    }

    public static l c(a7.g gVar, xa.j jVar, gd.i iVar, q0 q0Var) {
        return new l(gVar, jVar, iVar, q0Var);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public l get() {
        return c((a7.g) this.f22647a.get(), (xa.j) this.f22648b.get(), (gd.i) this.f22649c.get(), (q0) this.f22650d.get());
    }
}
