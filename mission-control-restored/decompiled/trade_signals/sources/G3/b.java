package G3;

/* JADX INFO: loaded from: classes.dex */
public final class b implements e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f2197c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile e f2198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f2199b = f2197c;

    public b(e eVar) {
        this.f2198a = eVar;
    }

    public static e a(e eVar) {
        d.b(eVar);
        return eVar instanceof b ? eVar : new b(eVar);
    }

    private static Object b(Object obj, Object obj2) {
        if (obj == f2197c || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // n5.InterfaceC2426a
    public Object get() {
        Object obj = this.f2199b;
        Object obj2 = f2197c;
        if (obj == obj2) {
            synchronized (this) {
                try {
                    obj = this.f2199b;
                    if (obj == obj2) {
                        obj = this.f2198a.get();
                        this.f2199b = b(this.f2199b, obj);
                        this.f2198a = null;
                    }
                } finally {
                }
            }
        }
        return obj;
    }
}
