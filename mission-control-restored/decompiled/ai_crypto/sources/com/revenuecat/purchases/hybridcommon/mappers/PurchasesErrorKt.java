package com.revenuecat.purchases.hybridcommon.mappers;

import E5.o;
import E5.t;
import F5.J;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.hybridcommon.ErrorContainer;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class PurchasesErrorKt {
    public static final ErrorContainer map(PurchasesError purchasesError, Map<String, ? extends Object> extra) {
        r.f(purchasesError, "<this>");
        r.f(extra, "extra");
        int code = purchasesError.getCode().getCode();
        String message = purchasesError.getMessage();
        o oVarA = t.a("code", Integer.valueOf(purchasesError.getCode().getCode()));
        o oVarA2 = t.a("message", purchasesError.getMessage());
        o oVarA3 = t.a("readableErrorCode", purchasesError.getCode().name());
        o oVarA4 = t.a("readable_error_code", purchasesError.getCode().name());
        String underlyingErrorMessage = purchasesError.getUnderlyingErrorMessage();
        if (underlyingErrorMessage == null) {
            underlyingErrorMessage = "";
        }
        return new ErrorContainer(code, message, J.k(J.g(oVarA, oVarA2, oVarA3, oVarA4, t.a("underlyingErrorMessage", underlyingErrorMessage)), extra));
    }

    public static /* synthetic */ ErrorContainer map$default(PurchasesError purchasesError, Map map, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            map = J.e();
        }
        return map(purchasesError, map);
    }
}
