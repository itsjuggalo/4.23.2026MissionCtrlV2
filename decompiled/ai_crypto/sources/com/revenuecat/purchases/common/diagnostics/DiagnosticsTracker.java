package com.revenuecat.purchases.common.diagnostics;

import E5.E;
import E5.o;
import E5.t;
import F5.I;
import F5.J;
import a6.C0929a;
import com.revenuecat.purchases.CacheFetchPolicy;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.events.EventsManager;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.strings.OfflineEntitlementsStrings;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes2.dex */
public final class DiagnosticsTracker {

    @Deprecated
    public static final String BACKEND_ERROR_CODE_KEY = "backend_error_code";

    @Deprecated
    public static final String BILLING_DEBUG_MESSAGE = "billing_debug_message";

    @Deprecated
    public static final String BILLING_RESPONSE_CODE = "billing_response_code";

    @Deprecated
    public static final String CACHE_STATUS_KEY = "cache_status";
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String ENDPOINT_NAME_KEY = "endpoint_name";

    @Deprecated
    public static final String ERROR_CODE_KEY = "error_code";

    @Deprecated
    public static final String ERROR_MESSAGE_KEY = "error_message";

    @Deprecated
    public static final String ETAG_HIT_KEY = "etag_hit";

    @Deprecated
    public static final String FETCH_POLICY_KEY = "fetch_policy";

    @Deprecated
    public static final String FOUND_PRODUCT_IDS_KEY = "found_product_ids";

    @Deprecated
    public static final String HAD_UNSYNCED_PURCHASES_BEFORE_KEY = "had_unsynced_purchases_before";

    @Deprecated
    public static final String HAS_INTRO_PRICE_KEY = "has_intro_price";

    @Deprecated
    public static final String HAS_INTRO_TRIAL_KEY = "has_intro_trial";

    @Deprecated
    public static final String HOST_KEY = "host";

    @Deprecated
    public static final String IS_RETRY = "is_retry";

    @Deprecated
    public static final String NOT_FOUND_PRODUCT_IDS_KEY = "not_found_product_ids";

    @Deprecated
    public static final String OLD_PRODUCT_ID_KEY = "old_product_id";

    @Deprecated
    public static final String PENDING_REQUEST_COUNT = "pending_request_count";

    @Deprecated
    public static final String PRODUCT_IDS_KEY = "product_ids";

    @Deprecated
    public static final String PRODUCT_ID_KEY = "product_id";

    @Deprecated
    public static final String PRODUCT_TYPE_KEY = "product_type";

    @Deprecated
    public static final String PRODUCT_TYPE_QUERIED_KEY = "product_type_queried";

    @Deprecated
    public static final String PURCHASE_STATUSES_KEY = "purchase_statuses";

    @Deprecated
    public static final String REQUESTED_PRODUCT_IDS_KEY = "requested_product_ids";

    @Deprecated
    public static final String REQUEST_STATUS_KEY = "request_status";

    @Deprecated
    public static final String RESPONSE_CODE_KEY = "response_code";

    @Deprecated
    public static final String RESPONSE_TIME_MILLIS_KEY = "response_time_millis";

    @Deprecated
    public static final String SUCCESSFUL_KEY = "successful";

    @Deprecated
    public static final String VERIFICATION_RESULT_KEY = "verification_result";
    private final AppConfig appConfig;
    private final UUID appSessionID;
    private final Map<String, String> commonProperties;
    private final Dispatcher diagnosticsDispatcher;
    private final DiagnosticsFileHelper diagnosticsFileHelper;
    private final DiagnosticsHelper diagnosticsHelper;
    private DiagnosticsEventTrackerListener listener;

    public enum CacheStatus {
        NOT_CHECKED,
        NOT_FOUND,
        STALE,
        VALID
    }

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker$checkAndClearDiagnosticsFileIfTooBig$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements Function0 {
        final /* synthetic */ Function0 $completion;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function0 function0) {
            super(0);
            this.$completion = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m83invoke();
            return E.f1657a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m83invoke() {
            if (DiagnosticsTracker.this.diagnosticsFileHelper.isDiagnosticsFileTooBig()) {
                LogUtilsKt.verboseLog("Diagnostics file is too big. Deleting it.");
                DiagnosticsTracker.this.diagnosticsHelper.resetDiagnosticsStatus();
                DiagnosticsTracker.trackMaxEventsStoredLimitReached$default(DiagnosticsTracker.this, false, 1, null);
            }
            this.$completion.invoke();
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker$trackEvent$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13191 extends s implements Function0 {
        final /* synthetic */ DiagnosticsEntry $diagnosticsEntry;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13191(DiagnosticsEntry diagnosticsEntry) {
            super(0);
            this.$diagnosticsEntry = diagnosticsEntry;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m84invoke();
            return E.f1657a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m84invoke() {
            DiagnosticsTracker.this.trackEventInCurrentThread$purchases_defaultsRelease(this.$diagnosticsEntry);
        }
    }

    public DiagnosticsTracker(AppConfig appConfig, DiagnosticsFileHelper diagnosticsFileHelper, DiagnosticsHelper diagnosticsHelper, Dispatcher diagnosticsDispatcher, UUID appSessionID) {
        r.f(appConfig, "appConfig");
        r.f(diagnosticsFileHelper, "diagnosticsFileHelper");
        r.f(diagnosticsHelper, "diagnosticsHelper");
        r.f(diagnosticsDispatcher, "diagnosticsDispatcher");
        r.f(appSessionID, "appSessionID");
        this.appConfig = appConfig;
        this.diagnosticsFileHelper = diagnosticsFileHelper;
        this.diagnosticsHelper = diagnosticsHelper;
        this.diagnosticsDispatcher = diagnosticsDispatcher;
        this.appSessionID = appSessionID;
        this.commonProperties = appConfig.getStore() == Store.PLAY_STORE ? MapExtensionsKt.filterNotNullValues(J.g(t.a("play_store_version", appConfig.getPlayStoreVersionName()), t.a("play_services_version", appConfig.getPlayServicesVersionName()))) : J.e();
    }

    private final void checkAndClearDiagnosticsFileIfTooBig(Function0 function0) {
        enqueue(new AnonymousClass1(function0));
    }

    private final void enqueue(final Function0 function0) {
        Dispatcher.enqueue$default(this.diagnosticsDispatcher, new Runnable() { // from class: com.revenuecat.purchases.common.diagnostics.b
            @Override // java.lang.Runnable
            public final void run() {
                DiagnosticsTracker.enqueue$lambda$0(function0);
            }
        }, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enqueue$lambda$0(Function0 tmp0) {
        r.f(tmp0, "$tmp0");
        tmp0.invoke();
    }

    private final void trackEvent(DiagnosticsEntryName diagnosticsEntryName, Map<String, ? extends Object> map) {
        trackEvent(new DiagnosticsEntry(null, diagnosticsEntryName, J.k(this.commonProperties, map), this.appSessionID, null, null, 49, null));
    }

    public static /* synthetic */ void trackMaxEventsStoredLimitReached$default(DiagnosticsTracker diagnosticsTracker, boolean z7, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            z7 = true;
        }
        diagnosticsTracker.trackMaxEventsStoredLimitReached(z7);
    }

    public final DiagnosticsEventTrackerListener getListener() {
        return this.listener;
    }

    public final void setListener(DiagnosticsEventTrackerListener diagnosticsEventTrackerListener) {
        this.listener = diagnosticsEventTrackerListener;
    }

    /* JADX INFO: renamed from: trackAmazonPurchaseAttempt-9VgGkz4, reason: not valid java name */
    public final void m70trackAmazonPurchaseAttempt9VgGkz4(String productId, String str, Integer num, String str2, long j7) {
        r.f(productId, "productId");
        trackEvent(DiagnosticsEntryName.AMAZON_PURCHASE_ATTEMPT, MapExtensionsKt.filterNotNullValues(J.g(t.a(PRODUCT_ID_KEY, productId), t.a(REQUEST_STATUS_KEY, str), t.a(ERROR_CODE_KEY, num), t.a(ERROR_MESSAGE_KEY, str2), t.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(C0929a.r(j7))))));
    }

    /* JADX INFO: renamed from: trackAmazonQueryProductDetailsRequest-KLykuaI, reason: not valid java name */
    public final void m71trackAmazonQueryProductDetailsRequestKLykuaI(long j7, boolean z7, Set<String> requestedProductIds) {
        r.f(requestedProductIds, "requestedProductIds");
        trackEvent(DiagnosticsEntryName.AMAZON_QUERY_PRODUCT_DETAILS_REQUEST, J.g(t.a(SUCCESSFUL_KEY, Boolean.valueOf(z7)), t.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(C0929a.r(j7))), t.a(REQUESTED_PRODUCT_IDS_KEY, requestedProductIds)));
    }

    /* JADX INFO: renamed from: trackAmazonQueryPurchasesRequest-KLykuaI, reason: not valid java name */
    public final void m72trackAmazonQueryPurchasesRequestKLykuaI(long j7, boolean z7, List<String> list) {
        trackEvent(DiagnosticsEntryName.AMAZON_QUERY_PURCHASES_REQUEST, MapExtensionsKt.filterNotNullValues(J.g(t.a(SUCCESSFUL_KEY, Boolean.valueOf(z7)), t.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(C0929a.r(j7))), t.a(FOUND_PRODUCT_IDS_KEY, list))));
    }

    public final void trackClearingDiagnosticsAfterFailedSync() {
        trackEvent(DiagnosticsEntryName.CLEARING_DIAGNOSTICS_AFTER_FAILED_SYNC, J.e());
    }

    public final void trackCustomerInfoVerificationResultIfNeeded(CustomerInfo customerInfo) {
        r.f(customerInfo, "customerInfo");
        VerificationResult verification = customerInfo.getEntitlements().getVerification();
        if (verification == VerificationResult.NOT_REQUESTED) {
            return;
        }
        trackEvent(DiagnosticsEntryName.CUSTOMER_INFO_VERIFICATION_RESULT, I.c(t.a(VERIFICATION_RESULT_KEY, verification.name())));
    }

    public final void trackEnteredOfflineEntitlementsMode() {
        trackEvent(DiagnosticsEntryName.ENTERED_OFFLINE_ENTITLEMENTS_MODE, J.e());
    }

    public final void trackErrorEnteringOfflineEntitlementsMode(PurchasesError error) {
        r.f(error, "error");
        String str = (error.getCode() == PurchasesErrorCode.UnsupportedError && r.b(error.getUnderlyingErrorMessage(), OfflineEntitlementsStrings.OFFLINE_ENTITLEMENTS_UNSUPPORTED_INAPP_PURCHASES)) ? "one_time_purchase_found" : (error.getCode() == PurchasesErrorCode.CustomerInfoError && r.b(error.getUnderlyingErrorMessage(), OfflineEntitlementsStrings.PRODUCT_ENTITLEMENT_MAPPING_REQUIRED)) ? "no_entitlement_mapping_available" : "unknown";
        trackEvent(DiagnosticsEntryName.ERROR_ENTERING_OFFLINE_ENTITLEMENTS_MODE, J.g(t.a("offline_entitlement_error_reason", str), t.a(ERROR_MESSAGE_KEY, error.getMessage() + " Underlying error: " + error.getUnderlyingErrorMessage())));
    }

    public final void trackEventInCurrentThread$purchases_defaultsRelease(DiagnosticsEntry diagnosticsEntry) {
        r.f(diagnosticsEntry, "diagnosticsEntry");
        LogUtilsKt.verboseLog("Tracking diagnostics entry: " + diagnosticsEntry);
        try {
            this.diagnosticsFileHelper.appendEvent(diagnosticsEntry);
            DiagnosticsEventTrackerListener diagnosticsEventTrackerListener = this.listener;
            if (diagnosticsEventTrackerListener != null) {
                diagnosticsEventTrackerListener.onEventTracked();
            }
        } catch (IOException e7) {
            LogUtilsKt.verboseLog("Error tracking diagnostics entry: " + e7);
        }
    }

    /* JADX INFO: renamed from: trackGetCustomerInfoResult-17CK4j0, reason: not valid java name */
    public final void m73trackGetCustomerInfoResult17CK4j0(CacheFetchPolicy cacheFetchPolicy, VerificationResult verificationResult, Boolean bool, String str, Integer num, long j7) {
        r.f(cacheFetchPolicy, "cacheFetchPolicy");
        trackEvent(DiagnosticsEntryName.GET_CUSTOMER_INFO_RESULT, MapExtensionsKt.filterNotNullValues(J.g(t.a(FETCH_POLICY_KEY, cacheFetchPolicy.name()), t.a(VERIFICATION_RESULT_KEY, verificationResult != null ? verificationResult.name() : null), t.a(HAD_UNSYNCED_PURCHASES_BEFORE_KEY, bool), t.a(ERROR_MESSAGE_KEY, str), t.a(ERROR_CODE_KEY, num), t.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(C0929a.r(j7))))));
    }

    public final void trackGetCustomerInfoStarted() {
        trackEvent(DiagnosticsEntryName.GET_CUSTOMER_INFO_STARTED, J.e());
    }

    /* JADX INFO: renamed from: trackGetOfferingsResult-B8UsjHI, reason: not valid java name */
    public final void m74trackGetOfferingsResultB8UsjHI(Set<String> set, Set<String> set2, String str, Integer num, String str2, CacheStatus cacheStatus, long j7) {
        r.f(cacheStatus, "cacheStatus");
        trackEvent(DiagnosticsEntryName.GET_OFFERINGS_RESULT, MapExtensionsKt.filterNotNullValues(J.g(t.a(REQUESTED_PRODUCT_IDS_KEY, set), t.a(NOT_FOUND_PRODUCT_IDS_KEY, set2), t.a(ERROR_MESSAGE_KEY, str), t.a(ERROR_CODE_KEY, num), t.a(VERIFICATION_RESULT_KEY, str2), t.a(CACHE_STATUS_KEY, cacheStatus.name()), t.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(C0929a.r(j7))))));
    }

    public final void trackGetOfferingsStarted() {
        trackEvent(DiagnosticsEntryName.GET_OFFERINGS_STARTED, J.e());
    }

    /* JADX INFO: renamed from: trackGetProductsResult-9VgGkz4, reason: not valid java name */
    public final void m75trackGetProductsResult9VgGkz4(Set<String> requestedProductIds, Set<String> notFoundProductIds, String str, Integer num, long j7) {
        r.f(requestedProductIds, "requestedProductIds");
        r.f(notFoundProductIds, "notFoundProductIds");
        trackEvent(DiagnosticsEntryName.GET_PRODUCTS_RESULT, MapExtensionsKt.filterNotNullValues(J.g(t.a(REQUESTED_PRODUCT_IDS_KEY, requestedProductIds), t.a(NOT_FOUND_PRODUCT_IDS_KEY, notFoundProductIds), t.a(ERROR_MESSAGE_KEY, str), t.a(ERROR_CODE_KEY, num), t.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(C0929a.r(j7))))));
    }

    public final void trackGetProductsStarted(Set<String> requestedProductIds) {
        r.f(requestedProductIds, "requestedProductIds");
        trackEvent(DiagnosticsEntryName.GET_PRODUCTS_STARTED, I.c(t.a(REQUESTED_PRODUCT_IDS_KEY, requestedProductIds)));
    }

    public final void trackGoogleBillingServiceDisconnected() {
        trackEvent(DiagnosticsEntryName.GOOGLE_BILLING_SERVICE_DISCONNECTED, J.e());
    }

    public final void trackGoogleBillingSetupFinished(int i7, String debugMessage, int i8) {
        r.f(debugMessage, "debugMessage");
        trackEvent(DiagnosticsEntryName.GOOGLE_BILLING_SETUP_FINISHED, J.g(t.a(BILLING_RESPONSE_CODE, Integer.valueOf(i7)), t.a(BILLING_DEBUG_MESSAGE, debugMessage), t.a(PENDING_REQUEST_COUNT, Integer.valueOf(i8))));
    }

    public final void trackGoogleBillingStartConnection() {
        trackEvent(DiagnosticsEntryName.GOOGLE_BILLING_START_CONNECTION, J.e());
    }

    public final void trackGooglePurchaseStarted(String productId, String str, Boolean bool, Boolean bool2) {
        r.f(productId, "productId");
        trackEvent(DiagnosticsEntryName.GOOGLE_PURCHASE_STARTED, MapExtensionsKt.filterNotNullValues(J.g(t.a(PRODUCT_ID_KEY, productId), t.a(OLD_PRODUCT_ID_KEY, str), t.a(HAS_INTRO_TRIAL_KEY, bool), t.a(HAS_INTRO_PRICE_KEY, bool2))));
    }

    public final void trackGooglePurchaseUpdateReceived(List<String> list, List<String> list2, int i7, String billingDebugMessage) {
        r.f(billingDebugMessage, "billingDebugMessage");
        trackEvent(DiagnosticsEntryName.GOOGLE_PURCHASES_UPDATE_RECEIVED, MapExtensionsKt.filterNotNullValues(J.g(t.a(PRODUCT_IDS_KEY, list), t.a(PURCHASE_STATUSES_KEY, list2), t.a(BILLING_RESPONSE_CODE, Integer.valueOf(i7)), t.a(BILLING_DEBUG_MESSAGE, billingDebugMessage))));
    }

    /* JADX INFO: renamed from: trackGoogleQueryProductDetailsRequest-9VgGkz4, reason: not valid java name */
    public final void m76trackGoogleQueryProductDetailsRequest9VgGkz4(Set<String> requestedProductIds, String productType, int i7, String billingDebugMessage, long j7) {
        r.f(requestedProductIds, "requestedProductIds");
        r.f(productType, "productType");
        r.f(billingDebugMessage, "billingDebugMessage");
        trackEvent(DiagnosticsEntryName.GOOGLE_QUERY_PRODUCT_DETAILS_REQUEST, J.g(t.a(REQUESTED_PRODUCT_IDS_KEY, requestedProductIds), t.a(PRODUCT_TYPE_QUERIED_KEY, productType), t.a(BILLING_RESPONSE_CODE, Integer.valueOf(i7)), t.a(BILLING_DEBUG_MESSAGE, billingDebugMessage), t.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(C0929a.r(j7)))));
    }

    /* JADX INFO: renamed from: trackGoogleQueryPurchaseHistoryRequest-Wn2Vu4Y, reason: not valid java name */
    public final void m77trackGoogleQueryPurchaseHistoryRequestWn2Vu4Y(String productType, int i7, String billingDebugMessage, long j7) {
        r.f(productType, "productType");
        r.f(billingDebugMessage, "billingDebugMessage");
        trackEvent(DiagnosticsEntryName.GOOGLE_QUERY_PURCHASE_HISTORY_REQUEST, J.g(t.a(PRODUCT_TYPE_QUERIED_KEY, productType), t.a(BILLING_RESPONSE_CODE, Integer.valueOf(i7)), t.a(BILLING_DEBUG_MESSAGE, billingDebugMessage), t.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(C0929a.r(j7)))));
    }

    /* JADX INFO: renamed from: trackGoogleQueryPurchasesRequest-zkXUZaI, reason: not valid java name */
    public final void m78trackGoogleQueryPurchasesRequestzkXUZaI(String productType, int i7, String billingDebugMessage, long j7, List<String> foundProductIds) {
        r.f(productType, "productType");
        r.f(billingDebugMessage, "billingDebugMessage");
        r.f(foundProductIds, "foundProductIds");
        trackEvent(DiagnosticsEntryName.GOOGLE_QUERY_PURCHASES_REQUEST, J.g(t.a(PRODUCT_TYPE_QUERIED_KEY, productType), t.a(BILLING_RESPONSE_CODE, Integer.valueOf(i7)), t.a(BILLING_DEBUG_MESSAGE, billingDebugMessage), t.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(C0929a.r(j7))), t.a(FOUND_PRODUCT_IDS_KEY, foundProductIds)));
    }

    /* JADX INFO: renamed from: trackHttpRequestPerformed-OCcUtpk, reason: not valid java name */
    public final void m79trackHttpRequestPerformedOCcUtpk(String host, Endpoint endpoint, long j7, boolean z7, int i7, Integer num, HTTPResult.Origin origin, VerificationResult verificationResult, boolean z8) {
        r.f(host, "host");
        r.f(endpoint, "endpoint");
        r.f(verificationResult, "verificationResult");
        trackEvent(DiagnosticsEntryName.HTTP_REQUEST_PERFORMED, MapExtensionsKt.filterNotNullValues(J.g(t.a(HOST_KEY, host), t.a(ENDPOINT_NAME_KEY, endpoint.getName()), t.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(C0929a.r(j7))), t.a(SUCCESSFUL_KEY, Boolean.valueOf(z7)), t.a(RESPONSE_CODE_KEY, Integer.valueOf(i7)), t.a(BACKEND_ERROR_CODE_KEY, num), t.a(ETAG_HIT_KEY, Boolean.valueOf(origin == HTTPResult.Origin.CACHE)), t.a(VERIFICATION_RESULT_KEY, verificationResult.name()), t.a(IS_RETRY, Boolean.valueOf(z8)))));
    }

    public final void trackMaxDiagnosticsSyncRetriesReached() {
        trackEvent(DiagnosticsEntryName.MAX_DIAGNOSTICS_SYNC_RETRIES_REACHED, J.e());
    }

    public final void trackMaxEventsStoredLimitReached(boolean z7) {
        DiagnosticsEntry diagnosticsEntry = new DiagnosticsEntry(null, DiagnosticsEntryName.MAX_EVENTS_STORED_LIMIT_REACHED, this.commonProperties, this.appSessionID, null, null, 49, null);
        if (z7) {
            trackEventInCurrentThread$purchases_defaultsRelease(diagnosticsEntry);
        } else {
            trackEvent(diagnosticsEntry);
        }
    }

    public final void trackProductDetailsNotSupported(int i7, String billingDebugMessage) {
        r.f(billingDebugMessage, "billingDebugMessage");
        DiagnosticsEntryName diagnosticsEntryName = DiagnosticsEntryName.PRODUCT_DETAILS_NOT_SUPPORTED;
        String playStoreVersionName = this.appConfig.getPlayStoreVersionName();
        if (playStoreVersionName == null) {
            playStoreVersionName = "";
        }
        o oVarA = t.a("play_store_version", playStoreVersionName);
        String playServicesVersionName = this.appConfig.getPlayServicesVersionName();
        trackEvent(diagnosticsEntryName, J.g(oVarA, t.a("play_services_version", playServicesVersionName != null ? playServicesVersionName : ""), t.a(BILLING_RESPONSE_CODE, Integer.valueOf(i7)), t.a(BILLING_DEBUG_MESSAGE, billingDebugMessage)));
    }

    /* JADX INFO: renamed from: trackPurchaseResult-myKFqkg, reason: not valid java name */
    public final void m80trackPurchaseResultmyKFqkg(String productId, ProductType productType, Integer num, String str, long j7, VerificationResult verificationResult) {
        r.f(productId, "productId");
        r.f(productType, "productType");
        trackEvent(DiagnosticsEntryName.PURCHASE_RESULT, MapExtensionsKt.filterNotNullValues(J.g(t.a(PRODUCT_ID_KEY, productId), t.a(PRODUCT_TYPE_KEY, DiagnosticsTrackerKt.getDiagnosticsName(productType)), t.a(ERROR_CODE_KEY, num), t.a(ERROR_MESSAGE_KEY, str), t.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(C0929a.r(j7))), t.a(VERIFICATION_RESULT_KEY, verificationResult != null ? verificationResult.name() : null))));
    }

    public final void trackPurchaseStarted(String productId, ProductType productType) {
        r.f(productId, "productId");
        r.f(productType, "productType");
        trackEvent(DiagnosticsEntryName.PURCHASE_STARTED, J.g(t.a(PRODUCT_ID_KEY, productId), t.a(PRODUCT_TYPE_KEY, DiagnosticsTrackerKt.getDiagnosticsName(productType))));
    }

    /* JADX INFO: renamed from: trackRestorePurchasesResult-SxA4cEA, reason: not valid java name */
    public final void m81trackRestorePurchasesResultSxA4cEA(Integer num, String str, long j7) {
        trackEvent(DiagnosticsEntryName.RESTORE_PURCHASES_RESULT, MapExtensionsKt.filterNotNullValues(J.g(t.a(ERROR_CODE_KEY, num), t.a(ERROR_MESSAGE_KEY, str), t.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(C0929a.r(j7))))));
    }

    public final void trackRestorePurchasesStarted() {
        trackEvent(DiagnosticsEntryName.RESTORE_PURCHASES_STARTED, J.e());
    }

    /* JADX INFO: renamed from: trackSyncPurchasesResult-SxA4cEA, reason: not valid java name */
    public final void m82trackSyncPurchasesResultSxA4cEA(Integer num, String str, long j7) {
        trackEvent(DiagnosticsEntryName.SYNC_PURCHASES_RESULT, MapExtensionsKt.filterNotNullValues(J.g(t.a(ERROR_CODE_KEY, num), t.a(ERROR_MESSAGE_KEY, str), t.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(C0929a.r(j7))))));
    }

    public final void trackSyncPurchasesStarted() {
        trackEvent(DiagnosticsEntryName.SYNC_PURCHASES_STARTED, J.e());
    }

    public final void trackEvent(DiagnosticsEntry diagnosticsEntry) {
        r.f(diagnosticsEntry, "diagnosticsEntry");
        checkAndClearDiagnosticsFileIfTooBig(new C13191(diagnosticsEntry));
    }

    public /* synthetic */ DiagnosticsTracker(AppConfig appConfig, DiagnosticsFileHelper diagnosticsFileHelper, DiagnosticsHelper diagnosticsHelper, Dispatcher dispatcher, UUID uuid, int i7, AbstractC2148j abstractC2148j) {
        this(appConfig, diagnosticsFileHelper, diagnosticsHelper, dispatcher, (i7 & 16) != 0 ? EventsManager.Companion.getAppSessionID$purchases_defaultsRelease() : uuid);
    }
}
