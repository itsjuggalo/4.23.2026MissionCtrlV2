package E5;

import F5.AbstractC0552j;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC2147i;

/* JADX INFO: loaded from: classes2.dex */
public final class C implements Collection, R5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final short[] f1654a;

    public static final class a implements Iterator, R5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final short[] f1655a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1656b;

        public a(short[] array) {
            kotlin.jvm.internal.r.f(array, "array");
            this.f1655a = array;
        }

        public short c() {
            int i7 = this.f1656b;
            short[] sArr = this.f1655a;
            if (i7 >= sArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f1656b));
            }
            this.f1656b = i7 + 1;
            return B.b(sArr[i7]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1656b < this.f1655a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return B.a(c());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public /* synthetic */ C(short[] sArr) {
        this.f1654a = sArr;
    }

    public static final /* synthetic */ C a(short[] sArr) {
        return new C(sArr);
    }

    public static short[] c(int i7) {
        return g(new short[i7]);
    }

    public static short[] g(short[] storage) {
        kotlin.jvm.internal.r.f(storage, "storage");
        return storage;
    }

    public static boolean j(short[] sArr, short s7) {
        return AbstractC0552j.q(sArr, s7);
    }

    public static boolean k(short[] sArr, Collection elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        for (Object obj : elements) {
            if (!(obj instanceof B) || !AbstractC0552j.q(sArr, ((B) obj).j())) {
                return false;
            }
        }
        return true;
    }

    public static boolean l(short[] sArr, Object obj) {
        return (obj instanceof C) && kotlin.jvm.internal.r.b(sArr, ((C) obj).w());
    }

    public static final short m(short[] sArr, int i7) {
        return B.b(sArr[i7]);
    }

    public static int p(short[] sArr) {
        return sArr.length;
    }

    public static int q(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    public static boolean r(short[] sArr) {
        return sArr.length == 0;
    }

    public static Iterator s(short[] sArr) {
        return new a(sArr);
    }

    public static final void t(short[] sArr, int i7, short s7) {
        sArr[i7] = s7;
    }

    public static String u(short[] sArr) {
        return "UShortArray(storage=" + Arrays.toString(sArr) + ')';
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
        if (obj instanceof B) {
            return h(((B) obj).j());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        return k(this.f1654a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return l(this.f1654a, obj);
    }

    public boolean h(short s7) {
        return j(this.f1654a, s7);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return q(this.f1654a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return r(this.f1654a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return s(this.f1654a);
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public int size() {
        return p(this.f1654a);
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
        return u(this.f1654a);
    }

    public final /* synthetic */ short[] w() {
        return this.f1654a;
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] array) {
        kotlin.jvm.internal.r.f(array, "array");
        return AbstractC2147i.b(this, array);
    }
}
