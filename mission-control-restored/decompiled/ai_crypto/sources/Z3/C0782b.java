package Z3;

/* JADX INFO: renamed from: Z3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0782b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f5885d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r f5886e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C0781a f5887f;

    public C0782b(String appId, String deviceModel, String sessionSdkVersion, String osVersion, r logEnvironment, C0781a androidAppInfo) {
        kotlin.jvm.internal.r.f(appId, "appId");
        kotlin.jvm.internal.r.f(deviceModel, "deviceModel");
        kotlin.jvm.internal.r.f(sessionSdkVersion, "sessionSdkVersion");
        kotlin.jvm.internal.r.f(osVersion, "osVersion");
        kotlin.jvm.internal.r.f(logEnvironment, "logEnvironment");
        kotlin.jvm.internal.r.f(androidAppInfo, "androidAppInfo");
        this.f5882a = appId;
        this.f5883b = deviceModel;
        this.f5884c = sessionSdkVersion;
        this.f5885d = osVersion;
        this.f5886e = logEnvironment;
        this.f5887f = androidAppInfo;
    }

    public final C0781a a() {
        return this.f5887f;
    }

    public final String b() {
        return this.f5882a;
    }

    public final String c() {
        return this.f5883b;
    }

    public final r d() {
        return this.f5886e;
    }

    public final String e() {
        return this.f5885d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0782b)) {
            return false;
        }
        C0782b c0782b = (C0782b) obj;
        return kotlin.jvm.internal.r.b(this.f5882a, c0782b.f5882a) && kotlin.jvm.internal.r.b(this.f5883b, c0782b.f5883b) && kotlin.jvm.internal.r.b(this.f5884c, c0782b.f5884c) && kotlin.jvm.internal.r.b(this.f5885d, c0782b.f5885d) && this.f5886e == c0782b.f5886e && kotlin.jvm.internal.r.b(this.f5887f, c0782b.f5887f);
    }

    public final String f() {
        return this.f5884c;
    }

    public int hashCode() {
        return (((((((((this.f5882a.hashCode() * 31) + this.f5883b.hashCode()) * 31) + this.f5884c.hashCode()) * 31) + this.f5885d.hashCode()) * 31) + this.f5886e.hashCode()) * 31) + this.f5887f.hashCode();
    }

    public String toString() {
        return "ApplicationInfo(appId=" + this.f5882a + ", deviceModel=" + this.f5883b + ", sessionSdkVersion=" + this.f5884c + ", osVersion=" + this.f5885d + ", logEnvironment=" + this.f5886e + ", androidAppInfo=" + this.f5887f + ')';
    }
}
