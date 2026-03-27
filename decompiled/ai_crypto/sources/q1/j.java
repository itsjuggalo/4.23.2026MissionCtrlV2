package q1;

import java.util.Arrays;
import q1.t;

/* JADX INFO: loaded from: classes.dex */
public final class j extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f22201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f22202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f22203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f22204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f22205e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f22206f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f22207g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final w f22208h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final q f22209i;

    public static final class b extends t.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f22210a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f22211b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public p f22212c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f22213d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte[] f22214e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f22215f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Long f22216g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public w f22217h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public q f22218i;

        @Override // q1.t.a
        public t a() {
            String str = "";
            if (this.f22210a == null) {
                str = " eventTimeMs";
            }
            if (this.f22213d == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f22216g == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new j(this.f22210a.longValue(), this.f22211b, this.f22212c, this.f22213d.longValue(), this.f22214e, this.f22215f, this.f22216g.longValue(), this.f22217h, this.f22218i);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // q1.t.a
        public t.a b(p pVar) {
            this.f22212c = pVar;
            return this;
        }

        @Override // q1.t.a
        public t.a c(Integer num) {
            this.f22211b = num;
            return this;
        }

        @Override // q1.t.a
        public t.a d(long j7) {
            this.f22210a = Long.valueOf(j7);
            return this;
        }

        @Override // q1.t.a
        public t.a e(long j7) {
            this.f22213d = Long.valueOf(j7);
            return this;
        }

        @Override // q1.t.a
        public t.a f(q qVar) {
            this.f22218i = qVar;
            return this;
        }

        @Override // q1.t.a
        public t.a g(w wVar) {
            this.f22217h = wVar;
            return this;
        }

        @Override // q1.t.a
        public t.a h(byte[] bArr) {
            this.f22214e = bArr;
            return this;
        }

        @Override // q1.t.a
        public t.a i(String str) {
            this.f22215f = str;
            return this;
        }

        @Override // q1.t.a
        public t.a j(long j7) {
            this.f22216g = Long.valueOf(j7);
            return this;
        }
    }

    @Override // q1.t
    public p b() {
        return this.f22203c;
    }

    @Override // q1.t
    public Integer c() {
        return this.f22202b;
    }

    @Override // q1.t
    public long d() {
        return this.f22201a;
    }

    @Override // q1.t
    public long e() {
        return this.f22204d;
    }

    public boolean equals(Object obj) {
        Integer num;
        p pVar;
        String str;
        w wVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        if (this.f22201a == tVar.d() && ((num = this.f22202b) != null ? num.equals(tVar.c()) : tVar.c() == null) && ((pVar = this.f22203c) != null ? pVar.equals(tVar.b()) : tVar.b() == null) && this.f22204d == tVar.e()) {
            if (Arrays.equals(this.f22205e, tVar instanceof j ? ((j) tVar).f22205e : tVar.h()) && ((str = this.f22206f) != null ? str.equals(tVar.i()) : tVar.i() == null) && this.f22207g == tVar.j() && ((wVar = this.f22208h) != null ? wVar.equals(tVar.g()) : tVar.g() == null)) {
                q qVar = this.f22209i;
                if (qVar == null) {
                    if (tVar.f() == null) {
                        return true;
                    }
                } else if (qVar.equals(tVar.f())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // q1.t
    public q f() {
        return this.f22209i;
    }

    @Override // q1.t
    public w g() {
        return this.f22208h;
    }

    @Override // q1.t
    public byte[] h() {
        return this.f22205e;
    }

    public int hashCode() {
        long j7 = this.f22201a;
        int i7 = (((int) (j7 ^ (j7 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f22202b;
        int iHashCode = (i7 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        p pVar = this.f22203c;
        int iHashCode2 = pVar == null ? 0 : pVar.hashCode();
        long j8 = this.f22204d;
        int iHashCode3 = (((((iHashCode ^ iHashCode2) * 1000003) ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f22205e)) * 1000003;
        String str = this.f22206f;
        int iHashCode4 = str == null ? 0 : str.hashCode();
        long j9 = this.f22207g;
        int i8 = (((iHashCode3 ^ iHashCode4) * 1000003) ^ ((int) ((j9 >>> 32) ^ j9))) * 1000003;
        w wVar = this.f22208h;
        int iHashCode5 = (i8 ^ (wVar == null ? 0 : wVar.hashCode())) * 1000003;
        q qVar = this.f22209i;
        return iHashCode5 ^ (qVar != null ? qVar.hashCode() : 0);
    }

    @Override // q1.t
    public String i() {
        return this.f22206f;
    }

    @Override // q1.t
    public long j() {
        return this.f22207g;
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.f22201a + ", eventCode=" + this.f22202b + ", complianceData=" + this.f22203c + ", eventUptimeMs=" + this.f22204d + ", sourceExtension=" + Arrays.toString(this.f22205e) + ", sourceExtensionJsonProto3=" + this.f22206f + ", timezoneOffsetSeconds=" + this.f22207g + ", networkConnectionInfo=" + this.f22208h + ", experimentIds=" + this.f22209i + "}";
    }

    public j(long j7, Integer num, p pVar, long j8, byte[] bArr, String str, long j9, w wVar, q qVar) {
        this.f22201a = j7;
        this.f22202b = num;
        this.f22203c = pVar;
        this.f22204d = j8;
        this.f22205e = bArr;
        this.f22206f = str;
        this.f22207g = j9;
        this.f22208h = wVar;
        this.f22209i = qVar;
    }
}
