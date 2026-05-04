package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f5652a = Collections.synchronizedMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f5653b = Collections.synchronizedMap(new WeakHashMap());

    public final void a(BasePendingResult basePendingResult, boolean z10) {
        this.f5652a.put(basePendingResult, Boolean.valueOf(z10));
        basePendingResult.addStatusListener(new q1(this, basePendingResult));
    }

    public final void b(TaskCompletionSource taskCompletionSource, boolean z10) {
        this.f5653b.put(taskCompletionSource, Boolean.valueOf(z10));
        taskCompletionSource.getTask().addOnCompleteListener(new r1(this, taskCompletionSource));
    }

    public final boolean c() {
        return (this.f5652a.isEmpty() && this.f5653b.isEmpty()) ? false : true;
    }

    public final void d() {
        h(false, g.f5543p);
    }

    public final void e(int i10, String str) {
        StringBuilder sb2 = new StringBuilder("The connection to Google Play services was lost");
        if (i10 == 1) {
            sb2.append(" due to service disconnection.");
        } else if (i10 == 3) {
            sb2.append(" due to dead object exception.");
        }
        if (str != null) {
            sb2.append(" Last reason for disconnect: ");
            sb2.append(str);
        }
        h(true, new Status(20, sb2.toString()));
    }

    public final /* synthetic */ Map f() {
        return this.f5652a;
    }

    public final /* synthetic */ Map g() {
        return this.f5653b;
    }

    public final void h(boolean z10, Status status) {
        HashMap map;
        HashMap map2;
        Map map3 = this.f5652a;
        synchronized (map3) {
            map = new HashMap(map3);
        }
        Map map4 = this.f5653b;
        synchronized (map4) {
            map2 = new HashMap(map4);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z10 || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).forceFailureUnlessReady(status);
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z10 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((TaskCompletionSource) entry2.getKey()).trySetException(new com.google.android.gms.common.api.b(status));
            }
        }
    }
}
