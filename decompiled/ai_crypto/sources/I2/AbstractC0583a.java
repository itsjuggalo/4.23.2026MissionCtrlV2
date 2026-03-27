package I2;

import java.util.NoSuchElementException;

/* JADX INFO: renamed from: I2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0583a extends C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2946b;

    public AbstractC0583a(int i7, int i8) {
        H2.m.q(i8, i7);
        this.f2945a = i7;
        this.f2946b = i8;
    }

    public abstract Object b(int i7);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f2946b < this.f2945a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f2946b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i7 = this.f2946b;
        this.f2946b = i7 + 1;
        return b(i7);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f2946b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i7 = this.f2946b - 1;
        this.f2946b = i7;
        return b(i7);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f2946b - 1;
    }
}
