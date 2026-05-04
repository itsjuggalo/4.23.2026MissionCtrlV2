package x6;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0424a f24211a = new C0424a(new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f24212b = new c(new d(new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}), new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0});

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f24213c = {-19, -45, -11, 92, 26, 99, 18, 88, -42, -100, -9, -94, -34, -7, -34, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16};

    /* JADX INFO: renamed from: x6.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class C0424a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f24214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f24215b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long[] f24216c;

        public C0424a(long[] jArr, long[] jArr2, long[] jArr3) {
            this.f24214a = jArr;
            this.f24215b = jArr2;
            this.f24216c = jArr3;
        }

        public void a(long[] jArr, long[] jArr2) {
            System.arraycopy(jArr2, 0, jArr, 0, 10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b extends C0424a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long[] f24217d;

        public b() {
            this(new long[10], new long[10], new long[10], new long[10]);
        }

        @Override // x6.a.C0424a
        public void a(long[] jArr, long[] jArr2) {
            f.f(jArr, jArr2, this.f24217d);
        }

        public b(e eVar) {
            this();
            long[] jArr = this.f24214a;
            d dVar = eVar.f24223a;
            f.n(jArr, dVar.f24221b, dVar.f24220a);
            long[] jArr2 = this.f24215b;
            d dVar2 = eVar.f24223a;
            f.m(jArr2, dVar2.f24221b, dVar2.f24220a);
            System.arraycopy(eVar.f24223a.f24222c, 0, this.f24217d, 0, 10);
            f.f(this.f24216c, eVar.f24224b, x6.b.f24226b);
        }

        public b(long[] jArr, long[] jArr2, long[] jArr3, long[] jArr4) {
            super(jArr, jArr2, jArr4);
            this.f24217d = jArr3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f24218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f24219b;

        public c() {
            this(new d(), new long[10]);
        }

        public c(d dVar, long[] jArr) {
            this.f24218a = dVar;
            this.f24219b = jArr;
        }

        public c(c cVar) {
            this.f24218a = new d(cVar.f24218a);
            this.f24219b = Arrays.copyOf(cVar.f24219b, 10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f24220a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f24221b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long[] f24222c;

        public d() {
            this(new long[10], new long[10], new long[10]);
        }

        public static d a(d dVar, c cVar) {
            f.f(dVar.f24220a, cVar.f24218a.f24220a, cVar.f24219b);
            long[] jArr = dVar.f24221b;
            d dVar2 = cVar.f24218a;
            f.f(jArr, dVar2.f24221b, dVar2.f24222c);
            f.f(dVar.f24222c, cVar.f24218a.f24222c, cVar.f24219b);
            return dVar;
        }

        public byte[] b() {
            long[] jArr = new long[10];
            long[] jArr2 = new long[10];
            long[] jArr3 = new long[10];
            f.e(jArr, this.f24222c);
            f.f(jArr2, this.f24220a, jArr);
            f.f(jArr3, this.f24221b, jArr);
            byte[] bArrA = f.a(jArr3);
            bArrA[31] = (byte) ((a.i(jArr2) << 7) ^ bArrA[31]);
            return bArrA;
        }

        public d(long[] jArr, long[] jArr2, long[] jArr3) {
            this.f24220a = jArr;
            this.f24221b = jArr2;
            this.f24222c = jArr3;
        }

        public d(d dVar) {
            this.f24220a = Arrays.copyOf(dVar.f24220a, 10);
            this.f24221b = Arrays.copyOf(dVar.f24221b, 10);
            this.f24222c = Arrays.copyOf(dVar.f24222c, 10);
        }

        public d(c cVar) {
            this();
            a(this, cVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f24223a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f24224b;

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
            f.f(jArr5, jArr4, x6.b.f24225a);
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
                f.f(jArr, jArr, x6.b.f24227c);
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
            f.f(eVar.f24223a.f24220a, cVar.f24218a.f24220a, cVar.f24219b);
            long[] jArr = eVar.f24223a.f24221b;
            d dVar = cVar.f24218a;
            f.f(jArr, dVar.f24221b, dVar.f24222c);
            f.f(eVar.f24223a.f24222c, cVar.f24218a.f24222c, cVar.f24219b);
            long[] jArr2 = eVar.f24224b;
            d dVar2 = cVar.f24218a;
            f.f(jArr2, dVar2.f24220a, dVar2.f24221b);
            return eVar;
        }

        public e(d dVar, long[] jArr) {
            this.f24223a = dVar;
            this.f24224b = jArr;
        }

        public e(c cVar) {
            this();
            d(this, cVar);
        }
    }

    public static void e(c cVar, e eVar, C0424a c0424a) {
        long[] jArr = new long[10];
        long[] jArr2 = cVar.f24218a.f24220a;
        d dVar = eVar.f24223a;
        f.n(jArr2, dVar.f24221b, dVar.f24220a);
        long[] jArr3 = cVar.f24218a.f24221b;
        d dVar2 = eVar.f24223a;
        f.m(jArr3, dVar2.f24221b, dVar2.f24220a);
        long[] jArr4 = cVar.f24218a.f24221b;
        f.f(jArr4, jArr4, c0424a.f24215b);
        d dVar3 = cVar.f24218a;
        f.f(dVar3.f24222c, dVar3.f24220a, c0424a.f24214a);
        f.f(cVar.f24219b, eVar.f24224b, c0424a.f24216c);
        c0424a.a(cVar.f24218a.f24220a, eVar.f24223a.f24222c);
        long[] jArr5 = cVar.f24218a.f24220a;
        f.n(jArr, jArr5, jArr5);
        d dVar4 = cVar.f24218a;
        f.m(dVar4.f24220a, dVar4.f24222c, dVar4.f24221b);
        d dVar5 = cVar.f24218a;
        long[] jArr6 = dVar5.f24221b;
        f.n(jArr6, dVar5.f24222c, jArr6);
        f.n(cVar.f24218a.f24222c, jArr, cVar.f24219b);
        long[] jArr7 = cVar.f24219b;
        f.m(jArr7, jArr, jArr7);
    }

    public static d f(byte[] bArr, e eVar, byte[] bArr2) {
        b[] bVarArr = new b[8];
        bVarArr[0] = new b(eVar);
        c cVar = new c();
        h(cVar, eVar);
        e eVar2 = new e(cVar);
        for (int i10 = 1; i10 < 8; i10++) {
            e(cVar, eVar2, bVarArr[i10 - 1]);
            bVarArr[i10] = new b(new e(cVar));
        }
        byte[] bArrQ = q(bArr);
        byte[] bArrQ2 = q(bArr2);
        c cVar2 = new c(f24212b);
        e eVar3 = new e();
        int i11 = 255;
        while (i11 >= 0 && bArrQ[i11] == 0 && bArrQ2[i11] == 0) {
            i11--;
        }
        while (i11 >= 0) {
            g(cVar2, new d(cVar2));
            byte b10 = bArrQ[i11];
            if (b10 > 0) {
                e(cVar2, e.d(eVar3, cVar2), bVarArr[bArrQ[i11] / 2]);
            } else if (b10 < 0) {
                r(cVar2, e.d(eVar3, cVar2), bVarArr[(-bArrQ[i11]) / 2]);
            }
            byte b11 = bArrQ2[i11];
            if (b11 > 0) {
                e(cVar2, e.d(eVar3, cVar2), x6.b.f24229e[bArrQ2[i11] / 2]);
            } else if (b11 < 0) {
                r(cVar2, e.d(eVar3, cVar2), x6.b.f24229e[(-bArrQ2[i11]) / 2]);
            }
            i11--;
        }
        return new d(cVar2);
    }

    public static void g(c cVar, d dVar) {
        long[] jArr = new long[10];
        f.k(cVar.f24218a.f24220a, dVar.f24220a);
        f.k(cVar.f24218a.f24222c, dVar.f24221b);
        f.k(cVar.f24219b, dVar.f24222c);
        long[] jArr2 = cVar.f24219b;
        f.n(jArr2, jArr2, jArr2);
        f.n(cVar.f24218a.f24221b, dVar.f24220a, dVar.f24221b);
        f.k(jArr, cVar.f24218a.f24221b);
        d dVar2 = cVar.f24218a;
        f.n(dVar2.f24221b, dVar2.f24222c, dVar2.f24220a);
        d dVar3 = cVar.f24218a;
        long[] jArr3 = dVar3.f24222c;
        f.m(jArr3, jArr3, dVar3.f24220a);
        d dVar4 = cVar.f24218a;
        f.m(dVar4.f24220a, jArr, dVar4.f24221b);
        long[] jArr4 = cVar.f24219b;
        f.m(jArr4, jArr4, cVar.f24218a.f24222c);
    }

    public static void h(c cVar, e eVar) {
        g(cVar, eVar.f24223a);
    }

    public static int i(long[] jArr) {
        return f.a(jArr)[0] & 1;
    }

    public static boolean j(long[] jArr) {
        long[] jArr2 = new long[jArr.length + 1];
        System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
        f.i(jArr2);
        for (byte b10 : f.a(jArr2)) {
            if (b10 != 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean k(byte[] bArr) {
        for (int i10 = 31; i10 >= 0; i10--) {
            int i11 = bArr[i10] & 255;
            int i12 = f24213c[i10] & 255;
            if (i11 != i12) {
                return i11 < i12;
            }
        }
        return false;
    }

    public static long l(byte[] bArr, int i10) {
        return (((long) (bArr[i10 + 2] & 255)) << 16) | (((long) bArr[i10]) & 255) | (((long) (bArr[i10 + 1] & 255)) << 8);
    }

    public static long m(byte[] bArr, int i10) {
        return (((long) (bArr[i10 + 3] & 255)) << 24) | l(bArr, i10);
    }

    public static void n(long[] jArr, long[] jArr2) {
        for (int i10 = 0; i10 < jArr2.length; i10++) {
            jArr[i10] = -jArr2[i10];
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
        for (int i10 = 1; i10 < 5; i10++) {
            f.k(jArr4, jArr4);
        }
        f.f(jArr3, jArr4, jArr3);
        f.k(jArr4, jArr3);
        for (int i11 = 1; i11 < 10; i11++) {
            f.k(jArr4, jArr4);
        }
        f.f(jArr4, jArr4, jArr3);
        f.k(jArr5, jArr4);
        for (int i12 = 1; i12 < 20; i12++) {
            f.k(jArr5, jArr5);
        }
        f.f(jArr4, jArr5, jArr4);
        f.k(jArr4, jArr4);
        for (int i13 = 1; i13 < 10; i13++) {
            f.k(jArr4, jArr4);
        }
        f.f(jArr3, jArr4, jArr3);
        f.k(jArr4, jArr3);
        for (int i14 = 1; i14 < 50; i14++) {
            f.k(jArr4, jArr4);
        }
        f.f(jArr4, jArr4, jArr3);
        f.k(jArr5, jArr4);
        for (int i15 = 1; i15 < 100; i15++) {
            f.k(jArr5, jArr5);
        }
        f.f(jArr4, jArr5, jArr4);
        f.k(jArr4, jArr4);
        for (int i16 = 1; i16 < 50; i16++) {
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
        long j10 = jL9 - (jM13 * 683901);
        long j11 = ((jM8 - (jM13 * 997805)) + (jM12 * 136657)) - (jL11 * 683901);
        long j12 = ((((jM7 + (jM13 * 470296)) + (jM12 * 654183)) - (jL11 * 997805)) + (jM11 * 136657)) - (jM10 * 683901);
        long j13 = jM4 + (jL10 * 666643);
        long j14 = jL4 + (jM10 * 666643) + (jL10 * 470296);
        long j15 = jL5 + (jM11 * 666643) + (jM10 * 470296) + (jL10 * 654183);
        long j16 = (((jM5 + (jL11 * 666643)) + (jM11 * 470296)) + (jM10 * 654183)) - (jL10 * 997805);
        long j17 = ((((jL6 + (jM12 * 666643)) + (jL11 * 470296)) + (jM11 * 654183)) - (jM10 * 997805)) + (jL10 * 136657);
        long j18 = (((((jM6 + (jM13 * 666643)) + (jM12 * 470296)) + (jL11 * 654183)) - (jM11 * 997805)) + (jM10 * 136657)) - (jL10 * 683901);
        long j19 = (j13 + 1048576) >> 21;
        long j20 = j14 + j19;
        long j21 = j13 - (j19 << 21);
        long j22 = (j15 + 1048576) >> 21;
        long j23 = j16 + j22;
        long j24 = j15 - (j22 << 21);
        long j25 = (j17 + 1048576) >> 21;
        long j26 = j18 + j25;
        long j27 = j17 - (j25 << 21);
        long j28 = (j12 + 1048576) >> 21;
        long j29 = ((((jL7 + (jM13 * 654183)) - (jM12 * 997805)) + (jL11 * 136657)) - (jM11 * 683901)) + j28;
        long j30 = j12 - (j28 << 21);
        long j31 = (j11 + 1048576) >> 21;
        long j32 = ((jL8 + (jM13 * 136657)) - (jM12 * 683901)) + j31;
        long j33 = j11 - (j31 << 21);
        long j34 = (j10 + 1048576) >> 21;
        long j35 = jM9 + j34;
        long j36 = j10 - (j34 << 21);
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
        long j49 = (j32 + 1048576) >> 21;
        long j50 = j36 + j49;
        long j51 = j32 - (j49 << 21);
        long j52 = j41 - (j35 * 683901);
        long j53 = ((j38 - (j35 * 997805)) + (j50 * 136657)) - (j51 * 683901);
        long j54 = ((((j21 + (j35 * 470296)) + (j50 * 654183)) - (j51 * 997805)) + (j47 * 136657)) - (j48 * 683901);
        long j55 = jL + (j44 * 666643);
        long j56 = jM + (j48 * 666643) + (j44 * 470296);
        long j57 = jL2 + (j47 * 666643) + (j48 * 470296) + (j44 * 654183);
        long j58 = (((jM2 + (j51 * 666643)) + (j47 * 470296)) + (j48 * 654183)) - (j44 * 997805);
        long j59 = ((((jM3 + (j50 * 666643)) + (j51 * 470296)) + (j47 * 654183)) - (j48 * 997805)) + (j44 * 136657);
        long j60 = (((((jL3 + (j35 * 666643)) + (j50 * 470296)) + (j51 * 654183)) - (j47 * 997805)) + (j48 * 136657)) - (j44 * 683901);
        long j61 = (j55 + 1048576) >> 21;
        long j62 = j56 + j61;
        long j63 = j55 - (j61 << 21);
        long j64 = (j57 + 1048576) >> 21;
        long j65 = j58 + j64;
        long j66 = j57 - (j64 << 21);
        long j67 = (j59 + 1048576) >> 21;
        long j68 = j60 + j67;
        long j69 = j59 - (j67 << 21);
        long j70 = (j54 + 1048576) >> 21;
        long j71 = ((((j39 + (j35 * 654183)) - (j50 * 997805)) + (j51 * 136657)) - (j47 * 683901)) + j70;
        long j72 = j54 - (j70 << 21);
        long j73 = (j53 + 1048576) >> 21;
        long j74 = ((j42 + (j35 * 136657)) - (j50 * 683901)) + j73;
        long j75 = j53 - (j73 << 21);
        long j76 = (j52 + 1048576) >> 21;
        long j77 = j45 + j76;
        long j78 = j52 - (j76 << 21);
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
        long j92 = (j77 + 1048576) >> 21;
        long j93 = j77 - (j92 << 21);
        long j94 = j63 + (j92 * 666643);
        long j95 = j81 + (j92 * 470296);
        long j96 = j80 + (j92 * 654183);
        long j97 = j84 - (j92 * 997805);
        long j98 = j83 + (j92 * 136657);
        long j99 = j87 - (j92 * 683901);
        long j100 = j94 >> 21;
        long j101 = j95 + j100;
        long j102 = j94 - (j100 << 21);
        long j103 = j101 >> 21;
        long j104 = j96 + j103;
        long j105 = j101 - (j103 << 21);
        long j106 = j104 >> 21;
        long j107 = j97 + j106;
        long j108 = j104 - (j106 << 21);
        long j109 = j107 >> 21;
        long j110 = j98 + j109;
        long j111 = j107 - (j109 << 21);
        long j112 = j110 >> 21;
        long j113 = j99 + j112;
        long j114 = j110 - (j112 << 21);
        long j115 = j113 >> 21;
        long j116 = j86 + j115;
        long j117 = j113 - (j115 << 21);
        long j118 = j116 >> 21;
        long j119 = j90 + j118;
        long j120 = j116 - (j118 << 21);
        long j121 = j119 >> 21;
        long j122 = j89 + j121;
        long j123 = j119 - (j121 << 21);
        long j124 = j122 >> 21;
        long j125 = (j74 - (j91 << 21)) + j124;
        long j126 = j122 - (j124 << 21);
        long j127 = j125 >> 21;
        long j128 = j78 + j91 + j127;
        long j129 = j125 - (j127 << 21);
        long j130 = j128 >> 21;
        long j131 = j93 + j130;
        long j132 = j128 - (j130 << 21);
        long j133 = j131 >> 21;
        long j134 = j131 - (j133 << 21);
        long j135 = j102 + (666643 * j133);
        long j136 = j105 + (470296 * j133);
        long j137 = j108 + (654183 * j133);
        long j138 = j111 - (997805 * j133);
        long j139 = j114 + (136657 * j133);
        long j140 = j117 - (j133 * 683901);
        long j141 = j135 >> 21;
        long j142 = j136 + j141;
        long j143 = j135 - (j141 << 21);
        long j144 = j142 >> 21;
        long j145 = j137 + j144;
        long j146 = j142 - (j144 << 21);
        long j147 = j145 >> 21;
        long j148 = j138 + j147;
        long j149 = j145 - (j147 << 21);
        long j150 = j148 >> 21;
        long j151 = j139 + j150;
        long j152 = j148 - (j150 << 21);
        long j153 = j151 >> 21;
        long j154 = j140 + j153;
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
        long j166 = j129 + j165;
        long j167 = j163 - (j165 << 21);
        long j168 = j166 >> 21;
        long j169 = j132 + j168;
        long j170 = j166 - (j168 << 21);
        long j171 = j169 >> 21;
        long j172 = j134 + j171;
        long j173 = j169 - (j171 << 21);
        bArr[0] = (byte) j143;
        bArr[1] = (byte) (j143 >> 8);
        bArr[2] = (byte) ((j143 >> 16) | (j146 << 5));
        bArr[3] = (byte) (j146 >> 3);
        bArr[4] = (byte) (j146 >> 11);
        bArr[5] = (byte) ((j146 >> 19) | (j149 << 2));
        bArr[6] = (byte) (j149 >> 6);
        bArr[7] = (byte) ((j149 >> 14) | (j152 << 7));
        bArr[8] = (byte) (j152 >> 1);
        bArr[9] = (byte) (j152 >> 9);
        bArr[10] = (byte) ((j152 >> 17) | (j155 << 4));
        bArr[11] = (byte) (j155 >> 4);
        bArr[12] = (byte) (j155 >> 12);
        bArr[13] = (byte) ((j155 >> 20) | (j158 << 1));
        bArr[14] = (byte) (j158 >> 7);
        bArr[15] = (byte) ((j158 >> 15) | (j161 << 6));
        bArr[16] = (byte) (j161 >> 2);
        bArr[17] = (byte) (j161 >> 10);
        bArr[18] = (byte) ((j161 >> 18) | (j164 << 3));
        bArr[19] = (byte) (j164 >> 5);
        bArr[20] = (byte) (j164 >> 13);
        bArr[21] = (byte) j167;
        bArr[22] = (byte) (j167 >> 8);
        bArr[23] = (byte) ((j167 >> 16) | (j170 << 5));
        bArr[24] = (byte) (j170 >> 3);
        bArr[25] = (byte) (j170 >> 11);
        bArr[26] = (byte) ((j170 >> 19) | (j173 << 2));
        bArr[27] = (byte) (j173 >> 6);
        bArr[28] = (byte) ((j173 >> 14) | (j172 << 7));
        bArr[29] = (byte) (j172 >> 1);
        bArr[30] = (byte) (j172 >> 9);
        bArr[31] = (byte) (j172 >> 17);
    }

    public static byte[] q(byte[] bArr) {
        int i10;
        byte[] bArr2 = new byte[256];
        for (int i11 = 0; i11 < 256; i11++) {
            bArr2[i11] = (byte) (1 & ((bArr[i11 >> 3] & 255) >> (i11 & 7)));
        }
        for (int i12 = 0; i12 < 256; i12++) {
            if (bArr2[i12] != 0) {
                for (int i13 = 1; i13 <= 6 && (i10 = i12 + i13) < 256; i13++) {
                    byte b10 = bArr2[i10];
                    if (b10 != 0) {
                        byte b11 = bArr2[i12];
                        if ((b10 << i13) + b11 <= 15) {
                            bArr2[i12] = (byte) (b11 + (b10 << i13));
                            bArr2[i10] = 0;
                        } else if (b11 - (b10 << i13) >= -15) {
                            bArr2[i12] = (byte) (b11 - (b10 << i13));
                            while (true) {
                                if (i10 >= 256) {
                                    break;
                                }
                                if (bArr2[i10] == 0) {
                                    bArr2[i10] = 1;
                                    break;
                                }
                                bArr2[i10] = 0;
                                i10++;
                            }
                        }
                    }
                }
            }
        }
        return bArr2;
    }

    public static void r(c cVar, e eVar, C0424a c0424a) {
        long[] jArr = new long[10];
        long[] jArr2 = cVar.f24218a.f24220a;
        d dVar = eVar.f24223a;
        f.n(jArr2, dVar.f24221b, dVar.f24220a);
        long[] jArr3 = cVar.f24218a.f24221b;
        d dVar2 = eVar.f24223a;
        f.m(jArr3, dVar2.f24221b, dVar2.f24220a);
        long[] jArr4 = cVar.f24218a.f24221b;
        f.f(jArr4, jArr4, c0424a.f24214a);
        d dVar3 = cVar.f24218a;
        f.f(dVar3.f24222c, dVar3.f24220a, c0424a.f24215b);
        f.f(cVar.f24219b, eVar.f24224b, c0424a.f24216c);
        c0424a.a(cVar.f24218a.f24220a, eVar.f24223a.f24222c);
        long[] jArr5 = cVar.f24218a.f24220a;
        f.n(jArr, jArr5, jArr5);
        d dVar4 = cVar.f24218a;
        f.m(dVar4.f24220a, dVar4.f24222c, dVar4.f24221b);
        d dVar5 = cVar.f24218a;
        long[] jArr6 = dVar5.f24221b;
        f.n(jArr6, dVar5.f24222c, jArr6);
        f.m(cVar.f24218a.f24222c, jArr, cVar.f24219b);
        long[] jArr7 = cVar.f24219b;
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
        MessageDigest messageDigest = (MessageDigest) x6.d.f24241e.a("SHA-512");
        messageDigest.update(bArr2, 0, 32);
        messageDigest.update(bArr3);
        messageDigest.update(bArr);
        byte[] bArrDigest = messageDigest.digest();
        p(bArrDigest);
        byte[] bArrB = f(bArrDigest, e.c(bArr3), bArrCopyOfRange).b();
        for (int i10 = 0; i10 < 32; i10++) {
            if (bArrB[i10] != bArr2[i10]) {
                return false;
            }
        }
        return true;
    }
}
