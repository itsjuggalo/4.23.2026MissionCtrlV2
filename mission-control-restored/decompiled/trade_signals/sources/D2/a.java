package D2;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0013a f739a = new C0013a(new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f740b = new c(new d(new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}), new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0});

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f741c = {-19, -45, -11, 92, 26, 99, 18, 88, -42, -100, -9, -94, -34, -7, -34, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16};

    /* JADX INFO: renamed from: D2.a$a, reason: collision with other inner class name */
    public static class C0013a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f742a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f743b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long[] f744c;

        public C0013a(long[] jArr, long[] jArr2, long[] jArr3) {
            this.f742a = jArr;
            this.f743b = jArr2;
            this.f744c = jArr3;
        }

        public void a(long[] jArr, long[] jArr2) {
            System.arraycopy(jArr2, 0, jArr, 0, 10);
        }
    }

    public static class b extends C0013a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long[] f745d;

        public b() {
            this(new long[10], new long[10], new long[10], new long[10]);
        }

        @Override // D2.a.C0013a
        public void a(long[] jArr, long[] jArr2) {
            f.f(jArr, jArr2, this.f745d);
        }

        public b(e eVar) {
            this();
            long[] jArr = this.f742a;
            d dVar = eVar.f751a;
            f.n(jArr, dVar.f749b, dVar.f748a);
            long[] jArr2 = this.f743b;
            d dVar2 = eVar.f751a;
            f.m(jArr2, dVar2.f749b, dVar2.f748a);
            System.arraycopy(eVar.f751a.f750c, 0, this.f745d, 0, 10);
            f.f(this.f744c, eVar.f752b, D2.b.f754b);
        }

        public b(long[] jArr, long[] jArr2, long[] jArr3, long[] jArr4) {
            super(jArr, jArr2, jArr4);
            this.f745d = jArr3;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f746a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f747b;

        public c() {
            this(new d(), new long[10]);
        }

        public c(c cVar) {
            this.f746a = new d(cVar.f746a);
            this.f747b = Arrays.copyOf(cVar.f747b, 10);
        }

        public c(d dVar, long[] jArr) {
            this.f746a = dVar;
            this.f747b = jArr;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f749b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long[] f750c;

        public d() {
            this(new long[10], new long[10], new long[10]);
        }

        public static d a(d dVar, c cVar) {
            f.f(dVar.f748a, cVar.f746a.f748a, cVar.f747b);
            long[] jArr = dVar.f749b;
            d dVar2 = cVar.f746a;
            f.f(jArr, dVar2.f749b, dVar2.f750c);
            f.f(dVar.f750c, cVar.f746a.f750c, cVar.f747b);
            return dVar;
        }

        public byte[] b() {
            long[] jArr = new long[10];
            long[] jArr2 = new long[10];
            long[] jArr3 = new long[10];
            f.e(jArr, this.f750c);
            f.f(jArr2, this.f748a, jArr);
            f.f(jArr3, this.f749b, jArr);
            byte[] bArrA = f.a(jArr3);
            bArrA[31] = (byte) ((a.i(jArr2) << 7) ^ bArrA[31]);
            return bArrA;
        }

        public d(c cVar) {
            this();
            a(this, cVar);
        }

        public d(d dVar) {
            this.f748a = Arrays.copyOf(dVar.f748a, 10);
            this.f749b = Arrays.copyOf(dVar.f749b, 10);
            this.f750c = Arrays.copyOf(dVar.f750c, 10);
        }

        public d(long[] jArr, long[] jArr2, long[] jArr3) {
            this.f748a = jArr;
            this.f749b = jArr2;
            this.f750c = jArr3;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f751a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f752b;

        public e() {
            this(new d(), new long[10]);
        }

        public static e c(byte[] bArr) throws GeneralSecurityException {
            long[] jArr = new long[10];
            long[] jArrC = f.c(bArr);
            long[] jArr2 = new long[10];
            jArr2[0] = 1;
            long[] jArr3 = new long[10];
            long[] jArr4 = new long[10];
            long[] jArr5 = new long[10];
            long[] jArr6 = new long[10];
            long[] jArr7 = new long[10];
            f.k(jArr4, jArrC);
            f.f(jArr5, jArr4, D2.b.f753a);
            f.m(jArr4, jArr4, jArr2);
            f.n(jArr5, jArr5, jArr2);
            long[] jArr8 = new long[10];
            f.k(jArr8, jArr5);
            f.f(jArr8, jArr8, jArr5);
            f.k(jArr, jArr8);
            f.f(jArr, jArr, jArr5);
            f.f(jArr, jArr, jArr4);
            a.o(jArr, jArr);
            f.f(jArr, jArr, jArr8);
            f.f(jArr, jArr, jArr4);
            f.k(jArr6, jArr);
            f.f(jArr6, jArr6, jArr5);
            f.m(jArr7, jArr6, jArr4);
            if (a.j(jArr7)) {
                f.n(jArr7, jArr6, jArr4);
                if (a.j(jArr7)) {
                    throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. No square root exists for modulo 2^255-19");
                }
                f.f(jArr, jArr, D2.b.f755c);
            }
            if (!a.j(jArr) && ((bArr[31] & 255) >> 7) != 0) {
                throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. Computed x is zero and encoded x's least significant bit is not zero");
            }
            if (a.i(jArr) == ((bArr[31] & 255) >> 7)) {
                a.n(jArr, jArr);
            }
            f.f(jArr3, jArr, jArrC);
            return new e(new d(jArr, jArrC, jArr2), jArr3);
        }

        public static e d(e eVar, c cVar) {
            f.f(eVar.f751a.f748a, cVar.f746a.f748a, cVar.f747b);
            long[] jArr = eVar.f751a.f749b;
            d dVar = cVar.f746a;
            f.f(jArr, dVar.f749b, dVar.f750c);
            f.f(eVar.f751a.f750c, cVar.f746a.f750c, cVar.f747b);
            long[] jArr2 = eVar.f752b;
            d dVar2 = cVar.f746a;
            f.f(jArr2, dVar2.f748a, dVar2.f749b);
            return eVar;
        }

        public e(c cVar) {
            this();
            d(this, cVar);
        }

        public e(d dVar, long[] jArr) {
            this.f751a = dVar;
            this.f752b = jArr;
        }
    }

    public static void e(c cVar, e eVar, C0013a c0013a) {
        long[] jArr = new long[10];
        long[] jArr2 = cVar.f746a.f748a;
        d dVar = eVar.f751a;
        f.n(jArr2, dVar.f749b, dVar.f748a);
        long[] jArr3 = cVar.f746a.f749b;
        d dVar2 = eVar.f751a;
        f.m(jArr3, dVar2.f749b, dVar2.f748a);
        long[] jArr4 = cVar.f746a.f749b;
        f.f(jArr4, jArr4, c0013a.f743b);
        d dVar3 = cVar.f746a;
        f.f(dVar3.f750c, dVar3.f748a, c0013a.f742a);
        f.f(cVar.f747b, eVar.f752b, c0013a.f744c);
        c0013a.a(cVar.f746a.f748a, eVar.f751a.f750c);
        long[] jArr5 = cVar.f746a.f748a;
        f.n(jArr, jArr5, jArr5);
        d dVar4 = cVar.f746a;
        f.m(dVar4.f748a, dVar4.f750c, dVar4.f749b);
        d dVar5 = cVar.f746a;
        long[] jArr6 = dVar5.f749b;
        f.n(jArr6, dVar5.f750c, jArr6);
        f.n(cVar.f746a.f750c, jArr, cVar.f747b);
        long[] jArr7 = cVar.f747b;
        f.m(jArr7, jArr, jArr7);
    }

    public static d f(byte[] bArr, e eVar, byte[] bArr2) {
        b[] bVarArr = new b[8];
        bVarArr[0] = new b(eVar);
        c cVar = new c();
        h(cVar, eVar);
        e eVar2 = new e(cVar);
        for (int i8 = 1; i8 < 8; i8++) {
            e(cVar, eVar2, bVarArr[i8 - 1]);
            bVarArr[i8] = new b(new e(cVar));
        }
        byte[] bArrQ = q(bArr);
        byte[] bArrQ2 = q(bArr2);
        c cVar2 = new c(f740b);
        e eVar3 = new e();
        int i9 = 255;
        while (i9 >= 0 && bArrQ[i9] == 0 && bArrQ2[i9] == 0) {
            i9--;
        }
        while (i9 >= 0) {
            g(cVar2, new d(cVar2));
            byte b8 = bArrQ[i9];
            if (b8 > 0) {
                e(cVar2, e.d(eVar3, cVar2), bVarArr[bArrQ[i9] / 2]);
            } else if (b8 < 0) {
                r(cVar2, e.d(eVar3, cVar2), bVarArr[(-bArrQ[i9]) / 2]);
            }
            byte b9 = bArrQ2[i9];
            if (b9 > 0) {
                e(cVar2, e.d(eVar3, cVar2), D2.b.f757e[bArrQ2[i9] / 2]);
            } else if (b9 < 0) {
                r(cVar2, e.d(eVar3, cVar2), D2.b.f757e[(-bArrQ2[i9]) / 2]);
            }
            i9--;
        }
        return new d(cVar2);
    }

    public static void g(c cVar, d dVar) {
        long[] jArr = new long[10];
        f.k(cVar.f746a.f748a, dVar.f748a);
        f.k(cVar.f746a.f750c, dVar.f749b);
        f.k(cVar.f747b, dVar.f750c);
        long[] jArr2 = cVar.f747b;
        f.n(jArr2, jArr2, jArr2);
        f.n(cVar.f746a.f749b, dVar.f748a, dVar.f749b);
        f.k(jArr, cVar.f746a.f749b);
        d dVar2 = cVar.f746a;
        f.n(dVar2.f749b, dVar2.f750c, dVar2.f748a);
        d dVar3 = cVar.f746a;
        long[] jArr3 = dVar3.f750c;
        f.m(jArr3, jArr3, dVar3.f748a);
        d dVar4 = cVar.f746a;
        f.m(dVar4.f748a, jArr, dVar4.f749b);
        long[] jArr4 = cVar.f747b;
        f.m(jArr4, jArr4, cVar.f746a.f750c);
    }

    public static void h(c cVar, e eVar) {
        g(cVar, eVar.f751a);
    }

    public static int i(long[] jArr) {
        return f.a(jArr)[0] & 1;
    }

    public static boolean j(long[] jArr) {
        long[] jArr2 = new long[jArr.length + 1];
        System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
        f.i(jArr2);
        for (byte b8 : f.a(jArr2)) {
            if (b8 != 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean k(byte[] bArr) {
        for (int i8 = 31; i8 >= 0; i8--) {
            int i9 = bArr[i8] & 255;
            int i10 = f741c[i8] & 255;
            if (i9 != i10) {
                return i9 < i10;
            }
        }
        return false;
    }

    public static long l(byte[] bArr, int i8) {
        return (((long) (bArr[i8 + 2] & 255)) << 16) | (((long) bArr[i8]) & 255) | (((long) (bArr[i8 + 1] & 255)) << 8);
    }

    public static long m(byte[] bArr, int i8) {
        return (((long) (bArr[i8 + 3] & 255)) << 24) | l(bArr, i8);
    }

    public static void n(long[] jArr, long[] jArr2) {
        for (int i8 = 0; i8 < jArr2.length; i8++) {
            jArr[i8] = -jArr2[i8];
        }
    }

    public static void o(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[10];
        long[] jArr4 = new long[10];
        long[] jArr5 = new long[10];
        f.k(jArr3, jArr2);
        f.k(jArr4, jArr3);
        f.k(jArr4, jArr4);
        f.f(jArr4, jArr2, jArr4);
        f.f(jArr3, jArr3, jArr4);
        f.k(jArr3, jArr3);
        f.f(jArr3, jArr4, jArr3);
        f.k(jArr4, jArr3);
        for (int i8 = 1; i8 < 5; i8++) {
            f.k(jArr4, jArr4);
        }
        f.f(jArr3, jArr4, jArr3);
        f.k(jArr4, jArr3);
        for (int i9 = 1; i9 < 10; i9++) {
            f.k(jArr4, jArr4);
        }
        f.f(jArr4, jArr4, jArr3);
        f.k(jArr5, jArr4);
        for (int i10 = 1; i10 < 20; i10++) {
            f.k(jArr5, jArr5);
        }
        f.f(jArr4, jArr5, jArr4);
        f.k(jArr4, jArr4);
        for (int i11 = 1; i11 < 10; i11++) {
            f.k(jArr4, jArr4);
        }
        f.f(jArr3, jArr4, jArr3);
        f.k(jArr4, jArr3);
        for (int i12 = 1; i12 < 50; i12++) {
            f.k(jArr4, jArr4);
        }
        f.f(jArr4, jArr4, jArr3);
        f.k(jArr5, jArr4);
        for (int i13 = 1; i13 < 100; i13++) {
            f.k(jArr5, jArr5);
        }
        f.f(jArr4, jArr5, jArr4);
        f.k(jArr4, jArr4);
        for (int i14 = 1; i14 < 50; i14++) {
            f.k(jArr4, jArr4);
        }
        f.f(jArr3, jArr4, jArr3);
        f.k(jArr3, jArr3);
        f.k(jArr3, jArr3);
        f.f(jArr, jArr3, jArr2);
    }

    public static void p(byte[] bArr) {
        long jL = l(bArr, 0) & 2097151;
        long jM = (m(bArr, 2) >> 5) & 2097151;
        long jL2 = (l(bArr, 5) >> 2) & 2097151;
        long jM2 = (m(bArr, 7) >> 7) & 2097151;
        long jM3 = (m(bArr, 10) >> 4) & 2097151;
        long jL3 = (l(bArr, 13) >> 1) & 2097151;
        long jM4 = (m(bArr, 15) >> 6) & 2097151;
        long jL4 = (l(bArr, 18) >> 3) & 2097151;
        long jL5 = l(bArr, 21) & 2097151;
        long jM5 = (m(bArr, 23) >> 5) & 2097151;
        long jL6 = (l(bArr, 26) >> 2) & 2097151;
        long jM6 = (m(bArr, 28) >> 7) & 2097151;
        long jM7 = (m(bArr, 31) >> 4) & 2097151;
        long jL7 = (l(bArr, 34) >> 1) & 2097151;
        long jM8 = (m(bArr, 36) >> 6) & 2097151;
        long jL8 = (l(bArr, 39) >> 3) & 2097151;
        long jL9 = l(bArr, 42) & 2097151;
        long jM9 = (m(bArr, 44) >> 5) & 2097151;
        long jL10 = (l(bArr, 47) >> 2) & 2097151;
        long jM10 = (m(bArr, 49) >> 7) & 2097151;
        long jM11 = (m(bArr, 52) >> 4) & 2097151;
        long jL11 = (l(bArr, 55) >> 1) & 2097151;
        long jM12 = (m(bArr, 57) >> 6) & 2097151;
        long jM13 = m(bArr, 60) >> 3;
        long j8 = jL9 - (jM13 * 683901);
        long j9 = ((jM8 - (jM13 * 997805)) + (jM12 * 136657)) - (jL11 * 683901);
        long j10 = ((((jM7 + (jM13 * 470296)) + (jM12 * 654183)) - (jL11 * 997805)) + (jM11 * 136657)) - (jM10 * 683901);
        long j11 = jM4 + (jL10 * 666643);
        long j12 = jL4 + (jM10 * 666643) + (jL10 * 470296);
        long j13 = jL5 + (jM11 * 666643) + (jM10 * 470296) + (jL10 * 654183);
        long j14 = (((jM5 + (jL11 * 666643)) + (jM11 * 470296)) + (jM10 * 654183)) - (jL10 * 997805);
        long j15 = ((((jL6 + (jM12 * 666643)) + (jL11 * 470296)) + (jM11 * 654183)) - (jM10 * 997805)) + (jL10 * 136657);
        long j16 = (((((jM6 + (jM13 * 666643)) + (jM12 * 470296)) + (jL11 * 654183)) - (jM11 * 997805)) + (jM10 * 136657)) - (jL10 * 683901);
        long j17 = (j11 + 1048576) >> 21;
        long j18 = j12 + j17;
        long j19 = j11 - (j17 << 21);
        long j20 = (j13 + 1048576) >> 21;
        long j21 = j14 + j20;
        long j22 = j13 - (j20 << 21);
        long j23 = (j15 + 1048576) >> 21;
        long j24 = j16 + j23;
        long j25 = j15 - (j23 << 21);
        long j26 = (j10 + 1048576) >> 21;
        long j27 = ((((jL7 + (jM13 * 654183)) - (jM12 * 997805)) + (jL11 * 136657)) - (jM11 * 683901)) + j26;
        long j28 = j10 - (j26 << 21);
        long j29 = (j9 + 1048576) >> 21;
        long j30 = ((jL8 + (jM13 * 136657)) - (jM12 * 683901)) + j29;
        long j31 = j9 - (j29 << 21);
        long j32 = (j8 + 1048576) >> 21;
        long j33 = jM9 + j32;
        long j34 = j8 - (j32 << 21);
        long j35 = (j18 + 1048576) >> 21;
        long j36 = j22 + j35;
        long j37 = j18 - (j35 << 21);
        long j38 = (j21 + 1048576) >> 21;
        long j39 = j25 + j38;
        long j40 = j21 - (j38 << 21);
        long j41 = (j24 + 1048576) >> 21;
        long j42 = j28 + j41;
        long j43 = j24 - (j41 << 21);
        long j44 = (j27 + 1048576) >> 21;
        long j45 = j31 + j44;
        long j46 = j27 - (j44 << 21);
        long j47 = (j30 + 1048576) >> 21;
        long j48 = j34 + j47;
        long j49 = j30 - (j47 << 21);
        long j50 = j39 - (j33 * 683901);
        long j51 = ((j36 - (j33 * 997805)) + (j48 * 136657)) - (j49 * 683901);
        long j52 = ((((j19 + (j33 * 470296)) + (j48 * 654183)) - (j49 * 997805)) + (j45 * 136657)) - (j46 * 683901);
        long j53 = jL + (j42 * 666643);
        long j54 = jM + (j46 * 666643) + (j42 * 470296);
        long j55 = jL2 + (j45 * 666643) + (j46 * 470296) + (j42 * 654183);
        long j56 = (((jM2 + (j49 * 666643)) + (j45 * 470296)) + (j46 * 654183)) - (j42 * 997805);
        long j57 = ((((jM3 + (j48 * 666643)) + (j49 * 470296)) + (j45 * 654183)) - (j46 * 997805)) + (j42 * 136657);
        long j58 = (((((jL3 + (j33 * 666643)) + (j48 * 470296)) + (j49 * 654183)) - (j45 * 997805)) + (j46 * 136657)) - (j42 * 683901);
        long j59 = (j53 + 1048576) >> 21;
        long j60 = j54 + j59;
        long j61 = j53 - (j59 << 21);
        long j62 = (j55 + 1048576) >> 21;
        long j63 = j56 + j62;
        long j64 = j55 - (j62 << 21);
        long j65 = (j57 + 1048576) >> 21;
        long j66 = j58 + j65;
        long j67 = j57 - (j65 << 21);
        long j68 = (j52 + 1048576) >> 21;
        long j69 = ((((j37 + (j33 * 654183)) - (j48 * 997805)) + (j49 * 136657)) - (j45 * 683901)) + j68;
        long j70 = j52 - (j68 << 21);
        long j71 = (j51 + 1048576) >> 21;
        long j72 = ((j40 + (j33 * 136657)) - (j48 * 683901)) + j71;
        long j73 = j51 - (j71 << 21);
        long j74 = (j50 + 1048576) >> 21;
        long j75 = j43 + j74;
        long j76 = j50 - (j74 << 21);
        long j77 = (j60 + 1048576) >> 21;
        long j78 = j64 + j77;
        long j79 = j60 - (j77 << 21);
        long j80 = (j63 + 1048576) >> 21;
        long j81 = j67 + j80;
        long j82 = j63 - (j80 << 21);
        long j83 = (j66 + 1048576) >> 21;
        long j84 = j70 + j83;
        long j85 = j66 - (j83 << 21);
        long j86 = (j69 + 1048576) >> 21;
        long j87 = j73 + j86;
        long j88 = j69 - (j86 << 21);
        long j89 = (j72 + 1048576) >> 21;
        long j90 = j76 + j89;
        long j91 = j72 - (j89 << 21);
        long j92 = (j75 + 1048576) >> 21;
        long j93 = j61 + (j92 * 666643);
        long j94 = j93 >> 21;
        long j95 = j79 + (j92 * 470296) + j94;
        long j96 = j93 - (j94 << 21);
        long j97 = j95 >> 21;
        long j98 = j78 + (j92 * 654183) + j97;
        long j99 = j95 - (j97 << 21);
        long j100 = j98 >> 21;
        long j101 = (j82 - (j92 * 997805)) + j100;
        long j102 = j98 - (j100 << 21);
        long j103 = j101 >> 21;
        long j104 = j81 + (j92 * 136657) + j103;
        long j105 = j101 - (j103 << 21);
        long j106 = j104 >> 21;
        long j107 = (j85 - (j92 * 683901)) + j106;
        long j108 = j104 - (j106 << 21);
        long j109 = j107 >> 21;
        long j110 = j84 + j109;
        long j111 = j107 - (j109 << 21);
        long j112 = j110 >> 21;
        long j113 = j88 + j112;
        long j114 = j110 - (j112 << 21);
        long j115 = j113 >> 21;
        long j116 = j87 + j115;
        long j117 = j113 - (j115 << 21);
        long j118 = j116 >> 21;
        long j119 = j91 + j118;
        long j120 = j116 - (j118 << 21);
        long j121 = j119 >> 21;
        long j122 = j90 + j121;
        long j123 = j119 - (j121 << 21);
        long j124 = j122 >> 21;
        long j125 = (j75 - (j92 << 21)) + j124;
        long j126 = j122 - (j124 << 21);
        long j127 = j125 >> 21;
        long j128 = j125 - (j127 << 21);
        long j129 = j96 + (666643 * j127);
        long j130 = j99 + (470296 * j127);
        long j131 = j102 + (654183 * j127);
        long j132 = j105 - (997805 * j127);
        long j133 = j108 + (136657 * j127);
        long j134 = j111 - (j127 * 683901);
        long j135 = j129 >> 21;
        long j136 = j130 + j135;
        long j137 = j129 - (j135 << 21);
        long j138 = j136 >> 21;
        long j139 = j131 + j138;
        long j140 = j136 - (j138 << 21);
        long j141 = j139 >> 21;
        long j142 = j132 + j141;
        long j143 = j139 - (j141 << 21);
        long j144 = j142 >> 21;
        long j145 = j133 + j144;
        long j146 = j142 - (j144 << 21);
        long j147 = j145 >> 21;
        long j148 = j134 + j147;
        long j149 = j145 - (j147 << 21);
        long j150 = j148 >> 21;
        long j151 = j114 + j150;
        long j152 = j148 - (j150 << 21);
        long j153 = j151 >> 21;
        long j154 = j117 + j153;
        long j155 = j151 - (j153 << 21);
        long j156 = j154 >> 21;
        long j157 = j120 + j156;
        long j158 = j154 - (j156 << 21);
        long j159 = j157 >> 21;
        long j160 = j123 + j159;
        long j161 = j160 >> 21;
        long j162 = j126 + j161;
        long j163 = j160 - (j161 << 21);
        long j164 = j162 >> 21;
        long j165 = j128 + j164;
        long j166 = j162 - (j164 << 21);
        bArr[0] = (byte) j137;
        bArr[1] = (byte) (j137 >> 8);
        bArr[2] = (byte) ((j137 >> 16) | (j140 << 5));
        bArr[3] = (byte) (j140 >> 3);
        bArr[4] = (byte) (j140 >> 11);
        bArr[5] = (byte) ((j140 >> 19) | (j143 << 2));
        bArr[6] = (byte) (j143 >> 6);
        bArr[7] = (byte) ((j143 >> 14) | (j146 << 7));
        bArr[8] = (byte) (j146 >> 1);
        bArr[9] = (byte) (j146 >> 9);
        bArr[10] = (byte) ((j146 >> 17) | (j149 << 4));
        bArr[11] = (byte) (j149 >> 4);
        bArr[12] = (byte) (j149 >> 12);
        bArr[13] = (byte) ((j149 >> 20) | (j152 << 1));
        bArr[14] = (byte) (j152 >> 7);
        bArr[15] = (byte) ((j152 >> 15) | (j155 << 6));
        bArr[16] = (byte) (j155 >> 2);
        bArr[17] = (byte) (j155 >> 10);
        bArr[18] = (byte) ((j155 >> 18) | (j158 << 3));
        bArr[19] = (byte) (j158 >> 5);
        bArr[20] = (byte) (j158 >> 13);
        bArr[21] = (byte) (j157 - (j159 << 21));
        bArr[22] = (byte) (r11 >> 8);
        bArr[23] = (byte) ((r11 >> 16) | (j163 << 5));
        bArr[24] = (byte) (j163 >> 3);
        bArr[25] = (byte) (j163 >> 11);
        bArr[26] = (byte) ((j163 >> 19) | (j166 << 2));
        bArr[27] = (byte) (j166 >> 6);
        bArr[28] = (byte) ((j166 >> 14) | (j165 << 7));
        bArr[29] = (byte) (j165 >> 1);
        bArr[30] = (byte) (j165 >> 9);
        bArr[31] = (byte) (j165 >> 17);
    }

    public static byte[] q(byte[] bArr) {
        int i8;
        byte[] bArr2 = new byte[256];
        for (int i9 = 0; i9 < 256; i9++) {
            bArr2[i9] = (byte) (1 & ((bArr[i9 >> 3] & 255) >> (i9 & 7)));
        }
        for (int i10 = 0; i10 < 256; i10++) {
            if (bArr2[i10] != 0) {
                for (int i11 = 1; i11 <= 6 && (i8 = i10 + i11) < 256; i11++) {
                    byte b8 = bArr2[i8];
                    if (b8 != 0) {
                        byte b9 = bArr2[i10];
                        if ((b8 << i11) + b9 <= 15) {
                            bArr2[i10] = (byte) (b9 + (b8 << i11));
                            bArr2[i8] = 0;
                        } else if (b9 - (b8 << i11) >= -15) {
                            bArr2[i10] = (byte) (b9 - (b8 << i11));
                            while (true) {
                                if (i8 >= 256) {
                                    break;
                                }
                                if (bArr2[i8] == 0) {
                                    bArr2[i8] = 1;
                                    break;
                                }
                                bArr2[i8] = 0;
                                i8++;
                            }
                        }
                    }
                }
            }
        }
        return bArr2;
    }

    public static void r(c cVar, e eVar, C0013a c0013a) {
        long[] jArr = new long[10];
        long[] jArr2 = cVar.f746a.f748a;
        d dVar = eVar.f751a;
        f.n(jArr2, dVar.f749b, dVar.f748a);
        long[] jArr3 = cVar.f746a.f749b;
        d dVar2 = eVar.f751a;
        f.m(jArr3, dVar2.f749b, dVar2.f748a);
        long[] jArr4 = cVar.f746a.f749b;
        f.f(jArr4, jArr4, c0013a.f742a);
        d dVar3 = cVar.f746a;
        f.f(dVar3.f750c, dVar3.f748a, c0013a.f743b);
        f.f(cVar.f747b, eVar.f752b, c0013a.f744c);
        c0013a.a(cVar.f746a.f748a, eVar.f751a.f750c);
        long[] jArr5 = cVar.f746a.f748a;
        f.n(jArr, jArr5, jArr5);
        d dVar4 = cVar.f746a;
        f.m(dVar4.f748a, dVar4.f750c, dVar4.f749b);
        d dVar5 = cVar.f746a;
        long[] jArr6 = dVar5.f749b;
        f.n(jArr6, dVar5.f750c, jArr6);
        f.m(cVar.f746a.f750c, jArr, cVar.f747b);
        long[] jArr7 = cVar.f747b;
        f.n(jArr7, jArr, jArr7);
    }

    public static boolean s(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr2.length != 64) {
            return false;
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr2, 32, 64);
        if (!k(bArrCopyOfRange)) {
            return false;
        }
        MessageDigest messageDigest = (MessageDigest) D2.d.f769e.a("SHA-512");
        messageDigest.update(bArr2, 0, 32);
        messageDigest.update(bArr3);
        messageDigest.update(bArr);
        byte[] bArrDigest = messageDigest.digest();
        p(bArrDigest);
        byte[] bArrB = f(bArrDigest, e.c(bArr3), bArrCopyOfRange).b();
        for (int i8 = 0; i8 < 32; i8++) {
            if (bArrB[i8] != bArr2[i8]) {
                return false;
            }
        }
        return true;
    }
}
