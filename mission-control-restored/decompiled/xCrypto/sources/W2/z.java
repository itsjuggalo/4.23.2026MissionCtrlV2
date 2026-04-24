package W2;

import X2.AbstractC0765l;
import j3.InterfaceC1564a;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC1584i;

/* JADX INFO: loaded from: classes3.dex */
public final class z implements Collection, InterfaceC1564a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long[] f5510a;

    public static final class a implements Iterator, InterfaceC1564a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f5511a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5512b;

        public a(long[] array) {
            kotlin.jvm.internal.r.f(array, "array");
            this.f5511a = array;
        }

        public long b() {
            int i4 = this.f5512b;
            long[] jArr = this.f5511a;
            if (i4 >= jArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f5512b));
            }
            this.f5512b = i4 + 1;
            return y.c(jArr[i4]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f5512b < this.f5511a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return y.a(b());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public /* synthetic */ z(long[] jArr) {
        this.f5510a = jArr;
    }

    public static final /* synthetic */ z f(long[] jArr) {
        return new z(jArr);
    }

    public static long[] i(int i4) {
        return k(new long[i4]);
    }

    public static long[] k(long[] storage) {
        kotlin.jvm.internal.r.f(storage, "storage");
        return storage;
    }

    public static boolean m(long[] jArr, long j4) {
        return AbstractC0765l.p(jArr, j4);
    }

    public static boolean n(long[] jArr, Collection elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        for (Object obj : elements) {
            if (!(obj instanceof y) || !AbstractC0765l.p(jArr, ((y) obj).k())) {
                return false;
            }
        }
        return true;
    }

    public static boolean o(long[] jArr, Object obj) {
        return (obj instanceof z) && kotlin.jvm.internal.r.b(jArr, ((z) obj).x());
    }

    public static final long p(long[] jArr, int i4) {
        return y.c(jArr[i4]);
    }

    public static int r(long[] jArr) {
        return jArr.length;
    }

    public static int s(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    public static boolean t(long[] jArr) {
        return jArr.length == 0;
    }

    public static Iterator u(long[] jArr) {
        return new a(jArr);
    }

    public static final void v(long[] jArr, int i4, long j4) {
        jArr[i4] = j4;
    }

    public static String w(long[] jArr) {
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
            return l(((y) obj).k());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        return n(this.f5510a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return o(this.f5510a, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return s(this.f5510a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return t(this.f5510a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return u(this.f5510a);
    }

    public boolean l(long j4) {
        return m(this.f5510a, j4);
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public int size() {
        return r(this.f5510a);
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
        return w(this.f5510a);
    }

    public final /* synthetic */ long[] x() {
        return this.f5510a;
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] array) {
        kotlin.jvm.internal.r.f(array, "array");
        return AbstractC1584i.b(this, array);
    }
}
