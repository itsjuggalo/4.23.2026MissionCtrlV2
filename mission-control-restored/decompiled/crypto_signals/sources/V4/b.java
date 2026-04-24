package V4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.j;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Iterator, S4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3297d;

    public b(char c6, char c7, int i) {
        this.f3294a = i;
        this.f3295b = c7;
        boolean z6 = false;
        if (i <= 0 ? j.f(c6, c7) >= 0 : j.f(c6, c7) <= 0) {
            z6 = true;
        }
        this.f3296c = z6;
        this.f3297d = z6 ? c6 : c7;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3296c;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.f3297d;
        if (i != this.f3295b) {
            this.f3297d = this.f3294a + i;
        } else {
            if (!this.f3296c) {
                throw new NoSuchElementException();
            }
            this.f3296c = false;
        }
        return Character.valueOf((char) i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
