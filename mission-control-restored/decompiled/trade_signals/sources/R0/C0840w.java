package R0;

/* JADX INFO: renamed from: R0.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0840w {

    /* JADX INFO: renamed from: R0.w$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f7082a;

        public /* synthetic */ a(H0 h02) {
        }

        public C0840w a() {
            if (this.f7082a != null) {
                return new C0840w(this, null);
            }
            throw new IllegalArgumentException("Product type must be set");
        }

        public a b(String str) {
            this.f7082a = str;
            return this;
        }
    }

    public /* synthetic */ C0840w(a aVar, H0 h02) {
    }

    public static a a() {
        return new a(null);
    }
}
