package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
abstract class zzaa extends zzd<String> {
    final CharSequence zza;
    private final zzf zzb;
    private int zze;
    private int zzd = 0;
    private final boolean zzc = false;

    public zzaa(zzt zztVar, CharSequence charSequence) {
        this.zzb = zztVar.zza;
        this.zze = zztVar.zzc;
        this.zza = charSequence;
    }

    public abstract int zza(int i);

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzd
    public final /* synthetic */ String zza() {
        int i = this.zzd;
        while (true) {
            int i6 = this.zzd;
            if (i6 == -1) {
                zzb();
                return null;
            }
            int iZzb = zzb(i6);
            if (iZzb == -1) {
                iZzb = this.zza.length();
                this.zzd = -1;
            } else {
                this.zzd = zza(iZzb);
            }
            int i7 = this.zzd;
            if (i7 != i) {
                while (i < iZzb && this.zzb.zza(this.zza.charAt(i))) {
                    i++;
                }
                while (iZzb > i && this.zzb.zza(this.zza.charAt(iZzb - 1))) {
                    iZzb--;
                }
                int i8 = this.zze;
                if (i8 == 1) {
                    iZzb = this.zza.length();
                    this.zzd = -1;
                    while (iZzb > i && this.zzb.zza(this.zza.charAt(iZzb - 1))) {
                        iZzb--;
                    }
                } else {
                    this.zze = i8 - 1;
                }
                return this.zza.subSequence(i, iZzb).toString();
            }
            int i9 = i7 + 1;
            this.zzd = i9;
            if (i9 > this.zza.length()) {
                this.zzd = -1;
            }
        }
    }

    public abstract int zzb(int i);
}
