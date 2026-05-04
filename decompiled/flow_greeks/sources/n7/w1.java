package n7;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class w1 extends s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16872c;

    @Override // n7.s1
    public final String b() {
        return this.f16871b;
    }

    @Override // n7.s1
    public final String c() {
        return this.f16872c;
    }

    @Override // n7.s1
    public final String d() {
        return this.f16870a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof s1) {
            s1 s1Var = (s1) obj;
            String str = this.f16870a;
            if (str != null ? str.equals(s1Var.d()) : s1Var.d() == null) {
                String str2 = this.f16871b;
                if (str2 != null ? str2.equals(s1Var.b()) : s1Var.b() == null) {
                    String str3 = this.f16872c;
                    if (str3 != null ? str3.equals(s1Var.c()) : s1Var.c() == null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f16870a;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f16871b;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f16872c;
        return iHashCode2 ^ (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        return "AttestationResult{recaptchaV2Token=" + this.f16870a + ", playIntegrityToken=" + this.f16871b + ", recaptchaEnterpriseToken=" + this.f16872c + "}";
    }

    public w1(String str, String str2, String str3) {
        this.f16870a = str;
        this.f16871b = str2;
        this.f16872c = str3;
    }
}
