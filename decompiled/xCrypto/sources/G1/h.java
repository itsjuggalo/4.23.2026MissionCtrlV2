package G1;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import io.flutter.plugins.firebase.auth.Constants;
import z1.AbstractC1993k;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Boolean f461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Boolean f462d;

    public static boolean a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f462d == null) {
            boolean z4 = false;
            if (m.e() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                z4 = true;
            }
            f462d = Boolean.valueOf(z4);
        }
        return f462d.booleanValue();
    }

    public static boolean b() {
        int i4 = AbstractC1993k.f16101a;
        return Constants.USER.equals(Build.TYPE);
    }

    public static boolean c(Context context) {
        return g(context.getPackageManager());
    }

    public static boolean d(Context context) {
        if (c(context) && !m.d()) {
            return true;
        }
        if (e(context)) {
            return !m.e() || m.h();
        }
        return false;
    }

    public static boolean e(Context context) {
        if (f460b == null) {
            f460b = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f460b.booleanValue();
    }

    public static boolean f(Context context) {
        if (f461c == null) {
            boolean z4 = true;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                z4 = false;
            }
            f461c = Boolean.valueOf(z4);
        }
        return f461c.booleanValue();
    }

    public static boolean g(PackageManager packageManager) {
        if (f459a == null) {
            f459a = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return f459a.booleanValue();
    }
}
