package ia;

import ia.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f12245d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d.b f12246e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f12248b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f12249c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public f f12250d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public d.b f12251e;

        @Override // ia.d.a
        public d a() {
            return new a(this.f12247a, this.f12248b, this.f12249c, this.f12250d, this.f12251e);
        }

        @Override // ia.d.a
        public d.a b(f fVar) {
            this.f12250d = fVar;
            return this;
        }

        @Override // ia.d.a
        public d.a c(String str) {
            this.f12248b = str;
            return this;
        }

        @Override // ia.d.a
        public d.a d(String str) {
            this.f12249c = str;
            return this;
        }

        @Override // ia.d.a
        public d.a e(d.b bVar) {
            this.f12251e = bVar;
            return this;
        }

        @Override // ia.d.a
        public d.a f(String str) {
            this.f12247a = str;
            return this;
        }
    }

    @Override // ia.d
    public f b() {
        return this.f12245d;
    }

    @Override // ia.d
    public String c() {
        return this.f12243b;
    }

    @Override // ia.d
    public String d() {
        return this.f12244c;
    }

    @Override // ia.d
    public d.b e() {
        return this.f12246e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            String str = this.f12242a;
            if (str != null ? str.equals(dVar.f()) : dVar.f() == null) {
                String str2 = this.f12243b;
                if (str2 != null ? str2.equals(dVar.c()) : dVar.c() == null) {
                    String str3 = this.f12244c;
                    if (str3 != null ? str3.equals(dVar.d()) : dVar.d() == null) {
                        f fVar = this.f12245d;
                        if (fVar != null ? fVar.equals(dVar.b()) : dVar.b() == null) {
                            d.b bVar = this.f12246e;
                            if (bVar != null ? bVar.equals(dVar.e()) : dVar.e() == null) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // ia.d
    public String f() {
        return this.f12242a;
    }

    public int hashCode() {
        String str = this.f12242a;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f12243b;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f12244c;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        f fVar = this.f12245d;
        int iHashCode4 = (iHashCode3 ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        d.b bVar = this.f12246e;
        return iHashCode4 ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "InstallationResponse{uri=" + this.f12242a + ", fid=" + this.f12243b + ", refreshToken=" + this.f12244c + ", authToken=" + this.f12245d + ", responseCode=" + this.f12246e + "}";
    }

    public a(String str, String str2, String str3, f fVar, d.b bVar) {
        this.f12242a = str;
        this.f12243b = str2;
        this.f12244c = str3;
        this.f12245d = fVar;
        this.f12246e = bVar;
    }
}
