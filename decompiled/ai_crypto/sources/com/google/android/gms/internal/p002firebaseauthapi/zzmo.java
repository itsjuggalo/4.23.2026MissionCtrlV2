package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzmo implements zzbk {
    private zzmo(zzbk zzbkVar, byte[] bArr) {
    }

    public static zzbk zza(zzoe zzoeVar) throws GeneralSecurityException {
        byte[] bArrZzb;
        zzqe zzqeVarZza = zzoeVar.zza(zzbj.zza());
        zzbk zzbkVar = (zzbk) zznt.zza().zza(zzqeVarZza.zzf(), zzbk.class).zzb(zzqeVarZza.zzd());
        zzxu zzxuVarZzc = zzqeVarZza.zzc();
        int i7 = zzmr.zza[zzxuVarZzc.ordinal()];
        if (i7 == 1) {
            bArrZzb = zzpd.zza.zzb();
        } else if (i7 == 2 || i7 == 3) {
            bArrZzb = zzpd.zza(zzoeVar.zzb().intValue()).zzb();
        } else {
            if (i7 != 4) {
                throw new GeneralSecurityException("unknown output prefix type " + String.valueOf(zzxuVarZzc));
            }
            bArrZzb = zzpd.zzb(zzoeVar.zzb().intValue()).zzb();
        }
        return new zzmo(zzbkVar, bArrZzb);
    }
}
