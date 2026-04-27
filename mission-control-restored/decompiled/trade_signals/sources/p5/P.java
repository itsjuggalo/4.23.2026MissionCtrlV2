package p5;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class P extends AbstractC2584f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f22370a;

    public static final class a implements ListIterator, C5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ListIterator f22371a;

        public a(int i8) {
            this.f22371a = P.this.f22370a.listIterator(w.M(P.this, i8));
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            this.f22371a.add(obj);
            this.f22371a.previous();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f22371a.hasPrevious();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f22371a.hasNext();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            return this.f22371a.previous();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return w.L(P.this, this.f22371a.previousIndex());
        }

        @Override // java.util.ListIterator
        public Object previous() {
            return this.f22371a.next();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return w.L(P.this, this.f22371a.nextIndex());
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            this.f22371a.remove();
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            this.f22371a.set(obj);
        }
    }

    public P(List delegate) {
        AbstractC2304t.f(delegate, "delegate");
        this.f22370a = delegate;
    }

    @Override // p5.AbstractC2584f
    public int a() {
        return this.f22370a.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i8, Object obj) {
        this.f22370a.add(w.M(this, i8), obj);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f22370a.clear();
    }

    @Override // p5.AbstractC2584f
    public Object d(int i8) {
        return this.f22370a.remove(w.K(this, i8));
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i8) {
        return this.f22370a.get(w.K(this, i8));
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i8, Object obj) {
        return this.f22370a.set(w.K(this, i8), obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator(int i8) {
        return new a(i8);
    }
}
