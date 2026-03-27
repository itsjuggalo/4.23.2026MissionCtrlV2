package com.google.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class V extends AbstractC1464c implements RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final V f16323d = new V(new Object[0], 0, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f16324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f16325c;

    public V(Object[] objArr, int i8, boolean z7) {
        super(z7);
        this.f16324b = objArr;
        this.f16325c = i8;
    }

    public static Object[] d(int i8) {
        return new Object[i8];
    }

    public static V e() {
        return f16323d;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i8, Object obj) {
        int i9;
        a();
        if (i8 < 0 || i8 > (i9 = this.f16325c)) {
            throw new IndexOutOfBoundsException(h(i8));
        }
        Object[] objArr = this.f16324b;
        if (i9 < objArr.length) {
            System.arraycopy(objArr, i8, objArr, i8 + 1, i9 - i8);
        } else {
            Object[] objArrD = d(((i9 * 3) / 2) + 1);
            System.arraycopy(this.f16324b, 0, objArrD, 0, i8);
            System.arraycopy(this.f16324b, i8, objArrD, i8 + 1, this.f16325c - i8);
            this.f16324b = objArrD;
        }
        this.f16324b[i8] = obj;
        this.f16325c++;
        ((AbstractList) this).modCount++;
    }

    public final void f(int i8) {
        if (i8 < 0 || i8 >= this.f16325c) {
            throw new IndexOutOfBoundsException(h(i8));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i8) {
        f(i8);
        return this.f16324b[i8];
    }

    public final String h(int i8) {
        return "Index:" + i8 + ", Size:" + this.f16325c;
    }

    @Override // com.google.protobuf.AbstractC1481u.d
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public V i(int i8) {
        if (i8 >= this.f16325c) {
            return new V(Arrays.copyOf(this.f16324b, i8), this.f16325c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractC1464c, java.util.AbstractList, java.util.List
    public Object remove(int i8) {
        a();
        f(i8);
        Object[] objArr = this.f16324b;
        Object obj = objArr[i8];
        if (i8 < this.f16325c - 1) {
            System.arraycopy(objArr, i8 + 1, objArr, i8, (r2 - i8) - 1);
        }
        this.f16325c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i8, Object obj) {
        a();
        f(i8);
        Object[] objArr = this.f16324b;
        Object obj2 = objArr[i8];
        objArr[i8] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f16325c;
    }

    @Override // com.google.protobuf.AbstractC1464c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        a();
        int i8 = this.f16325c;
        Object[] objArr = this.f16324b;
        if (i8 == objArr.length) {
            this.f16324b = Arrays.copyOf(objArr, ((i8 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f16324b;
        int i9 = this.f16325c;
        this.f16325c = i9 + 1;
        objArr2[i9] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
