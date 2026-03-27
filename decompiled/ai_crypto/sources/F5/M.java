package F5;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public final class M extends AbstractC0545c implements RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f2347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2349d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2350e;

    public static final class a extends AbstractC0544b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2351c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2352d;

        public a() {
            this.f2351c = M.this.size();
            this.f2352d = M.this.f2349d;
        }

        @Override // F5.AbstractC0544b
        public void c() {
            if (this.f2351c == 0) {
                d();
                return;
            }
            e(M.this.f2347b[this.f2352d]);
            this.f2352d = (this.f2352d + 1) % M.this.f2348c;
            this.f2351c--;
        }
    }

    public M(Object[] buffer, int i7) {
        kotlin.jvm.internal.r.f(buffer, "buffer");
        this.f2347b = buffer;
        if (i7 < 0) {
            throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i7).toString());
        }
        if (i7 <= buffer.length) {
            this.f2348c = buffer.length;
            this.f2350e = i7;
            return;
        }
        throw new IllegalArgumentException(("ring buffer filled size: " + i7 + " cannot be larger than the buffer size: " + buffer.length).toString());
    }

    @Override // F5.AbstractC0543a
    public int a() {
        return this.f2350e;
    }

    @Override // F5.AbstractC0545c, java.util.List
    public Object get(int i7) {
        AbstractC0545c.f2367a.b(i7, size());
        return this.f2347b[(this.f2349d + i7) % this.f2348c];
    }

    @Override // F5.AbstractC0545c, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return new a();
    }

    public final void j(Object obj) {
        if (l()) {
            throw new IllegalStateException("ring buffer is full");
        }
        this.f2347b[(this.f2349d + size()) % this.f2348c] = obj;
        this.f2350e = size() + 1;
    }

    public final M k(int i7) {
        Object[] array;
        int i8 = this.f2348c;
        int iD = W5.l.d(i8 + (i8 >> 1) + 1, i7);
        if (this.f2349d == 0) {
            array = Arrays.copyOf(this.f2347b, iD);
            kotlin.jvm.internal.r.e(array, "copyOf(...)");
        } else {
            array = toArray(new Object[iD]);
        }
        return new M(array, size());
    }

    public final boolean l() {
        return size() == this.f2348c;
    }

    public final void m(int i7) {
        if (i7 < 0) {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + i7).toString());
        }
        if (i7 > size()) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i7 + ", size = " + size()).toString());
        }
        if (i7 > 0) {
            int i8 = this.f2349d;
            int i9 = (i8 + i7) % this.f2348c;
            if (i8 > i9) {
                AbstractC0551i.j(this.f2347b, null, i8, this.f2348c);
                AbstractC0551i.j(this.f2347b, null, 0, i9);
            } else {
                AbstractC0551i.j(this.f2347b, null, i8, i9);
            }
            this.f2349d = i9;
            this.f2350e = size() - i7;
        }
    }

    @Override // F5.AbstractC0543a, java.util.Collection, java.util.List
    public Object[] toArray(Object[] array) {
        kotlin.jvm.internal.r.f(array, "array");
        if (array.length < size()) {
            array = Arrays.copyOf(array, size());
            kotlin.jvm.internal.r.e(array, "copyOf(...)");
        }
        int size = size();
        int i7 = 0;
        int i8 = 0;
        for (int i9 = this.f2349d; i8 < size && i9 < this.f2348c; i9++) {
            array[i8] = this.f2347b[i9];
            i8++;
        }
        while (i8 < size) {
            array[i8] = this.f2347b[i7];
            i8++;
            i7++;
        }
        return AbstractC0555m.d(size, array);
    }

    public M(int i7) {
        this(new Object[i7], 0);
    }

    @Override // F5.AbstractC0543a, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
