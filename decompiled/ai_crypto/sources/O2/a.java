package O2;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0062a f4112a = new C0062a(new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f4113b = new c(new d(new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}), new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0});

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f4114c = {-19, -45, -11, 92, 26, 99, 18, 88, -42, -100, -9, -94, -34, -7, -34, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16};

    /* JADX INFO: renamed from: O2.a$a, reason: collision with other inner class name */
    public static class C0062a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f4115a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f4116b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long[] f4117c;

        public C0062a(long[] jArr, long[] jArr2, long[] jArr3) {
            this.f4115a = jArr;
            this.f4116b = jArr2;
            this.f4117c = jArr3;
        }

        public void a(long[] jArr, long[] jArr2) {
            System.arraycopy(jArr2, 0, jArr, 0, 10);
        }
    }

    public static class b extends C0062a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long[] f4118d;

        public b() {
            this(new long[10], new long[10], new long[10], new long[10]);
        }

        @Override // O2.a.C0062a
        public void a(long[] jArr, long[] jArr2) {
            f.f(jArr, jArr2, this.f4118d);
        }

        public b(e eVar) {
            this();
            long[] jArr = this.f4115a;
            d dVar = eVar.f4124a;
            f.n(jArr, dVar.f4122b, dVar.f4121a);
            long[] jArr2 = this.f4116b;
            d dVar2 = eVar.f4124a;
            f.m(jArr2, dVar2.f4122b, dVar2.f4121a);
            System.arraycopy(eVar.f4124a.f4123c, 0, this.f4118d, 0, 10);
            f.f(this.f4117c, eVar.f4125b, O2.b.f4127b);
        }

        public b(long[] jArr, long[] jArr2, long[] jArr3, long[] jArr4) {
            super(jArr, jArr2, jArr4);
            this.f4118d = jArr3;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f4119a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f4120b;

        public c() {
            this(new d(), new long[10]);
        }

        public c(d dVar, long[] jArr) {
            this.f4119a = dVar;
            this.f4120b = jArr;
        }

        public c(c cVar) {
            this.f4119a = new d(cVar.f4119a);
            this.f4120b = Arrays.copyOf(cVar.f4120b, 10);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f4121a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f4122b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long[] f4123c;

        public d() {
            this(new long[10], new long[10], new long[10]);
        }

        public static d a(d dVar, c cVar) {
            f.f(dVar.f4121a, cVar.f4119a.f4121a, cVar.f4120b);
            long[] jArr = dVar.f4122b;
            d dVar2 = cVar.f4119a;
            f.f(jArr, dVar2.f4122b, dVar2.f4123c);
            f.f(dVar.f4123c, cVar.f4119a.f4123c, cVar.f4120b);
            return dVar;
        }

        public byte[] b() {
            long[] jArr = new long[10];
            long[] jArr2 = new long[10];
            long[] jArr3 = new long[10];
            f.e(jArr, this.f4123c);
            f.f(jArr2, this.f4121a, jArr);
            f.f(jArr3, this.f4122b, jArr);
            byte[] bArrA = f.a(jArr3);
            bArrA[31] = (byte) ((a.i(jArr2) << 7) ^ bArrA[31]);
            return bArrA;
        }

        public d(long[] jArr, long[] jArr2, long[] jArr3) {
            this.f4121a = jArr;
            this.f4122b = jArr2;
            this.f4123c = jArr3;
        }

        public d(d dVar) {
            this.f4121a = Arrays.copyOf(dVar.f4121a, 10);
            this.f4122b = Arrays.copyOf(dVar.f4122b, 10);
            this.f4123c = Arrays.copyOf(dVar.f4123c, 10);
        }

        public d(c cVar) {
            this();
            a(this, cVar);
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f4124a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f4125b;

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
            f.f(jArr5, jArr4, O2.b.f4126a);
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
                f.f(jArr, jArr, O2.b.f4128c);
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
            f.f(eVar.f4124a.f4121a, cVar.f4119a.f4121a, cVar.f4120b);
            long[] jArr = eVar.f4124a.f4122b;
            d dVar = cVar.f4119a;
            f.f(jArr, dVar.f4122b, dVar.f4123c);
            f.f(eVar.f4124a.f4123c, cVar.f4119a.f4123c, cVar.f4120b);
            long[] jArr2 = eVar.f4125b;
            d dVar2 = cVar.f4119a;
            f.f(jArr2, dVar2.f4121a, dVar2.f4122b);
            return eVar;
        }

        public e(d dVar, long[] jArr) {
            this.f4124a = dVar;
            this.f4125b = jArr;
        }

        public e(c cVar) {
            this();
            d(this, cVar);
        }
    }

    public static void e(c cVar, e eVar, C0062a c0062a) {
        long[] jArr = new long[10];
        long[] jArr2 = cVar.f4119a.f4121a;
        d dVar = eVar.f4124a;
        f.n(jArr2, dVar.f4122b, dVar.f4121a);
        long[] jArr3 = cVar.f4119a.f4122b;
        d dVar2 = eVar.f4124a;
        f.m(jArr3, dVar2.f4122b, dVar2.f4121a);
        long[] jArr4 = cVar.f4119a.f4122b;
        f.f(jArr4, jArr4, c0062a.f4116b);
        d dVar3 = cVar.f4119a;
        f.f(dVar3.f4123c, dVar3.f4121a, c0062a.f4115a);
        f.f(cVar.f4120b, eVar.f4125b, c0062a.f4117c);
        c0062a.a(cVar.f4119a.f4121a, eVar.f4124a.f4123c);
        long[] jArr5 = cVar.f4119a.f4121a;
        f.n(jArr, jArr5, jArr5);
        d dVar4 = cVar.f4119a;
        f.m(dVar4.f4121a, dVar4.f4123c, dVar4.f4122b);
        d dVar5 = cVar.f4119a;
        long[] jArr6 = dVar5.f4122b;
        f.n(jArr6, dVar5.f4123c, jArr6);
        f.n(cVar.f4119a.f4123c, jArr, cVar.f4120b);
        long[] jArr7 = cVar.f4120b;
        f.m(jArr7, jArr, jArr7);
    }

    public static d f(byte[] bArr, e eVar, byte[] bArr2) {
        b[] bVarArr = new b[8];
        bVarArr[0] = new b(eVar);
        c cVar = new c();
        h(cVar, eVar);
        e eVar2 = new e(cVar);
        for (int i7 = 1; i7 < 8; i7++) {
            e(cVar, eVar2, bVarArr[i7 - 1]);
            bVarArr[i7] = new b(new e(cVar));
        }
        byte[] bArrQ = q(bArr);
        byte[] bArrQ2 = q(bArr2);
        c cVar2 = new c(f4113b);
        e eVar3 = new e();
        int i8 = 255;
        while (i8 >= 0 && bArrQ[i8] == 0 && bArrQ2[i8] == 0) {
            i8--;
        }
        while (i8 >= 0) {
            g(cVar2, new d(cVar2));
            byte b7 = bArrQ[i8];
            if (b7 > 0) {
                e(cVar2, e.d(eVar3, cVar2), bVarArr[bArrQ[i8] / 2]);
            } else if (b7 < 0) {
                r(cVar2, e.d(eVar3, cVar2), bVarArr[(-bArrQ[i8]) / 2]);
            }
            byte b8 = bArrQ2[i8];
            if (b8 > 0) {
                e(cVar2, e.d(eVar3, cVar2), O2.b.f4130e[bArrQ2[i8] / 2]);
            } else if (b8 < 0) {
                r(cVar2, e.d(eVar3, cVar2), O2.b.f4130e[(-bArrQ2[i8]) / 2]);
            }
            i8--;
        }
        return new d(cVar2);
    }

    public static void g(c cVar, d dVar) {
        long[] jArr = new long[10];
        f.k(cVar.f4119a.f4121a, dVar.f4121a);
        f.k(cVar.f4119a.f4123c, dVar.f4122b);
        f.k(cVar.f4120b, dVar.f4123c);
        long[] jArr2 = cVar.f4120b;
        f.n(jArr2, jArr2, jArr2);
        f.n(cVar.f4119a.f4122b, dVar.f4121a, dVar.f4122b);
        f.k(jArr, cVar.f4119a.f4122b);
        d dVar2 = cVar.f4119a;
        f.n(dVar2.f4122b, dVar2.f4123c, dVar2.f4121a);
        d dVar3 = cVar.f4119a;
        long[] jArr3 = dVar3.f4123c;
        f.m(jArr3, jArr3, dVar3.f4121a);
        d dVar4 = cVar.f4119a;
        f.m(dVar4.f4121a, jArr, dVar4.f4122b);
        long[] jArr4 = cVar.f4120b;
        f.m(jArr4, jArr4, cVar.f4119a.f4123c);
    }

    public static void h(c cVar, e eVar) {
        g(cVar, eVar.f4124a);
    }

    public static int i(long[] jArr) {
        return f.a(jArr)[0] & 1;
    }

    public static boolean j(long[] jArr) {
        long[] jArr2 = new long[jArr.length + 1];
        System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
        f.i(jArr2);
        for (byte b7 : f.a(jArr2)) {
            if (b7 != 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean k(byte[] bArr) {
        for (int i7 = 31; i7 >= 0; i7--) {
            int i8 = bArr[i7] & 255;
            int i9 = f4114c[i7] & 255;
            if (i8 != i9) {
                return i8 < i9;
            }
        }
        return false;
    }

    public static long l(byte[] bArr, int i7) {
        return (((long) (bArr[i7 + 2] & 255)) << 16) | (((long) bArr[i7]) & 255) | (((long) (bArr[i7 + 1] & 255)) << 8);
    }

    public static long m(byte[] bArr, int i7) {
        return (((long) (bArr[i7 + 3] & 255)) << 24) | l(bArr, i7);
    }

    public static void n(long[] jArr, long[] jArr2) {
        for (int i7 = 0; i7 < jArr2.length; i7++) {
            jArr[i7] = -jArr2[i7];
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
        for (int i7 = 1; i7 < 5; i7++) {
            f.k(jArr4, jArr4);
        }
        f.f(jArr3, jArr4, jArr3);
        f.k(jArr4, jArr3);
        for (int i8 = 1; i8 < 10; i8++) {
            f.k(jArr4, jArr4);
        }
        f.f(jArr4, jArr4, jArr3);
        f.k(jArr5, jArr4);
        for (int i9 = 1; i9 < 20; i9++) {
            f.k(jArr5, jArr5);
        }
        f.f(jArr4, jArr5, jArr4);
        f.k(jArr4, jArr4);
        for (int i10 = 1; i10 < 10; i10++) {
            f.k(jArr4, jArr4);
        }
        f.f(jArr3, jArr4, jArr3);
        f.k(jArr4, jArr3);
        for (int i11 = 1; i11 < 50; i11++) {
            f.k(jArr4, jArr4);
        }
        f.f(jArr4, jArr4, jArr3);
        f.k(jArr5, jArr4);
        for (int i12 = 1; i12 < 100; i12++) {
            f.k(jArr5, jArr5);
        }
        f.f(jArr4, jArr5, jArr4);
        f.k(jArr4, jArr4);
        for (int i13 = 1; i13 < 50; i13++) {
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
        long j7 = jL9 - (jM13 * 683901);
        long j8 = ((jM8 - (jM13 * 997805)) + (jM12 * 136657)) - (jL11 * 683901);
        long j9 = ((((jM7 + (jM13 * 470296)) + (jM12 * 654183)) - (jL11 * 997805)) + (jM11 * 136657)) - (jM10 * 683901);
        long j10 = jM4 + (jL10 * 666643);
        long j11 = jL4 + (jM10 * 666643) + (jL10 * 470296);
        long j12 = jL5 + (jM11 * 666643) + (jM10 * 470296) + (jL10 * 654183);
        long j13 = (((jM5 + (jL11 * 666643)) + (jM11 * 470296)) + (jM10 * 654183)) - (jL10 * 997805);
        long j14 = ((((jL6 + (jM12 * 666643)) + (jL11 * 470296)) + (jM11 * 654183)) - (jM10 * 997805)) + (jL10 * 136657);
        long j15 = (((((jM6 + (jM13 * 666643)) + (jM12 * 470296)) + (jL11 * 654183)) - (jM11 * 997805)) + (jM10 * 136657)) - (jL10 * 683901);
        long j16 = (j10 + 1048576) >> 21;
        long j17 = j11 + j16;
        long j18 = j10 - (j16 << 21);
        long j19 = (j12 + 1048576) >> 21;
        long j20 = j13 + j19;
        long j21 = j12 - (j19 << 21);
        long j22 = (j14 + 1048576) >> 21;
        long j23 = j15 + j22;
        long j24 = j14 - (j22 << 21);
        long j25 = (j9 + 1048576) >> 21;
        long j26 = ((((jL7 + (jM13 * 654183)) - (jM12 * 997805)) + (jL11 * 136657)) - (jM11 * 683901)) + j25;
        long j27 = j9 - (j25 << 21);
        long j28 = (j8 + 1048576) >> 21;
        long j29 = ((jL8 + (jM13 * 136657)) - (jM12 * 683901)) + j28;
        long j30 = j8 - (j28 << 21);
        long j31 = (j7 + 1048576) >> 21;
        long j32 = jM9 + j31;
        long j33 = j7 - (j31 << 21);
        long j34 = (j17 + 1048576) >> 21;
        long j35 = j21 + j34;
        long j36 = j17 - (j34 << 21);
        long j37 = (j20 + 1048576) >> 21;
        long j38 = j24 + j37;
        long j39 = j20 - (j37 << 21);
        long j40 = (j23 + 1048576) >> 21;
        long j41 = j27 + j40;
        long j42 = j23 - (j40 << 21);
        long j43 = (j26 + 1048576) >> 21;
        long j44 = j30 + j43;
        long j45 = j26 - (j43 << 21);
        long j46 = (j29 + 1048576) >> 21;
        long j47 = j33 + j46;
        long j48 = j29 - (j46 << 21);
        long j49 = j38 - (j32 * 683901);
        long j50 = ((j35 - (j32 * 997805)) + (j47 * 136657)) - (j48 * 683901);
        long j51 = ((((j18 + (j32 * 470296)) + (j47 * 654183)) - (j48 * 997805)) + (j44 * 136657)) - (j45 * 683901);
        long j52 = jL + (j41 * 666643);
        long j53 = jM + (j45 * 666643) + (j41 * 470296);
        long j54 = jL2 + (j44 * 666643) + (j45 * 470296) + (j41 * 654183);
        long j55 = (((jM2 + (j48 * 666643)) + (j44 * 470296)) + (j45 * 654183)) - (j41 * 997805);
        long j56 = ((((jM3 + (j47 * 666643)) + (j48 * 470296)) + (j44 * 654183)) - (j45 * 997805)) + (j41 * 136657);
        long j57 = (((((jL3 + (j32 * 666643)) + (j47 * 470296)) + (j48 * 654183)) - (j44 * 997805)) + (j45 * 136657)) - (j41 * 683901);
        long j58 = (j52 + 1048576) >> 21;
        long j59 = j53 + j58;
        long j60 = j52 - (j58 << 21);
        long j61 = (j54 + 1048576) >> 21;
        long j62 = j55 + j61;
        long j63 = j54 - (j61 << 21);
        long j64 = (j56 + 1048576) >> 21;
        long j65 = j57 + j64;
        long j66 = j56 - (j64 << 21);
        long j67 = (j51 + 1048576) >> 21;
        long j68 = ((((j36 + (j32 * 654183)) - (j47 * 997805)) + (j48 * 136657)) - (j44 * 683901)) + j67;
        long j69 = j51 - (j67 << 21);
        long j70 = (j50 + 1048576) >> 21;
        long j71 = ((j39 + (j32 * 136657)) - (j47 * 683901)) + j70;
        long j72 = j50 - (j70 << 21);
        long j73 = (j49 + 1048576) >> 21;
        long j74 = j42 + j73;
        long j75 = j49 - (j73 << 21);
        long j76 = (j59 + 1048576) >> 21;
        long j77 = j63 + j76;
        long j78 = j59 - (j76 << 21);
        long j79 = (j62 + 1048576) >> 21;
        long j80 = j66 + j79;
        long j81 = j62 - (j79 << 21);
        long j82 = (j65 + 1048576) >> 21;
        long j83 = j69 + j82;
        long j84 = j65 - (j82 << 21);
        long j85 = (j68 + 1048576) >> 21;
        long j86 = j72 + j85;
        long j87 = j68 - (j85 << 21);
        long j88 = (j71 + 1048576) >> 21;
        long j89 = j75 + j88;
        long j90 = j71 - (j88 << 21);
        long j91 = (j74 + 1048576) >> 21;
        long j92 = j60 + (j91 * 666643);
        long j93 = j92 >> 21;
        long j94 = j78 + (j91 * 470296) + j93;
        long j95 = j92 - (j93 << 21);
        long j96 = j94 >> 21;
        long j97 = j77 + (j91 * 654183) + j96;
        long j98 = j94 - (j96 << 21);
        long j99 = j97 >> 21;
        long j100 = (j81 - (j91 * 997805)) + j99;
        long j101 = j97 - (j99 << 21);
        long j102 = j100 >> 21;
        long j103 = j80 + (j91 * 136657) + j102;
        long j104 = j100 - (j102 << 21);
        long j105 = j103 >> 21;
        long j106 = (j84 - (j91 * 683901)) + j105;
        long j107 = j103 - (j105 << 21);
        long j108 = j106 >> 21;
        long j109 = j83 + j108;
        long j110 = j106 - (j108 << 21);
        long j111 = j109 >> 21;
        long j112 = j87 + j111;
        long j113 = j109 - (j111 << 21);
        long j114 = j112 >> 21;
        long j115 = j86 + j114;
        long j116 = j112 - (j114 << 21);
        long j117 = j115 >> 21;
        long j118 = j90 + j117;
        long j119 = j115 - (j117 << 21);
        long j120 = j118 >> 21;
        long j121 = j89 + j120;
        long j122 = j118 - (j120 << 21);
        long j123 = j121 >> 21;
        long j124 = (j74 - (j91 << 21)) + j123;
        long j125 = j121 - (j123 << 21);
        long j126 = j124 >> 21;
        long j127 = j124 - (j126 << 21);
        long j128 = j95 + (666643 * j126);
        long j129 = j98 + (470296 * j126);
        long j130 = j101 + (654183 * j126);
        long j131 = j104 - (997805 * j126);
        long j132 = j107 + (136657 * j126);
        long j133 = j110 - (j126 * 683901);
        long j134 = j128 >> 21;
        long j135 = j129 + j134;
        long j136 = j128 - (j134 << 21);
        long j137 = j135 >> 21;
        long j138 = j130 + j137;
        long j139 = j135 - (j137 << 21);
        long j140 = j138 >> 21;
        long j141 = j131 + j140;
        long j142 = j138 - (j140 << 21);
        long j143 = j141 >> 21;
        long j144 = j132 + j143;
        long j145 = j141 - (j143 << 21);
        long j146 = j144 >> 21;
        long j147 = j133 + j146;
        long j148 = j144 - (j146 << 21);
        long j149 = j147 >> 21;
        long j150 = j113 + j149;
        long j151 = j147 - (j149 << 21);
        long j152 = j150 >> 21;
        long j153 = j116 + j152;
        long j154 = j150 - (j152 << 21);
        long j155 = j153 >> 21;
        long j156 = j119 + j155;
        long j157 = j153 - (j155 << 21);
        long j158 = j156 >> 21;
        long j159 = j122 + j158;
        long j160 = j159 >> 21;
        long j161 = j125 + j160;
        long j162 = j159 - (j160 << 21);
        long j163 = j161 >> 21;
        long j164 = j127 + j163;
        long j165 = j161 - (j163 << 21);
        bArr[0] = (byte) j136;
        bArr[1] = (byte) (j136 >> 8);
        bArr[2] = (byte) ((j136 >> 16) | (j139 << 5));
        bArr[3] = (byte) (j139 >> 3);
        bArr[4] = (byte) (j139 >> 11);
        bArr[5] = (byte) ((j139 >> 19) | (j142 << 2));
        bArr[6] = (byte) (j142 >> 6);
        bArr[7] = (byte) ((j142 >> 14) | (j145 << 7));
        bArr[8] = (byte) (j145 >> 1);
        bArr[9] = (byte) (j145 >> 9);
        bArr[10] = (byte) ((j145 >> 17) | (j148 << 4));
        bArr[11] = (byte) (j148 >> 4);
        bArr[12] = (byte) (j148 >> 12);
        bArr[13] = (byte) ((j148 >> 20) | (j151 << 1));
        bArr[14] = (byte) (j151 >> 7);
        bArr[15] = (byte) ((j151 >> 15) | (j154 << 6));
        bArr[16] = (byte) (j154 >> 2);
        bArr[17] = (byte) (j154 >> 10);
        bArr[18] = (byte) ((j154 >> 18) | (j157 << 3));
        bArr[19] = (byte) (j157 >> 5);
        bArr[20] = (byte) (j157 >> 13);
        bArr[21] = (byte) (j156 - (j158 << 21));
        bArr[22] = (byte) (r11 >> 8);
        bArr[23] = (byte) ((r11 >> 16) | (j162 << 5));
        bArr[24] = (byte) (j162 >> 3);
        bArr[25] = (byte) (j162 >> 11);
        bArr[26] = (byte) ((j162 >> 19) | (j165 << 2));
        bArr[27] = (byte) (j165 >> 6);
        bArr[28] = (byte) ((j165 >> 14) | (j164 << 7));
        bArr[29] = (byte) (j164 >> 1);
        bArr[30] = (byte) (j164 >> 9);
        bArr[31] = (byte) (j164 >> 17);
    }

    public static byte[] q(byte[] bArr) {
        int i7;
        byte[] bArr2 = new byte[256];
        for (int i8 = 0; i8 < 256; i8++) {
            bArr2[i8] = (byte) (1 & ((bArr[i8 >> 3] & 255) >> (i8 & 7)));
        }
        for (int i9 = 0; i9 < 256; i9++) {
            if (bArr2[i9] != 0) {
                for (int i10 = 1; i10 <= 6 && (i7 = i9 + i10) < 256; i10++) {
                    byte b7 = bArr2[i7];
                    if (b7 != 0) {
                        byte b8 = bArr2[i9];
                        if ((b7 << i10) + b8 <= 15) {
                            bArr2[i9] = (byte) (b8 + (b7 << i10));
                            bArr2[i7] = 0;
                        } else if (b8 - (b7 << i10) >= -15) {
                            bArr2[i9] = (byte) (b8 - (b7 << i10));
                            while (true) {
                                if (i7 >= 256) {
                                    break;
                                }
                                if (bArr2[i7] == 0) {
                                    bArr2[i7] = 1;
                                    break;
                                }
                                bArr2[i7] = 0;
                                i7++;
                            }
                        }
                    }
                }
            }
        }
        return bArr2;
    }

    public static void r(c cVar, e eVar, C0062a c0062a) {
        long[] jArr = new long[10];
        long[] jArr2 = cVar.f4119a.f4121a;
        d dVar = eVar.f4124a;
        f.n(jArr2, dVar.f4122b, dVar.f4121a);
        long[] jArr3 = cVar.f4119a.f4122b;
        d dVar2 = eVar.f4124a;
        f.m(jArr3, dVar2.f4122b, dVar2.f4121a);
        long[] jArr4 = cVar.f4119a.f4122b;
        f.f(jArr4, jArr4, c0062a.f4115a);
        d dVar3 = cVar.f4119a;
        f.f(dVar3.f4123c, dVar3.f4121a, c0062a.f4116b);
        f.f(cVar.f4120b, eVar.f4125b, c0062a.f4117c);
        c0062a.a(cVar.f4119a.f4121a, eVar.f4124a.f4123c);
        long[] jArr5 = cVar.f4119a.f4121a;
        f.n(jArr, jArr5, jArr5);
        d dVar4 = cVar.f4119a;
        f.m(dVar4.f4121a, dVar4.f4123c, dVar4.f4122b);
        d dVar5 = cVar.f4119a;
        long[] jArr6 = dVar5.f4122b;
        f.n(jArr6, dVar5.f4123c, jArr6);
        f.m(cVar.f4119a.f4123c, jArr, cVar.f4120b);
        long[] jArr7 = cVar.f4120b;
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
        MessageDigest messageDigest = (MessageDigest) O2.d.f4142e.a("SHA-512");
        messageDigest.update(bArr2, 0, 32);
        messageDigest.update(bArr3);
        messageDigest.update(bArr);
        byte[] bArrDigest = messageDigest.digest();
        p(bArrDigest);
        byte[] bArrB = f(bArrDigest, e.c(bArr3), bArrCopyOfRange).b();
        for (int i7 = 0; i7 < 32; i7++) {
            if (bArrB[i7] != bArr2[i7]) {
                return false;
            }
        }
        return true;
    }
}
