package u9;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements t9.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f22445a;

    public f(bd.a aVar) {
        this.f22445a = aVar;
    }

    public static f a(bd.a aVar) {
        return new f(aVar);
    }

    public static e c(com.bumptech.glide.k kVar) {
        return new e(kVar);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public e get() {
        return c((com.bumptech.glide.k) this.f22445a.get());
    }
}
