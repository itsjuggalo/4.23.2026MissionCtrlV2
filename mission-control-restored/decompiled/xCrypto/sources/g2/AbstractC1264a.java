package g2;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: renamed from: g2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1264a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0196a f11921a = new C0196a(new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f11922b = new c(new d(new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}), new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0});

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f11923c = {-19, -45, -11, 92, 26, 99, 18, 88, -42, -100, -9, -94, -34, -7, -34, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16};

    /* JADX INFO: renamed from: g2.a$a, reason: collision with other inner class name */
    public static class C0196a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f11924a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f11925b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long[] f11926c;

        public C0196a(long[] jArr, long[] jArr2, long[] jArr3) {
            this.f11924a = jArr;
            this.f11925b = jArr2;
            this.f11926c = jArr3;
        }

        public void a(long[] jArr, long[] jArr2) {
            System.arraycopy(jArr2, 0, jArr, 0, 10);
        }
    }

    /* JADX INFO: renamed from: g2.a$b */
    public static class b extends C0196a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long[] f11927d;

        public b() {
            this(new long[10], new long[10], new long[10], new long[10]);
        }

        @Override // g2.AbstractC1264a.C0196a
        public void a(long[] jArr, long[] jArr2) {
            f.f(jArr, jArr2, this.f11927d);
        }

        public b(e eVar) {
            this();
            long[] jArr = this.f11924a;
            d dVar = eVar.f11933a;
            f.n(jArr, dVar.f11931b, dVar.f11930a);
            long[] jArr2 = this.f11925b;
            d dVar2 = eVar.f11933a;
            f.m(jArr2, dVar2.f11931b, dVar2.f11930a);
            System.arraycopy(eVar.f11933a.f11932c, 0, this.f11927d, 0, 10);
            f.f(this.f11926c, eVar.f11934b, AbstractC1265b.f11936b);
        }

        public b(long[] jArr, long[] jArr2, long[] jArr3, long[] jArr4) {
            super(jArr, jArr2, jArr4);
            this.f11927d = jArr3;
        }
    }

    /* JADX INFO: renamed from: g2.a$c */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f11928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f11929b;

        public c() {
            this(new d(), new long[10]);
        }

        public c(d dVar, long[] jArr) {
            this.f11928a = dVar;
            this.f11929b = jArr;
        }

        public c(c cVar) {
            this.f11928a = new d(cVar.f11928a);
            this.f11929b = Arrays.copyOf(cVar.f11929b, 10);
        }
    }

    /* JADX INFO: renamed from: g2.a$d */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f11930a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f11931b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long[] f11932c;

        public d() {
            this(new long[10], new long[10], new long[10]);
        }

        public static d a(d dVar, c cVar) {
            f.f(dVar.f11930a, cVar.f11928a.f11930a, cVar.f11929b);
            long[] jArr = dVar.f11931b;
            d dVar2 = cVar.f11928a;
            f.f(jArr, dVar2.f11931b, dVar2.f11932c);
            f.f(dVar.f11932c, cVar.f11928a.f11932c, cVar.f11929b);
            return dVar;
        }

        public byte[] b() {
            long[] jArr = new long[10];
            long[] jArr2 = new long[10];
            long[] jArr3 = new long[10];
            f.e(jArr, this.f11932c);
            f.f(jArr2, this.f11930a, jArr);
            f.f(jArr3, this.f11931b, jArr);
            byte[] bArrA = f.a(jArr3);
            bArrA[31] = (byte) ((AbstractC1264a.i(jArr2) << 7) ^ bArrA[31]);
            return bArrA;
        }

        public d(long[] jArr, long[] jArr2, long[] jArr3) {
            this.f11930a = jArr;
            this.f11931b = jArr2;
            this.f11932c = jArr3;
        }

        public d(d dVar) {
            this.f11930a = Arrays.copyOf(dVar.f11930a, 10);
            this.f11931b = Arrays.copyOf(dVar.f11931b, 10);
            this.f11932c = Arrays.copyOf(dVar.f11932c, 10);
        }

        public d(c cVar) {
            this();
            a(this, cVar);
        }
    }

    /* JADX INFO: renamed from: g2.a$e */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f11933a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f11934b;

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
            f.f(jArr5, jArr4, AbstractC1265b.f11935a);
            f.m(jArr4, jArr4, jArr2);
            f.n(jArr5, jArr5, jArr2);
            long[] jArr8 = new long[10];
            f.k(jArr8, jArr5);
            f.f(jArr8, jArr8, jArr5);
            f.k(jArr, jArr8);
            f.f(jArr, jArr, jArr5);
            f.f(jArr, jArr, jArr4);
            AbstractC1264a.o(jArr, jArr);
            f.f(jArr, jArr, jArr8);
            f.f(jArr, jArr, jArr4);
            f.k(jArr6, jArr);
            f.f(jArr6, jArr6, jArr5);
            f.m(jArr7, jArr6, jArr4);
            if (AbstractC1264a.j(jArr7)) {
                f.n(jArr7, jArr6, jArr4);
                if (AbstractC1264a.j(jArr7)) {
                    throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. No square root exists for modulo 2^255-19");
                }
                f.f(jArr, jArr, AbstractC1265b.f11937c);
            }
            if (!AbstractC1264a.j(jArr) && ((bArr[31] & 255) >> 7) != 0) {
                throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. Computed x is zero and encoded x's least significant bit is not zero");
            }
            if (AbstractC1264a.i(jArr) == ((bArr[31] & 255) >> 7)) {
                AbstractC1264a.n(jArr, jArr);
            }
            f.f(jArr3, jArr, jArrC);
            return new e(new d(jArr, jArrC, jArr2), jArr3);
        }

        public static e d(e eVar, c cVar) {
            f.f(eVar.f11933a.f11930a, cVar.f11928a.f11930a, cVar.f11929b);
            long[] jArr = eVar.f11933a.f11931b;
            d dVar = cVar.f11928a;
            f.f(jArr, dVar.f11931b, dVar.f11932c);
            f.f(eVar.f11933a.f11932c, cVar.f11928a.f11932c, cVar.f11929b);
            long[] jArr2 = eVar.f11934b;
            d dVar2 = cVar.f11928a;
            f.f(jArr2, dVar2.f11930a, dVar2.f11931b);
            return eVar;
        }

        public e(d dVar, long[] jArr) {
            this.f11933a = dVar;
            this.f11934b = jArr;
        }

        public e(c cVar) {
            this();
            d(this, cVar);
        }
    }

    public static void e(c cVar, e eVar, C0196a c0196a) {
        long[] jArr = new long[10];
        long[] jArr2 = cVar.f11928a.f11930a;
        d dVar = eVar.f11933a;
        f.n(jArr2, dVar.f11931b, dVar.f11930a);
        long[] jArr3 = cVar.f11928a.f11931b;
        d dVar2 = eVar.f11933a;
        f.m(jArr3, dVar2.f11931b, dVar2.f11930a);
        long[] jArr4 = cVar.f11928a.f11931b;
        f.f(jArr4, jArr4, c0196a.f11925b);
        d dVar3 = cVar.f11928a;
        f.f(dVar3.f11932c, dVar3.f11930a, c0196a.f11924a);
        f.f(cVar.f11929b, eVar.f11934b, c0196a.f11926c);
        c0196a.a(cVar.f11928a.f11930a, eVar.f11933a.f11932c);
        long[] jArr5 = cVar.f11928a.f11930a;
        f.n(jArr, jArr5, jArr5);
        d dVar4 = cVar.f11928a;
        f.m(dVar4.f11930a, dVar4.f11932c, dVar4.f11931b);
        d dVar5 = cVar.f11928a;
        long[] jArr6 = dVar5.f11931b;
        f.n(jArr6, dVar5.f11932c, jArr6);
        f.n(cVar.f11928a.f11932c, jArr, cVar.f11929b);
        long[] jArr7 = cVar.f11929b;
        f.m(jArr7, jArr, jArr7);
    }

    public static d f(byte[] bArr, e eVar, byte[] bArr2) {
        b[] bVarArr = new b[8];
        bVarArr[0] = new b(eVar);
        c cVar = new c();
        h(cVar, eVar);
        e eVar2 = new e(cVar);
        for (int i4 = 1; i4 < 8; i4++) {
            e(cVar, eVar2, bVarArr[i4 - 1]);
            bVarArr[i4] = new b(new e(cVar));
        }
        byte[] bArrQ = q(bArr);
        byte[] bArrQ2 = q(bArr2);
        c cVar2 = new c(f11922b);
        e eVar3 = new e();
        int i5 = 255;
        while (i5 >= 0 && bArrQ[i5] == 0 && bArrQ2[i5] == 0) {
            i5--;
        }
        while (i5 >= 0) {
            g(cVar2, new d(cVar2));
            byte b4 = bArrQ[i5];
            if (b4 > 0) {
                e(cVar2, e.d(eVar3, cVar2), bVarArr[bArrQ[i5] / 2]);
            } else if (b4 < 0) {
                r(cVar2, e.d(eVar3, cVar2), bVarArr[(-bArrQ[i5]) / 2]);
            }
            byte b5 = bArrQ2[i5];
            if (b5 > 0) {
                e(cVar2, e.d(eVar3, cVar2), AbstractC1265b.f11939e[bArrQ2[i5] / 2]);
            } else if (b5 < 0) {
                r(cVar2, e.d(eVar3, cVar2), AbstractC1265b.f11939e[(-bArrQ2[i5]) / 2]);
            }
            i5--;
        }
        return new d(cVar2);
    }

    public static void g(c cVar, d dVar) {
        long[] jArr = new long[10];
        f.k(cVar.f11928a.f11930a, dVar.f11930a);
        f.k(cVar.f11928a.f11932c, dVar.f11931b);
        f.k(cVar.f11929b, dVar.f11932c);
        long[] jArr2 = cVar.f11929b;
        f.n(jArr2, jArr2, jArr2);
        f.n(cVar.f11928a.f11931b, dVar.f11930a, dVar.f11931b);
        f.k(jArr, cVar.f11928a.f11931b);
        d dVar2 = cVar.f11928a;
        f.n(dVar2.f11931b, dVar2.f11932c, dVar2.f11930a);
        d dVar3 = cVar.f11928a;
        long[] jArr3 = dVar3.f11932c;
        f.m(jArr3, jArr3, dVar3.f11930a);
        d dVar4 = cVar.f11928a;
        f.m(dVar4.f11930a, jArr, dVar4.f11931b);
        long[] jArr4 = cVar.f11929b;
        f.m(jArr4, jArr4, cVar.f11928a.f11932c);
    }

    public static void h(c cVar, e eVar) {
        g(cVar, eVar.f11933a);
    }

    public static int i(long[] jArr) {
        return f.a(jArr)[0] & 1;
    }

    public static boolean j(long[] jArr) {
        long[] jArr2 = new long[jArr.length + 1];
        System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
        f.i(jArr2);
        for (byte b4 : f.a(jArr2)) {
            if (b4 != 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean k(byte[] bArr) {
        for (int i4 = 31; i4 >= 0; i4--) {
            int i5 = bArr[i4] & 255;
            int i6 = f11923c[i4] & 255;
            if (i5 != i6) {
                return i5 < i6;
            }
        }
        return false;
    }

    public static long l(byte[] bArr, int i4) {
        return (((long) (bArr[i4 + 2] & 255)) << 16) | (((long) bArr[i4]) & 255) | (((long) (bArr[i4 + 1] & 255)) << 8);
    }

    public static long m(byte[] bArr, int i4) {
        return (((long) (bArr[i4 + 3] & 255)) << 24) | l(bArr, i4);
    }

    public static void n(long[] jArr, long[] jArr2) {
        for (int i4 = 0; i4 < jArr2.length; i4++) {
            jArr[i4] = -jArr2[i4];
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
        for (int i4 = 1; i4 < 5; i4++) {
            f.k(jArr4, jArr4);
        }
        f.f(jArr3, jArr4, jArr3);
        f.k(jArr4, jArr3);
        for (int i5 = 1; i5 < 10; i5++) {
            f.k(jArr4, jArr4);
        }
        f.f(jArr4, jArr4, jArr3);
        f.k(jArr5, jArr4);
        for (int i6 = 1; i6 < 20; i6++) {
            f.k(jArr5, jArr5);
        }
        f.f(jArr4, jArr5, jArr4);
        f.k(jArr4, jArr4);
        for (int i7 = 1; i7 < 10; i7++) {
            f.k(jArr4, jArr4);
        }
        f.f(jArr3, jArr4, jArr3);
        f.k(jArr4, jArr3);
        for (int i8 = 1; i8 < 50; i8++) {
            f.k(jArr4, jArr4);
        }
        f.f(jArr4, jArr4, jArr3);
        f.k(jArr5, jArr4);
        for (int i9 = 1; i9 < 100; i9++) {
            f.k(jArr5, jArr5);
        }
        f.f(jArr4, jArr5, jArr4);
        f.k(jArr4, jArr4);
        for (int i10 = 1; i10 < 50; i10++) {
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
        long j4 = jL9 - (jM13 * 683901);
        long j5 = ((jM8 - (jM13 * 997805)) + (jM12 * 136657)) - (jL11 * 683901);
        long j6 = ((((jM7 + (jM13 * 470296)) + (jM12 * 654183)) - (jL11 * 997805)) + (jM11 * 136657)) - (jM10 * 683901);
        long j7 = jM4 + (jL10 * 666643);
        long j8 = jL4 + (jM10 * 666643) + (jL10 * 470296);
        long j9 = jL5 + (jM11 * 666643) + (jM10 * 470296) + (jL10 * 654183);
        long j10 = (((jM5 + (jL11 * 666643)) + (jM11 * 470296)) + (jM10 * 654183)) - (jL10 * 997805);
        long j11 = ((((jL6 + (jM12 * 666643)) + (jL11 * 470296)) + (jM11 * 654183)) - (jM10 * 997805)) + (jL10 * 136657);
        long j12 = (((((jM6 + (jM13 * 666643)) + (jM12 * 470296)) + (jL11 * 654183)) - (jM11 * 997805)) + (jM10 * 136657)) - (jL10 * 683901);
        long j13 = (j7 + 1048576) >> 21;
        long j14 = j8 + j13;
        long j15 = j7 - (j13 << 21);
        long j16 = (j9 + 1048576) >> 21;
        long j17 = j10 + j16;
        long j18 = j9 - (j16 << 21);
        long j19 = (j11 + 1048576) >> 21;
        long j20 = j12 + j19;
        long j21 = j11 - (j19 << 21);
        long j22 = (j6 + 1048576) >> 21;
        long j23 = ((((jL7 + (jM13 * 654183)) - (jM12 * 997805)) + (jL11 * 136657)) - (jM11 * 683901)) + j22;
        long j24 = j6 - (j22 << 21);
        long j25 = (j5 + 1048576) >> 21;
        long j26 = ((jL8 + (jM13 * 136657)) - (jM12 * 683901)) + j25;
        long j27 = j5 - (j25 << 21);
        long j28 = (j4 + 1048576) >> 21;
        long j29 = jM9 + j28;
        long j30 = j4 - (j28 << 21);
        long j31 = (j14 + 1048576) >> 21;
        long j32 = j18 + j31;
        long j33 = j14 - (j31 << 21);
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
        long j46 = j35 - (j29 * 683901);
        long j47 = ((j32 - (j29 * 997805)) + (j44 * 136657)) - (j45 * 683901);
        long j48 = ((((j15 + (j29 * 470296)) + (j44 * 654183)) - (j45 * 997805)) + (j41 * 136657)) - (j42 * 683901);
        long j49 = jL + (j38 * 666643);
        long j50 = jM + (j42 * 666643) + (j38 * 470296);
        long j51 = jL2 + (j41 * 666643) + (j42 * 470296) + (j38 * 654183);
        long j52 = (((jM2 + (j45 * 666643)) + (j41 * 470296)) + (j42 * 654183)) - (j38 * 997805);
        long j53 = ((((jM3 + (j44 * 666643)) + (j45 * 470296)) + (j41 * 654183)) - (j42 * 997805)) + (j38 * 136657);
        long j54 = (((((jL3 + (j29 * 666643)) + (j44 * 470296)) + (j45 * 654183)) - (j41 * 997805)) + (j42 * 136657)) - (j38 * 683901);
        long j55 = (j49 + 1048576) >> 21;
        long j56 = j50 + j55;
        long j57 = j49 - (j55 << 21);
        long j58 = (j51 + 1048576) >> 21;
        long j59 = j52 + j58;
        long j60 = j51 - (j58 << 21);
        long j61 = (j53 + 1048576) >> 21;
        long j62 = j54 + j61;
        long j63 = j53 - (j61 << 21);
        long j64 = (j48 + 1048576) >> 21;
        long j65 = ((((j33 + (j29 * 654183)) - (j44 * 997805)) + (j45 * 136657)) - (j41 * 683901)) + j64;
        long j66 = j48 - (j64 << 21);
        long j67 = (j47 + 1048576) >> 21;
        long j68 = ((j36 + (j29 * 136657)) - (j44 * 683901)) + j67;
        long j69 = j47 - (j67 << 21);
        long j70 = (j46 + 1048576) >> 21;
        long j71 = j39 + j70;
        long j72 = j46 - (j70 << 21);
        long j73 = (j56 + 1048576) >> 21;
        long j74 = j60 + j73;
        long j75 = j56 - (j73 << 21);
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
        long j86 = (j71 + 1048576) >> 21;
        long j87 = j71 - (j86 << 21);
        long j88 = j57 + (j86 * 666643);
        long j89 = j75 + (j86 * 470296);
        long j90 = j74 + (j86 * 654183);
        long j91 = j78 - (j86 * 997805);
        long j92 = j77 + (j86 * 136657);
        long j93 = j81 - (j86 * 683901);
        long j94 = j88 >> 21;
        long j95 = j89 + j94;
        long j96 = j88 - (j94 << 21);
        long j97 = j95 >> 21;
        long j98 = j90 + j97;
        long j99 = j95 - (j97 << 21);
        long j100 = j98 >> 21;
        long j101 = j91 + j100;
        long j102 = j98 - (j100 << 21);
        long j103 = j101 >> 21;
        long j104 = j92 + j103;
        long j105 = j101 - (j103 << 21);
        long j106 = j104 >> 21;
        long j107 = j93 + j106;
        long j108 = j104 - (j106 << 21);
        long j109 = j107 >> 21;
        long j110 = j80 + j109;
        long j111 = j107 - (j109 << 21);
        long j112 = j110 >> 21;
        long j113 = j84 + j112;
        long j114 = j110 - (j112 << 21);
        long j115 = j113 >> 21;
        long j116 = j83 + j115;
        long j117 = j113 - (j115 << 21);
        long j118 = j116 >> 21;
        long j119 = (j68 - (j85 << 21)) + j118;
        long j120 = j116 - (j118 << 21);
        long j121 = j119 >> 21;
        long j122 = j72 + j85 + j121;
        long j123 = j119 - (j121 << 21);
        long j124 = j122 >> 21;
        long j125 = j87 + j124;
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
        long j161 = j157 - (j159 << 21);
        long j162 = j160 >> 21;
        long j163 = j126 + j162;
        long j164 = j160 - (j162 << 21);
        long j165 = j163 >> 21;
        long j166 = j128 + j165;
        long j167 = j163 - (j165 << 21);
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
        bArr[21] = (byte) j161;
        bArr[22] = (byte) (j161 >> 8);
        bArr[23] = (byte) ((j161 >> 16) | (j164 << 5));
        bArr[24] = (byte) (j164 >> 3);
        bArr[25] = (byte) (j164 >> 11);
        bArr[26] = (byte) ((j164 >> 19) | (j167 << 2));
        bArr[27] = (byte) (j167 >> 6);
        bArr[28] = (byte) ((j167 >> 14) | (j166 << 7));
        bArr[29] = (byte) (j166 >> 1);
        bArr[30] = (byte) (j166 >> 9);
        bArr[31] = (byte) (j166 >> 17);
    }

    public static byte[] q(byte[] bArr) {
        int i4;
        byte[] bArr2 = new byte[256];
        for (int i5 = 0; i5 < 256; i5++) {
            bArr2[i5] = (byte) (1 & ((bArr[i5 >> 3] & 255) >> (i5 & 7)));
        }
        for (int i6 = 0; i6 < 256; i6++) {
            if (bArr2[i6] != 0) {
                for (int i7 = 1; i7 <= 6 && (i4 = i6 + i7) < 256; i7++) {
                    byte b4 = bArr2[i4];
                    if (b4 != 0) {
                        byte b5 = bArr2[i6];
                        if ((b4 << i7) + b5 <= 15) {
                            bArr2[i6] = (byte) (b5 + (b4 << i7));
                            bArr2[i4] = 0;
                        } else if (b5 - (b4 << i7) >= -15) {
                            bArr2[i6] = (byte) (b5 - (b4 << i7));
                            while (true) {
                                if (i4 >= 256) {
                                    break;
                                }
                                if (bArr2[i4] == 0) {
                                    bArr2[i4] = 1;
                                    break;
                                }
                                bArr2[i4] = 0;
                                i4++;
                            }
                        }
                    }
                }
            }
        }
        return bArr2;
    }

    public static void r(c cVar, e eVar, C0196a c0196a) {
        long[] jArr = new long[10];
        long[] jArr2 = cVar.f11928a.f11930a;
        d dVar = eVar.f11933a;
        f.n(jArr2, dVar.f11931b, dVar.f11930a);
        long[] jArr3 = cVar.f11928a.f11931b;
        d dVar2 = eVar.f11933a;
        f.m(jArr3, dVar2.f11931b, dVar2.f11930a);
        long[] jArr4 = cVar.f11928a.f11931b;
        f.f(jArr4, jArr4, c0196a.f11924a);
        d dVar3 = cVar.f11928a;
        f.f(dVar3.f11932c, dVar3.f11930a, c0196a.f11925b);
        f.f(cVar.f11929b, eVar.f11934b, c0196a.f11926c);
        c0196a.a(cVar.f11928a.f11930a, eVar.f11933a.f11932c);
        long[] jArr5 = cVar.f11928a.f11930a;
        f.n(jArr, jArr5, jArr5);
        d dVar4 = cVar.f11928a;
        f.m(dVar4.f11930a, dVar4.f11932c, dVar4.f11931b);
        d dVar5 = cVar.f11928a;
        long[] jArr6 = dVar5.f11931b;
        f.n(jArr6, dVar5.f11932c, jArr6);
        f.m(cVar.f11928a.f11932c, jArr, cVar.f11929b);
        long[] jArr7 = cVar.f11929b;
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
        MessageDigest messageDigest = (MessageDigest) C1267d.f11951e.a("SHA-512");
        messageDigest.update(bArr2, 0, 32);
        messageDigest.update(bArr3);
        messageDigest.update(bArr);
        byte[] bArrDigest = messageDigest.digest();
        p(bArrDigest);
        byte[] bArrB = f(bArrDigest, e.c(bArr3), bArrCopyOfRange).b();
        for (int i4 = 0; i4 < 32; i4++) {
            if (bArrB[i4] != bArr2[i4]) {
                return false;
            }
        }
        return true;
    }
}
