package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: kotlin.jvm.internal.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2139a implements Iterator, R5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f18254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f18255b;

    public C2139a(Object[] array) {
        r.f(array, "array");
        this.f18254a = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f18255b < this.f18254a.length;
    }

    @Override // java.util.Iterator
    public Object next() {
        try {
            Object[] objArr = this.f18254a;
            int i7 = this.f18255b;
            this.f18255b = i7 + 1;
            return objArr[i7];
        } catch (ArrayIndexOutOfBoundsException e7) {
            this.f18255b--;
            throw new NoSuchElementException(e7.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
