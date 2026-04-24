package D2;

import D2.a;
import java.lang.reflect.Array;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long[] f753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long[] f754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long[] f755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a.C0013a[][] f756d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a.C0013a[] f757e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final BigInteger f758f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final BigInteger f759g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final BigInteger f760h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final BigInteger f761i;

    /* JADX INFO: renamed from: D2.b$b, reason: collision with other inner class name */
    public static class C0014b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BigInteger f762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public BigInteger f763b;

        public C0014b() {
        }
    }

    static {
        BigInteger bigIntegerSubtract = BigInteger.valueOf(2L).pow(255).subtract(BigInteger.valueOf(19L));
        f758f = bigIntegerSubtract;
        BigInteger bigIntegerMod = BigInteger.valueOf(-121665L).multiply(BigInteger.valueOf(121666L).modInverse(bigIntegerSubtract)).mod(bigIntegerSubtract);
        f759g = bigIntegerMod;
        BigInteger bigIntegerMod2 = BigInteger.valueOf(2L).multiply(bigIntegerMod).mod(bigIntegerSubtract);
        f760h = bigIntegerMod2;
        BigInteger bigIntegerModPow = BigInteger.valueOf(2L).modPow(bigIntegerSubtract.subtract(BigInteger.ONE).divide(BigInteger.valueOf(4L)), bigIntegerSubtract);
        f761i = bigIntegerModPow;
        C0014b c0014b = new C0014b();
        c0014b.f763b = BigInteger.valueOf(4L).multiply(BigInteger.valueOf(5L).modInverse(bigIntegerSubtract)).mod(bigIntegerSubtract);
        c0014b.f762a = c(c0014b.f763b);
        f753a = f.c(d(bigIntegerMod));
        f754b = f.c(d(bigIntegerMod2));
        f755c = f.c(d(bigIntegerModPow));
        f756d = (a.C0013a[][]) Array.newInstance((Class<?>) a.C0013a.class, 32, 8);
        C0014b c0014bA = c0014b;
        for (int i8 = 0; i8 < 32; i8++) {
            C0014b c0014bA2 = c0014bA;
            for (int i9 = 0; i9 < 8; i9++) {
                f756d[i8][i9] = b(c0014bA2);
                c0014bA2 = a(c0014bA2, c0014bA);
            }
            for (int i10 = 0; i10 < 8; i10++) {
                c0014bA = a(c0014bA, c0014bA);
            }
        }
        C0014b c0014bA3 = a(c0014b, c0014b);
        f757e = new a.C0013a[8];
        for (int i11 = 0; i11 < 8; i11++) {
            f757e[i11] = b(c0014b);
            c0014b = a(c0014b, c0014bA3);
        }
    }

    public static C0014b a(C0014b c0014b, C0014b c0014b2) {
        C0014b c0014b3 = new C0014b();
        BigInteger bigIntegerMultiply = f759g.multiply(c0014b.f762a.multiply(c0014b2.f762a).multiply(c0014b.f763b).multiply(c0014b2.f763b));
        BigInteger bigInteger = f758f;
        BigInteger bigIntegerMod = bigIntegerMultiply.mod(bigInteger);
        BigInteger bigIntegerAdd = c0014b.f762a.multiply(c0014b2.f763b).add(c0014b2.f762a.multiply(c0014b.f763b));
        BigInteger bigInteger2 = BigInteger.ONE;
        c0014b3.f762a = bigIntegerAdd.multiply(bigInteger2.add(bigIntegerMod).modInverse(bigInteger)).mod(bigInteger);
        c0014b3.f763b = c0014b.f763b.multiply(c0014b2.f763b).add(c0014b.f762a.multiply(c0014b2.f762a)).multiply(bigInteger2.subtract(bigIntegerMod).modInverse(bigInteger)).mod(bigInteger);
        return c0014b3;
    }

    public static a.C0013a b(C0014b c0014b) {
        BigInteger bigIntegerAdd = c0014b.f763b.add(c0014b.f762a);
        BigInteger bigInteger = f758f;
        return new a.C0013a(f.c(d(bigIntegerAdd.mod(bigInteger))), f.c(d(c0014b.f763b.subtract(c0014b.f762a).mod(bigInteger))), f.c(d(f760h.multiply(c0014b.f762a).multiply(c0014b.f763b).mod(bigInteger))));
    }

    public static BigInteger c(BigInteger bigInteger) {
        BigInteger bigIntegerPow = bigInteger.pow(2);
        BigInteger bigInteger2 = BigInteger.ONE;
        BigInteger bigIntegerSubtract = bigIntegerPow.subtract(bigInteger2);
        BigInteger bigIntegerAdd = f759g.multiply(bigInteger.pow(2)).add(bigInteger2);
        BigInteger bigInteger3 = f758f;
        BigInteger bigIntegerMultiply = bigIntegerSubtract.multiply(bigIntegerAdd.modInverse(bigInteger3));
        BigInteger bigIntegerModPow = bigIntegerMultiply.modPow(bigInteger3.add(BigInteger.valueOf(3L)).divide(BigInteger.valueOf(8L)), bigInteger3);
        if (!bigIntegerModPow.pow(2).subtract(bigIntegerMultiply).mod(bigInteger3).equals(BigInteger.ZERO)) {
            bigIntegerModPow = bigIntegerModPow.multiply(f761i).mod(bigInteger3);
        }
        return bigIntegerModPow.testBit(0) ? bigInteger3.subtract(bigIntegerModPow) : bigIntegerModPow;
    }

    public static byte[] d(BigInteger bigInteger) {
        byte[] bArr = new byte[32];
        byte[] byteArray = bigInteger.toByteArray();
        System.arraycopy(byteArray, 0, bArr, 32 - byteArray.length, byteArray.length);
        for (int i8 = 0; i8 < 16; i8++) {
            byte b8 = bArr[i8];
            int i9 = 31 - i8;
            bArr[i8] = bArr[i9];
            bArr[i9] = b8;
        }
        return bArr;
    }
}
