package com.google.android.gms.internal.common;

/* JADX INFO: loaded from: classes.dex */
abstract class zzz extends zzm {
    final CharSequence zzb;
    final zzr zzc;
    final boolean zzd;
    int zze = 0;
    int zzf = Integer.MAX_VALUE;

    public zzz(zzaa zzaaVar, CharSequence charSequence) {
        this.zzc = zzaaVar.zza;
        this.zzd = zzaaVar.zzb;
        this.zzb = charSequence;
    }

    @Override // com.google.android.gms.internal.common.zzm
    public final /* bridge */ /* synthetic */ Object zza() {
        int iZzd;
        int iZzc;
        int i4 = this.zze;
        while (true) {
            int i5 = this.zze;
            if (i5 == -1) {
                zzb();
                return null;
            }
            iZzd = zzd(i5);
            if (iZzd == -1) {
                iZzd = this.zzb.length();
                this.zze = -1;
                iZzc = -1;
            } else {
                iZzc = zzc(iZzd);
                this.zze = iZzc;
            }
            if (iZzc == i4) {
                int i6 = iZzc + 1;
                this.zze = i6;
                if (i6 > this.zzb.length()) {
                    this.zze = -1;
                }
            } else {
                if (i4 < iZzd) {
                    this.zzb.charAt(i4);
                }
                if (i4 < iZzd) {
                    this.zzb.charAt(iZzd - 1);
                }
                if (!this.zzd || i4 != iZzd) {
                    break;
                }
                i4 = this.zze;
            }
        }
        int i7 = this.zzf;
        if (i7 == 1) {
            iZzd = this.zzb.length();
            this.zze = -1;
            if (iZzd > i4) {
                this.zzb.charAt(iZzd - 1);
            }
        } else {
            this.zzf = i7 - 1;
        }
        return this.zzb.subSequence(i4, iZzd).toString();
    }

    public abstract int zzc(int i4);

    public abstract int zzd(int i4);
}
