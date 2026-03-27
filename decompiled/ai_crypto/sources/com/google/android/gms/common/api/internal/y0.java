package com.google.android.gms.common.api.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.internal.common.zzh;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import u.C2736a;

/* JADX INFO: loaded from: classes.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f11019a = Collections.synchronizedMap(new C2736a());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11020b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f11021c;

    public final AbstractC1173j c(String str, Class cls) {
        return (AbstractC1173j) cls.cast(this.f11019a.get(str));
    }

    public final void d(String str, AbstractC1173j abstractC1173j) {
        if (this.f11019a.containsKey(str)) {
            throw new IllegalArgumentException("LifecycleCallback with tag " + str + " already added to this fragment.");
        }
        this.f11019a.put(str, abstractC1173j);
        if (this.f11020b > 0) {
            new zzh(Looper.getMainLooper()).post(new x0(this, abstractC1173j, str));
        }
    }

    public final void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Iterator it = this.f11019a.values().iterator();
        while (it.hasNext()) {
            ((AbstractC1173j) it.next()).dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final void f(int i7, int i8, Intent intent) {
        Iterator it = this.f11019a.values().iterator();
        while (it.hasNext()) {
            ((AbstractC1173j) it.next()).onActivityResult(i7, i8, intent);
        }
    }

    public final void g(Bundle bundle) {
        this.f11020b = 1;
        this.f11021c = bundle;
        for (Map.Entry entry : this.f11019a.entrySet()) {
            ((AbstractC1173j) entry.getValue()).onCreate(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public final void h() {
        this.f11020b = 5;
        Iterator it = this.f11019a.values().iterator();
        while (it.hasNext()) {
            ((AbstractC1173j) it.next()).onDestroy();
        }
    }

    public final void i() {
        this.f11020b = 3;
        Iterator it = this.f11019a.values().iterator();
        while (it.hasNext()) {
            ((AbstractC1173j) it.next()).onResume();
        }
    }

    public final void j(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        for (Map.Entry entry : this.f11019a.entrySet()) {
            Bundle bundle2 = new Bundle();
            ((AbstractC1173j) entry.getValue()).onSaveInstanceState(bundle2);
            bundle.putBundle((String) entry.getKey(), bundle2);
        }
    }

    public final void k() {
        this.f11020b = 2;
        Iterator it = this.f11019a.values().iterator();
        while (it.hasNext()) {
            ((AbstractC1173j) it.next()).onStart();
        }
    }

    public final void l() {
        this.f11020b = 4;
        Iterator it = this.f11019a.values().iterator();
        while (it.hasNext()) {
            ((AbstractC1173j) it.next()).onStop();
        }
    }
}
