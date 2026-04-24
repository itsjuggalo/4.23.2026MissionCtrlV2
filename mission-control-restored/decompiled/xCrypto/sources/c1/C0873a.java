package c1;

/* JADX INFO: renamed from: c1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0873a implements V2.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f8304c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile V2.a f8305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f8306b = f8304c;

    public C0873a(V2.a aVar) {
        this.f8305a = aVar;
    }

    public static V2.a a(V2.a aVar) {
        d.b(aVar);
        return aVar instanceof C0873a ? aVar : new C0873a(aVar);
    }

    public static Object b(Object obj, Object obj2) {
        if (obj == f8304c || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // V2.a
    public Object get() {
        Object obj;
        Object obj2 = this.f8306b;
        Object obj3 = f8304c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f8306b;
                if (obj == obj3) {
                    obj = this.f8305a.get();
                    this.f8306b = b(this.f8306b, obj);
                    this.f8305a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
