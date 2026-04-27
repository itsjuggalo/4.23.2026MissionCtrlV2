package k3;

import k3.AbstractC2074F;

/* JADX INFO: renamed from: k3.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2087l extends AbstractC2074F.e.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f17863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AbstractC2074F.e.d.a f17865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AbstractC2074F.e.d.c f17866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AbstractC2074F.e.d.AbstractC0284d f17867e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AbstractC2074F.e.d.f f17868f;

    /* JADX INFO: renamed from: k3.l$b */
    public static final class b extends AbstractC2074F.e.d.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f17869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f17870b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public AbstractC2074F.e.d.a f17871c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public AbstractC2074F.e.d.c f17872d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public AbstractC2074F.e.d.AbstractC0284d f17873e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public AbstractC2074F.e.d.f f17874f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public byte f17875g;

        @Override // k3.AbstractC2074F.e.d.b
        public AbstractC2074F.e.d a() {
            String str;
            AbstractC2074F.e.d.a aVar;
            AbstractC2074F.e.d.c cVar;
            if (this.f17875g == 1 && (str = this.f17870b) != null && (aVar = this.f17871c) != null && (cVar = this.f17872d) != null) {
                return new C2087l(this.f17869a, str, aVar, cVar, this.f17873e, this.f17874f);
            }
            StringBuilder sb = new StringBuilder();
            if ((1 & this.f17875g) == 0) {
                sb.append(" timestamp");
            }
            if (this.f17870b == null) {
                sb.append(" type");
            }
            if (this.f17871c == null) {
                sb.append(" app");
            }
            if (this.f17872d == null) {
                sb.append(" device");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // k3.AbstractC2074F.e.d.b
        public AbstractC2074F.e.d.b b(AbstractC2074F.e.d.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("Null app");
            }
            this.f17871c = aVar;
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.b
        public AbstractC2074F.e.d.b c(AbstractC2074F.e.d.c cVar) {
            if (cVar == null) {
                throw new NullPointerException("Null device");
            }
            this.f17872d = cVar;
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.b
        public AbstractC2074F.e.d.b d(AbstractC2074F.e.d.AbstractC0284d abstractC0284d) {
            this.f17873e = abstractC0284d;
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.b
        public AbstractC2074F.e.d.b e(AbstractC2074F.e.d.f fVar) {
            this.f17874f = fVar;
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.b
        public AbstractC2074F.e.d.b f(long j7) {
            this.f17869a = j7;
            this.f17875g = (byte) (this.f17875g | 1);
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.b
        public AbstractC2074F.e.d.b g(String str) {
            if (str == null) {
                throw new NullPointerException("Null type");
            }
            this.f17870b = str;
            return this;
        }

        public b() {
        }

        public b(AbstractC2074F.e.d dVar) {
            this.f17869a = dVar.f();
            this.f17870b = dVar.g();
            this.f17871c = dVar.b();
            this.f17872d = dVar.c();
            this.f17873e = dVar.d();
            this.f17874f = dVar.e();
            this.f17875g = (byte) 1;
        }
    }

    @Override // k3.AbstractC2074F.e.d
    public AbstractC2074F.e.d.a b() {
        return this.f17865c;
    }

    @Override // k3.AbstractC2074F.e.d
    public AbstractC2074F.e.d.c c() {
        return this.f17866d;
    }

    @Override // k3.AbstractC2074F.e.d
    public AbstractC2074F.e.d.AbstractC0284d d() {
        return this.f17867e;
    }

    @Override // k3.AbstractC2074F.e.d
    public AbstractC2074F.e.d.f e() {
        return this.f17868f;
    }

    public boolean equals(Object obj) {
        AbstractC2074F.e.d.AbstractC0284d abstractC0284d;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2074F.e.d)) {
            return false;
        }
        AbstractC2074F.e.d dVar = (AbstractC2074F.e.d) obj;
        if (this.f17863a == dVar.f() && this.f17864b.equals(dVar.g()) && this.f17865c.equals(dVar.b()) && this.f17866d.equals(dVar.c()) && ((abstractC0284d = this.f17867e) != null ? abstractC0284d.equals(dVar.d()) : dVar.d() == null)) {
            AbstractC2074F.e.d.f fVar = this.f17868f;
            if (fVar == null) {
                if (dVar.e() == null) {
                    return true;
                }
            } else if (fVar.equals(dVar.e())) {
                return true;
            }
        }
        return false;
    }

    @Override // k3.AbstractC2074F.e.d
    public long f() {
        return this.f17863a;
    }

    @Override // k3.AbstractC2074F.e.d
    public String g() {
        return this.f17864b;
    }

    @Override // k3.AbstractC2074F.e.d
    public AbstractC2074F.e.d.b h() {
        return new b(this);
    }

    public int hashCode() {
        long j7 = this.f17863a;
        int iHashCode = (((((((((int) (j7 ^ (j7 >>> 32))) ^ 1000003) * 1000003) ^ this.f17864b.hashCode()) * 1000003) ^ this.f17865c.hashCode()) * 1000003) ^ this.f17866d.hashCode()) * 1000003;
        AbstractC2074F.e.d.AbstractC0284d abstractC0284d = this.f17867e;
        int iHashCode2 = (iHashCode ^ (abstractC0284d == null ? 0 : abstractC0284d.hashCode())) * 1000003;
        AbstractC2074F.e.d.f fVar = this.f17868f;
        return iHashCode2 ^ (fVar != null ? fVar.hashCode() : 0);
    }

    public String toString() {
        return "Event{timestamp=" + this.f17863a + ", type=" + this.f17864b + ", app=" + this.f17865c + ", device=" + this.f17866d + ", log=" + this.f17867e + ", rollouts=" + this.f17868f + "}";
    }

    public C2087l(long j7, String str, AbstractC2074F.e.d.a aVar, AbstractC2074F.e.d.c cVar, AbstractC2074F.e.d.AbstractC0284d abstractC0284d, AbstractC2074F.e.d.f fVar) {
        this.f17863a = j7;
        this.f17864b = str;
        this.f17865c = aVar;
        this.f17866d = cVar;
        this.f17867e = abstractC0284d;
        this.f17868f = fVar;
    }
}
