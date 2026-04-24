package F2;

/* JADX INFO: renamed from: F2.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0475m implements InterfaceC0474l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0475m f1930b = new C0475m(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1931a;

    public C0475m(Object obj) {
        this.f1931a = obj;
    }

    public static InterfaceC0474l b(Object obj) {
        if (obj != null) {
            return new C0475m(obj);
        }
        throw new NullPointerException("instance cannot be null");
    }

    @Override // F2.o
    public final Object a() {
        return this.f1931a;
    }
}
