package com.revenuecat.purchases;

import W2.E;
import X2.x;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.models.PurchaseState;
import com.revenuecat.purchases.models.StoreTransaction;
import i3.o;
import java.util.List;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class PostTransactionWithProductDetailsHelper {
    private final BillingAbstract billing;
    private final PostReceiptHelper postReceiptHelper;

    public PostTransactionWithProductDetailsHelper(BillingAbstract billing, PostReceiptHelper postReceiptHelper) {
        r.f(billing, "billing");
        r.f(postReceiptHelper, "postReceiptHelper");
        this.billing = billing;
        this.postReceiptHelper = postReceiptHelper;
    }

    public static /* synthetic */ void postTransactions$default(PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper, List list, boolean z4, String str, PostReceiptInitiationSource postReceiptInitiationSource, o oVar, o oVar2, int i4, Object obj) {
        if ((i4 & 16) != 0) {
            oVar = null;
        }
        if ((i4 & 32) != 0) {
            oVar2 = null;
        }
        postTransactionWithProductDetailsHelper.postTransactions(list, z4, str, postReceiptInitiationSource, oVar, oVar2);
    }

    public final void postTransactions(List<StoreTransaction> transactions, boolean z4, String appUserID, PostReceiptInitiationSource postReceiptInitiationSource, o oVar, o oVar2) {
        r.f(transactions, "transactions");
        r.f(appUserID, "appUserID");
        PostReceiptInitiationSource initiationSource = postReceiptInitiationSource;
        r.f(initiationSource, "initiationSource");
        for (StoreTransaction storeTransaction : transactions) {
            if (storeTransaction.getPurchaseState() != PurchaseState.PENDING) {
                this.billing.queryProductDetailsAsync(storeTransaction.getType(), x.l0(storeTransaction.getProductIds()), new PostTransactionWithProductDetailsHelper$postTransactions$1$1(storeTransaction, this, z4, appUserID, initiationSource, oVar, oVar2), new PostTransactionWithProductDetailsHelper$postTransactions$1$2(this, storeTransaction, z4, appUserID, postReceiptInitiationSource, oVar, oVar2));
            } else if (oVar2 != null) {
                PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.PaymentPendingError, null, 2, null);
                LogUtilsKt.errorLog(purchasesError);
                E e4 = E.f5463a;
                oVar2.invoke(storeTransaction, purchasesError);
            }
            initiationSource = postReceiptInitiationSource;
        }
    }
}
