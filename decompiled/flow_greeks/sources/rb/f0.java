package rb;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f19552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f19553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p0 f19554d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p0 f19555e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f19556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b f19557b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f19558c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public p0 f19559d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public p0 f19560e;

        public f0 a() {
            p6.n.o(this.f19556a, com.amazon.a.a.o.b.f4549c);
            p6.n.o(this.f19557b, "severity");
            p6.n.o(this.f19558c, "timestampNanos");
            p6.n.u(this.f19559d == null || this.f19560e == null, "at least one of channelRef and subchannelRef must be null");
            return new f0(this.f19556a, this.f19557b, this.f19558c.longValue(), this.f19559d, this.f19560e);
        }

        public a b(String str) {
            this.f19556a = str;
            return this;
        }

        public a c(b bVar) {
            this.f19557b = bVar;
            return this;
        }

        public a d(p0 p0Var) {
            this.f19560e = p0Var;
            return this;
        }

        public a e(long j10) {
            this.f19558c = Long.valueOf(j10);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum b {
        CT_UNKNOWN,
        CT_INFO,
        CT_WARNING,
        CT_ERROR
    }

    public boolean equals(Object obj) {
        if (obj instanceof f0) {
            f0 f0Var = (f0) obj;
            if (p6.j.a(this.f19551a, f0Var.f19551a) && p6.j.a(this.f19552b, f0Var.f19552b) && this.f19553c == f0Var.f19553c && p6.j.a(this.f19554d, f0Var.f19554d) && p6.j.a(this.f19555e, f0Var.f19555e)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return p6.j.b(this.f19551a, this.f19552b, Long.valueOf(this.f19553c), this.f19554d, this.f19555e);
    }

    public String toString() {
        return p6.h.b(this).d(com.amazon.a.a.o.b.f4549c, this.f19551a).d("severity", this.f19552b).c("timestampNanos", this.f19553c).d("channelRef", this.f19554d).d("subchannelRef", this.f19555e).toString();
    }

    public f0(String str, b bVar, long j10, p0 p0Var, p0 p0Var2) {
        this.f19551a = str;
        this.f19552b = (b) p6.n.o(bVar, "severity");
        this.f19553c = j10;
        this.f19554d = p0Var;
        this.f19555e = p0Var2;
    }
}
