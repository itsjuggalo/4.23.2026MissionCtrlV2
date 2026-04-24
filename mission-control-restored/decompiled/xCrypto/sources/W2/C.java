package W2;

import X2.AbstractC0765l;
import j3.InterfaceC1564a;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC1584i;

/* JADX INFO: loaded from: classes3.dex */
public final class C implements Collection, InterfaceC1564a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final short[] f5460a;

    public static final class a implements Iterator, InterfaceC1564a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final short[] f5461a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5462b;

        public a(short[] array) {
            kotlin.jvm.internal.r.f(array, "array");
            this.f5461a = array;
        }

        public short b() {
            int i4 = this.f5462b;
            short[] sArr = this.f5461a;
            if (i4 >= sArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f5462b));
            }
            this.f5462b = i4 + 1;
            return B.c(sArr[i4]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f5462b < this.f5461a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return B.a(b());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public /* synthetic */ C(short[] sArr) {
        this.f5460a = sArr;
    }

    public static final /* synthetic */ C f(short[] sArr) {
        return new C(sArr);
    }

    public static short[] i(int i4) {
        return k(new short[i4]);
    }

    public static short[] k(short[] storage) {
        kotlin.jvm.internal.r.f(storage, "storage");
        return storage;
    }

    public static boolean m(short[] sArr, short s4) {
        return AbstractC0765l.r(sArr, s4);
    }

    public static boolean n(short[] sArr, Collection elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        for (Object obj : elements) {
            if (!(obj instanceof B) || !AbstractC0765l.r(sArr, ((B) obj).k())) {
                return false;
            }
        }
        return true;
    }

    public static boolean o(short[] sArr, Object obj) {
        return (obj instanceof C) && kotlin.jvm.internal.r.b(sArr, ((C) obj).x());
    }

    public static final short p(short[] sArr, int i4) {
        return B.c(sArr[i4]);
    }

    public static int r(short[] sArr) {
        return sArr.length;
    }

    public static int s(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    public static boolean t(short[] sArr) {
        return sArr.length == 0;
    }

    public static Iterator u(short[] sArr) {
        return new a(sArr);
    }

    public static final void v(short[] sArr, int i4, short s4) {
        sArr[i4] = s4;
    }

    public static String w(short[] sArr) {
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
            return l(((B) obj).k());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        return n(this.f5460a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return o(this.f5460a, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return s(this.f5460a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return t(this.f5460a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return u(this.f5460a);
    }

    public boolean l(short s4) {
        return m(this.f5460a, s4);
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public int size() {
        return r(this.f5460a);
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
        return w(this.f5460a);
    }

    public final /* synthetic */ short[] x() {
        return this.f5460a;
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] array) {
        kotlin.jvm.internal.r.f(array, "array");
        return AbstractC1584i.b(this, array);
    }
}
