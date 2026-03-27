package d1;

/* JADX INFO: renamed from: d1.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1215f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C1215f f11423c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f11424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f11425b;

    /* JADX INFO: renamed from: d1.f$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f11426a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f11427b = 0;

        public C1215f a() {
            return new C1215f(this.f11426a, this.f11427b);
        }

        public a b(long j4) {
            this.f11427b = j4;
            return this;
        }

        public a c(long j4) {
            this.f11426a = j4;
            return this;
        }
    }

    public C1215f(long j4, long j5) {
        this.f11424a = j4;
        this.f11425b = j5;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.f11425b;
    }

    public long b() {
        return this.f11424a;
    }
}
