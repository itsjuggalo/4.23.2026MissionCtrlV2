package fe;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g1 f9483a = new a();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a implements g1 {
        public static /* synthetic */ void d(int i10) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/SourceElement$1", "getContainingFile"));
        }

        @Override // fe.g1
        public h1 a() {
            h1 h1Var = h1.f9484a;
            if (h1Var == null) {
                d(0);
            }
            return h1Var;
        }

        public String toString() {
            return "NO_SOURCE";
        }
    }

    h1 a();
}
