package com.revenuecat.purchases.amazon.handler;

import W2.E;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserData;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.amazon.AmazonStrings;
import com.revenuecat.purchases.amazon.PurchasingServiceProvider;
import com.revenuecat.purchases.amazon.listener.PurchaseResponseListener;
import com.revenuecat.purchases.amazon.purchasing.ProxyAmazonBillingActivity;
import com.revenuecat.purchases.amazon.purchasing.ProxyAmazonBillingActivityBroadcastReceiver;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.DurationExtensionsKt;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.models.StoreProduct;
import i3.k;
import i3.o;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import s3.C1779a;

/* JADX INFO: loaded from: classes.dex */
public final class PurchaseHandler implements PurchaseResponseListener {
    private final Context applicationContext;
    private final DateProvider dateProvider;
    private final DiagnosticsTracker diagnosticsTrackerIfEnabled;
    private final Map<String, ProductType> productTypes;
    private final Map<RequestId, PurchaseRequest> purchaseCallbacks;
    private final PurchasingServiceProvider purchasingServiceProvider;

    public static final class PurchaseRequest {
        private final k onError;
        private final o onSuccess;
        private final Date startTime;
        private final StoreProduct storeProduct;

        public PurchaseRequest(StoreProduct storeProduct, Date startTime, o onSuccess, k onError) {
            r.f(storeProduct, "storeProduct");
            r.f(startTime, "startTime");
            r.f(onSuccess, "onSuccess");
            r.f(onError, "onError");
            this.storeProduct = storeProduct;
            this.startTime = startTime;
            this.onSuccess = onSuccess;
            this.onError = onError;
        }

        public static /* synthetic */ PurchaseRequest copy$default(PurchaseRequest purchaseRequest, StoreProduct storeProduct, Date date, o oVar, k kVar, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                storeProduct = purchaseRequest.storeProduct;
            }
            if ((i4 & 2) != 0) {
                date = purchaseRequest.startTime;
            }
            if ((i4 & 4) != 0) {
                oVar = purchaseRequest.onSuccess;
            }
            if ((i4 & 8) != 0) {
                kVar = purchaseRequest.onError;
            }
            return purchaseRequest.copy(storeProduct, date, oVar, kVar);
        }

        public final StoreProduct component1() {
            return this.storeProduct;
        }

        public final Date component2() {
            return this.startTime;
        }

        public final o component3() {
            return this.onSuccess;
        }

        public final k component4() {
            return this.onError;
        }

        public final PurchaseRequest copy(StoreProduct storeProduct, Date startTime, o onSuccess, k onError) {
            r.f(storeProduct, "storeProduct");
            r.f(startTime, "startTime");
            r.f(onSuccess, "onSuccess");
            r.f(onError, "onError");
            return new PurchaseRequest(storeProduct, startTime, onSuccess, onError);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PurchaseRequest)) {
                return false;
            }
            PurchaseRequest purchaseRequest = (PurchaseRequest) obj;
            return r.b(this.storeProduct, purchaseRequest.storeProduct) && r.b(this.startTime, purchaseRequest.startTime) && r.b(this.onSuccess, purchaseRequest.onSuccess) && r.b(this.onError, purchaseRequest.onError);
        }

        public final k getOnError() {
            return this.onError;
        }

        public final o getOnSuccess() {
            return this.onSuccess;
        }

        public final Date getStartTime() {
            return this.startTime;
        }

        public final StoreProduct getStoreProduct() {
            return this.storeProduct;
        }

        public int hashCode() {
            return (((((this.storeProduct.hashCode() * 31) + this.startTime.hashCode()) * 31) + this.onSuccess.hashCode()) * 31) + this.onError.hashCode();
        }

        public String toString() {
            return "PurchaseRequest(storeProduct=" + this.storeProduct + ", startTime=" + this.startTime + ", onSuccess=" + this.onSuccess + ", onError=" + this.onError + ')';
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PurchaseResponse.RequestStatus.values().length];
            try {
                iArr[PurchaseResponse.RequestStatus.SUCCESSFUL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PurchaseResponse.RequestStatus.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PurchaseResponse.RequestStatus.INVALID_SKU.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PurchaseResponse.RequestStatus.ALREADY_PURCHASED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PurchaseResponse.RequestStatus.NOT_SUPPORTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PurchaseHandler(PurchasingServiceProvider purchasingServiceProvider, Context applicationContext, DiagnosticsTracker diagnosticsTracker, DateProvider dateProvider) {
        r.f(purchasingServiceProvider, "purchasingServiceProvider");
        r.f(applicationContext, "applicationContext");
        r.f(dateProvider, "dateProvider");
        this.purchasingServiceProvider = purchasingServiceProvider;
        this.applicationContext = applicationContext;
        this.diagnosticsTrackerIfEnabled = diagnosticsTracker;
        this.dateProvider = dateProvider;
        this.productTypes = new LinkedHashMap();
        this.purchaseCallbacks = new LinkedHashMap();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.revenuecat.purchases.amazon.handler.PurchaseHandler$createRequestIdResultReceiver$1] */
    private final AnonymousClass1 createRequestIdResultReceiver(Handler handler, final StoreProduct storeProduct, final o oVar, final k kVar) {
        return new ResultReceiver(handler) { // from class: com.revenuecat.purchases.amazon.handler.PurchaseHandler.createRequestIdResultReceiver.1
            @Override // android.os.ResultReceiver
            public void onReceiveResult(int i4, Bundle bundle) {
                Object obj;
                PurchaseHandler purchaseHandler = this;
                StoreProduct storeProduct2 = storeProduct;
                o oVar2 = oVar;
                k kVar2 = kVar;
                synchronized (purchaseHandler) {
                    if (bundle != null) {
                        try {
                            obj = bundle.get(ProxyAmazonBillingActivity.EXTRAS_REQUEST_ID);
                        } catch (Throwable th) {
                            throw th;
                        }
                    } else {
                        obj = null;
                    }
                    RequestId requestId = obj instanceof RequestId ? (RequestId) obj : null;
                    if (requestId != null) {
                        purchaseHandler.purchaseCallbacks.put(requestId, new PurchaseRequest(storeProduct2, purchaseHandler.dateProvider.getNow(), oVar2, kVar2));
                        purchaseHandler.productTypes.put(storeProduct2.getId(), storeProduct2.getType());
                    } else {
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "No RequestId coming from ProxyAmazonBillingActivity", null);
                    }
                    E e4 = E.f5463a;
                }
            }
        };
    }

    private final void startProxyActivity(Handler handler, Activity activity, StoreProduct storeProduct, o oVar, k kVar) {
        activity.startActivity(ProxyAmazonBillingActivity.Companion.newStartIntent(activity, createRequestIdResultReceiver(handler, storeProduct, oVar, kVar), storeProduct.getId(), this.purchasingServiceProvider));
    }

    @Override // com.amazon.device.iap.PurchasingListener, com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener, com.revenuecat.purchases.amazon.listener.UserDataResponseListener
    public void onPurchaseResponse(PurchaseResponse response) throws Exception {
        LogHandler currentLogHandler;
        String str;
        String str2;
        PurchaseRequest purchaseRequestRemove;
        PurchasesErrorCode code;
        r.f(response, "response");
        try {
            LogIntent logIntent = LogIntent.DEBUG;
            PurchaseHandler$onPurchaseResponse$$inlined$log$1 purchaseHandler$onPurchaseResponse$$inlined$log$1 = new PurchaseHandler$onPurchaseResponse$$inlined$log$1(logIntent, response);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        str = "[Purchases] - " + logLevel.name();
                        str2 = (String) purchaseHandler$onPurchaseResponse$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchaseHandler$onPurchaseResponse$$inlined$log$1.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchaseHandler$onPurchaseResponse$$inlined$log$1.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchaseHandler$onPurchaseResponse$$inlined$log$1.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        str = "[Purchases] - " + logLevel4.name();
                        str2 = (String) purchaseHandler$onPurchaseResponse$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchaseHandler$onPurchaseResponse$$inlined$log$1.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchaseHandler$onPurchaseResponse$$inlined$log$1.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        str = "[Purchases] - " + logLevel6.name();
                        str2 = (String) purchaseHandler$onPurchaseResponse$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        str = "[Purchases] - " + logLevel7.name();
                        str2 = (String) purchaseHandler$onPurchaseResponse$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchaseHandler$onPurchaseResponse$$inlined$log$1.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchaseHandler$onPurchaseResponse$$inlined$log$1.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchaseHandler$onPurchaseResponse$$inlined$log$1.invoke(), null);
                    break;
            }
            ProxyAmazonBillingActivityBroadcastReceiver.Companion companion = ProxyAmazonBillingActivityBroadcastReceiver.Companion;
            String packageName = this.applicationContext.getPackageName();
            r.e(packageName, "applicationContext.packageName");
            this.applicationContext.sendBroadcast(companion.newPurchaseFinishedIntent(packageName));
            RequestId requestId = response.getRequestId();
            synchronized (this) {
                purchaseRequestRemove = this.purchaseCallbacks.remove(requestId);
            }
            if (purchaseRequestRemove != null) {
                StoreProduct storeProductComponent1 = purchaseRequestRemove.component1();
                Date dateComponent2 = purchaseRequestRemove.component2();
                o oVarComponent3 = purchaseRequestRemove.component3();
                k kVarComponent4 = purchaseRequestRemove.component4();
                PurchaseResponse.RequestStatus requestStatus = response.getRequestStatus();
                int i4 = requestStatus == null ? -1 : WhenMappings.$EnumSwitchMapping$0[requestStatus.ordinal()];
                PurchasesError purchasesError = i4 != 1 ? i4 != 2 ? i4 != 3 ? i4 != 4 ? i4 != 5 ? new PurchasesError(PurchasesErrorCode.StoreProblemError, AmazonStrings.ERROR_PURCHASE_UNKNOWN) : new PurchasesError(PurchasesErrorCode.StoreProblemError, AmazonStrings.ERROR_PURCHASE_NOT_SUPPORTED) : new PurchasesError(PurchasesErrorCode.ProductAlreadyPurchasedError, AmazonStrings.ERROR_PURCHASE_ALREADY_OWNED) : new PurchasesError(PurchasesErrorCode.ProductNotAvailableForPurchaseError, AmazonStrings.ERROR_PURCHASE_INVALID_SKU) : new PurchasesError(PurchasesErrorCode.PurchaseCancelledError, AmazonStrings.ERROR_PURCHASE_FAILED) : null;
                DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
                if (diagnosticsTracker != null) {
                    diagnosticsTracker.m102trackAmazonPurchaseAttempt9VgGkz4(storeProductComponent1.getId(), response.getRequestStatus().name(), (purchasesError == null || (code = purchasesError.getCode()) == null) ? null : Integer.valueOf(code.getCode()), purchasesError != null ? purchasesError.getMessage() : null, DurationExtensionsKt.between(C1779a.f14679b, dateComponent2, this.dateProvider.getNow()));
                }
                if (purchasesError != null) {
                    kVarComponent4.invoke(purchasesError);
                    return;
                }
                Receipt receipt = response.getReceipt();
                r.e(receipt, "response.receipt");
                UserData userData = response.getUserData();
                r.e(userData, "response.userData");
                oVarComponent3.invoke(receipt, userData);
            }
        } catch (Exception e4) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Exception in onPurchaseResponse", e4);
            throw e4;
        }
    }

    @Override // com.revenuecat.purchases.amazon.listener.PurchaseResponseListener
    public void purchase(Handler mainHandler, Activity activity, String appUserID, StoreProduct storeProduct, o onSuccess, k onError) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        r.f(mainHandler, "mainHandler");
        r.f(activity, "activity");
        r.f(appUserID, "appUserID");
        r.f(storeProduct, "storeProduct");
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        LogIntent logIntent = LogIntent.PURCHASE;
        PurchaseHandler$purchase$$inlined$log$1 purchaseHandler$purchase$$inlined$log$1 = new PurchaseHandler$purchase$$inlined$log$1(logIntent, storeProduct);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    str2 = (String) purchaseHandler$purchase$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchaseHandler$purchase$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchaseHandler$purchase$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchaseHandler$purchase$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    str2 = (String) purchaseHandler$purchase$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchaseHandler$purchase$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchaseHandler$purchase$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    str2 = (String) purchaseHandler$purchase$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    str2 = (String) purchaseHandler$purchase$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchaseHandler$purchase$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchaseHandler$purchase$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchaseHandler$purchase$$inlined$log$1.invoke(), null);
                break;
        }
        startProxyActivity(mainHandler, activity, storeProduct, onSuccess, onError);
    }

    public /* synthetic */ PurchaseHandler(PurchasingServiceProvider purchasingServiceProvider, Context context, DiagnosticsTracker diagnosticsTracker, DateProvider dateProvider, int i4, AbstractC1585j abstractC1585j) {
        this(purchasingServiceProvider, context, diagnosticsTracker, (i4 & 8) != 0 ? new DefaultDateProvider() : dateProvider);
    }
}
