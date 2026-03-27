package p5;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class J implements Iterator, C5.a {
    public abstract long c();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return Long.valueOf(c());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
