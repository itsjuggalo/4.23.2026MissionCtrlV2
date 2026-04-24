package u1;

/* JADX INFO: renamed from: u1.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2749e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C2749e f24451c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f24452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f24453b;

    /* JADX INFO: renamed from: u1.e$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f24454a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f24455b = 0;

        public C2749e a() {
            return new C2749e(this.f24454a, this.f24455b);
        }

        public a b(long j7) {
            this.f24454a = j7;
            return this;
        }

        public a c(long j7) {
            this.f24455b = j7;
            return this;
        }
    }

    public C2749e(long j7, long j8) {
        this.f24452a = j7;
        this.f24453b = j8;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.f24452a;
    }

    public long b() {
        return this.f24453b;
    }
}
