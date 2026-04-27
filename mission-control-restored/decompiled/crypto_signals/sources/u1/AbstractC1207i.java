package u1;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: u1.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1207i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f10289b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f10290c = false;
    public static final /* synthetic */ int e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f10288a = new AtomicBoolean();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f10291d = new AtomicBoolean();

    public static void a(Context context, int i) throws C1205g, C1206h {
        C1204f c1204f = C1204f.f10286b;
        int iC = c1204f.c(context, i);
        if (iC != 0) {
            Intent intentA = c1204f.a(iC, context, "e");
            Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + iC);
            if (intentA != null) {
                throw new C1206h(intentA, iC);
            }
            throw new C1205g();
        }
    }

    public static boolean b(Context context) {
        try {
            if (!f10290c) {
                try {
                    PackageInfo packageInfoB = D1.d.a(context).b(64, "com.google.android.gms");
                    C1208j.a(context);
                    if (packageInfoB == null || C1208j.f(packageInfoB, false) || !C1208j.f(packageInfoB, true)) {
                        f10289b = false;
                    } else {
                        f10289b = true;
                    }
                    f10290c = true;
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e2);
                    f10290c = true;
                }
            }
            return f10289b || !"user".equals(Build.TYPE);
        } catch (Throwable th) {
            f10290c = true;
            throw th;
        }
    }

    public static boolean c(Context context) {
        try {
            Iterator<PackageInstaller.SessionInfo> it = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
            while (it.hasNext()) {
                if ("com.google.android.gms".equals(it.next().getAppPackageName())) {
                    return true;
                }
            }
            return context.getPackageManager().getApplicationInfo("com.google.android.gms", 8192).enabled;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return false;
        }
    }
}
