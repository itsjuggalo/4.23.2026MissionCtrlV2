package Y0;

/* JADX INFO: renamed from: Y0.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0723f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5590a;

    /* JADX INFO: renamed from: Y0.f$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5591a;

        public /* synthetic */ a(h0 h0Var) {
        }

        public C0723f a() {
            String str = this.f5591a;
            if (str == null) {
                throw new IllegalArgumentException("Purchase token must be set");
            }
            C0723f c0723f = new C0723f(null);
            c0723f.f5590a = str;
            return c0723f;
        }

        public a b(String str) {
            this.f5591a = str;
            return this;
        }
    }

    public /* synthetic */ C0723f(h0 h0Var) {
    }

    public static a b() {
        return new a(null);
    }

    public String a() {
        return this.f5590a;
    }
}
