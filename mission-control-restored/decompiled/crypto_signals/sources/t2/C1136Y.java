package t2;

/* JADX INFO: renamed from: t2.Y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1136Y extends A0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f10041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f10044d;
    public final int e;

    public C1136Y(long j4, String str, String str2, long j6, int i) {
        this.f10041a = j4;
        this.f10042b = str;
        this.f10043c = str2;
        this.f10044d = j6;
        this.e = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof A0) {
            A0 a02 = (A0) obj;
            if (this.f10041a == ((C1136Y) a02).f10041a) {
                C1136Y c1136y = (C1136Y) a02;
                if (this.f10042b.equals(c1136y.f10042b)) {
                    String str = c1136y.f10043c;
                    String str2 = this.f10043c;
                    if (str2 != null ? str2.equals(str) : str == null) {
                        if (this.f10044d == c1136y.f10044d && this.e == c1136y.e) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f10041a;
        int iHashCode = (((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ this.f10042b.hashCode()) * 1000003;
        String str = this.f10043c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j6 = this.f10044d;
        return ((iHashCode2 ^ ((int) ((j6 >>> 32) ^ j6))) * 1000003) ^ this.e;
    }

    public final String toString() {
        return "Frame{pc=" + this.f10041a + ", symbol=" + this.f10042b + ", file=" + this.f10043c + ", offset=" + this.f10044d + ", importance=" + this.e + "}";
    }
}
