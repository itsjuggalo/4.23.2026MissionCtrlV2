package o1;

/* JADX INFO: renamed from: o1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2290b extends AbstractC2295g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f20013a;

    public C2290b(Integer num) {
        this.f20013a = num;
    }

    @Override // o1.AbstractC2295g
    public Integer a() {
        return this.f20013a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2295g)) {
            return false;
        }
        Integer num = this.f20013a;
        Integer numA = ((AbstractC2295g) obj).a();
        return num == null ? numA == null : num.equals(numA);
    }

    public int hashCode() {
        Integer num = this.f20013a;
        return (num == null ? 0 : num.hashCode()) ^ 1000003;
    }

    public String toString() {
        return "ProductData{productId=" + this.f20013a + "}";
    }
}
