package V2;

import V2.F;

/* JADX INFO: loaded from: classes.dex */
public final class o extends F.e.d.a.b.AbstractC0126a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f8822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f8823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f8825d;

    public static final class b extends F.e.d.a.b.AbstractC0126a.AbstractC0127a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f8826a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f8827b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f8828c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f8829d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte f8830e;

        @Override // V2.F.e.d.a.b.AbstractC0126a.AbstractC0127a
        public F.e.d.a.b.AbstractC0126a a() {
            String str;
            if (this.f8830e == 3 && (str = this.f8828c) != null) {
                return new o(this.f8826a, this.f8827b, str, this.f8829d);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f8830e & 1) == 0) {
                sb.append(" baseAddress");
            }
            if ((this.f8830e & 2) == 0) {
                sb.append(" size");
            }
            if (this.f8828c == null) {
                sb.append(" name");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // V2.F.e.d.a.b.AbstractC0126a.AbstractC0127a
        public F.e.d.a.b.AbstractC0126a.AbstractC0127a b(long j8) {
            this.f8826a = j8;
            this.f8830e = (byte) (this.f8830e | 1);
            return this;
        }

        @Override // V2.F.e.d.a.b.AbstractC0126a.AbstractC0127a
        public F.e.d.a.b.AbstractC0126a.AbstractC0127a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.f8828c = str;
            return this;
        }

        @Override // V2.F.e.d.a.b.AbstractC0126a.AbstractC0127a
        public F.e.d.a.b.AbstractC0126a.AbstractC0127a d(long j8) {
            this.f8827b = j8;
            this.f8830e = (byte) (this.f8830e | 2);
            return this;
        }

        @Override // V2.F.e.d.a.b.AbstractC0126a.AbstractC0127a
        public F.e.d.a.b.AbstractC0126a.AbstractC0127a e(String str) {
            this.f8829d = str;
            return this;
        }
    }

    public o(long j8, long j9, String str, String str2) {
        this.f8822a = j8;
        this.f8823b = j9;
        this.f8824c = str;
        this.f8825d = str2;
    }

    @Override // V2.F.e.d.a.b.AbstractC0126a
    public long b() {
        return this.f8822a;
    }

    @Override // V2.F.e.d.a.b.AbstractC0126a
    public String c() {
        return this.f8824c;
    }

    @Override // V2.F.e.d.a.b.AbstractC0126a
    public long d() {
        return this.f8823b;
    }

    @Override // V2.F.e.d.a.b.AbstractC0126a
    public String e() {
        return this.f8825d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof F.e.d.a.b.AbstractC0126a)) {
            return false;
        }
        F.e.d.a.b.AbstractC0126a abstractC0126a = (F.e.d.a.b.AbstractC0126a) obj;
        if (this.f8822a == abstractC0126a.b() && this.f8823b == abstractC0126a.d() && this.f8824c.equals(abstractC0126a.c())) {
            String str = this.f8825d;
            String strE = abstractC0126a.e();
            if (str == null) {
                if (strE == null) {
                    return true;
                }
            } else if (str.equals(strE)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j8 = this.f8822a;
        long j9 = this.f8823b;
        int iHashCode = (((((((int) (j8 ^ (j8 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j9 >>> 32) ^ j9))) * 1000003) ^ this.f8824c.hashCode()) * 1000003;
        String str = this.f8825d;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "BinaryImage{baseAddress=" + this.f8822a + ", size=" + this.f8823b + ", name=" + this.f8824c + ", uuid=" + this.f8825d + "}";
    }
}
