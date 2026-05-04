package x7;

import x7.f0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class o extends f0.e.d.a.b.AbstractC0434a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f24580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f24581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f24582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f24583d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends f0.e.d.a.b.AbstractC0434a.AbstractC0435a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f24584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f24585b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f24586c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f24587d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte f24588e;

        @Override // x7.f0.e.d.a.b.AbstractC0434a.AbstractC0435a
        public f0.e.d.a.b.AbstractC0434a a() {
            String str;
            if (this.f24588e == 3 && (str = this.f24586c) != null) {
                return new o(this.f24584a, this.f24585b, str, this.f24587d);
            }
            StringBuilder sb2 = new StringBuilder();
            if ((this.f24588e & 1) == 0) {
                sb2.append(" baseAddress");
            }
            if ((this.f24588e & 2) == 0) {
                sb2.append(" size");
            }
            if (this.f24586c == null) {
                sb2.append(" name");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // x7.f0.e.d.a.b.AbstractC0434a.AbstractC0435a
        public f0.e.d.a.b.AbstractC0434a.AbstractC0435a b(long j10) {
            this.f24584a = j10;
            this.f24588e = (byte) (this.f24588e | 1);
            return this;
        }

        @Override // x7.f0.e.d.a.b.AbstractC0434a.AbstractC0435a
        public f0.e.d.a.b.AbstractC0434a.AbstractC0435a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.f24586c = str;
            return this;
        }

        @Override // x7.f0.e.d.a.b.AbstractC0434a.AbstractC0435a
        public f0.e.d.a.b.AbstractC0434a.AbstractC0435a d(long j10) {
            this.f24585b = j10;
            this.f24588e = (byte) (this.f24588e | 2);
            return this;
        }

        @Override // x7.f0.e.d.a.b.AbstractC0434a.AbstractC0435a
        public f0.e.d.a.b.AbstractC0434a.AbstractC0435a e(String str) {
            this.f24587d = str;
            return this;
        }
    }

    @Override // x7.f0.e.d.a.b.AbstractC0434a
    public long b() {
        return this.f24580a;
    }

    @Override // x7.f0.e.d.a.b.AbstractC0434a
    public String c() {
        return this.f24582c;
    }

    @Override // x7.f0.e.d.a.b.AbstractC0434a
    public long d() {
        return this.f24581b;
    }

    @Override // x7.f0.e.d.a.b.AbstractC0434a
    public String e() {
        return this.f24583d;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0.e.d.a.b.AbstractC0434a) {
            f0.e.d.a.b.AbstractC0434a abstractC0434a = (f0.e.d.a.b.AbstractC0434a) obj;
            if (this.f24580a == abstractC0434a.b() && this.f24581b == abstractC0434a.d() && this.f24582c.equals(abstractC0434a.c()) && ((str = this.f24583d) != null ? str.equals(abstractC0434a.e()) : abstractC0434a.e() == null)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.f24580a;
        long j11 = this.f24581b;
        int iHashCode = (((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003) ^ this.f24582c.hashCode()) * 1000003;
        String str = this.f24583d;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "BinaryImage{baseAddress=" + this.f24580a + ", size=" + this.f24581b + ", name=" + this.f24582c + ", uuid=" + this.f24583d + "}";
    }

    public o(long j10, long j11, String str, String str2) {
        this.f24580a = j10;
        this.f24581b = j11;
        this.f24582c = str;
        this.f24583d = str2;
    }
}
