package t2;

/* JADX INFO: renamed from: t2.B, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1114B extends O0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9927d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f9928f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f9929g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f9930h;
    public final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f9931j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C1122J f9932k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final C1119G f9933l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final C1116D f9934m;

    public C1114B(String str, String str2, int i, String str3, String str4, String str5, String str6, String str7, String str8, C1122J c1122j, C1119G c1119g, C1116D c1116d) {
        this.f9925b = str;
        this.f9926c = str2;
        this.f9927d = i;
        this.e = str3;
        this.f9928f = str4;
        this.f9929g = str5;
        this.f9930h = str6;
        this.i = str7;
        this.f9931j = str8;
        this.f9932k = c1122j;
        this.f9933l = c1119g;
        this.f9934m = c1116d;
    }

    public final C1113A a() {
        C1113A c1113a = new C1113A();
        c1113a.f9914a = this.f9925b;
        c1113a.f9915b = this.f9926c;
        c1113a.f9916c = this.f9927d;
        c1113a.f9917d = this.e;
        c1113a.e = this.f9928f;
        c1113a.f9918f = this.f9929g;
        c1113a.f9919g = this.f9930h;
        c1113a.f9920h = this.i;
        c1113a.i = this.f9931j;
        c1113a.f9921j = this.f9932k;
        c1113a.f9922k = this.f9933l;
        c1113a.f9923l = this.f9934m;
        c1113a.f9924m = (byte) 1;
        return c1113a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof O0)) {
            return false;
        }
        C1114B c1114b = (C1114B) ((O0) obj);
        if (!this.f9925b.equals(c1114b.f9925b)) {
            return false;
        }
        if (!this.f9926c.equals(c1114b.f9926c) || this.f9927d != c1114b.f9927d || !this.e.equals(c1114b.e)) {
            return false;
        }
        String str = c1114b.f9928f;
        String str2 = this.f9928f;
        if (str2 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str2.equals(str)) {
            return false;
        }
        String str3 = c1114b.f9929g;
        String str4 = this.f9929g;
        if (str4 == null) {
            if (str3 != null) {
                return false;
            }
        } else if (!str4.equals(str3)) {
            return false;
        }
        String str5 = c1114b.f9930h;
        String str6 = this.f9930h;
        if (str6 == null) {
            if (str5 != null) {
                return false;
            }
        } else if (!str6.equals(str5)) {
            return false;
        }
        if (!this.i.equals(c1114b.i) || !this.f9931j.equals(c1114b.f9931j)) {
            return false;
        }
        C1122J c1122j = c1114b.f9932k;
        C1122J c1122j2 = this.f9932k;
        if (c1122j2 == null) {
            if (c1122j != null) {
                return false;
            }
        } else if (!c1122j2.equals(c1122j)) {
            return false;
        }
        C1119G c1119g = c1114b.f9933l;
        C1119G c1119g2 = this.f9933l;
        if (c1119g2 == null) {
            if (c1119g != null) {
                return false;
            }
        } else if (!c1119g2.equals(c1119g)) {
            return false;
        }
        C1116D c1116d = c1114b.f9934m;
        C1116D c1116d2 = this.f9934m;
        return c1116d2 == null ? c1116d == null : c1116d2.equals(c1116d);
    }

    public final int hashCode() {
        int iHashCode = (((((((this.f9925b.hashCode() ^ 1000003) * 1000003) ^ this.f9926c.hashCode()) * 1000003) ^ this.f9927d) * 1000003) ^ this.e.hashCode()) * 1000003;
        String str = this.f9928f;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f9929g;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f9930h;
        int iHashCode4 = (((((iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003) ^ this.i.hashCode()) * 1000003) ^ this.f9931j.hashCode()) * 1000003;
        C1122J c1122j = this.f9932k;
        int iHashCode5 = (iHashCode4 ^ (c1122j == null ? 0 : c1122j.hashCode())) * 1000003;
        C1119G c1119g = this.f9933l;
        int iHashCode6 = (iHashCode5 ^ (c1119g == null ? 0 : c1119g.hashCode())) * 1000003;
        C1116D c1116d = this.f9934m;
        return iHashCode6 ^ (c1116d != null ? c1116d.hashCode() : 0);
    }

    public final String toString() {
        return "CrashlyticsReport{sdkVersion=" + this.f9925b + ", gmpAppId=" + this.f9926c + ", platform=" + this.f9927d + ", installationUuid=" + this.e + ", firebaseInstallationId=" + this.f9928f + ", firebaseAuthenticationToken=" + this.f9929g + ", appQualitySessionId=" + this.f9930h + ", buildVersion=" + this.i + ", displayVersion=" + this.f9931j + ", session=" + this.f9932k + ", ndkPayload=" + this.f9933l + ", appExitInfo=" + this.f9934m + "}";
    }
}
