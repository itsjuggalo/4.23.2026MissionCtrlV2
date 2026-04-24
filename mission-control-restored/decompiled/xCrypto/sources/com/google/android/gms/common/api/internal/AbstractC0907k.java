package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: renamed from: com.google.android.gms.common.api.internal.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0907k {
    protected final InterfaceC0908l mLifecycleFragment;

    public AbstractC0907k(InterfaceC0908l interfaceC0908l) {
        this.mLifecycleFragment = interfaceC0908l;
    }

    public static InterfaceC0908l getFragment(Activity activity) {
        return getFragment(new C0906j(activity));
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public Activity getActivity() {
        Activity activityC = this.mLifecycleFragment.c();
        AbstractC0940s.k(activityC);
        return activityC;
    }

    public void onActivityResult(int i4, int i5, Intent intent) {
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

    public void onStop() {
    }

    public static InterfaceC0908l getFragment(ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }

    public static InterfaceC0908l getFragment(C0906j c0906j) {
        if (c0906j.d()) {
            return C0.l(c0906j.b());
        }
        if (c0906j.c()) {
            return z0.d(c0906j.a());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }
}
