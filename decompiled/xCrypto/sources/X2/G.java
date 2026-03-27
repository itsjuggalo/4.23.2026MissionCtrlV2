package X2;

import j3.InterfaceC1564a;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class G implements Iterator, InterfaceC1564a {
    public abstract int b();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return Integer.valueOf(b());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
