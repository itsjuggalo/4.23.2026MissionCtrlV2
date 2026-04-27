package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzrp implements zzqc<zzcb, zzcb> {
    private static final zzrp zza = new zzrp();
    private static final zzpr<zzoe, zzcb> zzb = zzpr.zza(new zzpt() { // from class: com.google.android.gms.internal.firebase-auth-api.zzro
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpt
        public final Object zza(zzbm zzbmVar) {
            return zzsm.zza((zzoe) zzbmVar);
        }
    }, zzoe.class, zzcb.class);

    public static void zzc() {
        zzoz.zza().zza(zza);
        zzoz.zza().zza(zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqc
    public final Class<zzcb> zza() {
        return zzcb.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqc
    public final Class<zzcb> zzb() {
        return zzcb.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqc
    public final /* synthetic */ zzcb zza(zzoa zzoaVar, zzoj zzojVar, zzqb<zzcb> zzqbVar) throws GeneralSecurityException {
        zzon zzonVar;
        zzon zzonVarZza;
        zzaae zzaaeVarZzc;
        zzpq zzpqVar = new zzpq();
        for (int i4 = 0; i4 < zzoaVar.zza(); i4++) {
            zzod zzodVarZza = zzoaVar.zza(i4);
            if (zzodVarZza.zzc().equals(zzbo.zza)) {
                zzcb zzcbVarZza = zzqbVar.zza(zzodVarZza);
                zzbm zzbmVarZzb = zzodVarZza.zzb();
                if (zzbmVarZzb instanceof zzrn) {
                    zzaaeVarZzc = ((zzrn) zzbmVarZzb).zze();
                } else {
                    if (!(zzbmVarZzb instanceof zzoe)) {
                        throw new GeneralSecurityException("Cannot get output prefix for key of class " + zzbmVarZzb.getClass().getName() + " with parameters " + String.valueOf(zzbmVarZzb.zza()));
                    }
                    zzaaeVarZzc = ((zzoe) zzbmVarZzb).zzc();
                }
                zzpqVar.zza(zzaaeVarZzc, new zzrr(zzcbVarZza, zzodVarZza.zza()));
            }
        }
        if (zzojVar.zza()) {
            zzonVar = zzoq.zza;
            zzonVarZza = zzonVar;
        } else {
            zzoo zzooVarZza = zzov.zzb().zza();
            zzon zzonVarZza2 = zzooVarZza.zza(zzoaVar, zzojVar, "mac", "compute");
            zzonVarZza = zzooVarZza.zza(zzoaVar, zzojVar, "mac", "verify");
            zzonVar = zzonVarZza2;
        }
        return new zzrq(new zzrr(zzqbVar.zza(zzoaVar.zzc()), zzoaVar.zzc().zza()), zzpqVar.zza(), zzonVar, zzonVarZza);
    }
}
