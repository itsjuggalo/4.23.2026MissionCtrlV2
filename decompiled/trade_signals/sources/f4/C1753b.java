package f4;

import f4.AbstractC1755d;

/* JADX INFO: renamed from: f4.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1753b extends AbstractC1755d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f17538d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f17539e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f17540f;

    /* JADX INFO: renamed from: f4.b$b, reason: collision with other inner class name */
    public static final class C0303b extends AbstractC1755d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f17541a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f17542b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f17543c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f17544d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f17545e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public byte f17546f;

        @Override // f4.AbstractC1755d.a
        public AbstractC1755d a() {
            if (this.f17546f == 1 && this.f17541a != null && this.f17542b != null && this.f17543c != null && this.f17544d != null) {
                return new C1753b(this.f17541a, this.f17542b, this.f17543c, this.f17544d, this.f17545e);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f17541a == null) {
                sb.append(" rolloutId");
            }
            if (this.f17542b == null) {
                sb.append(" variantId");
            }
            if (this.f17543c == null) {
                sb.append(" parameterKey");
            }
            if (this.f17544d == null) {
                sb.append(" parameterValue");
            }
            if ((1 & this.f17546f) == 0) {
                sb.append(" templateVersion");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // f4.AbstractC1755d.a
        public AbstractC1755d.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null parameterKey");
            }
            this.f17543c = str;
            return this;
        }

        @Override // f4.AbstractC1755d.a
        public AbstractC1755d.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null parameterValue");
            }
            this.f17544d = str;
            return this;
        }

        @Override // f4.AbstractC1755d.a
        public AbstractC1755d.a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null rolloutId");
            }
            this.f17541a = str;
            return this;
        }

        @Override // f4.AbstractC1755d.a
        public AbstractC1755d.a e(long j8) {
            this.f17545e = j8;
            this.f17546f = (byte) (this.f17546f | 1);
            return this;
        }

        @Override // f4.AbstractC1755d.a
        public AbstractC1755d.a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null variantId");
            }
            this.f17542b = str;
            return this;
        }
    }

    public C1753b(String str, String str2, String str3, String str4, long j8) {
        this.f17536b = str;
        this.f17537c = str2;
        this.f17538d = str3;
        this.f17539e = str4;
        this.f17540f = j8;
    }

    @Override // f4.AbstractC1755d
    public String b() {
        return this.f17538d;
    }

    @Override // f4.AbstractC1755d
    public String c() {
        return this.f17539e;
    }

    @Override // f4.AbstractC1755d
    public String d() {
        return this.f17536b;
    }

    @Override // f4.AbstractC1755d
    public long e() {
        return this.f17540f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC1755d)) {
            return false;
        }
        AbstractC1755d abstractC1755d = (AbstractC1755d) obj;
        return this.f17536b.equals(abstractC1755d.d()) && this.f17537c.equals(abstractC1755d.f()) && this.f17538d.equals(abstractC1755d.b()) && this.f17539e.equals(abstractC1755d.c()) && this.f17540f == abstractC1755d.e();
    }

    @Override // f4.AbstractC1755d
    public String f() {
        return this.f17537c;
    }

    public int hashCode() {
        int iHashCode = (((((((this.f17536b.hashCode() ^ 1000003) * 1000003) ^ this.f17537c.hashCode()) * 1000003) ^ this.f17538d.hashCode()) * 1000003) ^ this.f17539e.hashCode()) * 1000003;
        long j8 = this.f17540f;
        return iHashCode ^ ((int) (j8 ^ (j8 >>> 32)));
    }

    public String toString() {
        return "RolloutAssignment{rolloutId=" + this.f17536b + ", variantId=" + this.f17537c + ", parameterKey=" + this.f17538d + ", parameterValue=" + this.f17539e + ", templateVersion=" + this.f17540f + "}";
    }
}
