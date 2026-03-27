package com.revenuecat.purchases.common;

import F5.v;
import com.android.billingclient.api.PurchaseHistoryRecord;
import java.util.ArrayList;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class PurchaseHistoryRecordExtensionsKt {
    public static final String getFirstSku(PurchaseHistoryRecord purchaseHistoryRecord) {
        r.f(purchaseHistoryRecord, "<this>");
        Object obj = purchaseHistoryRecord.f().get(0);
        String str = (String) obj;
        if (purchaseHistoryRecord.f().size() > 1) {
            LogWrapperKt.log(LogIntent.GOOGLE_WARNING, "There's more than one sku in the PurchaseHistoryRecord, but only one will be used.");
        }
        r.e(obj, "skus[0].also {\n        i…_ONE_SKU)\n        }\n    }");
        return str;
    }

    public static final ArrayList<String> getListOfSkus(PurchaseHistoryRecord purchaseHistoryRecord) {
        r.f(purchaseHistoryRecord, "<this>");
        ArrayList<String> arrayListF = purchaseHistoryRecord.f();
        r.e(arrayListF, "this.skus");
        return arrayListF;
    }

    public static final String toHumanReadableDescription(PurchaseHistoryRecord purchaseHistoryRecord) {
        r.f(purchaseHistoryRecord, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append("skus: ");
        ArrayList arrayListF = purchaseHistoryRecord.f();
        r.e(arrayListF, "this.skus");
        sb.append(v.R(arrayListF, null, "[", "]", 0, null, null, 57, null));
        sb.append(", purchaseTime: ");
        sb.append(purchaseHistoryRecord.c());
        sb.append(", purchaseToken: ");
        sb.append(purchaseHistoryRecord.d());
        return sb.toString();
    }
}
