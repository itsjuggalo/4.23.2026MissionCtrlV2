package E5;

import F5.AbstractC0552j;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC2147i;

/* JADX INFO: loaded from: classes2.dex */
public final class x implements Collection, R5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f1699a;

    public static final class a implements Iterator, R5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f1700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1701b;

        public a(int[] array) {
            kotlin.jvm.internal.r.f(array, "array");
            this.f1700a = array;
        }

        public int c() {
            int i7 = this.f1701b;
            int[] iArr = this.f1700a;
            if (i7 >= iArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f1701b));
            }
            this.f1701b = i7 + 1;
            return w.b(iArr[i7]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1701b < this.f1700a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return w.a(c());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public /* synthetic */ x(int[] iArr) {
        this.f1699a = iArr;
    }

    public static final /* synthetic */ x a(int[] iArr) {
        return new x(iArr);
    }

    public static int[] c(int i7) {
        return g(new int[i7]);
    }

    public static int[] g(int[] storage) {
        kotlin.jvm.internal.r.f(storage, "storage");
        return storage;
    }

    public static boolean j(int[] iArr, int i7) {
        return AbstractC0552j.n(iArr, i7);
    }

    public static boolean k(int[] iArr, Collection elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        for (Object obj : elements) {
            if (!(obj instanceof w) || !AbstractC0552j.n(iArr, ((w) obj).j())) {
                return false;
            }
        }
        return true;
    }

    public static boolean l(int[] iArr, Object obj) {
        return (obj instanceof x) && kotlin.jvm.internal.r.b(iArr, ((x) obj).w());
    }

    public static final int m(int[] iArr, int i7) {
        return w.b(iArr[i7]);
    }

    public static int p(int[] iArr) {
        return iArr.length;
    }

    public static int q(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    public static boolean r(int[] iArr) {
        return iArr.length == 0;
    }

    public static Iterator s(int[] iArr) {
        return new a(iArr);
    }

    public static final void t(int[] iArr, int i7, int i8) {
        iArr[i7] = i8;
    }

    public static String u(int[] iArr) {
        return "UIntArray(storage=" + Arrays.toString(iArr) + ')';
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
        if (obj instanceof w) {
            return h(((w) obj).j());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        return k(this.f1699a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return l(this.f1699a, obj);
    }

    public boolean h(int i7) {
        return j(this.f1699a, i7);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return q(this.f1699a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return r(this.f1699a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return s(this.f1699a);
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public int size() {
        return p(this.f1699a);
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
        return u(this.f1699a);
    }

    public final /* synthetic */ int[] w() {
        return this.f1699a;
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] array) {
        kotlin.jvm.internal.r.f(array, "array");
        return AbstractC2147i.b(this, array);
    }
}
