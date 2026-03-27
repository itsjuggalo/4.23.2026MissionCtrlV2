package Z0;

import Z0.u;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class k extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f5877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f5878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f5879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f5880d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f5881e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f5882f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final x f5883g;

    public static final class b extends u.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f5884a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f5885b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public o f5886c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f5887d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f5888e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List f5889f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public x f5890g;

        @Override // Z0.u.a
        public u a() {
            String str = "";
            if (this.f5884a == null) {
                str = " requestTimeMs";
            }
            if (this.f5885b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new k(this.f5884a.longValue(), this.f5885b.longValue(), this.f5886c, this.f5887d, this.f5888e, this.f5889f, this.f5890g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // Z0.u.a
        public u.a b(o oVar) {
            this.f5886c = oVar;
            return this;
        }

        @Override // Z0.u.a
        public u.a c(List list) {
            this.f5889f = list;
            return this;
        }

        @Override // Z0.u.a
        public u.a d(Integer num) {
            this.f5887d = num;
            return this;
        }

        @Override // Z0.u.a
        public u.a e(String str) {
            this.f5888e = str;
            return this;
        }

        @Override // Z0.u.a
        public u.a f(x xVar) {
            this.f5890g = xVar;
            return this;
        }

        @Override // Z0.u.a
        public u.a g(long j4) {
            this.f5884a = Long.valueOf(j4);
            return this;
        }

        @Override // Z0.u.a
        public u.a h(long j4) {
            this.f5885b = Long.valueOf(j4);
            return this;
        }
    }

    @Override // Z0.u
    public o b() {
        return this.f5879c;
    }

    @Override // Z0.u
    public List c() {
        return this.f5882f;
    }

    @Override // Z0.u
    public Integer d() {
        return this.f5880d;
    }

    @Override // Z0.u
    public String e() {
        return this.f5881e;
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
            if (this.f5877a == uVar.g() && this.f5878b == uVar.h() && ((oVar = this.f5879c) != null ? oVar.equals(uVar.b()) : uVar.b() == null) && ((num = this.f5880d) != null ? num.equals(uVar.d()) : uVar.d() == null) && ((str = this.f5881e) != null ? str.equals(uVar.e()) : uVar.e() == null) && ((list = this.f5882f) != null ? list.equals(uVar.c()) : uVar.c() == null) && ((xVar = this.f5883g) != null ? xVar.equals(uVar.f()) : uVar.f() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // Z0.u
    public x f() {
        return this.f5883g;
    }

    @Override // Z0.u
    public long g() {
        return this.f5877a;
    }

    @Override // Z0.u
    public long h() {
        return this.f5878b;
    }

    public int hashCode() {
        long j4 = this.f5877a;
        long j5 = this.f5878b;
        int i4 = (((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j5 >>> 32) ^ j5))) * 1000003;
        o oVar = this.f5879c;
        int iHashCode = (i4 ^ (oVar == null ? 0 : oVar.hashCode())) * 1000003;
        Integer num = this.f5880d;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f5881e;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List list = this.f5882f;
        int iHashCode4 = (iHashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        x xVar = this.f5883g;
        return iHashCode4 ^ (xVar != null ? xVar.hashCode() : 0);
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.f5877a + ", requestUptimeMs=" + this.f5878b + ", clientInfo=" + this.f5879c + ", logSource=" + this.f5880d + ", logSourceName=" + this.f5881e + ", logEvents=" + this.f5882f + ", qosTier=" + this.f5883g + "}";
    }

    public k(long j4, long j5, o oVar, Integer num, String str, List list, x xVar) {
        this.f5877a = j4;
        this.f5878b = j5;
        this.f5879c = oVar;
        this.f5880d = num;
        this.f5881e = str;
        this.f5882f = list;
        this.f5883g = xVar;
    }
}
