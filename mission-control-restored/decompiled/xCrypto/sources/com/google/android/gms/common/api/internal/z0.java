package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class z0 extends Fragment implements InterfaceC0908l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WeakHashMap f9839b = new WeakHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final B0 f9840a = new B0();

    public static z0 d(Activity activity) {
        z0 z0Var;
        WeakHashMap weakHashMap = f9839b;
        WeakReference weakReference = (WeakReference) weakHashMap.get(activity);
        if (weakReference != null && (z0Var = (z0) weakReference.get()) != null) {
            return z0Var;
        }
        try {
            z0 z0Var2 = (z0) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            if (z0Var2 == null || z0Var2.isRemoving()) {
                z0Var2 = new z0();
                activity.getFragmentManager().beginTransaction().add(z0Var2, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            weakHashMap.put(activity, new WeakReference(z0Var2));
            return z0Var2;
        } catch (ClassCastException e4) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e4);
        }
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC0908l
    public final void a(String str, AbstractC0907k abstractC0907k) {
        this.f9840a.d(str, abstractC0907k);
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC0908l
    public final AbstractC0907k b(String str, Class cls) {
        return this.f9840a.c(str, cls);
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC0908l
    public final Activity c() {
        return getActivity();
    }

    @Override // android.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        this.f9840a.e(str, fileDescriptor, printWriter, strArr);
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int i4, int i5, Intent intent) {
        super.onActivityResult(i4, i5, intent);
        this.f9840a.f(i4, i5, intent);
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9840a.g(bundle);
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f9840a.h();
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f9840a.i();
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f9840a.j(bundle);
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f9840a.k();
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f9840a.l();
    }
}
