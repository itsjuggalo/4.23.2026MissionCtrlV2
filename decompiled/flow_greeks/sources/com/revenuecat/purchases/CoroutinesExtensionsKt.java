package com.revenuecat.purchases;

import cd.r;
import cd.s;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.interfaces.GetCustomerCenterConfigCallback;
import io.flutter.plugins.firebase.auth.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\t\u0010\n\u001a\u0014\u0010\u000b\u001a\u00020\u0003*\u00020\u0000H\u0086@¢\u0006\u0004\b\u000b\u0010\f\u001a\u0014\u0010\r\u001a\u00020\u0003*\u00020\u0000H\u0086@¢\u0006\u0004\b\r\u0010\f\u001a\u0014\u0010\u000f\u001a\u00020\u000e*\u00020\u0000H\u0086@¢\u0006\u0004\b\u000f\u0010\f\u001a\u0014\u0010\u0011\u001a\u00020\u0010*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0011\u0010\f\u001a\u0014\u0010\u0013\u001a\u00020\u0012*\u00020\u0000H\u0087@¢\u0006\u0004\b\u0013\u0010\f\u001a\u0014\u0010\u0015\u001a\u00020\u0014*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0015\u0010\f\u001a\u0014\u0010\u0017\u001a\u00020\u0016*\u00020\u0000H\u0087@¢\u0006\u0004\b\u0017\u0010\f\u001a$\u0010\u001b\u001a\u00020\u001a*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0087@¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/revenuecat/purchases/Purchases;", "Lcom/revenuecat/purchases/CacheFetchPolicy;", "fetchPolicy", "Lcom/revenuecat/purchases/CustomerInfo;", "awaitCustomerInfo", "(Lcom/revenuecat/purchases/Purchases;Lcom/revenuecat/purchases/CacheFetchPolicy;Lgd/e;)Ljava/lang/Object;", "", "appUserID", "Lcom/revenuecat/purchases/data/LogInResult;", "awaitLogIn", "(Lcom/revenuecat/purchases/Purchases;Ljava/lang/String;Lgd/e;)Ljava/lang/Object;", "awaitLogOut", "(Lcom/revenuecat/purchases/Purchases;Lgd/e;)Ljava/lang/Object;", "awaitSyncPurchases", "Lcom/revenuecat/purchases/Offerings;", "awaitSyncAttributesAndOfferingsIfNeeded", "Lcom/revenuecat/purchases/AmazonLWAConsentStatus;", "getAmazonLWAConsentStatus", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData;", "awaitCustomerCenterConfigData", "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "awaitGetVirtualCurrencies", "Ljava/util/Locale;", "awaitStorefrontLocale", Constants.EMAIL, com.amazon.a.a.o.b.f4549c, "Lcom/revenuecat/purchases/CreateSupportTicketResult;", "awaitCreateSupportTicket", "(Lcom/revenuecat/purchases/Purchases;Ljava/lang/String;Ljava/lang/String;Lgd/e;)Ljava/lang/Object;", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CoroutinesExtensionsKt {
    @InternalRevenueCatAPI
    public static final /* synthetic */ Object awaitCreateSupportTicket(Purchases purchases, String str, String str2, gd.e eVar) throws Throwable {
        gd.k kVar = new gd.k(hd.b.c(eVar));
        purchases.createSupportTicket(str, str2, new CoroutinesExtensionsKt$awaitCreateSupportTicket$2$1(kVar), new CoroutinesExtensionsKt$awaitCreateSupportTicket$2$2(kVar));
        Object objA = kVar.a();
        if (objA == hd.c.f()) {
            id.h.c(eVar);
        }
        return objA;
    }

    @InternalRevenueCatAPI
    public static final /* synthetic */ Object awaitCustomerCenterConfigData(Purchases purchases, gd.e eVar) throws Throwable {
        final gd.k kVar = new gd.k(hd.b.c(eVar));
        purchases.getCustomerCenterConfigData$purchases_defaultsBc8Release(new GetCustomerCenterConfigCallback() { // from class: com.revenuecat.purchases.CoroutinesExtensionsKt$awaitCustomerCenterConfigData$2$1
            @Override // com.revenuecat.purchases.interfaces.GetCustomerCenterConfigCallback
            public void onError(PurchasesError error) {
                t.f(error, "error");
                gd.e eVar2 = kVar;
                r.a aVar = r.f3870b;
                eVar2.resumeWith(r.b(s.a(new PurchasesException(error))));
            }

            @Override // com.revenuecat.purchases.interfaces.GetCustomerCenterConfigCallback
            public void onSuccess(CustomerCenterConfigData customerCenterConfig) {
                t.f(customerCenterConfig, "customerCenterConfig");
                kVar.resumeWith(r.b(customerCenterConfig));
            }
        });
        Object objA = kVar.a();
        if (objA == hd.c.f()) {
            id.h.c(eVar);
        }
        return objA;
    }

    public static final /* synthetic */ Object awaitCustomerInfo(Purchases purchases, CacheFetchPolicy cacheFetchPolicy, gd.e eVar) throws Throwable {
        gd.k kVar = new gd.k(hd.b.c(eVar));
        ListenerConversionsKt.getCustomerInfoWith(purchases, cacheFetchPolicy, new CoroutinesExtensionsKt$awaitCustomerInfo$2$2(kVar), new CoroutinesExtensionsKt$awaitCustomerInfo$2$1(kVar));
        Object objA = kVar.a();
        if (objA == hd.c.f()) {
            id.h.c(eVar);
        }
        return objA;
    }

    public static /* synthetic */ Object awaitCustomerInfo$default(Purchases purchases, CacheFetchPolicy cacheFetchPolicy, gd.e eVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cacheFetchPolicy = CacheFetchPolicy.INSTANCE.m19default();
        }
        return awaitCustomerInfo(purchases, cacheFetchPolicy, eVar);
    }

    public static final /* synthetic */ Object awaitGetVirtualCurrencies(Purchases purchases, gd.e eVar) throws Throwable {
        gd.k kVar = new gd.k(hd.b.c(eVar));
        ListenerConversionsKt.getVirtualCurrenciesWith(purchases, new CoroutinesExtensionsKt$awaitGetVirtualCurrencies$2$1(kVar), new CoroutinesExtensionsKt$awaitGetVirtualCurrencies$2$2(kVar));
        Object objA = kVar.a();
        if (objA == hd.c.f()) {
            id.h.c(eVar);
        }
        return objA;
    }

    public static final /* synthetic */ Object awaitLogIn(Purchases purchases, String str, gd.e eVar) throws Throwable {
        gd.k kVar = new gd.k(hd.b.c(eVar));
        ListenerConversionsKt.logInWith(purchases, str, new CoroutinesExtensionsKt$awaitLogIn$2$1(kVar), new CoroutinesExtensionsKt$awaitLogIn$2$2(kVar));
        Object objA = kVar.a();
        if (objA == hd.c.f()) {
            id.h.c(eVar);
        }
        return objA;
    }

    public static final /* synthetic */ Object awaitLogOut(Purchases purchases, gd.e eVar) throws Throwable {
        gd.k kVar = new gd.k(hd.b.c(eVar));
        ListenerConversionsKt.logOutWith(purchases, new CoroutinesExtensionsKt$awaitLogOut$2$1(kVar), new CoroutinesExtensionsKt$awaitLogOut$2$2(kVar));
        Object objA = kVar.a();
        if (objA == hd.c.f()) {
            id.h.c(eVar);
        }
        return objA;
    }

    @ExperimentalPreviewRevenueCatPurchasesAPI
    public static final Object awaitStorefrontLocale(Purchases purchases, gd.e eVar) throws Throwable {
        gd.k kVar = new gd.k(hd.b.c(eVar));
        ListenerConversionsKt.getStorefrontLocaleWith(purchases, new CoroutinesExtensionsKt$awaitStorefrontLocale$2$2(kVar), new CoroutinesExtensionsKt$awaitStorefrontLocale$2$1(kVar));
        Object objA = kVar.a();
        if (objA == hd.c.f()) {
            id.h.c(eVar);
        }
        return objA;
    }

    public static final /* synthetic */ Object awaitSyncAttributesAndOfferingsIfNeeded(Purchases purchases, gd.e eVar) throws Throwable {
        gd.k kVar = new gd.k(hd.b.c(eVar));
        ListenerConversionsKt.syncAttributesAndOfferingsIfNeededWith(purchases, new CoroutinesExtensionsKt$awaitSyncAttributesAndOfferingsIfNeeded$2$2(kVar), new CoroutinesExtensionsKt$awaitSyncAttributesAndOfferingsIfNeeded$2$1(kVar));
        Object objA = kVar.a();
        if (objA == hd.c.f()) {
            id.h.c(eVar);
        }
        return objA;
    }

    public static final /* synthetic */ Object awaitSyncPurchases(Purchases purchases, gd.e eVar) throws Throwable {
        gd.k kVar = new gd.k(hd.b.c(eVar));
        ListenerConversionsKt.syncPurchasesWith(purchases, new CoroutinesExtensionsKt$awaitSyncPurchases$2$2(kVar), new CoroutinesExtensionsKt$awaitSyncPurchases$2$1(kVar));
        Object objA = kVar.a();
        if (objA == hd.c.f()) {
            id.h.c(eVar);
        }
        return objA;
    }

    public static final /* synthetic */ Object getAmazonLWAConsentStatus(Purchases purchases, gd.e eVar) throws Throwable {
        gd.k kVar = new gd.k(hd.b.c(eVar));
        ListenerConversionsKt.getAmazonLWAConsentStatusWith(purchases, new CoroutinesExtensionsKt$getAmazonLWAConsentStatus$2$2(kVar), new CoroutinesExtensionsKt$getAmazonLWAConsentStatus$2$1(kVar));
        Object objA = kVar.a();
        if (objA == hd.c.f()) {
            id.h.c(eVar);
        }
        return objA;
    }
}
