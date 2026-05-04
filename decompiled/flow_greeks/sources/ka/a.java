package ka;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import c9.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f14798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f14799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f14800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f14801d;

    public a(Context context, String str, c cVar) {
        Context contextA = a(context);
        this.f14798a = contextA;
        this.f14799b = contextA.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.f14800c = cVar;
        this.f14801d = c();
    }

    public static Context a(Context context) {
        return i0.a.b(context);
    }

    public synchronized boolean b() {
        return this.f14801d;
    }

    public final boolean c() {
        return this.f14799b.contains("firebase_data_collection_default_enabled") ? this.f14799b.getBoolean("firebase_data_collection_default_enabled", true) : d();
    }

    public final boolean d() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = this.f14798a.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.f14798a.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_data_collection_default_enabled")) {
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
                this.f14799b.edit().remove("firebase_data_collection_default_enabled").apply();
                f(d());
            } else {
                boolean zEquals = Boolean.TRUE.equals(bool);
                this.f14799b.edit().putBoolean("firebase_data_collection_default_enabled", zEquals).apply();
                f(zEquals);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void f(boolean z10) {
        if (this.f14801d != z10) {
            this.f14801d = z10;
            this.f14800c.a(new c9.a(a7.b.class, new a7.b(z10)));
        }
    }
}
