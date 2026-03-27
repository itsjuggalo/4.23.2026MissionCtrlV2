package i3;

import android.os.Build;
import java.util.ArrayList;

/* JADX INFO: renamed from: i3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0674a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final G f6896d;
    public final ArrayList e;

    public C0674a(String str, String versionName, String appBuildVersion, G g2, ArrayList arrayList) {
        String deviceManufacturer = Build.MANUFACTURER;
        kotlin.jvm.internal.j.e(versionName, "versionName");
        kotlin.jvm.internal.j.e(appBuildVersion, "appBuildVersion");
        kotlin.jvm.internal.j.e(deviceManufacturer, "deviceManufacturer");
        this.f6893a = str;
        this.f6894b = versionName;
        this.f6895c = appBuildVersion;
        this.f6896d = g2;
        this.e = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0674a)) {
            return false;
        }
        C0674a c0674a = (C0674a) obj;
        if (!this.f6893a.equals(c0674a.f6893a) || !kotlin.jvm.internal.j.a(this.f6894b, c0674a.f6894b) || !kotlin.jvm.internal.j.a(this.f6895c, c0674a.f6895c)) {
            return false;
        }
        String str = Build.MANUFACTURER;
        return kotlin.jvm.internal.j.a(str, str) && this.f6896d.equals(c0674a.f6896d) && this.e.equals(c0674a.e);
    }

    public final int hashCode() {
        return this.e.hashCode() + ((this.f6896d.hashCode() + ((Build.MANUFACTURER.hashCode() + ((this.f6895c.hashCode() + ((this.f6894b.hashCode() + (this.f6893a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "AndroidApplicationInfo(packageName=" + this.f6893a + ", versionName=" + this.f6894b + ", appBuildVersion=" + this.f6895c + ", deviceManufacturer=" + Build.MANUFACTURER + ", currentProcessDetails=" + this.f6896d + ", appProcessDetails=" + this.e + ')';
    }
}
