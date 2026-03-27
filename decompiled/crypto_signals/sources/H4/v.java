package H4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class v extends d implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f587d;

    public v(Object[] objArr, int i) {
        this.f584a = objArr;
        if (i < 0) {
            throw new IllegalArgumentException(a3.d.f(i, "ring buffer filled size should not be negative but it is ").toString());
        }
        if (i <= objArr.length) {
            this.f585b = objArr.length;
            this.f587d = i;
        } else {
            StringBuilder sbO = a3.d.o("ring buffer filled size: ", i, " cannot be larger than the buffer size: ");
            sbO.append(objArr.length);
            throw new IllegalArgumentException(sbO.toString().toString());
        }
    }

    @Override // H4.d
    public final int a() {
        return this.f587d;
    }

    public final void c() {
        if (20 > this.f587d) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = 20, size = " + this.f587d).toString());
        }
        int i = this.f586c;
        int i6 = this.f585b;
        int i7 = (i + 20) % i6;
        Object[] objArr = this.f584a;
        if (i > i7) {
            g.g0(objArr, i, i6);
            g.g0(objArr, 0, i7);
        } else {
            g.g0(objArr, i, i7);
        }
        this.f586c = i7;
        this.f587d -= 20;
    }

    @Override // java.util.List
    public final Object get(int i) {
        int iA = a();
        if (i < 0 || i >= iA) {
            throw new IndexOutOfBoundsException(a3.d.h("index: ", i, iA, ", size: "));
        }
        return this.f584a[(this.f586c + i) % this.f585b];
    }

    @Override // H4.d, java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new u(this);
    }

    @Override // H4.d, java.util.List, java.util.Collection
    public final Object[] toArray() {
        return toArray(new Object[a()]);
    }

    @Override // H4.d, java.util.List, java.util.Collection
    public final Object[] toArray(Object[] array) {
        Object[] objArr;
        kotlin.jvm.internal.j.e(array, "array");
        int length = array.length;
        int i = this.f587d;
        if (length < i) {
            array = Arrays.copyOf(array, i);
            kotlin.jvm.internal.j.d(array, "copyOf(...)");
        }
        int i6 = this.f587d;
        int i7 = this.f586c;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            objArr = this.f584a;
            if (i9 >= i6 || i7 >= this.f585b) {
                break;
            }
            array[i9] = objArr[i7];
            i9++;
            i7++;
        }
        while (i9 < i6) {
            array[i9] = objArr[i8];
            i9++;
            i8++;
        }
        if (i6 < array.length) {
            array[i6] = null;
        }
        return array;
    }
}
