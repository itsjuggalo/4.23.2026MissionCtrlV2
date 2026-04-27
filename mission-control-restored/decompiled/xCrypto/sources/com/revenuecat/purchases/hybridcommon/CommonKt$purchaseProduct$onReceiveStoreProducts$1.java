package com.revenuecat.purchases.hybridcommon;

import W2.E;
import android.app.Activity;
import com.revenuecat.purchases.ListenerConversionsCommonKt;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchaseParams;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.hybridcommon.mappers.PurchasesErrorKt;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import com.revenuecat.purchases.models.GoogleStoreProduct;
import com.revenuecat.purchases.models.GoogleStoreProductKt;
import com.revenuecat.purchases.models.StoreProduct;
import i3.k;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import r3.AbstractC1753A;

/* JADX INFO: loaded from: classes3.dex */
public final class CommonKt$purchaseProduct$onReceiveStoreProducts$1 extends s implements k {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ String $googleBasePlanId;
    final /* synthetic */ Boolean $googleIsPersonalizedPrice;
    final /* synthetic */ String $googleOldProductId;
    final /* synthetic */ GoogleReplacementMode $googleReplacementMode;
    final /* synthetic */ OnResult $onResult;
    final /* synthetic */ Map<String, Object> $presentedOfferingContext;
    final /* synthetic */ String $productIdentifier;
    final /* synthetic */ ProductType $productType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonKt$purchaseProduct$onReceiveStoreProducts$1(Activity activity, Map<String, ? extends Object> map, String str, GoogleReplacementMode googleReplacementMode, Boolean bool, OnResult onResult, String str2, ProductType productType, String str3) {
        super(1);
        this.$activity = activity;
        this.$presentedOfferingContext = map;
        this.$googleOldProductId = str;
        this.$googleReplacementMode = googleReplacementMode;
        this.$googleIsPersonalizedPrice = bool;
        this.$onResult = onResult;
        this.$productIdentifier = str2;
        this.$productType = productType;
        this.$googleBasePlanId = str3;
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<? extends StoreProduct>) obj);
        return E.f5463a;
    }

    public final void invoke(List<? extends StoreProduct> storeProducts) {
        Object next;
        PresentedOfferingContext presentedOfferingContext;
        r.f(storeProducts, "storeProducts");
        String str = this.$productIdentifier;
        ProductType productType = this.$productType;
        String str2 = this.$googleBasePlanId;
        Iterator<T> it = storeProducts.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            StoreProduct storeProduct = (StoreProduct) next;
            boolean z4 = false;
            boolean z5 = r.b(storeProduct.getId(), str) && storeProduct.getType() == productType;
            if (r.b(storeProduct.getPurchasingData().getProductId(), str)) {
                GoogleStoreProduct googleProduct = GoogleStoreProductKt.getGoogleProduct(storeProduct);
                if (r.b(googleProduct != null ? googleProduct.getBasePlanId() : null, str2) && storeProduct.getType() == productType) {
                    z4 = true;
                }
            }
            if (z5 || z4) {
                break;
            }
        }
        StoreProduct storeProduct2 = (StoreProduct) next;
        if (storeProduct2 == null) {
            this.$onResult.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.ProductNotAvailableForPurchaseError, "Couldn't find product " + this.$productIdentifier), null, 1, null));
            return;
        }
        PurchaseParams.Builder builder = new PurchaseParams.Builder(this.$activity, storeProduct2);
        Map<String, Object> map = this.$presentedOfferingContext;
        if (map != null && (presentedOfferingContext = CommonKt.toPresentedOfferingContext(map)) != null) {
            builder.presentedOfferingContext(presentedOfferingContext);
        }
        String str3 = this.$googleOldProductId;
        if (str3 != null && !AbstractC1753A.U(str3)) {
            builder.oldProductId(this.$googleOldProductId);
            GoogleReplacementMode googleReplacementMode = this.$googleReplacementMode;
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
