package xa;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements wa.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f24739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f24740b;

    public f(bd.a aVar, bd.a aVar2) {
        this.f24739a = aVar;
        this.f24740b = aVar2;
    }

    public static f a(bd.a aVar, bd.a aVar2) {
        return new f(aVar, aVar2);
    }

    public static e c(ua.b bVar, gd.i iVar) {
        return new e(bVar, iVar);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public e get() {
        return c((ua.b) this.f24739a.get(), (gd.i) this.f24740b.get());
    }
}
