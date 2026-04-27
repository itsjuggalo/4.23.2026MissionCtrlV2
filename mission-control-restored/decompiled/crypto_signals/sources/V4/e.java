package V4;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Iterator, S4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3304d;

    public e(int i, int i6, int i7) {
        this.f3301a = i7;
        this.f3302b = i6;
        boolean z6 = false;
        if (i7 <= 0 ? i >= i6 : i <= i6) {
            z6 = true;
        }
        this.f3303c = z6;
        this.f3304d = z6 ? i : i6;
    }

    public final int a() {
        int i = this.f3304d;
        if (i != this.f3302b) {
            this.f3304d = this.f3301a + i;
            return i;
        }
        if (!this.f3303c) {
            throw new NoSuchElementException();
        }
        this.f3303c = false;
        return i;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3303c;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return Integer.valueOf(a());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
