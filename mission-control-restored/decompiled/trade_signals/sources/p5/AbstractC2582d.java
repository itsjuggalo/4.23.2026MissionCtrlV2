package p5;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: p5.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2582d extends AbstractC2580b implements List, C5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f22376a = new a(null);

    /* JADX INFO: renamed from: p5.d$a */
    public static final class a {
        public a() {
        }

        public final void a(int i8, int i9, int i10) {
            if (i8 < 0 || i9 > i10) {
                throw new IndexOutOfBoundsException("startIndex: " + i8 + ", endIndex: " + i9 + ", size: " + i10);
            }
            if (i8 <= i9) {
                return;
            }
            throw new IllegalArgumentException("startIndex: " + i8 + " > endIndex: " + i9);
        }

        public final void b(int i8, int i9) {
            if (i8 < 0 || i8 >= i9) {
                throw new IndexOutOfBoundsException("index: " + i8 + ", size: " + i9);
            }
        }

        public final void c(int i8, int i9) {
            if (i8 < 0 || i8 > i9) {
                throw new IndexOutOfBoundsException("index: " + i8 + ", size: " + i9);
            }
        }

        public final void d(int i8, int i9, int i10) {
            if (i8 < 0 || i9 > i10) {
                throw new IndexOutOfBoundsException("fromIndex: " + i8 + ", toIndex: " + i9 + ", size: " + i10);
            }
            if (i8 <= i9) {
                return;
            }
            throw new IllegalArgumentException("fromIndex: " + i8 + " > toIndex: " + i9);
        }

        public final int e(int i8, int i9) {
            int i10 = i8 + (i8 >> 1);
            if (i10 - i9 < 0) {
                i10 = i9;
            }
            return i10 - 2147483639 > 0 ? i9 > 2147483639 ? Integer.MAX_VALUE : 2147483639 : i10;
        }

        public final boolean f(Collection c8, Collection other) {
            AbstractC2304t.f(c8, "c");
            AbstractC2304t.f(other, "other");
            if (c8.size() != other.size()) {
                return false;
            }
            Iterator it = other.iterator();
            Iterator it2 = c8.iterator();
            while (it2.hasNext()) {
                if (!AbstractC2304t.b(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int g(Collection c8) {
            AbstractC2304t.f(c8, "c");
            Iterator it = c8.iterator();
            int iHashCode = 1;
            while (it.hasNext()) {
                Object next = it.next();
                iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
            }
            return iHashCode;
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    /* JADX INFO: renamed from: p5.d$b */
    public class b implements Iterator, C5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f22377a;

        public b() {
        }

        public final int c() {
            return this.f22377a;
        }

        public final void d(int i8) {
            this.f22377a = i8;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f22377a < AbstractC2582d.this.size();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            AbstractC2582d abstractC2582d = AbstractC2582d.this;
            int i8 = this.f22377a;
            this.f22377a = i8 + 1;
            return abstractC2582d.get(i8);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: renamed from: p5.d$c */
    public class c extends b implements ListIterator, C5.a {
        public c(int i8) {
            super();
            AbstractC2582d.f22376a.c(i8, AbstractC2582d.this.size());
            d(i8);
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return c() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return c();
        }

        @Override // java.util.ListIterator
        public Object previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            AbstractC2582d abstractC2582d = AbstractC2582d.this;
            d(c() - 1);
            return abstractC2582d.get(c());
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return c() - 1;
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: renamed from: p5.d$d, reason: collision with other inner class name */
    public static final class C0378d extends AbstractC2582d implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractC2582d f22380b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f22381c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f22382d;

        public C0378d(AbstractC2582d list, int i8, int i9) {
            AbstractC2304t.f(list, "list");
            this.f22380b = list;
            this.f22381c = i8;
            AbstractC2582d.f22376a.d(i8, i9, list.size());
            this.f22382d = i9 - i8;
        }

        @Override // p5.AbstractC2580b
        public int d() {
            return this.f22382d;
        }

        @Override // p5.AbstractC2582d, java.util.List
        public Object get(int i8) {
            AbstractC2582d.f22376a.b(i8, this.f22382d);
            return this.f22380b.get(this.f22381c + i8);
        }
    }

    @Override // java.util.List
    public void add(int i8, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i8, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return f22376a.f(this, (Collection) obj);
        }
        return false;
    }

    public abstract Object get(int i8);

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return f22376a.g(this);
    }

    public int indexOf(Object obj) {
        Iterator it = iterator();
        int i8 = 0;
        while (it.hasNext()) {
            if (AbstractC2304t.b(it.next(), obj)) {
                return i8;
            }
            i8++;
        }
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return new b();
    }

    public int lastIndexOf(Object obj) {
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (AbstractC2304t.b(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return new c(0);
    }

    @Override // java.util.List
    public Object remove(int i8) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public Object set(int i8, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List subList(int i8, int i9) {
        return new C0378d(this, i8, i9);
    }

    @Override // java.util.List
    public ListIterator listIterator(int i8) {
        return new c(i8);
    }
}
