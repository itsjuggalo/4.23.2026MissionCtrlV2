package V3;

import V3.d;

/* JADX INFO: loaded from: classes.dex */
public final class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f8918d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d.b f8919e;

    public static final class b extends d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8920a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8921b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f8922c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public f f8923d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public d.b f8924e;

        @Override // V3.d.a
        public d a() {
            return new a(this.f8920a, this.f8921b, this.f8922c, this.f8923d, this.f8924e);
        }

        @Override // V3.d.a
        public d.a b(f fVar) {
            this.f8923d = fVar;
            return this;
        }

        @Override // V3.d.a
        public d.a c(String str) {
            this.f8921b = str;
            return this;
        }

        @Override // V3.d.a
        public d.a d(String str) {
            this.f8922c = str;
            return this;
        }

        @Override // V3.d.a
        public d.a e(d.b bVar) {
            this.f8924e = bVar;
            return this;
        }

        @Override // V3.d.a
        public d.a f(String str) {
            this.f8920a = str;
            return this;
        }
    }

    public a(String str, String str2, String str3, f fVar, d.b bVar) {
        this.f8915a = str;
        this.f8916b = str2;
        this.f8917c = str3;
        this.f8918d = fVar;
        this.f8919e = bVar;
    }

    @Override // V3.d
    public f b() {
        return this.f8918d;
    }

    @Override // V3.d
    public String c() {
        return this.f8916b;
    }

    @Override // V3.d
    public String d() {
        return this.f8917c;
    }

    @Override // V3.d
    public d.b e() {
        return this.f8919e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.f8915a;
        if (str != null ? str.equals(dVar.f()) : dVar.f() == null) {
            String str2 = this.f8916b;
            if (str2 != null ? str2.equals(dVar.c()) : dVar.c() == null) {
                String str3 = this.f8917c;
                if (str3 != null ? str3.equals(dVar.d()) : dVar.d() == null) {
                    f fVar = this.f8918d;
                    if (fVar != null ? fVar.equals(dVar.b()) : dVar.b() == null) {
                        d.b bVar = this.f8919e;
                        d.b bVarE = dVar.e();
                        if (bVar == null) {
                            if (bVarE == null) {
                                return true;
                            }
                        } else if (bVar.equals(bVarE)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // V3.d
    public String f() {
        return this.f8915a;
    }

    public int hashCode() {
        String str = this.f8915a;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f8916b;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f8917c;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        f fVar = this.f8918d;
        int iHashCode4 = (iHashCode3 ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        d.b bVar = this.f8919e;
        return iHashCode4 ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "InstallationResponse{uri=" + this.f8915a + ", fid=" + this.f8916b + ", refreshToken=" + this.f8917c + ", authToken=" + this.f8918d + ", responseCode=" + this.f8919e + "}";
    }
}
