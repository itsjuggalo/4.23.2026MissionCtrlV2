package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzws;
import com.google.android.gms.internal.p002firebaseauthapi.zzxc;
import com.google.android.gms.internal.p002firebaseauthapi.zzxf;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
final class zzcl {
    static {
        Charset.forName("UTF-8");
    }

    public static zzxf zza(zzxc zzxcVar) {
        zzxf.zzb zzbVarZza = zzxf.zza().zza(zzxcVar.zzb());
        for (zzxc.zza zzaVar : zzxcVar.zze()) {
            zzbVarZza.zza((zzxf.zza) ((zzaky) zzxf.zza.zza().zza(zzaVar.zzb().zzf()).zza(zzaVar.zzc()).zza(zzaVar.zzf()).zza(zzaVar.zza()).zze()));
        }
        return (zzxf) ((zzaky) zzbVarZza.zze());
    }

    public static void zzb(zzxc zzxcVar) {
        int iZzb = zzxcVar.zzb();
        int i4 = 0;
        boolean z4 = false;
        boolean z5 = true;
        for (zzxc.zza zzaVar : zzxcVar.zze()) {
            if (zzaVar.zzc() == zzwt.ENABLED) {
                if (!zzaVar.e_()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(zzaVar.zza())));
                }
                if (zzaVar.zzf() == zzxu.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(zzaVar.zza())));
                }
                if (zzaVar.zzc() == zzwt.UNKNOWN_STATUS) {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(zzaVar.zza())));
                }
                if (zzaVar.zza() == iZzb) {
                    if (z4) {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                    z4 = true;
                }
                if (zzaVar.zzb().zzb() != zzws.zza.ASYMMETRIC_PUBLIC) {
                    z5 = false;
                }
                i4++;
            }
        }
        if (i4 == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
        if (!z4 && !z5) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
