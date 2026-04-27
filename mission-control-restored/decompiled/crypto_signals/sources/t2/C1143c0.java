package t2;

/* JADX INFO: renamed from: t2.c0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1143c0 extends F0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Double f10074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f10076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f10077d;
    public final long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f10078f;

    public C1143c0(Double d4, int i, boolean z6, int i6, long j4, long j6) {
        this.f10074a = d4;
        this.f10075b = i;
        this.f10076c = z6;
        this.f10077d = i6;
        this.e = j4;
        this.f10078f = j6;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof F0) {
            F0 f02 = (F0) obj;
            Double d4 = this.f10074a;
            if (d4 != null ? d4.equals(((C1143c0) f02).f10074a) : ((C1143c0) f02).f10074a == null) {
                if (this.f10075b == ((C1143c0) f02).f10075b) {
                    C1143c0 c1143c0 = (C1143c0) f02;
                    if (this.f10076c == c1143c0.f10076c && this.f10077d == c1143c0.f10077d && this.e == c1143c0.e && this.f10078f == c1143c0.f10078f) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        Double d4 = this.f10074a;
        int iHashCode = ((((((((d4 == null ? 0 : d4.hashCode()) ^ 1000003) * 1000003) ^ this.f10075b) * 1000003) ^ (this.f10076c ? 1231 : 1237)) * 1000003) ^ this.f10077d) * 1000003;
        long j4 = this.e;
        long j6 = this.f10078f;
        return ((iHashCode ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003) ^ ((int) (j6 ^ (j6 >>> 32)));
    }

    public final String toString() {
        return "Device{batteryLevel=" + this.f10074a + ", batteryVelocity=" + this.f10075b + ", proximityOn=" + this.f10076c + ", orientation=" + this.f10077d + ", ramUsed=" + this.e + ", diskUsed=" + this.f10078f + "}";
    }
}
