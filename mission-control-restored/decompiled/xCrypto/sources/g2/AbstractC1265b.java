package g2;

import g2.AbstractC1264a;
import java.lang.reflect.Array;
import java.math.BigInteger;

/* JADX INFO: renamed from: g2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1265b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long[] f11935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long[] f11936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long[] f11937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AbstractC1264a.C0196a[][] f11938d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AbstractC1264a.C0196a[] f11939e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final BigInteger f11940f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final BigInteger f11941g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final BigInteger f11942h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final BigInteger f11943i;

    /* JADX INFO: renamed from: g2.b$b, reason: collision with other inner class name */
    public static class C0197b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BigInteger f11944a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public BigInteger f11945b;

        public C0197b() {
        }
    }

    static {
        BigInteger bigIntegerSubtract = BigInteger.valueOf(2L).pow(255).subtract(BigInteger.valueOf(19L));
        f11940f = bigIntegerSubtract;
        BigInteger bigIntegerMod = BigInteger.valueOf(-121665L).multiply(BigInteger.valueOf(121666L).modInverse(bigIntegerSubtract)).mod(bigIntegerSubtract);
        f11941g = bigIntegerMod;
        BigInteger bigIntegerMod2 = BigInteger.valueOf(2L).multiply(bigIntegerMod).mod(bigIntegerSubtract);
        f11942h = bigIntegerMod2;
        BigInteger bigIntegerModPow = BigInteger.valueOf(2L).modPow(bigIntegerSubtract.subtract(BigInteger.ONE).divide(BigInteger.valueOf(4L)), bigIntegerSubtract);
        f11943i = bigIntegerModPow;
        C0197b c0197b = new C0197b();
        c0197b.f11945b = BigInteger.valueOf(4L).multiply(BigInteger.valueOf(5L).modInverse(bigIntegerSubtract)).mod(bigIntegerSubtract);
        c0197b.f11944a = c(c0197b.f11945b);
        f11935a = f.c(d(bigIntegerMod));
        f11936b = f.c(d(bigIntegerMod2));
        f11937c = f.c(d(bigIntegerModPow));
        f11938d = (AbstractC1264a.C0196a[][]) Array.newInstance((Class<?>) AbstractC1264a.C0196a.class, 32, 8);
        C0197b c0197bA = c0197b;
        for (int i4 = 0; i4 < 32; i4++) {
            C0197b c0197bA2 = c0197bA;
            for (int i5 = 0; i5 < 8; i5++) {
                f11938d[i4][i5] = b(c0197bA2);
                c0197bA2 = a(c0197bA2, c0197bA);
            }
            for (int i6 = 0; i6 < 8; i6++) {
                c0197bA = a(c0197bA, c0197bA);
            }
        }
        C0197b c0197bA3 = a(c0197b, c0197b);
        f11939e = new AbstractC1264a.C0196a[8];
        for (int i7 = 0; i7 < 8; i7++) {
            f11939e[i7] = b(c0197b);
            c0197b = a(c0197b, c0197bA3);
        }
    }

    public static C0197b a(C0197b c0197b, C0197b c0197b2) {
        C0197b c0197b3 = new C0197b();
        BigInteger bigIntegerMultiply = f11941g.multiply(c0197b.f11944a.multiply(c0197b2.f11944a).multiply(c0197b.f11945b).multiply(c0197b2.f11945b));
        BigInteger bigInteger = f11940f;
        BigInteger bigIntegerMod = bigIntegerMultiply.mod(bigInteger);
        BigInteger bigIntegerAdd = c0197b.f11944a.multiply(c0197b2.f11945b).add(c0197b2.f11944a.multiply(c0197b.f11945b));
        BigInteger bigInteger2 = BigInteger.ONE;
        c0197b3.f11944a = bigIntegerAdd.multiply(bigInteger2.add(bigIntegerMod).modInverse(bigInteger)).mod(bigInteger);
        c0197b3.f11945b = c0197b.f11945b.multiply(c0197b2.f11945b).add(c0197b.f11944a.multiply(c0197b2.f11944a)).multiply(bigInteger2.subtract(bigIntegerMod).modInverse(bigInteger)).mod(bigInteger);
        return c0197b3;
    }

    public static AbstractC1264a.C0196a b(C0197b c0197b) {
        BigInteger bigIntegerAdd = c0197b.f11945b.add(c0197b.f11944a);
        BigInteger bigInteger = f11940f;
        return new AbstractC1264a.C0196a(f.c(d(bigIntegerAdd.mod(bigInteger))), f.c(d(c0197b.f11945b.subtract(c0197b.f11944a).mod(bigInteger))), f.c(d(f11942h.multiply(c0197b.f11944a).multiply(c0197b.f11945b).mod(bigInteger))));
    }

    public static BigInteger c(BigInteger bigInteger) {
        BigInteger bigIntegerPow = bigInteger.pow(2);
        BigInteger bigInteger2 = BigInteger.ONE;
        BigInteger bigIntegerSubtract = bigIntegerPow.subtract(bigInteger2);
        BigInteger bigIntegerAdd = f11941g.multiply(bigInteger.pow(2)).add(bigInteger2);
        BigInteger bigInteger3 = f11940f;
        BigInteger bigIntegerMultiply = bigIntegerSubtract.multiply(bigIntegerAdd.modInverse(bigInteger3));
        BigInteger bigIntegerModPow = bigIntegerMultiply.modPow(bigInteger3.add(BigInteger.valueOf(3L)).divide(BigInteger.valueOf(8L)), bigInteger3);
        if (!bigIntegerModPow.pow(2).subtract(bigIntegerMultiply).mod(bigInteger3).equals(BigInteger.ZERO)) {
            bigIntegerModPow = bigIntegerModPow.multiply(f11943i).mod(bigInteger3);
        }
        return bigIntegerModPow.testBit(0) ? bigInteger3.subtract(bigIntegerModPow) : bigIntegerModPow;
    }

    public static byte[] d(BigInteger bigInteger) {
        byte[] bArr = new byte[32];
        byte[] byteArray = bigInteger.toByteArray();
        System.arraycopy(byteArray, 0, bArr, 32 - byteArray.length, byteArray.length);
        for (int i4 = 0; i4 < 16; i4++) {
            byte b4 = bArr[i4];
            int i5 = 31 - i4;
            bArr[i4] = bArr[i5];
            bArr[i5] = b4;
        }
        return bArr;
    }
}
