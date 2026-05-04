package com.revenuecat.purchases.common.diagnostics;

import cd.h0;
import cd.q;
import cd.w;
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
import com.revenuecat.purchases.common.networking.ConnectionErrorReason;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.strings.OfflineEntitlementsStrings;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import dd.n0;
import dd.o0;
import io.flutter.plugins.firebase.analytics.Constants;
import io.flutter.plugins.firebase.database.FlutterFirebaseDatabaseException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000  \u00012\u00020\u0001:\u0004¡\u0001 \u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0018\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001b\u001a\u00020\u00132\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u0016H\u0002¢\u0006\u0004\b\u001b\u0010\u0019Jf\u0010/\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010#2\b\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020!2\b\u0010,\u001a\u0004\u0018\u00010+ø\u0001\u0000¢\u0006\u0004\b-\u0010.J>\u00107\u001a\u00020\u00132\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u0011002\u0006\u00102\u001a\u00020\u00112\u0006\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u001fø\u0001\u0000¢\u0006\u0004\b5\u00106J>\u0010<\u001a\u00020\u00132\u0006\u00102\u001a\u00020\u00112\u0006\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u001f2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u001108ø\u0001\u0000¢\u0006\u0004\b:\u0010;J0\u0010?\u001a\u00020\u00132\u0006\u00102\u001a\u00020\u00112\u0006\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u001fø\u0001\u0000¢\u0006\u0004\b=\u0010>J\r\u0010@\u001a\u00020\u0013¢\u0006\u0004\b@\u0010AJ%\u0010D\u001a\u00020\u00132\u0006\u0010$\u001a\u00020#2\u0006\u0010B\u001a\u00020\u00112\u0006\u0010C\u001a\u00020#¢\u0006\u0004\bD\u0010EJ\r\u0010F\u001a\u00020\u0013¢\u0006\u0004\bF\u0010AJ3\u0010K\u001a\u00020\u00132\u0006\u0010G\u001a\u00020\u00112\b\u0010H\u001a\u0004\u0018\u00010\u00112\b\u0010I\u001a\u0004\u0018\u00010!2\b\u0010J\u001a\u0004\u0018\u00010!¢\u0006\u0004\bK\u0010LJ=\u0010O\u001a\u00020\u00132\u000e\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001082\u000e\u0010N\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001082\u0006\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020\u0011¢\u0006\u0004\bO\u0010PJ.\u0010S\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001100ø\u0001\u0000¢\u0006\u0004\bQ\u0010RJ0\u0010V\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u000e\u00109\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u000108ø\u0001\u0000¢\u0006\u0004\bT\u0010UJ>\u0010\\\u001a\u00020\u00132\u0006\u0010G\u001a\u00020\u00112\b\u0010W\u001a\u0004\u0018\u00010\u00112\b\u0010X\u001a\u0004\u0018\u00010#2\b\u0010Y\u001a\u0004\u0018\u00010\u00112\u0006\u0010 \u001a\u00020\u001fø\u0001\u0000¢\u0006\u0004\bZ\u0010[J\u0017\u0010^\u001a\u00020\u00132\b\b\u0002\u0010]\u001a\u00020!¢\u0006\u0004\b^\u0010_J\r\u0010`\u001a\u00020\u0013¢\u0006\u0004\b`\u0010AJ\r\u0010a\u001a\u00020\u0013¢\u0006\u0004\ba\u0010AJ\u001d\u0010b\u001a\u00020\u00132\u0006\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020\u0011¢\u0006\u0004\bb\u0010cJ\u0015\u0010f\u001a\u00020\u00132\u0006\u0010e\u001a\u00020d¢\u0006\u0004\bf\u0010gJ\r\u0010h\u001a\u00020\u0013¢\u0006\u0004\bh\u0010AJ\u0015\u0010k\u001a\u00020\u00132\u0006\u0010j\u001a\u00020i¢\u0006\u0004\bk\u0010lJ\r\u0010m\u001a\u00020\u0013¢\u0006\u0004\bm\u0010AJ^\u0010s\u001a\u00020\u00132\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001002\u000e\u0010n\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001002\b\u0010Y\u001a\u0004\u0018\u00010\u00112\b\u0010X\u001a\u0004\u0018\u00010#2\b\u0010)\u001a\u0004\u0018\u00010\u00112\u0006\u0010p\u001a\u00020o2\u0006\u0010 \u001a\u00020\u001fø\u0001\u0000¢\u0006\u0004\bq\u0010rJ\u001b\u0010t\u001a\u00020\u00132\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001100¢\u0006\u0004\bt\u0010uJH\u0010x\u001a\u00020\u00132\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u0011002\f\u0010n\u001a\b\u0012\u0004\u0012\u00020\u0011002\b\u0010Y\u001a\u0004\u0018\u00010\u00112\b\u0010X\u001a\u0004\u0018\u00010#2\u0006\u0010 \u001a\u00020\u001fø\u0001\u0000¢\u0006\u0004\bv\u0010wJ\r\u0010y\u001a\u00020\u0013¢\u0006\u0004\by\u0010AJ,\u0010|\u001a\u00020\u00132\b\u0010X\u001a\u0004\u0018\u00010#2\b\u0010Y\u001a\u0004\u0018\u00010\u00112\u0006\u0010 \u001a\u00020\u001fø\u0001\u0000¢\u0006\u0004\bz\u0010{J\r\u0010}\u001a\u00020\u0013¢\u0006\u0004\b}\u0010AJ,\u0010\u007f\u001a\u00020\u00132\b\u0010X\u001a\u0004\u0018\u00010#2\b\u0010Y\u001a\u0004\u0018\u00010\u00112\u0006\u0010 \u001a\u00020\u001fø\u0001\u0000¢\u0006\u0004\b~\u0010{J\u000f\u0010\u0080\u0001\u001a\u00020\u0013¢\u0006\u0005\b\u0080\u0001\u0010AJN\u0010\u0086\u0001\u001a\u00020\u00132\b\u0010\u0082\u0001\u001a\u00030\u0081\u00012\b\u0010)\u001a\u0004\u0018\u00010(2\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010!2\b\u0010Y\u001a\u0004\u0018\u00010\u00112\b\u0010X\u001a\u0004\u0018\u00010#2\u0006\u0010 \u001a\u00020\u001fø\u0001\u0000¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J!\u0010\u0088\u0001\u001a\u00020\u00132\u0006\u0010G\u001a\u00020\u00112\u0007\u00102\u001a\u00030\u0087\u0001¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001JJ\u0010\u008c\u0001\u001a\u00020\u00132\u0006\u0010G\u001a\u00020\u00112\u0007\u00102\u001a\u00030\u0087\u00012\b\u0010X\u001a\u0004\u0018\u00010#2\b\u0010Y\u001a\u0004\u0018\u00010\u00112\u0006\u0010 \u001a\u00020\u001f2\b\u0010)\u001a\u0004\u0018\u00010(ø\u0001\u0000¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u008e\u0001\u001a\u00030\u008d\u0001H\u0007¢\u0006\u0005\b\u0014\u0010\u008f\u0001J\u001c\u0010\u0091\u0001\u001a\u00020\u00132\b\u0010\u008e\u0001\u001a\u00030\u008d\u0001H\u0000¢\u0006\u0006\b\u0090\u0001\u0010\u008f\u0001R\u0015\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0003\u0010\u0092\u0001R\u0015\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0005\u0010\u0093\u0001R\u0015\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0007\u0010\u0094\u0001R\u0015\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\t\u0010\u0095\u0001R\u0015\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u000b\u0010\u0096\u0001R#\u0010\u0097\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R,\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0099\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009a\u0001\u0010\u009b\u0001\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001\"\u0006\b\u009e\u0001\u0010\u009f\u0001\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006¢\u0001"}, d2 = {"Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;", "", "Lcom/revenuecat/purchases/common/AppConfig;", "appConfig", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsFileHelper;", "diagnosticsFileHelper", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsHelper;", "diagnosticsHelper", "Lcom/revenuecat/purchases/common/Dispatcher;", "diagnosticsDispatcher", "Ljava/util/UUID;", "appSessionID", "<init>", "(Lcom/revenuecat/purchases/common/AppConfig;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsFileHelper;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsHelper;Lcom/revenuecat/purchases/common/Dispatcher;Ljava/util/UUID;)V", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEntryName;", Constants.EVENT_NAME, "", "", DiagnosticsEntry.PROPERTIES_KEY, "Lcd/h0;", "trackEvent", "(Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEntryName;Ljava/util/Map;)V", "Lkotlin/Function0;", "completion", "checkAndClearDiagnosticsFileIfTooBig", "(Lkotlin/jvm/functions/Function0;)V", "command", "enqueue", DiagnosticsTracker.HOST_KEY, "Lcom/revenuecat/purchases/common/networking/Endpoint;", "endpoint", "Llg/a;", "responseTime", "", "wasSuccessful", "", "responseCode", "backendErrorCode", "Lcom/revenuecat/purchases/common/networking/HTTPResult$Origin;", "resultOrigin", "Lcom/revenuecat/purchases/VerificationResult;", "verificationResult", "isRetry", "Lcom/revenuecat/purchases/common/networking/ConnectionErrorReason;", "connectionErrorReason", "trackHttpRequestPerformed--XzGXFE", "(Ljava/lang/String;Lcom/revenuecat/purchases/common/networking/Endpoint;JZILjava/lang/Integer;Lcom/revenuecat/purchases/common/networking/HTTPResult$Origin;Lcom/revenuecat/purchases/VerificationResult;ZLcom/revenuecat/purchases/common/networking/ConnectionErrorReason;)V", "trackHttpRequestPerformed", "", "requestedProductIds", "productType", "billingResponseCode", "billingDebugMessage", "trackGoogleQueryProductDetailsRequest-9VgGkz4", "(Ljava/util/Set;Ljava/lang/String;ILjava/lang/String;J)V", "trackGoogleQueryProductDetailsRequest", "", "foundProductIds", "trackGoogleQueryPurchasesRequest-zkXUZaI", "(Ljava/lang/String;ILjava/lang/String;JLjava/util/List;)V", "trackGoogleQueryPurchasesRequest", "trackGoogleQueryPurchaseHistoryRequest-Wn2Vu4Y", "(Ljava/lang/String;ILjava/lang/String;J)V", "trackGoogleQueryPurchaseHistoryRequest", "trackGoogleBillingStartConnection", "()V", "debugMessage", "pendingRequestCount", "trackGoogleBillingSetupFinished", "(ILjava/lang/String;I)V", "trackGoogleBillingServiceDisconnected", "productId", "oldProductId", "hasIntroTrial", "hasIntroPrice", "trackGooglePurchaseStarted", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "productIds", "purchaseStatuses", "trackGooglePurchaseUpdateReceived", "(Ljava/util/List;Ljava/util/List;ILjava/lang/String;)V", "trackAmazonQueryProductDetailsRequest-KLykuaI", "(JZLjava/util/Set;)V", "trackAmazonQueryProductDetailsRequest", "trackAmazonQueryPurchasesRequest-KLykuaI", "(JZLjava/util/List;)V", "trackAmazonQueryPurchasesRequest", com.amazon.a.a.o.b.C, "errorCode", com.amazon.a.a.o.b.f4552f, "trackAmazonPurchaseAttempt-9VgGkz4", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;J)V", "trackAmazonPurchaseAttempt", "useCurrentThread", "trackMaxEventsStoredLimitReached", "(Z)V", "trackMaxDiagnosticsSyncRetriesReached", "trackClearingDiagnosticsAfterFailedSync", "trackProductDetailsNotSupported", "(ILjava/lang/String;)V", "Lcom/revenuecat/purchases/CustomerInfo;", "customerInfo", "trackCustomerInfoVerificationResultIfNeeded", "(Lcom/revenuecat/purchases/CustomerInfo;)V", "trackEnteredOfflineEntitlementsMode", "Lcom/revenuecat/purchases/PurchasesError;", "error", "trackErrorEnteringOfflineEntitlementsMode", "(Lcom/revenuecat/purchases/PurchasesError;)V", "trackGetOfferingsStarted", "notFoundProductIds", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker$CacheStatus;", "cacheStatus", "trackGetOfferingsResult-B8UsjHI", "(Ljava/util/Set;Ljava/util/Set;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker$CacheStatus;J)V", "trackGetOfferingsResult", "trackGetProductsStarted", "(Ljava/util/Set;)V", "trackGetProductsResult-9VgGkz4", "(Ljava/util/Set;Ljava/util/Set;Ljava/lang/String;Ljava/lang/Integer;J)V", "trackGetProductsResult", "trackSyncPurchasesStarted", "trackSyncPurchasesResult-SxA4cEA", "(Ljava/lang/Integer;Ljava/lang/String;J)V", "trackSyncPurchasesResult", "trackRestorePurchasesStarted", "trackRestorePurchasesResult-SxA4cEA", "trackRestorePurchasesResult", "trackGetCustomerInfoStarted", "Lcom/revenuecat/purchases/CacheFetchPolicy;", "cacheFetchPolicy", "hadUnsyncedPurchasesBefore", "trackGetCustomerInfoResult-17CK4j0", "(Lcom/revenuecat/purchases/CacheFetchPolicy;Lcom/revenuecat/purchases/VerificationResult;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;J)V", "trackGetCustomerInfoResult", "Lcom/revenuecat/purchases/ProductType;", "trackPurchaseStarted", "(Ljava/lang/String;Lcom/revenuecat/purchases/ProductType;)V", "trackPurchaseResult-myKFqkg", "(Ljava/lang/String;Lcom/revenuecat/purchases/ProductType;Ljava/lang/Integer;Ljava/lang/String;JLcom/revenuecat/purchases/VerificationResult;)V", "trackPurchaseResult", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEntry;", "diagnosticsEntry", "(Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEntry;)V", "trackEventInCurrentThread$purchases_defaultsBc8Release", "trackEventInCurrentThread", "Lcom/revenuecat/purchases/common/AppConfig;", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsFileHelper;", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsHelper;", "Lcom/revenuecat/purchases/common/Dispatcher;", "Ljava/util/UUID;", "commonProperties", "Ljava/util/Map;", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEventTrackerListener;", "listener", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEventTrackerListener;", "getListener", "()Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEventTrackerListener;", "setListener", "(Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsEventTrackerListener;)V", "Companion", "CacheStatus", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DiagnosticsTracker {

    @Deprecated
    public static final String BACKEND_ERROR_CODE_KEY = "backend_error_code";

    @Deprecated
    public static final String BILLING_DEBUG_MESSAGE = "billing_debug_message";

    @Deprecated
    public static final String BILLING_RESPONSE_CODE = "billing_response_code";

    @Deprecated
    public static final String CACHE_STATUS_KEY = "cache_status";

    @Deprecated
    public static final String CONNECTION_ERROR_REASON_KEY = "connection_error_reason";
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

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker$CacheStatus;", "", "(Ljava/lang/String;I)V", "NOT_CHECKED", "NOT_FOUND", "STALE", "VALID", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum CacheStatus {
        NOT_CHECKED,
        NOT_FOUND,
        STALE,
        VALID
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001e\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker$Companion;", "", "()V", "BACKEND_ERROR_CODE_KEY", "", "BILLING_DEBUG_MESSAGE", "BILLING_RESPONSE_CODE", "CACHE_STATUS_KEY", "CONNECTION_ERROR_REASON_KEY", "ENDPOINT_NAME_KEY", "ERROR_CODE_KEY", "ERROR_MESSAGE_KEY", "ETAG_HIT_KEY", "FETCH_POLICY_KEY", "FOUND_PRODUCT_IDS_KEY", "HAD_UNSYNCED_PURCHASES_BEFORE_KEY", "HAS_INTRO_PRICE_KEY", "HAS_INTRO_TRIAL_KEY", "HOST_KEY", "IS_RETRY", "NOT_FOUND_PRODUCT_IDS_KEY", "OLD_PRODUCT_ID_KEY", "PENDING_REQUEST_COUNT", "PRODUCT_IDS_KEY", "PRODUCT_ID_KEY", "PRODUCT_TYPE_KEY", "PRODUCT_TYPE_QUERIED_KEY", "PURCHASE_STATUSES_KEY", "REQUESTED_PRODUCT_IDS_KEY", "REQUEST_STATUS_KEY", "RESPONSE_CODE_KEY", "RESPONSE_TIME_MILLIS_KEY", "SUCCESSFUL_KEY", "VERIFICATION_RESULT_KEY", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(k kVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker$checkAndClearDiagnosticsFileIfTooBig$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcd/h0;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    public static final class AnonymousClass1 extends v implements Function0 {
        final /* synthetic */ Function0 $completion;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function0 function0) {
            super(0);
            this.$completion = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m124invoke();
            return h0.f3852a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m124invoke() {
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
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcd/h0;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    public static final class C05611 extends v implements Function0 {
        final /* synthetic */ DiagnosticsEntry $diagnosticsEntry;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C05611(DiagnosticsEntry diagnosticsEntry) {
            super(0);
            this.$diagnosticsEntry = diagnosticsEntry;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m125invoke();
            return h0.f3852a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m125invoke() {
            DiagnosticsTracker.this.trackEventInCurrentThread$purchases_defaultsBc8Release(this.$diagnosticsEntry);
        }
    }

    public DiagnosticsTracker(AppConfig appConfig, DiagnosticsFileHelper diagnosticsFileHelper, DiagnosticsHelper diagnosticsHelper, Dispatcher diagnosticsDispatcher, UUID appSessionID) {
        t.f(appConfig, "appConfig");
        t.f(diagnosticsFileHelper, "diagnosticsFileHelper");
        t.f(diagnosticsHelper, "diagnosticsHelper");
        t.f(diagnosticsDispatcher, "diagnosticsDispatcher");
        t.f(appSessionID, "appSessionID");
        this.appConfig = appConfig;
        this.diagnosticsFileHelper = diagnosticsFileHelper;
        this.diagnosticsHelper = diagnosticsHelper;
        this.diagnosticsDispatcher = diagnosticsDispatcher;
        this.appSessionID = appSessionID;
        this.commonProperties = appConfig.getStore() == Store.PLAY_STORE ? MapExtensionsKt.filterNotNullValues(o0.l(w.a("play_store_version", appConfig.getPlayStoreVersionName()), w.a("play_services_version", appConfig.getPlayServicesVersionName()))) : o0.h();
    }

    private final void checkAndClearDiagnosticsFileIfTooBig(Function0 completion) {
        enqueue(new AnonymousClass1(completion));
    }

    private final void enqueue(final Function0 command) {
        Dispatcher.enqueue$default(this.diagnosticsDispatcher, new Runnable() { // from class: com.revenuecat.purchases.common.diagnostics.b
            @Override // java.lang.Runnable
            public final void run() {
                command.invoke();
            }
        }, null, 2, null);
    }

    private final void trackEvent(DiagnosticsEntryName eventName, Map<String, ? extends Object> properties) {
        trackEvent(new DiagnosticsEntry(null, eventName, o0.p(this.commonProperties, properties), this.appSessionID, null, null, 49, null));
    }

    public static /* synthetic */ void trackMaxEventsStoredLimitReached$default(DiagnosticsTracker diagnosticsTracker, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        diagnosticsTracker.trackMaxEventsStoredLimitReached(z10);
    }

    public final DiagnosticsEventTrackerListener getListener() {
        return this.listener;
    }

    public final void setListener(DiagnosticsEventTrackerListener diagnosticsEventTrackerListener) {
        this.listener = diagnosticsEventTrackerListener;
    }

    /* JADX INFO: renamed from: trackAmazonPurchaseAttempt-9VgGkz4, reason: not valid java name */
    public final void m111trackAmazonPurchaseAttempt9VgGkz4(String productId, String requestStatus, Integer errorCode, String errorMessage, long responseTime) {
        t.f(productId, "productId");
        trackEvent(DiagnosticsEntryName.AMAZON_PURCHASE_ATTEMPT, MapExtensionsKt.filterNotNullValues(o0.l(w.a(PRODUCT_ID_KEY, productId), w.a(REQUEST_STATUS_KEY, requestStatus), w.a(ERROR_CODE_KEY, errorCode), w.a(ERROR_MESSAGE_KEY, errorMessage), w.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(lg.a.w(responseTime))))));
    }

    /* JADX INFO: renamed from: trackAmazonQueryProductDetailsRequest-KLykuaI, reason: not valid java name */
    public final void m112trackAmazonQueryProductDetailsRequestKLykuaI(long responseTime, boolean wasSuccessful, Set<String> requestedProductIds) {
        t.f(requestedProductIds, "requestedProductIds");
        trackEvent(DiagnosticsEntryName.AMAZON_QUERY_PRODUCT_DETAILS_REQUEST, o0.l(w.a(SUCCESSFUL_KEY, Boolean.valueOf(wasSuccessful)), w.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(lg.a.w(responseTime))), w.a(REQUESTED_PRODUCT_IDS_KEY, requestedProductIds)));
    }

    /* JADX INFO: renamed from: trackAmazonQueryPurchasesRequest-KLykuaI, reason: not valid java name */
    public final void m113trackAmazonQueryPurchasesRequestKLykuaI(long responseTime, boolean wasSuccessful, List<String> foundProductIds) {
        trackEvent(DiagnosticsEntryName.AMAZON_QUERY_PURCHASES_REQUEST, MapExtensionsKt.filterNotNullValues(o0.l(w.a(SUCCESSFUL_KEY, Boolean.valueOf(wasSuccessful)), w.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(lg.a.w(responseTime))), w.a(FOUND_PRODUCT_IDS_KEY, foundProductIds))));
    }

    public final void trackClearingDiagnosticsAfterFailedSync() {
        trackEvent(DiagnosticsEntryName.CLEARING_DIAGNOSTICS_AFTER_FAILED_SYNC, o0.h());
    }

    public final void trackCustomerInfoVerificationResultIfNeeded(CustomerInfo customerInfo) {
        t.f(customerInfo, "customerInfo");
        VerificationResult verification = customerInfo.getEntitlements().getVerification();
        if (verification == VerificationResult.NOT_REQUESTED) {
            return;
        }
        trackEvent(DiagnosticsEntryName.CUSTOMER_INFO_VERIFICATION_RESULT, n0.e(w.a(VERIFICATION_RESULT_KEY, verification.name())));
    }

    public final void trackEnteredOfflineEntitlementsMode() {
        trackEvent(DiagnosticsEntryName.ENTERED_OFFLINE_ENTITLEMENTS_MODE, o0.h());
    }

    public final void trackErrorEnteringOfflineEntitlementsMode(PurchasesError error) {
        t.f(error, "error");
        String str = (error.getCode() == PurchasesErrorCode.UnsupportedError && t.b(error.getUnderlyingErrorMessage(), OfflineEntitlementsStrings.OFFLINE_ENTITLEMENTS_UNSUPPORTED_INAPP_PURCHASES)) ? "one_time_purchase_found" : (error.getCode() == PurchasesErrorCode.CustomerInfoError && t.b(error.getUnderlyingErrorMessage(), OfflineEntitlementsStrings.PRODUCT_ENTITLEMENT_MAPPING_REQUIRED)) ? "no_entitlement_mapping_available" : FlutterFirebaseDatabaseException.UNKNOWN_ERROR_CODE;
        trackEvent(DiagnosticsEntryName.ERROR_ENTERING_OFFLINE_ENTITLEMENTS_MODE, o0.l(w.a("offline_entitlement_error_reason", str), w.a(ERROR_MESSAGE_KEY, error.getMessage() + " Underlying error: " + error.getUnderlyingErrorMessage())));
    }

    public final void trackEventInCurrentThread$purchases_defaultsBc8Release(DiagnosticsEntry diagnosticsEntry) {
        t.f(diagnosticsEntry, "diagnosticsEntry");
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
        } catch (IOException e10) {
            LogLevel logLevel2 = LogLevel.VERBOSE;
            LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                currentLogHandler2.v("[Purchases] - " + logLevel2.name(), "Error tracking diagnostics entry: " + e10);
            }
        }
    }

    /* JADX INFO: renamed from: trackGetCustomerInfoResult-17CK4j0, reason: not valid java name */
    public final void m114trackGetCustomerInfoResult17CK4j0(CacheFetchPolicy cacheFetchPolicy, VerificationResult verificationResult, Boolean hadUnsyncedPurchasesBefore, String errorMessage, Integer errorCode, long responseTime) {
        t.f(cacheFetchPolicy, "cacheFetchPolicy");
        trackEvent(DiagnosticsEntryName.GET_CUSTOMER_INFO_RESULT, MapExtensionsKt.filterNotNullValues(o0.l(w.a(FETCH_POLICY_KEY, cacheFetchPolicy.name()), w.a(VERIFICATION_RESULT_KEY, verificationResult != null ? verificationResult.name() : null), w.a(HAD_UNSYNCED_PURCHASES_BEFORE_KEY, hadUnsyncedPurchasesBefore), w.a(ERROR_MESSAGE_KEY, errorMessage), w.a(ERROR_CODE_KEY, errorCode), w.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(lg.a.w(responseTime))))));
    }

    public final void trackGetCustomerInfoStarted() {
        trackEvent(DiagnosticsEntryName.GET_CUSTOMER_INFO_STARTED, o0.h());
    }

    /* JADX INFO: renamed from: trackGetOfferingsResult-B8UsjHI, reason: not valid java name */
    public final void m115trackGetOfferingsResultB8UsjHI(Set<String> requestedProductIds, Set<String> notFoundProductIds, String errorMessage, Integer errorCode, String verificationResult, CacheStatus cacheStatus, long responseTime) {
        t.f(cacheStatus, "cacheStatus");
        trackEvent(DiagnosticsEntryName.GET_OFFERINGS_RESULT, MapExtensionsKt.filterNotNullValues(o0.l(w.a(REQUESTED_PRODUCT_IDS_KEY, requestedProductIds), w.a(NOT_FOUND_PRODUCT_IDS_KEY, notFoundProductIds), w.a(ERROR_MESSAGE_KEY, errorMessage), w.a(ERROR_CODE_KEY, errorCode), w.a(VERIFICATION_RESULT_KEY, verificationResult), w.a(CACHE_STATUS_KEY, cacheStatus.name()), w.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(lg.a.w(responseTime))))));
    }

    public final void trackGetOfferingsStarted() {
        trackEvent(DiagnosticsEntryName.GET_OFFERINGS_STARTED, o0.h());
    }

    /* JADX INFO: renamed from: trackGetProductsResult-9VgGkz4, reason: not valid java name */
    public final void m116trackGetProductsResult9VgGkz4(Set<String> requestedProductIds, Set<String> notFoundProductIds, String errorMessage, Integer errorCode, long responseTime) {
        t.f(requestedProductIds, "requestedProductIds");
        t.f(notFoundProductIds, "notFoundProductIds");
        trackEvent(DiagnosticsEntryName.GET_PRODUCTS_RESULT, MapExtensionsKt.filterNotNullValues(o0.l(w.a(REQUESTED_PRODUCT_IDS_KEY, requestedProductIds), w.a(NOT_FOUND_PRODUCT_IDS_KEY, notFoundProductIds), w.a(ERROR_MESSAGE_KEY, errorMessage), w.a(ERROR_CODE_KEY, errorCode), w.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(lg.a.w(responseTime))))));
    }

    public final void trackGetProductsStarted(Set<String> requestedProductIds) {
        t.f(requestedProductIds, "requestedProductIds");
        trackEvent(DiagnosticsEntryName.GET_PRODUCTS_STARTED, n0.e(w.a(REQUESTED_PRODUCT_IDS_KEY, requestedProductIds)));
    }

    public final void trackGoogleBillingServiceDisconnected() {
        trackEvent(DiagnosticsEntryName.GOOGLE_BILLING_SERVICE_DISCONNECTED, o0.h());
    }

    public final void trackGoogleBillingSetupFinished(int responseCode, String debugMessage, int pendingRequestCount) {
        t.f(debugMessage, "debugMessage");
        trackEvent(DiagnosticsEntryName.GOOGLE_BILLING_SETUP_FINISHED, o0.l(w.a(BILLING_RESPONSE_CODE, Integer.valueOf(responseCode)), w.a(BILLING_DEBUG_MESSAGE, debugMessage), w.a(PENDING_REQUEST_COUNT, Integer.valueOf(pendingRequestCount))));
    }

    public final void trackGoogleBillingStartConnection() {
        trackEvent(DiagnosticsEntryName.GOOGLE_BILLING_START_CONNECTION, o0.h());
    }

    public final void trackGooglePurchaseStarted(String productId, String oldProductId, Boolean hasIntroTrial, Boolean hasIntroPrice) {
        t.f(productId, "productId");
        trackEvent(DiagnosticsEntryName.GOOGLE_PURCHASE_STARTED, MapExtensionsKt.filterNotNullValues(o0.l(w.a(PRODUCT_ID_KEY, productId), w.a(OLD_PRODUCT_ID_KEY, oldProductId), w.a(HAS_INTRO_TRIAL_KEY, hasIntroTrial), w.a(HAS_INTRO_PRICE_KEY, hasIntroPrice))));
    }

    public final void trackGooglePurchaseUpdateReceived(List<String> productIds, List<String> purchaseStatuses, int billingResponseCode, String billingDebugMessage) {
        t.f(billingDebugMessage, "billingDebugMessage");
        trackEvent(DiagnosticsEntryName.GOOGLE_PURCHASES_UPDATE_RECEIVED, MapExtensionsKt.filterNotNullValues(o0.l(w.a(PRODUCT_IDS_KEY, productIds), w.a(PURCHASE_STATUSES_KEY, purchaseStatuses), w.a(BILLING_RESPONSE_CODE, Integer.valueOf(billingResponseCode)), w.a(BILLING_DEBUG_MESSAGE, billingDebugMessage))));
    }

    /* JADX INFO: renamed from: trackGoogleQueryProductDetailsRequest-9VgGkz4, reason: not valid java name */
    public final void m117trackGoogleQueryProductDetailsRequest9VgGkz4(Set<String> requestedProductIds, String productType, int billingResponseCode, String billingDebugMessage, long responseTime) {
        t.f(requestedProductIds, "requestedProductIds");
        t.f(productType, "productType");
        t.f(billingDebugMessage, "billingDebugMessage");
        trackEvent(DiagnosticsEntryName.GOOGLE_QUERY_PRODUCT_DETAILS_REQUEST, o0.l(w.a(REQUESTED_PRODUCT_IDS_KEY, requestedProductIds), w.a(PRODUCT_TYPE_QUERIED_KEY, productType), w.a(BILLING_RESPONSE_CODE, Integer.valueOf(billingResponseCode)), w.a(BILLING_DEBUG_MESSAGE, billingDebugMessage), w.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(lg.a.w(responseTime)))));
    }

    /* JADX INFO: renamed from: trackGoogleQueryPurchaseHistoryRequest-Wn2Vu4Y, reason: not valid java name */
    public final void m118trackGoogleQueryPurchaseHistoryRequestWn2Vu4Y(String productType, int billingResponseCode, String billingDebugMessage, long responseTime) {
        t.f(productType, "productType");
        t.f(billingDebugMessage, "billingDebugMessage");
        trackEvent(DiagnosticsEntryName.GOOGLE_QUERY_PURCHASE_HISTORY_REQUEST, o0.l(w.a(PRODUCT_TYPE_QUERIED_KEY, productType), w.a(BILLING_RESPONSE_CODE, Integer.valueOf(billingResponseCode)), w.a(BILLING_DEBUG_MESSAGE, billingDebugMessage), w.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(lg.a.w(responseTime)))));
    }

    /* JADX INFO: renamed from: trackGoogleQueryPurchasesRequest-zkXUZaI, reason: not valid java name */
    public final void m119trackGoogleQueryPurchasesRequestzkXUZaI(String productType, int billingResponseCode, String billingDebugMessage, long responseTime, List<String> foundProductIds) {
        t.f(productType, "productType");
        t.f(billingDebugMessage, "billingDebugMessage");
        t.f(foundProductIds, "foundProductIds");
        trackEvent(DiagnosticsEntryName.GOOGLE_QUERY_PURCHASES_REQUEST, o0.l(w.a(PRODUCT_TYPE_QUERIED_KEY, productType), w.a(BILLING_RESPONSE_CODE, Integer.valueOf(billingResponseCode)), w.a(BILLING_DEBUG_MESSAGE, billingDebugMessage), w.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(lg.a.w(responseTime))), w.a(FOUND_PRODUCT_IDS_KEY, foundProductIds)));
    }

    /* JADX INFO: renamed from: trackHttpRequestPerformed--XzGXFE, reason: not valid java name */
    public final void m120trackHttpRequestPerformedXzGXFE(String host, Endpoint endpoint, long responseTime, boolean wasSuccessful, int responseCode, Integer backendErrorCode, HTTPResult.Origin resultOrigin, VerificationResult verificationResult, boolean isRetry, ConnectionErrorReason connectionErrorReason) {
        t.f(host, "host");
        t.f(endpoint, "endpoint");
        t.f(verificationResult, "verificationResult");
        trackEvent(DiagnosticsEntryName.HTTP_REQUEST_PERFORMED, MapExtensionsKt.filterNotNullValues(o0.l(w.a(HOST_KEY, host), w.a(ENDPOINT_NAME_KEY, endpoint.getName()), w.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(lg.a.w(responseTime))), w.a(SUCCESSFUL_KEY, Boolean.valueOf(wasSuccessful)), w.a(RESPONSE_CODE_KEY, Integer.valueOf(responseCode)), w.a(BACKEND_ERROR_CODE_KEY, backendErrorCode), w.a(ETAG_HIT_KEY, Boolean.valueOf(resultOrigin == HTTPResult.Origin.CACHE)), w.a(VERIFICATION_RESULT_KEY, verificationResult.name()), w.a(IS_RETRY, Boolean.valueOf(isRetry)), w.a(CONNECTION_ERROR_REASON_KEY, connectionErrorReason != null ? connectionErrorReason.name() : null))));
    }

    public final void trackMaxDiagnosticsSyncRetriesReached() {
        trackEvent(DiagnosticsEntryName.MAX_DIAGNOSTICS_SYNC_RETRIES_REACHED, o0.h());
    }

    public final void trackMaxEventsStoredLimitReached(boolean useCurrentThread) {
        DiagnosticsEntry diagnosticsEntry = new DiagnosticsEntry(null, DiagnosticsEntryName.MAX_EVENTS_STORED_LIMIT_REACHED, this.commonProperties, this.appSessionID, null, null, 49, null);
        if (useCurrentThread) {
            trackEventInCurrentThread$purchases_defaultsBc8Release(diagnosticsEntry);
        } else {
            trackEvent(diagnosticsEntry);
        }
    }

    public final void trackProductDetailsNotSupported(int billingResponseCode, String billingDebugMessage) {
        t.f(billingDebugMessage, "billingDebugMessage");
        DiagnosticsEntryName diagnosticsEntryName = DiagnosticsEntryName.PRODUCT_DETAILS_NOT_SUPPORTED;
        String playStoreVersionName = this.appConfig.getPlayStoreVersionName();
        if (playStoreVersionName == null) {
            playStoreVersionName = "";
        }
        q qVarA = w.a("play_store_version", playStoreVersionName);
        String playServicesVersionName = this.appConfig.getPlayServicesVersionName();
        trackEvent(diagnosticsEntryName, o0.l(qVarA, w.a("play_services_version", playServicesVersionName != null ? playServicesVersionName : ""), w.a(BILLING_RESPONSE_CODE, Integer.valueOf(billingResponseCode)), w.a(BILLING_DEBUG_MESSAGE, billingDebugMessage)));
    }

    /* JADX INFO: renamed from: trackPurchaseResult-myKFqkg, reason: not valid java name */
    public final void m121trackPurchaseResultmyKFqkg(String productId, ProductType productType, Integer errorCode, String errorMessage, long responseTime, VerificationResult verificationResult) {
        t.f(productId, "productId");
        t.f(productType, "productType");
        trackEvent(DiagnosticsEntryName.PURCHASE_RESULT, MapExtensionsKt.filterNotNullValues(o0.l(w.a(PRODUCT_ID_KEY, productId), w.a(PRODUCT_TYPE_KEY, DiagnosticsTrackerKt.getDiagnosticsName(productType)), w.a(ERROR_CODE_KEY, errorCode), w.a(ERROR_MESSAGE_KEY, errorMessage), w.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(lg.a.w(responseTime))), w.a(VERIFICATION_RESULT_KEY, verificationResult != null ? verificationResult.name() : null))));
    }

    public final void trackPurchaseStarted(String productId, ProductType productType) {
        t.f(productId, "productId");
        t.f(productType, "productType");
        trackEvent(DiagnosticsEntryName.PURCHASE_STARTED, o0.l(w.a(PRODUCT_ID_KEY, productId), w.a(PRODUCT_TYPE_KEY, DiagnosticsTrackerKt.getDiagnosticsName(productType))));
    }

    /* JADX INFO: renamed from: trackRestorePurchasesResult-SxA4cEA, reason: not valid java name */
    public final void m122trackRestorePurchasesResultSxA4cEA(Integer errorCode, String errorMessage, long responseTime) {
        trackEvent(DiagnosticsEntryName.RESTORE_PURCHASES_RESULT, MapExtensionsKt.filterNotNullValues(o0.l(w.a(ERROR_CODE_KEY, errorCode), w.a(ERROR_MESSAGE_KEY, errorMessage), w.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(lg.a.w(responseTime))))));
    }

    public final void trackRestorePurchasesStarted() {
        trackEvent(DiagnosticsEntryName.RESTORE_PURCHASES_STARTED, o0.h());
    }

    /* JADX INFO: renamed from: trackSyncPurchasesResult-SxA4cEA, reason: not valid java name */
    public final void m123trackSyncPurchasesResultSxA4cEA(Integer errorCode, String errorMessage, long responseTime) {
        trackEvent(DiagnosticsEntryName.SYNC_PURCHASES_RESULT, MapExtensionsKt.filterNotNullValues(o0.l(w.a(ERROR_CODE_KEY, errorCode), w.a(ERROR_MESSAGE_KEY, errorMessage), w.a(RESPONSE_TIME_MILLIS_KEY, Long.valueOf(lg.a.w(responseTime))))));
    }

    public final void trackSyncPurchasesStarted() {
        trackEvent(DiagnosticsEntryName.SYNC_PURCHASES_STARTED, o0.h());
    }

    public final void trackEvent(DiagnosticsEntry diagnosticsEntry) {
        t.f(diagnosticsEntry, "diagnosticsEntry");
        checkAndClearDiagnosticsFileIfTooBig(new C05611(diagnosticsEntry));
    }

    public /* synthetic */ DiagnosticsTracker(AppConfig appConfig, DiagnosticsFileHelper diagnosticsFileHelper, DiagnosticsHelper diagnosticsHelper, Dispatcher dispatcher, UUID uuid, int i10, k kVar) {
        this(appConfig, diagnosticsFileHelper, diagnosticsHelper, dispatcher, (i10 & 16) != 0 ? EventsManager.INSTANCE.getAppSessionID$purchases_defaultsBc8Release() : uuid);
    }
}
