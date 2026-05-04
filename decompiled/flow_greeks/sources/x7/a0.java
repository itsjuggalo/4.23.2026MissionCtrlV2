package x7;

import x7.f0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 extends f0.e.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24400a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends f0.e.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f24401a;

        @Override // x7.f0.e.f.a
        public f0.e.f a() {
            String str = this.f24401a;
            if (str != null) {
                return new a0(str);
            }
            throw new IllegalStateException("Missing required properties: identifier");
        }

        @Override // x7.f0.e.f.a
        public f0.e.f.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.f24401a = str;
            return this;
        }
    }

    @Override // x7.f0.e.f
    public String b() {
        return this.f24400a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0.e.f) {
            return this.f24400a.equals(((f0.e.f) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f24400a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "User{identifier=" + this.f24400a + "}";
    }

    public a0(String str) {
        this.f24400a = str;
    }
}
