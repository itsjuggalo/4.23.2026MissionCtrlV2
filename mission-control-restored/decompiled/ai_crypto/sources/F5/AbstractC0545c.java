package F5;

import com.google.android.gms.common.api.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: renamed from: F5.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0545c extends AbstractC0543a implements List, R5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f2367a = new a(null);

    /* JADX INFO: renamed from: F5.c$a */
    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final void a(int i7, int i8, int i9) {
            if (i7 < 0 || i8 > i9) {
                throw new IndexOutOfBoundsException("startIndex: " + i7 + ", endIndex: " + i8 + ", size: " + i9);
            }
            if (i7 <= i8) {
                return;
            }
            throw new IllegalArgumentException("startIndex: " + i7 + " > endIndex: " + i8);
        }

        public final void b(int i7, int i8) {
            if (i7 < 0 || i7 >= i8) {
                throw new IndexOutOfBoundsException("index: " + i7 + ", size: " + i8);
            }
        }

        public final void c(int i7, int i8) {
            if (i7 < 0 || i7 > i8) {
                throw new IndexOutOfBoundsException("index: " + i7 + ", size: " + i8);
            }
        }

        public final void d(int i7, int i8, int i9) {
            if (i7 < 0 || i8 > i9) {
                throw new IndexOutOfBoundsException("fromIndex: " + i7 + ", toIndex: " + i8 + ", size: " + i9);
            }
            if (i7 <= i8) {
                return;
            }
            throw new IllegalArgumentException("fromIndex: " + i7 + " > toIndex: " + i8);
        }

        public final int e(int i7, int i8) {
            int i9 = i7 + (i7 >> 1);
            if (i9 - i8 < 0) {
                i9 = i8;
            }
            if (i9 - 2147483639 <= 0) {
                return i9;
            }
            if (i8 > 2147483639) {
                return a.e.API_PRIORITY_OTHER;
            }
            return 2147483639;
        }

        public final boolean f(Collection c7, Collection other) {
            kotlin.jvm.internal.r.f(c7, "c");
            kotlin.jvm.internal.r.f(other, "other");
            if (c7.size() != other.size()) {
                return false;
            }
            Iterator it = other.iterator();
            Iterator it2 = c7.iterator();
            while (it2.hasNext()) {
                if (!kotlin.jvm.internal.r.b(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int g(Collection c7) {
            kotlin.jvm.internal.r.f(c7, "c");
            Iterator it = c7.iterator();
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

    /* JADX INFO: renamed from: F5.c$b */
    public class b implements Iterator, R5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2368a;

        public b() {
        }

        public final int c() {
            return this.f2368a;
        }

        public final void d(int i7) {
            this.f2368a = i7;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2368a < AbstractC0545c.this.size();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            AbstractC0545c abstractC0545c = AbstractC0545c.this;
            int i7 = this.f2368a;
            this.f2368a = i7 + 1;
            return abstractC0545c.get(i7);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: renamed from: F5.c$c, reason: collision with other inner class name */
    public class C0018c extends b implements ListIterator, R5.a {
        public C0018c(int i7) {
            super();
            AbstractC0545c.f2367a.c(i7, AbstractC0545c.this.size());
            d(i7);
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
            AbstractC0545c abstractC0545c = AbstractC0545c.this;
            d(c() - 1);
            return abstractC0545c.get(c());
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

    /* JADX INFO: renamed from: F5.c$d */
    public static final class d extends AbstractC0545c implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractC0545c f2371b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f2372c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2373d;

        public d(AbstractC0545c list, int i7, int i8) {
            kotlin.jvm.internal.r.f(list, "list");
            this.f2371b = list;
            this.f2372c = i7;
            AbstractC0545c.f2367a.d(i7, i8, list.size());
            this.f2373d = i8 - i7;
        }

        @Override // F5.AbstractC0543a
        public int a() {
            return this.f2373d;
        }

        @Override // F5.AbstractC0545c, java.util.List
        public Object get(int i7) {
            AbstractC0545c.f2367a.b(i7, this.f2373d);
            return this.f2371b.get(this.f2372c + i7);
        }
    }

    @Override // java.util.List
    public void add(int i7, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i7, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return f2367a.f(this, (Collection) obj);
        }
        return false;
    }

    public abstract Object get(int i7);

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return f2367a.g(this);
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        Iterator it = iterator();
        int i7 = 0;
        while (it.hasNext()) {
            if (kotlin.jvm.internal.r.b(it.next(), obj)) {
                return i7;
            }
            i7++;
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
        return new C0018c(0);
    }

    @Override // java.util.List
    public Object remove(int i7) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public Object set(int i7, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List subList(int i7, int i8) {
        return new d(this, i7, i8);
    }

    @Override // java.util.List
    public ListIterator listIterator(int i7) {
        return new C0018c(i7);
    }
}
