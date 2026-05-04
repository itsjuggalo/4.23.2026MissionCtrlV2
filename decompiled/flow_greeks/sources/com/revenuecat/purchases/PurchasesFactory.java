package com.revenuecat.purchases;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Process;
import cd.h0;
import com.revenuecat.purchases.APIKeyValidator;
import com.revenuecat.purchases.PurchasesFactory;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.BackendHelper;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultLocaleProvider;
import com.revenuecat.purchases.common.Delay;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.FileHelper;
import com.revenuecat.purchases.common.HTTPClient;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.OfferingParser;
import com.revenuecat.purchases.common.PlatformInfo;
import com.revenuecat.purchases.common.SharedPreferencesManager;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsFileHelper;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsHelper;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.common.events.BackendStoredEvent;
import com.revenuecat.purchases.common.events.EventsManager;
import com.revenuecat.purchases.common.events.EventsRequest;
import com.revenuecat.purchases.common.networking.ETagManager;
import com.revenuecat.purchases.common.offerings.OfferingsCache;
import com.revenuecat.purchases.common.offerings.OfferingsFactory;
import com.revenuecat.purchases.common.offerings.OfferingsManager;
import com.revenuecat.purchases.common.offlineentitlements.OfflineCustomerInfoCalculator;
import com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager;
import com.revenuecat.purchases.common.offlineentitlements.PurchasedProductsFetcher;
import com.revenuecat.purchases.common.subscriberattributes.DeviceIdentifiersFetcher;
import com.revenuecat.purchases.common.verification.SignatureVerificationMode;
import com.revenuecat.purchases.common.verification.SigningManager;
import com.revenuecat.purchases.identity.IdentityManager;
import com.revenuecat.purchases.paywalls.FontLoader;
import com.revenuecat.purchases.paywalls.OfferingFontPreDownloader;
import com.revenuecat.purchases.paywalls.PaywallPresentedCache;
import com.revenuecat.purchases.paywalls.events.PaywallStoredEvent;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesPoster;
import com.revenuecat.purchases.subscriberattributes.caching.SubscriberAttributesCache;
import com.revenuecat.purchases.utils.AndroidVersionUtilsKt;
import com.revenuecat.purchases.utils.CoilImageDownloader;
import com.revenuecat.purchases.utils.EventsFileHelper;
import com.revenuecat.purchases.utils.IsDebugBuildProvider;
import com.revenuecat.purchases.utils.OfferingImagePreDownloader;
import com.revenuecat.purchases.utils.PurchaseParamsValidator;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencyManager;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import kg.c0;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import pd.o;
import pd.q;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u00010B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\bH\u0002JF\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0002JV\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020(J\u0010\u0010)\u001a\u00020*2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\f\u0010+\u001a\u00020,*\u00020-H\u0002J\u0014\u0010.\u001a\u00020%*\u00020-2\u0006\u0010/\u001a\u00020(H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/revenuecat/purchases/PurchasesFactory;", "", "isDebugBuild", "Lcom/revenuecat/purchases/utils/IsDebugBuildProvider;", "apiKeyValidator", "Lcom/revenuecat/purchases/APIKeyValidator;", "(Lcom/revenuecat/purchases/utils/IsDebugBuildProvider;Lcom/revenuecat/purchases/APIKeyValidator;)V", "createDefaultExecutor", "Ljava/util/concurrent/ExecutorService;", "createEventsExecutor", "createEventsManager", "Lcom/revenuecat/purchases/common/events/EventsManager;", "identityManager", "Lcom/revenuecat/purchases/identity/IdentityManager;", "eventsDispatcher", "Lcom/revenuecat/purchases/common/Dispatcher;", "backend", "Lcom/revenuecat/purchases/common/Backend;", "legacyEventsFileHelper", "Lcom/revenuecat/purchases/utils/EventsFileHelper;", "Lcom/revenuecat/purchases/paywalls/events/PaywallStoredEvent;", "fileHelper", "Lcom/revenuecat/purchases/common/events/BackendStoredEvent;", "baseURL", "Ljava/net/URL;", "createPurchases", "Lcom/revenuecat/purchases/Purchases;", "configuration", "Lcom/revenuecat/purchases/PurchasesConfiguration;", "platformInfo", "Lcom/revenuecat/purchases/common/PlatformInfo;", "proxyURL", "overrideBillingAbstract", "Lcom/revenuecat/purchases/common/BillingAbstract;", "forceServerErrorStrategy", "Lcom/revenuecat/purchases/ForceServerErrorStrategy;", "forceSigningError", "", "runningIntegrationTests", "baseUrlString", "", "validateConfiguration", "Lcom/revenuecat/purchases/APIKeyValidator$ValidationResult;", "getApplication", "Landroid/app/Application;", "Landroid/content/Context;", "hasPermission", "permission", "LowPriorityThreadFactory", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PurchasesFactory {
    private final APIKeyValidator apiKeyValidator;
    private final IsDebugBuildProvider isDebugBuild;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/PurchasesFactory$LowPriorityThreadFactory;", "Ljava/util/concurrent/ThreadFactory;", "threadName", "", "(Ljava/lang/String;)V", "newThread", "Ljava/lang/Thread;", "r", "Ljava/lang/Runnable;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class LowPriorityThreadFactory implements ThreadFactory {
        private final String threadName;

        public LowPriorityThreadFactory(String threadName) {
            t.f(threadName, "threadName");
            this.threadName = threadName;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void newThread$lambda$1(Runnable runnable) {
            if (runnable != null) {
                Process.setThreadPriority(10);
                runnable.run();
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(final Runnable r10) {
            return new Thread(new Runnable() { // from class: com.revenuecat.purchases.g
                @Override // java.lang.Runnable
                public final void run() {
                    PurchasesFactory.LowPriorityThreadFactory.newThread$lambda$1(r10);
                }
            }, this.threadName);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesFactory$createEventsManager$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\r\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0007H\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/revenuecat/purchases/common/events/EventsRequest;", "request", "Lcom/revenuecat/purchases/common/Delay;", "delay", "Lkotlin/Function0;", "Lcd/h0;", "onSuccess", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/PurchasesError;", "", "onError", "invoke", "(Lcom/revenuecat/purchases/common/events/EventsRequest;Lcom/revenuecat/purchases/common/Delay;Lkotlin/jvm/functions/Function0;Lpd/o;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    public static final class AnonymousClass1 extends v implements q {
        final /* synthetic */ Backend $backend;
        final /* synthetic */ URL $baseURL;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Backend backend, URL url) {
            super(4);
            this.$backend = backend;
            this.$baseURL = url;
        }

        @Override // pd.q
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            invoke((EventsRequest) obj, (Delay) obj2, (Function0) obj3, (o) obj4);
            return h0.f3852a;
        }

        public final void invoke(EventsRequest request, Delay delay, Function0 onSuccess, o onError) {
            t.f(request, "request");
            t.f(delay, "delay");
            t.f(onSuccess, "onSuccess");
            t.f(onError, "onError");
            this.$backend.postEvents(request, this.$baseURL, delay, onSuccess, onError);
        }
    }

    public PurchasesFactory(IsDebugBuildProvider isDebugBuild, APIKeyValidator apiKeyValidator) {
        t.f(isDebugBuild, "isDebugBuild");
        t.f(apiKeyValidator, "apiKeyValidator");
        this.isDebugBuild = isDebugBuild;
        this.apiKeyValidator = apiKeyValidator;
    }

    private final ExecutorService createDefaultExecutor() {
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        t.e(scheduledExecutorServiceNewSingleThreadScheduledExecutor, "newSingleThreadScheduledExecutor()");
        return scheduledExecutorServiceNewSingleThreadScheduledExecutor;
    }

    private final ExecutorService createEventsExecutor() {
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new LowPriorityThreadFactory("revenuecat-events-thread"));
        t.e(scheduledExecutorServiceNewSingleThreadScheduledExecutor, "newSingleThreadScheduled…venuecat-events-thread\"))");
        return scheduledExecutorServiceNewSingleThreadScheduledExecutor;
    }

    private final EventsManager createEventsManager(IdentityManager identityManager, Dispatcher eventsDispatcher, Backend backend, EventsFileHelper<PaywallStoredEvent> legacyEventsFileHelper, EventsFileHelper<BackendStoredEvent> fileHelper, URL baseURL) {
        return new EventsManager(null, legacyEventsFileHelper, fileHelper, identityManager, eventsDispatcher, new AnonymousClass1(backend, baseURL), 1, null);
    }

    public static /* synthetic */ Purchases createPurchases$default(PurchasesFactory purchasesFactory, PurchasesConfiguration purchasesConfiguration, PlatformInfo platformInfo, URL url, BillingAbstract billingAbstract, ForceServerErrorStrategy forceServerErrorStrategy, boolean z10, boolean z11, String str, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            billingAbstract = null;
        }
        if ((i10 & 16) != 0) {
            forceServerErrorStrategy = null;
        }
        if ((i10 & 32) != 0) {
            z10 = false;
        }
        if ((i10 & 64) != 0) {
            z11 = false;
        }
        if ((i10 & 128) != 0) {
            str = AppConfig.baseUrlString;
        }
        return purchasesFactory.createPurchases(purchasesConfiguration, platformInfo, url, billingAbstract, forceServerErrorStrategy, z10, z11, str);
    }

    private final Application getApplication(Context context) {
        Context applicationContext = context.getApplicationContext();
        t.d(applicationContext, "null cannot be cast to non-null type android.app.Application");
        return (Application) applicationContext;
    }

    private final boolean hasPermission(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Purchases createPurchases(PurchasesConfiguration configuration, PlatformInfo platformInfo, URL proxyURL, BillingAbstract overrideBillingAbstract, ForceServerErrorStrategy forceServerErrorStrategy, boolean forceSigningError, boolean runningIntegrationTests, String baseUrlString) {
        Context context;
        Context context2;
        AppConfig appConfig;
        Dispatcher dispatcher;
        DiagnosticsTracker diagnosticsTracker;
        DiagnosticsHelper diagnosticsHelper;
        DiagnosticsFileHelper diagnosticsFileHelper;
        SignatureVerificationMode signatureVerificationModeFromEntitlementVerificationMode$default;
        PurchasesStateCache purchasesStateCache;
        Application application;
        DeviceCache deviceCache;
        BillingAbstract billingAbstract;
        BillingAbstract billingAbstract2;
        Dispatcher dispatcher2;
        Backend backend;
        DiagnosticsTracker diagnosticsTracker2;
        DiagnosticsSynchronizer diagnosticsSynchronizer;
        int[] iArr;
        t.f(configuration, "configuration");
        t.f(platformInfo, "platformInfo");
        t.f(baseUrlString, "baseUrlString");
        APIKeyValidator.ValidationResult validationResultValidateConfiguration = validateConfiguration(configuration);
        Store store = validationResultValidateConfiguration == APIKeyValidator.ValidationResult.SIMULATED_STORE ? Store.TEST_STORE : configuration.getStore();
        Application application2 = getApplication(configuration.getContext());
        AppConfig appConfig2 = new AppConfig(configuration.getContext(), configuration.getPurchasesAreCompletedBy(), configuration.getShowInAppMessagesAutomatically(), platformInfo, proxyURL, store, this.isDebugBuild.invoke(), validationResultValidateConfiguration, configuration.getDangerousSettings(), runningIntegrationTests, forceSigningError, baseUrlString);
        if (UtilsKt.isDeviceProtectedStorageCompat(configuration.getContext())) {
            LogLevel logLevel = LogLevel.DEBUG;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.d("[Purchases] - " + logLevel.name(), "‼️ Using device-protected storage. Make sure to *always* configure Purchases with a Context object created using `createDeviceProtectedStorageContext()` to avoid undefined behavior.\nSee https://developer.android.com/reference/android/content/Context#createDeviceProtectedStorageContext() for more info.");
            }
            context = configuration.getContext();
        } else {
            context = application2;
        }
        try {
            SharedPreferences sharedPreferences = new SharedPreferencesManager(context, null, null, 6, null).getSharedPreferences();
            ETagManager eTagManager = new ETagManager(context, null, null, 6, null);
            Dispatcher dispatcher3 = new Dispatcher(createDefaultExecutor(), null, runningIntegrationTests, 2, null);
            ExecutorService service = configuration.getService();
            if (service == null) {
                service = createDefaultExecutor();
            }
            int i10 = 2;
            kotlin.jvm.internal.k kVar = null;
            Handler handler = null;
            Dispatcher dispatcher4 = new Dispatcher(service, handler, runningIntegrationTests, i10, kVar);
            Dispatcher dispatcher5 = new Dispatcher(createEventsExecutor(), handler, runningIntegrationTests, i10, kVar);
            if (configuration.getDiagnosticsEnabled() && AndroidVersionUtilsKt.isAndroidNOrNewer()) {
                DiagnosticsFileHelper diagnosticsFileHelper2 = new DiagnosticsFileHelper(new FileHelper(context));
                DiagnosticsHelper diagnosticsHelper2 = new DiagnosticsHelper(context, diagnosticsFileHelper2, null, 4, null);
                context2 = context;
                DiagnosticsTracker diagnosticsTracker3 = new DiagnosticsTracker(appConfig2, diagnosticsFileHelper2, diagnosticsHelper2, dispatcher5, null, 16, null);
                appConfig = appConfig2;
                dispatcher = dispatcher5;
                diagnosticsHelper = diagnosticsHelper2;
                diagnosticsFileHelper = diagnosticsFileHelper2;
                diagnosticsTracker = diagnosticsTracker3;
            } else {
                context2 = context;
                appConfig = appConfig2;
                dispatcher = dispatcher5;
                if (configuration.getDiagnosticsEnabled()) {
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), "Diagnostics are only supported on Android N or newer.");
                    }
                }
                diagnosticsTracker = null;
                diagnosticsHelper = null;
                diagnosticsFileHelper = null;
            }
            try {
                signatureVerificationModeFromEntitlementVerificationMode$default = SignatureVerificationMode.Companion.fromEntitlementVerificationMode$default(SignatureVerificationMode.INSTANCE, configuration.getVerificationMode(), null, 2, null);
            } catch (IllegalStateException e10) {
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error creating signature verifier: " + e10.getMessage() + ". Disabling signature verification.", null);
                signatureVerificationModeFromEntitlementVerificationMode$default = SignatureVerificationMode.Disabled.INSTANCE;
            }
            SigningManager signingManager = new SigningManager(signatureVerificationModeFromEntitlementVerificationMode$default, appConfig, configuration.getApiKey());
            DeviceCache deviceCache2 = new DeviceCache(sharedPreferences, configuration.getApiKey(), null, 4, null);
            DefaultLocaleProvider defaultLocaleProvider = new DefaultLocaleProvider();
            DiagnosticsTracker diagnosticsTracker4 = diagnosticsTracker;
            HTTPClient hTTPClient = new HTTPClient(appConfig, eTagManager, diagnosticsTracker4, signingManager, deviceCache2, null, null, defaultLocaleProvider, forceServerErrorStrategy, null, null, 1632, null);
            BackendHelper backendHelper = new BackendHelper(configuration.getApiKey(), dispatcher4, appConfig, hTTPClient);
            AppConfig appConfig3 = appConfig;
            Backend backend2 = new Backend(appConfig3, dispatcher4, dispatcher, hTTPClient, backendHelper);
            PurchasesStateCache purchasesStateCache2 = new PurchasesStateCache(new PurchasesState(null, null, null, false, false, 31, null));
            if (overrideBillingAbstract == null) {
                application = application2;
                BillingAbstract billingAbstractCreateBilling = BillingFactory.INSTANCE.createBilling(store, application, backendHelper, deviceCache2, PurchasesAreCompletedByKt.getFinishTransactions(configuration.getPurchasesAreCompletedBy()), diagnosticsTracker4, purchasesStateCache2, configuration.getPendingTransactionsForPrepaidPlansEnabled(), backend2);
                deviceCache = deviceCache2;
                purchasesStateCache = purchasesStateCache2;
                backend2 = backend2;
                billingAbstract = billingAbstractCreateBilling;
            } else {
                purchasesStateCache = purchasesStateCache2;
                application = application2;
                deviceCache = deviceCache2;
                billingAbstract = overrideBillingAbstract;
            }
            SubscriberAttributesPoster subscriberAttributesPoster = new SubscriberAttributesPoster(backendHelper);
            DeviceIdentifiersFetcher deviceIdentifiersFetcherCreateAttributionFetcher = AttributionFetcherFactory.INSTANCE.createAttributionFetcher(configuration.getStore(), dispatcher4);
            SubscriberAttributesCache subscriberAttributesCache = new SubscriberAttributesCache(deviceCache);
            SubscriberAttributesManager subscriberAttributesManager = new SubscriberAttributesManager(subscriberAttributesCache, subscriberAttributesPoster, deviceIdentifiersFetcherCreateAttributionFetcher, configuration.getAutomaticDeviceIdentifierCollectionEnabled());
            DateProvider dateProvider = null;
            DeviceCache deviceCache3 = deviceCache;
            BillingAbstract billingAbstract3 = billingAbstract;
            OfflineEntitlementsManager offlineEntitlementsManager = new OfflineEntitlementsManager(backend2, new OfflineCustomerInfoCalculator(new PurchasedProductsFetcher(deviceCache3, billingAbstract3, dateProvider, 4, null), appConfig3, diagnosticsTracker4, dateProvider, 8, 0 == true ? 1 : 0), deviceCache3, appConfig3, diagnosticsTracker4);
            OfferingsCache offeringsCache = new OfferingsCache(deviceCache3, null, 0 == true ? 1 : 0, defaultLocaleProvider, 6, null);
            Backend backend3 = backend2;
            IdentityManager identityManager = new IdentityManager(deviceCache3, subscriberAttributesCache, subscriberAttributesManager, offeringsCache, backend3, offlineEntitlementsManager, dispatcher3);
            CustomerInfoUpdateHandler customerInfoUpdateHandler = new CustomerInfoUpdateHandler(deviceCache3, identityManager, offlineEntitlementsManager, appConfig3, diagnosticsTracker4, null, 32, null);
            PaywallPresentedCache paywallPresentedCache = new PaywallPresentedCache();
            PostReceiptHelper postReceiptHelper = new PostReceiptHelper(appConfig3, backend3, billingAbstract3, customerInfoUpdateHandler, deviceCache3, subscriberAttributesManager, offlineEntitlementsManager, paywallPresentedCache);
            PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper = new PostTransactionWithProductDetailsHelper(billingAbstract3, postReceiptHelper);
            PostPendingTransactionsHelper postPendingTransactionsHelper = new PostPendingTransactionsHelper(appConfig3, deviceCache3, billingAbstract3, dispatcher4, identityManager, postTransactionWithProductDetailsHelper);
            CustomerInfoHelper customerInfoHelper = new CustomerInfoHelper(deviceCache3, backend3, offlineEntitlementsManager, customerInfoUpdateHandler, postPendingTransactionsHelper, diagnosticsTracker4, null, null, 192, null);
            OfferingParser offeringParserCreateOfferingParser = OfferingParserFactory.INSTANCE.createOfferingParser(store);
            if (diagnosticsFileHelper == null || diagnosticsHelper == null || diagnosticsTracker4 == null || !AndroidVersionUtilsKt.isAndroidNOrNewer()) {
                billingAbstract2 = billingAbstract3;
                dispatcher2 = dispatcher;
                backend = backend3;
                diagnosticsTracker2 = diagnosticsTracker4;
                diagnosticsSynchronizer = null;
            } else {
                Dispatcher dispatcher6 = dispatcher;
                diagnosticsSynchronizer = new DiagnosticsSynchronizer(diagnosticsHelper, diagnosticsFileHelper, diagnosticsTracker4, backend3, dispatcher6);
                backend = backend3;
                dispatcher2 = dispatcher6;
                billingAbstract2 = billingAbstract3;
                diagnosticsTracker2 = diagnosticsTracker4;
                diagnosticsTracker2.setListener(diagnosticsSynchronizer);
            }
            BillingAbstract billingAbstract4 = billingAbstract2;
            DiagnosticsTracker diagnosticsTracker5 = diagnosticsTracker2;
            SyncPurchasesHelper syncPurchasesHelper = new SyncPurchasesHelper(billingAbstract4, identityManager, customerInfoHelper, postReceiptHelper, diagnosticsTracker5, null, 32, null);
            Context context3 = context2;
            FontLoader fontLoader = new FontLoader(context3, null, null, null, 14, null);
            DiagnosticsSynchronizer diagnosticsSynchronizer2 = diagnosticsSynchronizer;
            Dispatcher dispatcher7 = dispatcher2;
            Backend backend4 = backend;
            OfferingsManager offeringsManager = new OfferingsManager(offeringsCache, backend4, new OfferingsFactory(billingAbstract4, offeringParserCreateOfferingParser, dispatcher3, appConfig3), new OfferingImagePreDownloader(false, new CoilImageDownloader(application), 1, null), diagnosticsTracker5, new OfferingFontPreDownloader(context3, fontLoader), null, null, 192, null);
            LogIntent logIntent = LogIntent.DEBUG;
            PurchasesFactory$createPurchases$lambda$8$$inlined$log$1 purchasesFactory$createPurchases$lambda$8$$inlined$log$1 = new PurchasesFactory$createPurchases$lambda$8$$inlined$log$1(logIntent);
            int[] iArr2 = LogWrapperKt.WhenMappings.$EnumSwitchMapping$0;
            switch (iArr2[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel3 = LogLevel.DEBUG;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.d("[Purchases] - " + logLevel3.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$1.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$1.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel4 = LogLevel.WARN;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        currentLogHandler4.w("[Purchases] - " + logLevel4.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$1.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler5.i("[Purchases] - " + logLevel5.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$1.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        currentLogHandler6.d("[Purchases] - " + logLevel6.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$1.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$1.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel7 = LogLevel.INFO;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        currentLogHandler7.i("[Purchases] - " + logLevel7.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$1.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel8 = LogLevel.DEBUG;
                    LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler8.d("[Purchases] - " + logLevel8.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$1.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel9 = LogLevel.DEBUG;
                    LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler9.d("[Purchases] - " + logLevel9.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$1.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel10 = LogLevel.WARN;
                    LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                        currentLogHandler10.w("[Purchases] - " + logLevel10.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$1.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel11 = LogLevel.WARN;
                    LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                        currentLogHandler11.w("[Purchases] - " + logLevel11.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$1.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$1.invoke(), null);
                    break;
            }
            PurchasesFactory$createPurchases$lambda$8$$inlined$log$2 purchasesFactory$createPurchases$lambda$8$$inlined$log$2 = new PurchasesFactory$createPurchases$lambda$8$$inlined$log$2(logIntent);
            switch (iArr2[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel12 = LogLevel.DEBUG;
                    LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                        currentLogHandler12.d("[Purchases] - " + logLevel12.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$2.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$2.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel13 = LogLevel.WARN;
                    LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                        currentLogHandler13.w("[Purchases] - " + logLevel13.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$2.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel14 = LogLevel.INFO;
                    LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                        currentLogHandler14.i("[Purchases] - " + logLevel14.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$2.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel15 = LogLevel.DEBUG;
                    LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                        currentLogHandler15.d("[Purchases] - " + logLevel15.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$2.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$2.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel16 = LogLevel.INFO;
                    LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                        currentLogHandler16.i("[Purchases] - " + logLevel16.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$2.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel17 = LogLevel.DEBUG;
                    LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                        currentLogHandler17.d("[Purchases] - " + logLevel17.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$2.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel18 = LogLevel.DEBUG;
                    LogHandler currentLogHandler18 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                        currentLogHandler18.d("[Purchases] - " + logLevel18.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$2.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel19 = LogLevel.WARN;
                    LogHandler currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                        currentLogHandler19.w("[Purchases] - " + logLevel19.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$2.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel20 = LogLevel.WARN;
                    LogHandler currentLogHandler20 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                        currentLogHandler20.w("[Purchases] - " + logLevel20.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$2.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$2.invoke(), null);
                    break;
            }
            PurchasesFactory$createPurchases$lambda$8$$inlined$log$3 purchasesFactory$createPurchases$lambda$8$$inlined$log$3 = new PurchasesFactory$createPurchases$lambda$8$$inlined$log$3(logIntent, appConfig3);
            switch (iArr2[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel21 = LogLevel.DEBUG;
                    LogHandler currentLogHandler21 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel21) <= 0) {
                        currentLogHandler21.d("[Purchases] - " + logLevel21.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$3.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$3.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel22 = LogLevel.WARN;
                    LogHandler currentLogHandler22 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel22) <= 0) {
                        currentLogHandler22.w("[Purchases] - " + logLevel22.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$3.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel23 = LogLevel.INFO;
                    LogHandler currentLogHandler23 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel23) <= 0) {
                        currentLogHandler23.i("[Purchases] - " + logLevel23.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$3.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel24 = LogLevel.DEBUG;
                    LogHandler currentLogHandler24 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel24) <= 0) {
                        currentLogHandler24.d("[Purchases] - " + logLevel24.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$3.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$3.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel25 = LogLevel.INFO;
                    LogHandler currentLogHandler25 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel25) <= 0) {
                        currentLogHandler25.i("[Purchases] - " + logLevel25.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$3.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel26 = LogLevel.DEBUG;
                    LogHandler currentLogHandler26 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel26) <= 0) {
                        currentLogHandler26.d("[Purchases] - " + logLevel26.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$3.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel27 = LogLevel.DEBUG;
                    LogHandler currentLogHandler27 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel27) <= 0) {
                        currentLogHandler27.d("[Purchases] - " + logLevel27.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$3.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel28 = LogLevel.WARN;
                    LogHandler currentLogHandler28 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel28) <= 0) {
                        currentLogHandler28.w("[Purchases] - " + logLevel28.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$3.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel29 = LogLevel.WARN;
                    LogHandler currentLogHandler29 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel29) <= 0) {
                        currentLogHandler29.w("[Purchases] - " + logLevel29.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$3.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$3.invoke(), null);
                    break;
            }
            LogIntent logIntent2 = LogIntent.USER;
            PurchasesFactory$createPurchases$lambda$8$$inlined$log$4 purchasesFactory$createPurchases$lambda$8$$inlined$log$4 = new PurchasesFactory$createPurchases$lambda$8$$inlined$log$4(logIntent2, configuration);
            switch (iArr2[logIntent2.ordinal()]) {
                case 1:
                    iArr = iArr2;
                    LogLevel logLevel30 = LogLevel.DEBUG;
                    LogHandler currentLogHandler30 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel30) <= 0) {
                        currentLogHandler30.d("[Purchases] - " + logLevel30.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$4.invoke());
                    }
                    break;
                case 2:
                    iArr = iArr2;
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$4.invoke(), null);
                    break;
                case 3:
                    iArr = iArr2;
                    LogLevel logLevel31 = LogLevel.WARN;
                    LogHandler currentLogHandler31 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel31) <= 0) {
                        currentLogHandler31.w("[Purchases] - " + logLevel31.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$4.invoke());
                    }
                    break;
                case 4:
                    iArr = iArr2;
                    LogLevel logLevel32 = LogLevel.INFO;
                    LogHandler currentLogHandler32 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel32) <= 0) {
                        currentLogHandler32.i("[Purchases] - " + logLevel32.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$4.invoke());
                    }
                    break;
                case 5:
                    iArr = iArr2;
                    LogLevel logLevel33 = LogLevel.DEBUG;
                    LogHandler currentLogHandler33 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel33) <= 0) {
                        currentLogHandler33.d("[Purchases] - " + logLevel33.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$4.invoke());
                    }
                    break;
                case 6:
                    iArr = iArr2;
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$4.invoke(), null);
                    break;
                case 7:
                    iArr = iArr2;
                    LogLevel logLevel34 = LogLevel.INFO;
                    LogHandler currentLogHandler34 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel34) <= 0) {
                        currentLogHandler34.i("[Purchases] - " + logLevel34.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$4.invoke());
                    }
                    break;
                case 8:
                    iArr = iArr2;
                    LogLevel logLevel35 = LogLevel.DEBUG;
                    LogHandler currentLogHandler35 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel35) <= 0) {
                        currentLogHandler35.d("[Purchases] - " + logLevel35.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$4.invoke());
                    }
                    break;
                case 9:
                    iArr = iArr2;
                    LogLevel logLevel36 = LogLevel.DEBUG;
                    LogHandler currentLogHandler36 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel36) <= 0) {
                        currentLogHandler36.d("[Purchases] - " + logLevel36.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$4.invoke());
                    }
                    break;
                case 10:
                    iArr = iArr2;
                    LogLevel logLevel37 = LogLevel.WARN;
                    LogHandler currentLogHandler37 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel37) <= 0) {
                        currentLogHandler37.w("[Purchases] - " + logLevel37.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$4.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel38 = LogLevel.WARN;
                    LogHandler currentLogHandler38 = LogWrapperKt.getCurrentLogHandler();
                    iArr = iArr2;
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel38) <= 0) {
                        currentLogHandler38.w("[Purchases] - " + logLevel38.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$4.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$4.invoke(), null);
                default:
                    iArr = iArr2;
                    break;
            }
            PurchasesFactory$createPurchases$lambda$8$$inlined$log$5 purchasesFactory$createPurchases$lambda$8$$inlined$log$5 = new PurchasesFactory$createPurchases$lambda$8$$inlined$log$5(logIntent, configuration);
            switch (iArr[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel39 = LogLevel.DEBUG;
                    LogHandler currentLogHandler39 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel39) <= 0) {
                        currentLogHandler39.d("[Purchases] - " + logLevel39.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$5.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$5.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel40 = LogLevel.WARN;
                    LogHandler currentLogHandler40 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel40) <= 0) {
                        currentLogHandler40.w("[Purchases] - " + logLevel40.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$5.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel41 = LogLevel.INFO;
                    LogHandler currentLogHandler41 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel41) <= 0) {
                        currentLogHandler41.i("[Purchases] - " + logLevel41.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$5.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel42 = LogLevel.DEBUG;
                    LogHandler currentLogHandler42 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel42) <= 0) {
                        currentLogHandler42.d("[Purchases] - " + logLevel42.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$5.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$5.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel43 = LogLevel.INFO;
                    LogHandler currentLogHandler43 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel43) <= 0) {
                        currentLogHandler43.i("[Purchases] - " + logLevel43.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$5.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel44 = LogLevel.DEBUG;
                    LogHandler currentLogHandler44 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel44) <= 0) {
                        currentLogHandler44.d("[Purchases] - " + logLevel44.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$5.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel45 = LogLevel.DEBUG;
                    LogHandler currentLogHandler45 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel45) <= 0) {
                        currentLogHandler45.d("[Purchases] - " + logLevel45.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$5.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel46 = LogLevel.WARN;
                    LogHandler currentLogHandler46 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel46) <= 0) {
                        currentLogHandler46.w("[Purchases] - " + logLevel46.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$5.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel47 = LogLevel.WARN;
                    LogHandler currentLogHandler47 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel47) <= 0) {
                        currentLogHandler47.w("[Purchases] - " + logLevel47.name(), (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$5.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesFactory$createPurchases$lambda$8$$inlined$log$5.invoke(), null);
                    break;
            }
            VirtualCurrencyManager virtualCurrencyManager = new VirtualCurrencyManager(identityManager, deviceCache3, backend4, appConfig3);
            PurchaseParamsValidator purchaseParamsValidator = new PurchaseParamsValidator();
            EventsManager.Companion companion = EventsManager.INSTANCE;
            EventsFileHelper<PaywallStoredEvent> eventsFileHelperPaywalls = companion.paywalls(new FileHelper(application));
            EventsFileHelper<BackendStoredEvent> eventsFileHelperBackendEvents = companion.backendEvents(new FileHelper(application));
            AppConfig.Companion companion2 = AppConfig.INSTANCE;
            return new Purchases(new PurchasesOrchestrator(application, configuration.getAppUserID(), backend4, billingAbstract4, deviceCache3, identityManager, subscriberAttributesManager, appConfig3, customerInfoHelper, customerInfoUpdateHandler, diagnosticsSynchronizer2, diagnosticsTracker5, null, offlineEntitlementsManager, postReceiptHelper, postTransactionWithProductDetailsHelper, postPendingTransactionsHelper, syncPurchasesHelper, offeringsManager, createEventsManager(identityManager, dispatcher7, backend4, eventsFileHelperPaywalls, eventsFileHelperBackendEvents, companion2.getPaywallEventsURL()), createEventsManager(identityManager, dispatcher7, backend4, null, companion.adEvents(new FileHelper(application)), companion2.getAdEventsURL()), paywallPresentedCache, purchasesStateCache, null, dispatcher3, configuration, fontLoader, defaultLocaleProvider, null, virtualCurrencyManager, purchaseParamsValidator, null, null, null, null, null, -1870655488, 15, null));
        } catch (IllegalStateException e11) {
            if (p0.l.a(configuration.getContext())) {
                throw e11;
            }
            throw new IllegalStateException("Trying to configure Purchases while the device is locked. If you need to support this scenario, ensure you *always* configure Purchases with a Context created with `createDeviceProtectedStorageContext()` to avoid undefined behavior.\nSee https://developer.android.com/reference/android/content/Context#createDeviceProtectedStorageContext() for more info.", e11);
        }
    }

    public final APIKeyValidator.ValidationResult validateConfiguration(PurchasesConfiguration configuration) {
        t.f(configuration, "configuration");
        if (!hasPermission(configuration.getContext(), "android.permission.INTERNET")) {
            throw new IllegalArgumentException("Purchases requires INTERNET permission.");
        }
        if (c0.e0(configuration.getApiKey())) {
            throw new IllegalArgumentException("API key must be set. Get this from the RevenueCat web app");
        }
        APIKeyValidator.ValidationResult validationResultValidateAndLog = this.apiKeyValidator.validateAndLog(configuration.getApiKey(), configuration.getStore());
        if (this.isDebugBuild.invoke() || validationResultValidateAndLog != APIKeyValidator.ValidationResult.SIMULATED_STORE) {
            if (configuration.getContext().getApplicationContext() instanceof Application) {
                return validationResultValidateAndLog;
            }
            throw new IllegalArgumentException("Needs an application context.");
        }
        String strRedactApiKey = this.apiKeyValidator.redactApiKey(configuration.getApiKey());
        LogUtilsKt.errorLog(new PurchasesError(PurchasesErrorCode.ConfigurationError, "Test Store API key used in release build: " + strRedactApiKey + ". Please configure the Play Store/Amazon app on the RevenueCat dashboard and use its corresponding API key before releasing. Visit https://rev.cat/sdk-test-store to learn more."));
        SimulatedStoreErrorDialogActivity.INSTANCE.show(configuration.getContext(), strRedactApiKey);
        return validationResultValidateAndLog;
    }

    public /* synthetic */ PurchasesFactory(IsDebugBuildProvider isDebugBuildProvider, APIKeyValidator aPIKeyValidator, int i10, kotlin.jvm.internal.k kVar) {
        this(isDebugBuildProvider, (i10 & 2) != 0 ? new APIKeyValidator() : aPIKeyValidator);
    }
}
