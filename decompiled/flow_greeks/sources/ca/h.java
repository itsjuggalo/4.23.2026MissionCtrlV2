package ca;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements r9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f3776a;

    public h(d dVar) {
        this.f3776a = dVar;
    }

    public static h a(d dVar) {
        return new h(dVar);
    }

    public static ga.h c(d dVar) {
        return (ga.h) r9.d.e(dVar.d());
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ga.h get() {
        return c(this.f3776a);
    }
}
