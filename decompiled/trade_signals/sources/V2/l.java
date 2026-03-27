package V2;

import V2.F;

/* JADX INFO: loaded from: classes.dex */
public final class l extends F.e.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f8784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final F.e.d.a f8786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final F.e.d.c f8787d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final F.e.d.AbstractC0137d f8788e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final F.e.d.f f8789f;

    public static final class b extends F.e.d.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f8790a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8791b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public F.e.d.a f8792c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public F.e.d.c f8793d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public F.e.d.AbstractC0137d f8794e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public F.e.d.f f8795f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public byte f8796g;

        public b() {
        }

        @Override // V2.F.e.d.b
        public F.e.d a() {
            String str;
            F.e.d.a aVar;
            F.e.d.c cVar;
            if (this.f8796g == 1 && (str = this.f8791b) != null && (aVar = this.f8792c) != null && (cVar = this.f8793d) != null) {
                return new l(this.f8790a, str, aVar, cVar, this.f8794e, this.f8795f);
            }
            StringBuilder sb = new StringBuilder();
            if ((1 & this.f8796g) == 0) {
                sb.append(" timestamp");
            }
            if (this.f8791b == null) {
                sb.append(" type");
            }
            if (this.f8792c == null) {
                sb.append(" app");
            }
            if (this.f8793d == null) {
                sb.append(" device");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // V2.F.e.d.b
        public F.e.d.b b(F.e.d.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("Null app");
            }
            this.f8792c = aVar;
            return this;
        }

        @Override // V2.F.e.d.b
        public F.e.d.b c(F.e.d.c cVar) {
            if (cVar == null) {
                throw new NullPointerException("Null device");
            }
            this.f8793d = cVar;
            return this;
        }

        @Override // V2.F.e.d.b
        public F.e.d.b d(F.e.d.AbstractC0137d abstractC0137d) {
            this.f8794e = abstractC0137d;
            return this;
        }

        @Override // V2.F.e.d.b
        public F.e.d.b e(F.e.d.f fVar) {
            this.f8795f = fVar;
            return this;
        }

        @Override // V2.F.e.d.b
        public F.e.d.b f(long j8) {
            this.f8790a = j8;
            this.f8796g = (byte) (this.f8796g | 1);
            return this;
        }

        @Override // V2.F.e.d.b
        public F.e.d.b g(String str) {
            if (str == null) {
                throw new NullPointerException("Null type");
            }
            this.f8791b = str;
            return this;
        }

        public b(F.e.d dVar) {
            this.f8790a = dVar.f();
            this.f8791b = dVar.g();
            this.f8792c = dVar.b();
            this.f8793d = dVar.c();
            this.f8794e = dVar.d();
            this.f8795f = dVar.e();
            this.f8796g = (byte) 1;
        }
    }

    public l(long j8, String str, F.e.d.a aVar, F.e.d.c cVar, F.e.d.AbstractC0137d abstractC0137d, F.e.d.f fVar) {
        this.f8784a = j8;
        this.f8785b = str;
        this.f8786c = aVar;
        this.f8787d = cVar;
        this.f8788e = abstractC0137d;
        this.f8789f = fVar;
    }

    @Override // V2.F.e.d
    public F.e.d.a b() {
        return this.f8786c;
    }

    @Override // V2.F.e.d
    public F.e.d.c c() {
        return this.f8787d;
    }

    @Override // V2.F.e.d
    public F.e.d.AbstractC0137d d() {
        return this.f8788e;
    }

    @Override // V2.F.e.d
    public F.e.d.f e() {
        return this.f8789f;
    }

    public boolean equals(Object obj) {
        F.e.d.AbstractC0137d abstractC0137d;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof F.e.d)) {
            return false;
        }
        F.e.d dVar = (F.e.d) obj;
        if (this.f8784a == dVar.f() && this.f8785b.equals(dVar.g()) && this.f8786c.equals(dVar.b()) && this.f8787d.equals(dVar.c()) && ((abstractC0137d = this.f8788e) != null ? abstractC0137d.equals(dVar.d()) : dVar.d() == null)) {
            F.e.d.f fVar = this.f8789f;
            F.e.d.f fVarE = dVar.e();
            if (fVar == null) {
                if (fVarE == null) {
                    return true;
                }
            } else if (fVar.equals(fVarE)) {
                return true;
            }
        }
        return false;
    }

    @Override // V2.F.e.d
    public long f() {
        return this.f8784a;
    }

    @Override // V2.F.e.d
    public String g() {
        return this.f8785b;
    }

    @Override // V2.F.e.d
    public F.e.d.b h() {
        return new b(this);
    }

    public int hashCode() {
        long j8 = this.f8784a;
        int iHashCode = (((((((((int) (j8 ^ (j8 >>> 32))) ^ 1000003) * 1000003) ^ this.f8785b.hashCode()) * 1000003) ^ this.f8786c.hashCode()) * 1000003) ^ this.f8787d.hashCode()) * 1000003;
        F.e.d.AbstractC0137d abstractC0137d = this.f8788e;
        int iHashCode2 = (iHashCode ^ (abstractC0137d == null ? 0 : abstractC0137d.hashCode())) * 1000003;
        F.e.d.f fVar = this.f8789f;
        return iHashCode2 ^ (fVar != null ? fVar.hashCode() : 0);
    }

    public String toString() {
        return "Event{timestamp=" + this.f8784a + ", type=" + this.f8785b + ", app=" + this.f8786c + ", device=" + this.f8787d + ", log=" + this.f8788e + ", rollouts=" + this.f8789f + "}";
    }
}
