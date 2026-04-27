package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
abstract class zzac extends zzd<String> {
    final CharSequence zza;
    private final zzf zzb;
    private int zze;
    private int zzd = 0;
    private final boolean zzc = false;

    public zzac(zzv zzvVar, CharSequence charSequence) {
        this.zzb = zzvVar.zza;
        this.zze = zzvVar.zzc;
        this.zza = charSequence;
    }

    public abstract int zza(int i7);

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzd
    public final /* synthetic */ String zza() {
        int i7 = this.zzd;
        while (true) {
            int i8 = this.zzd;
            if (i8 == -1) {
                zzb();
                return null;
            }
            int iZzb = zzb(i8);
            if (iZzb == -1) {
                iZzb = this.zza.length();
                this.zzd = -1;
            } else {
                this.zzd = zza(iZzb);
            }
            int i9 = this.zzd;
            if (i9 != i7) {
                while (i7 < iZzb && this.zzb.zza(this.zza.charAt(i7))) {
                    i7++;
                }
                while (iZzb > i7 && this.zzb.zza(this.zza.charAt(iZzb - 1))) {
                    iZzb--;
                }
                int i10 = this.zze;
                if (i10 == 1) {
                    iZzb = this.zza.length();
                    this.zzd = -1;
                    while (iZzb > i7 && this.zzb.zza(this.zza.charAt(iZzb - 1))) {
                        iZzb--;
                    }
                } else {
                    this.zze = i10 - 1;
                }
                return this.zza.subSequence(i7, iZzb).toString();
            }
            int i11 = i9 + 1;
            this.zzd = i11;
            if (i11 > this.zza.length()) {
                this.zzd = -1;
            }
        }
    }

    public abstract int zzb(int i7);
}
