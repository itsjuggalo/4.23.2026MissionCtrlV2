package W2;

import X2.AbstractC0765l;
import j3.InterfaceC1564a;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC1584i;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements Collection, InterfaceC1564a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f5500a;

    public static final class a implements Iterator, InterfaceC1564a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f5501a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5502b;

        public a(byte[] array) {
            kotlin.jvm.internal.r.f(array, "array");
            this.f5501a = array;
        }

        public byte b() {
            int i4 = this.f5502b;
            byte[] bArr = this.f5501a;
            if (i4 >= bArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f5502b));
            }
            this.f5502b = i4 + 1;
            return u.c(bArr[i4]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f5502b < this.f5501a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return u.a(b());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public /* synthetic */ v(byte[] bArr) {
        this.f5500a = bArr;
    }

    public static final /* synthetic */ v f(byte[] bArr) {
        return new v(bArr);
    }

    public static byte[] i(int i4) {
        return k(new byte[i4]);
    }

    public static byte[] k(byte[] storage) {
        kotlin.jvm.internal.r.f(storage, "storage");
        return storage;
    }

    public static boolean m(byte[] bArr, byte b4) {
        return AbstractC0765l.n(bArr, b4);
    }

    public static boolean n(byte[] bArr, Collection elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        for (Object obj : elements) {
            if (!(obj instanceof u) || !AbstractC0765l.n(bArr, ((u) obj).k())) {
                return false;
            }
        }
        return true;
    }

    public static boolean o(byte[] bArr, Object obj) {
        return (obj instanceof v) && kotlin.jvm.internal.r.b(bArr, ((v) obj).x());
    }

    public static final byte p(byte[] bArr, int i4) {
        return u.c(bArr[i4]);
    }

    public static int r(byte[] bArr) {
        return bArr.length;
    }

    public static int s(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    public static boolean t(byte[] bArr) {
        return bArr.length == 0;
    }

    public static Iterator u(byte[] bArr) {
        return new a(bArr);
    }

    public static final void v(byte[] bArr, int i4, byte b4) {
        bArr[i4] = b4;
    }

    public static String w(byte[] bArr) {
        return "UByteArray(storage=" + Arrays.toString(bArr) + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof u) {
            return l(((u) obj).k());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        return n(this.f5500a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return o(this.f5500a, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return s(this.f5500a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return t(this.f5500a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return u(this.f5500a);
    }

    public boolean l(byte b4) {
        return m(this.f5500a, b4);
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public int size() {
        return r(this.f5500a);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return AbstractC1584i.a(this);
    }

    public String toString() {
        return w(this.f5500a);
    }

    public final /* synthetic */ byte[] x() {
        return this.f5500a;
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] array) {
        kotlin.jvm.internal.r.f(array, "array");
        return AbstractC1584i.b(this, array);
    }
}
