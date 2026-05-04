package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class zzlj {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    public /* synthetic */ zzlj(byte[] bArr) {
    }

    public static int zzb(int i10) {
        return (i10 >>> 1) ^ (-(i10 & 1));
    }

    public static long zzc(long j10) {
        return (j10 >>> 1) ^ (-(1 & j10));
    }
}
