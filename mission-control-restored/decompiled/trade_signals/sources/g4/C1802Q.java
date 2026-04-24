package g4;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: g4.Q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1802Q implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC1804T f18073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f18074b;

    public C1802Q(InterfaceC1804T sharedSessionRepository) {
        AbstractC2304t.f(sharedSessionRepository, "sharedSessionRepository");
        this.f18073a = sharedSessionRepository;
        this.f18074b = true;
    }

    public final void a() {
        this.f18074b = false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        AbstractC2304t.f(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        AbstractC2304t.f(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        AbstractC2304t.f(activity, "activity");
        if (this.f18074b) {
            this.f18073a.b();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        AbstractC2304t.f(activity, "activity");
        if (this.f18074b) {
            this.f18073a.c();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        AbstractC2304t.f(activity, "activity");
        AbstractC2304t.f(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        AbstractC2304t.f(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        AbstractC2304t.f(activity, "activity");
    }
}
