package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0846i;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes.dex */
public class x extends Fragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f7725b = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f7726a;

    public interface a {
        void a();

        void onCreate();

        void onResume();
    }

    public static final class b {
        public /* synthetic */ b(AbstractC1585j abstractC1585j) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(Activity activity, AbstractC0846i.a event) {
            kotlin.jvm.internal.r.f(activity, "activity");
            kotlin.jvm.internal.r.f(event, "event");
            if (activity instanceof InterfaceC0850m) {
                AbstractC0846i lifecycle = ((InterfaceC0850m) activity).getLifecycle();
                if (lifecycle instanceof C0851n) {
                    ((C0851n) lifecycle).h(event);
                }
            }
        }

        public final x b(Activity activity) {
            kotlin.jvm.internal.r.f(activity, "<this>");
            Fragment fragmentFindFragmentByTag = activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
            kotlin.jvm.internal.r.d(fragmentFindFragmentByTag, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            return (x) fragmentFindFragmentByTag;
        }

        public final void c(Activity activity) {
            kotlin.jvm.internal.r.f(activity, "activity");
            if (Build.VERSION.SDK_INT >= 29) {
                c.Companion.a(activity);
            }
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
                fragmentManager.beginTransaction().add(new x(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
                fragmentManager.executePendingTransactions();
            }
        }

        public b() {
        }
    }

    public static final class c implements Application.ActivityLifecycleCallbacks {
        public static final a Companion = new a(null);

        public static final class a {
            public /* synthetic */ a(AbstractC1585j abstractC1585j) {
                this();
            }

            public final void a(Activity activity) {
                kotlin.jvm.internal.r.f(activity, "activity");
                activity.registerActivityLifecycleCallbacks(new c());
            }

            public a() {
            }
        }

        public static final void registerIn(Activity activity) {
            Companion.a(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.r.f(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            kotlin.jvm.internal.r.f(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            kotlin.jvm.internal.r.f(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.r.f(activity, "activity");
            x.f7725b.a(activity, AbstractC0846i.a.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            kotlin.jvm.internal.r.f(activity, "activity");
            x.f7725b.a(activity, AbstractC0846i.a.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            kotlin.jvm.internal.r.f(activity, "activity");
            x.f7725b.a(activity, AbstractC0846i.a.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity) {
            kotlin.jvm.internal.r.f(activity, "activity");
            x.f7725b.a(activity, AbstractC0846i.a.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity) {
            kotlin.jvm.internal.r.f(activity, "activity");
            x.f7725b.a(activity, AbstractC0846i.a.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            kotlin.jvm.internal.r.f(activity, "activity");
            x.f7725b.a(activity, AbstractC0846i.a.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            kotlin.jvm.internal.r.f(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.r.f(activity, "activity");
            kotlin.jvm.internal.r.f(bundle, "bundle");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            kotlin.jvm.internal.r.f(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            kotlin.jvm.internal.r.f(activity, "activity");
        }
    }

    public static final void e(Activity activity) {
        f7725b.c(activity);
    }

    public final void a(AbstractC0846i.a aVar) {
        if (Build.VERSION.SDK_INT < 29) {
            b bVar = f7725b;
            Activity activity = getActivity();
            kotlin.jvm.internal.r.e(activity, "activity");
            bVar.a(activity, aVar);
        }
    }

    public final void b(a aVar) {
        if (aVar != null) {
            aVar.onCreate();
        }
    }

    public final void c(a aVar) {
        if (aVar != null) {
            aVar.onResume();
        }
    }

    public final void d(a aVar) {
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void f(a aVar) {
        this.f7726a = aVar;
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        b(this.f7726a);
        a(AbstractC0846i.a.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a(AbstractC0846i.a.ON_DESTROY);
        this.f7726a = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        a(AbstractC0846i.a.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        c(this.f7726a);
        a(AbstractC0846i.a.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        d(this.f7726a);
        a(AbstractC0846i.a.ON_START);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        a(AbstractC0846i.a.ON_STOP);
    }
}
