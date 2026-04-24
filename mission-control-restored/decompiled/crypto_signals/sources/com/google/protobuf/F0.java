package com.google.protobuf;

import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public final class F0 implements ListIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ListIterator f5643a;

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f5643a.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f5643a.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        return (String) this.f5643a.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f5643a.nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return (String) this.f5643a.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f5643a.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
