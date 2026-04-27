package Y0;

/* JADX INFO: renamed from: Y0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0713a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5586a;

    /* JADX INFO: renamed from: Y0.a$a, reason: collision with other inner class name */
    public static final class C0101a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5587a;

        public /* synthetic */ C0101a(AbstractC0737s abstractC0737s) {
        }

        public C0713a a() {
            String str = this.f5587a;
            if (str == null) {
                throw new IllegalArgumentException("Purchase token must be set");
            }
            C0713a c0713a = new C0713a(null);
            c0713a.f5586a = str;
            return c0713a;
        }

        public C0101a b(String str) {
            this.f5587a = str;
            return this;
        }
    }

    public /* synthetic */ C0713a(AbstractC0737s abstractC0737s) {
    }

    public static C0101a b() {
        return new C0101a(null);
    }

    public String a() {
        return this.f5586a;
    }
}
