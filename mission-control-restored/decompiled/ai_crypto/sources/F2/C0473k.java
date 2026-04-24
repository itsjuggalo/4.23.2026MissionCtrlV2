package F2;

/* JADX INFO: renamed from: F2.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0473k implements o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f1927c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile o f1928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f1929b = f1927c;

    public C0473k(o oVar) {
        this.f1928a = oVar;
    }

    public static o b(o oVar) {
        return oVar instanceof C0473k ? oVar : new C0473k(oVar);
    }

    @Override // F2.o
    public final Object a() {
        Object objA = this.f1929b;
        Object obj = f1927c;
        if (objA == obj) {
            synchronized (this) {
                try {
                    objA = this.f1929b;
                    if (objA == obj) {
                        objA = this.f1928a.a();
                        Object obj2 = this.f1929b;
                        if (obj2 != obj && obj2 != objA) {
                            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj2 + " & " + objA + ". This is likely due to a circular dependency.");
                        }
                        this.f1929b = objA;
                        this.f1928a = null;
                    }
                } finally {
                }
            }
        }
        return objA;
    }
}
