package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzqy implements zzqc<zzqz, zzqz> {
    private static final zzqy zza = new zzqy();

    private zzqy() {
    }

    public static void zzc() {
        zzoz.zza().zza(zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqc
    public final Class<zzqz> zza() {
        return zzqz.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqc
    public final Class<zzqz> zzb() {
        return zzqz.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqc
    public final /* synthetic */ zzqz zza(zzoa zzoaVar, zzoj zzojVar, zzqb<zzqz> zzqbVar) throws GeneralSecurityException {
        zzaae zzaaeVarZzc;
        zzod zzodVarZzc = zzoaVar.zzc();
        if (zzodVarZzc == null) {
            throw new GeneralSecurityException("no primary in primitive set");
        }
        zzpq zzpqVar = new zzpq();
        for (int i7 = 0; i7 < zzoaVar.zza(); i7++) {
            zzod zzodVarZza = zzoaVar.zza(i7);
            if (zzodVarZza.zzc().equals(zzbo.zza)) {
                zzqz zzqzVarZza = zzqbVar.zza(zzodVarZza);
                zzbm zzbmVarZzb = zzodVarZza.zzb();
                if (zzbmVarZzb instanceof zzrn) {
                    zzaaeVarZzc = ((zzrn) zzbmVarZzb).zze();
                } else {
                    if (!(zzbmVarZzb instanceof zzoe)) {
                        throw new GeneralSecurityException("Cannot get output prefix for key of class " + zzbmVarZzb.getClass().getName() + " with parameters " + String.valueOf(zzbmVarZzb.zza()));
                    }
                    zzaaeVarZzc = ((zzoe) zzbmVarZzb).zzc();
                }
                zzpqVar.zza(zzaaeVarZzc, zzqzVarZza);
            }
        }
        return new zzrb(zzpqVar.zza(), zzqbVar.zza(zzodVarZzc));
    }
}
