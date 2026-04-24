package com.revenuecat.purchases.common.offlineentitlements;

import W2.E;
import X2.AbstractC0769p;
import X2.AbstractC0770q;
import X2.x;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.offlineentitlements.ProductEntitlementMapping;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.OfflineEntitlementsStrings;
import i3.k;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class PurchasedProductsFetcher {
    private final BillingAbstract billing;
    private final DateProvider dateProvider;
    private final DeviceCache deviceCache;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProductType.values().length];
            try {
                iArr[ProductType.SUBS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.offlineentitlements.PurchasedProductsFetcher$queryActiveProducts$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements k {
        final /* synthetic */ k $onSuccess;
        final /* synthetic */ ProductEntitlementMapping $productEntitlementMapping;
        final /* synthetic */ PurchasedProductsFetcher this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(k kVar, PurchasedProductsFetcher purchasedProductsFetcher, ProductEntitlementMapping productEntitlementMapping) {
            super(1);
            this.$onSuccess = kVar;
            this.this$0 = purchasedProductsFetcher;
            this.$productEntitlementMapping = productEntitlementMapping;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Map<String, StoreTransaction>) obj);
            return E.f5463a;
        }

        public final void invoke(Map<String, StoreTransaction> activePurchasesByHashedToken) {
            r.f(activePurchasesByHashedToken, "activePurchasesByHashedToken");
            List listG0 = x.g0(activePurchasesByHashedToken.values());
            PurchasedProductsFetcher purchasedProductsFetcher = this.this$0;
            ProductEntitlementMapping productEntitlementMapping = this.$productEntitlementMapping;
            ArrayList arrayList = new ArrayList(AbstractC0770q.q(listG0, 10));
            Iterator it = listG0.iterator();
            while (it.hasNext()) {
                arrayList.add(purchasedProductsFetcher.createPurchasedProduct((StoreTransaction) it.next(), productEntitlementMapping));
            }
            this.$onSuccess.invoke(arrayList);
        }
    }

    public PurchasedProductsFetcher(DeviceCache deviceCache, BillingAbstract billing, DateProvider dateProvider) {
        r.f(deviceCache, "deviceCache");
        r.f(billing, "billing");
        r.f(dateProvider, "dateProvider");
        this.deviceCache = deviceCache;
        this.billing = billing;
        this.dateProvider = dateProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PurchasedProduct createPurchasedProduct(StoreTransaction storeTransaction, ProductEntitlementMapping productEntitlementMapping) {
        List<String> listG;
        Date expirationDate = getExpirationDate(storeTransaction);
        String str = (String) x.H(storeTransaction.getProductIds());
        ProductEntitlementMapping.Mapping mapping = productEntitlementMapping.getMappings().get(str);
        String basePlanId = mapping != null ? mapping.getBasePlanId() : null;
        if (mapping == null || (listG = mapping.getEntitlements()) == null) {
            listG = AbstractC0769p.g();
        }
        return new PurchasedProduct(str, basePlanId, storeTransaction, listG, expirationDate);
    }

    private final Date getExpirationDate(StoreTransaction storeTransaction) {
        if (WhenMappings.$EnumSwitchMapping$0[storeTransaction.getType().ordinal()] == 1) {
            return new Date(this.dateProvider.getNow().getTime() + TimeUnit.DAYS.toMillis(1L));
        }
        return null;
    }

    public final void queryActiveProducts(String appUserID, k onSuccess, k onError) {
        r.f(appUserID, "appUserID");
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        ProductEntitlementMapping productEntitlementMapping = this.deviceCache.getProductEntitlementMapping();
        if (productEntitlementMapping == null) {
            onError.invoke(new PurchasesError(PurchasesErrorCode.CustomerInfoError, OfflineEntitlementsStrings.PRODUCT_ENTITLEMENT_MAPPING_REQUIRED));
        } else {
            this.billing.queryPurchases(appUserID, new AnonymousClass1(onSuccess, this, productEntitlementMapping), onError);
        }
    }

    public /* synthetic */ PurchasedProductsFetcher(DeviceCache deviceCache, BillingAbstract billingAbstract, DateProvider dateProvider, int i4, AbstractC1585j abstractC1585j) {
        this(deviceCache, billingAbstract, (i4 & 4) != 0 ? new DefaultDateProvider() : dateProvider);
    }
}
