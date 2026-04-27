package com.google.protobuf;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class I extends AbstractC0452b implements K, RandomAccess, InterfaceC0477n0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final I f5646d = new I(new int[0], 0, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f5647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5648c;

    public I(int[] iArr, int i, boolean z6) {
        super(z6);
        this.f5647b = iArr;
        this.f5648c = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i6;
        int iIntValue = ((Integer) obj).intValue();
        a();
        if (i < 0 || i > (i6 = this.f5648c)) {
            StringBuilder sbO = a3.d.o("Index:", i, ", Size:");
            sbO.append(this.f5648c);
            throw new IndexOutOfBoundsException(sbO.toString());
        }
        int[] iArr = this.f5647b;
        if (i6 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i6 - i);
        } else {
            int[] iArr2 = new int[a3.d.d(i6, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.f5647b, i, iArr2, i + 1, this.f5648c - i);
            this.f5647b = iArr2;
        }
        this.f5647b[i] = iIntValue;
        this.f5648c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractC0452b, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        a();
        Charset charset = M.f5651a;
        collection.getClass();
        if (!(collection instanceof I)) {
            return super.addAll(collection);
        }
        I i = (I) collection;
        int i6 = i.f5648c;
        if (i6 == 0) {
            return false;
        }
        int i7 = this.f5648c;
        if (com.google.android.gms.common.api.f.API_PRIORITY_OTHER - i7 < i6) {
            throw new OutOfMemoryError();
        }
        int i8 = i7 + i6;
        int[] iArr = this.f5647b;
        if (i8 > iArr.length) {
            this.f5647b = Arrays.copyOf(iArr, i8);
        }
        System.arraycopy(i.f5647b, 0, this.f5647b, this.f5648c, i.f5648c);
        this.f5648c = i8;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void b(int i) {
        a();
        int i6 = this.f5648c;
        int[] iArr = this.f5647b;
        if (i6 == iArr.length) {
            int[] iArr2 = new int[a3.d.d(i6, 3, 2, 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i6);
            this.f5647b = iArr2;
        }
        int[] iArr3 = this.f5647b;
        int i7 = this.f5648c;
        this.f5648c = i7 + 1;
        iArr3[i7] = i;
    }

    public final void c(int i) {
        if (i < 0 || i >= this.f5648c) {
            StringBuilder sbO = a3.d.o("Index:", i, ", Size:");
            sbO.append(this.f5648c);
            throw new IndexOutOfBoundsException(sbO.toString());
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.protobuf.L
    public final L d(int i) {
        if (i >= this.f5648c) {
            return new I(Arrays.copyOf(this.f5647b, i), this.f5648c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractC0452b, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof I)) {
            return super.equals(obj);
        }
        I i = (I) obj;
        if (this.f5648c != i.f5648c) {
            return false;
        }
        int[] iArr = i.f5647b;
        for (int i6 = 0; i6 < this.f5648c; i6++) {
            if (this.f5647b[i6] != iArr[i6]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        c(i);
        return Integer.valueOf(this.f5647b[i]);
    }

    @Override // com.google.protobuf.AbstractC0452b, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i6 = 0; i6 < this.f5648c; i6++) {
            i = (i * 31) + this.f5647b[i6];
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i = this.f5648c;
        for (int i6 = 0; i6 < i; i6++) {
            if (this.f5647b[i6] == iIntValue) {
                return i6;
            }
        }
        return -1;
    }

    @Override // com.google.protobuf.AbstractC0452b, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        a();
        c(i);
        int[] iArr = this.f5647b;
        int i6 = iArr[i];
        if (i < this.f5648c - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (r2 - i) - 1);
        }
        this.f5648c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i6);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i6) {
        a();
        if (i6 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f5647b;
        System.arraycopy(iArr, i6, iArr, i, this.f5648c - i6);
        this.f5648c -= i6 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        a();
        c(i);
        int[] iArr = this.f5647b;
        int i6 = iArr[i];
        iArr[i] = iIntValue;
        return Integer.valueOf(i6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f5648c;
    }

    @Override // com.google.protobuf.AbstractC0452b, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        b(((Integer) obj).intValue());
        return true;
    }
}
