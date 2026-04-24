package com.google.firebase.sessions;

import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationInfo {
    private final AndroidApplicationInfo androidAppInfo;
    private final String appId;
    private final String deviceModel;
    private final LogEnvironment logEnvironment;
    private final String osVersion;
    private final String sessionSdkVersion;

    public ApplicationInfo(String appId, String deviceModel, String sessionSdkVersion, String osVersion, LogEnvironment logEnvironment, AndroidApplicationInfo androidAppInfo) {
        r.f(appId, "appId");
        r.f(deviceModel, "deviceModel");
        r.f(sessionSdkVersion, "sessionSdkVersion");
        r.f(osVersion, "osVersion");
        r.f(logEnvironment, "logEnvironment");
        r.f(androidAppInfo, "androidAppInfo");
        this.appId = appId;
        this.deviceModel = deviceModel;
        this.sessionSdkVersion = sessionSdkVersion;
        this.osVersion = osVersion;
        this.logEnvironment = logEnvironment;
        this.androidAppInfo = androidAppInfo;
    }

    public static /* synthetic */ ApplicationInfo copy$default(ApplicationInfo applicationInfo, String str, String str2, String str3, String str4, LogEnvironment logEnvironment, AndroidApplicationInfo androidApplicationInfo, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = applicationInfo.appId;
        }
        if ((i4 & 2) != 0) {
            str2 = applicationInfo.deviceModel;
        }
        if ((i4 & 4) != 0) {
            str3 = applicationInfo.sessionSdkVersion;
        }
        if ((i4 & 8) != 0) {
            str4 = applicationInfo.osVersion;
        }
        if ((i4 & 16) != 0) {
            logEnvironment = applicationInfo.logEnvironment;
        }
        if ((i4 & 32) != 0) {
            androidApplicationInfo = applicationInfo.androidAppInfo;
        }
        LogEnvironment logEnvironment2 = logEnvironment;
        AndroidApplicationInfo androidApplicationInfo2 = androidApplicationInfo;
        return applicationInfo.copy(str, str2, str3, str4, logEnvironment2, androidApplicationInfo2);
    }

    public final String component1() {
        return this.appId;
    }

    public final String component2() {
        return this.deviceModel;
    }

    public final String component3() {
        return this.sessionSdkVersion;
    }

    public final String component4() {
        return this.osVersion;
    }

    public final LogEnvironment component5() {
        return this.logEnvironment;
    }

    public final AndroidApplicationInfo component6() {
        return this.androidAppInfo;
    }

    public final ApplicationInfo copy(String appId, String deviceModel, String sessionSdkVersion, String osVersion, LogEnvironment logEnvironment, AndroidApplicationInfo androidAppInfo) {
        r.f(appId, "appId");
        r.f(deviceModel, "deviceModel");
        r.f(sessionSdkVersion, "sessionSdkVersion");
        r.f(osVersion, "osVersion");
        r.f(logEnvironment, "logEnvironment");
        r.f(androidAppInfo, "androidAppInfo");
        return new ApplicationInfo(appId, deviceModel, sessionSdkVersion, osVersion, logEnvironment, androidAppInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApplicationInfo)) {
            return false;
        }
        ApplicationInfo applicationInfo = (ApplicationInfo) obj;
        return r.b(this.appId, applicationInfo.appId) && r.b(this.deviceModel, applicationInfo.deviceModel) && r.b(this.sessionSdkVersion, applicationInfo.sessionSdkVersion) && r.b(this.osVersion, applicationInfo.osVersion) && this.logEnvironment == applicationInfo.logEnvironment && r.b(this.androidAppInfo, applicationInfo.androidAppInfo);
    }

    public final AndroidApplicationInfo getAndroidAppInfo() {
        return this.androidAppInfo;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getDeviceModel() {
        return this.deviceModel;
    }

    public final LogEnvironment getLogEnvironment() {
        return this.logEnvironment;
    }

    public final String getOsVersion() {
        return this.osVersion;
    }

    public final String getSessionSdkVersion() {
        return this.sessionSdkVersion;
    }

    public int hashCode() {
        return (((((((((this.appId.hashCode() * 31) + this.deviceModel.hashCode()) * 31) + this.sessionSdkVersion.hashCode()) * 31) + this.osVersion.hashCode()) * 31) + this.logEnvironment.hashCode()) * 31) + this.androidAppInfo.hashCode();
    }

    public String toString() {
        return "ApplicationInfo(appId=" + this.appId + ", deviceModel=" + this.deviceModel + ", sessionSdkVersion=" + this.sessionSdkVersion + ", osVersion=" + this.osVersion + ", logEnvironment=" + this.logEnvironment + ", androidAppInfo=" + this.androidAppInfo + ')';
    }
}
