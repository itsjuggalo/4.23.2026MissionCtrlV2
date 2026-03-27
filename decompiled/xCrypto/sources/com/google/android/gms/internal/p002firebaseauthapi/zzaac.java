package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.InvalidKeyException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzaac {
    public static byte[] zza(byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("Private key must have 32 bytes.");
        }
        long[] jArr = new long[11];
        byte[] bArrCopyOf = Arrays.copyOf(bArr, 32);
        bArrCopyOf[0] = (byte) (bArrCopyOf[0] & 248);
        byte b4 = (byte) (bArrCopyOf[31] & 127);
        bArrCopyOf[31] = b4;
        bArrCopyOf[31] = (byte) (b4 | 64);
        zznj.zza(jArr, bArrCopyOf, bArr2);
        return zznp.zzc(jArr);
    }

    public static byte[] zza() {
        byte[] bArrZza = zzqg.zza(32);
        bArrZza[0] = (byte) (bArrZza[0] | 7);
        byte b4 = (byte) (bArrZza[31] & 63);
        bArrZza[31] = b4;
        bArrZza[31] = (byte) (b4 | 128);
        return bArrZza;
    }

    public static byte[] zza(byte[] bArr) throws InvalidKeyException {
        if (bArr.length == 32) {
            byte[] bArr2 = new byte[32];
            bArr2[0] = 9;
            return zza(bArr, bArr2);
        }
        throw new InvalidKeyException("Private key must have 32 bytes.");
    }
}
