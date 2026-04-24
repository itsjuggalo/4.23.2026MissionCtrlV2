package com.google.protobuf;

import com.google.protobuf.C;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class B extends AbstractC1054c implements C.g, RandomAccess, h0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final B f10877d = new B(new int[0], 0, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f10878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10879c;

    public B(int[] iArr, int i4, boolean z4) {
        super(z4);
        this.f10878b = iArr;
        this.f10879c = i4;
    }

    public static B m() {
        return f10877d;
    }

    private void n(int i4) {
        if (i4 < 0 || i4 >= this.f10879c) {
            throw new IndexOutOfBoundsException(q(i4));
        }
    }

    private String q(int i4) {
        return "Index:" + i4 + ", Size:" + this.f10879c;
    }

    @Override // com.google.protobuf.AbstractC1054c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        c();
        C.a(collection);
        if (!(collection instanceof B)) {
            return super.addAll(collection);
        }
        B b4 = (B) collection;
        int i4 = b4.f10879c;
        if (i4 == 0) {
            return false;
        }
        int i5 = this.f10879c;
        if (Integer.MAX_VALUE - i5 < i4) {
            throw new OutOfMemoryError();
        }
        int i6 = i5 + i4;
        int[] iArr = this.f10878b;
        if (i6 > iArr.length) {
            this.f10878b = Arrays.copyOf(iArr, i6);
        }
        System.arraycopy(b4.f10878b, 0, this.f10878b, this.f10879c, b4.f10879c);
        this.f10879c = i6;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.protobuf.AbstractC1054c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof B)) {
            return super.equals(obj);
        }
        B b4 = (B) obj;
        if (this.f10879c != b4.f10879c) {
            return false;
        }
        int[] iArr = b4.f10878b;
        for (int i4 = 0; i4 < this.f10879c; i4++) {
            if (this.f10878b[i4] != iArr[i4]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void add(int i4, Integer num) {
        l(i4, num.intValue());
    }

    @Override // com.google.protobuf.AbstractC1054c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i4 = 1;
        for (int i5 = 0; i5 < this.f10879c; i5++) {
            i4 = (i4 * 31) + this.f10878b[i5];
        }
        return i4;
    }

    @Override // com.google.protobuf.AbstractC1054c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean add(Integer num) {
        k(num.intValue());
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            if (this.f10878b[i4] == iIntValue) {
                return i4;
            }
        }
        return -1;
    }

    public void k(int i4) {
        c();
        int i5 = this.f10879c;
        int[] iArr = this.f10878b;
        if (i5 == iArr.length) {
            int[] iArr2 = new int[((i5 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i5);
            this.f10878b = iArr2;
        }
        int[] iArr3 = this.f10878b;
        int i6 = this.f10879c;
        this.f10879c = i6 + 1;
        iArr3[i6] = i4;
    }

    public final void l(int i4, int i5) {
        int i6;
        c();
        if (i4 < 0 || i4 > (i6 = this.f10879c)) {
            throw new IndexOutOfBoundsException(q(i4));
        }
        int[] iArr = this.f10878b;
        if (i6 < iArr.length) {
            System.arraycopy(iArr, i4, iArr, i4 + 1, i6 - i4);
        } else {
            int[] iArr2 = new int[((i6 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i4);
            System.arraycopy(this.f10878b, i4, iArr2, i4 + 1, this.f10879c - i4);
            this.f10878b = iArr2;
        }
        this.f10878b[i4] = i5;
        this.f10879c++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Integer get(int i4) {
        return Integer.valueOf(p(i4));
    }

    public int p(int i4) {
        n(i4);
        return this.f10878b[i4];
    }

    @Override // com.google.protobuf.AbstractC1054c, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public Integer remove(int i4) {
        c();
        n(i4);
        int[] iArr = this.f10878b;
        int i5 = iArr[i4];
        if (i4 < this.f10879c - 1) {
            System.arraycopy(iArr, i4 + 1, iArr, i4, (r2 - i4) - 1);
        }
        this.f10879c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i5);
    }

    @Override // java.util.AbstractList
    public void removeRange(int i4, int i5) {
        c();
        if (i5 < i4) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f10878b;
        System.arraycopy(iArr, i5, iArr, i4, this.f10879c - i5);
        this.f10879c -= i5 - i4;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public Integer set(int i4, Integer num) {
        return Integer.valueOf(t(i4, num.intValue()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f10879c;
    }

    public int t(int i4, int i5) {
        c();
        n(i4);
        int[] iArr = this.f10878b;
        int i6 = iArr[i4];
        iArr[i4] = i5;
        return i6;
    }

    @Override // com.google.protobuf.C.i, com.google.protobuf.C.g
    public C.g a(int i4) {
        if (i4 >= this.f10879c) {
            return new B(Arrays.copyOf(this.f10878b, i4), this.f10879c, true);
        }
        throw new IllegalArgumentException();
    }
}
