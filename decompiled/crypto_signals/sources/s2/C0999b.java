package s2;

/* JADX INFO: renamed from: s2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0999b extends n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f9541d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f9542f;

    public C0999b(String str, String str2, String str3, String str4, long j4) {
        if (str == null) {
            throw new NullPointerException("Null rolloutId");
        }
        this.f9539b = str;
        if (str2 == null) {
            throw new NullPointerException("Null parameterKey");
        }
        this.f9540c = str2;
        if (str3 == null) {
            throw new NullPointerException("Null parameterValue");
        }
        this.f9541d = str3;
        if (str4 == null) {
            throw new NullPointerException("Null variantId");
        }
        this.e = str4;
        this.f9542f = j4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (this.f9539b.equals(((C0999b) nVar).f9539b)) {
                C0999b c0999b = (C0999b) nVar;
                if (this.f9540c.equals(c0999b.f9540c) && this.f9541d.equals(c0999b.f9541d) && this.e.equals(c0999b.e) && this.f9542f == c0999b.f9542f) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((((((this.f9539b.hashCode() ^ 1000003) * 1000003) ^ this.f9540c.hashCode()) * 1000003) ^ this.f9541d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003;
        long j4 = this.f9542f;
        return iHashCode ^ ((int) ((j4 >>> 32) ^ j4));
    }

    public final String toString() {
        return "RolloutAssignment{rolloutId=" + this.f9539b + ", parameterKey=" + this.f9540c + ", parameterValue=" + this.f9541d + ", variantId=" + this.e + ", templateVersion=" + this.f9542f + "}";
    }
}
