package Z2;

import S.i;
import a3.d;
import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f3991h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3995d;
    public final long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f3996f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f3997g;

    static {
        byte b3 = (byte) (((byte) (0 | 2)) | 1);
        if (b3 == 3) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        if ((b3 & 1) == 0) {
            sb.append(" expiresInSecs");
        }
        if ((b3 & 2) == 0) {
            sb.append(" tokenCreationEpochInSecs");
        }
        throw new IllegalStateException(d.l("Missing required properties:", sb));
    }

    public b(String str, int i, String str2, String str3, long j4, long j6, String str4) {
        this.f3992a = str;
        this.f3993b = i;
        this.f3994c = str2;
        this.f3995d = str3;
        this.e = j4;
        this.f3996f = j6;
        this.f3997g = str4;
    }

    public final a a() {
        a aVar = new a();
        aVar.f3984a = this.f3992a;
        aVar.f3985b = this.f3993b;
        aVar.f3986c = this.f3994c;
        aVar.f3987d = this.f3995d;
        aVar.e = this.e;
        aVar.f3988f = this.f3996f;
        aVar.f3989g = this.f3997g;
        aVar.f3990h = (byte) 3;
        return aVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        String str = this.f3992a;
        if (str == null) {
            if (bVar.f3992a != null) {
                return false;
            }
        } else if (!str.equals(bVar.f3992a)) {
            return false;
        }
        if (!i.b(this.f3993b, bVar.f3993b)) {
            return false;
        }
        String str2 = bVar.f3994c;
        String str3 = this.f3994c;
        if (str3 == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str3.equals(str2)) {
            return false;
        }
        String str4 = bVar.f3995d;
        String str5 = this.f3995d;
        if (str5 == null) {
            if (str4 != null) {
                return false;
            }
        } else if (!str5.equals(str4)) {
            return false;
        }
        if (this.e != bVar.e || this.f3996f != bVar.f3996f) {
            return false;
        }
        String str6 = bVar.f3997g;
        String str7 = this.f3997g;
        return str7 == null ? str6 == null : str7.equals(str6);
    }

    public final int hashCode() {
        String str = this.f3992a;
        int iHashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ i.c(this.f3993b)) * 1000003;
        String str2 = this.f3994c;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f3995d;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        long j4 = this.e;
        int i = (iHashCode3 ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003;
        long j6 = this.f3996f;
        int i6 = (i ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003;
        String str4 = this.f3997g;
        return (str4 != null ? str4.hashCode() : 0) ^ i6;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PersistedInstallationEntry{firebaseInstallationId=");
        sb.append(this.f3992a);
        sb.append(", registrationStatus=");
        int i = this.f3993b;
        sb.append(i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "null" : "REGISTER_ERROR" : "REGISTERED" : "UNREGISTERED" : "NOT_GENERATED" : "ATTEMPT_MIGRATION");
        sb.append(", authToken=");
        sb.append(this.f3994c);
        sb.append(", refreshToken=");
        sb.append(this.f3995d);
        sb.append(", expiresInSecs=");
        sb.append(this.e);
        sb.append(", tokenCreationEpochInSecs=");
        sb.append(this.f3996f);
        sb.append(", fisError=");
        return AbstractC1024h.d(sb, this.f3997g, "}");
    }
}
