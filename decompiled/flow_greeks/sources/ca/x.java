package ca;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class x implements r9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f3814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f3815b;

    public x(w wVar, bd.a aVar) {
        this.f3814a = wVar;
        this.f3815b = aVar;
    }

    public static x a(w wVar, bd.a aVar) {
        return new x(wVar, aVar);
    }

    public static rb.d c(w wVar, String str) {
        return (rb.d) r9.d.e(wVar.a(str));
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public rb.d get() {
        return c(this.f3814a, (String) this.f3815b.get());
    }
}
