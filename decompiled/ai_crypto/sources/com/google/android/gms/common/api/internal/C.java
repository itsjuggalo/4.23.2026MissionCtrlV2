package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f10879a = Collections.synchronizedMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f10880b = Collections.synchronizedMap(new WeakHashMap());

    public final void c(BasePendingResult basePendingResult, boolean z7) {
        this.f10879a.put(basePendingResult, Boolean.valueOf(z7));
        basePendingResult.addStatusListener(new A(this, basePendingResult));
    }

    public final void d(TaskCompletionSource taskCompletionSource, boolean z7) {
        this.f10880b.put(taskCompletionSource, Boolean.valueOf(z7));
        taskCompletionSource.getTask().addOnCompleteListener(new B(this, taskCompletionSource));
    }

    public final void e(int i7, String str) {
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i7 == 1) {
            sb.append(" due to service disconnection.");
        } else if (i7 == 3) {
            sb.append(" due to dead object exception.");
        }
        if (str != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(str);
        }
        h(true, new Status(20, sb.toString()));
    }

    public final void f() {
        h(false, C1170g.f10954p);
    }

    public final boolean g() {
        return (this.f10879a.isEmpty() && this.f10880b.isEmpty()) ? false : true;
    }

    public final void h(boolean z7, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (this.f10879a) {
            map = new HashMap(this.f10879a);
        }
        synchronized (this.f10880b) {
            map2 = new HashMap(this.f10880b);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z7 || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).forceFailureUnlessReady(status);
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z7 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((TaskCompletionSource) entry2.getKey()).trySetException(new com.google.android.gms.common.api.b(status));
            }
        }
    }
}
