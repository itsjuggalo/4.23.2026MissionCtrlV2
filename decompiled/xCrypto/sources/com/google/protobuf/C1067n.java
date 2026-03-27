package com.google.protobuf;

import com.google.protobuf.C;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: renamed from: com.google.protobuf.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1067n extends AbstractC1054c implements C.b, RandomAccess, h0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C1067n f11119d = new C1067n(new double[0], 0, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double[] f11120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11121c;

    public C1067n(double[] dArr, int i4, boolean z4) {
        super(z4);
        this.f11120b = dArr;
        this.f11121c = i4;
    }

    public static C1067n m() {
        return f11119d;
    }

    private void n(int i4) {
        if (i4 < 0 || i4 >= this.f11121c) {
            throw new IndexOutOfBoundsException(q(i4));
        }
    }

    private String q(int i4) {
        return "Index:" + i4 + ", Size:" + this.f11121c;
    }

    @Override // com.google.protobuf.AbstractC1054c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        c();
        C.a(collection);
        if (!(collection instanceof C1067n)) {
            return super.addAll(collection);
        }
        C1067n c1067n = (C1067n) collection;
        int i4 = c1067n.f11121c;
        if (i4 == 0) {
            return false;
        }
        int i5 = this.f11121c;
        if (Integer.MAX_VALUE - i5 < i4) {
            throw new OutOfMemoryError();
        }
        int i6 = i5 + i4;
        double[] dArr = this.f11120b;
        if (i6 > dArr.length) {
            this.f11120b = Arrays.copyOf(dArr, i6);
        }
        System.arraycopy(c1067n.f11120b, 0, this.f11120b, this.f11121c, c1067n.f11121c);
        this.f11121c = i6;
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
        if (!(obj instanceof C1067n)) {
            return super.equals(obj);
        }
        C1067n c1067n = (C1067n) obj;
        if (this.f11121c != c1067n.f11121c) {
            return false;
        }
        double[] dArr = c1067n.f11120b;
        for (int i4 = 0; i4 < this.f11121c; i4++) {
            if (Double.doubleToLongBits(this.f11120b[i4]) != Double.doubleToLongBits(dArr[i4])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void add(int i4, Double d4) {
        l(i4, d4.doubleValue());
    }

    @Override // com.google.protobuf.AbstractC1054c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iF = 1;
        for (int i4 = 0; i4 < this.f11121c; i4++) {
            iF = (iF * 31) + C.f(Double.doubleToLongBits(this.f11120b[i4]));
        }
        return iF;
    }

    @Override // com.google.protobuf.AbstractC1054c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean add(Double d4) {
        k(d4.doubleValue());
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            if (this.f11120b[i4] == dDoubleValue) {
                return i4;
            }
        }
        return -1;
    }

    public void k(double d4) {
        c();
        int i4 = this.f11121c;
        double[] dArr = this.f11120b;
        if (i4 == dArr.length) {
            double[] dArr2 = new double[((i4 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i4);
            this.f11120b = dArr2;
        }
        double[] dArr3 = this.f11120b;
        int i5 = this.f11121c;
        this.f11121c = i5 + 1;
        dArr3[i5] = d4;
    }

    public final void l(int i4, double d4) {
        int i5;
        c();
        if (i4 < 0 || i4 > (i5 = this.f11121c)) {
            throw new IndexOutOfBoundsException(q(i4));
        }
        double[] dArr = this.f11120b;
        if (i5 < dArr.length) {
            System.arraycopy(dArr, i4, dArr, i4 + 1, i5 - i4);
        } else {
            double[] dArr2 = new double[((i5 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i4);
            System.arraycopy(this.f11120b, i4, dArr2, i4 + 1, this.f11121c - i4);
            this.f11120b = dArr2;
        }
        this.f11120b[i4] = d4;
        this.f11121c++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Double get(int i4) {
        return Double.valueOf(p(i4));
    }

    public double p(int i4) {
        n(i4);
        return this.f11120b[i4];
    }

    @Override // com.google.protobuf.AbstractC1054c, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public Double remove(int i4) {
        c();
        n(i4);
        double[] dArr = this.f11120b;
        double d4 = dArr[i4];
        if (i4 < this.f11121c - 1) {
            System.arraycopy(dArr, i4 + 1, dArr, i4, (r3 - i4) - 1);
        }
        this.f11121c--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d4);
    }

    @Override // java.util.AbstractList
    public void removeRange(int i4, int i5) {
        c();
        if (i5 < i4) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.f11120b;
        System.arraycopy(dArr, i5, dArr, i4, this.f11121c - i5);
        this.f11121c -= i5 - i4;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public Double set(int i4, Double d4) {
        return Double.valueOf(t(i4, d4.doubleValue()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f11121c;
    }

    public double t(int i4, double d4) {
        c();
        n(i4);
        double[] dArr = this.f11120b;
        double d5 = dArr[i4];
        dArr[i4] = d4;
        return d5;
    }

    @Override // com.google.protobuf.C.i, com.google.protobuf.C.g
    public C.b a(int i4) {
        if (i4 >= this.f11121c) {
            return new C1067n(Arrays.copyOf(this.f11120b, i4), this.f11121c, true);
        }
        throw new IllegalArgumentException();
    }
}
