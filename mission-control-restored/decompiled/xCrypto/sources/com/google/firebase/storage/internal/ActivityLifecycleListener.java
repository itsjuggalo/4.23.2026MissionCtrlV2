package com.google.firebase.storage.internal;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.common.api.internal.AbstractC0907k;
import com.google.android.gms.common.api.internal.C0906j;
import com.google.android.gms.common.api.internal.InterfaceC0908l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ActivityLifecycleListener {
    private static final ActivityLifecycleListener instance = new ActivityLifecycleListener();
    private final Map<Object, LifecycleEntry> cookieMap = new HashMap();
    private final Object sync = new Object();

    public static class LifecycleEntry {
        private final Activity activity;
        private final Object cookie;
        private final Runnable runnable;

        public LifecycleEntry(Activity activity, Runnable runnable, Object obj) {
            this.activity = activity;
            this.runnable = runnable;
            this.cookie = obj;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof LifecycleEntry)) {
                return false;
            }
            LifecycleEntry lifecycleEntry = (LifecycleEntry) obj;
            return lifecycleEntry.cookie.equals(this.cookie) && lifecycleEntry.runnable == this.runnable && lifecycleEntry.activity == this.activity;
        }

        public Activity getActivity() {
            return this.activity;
        }

        public Object getCookie() {
            return this.cookie;
        }

        public Runnable getRunnable() {
            return this.runnable;
        }

        public int hashCode() {
            return this.cookie.hashCode();
        }
    }

    public static class OnStopCallback extends AbstractC0907k {
        private static final String TAG = "StorageOnStopCallback";
        private final List<LifecycleEntry> listeners;

        private OnStopCallback(InterfaceC0908l interfaceC0908l) {
            super(interfaceC0908l);
            this.listeners = new ArrayList();
            this.mLifecycleFragment.a(TAG, this);
        }

        public static OnStopCallback getInstance(Activity activity) {
            InterfaceC0908l fragment = AbstractC0907k.getFragment(new C0906j(activity));
            OnStopCallback onStopCallback = (OnStopCallback) fragment.b(TAG, OnStopCallback.class);
            return onStopCallback == null ? new OnStopCallback(fragment) : onStopCallback;
        }

        public void addEntry(LifecycleEntry lifecycleEntry) {
            synchronized (this.listeners) {
                this.listeners.add(lifecycleEntry);
            }
        }

        @Override // com.google.android.gms.common.api.internal.AbstractC0907k
        public void onStop() {
            ArrayList<LifecycleEntry> arrayList;
            synchronized (this.listeners) {
                arrayList = new ArrayList(this.listeners);
                this.listeners.clear();
            }
            for (LifecycleEntry lifecycleEntry : arrayList) {
                if (lifecycleEntry != null) {
                    Log.d(TAG, "removing subscription from activity.");
                    lifecycleEntry.getRunnable().run();
                    ActivityLifecycleListener.getInstance().removeCookie(lifecycleEntry.getCookie());
                }
            }
        }

        public void removeEntry(LifecycleEntry lifecycleEntry) {
            synchronized (this.listeners) {
                this.listeners.remove(lifecycleEntry);
            }
        }
    }

    private ActivityLifecycleListener() {
    }

    public static ActivityLifecycleListener getInstance() {
        return instance;
    }

    public void removeCookie(Object obj) {
        synchronized (this.sync) {
            try {
                LifecycleEntry lifecycleEntry = this.cookieMap.get(obj);
                if (lifecycleEntry != null) {
                    OnStopCallback.getInstance(lifecycleEntry.getActivity()).removeEntry(lifecycleEntry);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void runOnActivityStopped(Activity activity, Object obj, Runnable runnable) {
        synchronized (this.sync) {
            LifecycleEntry lifecycleEntry = new LifecycleEntry(activity, runnable, obj);
            OnStopCallback.getInstance(activity).addEntry(lifecycleEntry);
            this.cookieMap.put(obj, lifecycleEntry);
        }
    }
}
