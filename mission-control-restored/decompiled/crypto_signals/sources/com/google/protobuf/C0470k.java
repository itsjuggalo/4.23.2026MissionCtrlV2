package com.google.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;

/* JADX INFO: renamed from: com.google.protobuf.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0470k extends AbstractC0472l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f5741d;

    public C0470k(byte[] bArr) {
        bArr.getClass();
        this.f5741d = bArr;
    }

    @Override // com.google.protobuf.AbstractC0472l
    public final ByteBuffer a() {
        return ByteBuffer.wrap(this.f5741d, y(), size()).asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.AbstractC0472l
    public byte c(int i) {
        return this.f5741d[i];
    }

    @Override // com.google.protobuf.AbstractC0472l
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof AbstractC0472l) && size() == ((AbstractC0472l) obj).size()) {
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof C0470k)) {
                return obj.equals(this);
            }
            C0470k c0470k = (C0470k) obj;
            int i = this.f5746a;
            int i6 = c0470k.f5746a;
            if (i == 0 || i6 == 0 || i == i6) {
                return x(c0470k, 0, size());
            }
        }
        return false;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new C0462g(this);
    }

    @Override // com.google.protobuf.AbstractC0472l
    public void l(int i, byte[] bArr, int i6, int i7) {
        System.arraycopy(this.f5741d, i, bArr, i6, i7);
    }

    @Override // com.google.protobuf.AbstractC0472l
    public final int m() {
        return 0;
    }

    @Override // com.google.protobuf.AbstractC0472l
    public byte n(int i) {
        return this.f5741d[i];
    }

    @Override // com.google.protobuf.AbstractC0472l
    public final boolean o() {
        return true;
    }

    @Override // com.google.protobuf.AbstractC0472l
    public final boolean p() {
        int iY = y();
        return P0.f5671a.s(this.f5741d, iY, size() + iY);
    }

    @Override // com.google.protobuf.AbstractC0472l
    public final AbstractC0480p q() {
        return AbstractC0480p.h(this.f5741d, y(), size(), true);
    }

    @Override // com.google.protobuf.AbstractC0472l
    public final int r(int i, int i6, int i7) {
        int iY = y() + i6;
        Charset charset = M.f5651a;
        for (int i8 = iY; i8 < iY + i7; i8++) {
            i = (i * 31) + this.f5741d[i8];
        }
        return i;
    }

    @Override // com.google.protobuf.AbstractC0472l
    public final int s(int i, int i6, int i7) {
        int iY = y() + i6;
        return P0.f5671a.v(i, this.f5741d, iY, i7 + iY);
    }

    @Override // com.google.protobuf.AbstractC0472l
    public int size() {
        return this.f5741d.length;
    }

    @Override // com.google.protobuf.AbstractC0472l
    public final AbstractC0472l t(int i, int i6) {
        int iH = AbstractC0472l.h(i, i6, size());
        if (iH == 0) {
            return AbstractC0472l.f5744b;
        }
        return new C0468j(this.f5741d, y() + i, iH);
    }

    @Override // com.google.protobuf.AbstractC0472l
    public final String v(Charset charset) {
        return new String(this.f5741d, y(), size(), charset);
    }

    @Override // com.google.protobuf.AbstractC0472l
    public final void w(AbstractC0485s abstractC0485s) {
        abstractC0485s.x(this.f5741d, y(), size());
    }

    public final boolean x(C0470k c0470k, int i, int i6) {
        if (i6 > c0470k.size()) {
            throw new IllegalArgumentException("Length too large: " + i6 + size());
        }
        int i7 = i + i6;
        if (i7 > c0470k.size()) {
            throw new IllegalArgumentException("Ran off end of other: " + i + ", " + i6 + ", " + c0470k.size());
        }
        if (!(c0470k instanceof C0470k)) {
            return c0470k.t(i, i7).equals(t(0, i6));
        }
        int iY = y() + i6;
        int iY2 = y();
        int iY3 = c0470k.y() + i;
        while (iY2 < iY) {
            if (this.f5741d[iY2] != c0470k.f5741d[iY3]) {
                return false;
            }
            iY2++;
            iY3++;
        }
        return true;
    }

    public int y() {
        return 0;
    }
}
