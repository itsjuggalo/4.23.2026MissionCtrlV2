package androidx.datastore.preferences.protobuf;

import com.google.android.gms.common.api.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0936g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile int f7413f = 100;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C0937h f7417d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f7418e;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.g$b */
    public static final class b extends AbstractC0936g {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final byte[] f7419g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f7420h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f7421i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f7422j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f7423k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f7424l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f7425m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f7426n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f7427o;

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public String A() throws C0950v {
            int iL = L();
            if (iL > 0) {
                int i7 = this.f7421i;
                int i8 = this.f7423k;
                if (iL <= i7 - i8) {
                    String str = new String(this.f7419g, i8, iL, AbstractC0949u.f7616b);
                    this.f7423k += iL;
                    return str;
                }
            }
            if (iL == 0) {
                return "";
            }
            if (iL < 0) {
                throw C0950v.g();
            }
            throw C0950v.m();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public String B() throws C0950v {
            int iL = L();
            if (iL > 0) {
                int i7 = this.f7421i;
                int i8 = this.f7423k;
                if (iL <= i7 - i8) {
                    String strA = j0.a(this.f7419g, i8, iL);
                    this.f7423k += iL;
                    return strA;
                }
            }
            if (iL == 0) {
                return "";
            }
            if (iL <= 0) {
                throw C0950v.g();
            }
            throw C0950v.m();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public int C() throws C0950v {
            if (f()) {
                this.f7425m = 0;
                return 0;
            }
            int iL = L();
            this.f7425m = iL;
            if (k0.a(iL) != 0) {
                return this.f7425m;
            }
            throw C0950v.c();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public int D() {
            return L();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public long E() {
            return M();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public boolean F(int i7) throws C0950v {
            int iB = k0.b(i7);
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
                a(k0.c(k0.a(i7), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw C0950v.e();
            }
            P(4);
            return true;
        }

        public byte H() throws C0950v {
            int i7 = this.f7423k;
            if (i7 == this.f7421i) {
                throw C0950v.m();
            }
            byte[] bArr = this.f7419g;
            this.f7423k = i7 + 1;
            return bArr[i7];
        }

        public byte[] I(int i7) throws C0950v {
            if (i7 > 0) {
                int i8 = this.f7421i;
                int i9 = this.f7423k;
                if (i7 <= i8 - i9) {
                    int i10 = i7 + i9;
                    this.f7423k = i10;
                    return Arrays.copyOfRange(this.f7419g, i9, i10);
                }
            }
            if (i7 > 0) {
                throw C0950v.m();
            }
            if (i7 == 0) {
                return AbstractC0949u.f7618d;
            }
            throw C0950v.g();
        }

        public int J() throws C0950v {
            int i7 = this.f7423k;
            if (this.f7421i - i7 < 4) {
                throw C0950v.m();
            }
            byte[] bArr = this.f7419g;
            this.f7423k = i7 + 4;
            return ((bArr[i7 + 3] & 255) << 24) | (bArr[i7] & 255) | ((bArr[i7 + 1] & 255) << 8) | ((bArr[i7 + 2] & 255) << 16);
        }

        public long K() throws C0950v {
            int i7 = this.f7423k;
            if (this.f7421i - i7 < 8) {
                throw C0950v.m();
            }
            byte[] bArr = this.f7419g;
            this.f7423k = i7 + 8;
            return ((((long) bArr[i7 + 7]) & 255) << 56) | (((long) bArr[i7]) & 255) | ((((long) bArr[i7 + 1]) & 255) << 8) | ((((long) bArr[i7 + 2]) & 255) << 16) | ((((long) bArr[i7 + 3]) & 255) << 24) | ((((long) bArr[i7 + 4]) & 255) << 32) | ((((long) bArr[i7 + 5]) & 255) << 40) | ((((long) bArr[i7 + 6]) & 255) << 48);
        }

        public int L() {
            int i7;
            int i8 = this.f7423k;
            int i9 = this.f7421i;
            if (i9 != i8) {
                byte[] bArr = this.f7419g;
                int i10 = i8 + 1;
                byte b7 = bArr[i8];
                if (b7 >= 0) {
                    this.f7423k = i10;
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
                    this.f7423k = i11;
                    return i7;
                }
            }
            return (int) N();
        }

        public long M() {
            long j7;
            long j8;
            long j9;
            int i7 = this.f7423k;
            int i8 = this.f7421i;
            if (i8 != i7) {
                byte[] bArr = this.f7419g;
                int i9 = i7 + 1;
                byte b7 = bArr[i7];
                if (b7 >= 0) {
                    this.f7423k = i9;
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
                    this.f7423k = i10;
                    return j7;
                }
            }
            return N();
        }

        public long N() throws C0950v {
            long j7 = 0;
            for (int i7 = 0; i7 < 64; i7 += 7) {
                byte bH = H();
                j7 |= ((long) (bH & 127)) << i7;
                if ((bH & 128) == 0) {
                    return j7;
                }
            }
            throw C0950v.f();
        }

        public final void O() {
            int i7 = this.f7421i + this.f7422j;
            this.f7421i = i7;
            int i8 = i7 - this.f7424l;
            int i9 = this.f7427o;
            if (i8 <= i9) {
                this.f7422j = 0;
                return;
            }
            int i10 = i8 - i9;
            this.f7422j = i10;
            this.f7421i = i7 - i10;
        }

        public void P(int i7) throws C0950v {
            if (i7 >= 0) {
                int i8 = this.f7421i;
                int i9 = this.f7423k;
                if (i7 <= i8 - i9) {
                    this.f7423k = i9 + i7;
                    return;
                }
            }
            if (i7 >= 0) {
                throw C0950v.m();
            }
            throw C0950v.g();
        }

        public final void Q() throws C0950v {
            if (this.f7421i - this.f7423k >= 10) {
                R();
            } else {
                S();
            }
        }

        public final void R() throws C0950v {
            for (int i7 = 0; i7 < 10; i7++) {
                byte[] bArr = this.f7419g;
                int i8 = this.f7423k;
                this.f7423k = i8 + 1;
                if (bArr[i8] >= 0) {
                    return;
                }
            }
            throw C0950v.f();
        }

        public final void S() throws C0950v {
            for (int i7 = 0; i7 < 10; i7++) {
                if (H() >= 0) {
                    return;
                }
            }
            throw C0950v.f();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public void a(int i7) throws C0950v {
            if (this.f7425m != i7) {
                throw C0950v.b();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public int e() {
            return this.f7423k - this.f7424l;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public boolean f() {
            return this.f7423k == this.f7421i;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public void l(int i7) {
            this.f7427o = i7;
            O();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public int m(int i7) throws C0950v {
            if (i7 < 0) {
                throw C0950v.g();
            }
            int iE = i7 + e();
            if (iE < 0) {
                throw C0950v.h();
            }
            int i8 = this.f7427o;
            if (iE > i8) {
                throw C0950v.m();
            }
            this.f7427o = iE;
            O();
            return i8;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public boolean n() {
            return M() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public AbstractC0935f o() {
            int iL = L();
            if (iL > 0) {
                int i7 = this.f7421i;
                int i8 = this.f7423k;
                if (iL <= i7 - i8) {
                    AbstractC0935f abstractC0935fX = (this.f7420h && this.f7426n) ? AbstractC0935f.x(this.f7419g, i8, iL) : AbstractC0935f.j(this.f7419g, i8, iL);
                    this.f7423k += iL;
                    return abstractC0935fX;
                }
            }
            return iL == 0 ? AbstractC0935f.f7402b : AbstractC0935f.w(I(iL));
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public double p() {
            return Double.longBitsToDouble(K());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public int q() {
            return L();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public int r() {
            return J();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public long s() {
            return K();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public float t() {
            return Float.intBitsToFloat(J());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public int u() {
            return L();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public long v() {
            return M();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public int w() {
            return J();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public long x() {
            return K();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public int y() {
            return AbstractC0936g.c(L());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public long z() {
            return AbstractC0936g.d(M());
        }

        public b(byte[] bArr, int i7, int i8, boolean z7) {
            super();
            this.f7427o = a.e.API_PRIORITY_OTHER;
            this.f7419g = bArr;
            this.f7421i = i8 + i7;
            this.f7423k = i7;
            this.f7424l = i7;
            this.f7420h = z7;
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.g$c */
    public static final class c extends AbstractC0936g {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final InputStream f7428g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final byte[] f7429h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f7430i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f7431j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f7432k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f7433l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f7434m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f7435n;

        public static int H(InputStream inputStream) throws C0950v {
            try {
                return inputStream.available();
            } catch (C0950v e7) {
                e7.j();
                throw e7;
            }
        }

        public static int I(InputStream inputStream, byte[] bArr, int i7, int i8) throws C0950v {
            try {
                return inputStream.read(bArr, i7, i8);
            } catch (C0950v e7) {
                e7.j();
                throw e7;
            }
        }

        private void T() {
            int i7 = this.f7430i + this.f7431j;
            this.f7430i = i7;
            int i8 = this.f7434m + i7;
            int i9 = this.f7435n;
            if (i8 <= i9) {
                this.f7431j = 0;
                return;
            }
            int i10 = i8 - i9;
            this.f7431j = i10;
            this.f7430i = i7 - i10;
        }

        public static long V(InputStream inputStream, long j7) throws C0950v {
            try {
                return inputStream.skip(j7);
            } catch (C0950v e7) {
                e7.j();
                throw e7;
            }
        }

        private void Y() throws C0950v {
            if (this.f7430i - this.f7432k >= 10) {
                Z();
            } else {
                a0();
            }
        }

        private void Z() throws C0950v {
            for (int i7 = 0; i7 < 10; i7++) {
                byte[] bArr = this.f7429h;
                int i8 = this.f7432k;
                this.f7432k = i8 + 1;
                if (bArr[i8] >= 0) {
                    return;
                }
            }
            throw C0950v.f();
        }

        private void a0() throws C0950v {
            for (int i7 = 0; i7 < 10; i7++) {
                if (K() >= 0) {
                    return;
                }
            }
            throw C0950v.f();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public String A() throws C0950v {
            int iQ = Q();
            if (iQ > 0) {
                int i7 = this.f7430i;
                int i8 = this.f7432k;
                if (iQ <= i7 - i8) {
                    String str = new String(this.f7429h, i8, iQ, AbstractC0949u.f7616b);
                    this.f7432k += iQ;
                    return str;
                }
            }
            if (iQ == 0) {
                return "";
            }
            if (iQ < 0) {
                throw C0950v.g();
            }
            if (iQ > this.f7430i) {
                return new String(L(iQ, false), AbstractC0949u.f7616b);
            }
            U(iQ);
            String str2 = new String(this.f7429h, this.f7432k, iQ, AbstractC0949u.f7616b);
            this.f7432k += iQ;
            return str2;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public String B() throws IOException {
            byte[] bArrL;
            int iQ = Q();
            int i7 = this.f7432k;
            int i8 = this.f7430i;
            if (iQ <= i8 - i7 && iQ > 0) {
                bArrL = this.f7429h;
                this.f7432k = i7 + iQ;
            } else {
                if (iQ == 0) {
                    return "";
                }
                if (iQ < 0) {
                    throw C0950v.g();
                }
                i7 = 0;
                if (iQ <= i8) {
                    U(iQ);
                    bArrL = this.f7429h;
                    this.f7432k = iQ;
                } else {
                    bArrL = L(iQ, false);
                }
            }
            return j0.a(bArrL, i7, iQ);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public int C() throws C0950v {
            if (f()) {
                this.f7433l = 0;
                return 0;
            }
            int iQ = Q();
            this.f7433l = iQ;
            if (k0.a(iQ) != 0) {
                return this.f7433l;
            }
            throw C0950v.c();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public int D() {
            return Q();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public long E() {
            return R();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public boolean F(int i7) throws C0950v {
            int iB = k0.b(i7);
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
                a(k0.c(k0.a(i7), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw C0950v.e();
            }
            W(4);
            return true;
        }

        public final AbstractC0935f J(int i7) throws IOException {
            byte[] bArrM = M(i7);
            if (bArrM != null) {
                return AbstractC0935f.h(bArrM);
            }
            int i8 = this.f7432k;
            int i9 = this.f7430i;
            int length = i9 - i8;
            this.f7434m += i9;
            this.f7432k = 0;
            this.f7430i = 0;
            List<byte[]> listN = N(i7 - length);
            byte[] bArr = new byte[i7];
            System.arraycopy(this.f7429h, i8, bArr, 0, length);
            for (byte[] bArr2 : listN) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return AbstractC0935f.w(bArr);
        }

        public byte K() throws C0950v {
            if (this.f7432k == this.f7430i) {
                U(1);
            }
            byte[] bArr = this.f7429h;
            int i7 = this.f7432k;
            this.f7432k = i7 + 1;
            return bArr[i7];
        }

        public final byte[] L(int i7, boolean z7) throws IOException {
            byte[] bArrM = M(i7);
            if (bArrM != null) {
                return z7 ? (byte[]) bArrM.clone() : bArrM;
            }
            int i8 = this.f7432k;
            int i9 = this.f7430i;
            int length = i9 - i8;
            this.f7434m += i9;
            this.f7432k = 0;
            this.f7430i = 0;
            List<byte[]> listN = N(i7 - length);
            byte[] bArr = new byte[i7];
            System.arraycopy(this.f7429h, i8, bArr, 0, length);
            for (byte[] bArr2 : listN) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return bArr;
        }

        public final byte[] M(int i7) throws C0950v {
            if (i7 == 0) {
                return AbstractC0949u.f7618d;
            }
            if (i7 < 0) {
                throw C0950v.g();
            }
            int i8 = this.f7434m;
            int i9 = this.f7432k;
            int i10 = i8 + i9 + i7;
            if (i10 - this.f7416c > 0) {
                throw C0950v.l();
            }
            int i11 = this.f7435n;
            if (i10 > i11) {
                W((i11 - i8) - i9);
                throw C0950v.m();
            }
            int i12 = this.f7430i - i9;
            int i13 = i7 - i12;
            if (i13 >= 4096 && i13 > H(this.f7428g)) {
                return null;
            }
            byte[] bArr = new byte[i7];
            System.arraycopy(this.f7429h, this.f7432k, bArr, 0, i12);
            this.f7434m += this.f7430i;
            this.f7432k = 0;
            this.f7430i = 0;
            while (i12 < i7) {
                int I6 = I(this.f7428g, bArr, i12, i7 - i12);
                if (I6 == -1) {
                    throw C0950v.m();
                }
                this.f7434m += I6;
                i12 += I6;
            }
            return bArr;
        }

        public final List N(int i7) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i7 > 0) {
                int iMin = Math.min(i7, 4096);
                byte[] bArr = new byte[iMin];
                int i8 = 0;
                while (i8 < iMin) {
                    int i9 = this.f7428g.read(bArr, i8, iMin - i8);
                    if (i9 == -1) {
                        throw C0950v.m();
                    }
                    this.f7434m += i9;
                    i8 += i9;
                }
                i7 -= iMin;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        public int O() throws C0950v {
            int i7 = this.f7432k;
            if (this.f7430i - i7 < 4) {
                U(4);
                i7 = this.f7432k;
            }
            byte[] bArr = this.f7429h;
            this.f7432k = i7 + 4;
            return ((bArr[i7 + 3] & 255) << 24) | (bArr[i7] & 255) | ((bArr[i7 + 1] & 255) << 8) | ((bArr[i7 + 2] & 255) << 16);
        }

        public long P() throws C0950v {
            int i7 = this.f7432k;
            if (this.f7430i - i7 < 8) {
                U(8);
                i7 = this.f7432k;
            }
            byte[] bArr = this.f7429h;
            this.f7432k = i7 + 8;
            return ((((long) bArr[i7 + 7]) & 255) << 56) | (((long) bArr[i7]) & 255) | ((((long) bArr[i7 + 1]) & 255) << 8) | ((((long) bArr[i7 + 2]) & 255) << 16) | ((((long) bArr[i7 + 3]) & 255) << 24) | ((((long) bArr[i7 + 4]) & 255) << 32) | ((((long) bArr[i7 + 5]) & 255) << 40) | ((((long) bArr[i7 + 6]) & 255) << 48);
        }

        public int Q() {
            int i7;
            int i8 = this.f7432k;
            int i9 = this.f7430i;
            if (i9 != i8) {
                byte[] bArr = this.f7429h;
                int i10 = i8 + 1;
                byte b7 = bArr[i8];
                if (b7 >= 0) {
                    this.f7432k = i10;
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
                    this.f7432k = i11;
                    return i7;
                }
            }
            return (int) S();
        }

        public long R() {
            long j7;
            long j8;
            long j9;
            int i7 = this.f7432k;
            int i8 = this.f7430i;
            if (i8 != i7) {
                byte[] bArr = this.f7429h;
                int i9 = i7 + 1;
                byte b7 = bArr[i7];
                if (b7 >= 0) {
                    this.f7432k = i9;
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
                    this.f7432k = i10;
                    return j7;
                }
            }
            return S();
        }

        public long S() throws C0950v {
            long j7 = 0;
            for (int i7 = 0; i7 < 64; i7 += 7) {
                byte bK = K();
                j7 |= ((long) (bK & 127)) << i7;
                if ((bK & 128) == 0) {
                    return j7;
                }
            }
            throw C0950v.f();
        }

        public final void U(int i7) throws C0950v {
            if (b0(i7)) {
                return;
            }
            if (i7 <= (this.f7416c - this.f7434m) - this.f7432k) {
                throw C0950v.m();
            }
            throw C0950v.l();
        }

        public void W(int i7) throws C0950v {
            int i8 = this.f7430i;
            int i9 = this.f7432k;
            if (i7 > i8 - i9 || i7 < 0) {
                X(i7);
            } else {
                this.f7432k = i9 + i7;
            }
        }

        public final void X(int i7) throws C0950v {
            if (i7 < 0) {
                throw C0950v.g();
            }
            int i8 = this.f7434m;
            int i9 = this.f7432k;
            int i10 = i8 + i9 + i7;
            int i11 = this.f7435n;
            if (i10 > i11) {
                W((i11 - i8) - i9);
                throw C0950v.m();
            }
            this.f7434m = i8 + i9;
            int i12 = this.f7430i - i9;
            this.f7430i = 0;
            this.f7432k = 0;
            while (i12 < i7) {
                try {
                    long j7 = i7 - i12;
                    long jV = V(this.f7428g, j7);
                    if (jV < 0 || jV > j7) {
                        throw new IllegalStateException(this.f7428g.getClass() + "#skip returned invalid result: " + jV + "\nThe InputStream implementation is buggy.");
                    }
                    if (jV == 0) {
                        break;
                    } else {
                        i12 += (int) jV;
                    }
                } finally {
                    this.f7434m += i12;
                    T();
                }
            }
            if (i12 >= i7) {
                return;
            }
            int i13 = this.f7430i;
            int i14 = i13 - this.f7432k;
            this.f7432k = i13;
            U(1);
            while (true) {
                int i15 = i7 - i14;
                int i16 = this.f7430i;
                if (i15 <= i16) {
                    this.f7432k = i15;
                    return;
                } else {
                    i14 += i16;
                    this.f7432k = i16;
                    U(1);
                }
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public void a(int i7) throws C0950v {
            if (this.f7433l != i7) {
                throw C0950v.b();
            }
        }

        public final boolean b0(int i7) throws C0950v {
            int i8 = this.f7432k;
            int i9 = i8 + i7;
            int i10 = this.f7430i;
            if (i9 <= i10) {
                throw new IllegalStateException("refillBuffer() called when " + i7 + " bytes were already available in buffer");
            }
            int i11 = this.f7416c;
            int i12 = this.f7434m;
            if (i7 > (i11 - i12) - i8 || i12 + i8 + i7 > this.f7435n) {
                return false;
            }
            if (i8 > 0) {
                if (i10 > i8) {
                    byte[] bArr = this.f7429h;
                    System.arraycopy(bArr, i8, bArr, 0, i10 - i8);
                }
                this.f7434m += i8;
                this.f7430i -= i8;
                this.f7432k = 0;
            }
            InputStream inputStream = this.f7428g;
            byte[] bArr2 = this.f7429h;
            int i13 = this.f7430i;
            int I6 = I(inputStream, bArr2, i13, Math.min(bArr2.length - i13, (this.f7416c - this.f7434m) - i13));
            if (I6 == 0 || I6 < -1 || I6 > this.f7429h.length) {
                throw new IllegalStateException(this.f7428g.getClass() + "#read(byte[]) returned invalid result: " + I6 + "\nThe InputStream implementation is buggy.");
            }
            if (I6 <= 0) {
                return false;
            }
            this.f7430i += I6;
            T();
            if (this.f7430i >= i7) {
                return true;
            }
            return b0(i7);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public int e() {
            return this.f7434m + this.f7432k;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public boolean f() {
            return this.f7432k == this.f7430i && !b0(1);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public void l(int i7) {
            this.f7435n = i7;
            T();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public int m(int i7) throws C0950v {
            if (i7 < 0) {
                throw C0950v.g();
            }
            int i8 = i7 + this.f7434m + this.f7432k;
            if (i8 < 0) {
                throw C0950v.h();
            }
            int i9 = this.f7435n;
            if (i8 > i9) {
                throw C0950v.m();
            }
            this.f7435n = i8;
            T();
            return i9;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public boolean n() {
            return R() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public AbstractC0935f o() throws C0950v {
            int iQ = Q();
            int i7 = this.f7430i;
            int i8 = this.f7432k;
            if (iQ <= i7 - i8 && iQ > 0) {
                AbstractC0935f abstractC0935fJ = AbstractC0935f.j(this.f7429h, i8, iQ);
                this.f7432k += iQ;
                return abstractC0935fJ;
            }
            if (iQ == 0) {
                return AbstractC0935f.f7402b;
            }
            if (iQ >= 0) {
                return J(iQ);
            }
            throw C0950v.g();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public double p() {
            return Double.longBitsToDouble(P());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public int q() {
            return Q();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public int r() {
            return O();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public long s() {
            return P();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public float t() {
            return Float.intBitsToFloat(O());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public int u() {
            return Q();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public long v() {
            return R();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public int w() {
            return O();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public long x() {
            return P();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public int y() {
            return AbstractC0936g.c(Q());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0936g
        public long z() {
            return AbstractC0936g.d(R());
        }

        public c(InputStream inputStream, int i7) {
            super();
            this.f7435n = a.e.API_PRIORITY_OTHER;
            AbstractC0949u.b(inputStream, "input");
            this.f7428g = inputStream;
            this.f7429h = new byte[i7];
            this.f7430i = 0;
            this.f7432k = 0;
            this.f7434m = 0;
        }
    }

    public static int c(int i7) {
        return (-(i7 & 1)) ^ (i7 >>> 1);
    }

    public static long d(long j7) {
        return (-(j7 & 1)) ^ (j7 >>> 1);
    }

    public static AbstractC0936g g(InputStream inputStream) {
        return h(inputStream, 4096);
    }

    public static AbstractC0936g h(InputStream inputStream, int i7) {
        if (i7 > 0) {
            return inputStream == null ? i(AbstractC0949u.f7618d) : new c(inputStream, i7);
        }
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    public static AbstractC0936g i(byte[] bArr) {
        return j(bArr, 0, bArr.length);
    }

    public static AbstractC0936g j(byte[] bArr, int i7, int i8) {
        return k(bArr, i7, i8, false);
    }

    public static AbstractC0936g k(byte[] bArr, int i7, int i8, boolean z7) {
        b bVar = new b(bArr, i7, i8, z7);
        try {
            bVar.m(i8);
            return bVar;
        } catch (C0950v e7) {
            throw new IllegalArgumentException(e7);
        }
    }

    public abstract String A();

    public abstract String B();

    public abstract int C();

    public abstract int D();

    public abstract long E();

    public abstract boolean F(int i7);

    public void G() throws C0950v {
        int iC;
        do {
            iC = C();
            if (iC == 0) {
                return;
            }
            b();
            this.f7414a++;
            this.f7414a--;
        } while (F(iC));
    }

    public abstract void a(int i7);

    public void b() throws C0950v {
        if (this.f7414a >= this.f7415b) {
            throw C0950v.i();
        }
    }

    public abstract int e();

    public abstract boolean f();

    public abstract void l(int i7);

    public abstract int m(int i7);

    public abstract boolean n();

    public abstract AbstractC0935f o();

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

    public AbstractC0936g() {
        this.f7415b = f7413f;
        this.f7416c = a.e.API_PRIORITY_OTHER;
        this.f7418e = false;
    }
}
