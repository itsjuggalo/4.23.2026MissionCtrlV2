package com.amazon.a.a.f;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.amazon.a.a.o.c;

/* JADX INFO: loaded from: classes.dex */
public class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f8451a = new c("ApplicationLifecycleObserver");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f8452b = a.class.getSimpleName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final a f8453c = new a();

    private a() {
    }

    public static a a() {
        return f8453c;
    }

    private static boolean b() {
        return com.amazon.a.a.d();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (!com.amazon.a.a.d()) {
            com.amazon.a.a.a((Context) activity.getApplication());
            f8451a.a("AppstoreSDK Re-initialized");
        }
        if (a("onCreate", activity)) {
            com.amazon.a.a.b().a(activity);
        }
        if (c.f8809a) {
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            f8451a.a("ActivityOnCreate Time: " + (jElapsedRealtime2 - jElapsedRealtime));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (a("onDestroy", activity)) {
            try {
                com.amazon.a.a.b().b(activity);
            } catch (Exception e4) {
                f8451a.b("ActivityOnDestroy Error: ", e4);
            }
        }
        if (c.f8809a) {
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            f8451a.a("ActivityOnDestroy Time: " + (jElapsedRealtime2 - jElapsedRealtime));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (a("onPause", activity)) {
            com.amazon.a.a.b().d(activity);
        }
        if (c.f8809a) {
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            f8451a.a("ActivityOnPause Time: " + (jElapsedRealtime2 - jElapsedRealtime));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (a("onResume", activity)) {
            com.amazon.a.a.b().c(activity);
        }
        if (c.f8809a) {
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            f8451a.a("ActivityOnResume Time: " + (jElapsedRealtime2 - jElapsedRealtime));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        f8451a.a(f8452b + " onActivitySaveInstanceState " + activity.getLocalClassName());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (a("onStart", activity)) {
            com.amazon.a.a.b().e(activity);
        }
        if (c.f8809a) {
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            f8451a.a("ActivityOnStart Time: " + (jElapsedRealtime2 - jElapsedRealtime));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (a("onStop", activity)) {
            com.amazon.a.a.b().f(activity);
        }
        if (c.f8809a) {
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            f8451a.a("ActivityOnStop Time: " + (jElapsedRealtime2 - jElapsedRealtime));
        }
    }

    private static boolean a(String str, Context context) {
        return com.amazon.a.a.a(str, context);
    }
}
