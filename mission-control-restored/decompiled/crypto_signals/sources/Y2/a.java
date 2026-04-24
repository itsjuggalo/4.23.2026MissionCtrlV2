package Y2;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f3592c;

    public a(String str, long j4, long j6) {
        this.f3590a = str;
        this.f3591b = j4;
        this.f3592c = j6;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f3590a.equals(aVar.f3590a) && this.f3591b == aVar.f3591b && this.f3592c == aVar.f3592c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f3590a.hashCode() ^ 1000003) * 1000003;
        long j4 = this.f3591b;
        long j6 = this.f3592c;
        return ((iHashCode ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003) ^ ((int) (j6 ^ (j6 >>> 32)));
    }

    public final String toString() {
        return "InstallationTokenResult{token=" + this.f3590a + ", tokenExpirationTimestamp=" + this.f3591b + ", tokenCreationTimestamp=" + this.f3592c + "}";
    }
}
