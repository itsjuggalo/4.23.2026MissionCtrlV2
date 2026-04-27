package com.revenuecat.purchases.google.usecase;

import E5.E;
import Q5.k;
import com.revenuecat.purchases.PostReceiptInitiationSource;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.google.BillingResultExtensionsKt;
import com.revenuecat.purchases.google.ErrorsKt;
import com.revenuecat.purchases.strings.PurchaseStrings;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes2.dex */
public final class AcknowledgePurchaseUseCase$executeAsync$1$1$1 extends s implements k {
    final /* synthetic */ AcknowledgePurchaseUseCase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AcknowledgePurchaseUseCase$executeAsync$1$1$1(AcknowledgePurchaseUseCase acknowledgePurchaseUseCase) {
        super(1);
        this.this$0 = acknowledgePurchaseUseCase;
    }

    @Override // Q5.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((com.android.billingclient.api.d) obj);
        return E.f1657a;
    }

    public final void invoke(com.android.billingclient.api.d errorBillingResult) {
        String str;
        r.f(errorBillingResult, "errorBillingResult");
        if (errorBillingResult.b() == 8 && this.this$0.useCaseParams.getInitiationSource() == PostReceiptInitiationSource.RESTORE) {
            LogIntent logIntent = LogIntent.GOOGLE_WARNING;
            str = PurchaseStrings.ACKNOWLEDGING_PURCHASE_ERROR_RESTORE;
            LogWrapperKt.log(logIntent, PurchaseStrings.ACKNOWLEDGING_PURCHASE_ERROR_RESTORE);
        } else {
            str = this.this$0.getErrorMessage() + " - " + BillingResultExtensionsKt.toHumanReadableDescription(errorBillingResult);
            LogWrapperKt.log(LogIntent.GOOGLE_ERROR, str);
        }
        this.this$0.getOnError().invoke(ErrorsKt.billingResponseToPurchasesError(errorBillingResult.b(), str));
    }
}
