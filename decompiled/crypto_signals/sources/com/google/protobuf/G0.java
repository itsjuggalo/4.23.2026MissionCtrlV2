package com.google.protobuf;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class G0 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Iterator f5644a;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5644a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return (String) this.f5644a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
