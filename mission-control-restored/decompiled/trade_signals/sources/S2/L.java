package S2;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f7508a;

    public static String b(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName == null ? "" : installerPackageName;
    }

    public synchronized String a(Context context) {
        try {
            if (this.f7508a == null) {
                this.f7508a = b(context);
            }
        } finally {
        }
        return "".equals(this.f7508a) ? null : this.f7508a;
    }
}
