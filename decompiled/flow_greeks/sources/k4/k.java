package k4;

import java.util.List;
import k4.u;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class k extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f14633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f14634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f14635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f14636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f14637e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f14638f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final x f14639g;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends u.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f14640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f14641b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public o f14642c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f14643d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f14644e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List f14645f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public x f14646g;

        @Override // k4.u.a
        public u a() {
            String str = "";
            if (this.f14640a == null) {
                str = " requestTimeMs";
            }
            if (this.f14641b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new k(this.f14640a.longValue(), this.f14641b.longValue(), this.f14642c, this.f14643d, this.f14644e, this.f14645f, this.f14646g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // k4.u.a
        public u.a b(o oVar) {
            this.f14642c = oVar;
            return this;
        }

        @Override // k4.u.a
        public u.a c(List list) {
            this.f14645f = list;
            return this;
        }

        @Override // k4.u.a
        public u.a d(Integer num) {
            this.f14643d = num;
            return this;
        }

        @Override // k4.u.a
        public u.a e(String str) {
            this.f14644e = str;
            return this;
        }

        @Override // k4.u.a
        public u.a f(x xVar) {
            this.f14646g = xVar;
            return this;
        }

        @Override // k4.u.a
        public u.a g(long j10) {
            this.f14640a = Long.valueOf(j10);
            return this;
        }

        @Override // k4.u.a
        public u.a h(long j10) {
            this.f14641b = Long.valueOf(j10);
            return this;
        }
    }

    @Override // k4.u
    public o b() {
        return this.f14635c;
    }

    @Override // k4.u
    public List c() {
        return this.f14638f;
    }

    @Override // k4.u
    public Integer d() {
        return this.f14636d;
    }

    @Override // k4.u
    public String e() {
        return this.f14637e;
    }

    public boolean equals(Object obj) {
        o oVar;
        Integer num;
        String str;
        List list;
        x xVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof u) {
            u uVar = (u) obj;
            if (this.f14633a == uVar.g() && this.f14634b == uVar.h() && ((oVar = this.f14635c) != null ? oVar.equals(uVar.b()) : uVar.b() == null) && ((num = this.f14636d) != null ? num.equals(uVar.d()) : uVar.d() == null) && ((str = this.f14637e) != null ? str.equals(uVar.e()) : uVar.e() == null) && ((list = this.f14638f) != null ? list.equals(uVar.c()) : uVar.c() == null) && ((xVar = this.f14639g) != null ? xVar.equals(uVar.f()) : uVar.f() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // k4.u
    public x f() {
        return this.f14639g;
    }

    @Override // k4.u
    public long g() {
        return this.f14633a;
    }

    @Override // k4.u
    public long h() {
        return this.f14634b;
    }

    public int hashCode() {
        long j10 = this.f14633a;
        long j11 = this.f14634b;
        int i10 = (((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003;
        o oVar = this.f14635c;
        int iHashCode = (i10 ^ (oVar == null ? 0 : oVar.hashCode())) * 1000003;
        Integer num = this.f14636d;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f14637e;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List list = this.f14638f;
        int iHashCode4 = (iHashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        x xVar = this.f14639g;
        return iHashCode4 ^ (xVar != null ? xVar.hashCode() : 0);
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.f14633a + ", requestUptimeMs=" + this.f14634b + ", clientInfo=" + this.f14635c + ", logSource=" + this.f14636d + ", logSourceName=" + this.f14637e + ", logEvents=" + this.f14638f + ", qosTier=" + this.f14639g + "}";
    }

    public k(long j10, long j11, o oVar, Integer num, String str, List list, x xVar) {
        this.f14633a = j10;
        this.f14634b = j11;
        this.f14635c = oVar;
        this.f14636d = num;
        this.f14637e = str;
        this.f14638f = list;
        this.f14639g = xVar;
    }
}
