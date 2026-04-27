package com.google.protobuf;

import com.google.protobuf.C;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: renamed from: com.google.protobuf.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1060g extends AbstractC1054c implements C.a, RandomAccess, h0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C1060g f11022d = new C1060g(new boolean[0], 0, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean[] f11023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11024c;

    public C1060g(boolean[] zArr, int i4, boolean z4) {
        super(z4);
        this.f11023b = zArr;
        this.f11024c = i4;
    }

    public static C1060g m() {
        return f11022d;
    }

    @Override // com.google.protobuf.AbstractC1054c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        c();
        C.a(collection);
        if (!(collection instanceof C1060g)) {
            return super.addAll(collection);
        }
        C1060g c1060g = (C1060g) collection;
        int i4 = c1060g.f11024c;
        if (i4 == 0) {
            return false;
        }
        int i5 = this.f11024c;
        if (Integer.MAX_VALUE - i5 < i4) {
            throw new OutOfMemoryError();
        }
        int i6 = i5 + i4;
        boolean[] zArr = this.f11023b;
        if (i6 > zArr.length) {
            this.f11023b = Arrays.copyOf(zArr, i6);
        }
        System.arraycopy(c1060g.f11023b, 0, this.f11023b, this.f11024c, c1060g.f11024c);
        this.f11024c = i6;
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
        if (!(obj instanceof C1060g)) {
            return super.equals(obj);
        }
        C1060g c1060g = (C1060g) obj;
        if (this.f11024c != c1060g.f11024c) {
            return false;
        }
        boolean[] zArr = c1060g.f11023b;
        for (int i4 = 0; i4 < this.f11024c; i4++) {
            if (this.f11023b[i4] != zArr[i4]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void add(int i4, Boolean bool) {
        k(i4, bool.booleanValue());
    }

    @Override // com.google.protobuf.AbstractC1054c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iC = 1;
        for (int i4 = 0; i4 < this.f11024c; i4++) {
            iC = (iC * 31) + C.c(this.f11023b[i4]);
        }
        return iC;
    }

    @Override // com.google.protobuf.AbstractC1054c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean add(Boolean bool) {
        l(bool.booleanValue());
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            if (this.f11023b[i4] == zBooleanValue) {
                return i4;
            }
        }
        return -1;
    }

    public final void k(int i4, boolean z4) {
        int i5;
        c();
        if (i4 < 0 || i4 > (i5 = this.f11024c)) {
            throw new IndexOutOfBoundsException(q(i4));
        }
        boolean[] zArr = this.f11023b;
        if (i5 < zArr.length) {
            System.arraycopy(zArr, i4, zArr, i4 + 1, i5 - i4);
        } else {
            boolean[] zArr2 = new boolean[((i5 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i4);
            System.arraycopy(this.f11023b, i4, zArr2, i4 + 1, this.f11024c - i4);
            this.f11023b = zArr2;
        }
        this.f11023b[i4] = z4;
        this.f11024c++;
        ((AbstractList) this).modCount++;
    }

    public void l(boolean z4) {
        c();
        int i4 = this.f11024c;
        boolean[] zArr = this.f11023b;
        if (i4 == zArr.length) {
            boolean[] zArr2 = new boolean[((i4 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i4);
            this.f11023b = zArr2;
        }
        boolean[] zArr3 = this.f11023b;
        int i5 = this.f11024c;
        this.f11024c = i5 + 1;
        zArr3[i5] = z4;
    }

    public final void n(int i4) {
        if (i4 < 0 || i4 >= this.f11024c) {
            throw new IndexOutOfBoundsException(q(i4));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Boolean get(int i4) {
        return Boolean.valueOf(p(i4));
    }

    public boolean p(int i4) {
        n(i4);
        return this.f11023b[i4];
    }

    public final String q(int i4) {
        return "Index:" + i4 + ", Size:" + this.f11024c;
    }

    @Override // com.google.protobuf.AbstractC1054c, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public Boolean remove(int i4) {
        c();
        n(i4);
        boolean[] zArr = this.f11023b;
        boolean z4 = zArr[i4];
        if (i4 < this.f11024c - 1) {
            System.arraycopy(zArr, i4 + 1, zArr, i4, (r2 - i4) - 1);
        }
        this.f11024c--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z4);
    }

    @Override // java.util.AbstractList
    public void removeRange(int i4, int i5) {
        c();
        if (i5 < i4) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.f11023b;
        System.arraycopy(zArr, i5, zArr, i4, this.f11024c - i5);
        this.f11024c -= i5 - i4;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public Boolean set(int i4, Boolean bool) {
        return Boolean.valueOf(t(i4, bool.booleanValue()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f11024c;
    }

    public boolean t(int i4, boolean z4) {
        c();
        n(i4);
        boolean[] zArr = this.f11023b;
        boolean z5 = zArr[i4];
        zArr[i4] = z4;
        return z5;
    }

    @Override // com.google.protobuf.C.i, com.google.protobuf.C.g
    public C.a a(int i4) {
        if (i4 >= this.f11024c) {
            return new C1060g(Arrays.copyOf(this.f11023b, i4), this.f11024c, true);
        }
        throw new IllegalArgumentException();
    }
}
