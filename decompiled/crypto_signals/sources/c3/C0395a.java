package c3;

import J2.c;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import u.AbstractC1193h;

/* JADX INFO: renamed from: c3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0395a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f4910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f4911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4912d;

    public C0395a(Context context, String str, c cVar) {
        Context contextCreateDeviceProtectedStorageContext = AbstractC1193h.createDeviceProtectedStorageContext(context);
        this.f4909a = contextCreateDeviceProtectedStorageContext;
        SharedPreferences sharedPreferences = contextCreateDeviceProtectedStorageContext.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.f4910b = sharedPreferences;
        this.f4911c = cVar;
        this.f4912d = sharedPreferences.contains("firebase_data_collection_default_enabled") ? sharedPreferences.getBoolean("firebase_data_collection_default_enabled", true) : a();
    }

    public final boolean a() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        Context context = this.f4909a;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_data_collection_default_enabled")) {
                return true;
            }
            return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    public final synchronized void b(boolean z6) {
        if (this.f4912d != z6) {
            this.f4912d = z6;
            this.f4911c.a(new J2.a(new Z1.b(z6)));
        }
    }
}
