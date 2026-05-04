package ed;

import dd.l;
import dd.q;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends dd.f implements List, RandomAccess, Serializable, qd.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0164b f8631d = new C0164b(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f8632e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f8633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8635c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends dd.f implements List, RandomAccess, Serializable, qd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object[] f8636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8637b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8638c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final a f8639d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final b f8640e;

        /* JADX INFO: renamed from: ed.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0163a implements ListIterator, qd.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final a f8641a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f8642b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f8643c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f8644d;

            public C0163a(a list, int i10) {
                t.f(list, "list");
                this.f8641a = list;
                this.f8642b = i10;
                this.f8643c = -1;
                this.f8644d = ((AbstractList) list).modCount;
            }

            private final void c() {
                if (((AbstractList) this.f8641a.f8640e).modCount != this.f8644d) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.ListIterator
            public void add(Object obj) {
                c();
                a aVar = this.f8641a;
                int i10 = this.f8642b;
                this.f8642b = i10 + 1;
                aVar.add(i10, obj);
                this.f8643c = -1;
                this.f8644d = ((AbstractList) this.f8641a).modCount;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.f8642b < this.f8641a.f8638c;
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.f8642b > 0;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public Object next() {
                c();
                if (this.f8642b >= this.f8641a.f8638c) {
                    throw new NoSuchElementException();
                }
                int i10 = this.f8642b;
                this.f8642b = i10 + 1;
                this.f8643c = i10;
                return this.f8641a.f8636a[this.f8641a.f8637b + this.f8643c];
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.f8642b;
            }

            @Override // java.util.ListIterator
            public Object previous() {
                c();
                int i10 = this.f8642b;
                if (i10 <= 0) {
                    throw new NoSuchElementException();
                }
                int i11 = i10 - 1;
                this.f8642b = i11;
                this.f8643c = i11;
                return this.f8641a.f8636a[this.f8641a.f8637b + this.f8643c];
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.f8642b - 1;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                c();
                int i10 = this.f8643c;
                if (i10 == -1) {
                    throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
                }
                this.f8641a.c(i10);
                this.f8642b = this.f8643c;
                this.f8643c = -1;
                this.f8644d = ((AbstractList) this.f8641a).modCount;
            }

            @Override // java.util.ListIterator
            public void set(Object obj) {
                c();
                int i10 = this.f8643c;
                if (i10 == -1) {
                    throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
                }
                this.f8641a.set(i10, obj);
            }
        }

        public a(Object[] backing, int i10, int i11, a aVar, b root) {
            t.f(backing, "backing");
            t.f(root, "root");
            this.f8636a = backing;
            this.f8637b = i10;
            this.f8638c = i11;
            this.f8639d = aVar;
            this.f8640e = root;
            ((AbstractList) this).modCount = ((AbstractList) root).modCount;
        }

        private final void A() {
            ((AbstractList) this).modCount++;
        }

        public final Object G(int i10) {
            A();
            a aVar = this.f8639d;
            this.f8638c--;
            return aVar != null ? aVar.G(i10) : this.f8640e.U(i10);
        }

        public final void K(int i10, int i11) {
            if (i11 > 0) {
                A();
            }
            a aVar = this.f8639d;
            if (aVar != null) {
                aVar.K(i10, i11);
            } else {
                this.f8640e.V(i10, i11);
            }
            this.f8638c -= i11;
        }

        public final int L(int i10, int i11, Collection collection, boolean z10) {
            a aVar = this.f8639d;
            int iL = aVar != null ? aVar.L(i10, i11, collection, z10) : this.f8640e.W(i10, i11, collection, z10);
            if (iL > 0) {
                A();
            }
            this.f8638c -= iL;
            return iL;
        }

        @Override // dd.f
        public int a() {
            u();
            return this.f8638c;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(Object obj) {
            v();
            u();
            s(this.f8637b + this.f8638c, obj);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean addAll(Collection elements) {
            t.f(elements, "elements");
            v();
            u();
            int size = elements.size();
            r(this.f8637b + this.f8638c, elements, size);
            return size > 0;
        }

        @Override // dd.f
        public Object c(int i10) {
            v();
            u();
            dd.d.f7994a.b(i10, this.f8638c);
            return G(this.f8637b + i10);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            v();
            u();
            K(this.f8637b, this.f8638c);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            u();
            if (obj != this) {
                return (obj instanceof List) && w((List) obj);
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i10) {
            u();
            dd.d.f7994a.b(i10, this.f8638c);
            return this.f8636a[this.f8637b + i10];
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            u();
            return ed.c.i(this.f8636a, this.f8637b, this.f8638c);
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            u();
            for (int i10 = 0; i10 < this.f8638c; i10++) {
                if (t.b(this.f8636a[this.f8637b + i10], obj)) {
                    return i10;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            u();
            return this.f8638c == 0;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator iterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            u();
            for (int i10 = this.f8638c - 1; i10 >= 0; i10--) {
                if (t.b(this.f8636a[this.f8637b + i10], obj)) {
                    return i10;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator listIterator() {
            return listIterator(0);
        }

        public final void r(int i10, Collection collection, int i11) {
            A();
            a aVar = this.f8639d;
            if (aVar != null) {
                aVar.r(i10, collection, i11);
            } else {
                this.f8640e.w(i10, collection, i11);
            }
            this.f8636a = this.f8640e.f8633a;
            this.f8638c += i11;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean remove(Object obj) {
            v();
            u();
            int iIndexOf = indexOf(obj);
            if (iIndexOf >= 0) {
                c(iIndexOf);
            }
            return iIndexOf >= 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean removeAll(Collection elements) {
            t.f(elements, "elements");
            v();
            u();
            return L(this.f8637b, this.f8638c, elements, false) > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean retainAll(Collection elements) {
            t.f(elements, "elements");
            v();
            u();
            return L(this.f8637b, this.f8638c, elements, true) > 0;
        }

        public final void s(int i10, Object obj) {
            A();
            a aVar = this.f8639d;
            if (aVar != null) {
                aVar.s(i10, obj);
            } else {
                this.f8640e.y(i10, obj);
            }
            this.f8636a = this.f8640e.f8633a;
            this.f8638c++;
        }

        @Override // java.util.AbstractList, java.util.List
        public Object set(int i10, Object obj) {
            v();
            u();
            dd.d.f7994a.b(i10, this.f8638c);
            Object[] objArr = this.f8636a;
            int i11 = this.f8637b;
            Object obj2 = objArr[i11 + i10];
            objArr[i11 + i10] = obj;
            return obj2;
        }

        @Override // java.util.AbstractList, java.util.List
        public List subList(int i10, int i11) {
            dd.d.f7994a.d(i10, i11, this.f8638c);
            return new a(this.f8636a, this.f8637b + i10, i11 - i10, this, this.f8640e);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public Object[] toArray(Object[] array) {
            t.f(array, "array");
            u();
            int length = array.length;
            int i10 = this.f8638c;
            if (length >= i10) {
                Object[] objArr = this.f8636a;
                int i11 = this.f8637b;
                l.h(objArr, array, 0, i11, i10 + i11);
                return q.g(this.f8638c, array);
            }
            Object[] objArr2 = this.f8636a;
            int i12 = this.f8637b;
            Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr2, i12, i10 + i12, array.getClass());
            t.e(objArrCopyOfRange, "copyOfRange(...)");
            return objArrCopyOfRange;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            u();
            return ed.c.j(this.f8636a, this.f8637b, this.f8638c, this);
        }

        public final void u() {
            if (((AbstractList) this.f8640e).modCount != ((AbstractList) this).modCount) {
                throw new ConcurrentModificationException();
            }
        }

        public final void v() {
            if (y()) {
                throw new UnsupportedOperationException();
            }
        }

        public final boolean w(List list) {
            return ed.c.h(this.f8636a, this.f8637b, this.f8638c, list);
        }

        public final boolean y() {
            return this.f8640e.f8635c;
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator listIterator(int i10) {
            u();
            dd.d.f7994a.c(i10, this.f8638c);
            return new C0163a(this, i10);
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i10, Object obj) {
            v();
            u();
            dd.d.f7994a.c(i10, this.f8638c);
            s(this.f8637b + i10, obj);
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int i10, Collection elements) {
            t.f(elements, "elements");
            v();
            u();
            dd.d.f7994a.c(i10, this.f8638c);
            int size = elements.size();
            r(this.f8637b + i10, elements, size);
            return size > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public Object[] toArray() {
            u();
            Object[] objArr = this.f8636a;
            int i10 = this.f8637b;
            return l.m(objArr, i10, this.f8638c + i10);
        }
    }

    /* JADX INFO: renamed from: ed.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0164b {
        public /* synthetic */ C0164b(k kVar) {
            this();
        }

        public C0164b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c implements ListIterator, qd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f8645a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8646b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8647c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8648d;

        public c(b list, int i10) {
            t.f(list, "list");
            this.f8645a = list;
            this.f8646b = i10;
            this.f8647c = -1;
            this.f8648d = ((AbstractList) list).modCount;
        }

        private final void c() {
            if (((AbstractList) this.f8645a).modCount != this.f8648d) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            c();
            b bVar = this.f8645a;
            int i10 = this.f8646b;
            this.f8646b = i10 + 1;
            bVar.add(i10, obj);
            this.f8647c = -1;
            this.f8648d = ((AbstractList) this.f8645a).modCount;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f8646b < this.f8645a.f8634b;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f8646b > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            c();
            if (this.f8646b >= this.f8645a.f8634b) {
                throw new NoSuchElementException();
            }
            int i10 = this.f8646b;
            this.f8646b = i10 + 1;
            this.f8647c = i10;
            return this.f8645a.f8633a[this.f8647c];
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f8646b;
        }

        @Override // java.util.ListIterator
        public Object previous() {
            c();
            int i10 = this.f8646b;
            if (i10 <= 0) {
                throw new NoSuchElementException();
            }
            int i11 = i10 - 1;
            this.f8646b = i11;
            this.f8647c = i11;
            return this.f8645a.f8633a[this.f8647c];
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f8646b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            c();
            int i10 = this.f8647c;
            if (i10 == -1) {
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
            }
            this.f8645a.c(i10);
            this.f8646b = this.f8647c;
            this.f8647c = -1;
            this.f8648d = ((AbstractList) this.f8645a).modCount;
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            c();
            int i10 = this.f8647c;
            if (i10 == -1) {
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
            }
            this.f8645a.set(i10, obj);
        }
    }

    static {
        b bVar = new b(0);
        bVar.f8635c = true;
        f8632e = bVar;
    }

    public b(int i10) {
        this.f8633a = ed.c.d(i10);
    }

    private final void G() {
        if (this.f8635c) {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean K(List list) {
        return ed.c.h(this.f8633a, 0, this.f8634b, list);
    }

    private final void T() {
        ((AbstractList) this).modCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object U(int i10) {
        T();
        Object[] objArr = this.f8633a;
        Object obj = objArr[i10];
        l.h(objArr, objArr, i10, i10 + 1, this.f8634b);
        ed.c.f(this.f8633a, this.f8634b - 1);
        this.f8634b--;
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V(int i10, int i11) {
        if (i11 > 0) {
            T();
        }
        Object[] objArr = this.f8633a;
        l.h(objArr, objArr, i10, i10 + i11, this.f8634b);
        Object[] objArr2 = this.f8633a;
        int i12 = this.f8634b;
        ed.c.g(objArr2, i12 - i11, i12);
        this.f8634b -= i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int W(int i10, int i11, Collection collection, boolean z10) {
        int i12 = 0;
        int i13 = 0;
        while (i12 < i11) {
            int i14 = i10 + i12;
            if (collection.contains(this.f8633a[i14]) == z10) {
                Object[] objArr = this.f8633a;
                i12++;
                objArr[i13 + i10] = objArr[i14];
                i13++;
            } else {
                i12++;
            }
        }
        int i15 = i11 - i13;
        Object[] objArr2 = this.f8633a;
        l.h(objArr2, objArr2, i10 + i13, i11 + i10, this.f8634b);
        Object[] objArr3 = this.f8633a;
        int i16 = this.f8634b;
        ed.c.g(objArr3, i16 - i15, i16);
        if (i15 > 0) {
            T();
        }
        this.f8634b -= i15;
        return i15;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(int i10, Collection collection, int i11) {
        T();
        S(i10, i11);
        Iterator it = collection.iterator();
        for (int i12 = 0; i12 < i11; i12++) {
            this.f8633a[i10 + i12] = it.next();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(int i10, Object obj) {
        T();
        S(i10, 1);
        this.f8633a[i10] = obj;
    }

    public final List A() {
        G();
        this.f8635c = true;
        return this.f8634b > 0 ? this : f8632e;
    }

    public final void L(int i10) {
        if (i10 < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr = this.f8633a;
        if (i10 > objArr.length) {
            this.f8633a = ed.c.e(this.f8633a, dd.d.f7994a.e(objArr.length, i10));
        }
    }

    public final void R(int i10) {
        L(this.f8634b + i10);
    }

    public final void S(int i10, int i11) {
        R(i11);
        Object[] objArr = this.f8633a;
        l.h(objArr, objArr, i10 + i11, i10, this.f8634b);
        this.f8634b += i11;
    }

    @Override // dd.f
    public int a() {
        return this.f8634b;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        G();
        y(this.f8634b, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection elements) {
        t.f(elements, "elements");
        G();
        int size = elements.size();
        w(this.f8634b, elements, size);
        return size > 0;
    }

    @Override // dd.f
    public Object c(int i10) {
        G();
        dd.d.f7994a.b(i10, this.f8634b);
        return U(i10);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        G();
        V(0, this.f8634b);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof List) && K((List) obj);
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i10) {
        dd.d.f7994a.b(i10, this.f8634b);
        return this.f8633a[i10];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return ed.c.i(this.f8633a, 0, this.f8634b);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        for (int i10 = 0; i10 < this.f8634b; i10++) {
            if (t.b(this.f8633a[i10], obj)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this.f8634b == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        for (int i10 = this.f8634b - 1; i10 >= 0; i10--) {
            if (t.b(this.f8633a[i10], obj)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        G();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            c(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection elements) {
        t.f(elements, "elements");
        G();
        return W(0, this.f8634b, elements, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection elements) {
        t.f(elements, "elements");
        G();
        return W(0, this.f8634b, elements, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i10, Object obj) {
        G();
        dd.d.f7994a.b(i10, this.f8634b);
        Object[] objArr = this.f8633a;
        Object obj2 = objArr[i10];
        objArr[i10] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public List subList(int i10, int i11) {
        dd.d.f7994a.d(i10, i11, this.f8634b);
        return new a(this.f8633a, i10, i11 - i10, null, this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray(Object[] array) {
        t.f(array, "array");
        int length = array.length;
        int i10 = this.f8634b;
        if (length >= i10) {
            l.h(this.f8633a, array, 0, 0, i10);
            return q.g(this.f8634b, array);
        }
        Object[] objArrCopyOfRange = Arrays.copyOfRange(this.f8633a, 0, i10, array.getClass());
        t.e(objArrCopyOfRange, "copyOfRange(...)");
        return objArrCopyOfRange;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return ed.c.j(this.f8633a, 0, this.f8634b, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator(int i10) {
        dd.d.f7994a.c(i10, this.f8634b);
        return new c(this, i10);
    }

    public /* synthetic */ b(int i10, int i11, k kVar) {
        this((i11 & 1) != 0 ? 10 : i10);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i10, Object obj) {
        G();
        dd.d.f7994a.c(i10, this.f8634b);
        y(i10, obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i10, Collection elements) {
        t.f(elements, "elements");
        G();
        dd.d.f7994a.c(i10, this.f8634b);
        int size = elements.size();
        w(i10, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return l.m(this.f8633a, 0, this.f8634b);
    }
}
