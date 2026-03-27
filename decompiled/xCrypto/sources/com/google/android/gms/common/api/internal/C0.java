package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.AbstractActivityC0832u;
import androidx.fragment.app.AbstractComponentCallbacksC0828p;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class C0 extends AbstractComponentCallbacksC0828p implements InterfaceC0908l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WeakHashMap f9699b = new WeakHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final B0 f9700a = new B0();

    public static C0 l(AbstractActivityC0832u abstractActivityC0832u) {
        C0 c02;
        WeakHashMap weakHashMap = f9699b;
        WeakReference weakReference = (WeakReference) weakHashMap.get(abstractActivityC0832u);
        if (weakReference != null && (c02 = (C0) weakReference.get()) != null) {
            return c02;
        }
        try {
            C0 c03 = (C0) abstractActivityC0832u.getSupportFragmentManager().j0("SLifecycleFragmentImpl");
            if (c03 == null || c03.isRemoving()) {
                c03 = new C0();
                abstractActivityC0832u.getSupportFragmentManager().o().d(c03, "SLifecycleFragmentImpl").g();
            }
            weakHashMap.put(abstractActivityC0832u, new WeakReference(c03));
            return c03;
        } catch (ClassCastException e4) {
            throw new IllegalStateException("Fragment with tag SLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e4);
        }
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC0908l
    public final void a(String str, AbstractC0907k abstractC0907k) {
        this.f9700a.d(str, abstractC0907k);
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC0908l
    public final AbstractC0907k b(String str, Class cls) {
        return this.f9700a.c(str, cls);
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC0908l
    public final Activity c() {
        return getActivity();
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0828p
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        this.f9700a.e(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0828p
    public final void onActivityResult(int i4, int i5, Intent intent) {
        super.onActivityResult(i4, i5, intent);
        this.f9700a.f(i4, i5, intent);
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0828p
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9700a.g(bundle);
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0828p
    public final void onDestroy() {
        super.onDestroy();
        this.f9700a.h();
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0828p
    public final void onResume() {
        super.onResume();
        this.f9700a.i();
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0828p
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f9700a.j(bundle);
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0828p
    public final void onStart() {
        super.onStart();
        this.f9700a.k();
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0828p
    public final void onStop() {
        super.onStop();
        this.f9700a.l();
    }
}
