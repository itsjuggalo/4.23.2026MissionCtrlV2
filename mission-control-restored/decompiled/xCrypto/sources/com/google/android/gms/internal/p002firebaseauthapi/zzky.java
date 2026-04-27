package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzky implements zzqc<zzbh, zzbh> {
    private static final zzky zza = new zzky();
    private static final zzpr<zzoe, zzbh> zzb = zzpr.zza(new zzpt() { // from class: com.google.android.gms.internal.firebase-auth-api.zzlb
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpt
        public final Object zza(zzbm zzbmVar) {
            return zzmm.zza((zzoe) zzbmVar);
        }
    }, zzoe.class, zzbh.class);

    public static void zzc() {
        zzoz.zza().zza(zza);
        zzoz.zza().zza(zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqc
    public final Class<zzbh> zza() {
        return zzbh.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqc
    public final Class<zzbh> zzb() {
        return zzbh.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqc
    public final /* synthetic */ zzbh zza(zzoa zzoaVar, zzoj zzojVar, zzqb<zzbh> zzqbVar) throws GeneralSecurityException {
        zzaae zzaaeVarZzc;
        zzpq zzpqVar = new zzpq();
        for (int i4 = 0; i4 < zzoaVar.zza(); i4++) {
            zzod zzodVarZza = zzoaVar.zza(i4);
            if (zzodVarZza.zzc().equals(zzbo.zza)) {
                zzbh zzbhVarZza = zzqbVar.zza(zzodVarZza);
                zzbm zzbmVarZzb = zzodVarZza.zzb();
                if (zzbmVarZzb instanceof zzli) {
                    zzaaeVarZzc = ((zzli) zzbmVarZzb).zzh();
                } else {
                    if (!(zzbmVarZzb instanceof zzoe)) {
                        throw new GeneralSecurityException("Cannot get output prefix for key of class " + zzbmVarZzb.getClass().getName() + " with parameters " + String.valueOf(zzbmVarZzb.zza()));
                    }
                    zzaaeVarZzc = ((zzoe) zzbmVarZzb).zzc();
                }
                zzpqVar.zza(zzaaeVarZzc, new zzla(zzbhVarZza, zzodVarZza.zza()));
            }
        }
        return new zzld(zzpqVar.zza(), !zzojVar.zza() ? zzov.zzb().zza().zza(zzoaVar, zzojVar, "hybrid_decrypt", "decrypt") : zzoq.zza);
    }

    public static void zza(zzpx zzpxVar) throws GeneralSecurityException {
        zzpxVar.zza(zza);
    }
}
