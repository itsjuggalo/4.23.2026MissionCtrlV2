package com.revenuecat.purchases.hybridcommon.mappers;

/* JADX INFO: loaded from: classes2.dex */
class PurchasesMath {
    public static int addExact(int i7, int i8) {
        int i9 = i7 + i8;
        if (((i7 ^ i9) & (i8 ^ i9)) >= 0) {
            return i9;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int multiplyExact(int i7, int i8) {
        long j7 = ((long) i7) * ((long) i8);
        int i9 = (int) j7;
        if (i9 == j7) {
            return i9;
        }
        throw new ArithmeticException("integer overflow");
    }
}
