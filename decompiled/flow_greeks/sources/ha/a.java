package ha;

import ha.c;
import ha.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.a f11256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f11257d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f11258e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f11259f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f11260g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f11261h;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f11262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c.a f11263b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f11264c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f11265d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f11266e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f11267f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f11268g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public byte f11269h;

        @Override // ha.d.a
        public d a() {
            if (this.f11269h == 3 && this.f11263b != null) {
                return new a(this.f11262a, this.f11263b, this.f11264c, this.f11265d, this.f11266e, this.f11267f, this.f11268g);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.f11263b == null) {
                sb2.append(" registrationStatus");
            }
            if ((this.f11269h & 1) == 0) {
                sb2.append(" expiresInSecs");
            }
            if ((this.f11269h & 2) == 0) {
                sb2.append(" tokenCreationEpochInSecs");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // ha.d.a
        public d.a b(String str) {
            this.f11264c = str;
            return this;
        }

        @Override // ha.d.a
        public d.a c(long j10) {
            this.f11266e = j10;
            this.f11269h = (byte) (this.f11269h | 1);
            return this;
        }

        @Override // ha.d.a
        public d.a d(String str) {
            this.f11262a = str;
            return this;
        }

        @Override // ha.d.a
        public d.a e(String str) {
            this.f11268g = str;
            return this;
        }

        @Override // ha.d.a
        public d.a f(String str) {
            this.f11265d = str;
            return this;
        }

        @Override // ha.d.a
        public d.a g(c.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("Null registrationStatus");
            }
            this.f11263b = aVar;
            return this;
        }

        @Override // ha.d.a
        public d.a h(long j10) {
            this.f11267f = j10;
            this.f11269h = (byte) (this.f11269h | 2);
            return this;
        }

        public b() {
        }

        public b(d dVar) {
            this.f11262a = dVar.d();
            this.f11263b = dVar.g();
            this.f11264c = dVar.b();
            this.f11265d = dVar.f();
            this.f11266e = dVar.c();
            this.f11267f = dVar.h();
            this.f11268g = dVar.e();
            this.f11269h = (byte) 3;
        }
    }

    @Override // ha.d
    public String b() {
        return this.f11257d;
    }

    @Override // ha.d
    public long c() {
        return this.f11259f;
    }

    @Override // ha.d
    public String d() {
        return this.f11255b;
    }

    @Override // ha.d
    public String e() {
        return this.f11261h;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            String str4 = this.f11255b;
            if (str4 != null ? str4.equals(dVar.d()) : dVar.d() == null) {
                if (this.f11256c.equals(dVar.g()) && ((str = this.f11257d) != null ? str.equals(dVar.b()) : dVar.b() == null) && ((str2 = this.f11258e) != null ? str2.equals(dVar.f()) : dVar.f() == null) && this.f11259f == dVar.c() && this.f11260g == dVar.h() && ((str3 = this.f11261h) != null ? str3.equals(dVar.e()) : dVar.e() == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // ha.d
    public String f() {
        return this.f11258e;
    }

    @Override // ha.d
    public c.a g() {
        return this.f11256c;
    }

    @Override // ha.d
    public long h() {
        return this.f11260g;
    }

    public int hashCode() {
        String str = this.f11255b;
        int iHashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.f11256c.hashCode()) * 1000003;
        String str2 = this.f11257d;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f11258e;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        long j10 = this.f11259f;
        int i10 = (iHashCode3 ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f11260g;
        int i11 = (i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        String str4 = this.f11261h;
        return i11 ^ (str4 != null ? str4.hashCode() : 0);
    }

    @Override // ha.d
    public d.a n() {
        return new b(this);
    }

    public String toString() {
        return "PersistedInstallationEntry{firebaseInstallationId=" + this.f11255b + ", registrationStatus=" + this.f11256c + ", authToken=" + this.f11257d + ", refreshToken=" + this.f11258e + ", expiresInSecs=" + this.f11259f + ", tokenCreationEpochInSecs=" + this.f11260g + ", fisError=" + this.f11261h + "}";
    }

    public a(String str, c.a aVar, String str2, String str3, long j10, long j11, String str4) {
        this.f11255b = str;
        this.f11256c = aVar;
        this.f11257d = str2;
        this.f11258e = str3;
        this.f11259f = j10;
        this.f11260g = j11;
        this.f11261h = str4;
    }
}
