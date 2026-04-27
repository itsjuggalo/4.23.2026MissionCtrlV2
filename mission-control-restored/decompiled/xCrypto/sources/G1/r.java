package G1;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import z1.C1994l;

/* JADX INFO: loaded from: classes.dex */
public abstract class r {
    public static boolean a(Context context, int i4) {
        if (!b(context, i4, "com.google.android.gms")) {
            return false;
        }
        try {
            return C1994l.a(context).b(context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
        } catch (PackageManager.NameNotFoundException unused) {
            if (!Log.isLoggable("UidVerifier", 3)) {
                return false;
            }
            Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
            return false;
        }
    }

    public static boolean b(Context context, int i4, String str) {
        return I1.f.a(context).g(i4, str);
    }
}
