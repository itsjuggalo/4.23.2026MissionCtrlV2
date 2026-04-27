package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
final class zzol extends zzon {
    public zzol(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final void zza(Object obj, long j4, byte b4) {
        if (zzoo.zzb) {
            zzoo.zzD(obj, j4, b4);
        } else {
            zzoo.zzE(obj, j4, b4);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final boolean zzb(Object obj, long j4) {
        return zzoo.zzb ? zzoo.zzu(obj, j4) : zzoo.zzv(obj, j4);
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final void zzc(Object obj, long j4, boolean z4) {
        if (zzoo.zzb) {
            zzoo.zzD(obj, j4, z4 ? (byte) 1 : (byte) 0);
        } else {
            zzoo.zzE(obj, j4, z4 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final float zzd(Object obj, long j4) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j4));
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final void zze(Object obj, long j4, float f4) {
        this.zza.putInt(obj, j4, Float.floatToIntBits(f4));
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final double zzf(Object obj, long j4) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j4));
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final void zzg(Object obj, long j4, double d4) {
        this.zza.putLong(obj, j4, Double.doubleToLongBits(d4));
    }
}
