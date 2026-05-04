package o4;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f17509c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f17510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f17511b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f17512a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f17513b = 0;

        public e a() {
            return new e(this.f17512a, this.f17513b);
        }

        public a b(long j10) {
            this.f17512a = j10;
            return this;
        }

        public a c(long j10) {
            this.f17513b = j10;
            return this;
        }
    }

    public e(long j10, long j11) {
        this.f17510a = j10;
        this.f17511b = j11;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.f17510a;
    }

    public long b() {
        return this.f17511b;
    }
}
