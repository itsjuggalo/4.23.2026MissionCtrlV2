package C1;

import z3.InterfaceC3007c;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f598c = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f600b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f601a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b f602b = b.REASON_UNKNOWN;

        public c a() {
            return new c(this.f601a, this.f602b);
        }

        public a b(long j8) {
            this.f601a = j8;
            return this;
        }

        public a c(b bVar) {
            this.f602b = bVar;
            return this;
        }
    }

    public enum b implements InterfaceC3007c {
        REASON_UNKNOWN(0),
        MESSAGE_TOO_OLD(1),
        CACHE_FULL(2),
        PAYLOAD_TOO_BIG(3),
        MAX_RETRIES_REACHED(4),
        INVALID_PAYLOD(5),
        SERVER_ERROR(6);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f611a;

        b(int i8) {
            this.f611a = i8;
        }

        @Override // z3.InterfaceC3007c
        public int d() {
            return this.f611a;
        }
    }

    public c(long j8, b bVar) {
        this.f599a = j8;
        this.f600b = bVar;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.f599a;
    }

    public b b() {
        return this.f600b;
    }
}
