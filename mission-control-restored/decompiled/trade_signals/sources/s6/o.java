package s6;

import java.io.IOException;
import java.io.OutputStream;
import java.util.NoSuchElementException;
import s6.AbstractC2717d;

/* JADX INFO: loaded from: classes2.dex */
public class o extends AbstractC2717d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f23189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f23190c = 0;

    public class b implements AbstractC2717d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f23191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f23192b;

        public b() {
            this.f23191a = 0;
            this.f23192b = o.this.size();
        }

        @Override // s6.AbstractC2717d.a
        public byte a() {
            try {
                byte[] bArr = o.this.f23189b;
                int i8 = this.f23191a;
                this.f23191a = i8 + 1;
                return bArr[i8];
            } catch (ArrayIndexOutOfBoundsException e8) {
                throw new NoSuchElementException(e8.getMessage());
            }
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Byte next() {
            return Byte.valueOf(a());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f23191a < this.f23192b;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public o(byte[] bArr) {
        this.f23189b = bArr;
    }

    public static int V(int i8, byte[] bArr, int i9, int i10) {
        for (int i11 = i9; i11 < i9 + i10; i11++) {
            i8 = (i8 * 31) + bArr[i11];
        }
        return i8;
    }

    @Override // s6.AbstractC2717d
    public void F(byte[] bArr, int i8, int i9, int i10) {
        System.arraycopy(this.f23189b, i8, bArr, i9, i10);
    }

    @Override // s6.AbstractC2717d
    public int H() {
        return 0;
    }

    @Override // s6.AbstractC2717d
    public boolean I() {
        return true;
    }

    @Override // s6.AbstractC2717d
    public boolean J() {
        int iU = U();
        return x.f(this.f23189b, iU, size() + iU);
    }

    @Override // s6.AbstractC2717d
    public int L(int i8, int i9, int i10) {
        return V(i8, this.f23189b, U() + i9, i10);
    }

    @Override // s6.AbstractC2717d
    public int M(int i8, int i9, int i10) {
        int iU = U() + i9;
        return x.g(i8, this.f23189b, iU, i10 + iU);
    }

    @Override // s6.AbstractC2717d
    public int N() {
        return this.f23190c;
    }

    @Override // s6.AbstractC2717d
    public String P(String str) {
        return new String(this.f23189b, U(), size(), str);
    }

    @Override // s6.AbstractC2717d
    public void S(OutputStream outputStream, int i8, int i9) throws IOException {
        outputStream.write(this.f23189b, U() + i8, i9);
    }

    public boolean T(o oVar, int i8, int i9) {
        if (i9 > oVar.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i9);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i8 + i9 > oVar.size()) {
            int size2 = oVar.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: ");
            sb2.append(i8);
            sb2.append(", ");
            sb2.append(i9);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        }
        byte[] bArr = this.f23189b;
        byte[] bArr2 = oVar.f23189b;
        int iU = U() + i9;
        int iU2 = U();
        int iU3 = oVar.U() + i8;
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
    public AbstractC2717d.a iterator() {
        return new b();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2717d) || size() != ((AbstractC2717d) obj).size()) {
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
        StringBuilder sb = new StringBuilder(strValueOf.length() + 49);
        sb.append("Has a new type of ByteString been created? Found ");
        sb.append(strValueOf);
        throw new IllegalArgumentException(sb.toString());
    }

    public int hashCode() {
        int iL = this.f23190c;
        if (iL == 0) {
            int size = size();
            iL = L(size, 0, size);
            if (iL == 0) {
                iL = 1;
            }
            this.f23190c = iL;
        }
        return iL;
    }

    @Override // s6.AbstractC2717d
    public int size() {
        return this.f23189b.length;
    }
}
