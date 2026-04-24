package Z0;

import Z0.t;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class j extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f5859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f5860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f5861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f5862d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f5863e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f5864f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f5865g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final w f5866h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final q f5867i;

    public static final class b extends t.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f5868a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f5869b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public p f5870c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f5871d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte[] f5872e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f5873f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Long f5874g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public w f5875h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public q f5876i;

        @Override // Z0.t.a
        public t a() {
            String str = "";
            if (this.f5868a == null) {
                str = " eventTimeMs";
            }
            if (this.f5871d == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f5874g == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new j(this.f5868a.longValue(), this.f5869b, this.f5870c, this.f5871d.longValue(), this.f5872e, this.f5873f, this.f5874g.longValue(), this.f5875h, this.f5876i);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // Z0.t.a
        public t.a b(p pVar) {
            this.f5870c = pVar;
            return this;
        }

        @Override // Z0.t.a
        public t.a c(Integer num) {
            this.f5869b = num;
            return this;
        }

        @Override // Z0.t.a
        public t.a d(long j4) {
            this.f5868a = Long.valueOf(j4);
            return this;
        }

        @Override // Z0.t.a
        public t.a e(long j4) {
            this.f5871d = Long.valueOf(j4);
            return this;
        }

        @Override // Z0.t.a
        public t.a f(q qVar) {
            this.f5876i = qVar;
            return this;
        }

        @Override // Z0.t.a
        public t.a g(w wVar) {
            this.f5875h = wVar;
            return this;
        }

        @Override // Z0.t.a
        public t.a h(byte[] bArr) {
            this.f5872e = bArr;
            return this;
        }

        @Override // Z0.t.a
        public t.a i(String str) {
            this.f5873f = str;
            return this;
        }

        @Override // Z0.t.a
        public t.a j(long j4) {
            this.f5874g = Long.valueOf(j4);
            return this;
        }
    }

    @Override // Z0.t
    public p b() {
        return this.f5861c;
    }

    @Override // Z0.t
    public Integer c() {
        return this.f5860b;
    }

    @Override // Z0.t
    public long d() {
        return this.f5859a;
    }

    @Override // Z0.t
    public long e() {
        return this.f5862d;
    }

    public boolean equals(Object obj) {
        Integer num;
        p pVar;
        String str;
        w wVar;
        q qVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof t) {
            t tVar = (t) obj;
            if (this.f5859a == tVar.d() && ((num = this.f5860b) != null ? num.equals(tVar.c()) : tVar.c() == null) && ((pVar = this.f5861c) != null ? pVar.equals(tVar.b()) : tVar.b() == null) && this.f5862d == tVar.e()) {
                if (Arrays.equals(this.f5863e, tVar instanceof j ? ((j) tVar).f5863e : tVar.h()) && ((str = this.f5864f) != null ? str.equals(tVar.i()) : tVar.i() == null) && this.f5865g == tVar.j() && ((wVar = this.f5866h) != null ? wVar.equals(tVar.g()) : tVar.g() == null) && ((qVar = this.f5867i) != null ? qVar.equals(tVar.f()) : tVar.f() == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // Z0.t
    public q f() {
        return this.f5867i;
    }

    @Override // Z0.t
    public w g() {
        return this.f5866h;
    }

    @Override // Z0.t
    public byte[] h() {
        return this.f5863e;
    }

    public int hashCode() {
        long j4 = this.f5859a;
        int i4 = (((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f5860b;
        int iHashCode = (i4 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        p pVar = this.f5861c;
        int iHashCode2 = pVar == null ? 0 : pVar.hashCode();
        long j5 = this.f5862d;
        int iHashCode3 = (((((iHashCode ^ iHashCode2) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f5863e)) * 1000003;
        String str = this.f5864f;
        int iHashCode4 = str == null ? 0 : str.hashCode();
        long j6 = this.f5865g;
        int i5 = (((iHashCode3 ^ iHashCode4) * 1000003) ^ ((int) ((j6 >>> 32) ^ j6))) * 1000003;
        w wVar = this.f5866h;
        int iHashCode5 = (i5 ^ (wVar == null ? 0 : wVar.hashCode())) * 1000003;
        q qVar = this.f5867i;
        return iHashCode5 ^ (qVar != null ? qVar.hashCode() : 0);
    }

    @Override // Z0.t
    public String i() {
        return this.f5864f;
    }

    @Override // Z0.t
    public long j() {
        return this.f5865g;
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.f5859a + ", eventCode=" + this.f5860b + ", complianceData=" + this.f5861c + ", eventUptimeMs=" + this.f5862d + ", sourceExtension=" + Arrays.toString(this.f5863e) + ", sourceExtensionJsonProto3=" + this.f5864f + ", timezoneOffsetSeconds=" + this.f5865g + ", networkConnectionInfo=" + this.f5866h + ", experimentIds=" + this.f5867i + "}";
    }

    public j(long j4, Integer num, p pVar, long j5, byte[] bArr, String str, long j6, w wVar, q qVar) {
        this.f5859a = j4;
        this.f5860b = num;
        this.f5861c = pVar;
        this.f5862d = j5;
        this.f5863e = bArr;
        this.f5864f = str;
        this.f5865g = j6;
        this.f5866h = wVar;
        this.f5867i = qVar;
    }
}
