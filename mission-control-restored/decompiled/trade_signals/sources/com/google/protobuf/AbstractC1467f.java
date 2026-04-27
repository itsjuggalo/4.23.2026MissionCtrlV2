package com.google.protobuf;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: com.google.protobuf.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1467f implements Iterable, Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbstractC1467f f16361b = new j(AbstractC1481u.f16590d);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final InterfaceC0264f f16362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Comparator f16363d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16364a = 0;

    /* JADX INFO: renamed from: com.google.protobuf.f$a */
    public class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f16365a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f16366b;

        public a() {
            this.f16366b = AbstractC1467f.this.size();
        }

        @Override // com.google.protobuf.AbstractC1467f.g
        public byte a() {
            int i8 = this.f16365a;
            if (i8 >= this.f16366b) {
                throw new NoSuchElementException();
            }
            this.f16365a = i8 + 1;
            return AbstractC1467f.this.F(i8);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f16365a < this.f16366b;
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.f$b */
    public class b implements Comparator {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(AbstractC1467f abstractC1467f, AbstractC1467f abstractC1467f2) {
            g gVarI = abstractC1467f.I();
            g gVarI2 = abstractC1467f2.I();
            while (gVarI.hasNext() && gVarI2.hasNext()) {
                int iCompareTo = Integer.valueOf(AbstractC1467f.N(gVarI.a())).compareTo(Integer.valueOf(AbstractC1467f.N(gVarI2.a())));
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
            }
            return Integer.valueOf(abstractC1467f.size()).compareTo(Integer.valueOf(abstractC1467f2.size()));
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.f$c */
    public static abstract class c implements g {
        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Byte next() {
            return Byte.valueOf(a());
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.f$d */
    public static final class d implements InterfaceC0264f {
        public d() {
        }

        @Override // com.google.protobuf.AbstractC1467f.InterfaceC0264f
        public byte[] a(byte[] bArr, int i8, int i9) {
            return Arrays.copyOfRange(bArr, i8, i9 + i8);
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.f$e */
    public static final class e extends j {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f16368f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f16369g;

        public e(byte[] bArr, int i8, int i9) {
            super(bArr);
            AbstractC1467f.f(i8, i8 + i9, bArr.length);
            this.f16368f = i8;
            this.f16369g = i9;
        }

        @Override // com.google.protobuf.AbstractC1467f.j, com.google.protobuf.AbstractC1467f
        public byte F(int i8) {
            return this.f16372e[this.f16368f + i8];
        }

        @Override // com.google.protobuf.AbstractC1467f.j
        public int W() {
            return this.f16368f;
        }

        @Override // com.google.protobuf.AbstractC1467f.j, com.google.protobuf.AbstractC1467f
        public byte d(int i8) {
            AbstractC1467f.e(i8, size());
            return this.f16372e[this.f16368f + i8];
        }

        @Override // com.google.protobuf.AbstractC1467f.j, com.google.protobuf.AbstractC1467f
        public int size() {
            return this.f16369g;
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.f$f, reason: collision with other inner class name */
    public interface InterfaceC0264f {
        byte[] a(byte[] bArr, int i8, int i9);
    }

    /* JADX INFO: renamed from: com.google.protobuf.f$g */
    public interface g extends Iterator {
        byte a();
    }

    /* JADX INFO: renamed from: com.google.protobuf.f$h */
    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC1470i f16370a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f16371b;

        public h(int i8) {
            byte[] bArr = new byte[i8];
            this.f16371b = bArr;
            this.f16370a = AbstractC1470i.a0(bArr);
        }

        public AbstractC1467f a() {
            this.f16370a.c();
            return new j(this.f16371b);
        }

        public AbstractC1470i b() {
            return this.f16370a;
        }

        public /* synthetic */ h(int i8, a aVar) {
            this(i8);
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.f$i */
    public static abstract class i extends AbstractC1467f {
        @Override // java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.I();
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.f$j */
    public static class j extends i {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final byte[] f16372e;

        public j(byte[] bArr) {
            bArr.getClass();
            this.f16372e = bArr;
        }

        @Override // com.google.protobuf.AbstractC1467f
        public byte F(int i8) {
            return this.f16372e[i8];
        }

        @Override // com.google.protobuf.AbstractC1467f
        public final boolean H() {
            int iW = W();
            return k0.n(this.f16372e, iW, size() + iW);
        }

        @Override // com.google.protobuf.AbstractC1467f
        public final int K(int i8, int i9, int i10) {
            return AbstractC1481u.h(i8, this.f16372e, W() + i9, i10);
        }

        @Override // com.google.protobuf.AbstractC1467f
        public final AbstractC1467f M(int i8, int i9) {
            int iF = AbstractC1467f.f(i8, i9, size());
            return iF == 0 ? AbstractC1467f.f16361b : new e(this.f16372e, W() + i8, iF);
        }

        @Override // com.google.protobuf.AbstractC1467f
        public final String P(Charset charset) {
            return new String(this.f16372e, W(), size(), charset);
        }

        @Override // com.google.protobuf.AbstractC1467f
        public final void U(AbstractC1466e abstractC1466e) {
            abstractC1466e.a(this.f16372e, W(), size());
        }

        public final boolean V(AbstractC1467f abstractC1467f, int i8, int i9) {
            if (i9 > abstractC1467f.size()) {
                throw new IllegalArgumentException("Length too large: " + i9 + size());
            }
            int i10 = i8 + i9;
            if (i10 > abstractC1467f.size()) {
                throw new IllegalArgumentException("Ran off end of other: " + i8 + ", " + i9 + ", " + abstractC1467f.size());
            }
            if (!(abstractC1467f instanceof j)) {
                return abstractC1467f.M(i8, i10).equals(M(0, i9));
            }
            j jVar = (j) abstractC1467f;
            byte[] bArr = this.f16372e;
            byte[] bArr2 = jVar.f16372e;
            int iW = W() + i9;
            int iW2 = W();
            int iW3 = jVar.W() + i8;
            while (iW2 < iW) {
                if (bArr[iW2] != bArr2[iW3]) {
                    return false;
                }
                iW2++;
                iW3++;
            }
            return true;
        }

        public int W() {
            return 0;
        }

        @Override // com.google.protobuf.AbstractC1467f
        public byte d(int i8) {
            return this.f16372e[i8];
        }

        @Override // com.google.protobuf.AbstractC1467f
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AbstractC1467f) || size() != ((AbstractC1467f) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof j)) {
                return obj.equals(this);
            }
            j jVar = (j) obj;
            int iL = L();
            int iL2 = jVar.L();
            if (iL == 0 || iL2 == 0 || iL == iL2) {
                return V(jVar, 0, size());
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractC1467f
        public int size() {
            return this.f16372e.length;
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.f$k */
    public static final class k implements InterfaceC0264f {
        public k() {
        }

        @Override // com.google.protobuf.AbstractC1467f.InterfaceC0264f
        public byte[] a(byte[] bArr, int i8, int i9) {
            byte[] bArr2 = new byte[i9];
            System.arraycopy(bArr, i8, bArr2, 0, i9);
            return bArr2;
        }

        public /* synthetic */ k(a aVar) {
            this();
        }
    }

    static {
        a aVar = null;
        f16362c = AbstractC1465d.c() ? new k(aVar) : new d(aVar);
        f16363d = new b();
    }

    public static AbstractC1467f C(String str) {
        return new j(str.getBytes(AbstractC1481u.f16588b));
    }

    public static h J(int i8) {
        return new h(i8, null);
    }

    public static int N(byte b8) {
        return b8 & 255;
    }

    public static AbstractC1467f S(byte[] bArr) {
        return new j(bArr);
    }

    public static AbstractC1467f T(byte[] bArr, int i8, int i9) {
        return new e(bArr, i8, i9);
    }

    public static void e(int i8, int i9) {
        if (((i9 - (i8 + 1)) | i8) < 0) {
            if (i8 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i8);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i8 + ", " + i9);
        }
    }

    public static int f(int i8, int i9, int i10) {
        int i11 = i9 - i8;
        if ((i8 | i9 | i11 | (i10 - i9)) >= 0) {
            return i11;
        }
        if (i8 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i8 + " < 0");
        }
        if (i9 < i8) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i8 + ", " + i9);
        }
        throw new IndexOutOfBoundsException("End index: " + i9 + " >= " + i10);
    }

    public static AbstractC1467f h(byte[] bArr) {
        return n(bArr, 0, bArr.length);
    }

    public static AbstractC1467f n(byte[] bArr, int i8, int i9) {
        f(i8, i8 + i9, bArr.length);
        return new j(f16362c.a(bArr, i8, i9));
    }

    public abstract byte F(int i8);

    public abstract boolean H();

    public g I() {
        return new a();
    }

    public abstract int K(int i8, int i9, int i10);

    public final int L() {
        return this.f16364a;
    }

    public abstract AbstractC1467f M(int i8, int i9);

    public final String O(Charset charset) {
        return size() == 0 ? "" : P(charset);
    }

    public abstract String P(Charset charset);

    public final String Q() {
        return O(AbstractC1481u.f16588b);
    }

    public final String R() {
        if (size() <= 50) {
            return d0.a(this);
        }
        return d0.a(M(0, 47)) + "...";
    }

    public abstract void U(AbstractC1466e abstractC1466e);

    public abstract byte d(int i8);

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iK = this.f16364a;
        if (iK == 0) {
            int size = size();
            iK = K(size, 0, size);
            if (iK == 0) {
                iK = 1;
            }
            this.f16364a = iK;
        }
        return iK;
    }

    public abstract int size();

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), R());
    }
}
