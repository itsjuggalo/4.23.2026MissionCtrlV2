package com.revenuecat.purchases.google;

import com.revenuecat.purchases.ProductType;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000\u001a\u000e\u0010\u0003\u001a\u00020\u0002*\u0004\u0018\u00010\u0001H\u0000¨\u0006\u0004"}, d2 = {"toGoogleProductType", "", "Lcom/revenuecat/purchases/ProductType;", "toRevenueCatProductType", "purchases_defaultsRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ProductTypeConversionsKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
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
        AbstractC2304t.f(productType, "<this>");
        int i8 = WhenMappings.$EnumSwitchMapping$0[productType.ordinal()];
        if (i8 == 1) {
            return "inapp";
        }
        if (i8 != 2) {
            return null;
        }
        return "subs";
    }

    public static final ProductType toRevenueCatProductType(String str) {
        return AbstractC2304t.b(str, "inapp") ? ProductType.INAPP : AbstractC2304t.b(str, "subs") ? ProductType.SUBS : ProductType.UNKNOWN;
    }
}
