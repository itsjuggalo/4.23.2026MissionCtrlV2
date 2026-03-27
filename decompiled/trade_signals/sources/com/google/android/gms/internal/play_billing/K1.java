package com.google.android.gms.internal.play_billing;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class K1 extends AbstractC1313b1 implements RandomAccess, N1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f15171d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final K1 f15172e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f15173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15174c;

    static {
        int[] iArr = new int[0];
        f15171d = iArr;
        f15172e = new K1(iArr, 0, false);
    }

    public K1(int[] iArr, int i8, boolean z7) {
        super(z7);
        this.f15173b = iArr;
        this.f15174c = i8;
    }

    public static K1 e() {
        return f15172e;
    }

    public static int n(int i8) {
        return Math.max(((i8 * 3) / 2) + 1, 10);
    }

    public final String C(int i8) {
        return "Index:" + i8 + ", Size:" + this.f15174c;
    }

    public final void F(int i8) {
        if (i8 < 0 || i8 >= this.f15174c) {
            throw new IndexOutOfBoundsException(C(i8));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i8, Object obj) {
        int i9;
        int iIntValue = ((Integer) obj).intValue();
        a();
        if (i8 < 0 || i8 > (i9 = this.f15174c)) {
            throw new IndexOutOfBoundsException(C(i8));
        }
        int i10 = i8 + 1;
        int[] iArr = this.f15173b;
        int length = iArr.length;
        if (i9 < length) {
            System.arraycopy(iArr, i8, iArr, i10, i9 - i8);
        } else {
            int[] iArr2 = new int[n(length)];
            System.arraycopy(this.f15173b, 0, iArr2, 0, i8);
            System.arraycopy(this.f15173b, i8, iArr2, i10, this.f15174c - i8);
            this.f15173b = iArr2;
        }
        this.f15173b[i8] = iIntValue;
        this.f15174c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1313b1, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        a();
        Charset charset = P1.f15203a;
        collection.getClass();
        if (!(collection instanceof K1)) {
            return super.addAll(collection);
        }
        K1 k12 = (K1) collection;
        int i8 = k12.f15174c;
        if (i8 == 0) {
            return false;
        }
        int i9 = this.f15174c;
        if (Integer.MAX_VALUE - i9 < i8) {
            throw new OutOfMemoryError();
        }
        int i10 = i9 + i8;
        int[] iArr = this.f15173b;
        if (i10 > iArr.length) {
            this.f15173b = Arrays.copyOf(iArr, i10);
        }
        System.arraycopy(k12.f15173b, 0, this.f15173b, this.f15174c, k12.f15174c);
        this.f15174c = i10;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final int d(int i8) {
        F(i8);
        return this.f15173b[i8];
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1313b1, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof K1)) {
            return super.equals(obj);
        }
        K1 k12 = (K1) obj;
        if (this.f15174c != k12.f15174c) {
            return false;
        }
        int[] iArr = k12.f15173b;
        for (int i8 = 0; i8 < this.f15174c; i8++) {
            if (this.f15173b[i8] != iArr[i8]) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i8) {
        a();
        int i9 = this.f15174c;
        int length = this.f15173b.length;
        if (i9 == length) {
            int[] iArr = new int[n(length)];
            System.arraycopy(this.f15173b, 0, iArr, 0, this.f15174c);
            this.f15173b = iArr;
        }
        int[] iArr2 = this.f15173b;
        int i10 = this.f15174c;
        this.f15174c = i10 + 1;
        iArr2[i10] = i8;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i8) {
        F(i8);
        return Integer.valueOf(this.f15173b[i8]);
    }

    public final void h(int i8) {
        int length = this.f15173b.length;
        if (i8 <= length) {
            return;
        }
        if (length == 0) {
            this.f15173b = new int[Math.max(i8, 10)];
            return;
        }
        while (length < i8) {
            length = n(length);
        }
        this.f15173b = Arrays.copyOf(this.f15173b, length);
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1313b1, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i8 = 1;
        for (int i9 = 0; i9 < this.f15174c; i9++) {
            i8 = (i8 * 31) + this.f15173b[i9];
        }
        return i8;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i8 = this.f15174c;
        for (int i9 = 0; i9 < i8; i9++) {
            if (this.f15173b[i9] == iIntValue) {
                return i9;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1313b1, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i8) {
        a();
        F(i8);
        int[] iArr = this.f15173b;
        int i9 = iArr[i8];
        if (i8 < this.f15174c - 1) {
            System.arraycopy(iArr, i8 + 1, iArr, i8, (r2 - i8) - 1);
        }
        this.f15174c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i9);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i8, int i9) {
        a();
        if (i9 < i8) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f15173b;
        System.arraycopy(iArr, i9, iArr, i8, this.f15174c - i9);
        this.f15174c -= i9 - i8;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i8, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        a();
        F(i8);
        int[] iArr = this.f15173b;
        int i9 = iArr[i8];
        iArr[i8] = iIntValue;
        return Integer.valueOf(i9);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f15174c;
    }

    @Override // com.google.android.gms.internal.play_billing.O1
    public final /* bridge */ /* synthetic */ O1 zzd(int i8) {
        if (i8 >= this.f15174c) {
            return new K1(i8 == 0 ? f15171d : Arrays.copyOf(this.f15173b, i8), this.f15174c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        f(((Integer) obj).intValue());
        return true;
    }
}
