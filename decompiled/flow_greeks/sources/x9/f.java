package x9;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements t9.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f24680a;

    public f(e eVar) {
        this.f24680a = eVar;
    }

    public static f a(e eVar) {
        return new f(eVar);
    }

    public static q9.q c(e eVar) {
        return (q9.q) t9.d.d(eVar.a());
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public q9.q get() {
        return c(this.f24680a);
    }
}
