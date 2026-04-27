package com.revenuecat.purchases.hybridcommon.mappers;

import W2.o;
import W2.t;
import X2.L;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.hybridcommon.ErrorContainer;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class PurchasesErrorKt {
    public static final ErrorContainer map(PurchasesError purchasesError, Map<String, ? extends Object> extra) {
        r.f(purchasesError, "<this>");
        r.f(extra, "extra");
        int code = purchasesError.getCode().getCode();
        String message = purchasesError.getMessage();
        o oVarA = t.a("code", Integer.valueOf(purchasesError.getCode().getCode()));
        o oVarA2 = t.a(Constants.MESSAGE, purchasesError.getMessage());
        o oVarA3 = t.a("readableErrorCode", purchasesError.getCode().name());
        o oVarA4 = t.a("readable_error_code", purchasesError.getCode().name());
        String underlyingErrorMessage = purchasesError.getUnderlyingErrorMessage();
        if (underlyingErrorMessage == null) {
            underlyingErrorMessage = "";
        }
        return new ErrorContainer(code, message, L.k(L.g(oVarA, oVarA2, oVarA3, oVarA4, t.a("underlyingErrorMessage", underlyingErrorMessage)), extra));
    }

    public static /* synthetic */ ErrorContainer map$default(PurchasesError purchasesError, Map map, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            map = L.e();
        }
        return map(purchasesError, map);
    }
}
