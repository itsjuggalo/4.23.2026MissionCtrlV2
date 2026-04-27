package b3;

/* JADX INFO: loaded from: classes.dex */
public class w implements N3.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f8573c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f8574a = f8573c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile N3.b f8575b;

    public w(N3.b bVar) {
        this.f8575b = bVar;
    }

    @Override // N3.b
    public Object get() {
        Object obj = this.f8574a;
        Object obj2 = f8573c;
        if (obj == obj2) {
            synchronized (this) {
                try {
                    obj = this.f8574a;
                    if (obj == obj2) {
                        obj = this.f8575b.get();
                        this.f8574a = obj;
                        this.f8575b = null;
                    }
                } finally {
                }
            }
        }
        return obj;
    }
}
