package com.google.android.gms.internal.play_billing;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.n2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1374n2 extends AbstractC1313b1 implements RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object[] f15460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C1374n2 f15461e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f15462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15463c;

    static {
        Object[] objArr = new Object[0];
        f15460d = objArr;
        f15461e = new C1374n2(objArr, 0, false);
    }

    public C1374n2(Object[] objArr, int i8, boolean z7) {
        super(z7);
        this.f15462b = objArr;
        this.f15463c = i8;
    }

    public static C1374n2 d() {
        return f15461e;
    }

    public static int f(int i8) {
        return Math.max(((i8 * 3) / 2) + 1, 10);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i8, Object obj) {
        int i9;
        a();
        if (i8 < 0 || i8 > (i9 = this.f15463c)) {
            throw new IndexOutOfBoundsException(h(i8));
        }
        int i10 = i8 + 1;
        Object[] objArr = this.f15462b;
        int length = objArr.length;
        if (i9 < length) {
            System.arraycopy(objArr, i8, objArr, i10, i9 - i8);
        } else {
            Object[] objArr2 = new Object[f(length)];
            System.arraycopy(this.f15462b, 0, objArr2, 0, i8);
            System.arraycopy(this.f15462b, i8, objArr2, i10, this.f15463c - i8);
            this.f15462b = objArr2;
        }
        this.f15462b[i8] = obj;
        this.f15463c++;
        ((AbstractList) this).modCount++;
    }

    public final void e(int i8) {
        int length = this.f15462b.length;
        if (i8 <= length) {
            return;
        }
        if (length == 0) {
            this.f15462b = new Object[Math.max(i8, 10)];
            return;
        }
        while (length < i8) {
            length = f(length);
        }
        this.f15462b = Arrays.copyOf(this.f15462b, length);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i8) {
        n(i8);
        return this.f15462b[i8];
    }

    public final String h(int i8) {
        return "Index:" + i8 + ", Size:" + this.f15463c;
    }

    public final void n(int i8) {
        if (i8 < 0 || i8 >= this.f15463c) {
            throw new IndexOutOfBoundsException(h(i8));
        }
    }

    @Override // com.google.android.gms.internal.play_billing.AbstractC1313b1, java.util.AbstractList, java.util.List
    public final Object remove(int i8) {
        a();
        n(i8);
        Object[] objArr = this.f15462b;
        Object obj = objArr[i8];
        if (i8 < this.f15463c - 1) {
            System.arraycopy(objArr, i8 + 1, objArr, i8, (r2 - i8) - 1);
        }
        this.f15463c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i8, Object obj) {
        a();
        n(i8);
        Object[] objArr = this.f15462b;
        Object obj2 = objArr[i8];
        objArr[i8] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f15463c;
    }

    @Override // com.google.android.gms.internal.play_billing.O1
    public final /* bridge */ /* synthetic */ O1 zzd(int i8) {
        if (i8 >= this.f15463c) {
            return new C1374n2(i8 == 0 ? f15460d : Arrays.copyOf(this.f15462b, i8), this.f15463c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        a();
        int i8 = this.f15463c;
        int length = this.f15462b.length;
        if (i8 == length) {
            this.f15462b = Arrays.copyOf(this.f15462b, f(length));
        }
        Object[] objArr = this.f15462b;
        int i9 = this.f15463c;
        this.f15463c = i9 + 1;
        objArr[i9] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
