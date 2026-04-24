package h3;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import e3.C1478g;
import i3.AbstractC1975b;

/* JADX INFO: renamed from: h3.I, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1678I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f14751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Q2.g f14752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f14753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TaskCompletionSource f14754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f14755e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f14756f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Boolean f14757g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TaskCompletionSource f14758h;

    public C1678I(Q2.g gVar) {
        Object obj = new Object();
        this.f14753c = obj;
        this.f14754d = new TaskCompletionSource();
        this.f14755e = false;
        this.f14756f = false;
        this.f14758h = new TaskCompletionSource();
        Context contextM = gVar.m();
        this.f14752b = gVar;
        this.f14751a = AbstractC1695i.q(contextM);
        Boolean boolB = b();
        this.f14757g = boolB == null ? a(contextM) : boolB;
        synchronized (obj) {
            try {
                if (d()) {
                    this.f14754d.trySetResult(null);
                    this.f14755e = true;
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
        } catch (PackageManager.NameNotFoundException e7) {
            C1478g.f().e("Could not read data collection permission from manifest", e7);
            return null;
        }
    }

    public static void i(SharedPreferences sharedPreferences, Boolean bool) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (bool != null) {
            editorEdit.putBoolean("firebase_crashlytics_collection_enabled", bool.booleanValue());
        } else {
            editorEdit.remove("firebase_crashlytics_collection_enabled");
        }
        editorEdit.apply();
    }

    public final Boolean a(Context context) {
        Boolean boolG = g(context);
        if (boolG == null) {
            this.f14756f = false;
            return null;
        }
        this.f14756f = true;
        return Boolean.valueOf(Boolean.TRUE.equals(boolG));
    }

    public final Boolean b() {
        if (!this.f14751a.contains("firebase_crashlytics_collection_enabled")) {
            return null;
        }
        this.f14756f = false;
        return Boolean.valueOf(this.f14751a.getBoolean("firebase_crashlytics_collection_enabled", true));
    }

    public void c(boolean z7) {
        if (!z7) {
            throw new IllegalStateException("An invalid data collection token was used.");
        }
        this.f14758h.trySetResult(null);
    }

    public synchronized boolean d() {
        boolean zBooleanValue;
        try {
            Boolean bool = this.f14757g;
            zBooleanValue = bool != null ? bool.booleanValue() : e();
            f(zBooleanValue);
        } catch (Throwable th) {
            throw th;
        }
        return zBooleanValue;
    }

    public final boolean e() {
        try {
            return this.f14752b.x();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    public final void f(boolean z7) {
        C1478g.f().b(String.format("Crashlytics automatic data collection %s by %s.", z7 ? "ENABLED" : "DISABLED", this.f14757g == null ? "global Firebase setting" : this.f14756f ? "firebase_crashlytics_collection_enabled manifest flag" : "API"));
    }

    public synchronized void h(Boolean bool) {
        if (bool != null) {
            try {
                this.f14756f = false;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f14757g = bool != null ? bool : a(this.f14752b.m());
        i(this.f14751a, bool);
        synchronized (this.f14753c) {
            try {
                if (d()) {
                    if (!this.f14755e) {
                        this.f14754d.trySetResult(null);
                        this.f14755e = true;
                    }
                } else if (this.f14755e) {
                    this.f14754d = new TaskCompletionSource();
                    this.f14755e = false;
                }
            } finally {
            }
        }
    }

    public Task j() {
        Task task;
        synchronized (this.f14753c) {
            task = this.f14754d.getTask();
        }
        return task;
    }

    public Task k() {
        return AbstractC1975b.c(this.f14758h.getTask(), j());
    }
}
