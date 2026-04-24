package com.revenuecat.purchases.google;

import F5.AbstractC0557o;
import Y0.C0735p;
import Y0.C0736q;
import com.android.billingclient.api.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class BillingClientParamBuildersKt {
    public static final com.android.billingclient.api.g buildQueryProductDetailsParams(String str, Set<String> productIds) {
        r.f(str, "<this>");
        r.f(productIds, "productIds");
        ArrayList arrayList = new ArrayList(AbstractC0557o.q(productIds, 10));
        Iterator<T> it = productIds.iterator();
        while (it.hasNext()) {
            arrayList.add(g.b.a().b((String) it.next()).c(str).a());
        }
        com.android.billingclient.api.g gVarA = com.android.billingclient.api.g.a().b(arrayList).a();
        r.e(gVarA, "newBuilder()\n        .se…List(productList).build()");
        return gVarA;
    }

    public static final C0735p buildQueryPurchaseHistoryParams(String str) {
        r.f(str, "<this>");
        if (r.b(str, "inapp") ? true : r.b(str, "subs")) {
            return C0735p.a().b(str).a();
        }
        return null;
    }

    public static final C0736q buildQueryPurchasesParams(String str) {
        r.f(str, "<this>");
        if (r.b(str, "inapp") ? true : r.b(str, "subs")) {
            return C0736q.a().b(str).a();
        }
        return null;
    }
}
