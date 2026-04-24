package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.AbstractC0963i;
import androidx.lifecycle.x;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes.dex */
public final class v implements InterfaceC0967m {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f7820i = new b(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final v f7821j = new v();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7823b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f7826e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7824c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f7825d = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C0968n f7827f = new C0968n(this);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Runnable f7828g = new Runnable() { // from class: androidx.lifecycle.u
        @Override // java.lang.Runnable
        public final void run() {
            v.k(this.f7819a);
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final x.a f7829h = new d();

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7830a = new a();

        public static final void a(Activity activity, Application.ActivityLifecycleCallbacks callback) {
            kotlin.jvm.internal.r.f(activity, "activity");
            kotlin.jvm.internal.r.f(callback, "callback");
            activity.registerActivityLifecycleCallbacks(callback);
        }
    }

    public static final class b {
        public /* synthetic */ b(AbstractC2148j abstractC2148j) {
            this();
        }

        public final InterfaceC0967m a() {
            return v.f7821j;
        }

        public final void b(Context context) {
            kotlin.jvm.internal.r.f(context, "context");
            v.f7821j.j(context);
        }

        public b() {
        }
    }

    public static final class c extends AbstractC0959e {

        public static final class a extends AbstractC0959e {
            final /* synthetic */ v this$0;

            public a(v vVar) {
                this.this$0 = vVar;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostResumed(Activity activity) {
                kotlin.jvm.internal.r.f(activity, "activity");
                this.this$0.f();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostStarted(Activity activity) {
                kotlin.jvm.internal.r.f(activity, "activity");
                this.this$0.g();
            }
        }

        public c() {
        }

        @Override // androidx.lifecycle.AbstractC0959e, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.r.f(activity, "activity");
            if (Build.VERSION.SDK_INT < 29) {
                x.f7834b.b(activity).e(v.this.f7829h);
            }
        }

        @Override // androidx.lifecycle.AbstractC0959e, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            kotlin.jvm.internal.r.f(activity, "activity");
            v.this.e();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.r.f(activity, "activity");
            a.a(activity, new a(v.this));
        }

        @Override // androidx.lifecycle.AbstractC0959e, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            kotlin.jvm.internal.r.f(activity, "activity");
            v.this.i();
        }
    }

    public static final class d implements x.a {
        public d() {
        }

        @Override // androidx.lifecycle.x.a
        public void a() {
            v.this.f();
        }

        @Override // androidx.lifecycle.x.a
        public void b() {
            v.this.g();
        }

        @Override // androidx.lifecycle.x.a
        public void onCreate() {
        }
    }

    public static final void k(v this$0) {
        kotlin.jvm.internal.r.f(this$0, "this$0");
        this$0.l();
        this$0.m();
    }

    public static final InterfaceC0967m n() {
        return f7820i.a();
    }

    @Override // androidx.lifecycle.InterfaceC0967m
    public AbstractC0963i a() {
        return this.f7827f;
    }

    public final void e() {
        int i7 = this.f7823b - 1;
        this.f7823b = i7;
        if (i7 == 0) {
            Handler handler = this.f7826e;
            kotlin.jvm.internal.r.c(handler);
            handler.postDelayed(this.f7828g, 700L);
        }
    }

    public final void f() {
        int i7 = this.f7823b + 1;
        this.f7823b = i7;
        if (i7 == 1) {
            if (this.f7824c) {
                this.f7827f.h(AbstractC0963i.a.ON_RESUME);
                this.f7824c = false;
            } else {
                Handler handler = this.f7826e;
                kotlin.jvm.internal.r.c(handler);
                handler.removeCallbacks(this.f7828g);
            }
        }
    }

    public final void g() {
        int i7 = this.f7822a + 1;
        this.f7822a = i7;
        if (i7 == 1 && this.f7825d) {
            this.f7827f.h(AbstractC0963i.a.ON_START);
            this.f7825d = false;
        }
    }

    public final void i() {
        this.f7822a--;
        m();
    }

    public final void j(Context context) {
        kotlin.jvm.internal.r.f(context, "context");
        this.f7826e = new Handler();
        this.f7827f.h(AbstractC0963i.a.ON_CREATE);
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.r.d(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new c());
    }

    public final void l() {
        if (this.f7823b == 0) {
            this.f7824c = true;
            this.f7827f.h(AbstractC0963i.a.ON_PAUSE);
        }
    }

    public final void m() {
        if (this.f7822a == 0 && this.f7824c) {
            this.f7827f.h(AbstractC0963i.a.ON_STOP);
            this.f7825d = true;
        }
    }
}
