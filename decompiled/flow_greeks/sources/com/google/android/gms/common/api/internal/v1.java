package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class v1 extends androidx.fragment.app.p implements k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WeakHashMap f5648b = new WeakHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u1 f5649a = new u1();

    public static v1 l(androidx.fragment.app.u uVar) {
        v1 v1Var;
        androidx.fragment.app.i0 supportFragmentManager = uVar.getSupportFragmentManager();
        WeakHashMap weakHashMap = f5648b;
        WeakReference weakReference = (WeakReference) weakHashMap.get(uVar);
        if (weakReference != null && (v1Var = (v1) weakReference.get()) != null) {
            return v1Var;
        }
        try {
            v1 v1Var2 = (v1) supportFragmentManager.j0("SLifecycleFragmentImpl");
            if (v1Var2 == null || v1Var2.isRemoving()) {
                v1Var2 = new v1();
                supportFragmentManager.o().d(v1Var2, "SLifecycleFragmentImpl").g();
            }
            weakHashMap.put(uVar, new WeakReference(v1Var2));
            return v1Var2;
        } catch (ClassCastException e10) {
            throw new IllegalStateException("Fragment with tag SLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e10);
        }
    }

    @Override // com.google.android.gms.common.api.internal.k
    public final void a(String str, j jVar) {
        this.f5649a.b(str, jVar);
    }

    @Override // com.google.android.gms.common.api.internal.k
    public final j b(String str, Class cls) {
        return this.f5649a.a(str, cls);
    }

    @Override // com.google.android.gms.common.api.internal.k
    public final Activity c() {
        return getActivity();
    }

    @Override // androidx.fragment.app.p
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        this.f5649a.j(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.fragment.app.p
    public final void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        this.f5649a.f(i10, i11, intent);
    }

    @Override // androidx.fragment.app.p
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5649a.c(bundle);
    }

    @Override // androidx.fragment.app.p
    public final void onDestroy() {
        super.onDestroy();
        this.f5649a.i();
    }

    @Override // androidx.fragment.app.p
    public final void onResume() {
        super.onResume();
        this.f5649a.e();
    }

    @Override // androidx.fragment.app.p
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f5649a.g(bundle);
    }

    @Override // androidx.fragment.app.p
    public final void onStart() {
        super.onStart();
        this.f5649a.d();
    }

    @Override // androidx.fragment.app.p
    public final void onStop() {
        super.onStop();
        this.f5649a.h();
    }
}
