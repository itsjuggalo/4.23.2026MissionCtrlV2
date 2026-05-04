package d3;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7808a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f7809a;

        public /* synthetic */ a(g2 g2Var) {
        }

        public w a() {
            if (this.f7809a != null) {
                return new w(this, null);
            }
            throw new IllegalArgumentException("Product type must be set");
        }

        public a b(String str) {
            this.f7809a = str;
            return this;
        }
    }

    public /* synthetic */ w(a aVar, g2 g2Var) {
        this.f7808a = aVar.f7809a;
    }

    public static a a() {
        return new a(null);
    }

    public final String b() {
        return this.f7808a;
    }
}
