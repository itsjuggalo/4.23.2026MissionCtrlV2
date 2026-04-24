package d1;

/* JADX INFO: renamed from: d1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1211b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C1211b f11396b = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1214e f11397a;

    /* JADX INFO: renamed from: d1.b$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public C1214e f11398a = null;

        public C1211b a() {
            return new C1211b(this.f11398a);
        }

        public a b(C1214e c1214e) {
            this.f11398a = c1214e;
            return this;
        }
    }

    public C1211b(C1214e c1214e) {
        this.f11397a = c1214e;
    }

    public static a b() {
        return new a();
    }

    public C1214e a() {
        return this.f11397a;
    }
}
