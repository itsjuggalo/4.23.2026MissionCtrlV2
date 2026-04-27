package X1;

/* JADX INFO: renamed from: X1.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0750k implements o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f5570c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile o f5571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f5572b = f5570c;

    public C0750k(o oVar) {
        this.f5571a = oVar;
    }

    public static o b(o oVar) {
        return oVar instanceof C0750k ? oVar : new C0750k(oVar);
    }

    @Override // X1.o
    public final Object a() {
        Object objA;
        Object obj = this.f5572b;
        Object obj2 = f5570c;
        if (obj != obj2) {
            return obj;
        }
        synchronized (this) {
            try {
                objA = this.f5572b;
                if (objA == obj2) {
                    objA = this.f5571a.a();
                    Object obj3 = this.f5572b;
                    if (obj3 != obj2 && obj3 != objA) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + objA + ". This is likely due to a circular dependency.");
                    }
                    this.f5572b = objA;
                    this.f5571a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return objA;
    }
}
