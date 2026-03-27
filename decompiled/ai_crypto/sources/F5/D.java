package F5;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class D implements Iterator, R5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator f2345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2346b;

    public D(Iterator iterator) {
        kotlin.jvm.internal.r.f(iterator, "iterator");
        this.f2345a = iterator;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final B next() {
        int i7 = this.f2346b;
        this.f2346b = i7 + 1;
        if (i7 < 0) {
            AbstractC0556n.p();
        }
        return new B(i7, this.f2345a.next());
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2345a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
