package o5;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC2295j;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2592n;

/* JADX INFO: renamed from: o5.C, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2465C implements Collection, C5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long[] f21947a;

    /* JADX INFO: renamed from: o5.C$a */
    public static final class a implements Iterator, C5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f21948a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f21949b;

        public a(long[] array) {
            AbstractC2304t.f(array, "array");
            this.f21948a = array;
        }

        public long c() {
            int i8 = this.f21949b;
            long[] jArr = this.f21948a;
            if (i8 >= jArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f21949b));
            }
            this.f21949b = i8 + 1;
            return C2464B.b(jArr[i8]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f21949b < this.f21948a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return C2464B.a(c());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public /* synthetic */ C2465C(long[] jArr) {
        this.f21947a = jArr;
    }

    public static boolean C(long[] jArr, Object obj) {
        return (obj instanceof C2465C) && AbstractC2304t.b(jArr, ((C2465C) obj).O());
    }

    public static final long F(long[] jArr, int i8) {
        return C2464B.b(jArr[i8]);
    }

    public static int I(long[] jArr) {
        return jArr.length;
    }

    public static int J(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    public static boolean K(long[] jArr) {
        return jArr.length == 0;
    }

    public static Iterator L(long[] jArr) {
        return new a(jArr);
    }

    public static final void M(long[] jArr, int i8, long j8) {
        jArr[i8] = j8;
    }

    public static String N(long[] jArr) {
        return "ULongArray(storage=" + Arrays.toString(jArr) + ')';
    }

    public static final /* synthetic */ C2465C a(long[] jArr) {
        return new C2465C(jArr);
    }

    public static long[] d(int i8) {
        return e(new long[i8]);
    }

    public static long[] e(long[] storage) {
        AbstractC2304t.f(storage, "storage");
        return storage;
    }

    public static boolean h(long[] jArr, long j8) {
        return AbstractC2592n.w(jArr, j8);
    }

    public static boolean n(long[] jArr, Collection elements) {
        AbstractC2304t.f(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        for (Object obj : elements) {
            if (!(obj instanceof C2464B) || !AbstractC2592n.w(jArr, ((C2464B) obj).l())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public int size() {
        return I(this.f21947a);
    }

    public final /* synthetic */ long[] O() {
        return this.f21947a;
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
        if (obj instanceof C2464B) {
            return f(((C2464B) obj).l());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection elements) {
        AbstractC2304t.f(elements, "elements");
        return n(this.f21947a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return C(this.f21947a, obj);
    }

    public boolean f(long j8) {
        return h(this.f21947a, j8);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return J(this.f21947a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return K(this.f21947a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return L(this.f21947a);
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
        return AbstractC2295j.a(this);
    }

    public String toString() {
        return N(this.f21947a);
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] array) {
        AbstractC2304t.f(array, "array");
        return AbstractC2295j.b(this, array);
    }
}
