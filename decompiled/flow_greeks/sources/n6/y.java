package n6;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class y implements d0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f16683c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile d0 f16684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f16685b = f16683c;

    public y(d0 d0Var) {
        this.f16684a = d0Var;
    }

    public static d0 b(d0 d0Var) {
        return d0Var instanceof y ? d0Var : new y(d0Var);
    }

    @Override // n6.e0
    public final Object a() {
        Object objA;
        Object obj = this.f16685b;
        Object obj2 = f16683c;
        if (obj != obj2) {
            return obj;
        }
        synchronized (this) {
            try {
                objA = this.f16685b;
                if (objA == obj2) {
                    objA = this.f16684a.a();
                    Object obj3 = this.f16685b;
                    if (obj3 != obj2 && obj3 != objA) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + objA + ". This is likely due to a circular dependency.");
                    }
                    this.f16685b = objA;
                    this.f16684a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return objA;
    }
}
