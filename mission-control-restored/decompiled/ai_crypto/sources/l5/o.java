package l5;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.MediaStore;
import com.google.android.gms.common.api.a;
import java.util.Arrays;
import l5.q;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o {
    public static int a(q.e eVar) {
        Long lC = eVar.c();
        int iB = b();
        return (lC == null || lC.longValue() >= ((long) iB)) ? iB : Math.toIntExact(lC.longValue());
    }

    public static int b() {
        return g.f.f() ? MediaStore.getPickImagesMaxLimit() : a.e.API_PRIORITY_OTHER;
    }

    public static PackageInfo c(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 4096);
    }

    public static boolean d(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return Arrays.asList((Build.VERSION.SDK_INT >= 33 ? packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(4096L)) : c(packageManager, context.getPackageName())).requestedPermissions).contains(str);
        } catch (PackageManager.NameNotFoundException e7) {
            e7.printStackTrace();
            return false;
        }
    }

    public static boolean e(Context context) {
        return d(context, "android.permission.CAMERA");
    }
}
