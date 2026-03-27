package com.revenuecat.purchases;

import W2.E;
import X2.x;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOptions;
import i3.k;
import i3.o;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class PostTransactionWithProductDetailsHelper$postTransactions$1$1 extends s implements k {
    final /* synthetic */ boolean $allowSharingPlayStoreAccount;
    final /* synthetic */ String $appUserID;
    final /* synthetic */ PostReceiptInitiationSource $initiationSource;
    final /* synthetic */ StoreTransaction $transaction;
    final /* synthetic */ o $transactionPostError;
    final /* synthetic */ o $transactionPostSuccess;
    final /* synthetic */ PostTransactionWithProductDetailsHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostTransactionWithProductDetailsHelper$postTransactions$1$1(StoreTransaction storeTransaction, PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper, boolean z4, String str, PostReceiptInitiationSource postReceiptInitiationSource, o oVar, o oVar2) {
        super(1);
        this.$transaction = storeTransaction;
        this.this$0 = postTransactionWithProductDetailsHelper;
        this.$allowSharingPlayStoreAccount = z4;
        this.$appUserID = str;
        this.$initiationSource = postReceiptInitiationSource;
        this.$transactionPostSuccess = oVar;
        this.$transactionPostError = oVar2;
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<? extends StoreProduct>) obj);
        return E.f5463a;
    }

    public final void invoke(List<? extends StoreProduct> storeProducts) {
        StoreProduct storeProduct;
        r.f(storeProducts, "storeProducts");
        Object obj = null;
        if (this.$transaction.getType() == ProductType.SUBS && this.$transaction.getMarketplace() == null) {
            StoreTransaction storeTransaction = this.$transaction;
            Iterator<T> it = storeProducts.iterator();
            loop0: while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                SubscriptionOptions subscriptionOptions = ((StoreProduct) next).getSubscriptionOptions();
                if (subscriptionOptions != null && !subscriptionOptions.isEmpty()) {
                    Iterator<SubscriptionOption> it2 = subscriptionOptions.iterator();
                    while (it2.hasNext()) {
                        if (r.b(it2.next().getId(), storeTransaction.getSubscriptionOptionId())) {
                            obj = next;
                            break loop0;
                        }
                    }
                }
            }
            storeProduct = (StoreProduct) obj;
        } else {
            StoreTransaction storeTransaction2 = this.$transaction;
            Iterator<T> it3 = storeProducts.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Object next2 = it3.next();
                if (r.b(((StoreProduct) next2).getId(), x.J(storeTransaction2.getProductIds()))) {
                    obj = next2;
                    break;
                }
            }
            storeProduct = (StoreProduct) obj;
        }
        StoreProduct storeProduct2 = storeProduct;
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "Store product found for transaction: " + storeProduct2);
        }
        this.this$0.postReceiptHelper.postTransactionAndConsumeIfNeeded(this.$transaction, storeProduct2, this.$allowSharingPlayStoreAccount, this.$appUserID, this.$initiationSource, this.$transactionPostSuccess, this.$transactionPostError);
    }
}
