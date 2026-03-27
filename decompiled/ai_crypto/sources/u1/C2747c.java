package u1;

/* JADX INFO: renamed from: u1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2747c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C2747c f24432c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f24433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f24434b;

    /* JADX INFO: renamed from: u1.c$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f24435a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b f24436b = b.REASON_UNKNOWN;

        public C2747c a() {
            return new C2747c(this.f24435a, this.f24436b);
        }

        public a b(long j7) {
            this.f24435a = j7;
            return this;
        }

        public a c(b bVar) {
            this.f24436b = bVar;
            return this;
        }
    }

    /* JADX INFO: renamed from: u1.c$b */
    public enum b implements y3.c {
        REASON_UNKNOWN(0),
        MESSAGE_TOO_OLD(1),
        CACHE_FULL(2),
        PAYLOAD_TOO_BIG(3),
        MAX_RETRIES_REACHED(4),
        INVALID_PAYLOD(5),
        SERVER_ERROR(6);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f24445a;

        b(int i7) {
            this.f24445a = i7;
        }

        @Override // y3.c
        public int d() {
            return this.f24445a;
        }
    }

    public C2747c(long j7, b bVar) {
        this.f24433a = j7;
        this.f24434b = bVar;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.f24433a;
    }

    public b b() {
        return this.f24434b;
    }
}
