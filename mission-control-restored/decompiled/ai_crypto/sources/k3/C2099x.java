package k3;

import k3.AbstractC2074F;

/* JADX INFO: renamed from: k3.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2099x extends AbstractC2074F.e.d.AbstractC0285e.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17980b;

    /* JADX INFO: renamed from: k3.x$b */
    public static final class b extends AbstractC2074F.e.d.AbstractC0285e.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f17981a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f17982b;

        @Override // k3.AbstractC2074F.e.d.AbstractC0285e.b.a
        public AbstractC2074F.e.d.AbstractC0285e.b a() {
            String str;
            String str2 = this.f17981a;
            if (str2 != null && (str = this.f17982b) != null) {
                return new C2099x(str2, str);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f17981a == null) {
                sb.append(" rolloutId");
            }
            if (this.f17982b == null) {
                sb.append(" variantId");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // k3.AbstractC2074F.e.d.AbstractC0285e.b.a
        public AbstractC2074F.e.d.AbstractC0285e.b.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null rolloutId");
            }
            this.f17981a = str;
            return this;
        }

        @Override // k3.AbstractC2074F.e.d.AbstractC0285e.b.a
        public AbstractC2074F.e.d.AbstractC0285e.b.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null variantId");
            }
            this.f17982b = str;
            return this;
        }
    }

    @Override // k3.AbstractC2074F.e.d.AbstractC0285e.b
    public String b() {
        return this.f17979a;
    }

    @Override // k3.AbstractC2074F.e.d.AbstractC0285e.b
    public String c() {
        return this.f17980b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2074F.e.d.AbstractC0285e.b)) {
            return false;
        }
        AbstractC2074F.e.d.AbstractC0285e.b bVar = (AbstractC2074F.e.d.AbstractC0285e.b) obj;
        return this.f17979a.equals(bVar.b()) && this.f17980b.equals(bVar.c());
    }

    public int hashCode() {
        return ((this.f17979a.hashCode() ^ 1000003) * 1000003) ^ this.f17980b.hashCode();
    }

    public String toString() {
        return "RolloutVariant{rolloutId=" + this.f17979a + ", variantId=" + this.f17980b + "}";
    }

    public C2099x(String str, String str2) {
        this.f17979a = str;
        this.f17980b = str2;
    }
}
