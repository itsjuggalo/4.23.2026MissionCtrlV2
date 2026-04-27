package w2;

import java.util.NoSuchElementException;
import v2.AbstractC2848n;

/* JADX INFO: renamed from: w2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2912a extends AbstractC2911C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f23994b;

    public AbstractC2912a(int i8, int i9) {
        AbstractC2848n.q(i9, i8);
        this.f23993a = i8;
        this.f23994b = i9;
    }

    public abstract Object b(int i8);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f23994b < this.f23993a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f23994b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i8 = this.f23994b;
        this.f23994b = i8 + 1;
        return b(i8);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f23994b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i8 = this.f23994b - 1;
        this.f23994b = i8;
        return b(i8);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f23994b - 1;
    }
}
