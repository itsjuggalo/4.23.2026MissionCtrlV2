package W1;

import P1.AbstractC0657k;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f5362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f5363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Boolean f5364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Boolean f5365d;

    public static boolean a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f5365d == null) {
            boolean z7 = false;
            if (m.e() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                z7 = true;
            }
            f5365d = Boolean.valueOf(z7);
        }
        return f5365d.booleanValue();
    }

    public static boolean b() {
        int i7 = AbstractC0657k.f4304a;
        return "user".equals(Build.TYPE);
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
        if (f5363b == null) {
            f5363b = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f5363b.booleanValue();
    }

    public static boolean f(Context context) {
        if (f5364c == null) {
            boolean z7 = true;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                z7 = false;
            }
            f5364c = Boolean.valueOf(z7);
        }
        return f5364c.booleanValue();
    }

    public static boolean g(PackageManager packageManager) {
        if (f5362a == null) {
            f5362a = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return f5362a.booleanValue();
    }
}
