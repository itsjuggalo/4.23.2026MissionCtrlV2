package V3;

import V3.f;

/* JADX INFO: loaded from: classes.dex */
public final class b extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f8926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f.b f8927c;

    /* JADX INFO: renamed from: V3.b$b, reason: collision with other inner class name */
    public static final class C0143b extends f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f8929b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public f.b f8930c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte f8931d;

        @Override // V3.f.a
        public f a() {
            if (this.f8931d == 1) {
                return new b(this.f8928a, this.f8929b, this.f8930c);
            }
            throw new IllegalStateException("Missing required properties: tokenExpirationTimestamp");
        }

        @Override // V3.f.a
        public f.a b(f.b bVar) {
            this.f8930c = bVar;
            return this;
        }

        @Override // V3.f.a
        public f.a c(String str) {
            this.f8928a = str;
            return this;
        }

        @Override // V3.f.a
        public f.a d(long j8) {
            this.f8929b = j8;
            this.f8931d = (byte) (this.f8931d | 1);
            return this;
        }
    }

    public b(String str, long j8, f.b bVar) {
        this.f8925a = str;
        this.f8926b = j8;
        this.f8927c = bVar;
    }

    @Override // V3.f
    public f.b b() {
        return this.f8927c;
    }

    @Override // V3.f
    public String c() {
        return this.f8925a;
    }

    @Override // V3.f
    public long d() {
        return this.f8926b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        String str = this.f8925a;
        if (str != null ? str.equals(fVar.c()) : fVar.c() == null) {
            if (this.f8926b == fVar.d()) {
                f.b bVar = this.f8927c;
                f.b bVarB = fVar.b();
                if (bVar == null) {
                    if (bVarB == null) {
                        return true;
                    }
                } else if (bVar.equals(bVarB)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f8925a;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j8 = this.f8926b;
        int i8 = (((iHashCode ^ 1000003) * 1000003) ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003;
        f.b bVar = this.f8927c;
        return i8 ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "TokenResult{token=" + this.f8925a + ", tokenExpirationTimestamp=" + this.f8926b + ", responseCode=" + this.f8927c + "}";
    }
}
