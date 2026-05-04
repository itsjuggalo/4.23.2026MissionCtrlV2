package d3;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f7576a;

    /* JADX INFO: renamed from: d3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0141a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f7577a;

        public /* synthetic */ C0141a(z zVar) {
        }

        public a a() {
            String str = this.f7577a;
            if (str == null) {
                throw new IllegalArgumentException("Purchase token must be set");
            }
            a aVar = new a(null);
            aVar.f7576a = str;
            return aVar;
        }

        public C0141a b(String str) {
            this.f7577a = str;
            return this;
        }
    }

    public /* synthetic */ a(z zVar) {
    }

    public static C0141a b() {
        return new C0141a(null);
    }

    public String a() {
        return this.f7576a;
    }
}
