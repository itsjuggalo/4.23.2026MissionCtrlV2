package X2;

import j3.InterfaceC1564a;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: X2.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0756c implements Iterator, InterfaceC1564a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f5604b;

    public abstract void b();

    public final void d() {
        this.f5603a = 2;
    }

    public final void e(Object obj) {
        this.f5604b = obj;
        this.f5603a = 1;
    }

    public final boolean f() {
        this.f5603a = 3;
        b();
        return this.f5603a == 1;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i4 = this.f5603a;
        if (i4 == 0) {
            return f();
        }
        if (i4 == 1) {
            return true;
        }
        if (i4 == 2) {
            return false;
        }
        throw new IllegalArgumentException("hasNext called when the iterator is in the FAILED state.");
    }

    @Override // java.util.Iterator
    public Object next() {
        int i4 = this.f5603a;
        if (i4 == 1) {
            this.f5603a = 0;
            return this.f5604b;
        }
        if (i4 == 2 || !f()) {
            throw new NoSuchElementException();
        }
        this.f5603a = 0;
        return this.f5604b;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
