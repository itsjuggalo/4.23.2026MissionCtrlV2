package M2;

/* JADX INFO: loaded from: classes.dex */
public class w implements S3.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f5340c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f5341a = f5340c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile S3.b f5342b;

    public w(S3.b bVar) {
        this.f5342b = bVar;
    }

    @Override // S3.b
    public Object get() {
        Object obj = this.f5341a;
        Object obj2 = f5340c;
        if (obj == obj2) {
            synchronized (this) {
                try {
                    obj = this.f5341a;
                    if (obj == obj2) {
                        obj = this.f5342b.get();
                        this.f5341a = obj;
                        this.f5342b = null;
                    }
                } finally {
                }
            }
        }
        return obj;
    }
}
