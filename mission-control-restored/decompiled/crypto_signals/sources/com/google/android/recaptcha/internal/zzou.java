package com.google.android.recaptcha.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzou implements zzof {
    private final zzoi zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    public zzou(zzoi zzoiVar, String str, Object[] objArr) {
        this.zza = zzoiVar;
        this.zzb = str;
        this.zzc = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.zzd = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i6 = 1;
        int i7 = 13;
        while (true) {
            int i8 = i6 + 1;
            char cCharAt2 = str.charAt(i6);
            if (cCharAt2 < 55296) {
                this.zzd = i | (cCharAt2 << i7);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i7;
                i7 += 13;
                i6 = i8;
            }
        }
    }

    @Override // com.google.android.recaptcha.internal.zzof
    public final zzoi zza() {
        return this.zza;
    }

    @Override // com.google.android.recaptcha.internal.zzof
    public final boolean zzb() {
        return (this.zzd & 2) == 2;
    }

    @Override // com.google.android.recaptcha.internal.zzof
    public final int zzc() {
        int i = this.zzd;
        if ((i & 1) != 0) {
            return 1;
        }
        return (i & 4) == 4 ? 3 : 2;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final Object[] zze() {
        return this.zzc;
    }
}
