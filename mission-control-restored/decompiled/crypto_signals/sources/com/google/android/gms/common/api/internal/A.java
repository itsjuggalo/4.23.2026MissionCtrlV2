package com.google.android.gms.common.api.internal;

import android.app.AlertDialog;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f5070b;

    public A(Z z6, AlertDialog alertDialog) {
        this.f5070b = z6;
        this.f5069a = alertDialog;
    }

    public void a(Status status, boolean z6) {
        HashMap map;
        HashMap map2;
        synchronized (((Map) this.f5069a)) {
            map = new HashMap((Map) this.f5069a);
        }
        synchronized (((Map) this.f5070b)) {
            map2 = new HashMap((Map) this.f5070b);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z6 || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).forceFailureUnlessReady(status);
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z6 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((TaskCompletionSource) entry2.getKey()).trySetException(new com.google.android.gms.common.api.j(status));
            }
        }
    }

    public A() {
        this.f5069a = Collections.synchronizedMap(new WeakHashMap());
        this.f5070b = Collections.synchronizedMap(new WeakHashMap());
    }
}
