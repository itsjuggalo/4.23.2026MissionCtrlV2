package V2;

import V2.F;

/* JADX INFO: loaded from: classes.dex */
public final class u extends F.e.d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Double f8876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f8878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8879d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f8880e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f8881f;

    public static final class b extends F.e.d.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Double f8882a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8883b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f8884c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8885d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f8886e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f8887f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public byte f8888g;

        @Override // V2.F.e.d.c.a
        public F.e.d.c a() {
            if (this.f8888g == 31) {
                return new u(this.f8882a, this.f8883b, this.f8884c, this.f8885d, this.f8886e, this.f8887f);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f8888g & 1) == 0) {
                sb.append(" batteryVelocity");
            }
            if ((this.f8888g & 2) == 0) {
                sb.append(" proximityOn");
            }
            if ((this.f8888g & 4) == 0) {
                sb.append(" orientation");
            }
            if ((this.f8888g & 8) == 0) {
                sb.append(" ramUsed");
            }
            if ((this.f8888g & 16) == 0) {
                sb.append(" diskUsed");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // V2.F.e.d.c.a
        public F.e.d.c.a b(Double d8) {
            this.f8882a = d8;
            return this;
        }

        @Override // V2.F.e.d.c.a
        public F.e.d.c.a c(int i8) {
            this.f8883b = i8;
            this.f8888g = (byte) (this.f8888g | 1);
            return this;
        }

        @Override // V2.F.e.d.c.a
        public F.e.d.c.a d(long j8) {
            this.f8887f = j8;
            this.f8888g = (byte) (this.f8888g | 16);
            return this;
        }

        @Override // V2.F.e.d.c.a
        public F.e.d.c.a e(int i8) {
            this.f8885d = i8;
            this.f8888g = (byte) (this.f8888g | 4);
            return this;
        }

        @Override // V2.F.e.d.c.a
        public F.e.d.c.a f(boolean z7) {
            this.f8884c = z7;
            this.f8888g = (byte) (this.f8888g | 2);
            return this;
        }

        @Override // V2.F.e.d.c.a
        public F.e.d.c.a g(long j8) {
            this.f8886e = j8;
            this.f8888g = (byte) (this.f8888g | 8);
            return this;
        }
    }

    public u(Double d8, int i8, boolean z7, int i9, long j8, long j9) {
        this.f8876a = d8;
        this.f8877b = i8;
        this.f8878c = z7;
        this.f8879d = i9;
        this.f8880e = j8;
        this.f8881f = j9;
    }

    @Override // V2.F.e.d.c
    public Double b() {
        return this.f8876a;
    }

    @Override // V2.F.e.d.c
    public int c() {
        return this.f8877b;
    }

    @Override // V2.F.e.d.c
    public long d() {
        return this.f8881f;
    }

    @Override // V2.F.e.d.c
    public int e() {
        return this.f8879d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof F.e.d.c)) {
            return false;
        }
        F.e.d.c cVar = (F.e.d.c) obj;
        Double d8 = this.f8876a;
        if (d8 != null ? d8.equals(cVar.b()) : cVar.b() == null) {
            if (this.f8877b == cVar.c() && this.f8878c == cVar.g() && this.f8879d == cVar.e() && this.f8880e == cVar.f() && this.f8881f == cVar.d()) {
                return true;
            }
        }
        return false;
    }

    @Override // V2.F.e.d.c
    public long f() {
        return this.f8880e;
    }

    @Override // V2.F.e.d.c
    public boolean g() {
        return this.f8878c;
    }

    public int hashCode() {
        Double d8 = this.f8876a;
        int iHashCode = ((((((((d8 == null ? 0 : d8.hashCode()) ^ 1000003) * 1000003) ^ this.f8877b) * 1000003) ^ (this.f8878c ? 1231 : 1237)) * 1000003) ^ this.f8879d) * 1000003;
        long j8 = this.f8880e;
        long j9 = this.f8881f;
        return ((iHashCode ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003) ^ ((int) (j9 ^ (j9 >>> 32)));
    }

    public String toString() {
        return "Device{batteryLevel=" + this.f8876a + ", batteryVelocity=" + this.f8877b + ", proximityOn=" + this.f8878c + ", orientation=" + this.f8879d + ", ramUsed=" + this.f8880e + ", diskUsed=" + this.f8881f + "}";
    }
}
