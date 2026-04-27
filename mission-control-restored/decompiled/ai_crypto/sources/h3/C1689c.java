package h3;

import h3.InterfaceC1684O;

/* JADX INFO: renamed from: h3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1689c extends InterfaceC1684O.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f14802c;

    public C1689c(String str, String str2, String str3) {
        if (str == null) {
            throw new NullPointerException("Null crashlyticsInstallId");
        }
        this.f14800a = str;
        this.f14801b = str2;
        this.f14802c = str3;
    }

    @Override // h3.InterfaceC1684O.a
    public String c() {
        return this.f14800a;
    }

    @Override // h3.InterfaceC1684O.a
    public String d() {
        return this.f14802c;
    }

    @Override // h3.InterfaceC1684O.a
    public String e() {
        return this.f14801b;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InterfaceC1684O.a)) {
            return false;
        }
        InterfaceC1684O.a aVar = (InterfaceC1684O.a) obj;
        if (this.f14800a.equals(aVar.c()) && ((str = this.f14801b) != null ? str.equals(aVar.e()) : aVar.e() == null)) {
            String str2 = this.f14802c;
            if (str2 == null) {
                if (aVar.d() == null) {
                    return true;
                }
            } else if (str2.equals(aVar.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.f14800a.hashCode() ^ 1000003) * 1000003;
        String str = this.f14801b;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f14802c;
        return iHashCode2 ^ (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "InstallIds{crashlyticsInstallId=" + this.f14800a + ", firebaseInstallationId=" + this.f14801b + ", firebaseAuthenticationToken=" + this.f14802c + "}";
    }
}
