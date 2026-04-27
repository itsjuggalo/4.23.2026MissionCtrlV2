package X2;

import j3.InterfaceC1564a;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class F implements Iterator, InterfaceC1564a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator f5583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5584b;

    public F(Iterator iterator) {
        kotlin.jvm.internal.r.f(iterator, "iterator");
        this.f5583a = iterator;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final D next() {
        int i4 = this.f5584b;
        this.f5584b = i4 + 1;
        if (i4 < 0) {
            AbstractC0769p.p();
        }
        return new D(i4, this.f5583a.next());
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5583a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
