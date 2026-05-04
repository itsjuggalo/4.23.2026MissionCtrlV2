package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdx;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzlp implements zzlr {
    private final int zza;

    public zzlp(zzdx zzdxVar) throws GeneralSecurityException {
        if (zzdxVar.zzb() != 12) {
            throw new GeneralSecurityException("invalid IV size");
        }
        if (zzdxVar.zzd() != 16) {
            throw new GeneralSecurityException("invalid tag size");
        }
        if (zzdxVar.zzf() != zzdx.zza.zzc) {
            throw new GeneralSecurityException("invalid variant");
        }
        this.zza = zzdxVar.zzc();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlr
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlr
    public final byte[] zza(byte[] bArr, byte[] bArr2, int i10) throws GeneralSecurityException {
        if (bArr2.length < i10) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (bArr.length != this.zza) {
            throw new GeneralSecurityException("invalid key size");
        }
        SecretKey secretKeyZzb = zzgr.zzb(bArr);
        int i11 = i10 + 12;
        if (bArr2.length < i10 + 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        AlgorithmParameterSpec algorithmParameterSpecZza = zzgr.zza(bArr2, i10, 12);
        Cipher cipherZza = zzgr.zza();
        cipherZza.init(2, secretKeyZzb, algorithmParameterSpecZza);
        return cipherZza.doFinal(bArr2, i11, (bArr2.length - i10) - 12);
    }
}
