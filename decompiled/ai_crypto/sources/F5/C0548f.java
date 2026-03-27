package F5;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: renamed from: F5.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0548f extends AbstractC0546d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f2376d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object[] f2377e = new Object[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f2379b = f2377e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2380c;

    /* JADX INFO: renamed from: F5.f$a */
    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public a() {
        }
    }

    @Override // F5.AbstractC0546d
    public int a() {
        return this.f2380c;
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
        q();
        k(size() + elements.size());
        g(p(this.f2378a + size()), elements);
        return true;
    }

    public final void addFirst(Object obj) {
        q();
        k(size() + 1);
        int iJ = j(this.f2378a);
        this.f2378a = iJ;
        this.f2379b[iJ] = obj;
        this.f2380c = size() + 1;
    }

    public final void addLast(Object obj) {
        q();
        k(size() + 1);
        this.f2379b[p(this.f2378a + size())] = obj;
        this.f2380c = size() + 1;
    }

    @Override // F5.AbstractC0546d
    public Object c(int i7) {
        AbstractC0545c.f2367a.b(i7, size());
        if (i7 == AbstractC0556n.i(this)) {
            return removeLast();
        }
        if (i7 == 0) {
            return removeFirst();
        }
        q();
        int iP = p(this.f2378a + i7);
        Object obj = this.f2379b[iP];
        if (i7 < (size() >> 1)) {
            int i8 = this.f2378a;
            if (iP >= i8) {
                Object[] objArr = this.f2379b;
                AbstractC0551i.e(objArr, objArr, i8 + 1, i8, iP);
            } else {
                Object[] objArr2 = this.f2379b;
                AbstractC0551i.e(objArr2, objArr2, 1, 0, iP);
                Object[] objArr3 = this.f2379b;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i9 = this.f2378a;
                AbstractC0551i.e(objArr3, objArr3, i9 + 1, i9, objArr3.length - 1);
            }
            Object[] objArr4 = this.f2379b;
            int i10 = this.f2378a;
            objArr4[i10] = null;
            this.f2378a = l(i10);
        } else {
            int iP2 = p(this.f2378a + AbstractC0556n.i(this));
            if (iP <= iP2) {
                Object[] objArr5 = this.f2379b;
                AbstractC0551i.e(objArr5, objArr5, iP, iP + 1, iP2 + 1);
            } else {
                Object[] objArr6 = this.f2379b;
                AbstractC0551i.e(objArr6, objArr6, iP, iP + 1, objArr6.length);
                Object[] objArr7 = this.f2379b;
                objArr7[objArr7.length - 1] = objArr7[0];
                AbstractC0551i.e(objArr7, objArr7, 0, 1, iP2 + 1);
            }
            this.f2379b[iP2] = null;
        }
        this.f2380c = size() - 1;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        if (!isEmpty()) {
            q();
            n(this.f2378a, p(this.f2378a + size()));
        }
        this.f2378a = 0;
        this.f2380c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void g(int i7, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f2379b.length;
        while (i7 < length && it.hasNext()) {
            this.f2379b[i7] = it.next();
            i7++;
        }
        int i8 = this.f2378a;
        for (int i9 = 0; i9 < i8 && it.hasNext(); i9++) {
            this.f2379b[i9] = it.next();
        }
        this.f2380c = size() + collection.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i7) {
        AbstractC0545c.f2367a.b(i7, size());
        return this.f2379b[p(this.f2378a + i7)];
    }

    public final void h(int i7) {
        Object[] objArr = new Object[i7];
        Object[] objArr2 = this.f2379b;
        AbstractC0551i.e(objArr2, objArr, 0, this.f2378a, objArr2.length);
        Object[] objArr3 = this.f2379b;
        int length = objArr3.length;
        int i8 = this.f2378a;
        AbstractC0551i.e(objArr3, objArr, length - i8, 0, i8);
        this.f2378a = 0;
        this.f2379b = objArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i7;
        int iP = p(this.f2378a + size());
        int length = this.f2378a;
        if (length < iP) {
            while (length < iP) {
                if (kotlin.jvm.internal.r.b(obj, this.f2379b[length])) {
                    i7 = this.f2378a;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iP) {
            return -1;
        }
        int length2 = this.f2379b.length;
        while (true) {
            if (length >= length2) {
                for (int i8 = 0; i8 < iP; i8++) {
                    if (kotlin.jvm.internal.r.b(obj, this.f2379b[i8])) {
                        length = i8 + this.f2379b.length;
                        i7 = this.f2378a;
                    }
                }
                return -1;
            }
            if (kotlin.jvm.internal.r.b(obj, this.f2379b[length])) {
                i7 = this.f2378a;
                break;
            }
            length++;
        }
        return length - i7;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    public final int j(int i7) {
        return i7 == 0 ? AbstractC0552j.x(this.f2379b) : i7 - 1;
    }

    public final void k(int i7) {
        if (i7 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f2379b;
        if (i7 <= objArr.length) {
            return;
        }
        if (objArr == f2377e) {
            this.f2379b = new Object[W5.l.b(i7, 10)];
        } else {
            h(AbstractC0545c.f2367a.e(objArr.length, i7));
        }
    }

    public final int l(int i7) {
        if (i7 == AbstractC0552j.x(this.f2379b)) {
            return 0;
        }
        return i7 + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int iX;
        int i7;
        int iP = p(this.f2378a + size());
        int i8 = this.f2378a;
        if (i8 < iP) {
            iX = iP - 1;
            if (i8 <= iX) {
                while (!kotlin.jvm.internal.r.b(obj, this.f2379b[iX])) {
                    if (iX != i8) {
                        iX--;
                    }
                }
                i7 = this.f2378a;
                return iX - i7;
            }
            return -1;
        }
        if (i8 > iP) {
            int i9 = iP - 1;
            while (true) {
                if (-1 >= i9) {
                    iX = AbstractC0552j.x(this.f2379b);
                    int i10 = this.f2378a;
                    if (i10 <= iX) {
                        while (!kotlin.jvm.internal.r.b(obj, this.f2379b[iX])) {
                            if (iX != i10) {
                                iX--;
                            }
                        }
                        i7 = this.f2378a;
                    }
                } else {
                    if (kotlin.jvm.internal.r.b(obj, this.f2379b[i9])) {
                        iX = i9 + this.f2379b.length;
                        i7 = this.f2378a;
                        break;
                    }
                    i9--;
                }
            }
        }
        return -1;
    }

    public final int m(int i7) {
        return i7 < 0 ? i7 + this.f2379b.length : i7;
    }

    public final void n(int i7, int i8) {
        if (i7 < i8) {
            AbstractC0551i.j(this.f2379b, null, i7, i8);
            return;
        }
        Object[] objArr = this.f2379b;
        AbstractC0551i.j(objArr, null, i7, objArr.length);
        AbstractC0551i.j(this.f2379b, null, 0, i8);
    }

    public final int p(int i7) {
        Object[] objArr = this.f2379b;
        return i7 >= objArr.length ? i7 - objArr.length : i7;
    }

    public final void q() {
        ((AbstractList) this).modCount++;
    }

    public final Object r() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
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
        int iP;
        kotlin.jvm.internal.r.f(elements, "elements");
        boolean z7 = false;
        z7 = false;
        z7 = false;
        if (!isEmpty() && this.f2379b.length != 0) {
            int iP2 = p(this.f2378a + size());
            int i7 = this.f2378a;
            if (i7 < iP2) {
                iP = i7;
                while (i7 < iP2) {
                    Object obj = this.f2379b[i7];
                    if (elements.contains(obj)) {
                        z7 = true;
                    } else {
                        this.f2379b[iP] = obj;
                        iP++;
                    }
                    i7++;
                }
                AbstractC0551i.j(this.f2379b, null, iP, iP2);
            } else {
                int length = this.f2379b.length;
                boolean z8 = false;
                int i8 = i7;
                while (i7 < length) {
                    Object[] objArr = this.f2379b;
                    Object obj2 = objArr[i7];
                    objArr[i7] = null;
                    if (elements.contains(obj2)) {
                        z8 = true;
                    } else {
                        this.f2379b[i8] = obj2;
                        i8++;
                    }
                    i7++;
                }
                iP = p(i8);
                for (int i9 = 0; i9 < iP2; i9++) {
                    Object[] objArr2 = this.f2379b;
                    Object obj3 = objArr2[i9];
                    objArr2[i9] = null;
                    if (elements.contains(obj3)) {
                        z8 = true;
                    } else {
                        this.f2379b[iP] = obj3;
                        iP = l(iP);
                    }
                }
                z7 = z8;
            }
            if (z7) {
                q();
                this.f2380c = m(iP - this.f2378a);
            }
        }
        return z7;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        q();
        Object[] objArr = this.f2379b;
        int i7 = this.f2378a;
        Object obj = objArr[i7];
        objArr[i7] = null;
        this.f2378a = l(i7);
        this.f2380c = size() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        q();
        int iP = p(this.f2378a + AbstractC0556n.i(this));
        Object[] objArr = this.f2379b;
        Object obj = objArr[iP];
        objArr[iP] = null;
        this.f2380c = size() - 1;
        return obj;
    }

    @Override // java.util.AbstractList
    public void removeRange(int i7, int i8) {
        AbstractC0545c.f2367a.d(i7, i8, size());
        int i9 = i8 - i7;
        if (i9 == 0) {
            return;
        }
        if (i9 == size()) {
            clear();
            return;
        }
        if (i9 == 1) {
            remove(i7);
            return;
        }
        q();
        if (i7 < size() - i8) {
            t(i7, i8);
            int iP = p(this.f2378a + i9);
            n(this.f2378a, iP);
            this.f2378a = iP;
        } else {
            u(i7, i8);
            int iP2 = p(this.f2378a + size());
            n(m(iP2 - i9), iP2);
        }
        this.f2380c = size() - i9;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection elements) {
        int iP;
        kotlin.jvm.internal.r.f(elements, "elements");
        boolean z7 = false;
        z7 = false;
        z7 = false;
        if (!isEmpty() && this.f2379b.length != 0) {
            int iP2 = p(this.f2378a + size());
            int i7 = this.f2378a;
            if (i7 < iP2) {
                iP = i7;
                while (i7 < iP2) {
                    Object obj = this.f2379b[i7];
                    if (elements.contains(obj)) {
                        this.f2379b[iP] = obj;
                        iP++;
                    } else {
                        z7 = true;
                    }
                    i7++;
                }
                AbstractC0551i.j(this.f2379b, null, iP, iP2);
            } else {
                int length = this.f2379b.length;
                boolean z8 = false;
                int i8 = i7;
                while (i7 < length) {
                    Object[] objArr = this.f2379b;
                    Object obj2 = objArr[i7];
                    objArr[i7] = null;
                    if (elements.contains(obj2)) {
                        this.f2379b[i8] = obj2;
                        i8++;
                    } else {
                        z8 = true;
                    }
                    i7++;
                }
                iP = p(i8);
                for (int i9 = 0; i9 < iP2; i9++) {
                    Object[] objArr2 = this.f2379b;
                    Object obj3 = objArr2[i9];
                    objArr2[i9] = null;
                    if (elements.contains(obj3)) {
                        this.f2379b[iP] = obj3;
                        iP = l(iP);
                    } else {
                        z8 = true;
                    }
                }
                z7 = z8;
            }
            if (z7) {
                q();
                this.f2380c = m(iP - this.f2378a);
            }
        }
        return z7;
    }

    public final Object s() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i7, Object obj) {
        AbstractC0545c.f2367a.b(i7, size());
        int iP = p(this.f2378a + i7);
        Object[] objArr = this.f2379b;
        Object obj2 = objArr[iP];
        objArr[iP] = obj;
        return obj2;
    }

    public final void t(int i7, int i8) {
        int iP = p(this.f2378a + (i7 - 1));
        int iP2 = p(this.f2378a + (i8 - 1));
        while (i7 > 0) {
            int i9 = iP + 1;
            int iMin = Math.min(i7, Math.min(i9, iP2 + 1));
            Object[] objArr = this.f2379b;
            int i10 = iP2 - iMin;
            int i11 = iP - iMin;
            AbstractC0551i.e(objArr, objArr, i10 + 1, i11 + 1, i9);
            iP = m(i11);
            iP2 = m(i10);
            i7 -= iMin;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray(Object[] array) {
        kotlin.jvm.internal.r.f(array, "array");
        if (array.length < size()) {
            array = AbstractC0549g.a(array, size());
        }
        int iP = p(this.f2378a + size());
        int i7 = this.f2378a;
        if (i7 < iP) {
            AbstractC0551i.g(this.f2379b, array, 0, i7, iP, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr = this.f2379b;
            AbstractC0551i.e(objArr, array, 0, this.f2378a, objArr.length);
            Object[] objArr2 = this.f2379b;
            AbstractC0551i.e(objArr2, array, objArr2.length - this.f2378a, 0, iP);
        }
        return AbstractC0555m.d(size(), array);
    }

    public final void u(int i7, int i8) {
        int iP = p(this.f2378a + i8);
        int iP2 = p(this.f2378a + i7);
        int size = size();
        while (true) {
            size -= i8;
            if (size <= 0) {
                return;
            }
            Object[] objArr = this.f2379b;
            i8 = Math.min(size, Math.min(objArr.length - iP, objArr.length - iP2));
            Object[] objArr2 = this.f2379b;
            int i9 = iP + i8;
            AbstractC0551i.e(objArr2, objArr2, iP2, iP, i9);
            iP = p(i9);
            iP2 = p(iP2 + i8);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i7, Object obj) {
        AbstractC0545c.f2367a.c(i7, size());
        if (i7 == size()) {
            addLast(obj);
            return;
        }
        if (i7 == 0) {
            addFirst(obj);
            return;
        }
        q();
        k(size() + 1);
        int iP = p(this.f2378a + i7);
        if (i7 < ((size() + 1) >> 1)) {
            int iJ = j(iP);
            int iJ2 = j(this.f2378a);
            int i8 = this.f2378a;
            if (iJ >= i8) {
                Object[] objArr = this.f2379b;
                objArr[iJ2] = objArr[i8];
                AbstractC0551i.e(objArr, objArr, i8, i8 + 1, iJ + 1);
            } else {
                Object[] objArr2 = this.f2379b;
                AbstractC0551i.e(objArr2, objArr2, i8 - 1, i8, objArr2.length);
                Object[] objArr3 = this.f2379b;
                objArr3[objArr3.length - 1] = objArr3[0];
                AbstractC0551i.e(objArr3, objArr3, 0, 1, iJ + 1);
            }
            this.f2379b[iJ] = obj;
            this.f2378a = iJ2;
        } else {
            int iP2 = p(this.f2378a + size());
            if (iP < iP2) {
                Object[] objArr4 = this.f2379b;
                AbstractC0551i.e(objArr4, objArr4, iP + 1, iP, iP2);
            } else {
                Object[] objArr5 = this.f2379b;
                AbstractC0551i.e(objArr5, objArr5, 1, 0, iP2);
                Object[] objArr6 = this.f2379b;
                objArr6[0] = objArr6[objArr6.length - 1];
                AbstractC0551i.e(objArr6, objArr6, iP + 1, iP, objArr6.length - 1);
            }
            this.f2379b[iP] = obj;
        }
        this.f2380c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i7, Collection elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        AbstractC0545c.f2367a.c(i7, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (i7 == size()) {
            return addAll(elements);
        }
        q();
        k(size() + elements.size());
        int iP = p(this.f2378a + size());
        int iP2 = p(this.f2378a + i7);
        int size = elements.size();
        if (i7 < ((size() + 1) >> 1)) {
            int i8 = this.f2378a;
            int length = i8 - size;
            if (iP2 < i8) {
                Object[] objArr = this.f2379b;
                AbstractC0551i.e(objArr, objArr, length, i8, objArr.length);
                if (size >= iP2) {
                    Object[] objArr2 = this.f2379b;
                    AbstractC0551i.e(objArr2, objArr2, objArr2.length - size, 0, iP2);
                } else {
                    Object[] objArr3 = this.f2379b;
                    AbstractC0551i.e(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f2379b;
                    AbstractC0551i.e(objArr4, objArr4, 0, size, iP2);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.f2379b;
                AbstractC0551i.e(objArr5, objArr5, length, i8, iP2);
            } else {
                Object[] objArr6 = this.f2379b;
                length += objArr6.length;
                int i9 = iP2 - i8;
                int length2 = objArr6.length - length;
                if (length2 >= i9) {
                    AbstractC0551i.e(objArr6, objArr6, length, i8, iP2);
                } else {
                    AbstractC0551i.e(objArr6, objArr6, length, i8, i8 + length2);
                    Object[] objArr7 = this.f2379b;
                    AbstractC0551i.e(objArr7, objArr7, 0, this.f2378a + length2, iP2);
                }
            }
            this.f2378a = length;
            g(m(iP2 - size), elements);
        } else {
            int i10 = iP2 + size;
            if (iP2 < iP) {
                int i11 = size + iP;
                Object[] objArr8 = this.f2379b;
                if (i11 <= objArr8.length) {
                    AbstractC0551i.e(objArr8, objArr8, i10, iP2, iP);
                } else if (i10 >= objArr8.length) {
                    AbstractC0551i.e(objArr8, objArr8, i10 - objArr8.length, iP2, iP);
                } else {
                    int length3 = iP - (i11 - objArr8.length);
                    AbstractC0551i.e(objArr8, objArr8, 0, length3, iP);
                    Object[] objArr9 = this.f2379b;
                    AbstractC0551i.e(objArr9, objArr9, i10, iP2, length3);
                }
            } else {
                Object[] objArr10 = this.f2379b;
                AbstractC0551i.e(objArr10, objArr10, size, 0, iP);
                Object[] objArr11 = this.f2379b;
                if (i10 >= objArr11.length) {
                    AbstractC0551i.e(objArr11, objArr11, i10 - objArr11.length, iP2, objArr11.length);
                } else {
                    AbstractC0551i.e(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f2379b;
                    AbstractC0551i.e(objArr12, objArr12, i10, iP2, objArr12.length - size);
                }
            }
            g(iP2, elements);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
