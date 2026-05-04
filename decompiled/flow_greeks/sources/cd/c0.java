package cd;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c0 implements Collection, qd.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long[] f3838a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements Iterator, qd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f3839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3840b;

        public a(long[] array) {
            kotlin.jvm.internal.t.f(array, "array");
            this.f3839a = array;
        }

        public long c() {
            int i10 = this.f3840b;
            long[] jArr = this.f3839a;
            if (i10 >= jArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f3840b));
            }
            this.f3840b = i10 + 1;
            return b0.b(jArr[i10]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f3840b < this.f3839a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return b0.a(c());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public /* synthetic */ c0(long[] jArr) {
        this.f3838a = jArr;
    }

    public static final void A(long[] jArr, int i10, long j10) {
        jArr[i10] = j10;
    }

    public static String G(long[] jArr) {
        return "ULongArray(storage=" + Arrays.toString(jArr) + ')';
    }

    public static final /* synthetic */ c0 a(long[] jArr) {
        return new c0(jArr);
    }

    public static long[] c(int i10) {
        return e(new long[i10]);
    }

    public static long[] e(long[] storage) {
        kotlin.jvm.internal.t.f(storage, "storage");
        return storage;
    }

    public static boolean g(long[] jArr, long j10) {
        return dd.n.w(jArr, j10);
    }

    public static boolean p(long[] jArr, Collection elements) {
        kotlin.jvm.internal.t.f(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        for (Object obj : elements) {
            if (!(obj instanceof b0) || !dd.n.w(jArr, ((b0) obj).k())) {
                return false;
            }
        }
        return true;
    }

    public static boolean q(long[] jArr, Object obj) {
        return (obj instanceof c0) && kotlin.jvm.internal.t.b(jArr, ((c0) obj).K());
    }

    public static final long r(long[] jArr, int i10) {
        return b0.b(jArr[i10]);
    }

    public static int u(long[] jArr) {
        return jArr.length;
    }

    public static int v(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    public static boolean w(long[] jArr) {
        return jArr.length == 0;
    }

    public static Iterator y(long[] jArr) {
        return new a(jArr);
    }

    public final /* synthetic */ long[] K() {
        return this.f3838a;
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
        if (obj instanceof b0) {
            return f(((b0) obj).k());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection elements) {
        kotlin.jvm.internal.t.f(elements, "elements");
        return p(this.f3838a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return q(this.f3838a, obj);
    }

    public boolean f(long j10) {
        return g(this.f3838a, j10);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return v(this.f3838a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return w(this.f3838a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return y(this.f3838a);
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
        return u(this.f3838a);
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return kotlin.jvm.internal.j.a(this);
    }

    public String toString() {
        return G(this.f3838a);
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] array) {
        kotlin.jvm.internal.t.f(array, "array");
        return kotlin.jvm.internal.j.b(this, array);
    }
}
