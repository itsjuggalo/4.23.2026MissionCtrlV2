package K2;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f861d;
    public final V e;

    public M(L l6) {
        this.f858a = l6.f853a;
        this.f859b = l6.f854b;
        this.f860c = l6.f855c;
        this.f861d = l6.f856d;
        this.e = l6.e;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || M.class != obj.getClass()) {
            return false;
        }
        M m5 = (M) obj;
        if (this.f859b == m5.f859b && this.f860c == m5.f860c && this.f861d == m5.f861d && this.f858a.equals(m5.f858a)) {
            return Objects.equals(this.e, m5.e);
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = ((((this.f858a.hashCode() * 31) + (this.f859b ? 1 : 0)) * 31) + (this.f860c ? 1 : 0)) * 31;
        long j4 = this.f861d;
        int i = (iHashCode + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        V v2 = this.e;
        return i + (v2 != null ? v2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FirebaseFirestoreSettings{host=");
        sb.append(this.f858a);
        sb.append(", sslEnabled=");
        sb.append(this.f859b);
        sb.append(", persistenceEnabled=");
        sb.append(this.f860c);
        sb.append(", cacheSizeBytes=");
        sb.append(this.f861d);
        sb.append(", cacheSettings=");
        V v2 = this.e;
        sb.append(v2);
        if (sb.toString() == null) {
            return "null";
        }
        return v2.toString() + "}";
    }
}
