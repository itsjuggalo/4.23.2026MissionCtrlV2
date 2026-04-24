package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzkv {
    private static final zzno zza = zzb();

    public static zzbf zza() throws GeneralSecurityException {
        if (zzix.zzb()) {
            throw new GeneralSecurityException("Cannot use non-FIPS-compliant HybridConfigurationV1 in FIPS mode");
        }
        return zza;
    }

    private static zzno zzb() {
        try {
            zzpx zzpxVarZza = zzpv.zza();
            zzlc.zza(zzpxVarZza);
            zzpxVarZza.zza(zzpr.zza(new zzpt() { // from class: com.google.android.gms.internal.firebase-auth-api.zzku
                @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpt
                public final Object zza(zzbm zzbmVar) {
                    return zzyy.zza((zzkg) zzbmVar);
                }
            }, zzkg.class, zzbk.class));
            zzpxVarZza.zza(zzpr.zza(new zzpt() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkx
                @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpt
                public final Object zza(zzbm zzbmVar) {
                    return zzmc.zza((zzkt) zzbmVar);
                }
            }, zzkt.class, zzbk.class));
            zzky.zza(zzpxVarZza);
            zzpxVarZza.zza(zzpr.zza(new zzpt() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkw
                @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpt
                public final Object zza(zzbm zzbmVar) {
                    return zzyv.zza((zzkh) zzbmVar);
                }
            }, zzkh.class, zzbh.class));
            zzpxVarZza.zza(zzpr.zza(new zzpt() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkz
                @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpt
                public final Object zza(zzbm zzbmVar) {
                    return zzmd.zza((zzkl) zzbmVar);
                }
            }, zzkl.class, zzbh.class));
            return zzno.zza(zzpxVarZza.zza());
        } catch (GeneralSecurityException e4) {
            throw new IllegalStateException(e4);
        }
    }
}
