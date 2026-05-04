package w;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e implements Iterator, qd.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f23564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f23565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f23566c;

    public e(int i10) {
        this.f23564a = i10;
    }

    public abstract Object c(int i10);

    public abstract void e(int i10);

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f23565b < this.f23564a;
    }

    @Override // java.util.Iterator
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object objC = c(this.f23565b);
        this.f23565b++;
        this.f23566c = true;
        return objC;
    }

    @Override // java.util.Iterator
    public void remove() {
        if (!this.f23566c) {
            throw new IllegalStateException("Call next() before removing an element.");
        }
        int i10 = this.f23565b - 1;
        this.f23565b = i10;
        e(i10);
        this.f23564a--;
        this.f23566c = false;
    }
}
