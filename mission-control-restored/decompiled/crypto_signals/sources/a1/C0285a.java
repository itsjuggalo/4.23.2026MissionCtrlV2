package a1;

/* JADX INFO: renamed from: a1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0285a implements F4.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f4048c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile InterfaceC0286b f4049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f4050b;

    public static F4.a a(InterfaceC0286b interfaceC0286b) {
        if (interfaceC0286b instanceof C0285a) {
            return interfaceC0286b;
        }
        C0285a c0285a = new C0285a();
        c0285a.f4050b = f4048c;
        c0285a.f4049a = interfaceC0286b;
        return c0285a;
    }

    @Override // F4.a
    public final Object get() {
        Object obj;
        Object obj2 = this.f4050b;
        Object obj3 = f4048c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f4050b;
                if (obj == obj3) {
                    obj = this.f4049a.get();
                    Object obj4 = this.f4050b;
                    if (obj4 != obj3 && obj4 != obj) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + obj + ". This is likely due to a circular dependency.");
                    }
                    this.f4050b = obj;
                    this.f4049a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
