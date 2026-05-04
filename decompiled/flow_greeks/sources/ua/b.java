package ua;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f22514d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u f22515e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f22516f;

    public b(String appId, String deviceModel, String sessionSdkVersion, String osVersion, u logEnvironment, a androidAppInfo) {
        kotlin.jvm.internal.t.f(appId, "appId");
        kotlin.jvm.internal.t.f(deviceModel, "deviceModel");
        kotlin.jvm.internal.t.f(sessionSdkVersion, "sessionSdkVersion");
        kotlin.jvm.internal.t.f(osVersion, "osVersion");
        kotlin.jvm.internal.t.f(logEnvironment, "logEnvironment");
        kotlin.jvm.internal.t.f(androidAppInfo, "androidAppInfo");
        this.f22511a = appId;
        this.f22512b = deviceModel;
        this.f22513c = sessionSdkVersion;
        this.f22514d = osVersion;
        this.f22515e = logEnvironment;
        this.f22516f = androidAppInfo;
    }

    public final a a() {
        return this.f22516f;
    }

    public final String b() {
        return this.f22511a;
    }

    public final String c() {
        return this.f22512b;
    }

    public final u d() {
        return this.f22515e;
    }

    public final String e() {
        return this.f22514d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return kotlin.jvm.internal.t.b(this.f22511a, bVar.f22511a) && kotlin.jvm.internal.t.b(this.f22512b, bVar.f22512b) && kotlin.jvm.internal.t.b(this.f22513c, bVar.f22513c) && kotlin.jvm.internal.t.b(this.f22514d, bVar.f22514d) && this.f22515e == bVar.f22515e && kotlin.jvm.internal.t.b(this.f22516f, bVar.f22516f);
    }

    public final String f() {
        return this.f22513c;
    }

    public int hashCode() {
        return (((((((((this.f22511a.hashCode() * 31) + this.f22512b.hashCode()) * 31) + this.f22513c.hashCode()) * 31) + this.f22514d.hashCode()) * 31) + this.f22515e.hashCode()) * 31) + this.f22516f.hashCode();
    }

    public String toString() {
        return "ApplicationInfo(appId=" + this.f22511a + ", deviceModel=" + this.f22512b + ", sessionSdkVersion=" + this.f22513c + ", osVersion=" + this.f22514d + ", logEnvironment=" + this.f22515e + ", androidAppInfo=" + this.f22516f + ')';
    }
}
