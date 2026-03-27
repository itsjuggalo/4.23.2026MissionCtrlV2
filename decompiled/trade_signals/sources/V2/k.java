package V2;

import V2.F;

/* JADX INFO: loaded from: classes.dex */
public final class k extends F.e.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f8768d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f8769e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f8770f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f8771g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f8772h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f8773i;

    public static final class b extends F.e.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8774a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8775b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8776c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f8777d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f8778e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f8779f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f8780g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f8781h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f8782i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public byte f8783j;

        @Override // V2.F.e.c.a
        public F.e.c a() {
            String str;
            String str2;
            String str3;
            if (this.f8783j == 63 && (str = this.f8775b) != null && (str2 = this.f8781h) != null && (str3 = this.f8782i) != null) {
                return new k(this.f8774a, str, this.f8776c, this.f8777d, this.f8778e, this.f8779f, this.f8780g, str2, str3);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f8783j & 1) == 0) {
                sb.append(" arch");
            }
            if (this.f8775b == null) {
                sb.append(" model");
            }
            if ((this.f8783j & 2) == 0) {
                sb.append(" cores");
            }
            if ((this.f8783j & 4) == 0) {
                sb.append(" ram");
            }
            if ((this.f8783j & 8) == 0) {
                sb.append(" diskSpace");
            }
            if ((this.f8783j & 16) == 0) {
                sb.append(" simulator");
            }
            if ((this.f8783j & 32) == 0) {
                sb.append(" state");
            }
            if (this.f8781h == null) {
                sb.append(" manufacturer");
            }
            if (this.f8782i == null) {
                sb.append(" modelClass");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // V2.F.e.c.a
        public F.e.c.a b(int i8) {
            this.f8774a = i8;
            this.f8783j = (byte) (this.f8783j | 1);
            return this;
        }

        @Override // V2.F.e.c.a
        public F.e.c.a c(int i8) {
            this.f8776c = i8;
            this.f8783j = (byte) (this.f8783j | 2);
            return this;
        }

        @Override // V2.F.e.c.a
        public F.e.c.a d(long j8) {
            this.f8778e = j8;
            this.f8783j = (byte) (this.f8783j | 8);
            return this;
        }

        @Override // V2.F.e.c.a
        public F.e.c.a e(String str) {
            if (str == null) {
                throw new NullPointerException("Null manufacturer");
            }
            this.f8781h = str;
            return this;
        }

        @Override // V2.F.e.c.a
        public F.e.c.a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null model");
            }
            this.f8775b = str;
            return this;
        }

        @Override // V2.F.e.c.a
        public F.e.c.a g(String str) {
            if (str == null) {
                throw new NullPointerException("Null modelClass");
            }
            this.f8782i = str;
            return this;
        }

        @Override // V2.F.e.c.a
        public F.e.c.a h(long j8) {
            this.f8777d = j8;
            this.f8783j = (byte) (this.f8783j | 4);
            return this;
        }

        @Override // V2.F.e.c.a
        public F.e.c.a i(boolean z7) {
            this.f8779f = z7;
            this.f8783j = (byte) (this.f8783j | 16);
            return this;
        }

        @Override // V2.F.e.c.a
        public F.e.c.a j(int i8) {
            this.f8780g = i8;
            this.f8783j = (byte) (this.f8783j | 32);
            return this;
        }
    }

    public k(int i8, String str, int i9, long j8, long j9, boolean z7, int i10, String str2, String str3) {
        this.f8765a = i8;
        this.f8766b = str;
        this.f8767c = i9;
        this.f8768d = j8;
        this.f8769e = j9;
        this.f8770f = z7;
        this.f8771g = i10;
        this.f8772h = str2;
        this.f8773i = str3;
    }

    @Override // V2.F.e.c
    public int b() {
        return this.f8765a;
    }

    @Override // V2.F.e.c
    public int c() {
        return this.f8767c;
    }

    @Override // V2.F.e.c
    public long d() {
        return this.f8769e;
    }

    @Override // V2.F.e.c
    public String e() {
        return this.f8772h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof F.e.c)) {
            return false;
        }
        F.e.c cVar = (F.e.c) obj;
        return this.f8765a == cVar.b() && this.f8766b.equals(cVar.f()) && this.f8767c == cVar.c() && this.f8768d == cVar.h() && this.f8769e == cVar.d() && this.f8770f == cVar.j() && this.f8771g == cVar.i() && this.f8772h.equals(cVar.e()) && this.f8773i.equals(cVar.g());
    }

    @Override // V2.F.e.c
    public String f() {
        return this.f8766b;
    }

    @Override // V2.F.e.c
    public String g() {
        return this.f8773i;
    }

    @Override // V2.F.e.c
    public long h() {
        return this.f8768d;
    }

    public int hashCode() {
        int iHashCode = (((((this.f8765a ^ 1000003) * 1000003) ^ this.f8766b.hashCode()) * 1000003) ^ this.f8767c) * 1000003;
        long j8 = this.f8768d;
        int i8 = (iHashCode ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003;
        long j9 = this.f8769e;
        return ((((((((i8 ^ ((int) (j9 ^ (j9 >>> 32)))) * 1000003) ^ (this.f8770f ? 1231 : 1237)) * 1000003) ^ this.f8771g) * 1000003) ^ this.f8772h.hashCode()) * 1000003) ^ this.f8773i.hashCode();
    }

    @Override // V2.F.e.c
    public int i() {
        return this.f8771g;
    }

    @Override // V2.F.e.c
    public boolean j() {
        return this.f8770f;
    }

    public String toString() {
        return "Device{arch=" + this.f8765a + ", model=" + this.f8766b + ", cores=" + this.f8767c + ", ram=" + this.f8768d + ", diskSpace=" + this.f8769e + ", simulator=" + this.f8770f + ", state=" + this.f8771g + ", manufacturer=" + this.f8772h + ", modelClass=" + this.f8773i + "}";
    }
}
