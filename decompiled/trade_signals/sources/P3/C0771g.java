package P3;

/* JADX INFO: renamed from: P3.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0771g implements E3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0768d f6407a;

    public C0771g(C0768d c0768d) {
        this.f6407a = c0768d;
    }

    public static C0771g a(C0768d c0768d) {
        return new C0771g(c0768d);
    }

    public static G2.f c(C0768d c0768d) {
        return (G2.f) E3.d.e(c0768d.c());
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public G2.f get() {
        return c(this.f6407a);
    }
}
