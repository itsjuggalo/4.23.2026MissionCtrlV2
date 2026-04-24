package com.google.protobuf;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.google.protobuf.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1063j {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile int f11041f = 100;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C1064k f11045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f11046e;

    /* JADX INFO: renamed from: com.google.protobuf.j$b */
    public static final class b extends AbstractC1063j {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final byte[] f11047g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f11048h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f11049i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f11050j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f11051k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f11052l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f11053m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f11054n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f11055o;

        @Override // com.google.protobuf.AbstractC1063j
        public int A() {
            return P();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public long B() {
            return Q();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int C() {
            return AbstractC1063j.c(R());
        }

        @Override // com.google.protobuf.AbstractC1063j
        public long D() {
            return AbstractC1063j.d(S());
        }

        @Override // com.google.protobuf.AbstractC1063j
        public String E() throws D {
            int iR = R();
            if (iR > 0) {
                int i4 = this.f11049i;
                int i5 = this.f11051k;
                if (iR <= i4 - i5) {
                    String str = new String(this.f11047g, i5, iR, C.f10882b);
                    this.f11051k += iR;
                    return str;
                }
            }
            if (iR == 0) {
                return "";
            }
            if (iR < 0) {
                throw D.g();
            }
            throw D.m();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public String F() throws D {
            int iR = R();
            if (iR > 0) {
                int i4 = this.f11049i;
                int i5 = this.f11051k;
                if (iR <= i4 - i5) {
                    String strH = B0.h(this.f11047g, i5, iR);
                    this.f11051k += iR;
                    return strH;
                }
            }
            if (iR == 0) {
                return "";
            }
            if (iR <= 0) {
                throw D.g();
            }
            throw D.m();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int G() throws D {
            if (f()) {
                this.f11053m = 0;
                return 0;
            }
            int iR = R();
            this.f11053m = iR;
            if (C0.a(iR) != 0) {
                return this.f11053m;
            }
            throw D.c();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int H() {
            return R();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public long I() {
            return S();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public boolean L(int i4) throws D {
            int iB = C0.b(i4);
            if (iB == 0) {
                W();
                return true;
            }
            if (iB == 1) {
                V(8);
                return true;
            }
            if (iB == 2) {
                V(R());
                return true;
            }
            if (iB == 3) {
                M();
                a(C0.c(C0.a(i4), 4));
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

        public byte N() throws D {
            int i4 = this.f11051k;
            if (i4 == this.f11049i) {
                throw D.m();
            }
            byte[] bArr = this.f11047g;
            this.f11051k = i4 + 1;
            return bArr[i4];
        }

        public byte[] O(int i4) throws D {
            if (i4 > 0) {
                int i5 = this.f11049i;
                int i6 = this.f11051k;
                if (i4 <= i5 - i6) {
                    int i7 = i4 + i6;
                    this.f11051k = i7;
                    return Arrays.copyOfRange(this.f11047g, i6, i7);
                }
            }
            if (i4 > 0) {
                throw D.m();
            }
            if (i4 == 0) {
                return C.f10884d;
            }
            throw D.g();
        }

        public int P() throws D {
            int i4 = this.f11051k;
            if (this.f11049i - i4 < 4) {
                throw D.m();
            }
            byte[] bArr = this.f11047g;
            this.f11051k = i4 + 4;
            return ((bArr[i4 + 3] & 255) << 24) | (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16);
        }

        public long Q() throws D {
            int i4 = this.f11051k;
            if (this.f11049i - i4 < 8) {
                throw D.m();
            }
            byte[] bArr = this.f11047g;
            this.f11051k = i4 + 8;
            return ((((long) bArr[i4 + 7]) & 255) << 56) | (((long) bArr[i4]) & 255) | ((((long) bArr[i4 + 1]) & 255) << 8) | ((((long) bArr[i4 + 2]) & 255) << 16) | ((((long) bArr[i4 + 3]) & 255) << 24) | ((((long) bArr[i4 + 4]) & 255) << 32) | ((((long) bArr[i4 + 5]) & 255) << 40) | ((((long) bArr[i4 + 6]) & 255) << 48);
        }

        public int R() {
            int i4;
            int i5 = this.f11051k;
            int i6 = this.f11049i;
            if (i6 != i5) {
                byte[] bArr = this.f11047g;
                int i7 = i5 + 1;
                byte b4 = bArr[i5];
                if (b4 >= 0) {
                    this.f11051k = i7;
                    return b4;
                }
                if (i6 - i7 >= 9) {
                    int i8 = i5 + 2;
                    int i9 = (bArr[i7] << 7) ^ b4;
                    if (i9 < 0) {
                        i4 = i9 ^ (-128);
                    } else {
                        int i10 = i5 + 3;
                        int i11 = (bArr[i8] << 14) ^ i9;
                        if (i11 >= 0) {
                            i4 = i11 ^ 16256;
                        } else {
                            int i12 = i5 + 4;
                            int i13 = i11 ^ (bArr[i10] << 21);
                            if (i13 < 0) {
                                i4 = (-2080896) ^ i13;
                            } else {
                                i10 = i5 + 5;
                                byte b5 = bArr[i12];
                                int i14 = (i13 ^ (b5 << 28)) ^ 266354560;
                                if (b5 < 0) {
                                    i12 = i5 + 6;
                                    if (bArr[i10] < 0) {
                                        i10 = i5 + 7;
                                        if (bArr[i12] < 0) {
                                            i12 = i5 + 8;
                                            if (bArr[i10] < 0) {
                                                i10 = i5 + 9;
                                                if (bArr[i12] < 0) {
                                                    int i15 = i5 + 10;
                                                    if (bArr[i10] >= 0) {
                                                        i8 = i15;
                                                        i4 = i14;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i4 = i14;
                                }
                                i4 = i14;
                            }
                            i8 = i12;
                        }
                        i8 = i10;
                    }
                    this.f11051k = i8;
                    return i4;
                }
            }
            return (int) T();
        }

        public long S() {
            long j4;
            long j5;
            long j6;
            int i4 = this.f11051k;
            int i5 = this.f11049i;
            if (i5 != i4) {
                byte[] bArr = this.f11047g;
                int i6 = i4 + 1;
                byte b4 = bArr[i4];
                if (b4 >= 0) {
                    this.f11051k = i6;
                    return b4;
                }
                if (i5 - i6 >= 9) {
                    int i7 = i4 + 2;
                    int i8 = (bArr[i6] << 7) ^ b4;
                    if (i8 < 0) {
                        j4 = i8 ^ (-128);
                    } else {
                        int i9 = i4 + 3;
                        int i10 = (bArr[i7] << 14) ^ i8;
                        if (i10 >= 0) {
                            j4 = i10 ^ 16256;
                            i7 = i9;
                        } else {
                            int i11 = i4 + 4;
                            int i12 = i10 ^ (bArr[i9] << 21);
                            if (i12 < 0) {
                                long j7 = (-2080896) ^ i12;
                                i7 = i11;
                                j4 = j7;
                            } else {
                                long j8 = i12;
                                i7 = i4 + 5;
                                long j9 = j8 ^ (((long) bArr[i11]) << 28);
                                if (j9 >= 0) {
                                    j6 = 266354560;
                                } else {
                                    int i13 = i4 + 6;
                                    long j10 = j9 ^ (((long) bArr[i7]) << 35);
                                    if (j10 < 0) {
                                        j5 = -34093383808L;
                                    } else {
                                        i7 = i4 + 7;
                                        j9 = j10 ^ (((long) bArr[i13]) << 42);
                                        if (j9 >= 0) {
                                            j6 = 4363953127296L;
                                        } else {
                                            i13 = i4 + 8;
                                            j10 = j9 ^ (((long) bArr[i7]) << 49);
                                            if (j10 < 0) {
                                                j5 = -558586000294016L;
                                            } else {
                                                i7 = i4 + 9;
                                                long j11 = (j10 ^ (((long) bArr[i13]) << 56)) ^ 71499008037633920L;
                                                if (j11 < 0) {
                                                    int i14 = i4 + 10;
                                                    if (bArr[i7] >= 0) {
                                                        i7 = i14;
                                                    }
                                                }
                                                j4 = j11;
                                            }
                                        }
                                    }
                                    j4 = j10 ^ j5;
                                    i7 = i13;
                                }
                                j4 = j9 ^ j6;
                            }
                        }
                    }
                    this.f11051k = i7;
                    return j4;
                }
            }
            return T();
        }

        public long T() throws D {
            long j4 = 0;
            for (int i4 = 0; i4 < 64; i4 += 7) {
                byte bN = N();
                j4 |= ((long) (bN & 127)) << i4;
                if ((bN & 128) == 0) {
                    return j4;
                }
            }
            throw D.f();
        }

        public final void U() {
            int i4 = this.f11049i + this.f11050j;
            this.f11049i = i4;
            int i5 = i4 - this.f11052l;
            int i6 = this.f11055o;
            if (i5 <= i6) {
                this.f11050j = 0;
                return;
            }
            int i7 = i5 - i6;
            this.f11050j = i7;
            this.f11049i = i4 - i7;
        }

        public void V(int i4) throws D {
            if (i4 >= 0) {
                int i5 = this.f11049i;
                int i6 = this.f11051k;
                if (i4 <= i5 - i6) {
                    this.f11051k = i6 + i4;
                    return;
                }
            }
            if (i4 >= 0) {
                throw D.m();
            }
            throw D.g();
        }

        public final void W() throws D {
            if (this.f11049i - this.f11051k >= 10) {
                X();
            } else {
                Y();
            }
        }

        public final void X() throws D {
            for (int i4 = 0; i4 < 10; i4++) {
                byte[] bArr = this.f11047g;
                int i5 = this.f11051k;
                this.f11051k = i5 + 1;
                if (bArr[i5] >= 0) {
                    return;
                }
            }
            throw D.f();
        }

        public final void Y() throws D {
            for (int i4 = 0; i4 < 10; i4++) {
                if (N() >= 0) {
                    return;
                }
            }
            throw D.f();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public void a(int i4) throws D {
            if (this.f11053m != i4) {
                throw D.b();
            }
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int e() {
            return this.f11051k - this.f11052l;
        }

        @Override // com.google.protobuf.AbstractC1063j
        public boolean f() {
            return this.f11051k == this.f11049i;
        }

        @Override // com.google.protobuf.AbstractC1063j
        public void o(int i4) {
            this.f11055o = i4;
            U();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int p(int i4) throws D {
            if (i4 < 0) {
                throw D.g();
            }
            int iE = i4 + e();
            if (iE < 0) {
                throw D.h();
            }
            int i5 = this.f11055o;
            if (iE > i5) {
                throw D.m();
            }
            this.f11055o = iE;
            U();
            return i5;
        }

        @Override // com.google.protobuf.AbstractC1063j
        public boolean q() {
            return S() != 0;
        }

        @Override // com.google.protobuf.AbstractC1063j
        public AbstractC1062i r() {
            int iR = R();
            if (iR > 0) {
                int i4 = this.f11049i;
                int i5 = this.f11051k;
                if (iR <= i4 - i5) {
                    AbstractC1062i abstractC1062iO = (this.f11048h && this.f11054n) ? AbstractC1062i.O(this.f11047g, i5, iR) : AbstractC1062i.q(this.f11047g, i5, iR);
                    this.f11051k += iR;
                    return abstractC1062iO;
                }
            }
            return iR == 0 ? AbstractC1062i.f11025b : AbstractC1062i.N(O(iR));
        }

        @Override // com.google.protobuf.AbstractC1063j
        public double s() {
            return Double.longBitsToDouble(Q());
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int t() {
            return R();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int u() {
            return P();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public long v() {
            return Q();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public float w() {
            return Float.intBitsToFloat(P());
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int x() {
            return R();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public long y() {
            return S();
        }

        public b(byte[] bArr, int i4, int i5, boolean z4) {
            super();
            this.f11055o = Integer.MAX_VALUE;
            this.f11047g = bArr;
            this.f11049i = i5 + i4;
            this.f11051k = i4;
            this.f11052l = i4;
            this.f11048h = z4;
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.j$c */
    public static final class c extends AbstractC1063j {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Iterable f11056g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Iterator f11057h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public ByteBuffer f11058i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f11059j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f11060k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f11061l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f11062m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f11063n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f11064o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f11065p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f11066q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public long f11067r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public long f11068s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public long f11069t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public long f11070u;

        private void W() {
            int i4 = this.f11061l + this.f11062m;
            this.f11061l = i4;
            int i5 = i4 - this.f11066q;
            int i6 = this.f11063n;
            if (i5 <= i6) {
                this.f11062m = 0;
                return;
            }
            int i7 = i5 - i6;
            this.f11062m = i7;
            this.f11061l = i4 - i7;
        }

        private void Z() throws D {
            for (int i4 = 0; i4 < 10; i4++) {
                if (P() >= 0) {
                    return;
                }
            }
            throw D.f();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int A() {
            return R();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public long B() {
            return S();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int C() {
            return AbstractC1063j.c(T());
        }

        @Override // com.google.protobuf.AbstractC1063j
        public long D() {
            return AbstractC1063j.d(U());
        }

        @Override // com.google.protobuf.AbstractC1063j
        public String E() throws D {
            int iT = T();
            if (iT > 0) {
                long j4 = iT;
                long j5 = this.f11070u;
                long j6 = this.f11067r;
                if (j4 <= j5 - j6) {
                    byte[] bArr = new byte[iT];
                    A0.p(j6, bArr, 0L, j4);
                    String str = new String(bArr, C.f10882b);
                    this.f11067r += j4;
                    return str;
                }
            }
            if (iT > 0 && iT <= X()) {
                byte[] bArr2 = new byte[iT];
                Q(bArr2, 0, iT);
                return new String(bArr2, C.f10882b);
            }
            if (iT == 0) {
                return "";
            }
            if (iT < 0) {
                throw D.g();
            }
            throw D.m();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public String F() throws D {
            int iT = T();
            if (iT > 0) {
                long j4 = iT;
                long j5 = this.f11070u;
                long j6 = this.f11067r;
                if (j4 <= j5 - j6) {
                    String strG = B0.g(this.f11058i, (int) (j6 - this.f11068s), iT);
                    this.f11067r += j4;
                    return strG;
                }
            }
            if (iT >= 0 && iT <= X()) {
                byte[] bArr = new byte[iT];
                Q(bArr, 0, iT);
                return B0.h(bArr, 0, iT);
            }
            if (iT == 0) {
                return "";
            }
            if (iT <= 0) {
                throw D.g();
            }
            throw D.m();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int G() throws D {
            if (f()) {
                this.f11064o = 0;
                return 0;
            }
            int iT = T();
            this.f11064o = iT;
            if (C0.a(iT) != 0) {
                return this.f11064o;
            }
            throw D.c();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int H() {
            return T();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public long I() {
            return U();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public boolean L(int i4) throws D {
            int iB = C0.b(i4);
            if (iB == 0) {
                Z();
                return true;
            }
            if (iB == 1) {
                Y(8);
                return true;
            }
            if (iB == 2) {
                Y(T());
                return true;
            }
            if (iB == 3) {
                M();
                a(C0.c(C0.a(i4), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw D.e();
            }
            Y(4);
            return true;
        }

        public final long N() {
            return this.f11070u - this.f11067r;
        }

        public final void O() throws D {
            if (!this.f11057h.hasNext()) {
                throw D.m();
            }
            b0();
        }

        public byte P() throws D {
            if (N() == 0) {
                O();
            }
            long j4 = this.f11067r;
            this.f11067r = 1 + j4;
            return A0.w(j4);
        }

        public final void Q(byte[] bArr, int i4, int i5) throws D {
            if (i5 < 0 || i5 > X()) {
                if (i5 > 0) {
                    throw D.m();
                }
                if (i5 != 0) {
                    throw D.g();
                }
                return;
            }
            int i6 = i5;
            while (i6 > 0) {
                if (N() == 0) {
                    O();
                }
                int iMin = Math.min(i6, (int) N());
                long j4 = iMin;
                A0.p(this.f11067r, bArr, (i5 - i6) + i4, j4);
                i6 -= iMin;
                this.f11067r += j4;
            }
        }

        public int R() {
            if (N() < 4) {
                return (P() & 255) | ((P() & 255) << 8) | ((P() & 255) << 16) | ((P() & 255) << 24);
            }
            long j4 = this.f11067r;
            this.f11067r = 4 + j4;
            return ((A0.w(j4 + 3) & 255) << 24) | (A0.w(j4) & 255) | ((A0.w(1 + j4) & 255) << 8) | ((A0.w(2 + j4) & 255) << 16);
        }

        public long S() throws D {
            char c4;
            long jP;
            byte bP;
            if (N() >= 8) {
                long j4 = this.f11067r;
                this.f11067r = 8 + j4;
                c4 = '8';
                jP = (((long) A0.w(j4)) & 255) | ((((long) A0.w(1 + j4)) & 255) << 8) | ((((long) A0.w(2 + j4)) & 255) << 16) | ((((long) A0.w(3 + j4)) & 255) << 24) | ((((long) A0.w(4 + j4)) & 255) << 32) | ((((long) A0.w(5 + j4)) & 255) << 40) | ((((long) A0.w(6 + j4)) & 255) << 48);
                bP = A0.w(j4 + 7);
            } else {
                c4 = '8';
                jP = (((long) P()) & 255) | ((((long) P()) & 255) << 8) | ((((long) P()) & 255) << 16) | ((((long) P()) & 255) << 24) | ((((long) P()) & 255) << 32) | ((((long) P()) & 255) << 40) | ((((long) P()) & 255) << 48);
                bP = P();
            }
            return jP | ((((long) bP) & 255) << c4);
        }

        public int T() {
            int i4;
            long j4 = this.f11067r;
            if (this.f11070u != j4) {
                long j5 = j4 + 1;
                byte bW = A0.w(j4);
                if (bW >= 0) {
                    this.f11067r++;
                    return bW;
                }
                if (this.f11070u - this.f11067r >= 10) {
                    long j6 = 2 + j4;
                    int iW = (A0.w(j5) << 7) ^ bW;
                    if (iW < 0) {
                        i4 = iW ^ (-128);
                    } else {
                        long j7 = 3 + j4;
                        int iW2 = (A0.w(j6) << 14) ^ iW;
                        if (iW2 >= 0) {
                            i4 = iW2 ^ 16256;
                        } else {
                            long j8 = 4 + j4;
                            int iW3 = iW2 ^ (A0.w(j7) << 21);
                            if (iW3 < 0) {
                                i4 = (-2080896) ^ iW3;
                            } else {
                                j7 = 5 + j4;
                                byte bW2 = A0.w(j8);
                                int i5 = (iW3 ^ (bW2 << 28)) ^ 266354560;
                                if (bW2 < 0) {
                                    j8 = 6 + j4;
                                    if (A0.w(j7) < 0) {
                                        j7 = 7 + j4;
                                        if (A0.w(j8) < 0) {
                                            j8 = 8 + j4;
                                            if (A0.w(j7) < 0) {
                                                j7 = 9 + j4;
                                                if (A0.w(j8) < 0) {
                                                    long j9 = j4 + 10;
                                                    if (A0.w(j7) >= 0) {
                                                        i4 = i5;
                                                        j6 = j9;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i4 = i5;
                                }
                                i4 = i5;
                            }
                            j6 = j8;
                        }
                        j6 = j7;
                    }
                    this.f11067r = j6;
                    return i4;
                }
            }
            return (int) V();
        }

        public long U() {
            long j4;
            long j5;
            long j6;
            long j7 = this.f11067r;
            if (this.f11070u != j7) {
                long j8 = j7 + 1;
                byte bW = A0.w(j7);
                if (bW >= 0) {
                    this.f11067r++;
                    return bW;
                }
                if (this.f11070u - this.f11067r >= 10) {
                    long j9 = 2 + j7;
                    int iW = (A0.w(j8) << 7) ^ bW;
                    if (iW < 0) {
                        j4 = iW ^ (-128);
                    } else {
                        long j10 = 3 + j7;
                        int iW2 = (A0.w(j9) << 14) ^ iW;
                        if (iW2 >= 0) {
                            j4 = iW2 ^ 16256;
                            j9 = j10;
                        } else {
                            long j11 = 4 + j7;
                            int iW3 = iW2 ^ (A0.w(j10) << 21);
                            if (iW3 < 0) {
                                j4 = (-2080896) ^ iW3;
                                j9 = j11;
                            } else {
                                long j12 = 5 + j7;
                                long jW = (((long) A0.w(j11)) << 28) ^ ((long) iW3);
                                if (jW >= 0) {
                                    j6 = 266354560;
                                } else {
                                    long j13 = 6 + j7;
                                    long jW2 = jW ^ (((long) A0.w(j12)) << 35);
                                    if (jW2 < 0) {
                                        j5 = -34093383808L;
                                    } else {
                                        j12 = 7 + j7;
                                        jW = jW2 ^ (((long) A0.w(j13)) << 42);
                                        if (jW >= 0) {
                                            j6 = 4363953127296L;
                                        } else {
                                            j13 = 8 + j7;
                                            jW2 = jW ^ (((long) A0.w(j12)) << 49);
                                            if (jW2 < 0) {
                                                j5 = -558586000294016L;
                                            } else {
                                                j12 = 9 + j7;
                                                long jW3 = (jW2 ^ (((long) A0.w(j13)) << 56)) ^ 71499008037633920L;
                                                if (jW3 < 0) {
                                                    long j14 = j7 + 10;
                                                    if (A0.w(j12) >= 0) {
                                                        j9 = j14;
                                                        j4 = jW3;
                                                    }
                                                } else {
                                                    j4 = jW3;
                                                    j9 = j12;
                                                }
                                            }
                                        }
                                    }
                                    j4 = j5 ^ jW2;
                                    j9 = j13;
                                }
                                j4 = j6 ^ jW;
                                j9 = j12;
                            }
                        }
                    }
                    this.f11067r = j9;
                    return j4;
                }
            }
            return V();
        }

        public long V() throws D {
            long j4 = 0;
            for (int i4 = 0; i4 < 64; i4 += 7) {
                byte bP = P();
                j4 |= ((long) (bP & 127)) << i4;
                if ((bP & 128) == 0) {
                    return j4;
                }
            }
            throw D.f();
        }

        public final int X() {
            return (int) ((((long) (this.f11061l - this.f11065p)) - this.f11067r) + this.f11068s);
        }

        public void Y(int i4) throws D {
            if (i4 < 0 || i4 > (((long) (this.f11061l - this.f11065p)) - this.f11067r) + this.f11068s) {
                if (i4 >= 0) {
                    throw D.m();
                }
                throw D.g();
            }
            while (i4 > 0) {
                if (N() == 0) {
                    O();
                }
                int iMin = Math.min(i4, (int) N());
                i4 -= iMin;
                this.f11067r += (long) iMin;
            }
        }

        @Override // com.google.protobuf.AbstractC1063j
        public void a(int i4) throws D {
            if (this.f11064o != i4) {
                throw D.b();
            }
        }

        public final ByteBuffer a0(int i4, int i5) {
            int iPosition = this.f11058i.position();
            int iLimit = this.f11058i.limit();
            ByteBuffer byteBuffer = this.f11058i;
            try {
                try {
                    byteBuffer.position(i4);
                    byteBuffer.limit(i5);
                    return this.f11058i.slice();
                } catch (IllegalArgumentException unused) {
                    throw D.m();
                }
            } finally {
                byteBuffer.position(iPosition);
                byteBuffer.limit(iLimit);
            }
        }

        public final void b0() {
            ByteBuffer byteBuffer = (ByteBuffer) this.f11057h.next();
            this.f11058i = byteBuffer;
            this.f11065p += (int) (this.f11067r - this.f11068s);
            long jPosition = byteBuffer.position();
            this.f11067r = jPosition;
            this.f11068s = jPosition;
            this.f11070u = this.f11058i.limit();
            long jK = A0.k(this.f11058i);
            this.f11069t = jK;
            this.f11067r += jK;
            this.f11068s += jK;
            this.f11070u += jK;
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int e() {
            return (int) ((((long) (this.f11065p - this.f11066q)) + this.f11067r) - this.f11068s);
        }

        @Override // com.google.protobuf.AbstractC1063j
        public boolean f() {
            return (((long) this.f11065p) + this.f11067r) - this.f11068s == ((long) this.f11061l);
        }

        @Override // com.google.protobuf.AbstractC1063j
        public void o(int i4) {
            this.f11063n = i4;
            W();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int p(int i4) throws D {
            if (i4 < 0) {
                throw D.g();
            }
            int iE = i4 + e();
            int i5 = this.f11063n;
            if (iE > i5) {
                throw D.m();
            }
            this.f11063n = iE;
            W();
            return i5;
        }

        @Override // com.google.protobuf.AbstractC1063j
        public boolean q() {
            return U() != 0;
        }

        @Override // com.google.protobuf.AbstractC1063j
        public AbstractC1062i r() throws D {
            int iT = T();
            if (iT > 0) {
                long j4 = iT;
                long j5 = this.f11070u;
                long j6 = this.f11067r;
                if (j4 <= j5 - j6) {
                    if (this.f11059j && this.f11060k) {
                        int i4 = (int) (j6 - this.f11069t);
                        AbstractC1062i abstractC1062iM = AbstractC1062i.M(a0(i4, iT + i4));
                        this.f11067r += j4;
                        return abstractC1062iM;
                    }
                    byte[] bArr = new byte[iT];
                    A0.p(j6, bArr, 0L, j4);
                    this.f11067r += j4;
                    return AbstractC1062i.N(bArr);
                }
            }
            if (iT <= 0 || iT > X()) {
                if (iT == 0) {
                    return AbstractC1062i.f11025b;
                }
                if (iT < 0) {
                    throw D.g();
                }
                throw D.m();
            }
            if (!this.f11059j || !this.f11060k) {
                byte[] bArr2 = new byte[iT];
                Q(bArr2, 0, iT);
                return AbstractC1062i.N(bArr2);
            }
            ArrayList arrayList = new ArrayList();
            while (iT > 0) {
                if (N() == 0) {
                    O();
                }
                int iMin = Math.min(iT, (int) N());
                int i5 = (int) (this.f11067r - this.f11069t);
                arrayList.add(AbstractC1062i.M(a0(i5, i5 + iMin)));
                iT -= iMin;
                this.f11067r += (long) iMin;
            }
            return AbstractC1062i.o(arrayList);
        }

        @Override // com.google.protobuf.AbstractC1063j
        public double s() {
            return Double.longBitsToDouble(S());
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int t() {
            return T();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int u() {
            return R();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public long v() {
            return S();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public float w() {
            return Float.intBitsToFloat(R());
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int x() {
            return T();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public long y() {
            return U();
        }

        public c(Iterable iterable, int i4, boolean z4) {
            super();
            this.f11063n = Integer.MAX_VALUE;
            this.f11061l = i4;
            this.f11056g = iterable;
            this.f11057h = iterable.iterator();
            this.f11059j = z4;
            this.f11065p = 0;
            this.f11066q = 0;
            if (i4 != 0) {
                b0();
                return;
            }
            this.f11058i = C.f10885e;
            this.f11067r = 0L;
            this.f11068s = 0L;
            this.f11070u = 0L;
            this.f11069t = 0L;
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.j$d */
    public static final class d extends AbstractC1063j {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final InputStream f11071g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final byte[] f11072h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f11073i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f11074j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f11075k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f11076l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f11077m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f11078n;

        public static int N(InputStream inputStream) throws D {
            try {
                return inputStream.available();
            } catch (D e4) {
                e4.j();
                throw e4;
            }
        }

        public static int O(InputStream inputStream, byte[] bArr, int i4, int i5) throws D {
            try {
                return inputStream.read(bArr, i4, i5);
            } catch (D e4) {
                e4.j();
                throw e4;
            }
        }

        private void Z() {
            int i4 = this.f11073i + this.f11074j;
            this.f11073i = i4;
            int i5 = this.f11077m + i4;
            int i6 = this.f11078n;
            if (i5 <= i6) {
                this.f11074j = 0;
                return;
            }
            int i7 = i5 - i6;
            this.f11074j = i7;
            this.f11073i = i4 - i7;
        }

        public static long b0(InputStream inputStream, long j4) throws D {
            try {
                return inputStream.skip(j4);
            } catch (D e4) {
                e4.j();
                throw e4;
            }
        }

        private void e0() throws D {
            if (this.f11073i - this.f11075k >= 10) {
                f0();
            } else {
                g0();
            }
        }

        private void f0() throws D {
            for (int i4 = 0; i4 < 10; i4++) {
                byte[] bArr = this.f11072h;
                int i5 = this.f11075k;
                this.f11075k = i5 + 1;
                if (bArr[i5] >= 0) {
                    return;
                }
            }
            throw D.f();
        }

        private void g0() throws D {
            for (int i4 = 0; i4 < 10; i4++) {
                if (Q() >= 0) {
                    return;
                }
            }
            throw D.f();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int A() {
            return U();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public long B() {
            return V();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int C() {
            return AbstractC1063j.c(W());
        }

        @Override // com.google.protobuf.AbstractC1063j
        public long D() {
            return AbstractC1063j.d(X());
        }

        @Override // com.google.protobuf.AbstractC1063j
        public String E() throws D {
            int iW = W();
            if (iW > 0) {
                int i4 = this.f11073i;
                int i5 = this.f11075k;
                if (iW <= i4 - i5) {
                    String str = new String(this.f11072h, i5, iW, C.f10882b);
                    this.f11075k += iW;
                    return str;
                }
            }
            if (iW == 0) {
                return "";
            }
            if (iW < 0) {
                throw D.g();
            }
            if (iW > this.f11073i) {
                return new String(R(iW, false), C.f10882b);
            }
            a0(iW);
            String str2 = new String(this.f11072h, this.f11075k, iW, C.f10882b);
            this.f11075k += iW;
            return str2;
        }

        @Override // com.google.protobuf.AbstractC1063j
        public String F() throws IOException {
            byte[] bArrR;
            int iW = W();
            int i4 = this.f11075k;
            int i5 = this.f11073i;
            if (iW <= i5 - i4 && iW > 0) {
                bArrR = this.f11072h;
                this.f11075k = i4 + iW;
            } else {
                if (iW == 0) {
                    return "";
                }
                if (iW < 0) {
                    throw D.g();
                }
                i4 = 0;
                if (iW <= i5) {
                    a0(iW);
                    bArrR = this.f11072h;
                    this.f11075k = iW;
                } else {
                    bArrR = R(iW, false);
                }
            }
            return B0.h(bArrR, i4, iW);
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int G() throws D {
            if (f()) {
                this.f11076l = 0;
                return 0;
            }
            int iW = W();
            this.f11076l = iW;
            if (C0.a(iW) != 0) {
                return this.f11076l;
            }
            throw D.c();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int H() {
            return W();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public long I() {
            return X();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public boolean L(int i4) throws D {
            int iB = C0.b(i4);
            if (iB == 0) {
                e0();
                return true;
            }
            if (iB == 1) {
                c0(8);
                return true;
            }
            if (iB == 2) {
                c0(W());
                return true;
            }
            if (iB == 3) {
                M();
                a(C0.c(C0.a(i4), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw D.e();
            }
            c0(4);
            return true;
        }

        public final AbstractC1062i P(int i4) throws IOException {
            byte[] bArrS = S(i4);
            if (bArrS != null) {
                return AbstractC1062i.p(bArrS);
            }
            int i5 = this.f11075k;
            int i6 = this.f11073i;
            int length = i6 - i5;
            this.f11077m += i6;
            this.f11075k = 0;
            this.f11073i = 0;
            List<byte[]> listT = T(i4 - length);
            byte[] bArr = new byte[i4];
            System.arraycopy(this.f11072h, i5, bArr, 0, length);
            for (byte[] bArr2 : listT) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return AbstractC1062i.N(bArr);
        }

        public byte Q() throws D {
            if (this.f11075k == this.f11073i) {
                a0(1);
            }
            byte[] bArr = this.f11072h;
            int i4 = this.f11075k;
            this.f11075k = i4 + 1;
            return bArr[i4];
        }

        public final byte[] R(int i4, boolean z4) throws IOException {
            byte[] bArrS = S(i4);
            if (bArrS != null) {
                return z4 ? (byte[]) bArrS.clone() : bArrS;
            }
            int i5 = this.f11075k;
            int i6 = this.f11073i;
            int length = i6 - i5;
            this.f11077m += i6;
            this.f11075k = 0;
            this.f11073i = 0;
            List<byte[]> listT = T(i4 - length);
            byte[] bArr = new byte[i4];
            System.arraycopy(this.f11072h, i5, bArr, 0, length);
            for (byte[] bArr2 : listT) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return bArr;
        }

        public final byte[] S(int i4) throws D {
            if (i4 == 0) {
                return C.f10884d;
            }
            if (i4 < 0) {
                throw D.g();
            }
            int i5 = this.f11077m;
            int i6 = this.f11075k;
            int i7 = i5 + i6 + i4;
            if (i7 - this.f11044c > 0) {
                throw D.l();
            }
            int i8 = this.f11078n;
            if (i7 > i8) {
                c0((i8 - i5) - i6);
                throw D.m();
            }
            int i9 = this.f11073i - i6;
            int i10 = i4 - i9;
            if (i10 >= 4096 && i10 > N(this.f11071g)) {
                return null;
            }
            byte[] bArr = new byte[i4];
            System.arraycopy(this.f11072h, this.f11075k, bArr, 0, i9);
            this.f11077m += this.f11073i;
            this.f11075k = 0;
            this.f11073i = 0;
            while (i9 < i4) {
                int iO = O(this.f11071g, bArr, i9, i4 - i9);
                if (iO == -1) {
                    throw D.m();
                }
                this.f11077m += iO;
                i9 += iO;
            }
            return bArr;
        }

        public final List T(int i4) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i4 > 0) {
                int iMin = Math.min(i4, 4096);
                byte[] bArr = new byte[iMin];
                int i5 = 0;
                while (i5 < iMin) {
                    int i6 = this.f11071g.read(bArr, i5, iMin - i5);
                    if (i6 == -1) {
                        throw D.m();
                    }
                    this.f11077m += i6;
                    i5 += i6;
                }
                i4 -= iMin;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        public int U() throws D {
            int i4 = this.f11075k;
            if (this.f11073i - i4 < 4) {
                a0(4);
                i4 = this.f11075k;
            }
            byte[] bArr = this.f11072h;
            this.f11075k = i4 + 4;
            return ((bArr[i4 + 3] & 255) << 24) | (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16);
        }

        public long V() throws D {
            int i4 = this.f11075k;
            if (this.f11073i - i4 < 8) {
                a0(8);
                i4 = this.f11075k;
            }
            byte[] bArr = this.f11072h;
            this.f11075k = i4 + 8;
            return ((((long) bArr[i4 + 7]) & 255) << 56) | (((long) bArr[i4]) & 255) | ((((long) bArr[i4 + 1]) & 255) << 8) | ((((long) bArr[i4 + 2]) & 255) << 16) | ((((long) bArr[i4 + 3]) & 255) << 24) | ((((long) bArr[i4 + 4]) & 255) << 32) | ((((long) bArr[i4 + 5]) & 255) << 40) | ((((long) bArr[i4 + 6]) & 255) << 48);
        }

        public int W() {
            int i4;
            int i5 = this.f11075k;
            int i6 = this.f11073i;
            if (i6 != i5) {
                byte[] bArr = this.f11072h;
                int i7 = i5 + 1;
                byte b4 = bArr[i5];
                if (b4 >= 0) {
                    this.f11075k = i7;
                    return b4;
                }
                if (i6 - i7 >= 9) {
                    int i8 = i5 + 2;
                    int i9 = (bArr[i7] << 7) ^ b4;
                    if (i9 < 0) {
                        i4 = i9 ^ (-128);
                    } else {
                        int i10 = i5 + 3;
                        int i11 = (bArr[i8] << 14) ^ i9;
                        if (i11 >= 0) {
                            i4 = i11 ^ 16256;
                        } else {
                            int i12 = i5 + 4;
                            int i13 = i11 ^ (bArr[i10] << 21);
                            if (i13 < 0) {
                                i4 = (-2080896) ^ i13;
                            } else {
                                i10 = i5 + 5;
                                byte b5 = bArr[i12];
                                int i14 = (i13 ^ (b5 << 28)) ^ 266354560;
                                if (b5 < 0) {
                                    i12 = i5 + 6;
                                    if (bArr[i10] < 0) {
                                        i10 = i5 + 7;
                                        if (bArr[i12] < 0) {
                                            i12 = i5 + 8;
                                            if (bArr[i10] < 0) {
                                                i10 = i5 + 9;
                                                if (bArr[i12] < 0) {
                                                    int i15 = i5 + 10;
                                                    if (bArr[i10] >= 0) {
                                                        i8 = i15;
                                                        i4 = i14;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i4 = i14;
                                }
                                i4 = i14;
                            }
                            i8 = i12;
                        }
                        i8 = i10;
                    }
                    this.f11075k = i8;
                    return i4;
                }
            }
            return (int) Y();
        }

        public long X() {
            long j4;
            long j5;
            long j6;
            int i4 = this.f11075k;
            int i5 = this.f11073i;
            if (i5 != i4) {
                byte[] bArr = this.f11072h;
                int i6 = i4 + 1;
                byte b4 = bArr[i4];
                if (b4 >= 0) {
                    this.f11075k = i6;
                    return b4;
                }
                if (i5 - i6 >= 9) {
                    int i7 = i4 + 2;
                    int i8 = (bArr[i6] << 7) ^ b4;
                    if (i8 < 0) {
                        j4 = i8 ^ (-128);
                    } else {
                        int i9 = i4 + 3;
                        int i10 = (bArr[i7] << 14) ^ i8;
                        if (i10 >= 0) {
                            j4 = i10 ^ 16256;
                            i7 = i9;
                        } else {
                            int i11 = i4 + 4;
                            int i12 = i10 ^ (bArr[i9] << 21);
                            if (i12 < 0) {
                                long j7 = (-2080896) ^ i12;
                                i7 = i11;
                                j4 = j7;
                            } else {
                                long j8 = i12;
                                i7 = i4 + 5;
                                long j9 = j8 ^ (((long) bArr[i11]) << 28);
                                if (j9 >= 0) {
                                    j6 = 266354560;
                                } else {
                                    int i13 = i4 + 6;
                                    long j10 = j9 ^ (((long) bArr[i7]) << 35);
                                    if (j10 < 0) {
                                        j5 = -34093383808L;
                                    } else {
                                        i7 = i4 + 7;
                                        j9 = j10 ^ (((long) bArr[i13]) << 42);
                                        if (j9 >= 0) {
                                            j6 = 4363953127296L;
                                        } else {
                                            i13 = i4 + 8;
                                            j10 = j9 ^ (((long) bArr[i7]) << 49);
                                            if (j10 < 0) {
                                                j5 = -558586000294016L;
                                            } else {
                                                i7 = i4 + 9;
                                                long j11 = (j10 ^ (((long) bArr[i13]) << 56)) ^ 71499008037633920L;
                                                if (j11 < 0) {
                                                    int i14 = i4 + 10;
                                                    if (bArr[i7] >= 0) {
                                                        i7 = i14;
                                                    }
                                                }
                                                j4 = j11;
                                            }
                                        }
                                    }
                                    j4 = j10 ^ j5;
                                    i7 = i13;
                                }
                                j4 = j9 ^ j6;
                            }
                        }
                    }
                    this.f11075k = i7;
                    return j4;
                }
            }
            return Y();
        }

        public long Y() throws D {
            long j4 = 0;
            for (int i4 = 0; i4 < 64; i4 += 7) {
                byte bQ = Q();
                j4 |= ((long) (bQ & 127)) << i4;
                if ((bQ & 128) == 0) {
                    return j4;
                }
            }
            throw D.f();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public void a(int i4) throws D {
            if (this.f11076l != i4) {
                throw D.b();
            }
        }

        public final void a0(int i4) throws D {
            if (h0(i4)) {
                return;
            }
            if (i4 <= (this.f11044c - this.f11077m) - this.f11075k) {
                throw D.m();
            }
            throw D.l();
        }

        public void c0(int i4) throws D {
            int i5 = this.f11073i;
            int i6 = this.f11075k;
            if (i4 > i5 - i6 || i4 < 0) {
                d0(i4);
            } else {
                this.f11075k = i6 + i4;
            }
        }

        public final void d0(int i4) throws D {
            if (i4 < 0) {
                throw D.g();
            }
            int i5 = this.f11077m;
            int i6 = this.f11075k;
            int i7 = i5 + i6 + i4;
            int i8 = this.f11078n;
            if (i7 > i8) {
                c0((i8 - i5) - i6);
                throw D.m();
            }
            this.f11077m = i5 + i6;
            int i9 = this.f11073i - i6;
            this.f11073i = 0;
            this.f11075k = 0;
            while (i9 < i4) {
                try {
                    long j4 = i4 - i9;
                    long jB0 = b0(this.f11071g, j4);
                    if (jB0 < 0 || jB0 > j4) {
                        throw new IllegalStateException(this.f11071g.getClass() + "#skip returned invalid result: " + jB0 + "\nThe InputStream implementation is buggy.");
                    }
                    if (jB0 == 0) {
                        break;
                    } else {
                        i9 += (int) jB0;
                    }
                } finally {
                    this.f11077m += i9;
                    Z();
                }
            }
            if (i9 >= i4) {
                return;
            }
            int i10 = this.f11073i;
            int i11 = i10 - this.f11075k;
            this.f11075k = i10;
            a0(1);
            while (true) {
                int i12 = i4 - i11;
                int i13 = this.f11073i;
                if (i12 <= i13) {
                    this.f11075k = i12;
                    return;
                } else {
                    i11 += i13;
                    this.f11075k = i13;
                    a0(1);
                }
            }
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int e() {
            return this.f11077m + this.f11075k;
        }

        @Override // com.google.protobuf.AbstractC1063j
        public boolean f() {
            return this.f11075k == this.f11073i && !h0(1);
        }

        public final boolean h0(int i4) throws D {
            int i5 = this.f11075k;
            int i6 = i5 + i4;
            int i7 = this.f11073i;
            if (i6 <= i7) {
                throw new IllegalStateException("refillBuffer() called when " + i4 + " bytes were already available in buffer");
            }
            int i8 = this.f11044c;
            int i9 = this.f11077m;
            if (i4 > (i8 - i9) - i5 || i9 + i5 + i4 > this.f11078n) {
                return false;
            }
            if (i5 > 0) {
                if (i7 > i5) {
                    byte[] bArr = this.f11072h;
                    System.arraycopy(bArr, i5, bArr, 0, i7 - i5);
                }
                this.f11077m += i5;
                this.f11073i -= i5;
                this.f11075k = 0;
            }
            InputStream inputStream = this.f11071g;
            byte[] bArr2 = this.f11072h;
            int i10 = this.f11073i;
            int iO = O(inputStream, bArr2, i10, Math.min(bArr2.length - i10, (this.f11044c - this.f11077m) - i10));
            if (iO == 0 || iO < -1 || iO > this.f11072h.length) {
                throw new IllegalStateException(this.f11071g.getClass() + "#read(byte[]) returned invalid result: " + iO + "\nThe InputStream implementation is buggy.");
            }
            if (iO <= 0) {
                return false;
            }
            this.f11073i += iO;
            Z();
            if (this.f11073i >= i4) {
                return true;
            }
            return h0(i4);
        }

        @Override // com.google.protobuf.AbstractC1063j
        public void o(int i4) {
            this.f11078n = i4;
            Z();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int p(int i4) throws D {
            if (i4 < 0) {
                throw D.g();
            }
            int i5 = i4 + this.f11077m + this.f11075k;
            int i6 = this.f11078n;
            if (i5 > i6) {
                throw D.m();
            }
            this.f11078n = i5;
            Z();
            return i6;
        }

        @Override // com.google.protobuf.AbstractC1063j
        public boolean q() {
            return X() != 0;
        }

        @Override // com.google.protobuf.AbstractC1063j
        public AbstractC1062i r() throws D {
            int iW = W();
            int i4 = this.f11073i;
            int i5 = this.f11075k;
            if (iW <= i4 - i5 && iW > 0) {
                AbstractC1062i abstractC1062iQ = AbstractC1062i.q(this.f11072h, i5, iW);
                this.f11075k += iW;
                return abstractC1062iQ;
            }
            if (iW == 0) {
                return AbstractC1062i.f11025b;
            }
            if (iW >= 0) {
                return P(iW);
            }
            throw D.g();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public double s() {
            return Double.longBitsToDouble(V());
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int t() {
            return W();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int u() {
            return U();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public long v() {
            return V();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public float w() {
            return Float.intBitsToFloat(U());
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int x() {
            return W();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public long y() {
            return X();
        }

        public d(InputStream inputStream, int i4) {
            super();
            this.f11078n = Integer.MAX_VALUE;
            C.b(inputStream, "input");
            this.f11071g = inputStream;
            this.f11072h = new byte[i4];
            this.f11073i = 0;
            this.f11075k = 0;
            this.f11077m = 0;
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.j$e */
    public static final class e extends AbstractC1063j {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final ByteBuffer f11079g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f11080h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f11081i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f11082j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f11083k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f11084l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f11085m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f11086n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f11087o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f11088p;

        public static boolean O() {
            return A0.J();
        }

        private void V() {
            long j4 = this.f11082j + ((long) this.f11085m);
            this.f11082j = j4;
            int i4 = (int) (j4 - this.f11084l);
            int i5 = this.f11088p;
            if (i4 <= i5) {
                this.f11085m = 0;
                return;
            }
            int i6 = i4 - i5;
            this.f11085m = i6;
            this.f11082j = j4 - ((long) i6);
        }

        private int W() {
            return (int) (this.f11082j - this.f11083k);
        }

        private void Y() throws D {
            if (W() >= 10) {
                Z();
            } else {
                a0();
            }
        }

        private void Z() throws D {
            for (int i4 = 0; i4 < 10; i4++) {
                long j4 = this.f11083k;
                this.f11083k = 1 + j4;
                if (A0.w(j4) >= 0) {
                    return;
                }
            }
            throw D.f();
        }

        private void a0() throws D {
            for (int i4 = 0; i4 < 10; i4++) {
                if (P() >= 0) {
                    return;
                }
            }
            throw D.f();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int A() {
            return Q();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public long B() {
            return R();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int C() {
            return AbstractC1063j.c(S());
        }

        @Override // com.google.protobuf.AbstractC1063j
        public long D() {
            return AbstractC1063j.d(T());
        }

        @Override // com.google.protobuf.AbstractC1063j
        public String E() throws D {
            int iS = S();
            if (iS <= 0 || iS > W()) {
                if (iS == 0) {
                    return "";
                }
                if (iS < 0) {
                    throw D.g();
                }
                throw D.m();
            }
            byte[] bArr = new byte[iS];
            long j4 = iS;
            A0.p(this.f11083k, bArr, 0L, j4);
            String str = new String(bArr, C.f10882b);
            this.f11083k += j4;
            return str;
        }

        @Override // com.google.protobuf.AbstractC1063j
        public String F() throws D {
            int iS = S();
            if (iS > 0 && iS <= W()) {
                String strG = B0.g(this.f11079g, N(this.f11083k), iS);
                this.f11083k += (long) iS;
                return strG;
            }
            if (iS == 0) {
                return "";
            }
            if (iS <= 0) {
                throw D.g();
            }
            throw D.m();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int G() throws D {
            if (f()) {
                this.f11086n = 0;
                return 0;
            }
            int iS = S();
            this.f11086n = iS;
            if (C0.a(iS) != 0) {
                return this.f11086n;
            }
            throw D.c();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int H() {
            return S();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public long I() {
            return T();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public boolean L(int i4) throws D {
            int iB = C0.b(i4);
            if (iB == 0) {
                Y();
                return true;
            }
            if (iB == 1) {
                X(8);
                return true;
            }
            if (iB == 2) {
                X(S());
                return true;
            }
            if (iB == 3) {
                M();
                a(C0.c(C0.a(i4), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw D.e();
            }
            X(4);
            return true;
        }

        public final int N(long j4) {
            return (int) (j4 - this.f11081i);
        }

        public byte P() throws D {
            long j4 = this.f11083k;
            if (j4 == this.f11082j) {
                throw D.m();
            }
            this.f11083k = 1 + j4;
            return A0.w(j4);
        }

        public int Q() throws D {
            long j4 = this.f11083k;
            if (this.f11082j - j4 < 4) {
                throw D.m();
            }
            this.f11083k = 4 + j4;
            return ((A0.w(j4 + 3) & 255) << 24) | (A0.w(j4) & 255) | ((A0.w(1 + j4) & 255) << 8) | ((A0.w(2 + j4) & 255) << 16);
        }

        public long R() throws D {
            long j4 = this.f11083k;
            if (this.f11082j - j4 < 8) {
                throw D.m();
            }
            this.f11083k = 8 + j4;
            return ((((long) A0.w(j4 + 7)) & 255) << 56) | (((long) A0.w(j4)) & 255) | ((((long) A0.w(1 + j4)) & 255) << 8) | ((((long) A0.w(2 + j4)) & 255) << 16) | ((((long) A0.w(3 + j4)) & 255) << 24) | ((((long) A0.w(4 + j4)) & 255) << 32) | ((((long) A0.w(5 + j4)) & 255) << 40) | ((((long) A0.w(6 + j4)) & 255) << 48);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x008c, code lost:
        
            if (com.google.protobuf.A0.w(r3) < 0) goto L34;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int S() {
            /*
                r9 = this;
                long r0 = r9.f11083k
                long r2 = r9.f11082j
                int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r2 != 0) goto La
                goto L8e
            La:
                r2 = 1
                long r2 = r2 + r0
                byte r4 = com.google.protobuf.A0.w(r0)
                if (r4 < 0) goto L16
                r9.f11083k = r2
                return r4
            L16:
                long r5 = r9.f11082j
                long r5 = r5 - r2
                r7 = 9
                int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r5 >= 0) goto L21
                goto L8e
            L21:
                r5 = 2
                long r5 = r5 + r0
                byte r2 = com.google.protobuf.A0.w(r2)
                int r2 = r2 << 7
                r2 = r2 ^ r4
                if (r2 >= 0) goto L31
                r0 = r2 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L98
            L31:
                r3 = 3
                long r3 = r3 + r0
                byte r5 = com.google.protobuf.A0.w(r5)
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
                byte r3 = com.google.protobuf.A0.w(r3)
                int r3 = r3 << 21
                r2 = r2 ^ r3
                if (r2 >= 0) goto L52
                r0 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L98
            L52:
                r3 = 5
                long r3 = r3 + r0
                byte r5 = com.google.protobuf.A0.w(r5)
                int r6 = r5 << 28
                r2 = r2 ^ r6
                r6 = 266354560(0xfe03f80, float:2.2112565E-29)
                r2 = r2 ^ r6
                if (r5 >= 0) goto L96
                r5 = 6
                long r5 = r5 + r0
                byte r3 = com.google.protobuf.A0.w(r3)
                if (r3 >= 0) goto L94
                r3 = 7
                long r3 = r3 + r0
                byte r5 = com.google.protobuf.A0.w(r5)
                if (r5 >= 0) goto L96
                r5 = 8
                long r5 = r5 + r0
                byte r3 = com.google.protobuf.A0.w(r3)
                if (r3 >= 0) goto L94
                long r3 = r0 + r7
                byte r5 = com.google.protobuf.A0.w(r5)
                if (r5 >= 0) goto L96
                r5 = 10
                long r5 = r5 + r0
                byte r0 = com.google.protobuf.A0.w(r3)
                if (r0 >= 0) goto L94
            L8e:
                long r0 = r9.U()
                int r0 = (int) r0
                return r0
            L94:
                r0 = r2
                goto L98
            L96:
                r0 = r2
                goto L3f
            L98:
                r9.f11083k = r5
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.AbstractC1063j.e.S():int");
        }

        public long T() {
            long j4;
            long j5;
            long j6;
            int i4;
            long j7 = this.f11083k;
            if (this.f11082j != j7) {
                long j8 = 1 + j7;
                byte bW = A0.w(j7);
                if (bW >= 0) {
                    this.f11083k = j8;
                    return bW;
                }
                if (this.f11082j - j8 >= 9) {
                    long j9 = 2 + j7;
                    int iW = (A0.w(j8) << 7) ^ bW;
                    if (iW >= 0) {
                        long j10 = 3 + j7;
                        int iW2 = iW ^ (A0.w(j9) << 14);
                        if (iW2 >= 0) {
                            j4 = iW2 ^ 16256;
                            j9 = j10;
                        } else {
                            j9 = 4 + j7;
                            int iW3 = iW2 ^ (A0.w(j10) << 21);
                            if (iW3 < 0) {
                                i4 = (-2080896) ^ iW3;
                            } else {
                                long j11 = 5 + j7;
                                long jW = ((long) iW3) ^ (((long) A0.w(j9)) << 28);
                                if (jW >= 0) {
                                    j6 = 266354560;
                                } else {
                                    long j12 = 6 + j7;
                                    long jW2 = jW ^ (((long) A0.w(j11)) << 35);
                                    if (jW2 < 0) {
                                        j5 = -34093383808L;
                                    } else {
                                        j11 = 7 + j7;
                                        jW = jW2 ^ (((long) A0.w(j12)) << 42);
                                        if (jW >= 0) {
                                            j6 = 4363953127296L;
                                        } else {
                                            j12 = 8 + j7;
                                            jW2 = jW ^ (((long) A0.w(j11)) << 49);
                                            if (jW2 < 0) {
                                                j5 = -558586000294016L;
                                            } else {
                                                long j13 = j7 + 9;
                                                long jW3 = (jW2 ^ (((long) A0.w(j12)) << 56)) ^ 71499008037633920L;
                                                if (jW3 < 0) {
                                                    long j14 = j7 + 10;
                                                    if (A0.w(j13) >= 0) {
                                                        j9 = j14;
                                                        j4 = jW3;
                                                    }
                                                } else {
                                                    j4 = jW3;
                                                    j9 = j13;
                                                }
                                            }
                                        }
                                    }
                                    j4 = j5 ^ jW2;
                                    j9 = j12;
                                }
                                j4 = j6 ^ jW;
                                j9 = j11;
                            }
                        }
                        this.f11083k = j9;
                        return j4;
                    }
                    i4 = iW ^ (-128);
                    j4 = i4;
                    this.f11083k = j9;
                    return j4;
                }
            }
            return U();
        }

        public long U() throws D {
            long j4 = 0;
            for (int i4 = 0; i4 < 64; i4 += 7) {
                byte bP = P();
                j4 |= ((long) (bP & 127)) << i4;
                if ((bP & 128) == 0) {
                    return j4;
                }
            }
            throw D.f();
        }

        public void X(int i4) throws D {
            if (i4 >= 0 && i4 <= W()) {
                this.f11083k += (long) i4;
            } else {
                if (i4 >= 0) {
                    throw D.m();
                }
                throw D.g();
            }
        }

        @Override // com.google.protobuf.AbstractC1063j
        public void a(int i4) throws D {
            if (this.f11086n != i4) {
                throw D.b();
            }
        }

        public final ByteBuffer b0(long j4, long j5) {
            int iPosition = this.f11079g.position();
            int iLimit = this.f11079g.limit();
            ByteBuffer byteBuffer = this.f11079g;
            try {
                try {
                    byteBuffer.position(N(j4));
                    byteBuffer.limit(N(j5));
                    return this.f11079g.slice();
                } catch (IllegalArgumentException e4) {
                    D dM = D.m();
                    dM.initCause(e4);
                    throw dM;
                }
            } finally {
                byteBuffer.position(iPosition);
                byteBuffer.limit(iLimit);
            }
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int e() {
            return (int) (this.f11083k - this.f11084l);
        }

        @Override // com.google.protobuf.AbstractC1063j
        public boolean f() {
            return this.f11083k == this.f11082j;
        }

        @Override // com.google.protobuf.AbstractC1063j
        public void o(int i4) {
            this.f11088p = i4;
            V();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int p(int i4) throws D {
            if (i4 < 0) {
                throw D.g();
            }
            int iE = i4 + e();
            int i5 = this.f11088p;
            if (iE > i5) {
                throw D.m();
            }
            this.f11088p = iE;
            V();
            return i5;
        }

        @Override // com.google.protobuf.AbstractC1063j
        public boolean q() {
            return T() != 0;
        }

        @Override // com.google.protobuf.AbstractC1063j
        public AbstractC1062i r() throws D {
            int iS = S();
            if (iS <= 0 || iS > W()) {
                if (iS == 0) {
                    return AbstractC1062i.f11025b;
                }
                if (iS < 0) {
                    throw D.g();
                }
                throw D.m();
            }
            if (this.f11080h && this.f11087o) {
                long j4 = this.f11083k;
                long j5 = iS;
                ByteBuffer byteBufferB0 = b0(j4, j4 + j5);
                this.f11083k += j5;
                return AbstractC1062i.M(byteBufferB0);
            }
            byte[] bArr = new byte[iS];
            long j6 = iS;
            A0.p(this.f11083k, bArr, 0L, j6);
            this.f11083k += j6;
            return AbstractC1062i.N(bArr);
        }

        @Override // com.google.protobuf.AbstractC1063j
        public double s() {
            return Double.longBitsToDouble(R());
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int t() {
            return S();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int u() {
            return Q();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public long v() {
            return R();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public float w() {
            return Float.intBitsToFloat(Q());
        }

        @Override // com.google.protobuf.AbstractC1063j
        public int x() {
            return S();
        }

        @Override // com.google.protobuf.AbstractC1063j
        public long y() {
            return T();
        }

        public e(ByteBuffer byteBuffer, boolean z4) {
            super();
            this.f11088p = Integer.MAX_VALUE;
            this.f11079g = byteBuffer;
            long jK = A0.k(byteBuffer);
            this.f11081i = jK;
            this.f11082j = ((long) byteBuffer.limit()) + jK;
            long jPosition = jK + ((long) byteBuffer.position());
            this.f11083k = jPosition;
            this.f11084l = jPosition;
            this.f11080h = z4;
        }
    }

    public static int c(int i4) {
        return (-(i4 & 1)) ^ (i4 >>> 1);
    }

    public static long d(long j4) {
        return (-(j4 & 1)) ^ (j4 >>> 1);
    }

    public static AbstractC1063j g(InputStream inputStream) {
        return h(inputStream, 4096);
    }

    public static AbstractC1063j h(InputStream inputStream, int i4) {
        if (i4 > 0) {
            return inputStream == null ? l(C.f10884d) : new d(inputStream, i4);
        }
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    public static AbstractC1063j i(Iterable iterable, boolean z4) {
        Iterator it = iterable.iterator();
        int i4 = 0;
        int iRemaining = 0;
        while (it.hasNext()) {
            ByteBuffer byteBuffer = (ByteBuffer) it.next();
            iRemaining += byteBuffer.remaining();
            i4 = byteBuffer.hasArray() ? i4 | 1 : byteBuffer.isDirect() ? i4 | 2 : i4 | 4;
        }
        return i4 == 2 ? new c(iterable, iRemaining, z4) : g(new E(iterable));
    }

    public static AbstractC1063j j(ByteBuffer byteBuffer) {
        return k(byteBuffer, false);
    }

    public static AbstractC1063j k(ByteBuffer byteBuffer, boolean z4) {
        if (byteBuffer.hasArray()) {
            return n(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), z4);
        }
        if (byteBuffer.isDirect() && e.O()) {
            return new e(byteBuffer, z4);
        }
        int iRemaining = byteBuffer.remaining();
        byte[] bArr = new byte[iRemaining];
        byteBuffer.duplicate().get(bArr);
        return n(bArr, 0, iRemaining, true);
    }

    public static AbstractC1063j l(byte[] bArr) {
        return m(bArr, 0, bArr.length);
    }

    public static AbstractC1063j m(byte[] bArr, int i4, int i5) {
        return n(bArr, i4, i5, false);
    }

    public static AbstractC1063j n(byte[] bArr, int i4, int i5, boolean z4) {
        b bVar = new b(bArr, i4, i5, z4);
        try {
            bVar.p(i5);
            return bVar;
        } catch (D e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    public static int z(int i4, InputStream inputStream) throws IOException {
        if ((i4 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) == 0) {
            return i4;
        }
        int i5 = i4 & 127;
        int i6 = 7;
        while (i6 < 32) {
            int i7 = inputStream.read();
            if (i7 == -1) {
                throw D.m();
            }
            i5 |= (i7 & 127) << i6;
            if ((i7 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) == 0) {
                return i5;
            }
            i6 += 7;
        }
        while (i6 < 64) {
            int i8 = inputStream.read();
            if (i8 == -1) {
                throw D.m();
            }
            if ((i8 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) == 0) {
                return i5;
            }
            i6 += 7;
        }
        throw D.f();
    }

    public abstract int A();

    public abstract long B();

    public abstract int C();

    public abstract long D();

    public abstract String E();

    public abstract String F();

    public abstract int G();

    public abstract int H();

    public abstract long I();

    public final int J(int i4) {
        if (i4 >= 0) {
            int i5 = this.f11043b;
            this.f11043b = i4;
            return i5;
        }
        throw new IllegalArgumentException("Recursion limit cannot be negative: " + i4);
    }

    public final int K(int i4) {
        if (i4 >= 0) {
            int i5 = this.f11044c;
            this.f11044c = i4;
            return i5;
        }
        throw new IllegalArgumentException("Size limit cannot be negative: " + i4);
    }

    public abstract boolean L(int i4);

    public void M() throws D {
        int iG;
        do {
            iG = G();
            if (iG == 0) {
                return;
            }
            b();
            this.f11042a++;
            this.f11042a--;
        } while (L(iG));
    }

    public abstract void a(int i4);

    public void b() throws D {
        if (this.f11042a >= this.f11043b) {
            throw D.i();
        }
    }

    public abstract int e();

    public abstract boolean f();

    public abstract void o(int i4);

    public abstract int p(int i4);

    public abstract boolean q();

    public abstract AbstractC1062i r();

    public abstract double s();

    public abstract int t();

    public abstract int u();

    public abstract long v();

    public abstract float w();

    public abstract int x();

    public abstract long y();

    public AbstractC1063j() {
        this.f11043b = f11041f;
        this.f11044c = Integer.MAX_VALUE;
        this.f11046e = false;
    }
}
