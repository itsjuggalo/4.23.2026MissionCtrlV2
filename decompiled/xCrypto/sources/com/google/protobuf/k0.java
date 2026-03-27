package com.google.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class k0 extends AbstractC1054c implements RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final k0 f11097d = new k0(new Object[0], 0, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f11098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11099c;

    public k0(Object[] objArr, int i4, boolean z4) {
        super(z4);
        this.f11098b = objArr;
        this.f11099c = i4;
    }

    public static Object[] f(int i4) {
        return new Object[i4];
    }

    public static k0 i() {
        return f11097d;
    }

    private void k(int i4) {
        if (i4 < 0 || i4 >= this.f11099c) {
            throw new IndexOutOfBoundsException(l(i4));
        }
    }

    private String l(int i4) {
        return "Index:" + i4 + ", Size:" + this.f11099c;
    }

    @Override // com.google.protobuf.AbstractC1054c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        c();
        int i4 = this.f11099c;
        Object[] objArr = this.f11098b;
        if (i4 == objArr.length) {
            this.f11098b = Arrays.copyOf(objArr, ((i4 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f11098b;
        int i5 = this.f11099c;
        this.f11099c = i5 + 1;
        objArr2[i5] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i4) {
        k(i4);
        return this.f11098b[i4];
    }

    @Override // com.google.protobuf.C.i, com.google.protobuf.C.g
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public k0 a(int i4) {
        if (i4 >= this.f11099c) {
            return new k0(Arrays.copyOf(this.f11098b, i4), this.f11099c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractC1054c, java.util.AbstractList, java.util.List
    public Object remove(int i4) {
        c();
        k(i4);
        Object[] objArr = this.f11098b;
        Object obj = objArr[i4];
        if (i4 < this.f11099c - 1) {
            System.arraycopy(objArr, i4 + 1, objArr, i4, (r2 - i4) - 1);
        }
        this.f11099c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i4, Object obj) {
        c();
        k(i4);
        Object[] objArr = this.f11098b;
        Object obj2 = objArr[i4];
        objArr[i4] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f11099c;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i4, Object obj) {
        int i5;
        c();
        if (i4 >= 0 && i4 <= (i5 = this.f11099c)) {
            Object[] objArr = this.f11098b;
            if (i5 < objArr.length) {
                System.arraycopy(objArr, i4, objArr, i4 + 1, i5 - i4);
            } else {
                Object[] objArrF = f(((i5 * 3) / 2) + 1);
                System.arraycopy(this.f11098b, 0, objArrF, 0, i4);
                System.arraycopy(this.f11098b, i4, objArrF, i4 + 1, this.f11099c - i4);
                this.f11098b = objArrF;
            }
            this.f11098b[i4] = obj;
            this.f11099c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(l(i4));
    }
}
