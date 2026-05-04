package dd;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f8008d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object[] f8009e = new Object[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f8011b = f8009e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8012c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    private final void p(int i10) {
        if (i10 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f8011b;
        if (i10 <= objArr.length) {
            return;
        }
        if (objArr == f8009e) {
            this.f8011b = new Object[vd.l.b(i10, 10)];
        } else {
            f(d.f7994a.e(objArr.length, i10));
        }
    }

    public final void A(int i10, int i11) {
        int iU = u(this.f8010a + (i10 - 1));
        int iU2 = u(this.f8010a + (i11 - 1));
        while (i10 > 0) {
            int i12 = iU + 1;
            int iMin = Math.min(i10, Math.min(i12, iU2 + 1));
            Object[] objArr = this.f8011b;
            int i13 = iU2 - iMin;
            int i14 = iU - iMin;
            l.h(objArr, objArr, i13 + 1, i14 + 1, i12);
            iU = r(i14);
            iU2 = r(i13);
            i10 -= iMin;
        }
    }

    public final void G(int i10, int i11) {
        int iU = u(this.f8010a + i11);
        int iU2 = u(this.f8010a + i10);
        int size = size();
        while (true) {
            size -= i11;
            if (size <= 0) {
                return;
            }
            Object[] objArr = this.f8011b;
            i11 = Math.min(size, Math.min(objArr.length - iU, objArr.length - iU2));
            Object[] objArr2 = this.f8011b;
            int i12 = iU + i11;
            l.h(objArr2, objArr2, iU2, iU, i12);
            iU = u(i12);
            iU2 = u(iU2 + i11);
        }
    }

    @Override // dd.f
    public int a() {
        return this.f8012c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection elements) {
        kotlin.jvm.internal.t.f(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        v();
        p(size() + elements.size());
        e(u(this.f8010a + size()), elements);
        return true;
    }

    public final void addFirst(Object obj) {
        v();
        p(size() + 1);
        int iG = g(this.f8010a);
        this.f8010a = iG;
        this.f8011b[iG] = obj;
        this.f8012c = size() + 1;
    }

    public final void addLast(Object obj) {
        v();
        p(size() + 1);
        this.f8011b[u(this.f8010a + size())] = obj;
        this.f8012c = size() + 1;
    }

    @Override // dd.f
    public Object c(int i10) {
        d.f7994a.b(i10, size());
        if (i10 == r.m(this)) {
            return removeLast();
        }
        if (i10 == 0) {
            return removeFirst();
        }
        v();
        int iU = u(this.f8010a + i10);
        Object obj = this.f8011b[iU];
        if (i10 < (size() >> 1)) {
            int i11 = this.f8010a;
            if (iU >= i11) {
                Object[] objArr = this.f8011b;
                l.h(objArr, objArr, i11 + 1, i11, iU);
            } else {
                Object[] objArr2 = this.f8011b;
                l.h(objArr2, objArr2, 1, 0, iU);
                Object[] objArr3 = this.f8011b;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i12 = this.f8010a;
                l.h(objArr3, objArr3, i12 + 1, i12, objArr3.length - 1);
            }
            Object[] objArr4 = this.f8011b;
            int i13 = this.f8010a;
            objArr4[i13] = null;
            this.f8010a = q(i13);
        } else {
            int iU2 = u(this.f8010a + r.m(this));
            if (iU <= iU2) {
                Object[] objArr5 = this.f8011b;
                l.h(objArr5, objArr5, iU, iU + 1, iU2 + 1);
            } else {
                Object[] objArr6 = this.f8011b;
                l.h(objArr6, objArr6, iU, iU + 1, objArr6.length);
                Object[] objArr7 = this.f8011b;
                objArr7[objArr7.length - 1] = objArr7[0];
                l.h(objArr7, objArr7, 0, 1, iU2 + 1);
            }
            this.f8011b[iU2] = null;
        }
        this.f8012c = size() - 1;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        if (!isEmpty()) {
            v();
            s(this.f8010a, u(this.f8010a + size()));
        }
        this.f8010a = 0;
        this.f8012c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void e(int i10, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f8011b.length;
        while (i10 < length && it.hasNext()) {
            this.f8011b[i10] = it.next();
            i10++;
        }
        int i11 = this.f8010a;
        for (int i12 = 0; i12 < i11 && it.hasNext(); i12++) {
            this.f8011b[i12] = it.next();
        }
        this.f8012c = size() + collection.size();
    }

    public final void f(int i10) {
        Object[] objArr = new Object[i10];
        Object[] objArr2 = this.f8011b;
        l.h(objArr2, objArr, 0, this.f8010a, objArr2.length);
        Object[] objArr3 = this.f8011b;
        int length = objArr3.length;
        int i11 = this.f8010a;
        l.h(objArr3, objArr, length - i11, 0, i11);
        this.f8010a = 0;
        this.f8011b = objArr;
    }

    public final int g(int i10) {
        return i10 == 0 ? n.G(this.f8011b) : i10 - 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i10) {
        d.f7994a.b(i10, size());
        return this.f8011b[u(this.f8010a + i10)];
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i10;
        int iU = u(this.f8010a + size());
        int length = this.f8010a;
        if (length < iU) {
            while (length < iU) {
                if (kotlin.jvm.internal.t.b(obj, this.f8011b[length])) {
                    i10 = this.f8010a;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iU) {
            return -1;
        }
        int length2 = this.f8011b.length;
        while (true) {
            if (length >= length2) {
                for (int i11 = 0; i11 < iU; i11++) {
                    if (kotlin.jvm.internal.t.b(obj, this.f8011b[i11])) {
                        length = i11 + this.f8011b.length;
                        i10 = this.f8010a;
                    }
                }
                return -1;
            }
            if (kotlin.jvm.internal.t.b(obj, this.f8011b[length])) {
                i10 = this.f8010a;
                break;
            }
            length++;
        }
        return length - i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int iG;
        int i10;
        int iU = u(this.f8010a + size());
        int i11 = this.f8010a;
        if (i11 < iU) {
            iG = iU - 1;
            if (i11 <= iG) {
                while (!kotlin.jvm.internal.t.b(obj, this.f8011b[iG])) {
                    if (iG != i11) {
                        iG--;
                    }
                }
                i10 = this.f8010a;
                return iG - i10;
            }
            return -1;
        }
        if (i11 > iU) {
            int i12 = iU - 1;
            while (true) {
                if (-1 >= i12) {
                    iG = n.G(this.f8011b);
                    int i13 = this.f8010a;
                    if (i13 <= iG) {
                        while (!kotlin.jvm.internal.t.b(obj, this.f8011b[iG])) {
                            if (iG != i13) {
                                iG--;
                            }
                        }
                        i10 = this.f8010a;
                    }
                } else {
                    if (kotlin.jvm.internal.t.b(obj, this.f8011b[i12])) {
                        iG = i12 + this.f8011b.length;
                        i10 = this.f8010a;
                        break;
                    }
                    i12--;
                }
            }
        }
        return -1;
    }

    public final int q(int i10) {
        if (i10 == n.G(this.f8011b)) {
            return 0;
        }
        return i10 + 1;
    }

    public final int r(int i10) {
        return i10 < 0 ? i10 + this.f8011b.length : i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        c(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection elements) {
        int iU;
        kotlin.jvm.internal.t.f(elements, "elements");
        boolean z10 = false;
        z10 = false;
        z10 = false;
        if (!isEmpty() && this.f8011b.length != 0) {
            int iU2 = u(this.f8010a + size());
            int i10 = this.f8010a;
            if (i10 < iU2) {
                iU = i10;
                while (i10 < iU2) {
                    Object obj = this.f8011b[i10];
                    if (elements.contains(obj)) {
                        z10 = true;
                    } else {
                        this.f8011b[iU] = obj;
                        iU++;
                    }
                    i10++;
                }
                l.n(this.f8011b, null, iU, iU2);
            } else {
                int length = this.f8011b.length;
                boolean z11 = false;
                int i11 = i10;
                while (i10 < length) {
                    Object[] objArr = this.f8011b;
                    Object obj2 = objArr[i10];
                    objArr[i10] = null;
                    if (elements.contains(obj2)) {
                        z11 = true;
                    } else {
                        this.f8011b[i11] = obj2;
                        i11++;
                    }
                    i10++;
                }
                iU = u(i11);
                for (int i12 = 0; i12 < iU2; i12++) {
                    Object[] objArr2 = this.f8011b;
                    Object obj3 = objArr2[i12];
                    objArr2[i12] = null;
                    if (elements.contains(obj3)) {
                        z11 = true;
                    } else {
                        this.f8011b[iU] = obj3;
                        iU = q(iU);
                    }
                }
                z10 = z11;
            }
            if (z10) {
                v();
                this.f8012c = r(iU - this.f8010a);
            }
        }
        return z10;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        v();
        Object[] objArr = this.f8011b;
        int i10 = this.f8010a;
        Object obj = objArr[i10];
        objArr[i10] = null;
        this.f8010a = q(i10);
        this.f8012c = size() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        v();
        int iU = u(this.f8010a + r.m(this));
        Object[] objArr = this.f8011b;
        Object obj = objArr[iU];
        objArr[iU] = null;
        this.f8012c = size() - 1;
        return obj;
    }

    @Override // java.util.AbstractList
    public void removeRange(int i10, int i11) {
        d.f7994a.d(i10, i11, size());
        int i12 = i11 - i10;
        if (i12 == 0) {
            return;
        }
        if (i12 == size()) {
            clear();
            return;
        }
        if (i12 == 1) {
            c(i10);
            return;
        }
        v();
        if (i10 < size() - i11) {
            A(i10, i11);
            int iU = u(this.f8010a + i12);
            s(this.f8010a, iU);
            this.f8010a = iU;
        } else {
            G(i10, i11);
            int iU2 = u(this.f8010a + size());
            s(r(iU2 - i12), iU2);
        }
        this.f8012c = size() - i12;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection elements) {
        int iU;
        kotlin.jvm.internal.t.f(elements, "elements");
        boolean z10 = false;
        z10 = false;
        z10 = false;
        if (!isEmpty() && this.f8011b.length != 0) {
            int iU2 = u(this.f8010a + size());
            int i10 = this.f8010a;
            if (i10 < iU2) {
                iU = i10;
                while (i10 < iU2) {
                    Object obj = this.f8011b[i10];
                    if (elements.contains(obj)) {
                        this.f8011b[iU] = obj;
                        iU++;
                    } else {
                        z10 = true;
                    }
                    i10++;
                }
                l.n(this.f8011b, null, iU, iU2);
            } else {
                int length = this.f8011b.length;
                boolean z11 = false;
                int i11 = i10;
                while (i10 < length) {
                    Object[] objArr = this.f8011b;
                    Object obj2 = objArr[i10];
                    objArr[i10] = null;
                    if (elements.contains(obj2)) {
                        this.f8011b[i11] = obj2;
                        i11++;
                    } else {
                        z11 = true;
                    }
                    i10++;
                }
                iU = u(i11);
                for (int i12 = 0; i12 < iU2; i12++) {
                    Object[] objArr2 = this.f8011b;
                    Object obj3 = objArr2[i12];
                    objArr2[i12] = null;
                    if (elements.contains(obj3)) {
                        this.f8011b[iU] = obj3;
                        iU = q(iU);
                    } else {
                        z11 = true;
                    }
                }
                z10 = z11;
            }
            if (z10) {
                v();
                this.f8012c = r(iU - this.f8010a);
            }
        }
        return z10;
    }

    public final void s(int i10, int i11) {
        if (i10 < i11) {
            l.n(this.f8011b, null, i10, i11);
            return;
        }
        Object[] objArr = this.f8011b;
        l.n(objArr, null, i10, objArr.length);
        l.n(this.f8011b, null, 0, i11);
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i10, Object obj) {
        d.f7994a.b(i10, size());
        int iU = u(this.f8010a + i10);
        Object[] objArr = this.f8011b;
        Object obj2 = objArr[iU];
        objArr[iU] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray(Object[] array) {
        kotlin.jvm.internal.t.f(array, "array");
        if (array.length < size()) {
            array = j.a(array, size());
        }
        Object[] objArr = array;
        int iU = u(this.f8010a + size());
        int i10 = this.f8010a;
        if (i10 < iU) {
            l.k(this.f8011b, objArr, 0, i10, iU, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.f8011b;
            l.h(objArr2, objArr, 0, this.f8010a, objArr2.length);
            Object[] objArr3 = this.f8011b;
            l.h(objArr3, objArr, objArr3.length - this.f8010a, 0, iU);
        }
        return q.g(size(), objArr);
    }

    public final int u(int i10) {
        Object[] objArr = this.f8011b;
        return i10 >= objArr.length ? i10 - objArr.length : i10;
    }

    public final void v() {
        ((AbstractList) this).modCount++;
    }

    public final Object w() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    public final Object y() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i10, Object obj) {
        d.f7994a.c(i10, size());
        if (i10 == size()) {
            addLast(obj);
            return;
        }
        if (i10 == 0) {
            addFirst(obj);
            return;
        }
        v();
        p(size() + 1);
        int iU = u(this.f8010a + i10);
        if (i10 < ((size() + 1) >> 1)) {
            int iG = g(iU);
            int iG2 = g(this.f8010a);
            int i11 = this.f8010a;
            if (iG >= i11) {
                Object[] objArr = this.f8011b;
                objArr[iG2] = objArr[i11];
                l.h(objArr, objArr, i11, i11 + 1, iG + 1);
            } else {
                Object[] objArr2 = this.f8011b;
                l.h(objArr2, objArr2, i11 - 1, i11, objArr2.length);
                Object[] objArr3 = this.f8011b;
                objArr3[objArr3.length - 1] = objArr3[0];
                l.h(objArr3, objArr3, 0, 1, iG + 1);
            }
            this.f8011b[iG] = obj;
            this.f8010a = iG2;
        } else {
            int iU2 = u(this.f8010a + size());
            if (iU < iU2) {
                Object[] objArr4 = this.f8011b;
                l.h(objArr4, objArr4, iU + 1, iU, iU2);
            } else {
                Object[] objArr5 = this.f8011b;
                l.h(objArr5, objArr5, 1, 0, iU2);
                Object[] objArr6 = this.f8011b;
                objArr6[0] = objArr6[objArr6.length - 1];
                l.h(objArr6, objArr6, iU + 1, iU, objArr6.length - 1);
            }
            this.f8011b[iU] = obj;
        }
        this.f8012c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i10, Collection elements) {
        kotlin.jvm.internal.t.f(elements, "elements");
        d.f7994a.c(i10, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (i10 == size()) {
            return addAll(elements);
        }
        v();
        p(size() + elements.size());
        int iU = u(this.f8010a + size());
        int iU2 = u(this.f8010a + i10);
        int size = elements.size();
        if (i10 < ((size() + 1) >> 1)) {
            int i11 = this.f8010a;
            int length = i11 - size;
            if (iU2 < i11) {
                Object[] objArr = this.f8011b;
                l.h(objArr, objArr, length, i11, objArr.length);
                if (size >= iU2) {
                    Object[] objArr2 = this.f8011b;
                    l.h(objArr2, objArr2, objArr2.length - size, 0, iU2);
                } else {
                    Object[] objArr3 = this.f8011b;
                    l.h(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f8011b;
                    l.h(objArr4, objArr4, 0, size, iU2);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.f8011b;
                l.h(objArr5, objArr5, length, i11, iU2);
            } else {
                Object[] objArr6 = this.f8011b;
                length += objArr6.length;
                int i12 = iU2 - i11;
                int length2 = objArr6.length - length;
                if (length2 >= i12) {
                    l.h(objArr6, objArr6, length, i11, iU2);
                } else {
                    l.h(objArr6, objArr6, length, i11, i11 + length2);
                    Object[] objArr7 = this.f8011b;
                    l.h(objArr7, objArr7, 0, this.f8010a + length2, iU2);
                }
            }
            this.f8010a = length;
            e(r(iU2 - size), elements);
        } else {
            int i13 = iU2 + size;
            if (iU2 < iU) {
                int i14 = size + iU;
                Object[] objArr8 = this.f8011b;
                if (i14 <= objArr8.length) {
                    l.h(objArr8, objArr8, i13, iU2, iU);
                } else if (i13 >= objArr8.length) {
                    l.h(objArr8, objArr8, i13 - objArr8.length, iU2, iU);
                } else {
                    int length3 = iU - (i14 - objArr8.length);
                    l.h(objArr8, objArr8, 0, length3, iU);
                    Object[] objArr9 = this.f8011b;
                    l.h(objArr9, objArr9, i13, iU2, length3);
                }
            } else {
                Object[] objArr10 = this.f8011b;
                l.h(objArr10, objArr10, size, 0, iU);
                Object[] objArr11 = this.f8011b;
                if (i13 >= objArr11.length) {
                    l.h(objArr11, objArr11, i13 - objArr11.length, iU2, objArr11.length);
                } else {
                    l.h(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f8011b;
                    l.h(objArr12, objArr12, i13, iU2, objArr12.length - size);
                }
            }
            e(iU2, elements);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
