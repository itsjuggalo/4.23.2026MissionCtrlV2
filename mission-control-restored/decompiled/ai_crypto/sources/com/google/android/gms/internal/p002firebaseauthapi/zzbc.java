package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
public final class zzbc {
    public static long zza(long j7, long j8) {
        long j9 = j7 + j8;
        zzbb.zza(((j7 ^ j8) < 0) | ((j7 ^ j9) >= 0), "checkedAdd", j7, j8);
        return j9;
    }

    public static long zzb(long j7, long j8) {
        long j9 = j7 - 1;
        zzbb.zza(((1 ^ j7) >= 0) | ((j7 ^ j9) >= 0), "checkedSubtract", j7, 1L);
        return j9;
    }
}
