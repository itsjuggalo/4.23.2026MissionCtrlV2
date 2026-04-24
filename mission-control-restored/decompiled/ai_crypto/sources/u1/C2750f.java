package u1;

/* JADX INFO: renamed from: u1.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2750f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C2750f f24456c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f24457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f24458b;

    /* JADX INFO: renamed from: u1.f$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f24459a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f24460b = 0;

        public C2750f a() {
            return new C2750f(this.f24459a, this.f24460b);
        }

        public a b(long j7) {
            this.f24460b = j7;
            return this;
        }

        public a c(long j7) {
            this.f24459a = j7;
            return this;
        }
    }

    public C2750f(long j7, long j8) {
        this.f24457a = j7;
        this.f24458b = j8;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.f24458b;
    }

    public long b() {
        return this.f24457a;
    }
}
