package W2;

import X2.AbstractC0765l;
import j3.InterfaceC1564a;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC1584i;

/* JADX INFO: loaded from: classes3.dex */
public final class x implements Collection, InterfaceC1564a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f5505a;

    public static final class a implements Iterator, InterfaceC1564a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f5506a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5507b;

        public a(int[] array) {
            kotlin.jvm.internal.r.f(array, "array");
            this.f5506a = array;
        }

        public int b() {
            int i4 = this.f5507b;
            int[] iArr = this.f5506a;
            if (i4 >= iArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f5507b));
            }
            this.f5507b = i4 + 1;
            return w.c(iArr[i4]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f5507b < this.f5506a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return w.a(b());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public /* synthetic */ x(int[] iArr) {
        this.f5505a = iArr;
    }

    public static final /* synthetic */ x f(int[] iArr) {
        return new x(iArr);
    }

    public static int[] i(int i4) {
        return k(new int[i4]);
    }

    public static int[] k(int[] storage) {
        kotlin.jvm.internal.r.f(storage, "storage");
        return storage;
    }

    public static boolean m(int[] iArr, int i4) {
        return AbstractC0765l.o(iArr, i4);
    }

    public static boolean n(int[] iArr, Collection elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        for (Object obj : elements) {
            if (!(obj instanceof w) || !AbstractC0765l.o(iArr, ((w) obj).k())) {
                return false;
            }
        }
        return true;
    }

    public static boolean o(int[] iArr, Object obj) {
        return (obj instanceof x) && kotlin.jvm.internal.r.b(iArr, ((x) obj).x());
    }

    public static final int p(int[] iArr, int i4) {
        return w.c(iArr[i4]);
    }

    public static int r(int[] iArr) {
        return iArr.length;
    }

    public static int s(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    public static boolean t(int[] iArr) {
        return iArr.length == 0;
    }

    public static Iterator u(int[] iArr) {
        return new a(iArr);
    }

    public static final void v(int[] iArr, int i4, int i5) {
        iArr[i4] = i5;
    }

    public static String w(int[] iArr) {
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
            return l(((w) obj).k());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        return n(this.f5505a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return o(this.f5505a, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return s(this.f5505a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return t(this.f5505a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return u(this.f5505a);
    }

    public boolean l(int i4) {
        return m(this.f5505a, i4);
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public int size() {
        return r(this.f5505a);
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
        return w(this.f5505a);
    }

    public final /* synthetic */ int[] x() {
        return this.f5505a;
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] array) {
        kotlin.jvm.internal.r.f(array, "array");
        return AbstractC1584i.b(this, array);
    }
}
