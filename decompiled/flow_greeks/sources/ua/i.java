package ua;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements wa.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f22587a;

    public i(bd.a aVar) {
        this.f22587a = aVar;
    }

    public static i a(bd.a aVar) {
        return new i(aVar);
    }

    public static g c(fa.b bVar) {
        return new g(bVar);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public g get() {
        return c((fa.b) this.f22587a.get());
    }
}
