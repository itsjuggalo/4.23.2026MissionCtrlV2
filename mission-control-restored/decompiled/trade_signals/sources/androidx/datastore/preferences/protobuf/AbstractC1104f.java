package androidx.datastore.preferences.protobuf;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1104f implements Iterable, Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbstractC1104f f11214b = new i(AbstractC1118u.f11430d);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final InterfaceC0180f f11215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Comparator f11216d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11217a = 0;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.f$a */
    public class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11218a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f11219b;

        public a() {
            this.f11219b = AbstractC1104f.this.size();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1104f.g
        public byte a() {
            int i8 = this.f11218a;
            if (i8 >= this.f11219b) {
                throw new NoSuchElementException();
            }
            this.f11218a = i8 + 1;
            return AbstractC1104f.this.H(i8);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f11218a < this.f11219b;
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.f$b */
    public class b implements Comparator {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(AbstractC1104f abstractC1104f, AbstractC1104f abstractC1104f2) {
            g gVarI = abstractC1104f.I();
            g gVarI2 = abstractC1104f2.I();
            while (gVarI.hasNext() && gVarI2.hasNext()) {
                int iCompareTo = Integer.valueOf(AbstractC1104f.N(gVarI.a())).compareTo(Integer.valueOf(AbstractC1104f.N(gVarI2.a())));
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
            }
            return Integer.valueOf(abstractC1104f.size()).compareTo(Integer.valueOf(abstractC1104f2.size()));
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
    public static final class d implements InterfaceC0180f {
        public d() {
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1104f.InterfaceC0180f
        public byte[] a(byte[] bArr, int i8, int i9) {
            return Arrays.copyOfRange(bArr, i8, i9 + i8);
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.f$e */
    public static final class e extends i {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f11221f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f11222g;

        public e(byte[] bArr, int i8, int i9) {
            super(bArr);
            AbstractC1104f.f(i8, i8 + i9, bArr.length);
            this.f11221f = i8;
            this.f11222g = i9;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1104f.i, androidx.datastore.preferences.protobuf.AbstractC1104f
        public void F(byte[] bArr, int i8, int i9, int i10) {
            System.arraycopy(this.f11223e, T() + i8, bArr, i9, i10);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1104f.i, androidx.datastore.preferences.protobuf.AbstractC1104f
        public byte H(int i8) {
            return this.f11223e[this.f11221f + i8];
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1104f.i
        public int T() {
            return this.f11221f;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1104f.i, androidx.datastore.preferences.protobuf.AbstractC1104f
        public byte d(int i8) {
            AbstractC1104f.e(i8, size());
            return this.f11223e[this.f11221f + i8];
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1104f.i, androidx.datastore.preferences.protobuf.AbstractC1104f
        public int size() {
            return this.f11222g;
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.f$f, reason: collision with other inner class name */
    public interface InterfaceC0180f {
        byte[] a(byte[] bArr, int i8, int i9);
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.f$g */
    public interface g extends Iterator {
        byte a();
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.f$h */
    public static abstract class h extends AbstractC1104f {
        public h() {
        }

        @Override // java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.I();
        }

        public /* synthetic */ h(a aVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.f$i */
    public static class i extends h {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final byte[] f11223e;

        public i(byte[] bArr) {
            super(null);
            bArr.getClass();
            this.f11223e = bArr;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1104f
        public void F(byte[] bArr, int i8, int i9, int i10) {
            System.arraycopy(this.f11223e, i8, bArr, i9, i10);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1104f
        public byte H(int i8) {
            return this.f11223e[i8];
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1104f
        public final int J(int i8, int i9, int i10) {
            return AbstractC1118u.g(i8, this.f11223e, T() + i9, i10);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1104f
        public final AbstractC1104f L(int i8, int i9) {
            int iF = AbstractC1104f.f(i8, i9, size());
            return iF == 0 ? AbstractC1104f.f11214b : new e(this.f11223e, T() + i8, iF);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1104f
        public final void R(AbstractC1103e abstractC1103e) {
            abstractC1103e.a(this.f11223e, T(), size());
        }

        public final boolean S(AbstractC1104f abstractC1104f, int i8, int i9) {
            if (i9 > abstractC1104f.size()) {
                throw new IllegalArgumentException("Length too large: " + i9 + size());
            }
            int i10 = i8 + i9;
            if (i10 > abstractC1104f.size()) {
                throw new IllegalArgumentException("Ran off end of other: " + i8 + ", " + i9 + ", " + abstractC1104f.size());
            }
            if (!(abstractC1104f instanceof i)) {
                return abstractC1104f.L(i8, i10).equals(L(0, i9));
            }
            i iVar = (i) abstractC1104f;
            byte[] bArr = this.f11223e;
            byte[] bArr2 = iVar.f11223e;
            int iT = T() + i9;
            int iT2 = T();
            int iT3 = iVar.T() + i8;
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

        @Override // androidx.datastore.preferences.protobuf.AbstractC1104f
        public byte d(int i8) {
            return this.f11223e[i8];
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1104f
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AbstractC1104f) || size() != ((AbstractC1104f) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof i)) {
                return obj.equals(this);
            }
            i iVar = (i) obj;
            int iK = K();
            int iK2 = iVar.K();
            if (iK == 0 || iK2 == 0 || iK == iK2) {
                return S(iVar, 0, size());
            }
            return false;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1104f
        public int size() {
            return this.f11223e.length;
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.f$j */
    public static final class j implements InterfaceC0180f {
        public j() {
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1104f.InterfaceC0180f
        public byte[] a(byte[] bArr, int i8, int i9) {
            byte[] bArr2 = new byte[i9];
            System.arraycopy(bArr, i8, bArr2, 0, i9);
            return bArr2;
        }

        public /* synthetic */ j(a aVar) {
            this();
        }
    }

    static {
        a aVar = null;
        f11215c = AbstractC1102d.c() ? new j(aVar) : new d(aVar);
        f11216d = new b();
    }

    public static AbstractC1104f C(String str) {
        return new i(str.getBytes(AbstractC1118u.f11428b));
    }

    public static int N(byte b8) {
        return b8 & 255;
    }

    public static AbstractC1104f P(byte[] bArr) {
        return new i(bArr);
    }

    public static AbstractC1104f Q(byte[] bArr, int i8, int i9) {
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

    public static AbstractC1104f h(byte[] bArr) {
        return n(bArr, 0, bArr.length);
    }

    public static AbstractC1104f n(byte[] bArr, int i8, int i9) {
        f(i8, i8 + i9, bArr.length);
        return new i(f11215c.a(bArr, i8, i9));
    }

    public abstract void F(byte[] bArr, int i8, int i9, int i10);

    public abstract byte H(int i8);

    public g I() {
        return new a();
    }

    public abstract int J(int i8, int i9, int i10);

    public final int K() {
        return this.f11217a;
    }

    public abstract AbstractC1104f L(int i8, int i9);

    public final byte[] M() {
        int size = size();
        if (size == 0) {
            return AbstractC1118u.f11430d;
        }
        byte[] bArr = new byte[size];
        F(bArr, 0, 0, size);
        return bArr;
    }

    public final String O() {
        if (size() <= 50) {
            return d0.a(this);
        }
        return d0.a(L(0, 47)) + "...";
    }

    public abstract void R(AbstractC1103e abstractC1103e);

    public abstract byte d(int i8);

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iJ = this.f11217a;
        if (iJ == 0) {
            int size = size();
            iJ = J(size, 0, size);
            if (iJ == 0) {
                iJ = 1;
            }
            this.f11217a = iJ;
        }
        return iJ;
    }

    public abstract int size();

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), O());
    }
}
