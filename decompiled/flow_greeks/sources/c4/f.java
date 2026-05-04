package c4;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile Object f3584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f3585b;

        public a(b bVar) {
            this.f3585b = bVar;
        }

        @Override // c4.f.b
        public Object get() {
            if (this.f3584a == null) {
                synchronized (this) {
                    try {
                        if (this.f3584a == null) {
                            this.f3584a = k.e(this.f3585b.get());
                        }
                    } finally {
                    }
                }
            }
            return this.f3584a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {
        Object get();
    }

    public static b a(b bVar) {
        return new a(bVar);
    }
}
