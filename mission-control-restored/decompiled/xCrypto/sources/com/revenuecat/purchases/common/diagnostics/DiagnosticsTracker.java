package com.revenuecat.purchases.common.diagnostics;

import W2.E;
import W2.o;
import W2.t;
import X2.K;
import X2.L;
import com.revenuecat.purchases.CacheFetchPolicy;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.LogWrapperKt;
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
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import s3.C1779a;

/* JADX INFO: loaded from: classes.dex */
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
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
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
            m115invoke();
            return E.f5463a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m115invoke() {
            if (DiagnosticsTracker.this.diagnosticsFileHelper.isDiagnosticsFileTooBig()) {
                LogLevel logLevel = LogLevel.VERBOSE;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.v("[Purchases] - " + logLevel.name(), "Diagnostics file is too big. Deleting it.");
                }
                DiagnosticsTracker.this.diagnosticsHelper.resetDiagnosticsStatus();
                DiagnosticsTracker.trackMaxEventsStoredLimitReached$default(DiagnosticsTracker.this, false, 1, null);
            }
            this.$completion.invoke();
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker$trackEvent$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11421 extends s implements Function0 {
        final /* synthetic */ DiagnosticsEntry $diagnosticsEntry;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11421(DiagnosticsEntry diagnosticsEntry) {
            super(0);
            this.$diagnosticsEntry = diagnosticsEntry;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m116invoke();
            return E.f5463a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m116invoke() {
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
        this.commonProperties = appConfig.getStore() == Store.PLAY_STORE ? MapExtensionsKt.filterNotNullValues(L.g(t.a("play_store_version", appConfig.getPlayStoreVersionName()), t.a("play_services_version", appConfig.getPlayServicesVersionName()))) : L.e();
    }

    private final void checkAndClearDiagnosticsFileIfTooBig(Function0 function0) {
        enqueue(new AnonymousClass1(function0));
    }

    private final void enqueue(final Function0 function0) {
        Dispatcher.enqueue$default(this.diagnosticsDispatcher, new Runnable() { // from class: com.revenuecat.purchases.common.diagnostics.b
            @Override // java.lang.Runnable
            public final void run() {
                DiagnosticsTracker.enqueue$lambda$2(function0);
            }
        }, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enqueue$lambda$2(Function0 tmp0) {
        r.f(tmp0, "$tmp0");
        tmp0.invoke();
    }

    private final void trackEvent(DiagnosticsEntryName diagnosticsEntryName, Map<String, ? extends Object> map) {
        trackEvent(new DiagnosticsEntry(null, diagnosticsEntryName, L.k(this.commonProperties, map), this.appSessionID, null, null, 49, null));
    }

    public static /* synthetic */ void trackMaxEventsStoredLimitReached$default(DiagnosticsTracker diagnosticsTracker, boolean z4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z4 = true;
        }
        diagnosticsTracker.trackMaxEventsStoredLimitReached(z4);
    }

    public final DiagnosticsEventTrackerListener getListener() {
        return this.listener;
    }

    public final void setListener(DiagnosticsEventTrackerListener diagnosticsEventTrackerListener) {
        this.listener = diagnosticsEventTrackerListener;
    }

    /* JADX INFO: renamed from: trackAmazonPurchaseAttempt-9VgGkz4, reason: not valid java name */
    public final void m102trackAmazonPurchaseAttempt9VgGkz4(String productId, String str, Integer num, String str2, long j4) {
        r.f(productId, "productId");
        trackEvent(DiagnosticsEntryName.AMAZON_PURCHASE_ATTEMPT, MapExtensionsKt.filterNotNullValues(L.g(t.a(PRODUCT_ID_KEY, productId), t.a(REQUEST_STATUS_KEY, str), t.a(ERROR_CODE_KEY, num), t.a(ERROR_MESSAGE_KEY, str2), t.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(C1779a.s(j4))))));
    }

    /* JADX INFO: renamed from: trackAmazonQueryProductDetailsRequest-KLykuaI, reason: not valid java name */
    public final void m103trackAmazonQueryProductDetailsRequestKLykuaI(long j4, boolean z4, Set<String> requestedProductIds) {
        r.f(requestedProductIds, "requestedProductIds");
        trackEvent(DiagnosticsEntryName.AMAZON_QUERY_PRODUCT_DETAILS_REQUEST, L.g(t.a(SUCCESSFUL_KEY, Boolean.valueOf(z4)), t.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(C1779a.s(j4))), t.a(REQUESTED_PRODUCT_IDS_KEY, requestedProductIds)));
    }

    /* JADX INFO: renamed from: trackAmazonQueryPurchasesRequest-KLykuaI, reason: not valid java name */
    public final void m104trackAmazonQueryPurchasesRequestKLykuaI(long j4, boolean z4, List<String> list) {
        trackEvent(DiagnosticsEntryName.AMAZON_QUERY_PURCHASES_REQUEST, MapExtensionsKt.filterNotNullValues(L.g(t.a(SUCCESSFUL_KEY, Boolean.valueOf(z4)), t.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(C1779a.s(j4))), t.a(FOUND_PRODUCT_IDS_KEY, list))));
    }

    public final void trackClearingDiagnosticsAfterFailedSync() {
        trackEvent(DiagnosticsEntryName.CLEARING_DIAGNOSTICS_AFTER_FAILED_SYNC, L.e());
    }

    public final void trackCustomerInfoVerificationResultIfNeeded(CustomerInfo customerInfo) {
        r.f(customerInfo, "customerInfo");
        VerificationResult verification = customerInfo.getEntitlements().getVerification();
        if (verification == VerificationResult.NOT_REQUESTED) {
            return;
        }
        trackEvent(DiagnosticsEntryName.CUSTOMER_INFO_VERIFICATION_RESULT, K.c(t.a(VERIFICATION_RESULT_KEY, verification.name())));
    }

    public final void trackEnteredOfflineEntitlementsMode() {
        trackEvent(DiagnosticsEntryName.ENTERED_OFFLINE_ENTITLEMENTS_MODE, L.e());
    }

    public final void trackErrorEnteringOfflineEntitlementsMode(PurchasesError error) {
        r.f(error, "error");
        String str = (error.getCode() == PurchasesErrorCode.UnsupportedError && r.b(error.getUnderlyingErrorMessage(), OfflineEntitlementsStrings.OFFLINE_ENTITLEMENTS_UNSUPPORTED_INAPP_PURCHASES)) ? "one_time_purchase_found" : (error.getCode() == PurchasesErrorCode.CustomerInfoError && r.b(error.getUnderlyingErrorMessage(), OfflineEntitlementsStrings.PRODUCT_ENTITLEMENT_MAPPING_REQUIRED)) ? "no_entitlement_mapping_available" : "unknown";
        trackEvent(DiagnosticsEntryName.ERROR_ENTERING_OFFLINE_ENTITLEMENTS_MODE, L.g(t.a("offline_entitlement_error_reason", str), t.a(ERROR_MESSAGE_KEY, error.getMessage() + " Underlying error: " + error.getUnderlyingErrorMessage())));
    }

    public final void trackEventInCurrentThread$purchases_defaultsRelease(DiagnosticsEntry diagnosticsEntry) {
        r.f(diagnosticsEntry, "diagnosticsEntry");
        LogLevel logLevel = LogLevel.VERBOSE;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.v("[Purchases] - " + logLevel.name(), "Tracking diagnostics entry: " + diagnosticsEntry);
        }
        try {
            this.diagnosticsFileHelper.appendEvent(diagnosticsEntry);
            DiagnosticsEventTrackerListener diagnosticsEventTrackerListener = this.listener;
            if (diagnosticsEventTrackerListener != null) {
                diagnosticsEventTrackerListener.onEventTracked();
            }
        } catch (IOException e4) {
            LogLevel logLevel2 = LogLevel.VERBOSE;
            LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                currentLogHandler2.v("[Purchases] - " + logLevel2.name(), "Error tracking diagnostics entry: " + e4);
            }
        }
    }

    /* JADX INFO: renamed from: trackGetCustomerInfoResult-17CK4j0, reason: not valid java name */
    public final void m105trackGetCustomerInfoResult17CK4j0(CacheFetchPolicy cacheFetchPolicy, VerificationResult verificationResult, Boolean bool, String str, Integer num, long j4) {
        r.f(cacheFetchPolicy, "cacheFetchPolicy");
        trackEvent(DiagnosticsEntryName.GET_CUSTOMER_INFO_RESULT, MapExtensionsKt.filterNotNullValues(L.g(t.a(FETCH_POLICY_KEY, cacheFetchPolicy.name()), t.a(VERIFICATION_RESULT_KEY, verificationResult != null ? verificationResult.name() : null), t.a(HAD_UNSYNCED_PURCHASES_BEFORE_KEY, bool), t.a(ERROR_MESSAGE_KEY, str), t.a(ERROR_CODE_KEY, num), t.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(C1779a.s(j4))))));
    }

    public final void trackGetCustomerInfoStarted() {
        trackEvent(DiagnosticsEntryName.GET_CUSTOMER_INFO_STARTED, L.e());
    }

    /* JADX INFO: renamed from: trackGetOfferingsResult-B8UsjHI, reason: not valid java name */
    public final void m106trackGetOfferingsResultB8UsjHI(Set<String> set, Set<String> set2, String str, Integer num, String str2, CacheStatus cacheStatus, long j4) {
        r.f(cacheStatus, "cacheStatus");
        trackEvent(DiagnosticsEntryName.GET_OFFERINGS_RESULT, MapExtensionsKt.filterNotNullValues(L.g(t.a(REQUESTED_PRODUCT_IDS_KEY, set), t.a(NOT_FOUND_PRODUCT_IDS_KEY, set2), t.a(ERROR_MESSAGE_KEY, str), t.a(ERROR_CODE_KEY, num), t.a(VERIFICATION_RESULT_KEY, str2), t.a(CACHE_STATUS_KEY, cacheStatus.name()), t.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(C1779a.s(j4))))));
    }

    public final void trackGetOfferingsStarted() {
        trackEvent(DiagnosticsEntryName.GET_OFFERINGS_STARTED, L.e());
    }

    /* JADX INFO: renamed from: trackGetProductsResult-9VgGkz4, reason: not valid java name */
    public final void m107trackGetProductsResult9VgGkz4(Set<String> requestedProductIds, Set<String> notFoundProductIds, String str, Integer num, long j4) {
        r.f(requestedProductIds, "requestedProductIds");
        r.f(notFoundProductIds, "notFoundProductIds");
        trackEvent(DiagnosticsEntryName.GET_PRODUCTS_RESULT, MapExtensionsKt.filterNotNullValues(L.g(t.a(REQUESTED_PRODUCT_IDS_KEY, requestedProductIds), t.a(NOT_FOUND_PRODUCT_IDS_KEY, notFoundProductIds), t.a(ERROR_MESSAGE_KEY, str), t.a(ERROR_CODE_KEY, num), t.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(C1779a.s(j4))))));
    }

    public final void trackGetProductsStarted(Set<String> requestedProductIds) {
        r.f(requestedProductIds, "requestedProductIds");
        trackEvent(DiagnosticsEntryName.GET_PRODUCTS_STARTED, K.c(t.a(REQUESTED_PRODUCT_IDS_KEY, requestedProductIds)));
    }

    public final void trackGoogleBillingServiceDisconnected() {
        trackEvent(DiagnosticsEntryName.GOOGLE_BILLING_SERVICE_DISCONNECTED, L.e());
    }

    public final void trackGoogleBillingSetupFinished(int i4, String debugMessage, int i5) {
        r.f(debugMessage, "debugMessage");
        trackEvent(DiagnosticsEntryName.GOOGLE_BILLING_SETUP_FINISHED, L.g(t.a(BILLING_RESPONSE_CODE, Integer.valueOf(i4)), t.a(BILLING_DEBUG_MESSAGE, debugMessage), t.a(PENDING_REQUEST_COUNT, Integer.valueOf(i5))));
    }

    public final void trackGoogleBillingStartConnection() {
        trackEvent(DiagnosticsEntryName.GOOGLE_BILLING_START_CONNECTION, L.e());
    }

    public final void trackGooglePurchaseStarted(String productId, String str, Boolean bool, Boolean bool2) {
        r.f(productId, "productId");
        trackEvent(DiagnosticsEntryName.GOOGLE_PURCHASE_STARTED, MapExtensionsKt.filterNotNullValues(L.g(t.a(PRODUCT_ID_KEY, productId), t.a(OLD_PRODUCT_ID_KEY, str), t.a(HAS_INTRO_TRIAL_KEY, bool), t.a(HAS_INTRO_PRICE_KEY, bool2))));
    }

    public final void trackGooglePurchaseUpdateReceived(List<String> list, List<String> list2, int i4, String billingDebugMessage) {
        r.f(billingDebugMessage, "billingDebugMessage");
        trackEvent(DiagnosticsEntryName.GOOGLE_PURCHASES_UPDATE_RECEIVED, MapExtensionsKt.filterNotNullValues(L.g(t.a(PRODUCT_IDS_KEY, list), t.a(PURCHASE_STATUSES_KEY, list2), t.a(BILLING_RESPONSE_CODE, Integer.valueOf(i4)), t.a(BILLING_DEBUG_MESSAGE, billingDebugMessage))));
    }

    /* JADX INFO: renamed from: trackGoogleQueryProductDetailsRequest-9VgGkz4, reason: not valid java name */
    public final void m108trackGoogleQueryProductDetailsRequest9VgGkz4(Set<String> requestedProductIds, String productType, int i4, String billingDebugMessage, long j4) {
        r.f(requestedProductIds, "requestedProductIds");
        r.f(productType, "productType");
        r.f(billingDebugMessage, "billingDebugMessage");
        trackEvent(DiagnosticsEntryName.GOOGLE_QUERY_PRODUCT_DETAILS_REQUEST, L.g(t.a(REQUESTED_PRODUCT_IDS_KEY, requestedProductIds), t.a(PRODUCT_TYPE_QUERIED_KEY, productType), t.a(BILLING_RESPONSE_CODE, Integer.valueOf(i4)), t.a(BILLING_DEBUG_MESSAGE, billingDebugMessage), t.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(C1779a.s(j4)))));
    }

    /* JADX INFO: renamed from: trackGoogleQueryPurchaseHistoryRequest-Wn2Vu4Y, reason: not valid java name */
    public final void m109trackGoogleQueryPurchaseHistoryRequestWn2Vu4Y(String productType, int i4, String billingDebugMessage, long j4) {
        r.f(productType, "productType");
        r.f(billingDebugMessage, "billingDebugMessage");
        trackEvent(DiagnosticsEntryName.GOOGLE_QUERY_PURCHASE_HISTORY_REQUEST, L.g(t.a(PRODUCT_TYPE_QUERIED_KEY, productType), t.a(BILLING_RESPONSE_CODE, Integer.valueOf(i4)), t.a(BILLING_DEBUG_MESSAGE, billingDebugMessage), t.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(C1779a.s(j4)))));
    }

    /* JADX INFO: renamed from: trackGoogleQueryPurchasesRequest-zkXUZaI, reason: not valid java name */
    public final void m110trackGoogleQueryPurchasesRequestzkXUZaI(String productType, int i4, String billingDebugMessage, long j4, List<String> foundProductIds) {
        r.f(productType, "productType");
        r.f(billingDebugMessage, "billingDebugMessage");
        r.f(foundProductIds, "foundProductIds");
        trackEvent(DiagnosticsEntryName.GOOGLE_QUERY_PURCHASES_REQUEST, L.g(t.a(PRODUCT_TYPE_QUERIED_KEY, productType), t.a(BILLING_RESPONSE_CODE, Integer.valueOf(i4)), t.a(BILLING_DEBUG_MESSAGE, billingDebugMessage), t.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(C1779a.s(j4))), t.a(FOUND_PRODUCT_IDS_KEY, foundProductIds)));
    }

    /* JADX INFO: renamed from: trackHttpRequestPerformed-OCcUtpk, reason: not valid java name */
    public final void m111trackHttpRequestPerformedOCcUtpk(String host, Endpoint endpoint, long j4, boolean z4, int i4, Integer num, HTTPResult.Origin origin, VerificationResult verificationResult, boolean z5) {
        r.f(host, "host");
        r.f(endpoint, "endpoint");
        r.f(verificationResult, "verificationResult");
        trackEvent(DiagnosticsEntryName.HTTP_REQUEST_PERFORMED, MapExtensionsKt.filterNotNullValues(L.g(t.a(HOST_KEY, host), t.a(ENDPOINT_NAME_KEY, endpoint.getName()), t.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(C1779a.s(j4))), t.a(SUCCESSFUL_KEY, Boolean.valueOf(z4)), t.a(RESPONSE_CODE_KEY, Integer.valueOf(i4)), t.a(BACKEND_ERROR_CODE_KEY, num), t.a(ETAG_HIT_KEY, Boolean.valueOf(origin == HTTPResult.Origin.CACHE)), t.a(VERIFICATION_RESULT_KEY, verificationResult.name()), t.a(IS_RETRY, Boolean.valueOf(z5)))));
    }

    public final void trackMaxDiagnosticsSyncRetriesReached() {
        trackEvent(DiagnosticsEntryName.MAX_DIAGNOSTICS_SYNC_RETRIES_REACHED, L.e());
    }

    public final void trackMaxEventsStoredLimitReached(boolean z4) {
        DiagnosticsEntry diagnosticsEntry = new DiagnosticsEntry(null, DiagnosticsEntryName.MAX_EVENTS_STORED_LIMIT_REACHED, this.commonProperties, this.appSessionID, null, null, 49, null);
        if (z4) {
            trackEventInCurrentThread$purchases_defaultsRelease(diagnosticsEntry);
        } else {
            trackEvent(diagnosticsEntry);
        }
    }

    public final void trackProductDetailsNotSupported(int i4, String billingDebugMessage) {
        r.f(billingDebugMessage, "billingDebugMessage");
        DiagnosticsEntryName diagnosticsEntryName = DiagnosticsEntryName.PRODUCT_DETAILS_NOT_SUPPORTED;
        String playStoreVersionName = this.appConfig.getPlayStoreVersionName();
        if (playStoreVersionName == null) {
            playStoreVersionName = "";
        }
        o oVarA = t.a("play_store_version", playStoreVersionName);
        String playServicesVersionName = this.appConfig.getPlayServicesVersionName();
        trackEvent(diagnosticsEntryName, L.g(oVarA, t.a("play_services_version", playServicesVersionName != null ? playServicesVersionName : ""), t.a(BILLING_RESPONSE_CODE, Integer.valueOf(i4)), t.a(BILLING_DEBUG_MESSAGE, billingDebugMessage)));
    }

    /* JADX INFO: renamed from: trackPurchaseResult-myKFqkg, reason: not valid java name */
    public final void m112trackPurchaseResultmyKFqkg(String productId, ProductType productType, Integer num, String str, long j4, VerificationResult verificationResult) {
        r.f(productId, "productId");
        r.f(productType, "productType");
        trackEvent(DiagnosticsEntryName.PURCHASE_RESULT, MapExtensionsKt.filterNotNullValues(L.g(t.a(PRODUCT_ID_KEY, productId), t.a(PRODUCT_TYPE_KEY, DiagnosticsTrackerKt.getDiagnosticsName(productType)), t.a(ERROR_CODE_KEY, num), t.a(ERROR_MESSAGE_KEY, str), t.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(C1779a.s(j4))), t.a(VERIFICATION_RESULT_KEY, verificationResult != null ? verificationResult.name() : null))));
    }

    public final void trackPurchaseStarted(String productId, ProductType productType) {
        r.f(productId, "productId");
        r.f(productType, "productType");
        trackEvent(DiagnosticsEntryName.PURCHASE_STARTED, L.g(t.a(PRODUCT_ID_KEY, productId), t.a(PRODUCT_TYPE_KEY, DiagnosticsTrackerKt.getDiagnosticsName(productType))));
    }

    /* JADX INFO: renamed from: trackRestorePurchasesResult-SxA4cEA, reason: not valid java name */
    public final void m113trackRestorePurchasesResultSxA4cEA(Integer num, String str, long j4) {
        trackEvent(DiagnosticsEntryName.RESTORE_PURCHASES_RESULT, MapExtensionsKt.filterNotNullValues(L.g(t.a(ERROR_CODE_KEY, num), t.a(ERROR_MESSAGE_KEY, str), t.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(C1779a.s(j4))))));
    }

    public final void trackRestorePurchasesStarted() {
        trackEvent(DiagnosticsEntryName.RESTORE_PURCHASES_STARTED, L.e());
    }

    /* JADX INFO: renamed from: trackSyncPurchasesResult-SxA4cEA, reason: not valid java name */
    public final void m114trackSyncPurchasesResultSxA4cEA(Integer num, String str, long j4) {
        trackEvent(DiagnosticsEntryName.SYNC_PURCHASES_RESULT, MapExtensionsKt.filterNotNullValues(L.g(t.a(ERROR_CODE_KEY, num), t.a(ERROR_MESSAGE_KEY, str), t.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(C1779a.s(j4))))));
    }

    public final void trackSyncPurchasesStarted() {
        trackEvent(DiagnosticsEntryName.SYNC_PURCHASES_STARTED, L.e());
    }

    public final void trackEvent(DiagnosticsEntry diagnosticsEntry) {
        r.f(diagnosticsEntry, "diagnosticsEntry");
        checkAndClearDiagnosticsFileIfTooBig(new C11421(diagnosticsEntry));
    }

    public /* synthetic */ DiagnosticsTracker(AppConfig appConfig, DiagnosticsFileHelper diagnosticsFileHelper, DiagnosticsHelper diagnosticsHelper, Dispatcher dispatcher, UUID uuid, int i4, AbstractC1585j abstractC1585j) {
        this(appConfig, diagnosticsFileHelper, diagnosticsHelper, dispatcher, (i4 & 16) != 0 ? EventsManager.Companion.getAppSessionID$purchases_defaultsRelease() : uuid);
    }
}
