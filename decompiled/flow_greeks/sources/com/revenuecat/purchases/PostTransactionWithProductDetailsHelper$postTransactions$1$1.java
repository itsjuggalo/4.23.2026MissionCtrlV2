package com.revenuecat.purchases;

import cd.h0;
import cd.w;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.models.GoogleStoreProduct;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOptions;
import dd.a0;
import dd.n0;
import dd.o0;
import dd.r;
import dd.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import pd.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/revenuecat/purchases/models/StoreProduct;", "storeProducts", "Lcd/h0;", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
public final class PostTransactionWithProductDetailsHelper$postTransactions$1$1 extends v implements pd.k {
    final /* synthetic */ boolean $allowSharingPlayStoreAccount;
    final /* synthetic */ String $appUserID;
    final /* synthetic */ PostReceiptInitiationSource $initiationSource;
    final /* synthetic */ StoreTransaction $transaction;
    final /* synthetic */ o $transactionPostError;
    final /* synthetic */ o $transactionPostSuccess;
    final /* synthetic */ PostTransactionWithProductDetailsHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostTransactionWithProductDetailsHelper$postTransactions$1$1(StoreTransaction storeTransaction, PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper, boolean z10, String str, PostReceiptInitiationSource postReceiptInitiationSource, o oVar, o oVar2) {
        super(1);
        this.$transaction = storeTransaction;
        this.this$0 = postTransactionWithProductDetailsHelper;
        this.$allowSharingPlayStoreAccount = z10;
        this.$appUserID = str;
        this.$initiationSource = postReceiptInitiationSource;
        this.$transactionPostSuccess = oVar;
        this.$transactionPostError = oVar2;
    }

    @Override // pd.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<? extends StoreProduct>) obj);
        return h0.f3852a;
    }

    public final void invoke(List<? extends StoreProduct> storeProducts) {
        Object next;
        StoreProduct storeProduct;
        Collection collectionK;
        Object next2;
        t.f(storeProducts, "storeProducts");
        Map<String, ? extends SubscriptionOption> mapB = null;
        if (this.$transaction.getType() == ProductType.SUBS && this.$transaction.getMarketplace() == null) {
            StoreTransaction storeTransaction = this.$transaction;
            Iterator<T> it = storeProducts.iterator();
            loop0: while (true) {
                if (!it.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it.next();
                SubscriptionOptions subscriptionOptions = ((StoreProduct) next2).getSubscriptionOptions();
                if (subscriptionOptions != null && !subscriptionOptions.isEmpty()) {
                    Iterator<SubscriptionOption> it2 = subscriptionOptions.iterator();
                    while (it2.hasNext()) {
                        if (t.b(it2.next().getId(), storeTransaction.getSubscriptionOptionId())) {
                            break loop0;
                        }
                    }
                }
            }
            storeProduct = (StoreProduct) next2;
        } else {
            StoreTransaction storeTransaction2 = this.$transaction;
            Iterator<T> it3 = storeProducts.iterator();
            while (true) {
                if (it3.hasNext()) {
                    next = it3.next();
                    if (t.b(((StoreProduct) next).getId(), a0.b0(storeTransaction2.getProductIds()))) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            storeProduct = (StoreProduct) next;
        }
        StoreProduct storeProduct2 = storeProduct;
        Map subscriptionOptionIdForProductIDs = this.$transaction.getSubscriptionOptionIdForProductIDs();
        if (subscriptionOptionIdForProductIDs != null) {
            ArrayList<GoogleStoreProduct> arrayList = new ArrayList();
            for (Object obj : storeProducts) {
                if (obj instanceof GoogleStoreProduct) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (GoogleStoreProduct googleStoreProduct : arrayList) {
                SubscriptionOptions subscriptionOptions2 = googleStoreProduct.getSubscriptionOptions();
                if (subscriptionOptions2 != null) {
                    collectionK = new ArrayList(s.u(subscriptionOptions2, 10));
                    for (SubscriptionOption subscriptionOption : subscriptionOptions2) {
                        collectionK.add(w.a(googleStoreProduct.getProductId() + '_' + subscriptionOption.getId(), subscriptionOption));
                    }
                } else {
                    collectionK = r.k();
                }
                dd.w.z(arrayList2, collectionK);
            }
            Map mapT = o0.t(arrayList2);
            Map mapC = n0.c();
            for (Map.Entry entry : subscriptionOptionIdForProductIDs.entrySet()) {
                String str = (String) entry.getKey();
                SubscriptionOption subscriptionOption2 = (SubscriptionOption) mapT.get(str + '_' + ((String) entry.getValue()));
                if (subscriptionOption2 != null) {
                    mapC.put(str, subscriptionOption2);
                }
            }
            mapB = n0.b(mapC);
        }
        Map<String, ? extends SubscriptionOption> map = mapB;
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "Store product found for transaction: " + storeProduct2);
        }
        this.this$0.postReceiptHelper.postTransactionAndConsumeIfNeeded(this.$transaction, storeProduct2, map, this.$allowSharingPlayStoreAccount, this.$appUserID, this.$initiationSource, this.$transactionPostSuccess, this.$transactionPostError);
    }
}
