package X2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import o3.AbstractC1681l;

/* JADX INFO: loaded from: classes3.dex */
public final class O extends AbstractC0757d implements RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f5585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5587d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5588e;

    public static final class a extends AbstractC0756c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f5589c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f5590d;

        public a() {
            this.f5589c = O.this.size();
            this.f5590d = O.this.f5587d;
        }

        @Override // X2.AbstractC0756c
        public void b() {
            if (this.f5589c == 0) {
                d();
                return;
            }
            e(O.this.f5585b[this.f5590d]);
            this.f5590d = (this.f5590d + 1) % O.this.f5586c;
            this.f5589c--;
        }
    }

    public O(Object[] buffer, int i4) {
        kotlin.jvm.internal.r.f(buffer, "buffer");
        this.f5585b = buffer;
        if (i4 < 0) {
            throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i4).toString());
        }
        if (i4 <= buffer.length) {
            this.f5586c = buffer.length;
            this.f5588e = i4;
            return;
        }
        throw new IllegalArgumentException(("ring buffer filled size: " + i4 + " cannot be larger than the buffer size: " + buffer.length).toString());
    }

    @Override // X2.AbstractC0757d, java.util.List
    public Object get(int i4) {
        AbstractC0757d.f5605a.b(i4, size());
        return this.f5585b[(this.f5587d + i4) % this.f5586c];
    }

    @Override // X2.AbstractC0755b
    public int i() {
        return this.f5588e;
    }

    @Override // X2.AbstractC0757d, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return new a();
    }

    public final void o(Object obj) {
        if (q()) {
            throw new IllegalStateException("ring buffer is full");
        }
        this.f5585b[(this.f5587d + size()) % this.f5586c] = obj;
        this.f5588e = size() + 1;
    }

    public final O p(int i4) {
        Object[] array;
        int i5 = this.f5586c;
        int iD = AbstractC1681l.d(i5 + (i5 >> 1) + 1, i4);
        if (this.f5587d == 0) {
            array = Arrays.copyOf(this.f5585b, iD);
            kotlin.jvm.internal.r.e(array, "copyOf(...)");
        } else {
            array = toArray(new Object[iD]);
        }
        return new O(array, size());
    }

    public final boolean q() {
        return size() == this.f5586c;
    }

    public final void r(int i4) {
        if (i4 < 0) {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + i4).toString());
        }
        if (i4 > size()) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i4 + ", size = " + size()).toString());
        }
        if (i4 > 0) {
            int i5 = this.f5587d;
            int i6 = (i5 + i4) % this.f5586c;
            if (i5 > i6) {
                AbstractC0763j.j(this.f5585b, null, i5, this.f5586c);
                AbstractC0763j.j(this.f5585b, null, 0, i6);
            } else {
                AbstractC0763j.j(this.f5585b, null, i5, i6);
            }
            this.f5587d = i6;
            this.f5588e = size() - i4;
        }
    }

    @Override // X2.AbstractC0755b, java.util.Collection, java.util.List
    public Object[] toArray(Object[] array) {
        kotlin.jvm.internal.r.f(array, "array");
        if (array.length < size()) {
            array = Arrays.copyOf(array, size());
            kotlin.jvm.internal.r.e(array, "copyOf(...)");
        }
        int size = size();
        int i4 = 0;
        int i5 = 0;
        for (int i6 = this.f5587d; i5 < size && i6 < this.f5586c; i6++) {
            array[i5] = this.f5585b[i6];
            i5++;
        }
        while (i5 < size) {
            array[i5] = this.f5585b[i4];
            i5++;
            i4++;
        }
        return AbstractC0768o.d(size, array);
    }

    public O(int i4) {
        this(new Object[i4], 0);
    }

    @Override // X2.AbstractC0755b, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
