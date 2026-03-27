package P3;

/* JADX INFO: renamed from: P3.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0777m implements E3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0775k f6415a;

    public C0777m(C0775k c0775k) {
        this.f6415a = c0775k;
    }

    public static C0777m a(C0775k c0775k) {
        return new C0777m(c0775k);
    }

    public static A3.d c(C0775k c0775k) {
        return (A3.d) E3.d.e(c0775k.b());
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public A3.d get() {
        return c(this.f6415a);
    }
}
