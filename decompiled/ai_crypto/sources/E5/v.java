package E5;

import F5.AbstractC0552j;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC2147i;

/* JADX INFO: loaded from: classes2.dex */
public final class v implements Collection, R5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f1694a;

    public static final class a implements Iterator, R5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f1695a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1696b;

        public a(byte[] array) {
            kotlin.jvm.internal.r.f(array, "array");
            this.f1695a = array;
        }

        public byte c() {
            int i7 = this.f1696b;
            byte[] bArr = this.f1695a;
            if (i7 >= bArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f1696b));
            }
            this.f1696b = i7 + 1;
            return u.b(bArr[i7]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1696b < this.f1695a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return u.a(c());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public /* synthetic */ v(byte[] bArr) {
        this.f1694a = bArr;
    }

    public static final /* synthetic */ v a(byte[] bArr) {
        return new v(bArr);
    }

    public static byte[] c(int i7) {
        return g(new byte[i7]);
    }

    public static byte[] g(byte[] storage) {
        kotlin.jvm.internal.r.f(storage, "storage");
        return storage;
    }

    public static boolean j(byte[] bArr, byte b7) {
        return AbstractC0552j.m(bArr, b7);
    }

    public static boolean k(byte[] bArr, Collection elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        for (Object obj : elements) {
            if (!(obj instanceof u) || !AbstractC0552j.m(bArr, ((u) obj).j())) {
                return false;
            }
        }
        return true;
    }

    public static boolean l(byte[] bArr, Object obj) {
        return (obj instanceof v) && kotlin.jvm.internal.r.b(bArr, ((v) obj).w());
    }

    public static final byte m(byte[] bArr, int i7) {
        return u.b(bArr[i7]);
    }

    public static int p(byte[] bArr) {
        return bArr.length;
    }

    public static int q(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    public static boolean r(byte[] bArr) {
        return bArr.length == 0;
    }

    public static Iterator s(byte[] bArr) {
        return new a(bArr);
    }

    public static final void t(byte[] bArr, int i7, byte b7) {
        bArr[i7] = b7;
    }

    public static String u(byte[] bArr) {
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
            return h(((u) obj).j());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        return k(this.f1694a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return l(this.f1694a, obj);
    }

    public boolean h(byte b7) {
        return j(this.f1694a, b7);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return q(this.f1694a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return r(this.f1694a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return s(this.f1694a);
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public int size() {
        return p(this.f1694a);
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
        return AbstractC2147i.a(this);
    }

    public String toString() {
        return u(this.f1694a);
    }

    public final /* synthetic */ byte[] w() {
        return this.f1694a;
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] array) {
        kotlin.jvm.internal.r.f(array, "array");
        return AbstractC2147i.b(this, array);
    }
}
