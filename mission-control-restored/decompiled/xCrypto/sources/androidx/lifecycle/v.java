package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.AbstractC0846i;
import androidx.lifecycle.x;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes.dex */
public final class v implements InterfaceC0850m {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b f7711j = new b(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final v f7712k = new v();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7714b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Handler f7717f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7715c = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f7716e = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C0851n f7718g = new C0851n(this);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Runnable f7719h = new Runnable() { // from class: androidx.lifecycle.u
        @Override // java.lang.Runnable
        public final void run() {
            v.i(this.f7710a);
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final x.a f7720i = new d();

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7721a = new a();

        public static final void a(Activity activity, Application.ActivityLifecycleCallbacks callback) {
            kotlin.jvm.internal.r.f(activity, "activity");
            kotlin.jvm.internal.r.f(callback, "callback");
            activity.registerActivityLifecycleCallbacks(callback);
        }
    }

    public static final class b {
        public /* synthetic */ b(AbstractC1585j abstractC1585j) {
            this();
        }

        public final InterfaceC0850m a() {
            return v.f7712k;
        }

        public final void b(Context context) {
            kotlin.jvm.internal.r.f(context, "context");
            v.f7712k.h(context);
        }

        public b() {
        }
    }

    public static final class c extends AbstractC0842e {

        public static final class a extends AbstractC0842e {
            final /* synthetic */ v this$0;

            public a(v vVar) {
                this.this$0 = vVar;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostResumed(Activity activity) {
                kotlin.jvm.internal.r.f(activity, "activity");
                this.this$0.e();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostStarted(Activity activity) {
                kotlin.jvm.internal.r.f(activity, "activity");
                this.this$0.f();
            }
        }

        public c() {
        }

        @Override // androidx.lifecycle.AbstractC0842e, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.r.f(activity, "activity");
            if (Build.VERSION.SDK_INT < 29) {
                x.f7725b.b(activity).f(v.this.f7720i);
            }
        }

        @Override // androidx.lifecycle.AbstractC0842e, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            kotlin.jvm.internal.r.f(activity, "activity");
            v.this.d();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.r.f(activity, "activity");
            a.a(activity, new a(v.this));
        }

        @Override // androidx.lifecycle.AbstractC0842e, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            kotlin.jvm.internal.r.f(activity, "activity");
            v.this.g();
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
        public void onCreate() {
        }

        @Override // androidx.lifecycle.x.a
        public void onResume() {
            v.this.e();
        }
    }

    public static final void i(v this$0) {
        kotlin.jvm.internal.r.f(this$0, "this$0");
        this$0.j();
        this$0.k();
    }

    public static final InterfaceC0850m l() {
        return f7711j.a();
    }

    public final void d() {
        int i4 = this.f7714b - 1;
        this.f7714b = i4;
        if (i4 == 0) {
            Handler handler = this.f7717f;
            kotlin.jvm.internal.r.c(handler);
            handler.postDelayed(this.f7719h, 700L);
        }
    }

    public final void e() {
        int i4 = this.f7714b + 1;
        this.f7714b = i4;
        if (i4 == 1) {
            if (this.f7715c) {
                this.f7718g.h(AbstractC0846i.a.ON_RESUME);
                this.f7715c = false;
            } else {
                Handler handler = this.f7717f;
                kotlin.jvm.internal.r.c(handler);
                handler.removeCallbacks(this.f7719h);
            }
        }
    }

    public final void f() {
        int i4 = this.f7713a + 1;
        this.f7713a = i4;
        if (i4 == 1 && this.f7716e) {
            this.f7718g.h(AbstractC0846i.a.ON_START);
            this.f7716e = false;
        }
    }

    public final void g() {
        this.f7713a--;
        k();
    }

    @Override // androidx.lifecycle.InterfaceC0850m
    public AbstractC0846i getLifecycle() {
        return this.f7718g;
    }

    public final void h(Context context) {
        kotlin.jvm.internal.r.f(context, "context");
        this.f7717f = new Handler();
        this.f7718g.h(AbstractC0846i.a.ON_CREATE);
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.r.d(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new c());
    }

    public final void j() {
        if (this.f7714b == 0) {
            this.f7715c = true;
            this.f7718g.h(AbstractC0846i.a.ON_PAUSE);
        }
    }

    public final void k() {
        if (this.f7713a == 0 && this.f7715c) {
            this.f7718g.h(AbstractC0846i.a.ON_STOP);
            this.f7716e = true;
        }
    }
}
