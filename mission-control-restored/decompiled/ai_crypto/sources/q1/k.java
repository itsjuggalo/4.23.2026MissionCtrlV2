package q1;

import java.util.List;
import q1.u;

/* JADX INFO: loaded from: classes.dex */
public final class k extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f22219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f22220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f22221c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f22222d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f22223e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f22224f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final x f22225g;

    public static final class b extends u.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f22226a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f22227b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public o f22228c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f22229d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f22230e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List f22231f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public x f22232g;

        @Override // q1.u.a
        public u a() {
            String str = "";
            if (this.f22226a == null) {
                str = " requestTimeMs";
            }
            if (this.f22227b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new k(this.f22226a.longValue(), this.f22227b.longValue(), this.f22228c, this.f22229d, this.f22230e, this.f22231f, this.f22232g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // q1.u.a
        public u.a b(o oVar) {
            this.f22228c = oVar;
            return this;
        }

        @Override // q1.u.a
        public u.a c(List list) {
            this.f22231f = list;
            return this;
        }

        @Override // q1.u.a
        public u.a d(Integer num) {
            this.f22229d = num;
            return this;
        }

        @Override // q1.u.a
        public u.a e(String str) {
            this.f22230e = str;
            return this;
        }

        @Override // q1.u.a
        public u.a f(x xVar) {
            this.f22232g = xVar;
            return this;
        }

        @Override // q1.u.a
        public u.a g(long j7) {
            this.f22226a = Long.valueOf(j7);
            return this;
        }

        @Override // q1.u.a
        public u.a h(long j7) {
            this.f22227b = Long.valueOf(j7);
            return this;
        }
    }

    @Override // q1.u
    public o b() {
        return this.f22221c;
    }

    @Override // q1.u
    public List c() {
        return this.f22224f;
    }

    @Override // q1.u
    public Integer d() {
        return this.f22222d;
    }

    @Override // q1.u
    public String e() {
        return this.f22223e;
    }

    public boolean equals(Object obj) {
        o oVar;
        Integer num;
        String str;
        List list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        if (this.f22219a == uVar.g() && this.f22220b == uVar.h() && ((oVar = this.f22221c) != null ? oVar.equals(uVar.b()) : uVar.b() == null) && ((num = this.f22222d) != null ? num.equals(uVar.d()) : uVar.d() == null) && ((str = this.f22223e) != null ? str.equals(uVar.e()) : uVar.e() == null) && ((list = this.f22224f) != null ? list.equals(uVar.c()) : uVar.c() == null)) {
            x xVar = this.f22225g;
            if (xVar == null) {
                if (uVar.f() == null) {
                    return true;
                }
            } else if (xVar.equals(uVar.f())) {
                return true;
            }
        }
        return false;
    }

    @Override // q1.u
    public x f() {
        return this.f22225g;
    }

    @Override // q1.u
    public long g() {
        return this.f22219a;
    }

    @Override // q1.u
    public long h() {
        return this.f22220b;
    }

    public int hashCode() {
        long j7 = this.f22219a;
        long j8 = this.f22220b;
        int i7 = (((((int) (j7 ^ (j7 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j8 >>> 32) ^ j8))) * 1000003;
        o oVar = this.f22221c;
        int iHashCode = (i7 ^ (oVar == null ? 0 : oVar.hashCode())) * 1000003;
        Integer num = this.f22222d;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f22223e;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List list = this.f22224f;
        int iHashCode4 = (iHashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        x xVar = this.f22225g;
        return iHashCode4 ^ (xVar != null ? xVar.hashCode() : 0);
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.f22219a + ", requestUptimeMs=" + this.f22220b + ", clientInfo=" + this.f22221c + ", logSource=" + this.f22222d + ", logSourceName=" + this.f22223e + ", logEvents=" + this.f22224f + ", qosTier=" + this.f22225g + "}";
    }

    public k(long j7, long j8, o oVar, Integer num, String str, List list, x xVar) {
        this.f22219a = j7;
        this.f22220b = j8;
        this.f22221c = oVar;
        this.f22222d = num;
        this.f22223e = str;
        this.f22224f = list;
        this.f22225g = xVar;
    }
}
