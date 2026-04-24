package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.AbstractC1157i;
import androidx.lifecycle.x;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class v implements InterfaceC1161m {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f12007i = new b(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final v f12008j = new v();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12010b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f12013e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12011c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f12012d = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C1162n f12014f = new C1162n(this);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Runnable f12015g = new Runnable() { // from class: androidx.lifecycle.u
        @Override // java.lang.Runnable
        public final void run() {
            v.i(this.f12006a);
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final x.a f12016h = new d();

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12017a = new a();

        public static final void a(Activity activity, Application.ActivityLifecycleCallbacks callback) {
            AbstractC2304t.f(activity, "activity");
            AbstractC2304t.f(callback, "callback");
            activity.registerActivityLifecycleCallbacks(callback);
        }
    }

    public static final class b {
        public b() {
        }

        public final InterfaceC1161m a() {
            return v.f12008j;
        }

        public final void b(Context context) {
            AbstractC2304t.f(context, "context");
            v.f12008j.h(context);
        }

        public /* synthetic */ b(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public static final class c extends AbstractC1153e {

        public static final class a extends AbstractC1153e {
            final /* synthetic */ v this$0;

            public a(v vVar) {
                this.this$0 = vVar;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostResumed(Activity activity) {
                AbstractC2304t.f(activity, "activity");
                this.this$0.e();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostStarted(Activity activity) {
                AbstractC2304t.f(activity, "activity");
                this.this$0.f();
            }
        }

        public c() {
        }

        @Override // androidx.lifecycle.AbstractC1153e, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            AbstractC2304t.f(activity, "activity");
            if (Build.VERSION.SDK_INT < 29) {
                x.f12021b.b(activity).f(v.this.f12016h);
            }
        }

        @Override // androidx.lifecycle.AbstractC1153e, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            AbstractC2304t.f(activity, "activity");
            v.this.d();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            AbstractC2304t.f(activity, "activity");
            a.a(activity, new a(v.this));
        }

        @Override // androidx.lifecycle.AbstractC1153e, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            AbstractC2304t.f(activity, "activity");
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
        public void b() {
            v.this.e();
        }

        @Override // androidx.lifecycle.x.a
        public void onCreate() {
        }
    }

    public static final void i(v this$0) {
        AbstractC2304t.f(this$0, "this$0");
        this$0.j();
        this$0.k();
    }

    public static final InterfaceC1161m l() {
        return f12007i.a();
    }

    public final void d() {
        int i8 = this.f12010b - 1;
        this.f12010b = i8;
        if (i8 == 0) {
            Handler handler = this.f12013e;
            AbstractC2304t.c(handler);
            handler.postDelayed(this.f12015g, 700L);
        }
    }

    public final void e() {
        int i8 = this.f12010b + 1;
        this.f12010b = i8;
        if (i8 == 1) {
            if (this.f12011c) {
                this.f12014f.h(AbstractC1157i.a.ON_RESUME);
                this.f12011c = false;
            } else {
                Handler handler = this.f12013e;
                AbstractC2304t.c(handler);
                handler.removeCallbacks(this.f12015g);
            }
        }
    }

    public final void f() {
        int i8 = this.f12009a + 1;
        this.f12009a = i8;
        if (i8 == 1 && this.f12012d) {
            this.f12014f.h(AbstractC1157i.a.ON_START);
            this.f12012d = false;
        }
    }

    public final void g() {
        this.f12009a--;
        k();
    }

    @Override // androidx.lifecycle.InterfaceC1161m
    public AbstractC1157i getLifecycle() {
        return this.f12014f;
    }

    public final void h(Context context) {
        AbstractC2304t.f(context, "context");
        this.f12013e = new Handler();
        this.f12014f.h(AbstractC1157i.a.ON_CREATE);
        Context applicationContext = context.getApplicationContext();
        AbstractC2304t.d(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new c());
    }

    public final void j() {
        if (this.f12010b == 0) {
            this.f12011c = true;
            this.f12014f.h(AbstractC1157i.a.ON_PAUSE);
        }
    }

    public final void k() {
        if (this.f12009a == 0 && this.f12011c) {
            this.f12014f.h(AbstractC1157i.a.ON_STOP);
            this.f12012d = true;
        }
    }
}
