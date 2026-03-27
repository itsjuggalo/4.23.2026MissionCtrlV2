package X0;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class t extends F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f3501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f3502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f3503d;
    public final byte[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f3504f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f3505g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final w f3506h;
    public final p i;

    public t(long j4, Integer num, o oVar, long j6, byte[] bArr, String str, long j7, w wVar, p pVar) {
        this.f3500a = j4;
        this.f3501b = num;
        this.f3502c = oVar;
        this.f3503d = j6;
        this.e = bArr;
        this.f3504f = str;
        this.f3505g = j7;
        this.f3506h = wVar;
        this.i = pVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof F)) {
            return false;
        }
        F f6 = (F) obj;
        t tVar = (t) f6;
        if (this.f3500a != tVar.f3500a) {
            return false;
        }
        Integer num = this.f3501b;
        if (num == null) {
            if (tVar.f3501b != null) {
                return false;
            }
        } else if (!num.equals(tVar.f3501b)) {
            return false;
        }
        o oVar = this.f3502c;
        if (oVar == null) {
            if (tVar.f3502c != null) {
                return false;
            }
        } else if (!oVar.equals(tVar.f3502c)) {
            return false;
        }
        if (this.f3503d != tVar.f3503d) {
            return false;
        }
        if (!Arrays.equals(this.e, f6 instanceof t ? ((t) f6).e : tVar.e)) {
            return false;
        }
        String str = tVar.f3504f;
        String str2 = this.f3504f;
        if (str2 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str2.equals(str)) {
            return false;
        }
        if (this.f3505g != tVar.f3505g) {
            return false;
        }
        w wVar = tVar.f3506h;
        w wVar2 = this.f3506h;
        if (wVar2 == null) {
            if (wVar != null) {
                return false;
            }
        } else if (!wVar2.equals(wVar)) {
            return false;
        }
        p pVar = tVar.i;
        p pVar2 = this.i;
        return pVar2 == null ? pVar == null : pVar2.equals(pVar);
    }

    public final int hashCode() {
        long j4 = this.f3500a;
        int i = (((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f3501b;
        int iHashCode = (i ^ (num == null ? 0 : num.hashCode())) * 1000003;
        o oVar = this.f3502c;
        int iHashCode2 = (iHashCode ^ (oVar == null ? 0 : oVar.hashCode())) * 1000003;
        long j6 = this.f3503d;
        int iHashCode3 = (((iHashCode2 ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.e)) * 1000003;
        String str = this.f3504f;
        int iHashCode4 = (iHashCode3 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j7 = this.f3505g;
        int i6 = (iHashCode4 ^ ((int) (j7 ^ (j7 >>> 32)))) * 1000003;
        w wVar = this.f3506h;
        int iHashCode5 = (i6 ^ (wVar == null ? 0 : wVar.hashCode())) * 1000003;
        p pVar = this.i;
        return iHashCode5 ^ (pVar != null ? pVar.hashCode() : 0);
    }

    public final String toString() {
        return "LogEvent{eventTimeMs=" + this.f3500a + ", eventCode=" + this.f3501b + ", complianceData=" + this.f3502c + ", eventUptimeMs=" + this.f3503d + ", sourceExtension=" + Arrays.toString(this.e) + ", sourceExtensionJsonProto3=" + this.f3504f + ", timezoneOffsetSeconds=" + this.f3505g + ", networkConnectionInfo=" + this.f3506h + ", experimentIds=" + this.i + "}";
    }
}
