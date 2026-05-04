package x7;

import x7.f0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends f0.e.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f24542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f24543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f0.e.d.a f24544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f0.e.d.c f24545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f0.e.d.AbstractC0445d f24546e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f0.e.d.f f24547f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends f0.e.d.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f24548a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f24549b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public f0.e.d.a f24550c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public f0.e.d.c f24551d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public f0.e.d.AbstractC0445d f24552e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public f0.e.d.f f24553f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public byte f24554g;

        @Override // x7.f0.e.d.b
        public f0.e.d a() {
            String str;
            f0.e.d.a aVar;
            f0.e.d.c cVar;
            if (this.f24554g == 1 && (str = this.f24549b) != null && (aVar = this.f24550c) != null && (cVar = this.f24551d) != null) {
                return new l(this.f24548a, str, aVar, cVar, this.f24552e, this.f24553f);
            }
            StringBuilder sb2 = new StringBuilder();
            if ((1 & this.f24554g) == 0) {
                sb2.append(" timestamp");
            }
            if (this.f24549b == null) {
                sb2.append(" type");
            }
            if (this.f24550c == null) {
                sb2.append(" app");
            }
            if (this.f24551d == null) {
                sb2.append(" device");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // x7.f0.e.d.b
        public f0.e.d.b b(f0.e.d.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("Null app");
            }
            this.f24550c = aVar;
            return this;
        }

        @Override // x7.f0.e.d.b
        public f0.e.d.b c(f0.e.d.c cVar) {
            if (cVar == null) {
                throw new NullPointerException("Null device");
            }
            this.f24551d = cVar;
            return this;
        }

        @Override // x7.f0.e.d.b
        public f0.e.d.b d(f0.e.d.AbstractC0445d abstractC0445d) {
            this.f24552e = abstractC0445d;
            return this;
        }

        @Override // x7.f0.e.d.b
        public f0.e.d.b e(f0.e.d.f fVar) {
            this.f24553f = fVar;
            return this;
        }

        @Override // x7.f0.e.d.b
        public f0.e.d.b f(long j10) {
            this.f24548a = j10;
            this.f24554g = (byte) (this.f24554g | 1);
            return this;
        }

        @Override // x7.f0.e.d.b
        public f0.e.d.b g(String str) {
            if (str == null) {
                throw new NullPointerException("Null type");
            }
            this.f24549b = str;
            return this;
        }

        public b() {
        }

        public b(f0.e.d dVar) {
            this.f24548a = dVar.f();
            this.f24549b = dVar.g();
            this.f24550c = dVar.b();
            this.f24551d = dVar.c();
            this.f24552e = dVar.d();
            this.f24553f = dVar.e();
            this.f24554g = (byte) 1;
        }
    }

    @Override // x7.f0.e.d
    public f0.e.d.a b() {
        return this.f24544c;
    }

    @Override // x7.f0.e.d
    public f0.e.d.c c() {
        return this.f24545d;
    }

    @Override // x7.f0.e.d
    public f0.e.d.AbstractC0445d d() {
        return this.f24546e;
    }

    @Override // x7.f0.e.d
    public f0.e.d.f e() {
        return this.f24547f;
    }

    public boolean equals(Object obj) {
        f0.e.d.AbstractC0445d abstractC0445d;
        f0.e.d.f fVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0.e.d) {
            f0.e.d dVar = (f0.e.d) obj;
            if (this.f24542a == dVar.f() && this.f24543b.equals(dVar.g()) && this.f24544c.equals(dVar.b()) && this.f24545d.equals(dVar.c()) && ((abstractC0445d = this.f24546e) != null ? abstractC0445d.equals(dVar.d()) : dVar.d() == null) && ((fVar = this.f24547f) != null ? fVar.equals(dVar.e()) : dVar.e() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // x7.f0.e.d
    public long f() {
        return this.f24542a;
    }

    @Override // x7.f0.e.d
    public String g() {
        return this.f24543b;
    }

    @Override // x7.f0.e.d
    public f0.e.d.b h() {
        return new b(this);
    }

    public int hashCode() {
        long j10 = this.f24542a;
        int iHashCode = (((((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f24543b.hashCode()) * 1000003) ^ this.f24544c.hashCode()) * 1000003) ^ this.f24545d.hashCode()) * 1000003;
        f0.e.d.AbstractC0445d abstractC0445d = this.f24546e;
        int iHashCode2 = (iHashCode ^ (abstractC0445d == null ? 0 : abstractC0445d.hashCode())) * 1000003;
        f0.e.d.f fVar = this.f24547f;
        return iHashCode2 ^ (fVar != null ? fVar.hashCode() : 0);
    }

    public String toString() {
        return "Event{timestamp=" + this.f24542a + ", type=" + this.f24543b + ", app=" + this.f24544c + ", device=" + this.f24545d + ", log=" + this.f24546e + ", rollouts=" + this.f24547f + "}";
    }

    public l(long j10, String str, f0.e.d.a aVar, f0.e.d.c cVar, f0.e.d.AbstractC0445d abstractC0445d, f0.e.d.f fVar) {
        this.f24542a = j10;
        this.f24543b = str;
        this.f24544c = aVar;
        this.f24545d = cVar;
        this.f24546e = abstractC0445d;
        this.f24547f = fVar;
    }
}
