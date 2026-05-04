package cd;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class y implements Collection, qd.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f3886a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements Iterator, qd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f3887a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3888b;

        public a(byte[] array) {
            kotlin.jvm.internal.t.f(array, "array");
            this.f3887a = array;
        }

        public byte c() {
            int i10 = this.f3888b;
            byte[] bArr = this.f3887a;
            if (i10 >= bArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f3888b));
            }
            this.f3888b = i10 + 1;
            return x.b(bArr[i10]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f3888b < this.f3887a.length;
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
        this.f3886a = bArr;
    }

    public static final void A(byte[] bArr, int i10, byte b10) {
        bArr[i10] = b10;
    }

    public static String G(byte[] bArr) {
        return "UByteArray(storage=" + Arrays.toString(bArr) + ')';
    }

    public static final /* synthetic */ y a(byte[] bArr) {
        return new y(bArr);
    }

    public static byte[] c(int i10) {
        return e(new byte[i10]);
    }

    public static byte[] e(byte[] storage) {
        kotlin.jvm.internal.t.f(storage, "storage");
        return storage;
    }

    public static boolean g(byte[] bArr, byte b10) {
        return dd.n.u(bArr, b10);
    }

    public static boolean p(byte[] bArr, Collection elements) {
        kotlin.jvm.internal.t.f(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        for (Object obj : elements) {
            if (!(obj instanceof x) || !dd.n.u(bArr, ((x) obj).k())) {
                return false;
            }
        }
        return true;
    }

    public static boolean q(byte[] bArr, Object obj) {
        return (obj instanceof y) && kotlin.jvm.internal.t.b(bArr, ((y) obj).K());
    }

    public static final byte r(byte[] bArr, int i10) {
        return x.b(bArr[i10]);
    }

    public static int u(byte[] bArr) {
        return bArr.length;
    }

    public static int v(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    public static boolean w(byte[] bArr) {
        return bArr.length == 0;
    }

    public static Iterator y(byte[] bArr) {
        return new a(bArr);
    }

    public final /* synthetic */ byte[] K() {
        return this.f3886a;
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
            return f(((x) obj).k());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection elements) {
        kotlin.jvm.internal.t.f(elements, "elements");
        return p(this.f3886a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return q(this.f3886a, obj);
    }

    public boolean f(byte b10) {
        return g(this.f3886a, b10);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return v(this.f3886a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return w(this.f3886a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return y(this.f3886a);
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
        return u(this.f3886a);
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return kotlin.jvm.internal.j.a(this);
    }

    public String toString() {
        return G(this.f3886a);
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] array) {
        kotlin.jvm.internal.t.f(array, "array");
        return kotlin.jvm.internal.j.b(this, array);
    }
}
