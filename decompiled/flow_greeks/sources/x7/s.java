package x7;

import x7.f0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class s extends f0.e.d.a.b.AbstractC0440e.AbstractC0442b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f24614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f24615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f24616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f24617d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f24618e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends f0.e.d.a.b.AbstractC0440e.AbstractC0442b.AbstractC0443a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f24619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f24620b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f24621c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f24622d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f24623e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public byte f24624f;

        @Override // x7.f0.e.d.a.b.AbstractC0440e.AbstractC0442b.AbstractC0443a
        public f0.e.d.a.b.AbstractC0440e.AbstractC0442b a() {
            String str;
            if (this.f24624f == 7 && (str = this.f24620b) != null) {
                return new s(this.f24619a, str, this.f24621c, this.f24622d, this.f24623e);
            }
            StringBuilder sb2 = new StringBuilder();
            if ((this.f24624f & 1) == 0) {
                sb2.append(" pc");
            }
            if (this.f24620b == null) {
                sb2.append(" symbol");
            }
            if ((this.f24624f & 2) == 0) {
                sb2.append(" offset");
            }
            if ((this.f24624f & 4) == 0) {
                sb2.append(" importance");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // x7.f0.e.d.a.b.AbstractC0440e.AbstractC0442b.AbstractC0443a
        public f0.e.d.a.b.AbstractC0440e.AbstractC0442b.AbstractC0443a b(String str) {
            this.f24621c = str;
            return this;
        }

        @Override // x7.f0.e.d.a.b.AbstractC0440e.AbstractC0442b.AbstractC0443a
        public f0.e.d.a.b.AbstractC0440e.AbstractC0442b.AbstractC0443a c(int i10) {
            this.f24623e = i10;
            this.f24624f = (byte) (this.f24624f | 4);
            return this;
        }

        @Override // x7.f0.e.d.a.b.AbstractC0440e.AbstractC0442b.AbstractC0443a
        public f0.e.d.a.b.AbstractC0440e.AbstractC0442b.AbstractC0443a d(long j10) {
            this.f24622d = j10;
            this.f24624f = (byte) (this.f24624f | 2);
            return this;
        }

        @Override // x7.f0.e.d.a.b.AbstractC0440e.AbstractC0442b.AbstractC0443a
        public f0.e.d.a.b.AbstractC0440e.AbstractC0442b.AbstractC0443a e(long j10) {
            this.f24619a = j10;
            this.f24624f = (byte) (this.f24624f | 1);
            return this;
        }

        @Override // x7.f0.e.d.a.b.AbstractC0440e.AbstractC0442b.AbstractC0443a
        public f0.e.d.a.b.AbstractC0440e.AbstractC0442b.AbstractC0443a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null symbol");
            }
            this.f24620b = str;
            return this;
        }
    }

    @Override // x7.f0.e.d.a.b.AbstractC0440e.AbstractC0442b
    public String b() {
        return this.f24616c;
    }

    @Override // x7.f0.e.d.a.b.AbstractC0440e.AbstractC0442b
    public int c() {
        return this.f24618e;
    }

    @Override // x7.f0.e.d.a.b.AbstractC0440e.AbstractC0442b
    public long d() {
        return this.f24617d;
    }

    @Override // x7.f0.e.d.a.b.AbstractC0440e.AbstractC0442b
    public long e() {
        return this.f24614a;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0.e.d.a.b.AbstractC0440e.AbstractC0442b) {
            f0.e.d.a.b.AbstractC0440e.AbstractC0442b abstractC0442b = (f0.e.d.a.b.AbstractC0440e.AbstractC0442b) obj;
            if (this.f24614a == abstractC0442b.e() && this.f24615b.equals(abstractC0442b.f()) && ((str = this.f24616c) != null ? str.equals(abstractC0442b.b()) : abstractC0442b.b() == null) && this.f24617d == abstractC0442b.d() && this.f24618e == abstractC0442b.c()) {
                return true;
            }
        }
        return false;
    }

    @Override // x7.f0.e.d.a.b.AbstractC0440e.AbstractC0442b
    public String f() {
        return this.f24615b;
    }

    public int hashCode() {
        long j10 = this.f24614a;
        int iHashCode = (((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f24615b.hashCode()) * 1000003;
        String str = this.f24616c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j11 = this.f24617d;
        return ((iHashCode2 ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003) ^ this.f24618e;
    }

    public String toString() {
        return "Frame{pc=" + this.f24614a + ", symbol=" + this.f24615b + ", file=" + this.f24616c + ", offset=" + this.f24617d + ", importance=" + this.f24618e + "}";
    }

    public s(long j10, String str, String str2, long j11, int i10) {
        this.f24614a = j10;
        this.f24615b = str;
        this.f24616c = str2;
        this.f24617d = j11;
        this.f24618e = i10;
    }
}
