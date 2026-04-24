package com.revenuecat.purchases;

import W2.E;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.PostReceiptErrorHandlingBehavior;
import com.revenuecat.purchases.common.ReceiptInfo;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.networking.PostReceiptResponse;
import com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.paywalls.PaywallPresentedCache;
import com.revenuecat.purchases.paywalls.events.PaywallEvent;
import com.revenuecat.purchases.subscriberattributes.BackendHelpersKt;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttribute;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager;
import i3.k;
import i3.o;
import i3.p;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class PostReceiptHelper {
    private final AppConfig appConfig;
    private final Backend backend;
    private final BillingAbstract billing;
    private final CustomerInfoUpdateHandler customerInfoUpdateHandler;
    private final DeviceCache deviceCache;
    private final OfflineEntitlementsManager offlineEntitlementsManager;
    private final PaywallPresentedCache paywallPresentedCache;
    private final SubscriberAttributesManager subscriberAttributesManager;

    /* JADX INFO: renamed from: com.revenuecat.purchases.PostReceiptHelper$calculateOfflineCustomerInfo$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements k {
        final /* synthetic */ k $onSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(k kVar) {
            super(1);
            this.$onSuccess = kVar;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CustomerInfo) obj);
            return E.f5463a;
        }

        public final void invoke(CustomerInfo customerInfo) {
            r.f(customerInfo, "customerInfo");
            PostReceiptHelper.this.customerInfoUpdateHandler.notifyListeners(customerInfo);
            this.$onSuccess.invoke(customerInfo);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PostReceiptHelper$calculateOfflineCustomerInfo$2, reason: invalid class name */
    public static final class AnonymousClass2 extends s implements k {
        final /* synthetic */ k $onError;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(k kVar) {
            super(1);
            this.$onError = kVar;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError error) {
            r.f(error, "error");
            this.$onError.invoke(error);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PostReceiptHelper$postReceiptAndSubscriberAttributes$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10951 extends s implements k {
        final /* synthetic */ String $appUserID;
        final /* synthetic */ PostReceiptInitiationSource $initiationSource;
        final /* synthetic */ boolean $isRestore;
        final /* synthetic */ String $marketplace;
        final /* synthetic */ p $onError;
        final /* synthetic */ k $onSuccess;
        final /* synthetic */ PaywallEvent $presentedPaywall;
        final /* synthetic */ String $purchaseToken;
        final /* synthetic */ ReceiptInfo $receiptInfo;
        final /* synthetic */ String $storeUserID;

        /* JADX INFO: renamed from: com.revenuecat.purchases.PostReceiptHelper$postReceiptAndSubscriberAttributes$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01621 extends s implements k {
            final /* synthetic */ String $appUserID;
            final /* synthetic */ k $onSuccess;
            final /* synthetic */ Map<String, SubscriberAttribute> $unsyncedSubscriberAttributesByKey;
            final /* synthetic */ PostReceiptHelper this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01621(PostReceiptHelper postReceiptHelper, String str, Map<String, SubscriberAttribute> map, k kVar) {
                super(1);
                this.this$0 = postReceiptHelper;
                this.$appUserID = str;
                this.$unsyncedSubscriberAttributesByKey = map;
                this.$onSuccess = kVar;
            }

            @Override // i3.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PostReceiptResponse) obj);
                return E.f5463a;
            }

            public final void invoke(PostReceiptResponse postReceiptResponse) {
                r.f(postReceiptResponse, "postReceiptResponse");
                this.this$0.offlineEntitlementsManager.resetOfflineCustomerInfoCache();
                this.this$0.subscriberAttributesManager.markAsSynced(this.$appUserID, this.$unsyncedSubscriberAttributesByKey, BackendHelpersKt.getAttributeErrors(postReceiptResponse.getBody()));
                this.this$0.customerInfoUpdateHandler.cacheAndNotifyListeners(postReceiptResponse.getCustomerInfo());
                this.$onSuccess.invoke(postReceiptResponse);
            }
        }

        /* JADX INFO: renamed from: com.revenuecat.purchases.PostReceiptHelper$postReceiptAndSubscriberAttributes$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends s implements p {
            final /* synthetic */ String $appUserID;
            final /* synthetic */ p $onError;
            final /* synthetic */ PaywallEvent $presentedPaywall;
            final /* synthetic */ Map<String, SubscriberAttribute> $unsyncedSubscriberAttributesByKey;
            final /* synthetic */ PostReceiptHelper this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(PaywallEvent paywallEvent, PostReceiptHelper postReceiptHelper, String str, Map<String, SubscriberAttribute> map, p pVar) {
                super(3);
                this.$presentedPaywall = paywallEvent;
                this.this$0 = postReceiptHelper;
                this.$appUserID = str;
                this.$unsyncedSubscriberAttributesByKey = map;
                this.$onError = pVar;
            }

            @Override // i3.p
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((PurchasesError) obj, (PostReceiptErrorHandlingBehavior) obj2, (JSONObject) obj3);
                return E.f5463a;
            }

            public final void invoke(PurchasesError error, PostReceiptErrorHandlingBehavior errorHandlingBehavior, JSONObject jSONObject) {
                r.f(error, "error");
                r.f(errorHandlingBehavior, "errorHandlingBehavior");
                PaywallEvent paywallEvent = this.$presentedPaywall;
                if (paywallEvent != null) {
                    this.this$0.paywallPresentedCache.cachePresentedPaywall(paywallEvent);
                }
                if (errorHandlingBehavior == PostReceiptErrorHandlingBehavior.SHOULD_BE_MARKED_SYNCED) {
                    this.this$0.subscriberAttributesManager.markAsSynced(this.$appUserID, this.$unsyncedSubscriberAttributesByKey, BackendHelpersKt.getAttributeErrors(jSONObject));
                }
                this.$onError.invoke(error, errorHandlingBehavior, jSONObject);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10951(String str, String str2, boolean z4, ReceiptInfo receiptInfo, String str3, String str4, PostReceiptInitiationSource postReceiptInitiationSource, PaywallEvent paywallEvent, k kVar, p pVar) {
            super(1);
            this.$purchaseToken = str;
            this.$appUserID = str2;
            this.$isRestore = z4;
            this.$receiptInfo = receiptInfo;
            this.$storeUserID = str3;
            this.$marketplace = str4;
            this.$initiationSource = postReceiptInitiationSource;
            this.$presentedPaywall = paywallEvent;
            this.$onSuccess = kVar;
            this.$onError = pVar;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Map<String, SubscriberAttribute>) obj);
            return E.f5463a;
        }

        public final void invoke(Map<String, SubscriberAttribute> unsyncedSubscriberAttributesByKey) {
            r.f(unsyncedSubscriberAttributesByKey, "unsyncedSubscriberAttributesByKey");
            Backend backend = PostReceiptHelper.this.backend;
            String str = this.$purchaseToken;
            String str2 = this.$appUserID;
            boolean z4 = this.$isRestore;
            boolean finishTransactions = PostReceiptHelper.this.getFinishTransactions();
            Map<String, Map<String, Object>> backendMap = BackendHelpersKt.toBackendMap(unsyncedSubscriberAttributesByKey);
            ReceiptInfo receiptInfo = this.$receiptInfo;
            String str3 = this.$storeUserID;
            String str4 = this.$marketplace;
            PostReceiptInitiationSource postReceiptInitiationSource = this.$initiationSource;
            PaywallEvent paywallEvent = this.$presentedPaywall;
            backend.postReceiptData(str, str2, z4, finishTransactions, backendMap, receiptInfo, str3, str4, postReceiptInitiationSource, paywallEvent != null ? paywallEvent.toPaywallPostReceiptData$purchases_defaultsRelease() : null, new C01621(PostReceiptHelper.this, this.$appUserID, unsyncedSubscriberAttributesByKey, this.$onSuccess), new AnonymousClass2(this.$presentedPaywall, PostReceiptHelper.this, this.$appUserID, unsyncedSubscriberAttributesByKey, this.$onError));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PostReceiptHelper$postTokenWithoutConsuming$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10961 extends s implements k {
        final /* synthetic */ k $onSuccess;
        final /* synthetic */ String $purchaseToken;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10961(String str, k kVar) {
            super(1);
            this.$purchaseToken = str;
            this.$onSuccess = kVar;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PostReceiptResponse) obj);
            return E.f5463a;
        }

        public final void invoke(PostReceiptResponse postReceiptResponse) {
            r.f(postReceiptResponse, "postReceiptResponse");
            PostReceiptHelper.this.deviceCache.addSuccessfullyPostedToken(this.$purchaseToken);
            this.$onSuccess.invoke(postReceiptResponse.getCustomerInfo());
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PostReceiptHelper$postTokenWithoutConsuming$2, reason: invalid class name and case insensitive filesystem */
    public static final class C10972 extends s implements p {
        final /* synthetic */ String $appUserID;
        final /* synthetic */ k $onError;
        final /* synthetic */ k $onSuccess;
        final /* synthetic */ String $purchaseToken;

        /* JADX INFO: renamed from: com.revenuecat.purchases.PostReceiptHelper$postTokenWithoutConsuming$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends s implements k {
            final /* synthetic */ k $onSuccess;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(k kVar) {
                super(1);
                this.$onSuccess = kVar;
            }

            @Override // i3.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((CustomerInfo) obj);
                return E.f5463a;
            }

            public final void invoke(CustomerInfo it) {
                r.f(it, "it");
                this.$onSuccess.invoke(it);
            }
        }

        /* JADX INFO: renamed from: com.revenuecat.purchases.PostReceiptHelper$postTokenWithoutConsuming$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C01632 extends s implements Function0 {
            final /* synthetic */ PurchasesError $backendError;
            final /* synthetic */ k $onError;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01632(k kVar, PurchasesError purchasesError) {
                super(0);
                this.$onError = kVar;
                this.$backendError = purchasesError;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m70invoke();
                return E.f5463a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m70invoke() {
                this.$onError.invoke(this.$backendError);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10972(String str, String str2, k kVar, k kVar2) {
            super(3);
            this.$purchaseToken = str;
            this.$appUserID = str2;
            this.$onSuccess = kVar;
            this.$onError = kVar2;
        }

        @Override // i3.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((PurchasesError) obj, (PostReceiptErrorHandlingBehavior) obj2, (JSONObject) obj3);
            return E.f5463a;
        }

        public final void invoke(PurchasesError backendError, PostReceiptErrorHandlingBehavior errorHandlingBehavior, JSONObject jSONObject) {
            r.f(backendError, "backendError");
            r.f(errorHandlingBehavior, "errorHandlingBehavior");
            if (errorHandlingBehavior == PostReceiptErrorHandlingBehavior.SHOULD_BE_MARKED_SYNCED) {
                PostReceiptHelper.this.deviceCache.addSuccessfullyPostedToken(this.$purchaseToken);
            }
            PostReceiptHelper.this.useOfflineEntitlementsCustomerInfoIfNeeded(errorHandlingBehavior, this.$appUserID, new AnonymousClass1(this.$onSuccess), new C01632(this.$onError, backendError));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PostReceiptHelper$postTransactionAndConsumeIfNeeded$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10981 extends s implements k {
        final /* synthetic */ PostReceiptInitiationSource $initiationSource;
        final /* synthetic */ o $onSuccess;
        final /* synthetic */ StoreTransaction $purchase;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10981(StoreTransaction storeTransaction, PostReceiptInitiationSource postReceiptInitiationSource, o oVar) {
            super(1);
            this.$purchase = storeTransaction;
            this.$initiationSource = postReceiptInitiationSource;
            this.$onSuccess = oVar;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PostReceiptResponse) obj);
            return E.f5463a;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x005b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void invoke(com.revenuecat.purchases.common.networking.PostReceiptResponse r7) {
            /*
                r6 = this;
                java.lang.String r0 = "postReceiptResponse"
                kotlin.jvm.internal.r.f(r7, r0)
                java.util.Map r0 = r7.getProductInfoByProductId()
                if (r0 == 0) goto L5b
                com.revenuecat.purchases.models.StoreTransaction r1 = r6.$purchase
                java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
                r2.<init>()
                java.util.Set r0 = r0.entrySet()
                java.util.Iterator r0 = r0.iterator()
            L1a:
                boolean r3 = r0.hasNext()
                if (r3 == 0) goto L42
                java.lang.Object r3 = r0.next()
                java.util.Map$Entry r3 = (java.util.Map.Entry) r3
                java.lang.Object r4 = r3.getKey()
                java.lang.String r4 = (java.lang.String) r4
                java.util.List r5 = r1.getProductIds()
                boolean r4 = r5.contains(r4)
                if (r4 == 0) goto L1a
                java.lang.Object r4 = r3.getKey()
                java.lang.Object r3 = r3.getValue()
                r2.put(r4, r3)
                goto L1a
            L42:
                java.util.Collection r0 = r2.values()
                if (r0 == 0) goto L5b
                java.lang.Object r0 = X2.x.I(r0)
                com.revenuecat.purchases.common.networking.PostReceiptProductInfo r0 = (com.revenuecat.purchases.common.networking.PostReceiptProductInfo) r0
                if (r0 == 0) goto L5b
                java.lang.Boolean r0 = r0.getShouldConsume()
                if (r0 == 0) goto L5b
                boolean r0 = r0.booleanValue()
                goto L5c
            L5b:
                r0 = 1
            L5c:
                com.revenuecat.purchases.PostReceiptHelper r1 = com.revenuecat.purchases.PostReceiptHelper.this
                com.revenuecat.purchases.common.BillingAbstract r1 = com.revenuecat.purchases.PostReceiptHelper.access$getBilling$p(r1)
                com.revenuecat.purchases.PostReceiptHelper r2 = com.revenuecat.purchases.PostReceiptHelper.this
                boolean r2 = com.revenuecat.purchases.PostReceiptHelper.access$getFinishTransactions(r2)
                com.revenuecat.purchases.models.StoreTransaction r3 = r6.$purchase
                com.revenuecat.purchases.PostReceiptInitiationSource r4 = r6.$initiationSource
                r1.consumeAndSave(r2, r3, r0, r4)
                i3.o r0 = r6.$onSuccess
                if (r0 == 0) goto L7c
                com.revenuecat.purchases.models.StoreTransaction r1 = r6.$purchase
                com.revenuecat.purchases.CustomerInfo r7 = r7.getCustomerInfo()
                r0.invoke(r1, r7)
            L7c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.PostReceiptHelper.C10981.invoke(com.revenuecat.purchases.common.networking.PostReceiptResponse):void");
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PostReceiptHelper$postTransactionAndConsumeIfNeeded$2, reason: invalid class name and case insensitive filesystem */
    public static final class C10992 extends s implements p {
        final /* synthetic */ String $appUserID;
        final /* synthetic */ PostReceiptInitiationSource $initiationSource;
        final /* synthetic */ o $onError;
        final /* synthetic */ o $onSuccess;
        final /* synthetic */ StoreTransaction $purchase;

        /* JADX INFO: renamed from: com.revenuecat.purchases.PostReceiptHelper$postTransactionAndConsumeIfNeeded$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends s implements k {
            final /* synthetic */ o $onSuccess;
            final /* synthetic */ StoreTransaction $purchase;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(o oVar, StoreTransaction storeTransaction) {
                super(1);
                this.$onSuccess = oVar;
                this.$purchase = storeTransaction;
            }

            @Override // i3.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((CustomerInfo) obj);
                return E.f5463a;
            }

            public final void invoke(CustomerInfo customerInfo) {
                r.f(customerInfo, "customerInfo");
                o oVar = this.$onSuccess;
                if (oVar != null) {
                    oVar.invoke(this.$purchase, customerInfo);
                }
            }
        }

        /* JADX INFO: renamed from: com.revenuecat.purchases.PostReceiptHelper$postTransactionAndConsumeIfNeeded$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C01642 extends s implements Function0 {
            final /* synthetic */ PurchasesError $backendError;
            final /* synthetic */ o $onError;
            final /* synthetic */ StoreTransaction $purchase;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01642(o oVar, StoreTransaction storeTransaction, PurchasesError purchasesError) {
                super(0);
                this.$onError = oVar;
                this.$purchase = storeTransaction;
                this.$backendError = purchasesError;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m71invoke();
                return E.f5463a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m71invoke() {
                o oVar = this.$onError;
                if (oVar != null) {
                    oVar.invoke(this.$purchase, this.$backendError);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10992(StoreTransaction storeTransaction, PostReceiptInitiationSource postReceiptInitiationSource, String str, o oVar, o oVar2) {
            super(3);
            this.$purchase = storeTransaction;
            this.$initiationSource = postReceiptInitiationSource;
            this.$appUserID = str;
            this.$onSuccess = oVar;
            this.$onError = oVar2;
        }

        @Override // i3.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((PurchasesError) obj, (PostReceiptErrorHandlingBehavior) obj2, (JSONObject) obj3);
            return E.f5463a;
        }

        public final void invoke(PurchasesError backendError, PostReceiptErrorHandlingBehavior errorHandlingBehavior, JSONObject jSONObject) {
            r.f(backendError, "backendError");
            r.f(errorHandlingBehavior, "errorHandlingBehavior");
            if (errorHandlingBehavior == PostReceiptErrorHandlingBehavior.SHOULD_BE_MARKED_SYNCED) {
                PostReceiptHelper.this.billing.consumeAndSave(PostReceiptHelper.this.getFinishTransactions(), this.$purchase, false, this.$initiationSource);
            }
            PostReceiptHelper.this.useOfflineEntitlementsCustomerInfoIfNeeded(errorHandlingBehavior, this.$appUserID, new AnonymousClass1(this.$onSuccess, this.$purchase), new C01642(this.$onError, this.$purchase, backendError));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PostReceiptHelper$useOfflineEntitlementsCustomerInfoIfNeeded$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11001 extends s implements k {
        final /* synthetic */ Function0 $onError;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11001(Function0 function0) {
            super(1);
            this.$onError = function0;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError it) {
            r.f(it, "it");
            this.$onError.invoke();
        }
    }

    public PostReceiptHelper(AppConfig appConfig, Backend backend, BillingAbstract billing, CustomerInfoUpdateHandler customerInfoUpdateHandler, DeviceCache deviceCache, SubscriberAttributesManager subscriberAttributesManager, OfflineEntitlementsManager offlineEntitlementsManager, PaywallPresentedCache paywallPresentedCache) {
        r.f(appConfig, "appConfig");
        r.f(backend, "backend");
        r.f(billing, "billing");
        r.f(customerInfoUpdateHandler, "customerInfoUpdateHandler");
        r.f(deviceCache, "deviceCache");
        r.f(subscriberAttributesManager, "subscriberAttributesManager");
        r.f(offlineEntitlementsManager, "offlineEntitlementsManager");
        r.f(paywallPresentedCache, "paywallPresentedCache");
        this.appConfig = appConfig;
        this.backend = backend;
        this.billing = billing;
        this.customerInfoUpdateHandler = customerInfoUpdateHandler;
        this.deviceCache = deviceCache;
        this.subscriberAttributesManager = subscriberAttributesManager;
        this.offlineEntitlementsManager = offlineEntitlementsManager;
        this.paywallPresentedCache = paywallPresentedCache;
    }

    private final void calculateOfflineCustomerInfo(String str, k kVar, k kVar2) {
        this.offlineEntitlementsManager.calculateAndCacheOfflineCustomerInfo(str, new AnonymousClass1(kVar), new AnonymousClass2(kVar2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getFinishTransactions() {
        return this.appConfig.getFinishTransactions();
    }

    private final void postReceiptAndSubscriberAttributes(String str, String str2, boolean z4, ReceiptInfo receiptInfo, String str3, String str4, PostReceiptInitiationSource postReceiptInitiationSource, k kVar, p pVar) {
        this.subscriberAttributesManager.getUnsyncedSubscriberAttributes(str, new C10951(str2, str, z4, receiptInfo, str3, str4, postReceiptInitiationSource, this.paywallPresentedCache.getAndRemovePresentedEvent(), kVar, pVar));
    }

    public static /* synthetic */ void postTransactionAndConsumeIfNeeded$default(PostReceiptHelper postReceiptHelper, StoreTransaction storeTransaction, StoreProduct storeProduct, boolean z4, String str, PostReceiptInitiationSource postReceiptInitiationSource, o oVar, o oVar2, int i4, Object obj) {
        if ((i4 & 32) != 0) {
            oVar = null;
        }
        if ((i4 & 64) != 0) {
            oVar2 = null;
        }
        postReceiptHelper.postTransactionAndConsumeIfNeeded(storeTransaction, storeProduct, z4, str, postReceiptInitiationSource, oVar, oVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void useOfflineEntitlementsCustomerInfoIfNeeded(PostReceiptErrorHandlingBehavior postReceiptErrorHandlingBehavior, String str, k kVar, Function0 function0) {
        if (this.offlineEntitlementsManager.shouldCalculateOfflineCustomerInfoInPostReceipt(postReceiptErrorHandlingBehavior == PostReceiptErrorHandlingBehavior.SHOULD_USE_OFFLINE_ENTITLEMENTS_AND_NOT_CONSUME)) {
            calculateOfflineCustomerInfo(str, kVar, new C11001(function0));
        } else {
            function0.invoke();
        }
    }

    public final void postTokenWithoutConsuming(String purchaseToken, String str, ReceiptInfo receiptInfo, boolean z4, String appUserID, String str2, PostReceiptInitiationSource initiationSource, k onSuccess, k onError) {
        r.f(purchaseToken, "purchaseToken");
        r.f(receiptInfo, "receiptInfo");
        r.f(appUserID, "appUserID");
        r.f(initiationSource, "initiationSource");
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        postReceiptAndSubscriberAttributes(appUserID, purchaseToken, z4, receiptInfo, str, str2, initiationSource, new C10961(purchaseToken, onSuccess), new C10972(purchaseToken, appUserID, onSuccess, onError));
    }

    public final void postTransactionAndConsumeIfNeeded(StoreTransaction purchase, StoreProduct storeProduct, boolean z4, String appUserID, PostReceiptInitiationSource initiationSource, o oVar, o oVar2) {
        r.f(purchase, "purchase");
        r.f(appUserID, "appUserID");
        r.f(initiationSource, "initiationSource");
        postReceiptAndSubscriberAttributes(appUserID, purchase.getPurchaseToken(), z4, new ReceiptInfo(purchase.getProductIds(), purchase.getPresentedOfferingContext(), purchase.getSubscriptionOptionId(), storeProduct, null, null, purchase.getReplacementMode(), 48, null), purchase.getStoreUserID(), purchase.getMarketplace(), initiationSource, new C10981(purchase, initiationSource, oVar), new C10992(purchase, initiationSource, appUserID, oVar, oVar2));
    }
}
