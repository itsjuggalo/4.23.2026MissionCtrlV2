package Z3;

import java.util.List;

/* JADX INFO: renamed from: Z3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0781a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f5879d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s f5880e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f5881f;

    public C0781a(String packageName, String versionName, String appBuildVersion, String deviceManufacturer, s currentProcessDetails, List appProcessDetails) {
        kotlin.jvm.internal.r.f(packageName, "packageName");
        kotlin.jvm.internal.r.f(versionName, "versionName");
        kotlin.jvm.internal.r.f(appBuildVersion, "appBuildVersion");
        kotlin.jvm.internal.r.f(deviceManufacturer, "deviceManufacturer");
        kotlin.jvm.internal.r.f(currentProcessDetails, "currentProcessDetails");
        kotlin.jvm.internal.r.f(appProcessDetails, "appProcessDetails");
        this.f5876a = packageName;
        this.f5877b = versionName;
        this.f5878c = appBuildVersion;
        this.f5879d = deviceManufacturer;
        this.f5880e = currentProcessDetails;
        this.f5881f = appProcessDetails;
    }

    public final String a() {
        return this.f5878c;
    }

    public final List b() {
        return this.f5881f;
    }

    public final s c() {
        return this.f5880e;
    }

    public final String d() {
        return this.f5879d;
    }

    public final String e() {
        return this.f5876a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0781a)) {
            return false;
        }
        C0781a c0781a = (C0781a) obj;
        return kotlin.jvm.internal.r.b(this.f5876a, c0781a.f5876a) && kotlin.jvm.internal.r.b(this.f5877b, c0781a.f5877b) && kotlin.jvm.internal.r.b(this.f5878c, c0781a.f5878c) && kotlin.jvm.internal.r.b(this.f5879d, c0781a.f5879d) && kotlin.jvm.internal.r.b(this.f5880e, c0781a.f5880e) && kotlin.jvm.internal.r.b(this.f5881f, c0781a.f5881f);
    }

    public final String f() {
        return this.f5877b;
    }

    public int hashCode() {
        return (((((((((this.f5876a.hashCode() * 31) + this.f5877b.hashCode()) * 31) + this.f5878c.hashCode()) * 31) + this.f5879d.hashCode()) * 31) + this.f5880e.hashCode()) * 31) + this.f5881f.hashCode();
    }

    public String toString() {
        return "AndroidApplicationInfo(packageName=" + this.f5876a + ", versionName=" + this.f5877b + ", appBuildVersion=" + this.f5878c + ", deviceManufacturer=" + this.f5879d + ", currentProcessDetails=" + this.f5880e + ", appProcessDetails=" + this.f5881f + ')';
    }
}
