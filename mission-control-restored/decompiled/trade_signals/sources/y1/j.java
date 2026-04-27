package y1;

import java.util.Arrays;
import y1.t;

/* JADX INFO: loaded from: classes.dex */
public final class j extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f24354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f24355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f24356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f24357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f24358e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f24359f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f24360g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final w f24361h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final q f24362i;

    public static final class b extends t.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f24363a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f24364b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public p f24365c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f24366d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte[] f24367e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f24368f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Long f24369g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public w f24370h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public q f24371i;

        @Override // y1.t.a
        public t a() {
            String str = "";
            if (this.f24363a == null) {
                str = " eventTimeMs";
            }
            if (this.f24366d == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f24369g == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new j(this.f24363a.longValue(), this.f24364b, this.f24365c, this.f24366d.longValue(), this.f24367e, this.f24368f, this.f24369g.longValue(), this.f24370h, this.f24371i);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // y1.t.a
        public t.a b(p pVar) {
            this.f24365c = pVar;
            return this;
        }

        @Override // y1.t.a
        public t.a c(Integer num) {
            this.f24364b = num;
            return this;
        }

        @Override // y1.t.a
        public t.a d(long j8) {
            this.f24363a = Long.valueOf(j8);
            return this;
        }

        @Override // y1.t.a
        public t.a e(long j8) {
            this.f24366d = Long.valueOf(j8);
            return this;
        }

        @Override // y1.t.a
        public t.a f(q qVar) {
            this.f24371i = qVar;
            return this;
        }

        @Override // y1.t.a
        public t.a g(w wVar) {
            this.f24370h = wVar;
            return this;
        }

        @Override // y1.t.a
        public t.a h(byte[] bArr) {
            this.f24367e = bArr;
            return this;
        }

        @Override // y1.t.a
        public t.a i(String str) {
            this.f24368f = str;
            return this;
        }

        @Override // y1.t.a
        public t.a j(long j8) {
            this.f24369g = Long.valueOf(j8);
            return this;
        }
    }

    public j(long j8, Integer num, p pVar, long j9, byte[] bArr, String str, long j10, w wVar, q qVar) {
        this.f24354a = j8;
        this.f24355b = num;
        this.f24356c = pVar;
        this.f24357d = j9;
        this.f24358e = bArr;
        this.f24359f = str;
        this.f24360g = j10;
        this.f24361h = wVar;
        this.f24362i = qVar;
    }

    @Override // y1.t
    public p b() {
        return this.f24356c;
    }

    @Override // y1.t
    public Integer c() {
        return this.f24355b;
    }

    @Override // y1.t
    public long d() {
        return this.f24354a;
    }

    @Override // y1.t
    public long e() {
        return this.f24357d;
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
        if (this.f24354a == tVar.d() && ((num = this.f24355b) != null ? num.equals(tVar.c()) : tVar.c() == null) && ((pVar = this.f24356c) != null ? pVar.equals(tVar.b()) : tVar.b() == null) && this.f24357d == tVar.e()) {
            if (Arrays.equals(this.f24358e, tVar instanceof j ? ((j) tVar).f24358e : tVar.h()) && ((str = this.f24359f) != null ? str.equals(tVar.i()) : tVar.i() == null) && this.f24360g == tVar.j() && ((wVar = this.f24361h) != null ? wVar.equals(tVar.g()) : tVar.g() == null)) {
                q qVar = this.f24362i;
                q qVarF = tVar.f();
                if (qVar == null) {
                    if (qVarF == null) {
                        return true;
                    }
                } else if (qVar.equals(qVarF)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // y1.t
    public q f() {
        return this.f24362i;
    }

    @Override // y1.t
    public w g() {
        return this.f24361h;
    }

    @Override // y1.t
    public byte[] h() {
        return this.f24358e;
    }

    public int hashCode() {
        long j8 = this.f24354a;
        int i8 = (((int) (j8 ^ (j8 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f24355b;
        int iHashCode = (i8 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        p pVar = this.f24356c;
        int iHashCode2 = pVar == null ? 0 : pVar.hashCode();
        long j9 = this.f24357d;
        int iHashCode3 = (((((iHashCode ^ iHashCode2) * 1000003) ^ ((int) (j9 ^ (j9 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f24358e)) * 1000003;
        String str = this.f24359f;
        int iHashCode4 = str == null ? 0 : str.hashCode();
        long j10 = this.f24360g;
        int i9 = (((iHashCode3 ^ iHashCode4) * 1000003) ^ ((int) ((j10 >>> 32) ^ j10))) * 1000003;
        w wVar = this.f24361h;
        int iHashCode5 = (i9 ^ (wVar == null ? 0 : wVar.hashCode())) * 1000003;
        q qVar = this.f24362i;
        return iHashCode5 ^ (qVar != null ? qVar.hashCode() : 0);
    }

    @Override // y1.t
    public String i() {
        return this.f24359f;
    }

    @Override // y1.t
    public long j() {
        return this.f24360g;
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.f24354a + ", eventCode=" + this.f24355b + ", complianceData=" + this.f24356c + ", eventUptimeMs=" + this.f24357d + ", sourceExtension=" + Arrays.toString(this.f24358e) + ", sourceExtensionJsonProto3=" + this.f24359f + ", timezoneOffsetSeconds=" + this.f24360g + ", networkConnectionInfo=" + this.f24361h + ", experimentIds=" + this.f24362i + "}";
    }
}
