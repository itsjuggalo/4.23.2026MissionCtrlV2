package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
public class zzli {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    public /* synthetic */ zzli(byte[] bArr) {
    }

    public static int zzb(int i4) {
        return (i4 >>> 1) ^ (-(i4 & 1));
    }

    public static long zzc(long j4) {
        return (j4 >>> 1) ^ (-(1 & j4));
    }
}
