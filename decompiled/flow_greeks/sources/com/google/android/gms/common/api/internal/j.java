package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j {
    protected final k mLifecycleFragment;

    public j(k kVar) {
        this.mLifecycleFragment = kVar;
    }

    public static k getFragment(Activity activity) {
        return getFragment(new i(activity));
    }

    public Activity getActivity() {
        Activity activityC = this.mLifecycleFragment.c();
        com.google.android.gms.common.internal.s.k(activityC);
        return activityC;
    }

    public static k getFragment(ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }

    public static k getFragment(i iVar) {
        if (iVar.a()) {
            return v1.l(iVar.d());
        }
        if (iVar.b()) {
            return s1.d(iVar.c());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    public void onDestroy() {
    }

    public void onResume() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void onCreate(Bundle bundle) {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onActivityResult(int i10, int i11, Intent intent) {
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }
}
