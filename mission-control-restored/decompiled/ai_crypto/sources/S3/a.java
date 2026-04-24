package S3;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import z3.C2889a;
import z3.InterfaceC2891c;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f4695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2891c f4696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4697d;

    public a(Context context, String str, InterfaceC2891c interfaceC2891c) {
        Context contextA = a(context);
        this.f4694a = contextA;
        this.f4695b = contextA.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.f4696c = interfaceC2891c;
        this.f4697d = c();
    }

    public static Context a(Context context) {
        return G.a.createDeviceProtectedStorageContext(context);
    }

    public synchronized boolean b() {
        return this.f4697d;
    }

    public final boolean c() {
        return this.f4695b.contains("firebase_data_collection_default_enabled") ? this.f4695b.getBoolean("firebase_data_collection_default_enabled", true) : d();
    }

    public final boolean d() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = this.f4694a.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.f4694a.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_data_collection_default_enabled")) {
                return true;
            }
            return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    public synchronized void e(Boolean bool) {
        try {
            if (bool == null) {
                this.f4695b.edit().remove("firebase_data_collection_default_enabled").apply();
                f(d());
            } else {
                boolean zEquals = Boolean.TRUE.equals(bool);
                this.f4695b.edit().putBoolean("firebase_data_collection_default_enabled", zEquals).apply();
                f(zEquals);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void f(boolean z7) {
        if (this.f4697d != z7) {
            this.f4697d = z7;
            this.f4696c.c(new C2889a(Q2.b.class, new Q2.b(z7)));
        }
    }
}
