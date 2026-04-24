package Y0;

import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f3558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f3559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f3560d;
    public final long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap f3561f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f3562g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f3563h;
    public final byte[] i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final byte[] f3564j;

    public i(String str, Integer num, l lVar, long j4, long j6, HashMap map, Integer num2, String str2, byte[] bArr, byte[] bArr2) {
        this.f3557a = str;
        this.f3558b = num;
        this.f3559c = lVar;
        this.f3560d = j4;
        this.e = j6;
        this.f3561f = map;
        this.f3562g = num2;
        this.f3563h = str2;
        this.i = bArr;
        this.f3564j = bArr2;
    }

    public final String a(String str) {
        String str2 = (String) this.f3561f.get(str);
        return str2 == null ? "" : str2;
    }

    public final int b(String str) {
        String str2 = (String) this.f3561f.get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public final h c() {
        h hVar = new h();
        String str = this.f3557a;
        if (str == null) {
            throw new NullPointerException("Null transportName");
        }
        hVar.f3549a = str;
        hVar.f3550b = this.f3558b;
        hVar.f3554g = this.f3562g;
        hVar.f3555h = this.f3563h;
        hVar.i = this.i;
        hVar.f3556j = this.f3564j;
        l lVar = this.f3559c;
        if (lVar == null) {
            throw new NullPointerException("Null encodedPayload");
        }
        hVar.f3551c = lVar;
        hVar.f3552d = Long.valueOf(this.f3560d);
        hVar.e = Long.valueOf(this.e);
        hVar.f3553f = new HashMap(this.f3561f);
        return hVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (!this.f3557a.equals(iVar.f3557a)) {
            return false;
        }
        Integer num = iVar.f3558b;
        Integer num2 = this.f3558b;
        if (num2 == null) {
            if (num != null) {
                return false;
            }
        } else if (!num2.equals(num)) {
            return false;
        }
        if (!this.f3559c.equals(iVar.f3559c) || this.f3560d != iVar.f3560d || this.e != iVar.e || !this.f3561f.equals(iVar.f3561f)) {
            return false;
        }
        Integer num3 = iVar.f3562g;
        Integer num4 = this.f3562g;
        if (num4 == null) {
            if (num3 != null) {
                return false;
            }
        } else if (!num4.equals(num3)) {
            return false;
        }
        String str = iVar.f3563h;
        String str2 = this.f3563h;
        if (str2 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str2.equals(str)) {
            return false;
        }
        return Arrays.equals(this.i, iVar.i) && Arrays.equals(this.f3564j, iVar.f3564j);
    }

    public final int hashCode() {
        int iHashCode = (this.f3557a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f3558b;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f3559c.hashCode()) * 1000003;
        long j4 = this.f3560d;
        int i = (iHashCode2 ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003;
        long j6 = this.e;
        int iHashCode3 = (((i ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003) ^ this.f3561f.hashCode()) * 1000003;
        Integer num2 = this.f3562g;
        int iHashCode4 = (iHashCode3 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        String str = this.f3563h;
        return ((((iHashCode4 ^ (str != null ? str.hashCode() : 0)) * 1000003) ^ Arrays.hashCode(this.i)) * 1000003) ^ Arrays.hashCode(this.f3564j);
    }

    public final String toString() {
        return "EventInternal{transportName=" + this.f3557a + ", code=" + this.f3558b + ", encodedPayload=" + this.f3559c + ", eventMillis=" + this.f3560d + ", uptimeMillis=" + this.e + ", autoMetadata=" + this.f3561f + ", productId=" + this.f3562g + ", pseudonymousId=" + this.f3563h + ", experimentIdsClear=" + Arrays.toString(this.i) + ", experimentIdsEncrypted=" + Arrays.toString(this.f3564j) + "}";
    }
}
