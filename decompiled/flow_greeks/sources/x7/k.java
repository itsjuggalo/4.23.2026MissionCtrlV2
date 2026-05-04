package x7;

import x7.f0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class k extends f0.e.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f24523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f24524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f24525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f24526d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f24527e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f24528f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f24529g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f24530h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f24531i;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends f0.e.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f24532a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f24533b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f24534c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f24535d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f24536e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f24537f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f24538g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f24539h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f24540i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public byte f24541j;

        @Override // x7.f0.e.c.a
        public f0.e.c a() {
            String str;
            String str2;
            String str3;
            if (this.f24541j == 63 && (str = this.f24533b) != null && (str2 = this.f24539h) != null && (str3 = this.f24540i) != null) {
                return new k(this.f24532a, str, this.f24534c, this.f24535d, this.f24536e, this.f24537f, this.f24538g, str2, str3);
            }
            StringBuilder sb2 = new StringBuilder();
            if ((this.f24541j & 1) == 0) {
                sb2.append(" arch");
            }
            if (this.f24533b == null) {
                sb2.append(" model");
            }
            if ((this.f24541j & 2) == 0) {
                sb2.append(" cores");
            }
            if ((this.f24541j & 4) == 0) {
                sb2.append(" ram");
            }
            if ((this.f24541j & 8) == 0) {
                sb2.append(" diskSpace");
            }
            if ((this.f24541j & 16) == 0) {
                sb2.append(" simulator");
            }
            if ((this.f24541j & 32) == 0) {
                sb2.append(" state");
            }
            if (this.f24539h == null) {
                sb2.append(" manufacturer");
            }
            if (this.f24540i == null) {
                sb2.append(" modelClass");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // x7.f0.e.c.a
        public f0.e.c.a b(int i10) {
            this.f24532a = i10;
            this.f24541j = (byte) (this.f24541j | 1);
            return this;
        }

        @Override // x7.f0.e.c.a
        public f0.e.c.a c(int i10) {
            this.f24534c = i10;
            this.f24541j = (byte) (this.f24541j | 2);
            return this;
        }

        @Override // x7.f0.e.c.a
        public f0.e.c.a d(long j10) {
            this.f24536e = j10;
            this.f24541j = (byte) (this.f24541j | 8);
            return this;
        }

        @Override // x7.f0.e.c.a
        public f0.e.c.a e(String str) {
            if (str == null) {
                throw new NullPointerException("Null manufacturer");
            }
            this.f24539h = str;
            return this;
        }

        @Override // x7.f0.e.c.a
        public f0.e.c.a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null model");
            }
            this.f24533b = str;
            return this;
        }

        @Override // x7.f0.e.c.a
        public f0.e.c.a g(String str) {
            if (str == null) {
                throw new NullPointerException("Null modelClass");
            }
            this.f24540i = str;
            return this;
        }

        @Override // x7.f0.e.c.a
        public f0.e.c.a h(long j10) {
            this.f24535d = j10;
            this.f24541j = (byte) (this.f24541j | 4);
            return this;
        }

        @Override // x7.f0.e.c.a
        public f0.e.c.a i(boolean z10) {
            this.f24537f = z10;
            this.f24541j = (byte) (this.f24541j | 16);
            return this;
        }

        @Override // x7.f0.e.c.a
        public f0.e.c.a j(int i10) {
            this.f24538g = i10;
            this.f24541j = (byte) (this.f24541j | 32);
            return this;
        }
    }

    @Override // x7.f0.e.c
    public int b() {
        return this.f24523a;
    }

    @Override // x7.f0.e.c
    public int c() {
        return this.f24525c;
    }

    @Override // x7.f0.e.c
    public long d() {
        return this.f24527e;
    }

    @Override // x7.f0.e.c
    public String e() {
        return this.f24530h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0.e.c) {
            f0.e.c cVar = (f0.e.c) obj;
            if (this.f24523a == cVar.b() && this.f24524b.equals(cVar.f()) && this.f24525c == cVar.c() && this.f24526d == cVar.h() && this.f24527e == cVar.d() && this.f24528f == cVar.j() && this.f24529g == cVar.i() && this.f24530h.equals(cVar.e()) && this.f24531i.equals(cVar.g())) {
                return true;
            }
        }
        return false;
    }

    @Override // x7.f0.e.c
    public String f() {
        return this.f24524b;
    }

    @Override // x7.f0.e.c
    public String g() {
        return this.f24531i;
    }

    @Override // x7.f0.e.c
    public long h() {
        return this.f24526d;
    }

    public int hashCode() {
        int iHashCode = (((((this.f24523a ^ 1000003) * 1000003) ^ this.f24524b.hashCode()) * 1000003) ^ this.f24525c) * 1000003;
        long j10 = this.f24526d;
        int i10 = (iHashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f24527e;
        return ((((((((i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ (this.f24528f ? 1231 : 1237)) * 1000003) ^ this.f24529g) * 1000003) ^ this.f24530h.hashCode()) * 1000003) ^ this.f24531i.hashCode();
    }

    @Override // x7.f0.e.c
    public int i() {
        return this.f24529g;
    }

    @Override // x7.f0.e.c
    public boolean j() {
        return this.f24528f;
    }

    public String toString() {
        return "Device{arch=" + this.f24523a + ", model=" + this.f24524b + ", cores=" + this.f24525c + ", ram=" + this.f24526d + ", diskSpace=" + this.f24527e + ", simulator=" + this.f24528f + ", state=" + this.f24529g + ", manufacturer=" + this.f24530h + ", modelClass=" + this.f24531i + "}";
    }

    public k(int i10, String str, int i11, long j10, long j11, boolean z10, int i12, String str2, String str3) {
        this.f24523a = i10;
        this.f24524b = str;
        this.f24525c = i11;
        this.f24526d = j10;
        this.f24527e = j11;
        this.f24528f = z10;
        this.f24529g = i12;
        this.f24530h = str2;
        this.f24531i = str3;
    }
}
