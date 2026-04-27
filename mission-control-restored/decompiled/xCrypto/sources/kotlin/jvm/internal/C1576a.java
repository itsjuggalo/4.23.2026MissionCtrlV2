package kotlin.jvm.internal;

import j3.InterfaceC1564a;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: kotlin.jvm.internal.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1576a implements Iterator, InterfaceC1564a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f13415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13416b;

    public C1576a(Object[] array) {
        r.f(array, "array");
        this.f13415a = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f13416b < this.f13415a.length;
    }

    @Override // java.util.Iterator
    public Object next() {
        try {
            Object[] objArr = this.f13415a;
            int i4 = this.f13416b;
            this.f13416b = i4 + 1;
            return objArr[i4];
        } catch (ArrayIndexOutOfBoundsException e4) {
            this.f13416b--;
            throw new NoSuchElementException(e4.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
