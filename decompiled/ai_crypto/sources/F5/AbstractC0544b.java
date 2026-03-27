package F5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: F5.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0544b implements Iterator, R5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f2366b;

    public abstract void c();

    public final void d() {
        this.f2365a = 2;
    }

    public final void e(Object obj) {
        this.f2366b = obj;
        this.f2365a = 1;
    }

    public final boolean f() {
        this.f2365a = 3;
        c();
        return this.f2365a == 1;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i7 = this.f2365a;
        if (i7 == 0) {
            return f();
        }
        if (i7 == 1) {
            return true;
        }
        if (i7 == 2) {
            return false;
        }
        throw new IllegalArgumentException("hasNext called when the iterator is in the FAILED state.");
    }

    @Override // java.util.Iterator
    public Object next() {
        int i7 = this.f2365a;
        if (i7 == 1) {
            this.f2365a = 0;
            return this.f2366b;
        }
        if (i7 == 2 || !f()) {
            throw new NoSuchElementException();
        }
        this.f2365a = 0;
        return this.f2366b;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
