package k3;

import k3.AbstractC2074F;

/* JADX INFO: renamed from: k3.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2090o extends AbstractC2074F.e.d.a.b.AbstractC0273a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f17901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f17902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f17904d;

    /* JADX INFO: renamed from: k3.o$b */
    public static final class b extends AbstractC2074F.e.d.a.b.AbstractC0273a.AbstractC0274a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f17905a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f17906b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f17907c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f17908d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte f17909e;

        @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0273a.AbstractC0274a
        public AbstractC2074F.e.d.a.b.AbstractC0273a a() {
            String str;
            if (this.f17909e == 3 && (str = this.f17907c) != null) {
                return new C2090o(this.f17905a, this.f17906b, str, this.f17908d);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f17909e & 1) == 0) {
                sb.append(" baseAddress");
            }
            if ((this.f17909e & 2) == 0) {
                sb.append(" size");
            }
            if (this.f17907c == null) {
                sb.append(" name");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0273a.AbstractC0274a
        public AbstractC2074F.e.d.a.b.AbstractC0273a.AbstractC0274a b(long j7) {
            this.f17905a = j7;
            this.f17909e = (byte) (this.f17909e | 1);
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0273a.AbstractC0274a
        public AbstractC2074F.e.d.a.b.AbstractC0273a.AbstractC0274a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.f17907c = str;
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0273a.AbstractC0274a
        public AbstractC2074F.e.d.a.b.AbstractC0273a.AbstractC0274a d(long j7) {
            this.f17906b = j7;
            this.f17909e = (byte) (this.f17909e | 2);
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0273a.AbstractC0274a
        public AbstractC2074F.e.d.a.b.AbstractC0273a.AbstractC0274a e(String str) {
            this.f17908d = str;
            return this;
        }
    }

    @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0273a
    public long b() {
        return this.f17901a;
    }

    @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0273a
    public String c() {
        return this.f17903c;
    }

    @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0273a
    public long d() {
        return this.f17902b;
    }

    @Override // k3.AbstractC2074F.e.d.a.b.AbstractC0273a
    public String e() {
        return this.f17904d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2074F.e.d.a.b.AbstractC0273a)) {
            return false;
        }
        AbstractC2074F.e.d.a.b.AbstractC0273a abstractC0273a = (AbstractC2074F.e.d.a.b.AbstractC0273a) obj;
        if (this.f17901a == abstractC0273a.b() && this.f17902b == abstractC0273a.d() && this.f17903c.equals(abstractC0273a.c())) {
            String str = this.f17904d;
            if (str == null) {
                if (abstractC0273a.e() == null) {
                    return true;
                }
            } else if (str.equals(abstractC0273a.e())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j7 = this.f17901a;
        long j8 = this.f17902b;
        int iHashCode = (((((((int) (j7 ^ (j7 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j8 >>> 32) ^ j8))) * 1000003) ^ this.f17903c.hashCode()) * 1000003;
        String str = this.f17904d;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "BinaryImage{baseAddress=" + this.f17901a + ", size=" + this.f17902b + ", name=" + this.f17903c + ", uuid=" + this.f17904d + "}";
    }

    public C2090o(long j7, long j8, String str, String str2) {
        this.f17901a = j7;
        this.f17902b = j8;
        this.f17903c = str;
        this.f17904d = str2;
    }
}
