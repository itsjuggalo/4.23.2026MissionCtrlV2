package com.revenuecat.purchases;

import E5.m;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class PurchasesAreCompletedByKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PurchasesAreCompletedBy.values().length];
            try {
                iArr[PurchasesAreCompletedBy.REVENUECAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PurchasesAreCompletedBy.MY_APP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean getFinishTransactions(PurchasesAreCompletedBy purchasesAreCompletedBy) {
        r.f(purchasesAreCompletedBy, "<this>");
        int i7 = WhenMappings.$EnumSwitchMapping$0[purchasesAreCompletedBy.ordinal()];
        if (i7 == 1) {
            return true;
        }
        if (i7 == 2) {
            return false;
        }
        throw new m();
    }
}
