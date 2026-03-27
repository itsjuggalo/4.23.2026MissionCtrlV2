package com.google.android.gms.common.api.internal;

import Z.AbstractActivityC0282y;
import Z.C0259a;
import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: com.google.android.gms.common.api.internal.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0408k {
    protected final InterfaceC0409l mLifecycleFragment;

    public AbstractC0408k(InterfaceC0409l interfaceC0409l) {
        this.mLifecycleFragment = interfaceC0409l;
    }

    public static InterfaceC0409l getFragment(Activity activity) {
        return getFragment(new C0407j(activity));
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public Activity getActivity() {
        Activity activityG = this.mLifecycleFragment.g();
        com.google.android.gms.common.internal.I.g(activityG);
        return activityG;
    }

    public void onActivityResult(int i, int i6, Intent intent) {
    }

    public void onCreate(Bundle bundle) {
    }

    public void onDestroy() {
    }

    public void onResume() {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
    }

    public abstract void onStop();

    public static InterfaceC0409l getFragment(C0407j c0407j) {
        b0 b0Var;
        c0 c0Var;
        Activity activity = c0407j.f5165a;
        if (!(activity instanceof AbstractActivityC0282y)) {
            if (activity == null) {
                throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
            }
            WeakHashMap weakHashMap = b0.f5140b;
            WeakReference weakReference = (WeakReference) weakHashMap.get(activity);
            if (weakReference != null && (b0Var = (b0) weakReference.get()) != null) {
                return b0Var;
            }
            try {
                b0 b0Var2 = (b0) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
                if (b0Var2 == null || b0Var2.isRemoving()) {
                    b0Var2 = new b0();
                    activity.getFragmentManager().beginTransaction().add(b0Var2, "LifecycleFragmentImpl").commitAllowingStateLoss();
                }
                weakHashMap.put(activity, new WeakReference(b0Var2));
                return b0Var2;
            } catch (ClassCastException e) {
                throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e);
            }
        }
        AbstractActivityC0282y abstractActivityC0282y = (AbstractActivityC0282y) activity;
        WeakHashMap weakHashMap2 = c0.f5146X;
        WeakReference weakReference2 = (WeakReference) weakHashMap2.get(abstractActivityC0282y);
        if (weakReference2 != null && (c0Var = (c0) weakReference2.get()) != null) {
            return c0Var;
        }
        try {
            c0 c0Var2 = (c0) abstractActivityC0282y.j().D("SLifecycleFragmentImpl");
            if (c0Var2 == null || c0Var2.f3907p) {
                c0Var2 = new c0();
                Z.P pJ = abstractActivityC0282y.j();
                pJ.getClass();
                C0259a c0259a = new C0259a(pJ);
                c0259a.e(0, c0Var2, "SLifecycleFragmentImpl");
                c0259a.d(true);
            }
            weakHashMap2.put(abstractActivityC0282y, new WeakReference(c0Var2));
            return c0Var2;
        } catch (ClassCastException e2) {
            throw new IllegalStateException("Fragment with tag SLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e2);
        }
    }

    public static InterfaceC0409l getFragment(ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }
}
