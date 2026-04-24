package R0;

/* JADX INFO: renamed from: R0.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0820j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6995a;

    /* JADX INFO: renamed from: R0.j$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f6996a;

        public /* synthetic */ a(t0 t0Var) {
        }

        public C0820j a() {
            String str = this.f6996a;
            if (str == null) {
                throw new IllegalArgumentException("Purchase token must be set");
            }
            C0820j c0820j = new C0820j(null);
            c0820j.f6995a = str;
            return c0820j;
        }

        public a b(String str) {
            this.f6996a = str;
            return this;
        }
    }

    public /* synthetic */ C0820j(t0 t0Var) {
    }

    public static a b() {
        return new a(null);
    }

    public String a() {
        return this.f6995a;
    }
}
