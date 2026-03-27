package H0;

/* JADX INFO: renamed from: H0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0292a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f659a;

    /* JADX INFO: renamed from: H0.a$a, reason: collision with other inner class name */
    public static final class C0023a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f660a;

        public /* synthetic */ C0023a(AbstractC0316s abstractC0316s) {
        }

        public C0292a a() {
            String str = this.f660a;
            if (str == null) {
                throw new IllegalArgumentException("Purchase token must be set");
            }
            C0292a c0292a = new C0292a(null);
            c0292a.f659a = str;
            return c0292a;
        }

        public C0023a b(String str) {
            this.f660a = str;
            return this;
        }
    }

    public /* synthetic */ C0292a(AbstractC0316s abstractC0316s) {
    }

    public static C0023a b() {
        return new C0023a(null);
    }

    public String a() {
        return this.f659a;
    }
}
