package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzjl implements zzqc<zzbi, zzbi> {
    private static final zzjl zza = new zzjl();
    private static final zzpr<zzoe, zzbi> zzb = zzpr.zza(new zzpt() { // from class: com.google.android.gms.internal.firebase-auth-api.zzjo
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpt
        public final Object zza(zzbm zzbmVar) {
            return zzjy.zza((zzoe) zzbmVar);
        }
    }, zzoe.class, zzbi.class);

    public static void zzc() {
        zzoz.zza().zza(zza);
        zzoz.zza().zza(zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqc
    public final Class<zzbi> zza() {
        return zzbi.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqc
    public final Class<zzbi> zzb() {
        return zzbi.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqc
    public final /* synthetic */ zzbi zza(zzoa zzoaVar, zzoj zzojVar, zzqb<zzbi> zzqbVar) throws GeneralSecurityException {
        zzon zzonVarZza;
        zzon zzonVarZza2;
        zzaae zzaaeVarZzc;
        zzpq zzpqVar = new zzpq();
        for (int i4 = 0; i4 < zzoaVar.zza(); i4++) {
            zzod zzodVarZza = zzoaVar.zza(i4);
            if (zzodVarZza.zzc().equals(zzbo.zza)) {
                zzbi zzbiVarZza = zzqbVar.zza(zzodVarZza);
                zzbm zzbmVarZzb = zzodVarZza.zzb();
                if (zzbmVarZzb instanceof zzjj) {
                    zzaaeVarZzc = ((zzjj) zzbmVarZzb).zze();
                } else {
                    if (!(zzbmVarZzb instanceof zzoe)) {
                        throw new GeneralSecurityException("Cannot get output prefix for key of class " + zzbmVarZzb.getClass().getName() + " with parameters " + String.valueOf(zzbmVarZzb.zza()));
                    }
                    zzaaeVarZzc = ((zzoe) zzbmVarZzb).zzc();
                }
                zzpqVar.zza(zzaaeVarZzc, new zzjn(zzbiVarZza, zzodVarZza.zza()));
            }
        }
        if (zzojVar.zza()) {
            zzonVarZza = zzoq.zza;
            zzonVarZza2 = zzonVarZza;
        } else {
            zzoo zzooVarZza = zzov.zzb().zza();
            zzonVarZza = zzooVarZza.zza(zzoaVar, zzojVar, "daead", "encrypt");
            zzonVarZza2 = zzooVarZza.zza(zzoaVar, zzojVar, "daead", "decrypt");
        }
        return new zzjq(new zzjn(zzqbVar.zza(zzoaVar.zzc()), zzoaVar.zzc().zza()), zzpqVar.zza(), zzonVarZza, zzonVarZza2);
    }
}
