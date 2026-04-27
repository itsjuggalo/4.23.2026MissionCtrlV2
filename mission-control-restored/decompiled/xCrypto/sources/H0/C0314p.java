package H0;

/* JADX INFO: renamed from: H0.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0314p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f674a;

    /* JADX INFO: renamed from: H0.p$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f675a;

        public /* synthetic */ a(u0 u0Var) {
        }

        public C0314p a() {
            if (this.f675a != null) {
                return new C0314p(this, null);
            }
            throw new IllegalArgumentException("Product type must be set");
        }

        public a b(String str) {
            this.f675a = str;
            return this;
        }
    }

    public /* synthetic */ C0314p(a aVar, u0 u0Var) {
        this.f674a = aVar.f675a;
    }

    public static a a() {
        return new a(null);
    }

    public final String b() {
        return this.f674a;
    }
}
