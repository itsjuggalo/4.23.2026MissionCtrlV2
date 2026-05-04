package ua;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f22502d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c0 f22503e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f22504f;

    public a(String packageName, String versionName, String appBuildVersion, String deviceManufacturer, c0 currentProcessDetails, List appProcessDetails) {
        kotlin.jvm.internal.t.f(packageName, "packageName");
        kotlin.jvm.internal.t.f(versionName, "versionName");
        kotlin.jvm.internal.t.f(appBuildVersion, "appBuildVersion");
        kotlin.jvm.internal.t.f(deviceManufacturer, "deviceManufacturer");
        kotlin.jvm.internal.t.f(currentProcessDetails, "currentProcessDetails");
        kotlin.jvm.internal.t.f(appProcessDetails, "appProcessDetails");
        this.f22499a = packageName;
        this.f22500b = versionName;
        this.f22501c = appBuildVersion;
        this.f22502d = deviceManufacturer;
        this.f22503e = currentProcessDetails;
        this.f22504f = appProcessDetails;
    }

    public final String a() {
        return this.f22501c;
    }

    public final List b() {
        return this.f22504f;
    }

    public final c0 c() {
        return this.f22503e;
    }

    public final String d() {
        return this.f22502d;
    }

    public final String e() {
        return this.f22499a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return kotlin.jvm.internal.t.b(this.f22499a, aVar.f22499a) && kotlin.jvm.internal.t.b(this.f22500b, aVar.f22500b) && kotlin.jvm.internal.t.b(this.f22501c, aVar.f22501c) && kotlin.jvm.internal.t.b(this.f22502d, aVar.f22502d) && kotlin.jvm.internal.t.b(this.f22503e, aVar.f22503e) && kotlin.jvm.internal.t.b(this.f22504f, aVar.f22504f);
    }

    public final String f() {
        return this.f22500b;
    }

    public int hashCode() {
        return (((((((((this.f22499a.hashCode() * 31) + this.f22500b.hashCode()) * 31) + this.f22501c.hashCode()) * 31) + this.f22502d.hashCode()) * 31) + this.f22503e.hashCode()) * 31) + this.f22504f.hashCode();
    }

    public String toString() {
        return "AndroidApplicationInfo(packageName=" + this.f22499a + ", versionName=" + this.f22500b + ", appBuildVersion=" + this.f22501c + ", deviceManufacturer=" + this.f22502d + ", currentProcessDetails=" + this.f22503e + ", appProcessDetails=" + this.f22504f + ')';
    }
}
