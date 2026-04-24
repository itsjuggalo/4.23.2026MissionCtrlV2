package com.google.firebase.sessions;

import java.util.List;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidApplicationInfo {
    private final String appBuildVersion;
    private final List<ProcessDetails> appProcessDetails;
    private final ProcessDetails currentProcessDetails;
    private final String deviceManufacturer;
    private final String packageName;
    private final String versionName;

    public AndroidApplicationInfo(String packageName, String versionName, String appBuildVersion, String deviceManufacturer, ProcessDetails currentProcessDetails, List<ProcessDetails> appProcessDetails) {
        r.f(packageName, "packageName");
        r.f(versionName, "versionName");
        r.f(appBuildVersion, "appBuildVersion");
        r.f(deviceManufacturer, "deviceManufacturer");
        r.f(currentProcessDetails, "currentProcessDetails");
        r.f(appProcessDetails, "appProcessDetails");
        this.packageName = packageName;
        this.versionName = versionName;
        this.appBuildVersion = appBuildVersion;
        this.deviceManufacturer = deviceManufacturer;
        this.currentProcessDetails = currentProcessDetails;
        this.appProcessDetails = appProcessDetails;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AndroidApplicationInfo copy$default(AndroidApplicationInfo androidApplicationInfo, String str, String str2, String str3, String str4, ProcessDetails processDetails, List list, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = androidApplicationInfo.packageName;
        }
        if ((i4 & 2) != 0) {
            str2 = androidApplicationInfo.versionName;
        }
        if ((i4 & 4) != 0) {
            str3 = androidApplicationInfo.appBuildVersion;
        }
        if ((i4 & 8) != 0) {
            str4 = androidApplicationInfo.deviceManufacturer;
        }
        if ((i4 & 16) != 0) {
            processDetails = androidApplicationInfo.currentProcessDetails;
        }
        if ((i4 & 32) != 0) {
            list = androidApplicationInfo.appProcessDetails;
        }
        ProcessDetails processDetails2 = processDetails;
        List list2 = list;
        return androidApplicationInfo.copy(str, str2, str3, str4, processDetails2, list2);
    }

    public final String component1() {
        return this.packageName;
    }

    public final String component2() {
        return this.versionName;
    }

    public final String component3() {
        return this.appBuildVersion;
    }

    public final String component4() {
        return this.deviceManufacturer;
    }

    public final ProcessDetails component5() {
        return this.currentProcessDetails;
    }

    public final List<ProcessDetails> component6() {
        return this.appProcessDetails;
    }

    public final AndroidApplicationInfo copy(String packageName, String versionName, String appBuildVersion, String deviceManufacturer, ProcessDetails currentProcessDetails, List<ProcessDetails> appProcessDetails) {
        r.f(packageName, "packageName");
        r.f(versionName, "versionName");
        r.f(appBuildVersion, "appBuildVersion");
        r.f(deviceManufacturer, "deviceManufacturer");
        r.f(currentProcessDetails, "currentProcessDetails");
        r.f(appProcessDetails, "appProcessDetails");
        return new AndroidApplicationInfo(packageName, versionName, appBuildVersion, deviceManufacturer, currentProcessDetails, appProcessDetails);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AndroidApplicationInfo)) {
            return false;
        }
        AndroidApplicationInfo androidApplicationInfo = (AndroidApplicationInfo) obj;
        return r.b(this.packageName, androidApplicationInfo.packageName) && r.b(this.versionName, androidApplicationInfo.versionName) && r.b(this.appBuildVersion, androidApplicationInfo.appBuildVersion) && r.b(this.deviceManufacturer, androidApplicationInfo.deviceManufacturer) && r.b(this.currentProcessDetails, androidApplicationInfo.currentProcessDetails) && r.b(this.appProcessDetails, androidApplicationInfo.appProcessDetails);
    }

    public final String getAppBuildVersion() {
        return this.appBuildVersion;
    }

    public final List<ProcessDetails> getAppProcessDetails() {
        return this.appProcessDetails;
    }

    public final ProcessDetails getCurrentProcessDetails() {
        return this.currentProcessDetails;
    }

    public final String getDeviceManufacturer() {
        return this.deviceManufacturer;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public int hashCode() {
        return (((((((((this.packageName.hashCode() * 31) + this.versionName.hashCode()) * 31) + this.appBuildVersion.hashCode()) * 31) + this.deviceManufacturer.hashCode()) * 31) + this.currentProcessDetails.hashCode()) * 31) + this.appProcessDetails.hashCode();
    }

    public String toString() {
        return "AndroidApplicationInfo(packageName=" + this.packageName + ", versionName=" + this.versionName + ", appBuildVersion=" + this.appBuildVersion + ", deviceManufacturer=" + this.deviceManufacturer + ", currentProcessDetails=" + this.currentProcessDetails + ", appProcessDetails=" + this.appProcessDetails + ')';
    }
}
