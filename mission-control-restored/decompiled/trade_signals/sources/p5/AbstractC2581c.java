package p5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: p5.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2581c implements Iterator, C5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f22374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f22375b;

    public abstract void c();

    public final void d() {
        this.f22374a = 2;
    }

    public final void e(Object obj) {
        this.f22375b = obj;
        this.f22374a = 1;
    }

    public final boolean f() {
        this.f22374a = 3;
        c();
        return this.f22374a == 1;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i8 = this.f22374a;
        if (i8 == 0) {
            return f();
        }
        if (i8 == 1) {
            return true;
        }
        if (i8 == 2) {
            return false;
        }
        throw new IllegalArgumentException("hasNext called when the iterator is in the FAILED state.");
    }

    @Override // java.util.Iterator
    public Object next() {
        int i8 = this.f22374a;
        if (i8 != 1 && (i8 == 2 || !f())) {
            throw new NoSuchElementException();
        }
        this.f22374a = 0;
        return this.f22375b;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
