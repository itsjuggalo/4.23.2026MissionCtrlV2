package w;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public abstract class e implements Iterator, C5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f23961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f23962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f23963c;

    public e(int i8) {
        this.f23961a = i8;
    }

    public abstract Object c(int i8);

    public abstract void d(int i8);

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f23962b < this.f23961a;
    }

    @Override // java.util.Iterator
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object objC = c(this.f23962b);
        this.f23962b++;
        this.f23963c = true;
        return objC;
    }

    @Override // java.util.Iterator
    public void remove() {
        if (!this.f23963c) {
            throw new IllegalStateException("Call next() before removing an element.".toString());
        }
        int i8 = this.f23962b - 1;
        this.f23962b = i8;
        d(i8);
        this.f23961a--;
        this.f23963c = false;
    }
}
