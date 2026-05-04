package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements Iterator, qd.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f14930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14931b;

    public b(Object[] array) {
        t.f(array, "array");
        this.f14930a = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f14931b < this.f14930a.length;
    }

    @Override // java.util.Iterator
    public Object next() {
        try {
            Object[] objArr = this.f14930a;
            int i10 = this.f14931b;
            this.f14931b = i10 + 1;
            return objArr[i10];
        } catch (ArrayIndexOutOfBoundsException e10) {
            this.f14931b--;
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
