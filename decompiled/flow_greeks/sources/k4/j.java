package k4;

import java.util.Arrays;
import k4.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f14615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f14616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f14617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f14618d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f14619e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f14620f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f14621g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final w f14622h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final q f14623i;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends t.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f14624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f14625b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public p f14626c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f14627d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte[] f14628e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f14629f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Long f14630g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public w f14631h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public q f14632i;

        @Override // k4.t.a
        public t a() {
            String str = "";
            if (this.f14624a == null) {
                str = " eventTimeMs";
            }
            if (this.f14627d == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f14630g == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new j(this.f14624a.longValue(), this.f14625b, this.f14626c, this.f14627d.longValue(), this.f14628e, this.f14629f, this.f14630g.longValue(), this.f14631h, this.f14632i);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // k4.t.a
        public t.a b(p pVar) {
            this.f14626c = pVar;
            return this;
        }

        @Override // k4.t.a
        public t.a c(Integer num) {
            this.f14625b = num;
            return this;
        }

        @Override // k4.t.a
        public t.a d(long j10) {
            this.f14624a = Long.valueOf(j10);
            return this;
        }

        @Override // k4.t.a
        public t.a e(long j10) {
            this.f14627d = Long.valueOf(j10);
            return this;
        }

        @Override // k4.t.a
        public t.a f(q qVar) {
            this.f14632i = qVar;
            return this;
        }

        @Override // k4.t.a
        public t.a g(w wVar) {
            this.f14631h = wVar;
            return this;
        }

        @Override // k4.t.a
        public t.a h(byte[] bArr) {
            this.f14628e = bArr;
            return this;
        }

        @Override // k4.t.a
        public t.a i(String str) {
            this.f14629f = str;
            return this;
        }

        @Override // k4.t.a
        public t.a j(long j10) {
            this.f14630g = Long.valueOf(j10);
            return this;
        }
    }

    @Override // k4.t
    public p b() {
        return this.f14617c;
    }

    @Override // k4.t
    public Integer c() {
        return this.f14616b;
    }

    @Override // k4.t
    public long d() {
        return this.f14615a;
    }

    @Override // k4.t
    public long e() {
        return this.f14618d;
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
            if (this.f14615a == tVar.d() && ((num = this.f14616b) != null ? num.equals(tVar.c()) : tVar.c() == null) && ((pVar = this.f14617c) != null ? pVar.equals(tVar.b()) : tVar.b() == null) && this.f14618d == tVar.e()) {
                if (Arrays.equals(this.f14619e, tVar instanceof j ? ((j) tVar).f14619e : tVar.h()) && ((str = this.f14620f) != null ? str.equals(tVar.i()) : tVar.i() == null) && this.f14621g == tVar.j() && ((wVar = this.f14622h) != null ? wVar.equals(tVar.g()) : tVar.g() == null) && ((qVar = this.f14623i) != null ? qVar.equals(tVar.f()) : tVar.f() == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // k4.t
    public q f() {
        return this.f14623i;
    }

    @Override // k4.t
    public w g() {
        return this.f14622h;
    }

    @Override // k4.t
    public byte[] h() {
        return this.f14619e;
    }

    public int hashCode() {
        long j10 = this.f14615a;
        int i10 = (((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f14616b;
        int iHashCode = (i10 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        p pVar = this.f14617c;
        int iHashCode2 = pVar == null ? 0 : pVar.hashCode();
        long j11 = this.f14618d;
        int iHashCode3 = (((((iHashCode ^ iHashCode2) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f14619e)) * 1000003;
        String str = this.f14620f;
        int iHashCode4 = str == null ? 0 : str.hashCode();
        long j12 = this.f14621g;
        int i11 = (((iHashCode3 ^ iHashCode4) * 1000003) ^ ((int) ((j12 >>> 32) ^ j12))) * 1000003;
        w wVar = this.f14622h;
        int iHashCode5 = (i11 ^ (wVar == null ? 0 : wVar.hashCode())) * 1000003;
        q qVar = this.f14623i;
        return iHashCode5 ^ (qVar != null ? qVar.hashCode() : 0);
    }

    @Override // k4.t
    public String i() {
        return this.f14620f;
    }

    @Override // k4.t
    public long j() {
        return this.f14621g;
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.f14615a + ", eventCode=" + this.f14616b + ", complianceData=" + this.f14617c + ", eventUptimeMs=" + this.f14618d + ", sourceExtension=" + Arrays.toString(this.f14619e) + ", sourceExtensionJsonProto3=" + this.f14620f + ", timezoneOffsetSeconds=" + this.f14621g + ", networkConnectionInfo=" + this.f14622h + ", experimentIds=" + this.f14623i + "}";
    }

    public j(long j10, Integer num, p pVar, long j11, byte[] bArr, String str, long j12, w wVar, q qVar) {
        this.f14615a = j10;
        this.f14616b = num;
        this.f14617c = pVar;
        this.f14618d = j11;
        this.f14619e = bArr;
        this.f14620f = str;
        this.f14621g = j12;
        this.f14622h = wVar;
        this.f14623i = qVar;
    }
}
