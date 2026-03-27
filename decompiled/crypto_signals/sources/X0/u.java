package X0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class u extends G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f3509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f3510d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList f3511f;

    public u(long j4, long j6, n nVar, Integer num, String str, ArrayList arrayList) {
        K k6 = K.f3430a;
        this.f3507a = j4;
        this.f3508b = j6;
        this.f3509c = nVar;
        this.f3510d = num;
        this.e = str;
        this.f3511f = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof G)) {
            return false;
        }
        u uVar = (u) ((G) obj);
        if (this.f3507a != uVar.f3507a) {
            return false;
        }
        if (this.f3508b != uVar.f3508b) {
            return false;
        }
        if (!this.f3509c.equals(uVar.f3509c)) {
            return false;
        }
        Integer num = uVar.f3510d;
        Integer num2 = this.f3510d;
        if (num2 == null) {
            if (num != null) {
                return false;
            }
        } else if (!num2.equals(num)) {
            return false;
        }
        String str = uVar.e;
        String str2 = this.e;
        if (str2 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str2.equals(str)) {
            return false;
        }
        if (!this.f3511f.equals(uVar.f3511f)) {
            return false;
        }
        Object obj2 = K.f3430a;
        return obj2.equals(obj2);
    }

    public final int hashCode() {
        long j4 = this.f3507a;
        long j6 = this.f3508b;
        int iHashCode = (((((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j6 >>> 32) ^ j6))) * 1000003) ^ this.f3509c.hashCode()) * 1000003;
        Integer num = this.f3510d;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.e;
        return ((((iHashCode2 ^ (str != null ? str.hashCode() : 0)) * 1000003) ^ this.f3511f.hashCode()) * 1000003) ^ K.f3430a.hashCode();
    }

    public final String toString() {
        return "LogRequest{requestTimeMs=" + this.f3507a + ", requestUptimeMs=" + this.f3508b + ", clientInfo=" + this.f3509c + ", logSource=" + this.f3510d + ", logSourceName=" + this.e + ", logEvents=" + this.f3511f + ", qosTier=" + K.f3430a + "}";
    }
}
