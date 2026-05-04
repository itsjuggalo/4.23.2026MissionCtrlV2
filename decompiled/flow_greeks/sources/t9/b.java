package t9;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f20837c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile e f20838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f20839b = f20837c;

    public b(e eVar) {
        this.f20838a = eVar;
    }

    public static e a(e eVar) {
        d.b(eVar);
        return eVar instanceof b ? eVar : new b(eVar);
    }

    private static Object b(Object obj, Object obj2) {
        if (obj == f20837c || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // bd.a
    public Object get() {
        Object obj;
        Object obj2 = this.f20839b;
        Object obj3 = f20837c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f20839b;
                if (obj == obj3) {
                    obj = this.f20838a.get();
                    this.f20839b = b(this.f20839b, obj);
                    this.f20838a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
