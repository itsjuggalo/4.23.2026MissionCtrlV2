package K2;

/* JADX INFO: loaded from: classes3.dex */
public final class F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f1032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f1033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final P f1034d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final P f1035e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f1036a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b f1037b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f1038c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public P f1039d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public P f1040e;

        public F a() {
            Z1.m.o(this.f1036a, com.amazon.a.a.o.b.f8755c);
            Z1.m.o(this.f1037b, "severity");
            Z1.m.o(this.f1038c, "timestampNanos");
            Z1.m.u(this.f1039d == null || this.f1040e == null, "at least one of channelRef and subchannelRef must be null");
            return new F(this.f1036a, this.f1037b, this.f1038c.longValue(), this.f1039d, this.f1040e);
        }

        public a b(String str) {
            this.f1036a = str;
            return this;
        }

        public a c(b bVar) {
            this.f1037b = bVar;
            return this;
        }

        public a d(P p4) {
            this.f1040e = p4;
            return this;
        }

        public a e(long j4) {
            this.f1038c = Long.valueOf(j4);
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
        if (obj instanceof F) {
            F f4 = (F) obj;
            if (Z1.i.a(this.f1031a, f4.f1031a) && Z1.i.a(this.f1032b, f4.f1032b) && this.f1033c == f4.f1033c && Z1.i.a(this.f1034d, f4.f1034d) && Z1.i.a(this.f1035e, f4.f1035e)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Z1.i.b(this.f1031a, this.f1032b, Long.valueOf(this.f1033c), this.f1034d, this.f1035e);
    }

    public String toString() {
        return Z1.g.b(this).d(com.amazon.a.a.o.b.f8755c, this.f1031a).d("severity", this.f1032b).c("timestampNanos", this.f1033c).d("channelRef", this.f1034d).d("subchannelRef", this.f1035e).toString();
    }

    public F(String str, b bVar, long j4, P p4, P p5) {
        this.f1031a = str;
        this.f1032b = (b) Z1.m.o(bVar, "severity");
        this.f1033c = j4;
        this.f1034d = p4;
        this.f1035e = p5;
    }
}
