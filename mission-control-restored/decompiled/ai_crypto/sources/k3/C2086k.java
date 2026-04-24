package k3;

import k3.AbstractC2074F;

/* JADX INFO: renamed from: k3.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2086k extends AbstractC2074F.e.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f17847d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f17848e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f17849f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f17850g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f17851h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f17852i;

    /* JADX INFO: renamed from: k3.k$b */
    public static final class b extends AbstractC2074F.e.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f17853a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f17854b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f17855c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f17856d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f17857e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f17858f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f17859g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f17860h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f17861i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public byte f17862j;

        @Override // k3.AbstractC2074F.e.c.a
        public AbstractC2074F.e.c a() {
            String str;
            String str2;
            String str3;
            if (this.f17862j == 63 && (str = this.f17854b) != null && (str2 = this.f17860h) != null && (str3 = this.f17861i) != null) {
                return new C2086k(this.f17853a, str, this.f17855c, this.f17856d, this.f17857e, this.f17858f, this.f17859g, str2, str3);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f17862j & 1) == 0) {
                sb.append(" arch");
            }
            if (this.f17854b == null) {
                sb.append(" model");
            }
            if ((this.f17862j & 2) == 0) {
                sb.append(" cores");
            }
            if ((this.f17862j & 4) == 0) {
                sb.append(" ram");
            }
            if ((this.f17862j & 8) == 0) {
                sb.append(" diskSpace");
            }
            if ((this.f17862j & 16) == 0) {
                sb.append(" simulator");
            }
            if ((this.f17862j & 32) == 0) {
                sb.append(" state");
            }
            if (this.f17860h == null) {
                sb.append(" manufacturer");
            }
            if (this.f17861i == null) {
                sb.append(" modelClass");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // k3.AbstractC2074F.e.c.a
        public AbstractC2074F.e.c.a b(int i7) {
            this.f17853a = i7;
            this.f17862j = (byte) (this.f17862j | 1);
            return this;
        }

        @Override // k3.AbstractC2074F.e.c.a
        public AbstractC2074F.e.c.a c(int i7) {
            this.f17855c = i7;
            this.f17862j = (byte) (this.f17862j | 2);
            return this;
        }

        @Override // k3.AbstractC2074F.e.c.a
        public AbstractC2074F.e.c.a d(long j7) {
            this.f17857e = j7;
            this.f17862j = (byte) (this.f17862j | 8);
            return this;
        }

        @Override // k3.AbstractC2074F.e.c.a
        public AbstractC2074F.e.c.a e(String str) {
            if (str == null) {
                throw new NullPointerException("Null manufacturer");
            }
            this.f17860h = str;
            return this;
        }

        @Override // k3.AbstractC2074F.e.c.a
        public AbstractC2074F.e.c.a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null model");
            }
            this.f17854b = str;
            return this;
        }

        @Override // k3.AbstractC2074F.e.c.a
        public AbstractC2074F.e.c.a g(String str) {
            if (str == null) {
                throw new NullPointerException("Null modelClass");
            }
            this.f17861i = str;
            return this;
        }

        @Override // k3.AbstractC2074F.e.c.a
        public AbstractC2074F.e.c.a h(long j7) {
            this.f17856d = j7;
            this.f17862j = (byte) (this.f17862j | 4);
            return this;
        }

        @Override // k3.AbstractC2074F.e.c.a
        public AbstractC2074F.e.c.a i(boolean z7) {
            this.f17858f = z7;
            this.f17862j = (byte) (this.f17862j | 16);
            return this;
        }

        @Override // k3.AbstractC2074F.e.c.a
        public AbstractC2074F.e.c.a j(int i7) {
            this.f17859g = i7;
            this.f17862j = (byte) (this.f17862j | 32);
            return this;
        }
    }

    @Override // k3.AbstractC2074F.e.c
    public int b() {
        return this.f17844a;
    }

    @Override // k3.AbstractC2074F.e.c
    public int c() {
        return this.f17846c;
    }

    @Override // k3.AbstractC2074F.e.c
    public long d() {
        return this.f17848e;
    }

    @Override // k3.AbstractC2074F.e.c
    public String e() {
        return this.f17851h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2074F.e.c)) {
            return false;
        }
        AbstractC2074F.e.c cVar = (AbstractC2074F.e.c) obj;
        return this.f17844a == cVar.b() && this.f17845b.equals(cVar.f()) && this.f17846c == cVar.c() && this.f17847d == cVar.h() && this.f17848e == cVar.d() && this.f17849f == cVar.j() && this.f17850g == cVar.i() && this.f17851h.equals(cVar.e()) && this.f17852i.equals(cVar.g());
    }

    @Override // k3.AbstractC2074F.e.c
    public String f() {
        return this.f17845b;
    }

    @Override // k3.AbstractC2074F.e.c
    public String g() {
        return this.f17852i;
    }

    @Override // k3.AbstractC2074F.e.c
    public long h() {
        return this.f17847d;
    }

    public int hashCode() {
        int iHashCode = (((((this.f17844a ^ 1000003) * 1000003) ^ this.f17845b.hashCode()) * 1000003) ^ this.f17846c) * 1000003;
        long j7 = this.f17847d;
        int i7 = (iHashCode ^ ((int) (j7 ^ (j7 >>> 32)))) * 1000003;
        long j8 = this.f17848e;
        return ((((((((i7 ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003) ^ (this.f17849f ? 1231 : 1237)) * 1000003) ^ this.f17850g) * 1000003) ^ this.f17851h.hashCode()) * 1000003) ^ this.f17852i.hashCode();
    }

    @Override // k3.AbstractC2074F.e.c
    public int i() {
        return this.f17850g;
    }

    @Override // k3.AbstractC2074F.e.c
    public boolean j() {
        return this.f17849f;
    }

    public String toString() {
        return "Device{arch=" + this.f17844a + ", model=" + this.f17845b + ", cores=" + this.f17846c + ", ram=" + this.f17847d + ", diskSpace=" + this.f17848e + ", simulator=" + this.f17849f + ", state=" + this.f17850g + ", manufacturer=" + this.f17851h + ", modelClass=" + this.f17852i + "}";
    }

    public C2086k(int i7, String str, int i8, long j7, long j8, boolean z7, int i9, String str2, String str3) {
        this.f17844a = i7;
        this.f17845b = str;
        this.f17846c = i8;
        this.f17847d = j7;
        this.f17848e = j8;
        this.f17849f = z7;
        this.f17850g = i9;
        this.f17851h = str2;
        this.f17852i = str3;
    }
}
