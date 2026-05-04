package o4;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f17514c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f17515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f17516b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f17517a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f17518b = 0;

        public f a() {
            return new f(this.f17517a, this.f17518b);
        }

        public a b(long j10) {
            this.f17518b = j10;
            return this;
        }

        public a c(long j10) {
            this.f17517a = j10;
            return this;
        }
    }

    public f(long j10, long j11) {
        this.f17515a = j10;
        this.f17516b = j11;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.f17516b;
    }

    public long b() {
        return this.f17515a;
    }
}
