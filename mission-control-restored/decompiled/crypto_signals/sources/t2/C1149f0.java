package t2;

/* JADX INFO: renamed from: t2.f0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1149f0 extends I0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1151g0 f10101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f10104d;

    public C1149f0(C1151g0 c1151g0, String str, String str2, long j4) {
        this.f10101a = c1151g0;
        this.f10102b = str;
        this.f10103c = str2;
        this.f10104d = j4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof I0)) {
            return false;
        }
        C1149f0 c1149f0 = (C1149f0) ((I0) obj);
        if (this.f10101a.equals(c1149f0.f10101a)) {
            return this.f10102b.equals(c1149f0.f10102b) && this.f10103c.equals(c1149f0.f10103c) && this.f10104d == c1149f0.f10104d;
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((((this.f10101a.hashCode() ^ 1000003) * 1000003) ^ this.f10102b.hashCode()) * 1000003) ^ this.f10103c.hashCode()) * 1000003;
        long j4 = this.f10104d;
        return iHashCode ^ ((int) (j4 ^ (j4 >>> 32)));
    }

    public final String toString() {
        return "RolloutAssignment{rolloutVariant=" + this.f10101a + ", parameterKey=" + this.f10102b + ", parameterValue=" + this.f10103c + ", templateVersion=" + this.f10104d + "}";
    }
}
