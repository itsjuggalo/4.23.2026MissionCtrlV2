package cd;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a0 implements Collection, qd.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f3832a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements Iterator, qd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f3833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3834b;

        public a(int[] array) {
            kotlin.jvm.internal.t.f(array, "array");
            this.f3833a = array;
        }

        public int c() {
            int i10 = this.f3834b;
            int[] iArr = this.f3833a;
            if (i10 >= iArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f3834b));
            }
            this.f3834b = i10 + 1;
            return z.b(iArr[i10]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f3834b < this.f3833a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return z.a(c());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public /* synthetic */ a0(int[] iArr) {
        this.f3832a = iArr;
    }

    public static final void A(int[] iArr, int i10, int i11) {
        iArr[i10] = i11;
    }

    public static String G(int[] iArr) {
        return "UIntArray(storage=" + Arrays.toString(iArr) + ')';
    }

    public static final /* synthetic */ a0 a(int[] iArr) {
        return new a0(iArr);
    }

    public static int[] c(int i10) {
        return e(new int[i10]);
    }

    public static int[] e(int[] storage) {
        kotlin.jvm.internal.t.f(storage, "storage");
        return storage;
    }

    public static boolean g(int[] iArr, int i10) {
        return dd.n.v(iArr, i10);
    }

    public static boolean p(int[] iArr, Collection elements) {
        kotlin.jvm.internal.t.f(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        for (Object obj : elements) {
            if (!(obj instanceof z) || !dd.n.v(iArr, ((z) obj).k())) {
                return false;
            }
        }
        return true;
    }

    public static boolean q(int[] iArr, Object obj) {
        return (obj instanceof a0) && kotlin.jvm.internal.t.b(iArr, ((a0) obj).K());
    }

    public static final int r(int[] iArr, int i10) {
        return z.b(iArr[i10]);
    }

    public static int u(int[] iArr) {
        return iArr.length;
    }

    public static int v(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    public static boolean w(int[] iArr) {
        return iArr.length == 0;
    }

    public static Iterator y(int[] iArr) {
        return new a(iArr);
    }

    public final /* synthetic */ int[] K() {
        return this.f3832a;
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
        if (obj instanceof z) {
            return f(((z) obj).k());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection elements) {
        kotlin.jvm.internal.t.f(elements, "elements");
        return p(this.f3832a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return q(this.f3832a, obj);
    }

    public boolean f(int i10) {
        return g(this.f3832a, i10);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return v(this.f3832a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return w(this.f3832a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return y(this.f3832a);
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
        return u(this.f3832a);
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return kotlin.jvm.internal.j.a(this);
    }

    public String toString() {
        return G(this.f3832a);
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] array) {
        kotlin.jvm.internal.t.f(array, "array");
        return kotlin.jvm.internal.j.b(this, array);
    }
}
