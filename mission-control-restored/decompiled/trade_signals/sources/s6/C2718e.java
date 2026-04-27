package s6;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import s6.p;

/* JADX INFO: renamed from: s6.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2718e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f23138d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final InputStream f23140f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f23141g;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f23145k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f23142h = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f23144j = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f23146l = 64;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f23147m = 67108864;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f23135a = new byte[4096];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f23137c = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f23139e = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f23143i = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f23136b = false;

    public C2718e(InputStream inputStream) {
        this.f23140f = inputStream;
    }

    public static int A(int i8, InputStream inputStream) throws IOException {
        if ((i8 & 128) == 0) {
            return i8;
        }
        int i9 = i8 & 127;
        int i10 = 7;
        while (i10 < 32) {
            int i11 = inputStream.read();
            if (i11 == -1) {
                throw C2724k.k();
            }
            i9 |= (i11 & 127) << i10;
            if ((i11 & 128) == 0) {
                return i9;
            }
            i10 += 7;
        }
        while (i10 < 64) {
            int i12 = inputStream.read();
            if (i12 == -1) {
                throw C2724k.k();
            }
            if ((i12 & 128) == 0) {
                return i9;
            }
            i10 += 7;
        }
        throw C2724k.f();
    }

    public static int b(int i8) {
        return (-(i8 & 1)) ^ (i8 >>> 1);
    }

    public static long c(long j8) {
        return (-(j8 & 1)) ^ (j8 >>> 1);
    }

    public static C2718e g(InputStream inputStream) {
        return new C2718e(inputStream);
    }

    public long B() {
        long j8;
        long j9;
        long j10;
        int i8 = this.f23139e;
        int i9 = this.f23137c;
        if (i9 != i8) {
            byte[] bArr = this.f23135a;
            int i10 = i8 + 1;
            byte b8 = bArr[i8];
            if (b8 >= 0) {
                this.f23139e = i10;
                return b8;
            }
            if (i9 - i10 >= 9) {
                int i11 = i8 + 2;
                long j11 = (bArr[i10] << 7) ^ b8;
                if (j11 >= 0) {
                    int i12 = i8 + 3;
                    long j12 = j11 ^ ((long) (bArr[i11] << 14));
                    if (j12 >= 0) {
                        j10 = 16256;
                    } else {
                        i11 = i8 + 4;
                        j11 = j12 ^ ((long) (bArr[i12] << 21));
                        if (j11 < 0) {
                            j9 = -2080896;
                        } else {
                            i12 = i8 + 5;
                            j12 = j11 ^ (((long) bArr[i11]) << 28);
                            if (j12 >= 0) {
                                j10 = 266354560;
                            } else {
                                i11 = i8 + 6;
                                j11 = j12 ^ (((long) bArr[i12]) << 35);
                                if (j11 < 0) {
                                    j9 = -34093383808L;
                                } else {
                                    i12 = i8 + 7;
                                    j12 = j11 ^ (((long) bArr[i11]) << 42);
                                    if (j12 >= 0) {
                                        j10 = 4363953127296L;
                                    } else {
                                        i11 = i8 + 8;
                                        j11 = j12 ^ (((long) bArr[i12]) << 49);
                                        if (j11 < 0) {
                                            j9 = -558586000294016L;
                                        } else {
                                            i12 = i8 + 9;
                                            long j13 = (j11 ^ (((long) bArr[i11]) << 56)) ^ 71499008037633920L;
                                            if (j13 >= 0) {
                                                j8 = j13;
                                                i11 = i12;
                                                this.f23139e = i11;
                                                return j8;
                                            }
                                            i11 = i8 + 10;
                                            if (bArr[i12] >= 0) {
                                                j8 = j13;
                                                this.f23139e = i11;
                                                return j8;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    j8 = j12 ^ j10;
                    i11 = i12;
                    this.f23139e = i11;
                    return j8;
                }
                j9 = -128;
                j8 = j11 ^ j9;
                this.f23139e = i11;
                return j8;
            }
        }
        return C();
    }

    public long C() throws C2724k {
        long j8 = 0;
        for (int i8 = 0; i8 < 64; i8 += 7) {
            byte bV = v();
            j8 |= ((long) (bV & 127)) << i8;
            if ((bV & 128) == 0) {
                return j8;
            }
        }
        throw C2724k.f();
    }

    public int D() {
        return x();
    }

    public long E() {
        return y();
    }

    public int F() {
        return b(z());
    }

    public long G() {
        return c(B());
    }

    public String H() {
        int iZ = z();
        int i8 = this.f23137c;
        int i9 = this.f23139e;
        if (iZ > i8 - i9 || iZ <= 0) {
            return iZ == 0 ? "" : new String(w(iZ), "UTF-8");
        }
        String str = new String(this.f23135a, i9, iZ, "UTF-8");
        this.f23139e += iZ;
        return str;
    }

    public String I() throws C2724k {
        byte[] bArrW;
        int iZ = z();
        int i8 = this.f23139e;
        if (iZ <= this.f23137c - i8 && iZ > 0) {
            bArrW = this.f23135a;
            this.f23139e = i8 + iZ;
        } else {
            if (iZ == 0) {
                return "";
            }
            bArrW = w(iZ);
            i8 = 0;
        }
        if (x.f(bArrW, i8, i8 + iZ)) {
            return new String(bArrW, i8, iZ, "UTF-8");
        }
        throw C2724k.d();
    }

    public int J() throws C2724k {
        if (f()) {
            this.f23141g = 0;
            return 0;
        }
        int iZ = z();
        this.f23141g = iZ;
        if (y.a(iZ) != 0) {
            return this.f23141g;
        }
        throw C2724k.c();
    }

    public int K() {
        return z();
    }

    public long L() {
        return B();
    }

    public final void M() {
        int i8 = this.f23137c + this.f23138d;
        this.f23137c = i8;
        int i9 = this.f23143i + i8;
        int i10 = this.f23144j;
        if (i9 <= i10) {
            this.f23138d = 0;
            return;
        }
        int i11 = i9 - i10;
        this.f23138d = i11;
        this.f23137c = i8 - i11;
    }

    public final void N(int i8) throws C2724k {
        if (!S(i8)) {
            throw C2724k.k();
        }
    }

    public boolean O(int i8, C2719f c2719f) throws C2724k {
        int iB = y.b(i8);
        if (iB == 0) {
            long jS = s();
            c2719f.n0(i8);
            c2719f.y0(jS);
            return true;
        }
        if (iB == 1) {
            long jY = y();
            c2719f.n0(i8);
            c2719f.U(jY);
            return true;
        }
        if (iB == 2) {
            AbstractC2717d abstractC2717dK = k();
            c2719f.n0(i8);
            c2719f.O(abstractC2717dK);
            return true;
        }
        if (iB == 3) {
            c2719f.n0(i8);
            P(c2719f);
            int iC = y.c(y.a(i8), 4);
            a(iC);
            c2719f.n0(iC);
            return true;
        }
        if (iB == 4) {
            return false;
        }
        if (iB != 5) {
            throw C2724k.e();
        }
        int iX = x();
        c2719f.n0(i8);
        c2719f.T(iX);
        return true;
    }

    public void P(C2719f c2719f) throws C2724k {
        int iJ;
        do {
            iJ = J();
            if (iJ == 0) {
                return;
            }
        } while (O(iJ, c2719f));
    }

    public void Q(int i8) throws C2724k {
        int i9 = this.f23137c;
        int i10 = this.f23139e;
        if (i8 > i9 - i10 || i8 < 0) {
            R(i8);
        } else {
            this.f23139e = i10 + i8;
        }
    }

    public final void R(int i8) throws C2724k {
        if (i8 < 0) {
            throw C2724k.g();
        }
        int i9 = this.f23143i;
        int i10 = this.f23139e;
        int i11 = i9 + i10 + i8;
        int i12 = this.f23144j;
        if (i11 > i12) {
            Q((i12 - i9) - i10);
            throw C2724k.k();
        }
        int i13 = this.f23137c;
        int i14 = i13 - i10;
        this.f23139e = i13;
        while (true) {
            N(1);
            int i15 = i8 - i14;
            int i16 = this.f23137c;
            if (i15 <= i16) {
                this.f23139e = i15;
                return;
            } else {
                i14 += i16;
                this.f23139e = i16;
            }
        }
    }

    public final boolean S(int i8) throws IOException {
        int i9 = this.f23139e;
        int i10 = i9 + i8;
        int i11 = this.f23137c;
        if (i10 <= i11) {
            StringBuilder sb = new StringBuilder(77);
            sb.append("refillBuffer() called when ");
            sb.append(i8);
            sb.append(" bytes were already available in buffer");
            throw new IllegalStateException(sb.toString());
        }
        if (this.f23143i + i9 + i8 <= this.f23144j && this.f23140f != null) {
            if (i9 > 0) {
                if (i11 > i9) {
                    byte[] bArr = this.f23135a;
                    System.arraycopy(bArr, i9, bArr, 0, i11 - i9);
                }
                this.f23143i += i9;
                this.f23137c -= i9;
                this.f23139e = 0;
            }
            InputStream inputStream = this.f23140f;
            byte[] bArr2 = this.f23135a;
            int i12 = this.f23137c;
            int i13 = inputStream.read(bArr2, i12, bArr2.length - i12);
            if (i13 == 0 || i13 < -1 || i13 > this.f23135a.length) {
                StringBuilder sb2 = new StringBuilder(102);
                sb2.append("InputStream#read(byte[]) returned invalid result: ");
                sb2.append(i13);
                sb2.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(sb2.toString());
            }
            if (i13 > 0) {
                this.f23137c += i13;
                if ((this.f23143i + i8) - this.f23147m > 0) {
                    throw C2724k.j();
                }
                M();
                if (this.f23137c >= i8) {
                    return true;
                }
                return S(i8);
            }
        }
        return false;
    }

    public void a(int i8) throws C2724k {
        if (this.f23141g != i8) {
            throw C2724k.b();
        }
    }

    public final void d(int i8) throws C2724k {
        if (this.f23137c - this.f23139e < i8) {
            N(i8);
        }
    }

    public int e() {
        int i8 = this.f23144j;
        if (i8 == Integer.MAX_VALUE) {
            return -1;
        }
        return i8 - (this.f23143i + this.f23139e);
    }

    public boolean f() {
        return this.f23139e == this.f23137c && !S(1);
    }

    public void h(int i8) {
        this.f23144j = i8;
        M();
    }

    public int i(int i8) throws C2724k {
        if (i8 < 0) {
            throw C2724k.g();
        }
        int i9 = i8 + this.f23143i + this.f23139e;
        int i10 = this.f23144j;
        if (i9 > i10) {
            throw C2724k.k();
        }
        this.f23144j = i9;
        M();
        return i10;
    }

    public boolean j() {
        return B() != 0;
    }

    public AbstractC2717d k() {
        int iZ = z();
        int i8 = this.f23137c;
        int i9 = this.f23139e;
        if (iZ > i8 - i9 || iZ <= 0) {
            return iZ == 0 ? AbstractC2717d.f23128a : new o(w(iZ));
        }
        AbstractC2717d c2716c = (this.f23136b && this.f23142h) ? new C2716c(this.f23135a, this.f23139e, iZ) : AbstractC2717d.h(this.f23135a, i9, iZ);
        this.f23139e += iZ;
        return c2716c;
    }

    public double l() {
        return Double.longBitsToDouble(y());
    }

    public int m() {
        return z();
    }

    public int n() {
        return x();
    }

    public long o() {
        return y();
    }

    public float p() {
        return Float.intBitsToFloat(x());
    }

    public void q(int i8, p.a aVar, C2720g c2720g) throws C2724k {
        int i9 = this.f23145k;
        if (i9 >= this.f23146l) {
            throw C2724k.h();
        }
        this.f23145k = i9 + 1;
        aVar.n(this, c2720g);
        a(y.c(i8, 4));
        this.f23145k--;
    }

    public int r() {
        return z();
    }

    public long s() {
        return B();
    }

    public p t(r rVar, C2720g c2720g) throws C2724k {
        int iZ = z();
        if (this.f23145k >= this.f23146l) {
            throw C2724k.h();
        }
        int i8 = i(iZ);
        this.f23145k++;
        p pVar = (p) rVar.b(this, c2720g);
        a(0);
        this.f23145k--;
        h(i8);
        return pVar;
    }

    public void u(p.a aVar, C2720g c2720g) throws C2724k {
        int iZ = z();
        if (this.f23145k >= this.f23146l) {
            throw C2724k.h();
        }
        int i8 = i(iZ);
        this.f23145k++;
        aVar.n(this, c2720g);
        a(0);
        this.f23145k--;
        h(i8);
    }

    public byte v() throws C2724k {
        if (this.f23139e == this.f23137c) {
            N(1);
        }
        byte[] bArr = this.f23135a;
        int i8 = this.f23139e;
        this.f23139e = i8 + 1;
        return bArr[i8];
    }

    public final byte[] w(int i8) throws C2724k {
        if (i8 <= 0) {
            if (i8 == 0) {
                return AbstractC2723j.f23183a;
            }
            throw C2724k.g();
        }
        int i9 = this.f23143i;
        int i10 = this.f23139e;
        int i11 = i9 + i10 + i8;
        int i12 = this.f23144j;
        if (i11 > i12) {
            Q((i12 - i9) - i10);
            throw C2724k.k();
        }
        if (i8 < 4096) {
            byte[] bArr = new byte[i8];
            int i13 = this.f23137c - i10;
            System.arraycopy(this.f23135a, i10, bArr, 0, i13);
            this.f23139e = this.f23137c;
            int i14 = i8 - i13;
            d(i14);
            System.arraycopy(this.f23135a, 0, bArr, i13, i14);
            this.f23139e = i14;
            return bArr;
        }
        int i15 = this.f23137c;
        this.f23143i = i9 + i15;
        this.f23139e = 0;
        this.f23137c = 0;
        int length = i15 - i10;
        int i16 = i8 - length;
        ArrayList<byte[]> arrayList = new ArrayList();
        while (i16 > 0) {
            int iMin = Math.min(i16, 4096);
            byte[] bArr2 = new byte[iMin];
            int i17 = 0;
            while (i17 < iMin) {
                InputStream inputStream = this.f23140f;
                int i18 = inputStream == null ? -1 : inputStream.read(bArr2, i17, iMin - i17);
                if (i18 == -1) {
                    throw C2724k.k();
                }
                this.f23143i += i18;
                i17 += i18;
            }
            i16 -= iMin;
            arrayList.add(bArr2);
        }
        byte[] bArr3 = new byte[i8];
        System.arraycopy(this.f23135a, i10, bArr3, 0, length);
        for (byte[] bArr4 : arrayList) {
            System.arraycopy(bArr4, 0, bArr3, length, bArr4.length);
            length += bArr4.length;
        }
        return bArr3;
    }

    public int x() throws C2724k {
        int i8 = this.f23139e;
        if (this.f23137c - i8 < 4) {
            N(4);
            i8 = this.f23139e;
        }
        byte[] bArr = this.f23135a;
        this.f23139e = i8 + 4;
        return ((bArr[i8 + 3] & 255) << 24) | (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16);
    }

    public long y() throws C2724k {
        int i8 = this.f23139e;
        if (this.f23137c - i8 < 8) {
            N(8);
            i8 = this.f23139e;
        }
        byte[] bArr = this.f23135a;
        this.f23139e = i8 + 8;
        return ((((long) bArr[i8 + 7]) & 255) << 56) | (((long) bArr[i8]) & 255) | ((((long) bArr[i8 + 1]) & 255) << 8) | ((((long) bArr[i8 + 2]) & 255) << 16) | ((((long) bArr[i8 + 3]) & 255) << 24) | ((((long) bArr[i8 + 4]) & 255) << 32) | ((((long) bArr[i8 + 5]) & 255) << 40) | ((((long) bArr[i8 + 6]) & 255) << 48);
    }

    public int z() {
        int i8;
        int i9 = this.f23139e;
        int i10 = this.f23137c;
        if (i10 != i9) {
            byte[] bArr = this.f23135a;
            int i11 = i9 + 1;
            byte b8 = bArr[i9];
            if (b8 >= 0) {
                this.f23139e = i11;
                return b8;
            }
            if (i10 - i11 >= 9) {
                int i12 = i9 + 2;
                int i13 = (bArr[i11] << 7) ^ b8;
                long j8 = i13;
                if (j8 < 0) {
                    i8 = (int) ((-128) ^ j8);
                } else {
                    int i14 = i9 + 3;
                    int i15 = (bArr[i12] << 14) ^ i13;
                    long j9 = i15;
                    if (j9 >= 0) {
                        i8 = (int) (16256 ^ j9);
                    } else {
                        int i16 = i9 + 4;
                        int i17 = i15 ^ (bArr[i14] << 21);
                        long j10 = i17;
                        if (j10 < 0) {
                            i8 = (int) ((-2080896) ^ j10);
                        } else {
                            i14 = i9 + 5;
                            byte b9 = bArr[i16];
                            int i18 = (int) (((long) (i17 ^ (b9 << 28))) ^ 266354560);
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
                this.f23139e = i12;
                return i8;
            }
        }
        return (int) C();
    }
}
