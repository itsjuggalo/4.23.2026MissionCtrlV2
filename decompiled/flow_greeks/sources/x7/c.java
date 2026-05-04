package x7;

import java.util.List;
import x7.f0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends f0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f24430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f24431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f24432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f24433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f24434e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f24435f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f24436g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f24437h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List f24438i;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends f0.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f24439a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f24440b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f24441c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f24442d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f24443e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f24444f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f24445g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f24446h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public List f24447i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public byte f24448j;

        @Override // x7.f0.a.b
        public f0.a a() {
            String str;
            if (this.f24448j == 63 && (str = this.f24440b) != null) {
                return new c(this.f24439a, str, this.f24441c, this.f24442d, this.f24443e, this.f24444f, this.f24445g, this.f24446h, this.f24447i);
            }
            StringBuilder sb2 = new StringBuilder();
            if ((this.f24448j & 1) == 0) {
                sb2.append(" pid");
            }
            if (this.f24440b == null) {
                sb2.append(" processName");
            }
            if ((this.f24448j & 2) == 0) {
                sb2.append(" reasonCode");
            }
            if ((this.f24448j & 4) == 0) {
                sb2.append(" importance");
            }
            if ((this.f24448j & 8) == 0) {
                sb2.append(" pss");
            }
            if ((this.f24448j & 16) == 0) {
                sb2.append(" rss");
            }
            if ((this.f24448j & 32) == 0) {
                sb2.append(" timestamp");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // x7.f0.a.b
        public f0.a.b b(List list) {
            this.f24447i = list;
            return this;
        }

        @Override // x7.f0.a.b
        public f0.a.b c(int i10) {
            this.f24442d = i10;
            this.f24448j = (byte) (this.f24448j | 4);
            return this;
        }

        @Override // x7.f0.a.b
        public f0.a.b d(int i10) {
            this.f24439a = i10;
            this.f24448j = (byte) (this.f24448j | 1);
            return this;
        }

        @Override // x7.f0.a.b
        public f0.a.b e(String str) {
            if (str == null) {
                throw new NullPointerException("Null processName");
            }
            this.f24440b = str;
            return this;
        }

        @Override // x7.f0.a.b
        public f0.a.b f(long j10) {
            this.f24443e = j10;
            this.f24448j = (byte) (this.f24448j | 8);
            return this;
        }

        @Override // x7.f0.a.b
        public f0.a.b g(int i10) {
            this.f24441c = i10;
            this.f24448j = (byte) (this.f24448j | 2);
            return this;
        }

        @Override // x7.f0.a.b
        public f0.a.b h(long j10) {
            this.f24444f = j10;
            this.f24448j = (byte) (this.f24448j | 16);
            return this;
        }

        @Override // x7.f0.a.b
        public f0.a.b i(long j10) {
            this.f24445g = j10;
            this.f24448j = (byte) (this.f24448j | 32);
            return this;
        }

        @Override // x7.f0.a.b
        public f0.a.b j(String str) {
            this.f24446h = str;
            return this;
        }
    }

    @Override // x7.f0.a
    public List b() {
        return this.f24438i;
    }

    @Override // x7.f0.a
    public int c() {
        return this.f24433d;
    }

    @Override // x7.f0.a
    public int d() {
        return this.f24430a;
    }

    @Override // x7.f0.a
    public String e() {
        return this.f24431b;
    }

    public boolean equals(Object obj) {
        String str;
        List list;
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0.a) {
            f0.a aVar = (f0.a) obj;
            if (this.f24430a == aVar.d() && this.f24431b.equals(aVar.e()) && this.f24432c == aVar.g() && this.f24433d == aVar.c() && this.f24434e == aVar.f() && this.f24435f == aVar.h() && this.f24436g == aVar.i() && ((str = this.f24437h) != null ? str.equals(aVar.j()) : aVar.j() == null) && ((list = this.f24438i) != null ? list.equals(aVar.b()) : aVar.b() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // x7.f0.a
    public long f() {
        return this.f24434e;
    }

    @Override // x7.f0.a
    public int g() {
        return this.f24432c;
    }

    @Override // x7.f0.a
    public long h() {
        return this.f24435f;
    }

    public int hashCode() {
        int iHashCode = (((((((this.f24430a ^ 1000003) * 1000003) ^ this.f24431b.hashCode()) * 1000003) ^ this.f24432c) * 1000003) ^ this.f24433d) * 1000003;
        long j10 = this.f24434e;
        int i10 = (iHashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f24435f;
        int i11 = (i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        long j12 = this.f24436g;
        int i12 = (i11 ^ ((int) (j12 ^ (j12 >>> 32)))) * 1000003;
        String str = this.f24437h;
        int iHashCode2 = (i12 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List list = this.f24438i;
        return iHashCode2 ^ (list != null ? list.hashCode() : 0);
    }

    @Override // x7.f0.a
    public long i() {
        return this.f24436g;
    }

    @Override // x7.f0.a
    public String j() {
        return this.f24437h;
    }

    public String toString() {
        return "ApplicationExitInfo{pid=" + this.f24430a + ", processName=" + this.f24431b + ", reasonCode=" + this.f24432c + ", importance=" + this.f24433d + ", pss=" + this.f24434e + ", rss=" + this.f24435f + ", timestamp=" + this.f24436g + ", traceFile=" + this.f24437h + ", buildIdMappingForArch=" + this.f24438i + "}";
    }

    public c(int i10, String str, int i11, int i12, long j10, long j11, long j12, String str2, List list) {
        this.f24430a = i10;
        this.f24431b = str;
        this.f24432c = i11;
        this.f24433d = i12;
        this.f24434e = j10;
        this.f24435f = j11;
        this.f24436g = j12;
        this.f24437h = str2;
        this.f24438i = list;
    }
}
