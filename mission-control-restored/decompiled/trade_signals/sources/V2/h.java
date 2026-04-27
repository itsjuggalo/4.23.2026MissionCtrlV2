package V2;

import V2.F;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class h extends F.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f8731d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f8732e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f8733f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final F.e.a f8734g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final F.e.f f8735h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final F.e.AbstractC0139e f8736i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final F.e.c f8737j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List f8738k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f8739l;

    public static final class b extends F.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8741b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f8742c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f8743d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f8744e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f8745f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public F.e.a f8746g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public F.e.f f8747h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public F.e.AbstractC0139e f8748i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public F.e.c f8749j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public List f8750k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f8751l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public byte f8752m;

        public b() {
        }

        @Override // V2.F.e.b
        public F.e a() {
            String str;
            String str2;
            F.e.a aVar;
            if (this.f8752m == 7 && (str = this.f8740a) != null && (str2 = this.f8741b) != null && (aVar = this.f8746g) != null) {
                return new h(str, str2, this.f8742c, this.f8743d, this.f8744e, this.f8745f, aVar, this.f8747h, this.f8748i, this.f8749j, this.f8750k, this.f8751l);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f8740a == null) {
                sb.append(" generator");
            }
            if (this.f8741b == null) {
                sb.append(" identifier");
            }
            if ((this.f8752m & 1) == 0) {
                sb.append(" startedAt");
            }
            if ((this.f8752m & 2) == 0) {
                sb.append(" crashed");
            }
            if (this.f8746g == null) {
                sb.append(" app");
            }
            if ((this.f8752m & 4) == 0) {
                sb.append(" generatorType");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // V2.F.e.b
        public F.e.b b(F.e.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("Null app");
            }
            this.f8746g = aVar;
            return this;
        }

        @Override // V2.F.e.b
        public F.e.b c(String str) {
            this.f8742c = str;
            return this;
        }

        @Override // V2.F.e.b
        public F.e.b d(boolean z7) {
            this.f8745f = z7;
            this.f8752m = (byte) (this.f8752m | 2);
            return this;
        }

        @Override // V2.F.e.b
        public F.e.b e(F.e.c cVar) {
            this.f8749j = cVar;
            return this;
        }

        @Override // V2.F.e.b
        public F.e.b f(Long l8) {
            this.f8744e = l8;
            return this;
        }

        @Override // V2.F.e.b
        public F.e.b g(List list) {
            this.f8750k = list;
            return this;
        }

        @Override // V2.F.e.b
        public F.e.b h(String str) {
            if (str == null) {
                throw new NullPointerException("Null generator");
            }
            this.f8740a = str;
            return this;
        }

        @Override // V2.F.e.b
        public F.e.b i(int i8) {
            this.f8751l = i8;
            this.f8752m = (byte) (this.f8752m | 4);
            return this;
        }

        @Override // V2.F.e.b
        public F.e.b j(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.f8741b = str;
            return this;
        }

        @Override // V2.F.e.b
        public F.e.b l(F.e.AbstractC0139e abstractC0139e) {
            this.f8748i = abstractC0139e;
            return this;
        }

        @Override // V2.F.e.b
        public F.e.b m(long j8) {
            this.f8743d = j8;
            this.f8752m = (byte) (this.f8752m | 1);
            return this;
        }

        @Override // V2.F.e.b
        public F.e.b n(F.e.f fVar) {
            this.f8747h = fVar;
            return this;
        }

        public b(F.e eVar) {
            this.f8740a = eVar.g();
            this.f8741b = eVar.i();
            this.f8742c = eVar.c();
            this.f8743d = eVar.l();
            this.f8744e = eVar.e();
            this.f8745f = eVar.n();
            this.f8746g = eVar.b();
            this.f8747h = eVar.m();
            this.f8748i = eVar.k();
            this.f8749j = eVar.d();
            this.f8750k = eVar.f();
            this.f8751l = eVar.h();
            this.f8752m = (byte) 7;
        }
    }

    public h(String str, String str2, String str3, long j8, Long l8, boolean z7, F.e.a aVar, F.e.f fVar, F.e.AbstractC0139e abstractC0139e, F.e.c cVar, List list, int i8) {
        this.f8728a = str;
        this.f8729b = str2;
        this.f8730c = str3;
        this.f8731d = j8;
        this.f8732e = l8;
        this.f8733f = z7;
        this.f8734g = aVar;
        this.f8735h = fVar;
        this.f8736i = abstractC0139e;
        this.f8737j = cVar;
        this.f8738k = list;
        this.f8739l = i8;
    }

    @Override // V2.F.e
    public F.e.a b() {
        return this.f8734g;
    }

    @Override // V2.F.e
    public String c() {
        return this.f8730c;
    }

    @Override // V2.F.e
    public F.e.c d() {
        return this.f8737j;
    }

    @Override // V2.F.e
    public Long e() {
        return this.f8732e;
    }

    public boolean equals(Object obj) {
        String str;
        Long l8;
        F.e.f fVar;
        F.e.AbstractC0139e abstractC0139e;
        F.e.c cVar;
        List list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof F.e)) {
            return false;
        }
        F.e eVar = (F.e) obj;
        return this.f8728a.equals(eVar.g()) && this.f8729b.equals(eVar.i()) && ((str = this.f8730c) != null ? str.equals(eVar.c()) : eVar.c() == null) && this.f8731d == eVar.l() && ((l8 = this.f8732e) != null ? l8.equals(eVar.e()) : eVar.e() == null) && this.f8733f == eVar.n() && this.f8734g.equals(eVar.b()) && ((fVar = this.f8735h) != null ? fVar.equals(eVar.m()) : eVar.m() == null) && ((abstractC0139e = this.f8736i) != null ? abstractC0139e.equals(eVar.k()) : eVar.k() == null) && ((cVar = this.f8737j) != null ? cVar.equals(eVar.d()) : eVar.d() == null) && ((list = this.f8738k) != null ? list.equals(eVar.f()) : eVar.f() == null) && this.f8739l == eVar.h();
    }

    @Override // V2.F.e
    public List f() {
        return this.f8738k;
    }

    @Override // V2.F.e
    public String g() {
        return this.f8728a;
    }

    @Override // V2.F.e
    public int h() {
        return this.f8739l;
    }

    public int hashCode() {
        int iHashCode = (((this.f8728a.hashCode() ^ 1000003) * 1000003) ^ this.f8729b.hashCode()) * 1000003;
        String str = this.f8730c;
        int iHashCode2 = str == null ? 0 : str.hashCode();
        long j8 = this.f8731d;
        int i8 = (((iHashCode ^ iHashCode2) * 1000003) ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003;
        Long l8 = this.f8732e;
        int iHashCode3 = (((((i8 ^ (l8 == null ? 0 : l8.hashCode())) * 1000003) ^ (this.f8733f ? 1231 : 1237)) * 1000003) ^ this.f8734g.hashCode()) * 1000003;
        F.e.f fVar = this.f8735h;
        int iHashCode4 = (iHashCode3 ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        F.e.AbstractC0139e abstractC0139e = this.f8736i;
        int iHashCode5 = (iHashCode4 ^ (abstractC0139e == null ? 0 : abstractC0139e.hashCode())) * 1000003;
        F.e.c cVar = this.f8737j;
        int iHashCode6 = (iHashCode5 ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        List list = this.f8738k;
        return ((iHashCode6 ^ (list != null ? list.hashCode() : 0)) * 1000003) ^ this.f8739l;
    }

    @Override // V2.F.e
    public String i() {
        return this.f8729b;
    }

    @Override // V2.F.e
    public F.e.AbstractC0139e k() {
        return this.f8736i;
    }

    @Override // V2.F.e
    public long l() {
        return this.f8731d;
    }

    @Override // V2.F.e
    public F.e.f m() {
        return this.f8735h;
    }

    @Override // V2.F.e
    public boolean n() {
        return this.f8733f;
    }

    @Override // V2.F.e
    public F.e.b o() {
        return new b(this);
    }

    public String toString() {
        return "Session{generator=" + this.f8728a + ", identifier=" + this.f8729b + ", appQualitySessionId=" + this.f8730c + ", startedAt=" + this.f8731d + ", endedAt=" + this.f8732e + ", crashed=" + this.f8733f + ", app=" + this.f8734g + ", user=" + this.f8735h + ", os=" + this.f8736i + ", device=" + this.f8737j + ", events=" + this.f8738k + ", generatorType=" + this.f8739l + "}";
    }
}
