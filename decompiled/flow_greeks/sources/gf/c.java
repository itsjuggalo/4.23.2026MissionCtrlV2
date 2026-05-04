package gf;

import gf.d;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class c extends o {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f10625d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f10626e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f10628b;

        @Override // gf.d.a
        public byte a() {
            int i10 = this.f10627a;
            if (i10 >= this.f10628b) {
                throw new NoSuchElementException();
            }
            byte[] bArr = c.this.f10691b;
            this.f10627a = i10 + 1;
            return bArr[i10];
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Byte next() {
            return Byte.valueOf(a());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f10627a < this.f10628b;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public b() {
            int iU = c.this.U();
            this.f10627a = iU;
            this.f10628b = iU + c.this.size();
        }
    }

    public c(byte[] bArr, int i10, int i11) {
        super(bArr);
        if (i10 < 0) {
            StringBuilder sb2 = new StringBuilder(29);
            sb2.append("Offset too small: ");
            sb2.append(i10);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (i11 < 0) {
            StringBuilder sb3 = new StringBuilder(29);
            sb3.append("Length too small: ");
            sb3.append(i10);
            throw new IllegalArgumentException(sb3.toString());
        }
        if (((long) i10) + ((long) i11) <= bArr.length) {
            this.f10625d = i10;
            this.f10626e = i11;
            return;
        }
        StringBuilder sb4 = new StringBuilder(48);
        sb4.append("Offset+Length too large: ");
        sb4.append(i10);
        sb4.append("+");
        sb4.append(i11);
        throw new IllegalArgumentException(sb4.toString());
    }

    @Override // gf.o
    public int U() {
        return this.f10625d;
    }

    @Override // gf.o, java.lang.Iterable
    /* JADX INFO: renamed from: W */
    public d.a iterator() {
        return new b();
    }

    @Override // gf.o, gf.d
    public void q(byte[] bArr, int i10, int i11, int i12) {
        System.arraycopy(this.f10691b, U() + i10, bArr, i11, i12);
    }

    @Override // gf.o, gf.d
    public int size() {
        return this.f10626e;
    }
}
