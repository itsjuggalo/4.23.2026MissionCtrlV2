package k3;

/* JADX INFO: renamed from: k3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0772a implements InterfaceC0774c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f7875c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile InterfaceC0773b f7876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f7877b;

    public static InterfaceC0774c a(InterfaceC0773b interfaceC0773b) {
        if (interfaceC0773b instanceof C0772a) {
            return interfaceC0773b;
        }
        C0772a c0772a = new C0772a();
        c0772a.f7877b = f7875c;
        c0772a.f7876a = interfaceC0773b;
        return c0772a;
    }

    @Override // F4.a
    public final Object get() {
        Object obj;
        Object obj2 = this.f7877b;
        Object obj3 = f7875c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f7877b;
                if (obj == obj3) {
                    obj = this.f7876a.get();
                    Object obj4 = this.f7877b;
                    if (obj4 != obj3 && obj4 != obj) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + obj + ". This is likely due to a circular dependency.");
                    }
                    this.f7877b = obj;
                    this.f7876a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
