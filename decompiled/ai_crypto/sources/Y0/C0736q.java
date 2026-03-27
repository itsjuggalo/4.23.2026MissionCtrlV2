package Y0;

/* JADX INFO: renamed from: Y0.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0736q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5604a;

    /* JADX INFO: renamed from: Y0.q$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5605a;

        public /* synthetic */ a(v0 v0Var) {
        }

        public C0736q a() {
            if (this.f5605a != null) {
                return new C0736q(this, null);
            }
            throw new IllegalArgumentException("Product type must be set");
        }

        public a b(String str) {
            this.f5605a = str;
            return this;
        }
    }

    public /* synthetic */ C0736q(a aVar, v0 v0Var) {
        this.f5604a = aVar.f5605a;
    }

    public static a a() {
        return new a(null);
    }

    public final String b() {
        return this.f5604a;
    }
}
