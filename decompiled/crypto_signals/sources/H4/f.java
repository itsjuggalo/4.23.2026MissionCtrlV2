package H4;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import s3.D;

/* JADX INFO: loaded from: classes.dex */
public final class f extends AbstractList implements List, S4.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object[] f572d = new Object[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f574b = f572d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f575c;

    public final void a(int i, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f574b.length;
        while (i < length && it.hasNext()) {
            this.f574b[i] = it.next();
            i++;
        }
        int i6 = this.f573a;
        for (int i7 = 0; i7 < i6 && it.hasNext(); i7++) {
            this.f574b[i7] = it.next();
        }
        this.f575c = collection.size() + this.f575c;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int length;
        int i6 = this.f575c;
        if (i < 0 || i > i6) {
            throw new IndexOutOfBoundsException(a3.d.h("index: ", i, i6, ", size: "));
        }
        if (i == i6) {
            addLast(obj);
            return;
        }
        if (i == 0) {
            addFirst(obj);
            return;
        }
        m();
        c(this.f575c + 1);
        int iL = l(this.f573a + i);
        int i7 = this.f575c;
        if (i < ((i7 + 1) >> 1)) {
            if (iL == 0) {
                Object[] objArr = this.f574b;
                kotlin.jvm.internal.j.e(objArr, "<this>");
                iL = objArr.length;
            }
            int i8 = iL - 1;
            int i9 = this.f573a;
            if (i9 == 0) {
                Object[] objArr2 = this.f574b;
                kotlin.jvm.internal.j.e(objArr2, "<this>");
                length = objArr2.length - 1;
            } else {
                length = i9 - 1;
            }
            int i10 = this.f573a;
            if (i8 >= i10) {
                Object[] objArr3 = this.f574b;
                objArr3[length] = objArr3[i10];
                g.f0(objArr3, i10, objArr3, i10 + 1, i8 + 1);
            } else {
                Object[] objArr4 = this.f574b;
                g.f0(objArr4, i10 - 1, objArr4, i10, objArr4.length);
                Object[] objArr5 = this.f574b;
                objArr5[objArr5.length - 1] = objArr5[0];
                g.f0(objArr5, 0, objArr5, 1, i8 + 1);
            }
            this.f574b[i8] = obj;
            this.f573a = length;
        } else {
            int iL2 = l(this.f573a + i7);
            if (iL < iL2) {
                Object[] objArr6 = this.f574b;
                g.f0(objArr6, iL + 1, objArr6, iL, iL2);
            } else {
                Object[] objArr7 = this.f574b;
                g.f0(objArr7, 1, objArr7, 0, iL2);
                Object[] objArr8 = this.f574b;
                objArr8[0] = objArr8[objArr8.length - 1];
                g.f0(objArr8, iL + 1, objArr8, iL, objArr8.length - 1);
            }
            this.f574b[iL] = obj;
        }
        this.f575c++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection elements) {
        kotlin.jvm.internal.j.e(elements, "elements");
        int i6 = this.f575c;
        if (i < 0 || i > i6) {
            throw new IndexOutOfBoundsException(a3.d.h("index: ", i, i6, ", size: "));
        }
        if (elements.isEmpty()) {
            return false;
        }
        if (i == this.f575c) {
            return addAll(elements);
        }
        m();
        c(elements.size() + this.f575c);
        int iL = l(this.f573a + this.f575c);
        int iL2 = l(this.f573a + i);
        int size = elements.size();
        if (i >= ((this.f575c + 1) >> 1)) {
            int i7 = iL2 + size;
            if (iL2 < iL) {
                int i8 = size + iL;
                Object[] objArr = this.f574b;
                if (i8 <= objArr.length) {
                    g.f0(objArr, i7, objArr, iL2, iL);
                } else if (i7 >= objArr.length) {
                    g.f0(objArr, i7 - objArr.length, objArr, iL2, iL);
                } else {
                    int length = iL - (i8 - objArr.length);
                    g.f0(objArr, 0, objArr, length, iL);
                    Object[] objArr2 = this.f574b;
                    g.f0(objArr2, i7, objArr2, iL2, length);
                }
            } else {
                Object[] objArr3 = this.f574b;
                g.f0(objArr3, size, objArr3, 0, iL);
                Object[] objArr4 = this.f574b;
                if (i7 >= objArr4.length) {
                    g.f0(objArr4, i7 - objArr4.length, objArr4, iL2, objArr4.length);
                } else {
                    g.f0(objArr4, 0, objArr4, objArr4.length - size, objArr4.length);
                    Object[] objArr5 = this.f574b;
                    g.f0(objArr5, i7, objArr5, iL2, objArr5.length - size);
                }
            }
            a(iL2, elements);
            return true;
        }
        int i9 = this.f573a;
        int length2 = i9 - size;
        if (iL2 < i9) {
            Object[] objArr6 = this.f574b;
            g.f0(objArr6, length2, objArr6, i9, objArr6.length);
            if (size >= iL2) {
                Object[] objArr7 = this.f574b;
                g.f0(objArr7, objArr7.length - size, objArr7, 0, iL2);
            } else {
                Object[] objArr8 = this.f574b;
                g.f0(objArr8, objArr8.length - size, objArr8, 0, size);
                Object[] objArr9 = this.f574b;
                g.f0(objArr9, 0, objArr9, size, iL2);
            }
        } else if (length2 >= 0) {
            Object[] objArr10 = this.f574b;
            g.f0(objArr10, length2, objArr10, i9, iL2);
        } else {
            Object[] objArr11 = this.f574b;
            length2 += objArr11.length;
            int i10 = iL2 - i9;
            int length3 = objArr11.length - length2;
            if (length3 >= i10) {
                g.f0(objArr11, length2, objArr11, i9, iL2);
            } else {
                g.f0(objArr11, length2, objArr11, i9, i9 + length3);
                Object[] objArr12 = this.f574b;
                g.f0(objArr12, 0, objArr12, this.f573a + length3, iL2);
            }
        }
        this.f573a = length2;
        a(h(iL2 - size), elements);
        return true;
    }

    public final void addFirst(Object obj) {
        m();
        c(this.f575c + 1);
        int length = this.f573a;
        if (length == 0) {
            Object[] objArr = this.f574b;
            kotlin.jvm.internal.j.e(objArr, "<this>");
            length = objArr.length;
        }
        int i = length - 1;
        this.f573a = i;
        this.f574b[i] = obj;
        this.f575c++;
    }

    public final void addLast(Object obj) {
        m();
        c(this.f575c + 1);
        this.f574b[l(this.f573a + this.f575c)] = obj;
        this.f575c++;
    }

    public final void c(int i) {
        if (i < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f574b;
        if (i <= objArr.length) {
            return;
        }
        if (objArr == f572d) {
            if (i < 10) {
                i = 10;
            }
            this.f574b = new Object[i];
            return;
        }
        int length = objArr.length;
        int i6 = length + (length >> 1);
        if (i6 - i < 0) {
            i6 = i;
        }
        if (i6 - 2147483639 > 0) {
            i6 = i > 2147483639 ? com.google.android.gms.common.api.f.API_PRIORITY_OTHER : 2147483639;
        }
        Object[] objArr2 = new Object[i6];
        g.f0(objArr, 0, objArr2, this.f573a, objArr.length);
        Object[] objArr3 = this.f574b;
        int length2 = objArr3.length;
        int i7 = this.f573a;
        g.f0(objArr3, length2 - i7, objArr2, 0, i7);
        this.f573a = 0;
        this.f574b = objArr2;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        if (!isEmpty()) {
            m();
            k(this.f573a, l(this.f573a + this.f575c));
        }
        this.f573a = 0;
        this.f575c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final int f(int i) {
        kotlin.jvm.internal.j.e(this.f574b, "<this>");
        if (i == r0.length - 1) {
            return 0;
        }
        return i + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int i6 = this.f575c;
        if (i < 0 || i >= i6) {
            throw new IndexOutOfBoundsException(a3.d.h("index: ", i, i6, ", size: "));
        }
        return this.f574b[l(this.f573a + i)];
    }

    public final int h(int i) {
        return i < 0 ? i + this.f574b.length : i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i;
        int iL = l(this.f573a + this.f575c);
        int length = this.f573a;
        if (length < iL) {
            while (length < iL) {
                if (kotlin.jvm.internal.j.a(obj, this.f574b[length])) {
                    i = this.f573a;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iL) {
            return -1;
        }
        int length2 = this.f574b.length;
        while (true) {
            if (length >= length2) {
                for (int i6 = 0; i6 < iL; i6++) {
                    if (kotlin.jvm.internal.j.a(obj, this.f574b[i6])) {
                        length = i6 + this.f574b.length;
                        i = this.f573a;
                    }
                }
                return -1;
            }
            if (kotlin.jvm.internal.j.a(obj, this.f574b[length])) {
                i = this.f573a;
                break;
            }
            length++;
        }
        return length - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.f575c == 0;
    }

    public final void k(int i, int i6) {
        if (i < i6) {
            g.g0(this.f574b, i, i6);
            return;
        }
        Object[] objArr = this.f574b;
        g.g0(objArr, i, objArr.length);
        g.g0(this.f574b, 0, i6);
    }

    public final int l(int i) {
        Object[] objArr = this.f574b;
        return i >= objArr.length ? i - objArr.length : i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int i;
        int iL = l(this.f573a + this.f575c);
        int i6 = this.f573a;
        if (i6 < iL) {
            length = iL - 1;
            if (i6 <= length) {
                while (!kotlin.jvm.internal.j.a(obj, this.f574b[length])) {
                    if (length != i6) {
                        length--;
                    }
                }
                i = this.f573a;
                return length - i;
            }
            return -1;
        }
        if (i6 > iL) {
            int i7 = iL - 1;
            while (true) {
                if (-1 >= i7) {
                    Object[] objArr = this.f574b;
                    kotlin.jvm.internal.j.e(objArr, "<this>");
                    length = objArr.length - 1;
                    int i8 = this.f573a;
                    if (i8 <= length) {
                        while (!kotlin.jvm.internal.j.a(obj, this.f574b[length])) {
                            if (length != i8) {
                                length--;
                            }
                        }
                        i = this.f573a;
                    }
                } else {
                    if (kotlin.jvm.internal.j.a(obj, this.f574b[i7])) {
                        length = i7 + this.f574b.length;
                        i = this.f573a;
                        break;
                    }
                    i7--;
                }
            }
        }
        return -1;
    }

    public final void m() {
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        int i6 = this.f575c;
        if (i < 0 || i >= i6) {
            throw new IndexOutOfBoundsException(a3.d.h("index: ", i, i6, ", size: "));
        }
        if (i == i.b0(this)) {
            return removeLast();
        }
        if (i == 0) {
            return removeFirst();
        }
        m();
        int iL = l(this.f573a + i);
        Object[] objArr = this.f574b;
        Object obj = objArr[iL];
        if (i < (this.f575c >> 1)) {
            int i7 = this.f573a;
            if (iL >= i7) {
                g.f0(objArr, i7 + 1, objArr, i7, iL);
            } else {
                g.f0(objArr, 1, objArr, 0, iL);
                Object[] objArr2 = this.f574b;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i8 = this.f573a;
                g.f0(objArr2, i8 + 1, objArr2, i8, objArr2.length - 1);
            }
            Object[] objArr3 = this.f574b;
            int i9 = this.f573a;
            objArr3[i9] = null;
            this.f573a = f(i9);
        } else {
            int iL2 = l(i.b0(this) + this.f573a);
            if (iL <= iL2) {
                Object[] objArr4 = this.f574b;
                g.f0(objArr4, iL, objArr4, iL + 1, iL2 + 1);
            } else {
                Object[] objArr5 = this.f574b;
                g.f0(objArr5, iL, objArr5, iL + 1, objArr5.length);
                Object[] objArr6 = this.f574b;
                objArr6[objArr6.length - 1] = objArr6[0];
                g.f0(objArr6, 0, objArr6, 1, iL2 + 1);
            }
            this.f574b[iL2] = null;
        }
        this.f575c--;
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection elements) {
        int iL;
        kotlin.jvm.internal.j.e(elements, "elements");
        boolean z6 = false;
        z6 = false;
        z6 = false;
        if (!isEmpty() && this.f574b.length != 0) {
            int iL2 = l(this.f573a + this.f575c);
            int i = this.f573a;
            if (i < iL2) {
                iL = i;
                while (i < iL2) {
                    Object obj = this.f574b[i];
                    if (elements.contains(obj)) {
                        z6 = true;
                    } else {
                        this.f574b[iL] = obj;
                        iL++;
                    }
                    i++;
                }
                g.g0(this.f574b, iL, iL2);
            } else {
                int length = this.f574b.length;
                boolean z7 = false;
                int i6 = i;
                while (i < length) {
                    Object[] objArr = this.f574b;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (elements.contains(obj2)) {
                        z7 = true;
                    } else {
                        this.f574b[i6] = obj2;
                        i6++;
                    }
                    i++;
                }
                iL = l(i6);
                for (int i7 = 0; i7 < iL2; i7++) {
                    Object[] objArr2 = this.f574b;
                    Object obj3 = objArr2[i7];
                    objArr2[i7] = null;
                    if (elements.contains(obj3)) {
                        z7 = true;
                    } else {
                        this.f574b[iL] = obj3;
                        iL = f(iL);
                    }
                }
                z6 = z7;
            }
            if (z6) {
                m();
                this.f575c = h(iL - this.f573a);
            }
        }
        return z6;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        m();
        Object[] objArr = this.f574b;
        int i = this.f573a;
        Object obj = objArr[i];
        objArr[i] = null;
        this.f573a = f(i);
        this.f575c--;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        m();
        int iL = l(i.b0(this) + this.f573a);
        Object[] objArr = this.f574b;
        Object obj = objArr[iL];
        objArr[iL] = null;
        this.f575c--;
        return obj;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i6) {
        D.n(i, i6, this.f575c);
        int i7 = i6 - i;
        if (i7 == 0) {
            return;
        }
        if (i7 == this.f575c) {
            clear();
            return;
        }
        if (i7 == 1) {
            remove(i);
            return;
        }
        m();
        if (i < this.f575c - i6) {
            int iL = l((i - 1) + this.f573a);
            int iL2 = l((i6 - 1) + this.f573a);
            while (i > 0) {
                int i8 = iL + 1;
                int iMin = Math.min(i, Math.min(i8, iL2 + 1));
                Object[] objArr = this.f574b;
                int i9 = iL2 - iMin;
                int i10 = iL - iMin;
                g.f0(objArr, i9 + 1, objArr, i10 + 1, i8);
                iL = h(i10);
                iL2 = h(i9);
                i -= iMin;
            }
            int iL3 = l(this.f573a + i7);
            k(this.f573a, iL3);
            this.f573a = iL3;
        } else {
            int iL4 = l(this.f573a + i6);
            int iL5 = l(this.f573a + i);
            int i11 = this.f575c;
            while (true) {
                i11 -= i6;
                if (i11 <= 0) {
                    break;
                }
                Object[] objArr2 = this.f574b;
                i6 = Math.min(i11, Math.min(objArr2.length - iL4, objArr2.length - iL5));
                Object[] objArr3 = this.f574b;
                int i12 = iL4 + i6;
                g.f0(objArr3, iL5, objArr3, iL4, i12);
                iL4 = l(i12);
                iL5 = l(iL5 + i6);
            }
            int iL6 = l(this.f573a + this.f575c);
            k(h(iL6 - i7), iL6);
        }
        this.f575c -= i7;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection elements) {
        int iL;
        kotlin.jvm.internal.j.e(elements, "elements");
        boolean z6 = false;
        z6 = false;
        z6 = false;
        if (!isEmpty() && this.f574b.length != 0) {
            int iL2 = l(this.f573a + this.f575c);
            int i = this.f573a;
            if (i < iL2) {
                iL = i;
                while (i < iL2) {
                    Object obj = this.f574b[i];
                    if (elements.contains(obj)) {
                        this.f574b[iL] = obj;
                        iL++;
                    } else {
                        z6 = true;
                    }
                    i++;
                }
                g.g0(this.f574b, iL, iL2);
            } else {
                int length = this.f574b.length;
                boolean z7 = false;
                int i6 = i;
                while (i < length) {
                    Object[] objArr = this.f574b;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (elements.contains(obj2)) {
                        this.f574b[i6] = obj2;
                        i6++;
                    } else {
                        z7 = true;
                    }
                    i++;
                }
                iL = l(i6);
                for (int i7 = 0; i7 < iL2; i7++) {
                    Object[] objArr2 = this.f574b;
                    Object obj3 = objArr2[i7];
                    objArr2[i7] = null;
                    if (elements.contains(obj3)) {
                        this.f574b[iL] = obj3;
                        iL = f(iL);
                    } else {
                        z7 = true;
                    }
                }
                z6 = z7;
            }
            if (z6) {
                m();
                this.f575c = h(iL - this.f573a);
            }
        }
        return z6;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        int i6 = this.f575c;
        if (i < 0 || i >= i6) {
            throw new IndexOutOfBoundsException(a3.d.h("index: ", i, i6, ", size: "));
        }
        int iL = l(this.f573a + i);
        Object[] objArr = this.f574b;
        Object obj2 = objArr[iL];
        objArr[iL] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f575c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[this.f575c]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] array) {
        kotlin.jvm.internal.j.e(array, "array");
        int length = array.length;
        int i = this.f575c;
        if (length < i) {
            Object objNewInstance = Array.newInstance(array.getClass().getComponentType(), i);
            kotlin.jvm.internal.j.c(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
            array = (Object[]) objNewInstance;
        }
        int iL = l(this.f573a + this.f575c);
        int i6 = this.f573a;
        if (i6 < iL) {
            g.f0(this.f574b, 0, array, i6, iL);
        } else if (!isEmpty()) {
            Object[] objArr = this.f574b;
            g.f0(objArr, 0, array, this.f573a, objArr.length);
            Object[] objArr2 = this.f574b;
            g.f0(objArr2, objArr2.length - this.f573a, array, 0, iL);
        }
        int i7 = this.f575c;
        if (i7 < array.length) {
            array[i7] = null;
        }
        return array;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection elements) {
        kotlin.jvm.internal.j.e(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        m();
        c(elements.size() + this.f575c);
        a(l(this.f573a + this.f575c), elements);
        return true;
    }
}
