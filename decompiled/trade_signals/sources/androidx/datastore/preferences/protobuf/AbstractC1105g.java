package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1105g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile int f11225f = 100;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C1106h f11229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f11230e;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.g$b */
    public static final class b extends AbstractC1105g {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final byte[] f11231g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f11232h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f11233i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f11234j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f11235k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f11236l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f11237m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f11238n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f11239o;

        public b(byte[] bArr, int i8, int i9, boolean z7) {
            super();
            this.f11239o = Integer.MAX_VALUE;
            this.f11231g = bArr;
            this.f11233i = i9 + i8;
            this.f11235k = i8;
            this.f11236l = i8;
            this.f11232h = z7;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public String A() throws C1119v {
            int iL = L();
            if (iL > 0) {
                int i8 = this.f11233i;
                int i9 = this.f11235k;
                if (iL <= i8 - i9) {
                    String str = new String(this.f11231g, i9, iL, AbstractC1118u.f11428b);
                    this.f11235k += iL;
                    return str;
                }
            }
            if (iL == 0) {
                return "";
            }
            if (iL < 0) {
                throw C1119v.g();
            }
            throw C1119v.m();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public String B() throws C1119v {
            int iL = L();
            if (iL > 0) {
                int i8 = this.f11233i;
                int i9 = this.f11235k;
                if (iL <= i8 - i9) {
                    String strA = j0.a(this.f11231g, i9, iL);
                    this.f11235k += iL;
                    return strA;
                }
            }
            if (iL == 0) {
                return "";
            }
            if (iL <= 0) {
                throw C1119v.g();
            }
            throw C1119v.m();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public int C() throws C1119v {
            if (f()) {
                this.f11237m = 0;
                return 0;
            }
            int iL = L();
            this.f11237m = iL;
            if (k0.a(iL) != 0) {
                return this.f11237m;
            }
            throw C1119v.c();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public int D() {
            return L();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public long E() {
            return M();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public boolean F(int i8) throws C1119v {
            int iB = k0.b(i8);
            if (iB == 0) {
                Q();
                return true;
            }
            if (iB == 1) {
                P(8);
                return true;
            }
            if (iB == 2) {
                P(L());
                return true;
            }
            if (iB == 3) {
                G();
                a(k0.c(k0.a(i8), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw C1119v.e();
            }
            P(4);
            return true;
        }

        public byte H() throws C1119v {
            int i8 = this.f11235k;
            if (i8 == this.f11233i) {
                throw C1119v.m();
            }
            byte[] bArr = this.f11231g;
            this.f11235k = i8 + 1;
            return bArr[i8];
        }

        public byte[] I(int i8) throws C1119v {
            if (i8 > 0) {
                int i9 = this.f11233i;
                int i10 = this.f11235k;
                if (i8 <= i9 - i10) {
                    int i11 = i8 + i10;
                    this.f11235k = i11;
                    return Arrays.copyOfRange(this.f11231g, i10, i11);
                }
            }
            if (i8 > 0) {
                throw C1119v.m();
            }
            if (i8 == 0) {
                return AbstractC1118u.f11430d;
            }
            throw C1119v.g();
        }

        public int J() throws C1119v {
            int i8 = this.f11235k;
            if (this.f11233i - i8 < 4) {
                throw C1119v.m();
            }
            byte[] bArr = this.f11231g;
            this.f11235k = i8 + 4;
            return ((bArr[i8 + 3] & 255) << 24) | (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16);
        }

        public long K() throws C1119v {
            int i8 = this.f11235k;
            if (this.f11233i - i8 < 8) {
                throw C1119v.m();
            }
            byte[] bArr = this.f11231g;
            this.f11235k = i8 + 8;
            return ((((long) bArr[i8 + 7]) & 255) << 56) | (((long) bArr[i8]) & 255) | ((((long) bArr[i8 + 1]) & 255) << 8) | ((((long) bArr[i8 + 2]) & 255) << 16) | ((((long) bArr[i8 + 3]) & 255) << 24) | ((((long) bArr[i8 + 4]) & 255) << 32) | ((((long) bArr[i8 + 5]) & 255) << 40) | ((((long) bArr[i8 + 6]) & 255) << 48);
        }

        public int L() {
            int i8;
            int i9 = this.f11235k;
            int i10 = this.f11233i;
            if (i10 != i9) {
                byte[] bArr = this.f11231g;
                int i11 = i9 + 1;
                byte b8 = bArr[i9];
                if (b8 >= 0) {
                    this.f11235k = i11;
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
                    this.f11235k = i12;
                    return i8;
                }
            }
            return (int) N();
        }

        public long M() {
            long j8;
            long j9;
            long j10;
            int i8 = this.f11235k;
            int i9 = this.f11233i;
            if (i9 != i8) {
                byte[] bArr = this.f11231g;
                int i10 = i8 + 1;
                byte b8 = bArr[i8];
                if (b8 >= 0) {
                    this.f11235k = i10;
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
                    this.f11235k = i11;
                    return j8;
                }
            }
            return N();
        }

        public long N() throws C1119v {
            long j8 = 0;
            for (int i8 = 0; i8 < 64; i8 += 7) {
                byte bH = H();
                j8 |= ((long) (bH & 127)) << i8;
                if ((bH & 128) == 0) {
                    return j8;
                }
            }
            throw C1119v.f();
        }

        public final void O() {
            int i8 = this.f11233i + this.f11234j;
            this.f11233i = i8;
            int i9 = i8 - this.f11236l;
            int i10 = this.f11239o;
            if (i9 <= i10) {
                this.f11234j = 0;
                return;
            }
            int i11 = i9 - i10;
            this.f11234j = i11;
            this.f11233i = i8 - i11;
        }

        public void P(int i8) throws C1119v {
            if (i8 >= 0) {
                int i9 = this.f11233i;
                int i10 = this.f11235k;
                if (i8 <= i9 - i10) {
                    this.f11235k = i10 + i8;
                    return;
                }
            }
            if (i8 >= 0) {
                throw C1119v.m();
            }
            throw C1119v.g();
        }

        public final void Q() throws C1119v {
            if (this.f11233i - this.f11235k >= 10) {
                R();
            } else {
                S();
            }
        }

        public final void R() throws C1119v {
            for (int i8 = 0; i8 < 10; i8++) {
                byte[] bArr = this.f11231g;
                int i9 = this.f11235k;
                this.f11235k = i9 + 1;
                if (bArr[i9] >= 0) {
                    return;
                }
            }
            throw C1119v.f();
        }

        public final void S() throws C1119v {
            for (int i8 = 0; i8 < 10; i8++) {
                if (H() >= 0) {
                    return;
                }
            }
            throw C1119v.f();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public void a(int i8) throws C1119v {
            if (this.f11237m != i8) {
                throw C1119v.b();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public int e() {
            return this.f11235k - this.f11236l;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public boolean f() {
            return this.f11235k == this.f11233i;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public void l(int i8) {
            this.f11239o = i8;
            O();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public int m(int i8) throws C1119v {
            if (i8 < 0) {
                throw C1119v.g();
            }
            int iE = i8 + e();
            if (iE < 0) {
                throw C1119v.h();
            }
            int i9 = this.f11239o;
            if (iE > i9) {
                throw C1119v.m();
            }
            this.f11239o = iE;
            O();
            return i9;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public boolean n() {
            return M() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public AbstractC1104f o() {
            int iL = L();
            if (iL > 0) {
                int i8 = this.f11233i;
                int i9 = this.f11235k;
                if (iL <= i8 - i9) {
                    AbstractC1104f abstractC1104fQ = (this.f11232h && this.f11238n) ? AbstractC1104f.Q(this.f11231g, i9, iL) : AbstractC1104f.n(this.f11231g, i9, iL);
                    this.f11235k += iL;
                    return abstractC1104fQ;
                }
            }
            return iL == 0 ? AbstractC1104f.f11214b : AbstractC1104f.P(I(iL));
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public double p() {
            return Double.longBitsToDouble(K());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public int q() {
            return L();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public int r() {
            return J();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public long s() {
            return K();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public float t() {
            return Float.intBitsToFloat(J());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public int u() {
            return L();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public long v() {
            return M();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public int w() {
            return J();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public long x() {
            return K();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public int y() {
            return AbstractC1105g.c(L());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public long z() {
            return AbstractC1105g.d(M());
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.g$c */
    public static final class c extends AbstractC1105g {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final InputStream f11240g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final byte[] f11241h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f11242i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f11243j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f11244k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f11245l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f11246m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f11247n;

        public c(InputStream inputStream, int i8) {
            super();
            this.f11247n = Integer.MAX_VALUE;
            AbstractC1118u.b(inputStream, "input");
            this.f11240g = inputStream;
            this.f11241h = new byte[i8];
            this.f11242i = 0;
            this.f11244k = 0;
            this.f11246m = 0;
        }

        public static int H(InputStream inputStream) throws C1119v {
            try {
                return inputStream.available();
            } catch (C1119v e8) {
                e8.j();
                throw e8;
            }
        }

        public static int I(InputStream inputStream, byte[] bArr, int i8, int i9) throws C1119v {
            try {
                return inputStream.read(bArr, i8, i9);
            } catch (C1119v e8) {
                e8.j();
                throw e8;
            }
        }

        private void T() {
            int i8 = this.f11242i + this.f11243j;
            this.f11242i = i8;
            int i9 = this.f11246m + i8;
            int i10 = this.f11247n;
            if (i9 <= i10) {
                this.f11243j = 0;
                return;
            }
            int i11 = i9 - i10;
            this.f11243j = i11;
            this.f11242i = i8 - i11;
        }

        public static long V(InputStream inputStream, long j8) throws C1119v {
            try {
                return inputStream.skip(j8);
            } catch (C1119v e8) {
                e8.j();
                throw e8;
            }
        }

        private void Y() throws C1119v {
            if (this.f11242i - this.f11244k >= 10) {
                Z();
            } else {
                a0();
            }
        }

        private void Z() throws C1119v {
            for (int i8 = 0; i8 < 10; i8++) {
                byte[] bArr = this.f11241h;
                int i9 = this.f11244k;
                this.f11244k = i9 + 1;
                if (bArr[i9] >= 0) {
                    return;
                }
            }
            throw C1119v.f();
        }

        private void a0() throws C1119v {
            for (int i8 = 0; i8 < 10; i8++) {
                if (K() >= 0) {
                    return;
                }
            }
            throw C1119v.f();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public String A() throws C1119v {
            int iQ = Q();
            if (iQ > 0) {
                int i8 = this.f11242i;
                int i9 = this.f11244k;
                if (iQ <= i8 - i9) {
                    String str = new String(this.f11241h, i9, iQ, AbstractC1118u.f11428b);
                    this.f11244k += iQ;
                    return str;
                }
            }
            if (iQ == 0) {
                return "";
            }
            if (iQ < 0) {
                throw C1119v.g();
            }
            if (iQ > this.f11242i) {
                return new String(L(iQ, false), AbstractC1118u.f11428b);
            }
            U(iQ);
            String str2 = new String(this.f11241h, this.f11244k, iQ, AbstractC1118u.f11428b);
            this.f11244k += iQ;
            return str2;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public String B() throws IOException {
            byte[] bArrL;
            int iQ = Q();
            int i8 = this.f11244k;
            int i9 = this.f11242i;
            if (iQ <= i9 - i8 && iQ > 0) {
                bArrL = this.f11241h;
                this.f11244k = i8 + iQ;
            } else {
                if (iQ == 0) {
                    return "";
                }
                if (iQ < 0) {
                    throw C1119v.g();
                }
                i8 = 0;
                if (iQ <= i9) {
                    U(iQ);
                    bArrL = this.f11241h;
                    this.f11244k = iQ;
                } else {
                    bArrL = L(iQ, false);
                }
            }
            return j0.a(bArrL, i8, iQ);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public int C() throws C1119v {
            if (f()) {
                this.f11245l = 0;
                return 0;
            }
            int iQ = Q();
            this.f11245l = iQ;
            if (k0.a(iQ) != 0) {
                return this.f11245l;
            }
            throw C1119v.c();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public int D() {
            return Q();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public long E() {
            return R();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public boolean F(int i8) throws C1119v {
            int iB = k0.b(i8);
            if (iB == 0) {
                Y();
                return true;
            }
            if (iB == 1) {
                W(8);
                return true;
            }
            if (iB == 2) {
                W(Q());
                return true;
            }
            if (iB == 3) {
                G();
                a(k0.c(k0.a(i8), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw C1119v.e();
            }
            W(4);
            return true;
        }

        public final AbstractC1104f J(int i8) throws IOException {
            byte[] bArrM = M(i8);
            if (bArrM != null) {
                return AbstractC1104f.h(bArrM);
            }
            int i9 = this.f11244k;
            int i10 = this.f11242i;
            int length = i10 - i9;
            this.f11246m += i10;
            this.f11244k = 0;
            this.f11242i = 0;
            List<byte[]> listN = N(i8 - length);
            byte[] bArr = new byte[i8];
            System.arraycopy(this.f11241h, i9, bArr, 0, length);
            for (byte[] bArr2 : listN) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return AbstractC1104f.P(bArr);
        }

        public byte K() throws C1119v {
            if (this.f11244k == this.f11242i) {
                U(1);
            }
            byte[] bArr = this.f11241h;
            int i8 = this.f11244k;
            this.f11244k = i8 + 1;
            return bArr[i8];
        }

        public final byte[] L(int i8, boolean z7) throws IOException {
            byte[] bArrM = M(i8);
            if (bArrM != null) {
                return z7 ? (byte[]) bArrM.clone() : bArrM;
            }
            int i9 = this.f11244k;
            int i10 = this.f11242i;
            int length = i10 - i9;
            this.f11246m += i10;
            this.f11244k = 0;
            this.f11242i = 0;
            List<byte[]> listN = N(i8 - length);
            byte[] bArr = new byte[i8];
            System.arraycopy(this.f11241h, i9, bArr, 0, length);
            for (byte[] bArr2 : listN) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return bArr;
        }

        public final byte[] M(int i8) throws C1119v {
            if (i8 == 0) {
                return AbstractC1118u.f11430d;
            }
            if (i8 < 0) {
                throw C1119v.g();
            }
            int i9 = this.f11246m;
            int i10 = this.f11244k;
            int i11 = i9 + i10 + i8;
            if (i11 - this.f11228c > 0) {
                throw C1119v.l();
            }
            int i12 = this.f11247n;
            if (i11 > i12) {
                W((i12 - i9) - i10);
                throw C1119v.m();
            }
            int i13 = this.f11242i - i10;
            int i14 = i8 - i13;
            if (i14 >= 4096 && i14 > H(this.f11240g)) {
                return null;
            }
            byte[] bArr = new byte[i8];
            System.arraycopy(this.f11241h, this.f11244k, bArr, 0, i13);
            this.f11246m += this.f11242i;
            this.f11244k = 0;
            this.f11242i = 0;
            while (i13 < i8) {
                int I7 = I(this.f11240g, bArr, i13, i8 - i13);
                if (I7 == -1) {
                    throw C1119v.m();
                }
                this.f11246m += I7;
                i13 += I7;
            }
            return bArr;
        }

        public final List N(int i8) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i8 > 0) {
                int iMin = Math.min(i8, 4096);
                byte[] bArr = new byte[iMin];
                int i9 = 0;
                while (i9 < iMin) {
                    int i10 = this.f11240g.read(bArr, i9, iMin - i9);
                    if (i10 == -1) {
                        throw C1119v.m();
                    }
                    this.f11246m += i10;
                    i9 += i10;
                }
                i8 -= iMin;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        public int O() throws C1119v {
            int i8 = this.f11244k;
            if (this.f11242i - i8 < 4) {
                U(4);
                i8 = this.f11244k;
            }
            byte[] bArr = this.f11241h;
            this.f11244k = i8 + 4;
            return ((bArr[i8 + 3] & 255) << 24) | (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16);
        }

        public long P() throws C1119v {
            int i8 = this.f11244k;
            if (this.f11242i - i8 < 8) {
                U(8);
                i8 = this.f11244k;
            }
            byte[] bArr = this.f11241h;
            this.f11244k = i8 + 8;
            return ((((long) bArr[i8 + 7]) & 255) << 56) | (((long) bArr[i8]) & 255) | ((((long) bArr[i8 + 1]) & 255) << 8) | ((((long) bArr[i8 + 2]) & 255) << 16) | ((((long) bArr[i8 + 3]) & 255) << 24) | ((((long) bArr[i8 + 4]) & 255) << 32) | ((((long) bArr[i8 + 5]) & 255) << 40) | ((((long) bArr[i8 + 6]) & 255) << 48);
        }

        public int Q() {
            int i8;
            int i9 = this.f11244k;
            int i10 = this.f11242i;
            if (i10 != i9) {
                byte[] bArr = this.f11241h;
                int i11 = i9 + 1;
                byte b8 = bArr[i9];
                if (b8 >= 0) {
                    this.f11244k = i11;
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
                    this.f11244k = i12;
                    return i8;
                }
            }
            return (int) S();
        }

        public long R() {
            long j8;
            long j9;
            long j10;
            int i8 = this.f11244k;
            int i9 = this.f11242i;
            if (i9 != i8) {
                byte[] bArr = this.f11241h;
                int i10 = i8 + 1;
                byte b8 = bArr[i8];
                if (b8 >= 0) {
                    this.f11244k = i10;
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
                    this.f11244k = i11;
                    return j8;
                }
            }
            return S();
        }

        public long S() throws C1119v {
            long j8 = 0;
            for (int i8 = 0; i8 < 64; i8 += 7) {
                byte bK = K();
                j8 |= ((long) (bK & 127)) << i8;
                if ((bK & 128) == 0) {
                    return j8;
                }
            }
            throw C1119v.f();
        }

        public final void U(int i8) throws C1119v {
            if (b0(i8)) {
                return;
            }
            if (i8 <= (this.f11228c - this.f11246m) - this.f11244k) {
                throw C1119v.m();
            }
            throw C1119v.l();
        }

        public void W(int i8) throws C1119v {
            int i9 = this.f11242i;
            int i10 = this.f11244k;
            if (i8 > i9 - i10 || i8 < 0) {
                X(i8);
            } else {
                this.f11244k = i10 + i8;
            }
        }

        public final void X(int i8) throws C1119v {
            if (i8 < 0) {
                throw C1119v.g();
            }
            int i9 = this.f11246m;
            int i10 = this.f11244k;
            int i11 = i9 + i10 + i8;
            int i12 = this.f11247n;
            if (i11 > i12) {
                W((i12 - i9) - i10);
                throw C1119v.m();
            }
            this.f11246m = i9 + i10;
            int i13 = this.f11242i - i10;
            this.f11242i = 0;
            this.f11244k = 0;
            while (i13 < i8) {
                try {
                    long j8 = i8 - i13;
                    long jV = V(this.f11240g, j8);
                    if (jV < 0 || jV > j8) {
                        throw new IllegalStateException(this.f11240g.getClass() + "#skip returned invalid result: " + jV + "\nThe InputStream implementation is buggy.");
                    }
                    if (jV == 0) {
                        break;
                    } else {
                        i13 += (int) jV;
                    }
                } finally {
                    this.f11246m += i13;
                    T();
                }
            }
            if (i13 >= i8) {
                return;
            }
            int i14 = this.f11242i;
            int i15 = i14 - this.f11244k;
            this.f11244k = i14;
            while (true) {
                U(1);
                int i16 = i8 - i15;
                int i17 = this.f11242i;
                if (i16 <= i17) {
                    this.f11244k = i16;
                    return;
                } else {
                    i15 += i17;
                    this.f11244k = i17;
                }
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public void a(int i8) throws C1119v {
            if (this.f11245l != i8) {
                throw C1119v.b();
            }
        }

        public final boolean b0(int i8) throws C1119v {
            int i9 = this.f11244k;
            int i10 = i9 + i8;
            int i11 = this.f11242i;
            if (i10 <= i11) {
                throw new IllegalStateException("refillBuffer() called when " + i8 + " bytes were already available in buffer");
            }
            int i12 = this.f11228c;
            int i13 = this.f11246m;
            if (i8 > (i12 - i13) - i9 || i13 + i9 + i8 > this.f11247n) {
                return false;
            }
            if (i9 > 0) {
                if (i11 > i9) {
                    byte[] bArr = this.f11241h;
                    System.arraycopy(bArr, i9, bArr, 0, i11 - i9);
                }
                this.f11246m += i9;
                this.f11242i -= i9;
                this.f11244k = 0;
            }
            InputStream inputStream = this.f11240g;
            byte[] bArr2 = this.f11241h;
            int i14 = this.f11242i;
            int I7 = I(inputStream, bArr2, i14, Math.min(bArr2.length - i14, (this.f11228c - this.f11246m) - i14));
            if (I7 == 0 || I7 < -1 || I7 > this.f11241h.length) {
                throw new IllegalStateException(this.f11240g.getClass() + "#read(byte[]) returned invalid result: " + I7 + "\nThe InputStream implementation is buggy.");
            }
            if (I7 <= 0) {
                return false;
            }
            this.f11242i += I7;
            T();
            if (this.f11242i >= i8) {
                return true;
            }
            return b0(i8);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public int e() {
            return this.f11246m + this.f11244k;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public boolean f() {
            return this.f11244k == this.f11242i && !b0(1);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public void l(int i8) {
            this.f11247n = i8;
            T();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public int m(int i8) throws C1119v {
            if (i8 < 0) {
                throw C1119v.g();
            }
            int i9 = i8 + this.f11246m + this.f11244k;
            if (i9 < 0) {
                throw C1119v.h();
            }
            int i10 = this.f11247n;
            if (i9 > i10) {
                throw C1119v.m();
            }
            this.f11247n = i9;
            T();
            return i10;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public boolean n() {
            return R() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public AbstractC1104f o() throws C1119v {
            int iQ = Q();
            int i8 = this.f11242i;
            int i9 = this.f11244k;
            if (iQ <= i8 - i9 && iQ > 0) {
                AbstractC1104f abstractC1104fN = AbstractC1104f.n(this.f11241h, i9, iQ);
                this.f11244k += iQ;
                return abstractC1104fN;
            }
            if (iQ == 0) {
                return AbstractC1104f.f11214b;
            }
            if (iQ >= 0) {
                return J(iQ);
            }
            throw C1119v.g();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public double p() {
            return Double.longBitsToDouble(P());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public int q() {
            return Q();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public int r() {
            return O();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public long s() {
            return P();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public float t() {
            return Float.intBitsToFloat(O());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public int u() {
            return Q();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public long v() {
            return R();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public int w() {
            return O();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public long x() {
            return P();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public int y() {
            return AbstractC1105g.c(Q());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1105g
        public long z() {
            return AbstractC1105g.d(R());
        }
    }

    public AbstractC1105g() {
        this.f11227b = f11225f;
        this.f11228c = Integer.MAX_VALUE;
        this.f11230e = false;
    }

    public static int c(int i8) {
        return (-(i8 & 1)) ^ (i8 >>> 1);
    }

    public static long d(long j8) {
        return (-(j8 & 1)) ^ (j8 >>> 1);
    }

    public static AbstractC1105g g(InputStream inputStream) {
        return h(inputStream, 4096);
    }

    public static AbstractC1105g h(InputStream inputStream, int i8) {
        if (i8 > 0) {
            return inputStream == null ? i(AbstractC1118u.f11430d) : new c(inputStream, i8);
        }
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    public static AbstractC1105g i(byte[] bArr) {
        return j(bArr, 0, bArr.length);
    }

    public static AbstractC1105g j(byte[] bArr, int i8, int i9) {
        return k(bArr, i8, i9, false);
    }

    public static AbstractC1105g k(byte[] bArr, int i8, int i9, boolean z7) {
        b bVar = new b(bArr, i8, i9, z7);
        try {
            bVar.m(i9);
            return bVar;
        } catch (C1119v e8) {
            throw new IllegalArgumentException(e8);
        }
    }

    public abstract String A();

    public abstract String B();

    public abstract int C();

    public abstract int D();

    public abstract long E();

    public abstract boolean F(int i8);

    public void G() throws C1119v {
        int iC;
        do {
            iC = C();
            if (iC == 0) {
                return;
            }
            b();
            this.f11226a++;
            this.f11226a--;
        } while (F(iC));
    }

    public abstract void a(int i8);

    public void b() throws C1119v {
        if (this.f11226a >= this.f11227b) {
            throw C1119v.i();
        }
    }

    public abstract int e();

    public abstract boolean f();

    public abstract void l(int i8);

    public abstract int m(int i8);

    public abstract boolean n();

    public abstract AbstractC1104f o();

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
