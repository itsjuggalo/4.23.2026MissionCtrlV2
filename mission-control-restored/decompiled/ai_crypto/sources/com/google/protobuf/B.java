package com.google.protobuf;

import com.google.android.gms.common.api.a;
import com.google.protobuf.C;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class B extends AbstractC1233c implements C.d, RandomAccess, g0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final B f12506d = new B(new int[0], 0, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f12507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12508c;

    public B(int[] iArr, int i7, boolean z7) {
        super(z7);
        this.f12507b = iArr;
        this.f12508c = i7;
    }

    public static B j() {
        return f12506d;
    }

    private void k(int i7) {
        if (i7 < 0 || i7 >= this.f12508c) {
            throw new IndexOutOfBoundsException(n(i7));
        }
    }

    private String n(int i7) {
        return "Index:" + i7 + ", Size:" + this.f12508c;
    }

    @Override // com.google.protobuf.AbstractC1233c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        a();
        C.a(collection);
        if (!(collection instanceof B)) {
            return super.addAll(collection);
        }
        B b7 = (B) collection;
        int i7 = b7.f12508c;
        if (i7 == 0) {
            return false;
        }
        int i8 = this.f12508c;
        if (a.e.API_PRIORITY_OTHER - i8 < i7) {
            throw new OutOfMemoryError();
        }
        int i9 = i8 + i7;
        int[] iArr = this.f12507b;
        if (i9 > iArr.length) {
            this.f12507b = Arrays.copyOf(iArr, i9);
        }
        System.arraycopy(b7.f12507b, 0, this.f12507b, this.f12508c, b7.f12508c);
        this.f12508c = i9;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void add(int i7, Integer num) {
        h(i7, num.intValue());
    }

    @Override // com.google.protobuf.AbstractC1233c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean add(Integer num) {
        g(num.intValue());
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.protobuf.AbstractC1233c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof B)) {
            return super.equals(obj);
        }
        B b7 = (B) obj;
        if (this.f12508c != b7.f12508c) {
            return false;
        }
        int[] iArr = b7.f12507b;
        for (int i7 = 0; i7 < this.f12508c; i7++) {
            if (this.f12507b[i7] != iArr[i7]) {
                return false;
            }
        }
        return true;
    }

    public void g(int i7) {
        a();
        int i8 = this.f12508c;
        int[] iArr = this.f12507b;
        if (i8 == iArr.length) {
            int[] iArr2 = new int[((i8 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i8);
            this.f12507b = iArr2;
        }
        int[] iArr3 = this.f12507b;
        int i9 = this.f12508c;
        this.f12508c = i9 + 1;
        iArr3[i9] = i7;
    }

    public final void h(int i7, int i8) {
        int i9;
        a();
        if (i7 < 0 || i7 > (i9 = this.f12508c)) {
            throw new IndexOutOfBoundsException(n(i7));
        }
        int[] iArr = this.f12507b;
        if (i9 < iArr.length) {
            System.arraycopy(iArr, i7, iArr, i7 + 1, i9 - i7);
        } else {
            int[] iArr2 = new int[((i9 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i7);
            System.arraycopy(this.f12507b, i7, iArr2, i7 + 1, this.f12508c - i7);
            this.f12507b = iArr2;
        }
        this.f12507b[i7] = i8;
        this.f12508c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractC1233c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i7 = 1;
        for (int i8 = 0; i8 < this.f12508c; i8++) {
            i7 = (i7 * 31) + this.f12507b[i8];
        }
        return i7;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int size = size();
        for (int i7 = 0; i7 < size; i7++) {
            if (this.f12507b[i7] == iIntValue) {
                return i7;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public Integer get(int i7) {
        return Integer.valueOf(m(i7));
    }

    public int m(int i7) {
        k(i7);
        return this.f12507b[i7];
    }

    @Override // com.google.protobuf.C.e
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public C.d e(int i7) {
        if (i7 >= this.f12508c) {
            return new B(Arrays.copyOf(this.f12507b, i7), this.f12508c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractC1233c, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public Integer remove(int i7) {
        a();
        k(i7);
        int[] iArr = this.f12507b;
        int i8 = iArr[i7];
        if (i7 < this.f12508c - 1) {
            System.arraycopy(iArr, i7 + 1, iArr, i7, (r2 - i7) - 1);
        }
        this.f12508c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i8);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public Integer set(int i7, Integer num) {
        return Integer.valueOf(s(i7, num.intValue()));
    }

    @Override // java.util.AbstractList
    public void removeRange(int i7, int i8) {
        a();
        if (i8 < i7) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f12507b;
        System.arraycopy(iArr, i8, iArr, i7, this.f12508c - i8);
        this.f12508c -= i8 - i7;
        ((AbstractList) this).modCount++;
    }

    public int s(int i7, int i8) {
        a();
        k(i7);
        int[] iArr = this.f12507b;
        int i9 = iArr[i7];
        iArr[i7] = i8;
        return i9;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f12508c;
    }
}
