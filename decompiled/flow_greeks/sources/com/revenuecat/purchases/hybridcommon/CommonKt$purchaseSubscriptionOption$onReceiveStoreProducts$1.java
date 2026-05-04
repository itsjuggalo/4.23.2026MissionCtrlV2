package com.revenuecat.purchases.hybridcommon;

import android.app.Activity;
import cd.h0;
import com.revenuecat.purchases.ListenerConversionsCommonKt;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.PurchaseParams;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.hybridcommon.mappers.PurchasesErrorKt;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import java.util.List;
import java.util.Map;
import kg.c0;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import pd.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/revenuecat/purchases/models/StoreProduct;", "storeProducts", "Lcd/h0;", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
public final class CommonKt$purchaseSubscriptionOption$onReceiveStoreProducts$1 extends v implements k {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ List<Map<String, Object>> $addOnPackages;
    final /* synthetic */ List<Map<String, Object>> $addOnStoreProducts;
    final /* synthetic */ List<Map<String, Object>> $addOnSubscriptionOptions;
    final /* synthetic */ Boolean $googleIsPersonalizedPrice;
    final /* synthetic */ String $googleOldProductId;
    final /* synthetic */ GoogleReplacementMode $googleReplacementMode;
    final /* synthetic */ OnResult $onResult;
    final /* synthetic */ String $optionIdentifier;
    final /* synthetic */ Map<String, Object> $presentedOfferingContext;
    final /* synthetic */ String $productIdentifier;

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$purchaseSubscriptionOption$onReceiveStoreProducts$1$10, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/revenuecat/purchases/Offerings;", "offerings", "Lcd/h0;", "invoke", "(Lcom/revenuecat/purchases/Offerings;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    public static final class AnonymousClass10 extends v implements k {
        final /* synthetic */ List<Map<String, Object>> $addOnPackages;
        final /* synthetic */ OnResult $onResult;
        final /* synthetic */ Map<String, Object> $presentedOfferingContext;
        final /* synthetic */ PurchaseParams.Builder $purchaseParams;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass10(Map<String, ? extends Object> map, OnResult onResult, List<? extends Map<String, ? extends Object>> list, PurchaseParams.Builder builder) {
            super(1);
            this.$presentedOfferingContext = map;
            this.$onResult = onResult;
            this.$addOnPackages = list;
            this.$purchaseParams = builder;
        }

        @Override // pd.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Offerings) obj);
            return h0.f3852a;
        }

        public final void invoke(Offerings offerings) {
            t.f(offerings, "offerings");
            Map<String, Object> map = this.$presentedOfferingContext;
            if ((map != null ? CommonKt.toPresentedOfferingContext(map) : null) == null) {
                this.$onResult.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.PurchaseInvalidError, "There is no or invalid presented offering context data provided to make this purchase"), null, 1, null));
                return;
            }
            try {
                List<Package> listCreateAddOnPackages = CommonKt.createAddOnPackages(this.$addOnPackages, offerings);
                if (listCreateAddOnPackages == null || listCreateAddOnPackages.isEmpty()) {
                    listCreateAddOnPackages = null;
                }
                if (listCreateAddOnPackages != null) {
                    this.$purchaseParams.addOnPackages(listCreateAddOnPackages);
                }
                ListenerConversionsCommonKt.purchaseWith(Purchases.INSTANCE.getSharedInstance(), this.$purchaseParams.build(), CommonKt.getPurchaseErrorFunction(this.$onResult), CommonKt.getPurchaseCompletedFunction(this.$onResult));
            } catch (IllegalArgumentException e10) {
                this.$onResult.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.PurchaseInvalidError, e10.getMessage()), null, 1, null));
            }
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$purchaseSubscriptionOption$onReceiveStoreProducts$1$9, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/revenuecat/purchases/PurchasesError;", "it", "Lcd/h0;", "invoke", "(Lcom/revenuecat/purchases/PurchasesError;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    public static final class AnonymousClass9 extends v implements k {
        final /* synthetic */ OnResult $onResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass9(OnResult onResult) {
            super(1);
            this.$onResult = onResult;
        }

        @Override // pd.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return h0.f3852a;
        }

        public final void invoke(PurchasesError it) {
            t.f(it, "it");
            this.$onResult.onError(PurchasesErrorKt.map$default(it, null, 1, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CommonKt$purchaseSubscriptionOption$onReceiveStoreProducts$1(String str, String str2, Activity activity, Map<String, ? extends Object> map, String str3, Boolean bool, List<? extends Map<String, ? extends Object>> list, List<? extends Map<String, ? extends Object>> list2, List<? extends Map<String, ? extends Object>> list3, OnResult onResult, GoogleReplacementMode googleReplacementMode) {
        super(1);
        this.$productIdentifier = str;
        this.$optionIdentifier = str2;
        this.$activity = activity;
        this.$presentedOfferingContext = map;
        this.$googleOldProductId = str3;
        this.$googleIsPersonalizedPrice = bool;
        this.$addOnStoreProducts = list;
        this.$addOnSubscriptionOptions = list2;
        this.$addOnPackages = list3;
        this.$onResult = onResult;
        this.$googleReplacementMode = googleReplacementMode;
    }

    @Override // pd.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<? extends StoreProduct>) obj);
        return h0.f3852a;
    }

    public final void invoke(List<? extends StoreProduct> storeProducts) {
        PresentedOfferingContext presentedOfferingContext;
        t.f(storeProducts, "storeProducts");
        SubscriptionOption subscriptionOptionSubscriptionOptionForIdentifiers = CommonKt.subscriptionOptionForIdentifiers(this.$productIdentifier, this.$optionIdentifier, storeProducts);
        List<? extends SubscriptionOption> list = null;
        if (subscriptionOptionSubscriptionOptionForIdentifiers == null) {
            this.$onResult.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.ProductNotAvailableForPurchaseError, "Couldn't find product " + this.$productIdentifier + ':' + this.$optionIdentifier), null, 1, null));
            return;
        }
        PurchaseParams.Builder builder = new PurchaseParams.Builder(this.$activity, subscriptionOptionSubscriptionOptionForIdentifiers);
        Map<String, Object> map = this.$presentedOfferingContext;
        if (map != null && (presentedOfferingContext = CommonKt.toPresentedOfferingContext(map)) != null) {
            builder.presentedOfferingContext(presentedOfferingContext);
        }
        String str = this.$googleOldProductId;
        if (str == null || c0.e0(str)) {
            str = null;
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
        List<? extends StoreProduct> listCreateAddOnStoreProducts = CommonKt.createAddOnStoreProducts(this.$addOnStoreProducts, storeProducts);
        if (listCreateAddOnStoreProducts == null || listCreateAddOnStoreProducts.isEmpty()) {
            listCreateAddOnStoreProducts = null;
        }
        if (listCreateAddOnStoreProducts != null) {
            builder.addOnStoreProducts(listCreateAddOnStoreProducts);
        }
        List<? extends SubscriptionOption> listCreateAddOnSubscriptionOptions = CommonKt.createAddOnSubscriptionOptions(this.$addOnSubscriptionOptions, storeProducts);
        if (listCreateAddOnSubscriptionOptions != null && !listCreateAddOnSubscriptionOptions.isEmpty()) {
            list = listCreateAddOnSubscriptionOptions;
        }
        if (list != null) {
            builder.addOnSubscriptionOptions(list);
        }
        List<Map<String, Object>> list2 = this.$addOnPackages;
        if (list2 == null || list2.isEmpty()) {
            ListenerConversionsCommonKt.purchaseWith(Purchases.INSTANCE.getSharedInstance(), builder.build(), CommonKt.getPurchaseErrorFunction(this.$onResult), CommonKt.getPurchaseCompletedFunction(this.$onResult));
        } else {
            ListenerConversionsCommonKt.getOfferingsWith(Purchases.INSTANCE.getSharedInstance(), new AnonymousClass9(this.$onResult), new AnonymousClass10(this.$presentedOfferingContext, this.$onResult, this.$addOnPackages, builder));
        }
    }
}
