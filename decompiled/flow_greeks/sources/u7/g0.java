package u7;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22272b;

    public g0(String str, String str2) {
        this.f22271a = str;
        this.f22272b = str2;
    }

    public final String a() {
        return this.f22272b;
    }

    public final String b() {
        return this.f22271a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return kotlin.jvm.internal.t.b(this.f22271a, g0Var.f22271a) && kotlin.jvm.internal.t.b(this.f22272b, g0Var.f22272b);
    }

    public int hashCode() {
        String str = this.f22271a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f22272b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "FirebaseInstallationId(fid=" + this.f22271a + ", authToken=" + this.f22272b + ')';
    }
}
