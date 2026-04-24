package p5;

import java.util.Iterator;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class H implements Iterator, C5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator f22368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22369b;

    public H(Iterator iterator) {
        AbstractC2304t.f(iterator, "iterator");
        this.f22368a = iterator;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final C2577F next() {
        int i8 = this.f22369b;
        this.f22369b = i8 + 1;
        if (i8 < 0) {
            AbstractC2595q.r();
        }
        return new C2577F(i8, this.f22368a.next());
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f22368a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
