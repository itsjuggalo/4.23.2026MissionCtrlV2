package r4;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements n4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f19313a;

    public g(bd.a aVar) {
        this.f19313a = aVar;
    }

    public static s4.f a(v4.a aVar) {
        return (s4.f) n4.d.d(f.a(aVar));
    }

    public static g b(bd.a aVar) {
        return new g(aVar);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public s4.f get() {
        return a((v4.a) this.f19313a.get());
    }
}
