package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
abstract class zzoo {
    final Unsafe zza;

    public zzoo(Unsafe unsafe) {
        this.zza = unsafe;
    }

    public abstract void zza(Object obj, long j4, byte b3);

    public abstract boolean zzb(Object obj, long j4);

    public abstract void zzc(Object obj, long j4, boolean z6);

    public abstract float zzd(Object obj, long j4);

    public abstract void zze(Object obj, long j4, float f6);

    public abstract double zzf(Object obj, long j4);

    public abstract void zzg(Object obj, long j4, double d4);
}
