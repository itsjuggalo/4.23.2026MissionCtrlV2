package k3;

import java.util.List;
import k3.AbstractC2074F;

/* JADX INFO: renamed from: k3.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2083h extends AbstractC2074F.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f17810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f17811e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f17812f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AbstractC2074F.e.a f17813g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AbstractC2074F.e.f f17814h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AbstractC2074F.e.AbstractC0286e f17815i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AbstractC2074F.e.c f17816j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List f17817k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f17818l;

    /* JADX INFO: renamed from: k3.h$b */
    public static final class b extends AbstractC2074F.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f17819a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f17820b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f17821c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f17822d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f17823e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f17824f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public AbstractC2074F.e.a f17825g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public AbstractC2074F.e.f f17826h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public AbstractC2074F.e.AbstractC0286e f17827i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public AbstractC2074F.e.c f17828j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public List f17829k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f17830l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public byte f17831m;

        @Override // k3.AbstractC2074F.e.b
        public AbstractC2074F.e a() {
            String str;
            String str2;
            AbstractC2074F.e.a aVar;
            if (this.f17831m == 7 && (str = this.f17819a) != null && (str2 = this.f17820b) != null && (aVar = this.f17825g) != null) {
                return new C2083h(str, str2, this.f17821c, this.f17822d, this.f17823e, this.f17824f, aVar, this.f17826h, this.f17827i, this.f17828j, this.f17829k, this.f17830l);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f17819a == null) {
                sb.append(" generator");
            }
            if (this.f17820b == null) {
                sb.append(" identifier");
            }
            if ((this.f17831m & 1) == 0) {
                sb.append(" startedAt");
            }
            if ((this.f17831m & 2) == 0) {
                sb.append(" crashed");
            }
            if (this.f17825g == null) {
                sb.append(" app");
            }
            if ((this.f17831m & 4) == 0) {
                sb.append(" generatorType");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // k3.AbstractC2074F.e.b
        public AbstractC2074F.e.b b(AbstractC2074F.e.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("Null app");
            }
            this.f17825g = aVar;
            return this;
        }

        @Override // k3.AbstractC2074F.e.b
        public AbstractC2074F.e.b c(String str) {
            this.f17821c = str;
            return this;
        }

        @Override // k3.AbstractC2074F.e.b
        public AbstractC2074F.e.b d(boolean z7) {
            this.f17824f = z7;
            this.f17831m = (byte) (this.f17831m | 2);
            return this;
        }

        @Override // k3.AbstractC2074F.e.b
        public AbstractC2074F.e.b e(AbstractC2074F.e.c cVar) {
            this.f17828j = cVar;
            return this;
        }

        @Override // k3.AbstractC2074F.e.b
        public AbstractC2074F.e.b f(Long l7) {
            this.f17823e = l7;
            return this;
        }

        @Override // k3.AbstractC2074F.e.b
        public AbstractC2074F.e.b g(List list) {
            this.f17829k = list;
            return this;
        }

        @Override // k3.AbstractC2074F.e.b
        public AbstractC2074F.e.b h(String str) {
            if (str == null) {
                throw new NullPointerException("Null generator");
            }
            this.f17819a = str;
            return this;
        }

        @Override // k3.AbstractC2074F.e.b
        public AbstractC2074F.e.b i(int i7) {
            this.f17830l = i7;
            this.f17831m = (byte) (this.f17831m | 4);
            return this;
        }

        @Override // k3.AbstractC2074F.e.b
        public AbstractC2074F.e.b j(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.f17820b = str;
            return this;
        }

        @Override // k3.AbstractC2074F.e.b
        public AbstractC2074F.e.b l(AbstractC2074F.e.AbstractC0286e abstractC0286e) {
            this.f17827i = abstractC0286e;
            return this;
        }

        @Override // k3.AbstractC2074F.e.b
        public AbstractC2074F.e.b m(long j7) {
            this.f17822d = j7;
            this.f17831m = (byte) (this.f17831m | 1);
            return this;
        }

        @Override // k3.AbstractC2074F.e.b
        public AbstractC2074F.e.b n(AbstractC2074F.e.f fVar) {
            this.f17826h = fVar;
            return this;
        }

        public b() {
        }

        public b(AbstractC2074F.e eVar) {
            this.f17819a = eVar.g();
            this.f17820b = eVar.i();
            this.f17821c = eVar.c();
            this.f17822d = eVar.l();
            this.f17823e = eVar.e();
            this.f17824f = eVar.n();
            this.f17825g = eVar.b();
            this.f17826h = eVar.m();
            this.f17827i = eVar.k();
            this.f17828j = eVar.d();
            this.f17829k = eVar.f();
            this.f17830l = eVar.h();
            this.f17831m = (byte) 7;
        }
    }

    @Override // k3.AbstractC2074F.e
    public AbstractC2074F.e.a b() {
        return this.f17813g;
    }

    @Override // k3.AbstractC2074F.e
    public String c() {
        return this.f17809c;
    }

    @Override // k3.AbstractC2074F.e
    public AbstractC2074F.e.c d() {
        return this.f17816j;
    }

    @Override // k3.AbstractC2074F.e
    public Long e() {
        return this.f17811e;
    }

    public boolean equals(Object obj) {
        String str;
        Long l7;
        AbstractC2074F.e.f fVar;
        AbstractC2074F.e.AbstractC0286e abstractC0286e;
        AbstractC2074F.e.c cVar;
        List list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2074F.e)) {
            return false;
        }
        AbstractC2074F.e eVar = (AbstractC2074F.e) obj;
        return this.f17807a.equals(eVar.g()) && this.f17808b.equals(eVar.i()) && ((str = this.f17809c) != null ? str.equals(eVar.c()) : eVar.c() == null) && this.f17810d == eVar.l() && ((l7 = this.f17811e) != null ? l7.equals(eVar.e()) : eVar.e() == null) && this.f17812f == eVar.n() && this.f17813g.equals(eVar.b()) && ((fVar = this.f17814h) != null ? fVar.equals(eVar.m()) : eVar.m() == null) && ((abstractC0286e = this.f17815i) != null ? abstractC0286e.equals(eVar.k()) : eVar.k() == null) && ((cVar = this.f17816j) != null ? cVar.equals(eVar.d()) : eVar.d() == null) && ((list = this.f17817k) != null ? list.equals(eVar.f()) : eVar.f() == null) && this.f17818l == eVar.h();
    }

    @Override // k3.AbstractC2074F.e
    public List f() {
        return this.f17817k;
    }

    @Override // k3.AbstractC2074F.e
    public String g() {
        return this.f17807a;
    }

    @Override // k3.AbstractC2074F.e
    public int h() {
        return this.f17818l;
    }

    public int hashCode() {
        int iHashCode = (((this.f17807a.hashCode() ^ 1000003) * 1000003) ^ this.f17808b.hashCode()) * 1000003;
        String str = this.f17809c;
        int iHashCode2 = str == null ? 0 : str.hashCode();
        long j7 = this.f17810d;
        int i7 = (((iHashCode ^ iHashCode2) * 1000003) ^ ((int) (j7 ^ (j7 >>> 32)))) * 1000003;
        Long l7 = this.f17811e;
        int iHashCode3 = (((((i7 ^ (l7 == null ? 0 : l7.hashCode())) * 1000003) ^ (this.f17812f ? 1231 : 1237)) * 1000003) ^ this.f17813g.hashCode()) * 1000003;
        AbstractC2074F.e.f fVar = this.f17814h;
        int iHashCode4 = (iHashCode3 ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        AbstractC2074F.e.AbstractC0286e abstractC0286e = this.f17815i;
        int iHashCode5 = (iHashCode4 ^ (abstractC0286e == null ? 0 : abstractC0286e.hashCode())) * 1000003;
        AbstractC2074F.e.c cVar = this.f17816j;
        int iHashCode6 = (iHashCode5 ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        List list = this.f17817k;
        return ((iHashCode6 ^ (list != null ? list.hashCode() : 0)) * 1000003) ^ this.f17818l;
    }

    @Override // k3.AbstractC2074F.e
    public String i() {
        return this.f17808b;
    }

    @Override // k3.AbstractC2074F.e
    public AbstractC2074F.e.AbstractC0286e k() {
        return this.f17815i;
    }

    @Override // k3.AbstractC2074F.e
    public long l() {
        return this.f17810d;
    }

    @Override // k3.AbstractC2074F.e
    public AbstractC2074F.e.f m() {
        return this.f17814h;
    }

    @Override // k3.AbstractC2074F.e
    public boolean n() {
        return this.f17812f;
    }

    @Override // k3.AbstractC2074F.e
    public AbstractC2074F.e.b o() {
        return new b(this);
    }

    public String toString() {
        return "Session{generator=" + this.f17807a + ", identifier=" + this.f17808b + ", appQualitySessionId=" + this.f17809c + ", startedAt=" + this.f17810d + ", endedAt=" + this.f17811e + ", crashed=" + this.f17812f + ", app=" + this.f17813g + ", user=" + this.f17814h + ", os=" + this.f17815i + ", device=" + this.f17816j + ", events=" + this.f17817k + ", generatorType=" + this.f17818l + "}";
    }

    public C2083h(String str, String str2, String str3, long j7, Long l7, boolean z7, AbstractC2074F.e.a aVar, AbstractC2074F.e.f fVar, AbstractC2074F.e.AbstractC0286e abstractC0286e, AbstractC2074F.e.c cVar, List list, int i7) {
        this.f17807a = str;
        this.f17808b = str2;
        this.f17809c = str3;
        this.f17810d = j7;
        this.f17811e = l7;
        this.f17812f = z7;
        this.f17813g = aVar;
        this.f17814h = fVar;
        this.f17815i = abstractC0286e;
        this.f17816j = cVar;
        this.f17817k = list;
        this.f17818l = i7;
    }
}
