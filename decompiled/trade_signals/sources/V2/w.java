package V2;

import V2.F;

/* JADX INFO: loaded from: classes.dex */
public final class w extends F.e.d.AbstractC0138e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F.e.d.AbstractC0138e.b f8891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f8894d;

    public static final class b extends F.e.d.AbstractC0138e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public F.e.d.AbstractC0138e.b f8895a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8896b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f8897c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f8898d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte f8899e;

        @Override // V2.F.e.d.AbstractC0138e.a
        public F.e.d.AbstractC0138e a() {
            F.e.d.AbstractC0138e.b bVar;
            String str;
            String str2;
            if (this.f8899e == 1 && (bVar = this.f8895a) != null && (str = this.f8896b) != null && (str2 = this.f8897c) != null) {
                return new w(bVar, str, str2, this.f8898d);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f8895a == null) {
                sb.append(" rolloutVariant");
            }
            if (this.f8896b == null) {
                sb.append(" parameterKey");
            }
            if (this.f8897c == null) {
                sb.append(" parameterValue");
            }
            if ((1 & this.f8899e) == 0) {
                sb.append(" templateVersion");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // V2.F.e.d.AbstractC0138e.a
        public F.e.d.AbstractC0138e.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null parameterKey");
            }
            this.f8896b = str;
            return this;
        }

        @Override // V2.F.e.d.AbstractC0138e.a
        public F.e.d.AbstractC0138e.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null parameterValue");
            }
            this.f8897c = str;
            return this;
        }

        @Override // V2.F.e.d.AbstractC0138e.a
        public F.e.d.AbstractC0138e.a d(F.e.d.AbstractC0138e.b bVar) {
            if (bVar == null) {
                throw new NullPointerException("Null rolloutVariant");
            }
            this.f8895a = bVar;
            return this;
        }

        @Override // V2.F.e.d.AbstractC0138e.a
        public F.e.d.AbstractC0138e.a e(long j8) {
            this.f8898d = j8;
            this.f8899e = (byte) (this.f8899e | 1);
            return this;
        }
    }

    public w(F.e.d.AbstractC0138e.b bVar, String str, String str2, long j8) {
        this.f8891a = bVar;
        this.f8892b = str;
        this.f8893c = str2;
        this.f8894d = j8;
    }

    @Override // V2.F.e.d.AbstractC0138e
    public String b() {
        return this.f8892b;
    }

    @Override // V2.F.e.d.AbstractC0138e
    public String c() {
        return this.f8893c;
    }

    @Override // V2.F.e.d.AbstractC0138e
    public F.e.d.AbstractC0138e.b d() {
        return this.f8891a;
    }

    @Override // V2.F.e.d.AbstractC0138e
    public long e() {
        return this.f8894d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof F.e.d.AbstractC0138e)) {
            return false;
        }
        F.e.d.AbstractC0138e abstractC0138e = (F.e.d.AbstractC0138e) obj;
        return this.f8891a.equals(abstractC0138e.d()) && this.f8892b.equals(abstractC0138e.b()) && this.f8893c.equals(abstractC0138e.c()) && this.f8894d == abstractC0138e.e();
    }

    public int hashCode() {
        int iHashCode = (((((this.f8891a.hashCode() ^ 1000003) * 1000003) ^ this.f8892b.hashCode()) * 1000003) ^ this.f8893c.hashCode()) * 1000003;
        long j8 = this.f8894d;
        return iHashCode ^ ((int) (j8 ^ (j8 >>> 32)));
    }

    public String toString() {
        return "RolloutAssignment{rolloutVariant=" + this.f8891a + ", parameterKey=" + this.f8892b + ", parameterValue=" + this.f8893c + ", templateVersion=" + this.f8894d + "}";
    }
}
