package R0;

/* JADX INFO: renamed from: R0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0802a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6910a;

    /* JADX INFO: renamed from: R0.a$a, reason: collision with other inner class name */
    public static final class C0096a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f6911a;

        public /* synthetic */ C0096a(A a8) {
        }

        public C0802a a() {
            String str = this.f6911a;
            if (str == null) {
                throw new IllegalArgumentException("Purchase token must be set");
            }
            C0802a c0802a = new C0802a(null);
            c0802a.f6910a = str;
            return c0802a;
        }

        public C0096a b(String str) {
            this.f6911a = str;
            return this;
        }
    }

    public /* synthetic */ C0802a(A a8) {
    }

    public static C0096a b() {
        return new C0096a(null);
    }

    public String a() {
        return this.f6910a;
    }
}
