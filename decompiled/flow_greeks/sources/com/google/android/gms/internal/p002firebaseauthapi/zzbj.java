package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbj {
    private final zzcb zza;

    private zzbj(zzcb zzcbVar) {
        this.zza = zzcbVar;
    }

    public static zzbj zza(zzcb zzcbVar) {
        return new zzbj(zzcbVar);
    }

    private final zzxb zzb() {
        try {
            zzcb zzcbVar = this.zza;
            return zzcbVar instanceof zzoi ? ((zzoi) zzcbVar).zzb().zza() : ((zzqe) zzoz.zza().zza(this.zza, zzqe.class)).zza();
        } catch (GeneralSecurityException e10) {
            throw new zzql("Parsing parameters failed in getProto(). You probably want to call some Tink register function for " + String.valueOf(this.zza), e10);
        }
    }

    public final zzcb zza() {
        zzcb zzcbVar = this.zza;
        return zzcbVar != null ? zzcbVar : zzcj.zza(zzb().zzk());
    }
}
