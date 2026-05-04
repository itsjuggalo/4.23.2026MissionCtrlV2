package cd;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f0 implements Collection, qd.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final short[] f3848a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements Iterator, qd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final short[] f3849a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3850b;

        public a(short[] array) {
            kotlin.jvm.internal.t.f(array, "array");
            this.f3849a = array;
        }

        public short c() {
            int i10 = this.f3850b;
            short[] sArr = this.f3849a;
            if (i10 >= sArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f3850b));
            }
            this.f3850b = i10 + 1;
            return e0.b(sArr[i10]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f3850b < this.f3849a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return e0.a(c());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public /* synthetic */ f0(short[] sArr) {
        this.f3848a = sArr;
    }

    public static final void A(short[] sArr, int i10, short s10) {
        sArr[i10] = s10;
    }

    public static String G(short[] sArr) {
        return "UShortArray(storage=" + Arrays.toString(sArr) + ')';
    }

    public static final /* synthetic */ f0 a(short[] sArr) {
        return new f0(sArr);
    }

    public static short[] c(int i10) {
        return e(new short[i10]);
    }

    public static short[] e(short[] storage) {
        kotlin.jvm.internal.t.f(storage, "storage");
        return storage;
    }

    public static boolean g(short[] sArr, short s10) {
        return dd.n.y(sArr, s10);
    }

    public static boolean p(short[] sArr, Collection elements) {
        kotlin.jvm.internal.t.f(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        for (Object obj : elements) {
            if (!(obj instanceof e0) || !dd.n.y(sArr, ((e0) obj).k())) {
                return false;
            }
        }
        return true;
    }

    public static boolean q(short[] sArr, Object obj) {
        return (obj instanceof f0) && kotlin.jvm.internal.t.b(sArr, ((f0) obj).K());
    }

    public static final short r(short[] sArr, int i10) {
        return e0.b(sArr[i10]);
    }

    public static int u(short[] sArr) {
        return sArr.length;
    }

    public static int v(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    public static boolean w(short[] sArr) {
        return sArr.length == 0;
    }

    public static Iterator y(short[] sArr) {
        return new a(sArr);
    }

    public final /* synthetic */ short[] K() {
        return this.f3848a;
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
        if (obj instanceof e0) {
            return f(((e0) obj).k());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection elements) {
        kotlin.jvm.internal.t.f(elements, "elements");
        return p(this.f3848a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return q(this.f3848a, obj);
    }

    public boolean f(short s10) {
        return g(this.f3848a, s10);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return v(this.f3848a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return w(this.f3848a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return y(this.f3848a);
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
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public int size() {
        return u(this.f3848a);
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return kotlin.jvm.internal.j.a(this);
    }

    public String toString() {
        return G(this.f3848a);
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] array) {
        kotlin.jvm.internal.t.f(array, "array");
        return kotlin.jvm.internal.j.b(this, array);
    }
}
