package R5;

/* JADX INFO: loaded from: classes2.dex */
public interface h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h0 f7249a = new a();

    public static class a implements h0 {
        public static /* synthetic */ void d(int i8) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/SourceElement$1", "getContainingFile"));
        }

        @Override // R5.h0
        public i0 a() {
            i0 i0Var = i0.f7250a;
            if (i0Var == null) {
                d(0);
            }
            return i0Var;
        }

        public String toString() {
            return "NO_SOURCE";
        }
    }

    i0 a();
}
