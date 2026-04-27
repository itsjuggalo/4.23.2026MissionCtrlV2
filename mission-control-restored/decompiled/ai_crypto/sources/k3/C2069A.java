package k3;

import k3.AbstractC2074F;

/* JADX INFO: renamed from: k3.A, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2069A extends AbstractC2074F.e.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17574a;

    /* JADX INFO: renamed from: k3.A$b */
    public static final class b extends AbstractC2074F.e.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f17575a;

        @Override // k3.AbstractC2074F.e.f.a
        public AbstractC2074F.e.f a() {
            String str = this.f17575a;
            if (str != null) {
                return new C2069A(str);
            }
            throw new IllegalStateException("Missing required properties: identifier");
        }

        @Override // k3.AbstractC2074F.e.f.a
        public AbstractC2074F.e.f.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.f17575a = str;
            return this;
        }
    }

    @Override // k3.AbstractC2074F.e.f
    public String b() {
        return this.f17574a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC2074F.e.f) {
            return this.f17574a.equals(((AbstractC2074F.e.f) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f17574a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "User{identifier=" + this.f17574a + "}";
    }

    public C2069A(String str) {
        this.f17574a = str;
    }
}
