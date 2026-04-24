package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zznv implements zzni {
    private final zznl zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    public zznv(zznl zznlVar, String str, Object[] objArr) {
        this.zza = zznlVar;
        this.zzb = str;
        this.zzc = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.zzd = cCharAt;
            return;
        }
        int i7 = cCharAt & 8191;
        int i8 = 1;
        int i9 = 13;
        while (true) {
            int i10 = i8 + 1;
            char cCharAt2 = str.charAt(i8);
            if (cCharAt2 < 55296) {
                this.zzd = i7 | (cCharAt2 << i9);
                return;
            } else {
                i7 |= (cCharAt2 & 8191) << i9;
                i9 += 13;
                i8 = i10;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzni
    public final boolean zza() {
        return (this.zzd & 2) == 2;
    }

    @Override // com.google.android.gms.internal.measurement.zzni
    public final zznl zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzni
    public final int zzc() {
        int i7 = this.zzd;
        if ((i7 & 1) != 0) {
            return 1;
        }
        return (i7 & 4) == 4 ? 3 : 2;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final Object[] zze() {
        return this.zzc;
    }
}
