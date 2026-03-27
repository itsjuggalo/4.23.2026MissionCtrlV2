package o5;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC2295j;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2592n;

/* JADX INFO: renamed from: o5.F, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2468F implements Collection, C5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final short[] f21953a;

    /* JADX INFO: renamed from: o5.F$a */
    public static final class a implements Iterator, C5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final short[] f21954a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f21955b;

        public a(short[] array) {
            AbstractC2304t.f(array, "array");
            this.f21954a = array;
        }

        public short c() {
            int i8 = this.f21955b;
            short[] sArr = this.f21954a;
            if (i8 >= sArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f21955b));
            }
            this.f21955b = i8 + 1;
            return C2467E.b(sArr[i8]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f21955b < this.f21954a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return C2467E.a(c());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public /* synthetic */ C2468F(short[] sArr) {
        this.f21953a = sArr;
    }

    public static boolean C(short[] sArr, Object obj) {
        return (obj instanceof C2468F) && AbstractC2304t.b(sArr, ((C2468F) obj).O());
    }

    public static final short F(short[] sArr, int i8) {
        return C2467E.b(sArr[i8]);
    }

    public static int I(short[] sArr) {
        return sArr.length;
    }

    public static int J(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    public static boolean K(short[] sArr) {
        return sArr.length == 0;
    }

    public static Iterator L(short[] sArr) {
        return new a(sArr);
    }

    public static final void M(short[] sArr, int i8, short s8) {
        sArr[i8] = s8;
    }

    public static String N(short[] sArr) {
        return "UShortArray(storage=" + Arrays.toString(sArr) + ')';
    }

    public static final /* synthetic */ C2468F a(short[] sArr) {
        return new C2468F(sArr);
    }

    public static short[] d(int i8) {
        return e(new short[i8]);
    }

    public static short[] e(short[] storage) {
        AbstractC2304t.f(storage, "storage");
        return storage;
    }

    public static boolean h(short[] sArr, short s8) {
        return AbstractC2592n.y(sArr, s8);
    }

    public static boolean n(short[] sArr, Collection elements) {
        AbstractC2304t.f(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        for (Object obj : elements) {
            if (!(obj instanceof C2467E) || !AbstractC2592n.y(sArr, ((C2467E) obj).l())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public int size() {
        return I(this.f21953a);
    }

    public final /* synthetic */ short[] O() {
        return this.f21953a;
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
        if (obj instanceof C2467E) {
            return f(((C2467E) obj).l());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection elements) {
        AbstractC2304t.f(elements, "elements");
        return n(this.f21953a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return C(this.f21953a, obj);
    }

    public boolean f(short s8) {
        return h(this.f21953a, s8);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return J(this.f21953a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return K(this.f21953a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return L(this.f21953a);
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
        return N(this.f21953a);
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] array) {
        AbstractC2304t.f(array, "array");
        return AbstractC2295j.b(this, array);
    }
}
