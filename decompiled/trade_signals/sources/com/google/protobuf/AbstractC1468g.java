package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.google.protobuf.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1468g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile int f16374f = 100;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f16377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C1469h f16378d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f16379e;

    /* JADX INFO: renamed from: com.google.protobuf.g$b */
    public static final class b extends AbstractC1468g {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final byte[] f16380g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f16381h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f16382i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f16383j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f16384k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f16385l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f16386m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f16387n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f16388o;

        public b(byte[] bArr, int i8, int i9, boolean z7) {
            super();
            this.f16388o = Integer.MAX_VALUE;
            this.f16380g = bArr;
            this.f16382i = i9 + i8;
            this.f16384k = i8;
            this.f16385l = i8;
            this.f16381h = z7;
        }

        @Override // com.google.protobuf.AbstractC1468g
        public String A() throws C1482v {
            int iN = N();
            if (iN > 0) {
                int i8 = this.f16382i;
                int i9 = this.f16384k;
                if (iN <= i8 - i9) {
                    String str = new String(this.f16380g, i9, iN, AbstractC1481u.f16588b);
                    this.f16384k += iN;
                    return str;
                }
            }
            if (iN == 0) {
                return "";
            }
            if (iN < 0) {
                throw C1482v.g();
            }
            throw C1482v.m();
        }

        @Override // com.google.protobuf.AbstractC1468g
        public String B() throws C1482v {
            int iN = N();
            if (iN > 0) {
                int i8 = this.f16382i;
                int i9 = this.f16384k;
                if (iN <= i8 - i9) {
                    String strE = k0.e(this.f16380g, i9, iN);
                    this.f16384k += iN;
                    return strE;
                }
            }
            if (iN == 0) {
                return "";
            }
            if (iN <= 0) {
                throw C1482v.g();
            }
            throw C1482v.m();
        }

        @Override // com.google.protobuf.AbstractC1468g
        public int C() throws C1482v {
            if (f()) {
                this.f16386m = 0;
                return 0;
            }
            int iN = N();
            this.f16386m = iN;
            if (l0.a(iN) != 0) {
                return this.f16386m;
            }
            throw C1482v.c();
        }

        @Override // com.google.protobuf.AbstractC1468g
        public int D() {
            return N();
        }

        @Override // com.google.protobuf.AbstractC1468g
        public long E() {
            return O();
        }

        @Override // com.google.protobuf.AbstractC1468g
        public boolean H(int i8) throws C1482v {
            int iB = l0.b(i8);
            if (iB == 0) {
                S();
                return true;
            }
            if (iB == 1) {
                R(8);
                return true;
            }
            if (iB == 2) {
                R(N());
                return true;
            }
            if (iB == 3) {
                I();
                a(l0.c(l0.a(i8), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw C1482v.e();
            }
            R(4);
            return true;
        }

        public byte J() throws C1482v {
            int i8 = this.f16384k;
            if (i8 == this.f16382i) {
                throw C1482v.m();
            }
            byte[] bArr = this.f16380g;
            this.f16384k = i8 + 1;
            return bArr[i8];
        }

        public byte[] K(int i8) throws C1482v {
            if (i8 > 0) {
                int i9 = this.f16382i;
                int i10 = this.f16384k;
                if (i8 <= i9 - i10) {
                    int i11 = i8 + i10;
                    this.f16384k = i11;
                    return Arrays.copyOfRange(this.f16380g, i10, i11);
                }
            }
            if (i8 > 0) {
                throw C1482v.m();
            }
            if (i8 == 0) {
                return AbstractC1481u.f16590d;
            }
            throw C1482v.g();
        }

        public int L() throws C1482v {
            int i8 = this.f16384k;
            if (this.f16382i - i8 < 4) {
                throw C1482v.m();
            }
            byte[] bArr = this.f16380g;
            this.f16384k = i8 + 4;
            return ((bArr[i8 + 3] & 255) << 24) | (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16);
        }

        public long M() throws C1482v {
            int i8 = this.f16384k;
            if (this.f16382i - i8 < 8) {
                throw C1482v.m();
            }
            byte[] bArr = this.f16380g;
            this.f16384k = i8 + 8;
            return ((((long) bArr[i8 + 7]) & 255) << 56) | (((long) bArr[i8]) & 255) | ((((long) bArr[i8 + 1]) & 255) << 8) | ((((long) bArr[i8 + 2]) & 255) << 16) | ((((long) bArr[i8 + 3]) & 255) << 24) | ((((long) bArr[i8 + 4]) & 255) << 32) | ((((long) bArr[i8 + 5]) & 255) << 40) | ((((long) bArr[i8 + 6]) & 255) << 48);
        }

        public int N() {
            int i8;
            int i9 = this.f16384k;
            int i10 = this.f16382i;
            if (i10 != i9) {
                byte[] bArr = this.f16380g;
                int i11 = i9 + 1;
                byte b8 = bArr[i9];
                if (b8 >= 0) {
                    this.f16384k = i11;
                    return b8;
                }
                if (i10 - i11 >= 9) {
                    int i12 = i9 + 2;
                    int i13 = (bArr[i11] << 7) ^ b8;
                    if (i13 < 0) {
                        i8 = i13 ^ (-128);
                    } else {
                        int i14 = i9 + 3;
                        int i15 = (bArr[i12] << 14) ^ i13;
                        if (i15 >= 0) {
                            i8 = i15 ^ 16256;
                        } else {
                            int i16 = i9 + 4;
                            int i17 = i15 ^ (bArr[i14] << 21);
                            if (i17 < 0) {
                                i8 = (-2080896) ^ i17;
                            } else {
                                i14 = i9 + 5;
                                byte b9 = bArr[i16];
                                int i18 = (i17 ^ (b9 << 28)) ^ 266354560;
                                if (b9 < 0) {
                                    i16 = i9 + 6;
                                    if (bArr[i14] < 0) {
                                        i14 = i9 + 7;
                                        if (bArr[i16] < 0) {
                                            i16 = i9 + 8;
                                            if (bArr[i14] < 0) {
                                                i14 = i9 + 9;
                                                if (bArr[i16] < 0) {
                                                    int i19 = i9 + 10;
                                                    if (bArr[i14] >= 0) {
                                                        i12 = i19;
                                                        i8 = i18;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i8 = i18;
                                }
                                i8 = i18;
                            }
                            i12 = i16;
                        }
                        i12 = i14;
                    }
                    this.f16384k = i12;
                    return i8;
                }
            }
            return (int) P();
        }

        public long O() {
            long j8;
            long j9;
            long j10;
            int i8 = this.f16384k;
            int i9 = this.f16382i;
            if (i9 != i8) {
                byte[] bArr = this.f16380g;
                int i10 = i8 + 1;
                byte b8 = bArr[i8];
                if (b8 >= 0) {
                    this.f16384k = i10;
                    return b8;
                }
                if (i9 - i10 >= 9) {
                    int i11 = i8 + 2;
                    int i12 = (bArr[i10] << 7) ^ b8;
                    if (i12 < 0) {
                        j8 = i12 ^ (-128);
                    } else {
                        int i13 = i8 + 3;
                        int i14 = (bArr[i11] << 14) ^ i12;
                        if (i14 >= 0) {
                            j8 = i14 ^ 16256;
                            i11 = i13;
                        } else {
                            int i15 = i8 + 4;
                            int i16 = i14 ^ (bArr[i13] << 21);
                            if (i16 < 0) {
                                long j11 = (-2080896) ^ i16;
                                i11 = i15;
                                j8 = j11;
                            } else {
                                long j12 = i16;
                                i11 = i8 + 5;
                                long j13 = j12 ^ (((long) bArr[i15]) << 28);
                                if (j13 >= 0) {
                                    j10 = 266354560;
                                } else {
                                    int i17 = i8 + 6;
                                    long j14 = j13 ^ (((long) bArr[i11]) << 35);
                                    if (j14 < 0) {
                                        j9 = -34093383808L;
                                    } else {
                                        i11 = i8 + 7;
                                        j13 = j14 ^ (((long) bArr[i17]) << 42);
                                        if (j13 >= 0) {
                                            j10 = 4363953127296L;
                                        } else {
                                            i17 = i8 + 8;
                                            j14 = j13 ^ (((long) bArr[i11]) << 49);
                                            if (j14 < 0) {
                                                j9 = -558586000294016L;
                                            } else {
                                                i11 = i8 + 9;
                                                long j15 = (j14 ^ (((long) bArr[i17]) << 56)) ^ 71499008037633920L;
                                                if (j15 < 0) {
                                                    int i18 = i8 + 10;
                                                    if (bArr[i11] >= 0) {
                                                        i11 = i18;
                                                    }
                                                }
                                                j8 = j15;
                                            }
                                        }
                                    }
                                    j8 = j14 ^ j9;
                                    i11 = i17;
                                }
                                j8 = j13 ^ j10;
                            }
                        }
                    }
                    this.f16384k = i11;
                    return j8;
                }
            }
            return P();
        }

        public long P() throws C1482v {
            long j8 = 0;
            for (int i8 = 0; i8 < 64; i8 += 7) {
                byte bJ = J();
                j8 |= ((long) (bJ & 127)) << i8;
                if ((bJ & 128) == 0) {
                    return j8;
                }
            }
            throw C1482v.f();
        }

        public final void Q() {
            int i8 = this.f16382i + this.f16383j;
            this.f16382i = i8;
            int i9 = i8 - this.f16385l;
            int i10 = this.f16388o;
            if (i9 <= i10) {
                this.f16383j = 0;
                return;
            }
            int i11 = i9 - i10;
            this.f16383j = i11;
            this.f16382i = i8 - i11;
        }

        public void R(int i8) throws C1482v {
            if (i8 >= 0) {
                int i9 = this.f16382i;
                int i10 = this.f16384k;
                if (i8 <= i9 - i10) {
                    this.f16384k = i10 + i8;
                    return;
                }
            }
            if (i8 >= 0) {
                throw C1482v.m();
            }
            throw C1482v.g();
        }

        public final void S() throws C1482v {
            if (this.f16382i - this.f16384k >= 10) {
                T();
            } else {
                U();
            }
        }

        public final void T() throws C1482v {
            for (int i8 = 0; i8 < 10; i8++) {
                byte[] bArr = this.f16380g;
                int i9 = this.f16384k;
                this.f16384k = i9 + 1;
                if (bArr[i9] >= 0) {
                    return;
                }
            }
            throw C1482v.f();
        }

        public final void U() throws C1482v {
            for (int i8 = 0; i8 < 10; i8++) {
                if (J() >= 0) {
                    return;
                }
            }
            throw C1482v.f();
        }

        @Override // com.google.protobuf.AbstractC1468g
        public void a(int i8) throws C1482v {
            if (this.f16386m != i8) {
                throw C1482v.b();
            }
        }

        @Override // com.google.protobuf.AbstractC1468g
        public int e() {
            return this.f16384k - this.f16385l;
        }

        @Override // com.google.protobuf.AbstractC1468g
        public boolean f() {
            return this.f16384k == this.f16382i;
        }

        @Override // com.google.protobuf.AbstractC1468g
        public void l(int i8) {
            this.f16388o = i8;
            Q();
        }

        @Override // com.google.protobuf.AbstractC1468g
        public int m(int i8) throws C1482v {
            if (i8 < 0) {
                throw C1482v.g();
            }
            int iE = i8 + e();
            if (iE < 0) {
                throw C1482v.h();
            }
            int i9 = this.f16388o;
            if (iE > i9) {
                throw C1482v.m();
            }
            this.f16388o = iE;
            Q();
            return i9;
        }

        @Override // com.google.protobuf.AbstractC1468g
        public boolean n() {
            return O() != 0;
        }

        @Override // com.google.protobuf.AbstractC1468g
        public AbstractC1467f o() {
            int iN = N();
            if (iN > 0) {
                int i8 = this.f16382i;
                int i9 = this.f16384k;
                if (iN <= i8 - i9) {
                    AbstractC1467f abstractC1467fT = (this.f16381h && this.f16387n) ? AbstractC1467f.T(this.f16380g, i9, iN) : AbstractC1467f.n(this.f16380g, i9, iN);
                    this.f16384k += iN;
                    return abstractC1467fT;
                }
            }
            return iN == 0 ? AbstractC1467f.f16361b : AbstractC1467f.S(K(iN));
        }

        @Override // com.google.protobuf.AbstractC1468g
        public double p() {
            return Double.longBitsToDouble(M());
        }

        @Override // com.google.protobuf.AbstractC1468g
        public int q() {
            return N();
        }

        @Override // com.google.protobuf.AbstractC1468g
        public int r() {
            return L();
        }

        @Override // com.google.protobuf.AbstractC1468g
        public long s() {
            return M();
        }

        @Override // com.google.protobuf.AbstractC1468g
        public float t() {
            return Float.intBitsToFloat(L());
        }

        @Override // com.google.protobuf.AbstractC1468g
        public int u() {
            return N();
        }

        @Override // com.google.protobuf.AbstractC1468g
        public long v() {
            return O();
        }

        @Override // com.google.protobuf.AbstractC1468g
        public int w() {
            return L();
        }

        @Override // com.google.protobuf.AbstractC1468g
        public long x() {
            return M();
        }

        @Override // com.google.protobuf.AbstractC1468g
        public int y() {
            return AbstractC1468g.c(N());
        }

        @Override // com.google.protobuf.AbstractC1468g
        public long z() {
            return AbstractC1468g.d(O());
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.g$c */
    public static final class c extends AbstractC1468g {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final InputStream f16389g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final byte[] f16390h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f16391i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f16392j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f16393k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f16394l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f16395m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f16396n;

        public c(InputStream inputStream, int i8) {
            super();
            this.f16396n = Integer.MAX_VALUE;
            AbstractC1481u.b(inputStream, "input");
            this.f16389g = inputStream;
            this.f16390h = new byte[i8];
            this.f16391i = 0;
            this.f16393k = 0;
            this.f16395m = 0;
        }

        public static int J(InputStream inputStream) throws C1482v {
            try {
                return inputStream.available();
            } catch (C1482v e8) {
                e8.j();
                throw e8;
            }
        }

        public static int K(InputStream inputStream, byte[] bArr, int i8, int i9) throws C1482v {
            try {
                return inputStream.read(bArr, i8, i9);
            } catch (C1482v e8) {
                e8.j();
                throw e8;
            }
        }

        private void V() {
            int i8 = this.f16391i + this.f16392j;
            this.f16391i = i8;
            int i9 = this.f16395m + i8;
            int i10 = this.f16396n;
            if (i9 <= i10) {
                this.f16392j = 0;
                return;
            }
            int i11 = i9 - i10;
            this.f16392j = i11;
            this.f16391i = i8 - i11;
        }

        public static long X(InputStream inputStream, long j8) throws C1482v {
            try {
                return inputStream.skip(j8);
            } catch (C1482v e8) {
                e8.j();
                throw e8;
            }
        }

        private void a0() throws C1482v {
            if (this.f16391i - this.f16393k >= 10) {
                b0();
            } else {
                c0();
            }
        }

        private void b0() throws C1482v {
            for (int i8 = 0; i8 < 10; i8++) {
                byte[] bArr = this.f16390h;
                int i9 = this.f16393k;
                this.f16393k = i9 + 1;
                if (bArr[i9] >= 0) {
                    return;
                }
            }
            throw C1482v.f();
        }

        private void c0() throws C1482v {
            for (int i8 = 0; i8 < 10; i8++) {
                if (M() >= 0) {
                    return;
                }
            }
            throw C1482v.f();
        }

        @Override // com.google.protobuf.AbstractC1468g
        public String A() throws C1482v {
            int iS = S();
            if (iS > 0) {
                int i8 = this.f16391i;
                int i9 = this.f16393k;
                if (iS <= i8 - i9) {
                    String str = new String(this.f16390h, i9, iS, AbstractC1481u.f16588b);
                    this.f16393k += iS;
                    return str;
                }
            }
            if (iS == 0) {
                return "";
            }
            if (iS < 0) {
                throw C1482v.g();
            }
            if (iS > this.f16391i) {
                return new String(N(iS, false), AbstractC1481u.f16588b);
            }
            W(iS);
            String str2 = new String(this.f16390h, this.f16393k, iS, AbstractC1481u.f16588b);
            this.f16393k += iS;
            return str2;
        }

        @Override // com.google.protobuf.AbstractC1468g
        public String B() throws IOException {
            byte[] bArrN;
            int iS = S();
            int i8 = this.f16393k;
            int i9 = this.f16391i;
            if (iS <= i9 - i8 && iS > 0) {
                bArrN = this.f16390h;
                this.f16393k = i8 + iS;
            } else {
                if (iS == 0) {
                    return "";
                }
                if (iS < 0) {
                    throw C1482v.g();
                }
                i8 = 0;
                if (iS <= i9) {
                    W(iS);
                    bArrN = this.f16390h;
                    this.f16393k = iS;
                } else {
                    bArrN = N(iS, false);
                }
            }
            return k0.e(bArrN, i8, iS);
        }

        @Override // com.google.protobuf.AbstractC1468g
        public int C() throws C1482v {
            if (f()) {
                this.f16394l = 0;
                return 0;
            }
            int iS = S();
            this.f16394l = iS;
            if (l0.a(iS) != 0) {
                return this.f16394l;
            }
            throw C1482v.c();
        }

        @Override // com.google.protobuf.AbstractC1468g
        public int D() {
            return S();
        }

        @Override // com.google.protobuf.AbstractC1468g
        public long E() {
            return T();
        }

        @Override // com.google.protobuf.AbstractC1468g
        public boolean H(int i8) throws C1482v {
            int iB = l0.b(i8);
            if (iB == 0) {
                a0();
                return true;
            }
            if (iB == 1) {
                Y(8);
                return true;
            }
            if (iB == 2) {
                Y(S());
                return true;
            }
            if (iB == 3) {
                I();
                a(l0.c(l0.a(i8), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw C1482v.e();
            }
            Y(4);
            return true;
        }

        public final AbstractC1467f L(int i8) throws IOException {
            byte[] bArrO = O(i8);
            if (bArrO != null) {
                return AbstractC1467f.h(bArrO);
            }
            int i9 = this.f16393k;
            int i10 = this.f16391i;
            int length = i10 - i9;
            this.f16395m += i10;
            this.f16393k = 0;
            this.f16391i = 0;
            List<byte[]> listP = P(i8 - length);
            byte[] bArr = new byte[i8];
            System.arraycopy(this.f16390h, i9, bArr, 0, length);
            for (byte[] bArr2 : listP) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return AbstractC1467f.S(bArr);
        }

        public byte M() throws C1482v {
            if (this.f16393k == this.f16391i) {
                W(1);
            }
            byte[] bArr = this.f16390h;
            int i8 = this.f16393k;
            this.f16393k = i8 + 1;
            return bArr[i8];
        }

        public final byte[] N(int i8, boolean z7) throws IOException {
            byte[] bArrO = O(i8);
            if (bArrO != null) {
                return z7 ? (byte[]) bArrO.clone() : bArrO;
            }
            int i9 = this.f16393k;
            int i10 = this.f16391i;
            int length = i10 - i9;
            this.f16395m += i10;
            this.f16393k = 0;
            this.f16391i = 0;
            List<byte[]> listP = P(i8 - length);
            byte[] bArr = new byte[i8];
            System.arraycopy(this.f16390h, i9, bArr, 0, length);
            for (byte[] bArr2 : listP) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return bArr;
        }

        public final byte[] O(int i8) throws C1482v {
            if (i8 == 0) {
                return AbstractC1481u.f16590d;
            }
            if (i8 < 0) {
                throw C1482v.g();
            }
            int i9 = this.f16395m;
            int i10 = this.f16393k;
            int i11 = i9 + i10 + i8;
            if (i11 - this.f16377c > 0) {
                throw C1482v.l();
            }
            int i12 = this.f16396n;
            if (i11 > i12) {
                Y((i12 - i9) - i10);
                throw C1482v.m();
            }
            int i13 = this.f16391i - i10;
            int i14 = i8 - i13;
            if (i14 >= 4096 && i14 > J(this.f16389g)) {
                return null;
            }
            byte[] bArr = new byte[i8];
            System.arraycopy(this.f16390h, this.f16393k, bArr, 0, i13);
            this.f16395m += this.f16391i;
            this.f16393k = 0;
            this.f16391i = 0;
            while (i13 < i8) {
                int iK = K(this.f16389g, bArr, i13, i8 - i13);
                if (iK == -1) {
                    throw C1482v.m();
                }
                this.f16395m += iK;
                i13 += iK;
            }
            return bArr;
        }

        public final List P(int i8) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i8 > 0) {
                int iMin = Math.min(i8, 4096);
                byte[] bArr = new byte[iMin];
                int i9 = 0;
                while (i9 < iMin) {
                    int i10 = this.f16389g.read(bArr, i9, iMin - i9);
                    if (i10 == -1) {
                        throw C1482v.m();
                    }
                    this.f16395m += i10;
                    i9 += i10;
                }
                i8 -= iMin;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        public int Q() throws C1482v {
            int i8 = this.f16393k;
            if (this.f16391i - i8 < 4) {
                W(4);
                i8 = this.f16393k;
            }
            byte[] bArr = this.f16390h;
            this.f16393k = i8 + 4;
            return ((bArr[i8 + 3] & 255) << 24) | (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16);
        }

        public long R() throws C1482v {
            int i8 = this.f16393k;
            if (this.f16391i - i8 < 8) {
                W(8);
                i8 = this.f16393k;
            }
            byte[] bArr = this.f16390h;
            this.f16393k = i8 + 8;
            return ((((long) bArr[i8 + 7]) & 255) << 56) | (((long) bArr[i8]) & 255) | ((((long) bArr[i8 + 1]) & 255) << 8) | ((((long) bArr[i8 + 2]) & 255) << 16) | ((((long) bArr[i8 + 3]) & 255) << 24) | ((((long) bArr[i8 + 4]) & 255) << 32) | ((((long) bArr[i8 + 5]) & 255) << 40) | ((((long) bArr[i8 + 6]) & 255) << 48);
        }

        public int S() {
            int i8;
            int i9 = this.f16393k;
            int i10 = this.f16391i;
            if (i10 != i9) {
                byte[] bArr = this.f16390h;
                int i11 = i9 + 1;
                byte b8 = bArr[i9];
                if (b8 >= 0) {
                    this.f16393k = i11;
                    return b8;
                }
                if (i10 - i11 >= 9) {
                    int i12 = i9 + 2;
                    int i13 = (bArr[i11] << 7) ^ b8;
                    if (i13 < 0) {
                        i8 = i13 ^ (-128);
                    } else {
                        int i14 = i9 + 3;
                        int i15 = (bArr[i12] << 14) ^ i13;
                        if (i15 >= 0) {
                            i8 = i15 ^ 16256;
                        } else {
                            int i16 = i9 + 4;
                            int i17 = i15 ^ (bArr[i14] << 21);
                            if (i17 < 0) {
                                i8 = (-2080896) ^ i17;
                            } else {
                                i14 = i9 + 5;
                                byte b9 = bArr[i16];
                                int i18 = (i17 ^ (b9 << 28)) ^ 266354560;
                                if (b9 < 0) {
                                    i16 = i9 + 6;
                                    if (bArr[i14] < 0) {
                                        i14 = i9 + 7;
                                        if (bArr[i16] < 0) {
                                            i16 = i9 + 8;
                                            if (bArr[i14] < 0) {
                                                i14 = i9 + 9;
                                                if (bArr[i16] < 0) {
                                                    int i19 = i9 + 10;
                                                    if (bArr[i14] >= 0) {
                                                        i12 = i19;
                                                        i8 = i18;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i8 = i18;
                                }
                                i8 = i18;
                            }
                            i12 = i16;
                        }
                        i12 = i14;
                    }
                    this.f16393k = i12;
                    return i8;
                }
            }
            return (int) U();
        }

        public long T() {
            long j8;
            long j9;
            long j10;
            int i8 = this.f16393k;
            int i9 = this.f16391i;
            if (i9 != i8) {
                byte[] bArr = this.f16390h;
                int i10 = i8 + 1;
                byte b8 = bArr[i8];
                if (b8 >= 0) {
                    this.f16393k = i10;
                    return b8;
                }
                if (i9 - i10 >= 9) {
                    int i11 = i8 + 2;
                    int i12 = (bArr[i10] << 7) ^ b8;
                    if (i12 < 0) {
                        j8 = i12 ^ (-128);
                    } else {
                        int i13 = i8 + 3;
                        int i14 = (bArr[i11] << 14) ^ i12;
                        if (i14 >= 0) {
                            j8 = i14 ^ 16256;
                            i11 = i13;
                        } else {
                            int i15 = i8 + 4;
                            int i16 = i14 ^ (bArr[i13] << 21);
                            if (i16 < 0) {
                                long j11 = (-2080896) ^ i16;
                                i11 = i15;
                                j8 = j11;
                            } else {
                                long j12 = i16;
                                i11 = i8 + 5;
                                long j13 = j12 ^ (((long) bArr[i15]) << 28);
                                if (j13 >= 0) {
                                    j10 = 266354560;
                                } else {
                                    int i17 = i8 + 6;
                                    long j14 = j13 ^ (((long) bArr[i11]) << 35);
                                    if (j14 < 0) {
                                        j9 = -34093383808L;
                                    } else {
                                        i11 = i8 + 7;
                                        j13 = j14 ^ (((long) bArr[i17]) << 42);
                                        if (j13 >= 0) {
                                            j10 = 4363953127296L;
                                        } else {
                                            i17 = i8 + 8;
                                            j14 = j13 ^ (((long) bArr[i11]) << 49);
                                            if (j14 < 0) {
                                                j9 = -558586000294016L;
                                            } else {
                                                i11 = i8 + 9;
                                                long j15 = (j14 ^ (((long) bArr[i17]) << 56)) ^ 71499008037633920L;
                                                if (j15 < 0) {
                                                    int i18 = i8 + 10;
                                                    if (bArr[i11] >= 0) {
                                                        i11 = i18;
                                                    }
                                                }
                                                j8 = j15;
                                            }
                                        }
                                    }
                                    j8 = j14 ^ j9;
                                    i11 = i17;
                                }
                                j8 = j13 ^ j10;
                            }
                        }
                    }
                    this.f16393k = i11;
                    return j8;
                }
            }
            return U();
        }

        public long U() throws C1482v {
            long j8 = 0;
            for (int i8 = 0; i8 < 64; i8 += 7) {
                byte bM = M();
                j8 |= ((long) (bM & 127)) << i8;
                if ((bM & 128) == 0) {
                    return j8;
                }
            }
            throw C1482v.f();
        }

        public final void W(int i8) throws C1482v {
            if (d0(i8)) {
                return;
            }
            if (i8 <= (this.f16377c - this.f16395m) - this.f16393k) {
                throw C1482v.m();
            }
            throw C1482v.l();
        }

        public void Y(int i8) throws C1482v {
            int i9 = this.f16391i;
            int i10 = this.f16393k;
            if (i8 > i9 - i10 || i8 < 0) {
                Z(i8);
            } else {
                this.f16393k = i10 + i8;
            }
        }

        public final void Z(int i8) throws C1482v {
            if (i8 < 0) {
                throw C1482v.g();
            }
            int i9 = this.f16395m;
            int i10 = this.f16393k;
            int i11 = i9 + i10 + i8;
            int i12 = this.f16396n;
            if (i11 > i12) {
                Y((i12 - i9) - i10);
                throw C1482v.m();
            }
            this.f16395m = i9 + i10;
            int i13 = this.f16391i - i10;
            this.f16391i = 0;
            this.f16393k = 0;
            while (i13 < i8) {
                try {
                    long j8 = i8 - i13;
                    long jX = X(this.f16389g, j8);
                    if (jX < 0 || jX > j8) {
                        throw new IllegalStateException(this.f16389g.getClass() + "#skip returned invalid result: " + jX + "\nThe InputStream implementation is buggy.");
                    }
                    if (jX == 0) {
                        break;
                    } else {
                        i13 += (int) jX;
                    }
                } finally {
                    this.f16395m += i13;
                    V();
                }
            }
            if (i13 >= i8) {
                return;
            }
            int i14 = this.f16391i;
            int i15 = i14 - this.f16393k;
            this.f16393k = i14;
            while (true) {
                W(1);
                int i16 = i8 - i15;
                int i17 = this.f16391i;
                if (i16 <= i17) {
                    this.f16393k = i16;
                    return;
                } else {
                    i15 += i17;
                    this.f16393k = i17;
                }
            }
        }

        @Override // com.google.protobuf.AbstractC1468g
        public void a(int i8) throws C1482v {
            if (this.f16394l != i8) {
                throw C1482v.b();
            }
        }

        public final boolean d0(int i8) throws C1482v {
            int i9 = this.f16393k;
            int i10 = i9 + i8;
            int i11 = this.f16391i;
            if (i10 <= i11) {
                throw new IllegalStateException("refillBuffer() called when " + i8 + " bytes were already available in buffer");
            }
            int i12 = this.f16377c;
            int i13 = this.f16395m;
            if (i8 > (i12 - i13) - i9 || i13 + i9 + i8 > this.f16396n) {
                return false;
            }
            if (i9 > 0) {
                if (i11 > i9) {
                    byte[] bArr = this.f16390h;
                    System.arraycopy(bArr, i9, bArr, 0, i11 - i9);
                }
                this.f16395m += i9;
                this.f16391i -= i9;
                this.f16393k = 0;
            }
            InputStream inputStream = this.f16389g;
            byte[] bArr2 = this.f16390h;
            int i14 = this.f16391i;
            int iK = K(inputStream, bArr2, i14, Math.min(bArr2.length - i14, (this.f16377c - this.f16395m) - i14));
            if (iK == 0 || iK < -1 || iK > this.f16390h.length) {
                throw new IllegalStateException(this.f16389g.getClass() + "#read(byte[]) returned invalid result: " + iK + "\nThe InputStream implementation is buggy.");
            }
            if (iK <= 0) {
                return false;
            }
            this.f16391i += iK;
            V();
            if (this.f16391i >= i8) {
                return true;
            }
            return d0(i8);
        }

        @Override // com.google.protobuf.AbstractC1468g
        public int e() {
            return this.f16395m + this.f16393k;
        }

        @Override // com.google.protobuf.AbstractC1468g
        public boolean f() {
            return this.f16393k == this.f16391i && !d0(1);
        }

        @Override // com.google.protobuf.AbstractC1468g
        public void l(int i8) {
            this.f16396n = i8;
            V();
        }

        @Override // com.google.protobuf.AbstractC1468g
        public int m(int i8) throws C1482v {
            if (i8 < 0) {
                throw C1482v.g();
            }
            int i9 = i8 + this.f16395m + this.f16393k;
            int i10 = this.f16396n;
            if (i9 > i10) {
                throw C1482v.m();
            }
            this.f16396n = i9;
            V();
            return i10;
        }

        @Override // com.google.protobuf.AbstractC1468g
        public boolean n() {
            return T() != 0;
        }

        @Override // com.google.protobuf.AbstractC1468g
        public AbstractC1467f o() throws C1482v {
            int iS = S();
            int i8 = this.f16391i;
            int i9 = this.f16393k;
            if (iS <= i8 - i9 && iS > 0) {
                AbstractC1467f abstractC1467fN = AbstractC1467f.n(this.f16390h, i9, iS);
                this.f16393k += iS;
                return abstractC1467fN;
            }
            if (iS == 0) {
                return AbstractC1467f.f16361b;
            }
            if (iS >= 0) {
                return L(iS);
            }
            throw C1482v.g();
        }

        @Override // com.google.protobuf.AbstractC1468g
        public double p() {
            return Double.longBitsToDouble(R());
        }

        @Override // com.google.protobuf.AbstractC1468g
        public int q() {
            return S();
        }

        @Override // com.google.protobuf.AbstractC1468g
        public int r() {
            return Q();
        }

        @Override // com.google.protobuf.AbstractC1468g
        public long s() {
            return R();
        }

        @Override // com.google.protobuf.AbstractC1468g
        public float t() {
            return Float.intBitsToFloat(Q());
        }

        @Override // com.google.protobuf.AbstractC1468g
        public int u() {
            return S();
        }

        @Override // com.google.protobuf.AbstractC1468g
        public long v() {
            return T();
        }

        @Override // com.google.protobuf.AbstractC1468g
        public int w() {
            return Q();
        }

        @Override // com.google.protobuf.AbstractC1468g
        public long x() {
            return R();
        }

        @Override // com.google.protobuf.AbstractC1468g
        public int y() {
            return AbstractC1468g.c(S());
        }

        @Override // com.google.protobuf.AbstractC1468g
        public long z() {
            return AbstractC1468g.d(T());
        }
    }

    public AbstractC1468g() {
        this.f16376b = f16374f;
        this.f16377c = Integer.MAX_VALUE;
        this.f16379e = false;
    }

    public static int c(int i8) {
        return (-(i8 & 1)) ^ (i8 >>> 1);
    }

    public static long d(long j8) {
        return (-(j8 & 1)) ^ (j8 >>> 1);
    }

    public static AbstractC1468g g(InputStream inputStream) {
        return h(inputStream, 4096);
    }

    public static AbstractC1468g h(InputStream inputStream, int i8) {
        if (i8 > 0) {
            return inputStream == null ? i(AbstractC1481u.f16590d) : new c(inputStream, i8);
        }
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    public static AbstractC1468g i(byte[] bArr) {
        return j(bArr, 0, bArr.length);
    }

    public static AbstractC1468g j(byte[] bArr, int i8, int i9) {
        return k(bArr, i8, i9, false);
    }

    public static AbstractC1468g k(byte[] bArr, int i8, int i9, boolean z7) {
        b bVar = new b(bArr, i8, i9, z7);
        try {
            bVar.m(i9);
            return bVar;
        } catch (C1482v e8) {
            throw new IllegalArgumentException(e8);
        }
    }

    public abstract String A();

    public abstract String B();

    public abstract int C();

    public abstract int D();

    public abstract long E();

    public final int F(int i8) {
        if (i8 >= 0) {
            int i9 = this.f16376b;
            this.f16376b = i8;
            return i9;
        }
        throw new IllegalArgumentException("Recursion limit cannot be negative: " + i8);
    }

    public final int G(int i8) {
        if (i8 >= 0) {
            int i9 = this.f16377c;
            this.f16377c = i8;
            return i9;
        }
        throw new IllegalArgumentException("Size limit cannot be negative: " + i8);
    }

    public abstract boolean H(int i8);

    public void I() throws C1482v {
        int iC;
        do {
            iC = C();
            if (iC == 0) {
                return;
            }
            b();
            this.f16375a++;
            this.f16375a--;
        } while (H(iC));
    }

    public abstract void a(int i8);

    public void b() throws C1482v {
        if (this.f16375a >= this.f16376b) {
            throw C1482v.i();
        }
    }

    public abstract int e();

    public abstract boolean f();

    public abstract void l(int i8);

    public abstract int m(int i8);

    public abstract boolean n();

    public abstract AbstractC1467f o();

    public abstract double p();

    public abstract int q();

    public abstract int r();

    public abstract long s();

    public abstract float t();

    public abstract int u();

    public abstract long v();

    public abstract int w();

    public abstract long x();

    public abstract int y();

    public abstract long z();
}
