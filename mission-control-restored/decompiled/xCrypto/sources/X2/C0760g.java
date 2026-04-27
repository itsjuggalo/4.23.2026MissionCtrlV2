package X2;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC1585j;
import o3.AbstractC1681l;

/* JADX INFO: renamed from: X2.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0760g extends AbstractC0758e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f5614d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object[] f5615e = new Object[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f5617b = f5615e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5618c;

    /* JADX INFO: renamed from: X2.g$a */
    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public a() {
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        s();
        n(size() + elements.size());
        k(r(this.f5616a + size()), elements);
        return true;
    }

    public final void addFirst(Object obj) {
        s();
        n(size() + 1);
        int iM = m(this.f5616a);
        this.f5616a = iM;
        this.f5617b[iM] = obj;
        this.f5618c = size() + 1;
    }

    public final void addLast(Object obj) {
        s();
        n(size() + 1);
        this.f5617b[r(this.f5616a + size())] = obj;
        this.f5618c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        if (!isEmpty()) {
            s();
            q(this.f5616a, r(this.f5616a + size()));
        }
        this.f5616a = 0;
        this.f5618c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // X2.AbstractC0758e
    public int f() {
        return this.f5618c;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i4) {
        AbstractC0757d.f5605a.b(i4, size());
        return this.f5617b[r(this.f5616a + i4)];
    }

    @Override // X2.AbstractC0758e
    public Object i(int i4) {
        AbstractC0757d.f5605a.b(i4, size());
        if (i4 == AbstractC0769p.i(this)) {
            return removeLast();
        }
        if (i4 == 0) {
            return removeFirst();
        }
        s();
        int iR = r(this.f5616a + i4);
        Object obj = this.f5617b[iR];
        if (i4 < (size() >> 1)) {
            int i5 = this.f5616a;
            if (iR >= i5) {
                Object[] objArr = this.f5617b;
                AbstractC0763j.e(objArr, objArr, i5 + 1, i5, iR);
            } else {
                Object[] objArr2 = this.f5617b;
                AbstractC0763j.e(objArr2, objArr2, 1, 0, iR);
                Object[] objArr3 = this.f5617b;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i6 = this.f5616a;
                AbstractC0763j.e(objArr3, objArr3, i6 + 1, i6, objArr3.length - 1);
            }
            Object[] objArr4 = this.f5617b;
            int i7 = this.f5616a;
            objArr4[i7] = null;
            this.f5616a = o(i7);
        } else {
            int iR2 = r(this.f5616a + AbstractC0769p.i(this));
            if (iR <= iR2) {
                Object[] objArr5 = this.f5617b;
                AbstractC0763j.e(objArr5, objArr5, iR, iR + 1, iR2 + 1);
            } else {
                Object[] objArr6 = this.f5617b;
                AbstractC0763j.e(objArr6, objArr6, iR, iR + 1, objArr6.length);
                Object[] objArr7 = this.f5617b;
                objArr7[objArr7.length - 1] = objArr7[0];
                AbstractC0763j.e(objArr7, objArr7, 0, 1, iR2 + 1);
            }
            this.f5617b[iR2] = null;
        }
        this.f5618c = size() - 1;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i4;
        int iR = r(this.f5616a + size());
        int length = this.f5616a;
        if (length < iR) {
            while (length < iR) {
                if (kotlin.jvm.internal.r.b(obj, this.f5617b[length])) {
                    i4 = this.f5616a;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iR) {
            return -1;
        }
        int length2 = this.f5617b.length;
        while (true) {
            if (length >= length2) {
                for (int i5 = 0; i5 < iR; i5++) {
                    if (kotlin.jvm.internal.r.b(obj, this.f5617b[i5])) {
                        length = i5 + this.f5617b.length;
                        i4 = this.f5616a;
                    }
                }
                return -1;
            }
            if (kotlin.jvm.internal.r.b(obj, this.f5617b[length])) {
                i4 = this.f5616a;
                break;
            }
            length++;
        }
        return length - i4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    public final void k(int i4, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f5617b.length;
        while (i4 < length && it.hasNext()) {
            this.f5617b[i4] = it.next();
            i4++;
        }
        int i5 = this.f5616a;
        for (int i6 = 0; i6 < i5 && it.hasNext(); i6++) {
            this.f5617b[i6] = it.next();
        }
        this.f5618c = size() + collection.size();
    }

    public final void l(int i4) {
        Object[] objArr = new Object[i4];
        Object[] objArr2 = this.f5617b;
        AbstractC0763j.e(objArr2, objArr, 0, this.f5616a, objArr2.length);
        Object[] objArr3 = this.f5617b;
        int length = objArr3.length;
        int i5 = this.f5616a;
        AbstractC0763j.e(objArr3, objArr, length - i5, 0, i5);
        this.f5616a = 0;
        this.f5617b = objArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int iY;
        int i4;
        int iR = r(this.f5616a + size());
        int i5 = this.f5616a;
        if (i5 < iR) {
            iY = iR - 1;
            if (i5 <= iY) {
                while (!kotlin.jvm.internal.r.b(obj, this.f5617b[iY])) {
                    if (iY != i5) {
                        iY--;
                    }
                }
                i4 = this.f5616a;
                return iY - i4;
            }
            return -1;
        }
        if (i5 > iR) {
            int i6 = iR - 1;
            while (true) {
                if (-1 >= i6) {
                    iY = AbstractC0765l.y(this.f5617b);
                    int i7 = this.f5616a;
                    if (i7 <= iY) {
                        while (!kotlin.jvm.internal.r.b(obj, this.f5617b[iY])) {
                            if (iY != i7) {
                                iY--;
                            }
                        }
                        i4 = this.f5616a;
                    }
                } else {
                    if (kotlin.jvm.internal.r.b(obj, this.f5617b[i6])) {
                        iY = i6 + this.f5617b.length;
                        i4 = this.f5616a;
                        break;
                    }
                    i6--;
                }
            }
        }
        return -1;
    }

    public final int m(int i4) {
        return i4 == 0 ? AbstractC0765l.y(this.f5617b) : i4 - 1;
    }

    public final void n(int i4) {
        if (i4 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f5617b;
        if (i4 <= objArr.length) {
            return;
        }
        if (objArr == f5615e) {
            this.f5617b = new Object[AbstractC1681l.b(i4, 10)];
        } else {
            l(AbstractC0757d.f5605a.e(objArr.length, i4));
        }
    }

    public final int o(int i4) {
        if (i4 == AbstractC0765l.y(this.f5617b)) {
            return 0;
        }
        return i4 + 1;
    }

    public final int p(int i4) {
        return i4 < 0 ? i4 + this.f5617b.length : i4;
    }

    public final void q(int i4, int i5) {
        if (i4 < i5) {
            AbstractC0763j.j(this.f5617b, null, i4, i5);
            return;
        }
        Object[] objArr = this.f5617b;
        AbstractC0763j.j(objArr, null, i4, objArr.length);
        AbstractC0763j.j(this.f5617b, null, 0, i5);
    }

    public final int r(int i4) {
        Object[] objArr = this.f5617b;
        return i4 >= objArr.length ? i4 - objArr.length : i4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection elements) {
        int iR;
        kotlin.jvm.internal.r.f(elements, "elements");
        boolean z4 = false;
        z4 = false;
        z4 = false;
        if (!isEmpty() && this.f5617b.length != 0) {
            int iR2 = r(this.f5616a + size());
            int i4 = this.f5616a;
            if (i4 < iR2) {
                iR = i4;
                while (i4 < iR2) {
                    Object obj = this.f5617b[i4];
                    if (elements.contains(obj)) {
                        z4 = true;
                    } else {
                        this.f5617b[iR] = obj;
                        iR++;
                    }
                    i4++;
                }
                AbstractC0763j.j(this.f5617b, null, iR, iR2);
            } else {
                int length = this.f5617b.length;
                boolean z5 = false;
                int i5 = i4;
                while (i4 < length) {
                    Object[] objArr = this.f5617b;
                    Object obj2 = objArr[i4];
                    objArr[i4] = null;
                    if (elements.contains(obj2)) {
                        z5 = true;
                    } else {
                        this.f5617b[i5] = obj2;
                        i5++;
                    }
                    i4++;
                }
                iR = r(i5);
                for (int i6 = 0; i6 < iR2; i6++) {
                    Object[] objArr2 = this.f5617b;
                    Object obj3 = objArr2[i6];
                    objArr2[i6] = null;
                    if (elements.contains(obj3)) {
                        z5 = true;
                    } else {
                        this.f5617b[iR] = obj3;
                        iR = o(iR);
                    }
                }
                z4 = z5;
            }
            if (z4) {
                s();
                this.f5618c = p(iR - this.f5616a);
            }
        }
        return z4;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        s();
        Object[] objArr = this.f5617b;
        int i4 = this.f5616a;
        Object obj = objArr[i4];
        objArr[i4] = null;
        this.f5616a = o(i4);
        this.f5618c = size() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        s();
        int iR = r(this.f5616a + AbstractC0769p.i(this));
        Object[] objArr = this.f5617b;
        Object obj = objArr[iR];
        objArr[iR] = null;
        this.f5618c = size() - 1;
        return obj;
    }

    @Override // java.util.AbstractList
    public void removeRange(int i4, int i5) {
        AbstractC0757d.f5605a.d(i4, i5, size());
        int i6 = i5 - i4;
        if (i6 == 0) {
            return;
        }
        if (i6 == size()) {
            clear();
            return;
        }
        if (i6 == 1) {
            remove(i4);
            return;
        }
        s();
        if (i4 < size() - i5) {
            v(i4, i5);
            int iR = r(this.f5616a + i6);
            q(this.f5616a, iR);
            this.f5616a = iR;
        } else {
            w(i4, i5);
            int iR2 = r(this.f5616a + size());
            q(p(iR2 - i6), iR2);
        }
        this.f5618c = size() - i6;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection elements) {
        int iR;
        kotlin.jvm.internal.r.f(elements, "elements");
        boolean z4 = false;
        z4 = false;
        z4 = false;
        if (!isEmpty() && this.f5617b.length != 0) {
            int iR2 = r(this.f5616a + size());
            int i4 = this.f5616a;
            if (i4 < iR2) {
                iR = i4;
                while (i4 < iR2) {
                    Object obj = this.f5617b[i4];
                    if (elements.contains(obj)) {
                        this.f5617b[iR] = obj;
                        iR++;
                    } else {
                        z4 = true;
                    }
                    i4++;
                }
                AbstractC0763j.j(this.f5617b, null, iR, iR2);
            } else {
                int length = this.f5617b.length;
                boolean z5 = false;
                int i5 = i4;
                while (i4 < length) {
                    Object[] objArr = this.f5617b;
                    Object obj2 = objArr[i4];
                    objArr[i4] = null;
                    if (elements.contains(obj2)) {
                        this.f5617b[i5] = obj2;
                        i5++;
                    } else {
                        z5 = true;
                    }
                    i4++;
                }
                iR = r(i5);
                for (int i6 = 0; i6 < iR2; i6++) {
                    Object[] objArr2 = this.f5617b;
                    Object obj3 = objArr2[i6];
                    objArr2[i6] = null;
                    if (elements.contains(obj3)) {
                        this.f5617b[iR] = obj3;
                        iR = o(iR);
                    } else {
                        z5 = true;
                    }
                }
                z4 = z5;
            }
            if (z4) {
                s();
                this.f5618c = p(iR - this.f5616a);
            }
        }
        return z4;
    }

    public final void s() {
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i4, Object obj) {
        AbstractC0757d.f5605a.b(i4, size());
        int iR = r(this.f5616a + i4);
        Object[] objArr = this.f5617b;
        Object obj2 = objArr[iR];
        objArr[iR] = obj;
        return obj2;
    }

    public final Object t() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray(Object[] array) {
        kotlin.jvm.internal.r.f(array, "array");
        if (array.length < size()) {
            array = AbstractC0761h.a(array, size());
        }
        Object[] objArr = array;
        int iR = r(this.f5616a + size());
        int i4 = this.f5616a;
        if (i4 < iR) {
            AbstractC0763j.g(this.f5617b, objArr, 0, i4, iR, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.f5617b;
            AbstractC0763j.e(objArr2, objArr, 0, this.f5616a, objArr2.length);
            Object[] objArr3 = this.f5617b;
            AbstractC0763j.e(objArr3, objArr, objArr3.length - this.f5616a, 0, iR);
        }
        return AbstractC0768o.d(size(), objArr);
    }

    public final Object u() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    public final void v(int i4, int i5) {
        int iR = r(this.f5616a + (i4 - 1));
        int iR2 = r(this.f5616a + (i5 - 1));
        while (i4 > 0) {
            int i6 = iR + 1;
            int iMin = Math.min(i4, Math.min(i6, iR2 + 1));
            Object[] objArr = this.f5617b;
            int i7 = iR2 - iMin;
            int i8 = iR - iMin;
            AbstractC0763j.e(objArr, objArr, i7 + 1, i8 + 1, i6);
            iR = p(i8);
            iR2 = p(i7);
            i4 -= iMin;
        }
    }

    public final void w(int i4, int i5) {
        int iR = r(this.f5616a + i5);
        int iR2 = r(this.f5616a + i4);
        int size = size();
        while (true) {
            size -= i5;
            if (size <= 0) {
                return;
            }
            Object[] objArr = this.f5617b;
            i5 = Math.min(size, Math.min(objArr.length - iR, objArr.length - iR2));
            Object[] objArr2 = this.f5617b;
            int i6 = iR + i5;
            AbstractC0763j.e(objArr2, objArr2, iR2, iR, i6);
            iR = r(i6);
            iR2 = r(iR2 + i5);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i4, Object obj) {
        AbstractC0757d.f5605a.c(i4, size());
        if (i4 == size()) {
            addLast(obj);
            return;
        }
        if (i4 == 0) {
            addFirst(obj);
            return;
        }
        s();
        n(size() + 1);
        int iR = r(this.f5616a + i4);
        if (i4 < ((size() + 1) >> 1)) {
            int iM = m(iR);
            int iM2 = m(this.f5616a);
            int i5 = this.f5616a;
            if (iM >= i5) {
                Object[] objArr = this.f5617b;
                objArr[iM2] = objArr[i5];
                AbstractC0763j.e(objArr, objArr, i5, i5 + 1, iM + 1);
            } else {
                Object[] objArr2 = this.f5617b;
                AbstractC0763j.e(objArr2, objArr2, i5 - 1, i5, objArr2.length);
                Object[] objArr3 = this.f5617b;
                objArr3[objArr3.length - 1] = objArr3[0];
                AbstractC0763j.e(objArr3, objArr3, 0, 1, iM + 1);
            }
            this.f5617b[iM] = obj;
            this.f5616a = iM2;
        } else {
            int iR2 = r(this.f5616a + size());
            if (iR < iR2) {
                Object[] objArr4 = this.f5617b;
                AbstractC0763j.e(objArr4, objArr4, iR + 1, iR, iR2);
            } else {
                Object[] objArr5 = this.f5617b;
                AbstractC0763j.e(objArr5, objArr5, 1, 0, iR2);
                Object[] objArr6 = this.f5617b;
                objArr6[0] = objArr6[objArr6.length - 1];
                AbstractC0763j.e(objArr6, objArr6, iR + 1, iR, objArr6.length - 1);
            }
            this.f5617b[iR] = obj;
        }
        this.f5618c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i4, Collection elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        AbstractC0757d.f5605a.c(i4, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (i4 == size()) {
            return addAll(elements);
        }
        s();
        n(size() + elements.size());
        int iR = r(this.f5616a + size());
        int iR2 = r(this.f5616a + i4);
        int size = elements.size();
        if (i4 < ((size() + 1) >> 1)) {
            int i5 = this.f5616a;
            int length = i5 - size;
            if (iR2 < i5) {
                Object[] objArr = this.f5617b;
                AbstractC0763j.e(objArr, objArr, length, i5, objArr.length);
                if (size >= iR2) {
                    Object[] objArr2 = this.f5617b;
                    AbstractC0763j.e(objArr2, objArr2, objArr2.length - size, 0, iR2);
                } else {
                    Object[] objArr3 = this.f5617b;
                    AbstractC0763j.e(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f5617b;
                    AbstractC0763j.e(objArr4, objArr4, 0, size, iR2);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.f5617b;
                AbstractC0763j.e(objArr5, objArr5, length, i5, iR2);
            } else {
                Object[] objArr6 = this.f5617b;
                length += objArr6.length;
                int i6 = iR2 - i5;
                int length2 = objArr6.length - length;
                if (length2 >= i6) {
                    AbstractC0763j.e(objArr6, objArr6, length, i5, iR2);
                } else {
                    AbstractC0763j.e(objArr6, objArr6, length, i5, i5 + length2);
                    Object[] objArr7 = this.f5617b;
                    AbstractC0763j.e(objArr7, objArr7, 0, this.f5616a + length2, iR2);
                }
            }
            this.f5616a = length;
            k(p(iR2 - size), elements);
        } else {
            int i7 = iR2 + size;
            if (iR2 < iR) {
                int i8 = size + iR;
                Object[] objArr8 = this.f5617b;
                if (i8 <= objArr8.length) {
                    AbstractC0763j.e(objArr8, objArr8, i7, iR2, iR);
                } else if (i7 >= objArr8.length) {
                    AbstractC0763j.e(objArr8, objArr8, i7 - objArr8.length, iR2, iR);
                } else {
                    int length3 = iR - (i8 - objArr8.length);
                    AbstractC0763j.e(objArr8, objArr8, 0, length3, iR);
                    Object[] objArr9 = this.f5617b;
                    AbstractC0763j.e(objArr9, objArr9, i7, iR2, length3);
                }
            } else {
                Object[] objArr10 = this.f5617b;
                AbstractC0763j.e(objArr10, objArr10, size, 0, iR);
                Object[] objArr11 = this.f5617b;
                if (i7 >= objArr11.length) {
                    AbstractC0763j.e(objArr11, objArr11, i7 - objArr11.length, iR2, objArr11.length);
                } else {
                    AbstractC0763j.e(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f5617b;
                    AbstractC0763j.e(objArr12, objArr12, i7, iR2, objArr12.length - size);
                }
            }
            k(iR2, elements);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
