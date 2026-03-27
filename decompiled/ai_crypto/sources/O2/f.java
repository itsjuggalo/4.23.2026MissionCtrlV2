package O2;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f4150a = {0, 3, 6, 9, 12, 16, 19, 22, 25, 28};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f4151b = {0, 2, 3, 5, 6, 0, 1, 3, 4, 6};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f4152c = {67108863, 33554431};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f4153d = {26, 25};

    public static byte[] a(long[] jArr) {
        int i7;
        long[] jArrCopyOf = Arrays.copyOf(jArr, 10);
        int i8 = 0;
        while (true) {
            if (i8 >= 2) {
                break;
            }
            int i9 = 0;
            while (i9 < 9) {
                long j7 = jArrCopyOf[i9];
                int i10 = f4153d[i9 & 1];
                int i11 = -((int) (((j7 >> 31) & j7) >> i10));
                jArrCopyOf[i9] = j7 + ((long) (i11 << i10));
                i9++;
                jArrCopyOf[i9] = jArrCopyOf[i9] - ((long) i11);
            }
            long j8 = jArrCopyOf[9];
            int i12 = -((int) (((j8 >> 31) & j8) >> 25));
            jArrCopyOf[9] = j8 + ((long) (i12 << 25));
            jArrCopyOf[0] = jArrCopyOf[0] - ((long) (i12 * 19));
            i8++;
        }
        long j9 = jArrCopyOf[0];
        int i13 = -((int) (((j9 >> 31) & j9) >> 26));
        jArrCopyOf[0] = j9 + ((long) (i13 << 26));
        jArrCopyOf[1] = jArrCopyOf[1] - ((long) i13);
        for (int i14 = 0; i14 < 2; i14++) {
            int i15 = 0;
            while (i15 < 9) {
                long j10 = jArrCopyOf[i15];
                int i16 = i15 & 1;
                int i17 = (int) (j10 >> f4153d[i16]);
                jArrCopyOf[i15] = j10 & ((long) f4152c[i16]);
                i15++;
                jArrCopyOf[i15] = jArrCopyOf[i15] + ((long) i17);
            }
        }
        long j11 = jArrCopyOf[9];
        jArrCopyOf[9] = j11 & 33554431;
        long j12 = jArrCopyOf[0] + ((long) (((int) (j11 >> 25)) * 19));
        jArrCopyOf[0] = j12;
        int iD = d((int) j12, 67108845);
        for (int i18 = 1; i18 < 10; i18++) {
            iD &= b((int) jArrCopyOf[i18], f4152c[i18 & 1]);
        }
        jArrCopyOf[0] = jArrCopyOf[0] - ((long) (67108845 & iD));
        long j13 = 33554431 & iD;
        jArrCopyOf[1] = jArrCopyOf[1] - j13;
        for (i7 = 2; i7 < 10; i7 += 2) {
            jArrCopyOf[i7] = jArrCopyOf[i7] - ((long) (67108863 & iD));
            int i19 = i7 + 1;
            jArrCopyOf[i19] = jArrCopyOf[i19] - j13;
        }
        for (int i20 = 0; i20 < 10; i20++) {
            jArrCopyOf[i20] = jArrCopyOf[i20] << f4151b[i20];
        }
        byte[] bArr = new byte[32];
        for (int i21 = 0; i21 < 10; i21++) {
            int i22 = f4150a[i21];
            long j14 = bArr[i22];
            long j15 = jArrCopyOf[i21];
            bArr[i22] = (byte) (j14 | (j15 & 255));
            bArr[i22 + 1] = (byte) (((long) bArr[r4]) | ((j15 >> 8) & 255));
            bArr[i22 + 2] = (byte) (((long) bArr[r4]) | ((j15 >> 16) & 255));
            bArr[i22 + 3] = (byte) (((long) bArr[r3]) | ((j15 >> 24) & 255));
        }
        return bArr;
    }

    public static int b(int i7, int i8) {
        int i9 = ~(i7 ^ i8);
        int i10 = i9 & (i9 << 16);
        int i11 = i10 & (i10 << 8);
        int i12 = i11 & (i11 << 4);
        int i13 = i12 & (i12 << 2);
        return (i13 & (i13 << 1)) >> 31;
    }

    public static long[] c(byte[] bArr) {
        long[] jArr = new long[10];
        for (int i7 = 0; i7 < 10; i7++) {
            int i8 = f4150a[i7];
            jArr[i7] = ((((((long) (bArr[i8] & 255)) | (((long) (bArr[i8 + 1] & 255)) << 8)) | (((long) (bArr[i8 + 2] & 255)) << 16)) | (((long) (bArr[i8 + 3] & 255)) << 24)) >> f4151b[i7]) & ((long) f4152c[i7 & 1]);
        }
        return jArr;
    }

    public static int d(int i7, int i8) {
        return ~((i7 - i8) >> 31);
    }

    public static void e(long[] jArr, long[] jArr2) {
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
        k(jArr3, jArr2);
        k(jArr12, jArr3);
        k(jArr11, jArr12);
        f(jArr4, jArr11, jArr2);
        f(jArr5, jArr4, jArr3);
        k(jArr11, jArr5);
        f(jArr6, jArr11, jArr4);
        k(jArr11, jArr6);
        k(jArr12, jArr11);
        k(jArr11, jArr12);
        k(jArr12, jArr11);
        k(jArr11, jArr12);
        f(jArr7, jArr11, jArr6);
        k(jArr11, jArr7);
        k(jArr12, jArr11);
        for (int i7 = 2; i7 < 10; i7 += 2) {
            k(jArr11, jArr12);
            k(jArr12, jArr11);
        }
        f(jArr8, jArr12, jArr7);
        k(jArr11, jArr8);
        k(jArr12, jArr11);
        for (int i8 = 2; i8 < 20; i8 += 2) {
            k(jArr11, jArr12);
            k(jArr12, jArr11);
        }
        f(jArr11, jArr12, jArr8);
        k(jArr12, jArr11);
        k(jArr11, jArr12);
        for (int i9 = 2; i9 < 10; i9 += 2) {
            k(jArr12, jArr11);
            k(jArr11, jArr12);
        }
        f(jArr9, jArr11, jArr7);
        k(jArr11, jArr9);
        k(jArr12, jArr11);
        for (int i10 = 2; i10 < 50; i10 += 2) {
            k(jArr11, jArr12);
            k(jArr12, jArr11);
        }
        f(jArr10, jArr12, jArr9);
        k(jArr12, jArr10);
        k(jArr11, jArr12);
        for (int i11 = 2; i11 < 100; i11 += 2) {
            k(jArr12, jArr11);
            k(jArr11, jArr12);
        }
        f(jArr12, jArr11, jArr10);
        k(jArr11, jArr12);
        k(jArr12, jArr11);
        for (int i12 = 2; i12 < 50; i12 += 2) {
            k(jArr11, jArr12);
            k(jArr12, jArr11);
        }
        f(jArr11, jArr12, jArr9);
        k(jArr12, jArr11);
        k(jArr11, jArr12);
        k(jArr12, jArr11);
        k(jArr11, jArr12);
        k(jArr12, jArr11);
        f(jArr, jArr12, jArr5);
    }

    public static void f(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[19];
        g(jArr4, jArr2, jArr3);
        h(jArr4, jArr);
    }

    public static void g(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr[0] = jArr2[0] * jArr3[0];
        long j7 = jArr2[0];
        long j8 = jArr3[1] * j7;
        long j9 = jArr2[1];
        long j10 = jArr3[0];
        jArr[1] = j8 + (j9 * j10);
        long j11 = jArr2[1];
        long j12 = jArr3[1];
        jArr[2] = (j11 * 2 * j12) + (jArr3[2] * j7) + (jArr2[2] * j10);
        long j13 = jArr3[2];
        long j14 = jArr2[2];
        jArr[3] = (j11 * j13) + (j14 * j12) + (jArr3[3] * j7) + (jArr2[3] * j10);
        long j15 = jArr3[3];
        long j16 = jArr2[3];
        jArr[4] = (j14 * j13) + (((j11 * j15) + (j16 * j12)) * 2) + (jArr3[4] * j7) + (jArr2[4] * j10);
        long j17 = jArr3[4];
        long j18 = jArr2[4];
        jArr[5] = (j14 * j15) + (j16 * j13) + (j11 * j17) + (j18 * j12) + (jArr3[5] * j7) + (jArr2[5] * j10);
        long j19 = jArr3[5];
        long j20 = jArr2[5];
        jArr[6] = (((j16 * j15) + (j11 * j19) + (j20 * j12)) * 2) + (j14 * j17) + (j18 * j13) + (jArr3[6] * j7) + (jArr2[6] * j10);
        long j21 = jArr3[6];
        long j22 = jArr2[6];
        jArr[7] = (j16 * j17) + (j18 * j15) + (j14 * j19) + (j20 * j13) + (j11 * j21) + (j22 * j12) + (jArr3[7] * j7) + (jArr2[7] * j10);
        long j23 = jArr3[7];
        long j24 = jArr2[7];
        jArr[8] = (j18 * j17) + (((j16 * j19) + (j20 * j15) + (j11 * j23) + (j24 * j12)) * 2) + (j14 * j21) + (j22 * j13) + (jArr3[8] * j7) + (jArr2[8] * j10);
        long j25 = jArr3[8];
        long j26 = jArr2[8];
        jArr[9] = (j18 * j19) + (j20 * j17) + (j16 * j21) + (j22 * j15) + (j14 * j23) + (j24 * j13) + (j11 * j25) + (j26 * j12) + (j7 * jArr3[9]) + (jArr2[9] * j10);
        long j27 = jArr3[9];
        long j28 = jArr2[9];
        jArr[10] = (((j20 * j19) + (j16 * j23) + (j24 * j15) + (j11 * j27) + (j12 * j28)) * 2) + (j18 * j21) + (j22 * j17) + (j14 * j25) + (j26 * j13);
        jArr[11] = (j20 * j21) + (j22 * j19) + (j18 * j23) + (j24 * j17) + (j16 * j25) + (j26 * j15) + (j14 * j27) + (j13 * j28);
        jArr[12] = (j22 * j21) + (((j20 * j23) + (j24 * j19) + (j16 * j27) + (j15 * j28)) * 2) + (j18 * j25) + (j26 * j17);
        jArr[13] = (j22 * j23) + (j24 * j21) + (j20 * j25) + (j26 * j19) + (j18 * j27) + (j17 * j28);
        jArr[14] = (((j24 * j23) + (j20 * j27) + (j19 * j28)) * 2) + (j22 * j25) + (j26 * j21);
        jArr[15] = (j24 * j25) + (j26 * j23) + (j22 * j27) + (j21 * j28);
        jArr[16] = (j26 * j25) + (((j24 * j27) + (j23 * j28)) * 2);
        jArr[17] = (j26 * j27) + (j25 * j28);
        jArr[18] = j28 * 2 * j27;
    }

    public static void h(long[] jArr, long[] jArr2) {
        if (jArr.length != 19) {
            long[] jArr3 = new long[19];
            System.arraycopy(jArr, 0, jArr3, 0, jArr.length);
            jArr = jArr3;
        }
        j(jArr);
        i(jArr);
        System.arraycopy(jArr, 0, jArr2, 0, 10);
    }

    public static void i(long[] jArr) {
        jArr[10] = 0;
        int i7 = 0;
        while (i7 < 10) {
            long j7 = jArr[i7];
            long j8 = j7 / 67108864;
            jArr[i7] = j7 - (j8 << 26);
            int i8 = i7 + 1;
            long j9 = jArr[i8] + j8;
            jArr[i8] = j9;
            long j10 = j9 / 33554432;
            jArr[i8] = j9 - (j10 << 25);
            i7 += 2;
            jArr[i7] = jArr[i7] + j10;
        }
        long j11 = jArr[0];
        long j12 = jArr[10];
        long j13 = j11 + (j12 << 4);
        jArr[0] = j13;
        long j14 = j13 + (j12 << 1);
        jArr[0] = j14;
        long j15 = j14 + j12;
        jArr[0] = j15;
        jArr[10] = 0;
        long j16 = j15 / 67108864;
        jArr[0] = j15 - (j16 << 26);
        jArr[1] = jArr[1] + j16;
    }

    public static void j(long[] jArr) {
        long j7 = jArr[8];
        long j8 = jArr[18];
        long j9 = j7 + (j8 << 4);
        jArr[8] = j9;
        long j10 = j9 + (j8 << 1);
        jArr[8] = j10;
        jArr[8] = j10 + j8;
        long j11 = jArr[7];
        long j12 = jArr[17];
        long j13 = j11 + (j12 << 4);
        jArr[7] = j13;
        long j14 = j13 + (j12 << 1);
        jArr[7] = j14;
        jArr[7] = j14 + j12;
        long j15 = jArr[6];
        long j16 = jArr[16];
        long j17 = j15 + (j16 << 4);
        jArr[6] = j17;
        long j18 = j17 + (j16 << 1);
        jArr[6] = j18;
        jArr[6] = j18 + j16;
        long j19 = jArr[5];
        long j20 = jArr[15];
        long j21 = j19 + (j20 << 4);
        jArr[5] = j21;
        long j22 = j21 + (j20 << 1);
        jArr[5] = j22;
        jArr[5] = j22 + j20;
        long j23 = jArr[4];
        long j24 = jArr[14];
        long j25 = j23 + (j24 << 4);
        jArr[4] = j25;
        long j26 = j25 + (j24 << 1);
        jArr[4] = j26;
        jArr[4] = j26 + j24;
        long j27 = jArr[3];
        long j28 = jArr[13];
        long j29 = j27 + (j28 << 4);
        jArr[3] = j29;
        long j30 = j29 + (j28 << 1);
        jArr[3] = j30;
        jArr[3] = j30 + j28;
        long j31 = jArr[2];
        long j32 = jArr[12];
        long j33 = j31 + (j32 << 4);
        jArr[2] = j33;
        long j34 = j33 + (j32 << 1);
        jArr[2] = j34;
        jArr[2] = j34 + j32;
        long j35 = jArr[1];
        long j36 = jArr[11];
        long j37 = j35 + (j36 << 4);
        jArr[1] = j37;
        long j38 = j37 + (j36 << 1);
        jArr[1] = j38;
        jArr[1] = j38 + j36;
        long j39 = jArr[0];
        long j40 = jArr[10];
        long j41 = j39 + (j40 << 4);
        jArr[0] = j41;
        long j42 = j41 + (j40 << 1);
        jArr[0] = j42;
        jArr[0] = j42 + j40;
    }

    public static void k(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[19];
        l(jArr3, jArr2);
        h(jArr3, jArr);
    }

    public static void l(long[] jArr, long[] jArr2) {
        long j7 = jArr2[0];
        jArr[0] = j7 * j7;
        long j8 = jArr2[0];
        jArr[1] = j8 * 2 * jArr2[1];
        long j9 = jArr2[1];
        jArr[2] = ((j9 * j9) + (jArr2[2] * j8)) * 2;
        long j10 = jArr2[2];
        jArr[3] = ((j9 * j10) + (jArr2[3] * j8)) * 2;
        long j11 = jArr2[3];
        jArr[4] = (j10 * j10) + (j9 * 4 * j11) + (j8 * 2 * jArr2[4]);
        long j12 = jArr2[4];
        jArr[5] = ((j10 * j11) + (j9 * j12) + (jArr2[5] * j8)) * 2;
        long j13 = (j11 * j11) + (j10 * j12) + (jArr2[6] * j8);
        long j14 = jArr2[5];
        jArr[6] = (j13 + (j9 * 2 * j14)) * 2;
        long j15 = jArr2[6];
        jArr[7] = ((j11 * j12) + (j10 * j14) + (j9 * j15) + (jArr2[7] * j8)) * 2;
        long j16 = (j10 * j15) + (jArr2[8] * j8);
        long j17 = jArr2[7];
        jArr[8] = (j12 * j12) + ((j16 + (((j9 * j17) + (j11 * j14)) * 2)) * 2);
        long j18 = jArr2[8];
        jArr[9] = ((j12 * j14) + (j11 * j15) + (j10 * j17) + (j9 * j18) + (j8 * jArr2[9])) * 2;
        long j19 = jArr2[9];
        jArr[10] = ((j14 * j14) + (j12 * j15) + (j10 * j18) + (((j11 * j17) + (j9 * j19)) * 2)) * 2;
        jArr[11] = ((j14 * j15) + (j12 * j17) + (j11 * j18) + (j10 * j19)) * 2;
        jArr[12] = (j15 * j15) + (((j12 * j18) + (((j14 * j17) + (j11 * j19)) * 2)) * 2);
        jArr[13] = ((j15 * j17) + (j14 * j18) + (j12 * j19)) * 2;
        jArr[14] = ((j17 * j17) + (j15 * j18) + (j14 * 2 * j19)) * 2;
        jArr[15] = ((j17 * j18) + (j15 * j19)) * 2;
        jArr[16] = (j18 * j18) + (j17 * 4 * j19);
        jArr[17] = j18 * 2 * j19;
        jArr[18] = 2 * j19 * j19;
    }

    public static void m(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i7 = 0; i7 < 10; i7++) {
            jArr[i7] = jArr2[i7] - jArr3[i7];
        }
    }

    public static void n(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i7 = 0; i7 < 10; i7++) {
            jArr[i7] = jArr2[i7] + jArr3[i7];
        }
    }
}
