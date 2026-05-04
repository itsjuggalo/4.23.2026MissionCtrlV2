package aa;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends g2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ga.m f422b;

    public e(String str, ga.m mVar) {
        if (str == null) {
            throw new NullPointerException("Null installationId");
        }
        this.f421a = str;
        if (mVar == null) {
            throw new NullPointerException("Null installationTokenResult");
        }
        this.f422b = mVar;
    }

    @Override // aa.g2
    public String b() {
        return this.f421a;
    }

    @Override // aa.g2
    public ga.m c() {
        return this.f422b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g2) {
            g2 g2Var = (g2) obj;
            if (this.f421a.equals(g2Var.b()) && this.f422b.equals(g2Var.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f421a.hashCode() ^ 1000003) * 1000003) ^ this.f422b.hashCode();
    }

    public String toString() {
        return "InstallationIdResult{installationId=" + this.f421a + ", installationTokenResult=" + this.f422b + "}";
    }
}
