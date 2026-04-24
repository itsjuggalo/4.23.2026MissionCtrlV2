package i4;

/* JADX INFO: renamed from: i4.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1924c implements InterfaceC1923b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C1924c f18803b = new C1924c(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f18804a;

    public C1924c(Object obj) {
        this.f18804a = obj;
    }

    public static InterfaceC1923b a(Object obj) {
        return new C1924c(AbstractC1925d.c(obj, "instance cannot be null"));
    }

    @Override // n5.InterfaceC2426a
    public Object get() {
        return this.f18804a;
    }
}
