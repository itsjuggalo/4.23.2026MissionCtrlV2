package V2;

import V2.G;

/* JADX INFO: loaded from: classes.dex */
public final class C extends G.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f8503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f8504e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final P2.f f8505f;

    public C(String str, String str2, String str3, String str4, int i8, P2.f fVar) {
        if (str == null) {
            throw new NullPointerException("Null appIdentifier");
        }
        this.f8500a = str;
        if (str2 == null) {
            throw new NullPointerException("Null versionCode");
        }
        this.f8501b = str2;
        if (str3 == null) {
            throw new NullPointerException("Null versionName");
        }
        this.f8502c = str3;
        if (str4 == null) {
            throw new NullPointerException("Null installUuid");
        }
        this.f8503d = str4;
        this.f8504e = i8;
        if (fVar == null) {
            throw new NullPointerException("Null developmentPlatformProvider");
        }
        this.f8505f = fVar;
    }

    @Override // V2.G.a
    public String a() {
        return this.f8500a;
    }

    @Override // V2.G.a
    public int c() {
        return this.f8504e;
    }

    @Override // V2.G.a
    public P2.f d() {
        return this.f8505f;
    }

    @Override // V2.G.a
    public String e() {
        return this.f8503d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof G.a)) {
            return false;
        }
        G.a aVar = (G.a) obj;
        return this.f8500a.equals(aVar.a()) && this.f8501b.equals(aVar.f()) && this.f8502c.equals(aVar.g()) && this.f8503d.equals(aVar.e()) && this.f8504e == aVar.c() && this.f8505f.equals(aVar.d());
    }

    @Override // V2.G.a
    public String f() {
        return this.f8501b;
    }

    @Override // V2.G.a
    public String g() {
        return this.f8502c;
    }

    public int hashCode() {
        return ((((((((((this.f8500a.hashCode() ^ 1000003) * 1000003) ^ this.f8501b.hashCode()) * 1000003) ^ this.f8502c.hashCode()) * 1000003) ^ this.f8503d.hashCode()) * 1000003) ^ this.f8504e) * 1000003) ^ this.f8505f.hashCode();
    }

    public String toString() {
        return "AppData{appIdentifier=" + this.f8500a + ", versionCode=" + this.f8501b + ", versionName=" + this.f8502c + ", installUuid=" + this.f8503d + ", deliveryMechanism=" + this.f8504e + ", developmentPlatformProvider=" + this.f8505f + "}";
    }
}
