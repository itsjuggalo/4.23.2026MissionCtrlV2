package com.google.protobuf;

import com.google.android.gms.common.api.a;
import com.google.protobuf.c0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b0 extends c implements c0.d, RandomAccess, f1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b0 f6934d = new b0(new int[0], 0, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f6935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6936c;

    public b0(int[] iArr, int i10, boolean z10) {
        super(z10);
        this.f6935b = iArr;
        this.f6936c = i10;
    }

    public static b0 g() {
        return f6934d;
    }

    private void p(int i10) {
        if (i10 < 0 || i10 >= this.f6936c) {
            throw new IndexOutOfBoundsException(s(i10));
        }
    }

    private String s(int i10) {
        return "Index:" + i10 + ", Size:" + this.f6936c;
    }

    @Override // com.google.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        a();
        c0.a(collection);
        if (!(collection instanceof b0)) {
            return super.addAll(collection);
        }
        b0 b0Var = (b0) collection;
        int i10 = b0Var.f6936c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f6936c;
        if (a.e.API_PRIORITY_OTHER - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        int[] iArr = this.f6935b;
        if (i12 > iArr.length) {
            this.f6935b = Arrays.copyOf(iArr, i12);
        }
        System.arraycopy(b0Var.f6935b, 0, this.f6935b, this.f6936c, b0Var.f6936c);
        this.f6936c = i12;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void add(int i10, Integer num) {
        f(i10, num.intValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean add(Integer num) {
        e(num.intValue());
        return true;
    }

    public void e(int i10) {
        a();
        int i11 = this.f6936c;
        int[] iArr = this.f6935b;
        if (i11 == iArr.length) {
            int[] iArr2 = new int[((i11 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i11);
            this.f6935b = iArr2;
        }
        int[] iArr3 = this.f6935b;
        int i12 = this.f6936c;
        this.f6936c = i12 + 1;
        iArr3[i12] = i10;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return super.equals(obj);
        }
        b0 b0Var = (b0) obj;
        if (this.f6936c != b0Var.f6936c) {
            return false;
        }
        int[] iArr = b0Var.f6935b;
        for (int i10 = 0; i10 < this.f6936c; i10++) {
            if (this.f6935b[i10] != iArr[i10]) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i10, int i11) {
        int i12;
        a();
        if (i10 < 0 || i10 > (i12 = this.f6936c)) {
            throw new IndexOutOfBoundsException(s(i10));
        }
        int[] iArr = this.f6935b;
        if (i12 < iArr.length) {
            System.arraycopy(iArr, i10, iArr, i10 + 1, i12 - i10);
        } else {
            int[] iArr2 = new int[((i12 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i10);
            System.arraycopy(this.f6935b, i10, iArr2, i10 + 1, this.f6936c - i10);
            this.f6935b = iArr2;
        }
        this.f6935b[i10] = i11;
        this.f6936c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f6936c; i11++) {
            i10 = (i10 * 31) + this.f6935b[i11];
        }
        return i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f6935b[i10] == iIntValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public Integer get(int i10) {
        return Integer.valueOf(r(i10));
    }

    public int r(int i10) {
        p(i10);
        return this.f6935b[i10];
    }

    @Override // java.util.AbstractList
    public void removeRange(int i10, int i11) {
        a();
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f6935b;
        System.arraycopy(iArr, i11, iArr, i10, this.f6936c - i11);
        this.f6936c -= i11 - i10;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f6936c;
    }

    @Override // com.google.protobuf.c0.e
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public c0.d i(int i10) {
        if (i10 >= this.f6936c) {
            return new b0(Arrays.copyOf(this.f6935b, i10), this.f6936c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public Integer remove(int i10) {
        a();
        p(i10);
        int[] iArr = this.f6935b;
        int i11 = iArr[i10];
        if (i10 < this.f6936c - 1) {
            System.arraycopy(iArr, i10 + 1, iArr, i10, (r2 - i10) - 1);
        }
        this.f6936c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i11);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public Integer set(int i10, Integer num) {
        return Integer.valueOf(y(i10, num.intValue()));
    }

    public int y(int i10, int i11) {
        a();
        p(i10);
        int[] iArr = this.f6935b;
        int i12 = iArr[i10];
        iArr[i10] = i11;
        return i12;
    }
}
