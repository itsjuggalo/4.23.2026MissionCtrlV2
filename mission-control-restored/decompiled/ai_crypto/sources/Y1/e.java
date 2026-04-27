package Y1;

import W1.m;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Binder;
import android.os.Process;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5639a;

    public e(Context context) {
        this.f5639a = context;
    }

    public int a(String str) {
        return this.f5639a.checkCallingOrSelfPermission(str);
    }

    public int b(String str, String str2) {
        return this.f5639a.getPackageManager().checkPermission(str, str2);
    }

    public ApplicationInfo c(String str, int i7) {
        return this.f5639a.getPackageManager().getApplicationInfo(str, i7);
    }

    public CharSequence d(String str) {
        Context context = this.f5639a;
        return context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(str, 0));
    }

    public PackageInfo e(String str, int i7) {
        return this.f5639a.getPackageManager().getPackageInfo(str, i7);
    }

    public boolean f() {
        String nameForUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return c.a(this.f5639a);
        }
        if (!m.e() || (nameForUid = this.f5639a.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return this.f5639a.getPackageManager().isInstantApp(nameForUid);
    }

    public final boolean g(int i7, String str) {
        try {
            AppOpsManager appOpsManager = (AppOpsManager) this.f5639a.getSystemService("appops");
            if (appOpsManager == null) {
                throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
            }
            appOpsManager.checkPackage(i7, str);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }
}
