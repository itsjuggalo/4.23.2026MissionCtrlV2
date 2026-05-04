package hh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class q extends g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient byte[][] f11507f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final transient int[] f11508g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(byte[][] segments, int[] directory) {
        super(g.f11479e.i());
        kotlin.jvm.internal.t.f(segments, "segments");
        kotlin.jvm.internal.t.f(directory, "directory");
        this.f11507f = segments;
        this.f11508g = directory;
    }

    @Override // hh.g
    public g G() {
        return S().G();
    }

    @Override // hh.g
    public byte[] H() {
        byte[] bArr = new byte[B()];
        int length = R().length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < length) {
            int i13 = M()[length + i10];
            int i14 = M()[i10];
            int i15 = i14 - i11;
            dd.l.e(R()[i10], bArr, i12, i13, i13 + i15);
            i12 += i15;
            i10++;
            i11 = i14;
        }
        return bArr;
    }

    @Override // hh.g
    public void L(d buffer, int i10, int i11) {
        kotlin.jvm.internal.t.f(buffer, "buffer");
        int i12 = i10 + i11;
        int iB = ih.c.b(this, i10);
        while (i10 < i12) {
            int i13 = iB == 0 ? 0 : M()[iB - 1];
            int i14 = M()[iB] - i13;
            int i15 = M()[R().length + iB];
            int iMin = Math.min(i12, i14 + i13) - i10;
            int i16 = i15 + (i10 - i13);
            o oVar = new o(R()[iB], i16, i16 + iMin, true, false);
            o oVar2 = buffer.f11469a;
            if (oVar2 == null) {
                oVar.f11501g = oVar;
                oVar.f11500f = oVar;
                buffer.f11469a = oVar;
            } else {
                kotlin.jvm.internal.t.c(oVar2);
                o oVar3 = oVar2.f11501g;
                kotlin.jvm.internal.t.c(oVar3);
                oVar3.c(oVar);
            }
            i10 += iMin;
            iB++;
        }
        buffer.f0(buffer.size() + ((long) i11));
    }

    public final int[] M() {
        return this.f11508g;
    }

    public final byte[][] R() {
        return this.f11507f;
    }

    public final g S() {
        return new g(H());
    }

    @Override // hh.g
    public String a() {
        return S().a();
    }

    @Override // hh.g
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (gVar.B() == B() && v(0, gVar, 0, B())) {
                return true;
            }
        }
        return false;
    }

    @Override // hh.g
    public int hashCode() {
        int iK = k();
        if (iK != 0) {
            return iK;
        }
        int length = R().length;
        int i10 = 0;
        int i11 = 1;
        int i12 = 0;
        while (i10 < length) {
            int i13 = M()[length + i10];
            int i14 = M()[i10];
            byte[] bArr = R()[i10];
            int i15 = (i14 - i12) + i13;
            while (i13 < i15) {
                i11 = (i11 * 31) + bArr[i13];
                i13++;
            }
            i10++;
            i12 = i14;
        }
        y(i11);
        return i11;
    }

    @Override // hh.g
    public int l() {
        return M()[R().length - 1];
    }

    @Override // hh.g
    public String o() {
        return S().o();
    }

    @Override // hh.g
    public byte[] q() {
        return H();
    }

    @Override // hh.g
    public byte s(int i10) {
        b.b(M()[R().length - 1], i10, 1L);
        int iB = ih.c.b(this, i10);
        return R()[iB][(i10 - (iB == 0 ? 0 : M()[iB - 1])) + M()[R().length + iB]];
    }

    @Override // hh.g
    public String toString() {
        return S().toString();
    }

    @Override // hh.g
    public boolean v(int i10, g other, int i11, int i12) {
        kotlin.jvm.internal.t.f(other, "other");
        if (i10 < 0 || i10 > B() - i12) {
            return false;
        }
        int i13 = i12 + i10;
        int iB = ih.c.b(this, i10);
        while (i10 < i13) {
            int i14 = iB == 0 ? 0 : M()[iB - 1];
            int i15 = M()[iB] - i14;
            int i16 = M()[R().length + iB];
            int iMin = Math.min(i13, i15 + i14) - i10;
            if (!other.w(i11, R()[iB], i16 + (i10 - i14), iMin)) {
                return false;
            }
            i11 += iMin;
            i10 += iMin;
            iB++;
        }
        return true;
    }

    @Override // hh.g
    public boolean w(int i10, byte[] other, int i11, int i12) {
        kotlin.jvm.internal.t.f(other, "other");
        if (i10 < 0 || i10 > B() - i12 || i11 < 0 || i11 > other.length - i12) {
            return false;
        }
        int i13 = i12 + i10;
        int iB = ih.c.b(this, i10);
        while (i10 < i13) {
            int i14 = iB == 0 ? 0 : M()[iB - 1];
            int i15 = M()[iB] - i14;
            int i16 = M()[R().length + iB];
            int iMin = Math.min(i13, i15 + i14) - i10;
            if (!b.a(R()[iB], i16 + (i10 - i14), other, i11, iMin)) {
                return false;
            }
            i11 += iMin;
            i10 += iMin;
            iB++;
        }
        return true;
    }
}
