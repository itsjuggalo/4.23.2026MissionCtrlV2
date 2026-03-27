package com.google.firebase.firestore.core;

import android.app.Activity;
import android.app.Fragment;
import androidx.fragment.app.AbstractActivityC0832u;
import androidx.fragment.app.AbstractComponentCallbacksC0828p;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class ActivityScope {
    private static final String FRAGMENT_TAG = "FirestoreOnStopObserverFragment";
    private static final String SUPPORT_FRAGMENT_TAG = "FirestoreOnStopObserverSupportFragment";

    public static class CallbackList {
        private final List<Runnable> callbacks;

        private CallbackList() {
            this.callbacks = new ArrayList();
        }

        public synchronized void add(Runnable runnable) {
            this.callbacks.add(runnable);
        }

        public void run() {
            for (Runnable runnable : this.callbacks) {
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }

    public static class StopListenerFragment extends Fragment {
        CallbackList callbacks = new CallbackList();

        @Override // android.app.Fragment
        public void onStop() {
            CallbackList callbackList;
            super.onStop();
            synchronized (this.callbacks) {
                callbackList = this.callbacks;
                this.callbacks = new CallbackList();
            }
            callbackList.run();
        }
    }

    public static class StopListenerSupportFragment extends AbstractComponentCallbacksC0828p {
        CallbackList callbacks = new CallbackList();

        @Override // androidx.fragment.app.AbstractComponentCallbacksC0828p
        public void onStop() {
            CallbackList callbackList;
            super.onStop();
            synchronized (this.callbacks) {
                callbackList = this.callbacks;
                this.callbacks = new CallbackList();
            }
            callbackList.run();
        }
    }

    public static /* synthetic */ void a(AbstractActivityC0832u abstractActivityC0832u, Runnable runnable) {
        StopListenerSupportFragment stopListenerSupportFragment = (StopListenerSupportFragment) castFragment(StopListenerSupportFragment.class, abstractActivityC0832u.getSupportFragmentManager().j0(SUPPORT_FRAGMENT_TAG), SUPPORT_FRAGMENT_TAG);
        if (stopListenerSupportFragment == null || stopListenerSupportFragment.isRemoving()) {
            stopListenerSupportFragment = new StopListenerSupportFragment();
            abstractActivityC0832u.getSupportFragmentManager().o().d(stopListenerSupportFragment, SUPPORT_FRAGMENT_TAG).g();
            abstractActivityC0832u.getSupportFragmentManager().f0();
        }
        stopListenerSupportFragment.callbacks.add(runnable);
    }

    public static /* synthetic */ void b(Activity activity, Runnable runnable) {
        StopListenerFragment stopListenerFragment = (StopListenerFragment) castFragment(StopListenerFragment.class, activity.getFragmentManager().findFragmentByTag(FRAGMENT_TAG), FRAGMENT_TAG);
        if (stopListenerFragment == null || stopListenerFragment.isRemoving()) {
            stopListenerFragment = new StopListenerFragment();
            activity.getFragmentManager().beginTransaction().add(stopListenerFragment, FRAGMENT_TAG).commitAllowingStateLoss();
            activity.getFragmentManager().executePendingTransactions();
        }
        stopListenerFragment.callbacks.add(runnable);
    }

    public static ListenerRegistration bind(Activity activity, final ListenerRegistration listenerRegistration) {
        if (activity != null) {
            if (activity instanceof AbstractActivityC0832u) {
                Objects.requireNonNull(listenerRegistration);
                onFragmentActivityStopCallOnce((AbstractActivityC0832u) activity, new Runnable() { // from class: com.google.firebase.firestore.core.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        listenerRegistration.remove();
                    }
                });
                return listenerRegistration;
            }
            Objects.requireNonNull(listenerRegistration);
            onActivityStopCallOnce(activity, new Runnable() { // from class: com.google.firebase.firestore.core.a
                @Override // java.lang.Runnable
                public final void run() {
                    listenerRegistration.remove();
                }
            });
        }
        return listenerRegistration;
    }

    private static <T> T castFragment(Class<T> cls, Object obj, String str) {
        if (obj == null) {
            return null;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException unused) {
            throw new IllegalStateException("Fragment with tag '" + str + "' is a " + obj.getClass().getName() + " but should be a " + cls.getName());
        }
    }

    private static void onActivityStopCallOnce(final Activity activity, final Runnable runnable) {
        Assert.hardAssert(!(activity instanceof AbstractActivityC0832u), "onActivityStopCallOnce must be called with a *non*-FragmentActivity Activity.", new Object[0]);
        activity.runOnUiThread(new Runnable() { // from class: com.google.firebase.firestore.core.c
            @Override // java.lang.Runnable
            public final void run() {
                ActivityScope.b(activity, runnable);
            }
        });
    }

    private static void onFragmentActivityStopCallOnce(final AbstractActivityC0832u abstractActivityC0832u, final Runnable runnable) {
        abstractActivityC0832u.runOnUiThread(new Runnable() { // from class: com.google.firebase.firestore.core.b
            @Override // java.lang.Runnable
            public final void run() {
                ActivityScope.a(abstractActivityC0832u, runnable);
            }
        });
    }
}
