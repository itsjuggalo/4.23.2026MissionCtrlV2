package u1;

/* JADX INFO: renamed from: u1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2746b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C2746b f24429b = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2749e f24430a;

    /* JADX INFO: renamed from: u1.b$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public C2749e f24431a = null;

        public C2746b a() {
            return new C2746b(this.f24431a);
        }

        public a b(C2749e c2749e) {
            this.f24431a = c2749e;
            return this;
        }
    }

    public C2746b(C2749e c2749e) {
        this.f24430a = c2749e;
    }

    public static a b() {
        return new a();
    }

    public C2749e a() {
        return this.f24430a;
    }
}
