package k3;

import k3.AbstractC2074F;

/* JADX INFO: renamed from: k3.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2097v extends AbstractC2074F.e.d.AbstractC0284d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17968a;

    /* JADX INFO: renamed from: k3.v$b */
    public static final class b extends AbstractC2074F.e.d.AbstractC0284d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f17969a;

        @Override // k3.AbstractC2074F.e.d.AbstractC0284d.a
        public AbstractC2074F.e.d.AbstractC0284d a() {
            String str = this.f17969a;
            if (str != null) {
                return new C2097v(str);
            }
            throw new IllegalStateException("Missing required properties: content");
        }

        @Override // k3.AbstractC2074F.e.d.AbstractC0284d.a
        public AbstractC2074F.e.d.AbstractC0284d.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null content");
            }
            this.f17969a = str;
            return this;
        }
    }

    @Override // k3.AbstractC2074F.e.d.AbstractC0284d
    public String b() {
        return this.f17968a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC2074F.e.d.AbstractC0284d) {
            return this.f17968a.equals(((AbstractC2074F.e.d.AbstractC0284d) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f17968a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Log{content=" + this.f17968a + "}";
    }

    public C2097v(String str) {
        this.f17968a = str;
    }
}
