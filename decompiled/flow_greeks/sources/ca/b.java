package ca;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements r9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f3753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f3754b;

    public b(a aVar, bd.a aVar2) {
        this.f3753a = aVar;
        this.f3754b = aVar2;
    }

    public static b a(a aVar, bd.a aVar2) {
        return new b(aVar, aVar2);
    }

    public static hc.a c(a aVar, aa.c cVar) {
        return (hc.a) r9.d.e(aVar.a(cVar));
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public hc.a get() {
        return c(this.f3753a, (aa.c) this.f3754b.get());
    }
}
