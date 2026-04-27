package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
final class zzom extends zzon {
    public zzom(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final void zza(Object obj, long j7, byte b7) {
        if (zzoo.zzb) {
            zzoo.zzD(obj, j7, b7);
        } else {
            zzoo.zzE(obj, j7, b7);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final boolean zzb(Object obj, long j7) {
        return zzoo.zzb ? zzoo.zzu(obj, j7) : zzoo.zzv(obj, j7);
    }

    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.measurement.zzoo.zzw(java.lang.Object, long, boolean):void */
    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.measurement.zzoo.zzx(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 'z7' boolean)' in method call: com.google.android.gms.internal.measurement.zzoo.zzw(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 'z7' boolean)' in method call: com.google.android.gms.internal.measurement.zzoo.zzx(java.lang.Object, long, boolean):void */
    @Override // com.google.android.gms.internal.measurement.zzon
    public final void zzc(Object obj, long j7, boolean z7) {
        if (zzoo.zzb) {
            zzoo.zzw(obj, j7, z7);
        } else {
            zzoo.zzx(obj, j7, z7);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final float zzd(Object obj, long j7) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j7));
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final void zze(Object obj, long j7, float f7) {
        this.zza.putInt(obj, j7, Float.floatToIntBits(f7));
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final double zzf(Object obj, long j7) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j7));
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final void zzg(Object obj, long j7, double d7) {
        this.zza.putLong(obj, j7, Double.doubleToLongBits(d7));
    }
}
