package com.google.android.gms.internal.play_billing;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class P {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f15200a = new Object[8];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f15201b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public O f15202c;

    public final P a(Object obj, Object obj2) {
        int i8 = this.f15201b + 1;
        Object[] objArr = this.f15200a;
        int length = objArr.length;
        int i9 = i8 + i8;
        if (i9 > length) {
            if (i9 > length) {
                length = length + (length >> 1) + 1;
                if (length < i9) {
                    int iHighestOneBit = Integer.highestOneBit(i9 - 1);
                    length = iHighestOneBit + iHighestOneBit;
                }
                if (length < 0) {
                    length = Integer.MAX_VALUE;
                }
            }
            this.f15200a = Arrays.copyOf(objArr, length);
        }
        I.a(obj, obj2);
        Object[] objArr2 = this.f15200a;
        int i10 = this.f15201b;
        int i11 = i10 + i10;
        objArr2[i11] = obj;
        objArr2[i11 + 1] = obj2;
        this.f15201b = i10 + 1;
        return this;
    }

    public final Q b() {
        O o8 = this.f15202c;
        if (o8 != null) {
            throw o8.a();
        }
        C1312b0 c1312b0G = C1312b0.g(this.f15201b, this.f15200a, this);
        O o9 = this.f15202c;
        if (o9 == null) {
            return c1312b0G;
        }
        throw o9.a();
    }
}
