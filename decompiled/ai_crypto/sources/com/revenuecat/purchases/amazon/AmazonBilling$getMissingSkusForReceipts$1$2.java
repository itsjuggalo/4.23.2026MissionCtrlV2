package com.revenuecat.purchases.amazon;

import Q5.k;
import Q5.o;
import com.amazon.device.iap.model.Receipt;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class AmazonBilling$getMissingSkusForReceipts$1$2 extends s implements k {
    final /* synthetic */ Map<String, PurchasesError> $errorMap;
    final /* synthetic */ o $onCompletion;
    final /* synthetic */ Receipt $receipt;
    final /* synthetic */ E $receiptsLeft;
    final /* synthetic */ Map<String, String> $successMap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmazonBilling$getMissingSkusForReceipts$1$2(Map<String, PurchasesError> map, Receipt receipt, E e7, o oVar, Map<String, String> map2) {
        super(1);
        this.$errorMap = map;
        this.$receipt = receipt;
        this.$receiptsLeft = e7;
        this.$onCompletion = oVar;
        this.$successMap = map2;
    }

    @Override // Q5.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return E5.E.f1657a;
    }

    public final void invoke(PurchasesError error) {
        r.f(error, "error");
        LogIntent logIntent = LogIntent.AMAZON_ERROR;
        String str = String.format(AmazonStrings.ERROR_FETCHING_RECEIPT_INFO, Arrays.copyOf(new Object[]{error}, 1));
        r.e(str, "format(this, *args)");
        LogWrapperKt.log(logIntent, str);
        Map<String, PurchasesError> map = this.$errorMap;
        String receiptId = this.$receipt.getReceiptId();
        r.e(receiptId, "receipt.receiptId");
        map.put(receiptId, error);
        E e7 = this.$receiptsLeft;
        int i7 = e7.f18247a - 1;
        e7.f18247a = i7;
        if (i7 == 0) {
            this.$onCompletion.invoke(this.$successMap, this.$errorMap);
        }
    }
}
