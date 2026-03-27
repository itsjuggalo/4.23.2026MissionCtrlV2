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
import u.C1853a;

/* JADX INFO: loaded from: classes.dex */
public final class B0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f9694a = Collections.synchronizedMap(new C1853a());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9695b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f9696c;

    public final AbstractC0907k c(String str, Class cls) {
        return (AbstractC0907k) cls.cast(this.f9694a.get(str));
    }

    public final void d(String str, AbstractC0907k abstractC0907k) {
        if (this.f9694a.containsKey(str)) {
            throw new IllegalArgumentException("LifecycleCallback with tag " + str + " already added to this fragment.");
        }
        this.f9694a.put(str, abstractC0907k);
        if (this.f9695b > 0) {
            new zzh(Looper.getMainLooper()).post(new A0(this, abstractC0907k, str));
        }
    }

    public final void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Iterator it = this.f9694a.values().iterator();
        while (it.hasNext()) {
            ((AbstractC0907k) it.next()).dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final void f(int i4, int i5, Intent intent) {
        Iterator it = this.f9694a.values().iterator();
        while (it.hasNext()) {
            ((AbstractC0907k) it.next()).onActivityResult(i4, i5, intent);
        }
    }

    public final void g(Bundle bundle) {
        this.f9695b = 1;
        this.f9696c = bundle;
        for (Map.Entry entry : this.f9694a.entrySet()) {
            ((AbstractC0907k) entry.getValue()).onCreate(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public final void h() {
        this.f9695b = 5;
        Iterator it = this.f9694a.values().iterator();
        while (it.hasNext()) {
            ((AbstractC0907k) it.next()).onDestroy();
        }
    }

    public final void i() {
        this.f9695b = 3;
        Iterator it = this.f9694a.values().iterator();
        while (it.hasNext()) {
            ((AbstractC0907k) it.next()).onResume();
        }
    }

    public final void j(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        for (Map.Entry entry : this.f9694a.entrySet()) {
            Bundle bundle2 = new Bundle();
            ((AbstractC0907k) entry.getValue()).onSaveInstanceState(bundle2);
            bundle.putBundle((String) entry.getKey(), bundle2);
        }
    }

    public final void k() {
        this.f9695b = 2;
        Iterator it = this.f9694a.values().iterator();
        while (it.hasNext()) {
            ((AbstractC0907k) it.next()).onStart();
        }
    }

    public final void l() {
        this.f9695b = 4;
        Iterator it = this.f9694a.values().iterator();
        while (it.hasNext()) {
            ((AbstractC0907k) it.next()).onStop();
        }
    }
}
