package y1;

import java.util.List;
import y1.u;

/* JADX INFO: loaded from: classes.dex */
public final class k extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f24372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f24373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f24374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f24375d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f24376e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f24377f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final x f24378g;

    public static final class b extends u.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f24379a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f24380b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public o f24381c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f24382d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f24383e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List f24384f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public x f24385g;

        @Override // y1.u.a
        public u a() {
            String str = "";
            if (this.f24379a == null) {
                str = " requestTimeMs";
            }
            if (this.f24380b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new k(this.f24379a.longValue(), this.f24380b.longValue(), this.f24381c, this.f24382d, this.f24383e, this.f24384f, this.f24385g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // y1.u.a
        public u.a b(o oVar) {
            this.f24381c = oVar;
            return this;
        }

        @Override // y1.u.a
        public u.a c(List list) {
            this.f24384f = list;
            return this;
        }

        @Override // y1.u.a
        public u.a d(Integer num) {
            this.f24382d = num;
            return this;
        }

        @Override // y1.u.a
        public u.a e(String str) {
            this.f24383e = str;
            return this;
        }

        @Override // y1.u.a
        public u.a f(x xVar) {
            this.f24385g = xVar;
            return this;
        }

        @Override // y1.u.a
        public u.a g(long j8) {
            this.f24379a = Long.valueOf(j8);
            return this;
        }

        @Override // y1.u.a
        public u.a h(long j8) {
            this.f24380b = Long.valueOf(j8);
            return this;
        }
    }

    public k(long j8, long j9, o oVar, Integer num, String str, List list, x xVar) {
        this.f24372a = j8;
        this.f24373b = j9;
        this.f24374c = oVar;
        this.f24375d = num;
        this.f24376e = str;
        this.f24377f = list;
        this.f24378g = xVar;
    }

    @Override // y1.u
    public o b() {
        return this.f24374c;
    }

    @Override // y1.u
    public List c() {
        return this.f24377f;
    }

    @Override // y1.u
    public Integer d() {
        return this.f24375d;
    }

    @Override // y1.u
    public String e() {
        return this.f24376e;
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
        if (this.f24372a == uVar.g() && this.f24373b == uVar.h() && ((oVar = this.f24374c) != null ? oVar.equals(uVar.b()) : uVar.b() == null) && ((num = this.f24375d) != null ? num.equals(uVar.d()) : uVar.d() == null) && ((str = this.f24376e) != null ? str.equals(uVar.e()) : uVar.e() == null) && ((list = this.f24377f) != null ? list.equals(uVar.c()) : uVar.c() == null)) {
            x xVar = this.f24378g;
            x xVarF = uVar.f();
            if (xVar == null) {
                if (xVarF == null) {
                    return true;
                }
            } else if (xVar.equals(xVarF)) {
                return true;
            }
        }
        return false;
    }

    @Override // y1.u
    public x f() {
        return this.f24378g;
    }

    @Override // y1.u
    public long g() {
        return this.f24372a;
    }

    @Override // y1.u
    public long h() {
        return this.f24373b;
    }

    public int hashCode() {
        long j8 = this.f24372a;
        long j9 = this.f24373b;
        int i8 = (((((int) (j8 ^ (j8 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j9 >>> 32) ^ j9))) * 1000003;
        o oVar = this.f24374c;
        int iHashCode = (i8 ^ (oVar == null ? 0 : oVar.hashCode())) * 1000003;
        Integer num = this.f24375d;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f24376e;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List list = this.f24377f;
        int iHashCode4 = (iHashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        x xVar = this.f24378g;
        return iHashCode4 ^ (xVar != null ? xVar.hashCode() : 0);
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.f24372a + ", requestUptimeMs=" + this.f24373b + ", clientInfo=" + this.f24374c + ", logSource=" + this.f24375d + ", logSourceName=" + this.f24376e + ", logEvents=" + this.f24377f + ", qosTier=" + this.f24378g + "}";
    }
}
