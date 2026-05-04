package u7;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f22238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a7.g f22239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f22240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TaskCompletionSource f22241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f22242e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f22243f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Boolean f22244g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TaskCompletionSource f22245h;

    public c0(a7.g gVar) {
        Object obj = new Object();
        this.f22240c = obj;
        this.f22241d = new TaskCompletionSource();
        this.f22242e = false;
        this.f22243f = false;
        this.f22245h = new TaskCompletionSource();
        Context contextM = gVar.m();
        this.f22239b = gVar;
        this.f22238a = i.q(contextM);
        Boolean boolB = b();
        this.f22244g = boolB == null ? a(contextM) : boolB;
        synchronized (obj) {
            try {
                if (d()) {
                    this.f22241d.trySetResult(null);
                    this.f22242e = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Boolean g(Context context) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_crashlytics_collection_enabled")) {
                return null;
            }
            return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_crashlytics_collection_enabled"));
        } catch (PackageManager.NameNotFoundException e10) {
            r7.g.f().e("Could not read data collection permission from manifest", e10);
            return null;
        }
    }

    public final Boolean a(Context context) {
        Boolean boolG = g(context);
        if (boolG == null) {
            this.f22243f = false;
            return null;
        }
        this.f22243f = true;
        return Boolean.valueOf(Boolean.TRUE.equals(boolG));
    }

    public final Boolean b() {
        if (!this.f22238a.contains("firebase_crashlytics_collection_enabled")) {
            return null;
        }
        this.f22243f = false;
        return Boolean.valueOf(this.f22238a.getBoolean("firebase_crashlytics_collection_enabled", true));
    }

    public void c(boolean z10) {
        if (!z10) {
            throw new IllegalStateException("An invalid data collection token was used.");
        }
        this.f22245h.trySetResult(null);
    }

    public synchronized boolean d() {
        boolean zBooleanValue;
        try {
            Boolean bool = this.f22244g;
            zBooleanValue = bool != null ? bool.booleanValue() : e();
            f(zBooleanValue);
        } catch (Throwable th) {
            throw th;
        }
        return zBooleanValue;
    }

    public final boolean e() {
        try {
            return this.f22239b.x();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    public final void f(boolean z10) {
        r7.g.f().b(String.format("Crashlytics automatic data collection %s by %s.", z10 ? "ENABLED" : "DISABLED", this.f22244g == null ? "global Firebase setting" : this.f22243f ? "firebase_crashlytics_collection_enabled manifest flag" : "API"));
    }

    public Task h() {
        Task task;
        synchronized (this.f22240c) {
            task = this.f22241d.getTask();
        }
        return task;
    }

    public Task i() {
        return v7.b.b(this.f22245h.getTask(), h());
    }
}
