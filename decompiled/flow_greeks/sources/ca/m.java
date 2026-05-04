package ca;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class m implements r9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f3789a;

    public m(k kVar) {
        this.f3789a = kVar;
    }

    public static m a(k kVar) {
        return new m(kVar);
    }

    public static c9.d c(k kVar) {
        return (c9.d) r9.d.e(kVar.b());
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c9.d get() {
        return c(this.f3789a);
    }
}
