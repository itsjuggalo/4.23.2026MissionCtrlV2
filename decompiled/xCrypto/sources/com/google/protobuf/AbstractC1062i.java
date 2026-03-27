package com.google.protobuf;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: com.google.protobuf.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1062i implements Iterable, Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbstractC1062i f11025b = new j(C.f10884d);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f11026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Comparator f11027d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11028a = 0;

    /* JADX INFO: renamed from: com.google.protobuf.i$a */
    public class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11029a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f11030b;

        public a() {
            this.f11030b = AbstractC1062i.this.size();
        }

        @Override // com.google.protobuf.AbstractC1062i.g
        public byte a() {
            int i4 = this.f11029a;
            if (i4 >= this.f11030b) {
                throw new NoSuchElementException();
            }
            this.f11029a = i4 + 1;
            return AbstractC1062i.this.v(i4);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f11029a < this.f11030b;
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.i$b */
    public class b implements Comparator {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(AbstractC1062i abstractC1062i, AbstractC1062i abstractC1062i2) {
            g gVarY = abstractC1062i.iterator();
            g gVarY2 = abstractC1062i2.iterator();
            while (gVarY.hasNext() && gVarY2.hasNext()) {
                int iCompareTo = Integer.valueOf(AbstractC1062i.H(gVarY.a())).compareTo(Integer.valueOf(AbstractC1062i.H(gVarY2.a())));
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
            }
            return Integer.valueOf(abstractC1062i.size()).compareTo(Integer.valueOf(abstractC1062i2.size()));
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.i$c */
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

    /* JADX INFO: renamed from: com.google.protobuf.i$d */
    public static final class d implements f {
        public d() {
        }

        @Override // com.google.protobuf.AbstractC1062i.f
        public byte[] a(byte[] bArr, int i4, int i5) {
            return Arrays.copyOfRange(bArr, i4, i5 + i4);
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.i$e */
    public static final class e extends j {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f11032f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f11033g;

        public e(byte[] bArr, int i4, int i5) {
            super(bArr);
            AbstractC1062i.m(i4, i4 + i5, bArr.length);
            this.f11032f = i4;
            this.f11033g = i5;
        }

        @Override // com.google.protobuf.AbstractC1062i.j
        public int R() {
            return this.f11032f;
        }

        @Override // com.google.protobuf.AbstractC1062i.j, com.google.protobuf.AbstractC1062i
        public byte k(int i4) {
            AbstractC1062i.l(i4, size());
            return this.f11036e[this.f11032f + i4];
        }

        @Override // com.google.protobuf.AbstractC1062i.j, com.google.protobuf.AbstractC1062i
        public int size() {
            return this.f11033g;
        }

        @Override // com.google.protobuf.AbstractC1062i.j, com.google.protobuf.AbstractC1062i
        public void t(byte[] bArr, int i4, int i5, int i6) {
            System.arraycopy(this.f11036e, R() + i4, bArr, i5, i6);
        }

        @Override // com.google.protobuf.AbstractC1062i.j, com.google.protobuf.AbstractC1062i
        public byte v(int i4) {
            return this.f11036e[this.f11032f + i4];
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.i$f */
    public interface f {
        byte[] a(byte[] bArr, int i4, int i5);
    }

    /* JADX INFO: renamed from: com.google.protobuf.i$g */
    public interface g extends Iterator {
        byte a();
    }

    /* JADX INFO: renamed from: com.google.protobuf.i$h */
    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC1065l f11034a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f11035b;

        public /* synthetic */ h(int i4, a aVar) {
            this(i4);
        }

        public AbstractC1062i a() {
            this.f11034a.d();
            return new j(this.f11035b);
        }

        public AbstractC1065l b() {
            return this.f11034a;
        }

        public h(int i4) {
            byte[] bArr = new byte[i4];
            this.f11035b = bArr;
            this.f11034a = AbstractC1065l.d0(bArr);
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.i$i, reason: collision with other inner class name */
    public static abstract class AbstractC0160i extends AbstractC1062i {
        public abstract boolean Q(AbstractC1062i abstractC1062i, int i4, int i5);

        @Override // java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.protobuf.AbstractC1062i
        public final int u() {
            return 0;
        }

        @Override // com.google.protobuf.AbstractC1062i
        public final boolean w() {
            return true;
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.i$j */
    public static class j extends AbstractC0160i {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final byte[] f11036e;

        public j(byte[] bArr) {
            bArr.getClass();
            this.f11036e = bArr;
        }

        @Override // com.google.protobuf.AbstractC1062i
        public final AbstractC1063j A() {
            return AbstractC1063j.n(this.f11036e, R(), size(), true);
        }

        @Override // com.google.protobuf.AbstractC1062i
        public final int B(int i4, int i5, int i6) {
            return C.i(i4, this.f11036e, R() + i5, i6);
        }

        @Override // com.google.protobuf.AbstractC1062i
        public final int C(int i4, int i5, int i6) {
            int iR = R() + i5;
            return B0.v(i4, this.f11036e, iR, i6 + iR);
        }

        @Override // com.google.protobuf.AbstractC1062i
        public final AbstractC1062i F(int i4, int i5) {
            int iM = AbstractC1062i.m(i4, i5, size());
            return iM == 0 ? AbstractC1062i.f11025b : new e(this.f11036e, R() + i4, iM);
        }

        @Override // com.google.protobuf.AbstractC1062i
        public final String J(Charset charset) {
            return new String(this.f11036e, R(), size(), charset);
        }

        @Override // com.google.protobuf.AbstractC1062i
        public final void P(AbstractC1061h abstractC1061h) {
            abstractC1061h.b(this.f11036e, R(), size());
        }

        @Override // com.google.protobuf.AbstractC1062i.AbstractC0160i
        public final boolean Q(AbstractC1062i abstractC1062i, int i4, int i5) {
            if (i5 > abstractC1062i.size()) {
                throw new IllegalArgumentException("Length too large: " + i5 + size());
            }
            int i6 = i4 + i5;
            if (i6 > abstractC1062i.size()) {
                throw new IllegalArgumentException("Ran off end of other: " + i4 + ", " + i5 + ", " + abstractC1062i.size());
            }
            if (!(abstractC1062i instanceof j)) {
                return abstractC1062i.F(i4, i6).equals(F(0, i5));
            }
            j jVar = (j) abstractC1062i;
            byte[] bArr = this.f11036e;
            byte[] bArr2 = jVar.f11036e;
            int iR = R() + i5;
            int iR2 = R();
            int iR3 = jVar.R() + i4;
            while (iR2 < iR) {
                if (bArr[iR2] != bArr2[iR3]) {
                    return false;
                }
                iR2++;
                iR3++;
            }
            return true;
        }

        public int R() {
            return 0;
        }

        @Override // com.google.protobuf.AbstractC1062i
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AbstractC1062i) || size() != ((AbstractC1062i) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof j)) {
                return obj.equals(this);
            }
            j jVar = (j) obj;
            int iD = D();
            int iD2 = jVar.D();
            if (iD == 0 || iD2 == 0 || iD == iD2) {
                return Q(jVar, 0, size());
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractC1062i
        public final ByteBuffer f() {
            return ByteBuffer.wrap(this.f11036e, R(), size()).asReadOnlyBuffer();
        }

        @Override // com.google.protobuf.AbstractC1062i
        public byte k(int i4) {
            return this.f11036e[i4];
        }

        @Override // com.google.protobuf.AbstractC1062i
        public int size() {
            return this.f11036e.length;
        }

        @Override // com.google.protobuf.AbstractC1062i
        public void t(byte[] bArr, int i4, int i5, int i6) {
            System.arraycopy(this.f11036e, i4, bArr, i5, i6);
        }

        @Override // com.google.protobuf.AbstractC1062i
        public byte v(int i4) {
            return this.f11036e[i4];
        }

        @Override // com.google.protobuf.AbstractC1062i
        public final boolean x() {
            int iR = R();
            return B0.t(this.f11036e, iR, size() + iR);
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.i$k */
    public static final class k implements f {
        public k() {
        }

        @Override // com.google.protobuf.AbstractC1062i.f
        public byte[] a(byte[] bArr, int i4, int i5) {
            byte[] bArr2 = new byte[i5];
            System.arraycopy(bArr, i4, bArr2, 0, i5);
            return bArr2;
        }

        public /* synthetic */ k(a aVar) {
            this();
        }
    }

    static {
        a aVar = null;
        f11026c = AbstractC1056d.c() ? new k(aVar) : new d(aVar);
        f11027d = new b();
    }

    public static int H(byte b4) {
        return b4 & 255;
    }

    public static AbstractC1062i M(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            return new e0(byteBuffer);
        }
        return O(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
    }

    public static AbstractC1062i N(byte[] bArr) {
        return new j(bArr);
    }

    public static AbstractC1062i O(byte[] bArr, int i4, int i5) {
        return new e(bArr, i4, i5);
    }

    public static AbstractC1062i i(Iterator it, int i4) {
        if (i4 < 1) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", Integer.valueOf(i4)));
        }
        if (i4 == 1) {
            return (AbstractC1062i) it.next();
        }
        int i5 = i4 >>> 1;
        return i(it, i5).n(i(it, i4 - i5));
    }

    public static void l(int i4, int i5) {
        if (((i5 - (i4 + 1)) | i4) < 0) {
            if (i4 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i4);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i4 + ", " + i5);
        }
    }

    public static int m(int i4, int i5, int i6) {
        int i7 = i5 - i4;
        if ((i4 | i5 | i7 | (i6 - i5)) >= 0) {
            return i7;
        }
        if (i4 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i4 + " < 0");
        }
        if (i5 < i4) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i4 + ", " + i5);
        }
        throw new IndexOutOfBoundsException("End index: " + i5 + " >= " + i6);
    }

    public static AbstractC1062i o(Iterable iterable) {
        int size;
        if (iterable instanceof Collection) {
            size = ((Collection) iterable).size();
        } else {
            Iterator it = iterable.iterator();
            size = 0;
            while (it.hasNext()) {
                it.next();
                size++;
            }
        }
        return size == 0 ? f11025b : i(iterable.iterator(), size);
    }

    public static AbstractC1062i p(byte[] bArr) {
        return q(bArr, 0, bArr.length);
    }

    public static AbstractC1062i q(byte[] bArr, int i4, int i5) {
        m(i4, i4 + i5, bArr.length);
        return new j(f11026c.a(bArr, i4, i5));
    }

    public static AbstractC1062i r(String str) {
        return new j(str.getBytes(C.f10882b));
    }

    public static h z(int i4) {
        return new h(i4, null);
    }

    public abstract AbstractC1063j A();

    public abstract int B(int i4, int i5, int i6);

    public abstract int C(int i4, int i5, int i6);

    public final int D() {
        return this.f11028a;
    }

    public final AbstractC1062i E(int i4) {
        return F(i4, size());
    }

    public abstract AbstractC1062i F(int i4, int i5);

    public final byte[] G() {
        int size = size();
        if (size == 0) {
            return C.f10884d;
        }
        byte[] bArr = new byte[size];
        t(bArr, 0, 0, size);
        return bArr;
    }

    public final String I(Charset charset) {
        return size() == 0 ? "" : J(charset);
    }

    public abstract String J(Charset charset);

    public final String K() {
        return I(C.f10882b);
    }

    public final String L() {
        if (size() <= 50) {
            return t0.a(this);
        }
        return t0.a(F(0, 47)) + "...";
    }

    public abstract void P(AbstractC1061h abstractC1061h);

    public abstract boolean equals(Object obj);

    public abstract ByteBuffer f();

    public final int hashCode() {
        int iB = this.f11028a;
        if (iB == 0) {
            int size = size();
            iB = B(size, 0, size);
            if (iB == 0) {
                iB = 1;
            }
            this.f11028a = iB;
        }
        return iB;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public abstract byte k(int i4);

    public final AbstractC1062i n(AbstractC1062i abstractC1062i) {
        if (Integer.MAX_VALUE - size() >= abstractC1062i.size()) {
            return n0.T(this, abstractC1062i);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + size() + "+" + abstractC1062i.size());
    }

    public final void s(byte[] bArr, int i4, int i5, int i6) {
        m(i4, i4 + i6, size());
        m(i5, i5 + i6, bArr.length);
        if (i6 > 0) {
            t(bArr, i4, i5, i6);
        }
    }

    public abstract int size();

    public abstract void t(byte[] bArr, int i4, int i5, int i6);

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), L());
    }

    public abstract int u();

    public abstract byte v(int i4);

    public abstract boolean w();

    public abstract boolean x();

    /* JADX INFO: renamed from: y */
    public g iterator() {
        return new a();
    }
}
