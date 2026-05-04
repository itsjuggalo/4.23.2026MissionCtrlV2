package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbs implements zzoa {
    private static final zzbu zza = new zzbu() { // from class: com.google.android.gms.internal.firebase-auth-api.zzbr
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbu
        public final void zza(zzbs zzbsVar) {
            zzbs.zzd(zzbsVar);
        }
    };
    private final zzbi zzb;
    private final zzxc zzc;
    private final zzbk zzd;
    private final int zze;
    private final boolean zzf;
    private final boolean zzg;
    private final zzbu zzh;

    private zzbs(zzbi zzbiVar, zzxc zzxcVar, int i10, boolean z10, boolean z11, zzbu zzbuVar) {
        this.zzb = zzbiVar;
        this.zzc = zzxcVar;
        int i11 = zzbo.zza[zzxcVar.ordinal()];
        this.zzd = i11 != 1 ? i11 != 2 ? zzbk.zzb : zzbk.zzc : zzbk.zza;
        this.zze = i10;
        this.zzf = z10;
        this.zzg = z11;
        this.zzh = zzbuVar;
    }

    public static /* synthetic */ void zzd(zzbs zzbsVar) {
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoa
    public final int zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoa
    public final zzbi zzb() {
        this.zzh.zza(this);
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzoa
    public final zzbk zzc() {
        return this.zzd;
    }

    public final boolean zze() {
        return this.zzf;
    }
}
