package h3;

import android.content.Context;

/* JADX INFO: renamed from: h3.P, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1685P {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f14786a;

    public static String b(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName == null ? "" : installerPackageName;
    }

    public synchronized String a(Context context) {
        try {
            if (this.f14786a == null) {
                this.f14786a = b(context);
            }
        } finally {
        }
        return "".equals(this.f14786a) ? null : this.f14786a;
    }
}
