package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzqz implements zzpz<zzqw, zzqw> {
    private static final zzqz zza = new zzqz();

    private zzqz() {
    }

    public static void zzc() {
        zzpa.zza().zza(zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
    public final Class<zzqw> zza() {
        return zzqw.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
    public final Class<zzqw> zzb() {
        return zzqw.class;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
    public final /* synthetic */ zzqw zza(zzob zzobVar, zzok zzokVar, zzqc<zzqw> zzqcVar) throws GeneralSecurityException {
        zzaaj zzaajVarZzc;
        zzoa zzoaVarZzc = zzobVar.zzc();
        if (zzoaVarZzc == null) {
            throw new GeneralSecurityException("no primary in primitive set");
        }
        zzpn zzpnVar = new zzpn();
        for (int i10 = 0; i10 < zzobVar.zza(); i10++) {
            zzoa zzoaVarZza = zzobVar.zza(i10);
            if (zzoaVarZza.zzc().equals(zzbk.zza)) {
                zzqw zzqwVarZza = zzqcVar.zza(zzoaVarZza);
                zzbi zzbiVarZzb = zzoaVarZza.zzb();
                if (zzbiVarZzb instanceof zzrk) {
                    zzaajVarZzc = ((zzrk) zzbiVarZzb).zze();
                } else {
                    if (!(zzbiVarZzb instanceof zzof)) {
                        throw new GeneralSecurityException("Cannot get output prefix for key of class " + zzbiVarZzb.getClass().getName() + " with parameters " + String.valueOf(zzbiVarZzb.zza()));
                    }
                    zzaajVarZzc = ((zzof) zzbiVarZzb).zzc();
                }
                zzpnVar.zza(zzaajVarZzc, zzqwVarZza);
            }
        }
        return new zzqy(zzpnVar.zza(), zzqcVar.zza(zzoaVarZzc));
    }
}
