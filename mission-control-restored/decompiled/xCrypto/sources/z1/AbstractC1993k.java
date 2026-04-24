package z1;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import io.flutter.plugins.firebase.auth.Constants;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: z1.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1993k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f16101a = 12451000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f16103c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f16104d = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f16102b = new AtomicBoolean();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicBoolean f16105e = new AtomicBoolean();

    public static void a(Context context, int i4) throws C1990h, C1991i {
        int iH = C1989g.f().h(context, i4);
        if (iH != 0) {
            Intent intentB = C1989g.f().b(context, iH, "e");
            Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + iH);
            if (intentB != null) {
                throw new C1991i(iH, "Google Play Services not available", intentB);
            }
            throw new C1990h(iH);
        }
    }

    public static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 0;
        }
    }

    public static String c(int i4) {
        return C1984b.o(i4);
    }

    public static Context d(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static Resources e(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static boolean f(Context context) {
        try {
            if (!f16104d) {
                try {
                    PackageInfo packageInfoE = I1.f.a(context).e("com.google.android.gms", 64);
                    C1994l.a(context);
                    if (packageInfoE == null || C1994l.e(packageInfoE, false) || !C1994l.e(packageInfoE, true)) {
                        f16103c = false;
                    } else {
                        f16103c = true;
                    }
                    f16104d = true;
                } catch (PackageManager.NameNotFoundException e4) {
                    Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e4);
                    f16104d = true;
                }
            }
            return f16103c || !G1.h.b();
        } catch (Throwable th) {
            f16104d = true;
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int g(android.content.Context r10, int r11) {
        /*
            Method dump skipped, instruction units count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z1.AbstractC1993k.g(android.content.Context, int):int");
    }

    public static boolean h(Context context, int i4) {
        if (i4 == 18) {
            return true;
        }
        if (i4 == 1) {
            return l(context, "com.google.android.gms");
        }
        return false;
    }

    public static boolean i(Context context) {
        Object systemService = context.getSystemService(Constants.USER);
        AbstractC0940s.k(systemService);
        Bundle applicationRestrictions = ((UserManager) systemService).getApplicationRestrictions(context.getPackageName());
        return applicationRestrictions != null && com.amazon.a.a.o.b.af.equals(applicationRestrictions.getString("restricted_profile"));
    }

    public static boolean j(int i4) {
        return i4 == 1 || i4 == 2 || i4 == 3 || i4 == 9;
    }

    public static boolean k(Context context, int i4, String str) {
        return G1.r.b(context, i4, str);
    }

    public static boolean l(Context context, String str) throws PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo;
        boolean zEquals = str.equals("com.google.android.gms");
        try {
            Iterator<PackageInstaller.SessionInfo> it = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().getAppPackageName())) {
                    return true;
                }
            }
            applicationInfo = context.getPackageManager().getApplicationInfo(str, UserMetadata.MAX_INTERNAL_KEY_SIZE);
        } catch (PackageManager.NameNotFoundException | Exception unused) {
        }
        return zEquals ? applicationInfo.enabled : applicationInfo.enabled && !i(context);
    }
}
