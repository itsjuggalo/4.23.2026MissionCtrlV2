package q1;

/* JADX INFO: renamed from: q1.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2623f {

    /* JADX INFO: renamed from: q1.f$a */
    public class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile Object f22525a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f22526b;

        public a(b bVar) {
            this.f22526b = bVar;
        }

        @Override // q1.AbstractC2623f.b
        public Object get() {
            if (this.f22525a == null) {
                synchronized (this) {
                    try {
                        if (this.f22525a == null) {
                            this.f22525a = AbstractC2628k.d(this.f22526b.get());
                        }
                    } finally {
                    }
                }
            }
            return this.f22525a;
        }
    }

    /* JADX INFO: renamed from: q1.f$b */
    public interface b {
        Object get();
    }

    public static b a(b bVar) {
        return new a(bVar);
    }
}
