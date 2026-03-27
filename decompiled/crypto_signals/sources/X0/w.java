package X0;

/* JADX INFO: loaded from: classes.dex */
public final class w extends J {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I f3513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final H f3514b;

    public w(I i, H h6) {
        this.f3513a = i;
        this.f3514b = h6;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof J) {
            J j4 = (J) obj;
            I i = this.f3513a;
            if (i != null ? i.equals(((w) j4).f3513a) : ((w) j4).f3513a == null) {
                H h6 = this.f3514b;
                if (h6 != null ? h6.equals(((w) j4).f3514b) : ((w) j4).f3514b == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        I i = this.f3513a;
        int iHashCode = ((i == null ? 0 : i.hashCode()) ^ 1000003) * 1000003;
        H h6 = this.f3514b;
        return (h6 != null ? h6.hashCode() : 0) ^ iHashCode;
    }

    public final String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f3513a + ", mobileSubtype=" + this.f3514b + "}";
    }
}
