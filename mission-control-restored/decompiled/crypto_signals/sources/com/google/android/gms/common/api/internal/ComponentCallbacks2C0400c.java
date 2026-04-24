package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.google.android.gms.common.api.internal.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class ComponentCallbacks2C0400c implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    public static final ComponentCallbacks2C0400c e = new ComponentCallbacks2C0400c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f5142a = new AtomicBoolean();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f5143b = new AtomicBoolean();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f5144c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5145d = false;

    public static void b(Application application) {
        ComponentCallbacks2C0400c componentCallbacks2C0400c = e;
        synchronized (componentCallbacks2C0400c) {
            try {
                if (!componentCallbacks2C0400c.f5145d) {
                    application.registerActivityLifecycleCallbacks(componentCallbacks2C0400c);
                    application.registerComponentCallbacks(componentCallbacks2C0400c);
                    componentCallbacks2C0400c.f5145d = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a(InterfaceC0399b interfaceC0399b) {
        synchronized (e) {
            this.f5144c.add(interfaceC0399b);
        }
    }

    public final void c(boolean z6) {
        synchronized (e) {
            try {
                Iterator it = this.f5144c.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0399b) it.next()).a(z6);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AtomicBoolean atomicBoolean = this.f5143b;
        boolean zCompareAndSet = this.f5142a.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (zCompareAndSet) {
            c(false);
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
        AtomicBoolean atomicBoolean = this.f5143b;
        boolean zCompareAndSet = this.f5142a.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (zCompareAndSet) {
            c(false);
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
    public final void onTrimMemory(int i) {
        if (i == 20 && this.f5142a.compareAndSet(false, true)) {
            this.f5143b.set(true);
            c(true);
        }
    }
}
