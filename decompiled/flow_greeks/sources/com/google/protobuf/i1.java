package com.google.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i1 extends c implements RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i1 f7013d = new i1(new Object[0], 0, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f7014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7015c;

    public i1(Object[] objArr, int i10, boolean z10) {
        super(z10);
        this.f7014b = objArr;
        this.f7015c = i10;
    }

    public static Object[] c(int i10) {
        return new Object[i10];
    }

    public static i1 d() {
        return f7013d;
    }

    private void e(int i10) {
        if (i10 < 0 || i10 >= this.f7015c) {
            throw new IndexOutOfBoundsException(f(i10));
        }
    }

    private String f(int i10) {
        return "Index:" + i10 + ", Size:" + this.f7015c;
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        a();
        int i10 = this.f7015c;
        Object[] objArr = this.f7014b;
        if (i10 == objArr.length) {
            this.f7014b = Arrays.copyOf(objArr, ((i10 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f7014b;
        int i11 = this.f7015c;
        this.f7015c = i11 + 1;
        objArr2[i11] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.protobuf.c0.e
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public i1 i(int i10) {
        if (i10 >= this.f7015c) {
            return new i1(Arrays.copyOf(this.f7014b, i10), this.f7015c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i10) {
        e(i10);
        return this.f7014b[i10];
    }

    @Override // com.google.protobuf.c, java.util.AbstractList, java.util.List
    public Object remove(int i10) {
        a();
        e(i10);
        Object[] objArr = this.f7014b;
        Object obj = objArr[i10];
        if (i10 < this.f7015c - 1) {
            System.arraycopy(objArr, i10 + 1, objArr, i10, (r2 - i10) - 1);
        }
        this.f7015c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i10, Object obj) {
        a();
        e(i10);
        Object[] objArr = this.f7014b;
        Object obj2 = objArr[i10];
        objArr[i10] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f7015c;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i10, Object obj) {
        int i11;
        a();
        if (i10 >= 0 && i10 <= (i11 = this.f7015c)) {
            Object[] objArr = this.f7014b;
            if (i11 < objArr.length) {
                System.arraycopy(objArr, i10, objArr, i10 + 1, i11 - i10);
            } else {
                Object[] objArrC = c(((i11 * 3) / 2) + 1);
                System.arraycopy(this.f7014b, 0, objArrC, 0, i10);
                System.arraycopy(this.f7014b, i10, objArrC, i10 + 1, this.f7015c - i10);
                this.f7014b = objArrC;
            }
            this.f7014b[i10] = obj;
            this.f7015c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(f(i10));
    }
}
