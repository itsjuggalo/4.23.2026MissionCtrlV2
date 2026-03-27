package com.revenuecat.purchases.hybridcommon;

import W2.E;
import android.app.Activity;
import com.revenuecat.purchases.ListenerConversionsCommonKt;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.PurchaseParams;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.hybridcommon.mappers.PurchasesErrorKt;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOptions;
import i3.k;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import r3.AbstractC1753A;

/* JADX INFO: loaded from: classes3.dex */
public final class CommonKt$purchaseSubscriptionOption$onReceiveStoreProducts$1 extends s implements k {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Boolean $googleIsPersonalizedPrice;
    final /* synthetic */ String $googleOldProductId;
    final /* synthetic */ GoogleReplacementMode $googleReplacementMode;
    final /* synthetic */ OnResult $onResult;
    final /* synthetic */ String $optionIdentifier;
    final /* synthetic */ Map<String, Object> $presentedOfferingContext;
    final /* synthetic */ String $productIdentifier;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonKt$purchaseSubscriptionOption$onReceiveStoreProducts$1(Activity activity, Map<String, ? extends Object> map, String str, Boolean bool, OnResult onResult, String str2, String str3, GoogleReplacementMode googleReplacementMode) {
        super(1);
        this.$activity = activity;
        this.$presentedOfferingContext = map;
        this.$googleOldProductId = str;
        this.$googleIsPersonalizedPrice = bool;
        this.$onResult = onResult;
        this.$productIdentifier = str2;
        this.$optionIdentifier = str3;
        this.$googleReplacementMode = googleReplacementMode;
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<? extends StoreProduct>) obj);
        return E.f5463a;
    }

    public final void invoke(List<? extends StoreProduct> storeProducts) {
        String str;
        SubscriptionOption subscriptionOption;
        PresentedOfferingContext presentedOfferingContext;
        SubscriptionOption next;
        r.f(storeProducts, "storeProducts");
        String str2 = this.$productIdentifier;
        String str3 = this.$optionIdentifier;
        Iterator<T> it = storeProducts.iterator();
        while (true) {
            str = null;
            if (!it.hasNext()) {
                subscriptionOption = null;
                break;
            }
            StoreProduct storeProduct = (StoreProduct) it.next();
            SubscriptionOptions subscriptionOptions = storeProduct.getSubscriptionOptions();
            if (subscriptionOptions != null) {
                Iterator<SubscriptionOption> it2 = subscriptionOptions.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                    SubscriptionOption subscriptionOption2 = next;
                    if (r.b(storeProduct.getPurchasingData().getProductId(), str2) && r.b(subscriptionOption2.getId(), str3)) {
                        break;
                    }
                }
                subscriptionOption = next;
            } else {
                subscriptionOption = null;
            }
            if (subscriptionOption != null) {
                break;
            }
        }
        if (subscriptionOption == null) {
            this.$onResult.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.ProductNotAvailableForPurchaseError, "Couldn't find product " + this.$productIdentifier + ':' + this.$optionIdentifier), null, 1, null));
            return;
        }
        PurchaseParams.Builder builder = new PurchaseParams.Builder(this.$activity, subscriptionOption);
        Map<String, Object> map = this.$presentedOfferingContext;
        if (map != null && (presentedOfferingContext = CommonKt.toPresentedOfferingContext(map)) != null) {
            builder.presentedOfferingContext(presentedOfferingContext);
        }
        String str4 = this.$googleOldProductId;
        if (str4 != null && !AbstractC1753A.U(str4)) {
            str = str4;
        }
        if (str != null) {
            GoogleReplacementMode googleReplacementMode = this.$googleReplacementMode;
            builder.oldProductId(str);
            if (googleReplacementMode != null) {
                builder.googleReplacementMode(googleReplacementMode);
            }
        }
        Boolean bool = this.$googleIsPersonalizedPrice;
        if (bool != null) {
            builder.isPersonalizedPrice(bool.booleanValue());
        }
        ListenerConversionsCommonKt.purchaseWith(Purchases.Companion.getSharedInstance(), builder.build(), CommonKt.getPurchaseErrorFunction(this.$onResult), CommonKt.getPurchaseCompletedFunction(this.$onResult));
    }
}
