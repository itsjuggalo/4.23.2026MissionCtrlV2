package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f9703a = Collections.synchronizedMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f9704b = Collections.synchronizedMap(new WeakHashMap());

    public final void c(BasePendingResult basePendingResult, boolean z4) {
        this.f9703a.put(basePendingResult, Boolean.valueOf(z4));
        basePendingResult.addStatusListener(new C(this, basePendingResult));
    }

    public final void d(TaskCompletionSource taskCompletionSource, boolean z4) {
        this.f9704b.put(taskCompletionSource, Boolean.valueOf(z4));
        taskCompletionSource.getTask().addOnCompleteListener(new D(this, taskCompletionSource));
    }

    public final void e(int i4, String str) {
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i4 == 1) {
            sb.append(" due to service disconnection.");
        } else if (i4 == 3) {
            sb.append(" due to dead object exception.");
        }
        if (str != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(str);
        }
        h(true, new Status(20, sb.toString()));
    }

    public final void f() {
        h(false, C0904h.f9771p);
    }

    public final boolean g() {
        return (this.f9703a.isEmpty() && this.f9704b.isEmpty()) ? false : true;
    }

    public final void h(boolean z4, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (this.f9703a) {
            map = new HashMap(this.f9703a);
        }
        synchronized (this.f9704b) {
            map2 = new HashMap(this.f9704b);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z4 || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).forceFailureUnlessReady(status);
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z4 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((TaskCompletionSource) entry2.getKey()).trySetException(new com.google.android.gms.common.api.b(status));
            }
        }
    }
}
