package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.i;
import androidx.lifecycle.x;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class v implements m {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f2472i = new b(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final v f2473j = new v();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2475b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f2478e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2476c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2477d = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n f2479f = new n(this);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Runnable f2480g = new Runnable() { // from class: androidx.lifecycle.u
        @Override // java.lang.Runnable
        public final void run() {
            v.i(this.f2471a);
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final x.a f2481h = new d();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f2482a = new a();

        public static final void a(Activity activity, Application.ActivityLifecycleCallbacks callback) {
            kotlin.jvm.internal.t.f(activity, "activity");
            kotlin.jvm.internal.t.f(callback, "callback");
            activity.registerActivityLifecycleCallbacks(callback);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final m a() {
            return v.f2473j;
        }

        public final void b(Context context) {
            kotlin.jvm.internal.t.f(context, "context");
            v.f2473j.h(context);
        }

        public b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends e {

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a extends e {
            final /* synthetic */ v this$0;

            public a(v vVar) {
                this.this$0 = vVar;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostResumed(Activity activity) {
                kotlin.jvm.internal.t.f(activity, "activity");
                this.this$0.e();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostStarted(Activity activity) {
                kotlin.jvm.internal.t.f(activity, "activity");
                this.this$0.f();
            }
        }

        public c() {
        }

        @Override // androidx.lifecycle.e, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.t.f(activity, "activity");
            if (Build.VERSION.SDK_INT < 29) {
                x.f2486b.b(activity).f(v.this.f2481h);
            }
        }

        @Override // androidx.lifecycle.e, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            kotlin.jvm.internal.t.f(activity, "activity");
            v.this.d();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.t.f(activity, "activity");
            a.a(activity, new a(v.this));
        }

        @Override // androidx.lifecycle.e, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            kotlin.jvm.internal.t.f(activity, "activity");
            v.this.g();
        }
    }

    public static final void i(v this$0) {
        kotlin.jvm.internal.t.f(this$0, "this$0");
        this$0.j();
        this$0.k();
    }

    public static final m l() {
        return f2472i.a();
    }

    public final void d() {
        int i10 = this.f2475b - 1;
        this.f2475b = i10;
        if (i10 == 0) {
            Handler handler = this.f2478e;
            kotlin.jvm.internal.t.c(handler);
            handler.postDelayed(this.f2480g, 700L);
        }
    }

    public final void e() {
        int i10 = this.f2475b + 1;
        this.f2475b = i10;
        if (i10 == 1) {
            if (this.f2476c) {
                this.f2479f.h(i.a.ON_RESUME);
                this.f2476c = false;
            } else {
                Handler handler = this.f2478e;
                kotlin.jvm.internal.t.c(handler);
                handler.removeCallbacks(this.f2480g);
            }
        }
    }

    public final void f() {
        int i10 = this.f2474a + 1;
        this.f2474a = i10;
        if (i10 == 1 && this.f2477d) {
            this.f2479f.h(i.a.ON_START);
            this.f2477d = false;
        }
    }

    public final void g() {
        this.f2474a--;
        k();
    }

    @Override // androidx.lifecycle.m
    public i getLifecycle() {
        return this.f2479f;
    }

    public final void h(Context context) {
        kotlin.jvm.internal.t.f(context, "context");
        this.f2478e = new Handler();
        this.f2479f.h(i.a.ON_CREATE);
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.t.d(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new c());
    }

    public final void j() {
        if (this.f2475b == 0) {
            this.f2476c = true;
            this.f2479f.h(i.a.ON_PAUSE);
        }
    }

    public final void k() {
        if (this.f2474a == 0 && this.f2476c) {
            this.f2479f.h(i.a.ON_STOP);
            this.f2477d = true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d implements x.a {
        public d() {
        }

        @Override // androidx.lifecycle.x.a
        public void a() {
            v.this.f();
        }

        @Override // androidx.lifecycle.x.a
        public void onResume() {
            v.this.e();
        }

        @Override // androidx.lifecycle.x.a
        public void onCreate() {
        }
    }
}
