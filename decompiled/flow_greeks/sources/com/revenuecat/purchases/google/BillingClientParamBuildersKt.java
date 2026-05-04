package com.revenuecat.purchases.google;

import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.common.LogWrapperKt;
import d3.t;
import d3.v;
import d3.w;
import dd.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a!\u0010\n\u001a\u00020\t*\u00020\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00000\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"", "Ld3/v;", "buildQueryPurchaseHistoryParams", "(Ljava/lang/String;)Ld3/v;", "Ld3/w;", "buildQueryPurchasesParams", "(Ljava/lang/String;)Ld3/w;", "", "productIds", "Ld3/t;", "buildQueryProductDetailsParams", "(Ljava/lang/String;Ljava/util/Set;)Ld3/t;", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BillingClientParamBuildersKt {
    public static final t buildQueryProductDetailsParams(String str, Set<String> productIds) throws QueryProductDetailsParamsBuilderException {
        kotlin.jvm.internal.t.f(str, "<this>");
        kotlin.jvm.internal.t.f(productIds, "productIds");
        ArrayList arrayList = new ArrayList(s.u(productIds, 10));
        Iterator<T> it = productIds.iterator();
        while (it.hasNext()) {
            arrayList.add(t.b.a().b((String) it.next()).c(str).a());
        }
        try {
            t tVarA = t.a().b(arrayList).a();
            kotlin.jvm.internal.t.e(tVarA, "{\n        QueryProductDe…roductList).build()\n    }");
            return tVarA;
        } catch (ExceptionInInitializerError e10) {
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Error while building QueryProductDetailsParams in Billing client");
            sb2.append(": ");
            sb2.append(e10.getMessage());
            sb2.append(". Caused by: ");
            Throwable cause = e10.getCause();
            sb2.append(cause != null ? cause.getMessage() : null);
            currentLogHandler.e("[Purchases] - ERROR", sb2.toString(), e10);
            throw new QueryProductDetailsParamsBuilderException("Error while building QueryProductDetailsParams in Billing client", e10.getCause());
        }
    }

    public static final v buildQueryPurchaseHistoryParams(String str) {
        kotlin.jvm.internal.t.f(str, "<this>");
        if (kotlin.jvm.internal.t.b(str, "inapp") ? true : kotlin.jvm.internal.t.b(str, "subs")) {
            return v.a().b(str).a();
        }
        return null;
    }

    public static final w buildQueryPurchasesParams(String str) {
        kotlin.jvm.internal.t.f(str, "<this>");
        if (kotlin.jvm.internal.t.b(str, "inapp") ? true : kotlin.jvm.internal.t.b(str, "subs")) {
            return w.a().b(str).a();
        }
        return null;
    }
}
