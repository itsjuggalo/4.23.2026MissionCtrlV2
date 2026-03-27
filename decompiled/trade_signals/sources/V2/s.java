package V2;

import V2.F;

/* JADX INFO: loaded from: classes.dex */
public final class s extends F.e.d.a.b.AbstractC0132e.AbstractC0134b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f8856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f8859d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f8860e;

    public static final class b extends F.e.d.a.b.AbstractC0132e.AbstractC0134b.AbstractC0135a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f8861a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8862b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f8863c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f8864d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8865e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public byte f8866f;

        @Override // V2.F.e.d.a.b.AbstractC0132e.AbstractC0134b.AbstractC0135a
        public F.e.d.a.b.AbstractC0132e.AbstractC0134b a() {
            String str;
            if (this.f8866f == 7 && (str = this.f8862b) != null) {
                return new s(this.f8861a, str, this.f8863c, this.f8864d, this.f8865e);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f8866f & 1) == 0) {
                sb.append(" pc");
            }
            if (this.f8862b == null) {
                sb.append(" symbol");
            }
            if ((this.f8866f & 2) == 0) {
                sb.append(" offset");
            }
            if ((this.f8866f & 4) == 0) {
                sb.append(" importance");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // V2.F.e.d.a.b.AbstractC0132e.AbstractC0134b.AbstractC0135a
        public F.e.d.a.b.AbstractC0132e.AbstractC0134b.AbstractC0135a b(String str) {
            this.f8863c = str;
            return this;
        }

        @Override // V2.F.e.d.a.b.AbstractC0132e.AbstractC0134b.AbstractC0135a
        public F.e.d.a.b.AbstractC0132e.AbstractC0134b.AbstractC0135a c(int i8) {
            this.f8865e = i8;
            this.f8866f = (byte) (this.f8866f | 4);
            return this;
        }

        @Override // V2.F.e.d.a.b.AbstractC0132e.AbstractC0134b.AbstractC0135a
        public F.e.d.a.b.AbstractC0132e.AbstractC0134b.AbstractC0135a d(long j8) {
            this.f8864d = j8;
            this.f8866f = (byte) (this.f8866f | 2);
            return this;
        }

        @Override // V2.F.e.d.a.b.AbstractC0132e.AbstractC0134b.AbstractC0135a
        public F.e.d.a.b.AbstractC0132e.AbstractC0134b.AbstractC0135a e(long j8) {
            this.f8861a = j8;
            this.f8866f = (byte) (this.f8866f | 1);
            return this;
        }

        @Override // V2.F.e.d.a.b.AbstractC0132e.AbstractC0134b.AbstractC0135a
        public F.e.d.a.b.AbstractC0132e.AbstractC0134b.AbstractC0135a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null symbol");
            }
            this.f8862b = str;
            return this;
        }
    }

    public s(long j8, String str, String str2, long j9, int i8) {
        this.f8856a = j8;
        this.f8857b = str;
        this.f8858c = str2;
        this.f8859d = j9;
        this.f8860e = i8;
    }

    @Override // V2.F.e.d.a.b.AbstractC0132e.AbstractC0134b
    public String b() {
        return this.f8858c;
    }

    @Override // V2.F.e.d.a.b.AbstractC0132e.AbstractC0134b
    public int c() {
        return this.f8860e;
    }

    @Override // V2.F.e.d.a.b.AbstractC0132e.AbstractC0134b
    public long d() {
        return this.f8859d;
    }

    @Override // V2.F.e.d.a.b.AbstractC0132e.AbstractC0134b
    public long e() {
        return this.f8856a;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof F.e.d.a.b.AbstractC0132e.AbstractC0134b)) {
            return false;
        }
        F.e.d.a.b.AbstractC0132e.AbstractC0134b abstractC0134b = (F.e.d.a.b.AbstractC0132e.AbstractC0134b) obj;
        return this.f8856a == abstractC0134b.e() && this.f8857b.equals(abstractC0134b.f()) && ((str = this.f8858c) != null ? str.equals(abstractC0134b.b()) : abstractC0134b.b() == null) && this.f8859d == abstractC0134b.d() && this.f8860e == abstractC0134b.c();
    }

    @Override // V2.F.e.d.a.b.AbstractC0132e.AbstractC0134b
    public String f() {
        return this.f8857b;
    }

    public int hashCode() {
        long j8 = this.f8856a;
        int iHashCode = (((((int) (j8 ^ (j8 >>> 32))) ^ 1000003) * 1000003) ^ this.f8857b.hashCode()) * 1000003;
        String str = this.f8858c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j9 = this.f8859d;
        return ((iHashCode2 ^ ((int) ((j9 >>> 32) ^ j9))) * 1000003) ^ this.f8860e;
    }

    public String toString() {
        return "Frame{pc=" + this.f8856a + ", symbol=" + this.f8857b + ", file=" + this.f8858c + ", offset=" + this.f8859d + ", importance=" + this.f8860e + "}";
    }
}
