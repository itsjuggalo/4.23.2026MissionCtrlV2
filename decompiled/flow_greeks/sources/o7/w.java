package o7;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class w implements fa.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f17596c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f17597a = f17596c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile fa.b f17598b;

    public w(fa.b bVar) {
        this.f17598b = bVar;
    }

    @Override // fa.b
    public Object get() {
        Object obj;
        Object obj2 = this.f17597a;
        Object obj3 = f17596c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f17597a;
                if (obj == obj3) {
                    obj = this.f17598b.get();
                    this.f17597a = obj;
                    this.f17598b = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
