package com.google.protobuf;

import com.google.android.gms.common.api.a;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile int f7016f = 100;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7019c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k f7020d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f7021e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends j {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final byte[] f7022g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f7023h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f7024i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f7025j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f7026k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f7027l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f7028m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f7029n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f7030o;

        @Override // com.google.protobuf.j
        public int A() {
            return j.c(P());
        }

        @Override // com.google.protobuf.j
        public long B() {
            return j.d(Q());
        }

        @Override // com.google.protobuf.j
        public String C() throws d0 {
            int iP = P();
            if (iP > 0) {
                int i10 = this.f7024i;
                int i11 = this.f7026k;
                if (iP <= i10 - i11) {
                    String str = new String(this.f7022g, i11, iP, c0.f6944b);
                    this.f7026k += iP;
                    return str;
                }
            }
            if (iP == 0) {
                return "";
            }
            if (iP < 0) {
                throw d0.g();
            }
            throw d0.m();
        }

        @Override // com.google.protobuf.j
        public String D() throws d0 {
            int iP = P();
            if (iP > 0) {
                int i10 = this.f7024i;
                int i11 = this.f7026k;
                if (iP <= i10 - i11) {
                    String strH = z1.h(this.f7022g, i11, iP);
                    this.f7026k += iP;
                    return strH;
                }
            }
            if (iP == 0) {
                return "";
            }
            if (iP <= 0) {
                throw d0.g();
            }
            throw d0.m();
        }

        @Override // com.google.protobuf.j
        public int E() throws d0 {
            if (f()) {
                this.f7028m = 0;
                return 0;
            }
            int iP = P();
            this.f7028m = iP;
            if (a2.a(iP) != 0) {
                return this.f7028m;
            }
            throw d0.c();
        }

        @Override // com.google.protobuf.j
        public int F() {
            return P();
        }

        @Override // com.google.protobuf.j
        public long G() {
            return Q();
        }

        @Override // com.google.protobuf.j
        public boolean J(int i10) throws d0 {
            int iB = a2.b(i10);
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
                a(a2.c(a2.a(i10), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw d0.e();
            }
            T(4);
            return true;
        }

        public byte L() throws d0 {
            int i10 = this.f7026k;
            if (i10 == this.f7024i) {
                throw d0.m();
            }
            byte[] bArr = this.f7022g;
            this.f7026k = i10 + 1;
            return bArr[i10];
        }

        public byte[] M(int i10) throws d0 {
            if (i10 > 0) {
                int i11 = this.f7024i;
                int i12 = this.f7026k;
                if (i10 <= i11 - i12) {
                    int i13 = i10 + i12;
                    this.f7026k = i13;
                    return Arrays.copyOfRange(this.f7022g, i12, i13);
                }
            }
            if (i10 > 0) {
                throw d0.m();
            }
            if (i10 == 0) {
                return c0.f6946d;
            }
            throw d0.g();
        }

        public int N() throws d0 {
            int i10 = this.f7026k;
            if (this.f7024i - i10 < 4) {
                throw d0.m();
            }
            byte[] bArr = this.f7022g;
            this.f7026k = i10 + 4;
            return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
        }

        public long O() throws d0 {
            int i10 = this.f7026k;
            if (this.f7024i - i10 < 8) {
                throw d0.m();
            }
            byte[] bArr = this.f7022g;
            this.f7026k = i10 + 8;
            return ((((long) bArr[i10 + 7]) & 255) << 56) | (((long) bArr[i10]) & 255) | ((((long) bArr[i10 + 1]) & 255) << 8) | ((((long) bArr[i10 + 2]) & 255) << 16) | ((((long) bArr[i10 + 3]) & 255) << 24) | ((((long) bArr[i10 + 4]) & 255) << 32) | ((((long) bArr[i10 + 5]) & 255) << 40) | ((((long) bArr[i10 + 6]) & 255) << 48);
        }

        public int P() {
            int i10;
            int i11 = this.f7026k;
            int i12 = this.f7024i;
            if (i12 != i11) {
                byte[] bArr = this.f7022g;
                int i13 = i11 + 1;
                byte b10 = bArr[i11];
                if (b10 >= 0) {
                    this.f7026k = i13;
                    return b10;
                }
                if (i12 - i13 >= 9) {
                    int i14 = i11 + 2;
                    int i15 = (bArr[i13] << 7) ^ b10;
                    if (i15 < 0) {
                        i10 = i15 ^ (-128);
                    } else {
                        int i16 = i11 + 3;
                        int i17 = (bArr[i14] << 14) ^ i15;
                        if (i17 >= 0) {
                            i10 = i17 ^ 16256;
                        } else {
                            int i18 = i11 + 4;
                            int i19 = i17 ^ (bArr[i16] << 21);
                            if (i19 < 0) {
                                i10 = (-2080896) ^ i19;
                            } else {
                                i16 = i11 + 5;
                                byte b11 = bArr[i18];
                                int i20 = (i19 ^ (b11 << 28)) ^ 266354560;
                                if (b11 < 0) {
                                    i18 = i11 + 6;
                                    if (bArr[i16] < 0) {
                                        i16 = i11 + 7;
                                        if (bArr[i18] < 0) {
                                            i18 = i11 + 8;
                                            if (bArr[i16] < 0) {
                                                i16 = i11 + 9;
                                                if (bArr[i18] < 0) {
                                                    int i21 = i11 + 10;
                                                    if (bArr[i16] >= 0) {
                                                        i14 = i21;
                                                        i10 = i20;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i10 = i20;
                                }
                                i10 = i20;
                            }
                            i14 = i18;
                        }
                        i14 = i16;
                    }
                    this.f7026k = i14;
                    return i10;
                }
            }
            return (int) R();
        }

        public long Q() {
            long j10;
            long j11;
            long j12;
            int i10 = this.f7026k;
            int i11 = this.f7024i;
            if (i11 != i10) {
                byte[] bArr = this.f7022g;
                int i12 = i10 + 1;
                byte b10 = bArr[i10];
                if (b10 >= 0) {
                    this.f7026k = i12;
                    return b10;
                }
                if (i11 - i12 >= 9) {
                    int i13 = i10 + 2;
                    int i14 = (bArr[i12] << 7) ^ b10;
                    if (i14 < 0) {
                        j10 = i14 ^ (-128);
                    } else {
                        int i15 = i10 + 3;
                        int i16 = (bArr[i13] << 14) ^ i14;
                        if (i16 >= 0) {
                            j10 = i16 ^ 16256;
                            i13 = i15;
                        } else {
                            int i17 = i10 + 4;
                            int i18 = i16 ^ (bArr[i15] << 21);
                            if (i18 < 0) {
                                long j13 = (-2080896) ^ i18;
                                i13 = i17;
                                j10 = j13;
                            } else {
                                long j14 = i18;
                                i13 = i10 + 5;
                                long j15 = j14 ^ (((long) bArr[i17]) << 28);
                                if (j15 >= 0) {
                                    j12 = 266354560;
                                } else {
                                    int i19 = i10 + 6;
                                    long j16 = j15 ^ (((long) bArr[i13]) << 35);
                                    if (j16 < 0) {
                                        j11 = -34093383808L;
                                    } else {
                                        i13 = i10 + 7;
                                        j15 = j16 ^ (((long) bArr[i19]) << 42);
                                        if (j15 >= 0) {
                                            j12 = 4363953127296L;
                                        } else {
                                            i19 = i10 + 8;
                                            j16 = j15 ^ (((long) bArr[i13]) << 49);
                                            if (j16 < 0) {
                                                j11 = -558586000294016L;
                                            } else {
                                                i13 = i10 + 9;
                                                long j17 = (j16 ^ (((long) bArr[i19]) << 56)) ^ 71499008037633920L;
                                                if (j17 < 0) {
                                                    int i20 = i10 + 10;
                                                    if (bArr[i13] >= 0) {
                                                        i13 = i20;
                                                    }
                                                }
                                                j10 = j17;
                                            }
                                        }
                                    }
                                    j10 = j16 ^ j11;
                                    i13 = i19;
                                }
                                j10 = j15 ^ j12;
                            }
                        }
                    }
                    this.f7026k = i13;
                    return j10;
                }
            }
            return R();
        }

        public long R() throws d0 {
            long j10 = 0;
            for (int i10 = 0; i10 < 64; i10 += 7) {
                byte bL = L();
                j10 |= ((long) (bL & 127)) << i10;
                if ((bL & 128) == 0) {
                    return j10;
                }
            }
            throw d0.f();
        }

        public final void S() {
            int i10 = this.f7024i + this.f7025j;
            this.f7024i = i10;
            int i11 = i10 - this.f7027l;
            int i12 = this.f7030o;
            if (i11 <= i12) {
                this.f7025j = 0;
                return;
            }
            int i13 = i11 - i12;
            this.f7025j = i13;
            this.f7024i = i10 - i13;
        }

        public void T(int i10) throws d0 {
            if (i10 >= 0) {
                int i11 = this.f7024i;
                int i12 = this.f7026k;
                if (i10 <= i11 - i12) {
                    this.f7026k = i12 + i10;
                    return;
                }
            }
            if (i10 >= 0) {
                throw d0.m();
            }
            throw d0.g();
        }

        public final void U() throws d0 {
            if (this.f7024i - this.f7026k >= 10) {
                V();
            } else {
                W();
            }
        }

        public final void V() throws d0 {
            for (int i10 = 0; i10 < 10; i10++) {
                byte[] bArr = this.f7022g;
                int i11 = this.f7026k;
                this.f7026k = i11 + 1;
                if (bArr[i11] >= 0) {
                    return;
                }
            }
            throw d0.f();
        }

        public final void W() throws d0 {
            for (int i10 = 0; i10 < 10; i10++) {
                if (L() >= 0) {
                    return;
                }
            }
            throw d0.f();
        }

        @Override // com.google.protobuf.j
        public void a(int i10) throws d0 {
            if (this.f7028m != i10) {
                throw d0.b();
            }
        }

        @Override // com.google.protobuf.j
        public int e() {
            return this.f7026k - this.f7027l;
        }

        @Override // com.google.protobuf.j
        public boolean f() {
            return this.f7026k == this.f7024i;
        }

        @Override // com.google.protobuf.j
        public void n(int i10) {
            this.f7030o = i10;
            S();
        }

        @Override // com.google.protobuf.j
        public int o(int i10) throws d0 {
            if (i10 < 0) {
                throw d0.g();
            }
            int iE = i10 + e();
            if (iE < 0) {
                throw d0.h();
            }
            int i11 = this.f7030o;
            if (iE > i11) {
                throw d0.m();
            }
            this.f7030o = iE;
            S();
            return i11;
        }

        @Override // com.google.protobuf.j
        public boolean p() {
            return Q() != 0;
        }

        @Override // com.google.protobuf.j
        public i q() {
            int iP = P();
            if (iP > 0) {
                int i10 = this.f7024i;
                int i11 = this.f7026k;
                if (iP <= i10 - i11) {
                    i iVarG0 = (this.f7023h && this.f7029n) ? i.g0(this.f7022g, i11, iP) : i.s(this.f7022g, i11, iP);
                    this.f7026k += iP;
                    return iVarG0;
                }
            }
            return iP == 0 ? i.f6998b : i.f0(M(iP));
        }

        @Override // com.google.protobuf.j
        public double r() {
            return Double.longBitsToDouble(O());
        }

        @Override // com.google.protobuf.j
        public int s() {
            return P();
        }

        @Override // com.google.protobuf.j
        public int t() {
            return N();
        }

        @Override // com.google.protobuf.j
        public long u() {
            return O();
        }

        @Override // com.google.protobuf.j
        public float v() {
            return Float.intBitsToFloat(N());
        }

        @Override // com.google.protobuf.j
        public int w() {
            return P();
        }

        @Override // com.google.protobuf.j
        public long x() {
            return Q();
        }

        @Override // com.google.protobuf.j
        public int y() {
            return N();
        }

        @Override // com.google.protobuf.j
        public long z() {
            return O();
        }

        public b(byte[] bArr, int i10, int i11, boolean z10) {
            super();
            this.f7030o = a.e.API_PRIORITY_OTHER;
            this.f7022g = bArr;
            this.f7024i = i11 + i10;
            this.f7026k = i10;
            this.f7027l = i10;
            this.f7023h = z10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends j {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Iterable f7031g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Iterator f7032h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public ByteBuffer f7033i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f7034j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f7035k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f7036l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f7037m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f7038n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f7039o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f7040p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f7041q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public long f7042r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public long f7043s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public long f7044t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public long f7045u;

        private void U() {
            int i10 = this.f7036l + this.f7037m;
            this.f7036l = i10;
            int i11 = i10 - this.f7041q;
            int i12 = this.f7038n;
            if (i11 <= i12) {
                this.f7037m = 0;
                return;
            }
            int i13 = i11 - i12;
            this.f7037m = i13;
            this.f7036l = i10 - i13;
        }

        private void X() throws d0 {
            for (int i10 = 0; i10 < 10; i10++) {
                if (N() >= 0) {
                    return;
                }
            }
            throw d0.f();
        }

        @Override // com.google.protobuf.j
        public int A() {
            return j.c(R());
        }

        @Override // com.google.protobuf.j
        public long B() {
            return j.d(S());
        }

        @Override // com.google.protobuf.j
        public String C() throws d0 {
            int iR = R();
            if (iR > 0) {
                long j10 = iR;
                long j11 = this.f7045u;
                long j12 = this.f7042r;
                if (j10 <= j11 - j12) {
                    byte[] bArr = new byte[iR];
                    y1.p(j12, bArr, 0L, j10);
                    String str = new String(bArr, c0.f6944b);
                    this.f7042r += j10;
                    return str;
                }
            }
            if (iR > 0 && iR <= V()) {
                byte[] bArr2 = new byte[iR];
                O(bArr2, 0, iR);
                return new String(bArr2, c0.f6944b);
            }
            if (iR == 0) {
                return "";
            }
            if (iR < 0) {
                throw d0.g();
            }
            throw d0.m();
        }

        @Override // com.google.protobuf.j
        public String D() throws d0 {
            int iR = R();
            if (iR > 0) {
                long j10 = iR;
                long j11 = this.f7045u;
                long j12 = this.f7042r;
                if (j10 <= j11 - j12) {
                    String strG = z1.g(this.f7033i, (int) (j12 - this.f7043s), iR);
                    this.f7042r += j10;
                    return strG;
                }
            }
            if (iR >= 0 && iR <= V()) {
                byte[] bArr = new byte[iR];
                O(bArr, 0, iR);
                return z1.h(bArr, 0, iR);
            }
            if (iR == 0) {
                return "";
            }
            if (iR <= 0) {
                throw d0.g();
            }
            throw d0.m();
        }

        @Override // com.google.protobuf.j
        public int E() throws d0 {
            if (f()) {
                this.f7039o = 0;
                return 0;
            }
            int iR = R();
            this.f7039o = iR;
            if (a2.a(iR) != 0) {
                return this.f7039o;
            }
            throw d0.c();
        }

        @Override // com.google.protobuf.j
        public int F() {
            return R();
        }

        @Override // com.google.protobuf.j
        public long G() {
            return S();
        }

        @Override // com.google.protobuf.j
        public boolean J(int i10) throws d0 {
            int iB = a2.b(i10);
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
                a(a2.c(a2.a(i10), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw d0.e();
            }
            W(4);
            return true;
        }

        public final long L() {
            return this.f7045u - this.f7042r;
        }

        public final void M() throws d0 {
            if (!this.f7032h.hasNext()) {
                throw d0.m();
            }
            Z();
        }

        public byte N() throws d0 {
            if (L() == 0) {
                M();
            }
            long j10 = this.f7042r;
            this.f7042r = 1 + j10;
            return y1.w(j10);
        }

        public final void O(byte[] bArr, int i10, int i11) throws d0 {
            if (i11 < 0 || i11 > V()) {
                if (i11 > 0) {
                    throw d0.m();
                }
                if (i11 != 0) {
                    throw d0.g();
                }
                return;
            }
            int i12 = i11;
            while (i12 > 0) {
                if (L() == 0) {
                    M();
                }
                int iMin = Math.min(i12, (int) L());
                long j10 = iMin;
                y1.p(this.f7042r, bArr, (i11 - i12) + i10, j10);
                i12 -= iMin;
                this.f7042r += j10;
            }
        }

        public int P() {
            if (L() < 4) {
                return (N() & 255) | ((N() & 255) << 8) | ((N() & 255) << 16) | ((N() & 255) << 24);
            }
            long j10 = this.f7042r;
            this.f7042r = 4 + j10;
            return ((y1.w(j10 + 3) & 255) << 24) | (y1.w(j10) & 255) | ((y1.w(1 + j10) & 255) << 8) | ((y1.w(2 + j10) & 255) << 16);
        }

        public long Q() throws d0 {
            char c10;
            long jN;
            byte bN;
            if (L() >= 8) {
                long j10 = this.f7042r;
                this.f7042r = 8 + j10;
                c10 = '8';
                jN = (((long) y1.w(j10)) & 255) | ((((long) y1.w(1 + j10)) & 255) << 8) | ((((long) y1.w(2 + j10)) & 255) << 16) | ((((long) y1.w(3 + j10)) & 255) << 24) | ((((long) y1.w(4 + j10)) & 255) << 32) | ((((long) y1.w(5 + j10)) & 255) << 40) | ((((long) y1.w(6 + j10)) & 255) << 48);
                bN = y1.w(j10 + 7);
            } else {
                c10 = '8';
                jN = (((long) N()) & 255) | ((((long) N()) & 255) << 8) | ((((long) N()) & 255) << 16) | ((((long) N()) & 255) << 24) | ((((long) N()) & 255) << 32) | ((((long) N()) & 255) << 40) | ((((long) N()) & 255) << 48);
                bN = N();
            }
            return jN | ((((long) bN) & 255) << c10);
        }

        public int R() {
            int i10;
            long j10 = this.f7042r;
            if (this.f7045u != j10) {
                long j11 = j10 + 1;
                byte bW = y1.w(j10);
                if (bW >= 0) {
                    this.f7042r++;
                    return bW;
                }
                if (this.f7045u - this.f7042r >= 10) {
                    long j12 = 2 + j10;
                    int iW = (y1.w(j11) << 7) ^ bW;
                    if (iW < 0) {
                        i10 = iW ^ (-128);
                    } else {
                        long j13 = 3 + j10;
                        int iW2 = (y1.w(j12) << 14) ^ iW;
                        if (iW2 >= 0) {
                            i10 = iW2 ^ 16256;
                        } else {
                            long j14 = 4 + j10;
                            int iW3 = iW2 ^ (y1.w(j13) << 21);
                            if (iW3 < 0) {
                                i10 = (-2080896) ^ iW3;
                            } else {
                                j13 = 5 + j10;
                                byte bW2 = y1.w(j14);
                                int i11 = (iW3 ^ (bW2 << 28)) ^ 266354560;
                                if (bW2 < 0) {
                                    j14 = 6 + j10;
                                    if (y1.w(j13) < 0) {
                                        j13 = 7 + j10;
                                        if (y1.w(j14) < 0) {
                                            j14 = 8 + j10;
                                            if (y1.w(j13) < 0) {
                                                j13 = 9 + j10;
                                                if (y1.w(j14) < 0) {
                                                    long j15 = j10 + 10;
                                                    if (y1.w(j13) >= 0) {
                                                        i10 = i11;
                                                        j12 = j15;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i10 = i11;
                                }
                                i10 = i11;
                            }
                            j12 = j14;
                        }
                        j12 = j13;
                    }
                    this.f7042r = j12;
                    return i10;
                }
            }
            return (int) T();
        }

        public long S() {
            long j10;
            long j11;
            long j12;
            long j13 = this.f7042r;
            if (this.f7045u != j13) {
                long j14 = j13 + 1;
                byte bW = y1.w(j13);
                if (bW >= 0) {
                    this.f7042r++;
                    return bW;
                }
                if (this.f7045u - this.f7042r >= 10) {
                    long j15 = 2 + j13;
                    int iW = (y1.w(j14) << 7) ^ bW;
                    if (iW < 0) {
                        j10 = iW ^ (-128);
                    } else {
                        long j16 = 3 + j13;
                        int iW2 = (y1.w(j15) << 14) ^ iW;
                        if (iW2 >= 0) {
                            j10 = iW2 ^ 16256;
                            j15 = j16;
                        } else {
                            long j17 = 4 + j13;
                            int iW3 = iW2 ^ (y1.w(j16) << 21);
                            if (iW3 < 0) {
                                j10 = (-2080896) ^ iW3;
                                j15 = j17;
                            } else {
                                long j18 = 5 + j13;
                                long jW = (((long) y1.w(j17)) << 28) ^ ((long) iW3);
                                if (jW >= 0) {
                                    j12 = 266354560;
                                } else {
                                    long j19 = 6 + j13;
                                    long jW2 = jW ^ (((long) y1.w(j18)) << 35);
                                    if (jW2 < 0) {
                                        j11 = -34093383808L;
                                    } else {
                                        j18 = 7 + j13;
                                        jW = jW2 ^ (((long) y1.w(j19)) << 42);
                                        if (jW >= 0) {
                                            j12 = 4363953127296L;
                                        } else {
                                            j19 = 8 + j13;
                                            jW2 = jW ^ (((long) y1.w(j18)) << 49);
                                            if (jW2 < 0) {
                                                j11 = -558586000294016L;
                                            } else {
                                                j18 = 9 + j13;
                                                long jW3 = (jW2 ^ (((long) y1.w(j19)) << 56)) ^ 71499008037633920L;
                                                if (jW3 < 0) {
                                                    long j20 = j13 + 10;
                                                    if (y1.w(j18) >= 0) {
                                                        j15 = j20;
                                                        j10 = jW3;
                                                    }
                                                } else {
                                                    j10 = jW3;
                                                    j15 = j18;
                                                }
                                            }
                                        }
                                    }
                                    j10 = j11 ^ jW2;
                                    j15 = j19;
                                }
                                j10 = j12 ^ jW;
                                j15 = j18;
                            }
                        }
                    }
                    this.f7042r = j15;
                    return j10;
                }
            }
            return T();
        }

        public long T() throws d0 {
            long j10 = 0;
            for (int i10 = 0; i10 < 64; i10 += 7) {
                byte bN = N();
                j10 |= ((long) (bN & 127)) << i10;
                if ((bN & 128) == 0) {
                    return j10;
                }
            }
            throw d0.f();
        }

        public final int V() {
            return (int) ((((long) (this.f7036l - this.f7040p)) - this.f7042r) + this.f7043s);
        }

        public void W(int i10) throws d0 {
            if (i10 < 0 || i10 > (((long) (this.f7036l - this.f7040p)) - this.f7042r) + this.f7043s) {
                if (i10 >= 0) {
                    throw d0.m();
                }
                throw d0.g();
            }
            while (i10 > 0) {
                if (L() == 0) {
                    M();
                }
                int iMin = Math.min(i10, (int) L());
                i10 -= iMin;
                this.f7042r += (long) iMin;
            }
        }

        public final ByteBuffer Y(int i10, int i11) {
            int iPosition = this.f7033i.position();
            int iLimit = this.f7033i.limit();
            ByteBuffer byteBuffer = this.f7033i;
            try {
                try {
                    byteBuffer.position(i10);
                    byteBuffer.limit(i11);
                    return this.f7033i.slice();
                } catch (IllegalArgumentException unused) {
                    throw d0.m();
                }
            } finally {
                byteBuffer.position(iPosition);
                byteBuffer.limit(iLimit);
            }
        }

        public final void Z() {
            ByteBuffer byteBuffer = (ByteBuffer) this.f7032h.next();
            this.f7033i = byteBuffer;
            this.f7040p += (int) (this.f7042r - this.f7043s);
            long jPosition = byteBuffer.position();
            this.f7042r = jPosition;
            this.f7043s = jPosition;
            this.f7045u = this.f7033i.limit();
            long jK = y1.k(this.f7033i);
            this.f7044t = jK;
            this.f7042r += jK;
            this.f7043s += jK;
            this.f7045u += jK;
        }

        @Override // com.google.protobuf.j
        public void a(int i10) throws d0 {
            if (this.f7039o != i10) {
                throw d0.b();
            }
        }

        @Override // com.google.protobuf.j
        public int e() {
            return (int) ((((long) (this.f7040p - this.f7041q)) + this.f7042r) - this.f7043s);
        }

        @Override // com.google.protobuf.j
        public boolean f() {
            return (((long) this.f7040p) + this.f7042r) - this.f7043s == ((long) this.f7036l);
        }

        @Override // com.google.protobuf.j
        public void n(int i10) {
            this.f7038n = i10;
            U();
        }

        @Override // com.google.protobuf.j
        public int o(int i10) throws d0 {
            if (i10 < 0) {
                throw d0.g();
            }
            int iE = i10 + e();
            int i11 = this.f7038n;
            if (iE > i11) {
                throw d0.m();
            }
            this.f7038n = iE;
            U();
            return i11;
        }

        @Override // com.google.protobuf.j
        public boolean p() {
            return S() != 0;
        }

        @Override // com.google.protobuf.j
        public i q() throws d0 {
            int iR = R();
            if (iR > 0) {
                long j10 = iR;
                long j11 = this.f7045u;
                long j12 = this.f7042r;
                if (j10 <= j11 - j12) {
                    if (this.f7034j && this.f7035k) {
                        int i10 = (int) (j12 - this.f7044t);
                        i iVarE0 = i.e0(Y(i10, iR + i10));
                        this.f7042r += j10;
                        return iVarE0;
                    }
                    byte[] bArr = new byte[iR];
                    y1.p(j12, bArr, 0L, j10);
                    this.f7042r += j10;
                    return i.f0(bArr);
                }
            }
            if (iR <= 0 || iR > V()) {
                if (iR == 0) {
                    return i.f6998b;
                }
                if (iR < 0) {
                    throw d0.g();
                }
                throw d0.m();
            }
            if (!this.f7034j || !this.f7035k) {
                byte[] bArr2 = new byte[iR];
                O(bArr2, 0, iR);
                return i.f0(bArr2);
            }
            ArrayList arrayList = new ArrayList();
            while (iR > 0) {
                if (L() == 0) {
                    M();
                }
                int iMin = Math.min(iR, (int) L());
                int i11 = (int) (this.f7042r - this.f7044t);
                arrayList.add(i.e0(Y(i11, i11 + iMin)));
                iR -= iMin;
                this.f7042r += (long) iMin;
            }
            return i.q(arrayList);
        }

        @Override // com.google.protobuf.j
        public double r() {
            return Double.longBitsToDouble(Q());
        }

        @Override // com.google.protobuf.j
        public int s() {
            return R();
        }

        @Override // com.google.protobuf.j
        public int t() {
            return P();
        }

        @Override // com.google.protobuf.j
        public long u() {
            return Q();
        }

        @Override // com.google.protobuf.j
        public float v() {
            return Float.intBitsToFloat(P());
        }

        @Override // com.google.protobuf.j
        public int w() {
            return R();
        }

        @Override // com.google.protobuf.j
        public long x() {
            return S();
        }

        @Override // com.google.protobuf.j
        public int y() {
            return P();
        }

        @Override // com.google.protobuf.j
        public long z() {
            return Q();
        }

        public c(Iterable iterable, int i10, boolean z10) {
            super();
            this.f7038n = a.e.API_PRIORITY_OTHER;
            this.f7036l = i10;
            this.f7031g = iterable;
            this.f7032h = iterable.iterator();
            this.f7034j = z10;
            this.f7040p = 0;
            this.f7041q = 0;
            if (i10 != 0) {
                Z();
                return;
            }
            this.f7033i = c0.f6947e;
            this.f7042r = 0L;
            this.f7043s = 0L;
            this.f7045u = 0L;
            this.f7044t = 0L;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends j {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final InputStream f7046g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final byte[] f7047h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f7048i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f7049j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f7050k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f7051l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f7052m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f7053n;

        public static int L(InputStream inputStream) throws d0 {
            try {
                return inputStream.available();
            } catch (d0 e10) {
                e10.j();
                throw e10;
            }
        }

        public static int M(InputStream inputStream, byte[] bArr, int i10, int i11) throws d0 {
            try {
                return inputStream.read(bArr, i10, i11);
            } catch (d0 e10) {
                e10.j();
                throw e10;
            }
        }

        private void X() {
            int i10 = this.f7048i + this.f7049j;
            this.f7048i = i10;
            int i11 = this.f7052m + i10;
            int i12 = this.f7053n;
            if (i11 <= i12) {
                this.f7049j = 0;
                return;
            }
            int i13 = i11 - i12;
            this.f7049j = i13;
            this.f7048i = i10 - i13;
        }

        public static long Z(InputStream inputStream, long j10) throws d0 {
            try {
                return inputStream.skip(j10);
            } catch (d0 e10) {
                e10.j();
                throw e10;
            }
        }

        private void c0() throws d0 {
            if (this.f7048i - this.f7050k >= 10) {
                d0();
            } else {
                e0();
            }
        }

        private void d0() throws d0 {
            for (int i10 = 0; i10 < 10; i10++) {
                byte[] bArr = this.f7047h;
                int i11 = this.f7050k;
                this.f7050k = i11 + 1;
                if (bArr[i11] >= 0) {
                    return;
                }
            }
            throw d0.f();
        }

        private void e0() throws d0 {
            for (int i10 = 0; i10 < 10; i10++) {
                if (O() >= 0) {
                    return;
                }
            }
            throw d0.f();
        }

        @Override // com.google.protobuf.j
        public int A() {
            return j.c(U());
        }

        @Override // com.google.protobuf.j
        public long B() {
            return j.d(V());
        }

        @Override // com.google.protobuf.j
        public String C() throws d0 {
            int iU = U();
            if (iU > 0) {
                int i10 = this.f7048i;
                int i11 = this.f7050k;
                if (iU <= i10 - i11) {
                    String str = new String(this.f7047h, i11, iU, c0.f6944b);
                    this.f7050k += iU;
                    return str;
                }
            }
            if (iU == 0) {
                return "";
            }
            if (iU < 0) {
                throw d0.g();
            }
            if (iU > this.f7048i) {
                return new String(P(iU, false), c0.f6944b);
            }
            Y(iU);
            String str2 = new String(this.f7047h, this.f7050k, iU, c0.f6944b);
            this.f7050k += iU;
            return str2;
        }

        @Override // com.google.protobuf.j
        public String D() throws IOException {
            byte[] bArrP;
            int iU = U();
            int i10 = this.f7050k;
            int i11 = this.f7048i;
            if (iU <= i11 - i10 && iU > 0) {
                bArrP = this.f7047h;
                this.f7050k = i10 + iU;
            } else {
                if (iU == 0) {
                    return "";
                }
                if (iU < 0) {
                    throw d0.g();
                }
                i10 = 0;
                if (iU <= i11) {
                    Y(iU);
                    bArrP = this.f7047h;
                    this.f7050k = iU;
                } else {
                    bArrP = P(iU, false);
                }
            }
            return z1.h(bArrP, i10, iU);
        }

        @Override // com.google.protobuf.j
        public int E() throws d0 {
            if (f()) {
                this.f7051l = 0;
                return 0;
            }
            int iU = U();
            this.f7051l = iU;
            if (a2.a(iU) != 0) {
                return this.f7051l;
            }
            throw d0.c();
        }

        @Override // com.google.protobuf.j
        public int F() {
            return U();
        }

        @Override // com.google.protobuf.j
        public long G() {
            return V();
        }

        @Override // com.google.protobuf.j
        public boolean J(int i10) throws d0 {
            int iB = a2.b(i10);
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
                a(a2.c(a2.a(i10), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw d0.e();
            }
            a0(4);
            return true;
        }

        public final i N(int i10) throws IOException {
            byte[] bArrQ = Q(i10);
            if (bArrQ != null) {
                return i.r(bArrQ);
            }
            int i11 = this.f7050k;
            int i12 = this.f7048i;
            int length = i12 - i11;
            this.f7052m += i12;
            this.f7050k = 0;
            this.f7048i = 0;
            List<byte[]> listR = R(i10 - length);
            byte[] bArr = new byte[i10];
            System.arraycopy(this.f7047h, i11, bArr, 0, length);
            for (byte[] bArr2 : listR) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return i.f0(bArr);
        }

        public byte O() throws d0 {
            if (this.f7050k == this.f7048i) {
                Y(1);
            }
            byte[] bArr = this.f7047h;
            int i10 = this.f7050k;
            this.f7050k = i10 + 1;
            return bArr[i10];
        }

        public final byte[] P(int i10, boolean z10) throws IOException {
            byte[] bArrQ = Q(i10);
            if (bArrQ != null) {
                return z10 ? (byte[]) bArrQ.clone() : bArrQ;
            }
            int i11 = this.f7050k;
            int i12 = this.f7048i;
            int length = i12 - i11;
            this.f7052m += i12;
            this.f7050k = 0;
            this.f7048i = 0;
            List<byte[]> listR = R(i10 - length);
            byte[] bArr = new byte[i10];
            System.arraycopy(this.f7047h, i11, bArr, 0, length);
            for (byte[] bArr2 : listR) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return bArr;
        }

        public final byte[] Q(int i10) throws d0 {
            if (i10 == 0) {
                return c0.f6946d;
            }
            if (i10 < 0) {
                throw d0.g();
            }
            int i11 = this.f7052m;
            int i12 = this.f7050k;
            int i13 = i11 + i12 + i10;
            if (i13 - this.f7019c > 0) {
                throw d0.l();
            }
            int i14 = this.f7053n;
            if (i13 > i14) {
                a0((i14 - i11) - i12);
                throw d0.m();
            }
            int i15 = this.f7048i - i12;
            int i16 = i10 - i15;
            if (i16 >= 4096 && i16 > L(this.f7046g)) {
                return null;
            }
            byte[] bArr = new byte[i10];
            System.arraycopy(this.f7047h, this.f7050k, bArr, 0, i15);
            this.f7052m += this.f7048i;
            this.f7050k = 0;
            this.f7048i = 0;
            while (i15 < i10) {
                int iM = M(this.f7046g, bArr, i15, i10 - i15);
                if (iM == -1) {
                    throw d0.m();
                }
                this.f7052m += iM;
                i15 += iM;
            }
            return bArr;
        }

        public final List R(int i10) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i10 > 0) {
                int iMin = Math.min(i10, 4096);
                byte[] bArr = new byte[iMin];
                int i11 = 0;
                while (i11 < iMin) {
                    int i12 = this.f7046g.read(bArr, i11, iMin - i11);
                    if (i12 == -1) {
                        throw d0.m();
                    }
                    this.f7052m += i12;
                    i11 += i12;
                }
                i10 -= iMin;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        public int S() throws d0 {
            int i10 = this.f7050k;
            if (this.f7048i - i10 < 4) {
                Y(4);
                i10 = this.f7050k;
            }
            byte[] bArr = this.f7047h;
            this.f7050k = i10 + 4;
            return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
        }

        public long T() throws d0 {
            int i10 = this.f7050k;
            if (this.f7048i - i10 < 8) {
                Y(8);
                i10 = this.f7050k;
            }
            byte[] bArr = this.f7047h;
            this.f7050k = i10 + 8;
            return ((((long) bArr[i10 + 7]) & 255) << 56) | (((long) bArr[i10]) & 255) | ((((long) bArr[i10 + 1]) & 255) << 8) | ((((long) bArr[i10 + 2]) & 255) << 16) | ((((long) bArr[i10 + 3]) & 255) << 24) | ((((long) bArr[i10 + 4]) & 255) << 32) | ((((long) bArr[i10 + 5]) & 255) << 40) | ((((long) bArr[i10 + 6]) & 255) << 48);
        }

        public int U() {
            int i10;
            int i11 = this.f7050k;
            int i12 = this.f7048i;
            if (i12 != i11) {
                byte[] bArr = this.f7047h;
                int i13 = i11 + 1;
                byte b10 = bArr[i11];
                if (b10 >= 0) {
                    this.f7050k = i13;
                    return b10;
                }
                if (i12 - i13 >= 9) {
                    int i14 = i11 + 2;
                    int i15 = (bArr[i13] << 7) ^ b10;
                    if (i15 < 0) {
                        i10 = i15 ^ (-128);
                    } else {
                        int i16 = i11 + 3;
                        int i17 = (bArr[i14] << 14) ^ i15;
                        if (i17 >= 0) {
                            i10 = i17 ^ 16256;
                        } else {
                            int i18 = i11 + 4;
                            int i19 = i17 ^ (bArr[i16] << 21);
                            if (i19 < 0) {
                                i10 = (-2080896) ^ i19;
                            } else {
                                i16 = i11 + 5;
                                byte b11 = bArr[i18];
                                int i20 = (i19 ^ (b11 << 28)) ^ 266354560;
                                if (b11 < 0) {
                                    i18 = i11 + 6;
                                    if (bArr[i16] < 0) {
                                        i16 = i11 + 7;
                                        if (bArr[i18] < 0) {
                                            i18 = i11 + 8;
                                            if (bArr[i16] < 0) {
                                                i16 = i11 + 9;
                                                if (bArr[i18] < 0) {
                                                    int i21 = i11 + 10;
                                                    if (bArr[i16] >= 0) {
                                                        i14 = i21;
                                                        i10 = i20;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i10 = i20;
                                }
                                i10 = i20;
                            }
                            i14 = i18;
                        }
                        i14 = i16;
                    }
                    this.f7050k = i14;
                    return i10;
                }
            }
            return (int) W();
        }

        public long V() {
            long j10;
            long j11;
            long j12;
            int i10 = this.f7050k;
            int i11 = this.f7048i;
            if (i11 != i10) {
                byte[] bArr = this.f7047h;
                int i12 = i10 + 1;
                byte b10 = bArr[i10];
                if (b10 >= 0) {
                    this.f7050k = i12;
                    return b10;
                }
                if (i11 - i12 >= 9) {
                    int i13 = i10 + 2;
                    int i14 = (bArr[i12] << 7) ^ b10;
                    if (i14 < 0) {
                        j10 = i14 ^ (-128);
                    } else {
                        int i15 = i10 + 3;
                        int i16 = (bArr[i13] << 14) ^ i14;
                        if (i16 >= 0) {
                            j10 = i16 ^ 16256;
                            i13 = i15;
                        } else {
                            int i17 = i10 + 4;
                            int i18 = i16 ^ (bArr[i15] << 21);
                            if (i18 < 0) {
                                long j13 = (-2080896) ^ i18;
                                i13 = i17;
                                j10 = j13;
                            } else {
                                long j14 = i18;
                                i13 = i10 + 5;
                                long j15 = j14 ^ (((long) bArr[i17]) << 28);
                                if (j15 >= 0) {
                                    j12 = 266354560;
                                } else {
                                    int i19 = i10 + 6;
                                    long j16 = j15 ^ (((long) bArr[i13]) << 35);
                                    if (j16 < 0) {
                                        j11 = -34093383808L;
                                    } else {
                                        i13 = i10 + 7;
                                        j15 = j16 ^ (((long) bArr[i19]) << 42);
                                        if (j15 >= 0) {
                                            j12 = 4363953127296L;
                                        } else {
                                            i19 = i10 + 8;
                                            j16 = j15 ^ (((long) bArr[i13]) << 49);
                                            if (j16 < 0) {
                                                j11 = -558586000294016L;
                                            } else {
                                                i13 = i10 + 9;
                                                long j17 = (j16 ^ (((long) bArr[i19]) << 56)) ^ 71499008037633920L;
                                                if (j17 < 0) {
                                                    int i20 = i10 + 10;
                                                    if (bArr[i13] >= 0) {
                                                        i13 = i20;
                                                    }
                                                }
                                                j10 = j17;
                                            }
                                        }
                                    }
                                    j10 = j16 ^ j11;
                                    i13 = i19;
                                }
                                j10 = j15 ^ j12;
                            }
                        }
                    }
                    this.f7050k = i13;
                    return j10;
                }
            }
            return W();
        }

        public long W() throws d0 {
            long j10 = 0;
            for (int i10 = 0; i10 < 64; i10 += 7) {
                byte bO = O();
                j10 |= ((long) (bO & 127)) << i10;
                if ((bO & 128) == 0) {
                    return j10;
                }
            }
            throw d0.f();
        }

        public final void Y(int i10) throws d0 {
            if (f0(i10)) {
                return;
            }
            if (i10 <= (this.f7019c - this.f7052m) - this.f7050k) {
                throw d0.m();
            }
            throw d0.l();
        }

        @Override // com.google.protobuf.j
        public void a(int i10) throws d0 {
            if (this.f7051l != i10) {
                throw d0.b();
            }
        }

        public void a0(int i10) throws d0 {
            int i11 = this.f7048i;
            int i12 = this.f7050k;
            if (i10 > i11 - i12 || i10 < 0) {
                b0(i10);
            } else {
                this.f7050k = i12 + i10;
            }
        }

        public final void b0(int i10) throws d0 {
            if (i10 < 0) {
                throw d0.g();
            }
            int i11 = this.f7052m;
            int i12 = this.f7050k;
            int i13 = i11 + i12 + i10;
            int i14 = this.f7053n;
            if (i13 > i14) {
                a0((i14 - i11) - i12);
                throw d0.m();
            }
            this.f7052m = i11 + i12;
            int i15 = this.f7048i - i12;
            this.f7048i = 0;
            this.f7050k = 0;
            while (i15 < i10) {
                try {
                    long j10 = i10 - i15;
                    long jZ = Z(this.f7046g, j10);
                    if (jZ < 0 || jZ > j10) {
                        throw new IllegalStateException(this.f7046g.getClass() + "#skip returned invalid result: " + jZ + "\nThe InputStream implementation is buggy.");
                    }
                    if (jZ == 0) {
                        break;
                    } else {
                        i15 += (int) jZ;
                    }
                } finally {
                    this.f7052m += i15;
                    X();
                }
            }
            if (i15 >= i10) {
                return;
            }
            int i16 = this.f7048i;
            int i17 = i16 - this.f7050k;
            this.f7050k = i16;
            Y(1);
            while (true) {
                int i18 = i10 - i17;
                int i19 = this.f7048i;
                if (i18 <= i19) {
                    this.f7050k = i18;
                    return;
                } else {
                    i17 += i19;
                    this.f7050k = i19;
                    Y(1);
                }
            }
        }

        @Override // com.google.protobuf.j
        public int e() {
            return this.f7052m + this.f7050k;
        }

        @Override // com.google.protobuf.j
        public boolean f() {
            return this.f7050k == this.f7048i && !f0(1);
        }

        public final boolean f0(int i10) throws d0 {
            int i11 = this.f7050k;
            int i12 = i11 + i10;
            int i13 = this.f7048i;
            if (i12 <= i13) {
                throw new IllegalStateException("refillBuffer() called when " + i10 + " bytes were already available in buffer");
            }
            int i14 = this.f7019c;
            int i15 = this.f7052m;
            if (i10 > (i14 - i15) - i11 || i15 + i11 + i10 > this.f7053n) {
                return false;
            }
            if (i11 > 0) {
                if (i13 > i11) {
                    byte[] bArr = this.f7047h;
                    System.arraycopy(bArr, i11, bArr, 0, i13 - i11);
                }
                this.f7052m += i11;
                this.f7048i -= i11;
                this.f7050k = 0;
            }
            InputStream inputStream = this.f7046g;
            byte[] bArr2 = this.f7047h;
            int i16 = this.f7048i;
            int iM = M(inputStream, bArr2, i16, Math.min(bArr2.length - i16, (this.f7019c - this.f7052m) - i16));
            if (iM == 0 || iM < -1 || iM > this.f7047h.length) {
                throw new IllegalStateException(this.f7046g.getClass() + "#read(byte[]) returned invalid result: " + iM + "\nThe InputStream implementation is buggy.");
            }
            if (iM <= 0) {
                return false;
            }
            this.f7048i += iM;
            X();
            if (this.f7048i >= i10) {
                return true;
            }
            return f0(i10);
        }

        @Override // com.google.protobuf.j
        public void n(int i10) {
            this.f7053n = i10;
            X();
        }

        @Override // com.google.protobuf.j
        public int o(int i10) throws d0 {
            if (i10 < 0) {
                throw d0.g();
            }
            int i11 = i10 + this.f7052m + this.f7050k;
            int i12 = this.f7053n;
            if (i11 > i12) {
                throw d0.m();
            }
            this.f7053n = i11;
            X();
            return i12;
        }

        @Override // com.google.protobuf.j
        public boolean p() {
            return V() != 0;
        }

        @Override // com.google.protobuf.j
        public i q() throws d0 {
            int iU = U();
            int i10 = this.f7048i;
            int i11 = this.f7050k;
            if (iU <= i10 - i11 && iU > 0) {
                i iVarS = i.s(this.f7047h, i11, iU);
                this.f7050k += iU;
                return iVarS;
            }
            if (iU == 0) {
                return i.f6998b;
            }
            if (iU >= 0) {
                return N(iU);
            }
            throw d0.g();
        }

        @Override // com.google.protobuf.j
        public double r() {
            return Double.longBitsToDouble(T());
        }

        @Override // com.google.protobuf.j
        public int s() {
            return U();
        }

        @Override // com.google.protobuf.j
        public int t() {
            return S();
        }

        @Override // com.google.protobuf.j
        public long u() {
            return T();
        }

        @Override // com.google.protobuf.j
        public float v() {
            return Float.intBitsToFloat(S());
        }

        @Override // com.google.protobuf.j
        public int w() {
            return U();
        }

        @Override // com.google.protobuf.j
        public long x() {
            return V();
        }

        @Override // com.google.protobuf.j
        public int y() {
            return S();
        }

        @Override // com.google.protobuf.j
        public long z() {
            return T();
        }

        public d(InputStream inputStream, int i10) {
            super();
            this.f7053n = a.e.API_PRIORITY_OTHER;
            c0.b(inputStream, "input");
            this.f7046g = inputStream;
            this.f7047h = new byte[i10];
            this.f7048i = 0;
            this.f7050k = 0;
            this.f7052m = 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e extends j {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final ByteBuffer f7054g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f7055h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f7056i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f7057j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f7058k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f7059l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f7060m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f7061n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f7062o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f7063p;

        public static boolean M() {
            return y1.J();
        }

        private void T() {
            long j10 = this.f7057j + ((long) this.f7060m);
            this.f7057j = j10;
            int i10 = (int) (j10 - this.f7059l);
            int i11 = this.f7063p;
            if (i10 <= i11) {
                this.f7060m = 0;
                return;
            }
            int i12 = i10 - i11;
            this.f7060m = i12;
            this.f7057j = j10 - ((long) i12);
        }

        private int U() {
            return (int) (this.f7057j - this.f7058k);
        }

        private void W() throws d0 {
            if (U() >= 10) {
                X();
            } else {
                Y();
            }
        }

        private void X() throws d0 {
            for (int i10 = 0; i10 < 10; i10++) {
                long j10 = this.f7058k;
                this.f7058k = 1 + j10;
                if (y1.w(j10) >= 0) {
                    return;
                }
            }
            throw d0.f();
        }

        private void Y() throws d0 {
            for (int i10 = 0; i10 < 10; i10++) {
                if (N() >= 0) {
                    return;
                }
            }
            throw d0.f();
        }

        @Override // com.google.protobuf.j
        public int A() {
            return j.c(Q());
        }

        @Override // com.google.protobuf.j
        public long B() {
            return j.d(R());
        }

        @Override // com.google.protobuf.j
        public String C() throws d0 {
            int iQ = Q();
            if (iQ <= 0 || iQ > U()) {
                if (iQ == 0) {
                    return "";
                }
                if (iQ < 0) {
                    throw d0.g();
                }
                throw d0.m();
            }
            byte[] bArr = new byte[iQ];
            long j10 = iQ;
            y1.p(this.f7058k, bArr, 0L, j10);
            String str = new String(bArr, c0.f6944b);
            this.f7058k += j10;
            return str;
        }

        @Override // com.google.protobuf.j
        public String D() throws d0 {
            int iQ = Q();
            if (iQ > 0 && iQ <= U()) {
                String strG = z1.g(this.f7054g, L(this.f7058k), iQ);
                this.f7058k += (long) iQ;
                return strG;
            }
            if (iQ == 0) {
                return "";
            }
            if (iQ <= 0) {
                throw d0.g();
            }
            throw d0.m();
        }

        @Override // com.google.protobuf.j
        public int E() throws d0 {
            if (f()) {
                this.f7061n = 0;
                return 0;
            }
            int iQ = Q();
            this.f7061n = iQ;
            if (a2.a(iQ) != 0) {
                return this.f7061n;
            }
            throw d0.c();
        }

        @Override // com.google.protobuf.j
        public int F() {
            return Q();
        }

        @Override // com.google.protobuf.j
        public long G() {
            return R();
        }

        @Override // com.google.protobuf.j
        public boolean J(int i10) throws d0 {
            int iB = a2.b(i10);
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
                a(a2.c(a2.a(i10), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw d0.e();
            }
            V(4);
            return true;
        }

        public final int L(long j10) {
            return (int) (j10 - this.f7056i);
        }

        public byte N() throws d0 {
            long j10 = this.f7058k;
            if (j10 == this.f7057j) {
                throw d0.m();
            }
            this.f7058k = 1 + j10;
            return y1.w(j10);
        }

        public int O() throws d0 {
            long j10 = this.f7058k;
            if (this.f7057j - j10 < 4) {
                throw d0.m();
            }
            this.f7058k = 4 + j10;
            return ((y1.w(j10 + 3) & 255) << 24) | (y1.w(j10) & 255) | ((y1.w(1 + j10) & 255) << 8) | ((y1.w(2 + j10) & 255) << 16);
        }

        public long P() throws d0 {
            long j10 = this.f7058k;
            if (this.f7057j - j10 < 8) {
                throw d0.m();
            }
            this.f7058k = 8 + j10;
            return ((((long) y1.w(j10 + 7)) & 255) << 56) | (((long) y1.w(j10)) & 255) | ((((long) y1.w(1 + j10)) & 255) << 8) | ((((long) y1.w(2 + j10)) & 255) << 16) | ((((long) y1.w(3 + j10)) & 255) << 24) | ((((long) y1.w(4 + j10)) & 255) << 32) | ((((long) y1.w(5 + j10)) & 255) << 40) | ((((long) y1.w(6 + j10)) & 255) << 48);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x008c, code lost:
        
            if (com.google.protobuf.y1.w(r3) < 0) goto L34;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int Q() {
            /*
                r9 = this;
                long r0 = r9.f7058k
                long r2 = r9.f7057j
                int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r2 != 0) goto La
                goto L8e
            La:
                r2 = 1
                long r2 = r2 + r0
                byte r4 = com.google.protobuf.y1.w(r0)
                if (r4 < 0) goto L16
                r9.f7058k = r2
                return r4
            L16:
                long r5 = r9.f7057j
                long r5 = r5 - r2
                r7 = 9
                int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r5 >= 0) goto L21
                goto L8e
            L21:
                r5 = 2
                long r5 = r5 + r0
                byte r2 = com.google.protobuf.y1.w(r2)
                int r2 = r2 << 7
                r2 = r2 ^ r4
                if (r2 >= 0) goto L31
                r0 = r2 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L98
            L31:
                r3 = 3
                long r3 = r3 + r0
                byte r5 = com.google.protobuf.y1.w(r5)
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
                byte r3 = com.google.protobuf.y1.w(r3)
                int r3 = r3 << 21
                r2 = r2 ^ r3
                if (r2 >= 0) goto L52
                r0 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L98
            L52:
                r3 = 5
                long r3 = r3 + r0
                byte r5 = com.google.protobuf.y1.w(r5)
                int r6 = r5 << 28
                r2 = r2 ^ r6
                r6 = 266354560(0xfe03f80, float:2.2112565E-29)
                r2 = r2 ^ r6
                if (r5 >= 0) goto L96
                r5 = 6
                long r5 = r5 + r0
                byte r3 = com.google.protobuf.y1.w(r3)
                if (r3 >= 0) goto L94
                r3 = 7
                long r3 = r3 + r0
                byte r5 = com.google.protobuf.y1.w(r5)
                if (r5 >= 0) goto L96
                r5 = 8
                long r5 = r5 + r0
                byte r3 = com.google.protobuf.y1.w(r3)
                if (r3 >= 0) goto L94
                long r3 = r0 + r7
                byte r5 = com.google.protobuf.y1.w(r5)
                if (r5 >= 0) goto L96
                r5 = 10
                long r5 = r5 + r0
                byte r0 = com.google.protobuf.y1.w(r3)
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
                r9.f7058k = r5
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.j.e.Q():int");
        }

        public long R() {
            long j10;
            long j11;
            long j12;
            int i10;
            long j13 = this.f7058k;
            if (this.f7057j != j13) {
                long j14 = 1 + j13;
                byte bW = y1.w(j13);
                if (bW >= 0) {
                    this.f7058k = j14;
                    return bW;
                }
                if (this.f7057j - j14 >= 9) {
                    long j15 = 2 + j13;
                    int iW = (y1.w(j14) << 7) ^ bW;
                    if (iW >= 0) {
                        long j16 = 3 + j13;
                        int iW2 = iW ^ (y1.w(j15) << 14);
                        if (iW2 >= 0) {
                            j10 = iW2 ^ 16256;
                            j15 = j16;
                        } else {
                            j15 = 4 + j13;
                            int iW3 = iW2 ^ (y1.w(j16) << 21);
                            if (iW3 < 0) {
                                i10 = (-2080896) ^ iW3;
                            } else {
                                long j17 = 5 + j13;
                                long jW = ((long) iW3) ^ (((long) y1.w(j15)) << 28);
                                if (jW >= 0) {
                                    j12 = 266354560;
                                } else {
                                    long j18 = 6 + j13;
                                    long jW2 = jW ^ (((long) y1.w(j17)) << 35);
                                    if (jW2 < 0) {
                                        j11 = -34093383808L;
                                    } else {
                                        j17 = 7 + j13;
                                        jW = jW2 ^ (((long) y1.w(j18)) << 42);
                                        if (jW >= 0) {
                                            j12 = 4363953127296L;
                                        } else {
                                            j18 = 8 + j13;
                                            jW2 = jW ^ (((long) y1.w(j17)) << 49);
                                            if (jW2 < 0) {
                                                j11 = -558586000294016L;
                                            } else {
                                                long j19 = j13 + 9;
                                                long jW3 = (jW2 ^ (((long) y1.w(j18)) << 56)) ^ 71499008037633920L;
                                                if (jW3 < 0) {
                                                    long j20 = j13 + 10;
                                                    if (y1.w(j19) >= 0) {
                                                        j15 = j20;
                                                        j10 = jW3;
                                                    }
                                                } else {
                                                    j10 = jW3;
                                                    j15 = j19;
                                                }
                                            }
                                        }
                                    }
                                    j10 = j11 ^ jW2;
                                    j15 = j18;
                                }
                                j10 = j12 ^ jW;
                                j15 = j17;
                            }
                        }
                        this.f7058k = j15;
                        return j10;
                    }
                    i10 = iW ^ (-128);
                    j10 = i10;
                    this.f7058k = j15;
                    return j10;
                }
            }
            return S();
        }

        public long S() throws d0 {
            long j10 = 0;
            for (int i10 = 0; i10 < 64; i10 += 7) {
                byte bN = N();
                j10 |= ((long) (bN & 127)) << i10;
                if ((bN & 128) == 0) {
                    return j10;
                }
            }
            throw d0.f();
        }

        public void V(int i10) throws d0 {
            if (i10 >= 0 && i10 <= U()) {
                this.f7058k += (long) i10;
            } else {
                if (i10 >= 0) {
                    throw d0.m();
                }
                throw d0.g();
            }
        }

        public final ByteBuffer Z(long j10, long j11) {
            int iPosition = this.f7054g.position();
            int iLimit = this.f7054g.limit();
            ByteBuffer byteBuffer = this.f7054g;
            try {
                try {
                    byteBuffer.position(L(j10));
                    byteBuffer.limit(L(j11));
                    return this.f7054g.slice();
                } catch (IllegalArgumentException e10) {
                    d0 d0VarM = d0.m();
                    d0VarM.initCause(e10);
                    throw d0VarM;
                }
            } finally {
                byteBuffer.position(iPosition);
                byteBuffer.limit(iLimit);
            }
        }

        @Override // com.google.protobuf.j
        public void a(int i10) throws d0 {
            if (this.f7061n != i10) {
                throw d0.b();
            }
        }

        @Override // com.google.protobuf.j
        public int e() {
            return (int) (this.f7058k - this.f7059l);
        }

        @Override // com.google.protobuf.j
        public boolean f() {
            return this.f7058k == this.f7057j;
        }

        @Override // com.google.protobuf.j
        public void n(int i10) {
            this.f7063p = i10;
            T();
        }

        @Override // com.google.protobuf.j
        public int o(int i10) throws d0 {
            if (i10 < 0) {
                throw d0.g();
            }
            int iE = i10 + e();
            int i11 = this.f7063p;
            if (iE > i11) {
                throw d0.m();
            }
            this.f7063p = iE;
            T();
            return i11;
        }

        @Override // com.google.protobuf.j
        public boolean p() {
            return R() != 0;
        }

        @Override // com.google.protobuf.j
        public i q() throws d0 {
            int iQ = Q();
            if (iQ <= 0 || iQ > U()) {
                if (iQ == 0) {
                    return i.f6998b;
                }
                if (iQ < 0) {
                    throw d0.g();
                }
                throw d0.m();
            }
            if (this.f7055h && this.f7062o) {
                long j10 = this.f7058k;
                long j11 = iQ;
                ByteBuffer byteBufferZ = Z(j10, j10 + j11);
                this.f7058k += j11;
                return i.e0(byteBufferZ);
            }
            byte[] bArr = new byte[iQ];
            long j12 = iQ;
            y1.p(this.f7058k, bArr, 0L, j12);
            this.f7058k += j12;
            return i.f0(bArr);
        }

        @Override // com.google.protobuf.j
        public double r() {
            return Double.longBitsToDouble(P());
        }

        @Override // com.google.protobuf.j
        public int s() {
            return Q();
        }

        @Override // com.google.protobuf.j
        public int t() {
            return O();
        }

        @Override // com.google.protobuf.j
        public long u() {
            return P();
        }

        @Override // com.google.protobuf.j
        public float v() {
            return Float.intBitsToFloat(O());
        }

        @Override // com.google.protobuf.j
        public int w() {
            return Q();
        }

        @Override // com.google.protobuf.j
        public long x() {
            return R();
        }

        @Override // com.google.protobuf.j
        public int y() {
            return O();
        }

        @Override // com.google.protobuf.j
        public long z() {
            return P();
        }

        public e(ByteBuffer byteBuffer, boolean z10) {
            super();
            this.f7063p = a.e.API_PRIORITY_OTHER;
            this.f7054g = byteBuffer;
            long jK = y1.k(byteBuffer);
            this.f7056i = jK;
            this.f7057j = ((long) byteBuffer.limit()) + jK;
            long jPosition = jK + ((long) byteBuffer.position());
            this.f7058k = jPosition;
            this.f7059l = jPosition;
            this.f7055h = z10;
        }
    }

    public static int c(int i10) {
        return (-(i10 & 1)) ^ (i10 >>> 1);
    }

    public static long d(long j10) {
        return (-(j10 & 1)) ^ (j10 >>> 1);
    }

    public static j g(InputStream inputStream) {
        return h(inputStream, 4096);
    }

    public static j h(InputStream inputStream, int i10) {
        if (i10 > 0) {
            return inputStream == null ? k(c0.f6946d) : new d(inputStream, i10);
        }
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    public static j i(Iterable iterable, boolean z10) {
        Iterator it = iterable.iterator();
        int i10 = 0;
        int iRemaining = 0;
        while (it.hasNext()) {
            ByteBuffer byteBuffer = (ByteBuffer) it.next();
            iRemaining += byteBuffer.remaining();
            i10 = byteBuffer.hasArray() ? i10 | 1 : byteBuffer.isDirect() ? i10 | 2 : i10 | 4;
        }
        return i10 == 2 ? new c(iterable, iRemaining, z10) : g(new e0(iterable));
    }

    public static j j(ByteBuffer byteBuffer, boolean z10) {
        if (byteBuffer.hasArray()) {
            return m(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), z10);
        }
        if (byteBuffer.isDirect() && e.M()) {
            return new e(byteBuffer, z10);
        }
        int iRemaining = byteBuffer.remaining();
        byte[] bArr = new byte[iRemaining];
        byteBuffer.duplicate().get(bArr);
        return m(bArr, 0, iRemaining, true);
    }

    public static j k(byte[] bArr) {
        return l(bArr, 0, bArr.length);
    }

    public static j l(byte[] bArr, int i10, int i11) {
        return m(bArr, i10, i11, false);
    }

    public static j m(byte[] bArr, int i10, int i11, boolean z10) {
        b bVar = new b(bArr, i10, i11, z10);
        try {
            bVar.o(i11);
            return bVar;
        } catch (d0 e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public abstract int A();

    public abstract long B();

    public abstract String C();

    public abstract String D();

    public abstract int E();

    public abstract int F();

    public abstract long G();

    public final int H(int i10) {
        if (i10 >= 0) {
            int i11 = this.f7018b;
            this.f7018b = i10;
            return i11;
        }
        throw new IllegalArgumentException("Recursion limit cannot be negative: " + i10);
    }

    public final int I(int i10) {
        if (i10 >= 0) {
            int i11 = this.f7019c;
            this.f7019c = i10;
            return i11;
        }
        throw new IllegalArgumentException("Size limit cannot be negative: " + i10);
    }

    public abstract boolean J(int i10);

    public void K() throws d0 {
        int iE;
        do {
            iE = E();
            if (iE == 0) {
                return;
            }
            b();
            this.f7017a++;
            this.f7017a--;
        } while (J(iE));
    }

    public abstract void a(int i10);

    public void b() throws d0 {
        if (this.f7017a >= this.f7018b) {
            throw d0.i();
        }
    }

    public abstract int e();

    public abstract boolean f();

    public abstract void n(int i10);

    public abstract int o(int i10);

    public abstract boolean p();

    public abstract i q();

    public abstract double r();

    public abstract int s();

    public abstract int t();

    public abstract long u();

    public abstract float v();

    public abstract int w();

    public abstract long x();

    public abstract int y();

    public abstract long z();

    public j() {
        this.f7018b = f7016f;
        this.f7019c = a.e.API_PRIORITY_OTHER;
        this.f7021e = false;
    }
}
