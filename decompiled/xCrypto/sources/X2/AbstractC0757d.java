package X2;

import j3.InterfaceC1564a;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: renamed from: X2.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0757d extends AbstractC0755b implements List, InterfaceC1564a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5605a = new a(null);

    /* JADX INFO: renamed from: X2.d$a */
    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public final void a(int i4, int i5, int i6) {
            if (i4 < 0 || i5 > i6) {
                throw new IndexOutOfBoundsException("startIndex: " + i4 + ", endIndex: " + i5 + ", size: " + i6);
            }
            if (i4 <= i5) {
                return;
            }
            throw new IllegalArgumentException("startIndex: " + i4 + " > endIndex: " + i5);
        }

        public final void b(int i4, int i5) {
            if (i4 < 0 || i4 >= i5) {
                throw new IndexOutOfBoundsException("index: " + i4 + ", size: " + i5);
            }
        }

        public final void c(int i4, int i5) {
            if (i4 < 0 || i4 > i5) {
                throw new IndexOutOfBoundsException("index: " + i4 + ", size: " + i5);
            }
        }

        public final void d(int i4, int i5, int i6) {
            if (i4 < 0 || i5 > i6) {
                throw new IndexOutOfBoundsException("fromIndex: " + i4 + ", toIndex: " + i5 + ", size: " + i6);
            }
            if (i4 <= i5) {
                return;
            }
            throw new IllegalArgumentException("fromIndex: " + i4 + " > toIndex: " + i5);
        }

        public final int e(int i4, int i5) {
            int i6 = i4 + (i4 >> 1);
            if (i6 - i5 < 0) {
                i6 = i5;
            }
            return i6 - 2147483639 > 0 ? i5 > 2147483639 ? Integer.MAX_VALUE : 2147483639 : i6;
        }

        public final boolean f(Collection c4, Collection other) {
            kotlin.jvm.internal.r.f(c4, "c");
            kotlin.jvm.internal.r.f(other, "other");
            if (c4.size() != other.size()) {
                return false;
            }
            Iterator it = other.iterator();
            Iterator it2 = c4.iterator();
            while (it2.hasNext()) {
                if (!kotlin.jvm.internal.r.b(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int g(Collection c4) {
            kotlin.jvm.internal.r.f(c4, "c");
            Iterator it = c4.iterator();
            int iHashCode = 1;
            while (it.hasNext()) {
                Object next = it.next();
                iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
            }
            return iHashCode;
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: X2.d$b */
    public class b implements Iterator, InterfaceC1564a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5606a;

        public b() {
        }

        public final int b() {
            return this.f5606a;
        }

        public final void d(int i4) {
            this.f5606a = i4;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f5606a < AbstractC0757d.this.size();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            AbstractC0757d abstractC0757d = AbstractC0757d.this;
            int i4 = this.f5606a;
            this.f5606a = i4 + 1;
            return abstractC0757d.get(i4);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: renamed from: X2.d$c */
    public class c extends b implements ListIterator, InterfaceC1564a {
        public c(int i4) {
            super();
            AbstractC0757d.f5605a.c(i4, AbstractC0757d.this.size());
            d(i4);
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return b() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return b();
        }

        @Override // java.util.ListIterator
        public Object previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            AbstractC0757d abstractC0757d = AbstractC0757d.this;
            d(b() - 1);
            return abstractC0757d.get(b());
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return b() - 1;
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: renamed from: X2.d$d, reason: collision with other inner class name */
    public static final class C0077d extends AbstractC0757d implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractC0757d f5609b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f5610c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f5611d;

        public C0077d(AbstractC0757d list, int i4, int i5) {
            kotlin.jvm.internal.r.f(list, "list");
            this.f5609b = list;
            this.f5610c = i4;
            AbstractC0757d.f5605a.d(i4, i5, list.size());
            this.f5611d = i5 - i4;
        }

        @Override // X2.AbstractC0757d, java.util.List
        public Object get(int i4) {
            AbstractC0757d.f5605a.b(i4, this.f5611d);
            return this.f5609b.get(this.f5610c + i4);
        }

        @Override // X2.AbstractC0755b
        public int i() {
            return this.f5611d;
        }
    }

    @Override // java.util.List
    public void add(int i4, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i4, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return f5605a.f(this, (Collection) obj);
        }
        return false;
    }

    public abstract Object get(int i4);

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return f5605a.g(this);
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        Iterator it = iterator();
        int i4 = 0;
        while (it.hasNext()) {
            if (kotlin.jvm.internal.r.b(it.next(), obj)) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return new b();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (kotlin.jvm.internal.r.b(listIterator.previous(), obj)) {
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
    public Object remove(int i4) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public Object set(int i4, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List subList(int i4, int i5) {
        return new C0077d(this, i4, i5);
    }

    @Override // java.util.List
    public ListIterator listIterator(int i4) {
        return new c(i4);
    }
}
