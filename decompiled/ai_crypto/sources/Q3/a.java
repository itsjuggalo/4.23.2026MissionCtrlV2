package Q3;

import Q3.d;

/* JADX INFO: loaded from: classes.dex */
public final class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f4527d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d.b f4528e;

    public static final class b extends d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f4529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f4530b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f4531c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public f f4532d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public d.b f4533e;

        @Override // Q3.d.a
        public d a() {
            return new a(this.f4529a, this.f4530b, this.f4531c, this.f4532d, this.f4533e);
        }

        @Override // Q3.d.a
        public d.a b(f fVar) {
            this.f4532d = fVar;
            return this;
        }

        @Override // Q3.d.a
        public d.a c(String str) {
            this.f4530b = str;
            return this;
        }

        @Override // Q3.d.a
        public d.a d(String str) {
            this.f4531c = str;
            return this;
        }

        @Override // Q3.d.a
        public d.a e(d.b bVar) {
            this.f4533e = bVar;
            return this;
        }

        @Override // Q3.d.a
        public d.a f(String str) {
            this.f4529a = str;
            return this;
        }
    }

    @Override // Q3.d
    public f b() {
        return this.f4527d;
    }

    @Override // Q3.d
    public String c() {
        return this.f4525b;
    }

    @Override // Q3.d
    public String d() {
        return this.f4526c;
    }

    @Override // Q3.d
    public d.b e() {
        return this.f4528e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.f4524a;
        if (str != null ? str.equals(dVar.f()) : dVar.f() == null) {
            String str2 = this.f4525b;
            if (str2 != null ? str2.equals(dVar.c()) : dVar.c() == null) {
                String str3 = this.f4526c;
                if (str3 != null ? str3.equals(dVar.d()) : dVar.d() == null) {
                    f fVar = this.f4527d;
                    if (fVar != null ? fVar.equals(dVar.b()) : dVar.b() == null) {
                        d.b bVar = this.f4528e;
                        if (bVar == null) {
                            if (dVar.e() == null) {
                                return true;
                            }
                        } else if (bVar.equals(dVar.e())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // Q3.d
    public String f() {
        return this.f4524a;
    }

    public int hashCode() {
        String str = this.f4524a;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f4525b;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f4526c;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        f fVar = this.f4527d;
        int iHashCode4 = (iHashCode3 ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        d.b bVar = this.f4528e;
        return iHashCode4 ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "InstallationResponse{uri=" + this.f4524a + ", fid=" + this.f4525b + ", refreshToken=" + this.f4526c + ", authToken=" + this.f4527d + ", responseCode=" + this.f4528e + "}";
    }

    public a(String str, String str2, String str3, f fVar, d.b bVar) {
        this.f4524a = str;
        this.f4525b = str2;
        this.f4526c = str3;
        this.f4527d = fVar;
        this.f4528e = bVar;
    }
}
