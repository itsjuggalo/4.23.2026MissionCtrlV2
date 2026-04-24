package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0963i;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes.dex */
public class x extends Fragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f7834b = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f7835a;

    public interface a {
        void a();

        void b();

        void onCreate();
    }

    public static final class b {
        public /* synthetic */ b(AbstractC2148j abstractC2148j) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(Activity activity, AbstractC0963i.a event) {
            kotlin.jvm.internal.r.f(activity, "activity");
            kotlin.jvm.internal.r.f(event, "event");
            if (activity instanceof InterfaceC0967m) {
                AbstractC0963i abstractC0963iA = ((InterfaceC0967m) activity).a();
                if (abstractC0963iA instanceof C0968n) {
                    ((C0968n) abstractC0963iA).h(event);
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
            public /* synthetic */ a(AbstractC2148j abstractC2148j) {
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
            x.f7834b.a(activity, AbstractC0963i.a.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            kotlin.jvm.internal.r.f(activity, "activity");
            x.f7834b.a(activity, AbstractC0963i.a.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            kotlin.jvm.internal.r.f(activity, "activity");
            x.f7834b.a(activity, AbstractC0963i.a.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity) {
            kotlin.jvm.internal.r.f(activity, "activity");
            x.f7834b.a(activity, AbstractC0963i.a.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity) {
            kotlin.jvm.internal.r.f(activity, "activity");
            x.f7834b.a(activity, AbstractC0963i.a.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            kotlin.jvm.internal.r.f(activity, "activity");
            x.f7834b.a(activity, AbstractC0963i.a.ON_STOP);
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

    public final void a(AbstractC0963i.a aVar) {
        if (Build.VERSION.SDK_INT < 29) {
            b bVar = f7834b;
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
            aVar.a();
        }
    }

    public final void d(a aVar) {
        if (aVar != null) {
            aVar.b();
        }
    }

    public final void e(a aVar) {
        this.f7835a = aVar;
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        b(this.f7835a);
        a(AbstractC0963i.a.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a(AbstractC0963i.a.ON_DESTROY);
        this.f7835a = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        a(AbstractC0963i.a.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        c(this.f7835a);
        a(AbstractC0963i.a.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        d(this.f7835a);
        a(AbstractC0963i.a.ON_START);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        a(AbstractC0963i.a.ON_STOP);
    }
}
