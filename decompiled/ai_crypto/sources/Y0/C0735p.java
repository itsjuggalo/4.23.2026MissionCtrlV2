package Y0;

/* JADX INFO: renamed from: Y0.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0735p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5601a;

    /* JADX INFO: renamed from: Y0.p$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5602a;

        public /* synthetic */ a(u0 u0Var) {
        }

        public C0735p a() {
            if (this.f5602a != null) {
                return new C0735p(this, null);
            }
            throw new IllegalArgumentException("Product type must be set");
        }

        public a b(String str) {
            this.f5602a = str;
            return this;
        }
    }

    public /* synthetic */ C0735p(a aVar, u0 u0Var) {
        this.f5601a = aVar.f5602a;
    }

    public static a a() {
        return new a(null);
    }

    public final String b() {
        return this.f5601a;
    }
}
