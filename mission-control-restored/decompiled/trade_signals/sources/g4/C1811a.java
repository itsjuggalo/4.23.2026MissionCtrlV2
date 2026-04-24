package g4;

import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: g4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1811a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f18131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f18132d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C1788C f18133e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f18134f;

    public C1811a(String packageName, String versionName, String appBuildVersion, String deviceManufacturer, C1788C currentProcessDetails, List appProcessDetails) {
        AbstractC2304t.f(packageName, "packageName");
        AbstractC2304t.f(versionName, "versionName");
        AbstractC2304t.f(appBuildVersion, "appBuildVersion");
        AbstractC2304t.f(deviceManufacturer, "deviceManufacturer");
        AbstractC2304t.f(currentProcessDetails, "currentProcessDetails");
        AbstractC2304t.f(appProcessDetails, "appProcessDetails");
        this.f18129a = packageName;
        this.f18130b = versionName;
        this.f18131c = appBuildVersion;
        this.f18132d = deviceManufacturer;
        this.f18133e = currentProcessDetails;
        this.f18134f = appProcessDetails;
    }

    public final String a() {
        return this.f18131c;
    }

    public final List b() {
        return this.f18134f;
    }

    public final C1788C c() {
        return this.f18133e;
    }

    public final String d() {
        return this.f18132d;
    }

    public final String e() {
        return this.f18129a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1811a)) {
            return false;
        }
        C1811a c1811a = (C1811a) obj;
        return AbstractC2304t.b(this.f18129a, c1811a.f18129a) && AbstractC2304t.b(this.f18130b, c1811a.f18130b) && AbstractC2304t.b(this.f18131c, c1811a.f18131c) && AbstractC2304t.b(this.f18132d, c1811a.f18132d) && AbstractC2304t.b(this.f18133e, c1811a.f18133e) && AbstractC2304t.b(this.f18134f, c1811a.f18134f);
    }

    public final String f() {
        return this.f18130b;
    }

    public int hashCode() {
        return (((((((((this.f18129a.hashCode() * 31) + this.f18130b.hashCode()) * 31) + this.f18131c.hashCode()) * 31) + this.f18132d.hashCode()) * 31) + this.f18133e.hashCode()) * 31) + this.f18134f.hashCode();
    }

    public String toString() {
        return "AndroidApplicationInfo(packageName=" + this.f18129a + ", versionName=" + this.f18130b + ", appBuildVersion=" + this.f18131c + ", deviceManufacturer=" + this.f18132d + ", currentProcessDetails=" + this.f18133e + ", appProcessDetails=" + this.f18134f + ')';
    }
}
