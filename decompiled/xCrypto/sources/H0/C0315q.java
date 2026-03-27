package H0;

/* JADX INFO: renamed from: H0.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0315q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f677a;

    /* JADX INFO: renamed from: H0.q$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f678a;

        public /* synthetic */ a(v0 v0Var) {
        }

        public C0315q a() {
            if (this.f678a != null) {
                return new C0315q(this, null);
            }
            throw new IllegalArgumentException("Product type must be set");
        }

        public a b(String str) {
            this.f678a = str;
            return this;
        }
    }

    public /* synthetic */ C0315q(a aVar, v0 v0Var) {
        this.f677a = aVar.f678a;
    }

    public static a a() {
        return new a(null);
    }

    public final String b() {
        return this.f677a;
    }
}
