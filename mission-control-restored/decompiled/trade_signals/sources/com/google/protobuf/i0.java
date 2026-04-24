package com.google.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public class i0 extends AbstractList implements InterfaceC1486z, RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC1486z f16421a;

    public class a implements ListIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ListIterator f16422a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f16423b;

        public a(int i8) {
            this.f16423b = i8;
            this.f16422a = i0.this.f16421a.listIterator(i8);
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public String next() {
            return (String) this.f16422a.next();
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String previous() {
            return (String) this.f16422a.previous();
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void set(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f16422a.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f16422a.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f16422a.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f16422a.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public class b implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Iterator f16425a;

        public b() {
            this.f16425a = i0.this.f16421a.iterator();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String next() {
            return (String) this.f16425a.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f16425a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public i0(InterfaceC1486z interfaceC1486z) {
        this.f16421a = interfaceC1486z;
    }

    @Override // com.google.protobuf.InterfaceC1486z
    public Object B(int i8) {
        return this.f16421a.B(i8);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public String get(int i8) {
        return (String) this.f16421a.get(i8);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return new b();
    }

    @Override // com.google.protobuf.InterfaceC1486z
    public List k() {
        return this.f16421a.k();
    }

    @Override // com.google.protobuf.InterfaceC1486z
    public InterfaceC1486z l() {
        return this;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator(int i8) {
        return new a(i8);
    }

    @Override // com.google.protobuf.InterfaceC1486z
    public void q(AbstractC1467f abstractC1467f) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f16421a.size();
    }
}
