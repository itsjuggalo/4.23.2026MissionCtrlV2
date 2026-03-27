package com.google.protobuf;

import com.google.android.gms.common.api.a;
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
public abstract class AbstractC1240i implements Iterable, Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbstractC1240i f12650b = new C0201i(C.f12548d);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f12651c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Comparator f12652d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12653a = 0;

    /* JADX INFO: renamed from: com.google.protobuf.i$a */
    public class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12654a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f12655b;

        public a() {
            this.f12655b = AbstractC1240i.this.size();
        }

        @Override // com.google.protobuf.AbstractC1240i.g
        public byte a() {
            int i7 = this.f12654a;
            if (i7 >= this.f12655b) {
                throw new NoSuchElementException();
            }
            this.f12654a = i7 + 1;
            return AbstractC1240i.this.t(i7);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12654a < this.f12655b;
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.i$b */
    public class b implements Comparator {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(AbstractC1240i abstractC1240i, AbstractC1240i abstractC1240i2) {
            g gVarX = abstractC1240i.iterator();
            g gVarX2 = abstractC1240i2.iterator();
            while (gVarX.hasNext() && gVarX2.hasNext()) {
                int iCompareTo = Integer.valueOf(AbstractC1240i.G(gVarX.a())).compareTo(Integer.valueOf(AbstractC1240i.G(gVarX2.a())));
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
            }
            return Integer.valueOf(abstractC1240i.size()).compareTo(Integer.valueOf(abstractC1240i2.size()));
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

        @Override // com.google.protobuf.AbstractC1240i.f
        public byte[] a(byte[] bArr, int i7, int i8) {
            return Arrays.copyOfRange(bArr, i7, i8 + i7);
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.i$e */
    public static final class e extends C0201i {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f12657f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f12658g;

        public e(byte[] bArr, int i7, int i8) {
            super(bArr);
            AbstractC1240i.j(i7, i7 + i8, bArr.length);
            this.f12657f = i7;
            this.f12658g = i8;
        }

        @Override // com.google.protobuf.AbstractC1240i.C0201i
        public int Q() {
            return this.f12657f;
        }

        @Override // com.google.protobuf.AbstractC1240i.C0201i, com.google.protobuf.AbstractC1240i
        public byte g(int i7) {
            AbstractC1240i.h(i7, size());
            return this.f12659e[this.f12657f + i7];
        }

        @Override // com.google.protobuf.AbstractC1240i.C0201i, com.google.protobuf.AbstractC1240i
        public void r(byte[] bArr, int i7, int i8, int i9) {
            System.arraycopy(this.f12659e, Q() + i7, bArr, i8, i9);
        }

        @Override // com.google.protobuf.AbstractC1240i.C0201i, com.google.protobuf.AbstractC1240i
        public int size() {
            return this.f12658g;
        }

        @Override // com.google.protobuf.AbstractC1240i.C0201i, com.google.protobuf.AbstractC1240i
        public byte t(int i7) {
            return this.f12659e[this.f12657f + i7];
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.i$f */
    public interface f {
        byte[] a(byte[] bArr, int i7, int i8);
    }

    /* JADX INFO: renamed from: com.google.protobuf.i$g */
    public interface g extends Iterator {
        byte a();
    }

    /* JADX INFO: renamed from: com.google.protobuf.i$h */
    public static abstract class h extends AbstractC1240i {
        public abstract boolean P(AbstractC1240i abstractC1240i, int i7, int i8);

        @Override // java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.protobuf.AbstractC1240i
        public final int s() {
            return 0;
        }

        @Override // com.google.protobuf.AbstractC1240i
        public final boolean u() {
            return true;
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.i$i, reason: collision with other inner class name */
    public static class C0201i extends h {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final byte[] f12659e;

        public C0201i(byte[] bArr) {
            bArr.getClass();
            this.f12659e = bArr;
        }

        @Override // com.google.protobuf.AbstractC1240i
        public final int A(int i7, int i8, int i9) {
            return C.h(i7, this.f12659e, Q() + i8, i9);
        }

        @Override // com.google.protobuf.AbstractC1240i
        public final int B(int i7, int i8, int i9) {
            int iQ = Q() + i8;
            return A0.v(i7, this.f12659e, iQ, i9 + iQ);
        }

        @Override // com.google.protobuf.AbstractC1240i
        public final AbstractC1240i E(int i7, int i8) {
            int iJ = AbstractC1240i.j(i7, i8, size());
            return iJ == 0 ? AbstractC1240i.f12650b : new e(this.f12659e, Q() + i7, iJ);
        }

        @Override // com.google.protobuf.AbstractC1240i
        public final String I(Charset charset) {
            return new String(this.f12659e, Q(), size(), charset);
        }

        @Override // com.google.protobuf.AbstractC1240i
        public final void O(AbstractC1239h abstractC1239h) {
            abstractC1239h.b(this.f12659e, Q(), size());
        }

        @Override // com.google.protobuf.AbstractC1240i.h
        public final boolean P(AbstractC1240i abstractC1240i, int i7, int i8) {
            if (i8 > abstractC1240i.size()) {
                throw new IllegalArgumentException("Length too large: " + i8 + size());
            }
            int i9 = i7 + i8;
            if (i9 > abstractC1240i.size()) {
                throw new IllegalArgumentException("Ran off end of other: " + i7 + ", " + i8 + ", " + abstractC1240i.size());
            }
            if (!(abstractC1240i instanceof C0201i)) {
                return abstractC1240i.E(i7, i9).equals(E(0, i8));
            }
            C0201i c0201i = (C0201i) abstractC1240i;
            byte[] bArr = this.f12659e;
            byte[] bArr2 = c0201i.f12659e;
            int iQ = Q() + i8;
            int iQ2 = Q();
            int iQ3 = c0201i.Q() + i7;
            while (iQ2 < iQ) {
                if (bArr[iQ2] != bArr2[iQ3]) {
                    return false;
                }
                iQ2++;
                iQ3++;
            }
            return true;
        }

        public int Q() {
            return 0;
        }

        @Override // com.google.protobuf.AbstractC1240i
        public final ByteBuffer b() {
            return ByteBuffer.wrap(this.f12659e, Q(), size()).asReadOnlyBuffer();
        }

        @Override // com.google.protobuf.AbstractC1240i
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AbstractC1240i) || size() != ((AbstractC1240i) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof C0201i)) {
                return obj.equals(this);
            }
            C0201i c0201i = (C0201i) obj;
            int iC = C();
            int iC2 = c0201i.C();
            if (iC == 0 || iC2 == 0 || iC == iC2) {
                return P(c0201i, 0, size());
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractC1240i
        public byte g(int i7) {
            return this.f12659e[i7];
        }

        @Override // com.google.protobuf.AbstractC1240i
        public void r(byte[] bArr, int i7, int i8, int i9) {
            System.arraycopy(this.f12659e, i7, bArr, i8, i9);
        }

        @Override // com.google.protobuf.AbstractC1240i
        public int size() {
            return this.f12659e.length;
        }

        @Override // com.google.protobuf.AbstractC1240i
        public byte t(int i7) {
            return this.f12659e[i7];
        }

        @Override // com.google.protobuf.AbstractC1240i
        public final boolean w() {
            int iQ = Q();
            return A0.t(this.f12659e, iQ, size() + iQ);
        }

        @Override // com.google.protobuf.AbstractC1240i
        public final AbstractC1241j y() {
            return AbstractC1241j.m(this.f12659e, Q(), size(), true);
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.i$j */
    public static final class j implements f {
        public j() {
        }

        @Override // com.google.protobuf.AbstractC1240i.f
        public byte[] a(byte[] bArr, int i7, int i8) {
            byte[] bArr2 = new byte[i8];
            System.arraycopy(bArr, i7, bArr2, 0, i8);
            return bArr2;
        }

        public /* synthetic */ j(a aVar) {
            this();
        }
    }

    static {
        a aVar = null;
        f12651c = AbstractC1235d.c() ? new j(aVar) : new d(aVar);
        f12652d = new b();
    }

    public static int G(byte b7) {
        return b7 & 255;
    }

    public static AbstractC1240i L(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            return new d0(byteBuffer);
        }
        return N(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
    }

    public static AbstractC1240i M(byte[] bArr) {
        return new C0201i(bArr);
    }

    public static AbstractC1240i N(byte[] bArr, int i7, int i8) {
        return new e(bArr, i7, i8);
    }

    public static AbstractC1240i c(Iterator it, int i7) {
        if (i7 < 1) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", Integer.valueOf(i7)));
        }
        if (i7 == 1) {
            return (AbstractC1240i) it.next();
        }
        int i8 = i7 >>> 1;
        return c(it, i8).k(c(it, i7 - i8));
    }

    public static void h(int i7, int i8) {
        if (((i8 - (i7 + 1)) | i7) < 0) {
            if (i7 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i7);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i7 + ", " + i8);
        }
    }

    public static int j(int i7, int i8, int i9) {
        int i10 = i8 - i7;
        if ((i7 | i8 | i10 | (i9 - i8)) >= 0) {
            return i10;
        }
        if (i7 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i7 + " < 0");
        }
        if (i8 < i7) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i7 + ", " + i8);
        }
        throw new IndexOutOfBoundsException("End index: " + i8 + " >= " + i9);
    }

    public static AbstractC1240i l(Iterable iterable) {
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
        return size == 0 ? f12650b : c(iterable.iterator(), size);
    }

    public static AbstractC1240i m(byte[] bArr) {
        return n(bArr, 0, bArr.length);
    }

    public static AbstractC1240i n(byte[] bArr, int i7, int i8) {
        j(i7, i7 + i8, bArr.length);
        return new C0201i(f12651c.a(bArr, i7, i8));
    }

    public static AbstractC1240i p(String str) {
        return new C0201i(str.getBytes(C.f12546b));
    }

    public abstract int A(int i7, int i8, int i9);

    public abstract int B(int i7, int i8, int i9);

    public final int C() {
        return this.f12653a;
    }

    public final AbstractC1240i D(int i7) {
        return E(i7, size());
    }

    public abstract AbstractC1240i E(int i7, int i8);

    public final byte[] F() {
        int size = size();
        if (size == 0) {
            return C.f12548d;
        }
        byte[] bArr = new byte[size];
        r(bArr, 0, 0, size);
        return bArr;
    }

    public final String H(Charset charset) {
        return size() == 0 ? "" : I(charset);
    }

    public abstract String I(Charset charset);

    public final String J() {
        return H(C.f12546b);
    }

    public final String K() {
        if (size() <= 50) {
            return s0.a(this);
        }
        return s0.a(E(0, 47)) + "...";
    }

    public abstract void O(AbstractC1239h abstractC1239h);

    public abstract ByteBuffer b();

    public abstract boolean equals(Object obj);

    public abstract byte g(int i7);

    public final int hashCode() {
        int iA = this.f12653a;
        if (iA == 0) {
            int size = size();
            iA = A(size, 0, size);
            if (iA == 0) {
                iA = 1;
            }
            this.f12653a = iA;
        }
        return iA;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final AbstractC1240i k(AbstractC1240i abstractC1240i) {
        if (a.e.API_PRIORITY_OTHER - size() >= abstractC1240i.size()) {
            return m0.S(this, abstractC1240i);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + size() + "+" + abstractC1240i.size());
    }

    public final void q(byte[] bArr, int i7, int i8, int i9) {
        j(i7, i7 + i9, size());
        j(i8, i8 + i9, bArr.length);
        if (i9 > 0) {
            r(bArr, i7, i8, i9);
        }
    }

    public abstract void r(byte[] bArr, int i7, int i8, int i9);

    public abstract int s();

    public abstract int size();

    public abstract byte t(int i7);

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), K());
    }

    public abstract boolean u();

    public abstract boolean w();

    /* JADX INFO: renamed from: x */
    public g iterator() {
        return new a();
    }

    public abstract AbstractC1241j y();
}
