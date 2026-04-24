package com.google.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public class z0 extends AbstractList implements K, RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final K f11274a;

    public class a implements ListIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ListIterator f11275a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f11276b;

        public a(int i4) {
            this.f11276b = i4;
            this.f11275a = z0.this.f11274a.listIterator(i4);
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public String next() {
            return (String) this.f11275a.next();
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String previous() {
            return (String) this.f11275a.previous();
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void set(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f11275a.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f11275a.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f11275a.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f11275a.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public class b implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Iterator f11278a;

        public b() {
            this.f11278a = z0.this.f11274a.iterator();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String next() {
            return (String) this.f11278a.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f11278a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public z0(K k4) {
        this.f11274a = k4;
    }

    @Override // com.google.protobuf.K
    public void b(AbstractC1062i abstractC1062i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public String get(int i4) {
        return (String) this.f11274a.get(i4);
    }

    @Override // com.google.protobuf.K
    public List g() {
        return this.f11274a.g();
    }

    @Override // com.google.protobuf.K
    public K h() {
        return this;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return new b();
    }

    @Override // com.google.protobuf.K
    public Object j(int i4) {
        return this.f11274a.j(i4);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator(int i4) {
        return new a(i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f11274a.size();
    }
}
