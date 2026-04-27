package androidx.datastore.preferences.protobuf;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0793f implements Iterable, Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbstractC0793f f6994b = new i(AbstractC0807u.f7210d);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final InterfaceC0101f f6995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Comparator f6996d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6997a = 0;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.f$a */
    public class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6998a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f6999b;

        public a() {
            this.f6999b = AbstractC0793f.this.size();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0793f.g
        public byte a() {
            int i4 = this.f6998a;
            if (i4 >= this.f6999b) {
                throw new NoSuchElementException();
            }
            this.f6998a = i4 + 1;
            return AbstractC0793f.this.p(i4);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6998a < this.f6999b;
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.f$b */
    public class b implements Comparator {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(AbstractC0793f abstractC0793f, AbstractC0793f abstractC0793f2) {
            g gVarQ = abstractC0793f.q();
            g gVarQ2 = abstractC0793f2.q();
            while (gVarQ.hasNext() && gVarQ2.hasNext()) {
                int iCompareTo = Integer.valueOf(AbstractC0793f.v(gVarQ.a())).compareTo(Integer.valueOf(AbstractC0793f.v(gVarQ2.a())));
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
            }
            return Integer.valueOf(abstractC0793f.size()).compareTo(Integer.valueOf(abstractC0793f2.size()));
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.f$c */
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

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.f$d */
    public static final class d implements InterfaceC0101f {
        public d() {
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0793f.InterfaceC0101f
        public byte[] a(byte[] bArr, int i4, int i5) {
            return Arrays.copyOfRange(bArr, i4, i5 + i4);
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.f$e */
    public static final class e extends i {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f7001f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f7002g;

        public e(byte[] bArr, int i4, int i5) {
            super(bArr);
            AbstractC0793f.k(i4, i4 + i5, bArr.length);
            this.f7001f = i4;
            this.f7002g = i5;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0793f.i
        public int B() {
            return this.f7001f;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0793f.i, androidx.datastore.preferences.protobuf.AbstractC0793f
        public byte f(int i4) {
            AbstractC0793f.i(i4, size());
            return this.f7003e[this.f7001f + i4];
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0793f.i, androidx.datastore.preferences.protobuf.AbstractC0793f
        public void o(byte[] bArr, int i4, int i5, int i6) {
            System.arraycopy(this.f7003e, B() + i4, bArr, i5, i6);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0793f.i, androidx.datastore.preferences.protobuf.AbstractC0793f
        public byte p(int i4) {
            return this.f7003e[this.f7001f + i4];
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0793f.i, androidx.datastore.preferences.protobuf.AbstractC0793f
        public int size() {
            return this.f7002g;
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.f$f, reason: collision with other inner class name */
    public interface InterfaceC0101f {
        byte[] a(byte[] bArr, int i4, int i5);
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.f$g */
    public interface g extends Iterator {
        byte a();
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.f$h */
    public static abstract class h extends AbstractC0793f {
        public /* synthetic */ h(a aVar) {
            this();
        }

        @Override // java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.q();
        }

        public h() {
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.f$i */
    public static class i extends h {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final byte[] f7003e;

        public i(byte[] bArr) {
            super(null);
            bArr.getClass();
            this.f7003e = bArr;
        }

        public final boolean A(AbstractC0793f abstractC0793f, int i4, int i5) {
            if (i5 > abstractC0793f.size()) {
                throw new IllegalArgumentException("Length too large: " + i5 + size());
            }
            int i6 = i4 + i5;
            if (i6 > abstractC0793f.size()) {
                throw new IllegalArgumentException("Ran off end of other: " + i4 + ", " + i5 + ", " + abstractC0793f.size());
            }
            if (!(abstractC0793f instanceof i)) {
                return abstractC0793f.t(i4, i6).equals(t(0, i5));
            }
            i iVar = (i) abstractC0793f;
            byte[] bArr = this.f7003e;
            byte[] bArr2 = iVar.f7003e;
            int iB = B() + i5;
            int iB2 = B();
            int iB3 = iVar.B() + i4;
            while (iB2 < iB) {
                if (bArr[iB2] != bArr2[iB3]) {
                    return false;
                }
                iB2++;
                iB3++;
            }
            return true;
        }

        public int B() {
            return 0;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0793f
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AbstractC0793f) || size() != ((AbstractC0793f) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof i)) {
                return obj.equals(this);
            }
            i iVar = (i) obj;
            int iS = s();
            int iS2 = iVar.s();
            if (iS == 0 || iS2 == 0 || iS == iS2) {
                return A(iVar, 0, size());
            }
            return false;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0793f
        public byte f(int i4) {
            return this.f7003e[i4];
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0793f
        public void o(byte[] bArr, int i4, int i5, int i6) {
            System.arraycopy(this.f7003e, i4, bArr, i5, i6);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0793f
        public byte p(int i4) {
            return this.f7003e[i4];
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0793f
        public final int r(int i4, int i5, int i6) {
            return AbstractC0807u.g(i4, this.f7003e, B() + i5, i6);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0793f
        public int size() {
            return this.f7003e.length;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0793f
        public final AbstractC0793f t(int i4, int i5) {
            int iK = AbstractC0793f.k(i4, i5, size());
            return iK == 0 ? AbstractC0793f.f6994b : new e(this.f7003e, B() + i4, iK);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0793f
        public final void z(AbstractC0792e abstractC0792e) {
            abstractC0792e.a(this.f7003e, B(), size());
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.f$j */
    public static final class j implements InterfaceC0101f {
        public j() {
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0793f.InterfaceC0101f
        public byte[] a(byte[] bArr, int i4, int i5) {
            byte[] bArr2 = new byte[i5];
            System.arraycopy(bArr, i4, bArr2, 0, i5);
            return bArr2;
        }

        public /* synthetic */ j(a aVar) {
            this();
        }
    }

    static {
        a aVar = null;
        f6995c = AbstractC0791d.c() ? new j(aVar) : new d(aVar);
        f6996d = new b();
    }

    public static void i(int i4, int i5) {
        if (((i5 - (i4 + 1)) | i4) < 0) {
            if (i4 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i4);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i4 + ", " + i5);
        }
    }

    public static int k(int i4, int i5, int i6) {
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

    public static AbstractC0793f l(byte[] bArr) {
        return m(bArr, 0, bArr.length);
    }

    public static AbstractC0793f m(byte[] bArr, int i4, int i5) {
        k(i4, i4 + i5, bArr.length);
        return new i(f6995c.a(bArr, i4, i5));
    }

    public static AbstractC0793f n(String str) {
        return new i(str.getBytes(AbstractC0807u.f7208b));
    }

    public static int v(byte b4) {
        return b4 & 255;
    }

    public static AbstractC0793f x(byte[] bArr) {
        return new i(bArr);
    }

    public static AbstractC0793f y(byte[] bArr, int i4, int i5) {
        return new e(bArr, i4, i5);
    }

    public abstract boolean equals(Object obj);

    public abstract byte f(int i4);

    public final int hashCode() {
        int iR = this.f6997a;
        if (iR == 0) {
            int size = size();
            iR = r(size, 0, size);
            if (iR == 0) {
                iR = 1;
            }
            this.f6997a = iR;
        }
        return iR;
    }

    public abstract void o(byte[] bArr, int i4, int i5, int i6);

    public abstract byte p(int i4);

    public g q() {
        return new a();
    }

    public abstract int r(int i4, int i5, int i6);

    public final int s() {
        return this.f6997a;
    }

    public abstract int size();

    public abstract AbstractC0793f t(int i4, int i5);

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), w());
    }

    public final byte[] u() {
        int size = size();
        if (size == 0) {
            return AbstractC0807u.f7210d;
        }
        byte[] bArr = new byte[size];
        o(bArr, 0, 0, size);
        return bArr;
    }

    public final String w() {
        if (size() <= 50) {
            return d0.a(this);
        }
        return d0.a(t(0, 47)) + "...";
    }

    public abstract void z(AbstractC0792e abstractC0792e);
}
