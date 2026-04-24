package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class J extends Fragment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f4636b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Y3.j f4637a;

    public static final class a implements Application.ActivityLifecycleCallbacks {
        public static final I Companion = new I();

        public static final void registerIn(Activity activity) {
            Companion.getClass();
            kotlin.jvm.internal.j.e(activity, "activity");
            activity.registerActivityLifecycleCallbacks(new a());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.j.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            kotlin.jvm.internal.j.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            kotlin.jvm.internal.j.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.j.e(activity, "activity");
            int i = J.f4636b;
            H.a(activity, EnumC0356m.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            kotlin.jvm.internal.j.e(activity, "activity");
            int i = J.f4636b;
            H.a(activity, EnumC0356m.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            kotlin.jvm.internal.j.e(activity, "activity");
            int i = J.f4636b;
            H.a(activity, EnumC0356m.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity) {
            kotlin.jvm.internal.j.e(activity, "activity");
            int i = J.f4636b;
            H.a(activity, EnumC0356m.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity) {
            kotlin.jvm.internal.j.e(activity, "activity");
            int i = J.f4636b;
            H.a(activity, EnumC0356m.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            kotlin.jvm.internal.j.e(activity, "activity");
            int i = J.f4636b;
            H.a(activity, EnumC0356m.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            kotlin.jvm.internal.j.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            kotlin.jvm.internal.j.e(activity, "activity");
            kotlin.jvm.internal.j.e(bundle, "bundle");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            kotlin.jvm.internal.j.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            kotlin.jvm.internal.j.e(activity, "activity");
        }
    }

    public final void a(EnumC0356m enumC0356m) {
        if (Build.VERSION.SDK_INT < 29) {
            Activity activity = getActivity();
            kotlin.jvm.internal.j.d(activity, "activity");
            H.a(activity, enumC0356m);
        }
    }

    @Override // android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(EnumC0356m.ON_CREATE);
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        a(EnumC0356m.ON_DESTROY);
        this.f4637a = null;
    }

    @Override // android.app.Fragment
    public final void onPause() {
        super.onPause();
        a(EnumC0356m.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        Y3.j jVar = this.f4637a;
        if (jVar != null) {
            ((G) jVar.f3665b).c();
        }
        a(EnumC0356m.ON_RESUME);
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        Y3.j jVar = this.f4637a;
        if (jVar != null) {
            G g2 = (G) jVar.f3665b;
            int i = g2.f4629a + 1;
            g2.f4629a = i;
            if (i == 1 && g2.f4632d) {
                g2.f4633f.e(EnumC0356m.ON_START);
                g2.f4632d = false;
            }
        }
        a(EnumC0356m.ON_START);
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        a(EnumC0356m.ON_STOP);
    }
}
