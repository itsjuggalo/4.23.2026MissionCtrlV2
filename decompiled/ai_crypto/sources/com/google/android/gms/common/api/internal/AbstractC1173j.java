package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: renamed from: com.google.android.gms.common.api.internal.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1173j {
    protected final InterfaceC1174k mLifecycleFragment;

    public AbstractC1173j(InterfaceC1174k interfaceC1174k) {
        this.mLifecycleFragment = interfaceC1174k;
    }

    public static InterfaceC1174k getFragment(Activity activity) {
        return getFragment(new C1172i(activity));
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public Activity getActivity() {
        Activity activityE = this.mLifecycleFragment.e();
        AbstractC1207s.k(activityE);
        return activityE;
    }

    public void onActivityResult(int i7, int i8, Intent intent) {
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

    public static InterfaceC1174k getFragment(ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }

    public static InterfaceC1174k getFragment(C1172i c1172i) {
        if (c1172i.d()) {
            return z0.E1(c1172i.b());
        }
        if (c1172i.c()) {
            return w0.a(c1172i.a());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }
}
