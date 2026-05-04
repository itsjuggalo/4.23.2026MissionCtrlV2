package d3;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f7680a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f7681a;

        public /* synthetic */ a(r1 r1Var) {
        }

        public i a() {
            String str = this.f7681a;
            if (str == null) {
                throw new IllegalArgumentException("Purchase token must be set");
            }
            i iVar = new i(null);
            iVar.f7680a = str;
            return iVar;
        }

        public a b(String str) {
            this.f7681a = str;
            return this;
        }
    }

    public /* synthetic */ i(r1 r1Var) {
    }

    public static a b() {
        return new a(null);
    }

    public String a() {
        return this.f7680a;
    }
}
