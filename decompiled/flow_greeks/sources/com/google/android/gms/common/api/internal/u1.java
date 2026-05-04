package com.google.android.gms.common.api.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.internal.common.zzg;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f5635a = Collections.synchronizedMap(new w.a());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5636b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f5637c;

    public final j a(String str, Class cls) {
        return (j) cls.cast(this.f5635a.get(str));
    }

    public final void b(String str, j jVar) {
        Map map = this.f5635a;
        if (map.containsKey(str)) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 59);
            sb2.append("LifecycleCallback with tag ");
            sb2.append(str);
            sb2.append(" already added to this fragment.");
            throw new IllegalArgumentException(sb2.toString());
        }
        map.put(str, jVar);
        if (this.f5636b > 0) {
            new zzg(Looper.getMainLooper()).post(new t1(this, jVar, str));
        }
    }

    public final void c(Bundle bundle) {
        this.f5636b = 1;
        this.f5637c = bundle;
        for (Map.Entry entry : this.f5635a.entrySet()) {
            ((j) entry.getValue()).onCreate(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    public final void d() {
        this.f5636b = 2;
        Iterator it = this.f5635a.values().iterator();
        while (it.hasNext()) {
            ((j) it.next()).onStart();
        }
    }

    public final void e() {
        this.f5636b = 3;
        Iterator it = this.f5635a.values().iterator();
        while (it.hasNext()) {
            ((j) it.next()).onResume();
        }
    }

    public final void f(int i10, int i11, Intent intent) {
        Iterator it = this.f5635a.values().iterator();
        while (it.hasNext()) {
            ((j) it.next()).onActivityResult(i10, i11, intent);
        }
    }

    public final void g(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        for (Map.Entry entry : this.f5635a.entrySet()) {
            Bundle bundle2 = new Bundle();
            ((j) entry.getValue()).onSaveInstanceState(bundle2);
            bundle.putBundle((String) entry.getKey(), bundle2);
        }
    }

    public final void h() {
        this.f5636b = 4;
        Iterator it = this.f5635a.values().iterator();
        while (it.hasNext()) {
            ((j) it.next()).onStop();
        }
    }

    public final void i() {
        this.f5636b = 5;
        Iterator it = this.f5635a.values().iterator();
        while (it.hasNext()) {
            ((j) it.next()).onDestroy();
        }
    }

    public final void j(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Iterator it = this.f5635a.values().iterator();
        while (it.hasNext()) {
            ((j) it.next()).dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final /* synthetic */ int k() {
        return this.f5636b;
    }

    public final /* synthetic */ Bundle l() {
        return this.f5637c;
    }
}
