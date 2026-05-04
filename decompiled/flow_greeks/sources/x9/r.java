package x9;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class r implements t9.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f24706a;

    public r(q qVar) {
        this.f24706a = qVar;
    }

    public static r a(q qVar) {
        return new r(qVar);
    }

    public static u9.k c(q qVar) {
        return (u9.k) t9.d.d(qVar.a());
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public u9.k get() {
        return c(this.f24706a);
    }
}
