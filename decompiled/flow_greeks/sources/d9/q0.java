package d9;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class q0 implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f7918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f7919b;

    public q0(double d10, double d11) {
        if (Double.isNaN(d10) || d10 < -90.0d || d10 > 90.0d) {
            throw new IllegalArgumentException("Latitude must be in the range of [-90, 90]");
        }
        if (Double.isNaN(d11) || d11 < -180.0d || d11 > 180.0d) {
            throw new IllegalArgumentException("Longitude must be in the range of [-180, 180]");
        }
        this.f7918a = d10;
        this.f7919b = d11;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(q0 q0Var) {
        int iK = n9.g0.k(this.f7918a, q0Var.f7918a);
        return iK == 0 ? n9.g0.k(this.f7919b, q0Var.f7919b) : iK;
    }

    public double b() {
        return this.f7918a;
    }

    public double c() {
        return this.f7919b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q0)) {
            return false;
        }
        q0 q0Var = (q0) obj;
        return this.f7918a == q0Var.f7918a && this.f7919b == q0Var.f7919b;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.f7918a);
        int i10 = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.f7919b);
        return (i10 * 31) + ((int) ((jDoubleToLongBits2 >>> 32) ^ jDoubleToLongBits2));
    }

    public String toString() {
        return "GeoPoint { latitude=" + this.f7918a + ", longitude=" + this.f7919b + " }";
    }
}
