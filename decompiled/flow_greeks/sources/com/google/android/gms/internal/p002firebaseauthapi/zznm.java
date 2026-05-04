package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zznm {
    private static final int[] zza = {0, 3, 6, 9, 12, 16, 19, 22, 25, 28};
    private static final int[] zzb = {0, 2, 3, 5, 6, 0, 1, 3, 4, 6};
    private static final int[] zzc = {67108863, 33554431};
    private static final int[] zzd = {26, 25};

    public static void zza(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[10];
        long[] jArr4 = new long[10];
        long[] jArr5 = new long[10];
        long[] jArr6 = new long[10];
        long[] jArr7 = new long[10];
        long[] jArr8 = new long[10];
        long[] jArr9 = new long[10];
        long[] jArr10 = new long[10];
        long[] jArr11 = new long[10];
        long[] jArr12 = new long[10];
        zzb(jArr3, jArr2);
        zzb(jArr12, jArr3);
        zzb(jArr11, jArr12);
        zza(jArr4, jArr11, jArr2);
        zza(jArr5, jArr4, jArr3);
        zzb(jArr11, jArr5);
        zza(jArr6, jArr11, jArr4);
        zzb(jArr11, jArr6);
        zzb(jArr12, jArr11);
        zzb(jArr11, jArr12);
        zzb(jArr12, jArr11);
        zzb(jArr11, jArr12);
        zza(jArr7, jArr11, jArr6);
        zzb(jArr11, jArr7);
        zzb(jArr12, jArr11);
        for (int i10 = 2; i10 < 10; i10 += 2) {
            zzb(jArr11, jArr12);
            zzb(jArr12, jArr11);
        }
        zza(jArr8, jArr12, jArr7);
        zzb(jArr11, jArr8);
        zzb(jArr12, jArr11);
        for (int i11 = 2; i11 < 20; i11 += 2) {
            zzb(jArr11, jArr12);
            zzb(jArr12, jArr11);
        }
        zza(jArr11, jArr12, jArr8);
        zzb(jArr12, jArr11);
        zzb(jArr11, jArr12);
        for (int i12 = 2; i12 < 10; i12 += 2) {
            zzb(jArr12, jArr11);
            zzb(jArr11, jArr12);
        }
        zza(jArr9, jArr11, jArr7);
        zzb(jArr11, jArr9);
        zzb(jArr12, jArr11);
        for (int i13 = 2; i13 < 50; i13 += 2) {
            zzb(jArr11, jArr12);
            zzb(jArr12, jArr11);
        }
        zza(jArr10, jArr12, jArr9);
        zzb(jArr12, jArr10);
        zzb(jArr11, jArr12);
        for (int i14 = 2; i14 < 100; i14 += 2) {
            zzb(jArr12, jArr11);
            zzb(jArr11, jArr12);
        }
        zza(jArr12, jArr11, jArr10);
        zzb(jArr11, jArr12);
        zzb(jArr12, jArr11);
        for (int i15 = 2; i15 < 50; i15 += 2) {
            zzb(jArr11, jArr12);
            zzb(jArr12, jArr11);
        }
        zza(jArr11, jArr12, jArr9);
        zzb(jArr12, jArr11);
        zzb(jArr11, jArr12);
        zzb(jArr12, jArr11);
        zzb(jArr11, jArr12);
        zzb(jArr12, jArr11);
        zza(jArr, jArr12, jArr5);
    }

    public static void zzb(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr[0] = jArr2[0] * jArr3[0];
        long j10 = jArr2[0];
        long j11 = jArr3[1] * j10;
        long j12 = jArr2[1];
        long j13 = jArr3[0];
        jArr[1] = j11 + (j12 * j13);
        long j14 = jArr2[1];
        long j15 = jArr3[1];
        jArr[2] = (j14 * 2 * j15) + (jArr3[2] * j10) + (jArr2[2] * j13);
        long j16 = jArr3[2];
        long j17 = jArr2[2];
        jArr[3] = (j14 * j16) + (j17 * j15) + (jArr3[3] * j10) + (jArr2[3] * j13);
        long j18 = jArr3[3];
        long j19 = jArr2[3];
        jArr[4] = (j17 * j16) + (((j14 * j18) + (j19 * j15)) * 2) + (jArr3[4] * j10) + (jArr2[4] * j13);
        long j20 = jArr3[4];
        long j21 = jArr2[4];
        jArr[5] = (j17 * j18) + (j19 * j16) + (j14 * j20) + (j21 * j15) + (jArr3[5] * j10) + (jArr2[5] * j13);
        long j22 = jArr3[5];
        long j23 = jArr2[5];
        jArr[6] = (((j19 * j18) + (j14 * j22) + (j23 * j15)) * 2) + (j17 * j20) + (j21 * j16) + (jArr3[6] * j10) + (jArr2[6] * j13);
        long j24 = jArr3[6];
        long j25 = jArr2[6];
        jArr[7] = (j19 * j20) + (j21 * j18) + (j17 * j22) + (j23 * j16) + (j14 * j24) + (j25 * j15) + (jArr3[7] * j10) + (jArr2[7] * j13);
        long j26 = jArr3[7];
        long j27 = jArr2[7];
        jArr[8] = (j21 * j20) + (((j19 * j22) + (j23 * j18) + (j14 * j26) + (j27 * j15)) * 2) + (j17 * j24) + (j25 * j16) + (jArr3[8] * j10) + (jArr2[8] * j13);
        long j28 = jArr3[8];
        long j29 = jArr2[8];
        jArr[9] = (j21 * j22) + (j23 * j20) + (j19 * j24) + (j25 * j18) + (j17 * j26) + (j27 * j16) + (j14 * j28) + (j29 * j15) + (j10 * jArr3[9]) + (jArr2[9] * j13);
        long j30 = jArr3[9];
        long j31 = jArr2[9];
        jArr[10] = (((j23 * j22) + (j19 * j26) + (j27 * j18) + (j14 * j30) + (j15 * j31)) * 2) + (j21 * j24) + (j25 * j20) + (j17 * j28) + (j29 * j16);
        jArr[11] = (j23 * j24) + (j25 * j22) + (j21 * j26) + (j27 * j20) + (j19 * j28) + (j29 * j18) + (j17 * j30) + (j16 * j31);
        jArr[12] = (j25 * j24) + (((j23 * j26) + (j27 * j22) + (j19 * j30) + (j18 * j31)) * 2) + (j21 * j28) + (j29 * j20);
        jArr[13] = (j25 * j26) + (j27 * j24) + (j23 * j28) + (j29 * j22) + (j21 * j30) + (j20 * j31);
        jArr[14] = (((j27 * j26) + (j23 * j30) + (j22 * j31)) * 2) + (j25 * j28) + (j29 * j24);
        jArr[15] = (j27 * j28) + (j29 * j26) + (j25 * j30) + (j24 * j31);
        jArr[16] = (j29 * j28) + (((j27 * j30) + (j26 * j31)) * 2);
        jArr[17] = (j29 * j30) + (j28 * j31);
        jArr[18] = j31 * 2 * j30;
    }

    public static void zzc(long[] jArr, long[] jArr2) {
        zzc(jArr, jArr2, jArr);
    }

    public static void zzd(long[] jArr, long[] jArr2) {
        zzd(jArr, jArr, jArr2);
    }

    private static void zze(long[] jArr, long[] jArr2) {
        if (jArr.length != 19) {
            long[] jArr3 = new long[19];
            System.arraycopy(jArr, 0, jArr3, 0, jArr.length);
            jArr = jArr3;
        }
        zzb(jArr);
        zza(jArr);
        System.arraycopy(jArr, 0, jArr2, 0, 10);
    }

    public static void zzc(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i10 = 0; i10 < 10; i10++) {
            jArr[i10] = jArr2[i10] - jArr3[i10];
        }
    }

    public static void zzd(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i10 = 0; i10 < 10; i10++) {
            jArr[i10] = jArr2[i10] + jArr3[i10];
        }
    }

    public static byte[] zzc(long[] jArr) {
        int i10;
        long[] jArrCopyOf = Arrays.copyOf(jArr, 10);
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i12 >= 2) {
                break;
            }
            int i13 = 0;
            while (i13 < 9) {
                long j10 = jArrCopyOf[i13];
                int i14 = zzd[i13 & 1];
                int i15 = -((int) (((j10 >> 31) & j10) >> i14));
                jArrCopyOf[i13] = j10 + ((long) (i15 << i14));
                i13++;
                jArrCopyOf[i13] = jArrCopyOf[i13] - ((long) i15);
            }
            long j11 = jArrCopyOf[9];
            int i16 = -((int) (((j11 >> 31) & j11) >> 25));
            jArrCopyOf[9] = j11 + ((long) (i16 << 25));
            jArrCopyOf[0] = jArrCopyOf[0] - (((long) i16) * 19);
            i12++;
        }
        long j12 = jArrCopyOf[0];
        int i17 = -((int) (((j12 >> 31) & j12) >> 26));
        jArrCopyOf[0] = j12 + ((long) (i17 << 26));
        jArrCopyOf[1] = jArrCopyOf[1] - ((long) i17);
        int i18 = 0;
        while (i18 < 2) {
            int i19 = i11;
            while (i19 < 9) {
                long j13 = jArrCopyOf[i19];
                int i20 = i19 & 1;
                int i21 = i11;
                int i22 = (int) (j13 >> zzd[i20]);
                jArrCopyOf[i19] = j13 & ((long) zzc[i20]);
                i19++;
                jArrCopyOf[i19] = jArrCopyOf[i19] + ((long) i22);
                i11 = i21;
                i18 = i18;
            }
            i18++;
        }
        int i23 = i11;
        long j14 = jArrCopyOf[9];
        jArrCopyOf[9] = j14 & 33554431;
        long j15 = jArrCopyOf[i23] + (((long) ((int) (j14 >> 25))) * 19);
        jArrCopyOf[i23] = j15;
        int i24 = ~((((int) j15) - 67108845) >> 31);
        for (int i25 = 1; i25 < 10; i25++) {
            int i26 = ~(((int) jArrCopyOf[i25]) ^ zzc[i25 & 1]);
            int i27 = i26 & (i26 << 16);
            int i28 = i27 & (i27 << 8);
            int i29 = i28 & (i28 << 4);
            int i30 = i29 & (i29 << 2);
            i24 &= (i30 & (i30 << 1)) >> 31;
        }
        jArrCopyOf[i23] = jArrCopyOf[i23] - ((long) (67108845 & i24));
        long j16 = 33554431 & i24;
        jArrCopyOf[1] = jArrCopyOf[1] - j16;
        for (i10 = 2; i10 < 10; i10 += 2) {
            jArrCopyOf[i10] = jArrCopyOf[i10] - ((long) (67108863 & i24));
            int i31 = i10 + 1;
            jArrCopyOf[i31] = jArrCopyOf[i31] - j16;
        }
        for (int i32 = i23; i32 < 10; i32++) {
            jArrCopyOf[i32] = jArrCopyOf[i32] << zzb[i32];
        }
        byte[] bArr = new byte[32];
        for (int i33 = i23; i33 < 10; i33++) {
            int i34 = zza[i33];
            long j17 = bArr[i34];
            long j18 = jArrCopyOf[i33];
            bArr[i34] = (byte) (j17 | (j18 & 255));
            bArr[i34 + 1] = (byte) (((long) bArr[r5]) | ((j18 >> 8) & 255));
            bArr[i34 + 2] = (byte) (((long) bArr[r5]) | ((j18 >> 16) & 255));
            bArr[i34 + 3] = (byte) (((long) bArr[r4]) | ((j18 >> 24) & 255));
        }
        return bArr;
    }

    public static void zzb(long[] jArr) {
        long j10 = jArr[8];
        long j11 = jArr[18];
        long j12 = j10 + (j11 << 4);
        jArr[8] = j12;
        long j13 = j12 + (j11 << 1);
        jArr[8] = j13;
        jArr[8] = j13 + j11;
        long j14 = jArr[7];
        long j15 = jArr[17];
        long j16 = j14 + (j15 << 4);
        jArr[7] = j16;
        long j17 = j16 + (j15 << 1);
        jArr[7] = j17;
        jArr[7] = j17 + j15;
        long j18 = jArr[6];
        long j19 = jArr[16];
        long j20 = j18 + (j19 << 4);
        jArr[6] = j20;
        long j21 = j20 + (j19 << 1);
        jArr[6] = j21;
        jArr[6] = j21 + j19;
        long j22 = jArr[5];
        long j23 = jArr[15];
        long j24 = j22 + (j23 << 4);
        jArr[5] = j24;
        long j25 = j24 + (j23 << 1);
        jArr[5] = j25;
        jArr[5] = j25 + j23;
        long j26 = jArr[4];
        long j27 = jArr[14];
        long j28 = j26 + (j27 << 4);
        jArr[4] = j28;
        long j29 = j28 + (j27 << 1);
        jArr[4] = j29;
        jArr[4] = j29 + j27;
        long j30 = jArr[3];
        long j31 = jArr[13];
        long j32 = j30 + (j31 << 4);
        jArr[3] = j32;
        long j33 = j32 + (j31 << 1);
        jArr[3] = j33;
        jArr[3] = j33 + j31;
        long j34 = jArr[2];
        long j35 = jArr[12];
        long j36 = j34 + (j35 << 4);
        jArr[2] = j36;
        long j37 = j36 + (j35 << 1);
        jArr[2] = j37;
        jArr[2] = j37 + j35;
        long j38 = jArr[1];
        long j39 = jArr[11];
        long j40 = j38 + (j39 << 4);
        jArr[1] = j40;
        long j41 = j40 + (j39 << 1);
        jArr[1] = j41;
        jArr[1] = j41 + j39;
        long j42 = jArr[0];
        long j43 = jArr[10];
        long j44 = j42 + (j43 << 4);
        jArr[0] = j44;
        long j45 = j44 + (j43 << 1);
        jArr[0] = j45;
        jArr[0] = j45 + j43;
    }

    public static void zzb(long[] jArr, long[] jArr2) {
        long j10 = jArr2[0];
        long j11 = jArr2[1];
        long j12 = jArr2[2];
        long j13 = jArr2[3];
        long j14 = jArr2[4];
        long j15 = jArr2[5];
        long j16 = jArr2[6];
        long j17 = jArr2[7];
        long j18 = jArr2[8];
        long j19 = jArr2[9];
        zze(new long[]{j10 * j10, j10 * 2 * j11, ((j11 * j11) + (j10 * j12)) * 2, ((j11 * j12) + (j10 * j13)) * 2, (j12 * j12) + (j11 * 4 * j13) + (j10 * 2 * j14), ((j12 * j13) + (j11 * j14) + (j10 * j15)) * 2, ((j13 * j13) + (j12 * j14) + (j10 * j16) + (j11 * 2 * j15)) * 2, ((j13 * j14) + (j12 * j15) + (j11 * j16) + (j10 * j17)) * 2, (j14 * j14) + (((j12 * j16) + (j10 * j18) + (((j11 * j17) + (j13 * j15)) * 2)) * 2), ((j14 * j15) + (j13 * j16) + (j12 * j17) + (j11 * j18) + (j10 * j19)) * 2, ((j15 * j15) + (j14 * j16) + (j12 * j18) + (((j13 * j17) + (j11 * j19)) * 2)) * 2, ((j15 * j16) + (j14 * j17) + (j13 * j18) + (j12 * j19)) * 2, (j16 * j16) + (((j14 * j18) + (((j15 * j17) + (j13 * j19)) * 2)) * 2), ((j16 * j17) + (j15 * j18) + (j14 * j19)) * 2, ((j17 * j17) + (j16 * j18) + (j15 * 2 * j19)) * 2, ((j17 * j18) + (j16 * j19)) * 2, (j18 * j18) + (j17 * 4 * j19), j18 * 2 * j19, 2 * j19 * j19}, jArr);
    }

    public static void zza(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[19];
        zzb(jArr4, jArr2, jArr3);
        zze(jArr4, jArr);
    }

    public static void zza(long[] jArr) {
        jArr[10] = 0;
        int i10 = 0;
        while (i10 < 10) {
            long j10 = jArr[i10];
            long j11 = j10 / 67108864;
            jArr[i10] = j10 - (j11 << 26);
            int i11 = i10 + 1;
            long j12 = jArr[i11] + j11;
            jArr[i11] = j12;
            long j13 = j12 / 33554432;
            jArr[i11] = j12 - (j13 << 25);
            i10 += 2;
            jArr[i10] = jArr[i10] + j13;
        }
        long j14 = jArr[0];
        long j15 = jArr[10];
        long j16 = j14 + (j15 << 4);
        jArr[0] = j16;
        long j17 = j16 + (j15 << 1);
        jArr[0] = j17;
        long j18 = j17 + j15;
        jArr[0] = j18;
        jArr[10] = 0;
        long j19 = j18 / 67108864;
        jArr[0] = j18 - (j19 << 26);
        jArr[1] = jArr[1] + j19;
    }

    public static void zza(long[] jArr, long[] jArr2, long j10) {
        for (int i10 = 0; i10 < 10; i10++) {
            jArr[i10] = jArr2[i10] * j10;
        }
    }

    public static long[] zza(byte[] bArr) {
        long[] jArr = new long[10];
        for (int i10 = 0; i10 < 10; i10++) {
            int i11 = zza[i10];
            jArr[i10] = ((((((long) (bArr[i11] & 255)) | (((long) (bArr[i11 + 1] & 255)) << 8)) | (((long) (bArr[i11 + 2] & 255)) << 16)) | (((long) (bArr[i11 + 3] & 255)) << 24)) >> zzb[i10]) & ((long) zzc[i10 & 1]);
        }
        return jArr;
    }
}
