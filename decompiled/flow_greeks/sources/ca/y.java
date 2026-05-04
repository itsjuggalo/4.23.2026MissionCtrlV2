package ca;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class y implements r9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f3816a;

    public y(w wVar) {
        this.f3816a = wVar;
    }

    public static y a(w wVar) {
        return new y(wVar);
    }

    public static String c(w wVar) {
        return (String) r9.d.e(wVar.b());
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public String get() {
        return c(this.f3816a);
    }
}
