package k3;

import k3.AbstractC2074F;

/* JADX INFO: renamed from: k3.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2094s extends AbstractC2074F.e.d.a.b.AbstractC0279e.AbstractC0281b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f17935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f17938d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f17939e;

    /* JADX INFO: renamed from: k3.s$b */
    public static final class b extends AbstractC2074F.e.d.a.b.AbstractC0279e.AbstractC0281b.AbstractC0282a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f17940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f17941b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f17942c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f17943d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f17944e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public byte f17945f;

        @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0279e.AbstractC0281b.AbstractC0282a
        public AbstractC2074F.e.d.a.b.AbstractC0279e.AbstractC0281b a() {
            String str;
            if (this.f17945f == 7 && (str = this.f17941b) != null) {
                return new C2094s(this.f17940a, str, this.f17942c, this.f17943d, this.f17944e);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f17945f & 1) == 0) {
                sb.append(" pc");
            }
            if (this.f17941b == null) {
                sb.append(" symbol");
            }
            if ((this.f17945f & 2) == 0) {
                sb.append(" offset");
            }
            if ((this.f17945f & 4) == 0) {
                sb.append(" importance");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0279e.AbstractC0281b.AbstractC0282a
        public AbstractC2074F.e.d.a.b.AbstractC0279e.AbstractC0281b.AbstractC0282a b(String str) {
            this.f17942c = str;
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0279e.AbstractC0281b.AbstractC0282a
        public AbstractC2074F.e.d.a.b.AbstractC0279e.AbstractC0281b.AbstractC0282a c(int i7) {
            this.f17944e = i7;
            this.f17945f = (byte) (this.f17945f | 4);
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0279e.AbstractC0281b.AbstractC0282a
        public AbstractC2074F.e.d.a.b.AbstractC0279e.AbstractC0281b.AbstractC0282a d(long j7) {
            this.f17943d = j7;
            this.f17945f = (byte) (this.f17945f | 2);
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0279e.AbstractC0281b.AbstractC0282a
        public AbstractC2074F.e.d.a.b.AbstractC0279e.AbstractC0281b.AbstractC0282a e(long j7) {
            this.f17940a = j7;
            this.f17945f = (byte) (this.f17945f | 1);
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0279e.AbstractC0281b.AbstractC0282a
        public AbstractC2074F.e.d.a.b.AbstractC0279e.AbstractC0281b.AbstractC0282a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null symbol");
            }
            this.f17941b = str;
            return this;
        }
    }

    @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0279e.AbstractC0281b
    public String b() {
        return this.f17937c;
    }

    @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0279e.AbstractC0281b
    public int c() {
        return this.f17939e;
    }

    @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0279e.AbstractC0281b
    public long d() {
        return this.f17938d;
    }

    @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0279e.AbstractC0281b
    public long e() {
        return this.f17935a;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2074F.e.d.a.b.AbstractC0279e.AbstractC0281b)) {
            return false;
        }
        AbstractC2074F.e.d.a.b.AbstractC0279e.AbstractC0281b abstractC0281b = (AbstractC2074F.e.d.a.b.AbstractC0279e.AbstractC0281b) obj;
        return this.f17935a == abstractC0281b.e() && this.f17936b.equals(abstractC0281b.f()) && ((str = this.f17937c) != null ? str.equals(abstractC0281b.b()) : abstractC0281b.b() == null) && this.f17938d == abstractC0281b.d() && this.f17939e == abstractC0281b.c();
    }

    @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0279e.AbstractC0281b
    public String f() {
        return this.f17936b;
    }

    public int hashCode() {
        long j7 = this.f17935a;
        int iHashCode = (((((int) (j7 ^ (j7 >>> 32))) ^ 1000003) * 1000003) ^ this.f17936b.hashCode()) * 1000003;
        String str = this.f17937c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j8 = this.f17938d;
        return ((iHashCode2 ^ ((int) ((j8 >>> 32) ^ j8))) * 1000003) ^ this.f17939e;
    }

    public String toString() {
        return "Frame{pc=" + this.f17935a + ", symbol=" + this.f17936b + ", file=" + this.f17937c + ", offset=" + this.f17938d + ", importance=" + this.f17939e + "}";
    }

    public C2094s(long j7, String str, String str2, long j8, int i7) {
        this.f17935a = j7;
        this.f17936b = str;
        this.f17937c = str2;
        this.f17938d = j8;
        this.f17939e = i7;
    }
}
