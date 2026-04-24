package Z3;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class I implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final I f5871a = new I();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f5872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static E f5873c;

    public final void a(E e7) {
        f5873c = e7;
        if (e7 == null || !f5872b) {
            return;
        }
        f5872b = false;
        e7.k();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        kotlin.jvm.internal.r.f(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        kotlin.jvm.internal.r.f(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        kotlin.jvm.internal.r.f(activity, "activity");
        E e7 = f5873c;
        if (e7 != null) {
            e7.h();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        E5.E e7;
        kotlin.jvm.internal.r.f(activity, "activity");
        E e8 = f5873c;
        if (e8 != null) {
            e8.k();
            e7 = E5.E.f1657a;
        } else {
            e7 = null;
        }
        if (e7 == null) {
            f5872b = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        kotlin.jvm.internal.r.f(activity, "activity");
        kotlin.jvm.internal.r.f(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        kotlin.jvm.internal.r.f(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        kotlin.jvm.internal.r.f(activity, "activity");
    }
}
