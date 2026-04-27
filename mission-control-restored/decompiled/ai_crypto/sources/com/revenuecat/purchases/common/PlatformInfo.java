package com.revenuecat.purchases.common;

import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class PlatformInfo {
    private final String flavor;
    private final String version;

    public PlatformInfo(String flavor, String str) {
        r.f(flavor, "flavor");
        this.flavor = flavor;
        this.version = str;
    }

    public static /* synthetic */ PlatformInfo copy$default(PlatformInfo platformInfo, String str, String str2, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            str = platformInfo.flavor;
        }
        if ((i7 & 2) != 0) {
            str2 = platformInfo.version;
        }
        return platformInfo.copy(str, str2);
    }

    public final String component1() {
        return this.flavor;
    }

    public final String component2() {
        return this.version;
    }

    public final PlatformInfo copy(String flavor, String str) {
        r.f(flavor, "flavor");
        return new PlatformInfo(flavor, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlatformInfo)) {
            return false;
        }
        PlatformInfo platformInfo = (PlatformInfo) obj;
        return r.b(this.flavor, platformInfo.flavor) && r.b(this.version, platformInfo.version);
    }

    public final String getFlavor() {
        return this.flavor;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int iHashCode = this.flavor.hashCode() * 31;
        String str = this.version;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "PlatformInfo(flavor=" + this.flavor + ", version=" + this.version + ')';
    }
}
