package o4;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f17490c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f17491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f17492b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f17493a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b f17494b = b.REASON_UNKNOWN;

        public c a() {
            return new c(this.f17493a, this.f17494b);
        }

        public a b(long j10) {
            this.f17493a = j10;
            return this;
        }

        public a c(b bVar) {
            this.f17494b = bVar;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum b implements b9.c {
        REASON_UNKNOWN(0),
        MESSAGE_TOO_OLD(1),
        CACHE_FULL(2),
        PAYLOAD_TOO_BIG(3),
        MAX_RETRIES_REACHED(4),
        INVALID_PAYLOD(5),
        SERVER_ERROR(6);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f17503a;

        b(int i10) {
            this.f17503a = i10;
        }

        @Override // b9.c
        public int d() {
            return this.f17503a;
        }
    }

    public c(long j10, b bVar) {
        this.f17491a = j10;
        this.f17492b = bVar;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.f17491a;
    }

    public b b() {
        return this.f17492b;
    }
}
