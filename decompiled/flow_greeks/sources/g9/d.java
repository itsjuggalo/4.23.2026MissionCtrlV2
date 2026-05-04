package g9;

import android.app.Activity;
import android.app.Fragment;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f10180a;

        public b() {
            this.f10180a = new ArrayList();
        }

        public synchronized void a(Runnable runnable) {
            this.f10180a.add(runnable);
        }

        public void b() {
            for (Runnable runnable : this.f10180a) {
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c extends Fragment {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f10181a = new b();

        @Override // android.app.Fragment
        public void onStop() {
            b bVar;
            super.onStop();
            synchronized (this.f10181a) {
                bVar = this.f10181a;
                this.f10181a = new b();
            }
            bVar.b();
        }
    }

    /* JADX INFO: renamed from: g9.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class C0186d extends androidx.fragment.app.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f10182a = new b();

        @Override // androidx.fragment.app.p
        public void onStop() {
            b bVar;
            super.onStop();
            synchronized (this.f10182a) {
                bVar = this.f10182a;
                this.f10182a = new b();
            }
            bVar.b();
        }
    }

    public static /* synthetic */ void a(androidx.fragment.app.u uVar, Runnable runnable) {
        C0186d c0186d = (C0186d) d(C0186d.class, uVar.getSupportFragmentManager().j0("FirestoreOnStopObserverSupportFragment"), "FirestoreOnStopObserverSupportFragment");
        if (c0186d == null || c0186d.isRemoving()) {
            c0186d = new C0186d();
            uVar.getSupportFragmentManager().o().d(c0186d, "FirestoreOnStopObserverSupportFragment").g();
            uVar.getSupportFragmentManager().f0();
        }
        c0186d.f10182a.a(runnable);
    }

    public static /* synthetic */ void b(Activity activity, Runnable runnable) {
        c cVar = (c) d(c.class, activity.getFragmentManager().findFragmentByTag("FirestoreOnStopObserverFragment"), "FirestoreOnStopObserverFragment");
        if (cVar == null || cVar.isRemoving()) {
            cVar = new c();
            activity.getFragmentManager().beginTransaction().add(cVar, "FirestoreOnStopObserverFragment").commitAllowingStateLoss();
            activity.getFragmentManager().executePendingTransactions();
        }
        cVar.f10181a.a(runnable);
    }

    public static d9.t0 c(Activity activity, final d9.t0 t0Var) {
        if (activity != null) {
            if (activity instanceof androidx.fragment.app.u) {
                Objects.requireNonNull(t0Var);
                f((androidx.fragment.app.u) activity, new Runnable() { // from class: g9.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        t0Var.remove();
                    }
                });
                return t0Var;
            }
            Objects.requireNonNull(t0Var);
            e(activity, new Runnable() { // from class: g9.a
                @Override // java.lang.Runnable
                public final void run() {
                    t0Var.remove();
                }
            });
        }
        return t0Var;
    }

    public static Object d(Class cls, Object obj, String str) {
        if (obj == null) {
            return null;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException unused) {
            throw new IllegalStateException("Fragment with tag '" + str + "' is a " + obj.getClass().getName() + " but should be a " + cls.getName());
        }
    }

    public static void e(final Activity activity, final Runnable runnable) {
        n9.b.d(!(activity instanceof androidx.fragment.app.u), "onActivityStopCallOnce must be called with a *non*-FragmentActivity Activity.", new Object[0]);
        activity.runOnUiThread(new Runnable() { // from class: g9.c
            @Override // java.lang.Runnable
            public final void run() {
                d.b(activity, runnable);
            }
        });
    }

    public static void f(final androidx.fragment.app.u uVar, final Runnable runnable) {
        uVar.runOnUiThread(new Runnable() { // from class: g9.b
            @Override // java.lang.Runnable
            public final void run() {
                d.a(uVar, runnable);
            }
        });
    }
}
