package com.revenuecat.purchases.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public interface CustomActivityLifecycleHandler extends Application.ActivityLifecycleCallbacks {

    public static final class DefaultImpls {
        @Deprecated
        public static void onActivityCreated(CustomActivityLifecycleHandler customActivityLifecycleHandler, Activity activity, Bundle bundle) {
            r.f(activity, "activity");
            CustomActivityLifecycleHandler.super.onActivityCreated(activity, bundle);
        }

        @Deprecated
        public static void onActivityDestroyed(CustomActivityLifecycleHandler customActivityLifecycleHandler, Activity activity) {
            r.f(activity, "activity");
            CustomActivityLifecycleHandler.super.onActivityDestroyed(activity);
        }

        @Deprecated
        public static void onActivityPaused(CustomActivityLifecycleHandler customActivityLifecycleHandler, Activity activity) {
            r.f(activity, "activity");
            CustomActivityLifecycleHandler.super.onActivityPaused(activity);
        }

        @Deprecated
        public static void onActivityResumed(CustomActivityLifecycleHandler customActivityLifecycleHandler, Activity activity) {
            r.f(activity, "activity");
            CustomActivityLifecycleHandler.super.onActivityResumed(activity);
        }

        @Deprecated
        public static void onActivitySaveInstanceState(CustomActivityLifecycleHandler customActivityLifecycleHandler, Activity activity, Bundle outState) {
            r.f(activity, "activity");
            r.f(outState, "outState");
            CustomActivityLifecycleHandler.super.onActivitySaveInstanceState(activity, outState);
        }

        @Deprecated
        public static void onActivityStarted(CustomActivityLifecycleHandler customActivityLifecycleHandler, Activity activity) {
            r.f(activity, "activity");
            CustomActivityLifecycleHandler.super.onActivityStarted(activity);
        }

        @Deprecated
        public static void onActivityStopped(CustomActivityLifecycleHandler customActivityLifecycleHandler, Activity activity) {
            r.f(activity, "activity");
            CustomActivityLifecycleHandler.super.onActivityStopped(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    default void onActivityCreated(Activity activity, Bundle bundle) {
        r.f(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    default void onActivityDestroyed(Activity activity) {
        r.f(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    default void onActivityPaused(Activity activity) {
        r.f(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    default void onActivityResumed(Activity activity) {
        r.f(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    default void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        r.f(activity, "activity");
        r.f(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    default void onActivityStarted(Activity activity) {
        r.f(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    default void onActivityStopped(Activity activity) {
        r.f(activity, "activity");
    }
}
