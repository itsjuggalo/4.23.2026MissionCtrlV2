package S1;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: S1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class ComponentCallbacks2C0871c implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ComponentCallbacks2C0871c f7398e = new ComponentCallbacks2C0871c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f7399a = new AtomicBoolean();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f7400b = new AtomicBoolean();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f7401c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f7402d = false;

    /* JADX INFO: renamed from: S1.c$a */
    public interface a {
        void a(boolean z7);
    }

    public static ComponentCallbacks2C0871c b() {
        return f7398e;
    }

    public static void c(Application application) {
        ComponentCallbacks2C0871c componentCallbacks2C0871c = f7398e;
        synchronized (componentCallbacks2C0871c) {
            try {
                if (!componentCallbacks2C0871c.f7402d) {
                    application.registerActivityLifecycleCallbacks(componentCallbacks2C0871c);
                    application.registerComponentCallbacks(componentCallbacks2C0871c);
                    componentCallbacks2C0871c.f7402d = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(a aVar) {
        synchronized (f7398e) {
            this.f7401c.add(aVar);
        }
    }

    public boolean d() {
        return this.f7399a.get();
    }

    public boolean e(boolean z7) {
        if (!this.f7400b.get()) {
            if (W1.o.b()) {
                return z7;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.f7400b.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f7399a.set(true);
            }
        }
        return d();
    }

    public final void f(boolean z7) {
        synchronized (f7398e) {
            try {
                Iterator it = this.f7401c.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).a(z7);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AtomicBoolean atomicBoolean = this.f7400b;
        boolean zCompareAndSet = this.f7399a.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (zCompareAndSet) {
            f(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        AtomicBoolean atomicBoolean = this.f7400b;
        boolean zCompareAndSet = this.f7399a.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (zCompareAndSet) {
            f(false);
        }
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i8) {
        if (i8 == 20 && this.f7399a.compareAndSet(false, true)) {
            this.f7400b.set(true);
            f(true);
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
