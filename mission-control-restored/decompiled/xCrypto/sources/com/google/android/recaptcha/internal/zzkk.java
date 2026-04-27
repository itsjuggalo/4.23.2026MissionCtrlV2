package com.google.android.recaptcha.internal;

/* JADX INFO: loaded from: classes.dex */
public final class zzkk {
    public static long zza(long j4, long j5) {
        long j6 = j4 + j5;
        zzkl.zza(((j4 ^ j5) < 0) | ((j4 ^ j6) >= 0), "checkedAdd", j4, j5);
        return j6;
    }

    public static long zzb(long j4, long j5) {
        long j6 = (-1) + j4;
        zzkl.zza(((1 ^ j4) >= 0) | ((j4 ^ j6) >= 0), "checkedSubtract", j4, 1L);
        return j6;
    }
}
