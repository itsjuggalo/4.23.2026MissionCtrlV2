package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: kotlin.jvm.internal.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2287b implements Iterator, C5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f20484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f20485b;

    public C2287b(Object[] array) {
        AbstractC2304t.f(array, "array");
        this.f20484a = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f20485b < this.f20484a.length;
    }

    @Override // java.util.Iterator
    public Object next() {
        try {
            Object[] objArr = this.f20484a;
            int i8 = this.f20485b;
            this.f20485b = i8 + 1;
            return objArr[i8];
        } catch (ArrayIndexOutOfBoundsException e8) {
            this.f20485b--;
            throw new NoSuchElementException(e8.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
