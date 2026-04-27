package V2;

import V2.F;

/* JADX INFO: loaded from: classes.dex */
public final class x extends F.e.d.AbstractC0138e.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8901b;

    public static final class b extends F.e.d.AbstractC0138e.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8902a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8903b;

        @Override // V2.F.e.d.AbstractC0138e.b.a
        public F.e.d.AbstractC0138e.b a() {
            String str;
            String str2 = this.f8902a;
            if (str2 != null && (str = this.f8903b) != null) {
                return new x(str2, str);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f8902a == null) {
                sb.append(" rolloutId");
            }
            if (this.f8903b == null) {
                sb.append(" variantId");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // V2.F.e.d.AbstractC0138e.b.a
        public F.e.d.AbstractC0138e.b.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null rolloutId");
            }
            this.f8902a = str;
            return this;
        }

        @Override // V2.F.e.d.AbstractC0138e.b.a
        public F.e.d.AbstractC0138e.b.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null variantId");
            }
            this.f8903b = str;
            return this;
        }
    }

    public x(String str, String str2) {
        this.f8900a = str;
        this.f8901b = str2;
    }

    @Override // V2.F.e.d.AbstractC0138e.b
    public String b() {
        return this.f8900a;
    }

    @Override // V2.F.e.d.AbstractC0138e.b
    public String c() {
        return this.f8901b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof F.e.d.AbstractC0138e.b)) {
            return false;
        }
        F.e.d.AbstractC0138e.b bVar = (F.e.d.AbstractC0138e.b) obj;
        return this.f8900a.equals(bVar.b()) && this.f8901b.equals(bVar.c());
    }

    public int hashCode() {
        return ((this.f8900a.hashCode() ^ 1000003) * 1000003) ^ this.f8901b.hashCode();
    }

    public String toString() {
        return "RolloutVariant{rolloutId=" + this.f8900a + ", variantId=" + this.f8901b + "}";
    }
}
