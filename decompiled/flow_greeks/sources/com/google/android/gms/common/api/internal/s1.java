package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class s1 extends Fragment implements k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WeakHashMap f5626b = new WeakHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u1 f5627a = new u1();

    public static s1 d(Activity activity) {
        s1 s1Var;
        WeakHashMap weakHashMap = f5626b;
        WeakReference weakReference = (WeakReference) weakHashMap.get(activity);
        if (weakReference != null && (s1Var = (s1) weakReference.get()) != null) {
            return s1Var;
        }
        try {
            s1 s1Var2 = (s1) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            if (s1Var2 == null || s1Var2.isRemoving()) {
                s1Var2 = new s1();
                activity.getFragmentManager().beginTransaction().add(s1Var2, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            weakHashMap.put(activity, new WeakReference(s1Var2));
            return s1Var2;
        } catch (ClassCastException e10) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e10);
        }
    }

    @Override // com.google.android.gms.common.api.internal.k
    public final void a(String str, j jVar) {
        this.f5627a.b(str, jVar);
    }

    @Override // com.google.android.gms.common.api.internal.k
    public final j b(String str, Class cls) {
        return this.f5627a.a(str, cls);
    }

    @Override // com.google.android.gms.common.api.internal.k
    public final Activity c() {
        return getActivity();
    }

    @Override // android.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        this.f5627a.j(str, fileDescriptor, printWriter, strArr);
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        this.f5627a.f(i10, i11, intent);
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5627a.c(bundle);
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f5627a.i();
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f5627a.e();
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f5627a.g(bundle);
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f5627a.d();
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f5627a.h();
    }
}
