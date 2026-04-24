package q5;

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
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2582d;
import p5.AbstractC2584f;
import p5.AbstractC2590l;
import p5.AbstractC2594p;

/* JADX INFO: renamed from: q5.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2635b extends AbstractC2584f implements List, RandomAccess, Serializable, C5.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0387b f22601d = new C0387b(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C2635b f22602e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f22603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f22605c;

    /* JADX INFO: renamed from: q5.b$a */
    public static final class a extends AbstractC2584f implements List, RandomAccess, Serializable, C5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object[] f22606a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f22607b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f22608c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final a f22609d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final C2635b f22610e;

        /* JADX INFO: renamed from: q5.b$a$a, reason: collision with other inner class name */
        public static final class C0386a implements ListIterator, C5.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final a f22611a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f22612b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f22613c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f22614d;

            public C0386a(a list, int i8) {
                AbstractC2304t.f(list, "list");
                this.f22611a = list;
                this.f22612b = i8;
                this.f22613c = -1;
                this.f22614d = ((AbstractList) list).modCount;
            }

            private final void c() {
                if (((AbstractList) this.f22611a.f22610e).modCount != this.f22614d) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.ListIterator
            public void add(Object obj) {
                c();
                a aVar = this.f22611a;
                int i8 = this.f22612b;
                this.f22612b = i8 + 1;
                aVar.add(i8, obj);
                this.f22613c = -1;
                this.f22614d = ((AbstractList) this.f22611a).modCount;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.f22612b < this.f22611a.f22608c;
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.f22612b > 0;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public Object next() {
                c();
                if (this.f22612b >= this.f22611a.f22608c) {
                    throw new NoSuchElementException();
                }
                int i8 = this.f22612b;
                this.f22612b = i8 + 1;
                this.f22613c = i8;
                return this.f22611a.f22606a[this.f22611a.f22607b + this.f22613c];
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.f22612b;
            }

            @Override // java.util.ListIterator
            public Object previous() {
                c();
                int i8 = this.f22612b;
                if (i8 <= 0) {
                    throw new NoSuchElementException();
                }
                int i9 = i8 - 1;
                this.f22612b = i9;
                this.f22613c = i9;
                return this.f22611a.f22606a[this.f22611a.f22607b + this.f22613c];
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.f22612b - 1;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                c();
                int i8 = this.f22613c;
                if (i8 == -1) {
                    throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
                }
                this.f22611a.remove(i8);
                this.f22612b = this.f22613c;
                this.f22613c = -1;
                this.f22614d = ((AbstractList) this.f22611a).modCount;
            }

            @Override // java.util.ListIterator
            public void set(Object obj) {
                c();
                int i8 = this.f22613c;
                if (i8 == -1) {
                    throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
                }
                this.f22611a.set(i8, obj);
            }
        }

        public a(Object[] backing, int i8, int i9, a aVar, C2635b root) {
            AbstractC2304t.f(backing, "backing");
            AbstractC2304t.f(root, "root");
            this.f22606a = backing;
            this.f22607b = i8;
            this.f22608c = i9;
            this.f22609d = aVar;
            this.f22610e = root;
            ((AbstractList) this).modCount = ((AbstractList) root).modCount;
        }

        private final void M() {
            ((AbstractList) this).modCount++;
        }

        public final void F(int i8, Collection collection, int i9) {
            M();
            a aVar = this.f22609d;
            if (aVar != null) {
                aVar.F(i8, collection, i9);
            } else {
                this.f22610e.K(i8, collection, i9);
            }
            this.f22606a = this.f22610e.f22603a;
            this.f22608c += i9;
        }

        public final void H(int i8, Object obj) {
            M();
            a aVar = this.f22609d;
            if (aVar != null) {
                aVar.H(i8, obj);
            } else {
                this.f22610e.L(i8, obj);
            }
            this.f22606a = this.f22610e.f22603a;
            this.f22608c++;
        }

        public final void I() {
            if (((AbstractList) this.f22610e).modCount != ((AbstractList) this).modCount) {
                throw new ConcurrentModificationException();
            }
        }

        public final void J() {
            if (L()) {
                throw new UnsupportedOperationException();
            }
        }

        public final boolean K(List list) {
            return AbstractC2636c.h(this.f22606a, this.f22607b, this.f22608c, list);
        }

        public final boolean L() {
            return this.f22610e.f22605c;
        }

        public final Object N(int i8) {
            M();
            a aVar = this.f22609d;
            this.f22608c--;
            return aVar != null ? aVar.N(i8) : this.f22610e.T(i8);
        }

        public final void O(int i8, int i9) {
            if (i9 > 0) {
                M();
            }
            a aVar = this.f22609d;
            if (aVar != null) {
                aVar.O(i8, i9);
            } else {
                this.f22610e.U(i8, i9);
            }
            this.f22608c -= i9;
        }

        public final int P(int i8, int i9, Collection collection, boolean z7) {
            a aVar = this.f22609d;
            int iP = aVar != null ? aVar.P(i8, i9, collection, z7) : this.f22610e.V(i8, i9, collection, z7);
            if (iP > 0) {
                M();
            }
            this.f22608c -= iP;
            return iP;
        }

        @Override // p5.AbstractC2584f
        public int a() {
            I();
            return this.f22608c;
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i8, Object obj) {
            J();
            I();
            AbstractC2582d.f22376a.c(i8, this.f22608c);
            H(this.f22607b + i8, obj);
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int i8, Collection elements) {
            AbstractC2304t.f(elements, "elements");
            J();
            I();
            AbstractC2582d.f22376a.c(i8, this.f22608c);
            int size = elements.size();
            F(this.f22607b + i8, elements, size);
            return size > 0;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            J();
            I();
            O(this.f22607b, this.f22608c);
        }

        @Override // p5.AbstractC2584f
        public Object d(int i8) {
            J();
            I();
            AbstractC2582d.f22376a.b(i8, this.f22608c);
            return N(this.f22607b + i8);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            I();
            return obj == this || ((obj instanceof List) && K((List) obj));
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i8) {
            I();
            AbstractC2582d.f22376a.b(i8, this.f22608c);
            return this.f22606a[this.f22607b + i8];
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            I();
            return AbstractC2636c.i(this.f22606a, this.f22607b, this.f22608c);
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            I();
            for (int i8 = 0; i8 < this.f22608c; i8++) {
                if (AbstractC2304t.b(this.f22606a[this.f22607b + i8], obj)) {
                    return i8;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            I();
            return this.f22608c == 0;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator iterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            I();
            for (int i8 = this.f22608c - 1; i8 >= 0; i8--) {
                if (AbstractC2304t.b(this.f22606a[this.f22607b + i8], obj)) {
                    return i8;
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
            J();
            I();
            int iIndexOf = indexOf(obj);
            if (iIndexOf >= 0) {
                remove(iIndexOf);
            }
            return iIndexOf >= 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean removeAll(Collection elements) {
            AbstractC2304t.f(elements, "elements");
            J();
            I();
            return P(this.f22607b, this.f22608c, elements, false) > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean retainAll(Collection elements) {
            AbstractC2304t.f(elements, "elements");
            J();
            I();
            return P(this.f22607b, this.f22608c, elements, true) > 0;
        }

        @Override // java.util.AbstractList, java.util.List
        public Object set(int i8, Object obj) {
            J();
            I();
            AbstractC2582d.f22376a.b(i8, this.f22608c);
            Object[] objArr = this.f22606a;
            int i9 = this.f22607b;
            Object obj2 = objArr[i9 + i8];
            objArr[i9 + i8] = obj;
            return obj2;
        }

        @Override // java.util.AbstractList, java.util.List
        public List subList(int i8, int i9) {
            AbstractC2582d.f22376a.d(i8, i9, this.f22608c);
            return new a(this.f22606a, this.f22607b + i8, i9 - i8, this, this.f22610e);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public Object[] toArray() {
            I();
            Object[] objArr = this.f22606a;
            int i8 = this.f22607b;
            return AbstractC2590l.m(objArr, i8, this.f22608c + i8);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            I();
            return AbstractC2636c.j(this.f22606a, this.f22607b, this.f22608c, this);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(Object obj) {
            J();
            I();
            H(this.f22607b + this.f22608c, obj);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean addAll(Collection elements) {
            AbstractC2304t.f(elements, "elements");
            J();
            I();
            int size = elements.size();
            F(this.f22607b + this.f22608c, elements, size);
            return size > 0;
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator listIterator(int i8) {
            I();
            AbstractC2582d.f22376a.c(i8, this.f22608c);
            return new C0386a(this, i8);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public Object[] toArray(Object[] array) {
            AbstractC2304t.f(array, "array");
            I();
            int length = array.length;
            int i8 = this.f22608c;
            if (length >= i8) {
                Object[] objArr = this.f22606a;
                int i9 = this.f22607b;
                AbstractC2590l.h(objArr, array, 0, i9, i8 + i9);
                return AbstractC2594p.f(this.f22608c, array);
            }
            Object[] objArr2 = this.f22606a;
            int i10 = this.f22607b;
            Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr2, i10, i8 + i10, array.getClass());
            AbstractC2304t.e(objArrCopyOfRange, "copyOfRange(...)");
            return objArrCopyOfRange;
        }
    }

    /* JADX INFO: renamed from: q5.b$b, reason: collision with other inner class name */
    public static final class C0387b {
        public C0387b() {
        }

        public /* synthetic */ C0387b(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    /* JADX INFO: renamed from: q5.b$c */
    public static final class c implements ListIterator, C5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C2635b f22615a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f22616b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f22617c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f22618d;

        public c(C2635b list, int i8) {
            AbstractC2304t.f(list, "list");
            this.f22615a = list;
            this.f22616b = i8;
            this.f22617c = -1;
            this.f22618d = ((AbstractList) list).modCount;
        }

        private final void c() {
            if (((AbstractList) this.f22615a).modCount != this.f22618d) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            c();
            C2635b c2635b = this.f22615a;
            int i8 = this.f22616b;
            this.f22616b = i8 + 1;
            c2635b.add(i8, obj);
            this.f22617c = -1;
            this.f22618d = ((AbstractList) this.f22615a).modCount;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f22616b < this.f22615a.f22604b;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f22616b > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            c();
            if (this.f22616b >= this.f22615a.f22604b) {
                throw new NoSuchElementException();
            }
            int i8 = this.f22616b;
            this.f22616b = i8 + 1;
            this.f22617c = i8;
            return this.f22615a.f22603a[this.f22617c];
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f22616b;
        }

        @Override // java.util.ListIterator
        public Object previous() {
            c();
            int i8 = this.f22616b;
            if (i8 <= 0) {
                throw new NoSuchElementException();
            }
            int i9 = i8 - 1;
            this.f22616b = i9;
            this.f22617c = i9;
            return this.f22615a.f22603a[this.f22617c];
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f22616b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            c();
            int i8 = this.f22617c;
            if (i8 == -1) {
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
            }
            this.f22615a.remove(i8);
            this.f22616b = this.f22617c;
            this.f22617c = -1;
            this.f22618d = ((AbstractList) this.f22615a).modCount;
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            c();
            int i8 = this.f22617c;
            if (i8 == -1) {
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
            }
            this.f22615a.set(i8, obj);
        }
    }

    static {
        C2635b c2635b = new C2635b(0);
        c2635b.f22605c = true;
        f22602e = c2635b;
    }

    public C2635b(int i8) {
        this.f22603a = AbstractC2636c.d(i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(int i8, Collection collection, int i9) {
        S();
        R(i8, i9);
        Iterator it = collection.iterator();
        for (int i10 = 0; i10 < i9; i10++) {
            this.f22603a[i8 + i10] = it.next();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(int i8, Object obj) {
        S();
        R(i8, 1);
        this.f22603a[i8] = obj;
    }

    private final void N() {
        if (this.f22605c) {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean O(List list) {
        return AbstractC2636c.h(this.f22603a, 0, this.f22604b, list);
    }

    private final void S() {
        ((AbstractList) this).modCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object T(int i8) {
        S();
        Object[] objArr = this.f22603a;
        Object obj = objArr[i8];
        AbstractC2590l.h(objArr, objArr, i8, i8 + 1, this.f22604b);
        AbstractC2636c.f(this.f22603a, this.f22604b - 1);
        this.f22604b--;
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(int i8, int i9) {
        if (i9 > 0) {
            S();
        }
        Object[] objArr = this.f22603a;
        AbstractC2590l.h(objArr, objArr, i8, i8 + i9, this.f22604b);
        Object[] objArr2 = this.f22603a;
        int i10 = this.f22604b;
        AbstractC2636c.g(objArr2, i10 - i9, i10);
        this.f22604b -= i9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int V(int i8, int i9, Collection collection, boolean z7) {
        int i10 = 0;
        int i11 = 0;
        while (i10 < i9) {
            int i12 = i8 + i10;
            if (collection.contains(this.f22603a[i12]) == z7) {
                Object[] objArr = this.f22603a;
                i10++;
                objArr[i11 + i8] = objArr[i12];
                i11++;
            } else {
                i10++;
            }
        }
        int i13 = i9 - i11;
        Object[] objArr2 = this.f22603a;
        AbstractC2590l.h(objArr2, objArr2, i8 + i11, i9 + i8, this.f22604b);
        Object[] objArr3 = this.f22603a;
        int i14 = this.f22604b;
        AbstractC2636c.g(objArr3, i14 - i13, i14);
        if (i13 > 0) {
            S();
        }
        this.f22604b -= i13;
        return i13;
    }

    public final List M() {
        N();
        this.f22605c = true;
        return this.f22604b > 0 ? this : f22602e;
    }

    public final void P(int i8) {
        if (i8 < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr = this.f22603a;
        if (i8 > objArr.length) {
            this.f22603a = AbstractC2636c.e(this.f22603a, AbstractC2582d.f22376a.e(objArr.length, i8));
        }
    }

    public final void Q(int i8) {
        P(this.f22604b + i8);
    }

    public final void R(int i8, int i9) {
        Q(i9);
        Object[] objArr = this.f22603a;
        AbstractC2590l.h(objArr, objArr, i8 + i9, i8, this.f22604b);
        this.f22604b += i9;
    }

    @Override // p5.AbstractC2584f
    public int a() {
        return this.f22604b;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i8, Object obj) {
        N();
        AbstractC2582d.f22376a.c(i8, this.f22604b);
        L(i8, obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i8, Collection elements) {
        AbstractC2304t.f(elements, "elements");
        N();
        AbstractC2582d.f22376a.c(i8, this.f22604b);
        int size = elements.size();
        K(i8, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        N();
        U(0, this.f22604b);
    }

    @Override // p5.AbstractC2584f
    public Object d(int i8) {
        N();
        AbstractC2582d.f22376a.b(i8, this.f22604b);
        return T(i8);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof List) && O((List) obj));
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i8) {
        AbstractC2582d.f22376a.b(i8, this.f22604b);
        return this.f22603a[i8];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return AbstractC2636c.i(this.f22603a, 0, this.f22604b);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        for (int i8 = 0; i8 < this.f22604b; i8++) {
            if (AbstractC2304t.b(this.f22603a[i8], obj)) {
                return i8;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this.f22604b == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        for (int i8 = this.f22604b - 1; i8 >= 0; i8--) {
            if (AbstractC2304t.b(this.f22603a[i8], obj)) {
                return i8;
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
        N();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            remove(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection elements) {
        AbstractC2304t.f(elements, "elements");
        N();
        return V(0, this.f22604b, elements, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection elements) {
        AbstractC2304t.f(elements, "elements");
        N();
        return V(0, this.f22604b, elements, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i8, Object obj) {
        N();
        AbstractC2582d.f22376a.b(i8, this.f22604b);
        Object[] objArr = this.f22603a;
        Object obj2 = objArr[i8];
        objArr[i8] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public List subList(int i8, int i9) {
        AbstractC2582d.f22376a.d(i8, i9, this.f22604b);
        return new a(this.f22603a, i8, i9 - i8, null, this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return AbstractC2590l.m(this.f22603a, 0, this.f22604b);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return AbstractC2636c.j(this.f22603a, 0, this.f22604b, this);
    }

    public /* synthetic */ C2635b(int i8, int i9, AbstractC2296k abstractC2296k) {
        this((i9 & 1) != 0 ? 10 : i8);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        N();
        L(this.f22604b, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection elements) {
        AbstractC2304t.f(elements, "elements");
        N();
        int size = elements.size();
        K(this.f22604b, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator(int i8) {
        AbstractC2582d.f22376a.c(i8, this.f22604b);
        return new c(this, i8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray(Object[] array) {
        AbstractC2304t.f(array, "array");
        int length = array.length;
        int i8 = this.f22604b;
        if (length >= i8) {
            AbstractC2590l.h(this.f22603a, array, 0, 0, i8);
            return AbstractC2594p.f(this.f22604b, array);
        }
        Object[] objArrCopyOfRange = Arrays.copyOfRange(this.f22603a, 0, i8, array.getClass());
        AbstractC2304t.e(objArrCopyOfRange, "copyOfRange(...)");
        return objArrCopyOfRange;
    }
}
