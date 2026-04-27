package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.AbstractC1157i;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public class x extends Fragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f12021b = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f12022a;

    public interface a {
        void a();

        void b();

        void onCreate();
    }

    public static final class b {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(Activity activity, AbstractC1157i.a event) {
            AbstractC2304t.f(activity, "activity");
            AbstractC2304t.f(event, "event");
            if (activity instanceof InterfaceC1161m) {
                AbstractC1157i lifecycle = ((InterfaceC1161m) activity).getLifecycle();
                if (lifecycle instanceof C1162n) {
                    ((C1162n) lifecycle).h(event);
                }
            }
        }

        public final x b(Activity activity) {
            AbstractC2304t.f(activity, "<this>");
            Fragment fragmentFindFragmentByTag = activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
            AbstractC2304t.d(fragmentFindFragmentByTag, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            return (x) fragmentFindFragmentByTag;
        }

        public final void c(Activity activity) {
            AbstractC2304t.f(activity, "activity");
            if (Build.VERSION.SDK_INT >= 29) {
                c.Companion.a(activity);
            }
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
                fragmentManager.beginTransaction().add(new x(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
                fragmentManager.executePendingTransactions();
            }
        }

        public /* synthetic */ b(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public static final class c implements Application.ActivityLifecycleCallbacks {
        public static final a Companion = new a(null);

        public static final class a {
            public a() {
            }

            public final void a(Activity activity) {
                AbstractC2304t.f(activity, "activity");
                activity.registerActivityLifecycleCallbacks(new c());
            }

            public /* synthetic */ a(AbstractC2296k abstractC2296k) {
                this();
            }
        }

        public static final void registerIn(Activity activity) {
            Companion.a(activity);
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
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            AbstractC2304t.f(activity, "activity");
            x.f12021b.a(activity, AbstractC1157i.a.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            AbstractC2304t.f(activity, "activity");
            x.f12021b.a(activity, AbstractC1157i.a.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            AbstractC2304t.f(activity, "activity");
            x.f12021b.a(activity, AbstractC1157i.a.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity) {
            AbstractC2304t.f(activity, "activity");
            x.f12021b.a(activity, AbstractC1157i.a.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity) {
            AbstractC2304t.f(activity, "activity");
            x.f12021b.a(activity, AbstractC1157i.a.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            AbstractC2304t.f(activity, "activity");
            x.f12021b.a(activity, AbstractC1157i.a.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            AbstractC2304t.f(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            AbstractC2304t.f(activity, "activity");
            AbstractC2304t.f(bundle, "bundle");
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

    public static final void e(Activity activity) {
        f12021b.c(activity);
    }

    public final void a(AbstractC1157i.a aVar) {
        if (Build.VERSION.SDK_INT < 29) {
            b bVar = f12021b;
            Activity activity = getActivity();
            AbstractC2304t.e(activity, "activity");
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
            aVar.b();
        }
    }

    public final void d(a aVar) {
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void f(a aVar) {
        this.f12022a = aVar;
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        b(this.f12022a);
        a(AbstractC1157i.a.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a(AbstractC1157i.a.ON_DESTROY);
        this.f12022a = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        a(AbstractC1157i.a.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        c(this.f12022a);
        a(AbstractC1157i.a.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        d(this.f12022a);
        a(AbstractC1157i.a.ON_START);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        a(AbstractC1157i.a.ON_STOP);
    }
}
