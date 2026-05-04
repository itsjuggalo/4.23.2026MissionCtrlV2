package gf;

import gf.d;
import java.io.IOException;
import java.io.OutputStream;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class o extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f10691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10692c = 0;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10693a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f10694b;

        @Override // gf.d.a
        public byte a() {
            try {
                byte[] bArr = o.this.f10691b;
                int i10 = this.f10693a;
                this.f10693a = i10 + 1;
                return bArr[i10];
            } catch (ArrayIndexOutOfBoundsException e10) {
                throw new NoSuchElementException(e10.getMessage());
            }
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Byte next() {
            return Byte.valueOf(a());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f10693a < this.f10694b;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public b() {
            this.f10693a = 0;
            this.f10694b = o.this.size();
        }
    }

    public o(byte[] bArr) {
        this.f10691b = bArr;
    }

    public static int V(int i10, byte[] bArr, int i11, int i12) {
        for (int i13 = i11; i13 < i11 + i12; i13++) {
            i10 = (i10 * 31) + bArr[i13];
        }
        return i10;
    }

    @Override // gf.d
    public int A() {
        return this.f10692c;
    }

    @Override // gf.d
    public String K(String str) {
        return new String(this.f10691b, U(), size(), str);
    }

    @Override // gf.d
    public void S(OutputStream outputStream, int i10, int i11) throws IOException {
        outputStream.write(this.f10691b, U() + i10, i11);
    }

    public boolean T(o oVar, int i10, int i11) {
        if (i11 > oVar.size()) {
            int size = size();
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Length too large: ");
            sb2.append(i11);
            sb2.append(size);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (i10 + i11 > oVar.size()) {
            int size2 = oVar.size();
            StringBuilder sb3 = new StringBuilder(59);
            sb3.append("Ran off end of other: ");
            sb3.append(i10);
            sb3.append(", ");
            sb3.append(i11);
            sb3.append(", ");
            sb3.append(size2);
            throw new IllegalArgumentException(sb3.toString());
        }
        byte[] bArr = this.f10691b;
        byte[] bArr2 = oVar.f10691b;
        int iU = U() + i11;
        int iU2 = U();
        int iU3 = oVar.U() + i10;
        while (iU2 < iU) {
            if (bArr[iU2] != bArr2[iU3]) {
                return false;
            }
            iU2++;
            iU3++;
        }
        return true;
    }

    public int U() {
        return 0;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public d.a iterator() {
        return new b();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d) || size() != ((d) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof o) {
            return T((o) obj, 0, size());
        }
        if (obj instanceof t) {
            return obj.equals(this);
        }
        String strValueOf = String.valueOf(obj.getClass());
        StringBuilder sb2 = new StringBuilder(strValueOf.length() + 49);
        sb2.append("Has a new type of ByteString been created? Found ");
        sb2.append(strValueOf);
        throw new IllegalArgumentException(sb2.toString());
    }

    public int hashCode() {
        int iW = this.f10692c;
        if (iW == 0) {
            int size = size();
            iW = w(size, 0, size);
            if (iW == 0) {
                iW = 1;
            }
            this.f10692c = iW;
        }
        return iW;
    }

    @Override // gf.d
    public void q(byte[] bArr, int i10, int i11, int i12) {
        System.arraycopy(this.f10691b, i10, bArr, i11, i12);
    }

    @Override // gf.d
    public int r() {
        return 0;
    }

    @Override // gf.d
    public boolean s() {
        return true;
    }

    @Override // gf.d
    public int size() {
        return this.f10691b.length;
    }

    @Override // gf.d
    public boolean u() {
        int iU = U();
        return x.f(this.f10691b, iU, size() + iU);
    }

    @Override // gf.d
    public int w(int i10, int i11, int i12) {
        return V(i10, this.f10691b, U() + i11, i12);
    }

    @Override // gf.d
    public int y(int i10, int i11, int i12) {
        int iU = U() + i11;
        return x.g(i10, this.f10691b, iU, i12 + iU);
    }
}
