package t5;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import io.flutter.plugins.firebase.auth.Constants;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f20813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f20814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Boolean f20815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Boolean f20816d;

    public static boolean a(Context context) {
        return h(context.getPackageManager());
    }

    public static boolean b() {
        int i10 = m5.j.f15932a;
        return Constants.USER.equals(Build.TYPE);
    }

    public static boolean c(Context context) {
        return e(context.getPackageManager());
    }

    public static boolean d(Context context) {
        if (c(context) && !n.d()) {
            return true;
        }
        if (f(context)) {
            return !n.e() || n.h();
        }
        return false;
    }

    public static boolean e(PackageManager packageManager) {
        if (f20813a == null) {
            f20813a = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return f20813a.booleanValue();
    }

    public static boolean f(Context context) {
        if (f20814b == null) {
            f20814b = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f20814b.booleanValue();
    }

    public static boolean g(Context context) {
        if (f20815c == null) {
            f20815c = Boolean.valueOf(n.e() ? context.getPackageManager().hasSystemFeature("android.hardware.type.embedded") : context.getPackageManager().hasSystemFeature("android.hardware.type.iot"));
        }
        return f20815c.booleanValue();
    }

    public static boolean h(PackageManager packageManager) {
        if (f20816d == null) {
            boolean z10 = false;
            if (n.e() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                z10 = true;
            }
            f20816d = Boolean.valueOf(z10);
        }
        return f20816d.booleanValue();
    }
}
