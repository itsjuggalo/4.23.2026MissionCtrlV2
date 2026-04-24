package com.google.android.recaptcha.internal;

import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
final class zzpp extends zzpr {
    public zzpp(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.recaptcha.internal.zzpr
    public final double zza(Object obj, long j4) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j4));
    }

    @Override // com.google.android.recaptcha.internal.zzpr
    public final float zzb(Object obj, long j4) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j4));
    }

    @Override // com.google.android.recaptcha.internal.zzpr
    public final void zzc(Object obj, long j4, boolean z4) {
        if (zzps.zzb) {
            zzps.zzD(obj, j4, z4 ? (byte) 1 : (byte) 0);
        } else {
            zzps.zzE(obj, j4, z4 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpr
    public final void zzd(Object obj, long j4, byte b4) {
        if (zzps.zzb) {
            zzps.zzD(obj, j4, b4);
        } else {
            zzps.zzE(obj, j4, b4);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzpr
    public final void zze(Object obj, long j4, double d4) {
        this.zza.putLong(obj, j4, Double.doubleToLongBits(d4));
    }

    @Override // com.google.android.recaptcha.internal.zzpr
    public final void zzf(Object obj, long j4, float f4) {
        this.zza.putInt(obj, j4, Float.floatToIntBits(f4));
    }

    @Override // com.google.android.recaptcha.internal.zzpr
    public final boolean zzg(Object obj, long j4) {
        return zzps.zzb ? zzps.zzt(obj, j4) : zzps.zzu(obj, j4);
    }
}
