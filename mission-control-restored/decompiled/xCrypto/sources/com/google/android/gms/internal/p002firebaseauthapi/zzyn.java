package com.google.android.gms.internal.p002firebaseauthapi;

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

    private zzyn(byte[] bArr, int i4, byte[] bArr2) throws GeneralSecurityException {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        if (i4 != 12 && i4 != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.zzh = i4;
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
        for (int i4 = 0; i4 < length; i4++) {
            bArr[i4] = (byte) (bArr[i4] ^ bArr2[i4]);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbe
    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        byte[] bArr3 = this.zzf;
        int length2 = Integer.MAX_VALUE - bArr3.length;
        int i4 = this.zzh;
        if (length > (length2 - i4) - 16) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr3, bArr3.length + i4 + bArr.length + 16);
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
        for (int i5 = 0; i5 < 16; i5++) {
            bArrCopyOf[length3 + i5] = (byte) ((bArrZza3[i5] ^ bArrZza2[i5]) ^ bArrZza4[i5]);
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
                byte[] bArr4 = bArr2 == null ? new byte[0] : bArr2;
                byte[] bArrZza2 = zza(cipher, 1, bArr4, 0, bArr4.length);
                byte[] bArrZza3 = zza(cipher, 2, bArr, this.zzf.length + this.zzh, length2);
                int length3 = bArr.length - 16;
                byte b4 = 0;
                for (int i4 = 0; i4 < 16; i4++) {
                    b4 = (byte) (b4 | (((bArr[length3 + i4] ^ bArrZza2[i4]) ^ bArrZza[i4]) ^ bArrZza3[i4]));
                }
                if (b4 == 0) {
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
        int i4 = 0;
        while (i4 < 15) {
            int i5 = i4 + 1;
            bArr2[i4] = (byte) ((bArr[i4] << 1) ^ ((bArr[i5] & 255) >>> 7));
            i4 = i5;
        }
        bArr2[15] = (byte) (((bArr[0] >> 7) & 135) ^ (bArr[15] << 1));
        return bArr2;
    }

    private final byte[] zza(Cipher cipher, int i4, byte[] bArr, int i5, int i6) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) i4;
        if (i6 == 0) {
            zzc(bArr2, this.zzd);
            return cipher.doFinal(bArr2);
        }
        byte[] bArr3 = new byte[16];
        cipher.doFinal(bArr2, 0, 16, bArr3);
        byte[] bArr4 = bArr3;
        byte[] bArr5 = bArr2;
        int i7 = 0;
        while (i6 - i7 > 16) {
            for (int i8 = 0; i8 < 16; i8++) {
                bArr4[i8] = (byte) (bArr4[i8] ^ bArr[(i5 + i7) + i8]);
            }
            cipher.doFinal(bArr4, 0, 16, bArr5);
            i7 += 16;
            byte[] bArr6 = bArr4;
            bArr4 = bArr5;
            bArr5 = bArr6;
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i7 + i5, i5 + i6);
        if (bArrCopyOfRange.length == 16) {
            zzc(bArrCopyOfRange, this.zzd);
        } else {
            byte[] bArrCopyOf = Arrays.copyOf(this.zze, 16);
            for (int i9 = 0; i9 < bArrCopyOfRange.length; i9++) {
                bArrCopyOf[i9] = (byte) (bArrCopyOf[i9] ^ bArrCopyOfRange[i9]);
            }
            bArrCopyOf[bArrCopyOfRange.length] = (byte) (bArrCopyOf[bArrCopyOfRange.length] ^ 128);
            bArrCopyOfRange = bArrCopyOf;
        }
        zzc(bArr4, bArrCopyOfRange);
        cipher.doFinal(bArr4, 0, 16, bArr5);
        return bArr5;
    }
}
