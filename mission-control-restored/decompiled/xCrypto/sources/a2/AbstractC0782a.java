package a2;

import java.util.NoSuchElementException;

/* JADX INFO: renamed from: a2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0782a extends C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6117b;

    public AbstractC0782a(int i4, int i5) {
        Z1.m.q(i5, i4);
        this.f6116a = i4;
        this.f6117b = i5;
    }

    public abstract Object b(int i4);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f6117b < this.f6116a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f6117b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i4 = this.f6117b;
        this.f6117b = i4 + 1;
        return b(i4);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f6117b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i4 = this.f6117b - 1;
        this.f6117b = i4;
        return b(i4);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f6117b - 1;
    }
}
