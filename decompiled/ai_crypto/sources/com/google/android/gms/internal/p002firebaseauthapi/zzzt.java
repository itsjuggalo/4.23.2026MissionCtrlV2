package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public final class zzzt implements zzso {
    private static final zzix.zza zza = zzix.zza.zza;
    private static final ThreadLocal<Cipher> zzb = new zzzw();
    private final SecretKey zzc;
    private byte[] zzd;
    private byte[] zze;

    public zzzt(byte[] bArr) throws GeneralSecurityException {
        zzzz.zza(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.zzc = secretKeySpec;
        Cipher cipherZza = zza();
        cipherZza.init(1, secretKeySpec);
        byte[] bArrZzb = zzse.zzb(cipherZza.doFinal(new byte[16]));
        this.zzd = bArrZzb;
        this.zze = zzse.zzb(bArrZzb);
    }

    private static Cipher zza() throws GeneralSecurityException {
        if (zza.zza()) {
            return zzb.get();
        }
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }

    private static void zza(byte[] bArr, byte[] bArr2, int i7, byte[] bArr3) {
        for (int i8 = 0; i8 < 16; i8++) {
            bArr3[i8] = (byte) (bArr[i8] ^ bArr2[i8 + i7]);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzso
    public final byte[] zza(byte[] bArr, int i7) throws GeneralSecurityException {
        byte[] bArrZza;
        if (i7 <= 16) {
            Cipher cipherZza = zza();
            cipherZza.init(1, this.zzc);
            int length = bArr.length;
            int i8 = length == 0 ? 1 : ((length - 1) / 16) + 1;
            if ((i8 << 4) == bArr.length) {
                bArrZza = zzyt.zza(bArr, (i8 - 1) << 4, this.zzd, 0, 16);
            } else {
                bArrZza = zzyt.zza(zzse.zza(Arrays.copyOfRange(bArr, (i8 - 1) << 4, bArr.length)), this.zze);
            }
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[16];
            for (int i9 = 0; i9 < i8 - 1; i9++) {
                zza(bArr2, bArr, i9 << 4, bArr3);
                if (cipherZza.doFinal(bArr3, 0, 16, bArr2) != 16) {
                    throw new IllegalStateException("Cipher didn't write full block");
                }
            }
            zza(bArr2, bArrZza, 0, bArr3);
            if (cipherZza.doFinal(bArr3, 0, 16, bArr2) == 16) {
                return 16 == i7 ? bArr2 : Arrays.copyOf(bArr2, i7);
            }
            throw new IllegalStateException("Cipher didn't write full block");
        }
        throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
    }
}
