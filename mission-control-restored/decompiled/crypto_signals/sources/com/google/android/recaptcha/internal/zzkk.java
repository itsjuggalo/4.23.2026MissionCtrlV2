package com.google.android.recaptcha.internal;

/* JADX INFO: loaded from: classes.dex */
public final class zzkk {
    public static long zza(long j4, long j6) {
        long j7 = j4 + j6;
        zzkl.zza(((j4 ^ j6) < 0) | ((j4 ^ j7) >= 0), "checkedAdd", j4, j6);
        return j7;
    }

    public static long zzb(long j4, long j6) {
        long j7 = (-1) + j4;
        zzkl.zza(((1 ^ j4) >= 0) | ((j4 ^ j7) >= 0), "checkedSubtract", j4, 1L);
        return j7;
    }
}
