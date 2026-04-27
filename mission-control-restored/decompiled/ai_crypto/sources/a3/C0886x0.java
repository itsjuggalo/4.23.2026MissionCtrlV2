package a3;

/* JADX INFO: renamed from: a3.x0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0886x0 extends AbstractC0878t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6293c;

    @Override // a3.AbstractC0878t0
    public final String b() {
        return this.f6292b;
    }

    @Override // a3.AbstractC0878t0
    public final String c() {
        return this.f6293c;
    }

    @Override // a3.AbstractC0878t0
    public final String d() {
        return this.f6291a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC0878t0) {
            AbstractC0878t0 abstractC0878t0 = (AbstractC0878t0) obj;
            String str = this.f6291a;
            if (str != null ? str.equals(abstractC0878t0.d()) : abstractC0878t0.d() == null) {
                String str2 = this.f6292b;
                if (str2 != null ? str2.equals(abstractC0878t0.b()) : abstractC0878t0.b() == null) {
                    String str3 = this.f6293c;
                    if (str3 != null ? str3.equals(abstractC0878t0.c()) : abstractC0878t0.c() == null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f6291a;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f6292b;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f6293c;
        return iHashCode2 ^ (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        return "AttestationResult{recaptchaV2Token=" + this.f6291a + ", playIntegrityToken=" + this.f6292b + ", recaptchaEnterpriseToken=" + this.f6293c + "}";
    }

    public C0886x0(String str, String str2, String str3) {
        this.f6291a = str;
        this.f6292b = str2;
        this.f6293c = str3;
    }
}
