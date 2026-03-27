package A3;

/* JADX INFO: loaded from: classes.dex */
public class Q implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f138b;

    public Q(double d7, double d8) {
        if (Double.isNaN(d7) || d7 < -90.0d || d7 > 90.0d) {
            throw new IllegalArgumentException("Latitude must be in the range of [-90, 90]");
        }
        if (Double.isNaN(d8) || d8 < -180.0d || d8 > 180.0d) {
            throw new IllegalArgumentException("Longitude must be in the range of [-180, 180]");
        }
        this.f137a = d7;
        this.f138b = d8;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(Q q7) {
        int iK = K3.I.k(this.f137a, q7.f137a);
        return iK == 0 ? K3.I.k(this.f138b, q7.f138b) : iK;
    }

    public double b() {
        return this.f137a;
    }

    public double c() {
        return this.f138b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Q)) {
            return false;
        }
        Q q7 = (Q) obj;
        return this.f137a == q7.f137a && this.f138b == q7.f138b;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.f137a);
        int i7 = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.f138b);
        return (i7 * 31) + ((int) ((jDoubleToLongBits2 >>> 32) ^ jDoubleToLongBits2));
    }

    public String toString() {
        return "GeoPoint { latitude=" + this.f137a + ", longitude=" + this.f138b + " }";
    }
}
