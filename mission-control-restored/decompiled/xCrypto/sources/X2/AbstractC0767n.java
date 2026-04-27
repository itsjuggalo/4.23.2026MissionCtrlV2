package X2;

import j3.InterfaceC1564a;
import java.util.Iterator;

/* JADX INFO: renamed from: X2.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0767n implements Iterator, InterfaceC1564a {
    public abstract char b();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return Character.valueOf(b());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
