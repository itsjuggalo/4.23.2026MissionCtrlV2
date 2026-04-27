package com.google.protobuf;

import java.util.AbstractList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class H0 extends AbstractList implements T, RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S f5645a;

    public H0(S s6) {
        this.f5645a = s6;
    }

    @Override // com.google.protobuf.T
    public final void e(AbstractC0472l abstractC0472l) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.protobuf.T
    public final T g() {
        return this;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return (String) this.f5645a.get(i);
    }

    @Override // com.google.protobuf.T
    public final Object i(int i) {
        return this.f5645a.f5682b.get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        G0 g02 = new G0();
        g02.f5644a = this.f5645a.iterator();
        return g02;
    }

    @Override // com.google.protobuf.T
    public final List j() {
        return Collections.unmodifiableList(this.f5645a.f5682b);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        F0 f02 = new F0();
        f02.f5643a = this.f5645a.listIterator(i);
        return f02;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f5645a.f5682b.size();
    }
}
