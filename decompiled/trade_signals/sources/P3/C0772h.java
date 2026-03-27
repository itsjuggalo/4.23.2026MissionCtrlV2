package P3;

/* JADX INFO: renamed from: P3.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0772h implements E3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0768d f6408a;

    public C0772h(C0768d c0768d) {
        this.f6408a = c0768d;
    }

    public static C0772h a(C0768d c0768d) {
        return new C0772h(c0768d);
    }

    public static T3.h c(C0768d c0768d) {
        return (T3.h) E3.d.e(c0768d.d());
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public T3.h get() {
        return c(this.f6408a);
    }
}
