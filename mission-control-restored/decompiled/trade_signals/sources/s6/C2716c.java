package s6;

import java.util.NoSuchElementException;
import s6.AbstractC2717d;

/* JADX INFO: renamed from: s6.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2716c extends o {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f23123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f23124e;

    /* JADX INFO: renamed from: s6.c$b */
    public class b implements AbstractC2717d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f23125a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f23126b;

        public b() {
            int iU = C2716c.this.U();
            this.f23125a = iU;
            this.f23126b = iU + C2716c.this.size();
        }

        @Override // s6.AbstractC2717d.a
        public byte a() {
            int i8 = this.f23125a;
            if (i8 >= this.f23126b) {
                throw new NoSuchElementException();
            }
            byte[] bArr = C2716c.this.f23189b;
            this.f23125a = i8 + 1;
            return bArr[i8];
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Byte next() {
            return Byte.valueOf(a());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f23125a < this.f23126b;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public C2716c(byte[] bArr, int i8, int i9) {
        super(bArr);
        if (i8 < 0) {
            StringBuilder sb = new StringBuilder(29);
            sb.append("Offset too small: ");
            sb.append(i8);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i9 < 0) {
            StringBuilder sb2 = new StringBuilder(29);
            sb2.append("Length too small: ");
            sb2.append(i8);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (((long) i8) + ((long) i9) <= bArr.length) {
            this.f23123d = i8;
            this.f23124e = i9;
            return;
        }
        StringBuilder sb3 = new StringBuilder(48);
        sb3.append("Offset+Length too large: ");
        sb3.append(i8);
        sb3.append("+");
        sb3.append(i9);
        throw new IllegalArgumentException(sb3.toString());
    }

    @Override // s6.o, s6.AbstractC2717d
    public void F(byte[] bArr, int i8, int i9, int i10) {
        System.arraycopy(this.f23189b, U() + i8, bArr, i9, i10);
    }

    @Override // s6.o
    public int U() {
        return this.f23123d;
    }

    @Override // s6.o, java.lang.Iterable
    /* JADX INFO: renamed from: W */
    public AbstractC2717d.a iterator() {
        return new b();
    }

    @Override // s6.o, s6.AbstractC2717d
    public int size() {
        return this.f23124e;
    }
}
