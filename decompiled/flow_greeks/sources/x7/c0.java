package x7;

import x7.g0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 extends g0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f24450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f24451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f24452d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f24453e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r7.f f24454f;

    public c0(String str, String str2, String str3, String str4, int i10, r7.f fVar) {
        if (str == null) {
            throw new NullPointerException("Null appIdentifier");
        }
        this.f24449a = str;
        if (str2 == null) {
            throw new NullPointerException("Null versionCode");
        }
        this.f24450b = str2;
        if (str3 == null) {
            throw new NullPointerException("Null versionName");
        }
        this.f24451c = str3;
        if (str4 == null) {
            throw new NullPointerException("Null installUuid");
        }
        this.f24452d = str4;
        this.f24453e = i10;
        if (fVar == null) {
            throw new NullPointerException("Null developmentPlatformProvider");
        }
        this.f24454f = fVar;
    }

    @Override // x7.g0.a
    public String a() {
        return this.f24449a;
    }

    @Override // x7.g0.a
    public int c() {
        return this.f24453e;
    }

    @Override // x7.g0.a
    public r7.f d() {
        return this.f24454f;
    }

    @Override // x7.g0.a
    public String e() {
        return this.f24452d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g0.a) {
            g0.a aVar = (g0.a) obj;
            if (this.f24449a.equals(aVar.a()) && this.f24450b.equals(aVar.f()) && this.f24451c.equals(aVar.g()) && this.f24452d.equals(aVar.e()) && this.f24453e == aVar.c() && this.f24454f.equals(aVar.d())) {
                return true;
            }
        }
        return false;
    }

    @Override // x7.g0.a
    public String f() {
        return this.f24450b;
    }

    @Override // x7.g0.a
    public String g() {
        return this.f24451c;
    }

    public int hashCode() {
        return ((((((((((this.f24449a.hashCode() ^ 1000003) * 1000003) ^ this.f24450b.hashCode()) * 1000003) ^ this.f24451c.hashCode()) * 1000003) ^ this.f24452d.hashCode()) * 1000003) ^ this.f24453e) * 1000003) ^ this.f24454f.hashCode();
    }

    public String toString() {
        return "AppData{appIdentifier=" + this.f24449a + ", versionCode=" + this.f24450b + ", versionName=" + this.f24451c + ", installUuid=" + this.f24452d + ", deliveryMechanism=" + this.f24453e + ", developmentPlatformProvider=" + this.f24454f + "}";
    }
}
