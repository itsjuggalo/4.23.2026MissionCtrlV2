package wa;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f23790c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile e f23791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f23792b = f23790c;

    public a(e eVar) {
        this.f23791a = eVar;
    }

    public static e a(e eVar) {
        d.b(eVar);
        return eVar instanceof a ? eVar : new a(eVar);
    }

    private static Object b(Object obj, Object obj2) {
        if (obj == f23790c || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // bd.a
    public Object get() {
        Object obj;
        Object obj2 = this.f23792b;
        Object obj3 = f23790c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f23792b;
                if (obj == obj3) {
                    obj = this.f23791a.get();
                    this.f23792b = b(this.f23792b, obj);
                    this.f23791a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
