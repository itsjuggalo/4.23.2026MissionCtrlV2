package a3;

import S.i;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4059c;

    public b(String str, long j4, int i) {
        this.f4057a = str;
        this.f4058b = j4;
        this.f4059c = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        String str = this.f4057a;
        if (str == null) {
            if (bVar.f4057a != null) {
                return false;
            }
        } else if (!str.equals(bVar.f4057a)) {
            return false;
        }
        if (this.f4058b != bVar.f4058b) {
            return false;
        }
        int i = bVar.f4059c;
        int i6 = this.f4059c;
        return i6 == 0 ? i == 0 : i.b(i6, i);
    }

    public final int hashCode() {
        String str = this.f4057a;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j4 = this.f4058b;
        int i = (((iHashCode ^ 1000003) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003;
        int i6 = this.f4059c;
        return (i6 != 0 ? i.c(i6) : 0) ^ i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TokenResult{token=");
        sb.append(this.f4057a);
        sb.append(", tokenExpirationTimestamp=");
        sb.append(this.f4058b);
        sb.append(", responseCode=");
        int i = this.f4059c;
        sb.append(i != 1 ? i != 2 ? i != 3 ? "null" : "AUTH_ERROR" : "BAD_CONFIG" : "OK");
        sb.append("}");
        return sb.toString();
    }
}
