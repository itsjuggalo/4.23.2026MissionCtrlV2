package dd;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c implements Iterator, qd.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f7992b;

    public abstract void c();

    public final void e() {
        this.f7991a = 2;
    }

    public final void f(Object obj) {
        this.f7992b = obj;
        this.f7991a = 1;
    }

    public final boolean g() {
        this.f7991a = 3;
        c();
        return this.f7991a == 1;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i10 = this.f7991a;
        if (i10 == 0) {
            return g();
        }
        if (i10 == 1) {
            return true;
        }
        if (i10 == 2) {
            return false;
        }
        throw new IllegalArgumentException("hasNext called when the iterator is in the FAILED state.");
    }

    @Override // java.util.Iterator
    public Object next() {
        int i10 = this.f7991a;
        if (i10 == 1) {
            this.f7991a = 0;
            return this.f7992b;
        }
        if (i10 == 2 || !g()) {
            throw new NoSuchElementException();
        }
        this.f7991a = 0;
        return this.f7992b;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
