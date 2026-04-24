package androidx.datastore.preferences.protobuf;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0935f implements Iterable, Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbstractC0935f f7402b = new i(AbstractC0949u.f7618d);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final InterfaceC0123f f7403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Comparator f7404d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7405a = 0;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.f$a */
    public class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7406a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7407b;

        public a() {
            this.f7407b = AbstractC0935f.this.size();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0935f.g
        public byte a() {
            int i7 = this.f7406a;
            if (i7 >= this.f7407b) {
                throw new NoSuchElementException();
            }
            this.f7406a = i7 + 1;
            return AbstractC0935f.this.m(i7);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f7406a < this.f7407b;
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.f$b */
    public class b implements Comparator {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(AbstractC0935f abstractC0935f, AbstractC0935f abstractC0935f2) {
            g gVarN = abstractC0935f.n();
            g gVarN2 = abstractC0935f2.n();
            while (gVarN.hasNext() && gVarN2.hasNext()) {
                int iCompareTo = Integer.valueOf(AbstractC0935f.t(gVarN.a())).compareTo(Integer.valueOf(AbstractC0935f.t(gVarN2.a())));
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
            }
            return Integer.valueOf(abstractC0935f.size()).compareTo(Integer.valueOf(abstractC0935f2.size()));
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
    public static final class d implements InterfaceC0123f {
        public d() {
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0935f.InterfaceC0123f
        public byte[] a(byte[] bArr, int i7, int i8) {
            return Arrays.copyOfRange(bArr, i7, i8 + i7);
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.f$e */
    public static final class e extends i {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f7409f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f7410g;

        public e(byte[] bArr, int i7, int i8) {
            super(bArr);
            AbstractC0935f.g(i7, i7 + i8, bArr.length);
            this.f7409f = i7;
            this.f7410g = i8;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0935f.i
        public int B() {
            return this.f7409f;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0935f.i, androidx.datastore.preferences.protobuf.AbstractC0935f
        public byte b(int i7) {
            AbstractC0935f.c(i7, size());
            return this.f7411e[this.f7409f + i7];
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0935f.i, androidx.datastore.preferences.protobuf.AbstractC0935f
        public void l(byte[] bArr, int i7, int i8, int i9) {
            System.arraycopy(this.f7411e, B() + i7, bArr, i8, i9);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0935f.i, androidx.datastore.preferences.protobuf.AbstractC0935f
        public byte m(int i7) {
            return this.f7411e[this.f7409f + i7];
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0935f.i, androidx.datastore.preferences.protobuf.AbstractC0935f
        public int size() {
            return this.f7410g;
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.f$f, reason: collision with other inner class name */
    public interface InterfaceC0123f {
        byte[] a(byte[] bArr, int i7, int i8);
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.f$g */
    public interface g extends Iterator {
        byte a();
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.f$h */
    public static abstract class h extends AbstractC0935f {
        public /* synthetic */ h(a aVar) {
            this();
        }

        @Override // java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.n();
        }

        public h() {
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.f$i */
    public static class i extends h {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final byte[] f7411e;

        public i(byte[] bArr) {
            super(null);
            bArr.getClass();
            this.f7411e = bArr;
        }

        public final boolean A(AbstractC0935f abstractC0935f, int i7, int i8) {
            if (i8 > abstractC0935f.size()) {
                throw new IllegalArgumentException("Length too large: " + i8 + size());
            }
            int i9 = i7 + i8;
            if (i9 > abstractC0935f.size()) {
                throw new IllegalArgumentException("Ran off end of other: " + i7 + ", " + i8 + ", " + abstractC0935f.size());
            }
            if (!(abstractC0935f instanceof i)) {
                return abstractC0935f.r(i7, i9).equals(r(0, i8));
            }
            i iVar = (i) abstractC0935f;
            byte[] bArr = this.f7411e;
            byte[] bArr2 = iVar.f7411e;
            int iB = B() + i8;
            int iB2 = B();
            int iB3 = iVar.B() + i7;
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

        @Override // androidx.datastore.preferences.protobuf.AbstractC0935f
        public byte b(int i7) {
            return this.f7411e[i7];
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0935f
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AbstractC0935f) || size() != ((AbstractC0935f) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof i)) {
                return obj.equals(this);
            }
            i iVar = (i) obj;
            int iQ = q();
            int iQ2 = iVar.q();
            if (iQ == 0 || iQ2 == 0 || iQ == iQ2) {
                return A(iVar, 0, size());
            }
            return false;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0935f
        public void l(byte[] bArr, int i7, int i8, int i9) {
            System.arraycopy(this.f7411e, i7, bArr, i8, i9);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0935f
        public byte m(int i7) {
            return this.f7411e[i7];
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0935f
        public final int p(int i7, int i8, int i9) {
            return AbstractC0949u.g(i7, this.f7411e, B() + i8, i9);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0935f
        public final AbstractC0935f r(int i7, int i8) {
            int iG = AbstractC0935f.g(i7, i8, size());
            return iG == 0 ? AbstractC0935f.f7402b : new e(this.f7411e, B() + i7, iG);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0935f
        public int size() {
            return this.f7411e.length;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0935f
        public final void y(AbstractC0934e abstractC0934e) {
            abstractC0934e.a(this.f7411e, B(), size());
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.f$j */
    public static final class j implements InterfaceC0123f {
        public j() {
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0935f.InterfaceC0123f
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
        f7403c = AbstractC0933d.c() ? new j(aVar) : new d(aVar);
        f7404d = new b();
    }

    public static void c(int i7, int i8) {
        if (((i8 - (i7 + 1)) | i7) < 0) {
            if (i7 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i7);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i7 + ", " + i8);
        }
    }

    public static int g(int i7, int i8, int i9) {
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

    public static AbstractC0935f h(byte[] bArr) {
        return j(bArr, 0, bArr.length);
    }

    public static AbstractC0935f j(byte[] bArr, int i7, int i8) {
        g(i7, i7 + i8, bArr.length);
        return new i(f7403c.a(bArr, i7, i8));
    }

    public static AbstractC0935f k(String str) {
        return new i(str.getBytes(AbstractC0949u.f7616b));
    }

    public static int t(byte b7) {
        return b7 & 255;
    }

    public static AbstractC0935f w(byte[] bArr) {
        return new i(bArr);
    }

    public static AbstractC0935f x(byte[] bArr, int i7, int i8) {
        return new e(bArr, i7, i8);
    }

    public abstract byte b(int i7);

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iP = this.f7405a;
        if (iP == 0) {
            int size = size();
            iP = p(size, 0, size);
            if (iP == 0) {
                iP = 1;
            }
            this.f7405a = iP;
        }
        return iP;
    }

    public abstract void l(byte[] bArr, int i7, int i8, int i9);

    public abstract byte m(int i7);

    public g n() {
        return new a();
    }

    public abstract int p(int i7, int i8, int i9);

    public final int q() {
        return this.f7405a;
    }

    public abstract AbstractC0935f r(int i7, int i8);

    public final byte[] s() {
        int size = size();
        if (size == 0) {
            return AbstractC0949u.f7618d;
        }
        byte[] bArr = new byte[size];
        l(bArr, 0, 0, size);
        return bArr;
    }

    public abstract int size();

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), u());
    }

    public final String u() {
        if (size() <= 50) {
            return d0.a(this);
        }
        return d0.a(r(0, 47)) + "...";
    }

    public abstract void y(AbstractC0934e abstractC0934e);
}
