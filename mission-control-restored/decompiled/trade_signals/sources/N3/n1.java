package N3;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final G2.f f5715a;

    public n1(G2.f fVar) {
        this.f5715a = fVar;
    }

    public boolean a(String str, boolean z7) {
        SharedPreferences sharedPreferences = ((Application) this.f5715a.m()).getSharedPreferences("com.google.firebase.inappmessaging", 0);
        if (sharedPreferences.contains(str)) {
            return sharedPreferences.getBoolean(str, z7);
        }
        f(str, z7);
        return z7;
    }

    public boolean b(String str, boolean z7) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        Application application = (Application) this.f5715a.m();
        try {
            PackageManager packageManager = application.getPackageManager();
            if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(application.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey(str)) {
                return applicationInfo.metaData.getBoolean(str);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return z7;
    }

    public boolean c(String str, boolean z7) {
        SharedPreferences sharedPreferences = ((Application) this.f5715a.m()).getSharedPreferences("com.google.firebase.inappmessaging", 0);
        return sharedPreferences.contains(str) ? sharedPreferences.getBoolean(str, z7) : z7;
    }

    public boolean d(String str) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        Application application = (Application) this.f5715a.m();
        try {
            PackageManager packageManager = application.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(application.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null) {
                return false;
            }
            return bundle.containsKey(str);
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public boolean e(String str) {
        return ((Application) this.f5715a.m()).getSharedPreferences("com.google.firebase.inappmessaging", 0).contains(str);
    }

    public void f(String str, boolean z7) {
        SharedPreferences.Editor editorEdit = ((Application) this.f5715a.m()).getSharedPreferences("com.google.firebase.inappmessaging", 0).edit();
        editorEdit.putBoolean(str, z7);
        editorEdit.apply();
    }
}
