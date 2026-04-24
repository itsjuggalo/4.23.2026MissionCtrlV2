package r5;

/* JADX INFO: loaded from: classes2.dex */
public final class F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f22522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f22523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final P f22524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final P f22525e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f22526a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b f22527b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f22528c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public P f22529d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public P f22530e;

        public F a() {
            H2.m.o(this.f22526a, com.amazon.a.a.o.b.f9940c);
            H2.m.o(this.f22527b, "severity");
            H2.m.o(this.f22528c, "timestampNanos");
            H2.m.u(this.f22529d == null || this.f22530e == null, "at least one of channelRef and subchannelRef must be null");
            return new F(this.f22526a, this.f22527b, this.f22528c.longValue(), this.f22529d, this.f22530e);
        }

        public a b(String str) {
            this.f22526a = str;
            return this;
        }

        public a c(b bVar) {
            this.f22527b = bVar;
            return this;
        }

        public a d(P p7) {
            this.f22530e = p7;
            return this;
        }

        public a e(long j7) {
            this.f22528c = Long.valueOf(j7);
            return this;
        }
    }

    public enum b {
        CT_UNKNOWN,
        CT_INFO,
        CT_WARNING,
        CT_ERROR
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof F)) {
            return false;
        }
        F f7 = (F) obj;
        return H2.i.a(this.f22521a, f7.f22521a) && H2.i.a(this.f22522b, f7.f22522b) && this.f22523c == f7.f22523c && H2.i.a(this.f22524d, f7.f22524d) && H2.i.a(this.f22525e, f7.f22525e);
    }

    public int hashCode() {
        return H2.i.b(this.f22521a, this.f22522b, Long.valueOf(this.f22523c), this.f22524d, this.f22525e);
    }

    public String toString() {
        return H2.g.b(this).d(com.amazon.a.a.o.b.f9940c, this.f22521a).d("severity", this.f22522b).c("timestampNanos", this.f22523c).d("channelRef", this.f22524d).d("subchannelRef", this.f22525e).toString();
    }

    public F(String str, b bVar, long j7, P p7, P p8) {
        this.f22521a = str;
        this.f22522b = (b) H2.m.o(bVar, "severity");
        this.f22523c = j7;
        this.f22524d = p7;
        this.f22525e = p8;
    }
}
