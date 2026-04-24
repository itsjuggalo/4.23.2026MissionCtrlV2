package p5;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: p5.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2587i extends AbstractC2584f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f22385d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object[] f22386e = new Object[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f22387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f22388b = f22386e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f22389c;

    /* JADX INFO: renamed from: p5.i$a */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    private final void n(int i8) {
        if (i8 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f22388b;
        if (i8 <= objArr.length) {
            return;
        }
        if (objArr == f22386e) {
            this.f22388b = new Object[H5.i.b(i8, 10)];
        } else {
            f(AbstractC2582d.f22376a.e(objArr.length, i8));
        }
    }

    public final int C(int i8) {
        if (i8 == AbstractC2592n.G(this.f22388b)) {
            return 0;
        }
        return i8 + 1;
    }

    public final int F(int i8) {
        return i8 < 0 ? i8 + this.f22388b.length : i8;
    }

    public final void H(int i8, int i9) {
        Object[] objArr = this.f22388b;
        if (i8 < i9) {
            AbstractC2590l.n(objArr, null, i8, i9);
        } else {
            AbstractC2590l.n(objArr, null, i8, objArr.length);
            AbstractC2590l.n(this.f22388b, null, 0, i9);
        }
    }

    public final int I(int i8) {
        Object[] objArr = this.f22388b;
        return i8 >= objArr.length ? i8 - objArr.length : i8;
    }

    public final void J() {
        ((AbstractList) this).modCount++;
    }

    public final Object K() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    public final Object L() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    public final void M(int i8, int i9) {
        int I7 = I(this.f22387a + (i8 - 1));
        int I8 = I(this.f22387a + (i9 - 1));
        while (i8 > 0) {
            int i10 = I7 + 1;
            int iMin = Math.min(i8, Math.min(i10, I8 + 1));
            Object[] objArr = this.f22388b;
            int i11 = I8 - iMin;
            int i12 = I7 - iMin;
            AbstractC2590l.h(objArr, objArr, i11 + 1, i12 + 1, i10);
            I7 = F(i12);
            I8 = F(i11);
            i8 -= iMin;
        }
    }

    public final void N(int i8, int i9) {
        int I7 = I(this.f22387a + i9);
        int I8 = I(this.f22387a + i8);
        int size = size();
        while (true) {
            size -= i9;
            if (size <= 0) {
                return;
            }
            Object[] objArr = this.f22388b;
            i9 = Math.min(size, Math.min(objArr.length - I7, objArr.length - I8));
            Object[] objArr2 = this.f22388b;
            int i10 = I7 + i9;
            AbstractC2590l.h(objArr2, objArr2, I8, I7, i10);
            I7 = I(i10);
            I8 = I(I8 + i9);
        }
    }

    @Override // p5.AbstractC2584f
    public int a() {
        return this.f22389c;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i8, Object obj) {
        AbstractC2582d.f22376a.c(i8, size());
        if (i8 == size()) {
            addLast(obj);
            return;
        }
        if (i8 == 0) {
            addFirst(obj);
            return;
        }
        J();
        n(size() + 1);
        int I7 = I(this.f22387a + i8);
        if (i8 < ((size() + 1) >> 1)) {
            int iH = h(I7);
            int iH2 = h(this.f22387a);
            int i9 = this.f22387a;
            if (iH >= i9) {
                Object[] objArr = this.f22388b;
                objArr[iH2] = objArr[i9];
                AbstractC2590l.h(objArr, objArr, i9, i9 + 1, iH + 1);
            } else {
                Object[] objArr2 = this.f22388b;
                AbstractC2590l.h(objArr2, objArr2, i9 - 1, i9, objArr2.length);
                Object[] objArr3 = this.f22388b;
                objArr3[objArr3.length - 1] = objArr3[0];
                AbstractC2590l.h(objArr3, objArr3, 0, 1, iH + 1);
            }
            this.f22388b[iH] = obj;
            this.f22387a = iH2;
        } else {
            int I8 = I(this.f22387a + size());
            Object[] objArr4 = this.f22388b;
            if (I7 < I8) {
                AbstractC2590l.h(objArr4, objArr4, I7 + 1, I7, I8);
            } else {
                AbstractC2590l.h(objArr4, objArr4, 1, 0, I8);
                Object[] objArr5 = this.f22388b;
                objArr5[0] = objArr5[objArr5.length - 1];
                AbstractC2590l.h(objArr5, objArr5, I7 + 1, I7, objArr5.length - 1);
            }
            this.f22388b[I7] = obj;
        }
        this.f22389c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i8, Collection elements) {
        AbstractC2304t.f(elements, "elements");
        AbstractC2582d.f22376a.c(i8, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (i8 == size()) {
            return addAll(elements);
        }
        J();
        n(size() + elements.size());
        int I7 = I(this.f22387a + size());
        int I8 = I(this.f22387a + i8);
        int size = elements.size();
        if (i8 < ((size() + 1) >> 1)) {
            int i9 = this.f22387a;
            int length = i9 - size;
            if (I8 < i9) {
                Object[] objArr = this.f22388b;
                AbstractC2590l.h(objArr, objArr, length, i9, objArr.length);
                Object[] objArr2 = this.f22388b;
                if (size >= I8) {
                    AbstractC2590l.h(objArr2, objArr2, objArr2.length - size, 0, I8);
                } else {
                    AbstractC2590l.h(objArr2, objArr2, objArr2.length - size, 0, size);
                    Object[] objArr3 = this.f22388b;
                    AbstractC2590l.h(objArr3, objArr3, 0, size, I8);
                }
            } else if (length >= 0) {
                Object[] objArr4 = this.f22388b;
                AbstractC2590l.h(objArr4, objArr4, length, i9, I8);
            } else {
                Object[] objArr5 = this.f22388b;
                length += objArr5.length;
                int i10 = I8 - i9;
                int length2 = objArr5.length - length;
                if (length2 >= i10) {
                    AbstractC2590l.h(objArr5, objArr5, length, i9, I8);
                } else {
                    AbstractC2590l.h(objArr5, objArr5, length, i9, i9 + length2);
                    Object[] objArr6 = this.f22388b;
                    AbstractC2590l.h(objArr6, objArr6, 0, this.f22387a + length2, I8);
                }
            }
            this.f22387a = length;
            e(F(I8 - size), elements);
        } else {
            int length3 = I8 + size;
            if (I8 < I7) {
                int i11 = size + I7;
                Object[] objArr7 = this.f22388b;
                if (i11 <= objArr7.length) {
                    AbstractC2590l.h(objArr7, objArr7, length3, I8, I7);
                } else if (length3 >= objArr7.length) {
                    length3 -= objArr7.length;
                    AbstractC2590l.h(objArr7, objArr7, length3, I8, I7);
                } else {
                    int length4 = I7 - (i11 - objArr7.length);
                    AbstractC2590l.h(objArr7, objArr7, 0, length4, I7);
                    Object[] objArr8 = this.f22388b;
                    AbstractC2590l.h(objArr8, objArr8, length3, I8, length4);
                }
            } else {
                Object[] objArr9 = this.f22388b;
                AbstractC2590l.h(objArr9, objArr9, size, 0, I7);
                Object[] objArr10 = this.f22388b;
                if (length3 >= objArr10.length) {
                    AbstractC2590l.h(objArr10, objArr10, length3 - objArr10.length, I8, objArr10.length);
                } else {
                    AbstractC2590l.h(objArr10, objArr10, 0, objArr10.length - size, objArr10.length);
                    Object[] objArr11 = this.f22388b;
                    AbstractC2590l.h(objArr11, objArr11, length3, I8, objArr11.length - size);
                }
            }
            e(I8, elements);
        }
        return true;
    }

    public final void addFirst(Object obj) {
        J();
        n(size() + 1);
        int iH = h(this.f22387a);
        this.f22387a = iH;
        this.f22388b[iH] = obj;
        this.f22389c = size() + 1;
    }

    public final void addLast(Object obj) {
        J();
        n(size() + 1);
        this.f22388b[I(this.f22387a + size())] = obj;
        this.f22389c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        if (!isEmpty()) {
            J();
            H(this.f22387a, I(this.f22387a + size()));
        }
        this.f22387a = 0;
        this.f22389c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // p5.AbstractC2584f
    public Object d(int i8) {
        AbstractC2582d.f22376a.b(i8, size());
        if (i8 == AbstractC2595q.k(this)) {
            return removeLast();
        }
        if (i8 == 0) {
            return removeFirst();
        }
        J();
        int I7 = I(this.f22387a + i8);
        Object obj = this.f22388b[I7];
        if (i8 < (size() >> 1)) {
            int i9 = this.f22387a;
            if (I7 >= i9) {
                Object[] objArr = this.f22388b;
                AbstractC2590l.h(objArr, objArr, i9 + 1, i9, I7);
            } else {
                Object[] objArr2 = this.f22388b;
                AbstractC2590l.h(objArr2, objArr2, 1, 0, I7);
                Object[] objArr3 = this.f22388b;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i10 = this.f22387a;
                AbstractC2590l.h(objArr3, objArr3, i10 + 1, i10, objArr3.length - 1);
            }
            Object[] objArr4 = this.f22388b;
            int i11 = this.f22387a;
            objArr4[i11] = null;
            this.f22387a = C(i11);
        } else {
            int I8 = I(this.f22387a + AbstractC2595q.k(this));
            Object[] objArr5 = this.f22388b;
            if (I7 <= I8) {
                AbstractC2590l.h(objArr5, objArr5, I7, I7 + 1, I8 + 1);
            } else {
                AbstractC2590l.h(objArr5, objArr5, I7, I7 + 1, objArr5.length);
                Object[] objArr6 = this.f22388b;
                objArr6[objArr6.length - 1] = objArr6[0];
                AbstractC2590l.h(objArr6, objArr6, 0, 1, I8 + 1);
            }
            this.f22388b[I8] = null;
        }
        this.f22389c = size() - 1;
        return obj;
    }

    public final void e(int i8, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f22388b.length;
        while (i8 < length && it.hasNext()) {
            this.f22388b[i8] = it.next();
            i8++;
        }
        int i9 = this.f22387a;
        for (int i10 = 0; i10 < i9 && it.hasNext(); i10++) {
            this.f22388b[i10] = it.next();
        }
        this.f22389c = size() + collection.size();
    }

    public final void f(int i8) {
        Object[] objArr = new Object[i8];
        Object[] objArr2 = this.f22388b;
        AbstractC2590l.h(objArr2, objArr, 0, this.f22387a, objArr2.length);
        Object[] objArr3 = this.f22388b;
        int length = objArr3.length;
        int i9 = this.f22387a;
        AbstractC2590l.h(objArr3, objArr, length - i9, 0, i9);
        this.f22387a = 0;
        this.f22388b = objArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i8) {
        AbstractC2582d.f22376a.b(i8, size());
        return this.f22388b[I(this.f22387a + i8)];
    }

    public final int h(int i8) {
        return i8 == 0 ? AbstractC2592n.G(this.f22388b) : i8 - 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int I7 = I(this.f22387a + size());
        int length = this.f22387a;
        if (length < I7) {
            while (length < I7) {
                if (!AbstractC2304t.b(obj, this.f22388b[length])) {
                    length++;
                }
            }
            return -1;
        }
        if (length < I7) {
            return -1;
        }
        int length2 = this.f22388b.length;
        while (true) {
            if (length >= length2) {
                for (int i8 = 0; i8 < I7; i8++) {
                    if (AbstractC2304t.b(obj, this.f22388b[i8])) {
                        length = i8 + this.f22388b.length;
                    }
                }
                return -1;
            }
            if (AbstractC2304t.b(obj, this.f22388b[length])) {
                break;
            }
            length++;
        }
        return length - this.f22387a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int iG;
        int I7 = I(this.f22387a + size());
        int i8 = this.f22387a;
        if (i8 < I7) {
            iG = I7 - 1;
            if (i8 <= iG) {
                while (!AbstractC2304t.b(obj, this.f22388b[iG])) {
                    if (iG != i8) {
                        iG--;
                    }
                }
                return iG - this.f22387a;
            }
            return -1;
        }
        if (i8 > I7) {
            int i9 = I7 - 1;
            while (true) {
                if (-1 >= i9) {
                    iG = AbstractC2592n.G(this.f22388b);
                    int i10 = this.f22387a;
                    if (i10 <= iG) {
                        while (!AbstractC2304t.b(obj, this.f22388b[iG])) {
                            if (iG != i10) {
                                iG--;
                            }
                        }
                    }
                } else {
                    if (AbstractC2304t.b(obj, this.f22388b[i9])) {
                        iG = i9 + this.f22388b.length;
                        break;
                    }
                    i9--;
                }
            }
        }
        return -1;
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
        int I7;
        AbstractC2304t.f(elements, "elements");
        boolean z7 = false;
        z7 = false;
        z7 = false;
        if (!isEmpty() && this.f22388b.length != 0) {
            int I8 = I(this.f22387a + size());
            int i8 = this.f22387a;
            if (i8 < I8) {
                I7 = i8;
                while (i8 < I8) {
                    Object obj = this.f22388b[i8];
                    if (!elements.contains(obj)) {
                        this.f22388b[I7] = obj;
                        I7++;
                    } else {
                        z7 = true;
                    }
                    i8++;
                }
                AbstractC2590l.n(this.f22388b, null, I7, I8);
            } else {
                int length = this.f22388b.length;
                boolean z8 = false;
                int i9 = i8;
                while (i8 < length) {
                    Object[] objArr = this.f22388b;
                    Object obj2 = objArr[i8];
                    objArr[i8] = null;
                    if (!elements.contains(obj2)) {
                        this.f22388b[i9] = obj2;
                        i9++;
                    } else {
                        z8 = true;
                    }
                    i8++;
                }
                I7 = I(i9);
                for (int i10 = 0; i10 < I8; i10++) {
                    Object[] objArr2 = this.f22388b;
                    Object obj3 = objArr2[i10];
                    objArr2[i10] = null;
                    if (!elements.contains(obj3)) {
                        this.f22388b[I7] = obj3;
                        I7 = C(I7);
                    } else {
                        z8 = true;
                    }
                }
                z7 = z8;
            }
            if (z7) {
                J();
                this.f22389c = F(I7 - this.f22387a);
            }
        }
        return z7;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        J();
        Object[] objArr = this.f22388b;
        int i8 = this.f22387a;
        Object obj = objArr[i8];
        objArr[i8] = null;
        this.f22387a = C(i8);
        this.f22389c = size() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        J();
        int I7 = I(this.f22387a + AbstractC2595q.k(this));
        Object[] objArr = this.f22388b;
        Object obj = objArr[I7];
        objArr[I7] = null;
        this.f22389c = size() - 1;
        return obj;
    }

    @Override // java.util.AbstractList
    public void removeRange(int i8, int i9) {
        AbstractC2582d.f22376a.d(i8, i9, size());
        int i10 = i9 - i8;
        if (i10 == 0) {
            return;
        }
        if (i10 == size()) {
            clear();
            return;
        }
        if (i10 == 1) {
            remove(i8);
            return;
        }
        J();
        if (i8 < size() - i9) {
            M(i8, i9);
            int I7 = I(this.f22387a + i10);
            H(this.f22387a, I7);
            this.f22387a = I7;
        } else {
            N(i8, i9);
            int I8 = I(this.f22387a + size());
            H(F(I8 - i10), I8);
        }
        this.f22389c = size() - i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection elements) {
        int I7;
        AbstractC2304t.f(elements, "elements");
        boolean z7 = false;
        z7 = false;
        z7 = false;
        if (!isEmpty() && this.f22388b.length != 0) {
            int I8 = I(this.f22387a + size());
            int i8 = this.f22387a;
            if (i8 < I8) {
                I7 = i8;
                while (i8 < I8) {
                    Object obj = this.f22388b[i8];
                    if (elements.contains(obj)) {
                        this.f22388b[I7] = obj;
                        I7++;
                    } else {
                        z7 = true;
                    }
                    i8++;
                }
                AbstractC2590l.n(this.f22388b, null, I7, I8);
            } else {
                int length = this.f22388b.length;
                boolean z8 = false;
                int i9 = i8;
                while (i8 < length) {
                    Object[] objArr = this.f22388b;
                    Object obj2 = objArr[i8];
                    objArr[i8] = null;
                    if (elements.contains(obj2)) {
                        this.f22388b[i9] = obj2;
                        i9++;
                    } else {
                        z8 = true;
                    }
                    i8++;
                }
                I7 = I(i9);
                for (int i10 = 0; i10 < I8; i10++) {
                    Object[] objArr2 = this.f22388b;
                    Object obj3 = objArr2[i10];
                    objArr2[i10] = null;
                    if (elements.contains(obj3)) {
                        this.f22388b[I7] = obj3;
                        I7 = C(I7);
                    } else {
                        z8 = true;
                    }
                }
                z7 = z8;
            }
            if (z7) {
                J();
                this.f22389c = F(I7 - this.f22387a);
            }
        }
        return z7;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i8, Object obj) {
        AbstractC2582d.f22376a.b(i8, size());
        int I7 = I(this.f22387a + i8);
        Object[] objArr = this.f22388b;
        Object obj2 = objArr[I7];
        objArr[I7] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection elements) {
        AbstractC2304t.f(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        J();
        n(size() + elements.size());
        e(I(this.f22387a + size()), elements);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray(Object[] array) {
        AbstractC2304t.f(array, "array");
        if (array.length < size()) {
            array = AbstractC2588j.a(array, size());
        }
        int I7 = I(this.f22387a + size());
        int i8 = this.f22387a;
        if (i8 < I7) {
            AbstractC2590l.k(this.f22388b, array, 0, i8, I7, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr = this.f22388b;
            AbstractC2590l.h(objArr, array, 0, this.f22387a, objArr.length);
            Object[] objArr2 = this.f22388b;
            AbstractC2590l.h(objArr2, array, objArr2.length - this.f22387a, 0, I7);
        }
        return AbstractC2594p.f(size(), array);
    }
}
