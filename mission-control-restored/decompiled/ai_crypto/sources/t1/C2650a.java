package t1;

/* JADX INFO: renamed from: t1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2650a implements D5.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f23112c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile D5.a f23113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f23114b = f23112c;

    public C2650a(D5.a aVar) {
        this.f23113a = aVar;
    }

    public static D5.a a(D5.a aVar) {
        AbstractC2653d.b(aVar);
        return aVar instanceof C2650a ? aVar : new C2650a(aVar);
    }

    public static Object b(Object obj, Object obj2) {
        if (obj == f23112c || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // D5.a
    public Object get() {
        Object obj = this.f23114b;
        Object obj2 = f23112c;
        if (obj == obj2) {
            synchronized (this) {
                try {
                    obj = this.f23114b;
                    if (obj == obj2) {
                        obj = this.f23113a.get();
                        this.f23114b = b(this.f23114b, obj);
                        this.f23113a = null;
                    }
                } finally {
                }
            }
        }
        return obj;
    }
}
