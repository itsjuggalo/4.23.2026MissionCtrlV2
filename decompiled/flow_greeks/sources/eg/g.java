package eg;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f8887a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f8888b = new a();

        public a() {
            super(false, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f8889b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String error) {
            super(false, null);
            kotlin.jvm.internal.t.f(error, "error");
            this.f8889b = error;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f8890b = new c();

        public c() {
            super(true, null);
        }
    }

    public /* synthetic */ g(boolean z10, kotlin.jvm.internal.k kVar) {
        this(z10);
    }

    public final boolean a() {
        return this.f8887a;
    }

    public g(boolean z10) {
        this.f8887a = z10;
    }
}
