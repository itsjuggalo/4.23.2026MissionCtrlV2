package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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

    public abstract int zza(int i10);

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzd
    public final /* synthetic */ String zza() {
        int i10 = this.zzd;
        while (true) {
            int i11 = this.zzd;
            if (i11 == -1) {
                zzb();
                return null;
            }
            int iZzb = zzb(i11);
            if (iZzb == -1) {
                iZzb = this.zza.length();
                this.zzd = -1;
            } else {
                this.zzd = zza(iZzb);
            }
            int i12 = this.zzd;
            if (i12 != i10) {
                while (i10 < iZzb && this.zzb.zza(this.zza.charAt(i10))) {
                    i10++;
                }
                while (iZzb > i10 && this.zzb.zza(this.zza.charAt(iZzb - 1))) {
                    iZzb--;
                }
                int i13 = this.zze;
                if (i13 == 1) {
                    iZzb = this.zza.length();
                    this.zzd = -1;
                    while (iZzb > i10 && this.zzb.zza(this.zza.charAt(iZzb - 1))) {
                        iZzb--;
                    }
                } else {
                    this.zze = i13 - 1;
                }
                return this.zza.subSequence(i10, iZzb).toString();
            }
            int i14 = i12 + 1;
            this.zzd = i14;
            if (i14 > this.zza.length()) {
                this.zzd = -1;
            }
        }
    }

    public abstract int zzb(int i10);
}
