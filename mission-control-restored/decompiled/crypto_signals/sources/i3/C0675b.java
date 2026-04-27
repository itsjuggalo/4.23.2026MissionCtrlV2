package i3;

import android.os.Build;

/* JADX INFO: renamed from: i3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0675b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0674a f6900b;

    public C0675b(String appId, C0674a c0674a) {
        String deviceModel = Build.MODEL;
        String osVersion = Build.VERSION.RELEASE;
        EnumC0672A enumC0672A = EnumC0672A.f6824b;
        kotlin.jvm.internal.j.e(appId, "appId");
        kotlin.jvm.internal.j.e(deviceModel, "deviceModel");
        kotlin.jvm.internal.j.e(osVersion, "osVersion");
        this.f6899a = appId;
        this.f6900b = c0674a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0675b)) {
            return false;
        }
        C0675b c0675b = (C0675b) obj;
        if (!kotlin.jvm.internal.j.a(this.f6899a, c0675b.f6899a)) {
            return false;
        }
        String str = Build.MODEL;
        if (!kotlin.jvm.internal.j.a(str, str)) {
            return false;
        }
        String str2 = Build.VERSION.RELEASE;
        if (!kotlin.jvm.internal.j.a(str2, str2)) {
            return false;
        }
        EnumC0672A enumC0672A = EnumC0672A.f6824b;
        return this.f6900b.equals(c0675b.f6900b);
    }

    public final int hashCode() {
        return this.f6900b.hashCode() + ((EnumC0672A.f6824b.hashCode() + ((Build.VERSION.RELEASE.hashCode() + ((((Build.MODEL.hashCode() + (this.f6899a.hashCode() * 31)) * 31) + 48517559) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "ApplicationInfo(appId=" + this.f6899a + ", deviceModel=" + Build.MODEL + ", sessionSdkVersion=3.0.0, osVersion=" + Build.VERSION.RELEASE + ", logEnvironment=" + EnumC0672A.f6824b + ", androidAppInfo=" + this.f6900b + ')';
    }
}
