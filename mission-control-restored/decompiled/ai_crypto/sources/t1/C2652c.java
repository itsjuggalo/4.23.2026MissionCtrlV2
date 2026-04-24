package t1;

/* JADX INFO: renamed from: t1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2652c implements InterfaceC2651b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C2652c f23115b = new C2652c(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f23116a;

    public C2652c(Object obj) {
        this.f23116a = obj;
    }

    public static InterfaceC2651b a(Object obj) {
        return new C2652c(AbstractC2653d.c(obj, "instance cannot be null"));
    }

    @Override // D5.a
    public Object get() {
        return this.f23116a;
    }
}
