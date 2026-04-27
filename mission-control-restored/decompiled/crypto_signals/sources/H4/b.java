package H4;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class b extends a implements ListIterator {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d f566d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d dVar, int i) {
        super(dVar);
        this.f566d = dVar;
        int iA = dVar.a();
        if (i < 0 || i > iA) {
            throw new IndexOutOfBoundsException(a3.d.h("index: ", i, iA, ", size: "));
        }
        this.f564b = i;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f564b > 0;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f564b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.f564b - 1;
        this.f564b = i;
        return this.f566d.get(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f564b - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
