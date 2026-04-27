package com.google.protobuf;

import com.google.android.gms.common.api.a;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.google.protobuf.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1241j {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile int f12663f = 100;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C1242k f12667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f12668e;

    /* JADX INFO: renamed from: com.google.protobuf.j$b */
    public static final class b extends AbstractC1241j {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final byte[] f12669g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f12670h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f12671i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f12672j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f12673k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f12674l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f12675m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f12676n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f12677o;

        @Override // com.google.protobuf.AbstractC1241j
        public int A() {
            return AbstractC1241j.c(P());
        }

        @Override // com.google.protobuf.AbstractC1241j
        public long B() {
            return AbstractC1241j.d(Q());
        }

        @Override // com.google.protobuf.AbstractC1241j
        public String C() throws D {
            int iP = P();
            if (iP > 0) {
                int i7 = this.f12671i;
                int i8 = this.f12673k;
                if (iP <= i7 - i8) {
                    String str = new String(this.f12669g, i8, iP, C.f12546b);
                    this.f12673k += iP;
                    return str;
                }
            }
            if (iP == 0) {
                return "";
            }
            if (iP < 0) {
                throw D.g();
            }
            throw D.m();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public String D() throws D {
            int iP = P();
            if (iP > 0) {
                int i7 = this.f12671i;
                int i8 = this.f12673k;
                if (iP <= i7 - i8) {
                    String strH = A0.h(this.f12669g, i8, iP);
                    this.f12673k += iP;
                    return strH;
                }
            }
            if (iP == 0) {
                return "";
            }
            if (iP <= 0) {
                throw D.g();
            }
            throw D.m();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int E() throws D {
            if (f()) {
                this.f12675m = 0;
                return 0;
            }
            int iP = P();
            this.f12675m = iP;
            if (B0.a(iP) != 0) {
                return this.f12675m;
            }
            throw D.c();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int F() {
            return P();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public long G() {
            return Q();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public boolean J(int i7) throws D {
            int iB = B0.b(i7);
            if (iB == 0) {
                U();
                return true;
            }
            if (iB == 1) {
                T(8);
                return true;
            }
            if (iB == 2) {
                T(P());
                return true;
            }
            if (iB == 3) {
                K();
                a(B0.c(B0.a(i7), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw D.e();
            }
            T(4);
            return true;
        }

        public byte L() throws D {
            int i7 = this.f12673k;
            if (i7 == this.f12671i) {
                throw D.m();
            }
            byte[] bArr = this.f12669g;
            this.f12673k = i7 + 1;
            return bArr[i7];
        }

        public byte[] M(int i7) throws D {
            if (i7 > 0) {
                int i8 = this.f12671i;
                int i9 = this.f12673k;
                if (i7 <= i8 - i9) {
                    int i10 = i7 + i9;
                    this.f12673k = i10;
                    return Arrays.copyOfRange(this.f12669g, i9, i10);
                }
            }
            if (i7 > 0) {
                throw D.m();
            }
            if (i7 == 0) {
                return C.f12548d;
            }
            throw D.g();
        }

        public int N() throws D {
            int i7 = this.f12673k;
            if (this.f12671i - i7 < 4) {
                throw D.m();
            }
            byte[] bArr = this.f12669g;
            this.f12673k = i7 + 4;
            return ((bArr[i7 + 3] & 255) << 24) | (bArr[i7] & 255) | ((bArr[i7 + 1] & 255) << 8) | ((bArr[i7 + 2] & 255) << 16);
        }

        public long O() throws D {
            int i7 = this.f12673k;
            if (this.f12671i - i7 < 8) {
                throw D.m();
            }
            byte[] bArr = this.f12669g;
            this.f12673k = i7 + 8;
            return ((((long) bArr[i7 + 7]) & 255) << 56) | (((long) bArr[i7]) & 255) | ((((long) bArr[i7 + 1]) & 255) << 8) | ((((long) bArr[i7 + 2]) & 255) << 16) | ((((long) bArr[i7 + 3]) & 255) << 24) | ((((long) bArr[i7 + 4]) & 255) << 32) | ((((long) bArr[i7 + 5]) & 255) << 40) | ((((long) bArr[i7 + 6]) & 255) << 48);
        }

        public int P() {
            int i7;
            int i8 = this.f12673k;
            int i9 = this.f12671i;
            if (i9 != i8) {
                byte[] bArr = this.f12669g;
                int i10 = i8 + 1;
                byte b7 = bArr[i8];
                if (b7 >= 0) {
                    this.f12673k = i10;
                    return b7;
                }
                if (i9 - i10 >= 9) {
                    int i11 = i8 + 2;
                    int i12 = (bArr[i10] << 7) ^ b7;
                    if (i12 < 0) {
                        i7 = i12 ^ (-128);
                    } else {
                        int i13 = i8 + 3;
                        int i14 = (bArr[i11] << 14) ^ i12;
                        if (i14 >= 0) {
                            i7 = i14 ^ 16256;
                        } else {
                            int i15 = i8 + 4;
                            int i16 = i14 ^ (bArr[i13] << 21);
                            if (i16 < 0) {
                                i7 = (-2080896) ^ i16;
                            } else {
                                i13 = i8 + 5;
                                byte b8 = bArr[i15];
                                int i17 = (i16 ^ (b8 << 28)) ^ 266354560;
                                if (b8 < 0) {
                                    i15 = i8 + 6;
                                    if (bArr[i13] < 0) {
                                        i13 = i8 + 7;
                                        if (bArr[i15] < 0) {
                                            i15 = i8 + 8;
                                            if (bArr[i13] < 0) {
                                                i13 = i8 + 9;
                                                if (bArr[i15] < 0) {
                                                    int i18 = i8 + 10;
                                                    if (bArr[i13] >= 0) {
                                                        i11 = i18;
                                                        i7 = i17;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i7 = i17;
                                }
                                i7 = i17;
                            }
                            i11 = i15;
                        }
                        i11 = i13;
                    }
                    this.f12673k = i11;
                    return i7;
                }
            }
            return (int) R();
        }

        public long Q() {
            long j7;
            long j8;
            long j9;
            int i7 = this.f12673k;
            int i8 = this.f12671i;
            if (i8 != i7) {
                byte[] bArr = this.f12669g;
                int i9 = i7 + 1;
                byte b7 = bArr[i7];
                if (b7 >= 0) {
                    this.f12673k = i9;
                    return b7;
                }
                if (i8 - i9 >= 9) {
                    int i10 = i7 + 2;
                    int i11 = (bArr[i9] << 7) ^ b7;
                    if (i11 < 0) {
                        j7 = i11 ^ (-128);
                    } else {
                        int i12 = i7 + 3;
                        int i13 = (bArr[i10] << 14) ^ i11;
                        if (i13 >= 0) {
                            j7 = i13 ^ 16256;
                            i10 = i12;
                        } else {
                            int i14 = i7 + 4;
                            int i15 = i13 ^ (bArr[i12] << 21);
                            if (i15 < 0) {
                                long j10 = (-2080896) ^ i15;
                                i10 = i14;
                                j7 = j10;
                            } else {
                                long j11 = i15;
                                i10 = i7 + 5;
                                long j12 = j11 ^ (((long) bArr[i14]) << 28);
                                if (j12 >= 0) {
                                    j9 = 266354560;
                                } else {
                                    int i16 = i7 + 6;
                                    long j13 = j12 ^ (((long) bArr[i10]) << 35);
                                    if (j13 < 0) {
                                        j8 = -34093383808L;
                                    } else {
                                        i10 = i7 + 7;
                                        j12 = j13 ^ (((long) bArr[i16]) << 42);
                                        if (j12 >= 0) {
                                            j9 = 4363953127296L;
                                        } else {
                                            i16 = i7 + 8;
                                            j13 = j12 ^ (((long) bArr[i10]) << 49);
                                            if (j13 < 0) {
                                                j8 = -558586000294016L;
                                            } else {
                                                i10 = i7 + 9;
                                                long j14 = (j13 ^ (((long) bArr[i16]) << 56)) ^ 71499008037633920L;
                                                if (j14 < 0) {
                                                    int i17 = i7 + 10;
                                                    if (bArr[i10] >= 0) {
                                                        i10 = i17;
                                                    }
                                                }
                                                j7 = j14;
                                            }
                                        }
                                    }
                                    j7 = j13 ^ j8;
                                    i10 = i16;
                                }
                                j7 = j12 ^ j9;
                            }
                        }
                    }
                    this.f12673k = i10;
                    return j7;
                }
            }
            return R();
        }

        public long R() throws D {
            long j7 = 0;
            for (int i7 = 0; i7 < 64; i7 += 7) {
                byte bL = L();
                j7 |= ((long) (bL & 127)) << i7;
                if ((bL & 128) == 0) {
                    return j7;
                }
            }
            throw D.f();
        }

        public final void S() {
            int i7 = this.f12671i + this.f12672j;
            this.f12671i = i7;
            int i8 = i7 - this.f12674l;
            int i9 = this.f12677o;
            if (i8 <= i9) {
                this.f12672j = 0;
                return;
            }
            int i10 = i8 - i9;
            this.f12672j = i10;
            this.f12671i = i7 - i10;
        }

        public void T(int i7) throws D {
            if (i7 >= 0) {
                int i8 = this.f12671i;
                int i9 = this.f12673k;
                if (i7 <= i8 - i9) {
                    this.f12673k = i9 + i7;
                    return;
                }
            }
            if (i7 >= 0) {
                throw D.m();
            }
            throw D.g();
        }

        public final void U() throws D {
            if (this.f12671i - this.f12673k >= 10) {
                V();
            } else {
                W();
            }
        }

        public final void V() throws D {
            for (int i7 = 0; i7 < 10; i7++) {
                byte[] bArr = this.f12669g;
                int i8 = this.f12673k;
                this.f12673k = i8 + 1;
                if (bArr[i8] >= 0) {
                    return;
                }
            }
            throw D.f();
        }

        public final void W() throws D {
            for (int i7 = 0; i7 < 10; i7++) {
                if (L() >= 0) {
                    return;
                }
            }
            throw D.f();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public void a(int i7) throws D {
            if (this.f12675m != i7) {
                throw D.b();
            }
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int e() {
            return this.f12673k - this.f12674l;
        }

        @Override // com.google.protobuf.AbstractC1241j
        public boolean f() {
            return this.f12673k == this.f12671i;
        }

        @Override // com.google.protobuf.AbstractC1241j
        public void n(int i7) {
            this.f12677o = i7;
            S();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int o(int i7) throws D {
            if (i7 < 0) {
                throw D.g();
            }
            int iE = i7 + e();
            if (iE < 0) {
                throw D.h();
            }
            int i8 = this.f12677o;
            if (iE > i8) {
                throw D.m();
            }
            this.f12677o = iE;
            S();
            return i8;
        }

        @Override // com.google.protobuf.AbstractC1241j
        public boolean p() {
            return Q() != 0;
        }

        @Override // com.google.protobuf.AbstractC1241j
        public AbstractC1240i q() {
            int iP = P();
            if (iP > 0) {
                int i7 = this.f12671i;
                int i8 = this.f12673k;
                if (iP <= i7 - i8) {
                    AbstractC1240i abstractC1240iN = (this.f12670h && this.f12676n) ? AbstractC1240i.N(this.f12669g, i8, iP) : AbstractC1240i.n(this.f12669g, i8, iP);
                    this.f12673k += iP;
                    return abstractC1240iN;
                }
            }
            return iP == 0 ? AbstractC1240i.f12650b : AbstractC1240i.M(M(iP));
        }

        @Override // com.google.protobuf.AbstractC1241j
        public double r() {
            return Double.longBitsToDouble(O());
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int s() {
            return P();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int t() {
            return N();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public long u() {
            return O();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public float v() {
            return Float.intBitsToFloat(N());
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int w() {
            return P();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public long x() {
            return Q();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int y() {
            return N();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public long z() {
            return O();
        }

        public b(byte[] bArr, int i7, int i8, boolean z7) {
            super();
            this.f12677o = a.e.API_PRIORITY_OTHER;
            this.f12669g = bArr;
            this.f12671i = i8 + i7;
            this.f12673k = i7;
            this.f12674l = i7;
            this.f12670h = z7;
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.j$c */
    public static final class c extends AbstractC1241j {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Iterable f12678g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Iterator f12679h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public ByteBuffer f12680i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f12681j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f12682k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f12683l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f12684m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f12685n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f12686o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f12687p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f12688q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public long f12689r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public long f12690s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public long f12691t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public long f12692u;

        private void U() {
            int i7 = this.f12683l + this.f12684m;
            this.f12683l = i7;
            int i8 = i7 - this.f12688q;
            int i9 = this.f12685n;
            if (i8 <= i9) {
                this.f12684m = 0;
                return;
            }
            int i10 = i8 - i9;
            this.f12684m = i10;
            this.f12683l = i7 - i10;
        }

        private void X() throws D {
            for (int i7 = 0; i7 < 10; i7++) {
                if (N() >= 0) {
                    return;
                }
            }
            throw D.f();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int A() {
            return AbstractC1241j.c(R());
        }

        @Override // com.google.protobuf.AbstractC1241j
        public long B() {
            return AbstractC1241j.d(S());
        }

        @Override // com.google.protobuf.AbstractC1241j
        public String C() throws D {
            int iR = R();
            if (iR > 0) {
                long j7 = iR;
                long j8 = this.f12692u;
                long j9 = this.f12689r;
                if (j7 <= j8 - j9) {
                    byte[] bArr = new byte[iR];
                    z0.p(j9, bArr, 0L, j7);
                    String str = new String(bArr, C.f12546b);
                    this.f12689r += j7;
                    return str;
                }
            }
            if (iR > 0 && iR <= V()) {
                byte[] bArr2 = new byte[iR];
                O(bArr2, 0, iR);
                return new String(bArr2, C.f12546b);
            }
            if (iR == 0) {
                return "";
            }
            if (iR < 0) {
                throw D.g();
            }
            throw D.m();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public String D() throws D {
            int iR = R();
            if (iR > 0) {
                long j7 = iR;
                long j8 = this.f12692u;
                long j9 = this.f12689r;
                if (j7 <= j8 - j9) {
                    String strG = A0.g(this.f12680i, (int) (j9 - this.f12690s), iR);
                    this.f12689r += j7;
                    return strG;
                }
            }
            if (iR >= 0 && iR <= V()) {
                byte[] bArr = new byte[iR];
                O(bArr, 0, iR);
                return A0.h(bArr, 0, iR);
            }
            if (iR == 0) {
                return "";
            }
            if (iR <= 0) {
                throw D.g();
            }
            throw D.m();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int E() throws D {
            if (f()) {
                this.f12686o = 0;
                return 0;
            }
            int iR = R();
            this.f12686o = iR;
            if (B0.a(iR) != 0) {
                return this.f12686o;
            }
            throw D.c();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int F() {
            return R();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public long G() {
            return S();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public boolean J(int i7) throws D {
            int iB = B0.b(i7);
            if (iB == 0) {
                X();
                return true;
            }
            if (iB == 1) {
                W(8);
                return true;
            }
            if (iB == 2) {
                W(R());
                return true;
            }
            if (iB == 3) {
                K();
                a(B0.c(B0.a(i7), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw D.e();
            }
            W(4);
            return true;
        }

        public final long L() {
            return this.f12692u - this.f12689r;
        }

        public final void M() throws D {
            if (!this.f12679h.hasNext()) {
                throw D.m();
            }
            Z();
        }

        public byte N() throws D {
            if (L() == 0) {
                M();
            }
            long j7 = this.f12689r;
            this.f12689r = 1 + j7;
            return z0.w(j7);
        }

        public final void O(byte[] bArr, int i7, int i8) throws D {
            if (i8 < 0 || i8 > V()) {
                if (i8 > 0) {
                    throw D.m();
                }
                if (i8 != 0) {
                    throw D.g();
                }
                return;
            }
            int i9 = i8;
            while (i9 > 0) {
                if (L() == 0) {
                    M();
                }
                int iMin = Math.min(i9, (int) L());
                long j7 = iMin;
                z0.p(this.f12689r, bArr, (i8 - i9) + i7, j7);
                i9 -= iMin;
                this.f12689r += j7;
            }
        }

        public int P() {
            if (L() < 4) {
                return (N() & 255) | ((N() & 255) << 8) | ((N() & 255) << 16) | ((N() & 255) << 24);
            }
            long j7 = this.f12689r;
            this.f12689r = 4 + j7;
            return ((z0.w(j7 + 3) & 255) << 24) | (z0.w(j7) & 255) | ((z0.w(1 + j7) & 255) << 8) | ((z0.w(2 + j7) & 255) << 16);
        }

        public long Q() throws D {
            long jN;
            byte bN;
            if (L() >= 8) {
                long j7 = this.f12689r;
                this.f12689r = 8 + j7;
                jN = (((long) z0.w(j7)) & 255) | ((((long) z0.w(1 + j7)) & 255) << 8) | ((((long) z0.w(2 + j7)) & 255) << 16) | ((((long) z0.w(3 + j7)) & 255) << 24) | ((((long) z0.w(4 + j7)) & 255) << 32) | ((((long) z0.w(5 + j7)) & 255) << 40) | ((((long) z0.w(6 + j7)) & 255) << 48);
                bN = z0.w(j7 + 7);
            } else {
                jN = (((long) N()) & 255) | ((((long) N()) & 255) << 8) | ((((long) N()) & 255) << 16) | ((((long) N()) & 255) << 24) | ((((long) N()) & 255) << 32) | ((((long) N()) & 255) << 40) | ((((long) N()) & 255) << 48);
                bN = N();
            }
            return ((((long) bN) & 255) << 56) | jN;
        }

        public int R() {
            int i7;
            long j7 = this.f12689r;
            if (this.f12692u != j7) {
                long j8 = j7 + 1;
                byte bW = z0.w(j7);
                if (bW >= 0) {
                    this.f12689r++;
                    return bW;
                }
                if (this.f12692u - this.f12689r >= 10) {
                    long j9 = 2 + j7;
                    int iW = (z0.w(j8) << 7) ^ bW;
                    if (iW < 0) {
                        i7 = iW ^ (-128);
                    } else {
                        long j10 = 3 + j7;
                        int iW2 = (z0.w(j9) << 14) ^ iW;
                        if (iW2 >= 0) {
                            i7 = iW2 ^ 16256;
                        } else {
                            long j11 = 4 + j7;
                            int iW3 = iW2 ^ (z0.w(j10) << 21);
                            if (iW3 < 0) {
                                i7 = (-2080896) ^ iW3;
                            } else {
                                j10 = 5 + j7;
                                byte bW2 = z0.w(j11);
                                int i8 = (iW3 ^ (bW2 << 28)) ^ 266354560;
                                if (bW2 < 0) {
                                    j11 = 6 + j7;
                                    if (z0.w(j10) < 0) {
                                        j10 = 7 + j7;
                                        if (z0.w(j11) < 0) {
                                            j11 = 8 + j7;
                                            if (z0.w(j10) < 0) {
                                                j10 = 9 + j7;
                                                if (z0.w(j11) < 0) {
                                                    long j12 = j7 + 10;
                                                    if (z0.w(j10) >= 0) {
                                                        i7 = i8;
                                                        j9 = j12;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i7 = i8;
                                }
                                i7 = i8;
                            }
                            j9 = j11;
                        }
                        j9 = j10;
                    }
                    this.f12689r = j9;
                    return i7;
                }
            }
            return (int) T();
        }

        public long S() {
            long j7;
            long j8;
            long j9;
            long j10 = this.f12689r;
            if (this.f12692u != j10) {
                long j11 = j10 + 1;
                byte bW = z0.w(j10);
                if (bW >= 0) {
                    this.f12689r++;
                    return bW;
                }
                if (this.f12692u - this.f12689r >= 10) {
                    long j12 = 2 + j10;
                    int iW = (z0.w(j11) << 7) ^ bW;
                    if (iW < 0) {
                        j7 = iW ^ (-128);
                    } else {
                        long j13 = 3 + j10;
                        int iW2 = (z0.w(j12) << 14) ^ iW;
                        if (iW2 >= 0) {
                            j7 = iW2 ^ 16256;
                            j12 = j13;
                        } else {
                            long j14 = 4 + j10;
                            int iW3 = iW2 ^ (z0.w(j13) << 21);
                            if (iW3 < 0) {
                                j7 = (-2080896) ^ iW3;
                                j12 = j14;
                            } else {
                                long j15 = 5 + j10;
                                long jW = (((long) z0.w(j14)) << 28) ^ ((long) iW3);
                                if (jW >= 0) {
                                    j9 = 266354560;
                                } else {
                                    long j16 = 6 + j10;
                                    long jW2 = jW ^ (((long) z0.w(j15)) << 35);
                                    if (jW2 < 0) {
                                        j8 = -34093383808L;
                                    } else {
                                        j15 = 7 + j10;
                                        jW = jW2 ^ (((long) z0.w(j16)) << 42);
                                        if (jW >= 0) {
                                            j9 = 4363953127296L;
                                        } else {
                                            j16 = 8 + j10;
                                            jW2 = jW ^ (((long) z0.w(j15)) << 49);
                                            if (jW2 < 0) {
                                                j8 = -558586000294016L;
                                            } else {
                                                j15 = 9 + j10;
                                                long jW3 = (jW2 ^ (((long) z0.w(j16)) << 56)) ^ 71499008037633920L;
                                                if (jW3 < 0) {
                                                    long j17 = j10 + 10;
                                                    if (z0.w(j15) >= 0) {
                                                        j7 = jW3;
                                                        j12 = j17;
                                                    }
                                                } else {
                                                    j7 = jW3;
                                                    j12 = j15;
                                                }
                                            }
                                        }
                                    }
                                    j7 = j8 ^ jW2;
                                    j12 = j16;
                                }
                                j7 = j9 ^ jW;
                                j12 = j15;
                            }
                        }
                    }
                    this.f12689r = j12;
                    return j7;
                }
            }
            return T();
        }

        public long T() throws D {
            long j7 = 0;
            for (int i7 = 0; i7 < 64; i7 += 7) {
                byte bN = N();
                j7 |= ((long) (bN & 127)) << i7;
                if ((bN & 128) == 0) {
                    return j7;
                }
            }
            throw D.f();
        }

        public final int V() {
            return (int) ((((long) (this.f12683l - this.f12687p)) - this.f12689r) + this.f12690s);
        }

        public void W(int i7) throws D {
            if (i7 < 0 || i7 > (((long) (this.f12683l - this.f12687p)) - this.f12689r) + this.f12690s) {
                if (i7 >= 0) {
                    throw D.m();
                }
                throw D.g();
            }
            while (i7 > 0) {
                if (L() == 0) {
                    M();
                }
                int iMin = Math.min(i7, (int) L());
                i7 -= iMin;
                this.f12689r += (long) iMin;
            }
        }

        public final ByteBuffer Y(int i7, int i8) {
            int iPosition = this.f12680i.position();
            int iLimit = this.f12680i.limit();
            ByteBuffer byteBuffer = this.f12680i;
            try {
                try {
                    byteBuffer.position(i7);
                    byteBuffer.limit(i8);
                    return this.f12680i.slice();
                } catch (IllegalArgumentException unused) {
                    throw D.m();
                }
            } finally {
                byteBuffer.position(iPosition);
                byteBuffer.limit(iLimit);
            }
        }

        public final void Z() {
            ByteBuffer byteBuffer = (ByteBuffer) this.f12679h.next();
            this.f12680i = byteBuffer;
            this.f12687p += (int) (this.f12689r - this.f12690s);
            long jPosition = byteBuffer.position();
            this.f12689r = jPosition;
            this.f12690s = jPosition;
            this.f12692u = this.f12680i.limit();
            long jK = z0.k(this.f12680i);
            this.f12691t = jK;
            this.f12689r += jK;
            this.f12690s += jK;
            this.f12692u += jK;
        }

        @Override // com.google.protobuf.AbstractC1241j
        public void a(int i7) throws D {
            if (this.f12686o != i7) {
                throw D.b();
            }
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int e() {
            return (int) ((((long) (this.f12687p - this.f12688q)) + this.f12689r) - this.f12690s);
        }

        @Override // com.google.protobuf.AbstractC1241j
        public boolean f() {
            return (((long) this.f12687p) + this.f12689r) - this.f12690s == ((long) this.f12683l);
        }

        @Override // com.google.protobuf.AbstractC1241j
        public void n(int i7) {
            this.f12685n = i7;
            U();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int o(int i7) throws D {
            if (i7 < 0) {
                throw D.g();
            }
            int iE = i7 + e();
            int i8 = this.f12685n;
            if (iE > i8) {
                throw D.m();
            }
            this.f12685n = iE;
            U();
            return i8;
        }

        @Override // com.google.protobuf.AbstractC1241j
        public boolean p() {
            return S() != 0;
        }

        @Override // com.google.protobuf.AbstractC1241j
        public AbstractC1240i q() throws D {
            int iR = R();
            if (iR > 0) {
                long j7 = iR;
                long j8 = this.f12692u;
                long j9 = this.f12689r;
                if (j7 <= j8 - j9) {
                    if (this.f12681j && this.f12682k) {
                        int i7 = (int) (j9 - this.f12691t);
                        AbstractC1240i abstractC1240iL = AbstractC1240i.L(Y(i7, iR + i7));
                        this.f12689r += j7;
                        return abstractC1240iL;
                    }
                    byte[] bArr = new byte[iR];
                    z0.p(j9, bArr, 0L, j7);
                    this.f12689r += j7;
                    return AbstractC1240i.M(bArr);
                }
            }
            if (iR <= 0 || iR > V()) {
                if (iR == 0) {
                    return AbstractC1240i.f12650b;
                }
                if (iR < 0) {
                    throw D.g();
                }
                throw D.m();
            }
            if (!this.f12681j || !this.f12682k) {
                byte[] bArr2 = new byte[iR];
                O(bArr2, 0, iR);
                return AbstractC1240i.M(bArr2);
            }
            ArrayList arrayList = new ArrayList();
            while (iR > 0) {
                if (L() == 0) {
                    M();
                }
                int iMin = Math.min(iR, (int) L());
                int i8 = (int) (this.f12689r - this.f12691t);
                arrayList.add(AbstractC1240i.L(Y(i8, i8 + iMin)));
                iR -= iMin;
                this.f12689r += (long) iMin;
            }
            return AbstractC1240i.l(arrayList);
        }

        @Override // com.google.protobuf.AbstractC1241j
        public double r() {
            return Double.longBitsToDouble(Q());
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int s() {
            return R();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int t() {
            return P();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public long u() {
            return Q();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public float v() {
            return Float.intBitsToFloat(P());
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int w() {
            return R();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public long x() {
            return S();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int y() {
            return P();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public long z() {
            return Q();
        }

        public c(Iterable iterable, int i7, boolean z7) {
            super();
            this.f12685n = a.e.API_PRIORITY_OTHER;
            this.f12683l = i7;
            this.f12678g = iterable;
            this.f12679h = iterable.iterator();
            this.f12681j = z7;
            this.f12687p = 0;
            this.f12688q = 0;
            if (i7 != 0) {
                Z();
                return;
            }
            this.f12680i = C.f12549e;
            this.f12689r = 0L;
            this.f12690s = 0L;
            this.f12692u = 0L;
            this.f12691t = 0L;
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.j$d */
    public static final class d extends AbstractC1241j {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final InputStream f12693g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final byte[] f12694h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f12695i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f12696j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f12697k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f12698l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f12699m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f12700n;

        public static int L(InputStream inputStream) throws D {
            try {
                return inputStream.available();
            } catch (D e7) {
                e7.j();
                throw e7;
            }
        }

        public static int M(InputStream inputStream, byte[] bArr, int i7, int i8) throws D {
            try {
                return inputStream.read(bArr, i7, i8);
            } catch (D e7) {
                e7.j();
                throw e7;
            }
        }

        private void X() {
            int i7 = this.f12695i + this.f12696j;
            this.f12695i = i7;
            int i8 = this.f12699m + i7;
            int i9 = this.f12700n;
            if (i8 <= i9) {
                this.f12696j = 0;
                return;
            }
            int i10 = i8 - i9;
            this.f12696j = i10;
            this.f12695i = i7 - i10;
        }

        public static long Z(InputStream inputStream, long j7) throws D {
            try {
                return inputStream.skip(j7);
            } catch (D e7) {
                e7.j();
                throw e7;
            }
        }

        private void c0() throws D {
            if (this.f12695i - this.f12697k >= 10) {
                d0();
            } else {
                e0();
            }
        }

        private void d0() throws D {
            for (int i7 = 0; i7 < 10; i7++) {
                byte[] bArr = this.f12694h;
                int i8 = this.f12697k;
                this.f12697k = i8 + 1;
                if (bArr[i8] >= 0) {
                    return;
                }
            }
            throw D.f();
        }

        private void e0() throws D {
            for (int i7 = 0; i7 < 10; i7++) {
                if (O() >= 0) {
                    return;
                }
            }
            throw D.f();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int A() {
            return AbstractC1241j.c(U());
        }

        @Override // com.google.protobuf.AbstractC1241j
        public long B() {
            return AbstractC1241j.d(V());
        }

        @Override // com.google.protobuf.AbstractC1241j
        public String C() throws D {
            int iU = U();
            if (iU > 0) {
                int i7 = this.f12695i;
                int i8 = this.f12697k;
                if (iU <= i7 - i8) {
                    String str = new String(this.f12694h, i8, iU, C.f12546b);
                    this.f12697k += iU;
                    return str;
                }
            }
            if (iU == 0) {
                return "";
            }
            if (iU < 0) {
                throw D.g();
            }
            if (iU > this.f12695i) {
                return new String(P(iU, false), C.f12546b);
            }
            Y(iU);
            String str2 = new String(this.f12694h, this.f12697k, iU, C.f12546b);
            this.f12697k += iU;
            return str2;
        }

        @Override // com.google.protobuf.AbstractC1241j
        public String D() throws IOException {
            byte[] bArrP;
            int iU = U();
            int i7 = this.f12697k;
            int i8 = this.f12695i;
            if (iU <= i8 - i7 && iU > 0) {
                bArrP = this.f12694h;
                this.f12697k = i7 + iU;
            } else {
                if (iU == 0) {
                    return "";
                }
                if (iU < 0) {
                    throw D.g();
                }
                i7 = 0;
                if (iU <= i8) {
                    Y(iU);
                    bArrP = this.f12694h;
                    this.f12697k = iU;
                } else {
                    bArrP = P(iU, false);
                }
            }
            return A0.h(bArrP, i7, iU);
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int E() throws D {
            if (f()) {
                this.f12698l = 0;
                return 0;
            }
            int iU = U();
            this.f12698l = iU;
            if (B0.a(iU) != 0) {
                return this.f12698l;
            }
            throw D.c();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int F() {
            return U();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public long G() {
            return V();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public boolean J(int i7) throws D {
            int iB = B0.b(i7);
            if (iB == 0) {
                c0();
                return true;
            }
            if (iB == 1) {
                a0(8);
                return true;
            }
            if (iB == 2) {
                a0(U());
                return true;
            }
            if (iB == 3) {
                K();
                a(B0.c(B0.a(i7), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw D.e();
            }
            a0(4);
            return true;
        }

        public final AbstractC1240i N(int i7) throws IOException {
            byte[] bArrQ = Q(i7);
            if (bArrQ != null) {
                return AbstractC1240i.m(bArrQ);
            }
            int i8 = this.f12697k;
            int i9 = this.f12695i;
            int length = i9 - i8;
            this.f12699m += i9;
            this.f12697k = 0;
            this.f12695i = 0;
            List<byte[]> listR = R(i7 - length);
            byte[] bArr = new byte[i7];
            System.arraycopy(this.f12694h, i8, bArr, 0, length);
            for (byte[] bArr2 : listR) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return AbstractC1240i.M(bArr);
        }

        public byte O() throws D {
            if (this.f12697k == this.f12695i) {
                Y(1);
            }
            byte[] bArr = this.f12694h;
            int i7 = this.f12697k;
            this.f12697k = i7 + 1;
            return bArr[i7];
        }

        public final byte[] P(int i7, boolean z7) throws IOException {
            byte[] bArrQ = Q(i7);
            if (bArrQ != null) {
                return z7 ? (byte[]) bArrQ.clone() : bArrQ;
            }
            int i8 = this.f12697k;
            int i9 = this.f12695i;
            int length = i9 - i8;
            this.f12699m += i9;
            this.f12697k = 0;
            this.f12695i = 0;
            List<byte[]> listR = R(i7 - length);
            byte[] bArr = new byte[i7];
            System.arraycopy(this.f12694h, i8, bArr, 0, length);
            for (byte[] bArr2 : listR) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return bArr;
        }

        public final byte[] Q(int i7) throws D {
            if (i7 == 0) {
                return C.f12548d;
            }
            if (i7 < 0) {
                throw D.g();
            }
            int i8 = this.f12699m;
            int i9 = this.f12697k;
            int i10 = i8 + i9 + i7;
            if (i10 - this.f12666c > 0) {
                throw D.l();
            }
            int i11 = this.f12700n;
            if (i10 > i11) {
                a0((i11 - i8) - i9);
                throw D.m();
            }
            int i12 = this.f12695i - i9;
            int i13 = i7 - i12;
            if (i13 >= 4096 && i13 > L(this.f12693g)) {
                return null;
            }
            byte[] bArr = new byte[i7];
            System.arraycopy(this.f12694h, this.f12697k, bArr, 0, i12);
            this.f12699m += this.f12695i;
            this.f12697k = 0;
            this.f12695i = 0;
            while (i12 < i7) {
                int iM = M(this.f12693g, bArr, i12, i7 - i12);
                if (iM == -1) {
                    throw D.m();
                }
                this.f12699m += iM;
                i12 += iM;
            }
            return bArr;
        }

        public final List R(int i7) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i7 > 0) {
                int iMin = Math.min(i7, 4096);
                byte[] bArr = new byte[iMin];
                int i8 = 0;
                while (i8 < iMin) {
                    int i9 = this.f12693g.read(bArr, i8, iMin - i8);
                    if (i9 == -1) {
                        throw D.m();
                    }
                    this.f12699m += i9;
                    i8 += i9;
                }
                i7 -= iMin;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        public int S() throws D {
            int i7 = this.f12697k;
            if (this.f12695i - i7 < 4) {
                Y(4);
                i7 = this.f12697k;
            }
            byte[] bArr = this.f12694h;
            this.f12697k = i7 + 4;
            return ((bArr[i7 + 3] & 255) << 24) | (bArr[i7] & 255) | ((bArr[i7 + 1] & 255) << 8) | ((bArr[i7 + 2] & 255) << 16);
        }

        public long T() throws D {
            int i7 = this.f12697k;
            if (this.f12695i - i7 < 8) {
                Y(8);
                i7 = this.f12697k;
            }
            byte[] bArr = this.f12694h;
            this.f12697k = i7 + 8;
            return ((((long) bArr[i7 + 7]) & 255) << 56) | (((long) bArr[i7]) & 255) | ((((long) bArr[i7 + 1]) & 255) << 8) | ((((long) bArr[i7 + 2]) & 255) << 16) | ((((long) bArr[i7 + 3]) & 255) << 24) | ((((long) bArr[i7 + 4]) & 255) << 32) | ((((long) bArr[i7 + 5]) & 255) << 40) | ((((long) bArr[i7 + 6]) & 255) << 48);
        }

        public int U() {
            int i7;
            int i8 = this.f12697k;
            int i9 = this.f12695i;
            if (i9 != i8) {
                byte[] bArr = this.f12694h;
                int i10 = i8 + 1;
                byte b7 = bArr[i8];
                if (b7 >= 0) {
                    this.f12697k = i10;
                    return b7;
                }
                if (i9 - i10 >= 9) {
                    int i11 = i8 + 2;
                    int i12 = (bArr[i10] << 7) ^ b7;
                    if (i12 < 0) {
                        i7 = i12 ^ (-128);
                    } else {
                        int i13 = i8 + 3;
                        int i14 = (bArr[i11] << 14) ^ i12;
                        if (i14 >= 0) {
                            i7 = i14 ^ 16256;
                        } else {
                            int i15 = i8 + 4;
                            int i16 = i14 ^ (bArr[i13] << 21);
                            if (i16 < 0) {
                                i7 = (-2080896) ^ i16;
                            } else {
                                i13 = i8 + 5;
                                byte b8 = bArr[i15];
                                int i17 = (i16 ^ (b8 << 28)) ^ 266354560;
                                if (b8 < 0) {
                                    i15 = i8 + 6;
                                    if (bArr[i13] < 0) {
                                        i13 = i8 + 7;
                                        if (bArr[i15] < 0) {
                                            i15 = i8 + 8;
                                            if (bArr[i13] < 0) {
                                                i13 = i8 + 9;
                                                if (bArr[i15] < 0) {
                                                    int i18 = i8 + 10;
                                                    if (bArr[i13] >= 0) {
                                                        i11 = i18;
                                                        i7 = i17;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i7 = i17;
                                }
                                i7 = i17;
                            }
                            i11 = i15;
                        }
                        i11 = i13;
                    }
                    this.f12697k = i11;
                    return i7;
                }
            }
            return (int) W();
        }

        public long V() {
            long j7;
            long j8;
            long j9;
            int i7 = this.f12697k;
            int i8 = this.f12695i;
            if (i8 != i7) {
                byte[] bArr = this.f12694h;
                int i9 = i7 + 1;
                byte b7 = bArr[i7];
                if (b7 >= 0) {
                    this.f12697k = i9;
                    return b7;
                }
                if (i8 - i9 >= 9) {
                    int i10 = i7 + 2;
                    int i11 = (bArr[i9] << 7) ^ b7;
                    if (i11 < 0) {
                        j7 = i11 ^ (-128);
                    } else {
                        int i12 = i7 + 3;
                        int i13 = (bArr[i10] << 14) ^ i11;
                        if (i13 >= 0) {
                            j7 = i13 ^ 16256;
                            i10 = i12;
                        } else {
                            int i14 = i7 + 4;
                            int i15 = i13 ^ (bArr[i12] << 21);
                            if (i15 < 0) {
                                long j10 = (-2080896) ^ i15;
                                i10 = i14;
                                j7 = j10;
                            } else {
                                long j11 = i15;
                                i10 = i7 + 5;
                                long j12 = j11 ^ (((long) bArr[i14]) << 28);
                                if (j12 >= 0) {
                                    j9 = 266354560;
                                } else {
                                    int i16 = i7 + 6;
                                    long j13 = j12 ^ (((long) bArr[i10]) << 35);
                                    if (j13 < 0) {
                                        j8 = -34093383808L;
                                    } else {
                                        i10 = i7 + 7;
                                        j12 = j13 ^ (((long) bArr[i16]) << 42);
                                        if (j12 >= 0) {
                                            j9 = 4363953127296L;
                                        } else {
                                            i16 = i7 + 8;
                                            j13 = j12 ^ (((long) bArr[i10]) << 49);
                                            if (j13 < 0) {
                                                j8 = -558586000294016L;
                                            } else {
                                                i10 = i7 + 9;
                                                long j14 = (j13 ^ (((long) bArr[i16]) << 56)) ^ 71499008037633920L;
                                                if (j14 < 0) {
                                                    int i17 = i7 + 10;
                                                    if (bArr[i10] >= 0) {
                                                        i10 = i17;
                                                    }
                                                }
                                                j7 = j14;
                                            }
                                        }
                                    }
                                    j7 = j13 ^ j8;
                                    i10 = i16;
                                }
                                j7 = j12 ^ j9;
                            }
                        }
                    }
                    this.f12697k = i10;
                    return j7;
                }
            }
            return W();
        }

        public long W() throws D {
            long j7 = 0;
            for (int i7 = 0; i7 < 64; i7 += 7) {
                byte bO = O();
                j7 |= ((long) (bO & 127)) << i7;
                if ((bO & 128) == 0) {
                    return j7;
                }
            }
            throw D.f();
        }

        public final void Y(int i7) throws D {
            if (f0(i7)) {
                return;
            }
            if (i7 <= (this.f12666c - this.f12699m) - this.f12697k) {
                throw D.m();
            }
            throw D.l();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public void a(int i7) throws D {
            if (this.f12698l != i7) {
                throw D.b();
            }
        }

        public void a0(int i7) throws D {
            int i8 = this.f12695i;
            int i9 = this.f12697k;
            if (i7 > i8 - i9 || i7 < 0) {
                b0(i7);
            } else {
                this.f12697k = i9 + i7;
            }
        }

        public final void b0(int i7) throws D {
            if (i7 < 0) {
                throw D.g();
            }
            int i8 = this.f12699m;
            int i9 = this.f12697k;
            int i10 = i8 + i9 + i7;
            int i11 = this.f12700n;
            if (i10 > i11) {
                a0((i11 - i8) - i9);
                throw D.m();
            }
            this.f12699m = i8 + i9;
            int i12 = this.f12695i - i9;
            this.f12695i = 0;
            this.f12697k = 0;
            while (i12 < i7) {
                try {
                    long j7 = i7 - i12;
                    long jZ = Z(this.f12693g, j7);
                    if (jZ < 0 || jZ > j7) {
                        throw new IllegalStateException(this.f12693g.getClass() + "#skip returned invalid result: " + jZ + "\nThe InputStream implementation is buggy.");
                    }
                    if (jZ == 0) {
                        break;
                    } else {
                        i12 += (int) jZ;
                    }
                } finally {
                    this.f12699m += i12;
                    X();
                }
            }
            if (i12 >= i7) {
                return;
            }
            int i13 = this.f12695i;
            int i14 = i13 - this.f12697k;
            this.f12697k = i13;
            Y(1);
            while (true) {
                int i15 = i7 - i14;
                int i16 = this.f12695i;
                if (i15 <= i16) {
                    this.f12697k = i15;
                    return;
                } else {
                    i14 += i16;
                    this.f12697k = i16;
                    Y(1);
                }
            }
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int e() {
            return this.f12699m + this.f12697k;
        }

        @Override // com.google.protobuf.AbstractC1241j
        public boolean f() {
            return this.f12697k == this.f12695i && !f0(1);
        }

        public final boolean f0(int i7) throws D {
            int i8 = this.f12697k;
            int i9 = i8 + i7;
            int i10 = this.f12695i;
            if (i9 <= i10) {
                throw new IllegalStateException("refillBuffer() called when " + i7 + " bytes were already available in buffer");
            }
            int i11 = this.f12666c;
            int i12 = this.f12699m;
            if (i7 > (i11 - i12) - i8 || i12 + i8 + i7 > this.f12700n) {
                return false;
            }
            if (i8 > 0) {
                if (i10 > i8) {
                    byte[] bArr = this.f12694h;
                    System.arraycopy(bArr, i8, bArr, 0, i10 - i8);
                }
                this.f12699m += i8;
                this.f12695i -= i8;
                this.f12697k = 0;
            }
            InputStream inputStream = this.f12693g;
            byte[] bArr2 = this.f12694h;
            int i13 = this.f12695i;
            int iM = M(inputStream, bArr2, i13, Math.min(bArr2.length - i13, (this.f12666c - this.f12699m) - i13));
            if (iM == 0 || iM < -1 || iM > this.f12694h.length) {
                throw new IllegalStateException(this.f12693g.getClass() + "#read(byte[]) returned invalid result: " + iM + "\nThe InputStream implementation is buggy.");
            }
            if (iM <= 0) {
                return false;
            }
            this.f12695i += iM;
            X();
            if (this.f12695i >= i7) {
                return true;
            }
            return f0(i7);
        }

        @Override // com.google.protobuf.AbstractC1241j
        public void n(int i7) {
            this.f12700n = i7;
            X();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int o(int i7) throws D {
            if (i7 < 0) {
                throw D.g();
            }
            int i8 = i7 + this.f12699m + this.f12697k;
            int i9 = this.f12700n;
            if (i8 > i9) {
                throw D.m();
            }
            this.f12700n = i8;
            X();
            return i9;
        }

        @Override // com.google.protobuf.AbstractC1241j
        public boolean p() {
            return V() != 0;
        }

        @Override // com.google.protobuf.AbstractC1241j
        public AbstractC1240i q() throws D {
            int iU = U();
            int i7 = this.f12695i;
            int i8 = this.f12697k;
            if (iU <= i7 - i8 && iU > 0) {
                AbstractC1240i abstractC1240iN = AbstractC1240i.n(this.f12694h, i8, iU);
                this.f12697k += iU;
                return abstractC1240iN;
            }
            if (iU == 0) {
                return AbstractC1240i.f12650b;
            }
            if (iU >= 0) {
                return N(iU);
            }
            throw D.g();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public double r() {
            return Double.longBitsToDouble(T());
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int s() {
            return U();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int t() {
            return S();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public long u() {
            return T();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public float v() {
            return Float.intBitsToFloat(S());
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int w() {
            return U();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public long x() {
            return V();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int y() {
            return S();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public long z() {
            return T();
        }

        public d(InputStream inputStream, int i7) {
            super();
            this.f12700n = a.e.API_PRIORITY_OTHER;
            C.b(inputStream, "input");
            this.f12693g = inputStream;
            this.f12694h = new byte[i7];
            this.f12695i = 0;
            this.f12697k = 0;
            this.f12699m = 0;
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.j$e */
    public static final class e extends AbstractC1241j {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final ByteBuffer f12701g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f12702h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f12703i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f12704j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f12705k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f12706l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f12707m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f12708n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f12709o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f12710p;

        public static boolean M() {
            return z0.J();
        }

        private void T() {
            long j7 = this.f12704j + ((long) this.f12707m);
            this.f12704j = j7;
            int i7 = (int) (j7 - this.f12706l);
            int i8 = this.f12710p;
            if (i7 <= i8) {
                this.f12707m = 0;
                return;
            }
            int i9 = i7 - i8;
            this.f12707m = i9;
            this.f12704j = j7 - ((long) i9);
        }

        private int U() {
            return (int) (this.f12704j - this.f12705k);
        }

        private void W() throws D {
            if (U() >= 10) {
                X();
            } else {
                Y();
            }
        }

        private void X() throws D {
            for (int i7 = 0; i7 < 10; i7++) {
                long j7 = this.f12705k;
                this.f12705k = 1 + j7;
                if (z0.w(j7) >= 0) {
                    return;
                }
            }
            throw D.f();
        }

        private void Y() throws D {
            for (int i7 = 0; i7 < 10; i7++) {
                if (N() >= 0) {
                    return;
                }
            }
            throw D.f();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int A() {
            return AbstractC1241j.c(Q());
        }

        @Override // com.google.protobuf.AbstractC1241j
        public long B() {
            return AbstractC1241j.d(R());
        }

        @Override // com.google.protobuf.AbstractC1241j
        public String C() throws D {
            int iQ = Q();
            if (iQ <= 0 || iQ > U()) {
                if (iQ == 0) {
                    return "";
                }
                if (iQ < 0) {
                    throw D.g();
                }
                throw D.m();
            }
            byte[] bArr = new byte[iQ];
            long j7 = iQ;
            z0.p(this.f12705k, bArr, 0L, j7);
            String str = new String(bArr, C.f12546b);
            this.f12705k += j7;
            return str;
        }

        @Override // com.google.protobuf.AbstractC1241j
        public String D() throws D {
            int iQ = Q();
            if (iQ > 0 && iQ <= U()) {
                String strG = A0.g(this.f12701g, L(this.f12705k), iQ);
                this.f12705k += (long) iQ;
                return strG;
            }
            if (iQ == 0) {
                return "";
            }
            if (iQ <= 0) {
                throw D.g();
            }
            throw D.m();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int E() throws D {
            if (f()) {
                this.f12708n = 0;
                return 0;
            }
            int iQ = Q();
            this.f12708n = iQ;
            if (B0.a(iQ) != 0) {
                return this.f12708n;
            }
            throw D.c();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int F() {
            return Q();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public long G() {
            return R();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public boolean J(int i7) throws D {
            int iB = B0.b(i7);
            if (iB == 0) {
                W();
                return true;
            }
            if (iB == 1) {
                V(8);
                return true;
            }
            if (iB == 2) {
                V(Q());
                return true;
            }
            if (iB == 3) {
                K();
                a(B0.c(B0.a(i7), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw D.e();
            }
            V(4);
            return true;
        }

        public final int L(long j7) {
            return (int) (j7 - this.f12703i);
        }

        public byte N() throws D {
            long j7 = this.f12705k;
            if (j7 == this.f12704j) {
                throw D.m();
            }
            this.f12705k = 1 + j7;
            return z0.w(j7);
        }

        public int O() throws D {
            long j7 = this.f12705k;
            if (this.f12704j - j7 < 4) {
                throw D.m();
            }
            this.f12705k = 4 + j7;
            return ((z0.w(j7 + 3) & 255) << 24) | (z0.w(j7) & 255) | ((z0.w(1 + j7) & 255) << 8) | ((z0.w(2 + j7) & 255) << 16);
        }

        public long P() throws D {
            long j7 = this.f12705k;
            if (this.f12704j - j7 < 8) {
                throw D.m();
            }
            this.f12705k = 8 + j7;
            return ((((long) z0.w(j7 + 7)) & 255) << 56) | (((long) z0.w(j7)) & 255) | ((((long) z0.w(1 + j7)) & 255) << 8) | ((((long) z0.w(2 + j7)) & 255) << 16) | ((((long) z0.w(3 + j7)) & 255) << 24) | ((((long) z0.w(4 + j7)) & 255) << 32) | ((((long) z0.w(5 + j7)) & 255) << 40) | ((((long) z0.w(6 + j7)) & 255) << 48);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x008c, code lost:
        
            if (com.google.protobuf.z0.w(r3) < 0) goto L34;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int Q() {
            /*
                r9 = this;
                long r0 = r9.f12705k
                long r2 = r9.f12704j
                int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r2 != 0) goto La
                goto L8e
            La:
                r2 = 1
                long r2 = r2 + r0
                byte r4 = com.google.protobuf.z0.w(r0)
                if (r4 < 0) goto L16
                r9.f12705k = r2
                return r4
            L16:
                long r5 = r9.f12704j
                long r5 = r5 - r2
                r7 = 9
                int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r5 >= 0) goto L21
                goto L8e
            L21:
                r5 = 2
                long r5 = r5 + r0
                byte r2 = com.google.protobuf.z0.w(r2)
                int r2 = r2 << 7
                r2 = r2 ^ r4
                if (r2 >= 0) goto L31
                r0 = r2 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L98
            L31:
                r3 = 3
                long r3 = r3 + r0
                byte r5 = com.google.protobuf.z0.w(r5)
                int r5 = r5 << 14
                r2 = r2 ^ r5
                if (r2 < 0) goto L41
                r0 = r2 ^ 16256(0x3f80, float:2.278E-41)
            L3f:
                r5 = r3
                goto L98
            L41:
                r5 = 4
                long r5 = r5 + r0
                byte r3 = com.google.protobuf.z0.w(r3)
                int r3 = r3 << 21
                r2 = r2 ^ r3
                if (r2 >= 0) goto L52
                r0 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L98
            L52:
                r3 = 5
                long r3 = r3 + r0
                byte r5 = com.google.protobuf.z0.w(r5)
                int r6 = r5 << 28
                r2 = r2 ^ r6
                r6 = 266354560(0xfe03f80, float:2.2112565E-29)
                r2 = r2 ^ r6
                if (r5 >= 0) goto L96
                r5 = 6
                long r5 = r5 + r0
                byte r3 = com.google.protobuf.z0.w(r3)
                if (r3 >= 0) goto L94
                r3 = 7
                long r3 = r3 + r0
                byte r5 = com.google.protobuf.z0.w(r5)
                if (r5 >= 0) goto L96
                r5 = 8
                long r5 = r5 + r0
                byte r3 = com.google.protobuf.z0.w(r3)
                if (r3 >= 0) goto L94
                long r3 = r0 + r7
                byte r5 = com.google.protobuf.z0.w(r5)
                if (r5 >= 0) goto L96
                r5 = 10
                long r5 = r5 + r0
                byte r0 = com.google.protobuf.z0.w(r3)
                if (r0 >= 0) goto L94
            L8e:
                long r0 = r9.S()
                int r0 = (int) r0
                return r0
            L94:
                r0 = r2
                goto L98
            L96:
                r0 = r2
                goto L3f
            L98:
                r9.f12705k = r5
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.AbstractC1241j.e.Q():int");
        }

        public long R() {
            long j7;
            long j8;
            long j9;
            int i7;
            long j10 = this.f12705k;
            if (this.f12704j != j10) {
                long j11 = 1 + j10;
                byte bW = z0.w(j10);
                if (bW >= 0) {
                    this.f12705k = j11;
                    return bW;
                }
                if (this.f12704j - j11 >= 9) {
                    long j12 = 2 + j10;
                    int iW = (z0.w(j11) << 7) ^ bW;
                    if (iW >= 0) {
                        long j13 = 3 + j10;
                        int iW2 = iW ^ (z0.w(j12) << 14);
                        if (iW2 >= 0) {
                            j7 = iW2 ^ 16256;
                            j12 = j13;
                        } else {
                            j12 = 4 + j10;
                            int iW3 = iW2 ^ (z0.w(j13) << 21);
                            if (iW3 < 0) {
                                i7 = (-2080896) ^ iW3;
                            } else {
                                long j14 = 5 + j10;
                                long jW = ((long) iW3) ^ (((long) z0.w(j12)) << 28);
                                if (jW >= 0) {
                                    j9 = 266354560;
                                } else {
                                    long j15 = 6 + j10;
                                    long jW2 = jW ^ (((long) z0.w(j14)) << 35);
                                    if (jW2 < 0) {
                                        j8 = -34093383808L;
                                    } else {
                                        j14 = 7 + j10;
                                        jW = jW2 ^ (((long) z0.w(j15)) << 42);
                                        if (jW >= 0) {
                                            j9 = 4363953127296L;
                                        } else {
                                            j15 = 8 + j10;
                                            jW2 = jW ^ (((long) z0.w(j14)) << 49);
                                            if (jW2 < 0) {
                                                j8 = -558586000294016L;
                                            } else {
                                                long j16 = j10 + 9;
                                                long jW3 = (jW2 ^ (((long) z0.w(j15)) << 56)) ^ 71499008037633920L;
                                                if (jW3 < 0) {
                                                    long j17 = j10 + 10;
                                                    if (z0.w(j16) >= 0) {
                                                        j12 = j17;
                                                        j7 = jW3;
                                                    }
                                                } else {
                                                    j7 = jW3;
                                                    j12 = j16;
                                                }
                                            }
                                        }
                                    }
                                    j7 = j8 ^ jW2;
                                    j12 = j15;
                                }
                                j7 = j9 ^ jW;
                                j12 = j14;
                            }
                        }
                        this.f12705k = j12;
                        return j7;
                    }
                    i7 = iW ^ (-128);
                    j7 = i7;
                    this.f12705k = j12;
                    return j7;
                }
            }
            return S();
        }

        public long S() throws D {
            long j7 = 0;
            for (int i7 = 0; i7 < 64; i7 += 7) {
                byte bN = N();
                j7 |= ((long) (bN & 127)) << i7;
                if ((bN & 128) == 0) {
                    return j7;
                }
            }
            throw D.f();
        }

        public void V(int i7) throws D {
            if (i7 >= 0 && i7 <= U()) {
                this.f12705k += (long) i7;
            } else {
                if (i7 >= 0) {
                    throw D.m();
                }
                throw D.g();
            }
        }

        public final ByteBuffer Z(long j7, long j8) {
            int iPosition = this.f12701g.position();
            int iLimit = this.f12701g.limit();
            ByteBuffer byteBuffer = this.f12701g;
            try {
                try {
                    byteBuffer.position(L(j7));
                    byteBuffer.limit(L(j8));
                    return this.f12701g.slice();
                } catch (IllegalArgumentException e7) {
                    D dM = D.m();
                    dM.initCause(e7);
                    throw dM;
                }
            } finally {
                byteBuffer.position(iPosition);
                byteBuffer.limit(iLimit);
            }
        }

        @Override // com.google.protobuf.AbstractC1241j
        public void a(int i7) throws D {
            if (this.f12708n != i7) {
                throw D.b();
            }
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int e() {
            return (int) (this.f12705k - this.f12706l);
        }

        @Override // com.google.protobuf.AbstractC1241j
        public boolean f() {
            return this.f12705k == this.f12704j;
        }

        @Override // com.google.protobuf.AbstractC1241j
        public void n(int i7) {
            this.f12710p = i7;
            T();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int o(int i7) throws D {
            if (i7 < 0) {
                throw D.g();
            }
            int iE = i7 + e();
            int i8 = this.f12710p;
            if (iE > i8) {
                throw D.m();
            }
            this.f12710p = iE;
            T();
            return i8;
        }

        @Override // com.google.protobuf.AbstractC1241j
        public boolean p() {
            return R() != 0;
        }

        @Override // com.google.protobuf.AbstractC1241j
        public AbstractC1240i q() throws D {
            int iQ = Q();
            if (iQ <= 0 || iQ > U()) {
                if (iQ == 0) {
                    return AbstractC1240i.f12650b;
                }
                if (iQ < 0) {
                    throw D.g();
                }
                throw D.m();
            }
            if (this.f12702h && this.f12709o) {
                long j7 = this.f12705k;
                long j8 = iQ;
                ByteBuffer byteBufferZ = Z(j7, j7 + j8);
                this.f12705k += j8;
                return AbstractC1240i.L(byteBufferZ);
            }
            byte[] bArr = new byte[iQ];
            long j9 = iQ;
            z0.p(this.f12705k, bArr, 0L, j9);
            this.f12705k += j9;
            return AbstractC1240i.M(bArr);
        }

        @Override // com.google.protobuf.AbstractC1241j
        public double r() {
            return Double.longBitsToDouble(P());
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int s() {
            return Q();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int t() {
            return O();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public long u() {
            return P();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public float v() {
            return Float.intBitsToFloat(O());
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int w() {
            return Q();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public long x() {
            return R();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public int y() {
            return O();
        }

        @Override // com.google.protobuf.AbstractC1241j
        public long z() {
            return P();
        }

        public e(ByteBuffer byteBuffer, boolean z7) {
            super();
            this.f12710p = a.e.API_PRIORITY_OTHER;
            this.f12701g = byteBuffer;
            long jK = z0.k(byteBuffer);
            this.f12703i = jK;
            this.f12704j = ((long) byteBuffer.limit()) + jK;
            long jPosition = jK + ((long) byteBuffer.position());
            this.f12705k = jPosition;
            this.f12706l = jPosition;
            this.f12702h = z7;
        }
    }

    public static int c(int i7) {
        return (-(i7 & 1)) ^ (i7 >>> 1);
    }

    public static long d(long j7) {
        return (-(j7 & 1)) ^ (j7 >>> 1);
    }

    public static AbstractC1241j g(InputStream inputStream) {
        return h(inputStream, 4096);
    }

    public static AbstractC1241j h(InputStream inputStream, int i7) {
        if (i7 > 0) {
            return inputStream == null ? k(C.f12548d) : new d(inputStream, i7);
        }
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    public static AbstractC1241j i(Iterable iterable, boolean z7) {
        Iterator it = iterable.iterator();
        int i7 = 0;
        int iRemaining = 0;
        while (it.hasNext()) {
            ByteBuffer byteBuffer = (ByteBuffer) it.next();
            iRemaining += byteBuffer.remaining();
            i7 = byteBuffer.hasArray() ? i7 | 1 : byteBuffer.isDirect() ? i7 | 2 : i7 | 4;
        }
        return i7 == 2 ? new c(iterable, iRemaining, z7) : g(new E(iterable));
    }

    public static AbstractC1241j j(ByteBuffer byteBuffer, boolean z7) {
        if (byteBuffer.hasArray()) {
            return m(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), z7);
        }
        if (byteBuffer.isDirect() && e.M()) {
            return new e(byteBuffer, z7);
        }
        int iRemaining = byteBuffer.remaining();
        byte[] bArr = new byte[iRemaining];
        byteBuffer.duplicate().get(bArr);
        return m(bArr, 0, iRemaining, true);
    }

    public static AbstractC1241j k(byte[] bArr) {
        return l(bArr, 0, bArr.length);
    }

    public static AbstractC1241j l(byte[] bArr, int i7, int i8) {
        return m(bArr, i7, i8, false);
    }

    public static AbstractC1241j m(byte[] bArr, int i7, int i8, boolean z7) {
        b bVar = new b(bArr, i7, i8, z7);
        try {
            bVar.o(i8);
            return bVar;
        } catch (D e7) {
            throw new IllegalArgumentException(e7);
        }
    }

    public abstract int A();

    public abstract long B();

    public abstract String C();

    public abstract String D();

    public abstract int E();

    public abstract int F();

    public abstract long G();

    public final int H(int i7) {
        if (i7 >= 0) {
            int i8 = this.f12665b;
            this.f12665b = i7;
            return i8;
        }
        throw new IllegalArgumentException("Recursion limit cannot be negative: " + i7);
    }

    public final int I(int i7) {
        if (i7 >= 0) {
            int i8 = this.f12666c;
            this.f12666c = i7;
            return i8;
        }
        throw new IllegalArgumentException("Size limit cannot be negative: " + i7);
    }

    public abstract boolean J(int i7);

    public void K() throws D {
        int iE;
        do {
            iE = E();
            if (iE == 0) {
                return;
            }
            b();
            this.f12664a++;
            this.f12664a--;
        } while (J(iE));
    }

    public abstract void a(int i7);

    public void b() throws D {
        if (this.f12664a >= this.f12665b) {
            throw D.i();
        }
    }

    public abstract int e();

    public abstract boolean f();

    public abstract void n(int i7);

    public abstract int o(int i7);

    public abstract boolean p();

    public abstract AbstractC1240i q();

    public abstract double r();

    public abstract int s();

    public abstract int t();

    public abstract long u();

    public abstract float v();

    public abstract int w();

    public abstract long x();

    public abstract int y();

    public abstract long z();

    public AbstractC1241j() {
        this.f12665b = f12663f;
        this.f12666c = a.e.API_PRIORITY_OTHER;
        this.f12668e = false;
    }
}
