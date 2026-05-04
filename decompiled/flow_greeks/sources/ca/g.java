package ca;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements r9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f3774a;

    public g(d dVar) {
        this.f3774a = dVar;
    }

    public static g a(d dVar) {
        return new g(dVar);
    }

    public static a7.g c(d dVar) {
        return (a7.g) r9.d.e(dVar.c());
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public a7.g get() {
        return c(this.f3774a);
    }
}
