package com.google.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public class y0 extends AbstractList implements J, RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final J f12878a;

    public class a implements ListIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ListIterator f12879a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f12880b;

        public a(int i7) {
            this.f12880b = i7;
            this.f12879a = y0.this.f12878a.listIterator(i7);
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public String next() {
            return (String) this.f12879a.next();
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String previous() {
            return (String) this.f12879a.previous();
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void set(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f12879a.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f12879a.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f12879a.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f12879a.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public class b implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Iterator f12882a;

        public b() {
            this.f12882a = y0.this.f12878a.iterator();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String next() {
            return (String) this.f12882a.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12882a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public y0(J j7) {
        this.f12878a = j7;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public String get(int i7) {
        return (String) this.f12878a.get(i7);
    }

    @Override // com.google.protobuf.J
    public void i(AbstractC1240i abstractC1240i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return new b();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator(int i7) {
        return new a(i7);
    }

    @Override // com.google.protobuf.J
    public List o() {
        return this.f12878a.o();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f12878a.size();
    }

    @Override // com.google.protobuf.J
    public J v() {
        return this;
    }

    @Override // com.google.protobuf.J
    public Object z(int i7) {
        return this.f12878a.z(i7);
    }
}
