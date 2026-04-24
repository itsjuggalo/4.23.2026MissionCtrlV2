package com.revenuecat.purchases.google;

import R0.C0838u;
import R0.C0840w;
import R0.C0841x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;
import p5.r;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a!\u0010\n\u001a\u00020\t*\u00020\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00000\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"", "LR0/w;", "buildQueryPurchaseHistoryParams", "(Ljava/lang/String;)LR0/w;", "LR0/x;", "buildQueryPurchasesParams", "(Ljava/lang/String;)LR0/x;", "", "productIds", "LR0/u;", "buildQueryProductDetailsParams", "(Ljava/lang/String;Ljava/util/Set;)LR0/u;", "purchases_defaultsRelease"}, k = 2, mv = {1, 8, 0})
public final class BillingClientParamBuildersKt {
    public static final C0838u buildQueryProductDetailsParams(String str, Set<String> productIds) {
        AbstractC2304t.f(str, "<this>");
        AbstractC2304t.f(productIds, "productIds");
        ArrayList arrayList = new ArrayList(r.s(productIds, 10));
        Iterator<T> it = productIds.iterator();
        while (it.hasNext()) {
            arrayList.add(C0838u.b.a().b((String) it.next()).c(str).a());
        }
        C0838u c0838uA = C0838u.a().b(arrayList).a();
        AbstractC2304t.e(c0838uA, "newBuilder()\n        .se…List(productList).build()");
        return c0838uA;
    }

    public static final C0840w buildQueryPurchaseHistoryParams(String str) {
        AbstractC2304t.f(str, "<this>");
        if (AbstractC2304t.b(str, "inapp") ? true : AbstractC2304t.b(str, "subs")) {
            return C0840w.a().b(str).a();
        }
        return null;
    }

    public static final C0841x buildQueryPurchasesParams(String str) {
        AbstractC2304t.f(str, "<this>");
        if (AbstractC2304t.b(str, "inapp") ? true : AbstractC2304t.b(str, "subs")) {
            return C0841x.a().b(str).a();
        }
        return null;
    }
}
