package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
public class zzlj {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    public /* synthetic */ zzlj(byte[] bArr) {
    }

    public static int zzb(int i8) {
        return (i8 >>> 1) ^ (-(i8 & 1));
    }

    public static long zzc(long j8) {
        return (j8 >>> 1) ^ (-(1 & j8));
    }
}
