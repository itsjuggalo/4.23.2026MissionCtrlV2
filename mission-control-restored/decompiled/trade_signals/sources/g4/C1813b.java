package g4;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: g4.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1813b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f18138c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f18139d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final EnumC1832u f18140e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C1811a f18141f;

    public C1813b(String appId, String deviceModel, String sessionSdkVersion, String osVersion, EnumC1832u logEnvironment, C1811a androidAppInfo) {
        AbstractC2304t.f(appId, "appId");
        AbstractC2304t.f(deviceModel, "deviceModel");
        AbstractC2304t.f(sessionSdkVersion, "sessionSdkVersion");
        AbstractC2304t.f(osVersion, "osVersion");
        AbstractC2304t.f(logEnvironment, "logEnvironment");
        AbstractC2304t.f(androidAppInfo, "androidAppInfo");
        this.f18136a = appId;
        this.f18137b = deviceModel;
        this.f18138c = sessionSdkVersion;
        this.f18139d = osVersion;
        this.f18140e = logEnvironment;
        this.f18141f = androidAppInfo;
    }

    public final C1811a a() {
        return this.f18141f;
    }

    public final String b() {
        return this.f18136a;
    }

    public final String c() {
        return this.f18137b;
    }

    public final EnumC1832u d() {
        return this.f18140e;
    }

    public final String e() {
        return this.f18139d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1813b)) {
            return false;
        }
        C1813b c1813b = (C1813b) obj;
        return AbstractC2304t.b(this.f18136a, c1813b.f18136a) && AbstractC2304t.b(this.f18137b, c1813b.f18137b) && AbstractC2304t.b(this.f18138c, c1813b.f18138c) && AbstractC2304t.b(this.f18139d, c1813b.f18139d) && this.f18140e == c1813b.f18140e && AbstractC2304t.b(this.f18141f, c1813b.f18141f);
    }

    public final String f() {
        return this.f18138c;
    }

    public int hashCode() {
        return (((((((((this.f18136a.hashCode() * 31) + this.f18137b.hashCode()) * 31) + this.f18138c.hashCode()) * 31) + this.f18139d.hashCode()) * 31) + this.f18140e.hashCode()) * 31) + this.f18141f.hashCode();
    }

    public String toString() {
        return "ApplicationInfo(appId=" + this.f18136a + ", deviceModel=" + this.f18137b + ", sessionSdkVersion=" + this.f18138c + ", osVersion=" + this.f18139d + ", logEnvironment=" + this.f18140e + ", androidAppInfo=" + this.f18141f + ')';
    }
}
