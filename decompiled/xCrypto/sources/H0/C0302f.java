package H0;

/* JADX INFO: renamed from: H0.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0302f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f663a;

    /* JADX INFO: renamed from: H0.f$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f664a;

        public /* synthetic */ a(h0 h0Var) {
        }

        public C0302f a() {
            String str = this.f664a;
            if (str == null) {
                throw new IllegalArgumentException("Purchase token must be set");
            }
            C0302f c0302f = new C0302f(null);
            c0302f.f663a = str;
            return c0302f;
        }

        public a b(String str) {
            this.f664a = str;
            return this;
        }
    }

    public /* synthetic */ C0302f(h0 h0Var) {
    }

    public static a b() {
        return new a(null);
    }

    public String a() {
        return this.f663a;
    }
}
