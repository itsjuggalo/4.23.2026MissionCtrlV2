package o5;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC2295j;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2592n;

/* JADX INFO: renamed from: o5.A, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2463A implements Collection, C5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f21942a;

    /* JADX INFO: renamed from: o5.A$a */
    public static final class a implements Iterator, C5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f21943a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f21944b;

        public a(int[] array) {
            AbstractC2304t.f(array, "array");
            this.f21943a = array;
        }

        public int c() {
            int i8 = this.f21944b;
            int[] iArr = this.f21943a;
            if (i8 >= iArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f21944b));
            }
            this.f21944b = i8 + 1;
            return z.b(iArr[i8]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f21944b < this.f21943a.length;
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

    public /* synthetic */ C2463A(int[] iArr) {
        this.f21942a = iArr;
    }

    public static boolean C(int[] iArr, Object obj) {
        return (obj instanceof C2463A) && AbstractC2304t.b(iArr, ((C2463A) obj).O());
    }

    public static final int F(int[] iArr, int i8) {
        return z.b(iArr[i8]);
    }

    public static int I(int[] iArr) {
        return iArr.length;
    }

    public static int J(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    public static boolean K(int[] iArr) {
        return iArr.length == 0;
    }

    public static Iterator L(int[] iArr) {
        return new a(iArr);
    }

    public static final void M(int[] iArr, int i8, int i9) {
        iArr[i8] = i9;
    }

    public static String N(int[] iArr) {
        return "UIntArray(storage=" + Arrays.toString(iArr) + ')';
    }

    public static final /* synthetic */ C2463A a(int[] iArr) {
        return new C2463A(iArr);
    }

    public static int[] d(int i8) {
        return e(new int[i8]);
    }

    public static int[] e(int[] storage) {
        AbstractC2304t.f(storage, "storage");
        return storage;
    }

    public static boolean h(int[] iArr, int i8) {
        return AbstractC2592n.v(iArr, i8);
    }

    public static boolean n(int[] iArr, Collection elements) {
        AbstractC2304t.f(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        for (Object obj : elements) {
            if (!(obj instanceof z) || !AbstractC2592n.v(iArr, ((z) obj).l())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public int size() {
        return I(this.f21942a);
    }

    public final /* synthetic */ int[] O() {
        return this.f21942a;
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
            return f(((z) obj).l());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection elements) {
        AbstractC2304t.f(elements, "elements");
        return n(this.f21942a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return C(this.f21942a, obj);
    }

    public boolean f(int i8) {
        return h(this.f21942a, i8);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return J(this.f21942a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return K(this.f21942a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return L(this.f21942a);
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
        return N(this.f21942a);
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] array) {
        AbstractC2304t.f(array, "array");
        return AbstractC2295j.b(this, array);
    }
}
