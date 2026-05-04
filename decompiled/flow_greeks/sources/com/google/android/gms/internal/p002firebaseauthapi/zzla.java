package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzla implements zzbd {
    private final zzpl<zzlb> zza;
    private final zzoo zzb;

    public zzla(zzpl<zzlb> zzplVar, zzoo zzooVar) {
        this.zza = zzplVar;
        this.zzb = zzooVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbd
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        for (zzlb zzlbVar : this.zza.zza(bArr)) {
            try {
                byte[] bArrZza = zzlbVar.zza.zza(bArr, bArr2);
                this.zzb.zza(zzlbVar.zzb, bArr.length);
                return bArrZza;
            } catch (GeneralSecurityException unused) {
            }
        }
        this.zzb.zza();
        throw new GeneralSecurityException("decryption failed");
    }
}
