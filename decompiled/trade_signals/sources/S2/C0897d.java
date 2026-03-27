package S2;

import S2.K;

/* JADX INFO: renamed from: S2.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0897d extends K.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f7529c;

    public C0897d(String str, String str2, String str3) {
        if (str == null) {
            throw new NullPointerException("Null crashlyticsInstallId");
        }
        this.f7527a = str;
        this.f7528b = str2;
        this.f7529c = str3;
    }

    @Override // S2.K.a
    public String c() {
        return this.f7527a;
    }

    @Override // S2.K.a
    public String d() {
        return this.f7529c;
    }

    @Override // S2.K.a
    public String e() {
        return this.f7528b;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof K.a)) {
            return false;
        }
        K.a aVar = (K.a) obj;
        if (this.f7527a.equals(aVar.c()) && ((str = this.f7528b) != null ? str.equals(aVar.e()) : aVar.e() == null)) {
            String str2 = this.f7529c;
            String strD = aVar.d();
            if (str2 == null) {
                if (strD == null) {
                    return true;
                }
            } else if (str2.equals(strD)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.f7527a.hashCode() ^ 1000003) * 1000003;
        String str = this.f7528b;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f7529c;
        return iHashCode2 ^ (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "InstallIds{crashlyticsInstallId=" + this.f7527a + ", firebaseInstallationId=" + this.f7528b + ", firebaseAuthenticationToken=" + this.f7529c + "}";
    }
}
