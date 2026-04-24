package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdz;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes.dex */
final class zzlo implements zzlq {
    private final int zza;

    public zzlo(zzdz zzdzVar) throws GeneralSecurityException {
        if (zzdzVar.zzb() != 12) {
            throw new GeneralSecurityException("invalid IV size");
        }
        if (zzdzVar.zzd() != 16) {
            throw new GeneralSecurityException("invalid tag size");
        }
        if (zzdzVar.zzf() != zzdz.zzb.zzc) {
            throw new GeneralSecurityException("invalid variant");
        }
        this.zza = zzdzVar.zzc();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlq
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlq
    public final byte[] zza(byte[] bArr, byte[] bArr2, int i4) throws GeneralSecurityException {
        if (bArr2.length < i4) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (bArr.length != this.zza) {
            throw new GeneralSecurityException("invalid key size");
        }
        SecretKey secretKeyZzb = zzgu.zzb(bArr);
        int i5 = i4 + 12;
        if (bArr2.length < i4 + 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        AlgorithmParameterSpec algorithmParameterSpecZza = zzgu.zza(bArr2, i4, 12);
        Cipher cipherZza = zzgu.zza();
        cipherZza.init(2, secretKeyZzb, algorithmParameterSpecZza);
        return cipherZza.doFinal(bArr2, i5, (bArr2.length - i4) - 12);
    }
}
