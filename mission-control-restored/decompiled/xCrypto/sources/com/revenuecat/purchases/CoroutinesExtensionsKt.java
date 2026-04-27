package com.revenuecat.purchases;

import W2.p;
import W2.q;
import Z2.k;
import a3.AbstractC0786b;
import a3.AbstractC0787c;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.interfaces.GetCustomerCenterConfigCallback;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class CoroutinesExtensionsKt {
    public static final /* synthetic */ Object awaitCustomerCenterConfigData(Purchases purchases, Z2.e eVar) throws Throwable {
        final k kVar = new k(AbstractC0786b.c(eVar));
        purchases.getCustomerCenterConfigData$purchases_defaultsRelease(new GetCustomerCenterConfigCallback() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitCustomerCenterConfigData$2$1
            @Override // com.revenuecat.purchases.interfaces.GetCustomerCenterConfigCallback
            public void onError(PurchasesError error) {
                r.f(error, "error");
                Z2.e eVar2 = kVar;
                p.a aVar = p.f5487b;
                eVar2.resumeWith(p.b(q.a(new PurchasesException(error))));
            }

            @Override // com.revenuecat.purchases.interfaces.GetCustomerCenterConfigCallback
            public void onSuccess(CustomerCenterConfigData customerCenterConfig) {
                r.f(customerCenterConfig, "customerCenterConfig");
                kVar.resumeWith(p.b(customerCenterConfig));
            }
        });
        Object objA = kVar.a();
        if (objA == AbstractC0787c.e()) {
            b3.h.c(eVar);
        }
        return objA;
    }

    public static final /* synthetic */ Object awaitCustomerInfo(Purchases purchases, CacheFetchPolicy cacheFetchPolicy, Z2.e eVar) throws Throwable {
        k kVar = new k(AbstractC0786b.c(eVar));
        ListenerConversionsKt.getCustomerInfoWith(purchases, cacheFetchPolicy, new CoroutinesExtensionsKt$awaitCustomerInfo$2$2(kVar), new CoroutinesExtensionsKt$awaitCustomerInfo$2$1(kVar));
        Object objA = kVar.a();
        if (objA == AbstractC0787c.e()) {
            b3.h.c(eVar);
        }
        return objA;
    }

    public static /* synthetic */ Object awaitCustomerInfo$default(Purchases purchases, CacheFetchPolicy cacheFetchPolicy, Z2.e eVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            cacheFetchPolicy = CacheFetchPolicy.Companion.m41default();
        }
        return awaitCustomerInfo(purchases, cacheFetchPolicy, eVar);
    }

    public static final /* synthetic */ Object awaitGetVirtualCurrencies(Purchases purchases, Z2.e eVar) throws Throwable {
        k kVar = new k(AbstractC0786b.c(eVar));
        ListenerConversionsKt.getVirtualCurrenciesWith(purchases, new CoroutinesExtensionsKt$awaitGetVirtualCurrencies$2$1(kVar), new CoroutinesExtensionsKt$awaitGetVirtualCurrencies$2$2(kVar));
        Object objA = kVar.a();
        if (objA == AbstractC0787c.e()) {
            b3.h.c(eVar);
        }
        return objA;
    }

    public static final /* synthetic */ Object awaitLogIn(Purchases purchases, String str, Z2.e eVar) throws Throwable {
        k kVar = new k(AbstractC0786b.c(eVar));
        ListenerConversionsKt.logInWith(purchases, str, new CoroutinesExtensionsKt$awaitLogIn$2$1(kVar), new CoroutinesExtensionsKt$awaitLogIn$2$2(kVar));
        Object objA = kVar.a();
        if (objA == AbstractC0787c.e()) {
            b3.h.c(eVar);
        }
        return objA;
    }

    public static final /* synthetic */ Object awaitLogOut(Purchases purchases, Z2.e eVar) throws Throwable {
        k kVar = new k(AbstractC0786b.c(eVar));
        ListenerConversionsKt.logOutWith(purchases, new CoroutinesExtensionsKt$awaitLogOut$2$1(kVar), new CoroutinesExtensionsKt$awaitLogOut$2$2(kVar));
        Object objA = kVar.a();
        if (objA == AbstractC0787c.e()) {
            b3.h.c(eVar);
        }
        return objA;
    }

    public static final /* synthetic */ Object awaitSyncAttributesAndOfferingsIfNeeded(Purchases purchases, Z2.e eVar) throws Throwable {
        k kVar = new k(AbstractC0786b.c(eVar));
        ListenerConversionsKt.syncAttributesAndOfferingsIfNeededWith(purchases, new CoroutinesExtensionsKt$awaitSyncAttributesAndOfferingsIfNeeded$2$2(kVar), new CoroutinesExtensionsKt$awaitSyncAttributesAndOfferingsIfNeeded$2$1(kVar));
        Object objA = kVar.a();
        if (objA == AbstractC0787c.e()) {
            b3.h.c(eVar);
        }
        return objA;
    }

    public static final /* synthetic */ Object awaitSyncPurchases(Purchases purchases, Z2.e eVar) throws Throwable {
        k kVar = new k(AbstractC0786b.c(eVar));
        ListenerConversionsKt.syncPurchasesWith(purchases, new CoroutinesExtensionsKt$awaitSyncPurchases$2$2(kVar), new CoroutinesExtensionsKt$awaitSyncPurchases$2$1(kVar));
        Object objA = kVar.a();
        if (objA == AbstractC0787c.e()) {
            b3.h.c(eVar);
        }
        return objA;
    }

    public static final /* synthetic */ Object getAmazonLWAConsentStatus(Purchases purchases, Z2.e eVar) throws Throwable {
        k kVar = new k(AbstractC0786b.c(eVar));
        ListenerConversionsKt.getAmazonLWAConsentStatusWith(purchases, new CoroutinesExtensionsKt$getAmazonLWAConsentStatus$2$2(kVar), new CoroutinesExtensionsKt$getAmazonLWAConsentStatus$2$1(kVar));
        Object objA = kVar.a();
        if (objA == AbstractC0787c.e()) {
            b3.h.c(eVar);
        }
        return objA;
    }
}
