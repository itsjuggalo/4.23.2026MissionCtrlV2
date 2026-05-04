package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzcj {
    public static zzcb zza(byte[] bArr) throws GeneralSecurityException {
        try {
            zzxb zzxbVarZza = zzxb.zza(bArr, zzaku.zza());
            zzoz zzozVarZza = zzoz.zza();
            zzqe zzqeVarZza = zzqe.zza(zzxbVarZza);
            return !zzozVarZza.zzc(zzqeVarZza) ? new zzoi(zzqeVarZza) : zzozVarZza.zza(zzqeVarZza);
        } catch (IOException e10) {
            throw new GeneralSecurityException("Failed to parse proto", e10);
        }
    }

    public static byte[] zza(zzcb zzcbVar) {
        if (zzcbVar instanceof zzoi) {
            return ((zzoi) zzcbVar).zzb().zza().zzk();
        }
        return ((zzqe) zzoz.zza().zza(zzcbVar, zzqe.class)).zza().zzk();
    }
}
