package u7;

import u7.i0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends i0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22237c;

    public c(String str, String str2, String str3) {
        if (str == null) {
            throw new NullPointerException("Null crashlyticsInstallId");
        }
        this.f22235a = str;
        this.f22236b = str2;
        this.f22237c = str3;
    }

    @Override // u7.i0.a
    public String c() {
        return this.f22235a;
    }

    @Override // u7.i0.a
    public String d() {
        return this.f22237c;
    }

    @Override // u7.i0.a
    public String e() {
        return this.f22236b;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof i0.a) {
            i0.a aVar = (i0.a) obj;
            if (this.f22235a.equals(aVar.c()) && ((str = this.f22236b) != null ? str.equals(aVar.e()) : aVar.e() == null) && ((str2 = this.f22237c) != null ? str2.equals(aVar.d()) : aVar.d() == null)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.f22235a.hashCode() ^ 1000003) * 1000003;
        String str = this.f22236b;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f22237c;
        return iHashCode2 ^ (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "InstallIds{crashlyticsInstallId=" + this.f22235a + ", firebaseInstallationId=" + this.f22236b + ", firebaseAuthenticationToken=" + this.f22237c + "}";
    }
}
