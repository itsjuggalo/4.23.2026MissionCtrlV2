package w6;

import F5.AbstractC0551i;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes2.dex */
public final class W extends C2795h {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient byte[][] f25064f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final transient int[] f25065g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public W(byte[][] segments, int[] directory) {
        super(C2795h.f25107e.m());
        kotlin.jvm.internal.r.f(segments, "segments");
        kotlin.jvm.internal.r.f(directory, "directory");
        this.f25064f = segments;
        this.f25065g = directory;
    }

    @Override // w6.C2795h
    public boolean B(int i7, C2795h other, int i8, int i9) {
        kotlin.jvm.internal.r.f(other, "other");
        if (i7 < 0 || i7 > H() - i9) {
            return false;
        }
        int i10 = i9 + i7;
        int iB = x6.e.b(this, i7);
        while (i7 < i10) {
            int i11 = iB == 0 ? 0 : P()[iB - 1];
            int i12 = P()[iB] - i11;
            int i13 = P()[Q().length + iB];
            int iMin = Math.min(i10, i12 + i11) - i7;
            if (!other.C(i8, Q()[iB], i13 + (i7 - i11), iMin)) {
                return false;
            }
            i8 += iMin;
            i7 += iMin;
            iB++;
        }
        return true;
    }

    @Override // w6.C2795h
    public boolean C(int i7, byte[] other, int i8, int i9) {
        kotlin.jvm.internal.r.f(other, "other");
        if (i7 < 0 || i7 > H() - i9 || i8 < 0 || i8 > other.length - i9) {
            return false;
        }
        int i10 = i9 + i7;
        int iB = x6.e.b(this, i7);
        while (i7 < i10) {
            int i11 = iB == 0 ? 0 : P()[iB - 1];
            int i12 = P()[iB] - i11;
            int i13 = P()[Q().length + iB];
            int iMin = Math.min(i10, i12 + i11) - i7;
            if (!AbstractC2789b.a(Q()[iB], i13 + (i7 - i11), other, i8, iMin)) {
                return false;
            }
            i8 += iMin;
            i7 += iMin;
            iB++;
        }
        return true;
    }

    @Override // w6.C2795h
    public C2795h J(int i7, int i8) {
        int iD = AbstractC2789b.d(this, i8);
        if (i7 < 0) {
            throw new IllegalArgumentException(("beginIndex=" + i7 + " < 0").toString());
        }
        if (iD > H()) {
            throw new IllegalArgumentException(("endIndex=" + iD + " > length(" + H() + ')').toString());
        }
        int i9 = iD - i7;
        if (i9 < 0) {
            throw new IllegalArgumentException(("endIndex=" + iD + " < beginIndex=" + i7).toString());
        }
        if (i7 == 0 && iD == H()) {
            return this;
        }
        if (i7 == iD) {
            return C2795h.f25107e;
        }
        int iB = x6.e.b(this, i7);
        int iB2 = x6.e.b(this, iD - 1);
        byte[][] bArr = (byte[][]) AbstractC0551i.i(Q(), iB, iB2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (iB <= iB2) {
            int i10 = iB;
            int i11 = 0;
            while (true) {
                iArr[i11] = Math.min(P()[i10] - i7, i9);
                int i12 = i11 + 1;
                iArr[i11 + bArr.length] = P()[Q().length + i10];
                if (i10 == iB2) {
                    break;
                }
                i10++;
                i11 = i12;
            }
        }
        int i13 = iB != 0 ? P()[iB - 1] : 0;
        int length = bArr.length;
        iArr[length] = iArr[length] + (i7 - i13);
        return new W(bArr, iArr);
    }

    @Override // w6.C2795h
    public C2795h L() {
        return R().L();
    }

    @Override // w6.C2795h
    public byte[] M() {
        byte[] bArr = new byte[H()];
        int length = Q().length;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i7 < length) {
            int i10 = P()[length + i7];
            int i11 = P()[i7];
            int i12 = i11 - i8;
            AbstractC0551i.d(Q()[i7], bArr, i9, i10, i10 + i12);
            i9 += i12;
            i7++;
            i8 = i11;
        }
        return bArr;
    }

    @Override // w6.C2795h
    public void O(C2792e buffer, int i7, int i8) {
        kotlin.jvm.internal.r.f(buffer, "buffer");
        int i9 = i7 + i8;
        int iB = x6.e.b(this, i7);
        while (i7 < i9) {
            int i10 = iB == 0 ? 0 : P()[iB - 1];
            int i11 = P()[iB] - i10;
            int i12 = P()[Q().length + iB];
            int iMin = Math.min(i9, i11 + i10) - i7;
            int i13 = i12 + (i7 - i10);
            U u7 = new U(Q()[iB], i13, i13 + iMin, true, false);
            U u8 = buffer.f25095a;
            if (u8 == null) {
                u7.f25058g = u7;
                u7.f25057f = u7;
                buffer.f25095a = u7;
            } else {
                kotlin.jvm.internal.r.c(u8);
                U u9 = u8.f25058g;
                kotlin.jvm.internal.r.c(u9);
                u9.c(u7);
            }
            i7 += iMin;
            iB++;
        }
        buffer.D0(buffer.E0() + ((long) i8));
    }

    public final int[] P() {
        return this.f25065g;
    }

    public final byte[][] Q() {
        return this.f25064f;
    }

    public final C2795h R() {
        return new C2795h(M());
    }

    @Override // w6.C2795h
    public String a() {
        return R().a();
    }

    @Override // w6.C2795h
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C2795h) {
            C2795h c2795h = (C2795h) obj;
            if (c2795h.H() == H() && B(0, c2795h, 0, H())) {
                return true;
            }
        }
        return false;
    }

    @Override // w6.C2795h
    public int hashCode() {
        int iN = n();
        if (iN != 0) {
            return iN;
        }
        int length = Q().length;
        int i7 = 0;
        int i8 = 1;
        int i9 = 0;
        while (i7 < length) {
            int i10 = P()[length + i7];
            int i11 = P()[i7];
            byte[] bArr = Q()[i7];
            int i12 = (i11 - i9) + i10;
            while (i10 < i12) {
                i8 = (i8 * 31) + bArr[i10];
                i10++;
            }
            i7++;
            i9 = i11;
        }
        D(i8);
        return i8;
    }

    @Override // w6.C2795h
    public C2795h i(String algorithm) throws NoSuchAlgorithmException {
        kotlin.jvm.internal.r.f(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        int length = Q().length;
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            int i9 = P()[length + i7];
            int i10 = P()[i7];
            messageDigest.update(Q()[i7], i9, i10 - i8);
            i7++;
            i8 = i10;
        }
        byte[] digestBytes = messageDigest.digest();
        kotlin.jvm.internal.r.e(digestBytes, "digestBytes");
        return new C2795h(digestBytes);
    }

    @Override // w6.C2795h
    public int o() {
        return P()[Q().length - 1];
    }

    @Override // w6.C2795h
    public String q() {
        return R().q();
    }

    @Override // w6.C2795h
    public int s(byte[] other, int i7) {
        kotlin.jvm.internal.r.f(other, "other");
        return R().s(other, i7);
    }

    @Override // w6.C2795h
    public String toString() {
        return R().toString();
    }

    @Override // w6.C2795h
    public byte[] u() {
        return M();
    }

    @Override // w6.C2795h
    public byte v(int i7) {
        AbstractC2789b.b(P()[Q().length - 1], i7, 1L);
        int iB = x6.e.b(this, i7);
        return Q()[iB][(i7 - (iB == 0 ? 0 : P()[iB - 1])) + P()[Q().length + iB]];
    }

    @Override // w6.C2795h
    public int x(byte[] other, int i7) {
        kotlin.jvm.internal.r.f(other, "other");
        return R().x(other, i7);
    }
}
