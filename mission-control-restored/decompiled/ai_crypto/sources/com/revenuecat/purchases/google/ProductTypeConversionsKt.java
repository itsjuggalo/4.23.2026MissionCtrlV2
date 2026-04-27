package com.revenuecat.purchases.google;

import com.revenuecat.purchases.ProductType;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class ProductTypeConversionsKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProductType.values().length];
            try {
                iArr[ProductType.INAPP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProductType.SUBS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final String toGoogleProductType(ProductType productType) {
        r.f(productType, "<this>");
        int i7 = WhenMappings.$EnumSwitchMapping$0[productType.ordinal()];
        if (i7 == 1) {
            return "inapp";
        }
        if (i7 != 2) {
            return null;
        }
        return "subs";
    }

    public static final ProductType toRevenueCatProductType(String str) {
        return r.b(str, "inapp") ? ProductType.INAPP : r.b(str, "subs") ? ProductType.SUBS : ProductType.UNKNOWN;
    }
}
