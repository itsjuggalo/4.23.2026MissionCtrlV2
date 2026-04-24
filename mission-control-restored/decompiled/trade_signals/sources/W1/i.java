package W1;

import Q1.AbstractC0799k;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f9258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f9259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Boolean f9260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Boolean f9261d;

    public static boolean a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f9261d == null) {
            boolean z7 = false;
            if (l.e() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                z7 = true;
            }
            f9261d = Boolean.valueOf(z7);
        }
        return f9261d.booleanValue();
    }

    public static boolean b() {
        int i8 = AbstractC0799k.f6698a;
        return "user".equals(Build.TYPE);
    }

    public static boolean c(Context context) {
        return g(context.getPackageManager());
    }

    public static boolean d(Context context) {
        if (c(context) && !l.d()) {
            return true;
        }
        if (e(context)) {
            return !l.e() || l.h();
        }
        return false;
    }

    public static boolean e(Context context) {
        if (f9259b == null) {
            f9259b = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f9259b.booleanValue();
    }

    public static boolean f(Context context) {
        if (f9260c == null) {
            boolean z7 = true;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                z7 = false;
            }
            f9260c = Boolean.valueOf(z7);
        }
        return f9260c.booleanValue();
    }

    public static boolean g(PackageManager packageManager) {
        if (f9258a == null) {
            f9258a = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return f9258a.booleanValue();
    }
}
