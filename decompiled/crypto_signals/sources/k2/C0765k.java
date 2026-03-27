package k2;

/* JADX INFO: renamed from: k2.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0765k implements X2.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f7856c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f7857a = f7856c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile X2.b f7858b;

    public C0765k(X2.b bVar) {
        this.f7858b = bVar;
    }

    @Override // X2.b
    public final Object get() {
        Object obj;
        Object obj2 = this.f7857a;
        Object obj3 = f7856c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f7857a;
                if (obj == obj3) {
                    obj = this.f7858b.get();
                    this.f7857a = obj;
                    this.f7858b = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
