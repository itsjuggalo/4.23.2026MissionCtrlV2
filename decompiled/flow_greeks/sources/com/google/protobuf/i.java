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

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i implements Iterable, Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f6998b = new j(c0.f6946d);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f6999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Comparator f7000d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7001a = 0;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7002a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7003b;

        public a() {
            this.f7003b = i.this.size();
        }

        @Override // com.google.protobuf.i.g
        public byte a() {
            int i10 = this.f7002a;
            if (i10 >= this.f7003b) {
                throw new NoSuchElementException();
            }
            this.f7002a = i10 + 1;
            return i.this.A(i10);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f7002a < this.f7003b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Comparator {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(i iVar, i iVar2) {
            g gVarL = iVar.iterator();
            g gVarL2 = iVar2.iterator();
            while (gVarL.hasNext() && gVarL2.hasNext()) {
                int iCompareTo = Integer.valueOf(i.Z(gVarL.a())).compareTo(Integer.valueOf(i.Z(gVarL2.a())));
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
            }
            return Integer.valueOf(iVar.size()).compareTo(Integer.valueOf(iVar2.size()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d implements f {
        public d() {
        }

        @Override // com.google.protobuf.i.f
        public byte[] a(byte[] bArr, int i10, int i11) {
            return Arrays.copyOfRange(bArr, i10, i11 + i10);
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e extends j {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f7005f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f7006g;

        public e(byte[] bArr, int i10, int i11) {
            super(bArr);
            i.g(i10, i10 + i11, bArr.length);
            this.f7005f = i10;
            this.f7006g = i11;
        }

        @Override // com.google.protobuf.i.j, com.google.protobuf.i
        public byte A(int i10) {
            return this.f7009e[this.f7005f + i10];
        }

        @Override // com.google.protobuf.i.j, com.google.protobuf.i
        public byte e(int i10) {
            i.f(i10, size());
            return this.f7009e[this.f7005f + i10];
        }

        @Override // com.google.protobuf.i.j
        public int j0() {
            return this.f7005f;
        }

        @Override // com.google.protobuf.i.j, com.google.protobuf.i
        public int size() {
            return this.f7006g;
        }

        @Override // com.google.protobuf.i.j, com.google.protobuf.i
        public void w(byte[] bArr, int i10, int i11, int i12) {
            System.arraycopy(this.f7009e, j0() + i10, bArr, i11, i12);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface f {
        byte[] a(byte[] bArr, int i10, int i11);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface g extends Iterator {
        byte a();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l f7007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f7008b;

        public /* synthetic */ h(int i10, a aVar) {
            this(i10);
        }

        public i a() {
            this.f7007a.d();
            return new j(this.f7008b);
        }

        public l b() {
            return this.f7007a;
        }

        public h(int i10) {
            byte[] bArr = new byte[i10];
            this.f7008b = bArr;
            this.f7007a = l.b0(bArr);
        }
    }

    /* JADX INFO: renamed from: com.google.protobuf.i$i, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class AbstractC0115i extends i {
        @Override // com.google.protobuf.i
        public final boolean G() {
            return true;
        }

        public abstract boolean i0(i iVar, int i10, int i11);

        @Override // java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.protobuf.i
        public final int y() {
            return 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class j extends AbstractC0115i {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final byte[] f7009e;

        public j(byte[] bArr) {
            bArr.getClass();
            this.f7009e = bArr;
        }

        @Override // com.google.protobuf.i
        public byte A(int i10) {
            return this.f7009e[i10];
        }

        @Override // com.google.protobuf.i
        public final boolean K() {
            int iJ0 = j0();
            return z1.t(this.f7009e, iJ0, size() + iJ0);
        }

        @Override // com.google.protobuf.i
        public final com.google.protobuf.j S() {
            return com.google.protobuf.j.m(this.f7009e, j0(), size(), true);
        }

        @Override // com.google.protobuf.i
        public final int T(int i10, int i11, int i12) {
            return c0.h(i10, this.f7009e, j0() + i11, i12);
        }

        @Override // com.google.protobuf.i
        public final int U(int i10, int i11, int i12) {
            int iJ0 = j0() + i11;
            return z1.v(i10, this.f7009e, iJ0, i12 + iJ0);
        }

        @Override // com.google.protobuf.i
        public final i X(int i10, int i11) {
            int iG = i.g(i10, i11, size());
            return iG == 0 ? i.f6998b : new e(this.f7009e, j0() + i10, iG);
        }

        @Override // com.google.protobuf.i
        public final String b0(Charset charset) {
            return new String(this.f7009e, j0(), size(), charset);
        }

        @Override // com.google.protobuf.i
        public final ByteBuffer c() {
            return ByteBuffer.wrap(this.f7009e, j0(), size()).asReadOnlyBuffer();
        }

        @Override // com.google.protobuf.i
        public byte e(int i10) {
            return this.f7009e[i10];
        }

        @Override // com.google.protobuf.i
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof i) || size() != ((i) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof j)) {
                return obj.equals(this);
            }
            j jVar = (j) obj;
            int iV = V();
            int iV2 = jVar.V();
            if (iV == 0 || iV2 == 0 || iV == iV2) {
                return i0(jVar, 0, size());
            }
            return false;
        }

        @Override // com.google.protobuf.i
        public final void h0(com.google.protobuf.h hVar) {
            hVar.b(this.f7009e, j0(), size());
        }

        @Override // com.google.protobuf.i.AbstractC0115i
        public final boolean i0(i iVar, int i10, int i11) {
            if (i11 > iVar.size()) {
                throw new IllegalArgumentException("Length too large: " + i11 + size());
            }
            int i12 = i10 + i11;
            if (i12 > iVar.size()) {
                throw new IllegalArgumentException("Ran off end of other: " + i10 + ", " + i11 + ", " + iVar.size());
            }
            if (!(iVar instanceof j)) {
                return iVar.X(i10, i12).equals(X(0, i11));
            }
            j jVar = (j) iVar;
            byte[] bArr = this.f7009e;
            byte[] bArr2 = jVar.f7009e;
            int iJ0 = j0() + i11;
            int iJ02 = j0();
            int iJ03 = jVar.j0() + i10;
            while (iJ02 < iJ0) {
                if (bArr[iJ02] != bArr2[iJ03]) {
                    return false;
                }
                iJ02++;
                iJ03++;
            }
            return true;
        }

        public int j0() {
            return 0;
        }

        @Override // com.google.protobuf.i
        public int size() {
            return this.f7009e.length;
        }

        @Override // com.google.protobuf.i
        public void w(byte[] bArr, int i10, int i11, int i12) {
            System.arraycopy(this.f7009e, i10, bArr, i11, i12);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class k implements f {
        public k() {
        }

        @Override // com.google.protobuf.i.f
        public byte[] a(byte[] bArr, int i10, int i11) {
            byte[] bArr2 = new byte[i11];
            System.arraycopy(bArr, i10, bArr2, 0, i11);
            return bArr2;
        }

        public /* synthetic */ k(a aVar) {
            this();
        }
    }

    static {
        a aVar = null;
        f6999c = com.google.protobuf.d.c() ? new k(aVar) : new d(aVar);
        f7000d = new b();
    }

    public static h R(int i10) {
        return new h(i10, null);
    }

    public static int Z(byte b10) {
        return b10 & 255;
    }

    public static i d(Iterator it, int i10) {
        if (i10 < 1) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", Integer.valueOf(i10)));
        }
        if (i10 == 1) {
            return (i) it.next();
        }
        int i11 = i10 >>> 1;
        return d(it, i11).p(d(it, i10 - i11));
    }

    public static i e0(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            return new c1(byteBuffer);
        }
        return g0(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
    }

    public static void f(int i10, int i11) {
        if (((i11 - (i10 + 1)) | i10) < 0) {
            if (i10 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i10);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i10 + ", " + i11);
        }
    }

    public static i f0(byte[] bArr) {
        return new j(bArr);
    }

    public static int g(int i10, int i11, int i12) {
        int i13 = i11 - i10;
        if ((i10 | i11 | i13 | (i12 - i11)) >= 0) {
            return i13;
        }
        if (i10 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i10 + " < 0");
        }
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i10 + ", " + i11);
        }
        throw new IndexOutOfBoundsException("End index: " + i11 + " >= " + i12);
    }

    public static i g0(byte[] bArr, int i10, int i11) {
        return new e(bArr, i10, i11);
    }

    public static i q(Iterable iterable) {
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
        return size == 0 ? f6998b : d(iterable.iterator(), size);
    }

    public static i r(byte[] bArr) {
        return s(bArr, 0, bArr.length);
    }

    public static i s(byte[] bArr, int i10, int i11) {
        g(i10, i10 + i11, bArr.length);
        return new j(f6999c.a(bArr, i10, i11));
    }

    public static i u(String str) {
        return new j(str.getBytes(c0.f6944b));
    }

    public abstract byte A(int i10);

    public abstract boolean G();

    public abstract boolean K();

    /* JADX INFO: renamed from: L */
    public g iterator() {
        return new a();
    }

    public abstract com.google.protobuf.j S();

    public abstract int T(int i10, int i11, int i12);

    public abstract int U(int i10, int i11, int i12);

    public final int V() {
        return this.f7001a;
    }

    public final i W(int i10) {
        return X(i10, size());
    }

    public abstract i X(int i10, int i11);

    public final byte[] Y() {
        int size = size();
        if (size == 0) {
            return c0.f6946d;
        }
        byte[] bArr = new byte[size];
        w(bArr, 0, 0, size);
        return bArr;
    }

    public final String a0(Charset charset) {
        return size() == 0 ? "" : b0(charset);
    }

    public abstract String b0(Charset charset);

    public abstract ByteBuffer c();

    public final String c0() {
        return a0(c0.f6944b);
    }

    public final String d0() {
        if (size() <= 50) {
            return r1.a(this);
        }
        return r1.a(X(0, 47)) + "...";
    }

    public abstract byte e(int i10);

    public abstract boolean equals(Object obj);

    public abstract void h0(com.google.protobuf.h hVar);

    public final int hashCode() {
        int iT = this.f7001a;
        if (iT == 0) {
            int size = size();
            iT = T(size, 0, size);
            if (iT == 0) {
                iT = 1;
            }
            this.f7001a = iT;
        }
        return iT;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final i p(i iVar) {
        if (a.e.API_PRIORITY_OTHER - size() >= iVar.size()) {
            return l1.l0(this, iVar);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + size() + "+" + iVar.size());
    }

    public abstract int size();

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), d0());
    }

    public final void v(byte[] bArr, int i10, int i11, int i12) {
        g(i10, i10 + i12, size());
        g(i11, i11 + i12, bArr.length);
        if (i12 > 0) {
            w(bArr, i10, i11, i12);
        }
    }

    public abstract void w(byte[] bArr, int i10, int i11, int i12);

    public abstract int y();
}
