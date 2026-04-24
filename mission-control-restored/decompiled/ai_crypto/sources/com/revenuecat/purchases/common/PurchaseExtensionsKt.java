package com.revenuecat.purchases.common;

import F5.v;
import com.android.billingclient.api.Purchase;
import java.util.List;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class PurchaseExtensionsKt {
    public static final String getFirstProductId(Purchase purchase) {
        r.f(purchase, "<this>");
        Object obj = purchase.c().get(0);
        String str = (String) obj;
        if (purchase.c().size() > 1) {
            LogWrapperKt.log(LogIntent.GOOGLE_WARNING, "There's more than one sku in the PurchaseHistoryRecord, but only one will be used.");
        }
        r.e(obj, "products[0].also {\n     …_ONE_SKU)\n        }\n    }");
        return str;
    }

    public static final String toHumanReadableDescription(Purchase purchase) {
        r.f(purchase, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append("productIds: ");
        List listC = purchase.c();
        r.e(listC, "this.products");
        sb.append(v.R(listC, null, "[", "]", 0, null, null, 57, null));
        sb.append(", orderId: ");
        sb.append(purchase.a());
        sb.append(", purchaseToken: ");
        sb.append(purchase.f());
        return sb.toString();
    }
}
