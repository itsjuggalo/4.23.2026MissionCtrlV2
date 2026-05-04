package aa;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g0 implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Runnable f466d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f463a = new Handler();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f464b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f465c = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ad.a f467e = ad.a.o();

    public static /* synthetic */ void a(g0 g0Var) {
        boolean z10 = g0Var.f464b;
        g0Var.f464b = !(z10 && g0Var.f465c) && z10;
    }

    public hc.a b() {
        return this.f467e.m(cc.a.BUFFER).C();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.f465c = true;
        Runnable runnable = this.f466d;
        if (runnable != null) {
            this.f463a.removeCallbacks(runnable);
        }
        Handler handler = this.f463a;
        Runnable runnable2 = new Runnable() { // from class: aa.f0
            @Override // java.lang.Runnable
            public final void run() {
                g0.a(this.f443a);
            }
        };
        this.f466d = runnable2;
        handler.postDelayed(runnable2, 1000L);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.f465c = false;
        boolean z10 = this.f464b;
        this.f464b = true;
        Runnable runnable = this.f466d;
        if (runnable != null) {
            this.f463a.removeCallbacks(runnable);
        }
        if (z10) {
            return;
        }
        h2.c("went foreground");
        this.f467e.onNext("ON_FOREGROUND");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
