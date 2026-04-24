package q;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: q.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0915g implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f9125d = false;
    public final /* synthetic */ C0909a e;

    public C0915g(C0909a c0909a, int i) {
        this.e = c0909a;
        this.f9122a = i;
        this.f9123b = c0909a.d();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f9124c < this.f9123b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object objB = this.e.b(this.f9124c, this.f9122a);
        this.f9124c++;
        this.f9125d = true;
        return objB;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f9125d) {
            throw new IllegalStateException();
        }
        int i = this.f9124c - 1;
        this.f9124c = i;
        this.f9123b--;
        this.f9125d = false;
        this.e.g(i);
    }
}
