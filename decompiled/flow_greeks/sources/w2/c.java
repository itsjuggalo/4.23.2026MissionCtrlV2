package w2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public interface c extends w2.a {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0410a f23618b = new C0410a(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f23619c = new a("NONE");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f23620d = new a("FULL");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f23621a;

        /* JADX INFO: renamed from: w2.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0410a {
            public /* synthetic */ C0410a(kotlin.jvm.internal.k kVar) {
                this();
            }

            public C0410a() {
            }
        }

        public a(String str) {
            this.f23621a = str;
        }

        public String toString() {
            return this.f23621a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f23622b = new a(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f23623c = new b("FLAT");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f23624d = new b("HALF_OPENED");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f23625a;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a {
            public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
                this();
            }

            public a() {
            }
        }

        public b(String str) {
            this.f23625a = str;
        }

        public String toString() {
            return this.f23625a;
        }
    }

    a a();

    b b();
}
