package com.revenuecat.purchases.hybridcommon.mappers;

import W2.m;
import com.revenuecat.purchases.ProductType;

/* JADX INFO: loaded from: classes3.dex */
public enum MappedProductCategory {
    SUBSCRIPTION("SUBSCRIPTION"),
    NON_SUBSCRIPTION("NON_SUBSCRIPTION"),
    UNKNOWN("UNKNOWN");

    private final String value;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MappedProductCategory.values().length];
            try {
                iArr[MappedProductCategory.NON_SUBSCRIPTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MappedProductCategory.SUBSCRIPTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MappedProductCategory.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    MappedProductCategory(String str) {
        this.value = str;
    }

    public final ProductType getToProductType() {
        int i4 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i4 == 1) {
            return ProductType.INAPP;
        }
        if (i4 == 2) {
            return ProductType.SUBS;
        }
        if (i4 == 3) {
            return ProductType.UNKNOWN;
        }
        throw new m();
    }

    public final String getValue() {
        return this.value;
    }
}
