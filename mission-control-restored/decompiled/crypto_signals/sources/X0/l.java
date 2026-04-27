package X0;

import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
public final class l extends AbstractC0248a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f3476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3479d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f3480f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f3481g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f3482h;
    public final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f3483j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f3484k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f3485l;

    public l(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f3476a = num;
        this.f3477b = str;
        this.f3478c = str2;
        this.f3479d = str3;
        this.e = str4;
        this.f3480f = str5;
        this.f3481g = str6;
        this.f3482h = str7;
        this.i = str8;
        this.f3483j = str9;
        this.f3484k = str10;
        this.f3485l = str11;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC0248a) {
            AbstractC0248a abstractC0248a = (AbstractC0248a) obj;
            Integer num = this.f3476a;
            if (num != null ? num.equals(((l) abstractC0248a).f3476a) : ((l) abstractC0248a).f3476a == null) {
                String str = this.f3477b;
                if (str != null ? str.equals(((l) abstractC0248a).f3477b) : ((l) abstractC0248a).f3477b == null) {
                    String str2 = this.f3478c;
                    if (str2 != null ? str2.equals(((l) abstractC0248a).f3478c) : ((l) abstractC0248a).f3478c == null) {
                        String str3 = this.f3479d;
                        if (str3 != null ? str3.equals(((l) abstractC0248a).f3479d) : ((l) abstractC0248a).f3479d == null) {
                            String str4 = this.e;
                            if (str4 != null ? str4.equals(((l) abstractC0248a).e) : ((l) abstractC0248a).e == null) {
                                String str5 = this.f3480f;
                                if (str5 != null ? str5.equals(((l) abstractC0248a).f3480f) : ((l) abstractC0248a).f3480f == null) {
                                    String str6 = this.f3481g;
                                    if (str6 != null ? str6.equals(((l) abstractC0248a).f3481g) : ((l) abstractC0248a).f3481g == null) {
                                        String str7 = this.f3482h;
                                        if (str7 != null ? str7.equals(((l) abstractC0248a).f3482h) : ((l) abstractC0248a).f3482h == null) {
                                            String str8 = this.i;
                                            if (str8 != null ? str8.equals(((l) abstractC0248a).i) : ((l) abstractC0248a).i == null) {
                                                String str9 = this.f3483j;
                                                if (str9 != null ? str9.equals(((l) abstractC0248a).f3483j) : ((l) abstractC0248a).f3483j == null) {
                                                    String str10 = this.f3484k;
                                                    if (str10 != null ? str10.equals(((l) abstractC0248a).f3484k) : ((l) abstractC0248a).f3484k == null) {
                                                        String str11 = this.f3485l;
                                                        if (str11 != null ? str11.equals(((l) abstractC0248a).f3485l) : ((l) abstractC0248a).f3485l == null) {
                                                            return true;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
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
        Integer num = this.f3476a;
        int iHashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.f3477b;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f3478c;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f3479d;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.e;
        int iHashCode5 = (iHashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f3480f;
        int iHashCode6 = (iHashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.f3481g;
        int iHashCode7 = (iHashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.f3482h;
        int iHashCode8 = (iHashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.i;
        int iHashCode9 = (iHashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.f3483j;
        int iHashCode10 = (iHashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.f3484k;
        int iHashCode11 = (iHashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.f3485l;
        return (str11 != null ? str11.hashCode() : 0) ^ iHashCode11;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AndroidClientInfo{sdkVersion=");
        sb.append(this.f3476a);
        sb.append(", model=");
        sb.append(this.f3477b);
        sb.append(", hardware=");
        sb.append(this.f3478c);
        sb.append(", device=");
        sb.append(this.f3479d);
        sb.append(", product=");
        sb.append(this.e);
        sb.append(", osBuild=");
        sb.append(this.f3480f);
        sb.append(", manufacturer=");
        sb.append(this.f3481g);
        sb.append(", fingerprint=");
        sb.append(this.f3482h);
        sb.append(", locale=");
        sb.append(this.i);
        sb.append(", country=");
        sb.append(this.f3483j);
        sb.append(", mccMnc=");
        sb.append(this.f3484k);
        sb.append(", applicationBuild=");
        return AbstractC1024h.d(sb, this.f3485l, "}");
    }
}
