package k3;

import k3.AbstractC2074F;

/* JADX INFO: renamed from: k3.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2096u extends AbstractC2074F.e.d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Double f17955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f17957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f17958d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f17959e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f17960f;

    /* JADX INFO: renamed from: k3.u$b */
    public static final class b extends AbstractC2074F.e.d.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Double f17961a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f17962b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f17963c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f17964d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f17965e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f17966f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public byte f17967g;

        @Override // k3.AbstractC2074F.e.d.c.a
        public AbstractC2074F.e.d.c a() {
            if (this.f17967g == 31) {
                return new C2096u(this.f17961a, this.f17962b, this.f17963c, this.f17964d, this.f17965e, this.f17966f);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f17967g & 1) == 0) {
                sb.append(" batteryVelocity");
            }
            if ((this.f17967g & 2) == 0) {
                sb.append(" proximityOn");
            }
            if ((this.f17967g & 4) == 0) {
                sb.append(" orientation");
            }
            if ((this.f17967g & 8) == 0) {
                sb.append(" ramUsed");
            }
            if ((this.f17967g & 16) == 0) {
                sb.append(" diskUsed");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // k3.AbstractC2074F.e.d.c.a
        public AbstractC2074F.e.d.c.a b(Double d7) {
            this.f17961a = d7;
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.c.a
        public AbstractC2074F.e.d.c.a c(int i7) {
            this.f17962b = i7;
            this.f17967g = (byte) (this.f17967g | 1);
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.c.a
        public AbstractC2074F.e.d.c.a d(long j7) {
            this.f17966f = j7;
            this.f17967g = (byte) (this.f17967g | 16);
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.c.a
        public AbstractC2074F.e.d.c.a e(int i7) {
            this.f17964d = i7;
            this.f17967g = (byte) (this.f17967g | 4);
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.c.a
        public AbstractC2074F.e.d.c.a f(boolean z7) {
            this.f17963c = z7;
            this.f17967g = (byte) (this.f17967g | 2);
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.c.a
        public AbstractC2074F.e.d.c.a g(long j7) {
            this.f17965e = j7;
            this.f17967g = (byte) (this.f17967g | 8);
            return this;
        }
    }

    @Override // k3.AbstractC2074F.e.d.c
    public Double b() {
        return this.f17955a;
    }

    @Override // k3.AbstractC2074F.e.d.c
    public int c() {
        return this.f17956b;
    }

    @Override // k3.AbstractC2074F.e.d.c
    public long d() {
        return this.f17960f;
    }

    @Override // k3.AbstractC2074F.e.d.c
    public int e() {
        return this.f17958d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2074F.e.d.c)) {
            return false;
        }
        AbstractC2074F.e.d.c cVar = (AbstractC2074F.e.d.c) obj;
        Double d7 = this.f17955a;
        if (d7 != null ? d7.equals(cVar.b()) : cVar.b() == null) {
            if (this.f17956b == cVar.c() && this.f17957c == cVar.g() && this.f17958d == cVar.e() && this.f17959e == cVar.f() && this.f17960f == cVar.d()) {
                return true;
            }
        }
        return false;
    }

    @Override // k3.AbstractC2074F.e.d.c
    public long f() {
        return this.f17959e;
    }

    @Override // k3.AbstractC2074F.e.d.c
    public boolean g() {
        return this.f17957c;
    }

    public int hashCode() {
        Double d7 = this.f17955a;
        int iHashCode = ((((((((d7 == null ? 0 : d7.hashCode()) ^ 1000003) * 1000003) ^ this.f17956b) * 1000003) ^ (this.f17957c ? 1231 : 1237)) * 1000003) ^ this.f17958d) * 1000003;
        long j7 = this.f17959e;
        long j8 = this.f17960f;
        return ((iHashCode ^ ((int) (j7 ^ (j7 >>> 32)))) * 1000003) ^ ((int) (j8 ^ (j8 >>> 32)));
    }

    public String toString() {
        return "Device{batteryLevel=" + this.f17955a + ", batteryVelocity=" + this.f17956b + ", proximityOn=" + this.f17957c + ", orientation=" + this.f17958d + ", ramUsed=" + this.f17959e + ", diskUsed=" + this.f17960f + "}";
    }

    public C2096u(Double d7, int i7, boolean z7, int i8, long j7, long j8) {
        this.f17955a = d7;
        this.f17956b = i7;
        this.f17957c = z7;
        this.f17958d = i8;
        this.f17959e = j7;
        this.f17960f = j8;
    }
}
