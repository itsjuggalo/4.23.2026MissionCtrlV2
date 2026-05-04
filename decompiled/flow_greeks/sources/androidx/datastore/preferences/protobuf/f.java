package androidx.datastore.preferences.protobuf;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f implements Iterable, Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f1682b = new i(u.f1914d);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final InterfaceC0021f f1683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Comparator f1684d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1685a = 0;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1686a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1687b;

        public a() {
            this.f1687b = f.this.size();
        }

        @Override // androidx.datastore.preferences.protobuf.f.g
        public byte a() {
            int i10 = this.f1686a;
            if (i10 >= this.f1687b) {
                throw new NoSuchElementException();
            }
            this.f1686a = i10 + 1;
            return f.this.r(i10);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1686a < this.f1687b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Comparator {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(f fVar, f fVar2) {
            g gVarS = fVar.s();
            g gVarS2 = fVar2.s();
            while (gVarS.hasNext() && gVarS2.hasNext()) {
                int iCompareTo = Integer.valueOf(f.A(gVarS.a())).compareTo(Integer.valueOf(f.A(gVarS2.a())));
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
            }
            return Integer.valueOf(fVar.size()).compareTo(Integer.valueOf(fVar2.size()));
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
    public static final class d implements InterfaceC0021f {
        public d() {
        }

        @Override // androidx.datastore.preferences.protobuf.f.InterfaceC0021f
        public byte[] a(byte[] bArr, int i10, int i11) {
            return Arrays.copyOfRange(bArr, i10, i11 + i10);
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e extends i {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f1689f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f1690g;

        public e(byte[] bArr, int i10, int i11) {
            super(bArr);
            f.e(i10, i10 + i11, bArr.length);
            this.f1689f = i10;
            this.f1690g = i11;
        }

        @Override // androidx.datastore.preferences.protobuf.f.i
        public int T() {
            return this.f1689f;
        }

        @Override // androidx.datastore.preferences.protobuf.f.i, androidx.datastore.preferences.protobuf.f
        public byte c(int i10) {
            f.d(i10, size());
            return this.f1691e[this.f1689f + i10];
        }

        @Override // androidx.datastore.preferences.protobuf.f.i, androidx.datastore.preferences.protobuf.f
        public void q(byte[] bArr, int i10, int i11, int i12) {
            System.arraycopy(this.f1691e, T() + i10, bArr, i11, i12);
        }

        @Override // androidx.datastore.preferences.protobuf.f.i, androidx.datastore.preferences.protobuf.f
        public byte r(int i10) {
            return this.f1691e[this.f1689f + i10];
        }

        @Override // androidx.datastore.preferences.protobuf.f.i, androidx.datastore.preferences.protobuf.f
        public int size() {
            return this.f1690g;
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface InterfaceC0021f {
        byte[] a(byte[] bArr, int i10, int i11);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface g extends Iterator {
        byte a();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class h extends f {
        public /* synthetic */ h(a aVar) {
            this();
        }

        @Override // java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.s();
        }

        public h() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class i extends h {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final byte[] f1691e;

        public i(byte[] bArr) {
            super(null);
            bArr.getClass();
            this.f1691e = bArr;
        }

        @Override // androidx.datastore.preferences.protobuf.f
        public final void R(androidx.datastore.preferences.protobuf.e eVar) {
            eVar.a(this.f1691e, T(), size());
        }

        public final boolean S(f fVar, int i10, int i11) {
            if (i11 > fVar.size()) {
                throw new IllegalArgumentException("Length too large: " + i11 + size());
            }
            int i12 = i10 + i11;
            if (i12 > fVar.size()) {
                throw new IllegalArgumentException("Ran off end of other: " + i10 + ", " + i11 + ", " + fVar.size());
            }
            if (!(fVar instanceof i)) {
                return fVar.w(i10, i12).equals(w(0, i11));
            }
            i iVar = (i) fVar;
            byte[] bArr = this.f1691e;
            byte[] bArr2 = iVar.f1691e;
            int iT = T() + i11;
            int iT2 = T();
            int iT3 = iVar.T() + i10;
            while (iT2 < iT) {
                if (bArr[iT2] != bArr2[iT3]) {
                    return false;
                }
                iT2++;
                iT3++;
            }
            return true;
        }

        public int T() {
            return 0;
        }

        @Override // androidx.datastore.preferences.protobuf.f
        public byte c(int i10) {
            return this.f1691e[i10];
        }

        @Override // androidx.datastore.preferences.protobuf.f
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof f) || size() != ((f) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof i)) {
                return obj.equals(this);
            }
            i iVar = (i) obj;
            int iV = v();
            int iV2 = iVar.v();
            if (iV == 0 || iV2 == 0 || iV == iV2) {
                return S(iVar, 0, size());
            }
            return false;
        }

        @Override // androidx.datastore.preferences.protobuf.f
        public void q(byte[] bArr, int i10, int i11, int i12) {
            System.arraycopy(this.f1691e, i10, bArr, i11, i12);
        }

        @Override // androidx.datastore.preferences.protobuf.f
        public byte r(int i10) {
            return this.f1691e[i10];
        }

        @Override // androidx.datastore.preferences.protobuf.f
        public int size() {
            return this.f1691e.length;
        }

        @Override // androidx.datastore.preferences.protobuf.f
        public final int u(int i10, int i11, int i12) {
            return u.g(i10, this.f1691e, T() + i11, i12);
        }

        @Override // androidx.datastore.preferences.protobuf.f
        public final f w(int i10, int i11) {
            int iE = f.e(i10, i11, size());
            return iE == 0 ? f.f1682b : new e(this.f1691e, T() + i10, iE);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class j implements InterfaceC0021f {
        public j() {
        }

        @Override // androidx.datastore.preferences.protobuf.f.InterfaceC0021f
        public byte[] a(byte[] bArr, int i10, int i11) {
            byte[] bArr2 = new byte[i11];
            System.arraycopy(bArr, i10, bArr2, 0, i11);
            return bArr2;
        }

        public /* synthetic */ j(a aVar) {
            this();
        }
    }

    static {
        a aVar = null;
        f1683c = androidx.datastore.preferences.protobuf.d.c() ? new j(aVar) : new d(aVar);
        f1684d = new b();
    }

    public static int A(byte b10) {
        return b10 & 255;
    }

    public static f K(byte[] bArr) {
        return new i(bArr);
    }

    public static f L(byte[] bArr, int i10, int i11) {
        return new e(bArr, i10, i11);
    }

    public static void d(int i10, int i11) {
        if (((i11 - (i10 + 1)) | i10) < 0) {
            if (i10 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i10);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i10 + ", " + i11);
        }
    }

    public static int e(int i10, int i11, int i12) {
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

    public static f f(byte[] bArr) {
        return g(bArr, 0, bArr.length);
    }

    public static f g(byte[] bArr, int i10, int i11) {
        e(i10, i10 + i11, bArr.length);
        return new i(f1683c.a(bArr, i10, i11));
    }

    public static f p(String str) {
        return new i(str.getBytes(u.f1912b));
    }

    public final String G() {
        if (size() <= 50) {
            return c1.a(this);
        }
        return c1.a(w(0, 47)) + "...";
    }

    public abstract void R(androidx.datastore.preferences.protobuf.e eVar);

    public abstract byte c(int i10);

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iU = this.f1685a;
        if (iU == 0) {
            int size = size();
            iU = u(size, 0, size);
            if (iU == 0) {
                iU = 1;
            }
            this.f1685a = iU;
        }
        return iU;
    }

    public abstract void q(byte[] bArr, int i10, int i11, int i12);

    public abstract byte r(int i10);

    public g s() {
        return new a();
    }

    public abstract int size();

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), G());
    }

    public abstract int u(int i10, int i11, int i12);

    public final int v() {
        return this.f1685a;
    }

    public abstract f w(int i10, int i11);

    public final byte[] y() {
        int size = size();
        if (size == 0) {
            return u.f1914d;
        }
        byte[] bArr = new byte[size];
        q(bArr, 0, 0, size);
        return bArr;
    }
}
