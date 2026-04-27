package com.google.android.gms.internal.common;

import com.google.android.gms.common.api.a;

/* JADX INFO: loaded from: classes.dex */
abstract class zzz extends zzm {
    final CharSequence zzb;
    final zzr zzc;
    final boolean zzd;
    int zze = 0;
    int zzf = a.e.API_PRIORITY_OTHER;

    public zzz(zzaa zzaaVar, CharSequence charSequence) {
        this.zzc = zzaaVar.zza;
        this.zzd = zzaaVar.zzb;
        this.zzb = charSequence;
    }

    @Override // com.google.android.gms.internal.common.zzm
    public final /* bridge */ /* synthetic */ Object zza() {
        int iZzd;
        int iZzc;
        int i7 = this.zze;
        while (true) {
            int i8 = this.zze;
            if (i8 == -1) {
                zzb();
                return null;
            }
            iZzd = zzd(i8);
            if (iZzd == -1) {
                iZzd = this.zzb.length();
                this.zze = -1;
                iZzc = -1;
            } else {
                iZzc = zzc(iZzd);
                this.zze = iZzc;
            }
            if (iZzc == i7) {
                int i9 = iZzc + 1;
                this.zze = i9;
                if (i9 > this.zzb.length()) {
                    this.zze = -1;
                }
            } else {
                if (i7 < iZzd) {
                    this.zzb.charAt(i7);
                }
                if (i7 < iZzd) {
                    this.zzb.charAt(iZzd - 1);
                }
                if (!this.zzd || i7 != iZzd) {
                    break;
                }
                i7 = this.zze;
            }
        }
        int i10 = this.zzf;
        if (i10 == 1) {
            iZzd = this.zzb.length();
            this.zze = -1;
            if (iZzd > i7) {
                this.zzb.charAt(iZzd - 1);
            }
        } else {
            this.zzf = i10 - 1;
        }
        return this.zzb.subSequence(i7, iZzd).toString();
    }

    public abstract int zzc(int i7);

    public abstract int zzd(int i7);
}
