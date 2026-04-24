package X3;

import A3.c;
import G2.b;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f9372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f9373c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f9374d;

    public a(Context context, String str, c cVar) {
        Context contextA = a(context);
        this.f9371a = contextA;
        this.f9372b = contextA.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.f9373c = cVar;
        this.f9374d = c();
    }

    public static Context a(Context context) {
        return I.a.b(context);
    }

    public synchronized boolean b() {
        return this.f9374d;
    }

    public final boolean c() {
        return this.f9372b.contains("firebase_data_collection_default_enabled") ? this.f9372b.getBoolean("firebase_data_collection_default_enabled", true) : d();
    }

    public final boolean d() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = this.f9371a.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.f9371a.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_data_collection_default_enabled")) {
                return true;
            }
            return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    public synchronized void e(Boolean bool) {
        boolean zEquals;
        try {
            if (bool == null) {
                this.f9372b.edit().remove("firebase_data_collection_default_enabled").apply();
                zEquals = d();
            } else {
                zEquals = Boolean.TRUE.equals(bool);
                this.f9372b.edit().putBoolean("firebase_data_collection_default_enabled", zEquals).apply();
            }
            f(zEquals);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void f(boolean z7) {
        if (this.f9374d != z7) {
            this.f9374d = z7;
            this.f9373c.d(new A3.a(b.class, new b(z7)));
        }
    }
}
