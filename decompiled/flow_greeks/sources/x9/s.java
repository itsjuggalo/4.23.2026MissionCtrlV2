package x9;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class s implements t9.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f24707a;

    public s(q qVar) {
        this.f24707a = qVar;
    }

    public static s a(q qVar) {
        return new s(qVar);
    }

    public static ea.i c(q qVar) {
        return (ea.i) t9.d.d(qVar.b());
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ea.i get() {
        return c(this.f24707a);
    }
}
