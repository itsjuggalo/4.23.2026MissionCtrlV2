package dd;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class s0 extends d implements RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f8022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8024d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8025e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8026c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8027d;

        public a() {
            this.f8026c = s0.this.size();
            this.f8027d = s0.this.f8024d;
        }

        @Override // dd.c
        public void c() {
            if (this.f8026c == 0) {
                e();
                return;
            }
            f(s0.this.f8022b[this.f8027d]);
            this.f8027d = (this.f8027d + 1) % s0.this.f8023c;
            this.f8026c--;
        }
    }

    public s0(Object[] buffer, int i10) {
        kotlin.jvm.internal.t.f(buffer, "buffer");
        this.f8022b = buffer;
        if (i10 < 0) {
            throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i10).toString());
        }
        if (i10 <= buffer.length) {
            this.f8023c = buffer.length;
            this.f8025e = i10;
            return;
        }
        throw new IllegalArgumentException(("ring buffer filled size: " + i10 + " cannot be larger than the buffer size: " + buffer.length).toString());
    }

    @Override // dd.b
    public int c() {
        return this.f8025e;
    }

    @Override // dd.d, java.util.List
    public Object get(int i10) {
        d.f7994a.b(i10, size());
        return this.f8022b[(this.f8024d + i10) % this.f8023c];
    }

    @Override // dd.d, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return new a();
    }

    public final void q(Object obj) {
        if (s()) {
            throw new IllegalStateException("ring buffer is full");
        }
        this.f8022b[(this.f8024d + size()) % this.f8023c] = obj;
        this.f8025e = size() + 1;
    }

    public final s0 r(int i10) {
        Object[] array;
        int i11 = this.f8023c;
        int iD = vd.l.d(i11 + (i11 >> 1) + 1, i10);
        if (this.f8024d == 0) {
            array = Arrays.copyOf(this.f8022b, iD);
            kotlin.jvm.internal.t.e(array, "copyOf(...)");
        } else {
            array = toArray(new Object[iD]);
        }
        return new s0(array, size());
    }

    public final boolean s() {
        return size() == this.f8023c;
    }

    @Override // dd.b, java.util.Collection
    public Object[] toArray(Object[] array) {
        kotlin.jvm.internal.t.f(array, "array");
        if (array.length < size()) {
            array = Arrays.copyOf(array, size());
            kotlin.jvm.internal.t.e(array, "copyOf(...)");
        }
        int size = size();
        int i10 = 0;
        int i11 = 0;
        for (int i12 = this.f8024d; i11 < size && i12 < this.f8023c; i12++) {
            array[i11] = this.f8022b[i12];
            i11++;
        }
        while (i11 < size) {
            array[i11] = this.f8022b[i10];
            i11++;
            i10++;
        }
        return q.g(size, array);
    }

    public final void u(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + i10).toString());
        }
        if (i10 > size()) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i10 + ", size = " + size()).toString());
        }
        if (i10 > 0) {
            int i11 = this.f8024d;
            int i12 = (i11 + i10) % this.f8023c;
            if (i11 > i12) {
                l.n(this.f8022b, null, i11, this.f8023c);
                l.n(this.f8022b, null, 0, i12);
            } else {
                l.n(this.f8022b, null, i11, i12);
            }
            this.f8024d = i12;
            this.f8025e = size() - i10;
        }
    }

    public s0(int i10) {
        this(new Object[i10], 0);
    }

    @Override // dd.b, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
