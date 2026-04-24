package t2;

/* JADX INFO: renamed from: t2.m0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1163m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f10166d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final io.flutter.plugin.platform.p f10167f;

    public C1163m0(String str, String str2, String str3, String str4, int i, io.flutter.plugin.platform.p pVar) {
        if (str == null) {
            throw new NullPointerException("Null appIdentifier");
        }
        this.f10163a = str;
        if (str2 == null) {
            throw new NullPointerException("Null versionCode");
        }
        this.f10164b = str2;
        if (str3 == null) {
            throw new NullPointerException("Null versionName");
        }
        this.f10165c = str3;
        if (str4 == null) {
            throw new NullPointerException("Null installUuid");
        }
        this.f10166d = str4;
        this.e = i;
        this.f10167f = pVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1163m0)) {
            return false;
        }
        C1163m0 c1163m0 = (C1163m0) obj;
        return this.f10163a.equals(c1163m0.f10163a) && this.f10164b.equals(c1163m0.f10164b) && this.f10165c.equals(c1163m0.f10165c) && this.f10166d.equals(c1163m0.f10166d) && this.e == c1163m0.e && this.f10167f.equals(c1163m0.f10167f);
    }

    public final int hashCode() {
        return ((((((((((this.f10163a.hashCode() ^ 1000003) * 1000003) ^ this.f10164b.hashCode()) * 1000003) ^ this.f10165c.hashCode()) * 1000003) ^ this.f10166d.hashCode()) * 1000003) ^ this.e) * 1000003) ^ this.f10167f.hashCode();
    }

    public final String toString() {
        return "AppData{appIdentifier=" + this.f10163a + ", versionCode=" + this.f10164b + ", versionName=" + this.f10165c + ", installUuid=" + this.f10166d + ", deliveryMechanism=" + this.e + ", developmentPlatformProvider=" + this.f10167f + "}";
    }
}
