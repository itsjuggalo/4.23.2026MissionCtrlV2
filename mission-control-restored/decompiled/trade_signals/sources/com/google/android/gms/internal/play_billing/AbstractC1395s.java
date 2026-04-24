package com.google.android.gms.internal.play_billing;

import android.os.SystemClock;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1395s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final F f15497a;

    static {
        F rVar;
        try {
            SystemClock.elapsedRealtimeNanos();
            rVar = new C1386q();
        } catch (Throwable unused) {
            SystemClock.elapsedRealtime();
            rVar = new r();
        }
        f15497a = rVar;
    }

    public static F a() {
        return f15497a;
    }
}
