package x7;

import java.util.List;
import x7.f0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends f0.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f24487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f24488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f24489d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f24490e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f24491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f0.e.a f24492g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f0.e.f f24493h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final f0.e.AbstractC0447e f24494i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final f0.e.c f24495j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List f24496k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f24497l;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends f0.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f24498a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f24499b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f24500c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f24501d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f24502e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f24503f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public f0.e.a f24504g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public f0.e.f f24505h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public f0.e.AbstractC0447e f24506i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public f0.e.c f24507j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public List f24508k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f24509l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public byte f24510m;

        @Override // x7.f0.e.b
        public f0.e a() {
            String str;
            String str2;
            f0.e.a aVar;
            if (this.f24510m == 7 && (str = this.f24498a) != null && (str2 = this.f24499b) != null && (aVar = this.f24504g) != null) {
                return new h(str, str2, this.f24500c, this.f24501d, this.f24502e, this.f24503f, aVar, this.f24505h, this.f24506i, this.f24507j, this.f24508k, this.f24509l);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.f24498a == null) {
                sb2.append(" generator");
            }
            if (this.f24499b == null) {
                sb2.append(" identifier");
            }
            if ((this.f24510m & 1) == 0) {
                sb2.append(" startedAt");
            }
            if ((this.f24510m & 2) == 0) {
                sb2.append(" crashed");
            }
            if (this.f24504g == null) {
                sb2.append(" app");
            }
            if ((this.f24510m & 4) == 0) {
                sb2.append(" generatorType");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // x7.f0.e.b
        public f0.e.b b(f0.e.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("Null app");
            }
            this.f24504g = aVar;
            return this;
        }

        @Override // x7.f0.e.b
        public f0.e.b c(String str) {
            this.f24500c = str;
            return this;
        }

        @Override // x7.f0.e.b
        public f0.e.b d(boolean z10) {
            this.f24503f = z10;
            this.f24510m = (byte) (this.f24510m | 2);
            return this;
        }

        @Override // x7.f0.e.b
        public f0.e.b e(f0.e.c cVar) {
            this.f24507j = cVar;
            return this;
        }

        @Override // x7.f0.e.b
        public f0.e.b f(Long l10) {
            this.f24502e = l10;
            return this;
        }

        @Override // x7.f0.e.b
        public f0.e.b g(List list) {
            this.f24508k = list;
            return this;
        }

        @Override // x7.f0.e.b
        public f0.e.b h(String str) {
            if (str == null) {
                throw new NullPointerException("Null generator");
            }
            this.f24498a = str;
            return this;
        }

        @Override // x7.f0.e.b
        public f0.e.b i(int i10) {
            this.f24509l = i10;
            this.f24510m = (byte) (this.f24510m | 4);
            return this;
        }

        @Override // x7.f0.e.b
        public f0.e.b j(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.f24499b = str;
            return this;
        }

        @Override // x7.f0.e.b
        public f0.e.b l(f0.e.AbstractC0447e abstractC0447e) {
            this.f24506i = abstractC0447e;
            return this;
        }

        @Override // x7.f0.e.b
        public f0.e.b m(long j10) {
            this.f24501d = j10;
            this.f24510m = (byte) (this.f24510m | 1);
            return this;
        }

        @Override // x7.f0.e.b
        public f0.e.b n(f0.e.f fVar) {
            this.f24505h = fVar;
            return this;
        }

        public b() {
        }

        public b(f0.e eVar) {
            this.f24498a = eVar.g();
            this.f24499b = eVar.i();
            this.f24500c = eVar.c();
            this.f24501d = eVar.l();
            this.f24502e = eVar.e();
            this.f24503f = eVar.n();
            this.f24504g = eVar.b();
            this.f24505h = eVar.m();
            this.f24506i = eVar.k();
            this.f24507j = eVar.d();
            this.f24508k = eVar.f();
            this.f24509l = eVar.h();
            this.f24510m = (byte) 7;
        }
    }

    @Override // x7.f0.e
    public f0.e.a b() {
        return this.f24492g;
    }

    @Override // x7.f0.e
    public String c() {
        return this.f24488c;
    }

    @Override // x7.f0.e
    public f0.e.c d() {
        return this.f24495j;
    }

    @Override // x7.f0.e
    public Long e() {
        return this.f24490e;
    }

    public boolean equals(Object obj) {
        String str;
        Long l10;
        f0.e.f fVar;
        f0.e.AbstractC0447e abstractC0447e;
        f0.e.c cVar;
        List list;
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0.e) {
            f0.e eVar = (f0.e) obj;
            if (this.f24486a.equals(eVar.g()) && this.f24487b.equals(eVar.i()) && ((str = this.f24488c) != null ? str.equals(eVar.c()) : eVar.c() == null) && this.f24489d == eVar.l() && ((l10 = this.f24490e) != null ? l10.equals(eVar.e()) : eVar.e() == null) && this.f24491f == eVar.n() && this.f24492g.equals(eVar.b()) && ((fVar = this.f24493h) != null ? fVar.equals(eVar.m()) : eVar.m() == null) && ((abstractC0447e = this.f24494i) != null ? abstractC0447e.equals(eVar.k()) : eVar.k() == null) && ((cVar = this.f24495j) != null ? cVar.equals(eVar.d()) : eVar.d() == null) && ((list = this.f24496k) != null ? list.equals(eVar.f()) : eVar.f() == null) && this.f24497l == eVar.h()) {
                return true;
            }
        }
        return false;
    }

    @Override // x7.f0.e
    public List f() {
        return this.f24496k;
    }

    @Override // x7.f0.e
    public String g() {
        return this.f24486a;
    }

    @Override // x7.f0.e
    public int h() {
        return this.f24497l;
    }

    public int hashCode() {
        int iHashCode = (((this.f24486a.hashCode() ^ 1000003) * 1000003) ^ this.f24487b.hashCode()) * 1000003;
        String str = this.f24488c;
        int iHashCode2 = str == null ? 0 : str.hashCode();
        long j10 = this.f24489d;
        int i10 = (((iHashCode ^ iHashCode2) * 1000003) ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        Long l10 = this.f24490e;
        int iHashCode3 = (((((i10 ^ (l10 == null ? 0 : l10.hashCode())) * 1000003) ^ (this.f24491f ? 1231 : 1237)) * 1000003) ^ this.f24492g.hashCode()) * 1000003;
        f0.e.f fVar = this.f24493h;
        int iHashCode4 = (iHashCode3 ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        f0.e.AbstractC0447e abstractC0447e = this.f24494i;
        int iHashCode5 = (iHashCode4 ^ (abstractC0447e == null ? 0 : abstractC0447e.hashCode())) * 1000003;
        f0.e.c cVar = this.f24495j;
        int iHashCode6 = (iHashCode5 ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        List list = this.f24496k;
        return ((iHashCode6 ^ (list != null ? list.hashCode() : 0)) * 1000003) ^ this.f24497l;
    }

    @Override // x7.f0.e
    public String i() {
        return this.f24487b;
    }

    @Override // x7.f0.e
    public f0.e.AbstractC0447e k() {
        return this.f24494i;
    }

    @Override // x7.f0.e
    public long l() {
        return this.f24489d;
    }

    @Override // x7.f0.e
    public f0.e.f m() {
        return this.f24493h;
    }

    @Override // x7.f0.e
    public boolean n() {
        return this.f24491f;
    }

    @Override // x7.f0.e
    public f0.e.b o() {
        return new b(this);
    }

    public String toString() {
        return "Session{generator=" + this.f24486a + ", identifier=" + this.f24487b + ", appQualitySessionId=" + this.f24488c + ", startedAt=" + this.f24489d + ", endedAt=" + this.f24490e + ", crashed=" + this.f24491f + ", app=" + this.f24492g + ", user=" + this.f24493h + ", os=" + this.f24494i + ", device=" + this.f24495j + ", events=" + this.f24496k + ", generatorType=" + this.f24497l + "}";
    }

    public h(String str, String str2, String str3, long j10, Long l10, boolean z10, f0.e.a aVar, f0.e.f fVar, f0.e.AbstractC0447e abstractC0447e, f0.e.c cVar, List list, int i10) {
        this.f24486a = str;
        this.f24487b = str2;
        this.f24488c = str3;
        this.f24489d = j10;
        this.f24490e = l10;
        this.f24491f = z10;
        this.f24492g = aVar;
        this.f24493h = fVar;
        this.f24494i = abstractC0447e;
        this.f24495j = cVar;
        this.f24496k = list;
        this.f24497l = i10;
    }
}
