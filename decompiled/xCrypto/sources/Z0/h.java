package Z0;

import Z0.r;

/* JADX INFO: loaded from: classes.dex */
public final class h extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f5855a;

    public static final class b extends r.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f5856a;

        @Override // Z0.r.a
        public r a() {
            return new h(this.f5856a);
        }

        @Override // Z0.r.a
        public r.a b(Integer num) {
            this.f5856a = num;
            return this;
        }
    }

    @Override // Z0.r
    public Integer b() {
        return this.f5855a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        Integer num = this.f5855a;
        Integer numB = ((r) obj).b();
        return num == null ? numB == null : num.equals(numB);
    }

    public int hashCode() {
        Integer num = this.f5855a;
        return (num == null ? 0 : num.hashCode()) ^ 1000003;
    }

    public String toString() {
        return "ExternalPRequestContext{originAssociatedProductId=" + this.f5855a + "}";
    }

    public h(Integer num) {
        this.f5855a = num;
    }
}
