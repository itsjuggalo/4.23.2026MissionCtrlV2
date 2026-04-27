package com.google.protobuf;

import com.google.protobuf.C;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class M extends AbstractC1054c implements C.h, RandomAccess, h0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final M f10958d = new M(new long[0], 0, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long[] f10959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10960c;

    public M(long[] jArr, int i4, boolean z4) {
        super(z4);
        this.f10959b = jArr;
        this.f10960c = i4;
    }

    public static M m() {
        return f10958d;
    }

    private void n(int i4) {
        if (i4 < 0 || i4 >= this.f10960c) {
            throw new IndexOutOfBoundsException(q(i4));
        }
    }

    private String q(int i4) {
        return "Index:" + i4 + ", Size:" + this.f10960c;
    }

    @Override // com.google.protobuf.AbstractC1054c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        c();
        C.a(collection);
        if (!(collection instanceof M)) {
            return super.addAll(collection);
        }
        M m4 = (M) collection;
        int i4 = m4.f10960c;
        if (i4 == 0) {
            return false;
        }
        int i5 = this.f10960c;
        if (Integer.MAX_VALUE - i5 < i4) {
            throw new OutOfMemoryError();
        }
        int i6 = i5 + i4;
        long[] jArr = this.f10959b;
        if (i6 > jArr.length) {
            this.f10959b = Arrays.copyOf(jArr, i6);
        }
        System.arraycopy(m4.f10959b, 0, this.f10959b, this.f10960c, m4.f10960c);
        this.f10960c = i6;
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
        if (!(obj instanceof M)) {
            return super.equals(obj);
        }
        M m4 = (M) obj;
        if (this.f10960c != m4.f10960c) {
            return false;
        }
        long[] jArr = m4.f10959b;
        for (int i4 = 0; i4 < this.f10960c; i4++) {
            if (this.f10959b[i4] != jArr[i4]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void add(int i4, Long l4) {
        k(i4, l4.longValue());
    }

    @Override // com.google.protobuf.AbstractC1054c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iF = 1;
        for (int i4 = 0; i4 < this.f10960c; i4++) {
            iF = (iF * 31) + C.f(this.f10959b[i4]);
        }
        return iF;
    }

    @Override // com.google.protobuf.AbstractC1054c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean add(Long l4) {
        l(l4.longValue());
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            if (this.f10959b[i4] == jLongValue) {
                return i4;
            }
        }
        return -1;
    }

    public final void k(int i4, long j4) {
        int i5;
        c();
        if (i4 < 0 || i4 > (i5 = this.f10960c)) {
            throw new IndexOutOfBoundsException(q(i4));
        }
        long[] jArr = this.f10959b;
        if (i5 < jArr.length) {
            System.arraycopy(jArr, i4, jArr, i4 + 1, i5 - i4);
        } else {
            long[] jArr2 = new long[((i5 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i4);
            System.arraycopy(this.f10959b, i4, jArr2, i4 + 1, this.f10960c - i4);
            this.f10959b = jArr2;
        }
        this.f10959b[i4] = j4;
        this.f10960c++;
        ((AbstractList) this).modCount++;
    }

    public void l(long j4) {
        c();
        int i4 = this.f10960c;
        long[] jArr = this.f10959b;
        if (i4 == jArr.length) {
            long[] jArr2 = new long[((i4 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i4);
            this.f10959b = jArr2;
        }
        long[] jArr3 = this.f10959b;
        int i5 = this.f10960c;
        this.f10960c = i5 + 1;
        jArr3[i5] = j4;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Long get(int i4) {
        return Long.valueOf(p(i4));
    }

    public long p(int i4) {
        n(i4);
        return this.f10959b[i4];
    }

    @Override // com.google.protobuf.AbstractC1054c, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public Long remove(int i4) {
        c();
        n(i4);
        long[] jArr = this.f10959b;
        long j4 = jArr[i4];
        if (i4 < this.f10960c - 1) {
            System.arraycopy(jArr, i4 + 1, jArr, i4, (r3 - i4) - 1);
        }
        this.f10960c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j4);
    }

    @Override // java.util.AbstractList
    public void removeRange(int i4, int i5) {
        c();
        if (i5 < i4) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.f10959b;
        System.arraycopy(jArr, i5, jArr, i4, this.f10960c - i5);
        this.f10960c -= i5 - i4;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public Long set(int i4, Long l4) {
        return Long.valueOf(t(i4, l4.longValue()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f10960c;
    }

    public long t(int i4, long j4) {
        c();
        n(i4);
        long[] jArr = this.f10959b;
        long j5 = jArr[i4];
        jArr[i4] = j4;
        return j5;
    }

    @Override // com.google.protobuf.C.i, com.google.protobuf.C.g
    public C.h a(int i4) {
        if (i4 >= this.f10960c) {
            return new M(Arrays.copyOf(this.f10959b, i4), this.f10960c, true);
        }
        throw new IllegalArgumentException();
    }
}
