package k3;

import e3.C1477f;
import k3.AbstractC2075G;

/* JADX INFO: renamed from: k3.C, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2071C extends AbstractC2075G.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f17582d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f17583e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C1477f f17584f;

    public C2071C(String str, String str2, String str3, String str4, int i7, C1477f c1477f) {
        if (str == null) {
            throw new NullPointerException("Null appIdentifier");
        }
        this.f17579a = str;
        if (str2 == null) {
            throw new NullPointerException("Null versionCode");
        }
        this.f17580b = str2;
        if (str3 == null) {
            throw new NullPointerException("Null versionName");
        }
        this.f17581c = str3;
        if (str4 == null) {
            throw new NullPointerException("Null installUuid");
        }
        this.f17582d = str4;
        this.f17583e = i7;
        if (c1477f == null) {
            throw new NullPointerException("Null developmentPlatformProvider");
        }
        this.f17584f = c1477f;
    }

    @Override // k3.AbstractC2075G.a
    public String a() {
        return this.f17579a;
    }

    @Override // k3.AbstractC2075G.a
    public int c() {
        return this.f17583e;
    }

    @Override // k3.AbstractC2075G.a
    public C1477f d() {
        return this.f17584f;
    }

    @Override // k3.AbstractC2075G.a
    public String e() {
        return this.f17582d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2075G.a)) {
            return false;
        }
        AbstractC2075G.a aVar = (AbstractC2075G.a) obj;
        return this.f17579a.equals(aVar.a()) && this.f17580b.equals(aVar.f()) && this.f17581c.equals(aVar.g()) && this.f17582d.equals(aVar.e()) && this.f17583e == aVar.c() && this.f17584f.equals(aVar.d());
    }

    @Override // k3.AbstractC2075G.a
    public String f() {
        return this.f17580b;
    }

    @Override // k3.AbstractC2075G.a
    public String g() {
        return this.f17581c;
    }

    public int hashCode() {
        return ((((((((((this.f17579a.hashCode() ^ 1000003) * 1000003) ^ this.f17580b.hashCode()) * 1000003) ^ this.f17581c.hashCode()) * 1000003) ^ this.f17582d.hashCode()) * 1000003) ^ this.f17583e) * 1000003) ^ this.f17584f.hashCode();
    }

    public String toString() {
        return "AppData{appIdentifier=" + this.f17579a + ", versionCode=" + this.f17580b + ", versionName=" + this.f17581c + ", installUuid=" + this.f17582d + ", deliveryMechanism=" + this.f17583e + ", developmentPlatformProvider=" + this.f17584f + "}";
    }
}
