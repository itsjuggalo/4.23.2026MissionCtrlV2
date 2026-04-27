package s6;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public class w extends AbstractList implements RandomAccess, n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f23224a;

    public class a implements ListIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ListIterator f23225a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f23226b;

        public a(int i8) {
            this.f23226b = i8;
            this.f23225a = w.this.f23224a.listIterator(i8);
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public String next() {
            return (String) this.f23225a.next();
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String previous() {
            return (String) this.f23225a.previous();
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void set(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f23225a.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f23225a.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f23225a.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f23225a.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public class b implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Iterator f23228a;

        public b() {
            this.f23228a = w.this.f23224a.iterator();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String next() {
            return (String) this.f23228a.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f23228a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public w(n nVar) {
        this.f23224a = nVar;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public String get(int i8) {
        return (String) this.f23224a.get(i8);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return new b();
    }

    @Override // s6.n
    public List k() {
        return this.f23224a.k();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator(int i8) {
        return new a(i8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f23224a.size();
    }

    @Override // s6.n
    public void t(AbstractC2717d abstractC2717d) {
        throw new UnsupportedOperationException();
    }

    @Override // s6.n
    public AbstractC2717d w(int i8) {
        return this.f23224a.w(i8);
    }

    @Override // s6.n
    public n l() {
        return this;
    }
}
