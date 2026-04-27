package S1;

/* JADX INFO: loaded from: classes.dex */
public final class h implements j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f2873c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile i f2874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f2875b;

    /* JADX WARN: Multi-variable type inference failed */
    public static h b(i iVar) {
        if (iVar instanceof h) {
            return (h) iVar;
        }
        h hVar = new h();
        hVar.f2875b = f2873c;
        hVar.f2874a = iVar;
        return hVar;
    }

    @Override // S1.j
    public final Object a() {
        Object objA;
        Object obj = this.f2875b;
        Object obj2 = f2873c;
        if (obj != obj2) {
            return obj;
        }
        synchronized (this) {
            try {
                objA = this.f2875b;
                if (objA == obj2) {
                    objA = this.f2874a.a();
                    Object obj3 = this.f2875b;
                    if (obj3 != obj2 && obj3 != objA) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + objA + ". This is likely due to a circular dependency.");
                    }
                    this.f2875b = objA;
                    this.f2874a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return objA;
    }
}
