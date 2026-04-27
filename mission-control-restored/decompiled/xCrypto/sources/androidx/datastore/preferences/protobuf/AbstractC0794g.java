package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0794g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile int f7005f = 100;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C0795h f7009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f7010e;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.g$b */
    public static final class b extends AbstractC0794g {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final byte[] f7011g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f7012h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f7013i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f7014j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f7015k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f7016l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f7017m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f7018n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f7019o;

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public String A() throws C0808v {
            int iL = L();
            if (iL > 0) {
                int i4 = this.f7013i;
                int i5 = this.f7015k;
                if (iL <= i4 - i5) {
                    String str = new String(this.f7011g, i5, iL, AbstractC0807u.f7208b);
                    this.f7015k += iL;
                    return str;
                }
            }
            if (iL == 0) {
                return "";
            }
            if (iL < 0) {
                throw C0808v.g();
            }
            throw C0808v.m();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public String B() throws C0808v {
            int iL = L();
            if (iL > 0) {
                int i4 = this.f7013i;
                int i5 = this.f7015k;
                if (iL <= i4 - i5) {
                    String strA = j0.a(this.f7011g, i5, iL);
                    this.f7015k += iL;
                    return strA;
                }
            }
            if (iL == 0) {
                return "";
            }
            if (iL <= 0) {
                throw C0808v.g();
            }
            throw C0808v.m();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public int C() throws C0808v {
            if (f()) {
                this.f7017m = 0;
                return 0;
            }
            int iL = L();
            this.f7017m = iL;
            if (k0.a(iL) != 0) {
                return this.f7017m;
            }
            throw C0808v.c();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public int D() {
            return L();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public long E() {
            return M();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public boolean F(int i4) throws C0808v {
            int iB = k0.b(i4);
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
                a(k0.c(k0.a(i4), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw C0808v.e();
            }
            P(4);
            return true;
        }

        public byte H() throws C0808v {
            int i4 = this.f7015k;
            if (i4 == this.f7013i) {
                throw C0808v.m();
            }
            byte[] bArr = this.f7011g;
            this.f7015k = i4 + 1;
            return bArr[i4];
        }

        public byte[] I(int i4) throws C0808v {
            if (i4 > 0) {
                int i5 = this.f7013i;
                int i6 = this.f7015k;
                if (i4 <= i5 - i6) {
                    int i7 = i4 + i6;
                    this.f7015k = i7;
                    return Arrays.copyOfRange(this.f7011g, i6, i7);
                }
            }
            if (i4 > 0) {
                throw C0808v.m();
            }
            if (i4 == 0) {
                return AbstractC0807u.f7210d;
            }
            throw C0808v.g();
        }

        public int J() throws C0808v {
            int i4 = this.f7015k;
            if (this.f7013i - i4 < 4) {
                throw C0808v.m();
            }
            byte[] bArr = this.f7011g;
            this.f7015k = i4 + 4;
            return ((bArr[i4 + 3] & 255) << 24) | (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16);
        }

        public long K() throws C0808v {
            int i4 = this.f7015k;
            if (this.f7013i - i4 < 8) {
                throw C0808v.m();
            }
            byte[] bArr = this.f7011g;
            this.f7015k = i4 + 8;
            return ((((long) bArr[i4 + 7]) & 255) << 56) | (((long) bArr[i4]) & 255) | ((((long) bArr[i4 + 1]) & 255) << 8) | ((((long) bArr[i4 + 2]) & 255) << 16) | ((((long) bArr[i4 + 3]) & 255) << 24) | ((((long) bArr[i4 + 4]) & 255) << 32) | ((((long) bArr[i4 + 5]) & 255) << 40) | ((((long) bArr[i4 + 6]) & 255) << 48);
        }

        public int L() {
            int i4;
            int i5 = this.f7015k;
            int i6 = this.f7013i;
            if (i6 != i5) {
                byte[] bArr = this.f7011g;
                int i7 = i5 + 1;
                byte b4 = bArr[i5];
                if (b4 >= 0) {
                    this.f7015k = i7;
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
                    this.f7015k = i8;
                    return i4;
                }
            }
            return (int) N();
        }

        public long M() {
            long j4;
            long j5;
            long j6;
            int i4 = this.f7015k;
            int i5 = this.f7013i;
            if (i5 != i4) {
                byte[] bArr = this.f7011g;
                int i6 = i4 + 1;
                byte b4 = bArr[i4];
                if (b4 >= 0) {
                    this.f7015k = i6;
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
                    this.f7015k = i7;
                    return j4;
                }
            }
            return N();
        }

        public long N() throws C0808v {
            long j4 = 0;
            for (int i4 = 0; i4 < 64; i4 += 7) {
                byte bH = H();
                j4 |= ((long) (bH & 127)) << i4;
                if ((bH & 128) == 0) {
                    return j4;
                }
            }
            throw C0808v.f();
        }

        public final void O() {
            int i4 = this.f7013i + this.f7014j;
            this.f7013i = i4;
            int i5 = i4 - this.f7016l;
            int i6 = this.f7019o;
            if (i5 <= i6) {
                this.f7014j = 0;
                return;
            }
            int i7 = i5 - i6;
            this.f7014j = i7;
            this.f7013i = i4 - i7;
        }

        public void P(int i4) throws C0808v {
            if (i4 >= 0) {
                int i5 = this.f7013i;
                int i6 = this.f7015k;
                if (i4 <= i5 - i6) {
                    this.f7015k = i6 + i4;
                    return;
                }
            }
            if (i4 >= 0) {
                throw C0808v.m();
            }
            throw C0808v.g();
        }

        public final void Q() throws C0808v {
            if (this.f7013i - this.f7015k >= 10) {
                R();
            } else {
                S();
            }
        }

        public final void R() throws C0808v {
            for (int i4 = 0; i4 < 10; i4++) {
                byte[] bArr = this.f7011g;
                int i5 = this.f7015k;
                this.f7015k = i5 + 1;
                if (bArr[i5] >= 0) {
                    return;
                }
            }
            throw C0808v.f();
        }

        public final void S() throws C0808v {
            for (int i4 = 0; i4 < 10; i4++) {
                if (H() >= 0) {
                    return;
                }
            }
            throw C0808v.f();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public void a(int i4) throws C0808v {
            if (this.f7017m != i4) {
                throw C0808v.b();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public int e() {
            return this.f7015k - this.f7016l;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public boolean f() {
            return this.f7015k == this.f7013i;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public void l(int i4) {
            this.f7019o = i4;
            O();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public int m(int i4) throws C0808v {
            if (i4 < 0) {
                throw C0808v.g();
            }
            int iE = i4 + e();
            if (iE < 0) {
                throw C0808v.h();
            }
            int i5 = this.f7019o;
            if (iE > i5) {
                throw C0808v.m();
            }
            this.f7019o = iE;
            O();
            return i5;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public boolean n() {
            return M() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public AbstractC0793f o() {
            int iL = L();
            if (iL > 0) {
                int i4 = this.f7013i;
                int i5 = this.f7015k;
                if (iL <= i4 - i5) {
                    AbstractC0793f abstractC0793fY = (this.f7012h && this.f7018n) ? AbstractC0793f.y(this.f7011g, i5, iL) : AbstractC0793f.m(this.f7011g, i5, iL);
                    this.f7015k += iL;
                    return abstractC0793fY;
                }
            }
            return iL == 0 ? AbstractC0793f.f6994b : AbstractC0793f.x(I(iL));
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public double p() {
            return Double.longBitsToDouble(K());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public int q() {
            return L();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public int r() {
            return J();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public long s() {
            return K();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public float t() {
            return Float.intBitsToFloat(J());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public int u() {
            return L();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public long v() {
            return M();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public int w() {
            return J();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public long x() {
            return K();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public int y() {
            return AbstractC0794g.c(L());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public long z() {
            return AbstractC0794g.d(M());
        }

        public b(byte[] bArr, int i4, int i5, boolean z4) {
            super();
            this.f7019o = Integer.MAX_VALUE;
            this.f7011g = bArr;
            this.f7013i = i5 + i4;
            this.f7015k = i4;
            this.f7016l = i4;
            this.f7012h = z4;
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.g$c */
    public static final class c extends AbstractC0794g {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final InputStream f7020g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final byte[] f7021h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f7022i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f7023j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f7024k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f7025l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f7026m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f7027n;

        public static int H(InputStream inputStream) throws C0808v {
            try {
                return inputStream.available();
            } catch (C0808v e4) {
                e4.j();
                throw e4;
            }
        }

        public static int I(InputStream inputStream, byte[] bArr, int i4, int i5) throws C0808v {
            try {
                return inputStream.read(bArr, i4, i5);
            } catch (C0808v e4) {
                e4.j();
                throw e4;
            }
        }

        private void T() {
            int i4 = this.f7022i + this.f7023j;
            this.f7022i = i4;
            int i5 = this.f7026m + i4;
            int i6 = this.f7027n;
            if (i5 <= i6) {
                this.f7023j = 0;
                return;
            }
            int i7 = i5 - i6;
            this.f7023j = i7;
            this.f7022i = i4 - i7;
        }

        public static long V(InputStream inputStream, long j4) throws C0808v {
            try {
                return inputStream.skip(j4);
            } catch (C0808v e4) {
                e4.j();
                throw e4;
            }
        }

        private void Y() throws C0808v {
            if (this.f7022i - this.f7024k >= 10) {
                Z();
            } else {
                a0();
            }
        }

        private void Z() throws C0808v {
            for (int i4 = 0; i4 < 10; i4++) {
                byte[] bArr = this.f7021h;
                int i5 = this.f7024k;
                this.f7024k = i5 + 1;
                if (bArr[i5] >= 0) {
                    return;
                }
            }
            throw C0808v.f();
        }

        private void a0() throws C0808v {
            for (int i4 = 0; i4 < 10; i4++) {
                if (K() >= 0) {
                    return;
                }
            }
            throw C0808v.f();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public String A() throws C0808v {
            int iQ = Q();
            if (iQ > 0) {
                int i4 = this.f7022i;
                int i5 = this.f7024k;
                if (iQ <= i4 - i5) {
                    String str = new String(this.f7021h, i5, iQ, AbstractC0807u.f7208b);
                    this.f7024k += iQ;
                    return str;
                }
            }
            if (iQ == 0) {
                return "";
            }
            if (iQ < 0) {
                throw C0808v.g();
            }
            if (iQ > this.f7022i) {
                return new String(L(iQ, false), AbstractC0807u.f7208b);
            }
            U(iQ);
            String str2 = new String(this.f7021h, this.f7024k, iQ, AbstractC0807u.f7208b);
            this.f7024k += iQ;
            return str2;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public String B() throws IOException {
            byte[] bArrL;
            int iQ = Q();
            int i4 = this.f7024k;
            int i5 = this.f7022i;
            if (iQ <= i5 - i4 && iQ > 0) {
                bArrL = this.f7021h;
                this.f7024k = i4 + iQ;
            } else {
                if (iQ == 0) {
                    return "";
                }
                if (iQ < 0) {
                    throw C0808v.g();
                }
                i4 = 0;
                if (iQ <= i5) {
                    U(iQ);
                    bArrL = this.f7021h;
                    this.f7024k = iQ;
                } else {
                    bArrL = L(iQ, false);
                }
            }
            return j0.a(bArrL, i4, iQ);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public int C() throws C0808v {
            if (f()) {
                this.f7025l = 0;
                return 0;
            }
            int iQ = Q();
            this.f7025l = iQ;
            if (k0.a(iQ) != 0) {
                return this.f7025l;
            }
            throw C0808v.c();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public int D() {
            return Q();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public long E() {
            return R();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public boolean F(int i4) throws C0808v {
            int iB = k0.b(i4);
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
                a(k0.c(k0.a(i4), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw C0808v.e();
            }
            W(4);
            return true;
        }

        public final AbstractC0793f J(int i4) throws IOException {
            byte[] bArrM = M(i4);
            if (bArrM != null) {
                return AbstractC0793f.l(bArrM);
            }
            int i5 = this.f7024k;
            int i6 = this.f7022i;
            int length = i6 - i5;
            this.f7026m += i6;
            this.f7024k = 0;
            this.f7022i = 0;
            List<byte[]> listN = N(i4 - length);
            byte[] bArr = new byte[i4];
            System.arraycopy(this.f7021h, i5, bArr, 0, length);
            for (byte[] bArr2 : listN) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return AbstractC0793f.x(bArr);
        }

        public byte K() throws C0808v {
            if (this.f7024k == this.f7022i) {
                U(1);
            }
            byte[] bArr = this.f7021h;
            int i4 = this.f7024k;
            this.f7024k = i4 + 1;
            return bArr[i4];
        }

        public final byte[] L(int i4, boolean z4) throws IOException {
            byte[] bArrM = M(i4);
            if (bArrM != null) {
                return z4 ? (byte[]) bArrM.clone() : bArrM;
            }
            int i5 = this.f7024k;
            int i6 = this.f7022i;
            int length = i6 - i5;
            this.f7026m += i6;
            this.f7024k = 0;
            this.f7022i = 0;
            List<byte[]> listN = N(i4 - length);
            byte[] bArr = new byte[i4];
            System.arraycopy(this.f7021h, i5, bArr, 0, length);
            for (byte[] bArr2 : listN) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return bArr;
        }

        public final byte[] M(int i4) throws C0808v {
            if (i4 == 0) {
                return AbstractC0807u.f7210d;
            }
            if (i4 < 0) {
                throw C0808v.g();
            }
            int i5 = this.f7026m;
            int i6 = this.f7024k;
            int i7 = i5 + i6 + i4;
            if (i7 - this.f7008c > 0) {
                throw C0808v.l();
            }
            int i8 = this.f7027n;
            if (i7 > i8) {
                W((i8 - i5) - i6);
                throw C0808v.m();
            }
            int i9 = this.f7022i - i6;
            int i10 = i4 - i9;
            if (i10 >= 4096 && i10 > H(this.f7020g)) {
                return null;
            }
            byte[] bArr = new byte[i4];
            System.arraycopy(this.f7021h, this.f7024k, bArr, 0, i9);
            this.f7026m += this.f7022i;
            this.f7024k = 0;
            this.f7022i = 0;
            while (i9 < i4) {
                int I4 = I(this.f7020g, bArr, i9, i4 - i9);
                if (I4 == -1) {
                    throw C0808v.m();
                }
                this.f7026m += I4;
                i9 += I4;
            }
            return bArr;
        }

        public final List N(int i4) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i4 > 0) {
                int iMin = Math.min(i4, 4096);
                byte[] bArr = new byte[iMin];
                int i5 = 0;
                while (i5 < iMin) {
                    int i6 = this.f7020g.read(bArr, i5, iMin - i5);
                    if (i6 == -1) {
                        throw C0808v.m();
                    }
                    this.f7026m += i6;
                    i5 += i6;
                }
                i4 -= iMin;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        public int O() throws C0808v {
            int i4 = this.f7024k;
            if (this.f7022i - i4 < 4) {
                U(4);
                i4 = this.f7024k;
            }
            byte[] bArr = this.f7021h;
            this.f7024k = i4 + 4;
            return ((bArr[i4 + 3] & 255) << 24) | (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16);
        }

        public long P() throws C0808v {
            int i4 = this.f7024k;
            if (this.f7022i - i4 < 8) {
                U(8);
                i4 = this.f7024k;
            }
            byte[] bArr = this.f7021h;
            this.f7024k = i4 + 8;
            return ((((long) bArr[i4 + 7]) & 255) << 56) | (((long) bArr[i4]) & 255) | ((((long) bArr[i4 + 1]) & 255) << 8) | ((((long) bArr[i4 + 2]) & 255) << 16) | ((((long) bArr[i4 + 3]) & 255) << 24) | ((((long) bArr[i4 + 4]) & 255) << 32) | ((((long) bArr[i4 + 5]) & 255) << 40) | ((((long) bArr[i4 + 6]) & 255) << 48);
        }

        public int Q() {
            int i4;
            int i5 = this.f7024k;
            int i6 = this.f7022i;
            if (i6 != i5) {
                byte[] bArr = this.f7021h;
                int i7 = i5 + 1;
                byte b4 = bArr[i5];
                if (b4 >= 0) {
                    this.f7024k = i7;
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
                    this.f7024k = i8;
                    return i4;
                }
            }
            return (int) S();
        }

        public long R() {
            long j4;
            long j5;
            long j6;
            int i4 = this.f7024k;
            int i5 = this.f7022i;
            if (i5 != i4) {
                byte[] bArr = this.f7021h;
                int i6 = i4 + 1;
                byte b4 = bArr[i4];
                if (b4 >= 0) {
                    this.f7024k = i6;
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
                    this.f7024k = i7;
                    return j4;
                }
            }
            return S();
        }

        public long S() throws C0808v {
            long j4 = 0;
            for (int i4 = 0; i4 < 64; i4 += 7) {
                byte bK = K();
                j4 |= ((long) (bK & 127)) << i4;
                if ((bK & 128) == 0) {
                    return j4;
                }
            }
            throw C0808v.f();
        }

        public final void U(int i4) throws C0808v {
            if (b0(i4)) {
                return;
            }
            if (i4 <= (this.f7008c - this.f7026m) - this.f7024k) {
                throw C0808v.m();
            }
            throw C0808v.l();
        }

        public void W(int i4) throws C0808v {
            int i5 = this.f7022i;
            int i6 = this.f7024k;
            if (i4 > i5 - i6 || i4 < 0) {
                X(i4);
            } else {
                this.f7024k = i6 + i4;
            }
        }

        public final void X(int i4) throws C0808v {
            if (i4 < 0) {
                throw C0808v.g();
            }
            int i5 = this.f7026m;
            int i6 = this.f7024k;
            int i7 = i5 + i6 + i4;
            int i8 = this.f7027n;
            if (i7 > i8) {
                W((i8 - i5) - i6);
                throw C0808v.m();
            }
            this.f7026m = i5 + i6;
            int i9 = this.f7022i - i6;
            this.f7022i = 0;
            this.f7024k = 0;
            while (i9 < i4) {
                try {
                    long j4 = i4 - i9;
                    long jV = V(this.f7020g, j4);
                    if (jV < 0 || jV > j4) {
                        throw new IllegalStateException(this.f7020g.getClass() + "#skip returned invalid result: " + jV + "\nThe InputStream implementation is buggy.");
                    }
                    if (jV == 0) {
                        break;
                    } else {
                        i9 += (int) jV;
                    }
                } finally {
                    this.f7026m += i9;
                    T();
                }
            }
            if (i9 >= i4) {
                return;
            }
            int i10 = this.f7022i;
            int i11 = i10 - this.f7024k;
            this.f7024k = i10;
            U(1);
            while (true) {
                int i12 = i4 - i11;
                int i13 = this.f7022i;
                if (i12 <= i13) {
                    this.f7024k = i12;
                    return;
                } else {
                    i11 += i13;
                    this.f7024k = i13;
                    U(1);
                }
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public void a(int i4) throws C0808v {
            if (this.f7025l != i4) {
                throw C0808v.b();
            }
        }

        public final boolean b0(int i4) throws C0808v {
            int i5 = this.f7024k;
            int i6 = i5 + i4;
            int i7 = this.f7022i;
            if (i6 <= i7) {
                throw new IllegalStateException("refillBuffer() called when " + i4 + " bytes were already available in buffer");
            }
            int i8 = this.f7008c;
            int i9 = this.f7026m;
            if (i4 > (i8 - i9) - i5 || i9 + i5 + i4 > this.f7027n) {
                return false;
            }
            if (i5 > 0) {
                if (i7 > i5) {
                    byte[] bArr = this.f7021h;
                    System.arraycopy(bArr, i5, bArr, 0, i7 - i5);
                }
                this.f7026m += i5;
                this.f7022i -= i5;
                this.f7024k = 0;
            }
            InputStream inputStream = this.f7020g;
            byte[] bArr2 = this.f7021h;
            int i10 = this.f7022i;
            int I4 = I(inputStream, bArr2, i10, Math.min(bArr2.length - i10, (this.f7008c - this.f7026m) - i10));
            if (I4 == 0 || I4 < -1 || I4 > this.f7021h.length) {
                throw new IllegalStateException(this.f7020g.getClass() + "#read(byte[]) returned invalid result: " + I4 + "\nThe InputStream implementation is buggy.");
            }
            if (I4 <= 0) {
                return false;
            }
            this.f7022i += I4;
            T();
            if (this.f7022i >= i4) {
                return true;
            }
            return b0(i4);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public int e() {
            return this.f7026m + this.f7024k;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public boolean f() {
            return this.f7024k == this.f7022i && !b0(1);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public void l(int i4) {
            this.f7027n = i4;
            T();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public int m(int i4) throws C0808v {
            if (i4 < 0) {
                throw C0808v.g();
            }
            int i5 = i4 + this.f7026m + this.f7024k;
            if (i5 < 0) {
                throw C0808v.h();
            }
            int i6 = this.f7027n;
            if (i5 > i6) {
                throw C0808v.m();
            }
            this.f7027n = i5;
            T();
            return i6;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public boolean n() {
            return R() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public AbstractC0793f o() throws C0808v {
            int iQ = Q();
            int i4 = this.f7022i;
            int i5 = this.f7024k;
            if (iQ <= i4 - i5 && iQ > 0) {
                AbstractC0793f abstractC0793fM = AbstractC0793f.m(this.f7021h, i5, iQ);
                this.f7024k += iQ;
                return abstractC0793fM;
            }
            if (iQ == 0) {
                return AbstractC0793f.f6994b;
            }
            if (iQ >= 0) {
                return J(iQ);
            }
            throw C0808v.g();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public double p() {
            return Double.longBitsToDouble(P());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public int q() {
            return Q();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public int r() {
            return O();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public long s() {
            return P();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public float t() {
            return Float.intBitsToFloat(O());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public int u() {
            return Q();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public long v() {
            return R();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public int w() {
            return O();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public long x() {
            return P();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public int y() {
            return AbstractC0794g.c(Q());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0794g
        public long z() {
            return AbstractC0794g.d(R());
        }

        public c(InputStream inputStream, int i4) {
            super();
            this.f7027n = Integer.MAX_VALUE;
            AbstractC0807u.b(inputStream, "input");
            this.f7020g = inputStream;
            this.f7021h = new byte[i4];
            this.f7022i = 0;
            this.f7024k = 0;
            this.f7026m = 0;
        }
    }

    public static int c(int i4) {
        return (-(i4 & 1)) ^ (i4 >>> 1);
    }

    public static long d(long j4) {
        return (-(j4 & 1)) ^ (j4 >>> 1);
    }

    public static AbstractC0794g g(InputStream inputStream) {
        return h(inputStream, 4096);
    }

    public static AbstractC0794g h(InputStream inputStream, int i4) {
        if (i4 > 0) {
            return inputStream == null ? i(AbstractC0807u.f7210d) : new c(inputStream, i4);
        }
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    public static AbstractC0794g i(byte[] bArr) {
        return j(bArr, 0, bArr.length);
    }

    public static AbstractC0794g j(byte[] bArr, int i4, int i5) {
        return k(bArr, i4, i5, false);
    }

    public static AbstractC0794g k(byte[] bArr, int i4, int i5, boolean z4) {
        b bVar = new b(bArr, i4, i5, z4);
        try {
            bVar.m(i5);
            return bVar;
        } catch (C0808v e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    public abstract String A();

    public abstract String B();

    public abstract int C();

    public abstract int D();

    public abstract long E();

    public abstract boolean F(int i4);

    public void G() throws C0808v {
        int iC;
        do {
            iC = C();
            if (iC == 0) {
                return;
            }
            b();
            this.f7006a++;
            this.f7006a--;
        } while (F(iC));
    }

    public abstract void a(int i4);

    public void b() throws C0808v {
        if (this.f7006a >= this.f7007b) {
            throw C0808v.i();
        }
    }

    public abstract int e();

    public abstract boolean f();

    public abstract void l(int i4);

    public abstract int m(int i4);

    public abstract boolean n();

    public abstract AbstractC0793f o();

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

    public AbstractC0794g() {
        this.f7007b = f7005f;
        this.f7008c = Integer.MAX_VALUE;
        this.f7010e = false;
    }
}
