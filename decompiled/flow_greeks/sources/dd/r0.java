package dd;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class r0 extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f8019a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements ListIterator, qd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ListIterator f8020a;

        public a(int i10) {
            this.f8020a = r0.this.f8019a.listIterator(x.N(r0.this, i10));
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            this.f8020a.add(obj);
            this.f8020a.previous();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f8020a.hasPrevious();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f8020a.hasNext();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            return this.f8020a.previous();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return x.M(r0.this, this.f8020a.previousIndex());
        }

        @Override // java.util.ListIterator
        public Object previous() {
            return this.f8020a.next();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return x.M(r0.this, this.f8020a.nextIndex());
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            this.f8020a.remove();
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            this.f8020a.set(obj);
        }
    }

    public r0(List delegate) {
        kotlin.jvm.internal.t.f(delegate, "delegate");
        this.f8019a = delegate;
    }

    @Override // dd.f
    public int a() {
        return this.f8019a.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i10, Object obj) {
        this.f8019a.add(x.N(this, i10), obj);
    }

    @Override // dd.f
    public Object c(int i10) {
        return this.f8019a.remove(x.L(this, i10));
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f8019a.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i10) {
        return this.f8019a.get(x.L(this, i10));
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
    public Object set(int i10, Object obj) {
        return this.f8019a.set(x.L(this, i10), obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator(int i10) {
        return new a(i10);
    }
}
