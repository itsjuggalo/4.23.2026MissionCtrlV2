package k3;

import java.util.List;
import k3.AbstractC2074F;

/* JADX INFO: renamed from: k3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2078c extends AbstractC2074F.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f17773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f17774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f17775f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f17776g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f17777h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List f17778i;

    /* JADX INFO: renamed from: k3.c$b */
    public static final class b extends AbstractC2074F.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f17779a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f17780b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f17781c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f17782d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f17783e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f17784f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f17785g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f17786h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public List f17787i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public byte f17788j;

        @Override // k3.AbstractC2074F.a.b
        public AbstractC2074F.a a() {
            String str;
            if (this.f17788j == 63 && (str = this.f17780b) != null) {
                return new C2078c(this.f17779a, str, this.f17781c, this.f17782d, this.f17783e, this.f17784f, this.f17785g, this.f17786h, this.f17787i);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f17788j & 1) == 0) {
                sb.append(" pid");
            }
            if (this.f17780b == null) {
                sb.append(" processName");
            }
            if ((this.f17788j & 2) == 0) {
                sb.append(" reasonCode");
            }
            if ((this.f17788j & 4) == 0) {
                sb.append(" importance");
            }
            if ((this.f17788j & 8) == 0) {
                sb.append(" pss");
            }
            if ((this.f17788j & 16) == 0) {
                sb.append(" rss");
            }
            if ((this.f17788j & 32) == 0) {
                sb.append(" timestamp");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // k3.AbstractC2074F.a.b
        public AbstractC2074F.a.b b(List list) {
            this.f17787i = list;
            return this;
        }

        @Override // k3.AbstractC2074F.a.b
        public AbstractC2074F.a.b c(int i7) {
            this.f17782d = i7;
            this.f17788j = (byte) (this.f17788j | 4);
            return this;
        }

        @Override // k3.AbstractC2074F.a.b
        public AbstractC2074F.a.b d(int i7) {
            this.f17779a = i7;
            this.f17788j = (byte) (this.f17788j | 1);
            return this;
        }

        @Override // k3.AbstractC2074F.a.b
        public AbstractC2074F.a.b e(String str) {
            if (str == null) {
                throw new NullPointerException("Null processName");
            }
            this.f17780b = str;
            return this;
        }

        @Override // k3.AbstractC2074F.a.b
        public AbstractC2074F.a.b f(long j7) {
            this.f17783e = j7;
            this.f17788j = (byte) (this.f17788j | 8);
            return this;
        }

        @Override // k3.AbstractC2074F.a.b
        public AbstractC2074F.a.b g(int i7) {
            this.f17781c = i7;
            this.f17788j = (byte) (this.f17788j | 2);
            return this;
        }

        @Override // k3.AbstractC2074F.a.b
        public AbstractC2074F.a.b h(long j7) {
            this.f17784f = j7;
            this.f17788j = (byte) (this.f17788j | 16);
            return this;
        }

        @Override // k3.AbstractC2074F.a.b
        public AbstractC2074F.a.b i(long j7) {
            this.f17785g = j7;
            this.f17788j = (byte) (this.f17788j | 32);
            return this;
        }

        @Override // k3.AbstractC2074F.a.b
        public AbstractC2074F.a.b j(String str) {
            this.f17786h = str;
            return this;
        }
    }

    @Override // k3.AbstractC2074F.a
    public List b() {
        return this.f17778i;
    }

    @Override // k3.AbstractC2074F.a
    public int c() {
        return this.f17773d;
    }

    @Override // k3.AbstractC2074F.a
    public int d() {
        return this.f17770a;
    }

    @Override // k3.AbstractC2074F.a
    public String e() {
        return this.f17771b;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2074F.a)) {
            return false;
        }
        AbstractC2074F.a aVar = (AbstractC2074F.a) obj;
        if (this.f17770a == aVar.d() && this.f17771b.equals(aVar.e()) && this.f17772c == aVar.g() && this.f17773d == aVar.c() && this.f17774e == aVar.f() && this.f17775f == aVar.h() && this.f17776g == aVar.i() && ((str = this.f17777h) != null ? str.equals(aVar.j()) : aVar.j() == null)) {
            List list = this.f17778i;
            if (list == null) {
                if (aVar.b() == null) {
                    return true;
                }
            } else if (list.equals(aVar.b())) {
                return true;
            }
        }
        return false;
    }

    @Override // k3.AbstractC2074F.a
    public long f() {
        return this.f17774e;
    }

    @Override // k3.AbstractC2074F.a
    public int g() {
        return this.f17772c;
    }

    @Override // k3.AbstractC2074F.a
    public long h() {
        return this.f17775f;
    }

    public int hashCode() {
        int iHashCode = (((((((this.f17770a ^ 1000003) * 1000003) ^ this.f17771b.hashCode()) * 1000003) ^ this.f17772c) * 1000003) ^ this.f17773d) * 1000003;
        long j7 = this.f17774e;
        int i7 = (iHashCode ^ ((int) (j7 ^ (j7 >>> 32)))) * 1000003;
        long j8 = this.f17775f;
        int i8 = (i7 ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003;
        long j9 = this.f17776g;
        int i9 = (i8 ^ ((int) (j9 ^ (j9 >>> 32)))) * 1000003;
        String str = this.f17777h;
        int iHashCode2 = (i9 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List list = this.f17778i;
        return iHashCode2 ^ (list != null ? list.hashCode() : 0);
    }

    @Override // k3.AbstractC2074F.a
    public long i() {
        return this.f17776g;
    }

    @Override // k3.AbstractC2074F.a
    public String j() {
        return this.f17777h;
    }

    public String toString() {
        return "ApplicationExitInfo{pid=" + this.f17770a + ", processName=" + this.f17771b + ", reasonCode=" + this.f17772c + ", importance=" + this.f17773d + ", pss=" + this.f17774e + ", rss=" + this.f17775f + ", timestamp=" + this.f17776g + ", traceFile=" + this.f17777h + ", buildIdMappingForArch=" + this.f17778i + "}";
    }

    public C2078c(int i7, String str, int i8, int i9, long j7, long j8, long j9, String str2, List list) {
        this.f17770a = i7;
        this.f17771b = str;
        this.f17772c = i8;
        this.f17773d = i9;
        this.f17774e = j7;
        this.f17775f = j8;
        this.f17776g = j9;
        this.f17777h = str2;
        this.f17778i = list;
    }
}
