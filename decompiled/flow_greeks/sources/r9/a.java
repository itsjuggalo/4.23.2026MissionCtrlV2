package r9;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f19443c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile e f19444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f19445b = f19443c;

    public a(e eVar) {
        this.f19444a = eVar;
    }

    public static e a(e eVar) {
        d.b(eVar);
        return eVar instanceof a ? eVar : new a(eVar);
    }

    private static Object b(Object obj, Object obj2) {
        if (obj == f19443c || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // bd.a
    public Object get() {
        Object obj;
        Object obj2 = this.f19445b;
        Object obj3 = f19443c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f19445b;
                if (obj == obj3) {
                    obj = this.f19444a.get();
                    this.f19445b = b(this.f19445b, obj);
                    this.f19444a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
