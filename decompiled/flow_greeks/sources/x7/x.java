package x7;

import x7.f0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class x extends f0.e.d.AbstractC0446e.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f24659b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends f0.e.d.AbstractC0446e.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f24660a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f24661b;

        @Override // x7.f0.e.d.AbstractC0446e.b.a
        public f0.e.d.AbstractC0446e.b a() {
            String str;
            String str2 = this.f24660a;
            if (str2 != null && (str = this.f24661b) != null) {
                return new x(str2, str);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.f24660a == null) {
                sb2.append(" rolloutId");
            }
            if (this.f24661b == null) {
                sb2.append(" variantId");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // x7.f0.e.d.AbstractC0446e.b.a
        public f0.e.d.AbstractC0446e.b.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null rolloutId");
            }
            this.f24660a = str;
            return this;
        }

        @Override // x7.f0.e.d.AbstractC0446e.b.a
        public f0.e.d.AbstractC0446e.b.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null variantId");
            }
            this.f24661b = str;
            return this;
        }
    }

    @Override // x7.f0.e.d.AbstractC0446e.b
    public String b() {
        return this.f24658a;
    }

    @Override // x7.f0.e.d.AbstractC0446e.b
    public String c() {
        return this.f24659b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0.e.d.AbstractC0446e.b) {
            f0.e.d.AbstractC0446e.b bVar = (f0.e.d.AbstractC0446e.b) obj;
            if (this.f24658a.equals(bVar.b()) && this.f24659b.equals(bVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f24658a.hashCode() ^ 1000003) * 1000003) ^ this.f24659b.hashCode();
    }

    public String toString() {
        return "RolloutVariant{rolloutId=" + this.f24658a + ", variantId=" + this.f24659b + "}";
    }

    public x(String str, String str2) {
        this.f24658a = str;
        this.f24659b = str2;
    }
}
