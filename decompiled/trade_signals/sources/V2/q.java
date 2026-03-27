package V2;

import V2.F;

/* JADX INFO: loaded from: classes.dex */
public final class q extends F.e.d.a.b.AbstractC0130d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f8844c;

    public static final class b extends F.e.d.a.b.AbstractC0130d.AbstractC0131a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8845a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8846b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f8847c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte f8848d;

        @Override // V2.F.e.d.a.b.AbstractC0130d.AbstractC0131a
        public F.e.d.a.b.AbstractC0130d a() {
            String str;
            String str2;
            if (this.f8848d == 1 && (str = this.f8845a) != null && (str2 = this.f8846b) != null) {
                return new q(str, str2, this.f8847c);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f8845a == null) {
                sb.append(" name");
            }
            if (this.f8846b == null) {
                sb.append(" code");
            }
            if ((1 & this.f8848d) == 0) {
                sb.append(" address");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // V2.F.e.d.a.b.AbstractC0130d.AbstractC0131a
        public F.e.d.a.b.AbstractC0130d.AbstractC0131a b(long j8) {
            this.f8847c = j8;
            this.f8848d = (byte) (this.f8848d | 1);
            return this;
        }

        @Override // V2.F.e.d.a.b.AbstractC0130d.AbstractC0131a
        public F.e.d.a.b.AbstractC0130d.AbstractC0131a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null code");
            }
            this.f8846b = str;
            return this;
        }

        @Override // V2.F.e.d.a.b.AbstractC0130d.AbstractC0131a
        public F.e.d.a.b.AbstractC0130d.AbstractC0131a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.f8845a = str;
            return this;
        }
    }

    public q(String str, String str2, long j8) {
        this.f8842a = str;
        this.f8843b = str2;
        this.f8844c = j8;
    }

    @Override // V2.F.e.d.a.b.AbstractC0130d
    public long b() {
        return this.f8844c;
    }

    @Override // V2.F.e.d.a.b.AbstractC0130d
    public String c() {
        return this.f8843b;
    }

    @Override // V2.F.e.d.a.b.AbstractC0130d
    public String d() {
        return this.f8842a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof F.e.d.a.b.AbstractC0130d)) {
            return false;
        }
        F.e.d.a.b.AbstractC0130d abstractC0130d = (F.e.d.a.b.AbstractC0130d) obj;
        return this.f8842a.equals(abstractC0130d.d()) && this.f8843b.equals(abstractC0130d.c()) && this.f8844c == abstractC0130d.b();
    }

    public int hashCode() {
        int iHashCode = (((this.f8842a.hashCode() ^ 1000003) * 1000003) ^ this.f8843b.hashCode()) * 1000003;
        long j8 = this.f8844c;
        return iHashCode ^ ((int) (j8 ^ (j8 >>> 32)));
    }

    public String toString() {
        return "Signal{name=" + this.f8842a + ", code=" + this.f8843b + ", address=" + this.f8844c + "}";
    }
}
