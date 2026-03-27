package C1;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f617c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f619b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f620a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f621b = 0;

        public e a() {
            return new e(this.f620a, this.f621b);
        }

        public a b(long j8) {
            this.f620a = j8;
            return this;
        }

        public a c(long j8) {
            this.f621b = j8;
            return this;
        }
    }

    public e(long j8, long j9) {
        this.f618a = j8;
        this.f619b = j9;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.f618a;
    }

    public long b() {
        return this.f619b;
    }
}
