package q2;

import s3.AbstractC1024h;

/* JADX INFO: renamed from: q2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0924c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9168c;

    public C0924c(String str, String str2, String str3) {
        if (str == null) {
            throw new NullPointerException("Null crashlyticsInstallId");
        }
        this.f9166a = str;
        this.f9167b = str2;
        this.f9168c = str3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0924c) {
            C0924c c0924c = (C0924c) obj;
            if (this.f9166a.equals(c0924c.f9166a)) {
                String str = c0924c.f9167b;
                String str2 = this.f9167b;
                if (str2 != null ? str2.equals(str) : str == null) {
                    String str3 = c0924c.f9168c;
                    String str4 = this.f9168c;
                    if (str4 != null ? str4.equals(str3) : str3 == null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f9166a.hashCode() ^ 1000003) * 1000003;
        String str = this.f9167b;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f9168c;
        return iHashCode2 ^ (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("InstallIds{crashlyticsInstallId=");
        sb.append(this.f9166a);
        sb.append(", firebaseInstallationId=");
        sb.append(this.f9167b);
        sb.append(", firebaseAuthenticationToken=");
        return AbstractC1024h.d(sb, this.f9168c, "}");
    }
}
