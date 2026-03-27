package V1;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import s3.D;

/* JADX INFO: loaded from: classes.dex */
public final class c extends s implements ListIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f3197c;

    public c(e eVar, int i) {
        int size = eVar.size();
        D.l(i, size);
        this.f3195a = size;
        this.f3196b = i;
        this.f3197c = eVar;
    }

    public final Object a(int i) {
        return this.f3197c.get(i);
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f3196b < this.f3195a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f3196b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.f3196b;
        this.f3196b = i + 1;
        return a(i);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f3196b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.f3196b - 1;
        this.f3196b = i;
        return a(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f3196b - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
