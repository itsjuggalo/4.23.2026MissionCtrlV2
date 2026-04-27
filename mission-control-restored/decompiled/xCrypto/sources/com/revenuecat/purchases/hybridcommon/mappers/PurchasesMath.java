package com.revenuecat.purchases.hybridcommon.mappers;

/* JADX INFO: loaded from: classes3.dex */
class PurchasesMath {
    public static int addExact(int i4, int i5) {
        int i6 = i4 + i5;
        if (((i4 ^ i6) & (i5 ^ i6)) >= 0) {
            return i6;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int multiplyExact(int i4, int i5) {
        long j4 = ((long) i4) * ((long) i5);
        int i6 = (int) j4;
        if (i6 == j4) {
            return i6;
        }
        throw new ArithmeticException("integer overflow");
    }
}
