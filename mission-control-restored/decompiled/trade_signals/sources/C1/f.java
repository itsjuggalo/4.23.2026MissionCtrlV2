package C1;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f622c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f624b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f625a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f626b = 0;

        public f a() {
            return new f(this.f625a, this.f626b);
        }

        public a b(long j8) {
            this.f626b = j8;
            return this;
        }

        public a c(long j8) {
            this.f625a = j8;
            return this;
        }
    }

    public f(long j8, long j9) {
        this.f623a = j8;
        this.f624b = j9;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.f624b;
    }

    public long b() {
        return this.f623a;
    }
}
