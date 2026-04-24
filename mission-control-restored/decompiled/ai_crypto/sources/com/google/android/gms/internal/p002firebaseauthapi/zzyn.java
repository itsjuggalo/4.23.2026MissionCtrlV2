package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.a;
import com.google.android.gms.internal.p002firebaseauthapi.zzix;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public final class zzyn implements zzbe {
    private static final zzix.zza zza = zzix.zza.zza;
    private static final ThreadLocal<Cipher> zzb = new zzyq();
    private static final ThreadLocal<Cipher> zzc = new zzyp();
    private final byte[] zzd;
    private final byte[] zze;
    private final byte[] zzf;
    private final SecretKeySpec zzg;
    private final int zzh;

    private zzyn(byte[] bArr, int i7, byte[] bArr2) throws GeneralSecurityException {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        if (i7 != 12 && i7 != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.zzh = i7;
        zzzz.zza(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.zzg = secretKeySpec;
        Cipher cipher = zzb.get();
        cipher.init(1, secretKeySpec);
        byte[] bArrZza = zza(cipher.doFinal(new byte[16]));
        this.zzd = bArrZza;
        this.zze = zza(bArrZza);
        this.zzf = bArr2;
    }

    public static zzbe zza(zzdl zzdlVar) throws GeneralSecurityException {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        if (((zzdq) ((zzcx) zzdlVar.zza())).zzd() == 16) {
            return new zzyn(zzdlVar.zzf().zza(zzbj.zza()), ((zzdq) ((zzcx) zzdlVar.zza())).zzb(), zzdlVar.zzd().zzb());
        }
        throw new GeneralSecurityException("AesEaxJce only supports 16 byte tag size, not " + ((zzdq) ((zzcx) zzdlVar.zza())).zzd());
    }

    private static void zzc(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            bArr[i7] = (byte) (bArr[i7] ^ bArr2[i7]);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        byte[] bArr3 = this.zzf;
        int length2 = a.e.API_PRIORITY_OTHER - bArr3.length;
        int i7 = this.zzh;
        if (length > (length2 - i7) - 16) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr3, bArr3.length + i7 + bArr.length + 16);
        byte[] bArrZza = zzqg.zza(this.zzh);
        System.arraycopy(bArrZza, 0, bArrCopyOf, this.zzf.length, this.zzh);
        Cipher cipher = zzb.get();
        cipher.init(1, this.zzg);
        byte[] bArrZza2 = zza(cipher, 0, bArrZza, 0, bArrZza.length);
        byte[] bArr4 = bArr2 == null ? new byte[0] : bArr2;
        byte[] bArrZza3 = zza(cipher, 1, bArr4, 0, bArr4.length);
        Cipher cipher2 = zzc.get();
        cipher2.init(1, this.zzg, new IvParameterSpec(bArrZza2));
        cipher2.doFinal(bArr, 0, bArr.length, bArrCopyOf, this.zzf.length + this.zzh);
        byte[] bArrZza4 = zza(cipher, 2, bArrCopyOf, this.zzf.length + this.zzh, bArr.length);
        int length3 = this.zzf.length + bArr.length + this.zzh;
        for (int i8 = 0; i8 < 16; i8++) {
            bArrCopyOf[length3 + i8] = (byte) ((bArrZza3[i8] ^ bArrZza2[i8]) ^ bArrZza4[i8]);
        }
        return bArrCopyOf;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        byte[] bArr3 = this.zzf;
        int length2 = ((length - bArr3.length) - this.zzh) - 16;
        if (length2 >= 0) {
            if (zzqq.zza(bArr3, bArr)) {
                Cipher cipher = zzb.get();
                cipher.init(1, this.zzg);
                byte[] bArrZza = zza(cipher, 0, bArr, this.zzf.length, this.zzh);
                if (bArr2 == null) {
                    bArr2 = new byte[0];
                }
                byte[] bArr4 = bArr2;
                byte[] bArrZza2 = zza(cipher, 1, bArr4, 0, bArr4.length);
                byte[] bArrZza3 = zza(cipher, 2, bArr, this.zzf.length + this.zzh, length2);
                int length3 = bArr.length - 16;
                byte b7 = 0;
                for (int i7 = 0; i7 < 16; i7++) {
                    b7 = (byte) (b7 | (((bArr[length3 + i7] ^ bArrZza2[i7]) ^ bArrZza[i7]) ^ bArrZza3[i7]));
                }
                if (b7 == 0) {
                    Cipher cipher2 = zzc.get();
                    cipher2.init(1, this.zzg, new IvParameterSpec(bArrZza));
                    return cipher2.doFinal(bArr, this.zzf.length + this.zzh, length2);
                }
                throw new AEADBadTagException("tag mismatch");
            }
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    private static byte[] zza(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i7 = 0;
        while (i7 < 15) {
            int i8 = i7 + 1;
            bArr2[i7] = (byte) ((bArr[i7] << 1) ^ ((bArr[i8] & 255) >>> 7));
            i7 = i8;
        }
        bArr2[15] = (byte) (((bArr[0] >> 7) & 135) ^ (bArr[15] << 1));
        return bArr2;
    }

    private final byte[] zza(Cipher cipher, int i7, byte[] bArr, int i8, int i9) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) i7;
        if (i9 == 0) {
            zzc(bArr2, this.zzd);
            return cipher.doFinal(bArr2);
        }
        byte[] bArr3 = new byte[16];
        cipher.doFinal(bArr2, 0, 16, bArr3);
        int i10 = 0;
        while (true) {
            byte[] bArr4 = bArr2;
            bArr2 = bArr3;
            bArr3 = bArr4;
            if (i9 - i10 <= 16) {
                break;
            }
            for (int i11 = 0; i11 < 16; i11++) {
                bArr2[i11] = (byte) (bArr2[i11] ^ bArr[(i8 + i10) + i11]);
            }
            cipher.doFinal(bArr2, 0, 16, bArr3);
            i10 += 16;
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i10 + i8, i8 + i9);
        if (bArrCopyOfRange.length == 16) {
            zzc(bArrCopyOfRange, this.zzd);
        } else {
            byte[] bArrCopyOf = Arrays.copyOf(this.zze, 16);
            for (int i12 = 0; i12 < bArrCopyOfRange.length; i12++) {
                bArrCopyOf[i12] = (byte) (bArrCopyOf[i12] ^ bArrCopyOfRange[i12]);
            }
            bArrCopyOf[bArrCopyOfRange.length] = (byte) (bArrCopyOf[bArrCopyOfRange.length] ^ 128);
            bArrCopyOfRange = bArrCopyOf;
        }
        zzc(bArr2, bArrCopyOfRange);
        cipher.doFinal(bArr2, 0, 16, bArr3);
        return bArr3;
    }
}
