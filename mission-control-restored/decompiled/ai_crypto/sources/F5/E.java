package F5;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class E implements Iterator, R5.a {
    public abstract int c();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return Integer.valueOf(c());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
