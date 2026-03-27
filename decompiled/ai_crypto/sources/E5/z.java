package E5;

import F5.AbstractC0552j;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC2147i;

/* JADX INFO: loaded from: classes2.dex */
public final class z implements Collection, R5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long[] f1704a;

    public static final class a implements Iterator, R5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f1705a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1706b;

        public a(long[] array) {
            kotlin.jvm.internal.r.f(array, "array");
            this.f1705a = array;
        }

        public long c() {
            int i7 = this.f1706b;
            long[] jArr = this.f1705a;
            if (i7 >= jArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f1706b));
            }
            this.f1706b = i7 + 1;
            return y.b(jArr[i7]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1706b < this.f1705a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return y.a(c());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public /* synthetic */ z(long[] jArr) {
        this.f1704a = jArr;
    }

    public static final /* synthetic */ z a(long[] jArr) {
        return new z(jArr);
    }

    public static long[] c(int i7) {
        return g(new long[i7]);
    }

    public static long[] g(long[] storage) {
        kotlin.jvm.internal.r.f(storage, "storage");
        return storage;
    }

    public static boolean j(long[] jArr, long j7) {
        return AbstractC0552j.o(jArr, j7);
    }

    public static boolean k(long[] jArr, Collection elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        for (Object obj : elements) {
            if (!(obj instanceof y) || !AbstractC0552j.o(jArr, ((y) obj).j())) {
                return false;
            }
        }
        return true;
    }

    public static boolean l(long[] jArr, Object obj) {
        return (obj instanceof z) && kotlin.jvm.internal.r.b(jArr, ((z) obj).w());
    }

    public static final long m(long[] jArr, int i7) {
        return y.b(jArr[i7]);
    }

    public static int p(long[] jArr) {
        return jArr.length;
    }

    public static int q(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    public static boolean r(long[] jArr) {
        return jArr.length == 0;
    }

    public static Iterator s(long[] jArr) {
        return new a(jArr);
    }

    public static final void t(long[] jArr, int i7, long j7) {
        jArr[i7] = j7;
    }

    public static String u(long[] jArr) {
        return "ULongArray(storage=" + Arrays.toString(jArr) + ')';
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
        if (obj instanceof y) {
            return h(((y) obj).j());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        return k(this.f1704a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return l(this.f1704a, obj);
    }

    public boolean h(long j7) {
        return j(this.f1704a, j7);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return q(this.f1704a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return r(this.f1704a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return s(this.f1704a);
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public int size() {
        return p(this.f1704a);
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
        return u(this.f1704a);
    }

    public final /* synthetic */ long[] w() {
        return this.f1704a;
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] array) {
        kotlin.jvm.internal.r.f(array, "array");
        return AbstractC2147i.b(this, array);
    }
}
