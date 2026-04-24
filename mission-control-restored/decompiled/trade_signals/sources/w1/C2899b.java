package w1;

/* JADX INFO: renamed from: w1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2899b extends AbstractC2904g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f23987a;

    public C2899b(Integer num) {
        this.f23987a = num;
    }

    @Override // w1.AbstractC2904g
    public Integer a() {
        return this.f23987a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2904g)) {
            return false;
        }
        Integer num = this.f23987a;
        Integer numA = ((AbstractC2904g) obj).a();
        return num == null ? numA == null : num.equals(numA);
    }

    public int hashCode() {
        Integer num = this.f23987a;
        return (num == null ? 0 : num.hashCode()) ^ 1000003;
    }

    public String toString() {
        return "ProductData{productId=" + this.f23987a + "}";
    }
}
