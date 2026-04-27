package g2;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f11959a = {0, 3, 6, 9, 12, 16, 19, 22, 25, 28};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f11960b = {0, 2, 3, 5, 6, 0, 1, 3, 4, 6};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f11961c = {67108863, 33554431};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f11962d = {26, 25};

    public static byte[] a(long[] jArr) {
        int i4;
        long[] jArrCopyOf = Arrays.copyOf(jArr, 10);
        int i5 = 0;
        while (true) {
            if (i5 >= 2) {
                break;
            }
            int i6 = 0;
            while (i6 < 9) {
                long j4 = jArrCopyOf[i6];
                int i7 = f11962d[i6 & 1];
                int i8 = -((int) (((j4 >> 31) & j4) >> i7));
                jArrCopyOf[i6] = j4 + ((long) (i8 << i7));
                i6++;
                jArrCopyOf[i6] = jArrCopyOf[i6] - ((long) i8);
            }
            long j5 = jArrCopyOf[9];
            int i9 = -((int) (((j5 >> 31) & j5) >> 25));
            jArrCopyOf[9] = j5 + ((long) (i9 << 25));
            jArrCopyOf[0] = jArrCopyOf[0] - ((long) (i9 * 19));
            i5++;
        }
        long j6 = jArrCopyOf[0];
        int i10 = -((int) (((j6 >> 31) & j6) >> 26));
        jArrCopyOf[0] = j6 + ((long) (i10 << 26));
        jArrCopyOf[1] = jArrCopyOf[1] - ((long) i10);
        for (int i11 = 0; i11 < 2; i11++) {
            int i12 = 0;
            while (i12 < 9) {
                long j7 = jArrCopyOf[i12];
                int i13 = i12 & 1;
                int i14 = (int) (j7 >> f11962d[i13]);
                jArrCopyOf[i12] = j7 & ((long) f11961c[i13]);
                i12++;
                jArrCopyOf[i12] = jArrCopyOf[i12] + ((long) i14);
            }
        }
        long j8 = jArrCopyOf[9];
        jArrCopyOf[9] = j8 & 33554431;
        long j9 = jArrCopyOf[0] + ((long) (((int) (j8 >> 25)) * 19));
        jArrCopyOf[0] = j9;
        int iD = d((int) j9, 67108845);
        for (int i15 = 1; i15 < 10; i15++) {
            iD &= b((int) jArrCopyOf[i15], f11961c[i15 & 1]);
        }
        jArrCopyOf[0] = jArrCopyOf[0] - ((long) (67108845 & iD));
        long j10 = 33554431 & iD;
        jArrCopyOf[1] = jArrCopyOf[1] - j10;
        for (i4 = 2; i4 < 10; i4 += 2) {
            jArrCopyOf[i4] = jArrCopyOf[i4] - ((long) (67108863 & iD));
            int i16 = i4 + 1;
            jArrCopyOf[i16] = jArrCopyOf[i16] - j10;
        }
        for (int i17 = 0; i17 < 10; i17++) {
            jArrCopyOf[i17] = jArrCopyOf[i17] << f11960b[i17];
        }
        byte[] bArr = new byte[32];
        for (int i18 = 0; i18 < 10; i18++) {
            int i19 = f11959a[i18];
            long j11 = bArr[i19];
            long j12 = jArrCopyOf[i18];
            bArr[i19] = (byte) (j11 | (j12 & 255));
            bArr[i19 + 1] = (byte) (((long) bArr[r4]) | ((j12 >> 8) & 255));
            bArr[i19 + 2] = (byte) (((long) bArr[r4]) | ((j12 >> 16) & 255));
            bArr[i19 + 3] = (byte) (((long) bArr[r3]) | ((j12 >> 24) & 255));
        }
        return bArr;
    }

    public static int b(int i4, int i5) {
        int i6 = ~(i4 ^ i5);
        int i7 = i6 & (i6 << 16);
        int i8 = i7 & (i7 << 8);
        int i9 = i8 & (i8 << 4);
        int i10 = i9 & (i9 << 2);
        return (i10 & (i10 << 1)) >> 31;
    }

    public static long[] c(byte[] bArr) {
        long[] jArr = new long[10];
        for (int i4 = 0; i4 < 10; i4++) {
            int i5 = f11959a[i4];
            jArr[i4] = ((((((long) (bArr[i5] & 255)) | (((long) (bArr[i5 + 1] & 255)) << 8)) | (((long) (bArr[i5 + 2] & 255)) << 16)) | (((long) (bArr[i5 + 3] & 255)) << 24)) >> f11960b[i4]) & ((long) f11961c[i4 & 1]);
        }
        return jArr;
    }

    public static int d(int i4, int i5) {
        return ~((i4 - i5) >> 31);
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
        for (int i4 = 2; i4 < 10; i4 += 2) {
            k(jArr11, jArr12);
            k(jArr12, jArr11);
        }
        f(jArr8, jArr12, jArr7);
        k(jArr11, jArr8);
        k(jArr12, jArr11);
        for (int i5 = 2; i5 < 20; i5 += 2) {
            k(jArr11, jArr12);
            k(jArr12, jArr11);
        }
        f(jArr11, jArr12, jArr8);
        k(jArr12, jArr11);
        k(jArr11, jArr12);
        for (int i6 = 2; i6 < 10; i6 += 2) {
            k(jArr12, jArr11);
            k(jArr11, jArr12);
        }
        f(jArr9, jArr11, jArr7);
        k(jArr11, jArr9);
        k(jArr12, jArr11);
        for (int i7 = 2; i7 < 50; i7 += 2) {
            k(jArr11, jArr12);
            k(jArr12, jArr11);
        }
        f(jArr10, jArr12, jArr9);
        k(jArr12, jArr10);
        k(jArr11, jArr12);
        for (int i8 = 2; i8 < 100; i8 += 2) {
            k(jArr12, jArr11);
            k(jArr11, jArr12);
        }
        f(jArr12, jArr11, jArr10);
        k(jArr11, jArr12);
        k(jArr12, jArr11);
        for (int i9 = 2; i9 < 50; i9 += 2) {
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
        long j4 = jArr2[0];
        long j5 = jArr3[1] * j4;
        long j6 = jArr2[1];
        long j7 = jArr3[0];
        jArr[1] = j5 + (j6 * j7);
        long j8 = jArr2[1];
        long j9 = jArr3[1];
        jArr[2] = (j8 * 2 * j9) + (jArr3[2] * j4) + (jArr2[2] * j7);
        long j10 = jArr3[2];
        long j11 = jArr2[2];
        jArr[3] = (j8 * j10) + (j11 * j9) + (jArr3[3] * j4) + (jArr2[3] * j7);
        long j12 = jArr3[3];
        long j13 = jArr2[3];
        jArr[4] = (j11 * j10) + (((j8 * j12) + (j13 * j9)) * 2) + (jArr3[4] * j4) + (jArr2[4] * j7);
        long j14 = jArr3[4];
        long j15 = jArr2[4];
        jArr[5] = (j11 * j12) + (j13 * j10) + (j8 * j14) + (j15 * j9) + (jArr3[5] * j4) + (jArr2[5] * j7);
        long j16 = jArr3[5];
        long j17 = jArr2[5];
        jArr[6] = (((j13 * j12) + (j8 * j16) + (j17 * j9)) * 2) + (j11 * j14) + (j15 * j10) + (jArr3[6] * j4) + (jArr2[6] * j7);
        long j18 = jArr3[6];
        long j19 = jArr2[6];
        jArr[7] = (j13 * j14) + (j15 * j12) + (j11 * j16) + (j17 * j10) + (j8 * j18) + (j19 * j9) + (jArr3[7] * j4) + (jArr2[7] * j7);
        long j20 = jArr3[7];
        long j21 = jArr2[7];
        jArr[8] = (j15 * j14) + (((j13 * j16) + (j17 * j12) + (j8 * j20) + (j21 * j9)) * 2) + (j11 * j18) + (j19 * j10) + (jArr3[8] * j4) + (jArr2[8] * j7);
        long j22 = jArr3[8];
        long j23 = jArr2[8];
        jArr[9] = (j15 * j16) + (j17 * j14) + (j13 * j18) + (j19 * j12) + (j11 * j20) + (j21 * j10) + (j8 * j22) + (j23 * j9) + (j4 * jArr3[9]) + (jArr2[9] * j7);
        long j24 = jArr3[9];
        long j25 = jArr2[9];
        jArr[10] = (((j17 * j16) + (j13 * j20) + (j21 * j12) + (j8 * j24) + (j9 * j25)) * 2) + (j15 * j18) + (j19 * j14) + (j11 * j22) + (j23 * j10);
        jArr[11] = (j17 * j18) + (j19 * j16) + (j15 * j20) + (j21 * j14) + (j13 * j22) + (j23 * j12) + (j11 * j24) + (j10 * j25);
        jArr[12] = (j19 * j18) + (((j17 * j20) + (j21 * j16) + (j13 * j24) + (j12 * j25)) * 2) + (j15 * j22) + (j23 * j14);
        jArr[13] = (j19 * j20) + (j21 * j18) + (j17 * j22) + (j23 * j16) + (j15 * j24) + (j14 * j25);
        jArr[14] = (((j21 * j20) + (j17 * j24) + (j16 * j25)) * 2) + (j19 * j22) + (j23 * j18);
        jArr[15] = (j21 * j22) + (j23 * j20) + (j19 * j24) + (j18 * j25);
        jArr[16] = (j23 * j22) + (((j21 * j24) + (j20 * j25)) * 2);
        jArr[17] = (j23 * j24) + (j22 * j25);
        jArr[18] = j25 * 2 * j24;
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
        int i4 = 0;
        while (i4 < 10) {
            long j4 = jArr[i4];
            long j5 = j4 / 67108864;
            jArr[i4] = j4 - (j5 << 26);
            int i5 = i4 + 1;
            long j6 = jArr[i5] + j5;
            jArr[i5] = j6;
            long j7 = j6 / 33554432;
            jArr[i5] = j6 - (j7 << 25);
            i4 += 2;
            jArr[i4] = jArr[i4] + j7;
        }
        long j8 = jArr[0];
        long j9 = jArr[10];
        long j10 = j8 + (j9 << 4);
        jArr[0] = j10;
        long j11 = j10 + (j9 << 1);
        jArr[0] = j11;
        long j12 = j11 + j9;
        jArr[0] = j12;
        jArr[10] = 0;
        long j13 = j12 / 67108864;
        jArr[0] = j12 - (j13 << 26);
        jArr[1] = jArr[1] + j13;
    }

    public static void j(long[] jArr) {
        long j4 = jArr[8];
        long j5 = jArr[18];
        long j6 = j4 + (j5 << 4);
        jArr[8] = j6;
        long j7 = j6 + (j5 << 1);
        jArr[8] = j7;
        jArr[8] = j7 + j5;
        long j8 = jArr[7];
        long j9 = jArr[17];
        long j10 = j8 + (j9 << 4);
        jArr[7] = j10;
        long j11 = j10 + (j9 << 1);
        jArr[7] = j11;
        jArr[7] = j11 + j9;
        long j12 = jArr[6];
        long j13 = jArr[16];
        long j14 = j12 + (j13 << 4);
        jArr[6] = j14;
        long j15 = j14 + (j13 << 1);
        jArr[6] = j15;
        jArr[6] = j15 + j13;
        long j16 = jArr[5];
        long j17 = jArr[15];
        long j18 = j16 + (j17 << 4);
        jArr[5] = j18;
        long j19 = j18 + (j17 << 1);
        jArr[5] = j19;
        jArr[5] = j19 + j17;
        long j20 = jArr[4];
        long j21 = jArr[14];
        long j22 = j20 + (j21 << 4);
        jArr[4] = j22;
        long j23 = j22 + (j21 << 1);
        jArr[4] = j23;
        jArr[4] = j23 + j21;
        long j24 = jArr[3];
        long j25 = jArr[13];
        long j26 = j24 + (j25 << 4);
        jArr[3] = j26;
        long j27 = j26 + (j25 << 1);
        jArr[3] = j27;
        jArr[3] = j27 + j25;
        long j28 = jArr[2];
        long j29 = jArr[12];
        long j30 = j28 + (j29 << 4);
        jArr[2] = j30;
        long j31 = j30 + (j29 << 1);
        jArr[2] = j31;
        jArr[2] = j31 + j29;
        long j32 = jArr[1];
        long j33 = jArr[11];
        long j34 = j32 + (j33 << 4);
        jArr[1] = j34;
        long j35 = j34 + (j33 << 1);
        jArr[1] = j35;
        jArr[1] = j35 + j33;
        long j36 = jArr[0];
        long j37 = jArr[10];
        long j38 = j36 + (j37 << 4);
        jArr[0] = j38;
        long j39 = j38 + (j37 << 1);
        jArr[0] = j39;
        jArr[0] = j39 + j37;
    }

    public static void k(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[19];
        l(jArr3, jArr2);
        h(jArr3, jArr);
    }

    public static void l(long[] jArr, long[] jArr2) {
        long j4 = jArr2[0];
        jArr[0] = j4 * j4;
        long j5 = jArr2[0];
        jArr[1] = j5 * 2 * jArr2[1];
        long j6 = jArr2[1];
        jArr[2] = ((j6 * j6) + (jArr2[2] * j5)) * 2;
        long j7 = jArr2[2];
        jArr[3] = ((j6 * j7) + (jArr2[3] * j5)) * 2;
        long j8 = jArr2[3];
        jArr[4] = (j7 * j7) + (j6 * 4 * j8) + (j5 * 2 * jArr2[4]);
        long j9 = jArr2[4];
        jArr[5] = ((j7 * j8) + (j6 * j9) + (jArr2[5] * j5)) * 2;
        long j10 = (j8 * j8) + (j7 * j9) + (jArr2[6] * j5);
        long j11 = jArr2[5];
        jArr[6] = (j10 + (j6 * 2 * j11)) * 2;
        long j12 = jArr2[6];
        jArr[7] = ((j8 * j9) + (j7 * j11) + (j6 * j12) + (jArr2[7] * j5)) * 2;
        long j13 = (j7 * j12) + (jArr2[8] * j5);
        long j14 = jArr2[7];
        jArr[8] = (j9 * j9) + ((j13 + (((j6 * j14) + (j8 * j11)) * 2)) * 2);
        long j15 = jArr2[8];
        jArr[9] = ((j9 * j11) + (j8 * j12) + (j7 * j14) + (j6 * j15) + (j5 * jArr2[9])) * 2;
        long j16 = jArr2[9];
        jArr[10] = ((j11 * j11) + (j9 * j12) + (j7 * j15) + (((j8 * j14) + (j6 * j16)) * 2)) * 2;
        jArr[11] = ((j11 * j12) + (j9 * j14) + (j8 * j15) + (j7 * j16)) * 2;
        jArr[12] = (j12 * j12) + (((j9 * j15) + (((j11 * j14) + (j8 * j16)) * 2)) * 2);
        jArr[13] = ((j12 * j14) + (j11 * j15) + (j9 * j16)) * 2;
        jArr[14] = ((j14 * j14) + (j12 * j15) + (j11 * 2 * j16)) * 2;
        jArr[15] = ((j14 * j15) + (j12 * j16)) * 2;
        jArr[16] = (j15 * j15) + (j14 * 4 * j16);
        jArr[17] = j15 * 2 * j16;
        jArr[18] = 2 * j16 * j16;
    }

    public static void m(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i4 = 0; i4 < 10; i4++) {
            jArr[i4] = jArr2[i4] - jArr3[i4];
        }
    }

    public static void n(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i4 = 0; i4 < 10; i4++) {
            jArr[i4] = jArr2[i4] + jArr3[i4];
        }
    }
}
