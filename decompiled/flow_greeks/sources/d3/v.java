package d3;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f7802a;

        public /* synthetic */ a(f2 f2Var) {
        }

        public v a() {
            if (this.f7802a != null) {
                return new v(this, null);
            }
            throw new IllegalArgumentException("Product type must be set");
        }

        public a b(String str) {
            this.f7802a = str;
            return this;
        }
    }

    public /* synthetic */ v(a aVar, f2 f2Var) {
    }

    public static a a() {
        return new a(null);
    }
}
