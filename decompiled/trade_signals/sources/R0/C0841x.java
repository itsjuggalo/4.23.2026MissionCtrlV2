package R0;

/* JADX INFO: renamed from: R0.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0841x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7085a;

    /* JADX INFO: renamed from: R0.x$a */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f7086a;

        public /* synthetic */ a(I0 i02) {
        }

        public C0841x a() {
            if (this.f7086a != null) {
                return new C0841x(this, null);
            }
            throw new IllegalArgumentException("Product type must be set");
        }

        public a b(String str) {
            this.f7086a = str;
            return this;
        }
    }

    public /* synthetic */ C0841x(a aVar, I0 i02) {
        this.f7085a = aVar.f7086a;
    }

    public static a a() {
        return new a(null);
    }

    public final String b() {
        return this.f7085a;
    }
}
