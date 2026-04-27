package t2;

import s3.AbstractC1024h;

/* JADX INFO: renamed from: t2.K, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1123K extends v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f9983d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f9984f;

    public C1123K(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f9980a = str;
        this.f9981b = str2;
        this.f9982c = str3;
        this.f9983d = str4;
        this.e = str5;
        this.f9984f = str6;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v0) {
            v0 v0Var = (v0) obj;
            if (this.f9980a.equals(((C1123K) v0Var).f9980a)) {
                C1123K c1123k = (C1123K) v0Var;
                if (this.f9981b.equals(c1123k.f9981b)) {
                    String str = c1123k.f9982c;
                    String str2 = this.f9982c;
                    if (str2 != null ? str2.equals(str) : str == null) {
                        String str3 = c1123k.f9983d;
                        String str4 = this.f9983d;
                        if (str4 != null ? str4.equals(str3) : str3 == null) {
                            String str5 = c1123k.e;
                            String str6 = this.e;
                            if (str6 != null ? str6.equals(str5) : str5 == null) {
                                String str7 = c1123k.f9984f;
                                String str8 = this.f9984f;
                                if (str8 != null ? str8.equals(str7) : str7 == null) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((this.f9980a.hashCode() ^ 1000003) * 1000003) ^ this.f9981b.hashCode()) * 1000003;
        String str = this.f9982c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * (-721379959);
        String str2 = this.f9983d;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.e;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f9984f;
        return iHashCode4 ^ (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Application{identifier=");
        sb.append(this.f9980a);
        sb.append(", version=");
        sb.append(this.f9981b);
        sb.append(", displayVersion=");
        sb.append(this.f9982c);
        sb.append(", organization=null, installationUuid=");
        sb.append(this.f9983d);
        sb.append(", developmentPlatform=");
        sb.append(this.e);
        sb.append(", developmentPlatformVersion=");
        return AbstractC1024h.d(sb, this.f9984f, "}");
    }
}
