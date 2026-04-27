package com.revenuecat.purchases.common;

import F3.g;
import K3.n;
import W2.E;
import W2.o;
import W2.t;
import X2.AbstractC0768o;
import X2.AbstractC0769p;
import X2.AbstractC0770q;
import X2.K;
import X2.L;
import X2.x;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PostReceiptInitiationSource;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.common.events.EventsRequest;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.common.networking.PostReceiptResponseKt;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.common.networking.WebBillingProductsResponse;
import com.revenuecat.purchases.common.offlineentitlements.ProductEntitlementMapping;
import com.revenuecat.purchases.common.verification.SignatureVerificationMode;
import com.revenuecat.purchases.customercenter.CustomerCenterRoot;
import com.revenuecat.purchases.interfaces.RedeemWebPurchaseListener;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.paywalls.events.PaywallPostReceiptData;
import com.revenuecat.purchases.strings.NetworkStrings;
import com.revenuecat.purchases.utils.JsonElementExtensionsKt;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrenciesFactory;
import i3.k;
import i3.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.J;
import kotlin.jvm.internal.r;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class Backend {
    private static final String APP_USER_ID = "app_user_id";
    private static final String FETCH_TOKEN = "fetch_token";
    private static final String NEW_APP_USER_ID = "new_app_user_id";
    private volatile Map<List<String>, List<o>> aliasCallbacks;
    private final AppConfig appConfig;
    private final BackendHelper backendHelper;
    private volatile Map<BackgroundAwareCallbackCacheKey, List<o>> callbacks;
    private volatile Map<String, List<o>> customerCenterCallbacks;
    private volatile Map<List<String>, List<o>> diagnosticsCallbacks;
    private final Dispatcher dispatcher;
    private final Dispatcher eventsDispatcher;
    private final HTTPClient httpClient;
    private volatile Map<List<String>, List<o>> identifyCallbacks;
    private volatile Map<BackgroundAwareCallbackCacheKey, List<o>> offeringsCallbacks;
    private volatile Map<List<String>, List<o>> paywallEventsCallbacks;
    private volatile Map<List<String>, List<o>> postReceiptCallbacks;
    private volatile Map<String, List<o>> productEntitlementCallbacks;
    private volatile Map<String, List<k>> redeemWebPurchaseCallbacks;
    private volatile Map<BackgroundAwareCallbackCacheKey, List<o>> virtualCurrenciesCallbacks;
    private volatile Map<String, List<o>> webBillingProductsCallbacks;
    public static final Companion Companion = new Companion(null);
    private static final K3.a json = n.b(null, Backend$Companion$json$1.INSTANCE, 1, null);

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public static /* synthetic */ void getJson$purchases_defaultsRelease$annotations() {
        }

        public final K3.a getJson$purchases_defaultsRelease() {
            return Backend.json;
        }

        private Companion() {
        }
    }

    public Backend(AppConfig appConfig, Dispatcher dispatcher, Dispatcher eventsDispatcher, HTTPClient httpClient, BackendHelper backendHelper) {
        r.f(appConfig, "appConfig");
        r.f(dispatcher, "dispatcher");
        r.f(eventsDispatcher, "eventsDispatcher");
        r.f(httpClient, "httpClient");
        r.f(backendHelper, "backendHelper");
        this.appConfig = appConfig;
        this.dispatcher = dispatcher;
        this.eventsDispatcher = eventsDispatcher;
        this.httpClient = httpClient;
        this.backendHelper = backendHelper;
        this.callbacks = new LinkedHashMap();
        this.postReceiptCallbacks = new LinkedHashMap();
        this.offeringsCallbacks = new LinkedHashMap();
        this.identifyCallbacks = new LinkedHashMap();
        this.aliasCallbacks = new LinkedHashMap();
        this.diagnosticsCallbacks = new LinkedHashMap();
        this.paywallEventsCallbacks = new LinkedHashMap();
        this.productEntitlementCallbacks = new LinkedHashMap();
        this.customerCenterCallbacks = new LinkedHashMap();
        this.redeemWebPurchaseCallbacks = new LinkedHashMap();
        this.virtualCurrenciesCallbacks = new LinkedHashMap();
        this.webBillingProductsCallbacks = new LinkedHashMap();
    }

    private final synchronized <S, E> void addBackgroundAwareCallback(Map<BackgroundAwareCallbackCacheKey, List<o>> map, Dispatcher.AsyncCall asyncCall, Dispatcher dispatcher, BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey, o oVar, Delay delay) {
        BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2;
        try {
            BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKeyCopy$default = BackgroundAwareCallbackCacheKey.copy$default(backgroundAwareCallbackCacheKey, null, false, 1, null);
            boolean zContainsKey = map.containsKey(backgroundAwareCallbackCacheKeyCopy$default);
            if (backgroundAwareCallbackCacheKey.getAppInBackground() && zContainsKey) {
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    String str = "[Purchases] - " + logLevel.name();
                    String str2 = String.format(NetworkStrings.SAME_CALL_SCHEDULED_WITHOUT_JITTER, Arrays.copyOf(new Object[]{backgroundAwareCallbackCacheKeyCopy$default}, 1));
                    r.e(str2, "format(this, *args)");
                    currentLogHandler.d(str, str2);
                }
                backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKeyCopy$default;
            } else {
                backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
            }
            addCallback(map, asyncCall, dispatcher, backgroundAwareCallbackCacheKey2, oVar, delay);
            BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKeyCopy$default2 = BackgroundAwareCallbackCacheKey.copy$default(backgroundAwareCallbackCacheKey, null, true, 1, null);
            boolean zContainsKey2 = map.containsKey(backgroundAwareCallbackCacheKeyCopy$default);
            if (!backgroundAwareCallbackCacheKey.getAppInBackground() && zContainsKey2) {
                LogLevel logLevel2 = LogLevel.DEBUG;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    String str3 = "[Purchases] - " + logLevel2.name();
                    String str4 = String.format(NetworkStrings.SAME_CALL_SCHEDULED_WITH_JITTER, Arrays.copyOf(new Object[]{backgroundAwareCallbackCacheKeyCopy$default}, 1));
                    r.e(str4, "format(this, *args)");
                    currentLogHandler2.d(str3, str4);
                }
                List<o> listRemove = map.remove(backgroundAwareCallbackCacheKeyCopy$default2);
                if (listRemove != null) {
                    List<o> list = listRemove.isEmpty() ? null : listRemove;
                    if (list != null) {
                        if (map.containsKey(backgroundAwareCallbackCacheKey)) {
                            List<o> list2 = map.get(backgroundAwareCallbackCacheKey);
                            if (list2 != null) {
                                list2.addAll(list);
                            }
                        } else {
                            map.put(backgroundAwareCallbackCacheKey, list);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static /* synthetic */ void addBackgroundAwareCallback$default(Backend backend, Map map, Dispatcher.AsyncCall asyncCall, Dispatcher dispatcher, BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey, o oVar, Delay delay, int i4, Object obj) {
        if ((i4 & 16) != 0) {
            delay = Delay.NONE;
        }
        backend.addBackgroundAwareCallback(map, asyncCall, dispatcher, backgroundAwareCallbackCacheKey, oVar, delay);
    }

    private final <K, F> void addCallback(Map<K, List<F>> map, Dispatcher.AsyncCall asyncCall, Dispatcher dispatcher, K k4, F f4, Delay delay) {
        if (!map.containsKey(k4)) {
            map.put(k4, AbstractC0769p.m(f4));
            this.backendHelper.enqueue(asyncCall, dispatcher, delay);
            return;
        }
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            String str = "[Purchases] - " + logLevel.name();
            J j4 = J.f13414a;
            String str2 = String.format(NetworkStrings.SAME_CALL_ALREADY_IN_PROGRESS, Arrays.copyOf(new Object[]{k4}, 1));
            r.e(str2, "format(format, *args)");
            currentLogHandler.d(str, str2);
        }
        List<F> list = map.get(k4);
        r.c(list);
        list.add(f4);
    }

    public static /* synthetic */ void addCallback$default(Backend backend, Map map, Dispatcher.AsyncCall asyncCall, Dispatcher dispatcher, Object obj, Object obj2, Delay delay, int i4, Object obj3) {
        if ((i4 & 16) != 0) {
            delay = Delay.NONE;
        }
        backend.addCallback(map, asyncCall, dispatcher, obj, obj2, delay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PostReceiptErrorHandlingBehavior determinePostReceiptErrorHandlingBehavior(int i4, PurchasesError purchasesError) {
        return RCHTTPStatusCodes.INSTANCE.isServerError(i4) ? PostReceiptErrorHandlingBehavior.SHOULD_USE_OFFLINE_ENTITLEMENTS_AND_NOT_CONSUME : purchasesError.getCode() == PurchasesErrorCode.UnsupportedError ? PostReceiptErrorHandlingBehavior.SHOULD_NOT_CONSUME : PostReceiptErrorHandlingBehavior.SHOULD_BE_MARKED_SYNCED;
    }

    public final void aliasUsers(final String oldAppUserID, final String newAppUserID, Function0 onSuccessHandler, k onErrorHandler) {
        r.f(oldAppUserID, "oldAppUserID");
        r.f(newAppUserID, "newAppUserID");
        r.f(onSuccessHandler, "onSuccessHandler");
        r.f(onErrorHandler, "onErrorHandler");
        final List listL = AbstractC0769p.l(oldAppUserID, newAppUserID);
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$aliasUsers$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.httpClient, this.appConfig.getBaseURL(), new Endpoint.AliasUsers(oldAppUserID), L.g(t.a("app_user_id", oldAppUserID), t.a("new_app_user_id", newAppUserID)), null, this.backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), false, this.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<o> listRemove;
                r.f(result, "result");
                if (!BackendHelperKt.isSuccessful(result)) {
                    PurchasesError purchasesError = ErrorsKt.toPurchasesError(result);
                    LogUtilsKt.errorLog(purchasesError);
                    onError(purchasesError);
                    return;
                }
                Backend backend = this;
                List<String> list = listL;
                synchronized (backend) {
                    listRemove = backend.getAliasCallbacks().remove(list);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((Function0) ((o) it.next()).a()).invoke();
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<o> listRemove;
                r.f(error, "error");
                Backend backend = this;
                List<String> list = listL;
                synchronized (backend) {
                    listRemove = backend.getAliasCallbacks().remove(list);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((k) ((o) it.next()).b()).invoke(error);
                    }
                }
            }
        };
        synchronized (this) {
            try {
                try {
                    addCallback$default(this, this.aliasCallbacks, asyncCall, this.dispatcher, listL, t.a(onSuccessHandler, onErrorHandler), null, 16, null);
                    E e4 = E.f5463a;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final void clearCaches() {
        this.httpClient.clearCaches();
    }

    public final void close() {
        this.dispatcher.close();
    }

    public final synchronized Map<List<String>, List<o>> getAliasCallbacks() {
        return this.aliasCallbacks;
    }

    public final synchronized Map<BackgroundAwareCallbackCacheKey, List<o>> getCallbacks() {
        return this.callbacks;
    }

    public final synchronized Map<String, List<o>> getCustomerCenterCallbacks() {
        return this.customerCenterCallbacks;
    }

    public final void getCustomerCenterConfig(String appUserID, k onSuccessHandler, k onErrorHandler) {
        r.f(appUserID, "appUserID");
        r.f(onSuccessHandler, "onSuccessHandler");
        r.f(onErrorHandler, "onErrorHandler");
        final Endpoint.GetCustomerCenterConfig getCustomerCenterConfig = new Endpoint.GetCustomerCenterConfig(appUserID);
        final String path = getCustomerCenterConfig.getPath();
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getCustomerCenterConfig$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), getCustomerCenterConfig, null, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<o> listRemove;
                r.f(result, "result");
                Backend backend = this.this$0;
                String str = path;
                synchronized (backend) {
                    listRemove = backend.getCustomerCenterCallbacks().remove(str);
                }
                if (listRemove != null) {
                    for (o oVar : listRemove) {
                        k kVar = (k) oVar.a();
                        k kVar2 = (k) oVar.b();
                        if (BackendHelperKt.isSuccessful(result)) {
                            try {
                                K3.a json$purchases_defaultsRelease = Backend.Companion.getJson$purchases_defaultsRelease();
                                String payload = result.getPayload();
                                json$purchases_defaultsRelease.a();
                                kVar.invoke(((CustomerCenterRoot) json$purchases_defaultsRelease.d(CustomerCenterRoot.Companion.serializer(), payload)).getCustomerCenter());
                            } catch (g e4) {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e4);
                                LogUtilsKt.errorLog(purchasesError);
                                kVar2.invoke(purchasesError);
                            } catch (IllegalArgumentException e5) {
                                PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e5);
                                LogUtilsKt.errorLog(purchasesError2);
                                kVar2.invoke(purchasesError2);
                            }
                        } else {
                            PurchasesError purchasesError3 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError3);
                            kVar2.invoke(purchasesError3);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<o> listRemove;
                r.f(error, "error");
                Backend backend = this.this$0;
                String str = path;
                synchronized (backend) {
                    listRemove = backend.getCustomerCenterCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((k) ((o) it.next()).b()).invoke(error);
                    }
                }
            }
        };
        synchronized (this) {
            try {
                try {
                    addCallback(this.customerCenterCallbacks, asyncCall, this.dispatcher, path, t.a(onSuccessHandler, onErrorHandler), Delay.NONE);
                    E e4 = E.f5463a;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final void getCustomerInfo(String appUserID, boolean z4, k onSuccess, i3.o onError) {
        Throwable th;
        BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey;
        Delay delay;
        Throwable th2;
        r.f(appUserID, "appUserID");
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        final Endpoint.GetCustomerInfo getCustomerInfo = new Endpoint.GetCustomerInfo(appUserID);
        String path = getCustomerInfo.getPath();
        synchronized (this) {
            try {
                if (this.postReceiptCallbacks.isEmpty()) {
                    try {
                        backgroundAwareCallbackCacheKey = new BackgroundAwareCallbackCacheKey(AbstractC0768o.b(path), z4);
                    } catch (Throwable th3) {
                        th = th3;
                        throw th;
                    }
                } else {
                    backgroundAwareCallbackCacheKey = new BackgroundAwareCallbackCacheKey(x.V(AbstractC0768o.b(path), String.valueOf(this.callbacks.size())), z4);
                }
                final BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
                Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getCustomerInfo$call$1
                    @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
                    public HTTPResult call() {
                        return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), getCustomerInfo, null, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
                    }

                    @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
                    public void onCompletion(HTTPResult result) {
                        List<o> listRemove;
                        r.f(result, "result");
                        Backend backend = this.this$0;
                        BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey3 = backgroundAwareCallbackCacheKey2;
                        synchronized (backend) {
                            listRemove = backend.getCallbacks().remove(backgroundAwareCallbackCacheKey3);
                        }
                        if (listRemove != null) {
                            for (o oVar : listRemove) {
                                k kVar = (k) oVar.a();
                                i3.o oVar2 = (i3.o) oVar.b();
                                try {
                                    if (BackendHelperKt.isSuccessful(result)) {
                                        kVar.invoke(CustomerInfoFactory.INSTANCE.buildCustomerInfo(result));
                                    } else {
                                        PurchasesError purchasesError = ErrorsKt.toPurchasesError(result);
                                        LogUtilsKt.errorLog(purchasesError);
                                        oVar2.invoke(purchasesError, Boolean.valueOf(RCHTTPStatusCodes.INSTANCE.isServerError(result.getResponseCode())));
                                    }
                                } catch (JSONException e4) {
                                    PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e4);
                                    LogUtilsKt.errorLog(purchasesError2);
                                    oVar2.invoke(purchasesError2, Boolean.FALSE);
                                }
                            }
                        }
                    }

                    @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
                    public void onError(PurchasesError error) {
                        List<o> listRemove;
                        r.f(error, "error");
                        Backend backend = this.this$0;
                        BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey3 = backgroundAwareCallbackCacheKey2;
                        synchronized (backend) {
                            listRemove = backend.getCallbacks().remove(backgroundAwareCallbackCacheKey3);
                        }
                        if (listRemove != null) {
                            Iterator<T> it = listRemove.iterator();
                            while (it.hasNext()) {
                                ((i3.o) ((o) it.next()).b()).invoke(error, Boolean.FALSE);
                            }
                        }
                    }
                };
                synchronized (this) {
                    if (z4) {
                        try {
                            delay = Delay.DEFAULT;
                        } catch (Throwable th4) {
                            th2 = th4;
                            throw th2;
                        }
                    } else {
                        try {
                            delay = Delay.NONE;
                        } catch (Throwable th5) {
                            th = th5;
                            th2 = th;
                            throw th2;
                        }
                    }
                    try {
                        addBackgroundAwareCallback(this.callbacks, asyncCall, this.dispatcher, backgroundAwareCallbackCacheKey2, t.a(onSuccess, onError), delay);
                        E e4 = E.f5463a;
                    } catch (Throwable th6) {
                        th = th6;
                        th2 = th;
                        throw th2;
                    }
                }
            } catch (Throwable th7) {
                th = th7;
            }
        }
    }

    public final synchronized Map<List<String>, List<o>> getDiagnosticsCallbacks() {
        return this.diagnosticsCallbacks;
    }

    public final synchronized Map<List<String>, List<o>> getIdentifyCallbacks() {
        return this.identifyCallbacks;
    }

    public final void getOfferings(String appUserID, boolean z4, k onSuccess, i3.o onError) {
        Throwable th;
        Delay delay;
        r.f(appUserID, "appUserID");
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        final Endpoint.GetOfferings getOfferings = new Endpoint.GetOfferings(appUserID);
        final BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey = new BackgroundAwareCallbackCacheKey(AbstractC0768o.b(getOfferings.getPath()), z4);
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getOfferings$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), getOfferings, null, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<o> listRemove;
                r.f(result, "result");
                Backend backend = this.this$0;
                BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
                synchronized (backend) {
                    listRemove = backend.getOfferingsCallbacks().remove(backgroundAwareCallbackCacheKey2);
                }
                if (listRemove != null) {
                    for (o oVar : listRemove) {
                        k kVar = (k) oVar.a();
                        i3.o oVar2 = (i3.o) oVar.b();
                        if (BackendHelperKt.isSuccessful(result)) {
                            try {
                                kVar.invoke(result.getBody());
                            } catch (JSONException e4) {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e4);
                                LogUtilsKt.errorLog(purchasesError);
                                oVar2.invoke(purchasesError, Boolean.FALSE);
                            }
                        } else {
                            PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError2);
                            oVar2.invoke(purchasesError2, Boolean.valueOf(RCHTTPStatusCodes.INSTANCE.isServerError(result.getResponseCode())));
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<o> listRemove;
                r.f(error, "error");
                Backend backend = this.this$0;
                BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
                synchronized (backend) {
                    listRemove = backend.getOfferingsCallbacks().remove(backgroundAwareCallbackCacheKey2);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((i3.o) ((o) it.next()).b()).invoke(error, Boolean.FALSE);
                    }
                }
            }
        };
        synchronized (this) {
            if (z4) {
                try {
                    delay = Delay.DEFAULT;
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } else {
                try {
                    delay = Delay.NONE;
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    throw th;
                }
            }
            try {
                addBackgroundAwareCallback(this.offeringsCallbacks, asyncCall, this.dispatcher, backgroundAwareCallbackCacheKey, t.a(onSuccess, onError), delay);
                E e4 = E.f5463a;
            } catch (Throwable th4) {
                th = th4;
                th = th;
                throw th;
            }
        }
    }

    public final synchronized Map<BackgroundAwareCallbackCacheKey, List<o>> getOfferingsCallbacks() {
        return this.offeringsCallbacks;
    }

    public final synchronized Map<List<String>, List<o>> getPaywallEventsCallbacks() {
        return this.paywallEventsCallbacks;
    }

    public final synchronized Map<List<String>, List<o>> getPostReceiptCallbacks() {
        return this.postReceiptCallbacks;
    }

    public final synchronized Map<String, List<o>> getProductEntitlementCallbacks() {
        return this.productEntitlementCallbacks;
    }

    public final void getProductEntitlementMapping(k onSuccessHandler, k onErrorHandler) {
        r.f(onSuccessHandler, "onSuccessHandler");
        r.f(onErrorHandler, "onErrorHandler");
        final Endpoint.GetProductEntitlementMapping getProductEntitlementMapping = Endpoint.GetProductEntitlementMapping.INSTANCE;
        final String path = getProductEntitlementMapping.getPath();
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getProductEntitlementMapping$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), getProductEntitlementMapping, null, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<o> listRemove;
                r.f(result, "result");
                Backend backend = this.this$0;
                String str = path;
                synchronized (backend) {
                    listRemove = backend.getProductEntitlementCallbacks().remove(str);
                }
                if (listRemove != null) {
                    for (o oVar : listRemove) {
                        k kVar = (k) oVar.a();
                        k kVar2 = (k) oVar.b();
                        if (BackendHelperKt.isSuccessful(result)) {
                            try {
                                kVar.invoke(ProductEntitlementMapping.Companion.fromJson(result.getBody()));
                            } catch (JSONException e4) {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e4);
                                LogUtilsKt.errorLog(purchasesError);
                                kVar2.invoke(purchasesError);
                            }
                        } else {
                            PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError2);
                            kVar2.invoke(purchasesError2);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<o> listRemove;
                r.f(error, "error");
                Backend backend = this.this$0;
                String str = path;
                synchronized (backend) {
                    listRemove = backend.getProductEntitlementCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((k) ((o) it.next()).b()).invoke(error);
                    }
                }
            }
        };
        synchronized (this) {
            try {
                try {
                    addCallback(this.productEntitlementCallbacks, asyncCall, this.dispatcher, path, t.a(onSuccessHandler, onErrorHandler), Delay.LONG);
                    E e4 = E.f5463a;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final synchronized Map<String, List<k>> getRedeemWebPurchaseCallbacks() {
        return this.redeemWebPurchaseCallbacks;
    }

    public final SignatureVerificationMode getVerificationMode() {
        return this.httpClient.getSigningManager().getSignatureVerificationMode();
    }

    public final void getVirtualCurrencies(String appUserID, boolean z4, k onSuccess, k onError) throws Throwable {
        Throwable th;
        Delay delay;
        r.f(appUserID, "appUserID");
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        final Endpoint.GetVirtualCurrencies getVirtualCurrencies = new Endpoint.GetVirtualCurrencies(appUserID);
        final BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey = new BackgroundAwareCallbackCacheKey(AbstractC0768o.b(getVirtualCurrencies.getPath()), z4);
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getVirtualCurrencies$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), getVirtualCurrencies, null, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<o> listRemove;
                r.f(result, "result");
                Backend backend = this.this$0;
                BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
                synchronized (backend) {
                    listRemove = backend.getVirtualCurrenciesCallbacks().remove(backgroundAwareCallbackCacheKey2);
                }
                if (listRemove != null) {
                    for (o oVar : listRemove) {
                        k kVar = (k) oVar.a();
                        k kVar2 = (k) oVar.b();
                        if (BackendHelperKt.isSuccessful(result)) {
                            try {
                                kVar.invoke(VirtualCurrenciesFactory.INSTANCE.buildVirtualCurrencies(result));
                            } catch (g e4) {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e4);
                                LogUtilsKt.errorLog(purchasesError);
                                kVar2.invoke(purchasesError);
                            } catch (IllegalArgumentException e5) {
                                PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e5);
                                LogUtilsKt.errorLog(purchasesError2);
                                kVar2.invoke(purchasesError2);
                            } catch (JSONException e6) {
                                PurchasesError purchasesError3 = ErrorsKt.toPurchasesError(e6);
                                LogUtilsKt.errorLog(purchasesError3);
                                kVar2.invoke(purchasesError3);
                            }
                        } else {
                            PurchasesError purchasesError4 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError4);
                            kVar2.invoke(purchasesError4);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<o> listRemove;
                r.f(error, "error");
                Backend backend = this.this$0;
                BackgroundAwareCallbackCacheKey backgroundAwareCallbackCacheKey2 = backgroundAwareCallbackCacheKey;
                synchronized (backend) {
                    listRemove = backend.getVirtualCurrenciesCallbacks().remove(backgroundAwareCallbackCacheKey2);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((k) ((o) it.next()).b()).invoke(error);
                    }
                }
            }
        };
        synchronized (this) {
            if (z4) {
                try {
                    delay = Delay.DEFAULT;
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } else {
                try {
                    delay = Delay.NONE;
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    throw th;
                }
            }
            try {
                addBackgroundAwareCallback(this.virtualCurrenciesCallbacks, asyncCall, this.dispatcher, backgroundAwareCallbackCacheKey, t.a(onSuccess, onError), delay);
                E e4 = E.f5463a;
            } catch (Throwable th4) {
                th = th4;
                th = th;
                throw th;
            }
        }
    }

    public final synchronized Map<BackgroundAwareCallbackCacheKey, List<o>> getVirtualCurrenciesCallbacks() {
        return this.virtualCurrenciesCallbacks;
    }

    public final void getWebBillingProducts(String appUserID, Set<String> productIds, k onSuccess, k onError) throws Throwable {
        r.f(appUserID, "appUserID");
        r.f(productIds, "productIds");
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        final Endpoint.WebBillingGetProducts webBillingGetProducts = new Endpoint.WebBillingGetProducts(appUserID, productIds);
        final String path = webBillingGetProducts.getPath();
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$getWebBillingProducts$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), webBillingGetProducts, null, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<o> listRemove;
                r.f(result, "result");
                Backend backend = this.this$0;
                String str = path;
                synchronized (backend) {
                    listRemove = backend.getWebBillingProductsCallbacks().remove(str);
                }
                if (listRemove != null) {
                    for (o oVar : listRemove) {
                        k kVar = (k) oVar.a();
                        k kVar2 = (k) oVar.b();
                        if (BackendHelperKt.isSuccessful(result)) {
                            try {
                                K3.a json$purchases_defaultsRelease = Backend.Companion.getJson$purchases_defaultsRelease();
                                String payload = result.getPayload();
                                json$purchases_defaultsRelease.a();
                                kVar.invoke((WebBillingProductsResponse) json$purchases_defaultsRelease.d(WebBillingProductsResponse.Companion.serializer(), payload));
                            } catch (g e4) {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(e4);
                                LogUtilsKt.errorLog(purchasesError);
                                kVar2.invoke(purchasesError);
                            } catch (IllegalArgumentException e5) {
                                PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e5);
                                LogUtilsKt.errorLog(purchasesError2);
                                kVar2.invoke(purchasesError2);
                            }
                        } else {
                            PurchasesError purchasesError3 = ErrorsKt.toPurchasesError(result);
                            LogUtilsKt.errorLog(purchasesError3);
                            kVar2.invoke(purchasesError3);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<o> listRemove;
                r.f(error, "error");
                Backend backend = this.this$0;
                String str = path;
                synchronized (backend) {
                    listRemove = backend.getWebBillingProductsCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((k) ((o) it.next()).b()).invoke(error);
                    }
                }
            }
        };
        synchronized (this) {
            try {
                try {
                    addCallback(this.webBillingProductsCallbacks, asyncCall, this.dispatcher, path, t.a(onSuccess, onError), Delay.NONE);
                    E e4 = E.f5463a;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final synchronized Map<String, List<o>> getWebBillingProductsCallbacks() {
        return this.webBillingProductsCallbacks;
    }

    public final void logIn(final String appUserID, final String newAppUserID, i3.o onSuccessHandler, k onErrorHandler) {
        r.f(appUserID, "appUserID");
        r.f(newAppUserID, "newAppUserID");
        r.f(onSuccessHandler, "onSuccessHandler");
        r.f(onErrorHandler, "onErrorHandler");
        final List listL = AbstractC0769p.l(appUserID, newAppUserID);
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$logIn$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.httpClient, this.appConfig.getBaseURL(), Endpoint.LogIn.INSTANCE, L.g(t.a("app_user_id", appUserID), t.a("new_app_user_id", newAppUserID)), AbstractC0769p.j(t.a("app_user_id", appUserID), t.a("new_app_user_id", newAppUserID)), this.backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), false, this.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<o> listRemove;
                r.f(result, "result");
                if (!BackendHelperKt.isSuccessful(result)) {
                    PurchasesError purchasesError = ErrorsKt.toPurchasesError(result);
                    LogUtilsKt.errorLog(purchasesError);
                    onError(purchasesError);
                    return;
                }
                Backend backend = this;
                List<String> list = listL;
                synchronized (backend) {
                    listRemove = backend.getIdentifyCallbacks().remove(list);
                }
                if (listRemove != null) {
                    for (o oVar : listRemove) {
                        i3.o oVar2 = (i3.o) oVar.a();
                        k kVar = (k) oVar.b();
                        boolean z4 = result.getResponseCode() == 201;
                        if (result.getBody().length() > 0) {
                            oVar2.invoke(CustomerInfoFactory.INSTANCE.buildCustomerInfo(result), Boolean.valueOf(z4));
                        } else {
                            PurchasesError purchasesError2 = new PurchasesError(PurchasesErrorCode.UnknownError, null, 2, null);
                            LogUtilsKt.errorLog(purchasesError2);
                            kVar.invoke(purchasesError2);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<o> listRemove;
                r.f(error, "error");
                Backend backend = this;
                List<String> list = listL;
                synchronized (backend) {
                    listRemove = backend.getIdentifyCallbacks().remove(list);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((k) ((o) it.next()).b()).invoke(error);
                    }
                }
            }
        };
        synchronized (this) {
            try {
                try {
                    addCallback$default(this, this.identifyCallbacks, asyncCall, this.dispatcher, listL, t.a(onSuccessHandler, onErrorHandler), null, 16, null);
                    E e4 = E.f5463a;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final void postDiagnostics(List<? extends JSONObject> diagnosticsList, k onSuccessHandler, i3.o onErrorHandler) throws Throwable {
        r.f(diagnosticsList, "diagnosticsList");
        r.f(onSuccessHandler, "onSuccessHandler");
        r.f(onErrorHandler, "onErrorHandler");
        final ArrayList arrayList = new ArrayList(AbstractC0770q.q(diagnosticsList, 10));
        Iterator<T> it = diagnosticsList.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((JSONObject) it.next()).hashCode()));
        }
        final Map mapC = K.c(t.a("entries", new JSONArray((Collection) diagnosticsList)));
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$postDiagnostics$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, AppConfig.Companion.getDiagnosticsURL(), Endpoint.PostDiagnostics.INSTANCE, mapC, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<o> listRemove;
                r.f(result, "result");
                Backend backend = this.this$0;
                List<String> list = arrayList;
                synchronized (backend) {
                    listRemove = backend.getDiagnosticsCallbacks().remove(list);
                }
                if (listRemove != null) {
                    for (o oVar : listRemove) {
                        k kVar = (k) oVar.a();
                        i3.o oVar2 = (i3.o) oVar.b();
                        if (BackendHelperKt.isSuccessful(result)) {
                            kVar.invoke(result.getBody());
                        } else {
                            PurchasesError purchasesError = ErrorsKt.toPurchasesError(result);
                            oVar2.invoke(purchasesError, Boolean.valueOf(RCHTTPStatusCodes.INSTANCE.isServerError(result.getResponseCode()) || purchasesError.getCode() == PurchasesErrorCode.NetworkError));
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<o> listRemove;
                r.f(error, "error");
                Backend backend = this.this$0;
                List<String> list = arrayList;
                synchronized (backend) {
                    listRemove = backend.getDiagnosticsCallbacks().remove(list);
                }
                if (listRemove != null) {
                    Iterator<T> it2 = listRemove.iterator();
                    while (it2.hasNext()) {
                        ((i3.o) ((o) it2.next()).b()).invoke(error, Boolean.valueOf(error.getCode() == PurchasesErrorCode.NetworkError));
                    }
                }
            }
        };
        synchronized (this) {
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                addCallback(this.diagnosticsCallbacks, asyncCall, this.eventsDispatcher, arrayList, t.a(onSuccessHandler, onErrorHandler), Delay.LONG);
                E e4 = E.f5463a;
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public final void postEvents(final EventsRequest paywallEventRequest, Function0 onSuccessHandler, i3.o onErrorHandler) {
        r.f(paywallEventRequest, "paywallEventRequest");
        r.f(onSuccessHandler, "onSuccessHandler");
        r.f(onErrorHandler, "onErrorHandler");
        K3.a defaultJson = JsonProvider.Companion.getDefaultJson();
        defaultJson.a();
        final Map<String, Object> mapAsMap = JsonElementExtensionsKt.asMap(defaultJson.e(EventsRequest.Companion.serializer(), paywallEventRequest));
        if (mapAsMap == null) {
            PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.UnknownError, "Error encoding paywall event request");
            LogUtilsKt.errorLog(purchasesError);
            onErrorHandler.invoke(purchasesError, Boolean.TRUE);
            return;
        }
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$postEvents$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, AppConfig.Companion.getPaywallEventsURL(), Endpoint.PostPaywallEvents.INSTANCE, mapAsMap, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<o> listRemove;
                r.f(result, "result");
                Backend backend = this.this$0;
                EventsRequest eventsRequest = paywallEventRequest;
                synchronized (backend) {
                    listRemove = backend.getPaywallEventsCallbacks().remove(eventsRequest.getCacheKey());
                }
                if (listRemove != null) {
                    for (o oVar : listRemove) {
                        Function0 function0 = (Function0) oVar.a();
                        i3.o oVar2 = (i3.o) oVar.b();
                        if (BackendHelperKt.isSuccessful(result)) {
                            function0.invoke();
                        } else {
                            oVar2.invoke(ErrorsKt.toPurchasesError(result), Boolean.valueOf(RCHTTPStatusCodes.INSTANCE.isSynced(result.getResponseCode())));
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<o> listRemove;
                r.f(error, "error");
                Backend backend = this.this$0;
                EventsRequest eventsRequest = paywallEventRequest;
                synchronized (backend) {
                    listRemove = backend.getPaywallEventsCallbacks().remove(eventsRequest.getCacheKey());
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((i3.o) ((o) it.next()).b()).invoke(error, Boolean.FALSE);
                    }
                }
            }
        };
        synchronized (this) {
            try {
                try {
                    addCallback(this.paywallEventsCallbacks, asyncCall, this.eventsDispatcher, paywallEventRequest.getCacheKey(), t.a(onSuccessHandler, onErrorHandler), Delay.LONG);
                    E e4 = E.f5463a;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final void postReceiptData(String purchaseToken, String appUserID, boolean z4, boolean z5, Map<String, ? extends Map<String, ? extends Object>> map, ReceiptInfo receiptInfo, String str, String str2, PostReceiptInitiationSource initiationSource, PaywallPostReceiptData paywallPostReceiptData, k onSuccess, p onError) {
        ArrayList arrayList;
        ArrayList arrayList2;
        Price price;
        LegacyProrationMode asLegacyProrationMode;
        PresentedOfferingContext.TargetingContext targetingContext;
        r.f(purchaseToken, "purchaseToken");
        r.f(appUserID, "appUserID");
        Map<String, ? extends Map<String, ? extends Object>> subscriberAttributes = map;
        r.f(subscriberAttributes, "subscriberAttributes");
        r.f(receiptInfo, "receiptInfo");
        r.f(initiationSource, "initiationSource");
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        final List listL = AbstractC0769p.l(purchaseToken, appUserID, String.valueOf(z4), String.valueOf(z5), subscriberAttributes.toString(), receiptInfo.toString(), str);
        o oVarA = t.a(FETCH_TOKEN, purchaseToken);
        o oVarA2 = t.a(DiagnosticsTracker.PRODUCT_IDS_KEY, receiptInfo.getProductIDs());
        List<PlatformProductId> platformProductIds$purchases_defaultsRelease = receiptInfo.getPlatformProductIds$purchases_defaultsRelease();
        if (platformProductIds$purchases_defaultsRelease != null) {
            arrayList = new ArrayList(AbstractC0770q.q(platformProductIds$purchases_defaultsRelease, 10));
            Iterator<T> it = platformProductIds$purchases_defaultsRelease.iterator();
            while (it.hasNext()) {
                arrayList.add(((PlatformProductId) it.next()).getAsMap());
            }
        } else {
            arrayList = null;
        }
        o oVarA3 = t.a("platform_product_ids", arrayList);
        o oVarA4 = t.a(APP_USER_ID, appUserID);
        o oVarA5 = t.a("is_restore", Boolean.valueOf(z4));
        PresentedOfferingContext presentedOfferingContext = receiptInfo.getPresentedOfferingContext();
        o oVarA6 = t.a("presented_offering_identifier", presentedOfferingContext != null ? presentedOfferingContext.getOfferingIdentifier() : null);
        PresentedOfferingContext presentedOfferingContext2 = receiptInfo.getPresentedOfferingContext();
        o oVarA7 = t.a("presented_placement_identifier", presentedOfferingContext2 != null ? presentedOfferingContext2.getPlacementIdentifier() : null);
        PresentedOfferingContext presentedOfferingContext3 = receiptInfo.getPresentedOfferingContext();
        o oVarA8 = t.a("applied_targeting_rule", (presentedOfferingContext3 == null || (targetingContext = presentedOfferingContext3.getTargetingContext()) == null) ? null : L.g(t.a("revision", Integer.valueOf(targetingContext.getRevision())), t.a("rule_id", targetingContext.getRuleId())));
        o oVarA9 = t.a("observer_mode", Boolean.valueOf(!z5));
        o oVarA10 = t.a("price", receiptInfo.getPrice());
        o oVarA11 = t.a("currency", receiptInfo.getCurrency());
        if (subscriberAttributes.isEmpty() || this.appConfig.getCustomEntitlementComputation()) {
            subscriberAttributes = null;
        }
        o oVarA12 = t.a("attributes", subscriberAttributes);
        o oVarA13 = t.a("normal_duration", receiptInfo.getDuration());
        o oVarA14 = t.a("store_user_id", str);
        List<PricingPhase> pricingPhases = receiptInfo.getPricingPhases();
        if (pricingPhases != null) {
            arrayList2 = new ArrayList(AbstractC0770q.q(pricingPhases, 10));
            Iterator<T> it2 = pricingPhases.iterator();
            while (it2.hasNext()) {
                arrayList2.add(BackendKt.toMap((PricingPhase) it2.next()));
            }
        } else {
            arrayList2 = null;
        }
        o oVarA15 = t.a("pricing_phases", arrayList2);
        ReplacementMode replacementMode = receiptInfo.getReplacementMode();
        GoogleReplacementMode googleReplacementMode = replacementMode instanceof GoogleReplacementMode ? (GoogleReplacementMode) replacementMode : null;
        final Map mapFilterNotNullValues = MapExtensionsKt.filterNotNullValues(L.g(oVarA, oVarA2, oVarA3, oVarA4, oVarA5, oVarA6, oVarA7, oVarA8, oVarA9, oVarA10, oVarA11, oVarA12, oVarA13, oVarA14, oVarA15, t.a("proration_mode", (googleReplacementMode == null || (asLegacyProrationMode = BackendKt.getAsLegacyProrationMode(googleReplacementMode)) == null) ? null : asLegacyProrationMode.name()), t.a("initiation_source", initiationSource.getPostReceiptFieldValue()), t.a("paywall", paywallPostReceiptData != null ? paywallPostReceiptData.toMap() : null)));
        final List listJ = AbstractC0769p.j(t.a(APP_USER_ID, appUserID), t.a(FETCH_TOKEN, purchaseToken));
        StoreProduct storeProduct = receiptInfo.getStoreProduct();
        final Map mapFilterNotNullValues2 = MapExtensionsKt.filterNotNullValues(L.g(t.a("price_string", (storeProduct == null || (price = storeProduct.getPrice()) == null) ? null : price.getFormatted()), t.a(com.amazon.a.a.o.b.f8765m, str2)));
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$postReceiptData$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), Endpoint.PostReceipt.INSTANCE, mapFilterNotNullValues, listJ, L.k(this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), mapFilterNotNullValues2), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<o> listRemove;
                r.f(result, "result");
                Backend backend = this.this$0;
                List<String> list = listL;
                synchronized (backend) {
                    listRemove = backend.getPostReceiptCallbacks().remove(list);
                }
                if (listRemove != null) {
                    Backend backend2 = this.this$0;
                    for (o oVar : listRemove) {
                        k kVar = (k) oVar.a();
                        p pVar = (p) oVar.b();
                        try {
                            if (BackendHelperKt.isSuccessful(result)) {
                                kVar.invoke(PostReceiptResponseKt.buildPostReceiptResponse(result));
                            } else {
                                PurchasesError purchasesError = ErrorsKt.toPurchasesError(result);
                                LogUtilsKt.errorLog(purchasesError);
                                pVar.invoke(purchasesError, backend2.determinePostReceiptErrorHandlingBehavior(result.getResponseCode(), purchasesError), result.getBody());
                            }
                        } catch (JSONException e4) {
                            PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(e4);
                            LogUtilsKt.errorLog(purchasesError2);
                            pVar.invoke(purchasesError2, PostReceiptErrorHandlingBehavior.SHOULD_NOT_CONSUME, null);
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<o> listRemove;
                r.f(error, "error");
                Backend backend = this.this$0;
                List<String> list = listL;
                synchronized (backend) {
                    listRemove = backend.getPostReceiptCallbacks().remove(list);
                }
                if (listRemove != null) {
                    Iterator<T> it3 = listRemove.iterator();
                    while (it3.hasNext()) {
                        ((p) ((o) it3.next()).b()).invoke(error, PostReceiptErrorHandlingBehavior.SHOULD_NOT_CONSUME, null);
                    }
                }
            }
        };
        synchronized (this) {
            addCallback$default(this, this.postReceiptCallbacks, asyncCall, this.dispatcher, listL, t.a(onSuccess, onError), null, 16, null);
            E e4 = E.f5463a;
        }
    }

    public final void postRedeemWebPurchase(String appUserID, String redemptionToken, k onResultHandler) throws Throwable {
        r.f(appUserID, "appUserID");
        r.f(redemptionToken, "redemptionToken");
        r.f(onResultHandler, "onResultHandler");
        final Endpoint.PostRedeemWebPurchase postRedeemWebPurchase = Endpoint.PostRedeemWebPurchase.INSTANCE;
        final String path = postRedeemWebPurchase.getPath();
        final Map mapG = L.g(t.a("redemption_token", redemptionToken), t.a(APP_USER_ID, appUserID));
        Dispatcher.AsyncCall asyncCall = new Dispatcher.AsyncCall() { // from class: com.revenuecat.purchases.common.Backend$postRedeemWebPurchase$call$1
            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public HTTPResult call() {
                return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), postRedeemWebPurchase, mapG, null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), false, this.this$0.appConfig.getFallbackBaseURLs(), 0, 160, null);
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onCompletion(HTTPResult result) {
                List<k> listRemove;
                r.f(result, "result");
                Backend backend = this.this$0;
                String str = path;
                synchronized (backend) {
                    listRemove = backend.getRedeemWebPurchaseCallbacks().remove(str);
                }
                if (listRemove != null) {
                    for (k kVar : listRemove) {
                        if (BackendHelperKt.isSuccessful(result)) {
                            kVar.invoke(new RedeemWebPurchaseListener.Result.Success(CustomerInfoFactory.INSTANCE.buildCustomerInfo(result)));
                        } else {
                            Integer backendErrorCode = result.getBackendErrorCode();
                            int value = BackendErrorCode.BackendInvalidWebRedemptionToken.getValue();
                            if (backendErrorCode != null && backendErrorCode.intValue() == value) {
                                kVar.invoke(RedeemWebPurchaseListener.Result.InvalidToken.INSTANCE);
                            } else {
                                int value2 = BackendErrorCode.BackendExpiredWebRedemptionToken.getValue();
                                if (backendErrorCode != null && backendErrorCode.intValue() == value2) {
                                    JSONObject body = result.getBody();
                                    JSONObject jSONObjectOptJSONObject = body.optJSONObject("purchase_redemption_error_info");
                                    String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("obfuscated_email") : null;
                                    if (strOptString == null) {
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error parsing expired redemption token response: " + body, null);
                                        kVar.invoke(new RedeemWebPurchaseListener.Result.Error(ErrorsKt.toPurchasesError(result)));
                                    } else {
                                        kVar.invoke(new RedeemWebPurchaseListener.Result.Expired(strOptString));
                                    }
                                } else {
                                    int value3 = BackendErrorCode.BackendPurchaseBelongsToOtherUser.getValue();
                                    if (backendErrorCode != null && backendErrorCode.intValue() == value3) {
                                        kVar.invoke(RedeemWebPurchaseListener.Result.PurchaseBelongsToOtherUser.INSTANCE);
                                    } else {
                                        kVar.invoke(new RedeemWebPurchaseListener.Result.Error(ErrorsKt.toPurchasesError(result)));
                                    }
                                }
                            }
                        }
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.Dispatcher.AsyncCall
            public void onError(PurchasesError error) {
                List<k> listRemove;
                r.f(error, "error");
                Backend backend = this.this$0;
                String str = path;
                synchronized (backend) {
                    listRemove = backend.getRedeemWebPurchaseCallbacks().remove(str);
                }
                if (listRemove != null) {
                    Iterator<T> it = listRemove.iterator();
                    while (it.hasNext()) {
                        ((k) it.next()).invoke(new RedeemWebPurchaseListener.Result.Error(error));
                    }
                }
            }
        };
        synchronized (this) {
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                addCallback(this.redeemWebPurchaseCallbacks, asyncCall, this.dispatcher, path, onResultHandler, Delay.NONE);
                E e4 = E.f5463a;
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public final synchronized void setAliasCallbacks(Map<List<String>, List<o>> map) {
        r.f(map, "<set-?>");
        this.aliasCallbacks = map;
    }

    public final synchronized void setCallbacks(Map<BackgroundAwareCallbackCacheKey, List<o>> map) {
        r.f(map, "<set-?>");
        this.callbacks = map;
    }

    public final synchronized void setCustomerCenterCallbacks(Map<String, List<o>> map) {
        r.f(map, "<set-?>");
        this.customerCenterCallbacks = map;
    }

    public final synchronized void setDiagnosticsCallbacks(Map<List<String>, List<o>> map) {
        r.f(map, "<set-?>");
        this.diagnosticsCallbacks = map;
    }

    public final synchronized void setIdentifyCallbacks(Map<List<String>, List<o>> map) {
        r.f(map, "<set-?>");
        this.identifyCallbacks = map;
    }

    public final synchronized void setOfferingsCallbacks(Map<BackgroundAwareCallbackCacheKey, List<o>> map) {
        r.f(map, "<set-?>");
        this.offeringsCallbacks = map;
    }

    public final synchronized void setPaywallEventsCallbacks(Map<List<String>, List<o>> map) {
        r.f(map, "<set-?>");
        this.paywallEventsCallbacks = map;
    }

    public final synchronized void setPostReceiptCallbacks(Map<List<String>, List<o>> map) {
        r.f(map, "<set-?>");
        this.postReceiptCallbacks = map;
    }

    public final synchronized void setProductEntitlementCallbacks(Map<String, List<o>> map) {
        r.f(map, "<set-?>");
        this.productEntitlementCallbacks = map;
    }

    public final synchronized void setRedeemWebPurchaseCallbacks(Map<String, List<k>> map) {
        r.f(map, "<set-?>");
        this.redeemWebPurchaseCallbacks = map;
    }

    public final synchronized void setVirtualCurrenciesCallbacks(Map<BackgroundAwareCallbackCacheKey, List<o>> map) {
        r.f(map, "<set-?>");
        this.virtualCurrenciesCallbacks = map;
    }

    public final synchronized void setWebBillingProductsCallbacks(Map<String, List<o>> map) {
        r.f(map, "<set-?>");
        this.webBillingProductsCallbacks = map;
    }
}
