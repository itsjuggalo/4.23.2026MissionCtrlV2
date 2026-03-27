package V2;

import V2.F;
import java.util.List;

/* JADX INFO: renamed from: V2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0970c extends F.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f8695e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f8696f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f8697g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f8698h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List f8699i;

    /* JADX INFO: renamed from: V2.c$b */
    public static final class b extends F.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8701b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8702c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8703d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f8704e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f8705f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f8706g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f8707h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public List f8708i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public byte f8709j;

        @Override // V2.F.a.b
        public F.a a() {
            String str;
            if (this.f8709j == 63 && (str = this.f8701b) != null) {
                return new C0970c(this.f8700a, str, this.f8702c, this.f8703d, this.f8704e, this.f8705f, this.f8706g, this.f8707h, this.f8708i);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f8709j & 1) == 0) {
                sb.append(" pid");
            }
            if (this.f8701b == null) {
                sb.append(" processName");
            }
            if ((this.f8709j & 2) == 0) {
                sb.append(" reasonCode");
            }
            if ((this.f8709j & 4) == 0) {
                sb.append(" importance");
            }
            if ((this.f8709j & 8) == 0) {
                sb.append(" pss");
            }
            if ((this.f8709j & 16) == 0) {
                sb.append(" rss");
            }
            if ((this.f8709j & 32) == 0) {
                sb.append(" timestamp");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // V2.F.a.b
        public F.a.b b(List list) {
            this.f8708i = list;
            return this;
        }

        @Override // V2.F.a.b
        public F.a.b c(int i8) {
            this.f8703d = i8;
            this.f8709j = (byte) (this.f8709j | 4);
            return this;
        }

        @Override // V2.F.a.b
        public F.a.b d(int i8) {
            this.f8700a = i8;
            this.f8709j = (byte) (this.f8709j | 1);
            return this;
        }

        @Override // V2.F.a.b
        public F.a.b e(String str) {
            if (str == null) {
                throw new NullPointerException("Null processName");
            }
            this.f8701b = str;
            return this;
        }

        @Override // V2.F.a.b
        public F.a.b f(long j8) {
            this.f8704e = j8;
            this.f8709j = (byte) (this.f8709j | 8);
            return this;
        }

        @Override // V2.F.a.b
        public F.a.b g(int i8) {
            this.f8702c = i8;
            this.f8709j = (byte) (this.f8709j | 2);
            return this;
        }

        @Override // V2.F.a.b
        public F.a.b h(long j8) {
            this.f8705f = j8;
            this.f8709j = (byte) (this.f8709j | 16);
            return this;
        }

        @Override // V2.F.a.b
        public F.a.b i(long j8) {
            this.f8706g = j8;
            this.f8709j = (byte) (this.f8709j | 32);
            return this;
        }

        @Override // V2.F.a.b
        public F.a.b j(String str) {
            this.f8707h = str;
            return this;
        }
    }

    public C0970c(int i8, String str, int i9, int i10, long j8, long j9, long j10, String str2, List list) {
        this.f8691a = i8;
        this.f8692b = str;
        this.f8693c = i9;
        this.f8694d = i10;
        this.f8695e = j8;
        this.f8696f = j9;
        this.f8697g = j10;
        this.f8698h = str2;
        this.f8699i = list;
    }

    @Override // V2.F.a
    public List b() {
        return this.f8699i;
    }

    @Override // V2.F.a
    public int c() {
        return this.f8694d;
    }

    @Override // V2.F.a
    public int d() {
        return this.f8691a;
    }

    @Override // V2.F.a
    public String e() {
        return this.f8692b;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof F.a)) {
            return false;
        }
        F.a aVar = (F.a) obj;
        if (this.f8691a == aVar.d() && this.f8692b.equals(aVar.e()) && this.f8693c == aVar.g() && this.f8694d == aVar.c() && this.f8695e == aVar.f() && this.f8696f == aVar.h() && this.f8697g == aVar.i() && ((str = this.f8698h) != null ? str.equals(aVar.j()) : aVar.j() == null)) {
            List list = this.f8699i;
            List listB = aVar.b();
            if (list == null) {
                if (listB == null) {
                    return true;
                }
            } else if (list.equals(listB)) {
                return true;
            }
        }
        return false;
    }

    @Override // V2.F.a
    public long f() {
        return this.f8695e;
    }

    @Override // V2.F.a
    public int g() {
        return this.f8693c;
    }

    @Override // V2.F.a
    public long h() {
        return this.f8696f;
    }

    public int hashCode() {
        int iHashCode = (((((((this.f8691a ^ 1000003) * 1000003) ^ this.f8692b.hashCode()) * 1000003) ^ this.f8693c) * 1000003) ^ this.f8694d) * 1000003;
        long j8 = this.f8695e;
        int i8 = (iHashCode ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003;
        long j9 = this.f8696f;
        int i9 = (i8 ^ ((int) (j9 ^ (j9 >>> 32)))) * 1000003;
        long j10 = this.f8697g;
        int i10 = (i9 ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        String str = this.f8698h;
        int iHashCode2 = (i10 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List list = this.f8699i;
        return iHashCode2 ^ (list != null ? list.hashCode() : 0);
    }

    @Override // V2.F.a
    public long i() {
        return this.f8697g;
    }

    @Override // V2.F.a
    public String j() {
        return this.f8698h;
    }

    public String toString() {
        return "ApplicationExitInfo{pid=" + this.f8691a + ", processName=" + this.f8692b + ", reasonCode=" + this.f8693c + ", importance=" + this.f8694d + ", pss=" + this.f8695e + ", rss=" + this.f8696f + ", timestamp=" + this.f8697g + ", traceFile=" + this.f8698h + ", buildIdMappingForArch=" + this.f8699i + "}";
    }
}
