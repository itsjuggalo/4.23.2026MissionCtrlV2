package com.google.android.gms.internal.play_billing;

import sun.misc.Unsafe;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.s0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC1396s0 {
    public static /* synthetic */ boolean a(Unsafe unsafe, Object obj, long j8, Object obj2, Object obj3) {
        while (!unsafe.compareAndSwapObject(obj, j8, obj2, obj3)) {
            if (unsafe.getObject(obj, j8) != obj2) {
                return false;
            }
        }
        return true;
    }
}
