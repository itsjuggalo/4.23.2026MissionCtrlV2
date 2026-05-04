package x6;

import java.lang.reflect.Array;
import java.math.BigInteger;
import x6.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long[] f24225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long[] f24226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long[] f24227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a.C0424a[][] f24228d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a.C0424a[] f24229e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final BigInteger f24230f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final BigInteger f24231g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final BigInteger f24232h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final BigInteger f24233i;

    /* JADX INFO: renamed from: x6.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class C0425b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BigInteger f24234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public BigInteger f24235b;

        public C0425b() {
        }
    }

    static {
        BigInteger bigIntegerSubtract = BigInteger.valueOf(2L).pow(255).subtract(BigInteger.valueOf(19L));
        f24230f = bigIntegerSubtract;
        BigInteger bigIntegerMod = BigInteger.valueOf(-121665L).multiply(BigInteger.valueOf(121666L).modInverse(bigIntegerSubtract)).mod(bigIntegerSubtract);
        f24231g = bigIntegerMod;
        BigInteger bigIntegerMod2 = BigInteger.valueOf(2L).multiply(bigIntegerMod).mod(bigIntegerSubtract);
        f24232h = bigIntegerMod2;
        BigInteger bigIntegerModPow = BigInteger.valueOf(2L).modPow(bigIntegerSubtract.subtract(BigInteger.ONE).divide(BigInteger.valueOf(4L)), bigIntegerSubtract);
        f24233i = bigIntegerModPow;
        C0425b c0425b = new C0425b();
        c0425b.f24235b = BigInteger.valueOf(4L).multiply(BigInteger.valueOf(5L).modInverse(bigIntegerSubtract)).mod(bigIntegerSubtract);
        c0425b.f24234a = c(c0425b.f24235b);
        f24225a = f.c(d(bigIntegerMod));
        f24226b = f.c(d(bigIntegerMod2));
        f24227c = f.c(d(bigIntegerModPow));
        f24228d = (a.C0424a[][]) Array.newInstance((Class<?>) a.C0424a.class, 32, 8);
        C0425b c0425bA = c0425b;
        for (int i10 = 0; i10 < 32; i10++) {
            C0425b c0425bA2 = c0425bA;
            for (int i11 = 0; i11 < 8; i11++) {
                f24228d[i10][i11] = b(c0425bA2);
                c0425bA2 = a(c0425bA2, c0425bA);
            }
            for (int i12 = 0; i12 < 8; i12++) {
                c0425bA = a(c0425bA, c0425bA);
            }
        }
        C0425b c0425bA3 = a(c0425b, c0425b);
        f24229e = new a.C0424a[8];
        for (int i13 = 0; i13 < 8; i13++) {
            f24229e[i13] = b(c0425b);
            c0425b = a(c0425b, c0425bA3);
        }
    }

    public static C0425b a(C0425b c0425b, C0425b c0425b2) {
        C0425b c0425b3 = new C0425b();
        BigInteger bigIntegerMultiply = f24231g.multiply(c0425b.f24234a.multiply(c0425b2.f24234a).multiply(c0425b.f24235b).multiply(c0425b2.f24235b));
        BigInteger bigInteger = f24230f;
        BigInteger bigIntegerMod = bigIntegerMultiply.mod(bigInteger);
        BigInteger bigIntegerAdd = c0425b.f24234a.multiply(c0425b2.f24235b).add(c0425b2.f24234a.multiply(c0425b.f24235b));
        BigInteger bigInteger2 = BigInteger.ONE;
        c0425b3.f24234a = bigIntegerAdd.multiply(bigInteger2.add(bigIntegerMod).modInverse(bigInteger)).mod(bigInteger);
        c0425b3.f24235b = c0425b.f24235b.multiply(c0425b2.f24235b).add(c0425b.f24234a.multiply(c0425b2.f24234a)).multiply(bigInteger2.subtract(bigIntegerMod).modInverse(bigInteger)).mod(bigInteger);
        return c0425b3;
    }

    public static a.C0424a b(C0425b c0425b) {
        BigInteger bigIntegerAdd = c0425b.f24235b.add(c0425b.f24234a);
        BigInteger bigInteger = f24230f;
        return new a.C0424a(f.c(d(bigIntegerAdd.mod(bigInteger))), f.c(d(c0425b.f24235b.subtract(c0425b.f24234a).mod(bigInteger))), f.c(d(f24232h.multiply(c0425b.f24234a).multiply(c0425b.f24235b).mod(bigInteger))));
    }

    public static BigInteger c(BigInteger bigInteger) {
        BigInteger bigIntegerPow = bigInteger.pow(2);
        BigInteger bigInteger2 = BigInteger.ONE;
        BigInteger bigIntegerSubtract = bigIntegerPow.subtract(bigInteger2);
        BigInteger bigIntegerAdd = f24231g.multiply(bigInteger.pow(2)).add(bigInteger2);
        BigInteger bigInteger3 = f24230f;
        BigInteger bigIntegerMultiply = bigIntegerSubtract.multiply(bigIntegerAdd.modInverse(bigInteger3));
        BigInteger bigIntegerModPow = bigIntegerMultiply.modPow(bigInteger3.add(BigInteger.valueOf(3L)).divide(BigInteger.valueOf(8L)), bigInteger3);
        if (!bigIntegerModPow.pow(2).subtract(bigIntegerMultiply).mod(bigInteger3).equals(BigInteger.ZERO)) {
            bigIntegerModPow = bigIntegerModPow.multiply(f24233i).mod(bigInteger3);
        }
        return bigIntegerModPow.testBit(0) ? bigInteger3.subtract(bigIntegerModPow) : bigIntegerModPow;
    }

    public static byte[] d(BigInteger bigInteger) {
        byte[] bArr = new byte[32];
        byte[] byteArray = bigInteger.toByteArray();
        System.arraycopy(byteArray, 0, bArr, 32 - byteArray.length, byteArray.length);
        for (int i10 = 0; i10 < 16; i10++) {
            byte b10 = bArr[i10];
            int i11 = 31 - i10;
            bArr[i10] = bArr[i11];
            bArr[i11] = b10;
        }
        return bArr;
    }
}
