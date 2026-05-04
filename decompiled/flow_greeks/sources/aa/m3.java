package aa;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class m3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a7.g f526a;

    public m3(a7.g gVar) {
        this.f526a = gVar;
    }

    public boolean a(String str, boolean z10) {
        SharedPreferences sharedPreferences = ((Application) this.f526a.m()).getSharedPreferences("com.google.firebase.inappmessaging", 0);
        if (sharedPreferences.contains(str)) {
            return sharedPreferences.getBoolean(str, z10);
        }
        f(str, z10);
        return z10;
    }

    public boolean b(String str, boolean z10) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        Application application = (Application) this.f526a.m();
        try {
            PackageManager packageManager = application.getPackageManager();
            if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(application.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey(str)) {
                return applicationInfo.metaData.getBoolean(str);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return z10;
    }

    public boolean c(String str, boolean z10) {
        SharedPreferences sharedPreferences = ((Application) this.f526a.m()).getSharedPreferences("com.google.firebase.inappmessaging", 0);
        return sharedPreferences.contains(str) ? sharedPreferences.getBoolean(str, z10) : z10;
    }

    public boolean d(String str) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        Application application = (Application) this.f526a.m();
        try {
            PackageManager packageManager = application.getPackageManager();
            if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(application.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null) {
                if (bundle.containsKey(str)) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public boolean e(String str) {
        return ((Application) this.f526a.m()).getSharedPreferences("com.google.firebase.inappmessaging", 0).contains(str);
    }

    public void f(String str, boolean z10) {
        SharedPreferences.Editor editorEdit = ((Application) this.f526a.m()).getSharedPreferences("com.google.firebase.inappmessaging", 0).edit();
        editorEdit.putBoolean(str, z10);
        editorEdit.apply();
    }
}
