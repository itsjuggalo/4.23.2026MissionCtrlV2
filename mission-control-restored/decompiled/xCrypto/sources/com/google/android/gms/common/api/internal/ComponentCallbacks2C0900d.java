package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.google.android.gms.common.api.internal.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class ComponentCallbacks2C0900d implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ComponentCallbacks2C0900d f9759f = new ComponentCallbacks2C0900d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f9760a = new AtomicBoolean();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f9761b = new AtomicBoolean();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f9762c = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f9763e = false;

    /* JADX INFO: renamed from: com.google.android.gms.common.api.internal.d$a */
    public interface a {
        void onBackgroundStateChanged(boolean z4);
    }

    public static ComponentCallbacks2C0900d b() {
        return f9759f;
    }

    public static void c(Application application) {
        ComponentCallbacks2C0900d componentCallbacks2C0900d = f9759f;
        synchronized (componentCallbacks2C0900d) {
            try {
                if (!componentCallbacks2C0900d.f9763e) {
                    application.registerActivityLifecycleCallbacks(componentCallbacks2C0900d);
                    application.registerComponentCallbacks(componentCallbacks2C0900d);
                    componentCallbacks2C0900d.f9763e = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(a aVar) {
        synchronized (f9759f) {
            this.f9762c.add(aVar);
        }
    }

    public boolean d() {
        return this.f9760a.get();
    }

    public boolean e(boolean z4) {
        if (!this.f9761b.get()) {
            if (G1.p.b()) {
                return z4;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.f9761b.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f9760a.set(true);
            }
        }
        return d();
    }

    public final void f(boolean z4) {
        synchronized (f9759f) {
            try {
                Iterator it = this.f9762c.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).onBackgroundStateChanged(z4);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AtomicBoolean atomicBoolean = this.f9761b;
        boolean zCompareAndSet = this.f9760a.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (zCompareAndSet) {
            f(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        AtomicBoolean atomicBoolean = this.f9761b;
        boolean zCompareAndSet = this.f9760a.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (zCompareAndSet) {
            f(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i4) {
        if (i4 == 20 && this.f9760a.compareAndSet(false, true)) {
            this.f9761b.set(true);
            f(true);
        }
    }
}
