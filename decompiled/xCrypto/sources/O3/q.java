package O3;

import X2.AbstractC0763j;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient byte[][] f3359f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final transient int[] f3360g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(byte[][] segments, int[] directory) {
        super(g.f3331e.i());
        kotlin.jvm.internal.r.f(segments, "segments");
        kotlin.jvm.internal.r.f(directory, "directory");
        this.f3359f = segments;
        this.f3360g = directory;
    }

    @Override // O3.g
    public void A(d buffer, int i4, int i5) {
        kotlin.jvm.internal.r.f(buffer, "buffer");
        int i6 = i4 + i5;
        int iB = P3.c.b(this, i4);
        while (i4 < i6) {
            int i7 = iB == 0 ? 0 : B()[iB - 1];
            int i8 = B()[iB] - i7;
            int i9 = B()[C().length + iB];
            int iMin = Math.min(i6, i8 + i7) - i4;
            int i10 = i9 + (i4 - i7);
            o oVar = new o(C()[iB], i10, i10 + iMin, true, false);
            o oVar2 = buffer.f3321a;
            if (oVar2 == null) {
                oVar.f3353g = oVar;
                oVar.f3352f = oVar;
                buffer.f3321a = oVar;
            } else {
                kotlin.jvm.internal.r.c(oVar2);
                o oVar3 = oVar2.f3353g;
                kotlin.jvm.internal.r.c(oVar3);
                oVar3.c(oVar);
            }
            i4 += iMin;
            iB++;
        }
        buffer.h0(buffer.i0() + ((long) i5));
    }

    public final int[] B() {
        return this.f3360g;
    }

    public final byte[][] C() {
        return this.f3359f;
    }

    public final g D() {
        return new g(y());
    }

    @Override // O3.g
    public String a() {
        return D().a();
    }

    @Override // O3.g
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (gVar.v() == v() && r(0, gVar, 0, v())) {
                return true;
            }
        }
        return false;
    }

    @Override // O3.g
    public int hashCode() {
        int iK = k();
        if (iK != 0) {
            return iK;
        }
        int length = C().length;
        int i4 = 0;
        int i5 = 1;
        int i6 = 0;
        while (i4 < length) {
            int i7 = B()[length + i4];
            int i8 = B()[i4];
            byte[] bArr = C()[i4];
            int i9 = (i8 - i6) + i7;
            while (i7 < i9) {
                i5 = (i5 * 31) + bArr[i7];
                i7++;
            }
            i4++;
            i6 = i8;
        }
        t(i5);
        return i5;
    }

    @Override // O3.g
    public int l() {
        return B()[C().length - 1];
    }

    @Override // O3.g
    public String n() {
        return D().n();
    }

    @Override // O3.g
    public byte[] o() {
        return y();
    }

    @Override // O3.g
    public byte p(int i4) {
        b.b(B()[C().length - 1], i4, 1L);
        int iB = P3.c.b(this, i4);
        return C()[iB][(i4 - (iB == 0 ? 0 : B()[iB - 1])) + B()[C().length + iB]];
    }

    @Override // O3.g
    public boolean r(int i4, g other, int i5, int i6) {
        kotlin.jvm.internal.r.f(other, "other");
        if (i4 < 0 || i4 > v() - i6) {
            return false;
        }
        int i7 = i6 + i4;
        int iB = P3.c.b(this, i4);
        while (i4 < i7) {
            int i8 = iB == 0 ? 0 : B()[iB - 1];
            int i9 = B()[iB] - i8;
            int i10 = B()[C().length + iB];
            int iMin = Math.min(i7, i9 + i8) - i4;
            if (!other.s(i5, C()[iB], i10 + (i4 - i8), iMin)) {
                return false;
            }
            i5 += iMin;
            i4 += iMin;
            iB++;
        }
        return true;
    }

    @Override // O3.g
    public boolean s(int i4, byte[] other, int i5, int i6) {
        kotlin.jvm.internal.r.f(other, "other");
        if (i4 < 0 || i4 > v() - i6 || i5 < 0 || i5 > other.length - i6) {
            return false;
        }
        int i7 = i6 + i4;
        int iB = P3.c.b(this, i4);
        while (i4 < i7) {
            int i8 = iB == 0 ? 0 : B()[iB - 1];
            int i9 = B()[iB] - i8;
            int i10 = B()[C().length + iB];
            int iMin = Math.min(i7, i9 + i8) - i4;
            if (!b.a(C()[iB], i10 + (i4 - i8), other, i5, iMin)) {
                return false;
            }
            i5 += iMin;
            i4 += iMin;
            iB++;
        }
        return true;
    }

    @Override // O3.g
    public String toString() {
        return D().toString();
    }

    @Override // O3.g
    public g x() {
        return D().x();
    }

    @Override // O3.g
    public byte[] y() {
        byte[] bArr = new byte[v()];
        int length = C().length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < length) {
            int i7 = B()[length + i4];
            int i8 = B()[i4];
            int i9 = i8 - i5;
            AbstractC0763j.d(C()[i4], bArr, i6, i7, i7 + i9);
            i6 += i9;
            i4++;
            i5 = i8;
        }
        return bArr;
    }
}
