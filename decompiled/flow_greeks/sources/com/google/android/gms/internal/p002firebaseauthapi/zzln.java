package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzln {
    private static final byte[] zza = new byte[0];

    public static zzlr zza(zzkb zzkbVar) throws GeneralSecurityException {
        zzcb zzcbVarZzb = zzkbVar.zzb();
        if (zzcbVarZzb instanceof zzdx) {
            return new zzlp((zzdx) zzcbVarZzb);
        }
        if (zzcbVarZzb instanceof zzdi) {
            return new zzlm((zzdi) zzcbVarZzb);
        }
        if (zzcbVarZzb instanceof zzjf) {
            return new zzlo((zzjf) zzcbVarZzb);
        }
        throw new GeneralSecurityException("Unsupported DEM parameters: " + String.valueOf(zzcbVarZzb));
    }
}
