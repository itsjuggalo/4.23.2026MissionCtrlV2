package x7;

import x7.f0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class v extends f0.e.d.AbstractC0445d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24647a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends f0.e.d.AbstractC0445d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f24648a;

        @Override // x7.f0.e.d.AbstractC0445d.a
        public f0.e.d.AbstractC0445d a() {
            String str = this.f24648a;
            if (str != null) {
                return new v(str);
            }
            throw new IllegalStateException("Missing required properties: content");
        }

        @Override // x7.f0.e.d.AbstractC0445d.a
        public f0.e.d.AbstractC0445d.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null content");
            }
            this.f24648a = str;
            return this;
        }
    }

    @Override // x7.f0.e.d.AbstractC0445d
    public String b() {
        return this.f24647a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0.e.d.AbstractC0445d) {
            return this.f24647a.equals(((f0.e.d.AbstractC0445d) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f24647a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Log{content=" + this.f24647a + "}";
    }

    public v(String str) {
        this.f24647a = str;
    }
}
