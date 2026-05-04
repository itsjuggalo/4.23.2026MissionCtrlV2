package dd;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i0 implements Iterator, qd.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator f8013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8014b;

    public i0(Iterator iterator) {
        kotlin.jvm.internal.t.f(iterator, "iterator");
        this.f8013a = iterator;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final g0 next() {
        int i10 = this.f8014b;
        this.f8014b = i10 + 1;
        if (i10 < 0) {
            r.t();
        }
        return new g0(i10, this.f8013a.next());
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f8013a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
