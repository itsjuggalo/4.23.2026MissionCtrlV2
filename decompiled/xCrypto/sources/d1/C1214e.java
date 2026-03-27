package d1;

/* JADX INFO: renamed from: d1.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1214e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C1214e f11418c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f11419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f11420b;

    /* JADX INFO: renamed from: d1.e$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f11421a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f11422b = 0;

        public C1214e a() {
            return new C1214e(this.f11421a, this.f11422b);
        }

        public a b(long j4) {
            this.f11421a = j4;
            return this;
        }

        public a c(long j4) {
            this.f11422b = j4;
            return this;
        }
    }

    public C1214e(long j4, long j5) {
        this.f11419a = j4;
        this.f11420b = j5;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.f11419a;
    }

    public long b() {
        return this.f11420b;
    }
}
