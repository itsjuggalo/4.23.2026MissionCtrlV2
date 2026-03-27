package com.revenuecat.purchases;

import D.m;
import W2.E;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Process;
import com.revenuecat.purchases.APIKeyValidator;
import com.revenuecat.purchases.PurchasesFactory;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.BackendHelper;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.DefaultLocaleProvider;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.FileHelper;
import com.revenuecat.purchases.common.HTTPClient;
import com.revenuecat.purchases.common.LogIntent;
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
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesPoster;
import com.revenuecat.purchases.subscriberattributes.caching.SubscriberAttributesCache;
import com.revenuecat.purchases.utils.AndroidVersionUtilsKt;
import com.revenuecat.purchases.utils.CoilImageDownloader;
import com.revenuecat.purchases.utils.IsDebugBuildProvider;
import com.revenuecat.purchases.utils.OfferingImagePreDownloader;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencyManager;
import i3.o;
import i3.p;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import r3.AbstractC1753A;

/* JADX INFO: loaded from: classes.dex */
public final class PurchasesFactory {
    private final APIKeyValidator apiKeyValidator;
    private final IsDebugBuildProvider isDebugBuild;
    private final Function0 isSimulatedStoreEnabled;

    /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesFactory$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements Function0 {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.FALSE;
        }
    }

    public static final class LowPriorityThreadFactory implements ThreadFactory {
        private final String threadName;

        public LowPriorityThreadFactory(String threadName) {
            r.f(threadName, "threadName");
            this.threadName = threadName;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void newThread$lambda$1(Runnable runnable) {
            if (runnable != null) {
                Process.setThreadPriority(19);
                runnable.run();
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(final Runnable runnable) {
            return new Thread(new Runnable() { // from class: com.revenuecat.purchases.d
                @Override // java.lang.Runnable
                public final void run() {
                    PurchasesFactory.LowPriorityThreadFactory.newThread$lambda$1(runnable);
                }
            }, this.threadName);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesFactory$createEventsManager$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11011 extends s implements p {
        final /* synthetic */ Backend $backend;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11011(Backend backend) {
            super(3);
            this.$backend = backend;
        }

        @Override // i3.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((EventsRequest) obj, (Function0) obj2, (o) obj3);
            return E.f5463a;
        }

        public final void invoke(EventsRequest request, Function0 onSuccess, o onError) {
            r.f(request, "request");
            r.f(onSuccess, "onSuccess");
            r.f(onError, "onError");
            this.$backend.postEvents(request, onSuccess, onError);
        }
    }

    public PurchasesFactory(IsDebugBuildProvider isDebugBuild, APIKeyValidator apiKeyValidator, Function0 isSimulatedStoreEnabled) {
        r.f(isDebugBuild, "isDebugBuild");
        r.f(apiKeyValidator, "apiKeyValidator");
        r.f(isSimulatedStoreEnabled, "isSimulatedStoreEnabled");
        this.isDebugBuild = isDebugBuild;
        this.apiKeyValidator = apiKeyValidator;
        this.isSimulatedStoreEnabled = isSimulatedStoreEnabled;
    }

    private final ExecutorService createDefaultExecutor() {
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        r.e(scheduledExecutorServiceNewSingleThreadScheduledExecutor, "newSingleThreadScheduledExecutor()");
        return scheduledExecutorServiceNewSingleThreadScheduledExecutor;
    }

    private final ExecutorService createEventsExecutor() {
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new LowPriorityThreadFactory("revenuecat-events-thread"));
        r.e(scheduledExecutorServiceNewSingleThreadScheduledExecutor, "newSingleThreadScheduled…venuecat-events-thread\"))");
        return scheduledExecutorServiceNewSingleThreadScheduledExecutor;
    }

    private final EventsManager createEventsManager(Context context, IdentityManager identityManager, Dispatcher dispatcher, Backend backend) {
        if (AndroidVersionUtilsKt.isAndroidNOrNewer()) {
            EventsManager.Companion companion = EventsManager.Companion;
            return new EventsManager(null, companion.paywalls(new FileHelper(context)), companion.backendEvents(new FileHelper(context)), identityManager, dispatcher, new C11011(backend), 1, null);
        }
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) > 0) {
            return null;
        }
        currentLogHandler.d("[Purchases] - " + logLevel.name(), "Paywall events are only supported on Android N or newer.");
        return null;
    }

    public static /* synthetic */ Purchases createPurchases$default(PurchasesFactory purchasesFactory, PurchasesConfiguration purchasesConfiguration, PlatformInfo platformInfo, URL url, BillingAbstract billingAbstract, boolean z4, boolean z5, boolean z6, int i4, Object obj) {
        boolean z7;
        PurchasesFactory purchasesFactory2;
        PurchasesConfiguration purchasesConfiguration2;
        PlatformInfo platformInfo2;
        URL url2;
        if ((i4 & 8) != 0) {
            billingAbstract = null;
        }
        BillingAbstract billingAbstract2 = billingAbstract;
        boolean z8 = (i4 & 16) != 0 ? false : z4;
        boolean z9 = (i4 & 32) != 0 ? false : z5;
        if ((i4 & 64) != 0) {
            z7 = false;
            purchasesConfiguration2 = purchasesConfiguration;
            platformInfo2 = platformInfo;
            url2 = url;
            purchasesFactory2 = purchasesFactory;
        } else {
            z7 = z6;
            purchasesFactory2 = purchasesFactory;
            purchasesConfiguration2 = purchasesConfiguration;
            platformInfo2 = platformInfo;
            url2 = url;
        }
        return purchasesFactory2.createPurchases(purchasesConfiguration2, platformInfo2, url2, billingAbstract2, z8, z9, z7);
    }

    private final Application getApplication(Context context) {
        Context applicationContext = context.getApplicationContext();
        r.d(applicationContext, "null cannot be cast to non-null type android.app.Application");
        return (Application) applicationContext;
    }

    private final boolean hasPermission(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.revenuecat.purchases.common.verification.SignatureVerifier, java.lang.Object, java.lang.Throwable] */
    public final Purchases createPurchases(PurchasesConfiguration configuration, PlatformInfo platformInfo, URL url, BillingAbstract billingAbstract, boolean z4, boolean z5, boolean z6) throws PurchasesException {
        Context context;
        ?? r12;
        Context context2;
        AppConfig appConfig;
        Dispatcher dispatcher;
        DiagnosticsTracker diagnosticsTracker;
        DiagnosticsFileHelper diagnosticsFileHelper;
        DiagnosticsHelper diagnosticsHelper;
        SignatureVerificationMode signatureVerificationModeFromEntitlementVerificationMode$default;
        Dispatcher dispatcher2;
        Application application;
        DeviceCache deviceCache;
        BillingAbstract billingAbstract2;
        PostReceiptHelper postReceiptHelper;
        DiagnosticsTracker diagnosticsTracker2;
        Backend backend;
        Dispatcher dispatcher3;
        OfferingsCache offeringsCache;
        DiagnosticsSynchronizer diagnosticsSynchronizer;
        int[] iArr;
        r.f(configuration, "configuration");
        r.f(platformInfo, "platformInfo");
        APIKeyValidator.ValidationResult validationResultValidateConfiguration = validateConfiguration(configuration);
        Store store = (validationResultValidateConfiguration == APIKeyValidator.ValidationResult.SIMULATED_STORE && ((Boolean) this.isSimulatedStoreEnabled.invoke()).booleanValue()) ? Store.UNKNOWN_STORE : configuration.getStore();
        Application application2 = getApplication(configuration.getContext());
        AppConfig appConfig2 = new AppConfig(configuration.getContext(), configuration.getPurchasesAreCompletedBy(), configuration.getShowInAppMessagesAutomatically(), platformInfo, url, store, this.isDebugBuild.invoke(), validationResultValidateConfiguration, configuration.getDangerousSettings(), z6, z4, z5);
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
            Dispatcher dispatcher4 = new Dispatcher(createDefaultExecutor(), null, z6, 2, null);
            ExecutorService service = configuration.getService();
            if (service == null) {
                service = createDefaultExecutor();
            }
            int i4 = 2;
            AbstractC1585j abstractC1585j = null;
            Handler handler = null;
            Dispatcher dispatcher5 = new Dispatcher(service, handler, z6, i4, abstractC1585j);
            Dispatcher dispatcher6 = new Dispatcher(createEventsExecutor(), handler, z6, i4, abstractC1585j);
            if (configuration.getDiagnosticsEnabled() && AndroidVersionUtilsKt.isAndroidNOrNewer()) {
                DiagnosticsFileHelper diagnosticsFileHelper2 = new DiagnosticsFileHelper(new FileHelper(context));
                r12 = 0;
                DiagnosticsHelper diagnosticsHelper2 = new DiagnosticsHelper(context, diagnosticsFileHelper2, null, 4, null);
                context2 = context;
                appConfig = appConfig2;
                dispatcher = dispatcher6;
                diagnosticsHelper = diagnosticsHelper2;
                diagnosticsFileHelper = diagnosticsFileHelper2;
                diagnosticsTracker = new DiagnosticsTracker(appConfig2, diagnosticsFileHelper2, diagnosticsHelper2, dispatcher6, null, 16, null);
            } else {
                r12 = 0;
                context2 = context;
                appConfig = appConfig2;
                dispatcher = dispatcher6;
                if (configuration.getDiagnosticsEnabled()) {
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), "Diagnostics are only supported on Android N or newer.");
                    }
                }
                diagnosticsTracker = null;
                diagnosticsFileHelper = null;
                diagnosticsHelper = null;
            }
            try {
                signatureVerificationModeFromEntitlementVerificationMode$default = SignatureVerificationMode.Companion.fromEntitlementVerificationMode$default(SignatureVerificationMode.Companion, configuration.getVerificationMode(), r12, 2, r12);
            } catch (IllegalStateException e4) {
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error creating signature verifier: " + e4.getMessage() + ". Disabling signature verification.", r12);
                signatureVerificationModeFromEntitlementVerificationMode$default = SignatureVerificationMode.Disabled.INSTANCE;
            }
            SigningManager signingManager = new SigningManager(signatureVerificationModeFromEntitlementVerificationMode$default, appConfig, configuration.getApiKey());
            DeviceCache deviceCache2 = new DeviceCache(sharedPreferences, configuration.getApiKey(), null, 4, null);
            DefaultLocaleProvider defaultLocaleProvider = new DefaultLocaleProvider();
            DiagnosticsTracker diagnosticsTracker3 = diagnosticsTracker;
            HTTPClient hTTPClient = new HTTPClient(appConfig, eTagManager, diagnosticsTracker3, signingManager, deviceCache2, null, null, defaultLocaleProvider, 96, null);
            BackendHelper backendHelper = new BackendHelper(configuration.getApiKey(), dispatcher5, appConfig, hTTPClient);
            Backend backend2 = new Backend(appConfig, dispatcher5, dispatcher, hTTPClient, backendHelper);
            AppConfig appConfig3 = appConfig;
            Dispatcher dispatcher7 = dispatcher;
            PurchasesStateCache purchasesStateCache = new PurchasesStateCache(new PurchasesState(null, null, null, false, false, 31, null));
            if (billingAbstract == null) {
                dispatcher2 = dispatcher5;
                application = application2;
                deviceCache = deviceCache2;
                BillingAbstract billingAbstractCreateBilling = BillingFactory.INSTANCE.createBilling(store, application, backendHelper, deviceCache, PurchasesAreCompletedByKt.getFinishTransactions(configuration.getPurchasesAreCompletedBy()), diagnosticsTracker3, purchasesStateCache, configuration.getPendingTransactionsForPrepaidPlansEnabled(), backend2, validationResultValidateConfiguration);
                backendHelper = backendHelper;
                validationResultValidateConfiguration = validationResultValidateConfiguration;
                store = store;
                billingAbstract2 = billingAbstractCreateBilling;
            } else {
                dispatcher2 = dispatcher5;
                application = application2;
                deviceCache = deviceCache2;
                billingAbstract2 = billingAbstract;
            }
            SubscriberAttributesPoster subscriberAttributesPoster = new SubscriberAttributesPoster(backendHelper);
            DeviceIdentifiersFetcher deviceIdentifiersFetcherCreateAttributionFetcher = AttributionFetcherFactory.INSTANCE.createAttributionFetcher(configuration.getStore(), dispatcher2);
            SubscriberAttributesCache subscriberAttributesCache = new SubscriberAttributesCache(deviceCache);
            SubscriberAttributesManager subscriberAttributesManager = new SubscriberAttributesManager(subscriberAttributesCache, subscriberAttributesPoster, deviceIdentifiersFetcherCreateAttributionFetcher, configuration.getAutomaticDeviceIdentifierCollectionEnabled());
            BillingAbstract billingAbstract3 = billingAbstract2;
            DeviceCache deviceCache3 = deviceCache;
            OfflineEntitlementsManager offlineEntitlementsManager = new OfflineEntitlementsManager(backend2, new OfflineCustomerInfoCalculator(new PurchasedProductsFetcher(deviceCache, billingAbstract3, null, 4, null), appConfig3, diagnosticsTracker3, null, 8, null), deviceCache3, appConfig3, diagnosticsTracker3);
            OfferingsCache offeringsCache2 = new OfferingsCache(deviceCache3, null, null, defaultLocaleProvider, 6, null);
            Context context3 = context2;
            IdentityManager identityManager = new IdentityManager(deviceCache3, subscriberAttributesCache, subscriberAttributesManager, offeringsCache2, backend2, offlineEntitlementsManager, dispatcher4);
            CustomerInfoUpdateHandler customerInfoUpdateHandler = new CustomerInfoUpdateHandler(deviceCache3, identityManager, offlineEntitlementsManager, appConfig3, diagnosticsTracker3, null, 32, null);
            PaywallPresentedCache paywallPresentedCache = new PaywallPresentedCache();
            PostReceiptHelper postReceiptHelper2 = new PostReceiptHelper(appConfig3, backend2, billingAbstract3, customerInfoUpdateHandler, deviceCache3, subscriberAttributesManager, offlineEntitlementsManager, paywallPresentedCache);
            PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper = new PostTransactionWithProductDetailsHelper(billingAbstract3, postReceiptHelper2);
            PostPendingTransactionsHelper postPendingTransactionsHelper = new PostPendingTransactionsHelper(appConfig3, deviceCache3, billingAbstract3, dispatcher2, identityManager, postTransactionWithProductDetailsHelper);
            CustomerInfoHelper customerInfoHelper = new CustomerInfoHelper(deviceCache3, backend2, offlineEntitlementsManager, customerInfoUpdateHandler, postPendingTransactionsHelper, diagnosticsTracker3, null, null, 192, null);
            OfferingParser offeringParserCreateOfferingParser = OfferingParserFactory.INSTANCE.createOfferingParser(store, validationResultValidateConfiguration);
            if (diagnosticsFileHelper == null || diagnosticsHelper == null || diagnosticsTracker3 == null || !AndroidVersionUtilsKt.isAndroidNOrNewer()) {
                postReceiptHelper = postReceiptHelper2;
                diagnosticsTracker2 = diagnosticsTracker3;
                backend = backend2;
                dispatcher3 = dispatcher7;
                offeringsCache = offeringsCache2;
                diagnosticsSynchronizer = null;
            } else {
                DiagnosticsSynchronizer diagnosticsSynchronizer2 = new DiagnosticsSynchronizer(diagnosticsHelper, diagnosticsFileHelper, diagnosticsTracker3, backend2, dispatcher7);
                backend = backend2;
                dispatcher3 = dispatcher7;
                postReceiptHelper = postReceiptHelper2;
                diagnosticsTracker2 = diagnosticsTracker3;
                diagnosticsTracker2.setListener(diagnosticsSynchronizer2);
                diagnosticsSynchronizer = diagnosticsSynchronizer2;
                offeringsCache = offeringsCache2;
            }
            DiagnosticsTracker diagnosticsTracker4 = diagnosticsTracker2;
            SyncPurchasesHelper syncPurchasesHelper = new SyncPurchasesHelper(billingAbstract3, identityManager, customerInfoHelper, postReceiptHelper, diagnosticsTracker4, null, 32, null);
            PostReceiptHelper postReceiptHelper3 = postReceiptHelper;
            FontLoader fontLoader = new FontLoader(context3, null, null, null, 14, null);
            Backend backend3 = backend;
            OfferingsManager offeringsManager = new OfferingsManager(offeringsCache, backend3, new OfferingsFactory(billingAbstract3, offeringParserCreateOfferingParser, dispatcher4), new OfferingImagePreDownloader(false, new CoilImageDownloader(application), 1, null), diagnosticsTracker4, new OfferingFontPreDownloader(context3, fontLoader), null, 0 == true ? 1 : 0, 192, null);
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
            return new Purchases(new PurchasesOrchestrator(application, configuration.getAppUserID(), backend3, billingAbstract3, deviceCache3, identityManager, subscriberAttributesManager, appConfig3, customerInfoHelper, customerInfoUpdateHandler, diagnosticsSynchronizer, diagnosticsTracker4, null, offlineEntitlementsManager, postReceiptHelper3, postTransactionWithProductDetailsHelper, postPendingTransactionsHelper, syncPurchasesHelper, offeringsManager, createEventsManager(application, identityManager, dispatcher3, backend3), paywallPresentedCache, purchasesStateCache, null, dispatcher4, configuration, fontLoader, defaultLocaleProvider, null, new VirtualCurrencyManager(identityManager, deviceCache3, backend3, appConfig3), null, null, null, null, -398454784, 1, null));
        } catch (IllegalStateException e5) {
            if (m.a(configuration.getContext())) {
                throw e5;
            }
            throw new IllegalStateException("Trying to configure Purchases while the device is locked. If you need to support this scenario, ensure you *always* configure Purchases with a Context created with `createDeviceProtectedStorageContext()` to avoid undefined behavior.\nSee https://developer.android.com/reference/android/content/Context#createDeviceProtectedStorageContext() for more info.", e5);
        }
    }

    public final APIKeyValidator.ValidationResult validateConfiguration(PurchasesConfiguration configuration) throws PurchasesException {
        r.f(configuration, "configuration");
        if (!hasPermission(configuration.getContext(), "android.permission.INTERNET")) {
            throw new IllegalArgumentException("Purchases requires INTERNET permission.");
        }
        if (AbstractC1753A.U(configuration.getApiKey())) {
            throw new IllegalArgumentException("API key must be set. Get this from the RevenueCat web app");
        }
        APIKeyValidator.ValidationResult validationResultValidateAndLog = this.apiKeyValidator.validateAndLog(configuration.getApiKey(), configuration.getStore());
        if (!this.isDebugBuild.invoke() && validationResultValidateAndLog == APIKeyValidator.ValidationResult.SIMULATED_STORE && ((Boolean) this.isSimulatedStoreEnabled.invoke()).booleanValue()) {
            throw new PurchasesException(new PurchasesError(PurchasesErrorCode.ConfigurationError, "Please configure the Play Store/Amazon store app on the RevenueCat dashboard and use its corresponding API key before releasing."));
        }
        if (configuration.getContext().getApplicationContext() instanceof Application) {
            return validationResultValidateAndLog;
        }
        throw new IllegalArgumentException("Needs an application context.");
    }

    public /* synthetic */ PurchasesFactory(IsDebugBuildProvider isDebugBuildProvider, APIKeyValidator aPIKeyValidator, Function0 function0, int i4, AbstractC1585j abstractC1585j) {
        this(isDebugBuildProvider, (i4 & 2) != 0 ? new APIKeyValidator() : aPIKeyValidator, (i4 & 4) != 0 ? AnonymousClass1.INSTANCE : function0);
    }
}
