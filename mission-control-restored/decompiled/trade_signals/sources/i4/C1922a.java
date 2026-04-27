package i4;

/* JADX INFO: renamed from: i4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1922a implements InterfaceC1926e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f18800c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile InterfaceC1926e f18801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f18802b = f18800c;

    public C1922a(InterfaceC1926e interfaceC1926e) {
        this.f18801a = interfaceC1926e;
    }

    public static InterfaceC1926e a(InterfaceC1926e interfaceC1926e) {
        AbstractC1925d.b(interfaceC1926e);
        return interfaceC1926e instanceof C1922a ? interfaceC1926e : new C1922a(interfaceC1926e);
    }

    private static Object b(Object obj, Object obj2) {
        if (obj == f18800c || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // n5.InterfaceC2426a
    public Object get() {
        Object obj = this.f18802b;
        Object obj2 = f18800c;
        if (obj == obj2) {
            synchronized (this) {
                try {
                    obj = this.f18802b;
                    if (obj == obj2) {
                        obj = this.f18801a.get();
                        this.f18802b = b(this.f18802b, obj);
                        this.f18801a = null;
                    }
                } finally {
                }
            }
        }
        return obj;
    }
}
