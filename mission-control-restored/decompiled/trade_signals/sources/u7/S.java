package u7;

import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2590l;

/* JADX INFO: loaded from: classes2.dex */
public final class S extends C2814g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient byte[][] f23607f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final transient int[] f23608g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public S(byte[][] segments, int[] directory) {
        super(C2814g.f23649e.l());
        AbstractC2304t.f(segments, "segments");
        AbstractC2304t.f(directory, "directory");
        this.f23607f = segments;
        this.f23608g = directory;
    }

    @Override // u7.C2814g
    public byte[] H() {
        return W();
    }

    @Override // u7.C2814g
    public byte I(int i8) {
        AbstractC2809b.b(Z()[a0().length - 1], i8, 1L);
        int iB = v7.e.b(this, i8);
        return a0()[iB][(i8 - (iB == 0 ? 0 : Z()[iB - 1])) + Z()[a0().length + iB]];
    }

    @Override // u7.C2814g
    public int K(byte[] other, int i8) {
        AbstractC2304t.f(other, "other");
        return b0().K(other, i8);
    }

    @Override // u7.C2814g
    public boolean N(int i8, C2814g other, int i9, int i10) {
        AbstractC2304t.f(other, "other");
        if (i8 < 0 || i8 > R() - i10) {
            return false;
        }
        int i11 = i10 + i8;
        int iB = v7.e.b(this, i8);
        while (i8 < i11) {
            int i12 = iB == 0 ? 0 : Z()[iB - 1];
            int i13 = Z()[iB] - i12;
            int i14 = Z()[a0().length + iB];
            int iMin = Math.min(i11, i13 + i12) - i8;
            if (!other.O(i9, a0()[iB], i14 + (i8 - i12), iMin)) {
                return false;
            }
            i9 += iMin;
            i8 += iMin;
            iB++;
        }
        return true;
    }

    @Override // u7.C2814g
    public boolean O(int i8, byte[] other, int i9, int i10) {
        AbstractC2304t.f(other, "other");
        if (i8 < 0 || i8 > R() - i10 || i9 < 0 || i9 > other.length - i10) {
            return false;
        }
        int i11 = i10 + i8;
        int iB = v7.e.b(this, i8);
        while (i8 < i11) {
            int i12 = iB == 0 ? 0 : Z()[iB - 1];
            int i13 = Z()[iB] - i12;
            int i14 = Z()[a0().length + iB];
            int iMin = Math.min(i11, i13 + i12) - i8;
            if (!AbstractC2809b.a(a0()[iB], i14 + (i8 - i12), other, i9, iMin)) {
                return false;
            }
            i9 += iMin;
            i8 += iMin;
            iB++;
        }
        return true;
    }

    @Override // u7.C2814g
    public C2814g T(int i8, int i9) {
        int iD = AbstractC2809b.d(this, i9);
        if (i8 < 0) {
            throw new IllegalArgumentException(("beginIndex=" + i8 + " < 0").toString());
        }
        if (iD > R()) {
            throw new IllegalArgumentException(("endIndex=" + iD + " > length(" + R() + ')').toString());
        }
        int i10 = iD - i8;
        if (i10 < 0) {
            throw new IllegalArgumentException(("endIndex=" + iD + " < beginIndex=" + i8).toString());
        }
        if (i8 == 0 && iD == R()) {
            return this;
        }
        if (i8 == iD) {
            return C2814g.f23649e;
        }
        int iB = v7.e.b(this, i8);
        int iB2 = v7.e.b(this, iD - 1);
        byte[][] bArr = (byte[][]) AbstractC2590l.m(a0(), iB, iB2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (iB <= iB2) {
            int i11 = iB;
            int i12 = 0;
            while (true) {
                iArr[i12] = Math.min(Z()[i11] - i8, i10);
                int i13 = i12 + 1;
                iArr[i12 + bArr.length] = Z()[a0().length + i11];
                if (i11 == iB2) {
                    break;
                }
                i11++;
                i12 = i13;
            }
        }
        int i14 = iB != 0 ? Z()[iB - 1] : 0;
        int length = bArr.length;
        iArr[length] = iArr[length] + (i8 - i14);
        return new S(bArr, iArr);
    }

    @Override // u7.C2814g
    public C2814g V() {
        return b0().V();
    }

    @Override // u7.C2814g
    public byte[] W() {
        byte[] bArr = new byte[R()];
        int length = a0().length;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i8 < length) {
            int i11 = Z()[length + i8];
            int i12 = Z()[i8];
            int i13 = i12 - i9;
            AbstractC2590l.e(a0()[i8], bArr, i10, i11, i11 + i13);
            i10 += i13;
            i8++;
            i9 = i12;
        }
        return bArr;
    }

    @Override // u7.C2814g
    public void Y(C2811d buffer, int i8, int i9) {
        AbstractC2304t.f(buffer, "buffer");
        int i10 = i8 + i9;
        int iB = v7.e.b(this, i8);
        while (i8 < i10) {
            int i11 = iB == 0 ? 0 : Z()[iB - 1];
            int i12 = Z()[iB] - i11;
            int i13 = Z()[a0().length + iB];
            int iMin = Math.min(i10, i12 + i11) - i8;
            int i14 = i13 + (i8 - i11);
            P p8 = new P(a0()[iB], i14, i14 + iMin, true, false);
            P p9 = buffer.f23638a;
            if (p9 == null) {
                p8.f23601g = p8;
                p8.f23600f = p8;
                buffer.f23638a = p8;
            } else {
                AbstractC2304t.c(p9);
                P p10 = p9.f23601g;
                AbstractC2304t.c(p10);
                p10.c(p8);
            }
            i8 += iMin;
            iB++;
        }
        buffer.r0(buffer.s0() + ((long) i9));
    }

    public final int[] Z() {
        return this.f23608g;
    }

    @Override // u7.C2814g
    public String a() {
        return b0().a();
    }

    public final byte[][] a0() {
        return this.f23607f;
    }

    public final C2814g b0() {
        return new C2814g(W());
    }

    @Override // u7.C2814g
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C2814g) {
            C2814g c2814g = (C2814g) obj;
            if (c2814g.R() == R() && N(0, c2814g, 0, R())) {
                return true;
            }
        }
        return false;
    }

    @Override // u7.C2814g
    public int hashCode() {
        int iM = m();
        if (iM != 0) {
            return iM;
        }
        int length = a0().length;
        int i8 = 0;
        int i9 = 1;
        int i10 = 0;
        while (i8 < length) {
            int i11 = Z()[length + i8];
            int i12 = Z()[i8];
            byte[] bArr = a0()[i8];
            int i13 = (i12 - i10) + i11;
            while (i11 < i13) {
                i9 = (i9 * 31) + bArr[i11];
                i11++;
            }
            i8++;
            i10 = i12;
        }
        P(i9);
        return i9;
    }

    @Override // u7.C2814g
    public int n() {
        return Z()[a0().length - 1];
    }

    @Override // u7.C2814g
    public String r() {
        return b0().r();
    }

    @Override // u7.C2814g
    public String toString() {
        return b0().toString();
    }

    @Override // u7.C2814g
    public int w(byte[] other, int i8) {
        AbstractC2304t.f(other, "other");
        return b0().w(other, i8);
    }
}
