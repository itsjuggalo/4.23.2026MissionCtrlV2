package n4;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements bd.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f16634c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile bd.a f16635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f16636b = f16634c;

    public a(bd.a aVar) {
        this.f16635a = aVar;
    }

    public static bd.a a(bd.a aVar) {
        d.b(aVar);
        return aVar instanceof a ? aVar : new a(aVar);
    }

    public static Object b(Object obj, Object obj2) {
        if (obj == f16634c || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // bd.a
    public Object get() {
        Object obj;
        Object obj2 = this.f16636b;
        Object obj3 = f16634c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f16636b;
                if (obj == obj3) {
                    obj = this.f16635a.get();
                    this.f16636b = b(this.f16636b, obj);
                    this.f16635a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
