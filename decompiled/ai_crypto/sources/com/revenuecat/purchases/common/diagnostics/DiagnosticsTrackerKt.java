package com.revenuecat.purchases.common.diagnostics;

import E5.m;
import com.revenuecat.purchases.ProductType;

/* JADX INFO: loaded from: classes2.dex */
public final class DiagnosticsTrackerKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProductType.values().length];
            try {
                iArr[ProductType.SUBS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProductType.INAPP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProductType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getDiagnosticsName(ProductType productType) {
        int i7 = WhenMappings.$EnumSwitchMapping$0[productType.ordinal()];
        if (i7 == 1) {
            return "AUTO_RENEWABLE_SUBSCRIPTION";
        }
        if (i7 == 2) {
            return "NON_SUBSCRIPTION";
        }
        if (i7 == 3) {
            return "UNKNOWN";
        }
        throw new m();
    }
}
