package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzic {
    private static long zza(byte[] bArr, int i, int i6) {
        return (zza(bArr, i) >> i6) & 67108863;
    }

    private static long zza(byte[] bArr, int i) {
        return ((long) (((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16))) & 4294967295L;
    }

    private static void zza(byte[] bArr, long j4, int i) {
        int i6 = 0;
        while (i6 < 4) {
            bArr[i + i6] = (byte) (255 & j4);
            i6++;
            j4 >>= 8;
        }
    }

    public static byte[] zza(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 32) {
            long jZza = zza(bArr, 0, 0) & 67108863;
            long jZza2 = zza(bArr, 3, 2) & 67108611;
            long jZza3 = zza(bArr, 6, 4) & 67092735;
            long jZza4 = zza(bArr, 9, 6) & 66076671;
            long jZza5 = zza(bArr, 12, 8) & 1048575;
            long j4 = jZza2 * 5;
            long j6 = jZza3 * 5;
            long j7 = jZza4 * 5;
            long j8 = jZza5 * 5;
            int i = 17;
            byte[] bArr3 = new byte[17];
            long j9 = 0;
            int i6 = 0;
            long j10 = 0;
            long j11 = 0;
            long j12 = 0;
            long j13 = 0;
            while (i6 < bArr2.length) {
                int iMin = Math.min(16, bArr2.length - i6);
                System.arraycopy(bArr2, i6, bArr3, 0, iMin);
                bArr3[iMin] = 1;
                if (iMin != 16) {
                    Arrays.fill(bArr3, iMin + 1, i, (byte) 0);
                }
                long jZza6 = j13 + zza(bArr3, 0, 0);
                long jZza7 = j9 + zza(bArr3, 3, 2);
                long jZza8 = j10 + zza(bArr3, 6, 4);
                long jZza9 = j11 + zza(bArr3, 9, 6);
                long jZza10 = j12 + (zza(bArr3, 12, 8) | ((long) (bArr3[16] << 24)));
                long j14 = (jZza10 * j4) + (jZza9 * j6) + (jZza8 * j7) + (jZza7 * j8) + (jZza6 * jZza);
                long j15 = (jZza10 * j6) + (jZza9 * j7) + (jZza8 * j8) + (jZza7 * jZza) + (jZza6 * jZza2);
                long j16 = (jZza10 * j7) + (jZza9 * j8) + (jZza8 * jZza) + (jZza7 * jZza2) + (jZza6 * jZza3);
                long j17 = (jZza10 * j8) + (jZza9 * jZza) + (jZza8 * jZza2) + (jZza7 * jZza3) + (jZza6 * jZza4);
                long j18 = jZza9 * jZza2;
                long j19 = jZza10 * jZza;
                long j20 = j15 + (j14 >> 26);
                long j21 = j16 + (j20 >> 26);
                long j22 = j17 + (j21 >> 26);
                long j23 = j19 + j18 + (jZza8 * jZza3) + (jZza7 * jZza4) + (jZza6 * jZza5) + (j22 >> 26);
                long j24 = j23 >> 26;
                j12 = j23 & 67108863;
                long j25 = (j24 * 5) + (j14 & 67108863);
                i6 += 16;
                j10 = j21 & 67108863;
                j11 = j22 & 67108863;
                i = 17;
                j13 = j25 & 67108863;
                j9 = (j20 & 67108863) + (j25 >> 26);
            }
            long j26 = j10 + (j9 >> 26);
            long j27 = j26 & 67108863;
            long j28 = j11 + (j26 >> 26);
            long j29 = j28 & 67108863;
            long j30 = j12 + (j28 >> 26);
            long j31 = j30 & 67108863;
            long j32 = ((j30 >> 26) * 5) + j13;
            long j33 = j32 >> 26;
            long j34 = j32 & 67108863;
            long j35 = (j9 & 67108863) + j33;
            long j36 = j34 + 5;
            long j37 = j36 & 67108863;
            long j38 = (j36 >> 26) + j35;
            long j39 = j27 + (j38 >> 26);
            long j40 = j29 + (j39 >> 26);
            long j41 = (j31 + (j40 >> 26)) - 67108864;
            long j42 = j41 >> 63;
            long j43 = ~j42;
            long j44 = (j34 & j42) | (j37 & j43);
            long j45 = (j35 & j42) | (j38 & 67108863 & j43);
            long j46 = (j27 & j42) | (j39 & 67108863 & j43);
            long j47 = (j29 & j42) | (j40 & 67108863 & j43);
            long j48 = (j44 | (j45 << 26)) & 4294967295L;
            long j49 = ((j45 >> 6) | (j46 << 20)) & 4294967295L;
            long j50 = ((j46 >> 12) | (j47 << 14)) & 4294967295L;
            long j51 = ((((j41 & j43) | (j31 & j42)) << 8) | (j47 >> 18)) & 4294967295L;
            long jZza11 = j48 + zza(bArr, 16);
            long j52 = jZza11 & 4294967295L;
            long jZza12 = j49 + zza(bArr, 20) + (jZza11 >> 32);
            long jZza13 = j50 + zza(bArr, 24) + (jZza12 >> 32);
            long jZza14 = (j51 + zza(bArr, 28) + (jZza13 >> 32)) & 4294967295L;
            byte[] bArr4 = new byte[16];
            zza(bArr4, j52, 0);
            zza(bArr4, jZza12 & 4294967295L, 4);
            zza(bArr4, jZza13 & 4294967295L, 8);
            zza(bArr4, jZza14, 12);
            return bArr4;
        }
        throw new IllegalArgumentException("The key length in bytes must be 32.");
    }
}
