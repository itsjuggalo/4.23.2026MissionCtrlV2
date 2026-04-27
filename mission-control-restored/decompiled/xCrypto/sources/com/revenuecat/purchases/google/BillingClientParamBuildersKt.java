package com.revenuecat.purchases.google;

import H0.C0314p;
import H0.C0315q;
import X2.AbstractC0770q;
import com.android.billingclient.api.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class BillingClientParamBuildersKt {
    public static final com.android.billingclient.api.g buildQueryProductDetailsParams(String str, Set<String> productIds) {
        r.f(str, "<this>");
        r.f(productIds, "productIds");
        ArrayList arrayList = new ArrayList(AbstractC0770q.q(productIds, 10));
        Iterator<T> it = productIds.iterator();
        while (it.hasNext()) {
            arrayList.add(g.b.a().b((String) it.next()).c(str).a());
        }
        com.android.billingclient.api.g gVarA = com.android.billingclient.api.g.a().b(arrayList).a();
        r.e(gVarA, "newBuilder()\n        .se…List(productList).build()");
        return gVarA;
    }

    public static final C0314p buildQueryPurchaseHistoryParams(String str) {
        r.f(str, "<this>");
        if (r.b(str, "inapp") ? true : r.b(str, "subs")) {
            return C0314p.a().b(str).a();
        }
        return null;
    }

    public static final C0315q buildQueryPurchasesParams(String str) {
        r.f(str, "<this>");
        if (r.b(str, "inapp") ? true : r.b(str, "subs")) {
            return C0315q.a().b(str).a();
        }
        return null;
    }
}
