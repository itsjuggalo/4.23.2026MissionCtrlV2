package E3;

/* JADX INFO: loaded from: classes.dex */
public final class a implements e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f889c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile e f890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f891b = f889c;

    public a(e eVar) {
        this.f890a = eVar;
    }

    public static e a(e eVar) {
        d.b(eVar);
        return eVar instanceof a ? eVar : new a(eVar);
    }

    private static Object b(Object obj, Object obj2) {
        if (obj == f889c || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // n5.InterfaceC2426a
    public Object get() {
        Object obj = this.f891b;
        Object obj2 = f889c;
        if (obj == obj2) {
            synchronized (this) {
                try {
                    obj = this.f891b;
                    if (obj == obj2) {
                        obj = this.f890a.get();
                        this.f891b = b(this.f891b, obj);
                        this.f890a = null;
                    }
                } finally {
                }
            }
        }
        return obj;
    }
}
