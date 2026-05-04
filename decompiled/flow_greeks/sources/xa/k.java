package xa;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements wa.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f24761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f24762b;

    public k(bd.a aVar, bd.a aVar2) {
        this.f24761a = aVar;
        this.f24762b = aVar2;
    }

    public static k a(bd.a aVar, bd.a aVar2) {
        return new k(aVar, aVar2);
    }

    public static j c(o oVar, o oVar2) {
        return new j(oVar, oVar2);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public j get() {
        return c((o) this.f24761a.get(), (o) this.f24762b.get());
    }
}
