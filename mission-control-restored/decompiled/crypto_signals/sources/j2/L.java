package j2;

import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
public final class L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f7652c;

    public L(String str, String str2, String str3) {
        this.f7650a = str;
        this.f7651b = str2;
        this.f7652c = str3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof L) {
            L l6 = (L) obj;
            String str = this.f7650a;
            if (str != null ? str.equals(l6.f7650a) : l6.f7650a == null) {
                String str2 = this.f7651b;
                if (str2 != null ? str2.equals(l6.f7651b) : l6.f7651b == null) {
                    String str3 = this.f7652c;
                    if (str3 != null ? str3.equals(l6.f7652c) : l6.f7652c == null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f7650a;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f7651b;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f7652c;
        return (str3 != null ? str3.hashCode() : 0) ^ iHashCode2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AttestationResult{recaptchaV2Token=");
        sb.append(this.f7650a);
        sb.append(", playIntegrityToken=");
        sb.append(this.f7651b);
        sb.append(", recaptchaEnterpriseToken=");
        return AbstractC1024h.d(sb, this.f7652c, "}");
    }
}
