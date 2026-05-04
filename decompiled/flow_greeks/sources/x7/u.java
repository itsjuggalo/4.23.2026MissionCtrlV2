package x7;

import x7.f0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class u extends f0.e.d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Double f24634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f24635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f24636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f24637d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f24638e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f24639f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends f0.e.d.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Double f24640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f24641b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f24642c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f24643d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f24644e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f24645f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public byte f24646g;

        @Override // x7.f0.e.d.c.a
        public f0.e.d.c a() {
            if (this.f24646g == 31) {
                return new u(this.f24640a, this.f24641b, this.f24642c, this.f24643d, this.f24644e, this.f24645f);
            }
            StringBuilder sb2 = new StringBuilder();
            if ((this.f24646g & 1) == 0) {
                sb2.append(" batteryVelocity");
            }
            if ((this.f24646g & 2) == 0) {
                sb2.append(" proximityOn");
            }
            if ((this.f24646g & 4) == 0) {
                sb2.append(" orientation");
            }
            if ((this.f24646g & 8) == 0) {
                sb2.append(" ramUsed");
            }
            if ((this.f24646g & 16) == 0) {
                sb2.append(" diskUsed");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // x7.f0.e.d.c.a
        public f0.e.d.c.a b(Double d10) {
            this.f24640a = d10;
            return this;
        }

        @Override // x7.f0.e.d.c.a
        public f0.e.d.c.a c(int i10) {
            this.f24641b = i10;
            this.f24646g = (byte) (this.f24646g | 1);
            return this;
        }

        @Override // x7.f0.e.d.c.a
        public f0.e.d.c.a d(long j10) {
            this.f24645f = j10;
            this.f24646g = (byte) (this.f24646g | 16);
            return this;
        }

        @Override // x7.f0.e.d.c.a
        public f0.e.d.c.a e(int i10) {
            this.f24643d = i10;
            this.f24646g = (byte) (this.f24646g | 4);
            return this;
        }

        @Override // x7.f0.e.d.c.a
        public f0.e.d.c.a f(boolean z10) {
            this.f24642c = z10;
            this.f24646g = (byte) (this.f24646g | 2);
            return this;
        }

        @Override // x7.f0.e.d.c.a
        public f0.e.d.c.a g(long j10) {
            this.f24644e = j10;
            this.f24646g = (byte) (this.f24646g | 8);
            return this;
        }
    }

    @Override // x7.f0.e.d.c
    public Double b() {
        return this.f24634a;
    }

    @Override // x7.f0.e.d.c
    public int c() {
        return this.f24635b;
    }

    @Override // x7.f0.e.d.c
    public long d() {
        return this.f24639f;
    }

    @Override // x7.f0.e.d.c
    public int e() {
        return this.f24637d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0.e.d.c) {
            f0.e.d.c cVar = (f0.e.d.c) obj;
            Double d10 = this.f24634a;
            if (d10 != null ? d10.equals(cVar.b()) : cVar.b() == null) {
                if (this.f24635b == cVar.c() && this.f24636c == cVar.g() && this.f24637d == cVar.e() && this.f24638e == cVar.f() && this.f24639f == cVar.d()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // x7.f0.e.d.c
    public long f() {
        return this.f24638e;
    }

    @Override // x7.f0.e.d.c
    public boolean g() {
        return this.f24636c;
    }

    public int hashCode() {
        Double d10 = this.f24634a;
        int iHashCode = ((((((((d10 == null ? 0 : d10.hashCode()) ^ 1000003) * 1000003) ^ this.f24635b) * 1000003) ^ (this.f24636c ? 1231 : 1237)) * 1000003) ^ this.f24637d) * 1000003;
        long j10 = this.f24638e;
        long j11 = this.f24639f;
        return ((iHashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)));
    }

    public String toString() {
        return "Device{batteryLevel=" + this.f24634a + ", batteryVelocity=" + this.f24635b + ", proximityOn=" + this.f24636c + ", orientation=" + this.f24637d + ", ramUsed=" + this.f24638e + ", diskUsed=" + this.f24639f + "}";
    }

    public u(Double d10, int i10, boolean z10, int i11, long j10, long j11) {
        this.f24634a = d10;
        this.f24635b = i10;
        this.f24636c = z10;
        this.f24637d = i11;
        this.f24638e = j10;
        this.f24639f = j11;
    }
}
