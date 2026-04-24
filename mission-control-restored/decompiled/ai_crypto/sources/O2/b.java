package O2;

import O2.a;
import java.lang.reflect.Array;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long[] f4126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long[] f4127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long[] f4128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a.C0062a[][] f4129d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a.C0062a[] f4130e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final BigInteger f4131f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final BigInteger f4132g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final BigInteger f4133h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final BigInteger f4134i;

    /* JADX INFO: renamed from: O2.b$b, reason: collision with other inner class name */
    public static class C0063b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BigInteger f4135a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public BigInteger f4136b;

        public C0063b() {
        }
    }

    static {
        BigInteger bigIntegerSubtract = BigInteger.valueOf(2L).pow(255).subtract(BigInteger.valueOf(19L));
        f4131f = bigIntegerSubtract;
        BigInteger bigIntegerMod = BigInteger.valueOf(-121665L).multiply(BigInteger.valueOf(121666L).modInverse(bigIntegerSubtract)).mod(bigIntegerSubtract);
        f4132g = bigIntegerMod;
        BigInteger bigIntegerMod2 = BigInteger.valueOf(2L).multiply(bigIntegerMod).mod(bigIntegerSubtract);
        f4133h = bigIntegerMod2;
        BigInteger bigIntegerModPow = BigInteger.valueOf(2L).modPow(bigIntegerSubtract.subtract(BigInteger.ONE).divide(BigInteger.valueOf(4L)), bigIntegerSubtract);
        f4134i = bigIntegerModPow;
        C0063b c0063b = new C0063b();
        c0063b.f4136b = BigInteger.valueOf(4L).multiply(BigInteger.valueOf(5L).modInverse(bigIntegerSubtract)).mod(bigIntegerSubtract);
        c0063b.f4135a = c(c0063b.f4136b);
        f4126a = f.c(d(bigIntegerMod));
        f4127b = f.c(d(bigIntegerMod2));
        f4128c = f.c(d(bigIntegerModPow));
        f4129d = (a.C0062a[][]) Array.newInstance((Class<?>) a.C0062a.class, 32, 8);
        C0063b c0063bA = c0063b;
        for (int i7 = 0; i7 < 32; i7++) {
            C0063b c0063bA2 = c0063bA;
            for (int i8 = 0; i8 < 8; i8++) {
                f4129d[i7][i8] = b(c0063bA2);
                c0063bA2 = a(c0063bA2, c0063bA);
            }
            for (int i9 = 0; i9 < 8; i9++) {
                c0063bA = a(c0063bA, c0063bA);
            }
        }
        C0063b c0063bA3 = a(c0063b, c0063b);
        f4130e = new a.C0062a[8];
        for (int i10 = 0; i10 < 8; i10++) {
            f4130e[i10] = b(c0063b);
            c0063b = a(c0063b, c0063bA3);
        }
    }

    public static C0063b a(C0063b c0063b, C0063b c0063b2) {
        C0063b c0063b3 = new C0063b();
        BigInteger bigIntegerMultiply = f4132g.multiply(c0063b.f4135a.multiply(c0063b2.f4135a).multiply(c0063b.f4136b).multiply(c0063b2.f4136b));
        BigInteger bigInteger = f4131f;
        BigInteger bigIntegerMod = bigIntegerMultiply.mod(bigInteger);
        BigInteger bigIntegerAdd = c0063b.f4135a.multiply(c0063b2.f4136b).add(c0063b2.f4135a.multiply(c0063b.f4136b));
        BigInteger bigInteger2 = BigInteger.ONE;
        c0063b3.f4135a = bigIntegerAdd.multiply(bigInteger2.add(bigIntegerMod).modInverse(bigInteger)).mod(bigInteger);
        c0063b3.f4136b = c0063b.f4136b.multiply(c0063b2.f4136b).add(c0063b.f4135a.multiply(c0063b2.f4135a)).multiply(bigInteger2.subtract(bigIntegerMod).modInverse(bigInteger)).mod(bigInteger);
        return c0063b3;
    }

    public static a.C0062a b(C0063b c0063b) {
        BigInteger bigIntegerAdd = c0063b.f4136b.add(c0063b.f4135a);
        BigInteger bigInteger = f4131f;
        return new a.C0062a(f.c(d(bigIntegerAdd.mod(bigInteger))), f.c(d(c0063b.f4136b.subtract(c0063b.f4135a).mod(bigInteger))), f.c(d(f4133h.multiply(c0063b.f4135a).multiply(c0063b.f4136b).mod(bigInteger))));
    }

    public static BigInteger c(BigInteger bigInteger) {
        BigInteger bigIntegerPow = bigInteger.pow(2);
        BigInteger bigInteger2 = BigInteger.ONE;
        BigInteger bigIntegerSubtract = bigIntegerPow.subtract(bigInteger2);
        BigInteger bigIntegerAdd = f4132g.multiply(bigInteger.pow(2)).add(bigInteger2);
        BigInteger bigInteger3 = f4131f;
        BigInteger bigIntegerMultiply = bigIntegerSubtract.multiply(bigIntegerAdd.modInverse(bigInteger3));
        BigInteger bigIntegerModPow = bigIntegerMultiply.modPow(bigInteger3.add(BigInteger.valueOf(3L)).divide(BigInteger.valueOf(8L)), bigInteger3);
        if (!bigIntegerModPow.pow(2).subtract(bigIntegerMultiply).mod(bigInteger3).equals(BigInteger.ZERO)) {
            bigIntegerModPow = bigIntegerModPow.multiply(f4134i).mod(bigInteger3);
        }
        return bigIntegerModPow.testBit(0) ? bigInteger3.subtract(bigIntegerModPow) : bigIntegerModPow;
    }

    public static byte[] d(BigInteger bigInteger) {
        byte[] bArr = new byte[32];
        byte[] byteArray = bigInteger.toByteArray();
        System.arraycopy(byteArray, 0, bArr, 32 - byteArray.length, byteArray.length);
        for (int i7 = 0; i7 < 16; i7++) {
            byte b7 = bArr[i7];
            int i8 = 31 - i7;
            bArr[i7] = bArr[i8];
            bArr[i8] = b7;
        }
        return bArr;
    }
}
