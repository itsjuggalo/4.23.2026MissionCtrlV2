package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes.dex */
public final class zzhr {
    private static final zzix.zza zza = zzix.zza.zzb;
    private final SecretKey zzb;

    public zzhr(byte[] bArr) throws GeneralSecurityException {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        this.zzb = zzgu.zzb(bArr);
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2, int i4, byte[] bArr3) throws GeneralSecurityException {
        if (bArr.length != 12) {
            throw new GeneralSecurityException("iv is wrong size");
        }
        if (bArr2.length < i4 + 16) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        AlgorithmParameterSpec algorithmParameterSpecZza = zzgu.zza(bArr);
        Cipher cipherZza = zzgu.zza();
        cipherZza.init(2, this.zzb, algorithmParameterSpecZza);
        if (bArr3 != null && bArr3.length != 0) {
            cipherZza.updateAAD(bArr3);
        }
        return cipherZza.doFinal(bArr2, i4, bArr2.length - i4);
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2, int i4, byte[] bArr3) throws GeneralSecurityException {
        if (bArr.length != 12) {
            throw new GeneralSecurityException("iv is wrong size");
        }
        AlgorithmParameterSpec algorithmParameterSpecZza = zzgu.zza(bArr);
        Cipher cipherZza = zzgu.zza();
        cipherZza.init(1, this.zzb, algorithmParameterSpecZza);
        if (bArr3 != null && bArr3.length != 0) {
            cipherZza.updateAAD(bArr3);
        }
        int outputSize = cipherZza.getOutputSize(bArr2.length);
        if (outputSize > Integer.MAX_VALUE - i4) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr4 = new byte[i4 + outputSize];
        if (cipherZza.doFinal(bArr2, 0, bArr2.length, bArr4, i4) == outputSize) {
            return bArr4;
        }
        throw new GeneralSecurityException("not enough data written");
    }
}
