package o5;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC2295j;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2592n;

/* JADX INFO: loaded from: classes2.dex */
public final class y implements Collection, C5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f21997a;

    public static final class a implements Iterator, C5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f21998a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f21999b;

        public a(byte[] array) {
            AbstractC2304t.f(array, "array");
            this.f21998a = array;
        }

        public byte c() {
            int i8 = this.f21999b;
            byte[] bArr = this.f21998a;
            if (i8 >= bArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f21999b));
            }
            this.f21999b = i8 + 1;
            return x.b(bArr[i8]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f21999b < this.f21998a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return x.a(c());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public /* synthetic */ y(byte[] bArr) {
        this.f21997a = bArr;
    }

    public static boolean C(byte[] bArr, Object obj) {
        return (obj instanceof y) && AbstractC2304t.b(bArr, ((y) obj).O());
    }

    public static final byte F(byte[] bArr, int i8) {
        return x.b(bArr[i8]);
    }

    public static int I(byte[] bArr) {
        return bArr.length;
    }

    public static int J(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    public static boolean K(byte[] bArr) {
        return bArr.length == 0;
    }

    public static Iterator L(byte[] bArr) {
        return new a(bArr);
    }

    public static final void M(byte[] bArr, int i8, byte b8) {
        bArr[i8] = b8;
    }

    public static String N(byte[] bArr) {
        return "UByteArray(storage=" + Arrays.toString(bArr) + ')';
    }

    public static final /* synthetic */ y a(byte[] bArr) {
        return new y(bArr);
    }

    public static byte[] d(int i8) {
        return e(new byte[i8]);
    }

    public static byte[] e(byte[] storage) {
        AbstractC2304t.f(storage, "storage");
        return storage;
    }

    public static boolean h(byte[] bArr, byte b8) {
        return AbstractC2592n.u(bArr, b8);
    }

    public static boolean n(byte[] bArr, Collection elements) {
        AbstractC2304t.f(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        for (Object obj : elements) {
            if (!(obj instanceof x) || !AbstractC2592n.u(bArr, ((x) obj).l())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public int size() {
        return I(this.f21997a);
    }

    public final /* synthetic */ byte[] O() {
        return this.f21997a;
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
        if (obj instanceof x) {
            return f(((x) obj).l());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection elements) {
        AbstractC2304t.f(elements, "elements");
        return n(this.f21997a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return C(this.f21997a, obj);
    }

    public boolean f(byte b8) {
        return h(this.f21997a, b8);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return J(this.f21997a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return K(this.f21997a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return L(this.f21997a);
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
        return N(this.f21997a);
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] array) {
        AbstractC2304t.f(array, "array");
        return AbstractC2295j.b(this, array);
    }
}
