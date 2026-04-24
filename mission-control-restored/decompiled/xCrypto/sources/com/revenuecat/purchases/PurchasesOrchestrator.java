package com.revenuecat.purchases;

import H0.InterfaceC0313o;
import W2.E;
import W2.j;
import W2.t;
import X2.AbstractC0765l;
import X2.AbstractC0768o;
import X2.AbstractC0769p;
import X2.AbstractC0770q;
import X2.K;
import X2.L;
import X2.P;
import X2.Q;
import X2.S;
import X2.x;
import android.app.Activity;
import android.app.Application;
import android.app.backup.BackupManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import androidx.lifecycle.InterfaceC0850m;
import androidx.lifecycle.v;
import coil.ImageLoader;
import com.revenuecat.purchases.APIKeyValidator;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.blockstore.BlockstoreHelper;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.DefaultLocaleProvider;
import com.revenuecat.purchases.common.Delay;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.DurationExtensionsKt;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.PlatformInfo;
import com.revenuecat.purchases.common.ReceiptInfo;
import com.revenuecat.purchases.common.ReplaceProductInfo;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.common.events.EventsManager;
import com.revenuecat.purchases.common.events.FeatureEvent;
import com.revenuecat.purchases.common.offerings.OfferingsManager;
import com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager;
import com.revenuecat.purchases.common.subscriberattributes.SubscriberAttributeKey;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.customercenter.CustomerCenterListener;
import com.revenuecat.purchases.deeplinks.WebPurchaseRedemptionHelper;
import com.revenuecat.purchases.identity.IdentityManager;
import com.revenuecat.purchases.interfaces.Callback;
import com.revenuecat.purchases.interfaces.GetAmazonLWAConsentStatusCallback;
import com.revenuecat.purchases.interfaces.GetCustomerCenterConfigCallback;
import com.revenuecat.purchases.interfaces.GetStoreProductsCallback;
import com.revenuecat.purchases.interfaces.GetStorefrontCallback;
import com.revenuecat.purchases.interfaces.GetVirtualCurrenciesCallback;
import com.revenuecat.purchases.interfaces.LogInCallback;
import com.revenuecat.purchases.interfaces.ProductChangeCallback;
import com.revenuecat.purchases.interfaces.PurchaseCallback;
import com.revenuecat.purchases.interfaces.PurchaseErrorCallback;
import com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback;
import com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback;
import com.revenuecat.purchases.interfaces.RedeemWebPurchaseListener;
import com.revenuecat.purchases.interfaces.SyncAttributesAndOfferingsCallback;
import com.revenuecat.purchases.interfaces.SyncPurchasesCallback;
import com.revenuecat.purchases.interfaces.UpdatedCustomerInfoListener;
import com.revenuecat.purchases.models.BillingFeature;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import com.revenuecat.purchases.models.InAppMessageType;
import com.revenuecat.purchases.models.PurchasingData;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.paywalls.DownloadedFontFamily;
import com.revenuecat.purchases.paywalls.FontLoader;
import com.revenuecat.purchases.paywalls.PaywallPresentedCache;
import com.revenuecat.purchases.paywalls.events.PaywallEvent;
import com.revenuecat.purchases.strings.IdentityStrings;
import com.revenuecat.purchases.strings.PurchaseStrings;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager;
import com.revenuecat.purchases.utils.AndroidVersionUtilsKt;
import com.revenuecat.purchases.utils.CustomActivityLifecycleHandler;
import com.revenuecat.purchases.utils.RateLimiter;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencyManager;
import i3.k;
import i3.o;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.D;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import r3.AbstractC1753A;
import s3.C1779a;

/* JADX INFO: loaded from: classes.dex */
public final class PurchasesOrchestrator implements LifecycleDelegate, CustomActivityLifecycleHandler {
    private static ImageLoader cachedImageLoader = null;
    public static final String frameworkVersion = "8.24.0";
    private static URL proxyURL;
    private volatile String _preferredUILocaleOverride;
    private AppConfig appConfig;
    private final Application application;
    private final Backend backend;
    private final BackupManager backupManager;
    private final BillingAbstract billing;
    private final BlockstoreHelper blockstoreHelper;
    private CustomerCenterListener customerCenterListener;
    private final CustomerInfoHelper customerInfoHelper;
    private final CustomerInfoUpdateHandler customerInfoUpdateHandler;
    private final DateProvider dateProvider;
    private final DeviceCache deviceCache;
    private final DiagnosticsSynchronizer diagnosticsSynchronizer;
    private final DiagnosticsTracker diagnosticsTrackerIfEnabled;
    private final Dispatcher dispatcher;
    private final EventsManager eventsManager;
    private final FontLoader fontLoader;
    private final IdentityManager identityManager;
    private final PurchasesConfiguration initialConfiguration;
    private final Function0 isSimulatedStoreEnabled;
    private final RateLimiter lastSyncAttributesAndOfferingsRateLimiter;
    private final j lifecycleHandler$delegate;
    private final DefaultLocaleProvider localeProvider;
    private final Handler mainHandler;
    private final OfferingsManager offeringsManager;
    private final OfflineEntitlementsManager offlineEntitlementsManager;
    private final PaywallPresentedCache paywallPresentedCache;
    private final PostPendingTransactionsHelper postPendingTransactionsHelper;
    private final PostReceiptHelper postReceiptHelper;
    private final PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper;
    private final RateLimiter preferredLocaleOverrideRateLimiter;
    private final Function0 processLifecycleOwnerProvider;
    private final PurchasesStateCache purchasesStateCache;
    private String storefrontCountryCode;
    private final SubscriberAttributesManager subscriberAttributesManager;
    private final SyncPurchasesHelper syncPurchasesHelper;
    private final VirtualCurrencyManager virtualCurrencyManager;
    private final WebPurchaseRedemptionHelper webPurchaseRedemptionHelper;
    public static final Companion Companion = new Companion(null);
    private static PlatformInfo platformInfo = new PlatformInfo("native", null);

    /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements Function0 {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final InterfaceC0850m invoke() {
            InterfaceC0850m interfaceC0850mL = v.l();
            r.e(interfaceC0850mL, "get()");
            return interfaceC0850mL;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$2, reason: invalid class name */
    public static final class AnonymousClass2 extends s implements Function0 {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$4, reason: invalid class name */
    public static final class AnonymousClass4 extends s implements Function0 {
        public AnonymousClass4() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m72invoke();
            return E.f5463a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m72invoke() {
            ((InterfaceC0850m) PurchasesOrchestrator.this.getProcessLifecycleOwnerProvider().invoke()).getLifecycle().a(PurchasesOrchestrator.this.getLifecycleHandler());
            PurchasesOrchestrator.this.application.registerActivityLifecycleCallbacks(PurchasesOrchestrator.this);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void canMakePayments$default(Companion companion, Context context, List list, Callback callback, int i4, Object obj) {
            if ((i4 & 2) != 0) {
                list = AbstractC0769p.g();
            }
            companion.canMakePayments(context, list, callback);
        }

        public final void canMakePayments(Context context, List<? extends BillingFeature> features, Callback<Boolean> callback) {
            r.f(context, "context");
            r.f(features, "features");
            r.f(callback, "callback");
            com.android.billingclient.api.a aVarA = com.android.billingclient.api.a.h(context).b().d(new InterfaceC0313o() { // from class: com.revenuecat.purchases.g
                @Override // H0.InterfaceC0313o
                public final void onPurchasesUpdated(com.android.billingclient.api.d dVar, List list) {
                    r.f(dVar, "<anonymous parameter 0>");
                }
            }).a();
            aVarA.m(new PurchasesOrchestrator$Companion$canMakePayments$2$1(new Handler(context.getMainLooper()), new AtomicBoolean(false), callback, aVarA, features));
        }

        public final boolean getDebugLogsEnabled() {
            return LogUtilsKt.getDebugLogsEnabled(getLogLevel());
        }

        public final synchronized ImageLoader getImageLoader(Context context) {
            ImageLoader imageLoaderBuild;
            r.f(context, "context");
            imageLoaderBuild = PurchasesOrchestrator.cachedImageLoader;
            if (imageLoaderBuild == null) {
                imageLoaderBuild = new ImageLoader.Builder(context).diskCache(new PurchasesOrchestrator$Companion$getImageLoader$imageLoader$1(context, "revenuecatui_cache", 26214400L)).build();
                PurchasesOrchestrator.cachedImageLoader = imageLoaderBuild;
            }
            return imageLoaderBuild;
        }

        public final synchronized LogHandler getLogHandler() {
            return LogWrapperKt.getCurrentLogHandler();
        }

        public final LogLevel getLogLevel() {
            return Config.INSTANCE.getLogLevel();
        }

        public final PlatformInfo getPlatformInfo() {
            return PurchasesOrchestrator.platformInfo;
        }

        public final URL getProxyURL() {
            return PurchasesOrchestrator.proxyURL;
        }

        public final void setDebugLogsEnabled(boolean z4) {
            setLogLevel(LogUtilsKt.debugLogsEnabled(LogLevel.Companion, z4));
        }

        public final synchronized void setLogHandler(LogHandler value) {
            r.f(value, "value");
            LogWrapperKt.setCurrentLogHandler(value);
        }

        public final void setLogLevel(LogLevel value) {
            r.f(value, "value");
            Config.INSTANCE.setLogLevel(value);
        }

        public final void setPlatformInfo(PlatformInfo platformInfo) {
            r.f(platformInfo, "<set-?>");
            PurchasesOrchestrator.platformInfo = platformInfo;
        }

        public final void setProxyURL(URL url) {
            PurchasesOrchestrator.proxyURL = url;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$close$2, reason: invalid class name and case insensitive filesystem */
    public static final class C11022 extends s implements Function0 {
        public C11022() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m73invoke();
            return E.f5463a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m73invoke() {
            ((InterfaceC0850m) PurchasesOrchestrator.this.getProcessLifecycleOwnerProvider().invoke()).getLifecycle().c(PurchasesOrchestrator.this.getLifecycleHandler());
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$dispatch$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11041 extends s implements Function0 {
        final /* synthetic */ PurchasesError $error;
        final /* synthetic */ PurchaseErrorCallback $this_dispatch;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11041(PurchaseErrorCallback purchaseErrorCallback, PurchasesError purchasesError) {
            super(0);
            this.$this_dispatch = purchaseErrorCallback;
            this.$error = purchasesError;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m74invoke();
            return E.f5463a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m74invoke() {
            PurchaseErrorCallback purchaseErrorCallback = this.$this_dispatch;
            PurchasesError purchasesError = this.$error;
            purchaseErrorCallback.onError(purchasesError, purchasesError.getCode() == PurchasesErrorCode.PurchaseCancelledError);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$getAmazonLWAConsentStatus$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11061 extends s implements k {
        final /* synthetic */ GetAmazonLWAConsentStatusCallback $callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11061(GetAmazonLWAConsentStatusCallback getAmazonLWAConsentStatusCallback) {
            super(1);
            this.$callback = getAmazonLWAConsentStatusCallback;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((AmazonLWAConsentStatus) obj);
            return E.f5463a;
        }

        public final void invoke(AmazonLWAConsentStatus it) {
            r.f(it, "it");
            this.$callback.onSuccess(it);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$getAmazonLWAConsentStatus$2, reason: invalid class name and case insensitive filesystem */
    public static final class C11072 extends s implements k {
        final /* synthetic */ GetAmazonLWAConsentStatusCallback $callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11072(GetAmazonLWAConsentStatusCallback getAmazonLWAConsentStatusCallback) {
            super(1);
            this.$callback = getAmazonLWAConsentStatusCallback;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError it) {
            r.f(it, "it");
            this.$callback.onError(it);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$getCustomerCenterConfig$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11081 extends s implements k {
        final /* synthetic */ GetCustomerCenterConfigCallback $callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11081(GetCustomerCenterConfigCallback getCustomerCenterConfigCallback) {
            super(1);
            this.$callback = getCustomerCenterConfigCallback;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CustomerCenterConfigData) obj);
            return E.f5463a;
        }

        public final void invoke(CustomerCenterConfigData config) {
            r.f(config, "config");
            this.$callback.onSuccess(config);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$getCustomerCenterConfig$2, reason: invalid class name and case insensitive filesystem */
    public static final class C11092 extends s implements k {
        final /* synthetic */ GetCustomerCenterConfigCallback $callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11092(GetCustomerCenterConfigCallback getCustomerCenterConfigCallback) {
            super(1);
            this.$callback = getCustomerCenterConfigCallback;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError error) {
            r.f(error, "error");
            this.$callback.onError(error);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$getOfferings$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11101 extends s implements k {
        final /* synthetic */ ReceiveOfferingsCallback $listener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11101(ReceiveOfferingsCallback receiveOfferingsCallback) {
            super(1);
            this.$listener = receiveOfferingsCallback;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError it) {
            r.f(it, "it");
            this.$listener.onError(it);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$getOfferings$2, reason: invalid class name and case insensitive filesystem */
    public static final class C11112 extends s implements k {
        final /* synthetic */ ReceiveOfferingsCallback $listener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11112(ReceiveOfferingsCallback receiveOfferingsCallback) {
            super(1);
            this.$listener = receiveOfferingsCallback;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Offerings) obj);
            return E.f5463a;
        }

        public final void invoke(Offerings it) {
            r.f(it, "it");
            this.$listener.onReceived(it);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$logIn$3, reason: invalid class name and case insensitive filesystem */
    public static final class C11143 extends s implements k {
        final /* synthetic */ LogInCallback $callback;

        /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$logIn$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends s implements Function0 {
            final /* synthetic */ LogInCallback $callback;
            final /* synthetic */ CustomerInfo $customerInfo;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(LogInCallback logInCallback, CustomerInfo customerInfo) {
                super(0);
                this.$callback = logInCallback;
                this.$customerInfo = customerInfo;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m83invoke();
                return E.f5463a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m83invoke() {
                LogInCallback logInCallback = this.$callback;
                if (logInCallback != null) {
                    logInCallback.onReceived(this.$customerInfo, false);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11143(LogInCallback logInCallback) {
            super(1);
            this.$callback = logInCallback;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CustomerInfo) obj);
            return E.f5463a;
        }

        public final void invoke(CustomerInfo customerInfo) {
            r.f(customerInfo, "customerInfo");
            PurchasesOrchestrator.this.dispatch(new AnonymousClass1(this.$callback, customerInfo));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$logIn$4, reason: invalid class name and case insensitive filesystem */
    public static final class C11154 extends s implements k {
        final /* synthetic */ LogInCallback $callback;

        /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$logIn$4$1, reason: invalid class name */
        public static final class AnonymousClass1 extends s implements Function0 {
            final /* synthetic */ LogInCallback $callback;
            final /* synthetic */ PurchasesError $error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(LogInCallback logInCallback, PurchasesError purchasesError) {
                super(0);
                this.$callback = logInCallback;
                this.$error = purchasesError;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m84invoke();
                return E.f5463a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m84invoke() {
                LogInCallback logInCallback = this.$callback;
                if (logInCallback != null) {
                    logInCallback.onError(this.$error);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11154(LogInCallback logInCallback) {
            super(1);
            this.$callback = logInCallback;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError error) {
            r.f(error, "error");
            PurchasesOrchestrator.this.dispatch(new AnonymousClass1(this.$callback, error));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$logOut$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11161 extends s implements k {
        final /* synthetic */ ReceiveCustomerInfoCallback $callback;
        final /* synthetic */ PurchasesOrchestrator this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11161(ReceiveCustomerInfoCallback receiveCustomerInfoCallback, PurchasesOrchestrator purchasesOrchestrator) {
            super(1);
            this.$callback = receiveCustomerInfoCallback;
            this.this$0 = purchasesOrchestrator;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError purchasesError) {
            if (purchasesError != null) {
                ReceiveCustomerInfoCallback receiveCustomerInfoCallback = this.$callback;
                if (receiveCustomerInfoCallback != null) {
                    receiveCustomerInfoCallback.onError(purchasesError);
                    return;
                }
                return;
            }
            PurchasesOrchestrator purchasesOrchestrator = this.this$0;
            synchronized (purchasesOrchestrator) {
                PurchasesState state$purchases_defaultsRelease = purchasesOrchestrator.getState$purchases_defaultsRelease();
                Map map = Collections.EMPTY_MAP;
                r.e(map, "emptyMap()");
                purchasesOrchestrator.setState$purchases_defaultsRelease(PurchasesState.copy$default(state$purchases_defaultsRelease, null, map, null, false, false, 29, null));
                E e4 = E.f5463a;
            }
            PurchasesOrchestrator purchasesOrchestrator2 = this.this$0;
            purchasesOrchestrator2.updateAllCaches(purchasesOrchestrator2.identityManager.getCurrentAppUserID(), this.$callback);
            this.this$0.backupManager.dataChanged();
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$onAppForegrounded$3, reason: invalid class name and case insensitive filesystem */
    public static final class C11173 extends s implements Function0 {
        final /* synthetic */ D $firstTimeInForeground;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11173(D d4) {
            super(0);
            this.$firstTimeInForeground = d4;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m85invoke();
            return E.f5463a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m85invoke() {
            DiagnosticsSynchronizer diagnosticsSynchronizer;
            LogHandler currentLogHandler;
            String str;
            String str2;
            if (PurchasesOrchestrator.this.shouldRefreshCustomerInfo(this.$firstTimeInForeground.f13408a)) {
                LogIntent logIntent = LogIntent.DEBUG;
                PurchasesOrchestrator$onAppForegrounded$3$invoke$$inlined$log$1 purchasesOrchestrator$onAppForegrounded$3$invoke$$inlined$log$1 = new PurchasesOrchestrator$onAppForegrounded$3$invoke$$inlined$log$1(logIntent);
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                    case 1:
                        LogLevel logLevel = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            str = "[Purchases] - " + logLevel.name();
                            str2 = (String) purchasesOrchestrator$onAppForegrounded$3$invoke$$inlined$log$1.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$onAppForegrounded$3$invoke$$inlined$log$1.invoke(), null);
                        break;
                    case 3:
                        LogLevel logLevel2 = LogLevel.WARN;
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$onAppForegrounded$3$invoke$$inlined$log$1.invoke());
                        }
                        break;
                    case 4:
                        LogLevel logLevel3 = LogLevel.INFO;
                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$onAppForegrounded$3$invoke$$inlined$log$1.invoke());
                        }
                        break;
                    case 5:
                        LogLevel logLevel4 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            str = "[Purchases] - " + logLevel4.name();
                            str2 = (String) purchasesOrchestrator$onAppForegrounded$3$invoke$$inlined$log$1.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$onAppForegrounded$3$invoke$$inlined$log$1.invoke(), null);
                        break;
                    case 7:
                        LogLevel logLevel5 = LogLevel.INFO;
                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                            currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$onAppForegrounded$3$invoke$$inlined$log$1.invoke());
                        }
                        break;
                    case 8:
                        LogLevel logLevel6 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                            str = "[Purchases] - " + logLevel6.name();
                            str2 = (String) purchasesOrchestrator$onAppForegrounded$3$invoke$$inlined$log$1.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 9:
                        LogLevel logLevel7 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                            str = "[Purchases] - " + logLevel7.name();
                            str2 = (String) purchasesOrchestrator$onAppForegrounded$3$invoke$$inlined$log$1.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 10:
                        LogLevel logLevel8 = LogLevel.WARN;
                        LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                            currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$onAppForegrounded$3$invoke$$inlined$log$1.invoke());
                        }
                        break;
                    case 11:
                        LogLevel logLevel9 = LogLevel.WARN;
                        LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                            currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$onAppForegrounded$3$invoke$$inlined$log$1.invoke());
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$onAppForegrounded$3$invoke$$inlined$log$1.invoke(), null);
                        break;
                }
                CustomerInfoHelper customerInfoHelper = PurchasesOrchestrator.this.customerInfoHelper;
                String currentAppUserID = PurchasesOrchestrator.this.identityManager.getCurrentAppUserID();
                CacheFetchPolicy cacheFetchPolicy = CacheFetchPolicy.FETCH_CURRENT;
                boolean allowSharingPlayStoreAccount = PurchasesOrchestrator.this.getAllowSharingPlayStoreAccount();
                final PurchasesOrchestrator purchasesOrchestrator = PurchasesOrchestrator.this;
                CustomerInfoHelper.retrieveCustomerInfo$default(customerInfoHelper, currentAppUserID, cacheFetchPolicy, false, allowSharingPlayStoreAccount, false, new ReceiveCustomerInfoCallback() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.onAppForegrounded.3.2
                    @Override // com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
                    public void onError(PurchasesError error) {
                        r.f(error, "error");
                    }

                    @Override // com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
                    public void onReceived(CustomerInfo customerInfo) {
                        r.f(customerInfo, "customerInfo");
                        purchasesOrchestrator.blockstoreHelper.storeUserIdIfNeeded(customerInfo);
                    }
                }, 16, null);
            }
            PurchasesOrchestrator.this.offeringsManager.onAppForeground(PurchasesOrchestrator.this.identityManager.getCurrentAppUserID());
            PostPendingTransactionsHelper.syncPendingPurchaseQueue$default(PurchasesOrchestrator.this.postPendingTransactionsHelper, PurchasesOrchestrator.this.getAllowSharingPlayStoreAccount(), null, 2, null);
            PurchasesOrchestrator.this.synchronizeSubscriberAttributesIfNeeded();
            OfflineEntitlementsManager.updateProductEntitlementMappingCacheIfStale$default(PurchasesOrchestrator.this.getOfflineEntitlementsManager(), null, 1, null);
            PurchasesOrchestrator.this.flushPaywallEvents();
            if (this.$firstTimeInForeground.f13408a && AndroidVersionUtilsKt.isAndroidNOrNewer() && (diagnosticsSynchronizer = PurchasesOrchestrator.this.diagnosticsSynchronizer) != null) {
                diagnosticsSynchronizer.syncDiagnosticsFileIfNeeded();
            }
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$overridePreferredUILocale$4, reason: invalid class name and case insensitive filesystem */
    public static final class C11184 extends s implements o {
        public static final C11184 INSTANCE = new C11184();

        public C11184() {
            super(2);
        }

        @Override // i3.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Offerings) obj, (PurchasesError) obj2);
            return E.f5463a;
        }

        public final void invoke(Offerings offerings, PurchasesError purchasesError) {
            if (offerings != null) {
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), "Fresh offerings fetch completed successfully");
                    return;
                }
                return;
            }
            LogLevel logLevel2 = LogLevel.DEBUG;
            LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                String str = "[Purchases] - " + logLevel2.name();
                StringBuilder sb = new StringBuilder();
                sb.append("Fresh offerings fetch failed: ");
                sb.append(purchasesError != null ? purchasesError.getMessage() : null);
                currentLogHandler2.d(str, sb.toString());
            }
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$replaceOldPurchaseWithNewProduct$3, reason: invalid class name and case insensitive filesystem */
    public static final class C11193 extends s implements k {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ String $appUserID;
        final /* synthetic */ GoogleReplacementMode $googleReplacementMode;
        final /* synthetic */ Boolean $isPersonalizedPrice;
        final /* synthetic */ PresentedOfferingContext $presentedOfferingContext;
        final /* synthetic */ F $previousProductId;
        final /* synthetic */ PurchasingData $purchasingData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11193(Activity activity, String str, PurchasingData purchasingData, GoogleReplacementMode googleReplacementMode, PresentedOfferingContext presentedOfferingContext, Boolean bool, F f4) {
            super(1);
            this.$activity = activity;
            this.$appUserID = str;
            this.$purchasingData = purchasingData;
            this.$googleReplacementMode = googleReplacementMode;
            this.$presentedOfferingContext = presentedOfferingContext;
            this.$isPersonalizedPrice = bool;
            this.$previousProductId = f4;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((StoreTransaction) obj);
            return E.f5463a;
        }

        public final void invoke(StoreTransaction purchaseRecord) {
            LogHandler currentLogHandler;
            String str;
            String str2;
            r.f(purchaseRecord, "purchaseRecord");
            LogIntent logIntent = LogIntent.PURCHASE;
            PurchasesOrchestrator$replaceOldPurchaseWithNewProduct$3$invoke$$inlined$log$1 purchasesOrchestrator$replaceOldPurchaseWithNewProduct$3$invoke$$inlined$log$1 = new PurchasesOrchestrator$replaceOldPurchaseWithNewProduct$3$invoke$$inlined$log$1(logIntent, this.$previousProductId);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        str = "[Purchases] - " + logLevel.name();
                        str2 = (String) purchasesOrchestrator$replaceOldPurchaseWithNewProduct$3$invoke$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$replaceOldPurchaseWithNewProduct$3$invoke$$inlined$log$1.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$replaceOldPurchaseWithNewProduct$3$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$replaceOldPurchaseWithNewProduct$3$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        str = "[Purchases] - " + logLevel4.name();
                        str2 = (String) purchasesOrchestrator$replaceOldPurchaseWithNewProduct$3$invoke$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$replaceOldPurchaseWithNewProduct$3$invoke$$inlined$log$1.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$replaceOldPurchaseWithNewProduct$3$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        str = "[Purchases] - " + logLevel6.name();
                        str2 = (String) purchasesOrchestrator$replaceOldPurchaseWithNewProduct$3$invoke$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        str = "[Purchases] - " + logLevel7.name();
                        str2 = (String) purchasesOrchestrator$replaceOldPurchaseWithNewProduct$3$invoke$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$replaceOldPurchaseWithNewProduct$3$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$replaceOldPurchaseWithNewProduct$3$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$replaceOldPurchaseWithNewProduct$3$invoke$$inlined$log$1.invoke(), null);
                    break;
            }
            PurchasesOrchestrator.this.billing.makePurchaseAsync(this.$activity, this.$appUserID, this.$purchasingData, new ReplaceProductInfo(purchaseRecord, this.$googleReplacementMode), this.$presentedOfferingContext, this.$isPersonalizedPrice);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$replaceOldPurchaseWithNewProduct$4, reason: invalid class name and case insensitive filesystem */
    public static final class C11204 extends s implements k {
        final /* synthetic */ PurchaseErrorCallback $listener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11204(PurchaseErrorCallback purchaseErrorCallback) {
            super(1);
            this.$listener = purchaseErrorCallback;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError error) {
            LogHandler currentLogHandler;
            String str;
            String str2;
            r.f(error, "error");
            LogIntent logIntent = LogIntent.GOOGLE_ERROR;
            PurchasesOrchestrator$replaceOldPurchaseWithNewProduct$4$invoke$$inlined$log$1 purchasesOrchestrator$replaceOldPurchaseWithNewProduct$4$invoke$$inlined$log$1 = new PurchasesOrchestrator$replaceOldPurchaseWithNewProduct$4$invoke$$inlined$log$1(logIntent, error);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        str = "[Purchases] - " + logLevel.name();
                        str2 = (String) purchasesOrchestrator$replaceOldPurchaseWithNewProduct$4$invoke$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$replaceOldPurchaseWithNewProduct$4$invoke$$inlined$log$1.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$replaceOldPurchaseWithNewProduct$4$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$replaceOldPurchaseWithNewProduct$4$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        str = "[Purchases] - " + logLevel4.name();
                        str2 = (String) purchasesOrchestrator$replaceOldPurchaseWithNewProduct$4$invoke$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$replaceOldPurchaseWithNewProduct$4$invoke$$inlined$log$1.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$replaceOldPurchaseWithNewProduct$4$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        str = "[Purchases] - " + logLevel6.name();
                        str2 = (String) purchasesOrchestrator$replaceOldPurchaseWithNewProduct$4$invoke$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        str = "[Purchases] - " + logLevel7.name();
                        str2 = (String) purchasesOrchestrator$replaceOldPurchaseWithNewProduct$4$invoke$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$replaceOldPurchaseWithNewProduct$4$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$replaceOldPurchaseWithNewProduct$4$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$replaceOldPurchaseWithNewProduct$4$invoke$$inlined$log$1.invoke(), null);
                    break;
            }
            PurchasesOrchestrator.this.getAndClearProductChangeCallback();
            PurchasesOrchestrator.this.getAndClearAllPurchaseCallbacks();
            PurchasesOrchestrator.this.dispatch(this.$listener, error);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$4, reason: invalid class name and case insensitive filesystem */
    public static final class C11214 extends s implements Function0 {
        final /* synthetic */ String $appUserID;
        final /* synthetic */ ReceiveCustomerInfoCallback $callbackWithTracking;

        /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$4$1, reason: invalid class name */
        public static final class AnonymousClass1 extends s implements k {
            final /* synthetic */ String $appUserID;
            final /* synthetic */ ReceiveCustomerInfoCallback $callbackWithTracking;
            final /* synthetic */ PurchasesOrchestrator this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(PurchasesOrchestrator purchasesOrchestrator, ReceiveCustomerInfoCallback receiveCustomerInfoCallback, String str) {
                super(1);
                this.this$0 = purchasesOrchestrator;
                this.$callbackWithTracking = receiveCustomerInfoCallback;
                this.$appUserID = str;
            }

            @Override // i3.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<StoreTransaction>) obj);
                return E.f5463a;
            }

            public final void invoke(List<StoreTransaction> allPurchases) {
                LogHandler currentLogHandler;
                String str;
                String str2;
                r.f(allPurchases, "allPurchases");
                if (!allPurchases.isEmpty()) {
                    List<StoreTransaction> listZ = x.Z(allPurchases, new Comparator() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$4$1$invoke$$inlined$sortedBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t4, T t5) {
                            return Y2.a.a(Long.valueOf(((StoreTransaction) t4).getPurchaseTime()), Long.valueOf(((StoreTransaction) t5).getPurchaseTime()));
                        }
                    });
                    PurchasesOrchestrator purchasesOrchestrator = this.this$0;
                    String str3 = this.$appUserID;
                    ReceiveCustomerInfoCallback receiveCustomerInfoCallback = this.$callbackWithTracking;
                    for (StoreTransaction storeTransaction : listZ) {
                        purchasesOrchestrator.postReceiptHelper.postTransactionAndConsumeIfNeeded(storeTransaction, null, true, str3, PostReceiptInitiationSource.RESTORE, new PurchasesOrchestrator$restorePurchases$4$1$3$1$1(listZ, storeTransaction, purchasesOrchestrator, receiveCustomerInfoCallback), new PurchasesOrchestrator$restorePurchases$4$1$3$1$2(listZ, storeTransaction, purchasesOrchestrator, receiveCustomerInfoCallback));
                    }
                    return;
                }
                LogIntent logIntent = LogIntent.DEBUG;
                PurchasesOrchestrator$restorePurchases$4$1$invoke$$inlined$log$1 purchasesOrchestrator$restorePurchases$4$1$invoke$$inlined$log$1 = new PurchasesOrchestrator$restorePurchases$4$1$invoke$$inlined$log$1(logIntent);
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                    case 1:
                        LogLevel logLevel = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            str = "[Purchases] - " + logLevel.name();
                            str2 = (String) purchasesOrchestrator$restorePurchases$4$1$invoke$$inlined$log$1.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$restorePurchases$4$1$invoke$$inlined$log$1.invoke(), null);
                        break;
                    case 3:
                        LogLevel logLevel2 = LogLevel.WARN;
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$restorePurchases$4$1$invoke$$inlined$log$1.invoke());
                        }
                        break;
                    case 4:
                        LogLevel logLevel3 = LogLevel.INFO;
                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$restorePurchases$4$1$invoke$$inlined$log$1.invoke());
                        }
                        break;
                    case 5:
                        LogLevel logLevel4 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            str = "[Purchases] - " + logLevel4.name();
                            str2 = (String) purchasesOrchestrator$restorePurchases$4$1$invoke$$inlined$log$1.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$restorePurchases$4$1$invoke$$inlined$log$1.invoke(), null);
                        break;
                    case 7:
                        LogLevel logLevel5 = LogLevel.INFO;
                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                            currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$restorePurchases$4$1$invoke$$inlined$log$1.invoke());
                        }
                        break;
                    case 8:
                        LogLevel logLevel6 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                            str = "[Purchases] - " + logLevel6.name();
                            str2 = (String) purchasesOrchestrator$restorePurchases$4$1$invoke$$inlined$log$1.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 9:
                        LogLevel logLevel7 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                            str = "[Purchases] - " + logLevel7.name();
                            str2 = (String) purchasesOrchestrator$restorePurchases$4$1$invoke$$inlined$log$1.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 10:
                        LogLevel logLevel8 = LogLevel.WARN;
                        LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                            currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$restorePurchases$4$1$invoke$$inlined$log$1.invoke());
                        }
                        break;
                    case 11:
                        LogLevel logLevel9 = LogLevel.WARN;
                        LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                            currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$restorePurchases$4$1$invoke$$inlined$log$1.invoke());
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$restorePurchases$4$1$invoke$$inlined$log$1.invoke(), null);
                        break;
                }
                this.this$0.getCustomerInfo(this.$callbackWithTracking);
            }
        }

        /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$4$2, reason: invalid class name */
        public static final class AnonymousClass2 extends s implements k {
            final /* synthetic */ ReceiveCustomerInfoCallback $callbackWithTracking;
            final /* synthetic */ PurchasesOrchestrator this$0;

            /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$4$2$1, reason: invalid class name */
            public static final class AnonymousClass1 extends s implements Function0 {
                final /* synthetic */ ReceiveCustomerInfoCallback $callbackWithTracking;
                final /* synthetic */ PurchasesError $error;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(ReceiveCustomerInfoCallback receiveCustomerInfoCallback, PurchasesError purchasesError) {
                    super(0);
                    this.$callbackWithTracking = receiveCustomerInfoCallback;
                    this.$error = purchasesError;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m89invoke();
                    return E.f5463a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m89invoke() {
                    this.$callbackWithTracking.onError(this.$error);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(PurchasesOrchestrator purchasesOrchestrator, ReceiveCustomerInfoCallback receiveCustomerInfoCallback) {
                super(1);
                this.this$0 = purchasesOrchestrator;
                this.$callbackWithTracking = receiveCustomerInfoCallback;
            }

            @Override // i3.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PurchasesError) obj);
                return E.f5463a;
            }

            public final void invoke(PurchasesError error) {
                r.f(error, "error");
                this.this$0.dispatch(new AnonymousClass1(this.$callbackWithTracking, error));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11214(String str, ReceiveCustomerInfoCallback receiveCustomerInfoCallback) {
            super(0);
            this.$appUserID = str;
            this.$callbackWithTracking = receiveCustomerInfoCallback;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m86invoke();
            return E.f5463a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m86invoke() {
            BillingAbstract billingAbstract = PurchasesOrchestrator.this.billing;
            String str = this.$appUserID;
            billingAbstract.queryAllPurchases(str, new AnonymousClass1(PurchasesOrchestrator.this, this.$callbackWithTracking, str), new AnonymousClass2(PurchasesOrchestrator.this, this.$callbackWithTracking));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$showInAppMessagesIfNeeded$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11221 extends s implements Function0 {
        public C11221() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m90invoke();
            return E.f5463a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m90invoke() {
            PurchasesOrchestrator.syncPurchases$default(PurchasesOrchestrator.this, null, 1, null);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$syncAmazonPurchase$4, reason: invalid class name and case insensitive filesystem */
    public static final class C11234 extends s implements k {
        final /* synthetic */ String $amazonUserID;
        final /* synthetic */ String $appUserID;
        final /* synthetic */ String $isoCurrencyCode;
        final /* synthetic */ Double $price;
        final /* synthetic */ String $receiptID;
        final /* synthetic */ PurchasesOrchestrator this$0;

        /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$syncAmazonPurchase$4$1, reason: invalid class name */
        public static final class AnonymousClass1 extends s implements k {
            final /* synthetic */ String $amazonUserID;
            final /* synthetic */ String $receiptID;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(String str, String str2) {
                super(1);
                this.$receiptID = str;
                this.$amazonUserID = str2;
            }

            @Override // i3.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((CustomerInfo) obj);
                return E.f5463a;
            }

            public final void invoke(CustomerInfo it) {
                r.f(it, "it");
                LogIntent logIntent = LogIntent.PURCHASE;
                PurchasesOrchestrator$syncAmazonPurchase$4$1$invoke$$inlined$log$1 purchasesOrchestrator$syncAmazonPurchase$4$1$invoke$$inlined$log$1 = new PurchasesOrchestrator$syncAmazonPurchase$4$1$invoke$$inlined$log$1(logIntent, this.$receiptID, this.$amazonUserID);
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                    case 1:
                        LogLevel logLevel = LogLevel.DEBUG;
                        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            currentLogHandler.d("[Purchases] - " + logLevel.name(), (String) purchasesOrchestrator$syncAmazonPurchase$4$1$invoke$$inlined$log$1.invoke());
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$syncAmazonPurchase$4$1$invoke$$inlined$log$1.invoke(), null);
                        break;
                    case 3:
                        LogLevel logLevel2 = LogLevel.WARN;
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$syncAmazonPurchase$4$1$invoke$$inlined$log$1.invoke());
                        }
                        break;
                    case 4:
                        LogLevel logLevel3 = LogLevel.INFO;
                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$syncAmazonPurchase$4$1$invoke$$inlined$log$1.invoke());
                        }
                        break;
                    case 5:
                        LogLevel logLevel4 = LogLevel.DEBUG;
                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            currentLogHandler4.d("[Purchases] - " + logLevel4.name(), (String) purchasesOrchestrator$syncAmazonPurchase$4$1$invoke$$inlined$log$1.invoke());
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$syncAmazonPurchase$4$1$invoke$$inlined$log$1.invoke(), null);
                        break;
                    case 7:
                        LogLevel logLevel5 = LogLevel.INFO;
                        LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                            currentLogHandler5.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$syncAmazonPurchase$4$1$invoke$$inlined$log$1.invoke());
                        }
                        break;
                    case 8:
                        LogLevel logLevel6 = LogLevel.DEBUG;
                        LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                            currentLogHandler6.d("[Purchases] - " + logLevel6.name(), (String) purchasesOrchestrator$syncAmazonPurchase$4$1$invoke$$inlined$log$1.invoke());
                        }
                        break;
                    case 9:
                        LogLevel logLevel7 = LogLevel.DEBUG;
                        LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                            currentLogHandler7.d("[Purchases] - " + logLevel7.name(), (String) purchasesOrchestrator$syncAmazonPurchase$4$1$invoke$$inlined$log$1.invoke());
                        }
                        break;
                    case 10:
                        LogLevel logLevel8 = LogLevel.WARN;
                        LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                            currentLogHandler8.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$syncAmazonPurchase$4$1$invoke$$inlined$log$1.invoke());
                        }
                        break;
                    case 11:
                        LogLevel logLevel9 = LogLevel.WARN;
                        LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                            currentLogHandler9.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$syncAmazonPurchase$4$1$invoke$$inlined$log$1.invoke());
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$syncAmazonPurchase$4$1$invoke$$inlined$log$1.invoke(), null);
                        break;
                }
            }
        }

        /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$syncAmazonPurchase$4$2, reason: invalid class name */
        public static final class AnonymousClass2 extends s implements k {
            final /* synthetic */ String $amazonUserID;
            final /* synthetic */ String $receiptID;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(String str, String str2) {
                super(1);
                this.$receiptID = str;
                this.$amazonUserID = str2;
            }

            @Override // i3.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PurchasesError) obj);
                return E.f5463a;
            }

            public final void invoke(PurchasesError error) {
                r.f(error, "error");
                LogIntent logIntent = LogIntent.RC_ERROR;
                PurchasesOrchestrator$syncAmazonPurchase$4$2$invoke$$inlined$log$1 purchasesOrchestrator$syncAmazonPurchase$4$2$invoke$$inlined$log$1 = new PurchasesOrchestrator$syncAmazonPurchase$4$2$invoke$$inlined$log$1(logIntent, this.$receiptID, this.$amazonUserID, error);
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                    case 1:
                        LogLevel logLevel = LogLevel.DEBUG;
                        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            currentLogHandler.d("[Purchases] - " + logLevel.name(), (String) purchasesOrchestrator$syncAmazonPurchase$4$2$invoke$$inlined$log$1.invoke());
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$syncAmazonPurchase$4$2$invoke$$inlined$log$1.invoke(), null);
                        break;
                    case 3:
                        LogLevel logLevel2 = LogLevel.WARN;
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$syncAmazonPurchase$4$2$invoke$$inlined$log$1.invoke());
                        }
                        break;
                    case 4:
                        LogLevel logLevel3 = LogLevel.INFO;
                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$syncAmazonPurchase$4$2$invoke$$inlined$log$1.invoke());
                        }
                        break;
                    case 5:
                        LogLevel logLevel4 = LogLevel.DEBUG;
                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            currentLogHandler4.d("[Purchases] - " + logLevel4.name(), (String) purchasesOrchestrator$syncAmazonPurchase$4$2$invoke$$inlined$log$1.invoke());
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$syncAmazonPurchase$4$2$invoke$$inlined$log$1.invoke(), null);
                        break;
                    case 7:
                        LogLevel logLevel5 = LogLevel.INFO;
                        LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                            currentLogHandler5.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$syncAmazonPurchase$4$2$invoke$$inlined$log$1.invoke());
                        }
                        break;
                    case 8:
                        LogLevel logLevel6 = LogLevel.DEBUG;
                        LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                            currentLogHandler6.d("[Purchases] - " + logLevel6.name(), (String) purchasesOrchestrator$syncAmazonPurchase$4$2$invoke$$inlined$log$1.invoke());
                        }
                        break;
                    case 9:
                        LogLevel logLevel7 = LogLevel.DEBUG;
                        LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                            currentLogHandler7.d("[Purchases] - " + logLevel7.name(), (String) purchasesOrchestrator$syncAmazonPurchase$4$2$invoke$$inlined$log$1.invoke());
                        }
                        break;
                    case 10:
                        LogLevel logLevel8 = LogLevel.WARN;
                        LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                            currentLogHandler8.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$syncAmazonPurchase$4$2$invoke$$inlined$log$1.invoke());
                        }
                        break;
                    case 11:
                        LogLevel logLevel9 = LogLevel.WARN;
                        LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                            currentLogHandler9.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$syncAmazonPurchase$4$2$invoke$$inlined$log$1.invoke());
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$syncAmazonPurchase$4$2$invoke$$inlined$log$1.invoke(), null);
                        break;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11234(Double d4, String str, PurchasesOrchestrator purchasesOrchestrator, String str2, String str3, String str4) {
            super(1);
            this.$price = d4;
            this.$isoCurrencyCode = str;
            this.this$0 = purchasesOrchestrator;
            this.$receiptID = str2;
            this.$amazonUserID = str3;
            this.$appUserID = str4;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return E.f5463a;
        }

        public final void invoke(String normalizedProductID) {
            r.f(normalizedProductID, "normalizedProductID");
            List listB = AbstractC0768o.b(normalizedProductID);
            Double d4 = this.$price;
            Double d5 = (d4 == null || d4.doubleValue() == 0.0d) ? null : d4;
            String str = this.$isoCurrencyCode;
            this.this$0.postReceiptHelper.postTokenWithoutConsuming(this.$receiptID, this.$amazonUserID, new ReceiptInfo(listB, null, null, null, d5, (str == null || AbstractC1753A.U(str)) ? null : str, null, 78, null), this.this$0.getAllowSharingPlayStoreAccount(), this.$appUserID, null, PostReceiptInitiationSource.RESTORE, new AnonymousClass1(this.$receiptID, this.$amazonUserID), new AnonymousClass2(this.$receiptID, this.$amazonUserID));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$syncAmazonPurchase$5, reason: invalid class name */
    public static final class AnonymousClass5 extends s implements k {
        final /* synthetic */ String $amazonUserID;
        final /* synthetic */ String $receiptID;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(String str, String str2) {
            super(1);
            this.$receiptID = str;
            this.$amazonUserID = str2;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError error) {
            r.f(error, "error");
            LogIntent logIntent = LogIntent.RC_ERROR;
            PurchasesOrchestrator$syncAmazonPurchase$5$invoke$$inlined$log$1 purchasesOrchestrator$syncAmazonPurchase$5$invoke$$inlined$log$1 = new PurchasesOrchestrator$syncAmazonPurchase$5$invoke$$inlined$log$1(logIntent, this.$receiptID, this.$amazonUserID, error);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.d("[Purchases] - " + logLevel.name(), (String) purchasesOrchestrator$syncAmazonPurchase$5$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$syncAmazonPurchase$5$invoke$$inlined$log$1.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$syncAmazonPurchase$5$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$syncAmazonPurchase$5$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        currentLogHandler4.d("[Purchases] - " + logLevel4.name(), (String) purchasesOrchestrator$syncAmazonPurchase$5$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$syncAmazonPurchase$5$invoke$$inlined$log$1.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler5.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$syncAmazonPurchase$5$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        currentLogHandler6.d("[Purchases] - " + logLevel6.name(), (String) purchasesOrchestrator$syncAmazonPurchase$5$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        currentLogHandler7.d("[Purchases] - " + logLevel7.name(), (String) purchasesOrchestrator$syncAmazonPurchase$5$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler8.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$syncAmazonPurchase$5$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler9.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$syncAmazonPurchase$5$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$syncAmazonPurchase$5$invoke$$inlined$log$1.invoke(), null);
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$syncAttributesAndOfferingsIfNeeded$2, reason: invalid class name and case insensitive filesystem */
    public static final class C11242 extends s implements Function0 {
        final /* synthetic */ PurchasesOrchestrator$syncAttributesAndOfferingsIfNeeded$receiveOfferingsCallback$1 $receiveOfferingsCallback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11242(PurchasesOrchestrator$syncAttributesAndOfferingsIfNeeded$receiveOfferingsCallback$1 purchasesOrchestrator$syncAttributesAndOfferingsIfNeeded$receiveOfferingsCallback$1) {
            super(0);
            this.$receiveOfferingsCallback = purchasesOrchestrator$syncAttributesAndOfferingsIfNeeded$receiveOfferingsCallback$1;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m91invoke();
            return E.f5463a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m91invoke() {
            PurchasesOrchestrator.this.getOfferings(this.$receiveOfferingsCallback, true);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$syncPurchases$3, reason: invalid class name and case insensitive filesystem */
    public static final class C11263 extends s implements k {
        final /* synthetic */ SyncPurchasesCallback $listener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11263(SyncPurchasesCallback syncPurchasesCallback) {
            super(1);
            this.$listener = syncPurchasesCallback;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CustomerInfo) obj);
            return E.f5463a;
        }

        public final void invoke(CustomerInfo it) {
            r.f(it, "it");
            SyncPurchasesCallback syncPurchasesCallback = this.$listener;
            if (syncPurchasesCallback != null) {
                syncPurchasesCallback.onSuccess(it);
            }
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.PurchasesOrchestrator$syncPurchases$4, reason: invalid class name and case insensitive filesystem */
    public static final class C11274 extends s implements k {
        final /* synthetic */ SyncPurchasesCallback $listener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11274(SyncPurchasesCallback syncPurchasesCallback) {
            super(1);
            this.$listener = syncPurchasesCallback;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f5463a;
        }

        public final void invoke(PurchasesError it) {
            r.f(it, "it");
            SyncPurchasesCallback syncPurchasesCallback = this.$listener;
            if (syncPurchasesCallback != null) {
                syncPurchasesCallback.onError(it);
            }
        }
    }

    public PurchasesOrchestrator(Application application, String str, Backend backend, BillingAbstract billing, DeviceCache deviceCache, IdentityManager identityManager, SubscriberAttributesManager subscriberAttributesManager, AppConfig appConfig, CustomerInfoHelper customerInfoHelper, CustomerInfoUpdateHandler customerInfoUpdateHandler, DiagnosticsSynchronizer diagnosticsSynchronizer, DiagnosticsTracker diagnosticsTracker, DateProvider dateProvider, OfflineEntitlementsManager offlineEntitlementsManager, PostReceiptHelper postReceiptHelper, PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper, PostPendingTransactionsHelper postPendingTransactionsHelper, SyncPurchasesHelper syncPurchasesHelper, OfferingsManager offeringsManager, EventsManager eventsManager, PaywallPresentedCache paywallPresentedCache, PurchasesStateCache purchasesStateCache, Handler handler, Dispatcher dispatcher, PurchasesConfiguration initialConfiguration, FontLoader fontLoader, DefaultLocaleProvider localeProvider, WebPurchaseRedemptionHelper webPurchaseRedemptionHelper, VirtualCurrencyManager virtualCurrencyManager, Function0 processLifecycleOwnerProvider, Function0 isSimulatedStoreEnabled, BlockstoreHelper blockstoreHelper, BackupManager backupManager) {
        r.f(application, "application");
        r.f(backend, "backend");
        r.f(billing, "billing");
        r.f(deviceCache, "deviceCache");
        r.f(identityManager, "identityManager");
        r.f(subscriberAttributesManager, "subscriberAttributesManager");
        r.f(appConfig, "appConfig");
        r.f(customerInfoHelper, "customerInfoHelper");
        r.f(customerInfoUpdateHandler, "customerInfoUpdateHandler");
        r.f(dateProvider, "dateProvider");
        r.f(offlineEntitlementsManager, "offlineEntitlementsManager");
        r.f(postReceiptHelper, "postReceiptHelper");
        r.f(postTransactionWithProductDetailsHelper, "postTransactionWithProductDetailsHelper");
        r.f(postPendingTransactionsHelper, "postPendingTransactionsHelper");
        r.f(syncPurchasesHelper, "syncPurchasesHelper");
        r.f(offeringsManager, "offeringsManager");
        r.f(paywallPresentedCache, "paywallPresentedCache");
        r.f(purchasesStateCache, "purchasesStateCache");
        r.f(dispatcher, "dispatcher");
        r.f(initialConfiguration, "initialConfiguration");
        r.f(fontLoader, "fontLoader");
        r.f(localeProvider, "localeProvider");
        r.f(webPurchaseRedemptionHelper, "webPurchaseRedemptionHelper");
        r.f(virtualCurrencyManager, "virtualCurrencyManager");
        r.f(processLifecycleOwnerProvider, "processLifecycleOwnerProvider");
        r.f(isSimulatedStoreEnabled, "isSimulatedStoreEnabled");
        r.f(blockstoreHelper, "blockstoreHelper");
        r.f(backupManager, "backupManager");
        this.application = application;
        this.backend = backend;
        this.billing = billing;
        this.deviceCache = deviceCache;
        this.identityManager = identityManager;
        this.subscriberAttributesManager = subscriberAttributesManager;
        this.appConfig = appConfig;
        this.customerInfoHelper = customerInfoHelper;
        this.customerInfoUpdateHandler = customerInfoUpdateHandler;
        this.diagnosticsSynchronizer = diagnosticsSynchronizer;
        this.diagnosticsTrackerIfEnabled = diagnosticsTracker;
        this.dateProvider = dateProvider;
        this.offlineEntitlementsManager = offlineEntitlementsManager;
        this.postReceiptHelper = postReceiptHelper;
        this.postTransactionWithProductDetailsHelper = postTransactionWithProductDetailsHelper;
        this.postPendingTransactionsHelper = postPendingTransactionsHelper;
        this.syncPurchasesHelper = syncPurchasesHelper;
        this.offeringsManager = offeringsManager;
        this.eventsManager = eventsManager;
        this.paywallPresentedCache = paywallPresentedCache;
        this.purchasesStateCache = purchasesStateCache;
        this.mainHandler = handler;
        this.dispatcher = dispatcher;
        this.initialConfiguration = initialConfiguration;
        this.fontLoader = fontLoader;
        this.localeProvider = localeProvider;
        this.webPurchaseRedemptionHelper = webPurchaseRedemptionHelper;
        this.virtualCurrencyManager = virtualCurrencyManager;
        this.processLifecycleOwnerProvider = processLifecycleOwnerProvider;
        this.isSimulatedStoreEnabled = isSimulatedStoreEnabled;
        this.blockstoreHelper = blockstoreHelper;
        this.backupManager = backupManager;
        this.lifecycleHandler$delegate = W2.k.b(new PurchasesOrchestrator$lifecycleHandler$2(this));
        C1779a.C0237a c0237a = C1779a.f14679b;
        s3.d dVar = s3.d.f14689e;
        this.lastSyncAttributesAndOfferingsRateLimiter = new RateLimiter(5, s3.c.s(60, dVar), null);
        this.preferredLocaleOverrideRateLimiter = new RateLimiter(2, s3.c.s(60, dVar), null);
        this._preferredUILocaleOverride = initialConfiguration.getPreferredUILocaleOverride();
        localeProvider.setPreferredLocaleOverride(this._preferredUILocaleOverride);
        identityManager.configure(str);
        billing.setStateListener(new BillingAbstract.StateListener() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.3
            @Override // com.revenuecat.purchases.common.BillingAbstract.StateListener
            public void onConnected() {
                PostPendingTransactionsHelper.syncPendingPurchaseQueue$default(PurchasesOrchestrator.this.postPendingTransactionsHelper, PurchasesOrchestrator.this.getAllowSharingPlayStoreAccount(), null, 2, null);
                PurchasesOrchestrator.this.billing.getStorefront(new PurchasesOrchestrator$3$onConnected$1(PurchasesOrchestrator.this), PurchasesOrchestrator$3$onConnected$2.INSTANCE);
            }
        });
        billing.setPurchasesUpdatedListener(getPurchasesUpdatedListener());
        BillingAbstract.startConnectionOnMainThread$default(billing, 0L, 1, null);
        dispatch(new AnonymousClass4());
        if (this.appConfig.getDangerousSettings().getAutoSyncPurchases()) {
            return;
        }
        LogIntent logIntent = LogIntent.WARNING;
        PurchasesOrchestrator$special$$inlined$log$1 purchasesOrchestrator$special$$inlined$log$1 = new PurchasesOrchestrator$special$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), (String) purchasesOrchestrator$special$$inlined$log$1.invoke());
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$special$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$special$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$special$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    currentLogHandler4.d("[Purchases] - " + logLevel4.name(), (String) purchasesOrchestrator$special$$inlined$log$1.invoke());
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$special$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler5.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$special$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    currentLogHandler6.d("[Purchases] - " + logLevel6.name(), (String) purchasesOrchestrator$special$$inlined$log$1.invoke());
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    currentLogHandler7.d("[Purchases] - " + logLevel7.name(), (String) purchasesOrchestrator$special$$inlined$log$1.invoke());
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler8.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$special$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler9.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$special$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$special$$inlined$log$1.invoke(), null);
                break;
        }
    }

    private final PurchaseCallback createCallbackWithDiagnosticsIfNeeded(final PurchaseCallback purchaseCallback, final PurchasingData purchasingData, final Date date) {
        return this.diagnosticsTrackerIfEnabled == null ? purchaseCallback : new PurchaseCallback() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.createCallbackWithDiagnosticsIfNeeded.1
            @Override // com.revenuecat.purchases.interfaces.PurchaseCallback
            public void onCompleted(StoreTransaction storeTransaction, CustomerInfo customerInfo) {
                r.f(storeTransaction, "storeTransaction");
                r.f(customerInfo, "customerInfo");
                PurchasesOrchestrator.this.trackPurchaseResultIfNeeded(purchasingData, null, date, customerInfo.getEntitlements().getVerification());
                purchaseCallback.onCompleted(storeTransaction, customerInfo);
            }

            @Override // com.revenuecat.purchases.interfaces.PurchaseErrorCallback
            public void onError(PurchasesError error, boolean z4) {
                r.f(error, "error");
                PurchasesOrchestrator.this.trackPurchaseResultIfNeeded(purchasingData, error, date, null);
                purchaseCallback.onError(error, z4);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatch(final Function0 function0) {
        if (r.b(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            function0.invoke();
            return;
        }
        Handler handler = this.mainHandler;
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.post(new Runnable() { // from class: com.revenuecat.purchases.e
            @Override // java.lang.Runnable
            public final void run() {
                PurchasesOrchestrator.dispatch$lambda$63(function0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dispatch$lambda$63(Function0 tmp0) {
        r.f(tmp0, "$tmp0");
        tmp0.invoke();
    }

    private final void enqueue(final Function0 function0) {
        this.dispatcher.enqueue(new Runnable() { // from class: com.revenuecat.purchases.f
            @Override // java.lang.Runnable
            public final void run() {
                PurchasesOrchestrator.enqueue$lambda$56(function0);
            }
        }, Delay.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enqueue$lambda$56(Function0 command) {
        r.f(command, "$command");
        command.invoke();
    }

    private final boolean fetchOfferingsWithRateLimit(final o oVar) {
        if (this.preferredLocaleOverrideRateLimiter.shouldProceed()) {
            LogLevel logLevel = LogLevel.VERBOSE;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.v("[Purchases] - " + logLevel.name(), "Fetching fresh offerings");
            }
            getOfferings(new ReceiveOfferingsCallback() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.fetchOfferingsWithRateLimit.2
                @Override // com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback
                public void onError(PurchasesError error) {
                    r.f(error, "error");
                    oVar.invoke(null, error);
                }

                @Override // com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback
                public void onReceived(Offerings offerings) {
                    r.f(offerings, "offerings");
                    oVar.invoke(offerings, null);
                }
            }, true);
            return true;
        }
        LogLevel logLevel2 = LogLevel.DEBUG;
        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) > 0) {
            return false;
        }
        currentLogHandler2.d("[Purchases] - " + logLevel2.name(), "Fresh offerings fetch rate limit reached: " + this.preferredLocaleOverrideRateLimiter.getMaxCallsInPeriod() + " per " + C1779a.u(this.preferredLocaleOverrideRateLimiter.m219getPeriodSecondsUwyO8pc()) + " seconds. Fetch not triggered.");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void flushPaywallEvents() {
        EventsManager eventsManager;
        if (!AndroidVersionUtilsKt.isAndroidNOrNewer() || (eventsManager = this.eventsManager) == null) {
            return;
        }
        eventsManager.flushEvents();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<PurchaseCallback> getAndClearAllPurchaseCallbacks() {
        List<PurchaseCallback> listG0;
        synchronized (this) {
            Map<String, PurchaseCallback> purchaseCallbacksByProductId = getState$purchases_defaultsRelease().getPurchaseCallbacksByProductId();
            PurchasesState state$purchases_defaultsRelease = getState$purchases_defaultsRelease();
            Map map = Collections.EMPTY_MAP;
            r.e(map, "emptyMap()");
            setState$purchases_defaultsRelease(PurchasesState.copy$default(state$purchases_defaultsRelease, null, map, null, false, false, 29, null));
            listG0 = x.g0(purchaseCallbacksByProductId.values());
        }
        return listG0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProductChangeCallback getAndClearProductChangeCallback() {
        ProductChangeCallback deprecatedProductChangeCallback = getState$purchases_defaultsRelease().getDeprecatedProductChangeCallback();
        setState$purchases_defaultsRelease(PurchasesState.copy$default(getState$purchases_defaultsRelease(), null, null, null, false, false, 27, null));
        return deprecatedProductChangeCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getCustomerInfo(ReceiveCustomerInfoCallback receiveCustomerInfoCallback) {
        getCustomerInfo(CacheFetchPolicy.Companion.m41default(), false, receiveCustomerInfoCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppLifecycleHandler getLifecycleHandler() {
        return (AppLifecycleHandler) this.lifecycleHandler$delegate.getValue();
    }

    public static /* synthetic */ void getOfferings$default(PurchasesOrchestrator purchasesOrchestrator, ReceiveOfferingsCallback receiveOfferingsCallback, boolean z4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z4 = false;
        }
        purchasesOrchestrator.getOfferings(receiveOfferingsCallback, z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<o, o> getProductChangeCompletedCallbacks(ProductChangeCallback productChangeCallback) {
        return new Pair<>(new PurchasesOrchestrator$getProductChangeCompletedCallbacks$onSuccess$1(productChangeCallback, this), new PurchasesOrchestrator$getProductChangeCompletedCallbacks$onError$1(productChangeCallback, this));
    }

    public static /* synthetic */ void getProducts$default(PurchasesOrchestrator purchasesOrchestrator, List list, ProductType productType, GetStoreProductsCallback getStoreProductsCallback, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            productType = null;
        }
        purchasesOrchestrator.getProducts(list, productType, getStoreProductsCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void getProductsOfTypes(Set<String> set, Set<? extends ProductType> set2, List<? extends StoreProduct> list, Date date, GetStoreProductsCallback getStoreProductsCallback) {
        Set<String> set3;
        List<? extends StoreProduct> list2;
        GetStoreProductsCallback getStoreProductsCallback2;
        E e4;
        if (date == null) {
            trackGetProductsStarted(set);
            date = this.dateProvider.getNow();
        }
        Date date2 = date;
        Set setK0 = x.k0(set2);
        ProductType productType = (ProductType) x.I(setK0);
        if (productType != null) {
            setK0.remove(productType);
        } else {
            productType = null;
        }
        if (productType != null) {
            set3 = set;
            list2 = list;
            GetStoreProductsCallback getStoreProductsCallback3 = getStoreProductsCallback;
            this.billing.queryProductDetailsAsync(productType, set3, new PurchasesOrchestrator$getProductsOfTypes$1$1(this, set3, setK0, list2, date2, getStoreProductsCallback3), new PurchasesOrchestrator$getProductsOfTypes$1$2(this, date2, set3, getStoreProductsCallback3));
            e4 = E.f5463a;
            getStoreProductsCallback2 = getStoreProductsCallback3;
        } else {
            set3 = set;
            list2 = list;
            getStoreProductsCallback2 = getStoreProductsCallback;
            e4 = null;
        }
        if (e4 == null) {
            ArrayList arrayList = new ArrayList(AbstractC0770q.q(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((StoreProduct) it.next()).getId());
            }
            trackGetProductsResult(date2, set3, S.g(set3, x.l0(arrayList)), null);
            getStoreProductsCallback2.onReceived(list2);
        }
    }

    public static /* synthetic */ void getProductsOfTypes$default(PurchasesOrchestrator purchasesOrchestrator, Set set, Set set2, List list, Date date, GetStoreProductsCallback getStoreProductsCallback, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            date = null;
        }
        purchasesOrchestrator.getProductsOfTypes(set, set2, list, date, getStoreProductsCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PurchaseCallback getPurchaseCallback(String str) {
        PurchaseCallback purchaseCallback = getState$purchases_defaultsRelease().getPurchaseCallbacksByProductId().get(str);
        PurchasesState state$purchases_defaultsRelease = getState$purchases_defaultsRelease();
        Map<String, PurchaseCallback> purchaseCallbacksByProductId = getState$purchases_defaultsRelease().getPurchaseCallbacksByProductId();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, PurchaseCallback> entry : purchaseCallbacksByProductId.entrySet()) {
            if (!r.b(entry.getKey(), str)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        setState$purchases_defaultsRelease(PurchasesState.copy$default(state$purchases_defaultsRelease, null, linkedHashMap, null, false, false, 29, null));
        return purchaseCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<o, o> getPurchaseCompletedCallbacks() {
        return new Pair<>(new PurchasesOrchestrator$getPurchaseCompletedCallbacks$onSuccess$1(this), new PurchasesOrchestrator$getPurchaseCompletedCallbacks$onError$1(this));
    }

    private final BillingAbstract.PurchasesUpdatedListener getPurchasesUpdatedListener() {
        return new BillingAbstract.PurchasesUpdatedListener() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.getPurchasesUpdatedListener.1
            @Override // com.revenuecat.purchases.common.BillingAbstract.PurchasesUpdatedListener
            public void onPurchasesFailedToUpdate(PurchasesError purchasesError) {
                E e4;
                r.f(purchasesError, "purchasesError");
                PurchasesOrchestrator purchasesOrchestrator = PurchasesOrchestrator.this;
                synchronized (purchasesOrchestrator) {
                    try {
                        ProductChangeCallback andClearProductChangeCallback = purchasesOrchestrator.getAndClearProductChangeCallback();
                        if (andClearProductChangeCallback != null) {
                            purchasesOrchestrator.dispatch(andClearProductChangeCallback, purchasesError);
                            e4 = E.f5463a;
                        } else {
                            e4 = null;
                        }
                        if (e4 == null) {
                            Iterator it = purchasesOrchestrator.getAndClearAllPurchaseCallbacks().iterator();
                            while (it.hasNext()) {
                                purchasesOrchestrator.dispatch((PurchaseCallback) it.next(), purchasesError);
                            }
                        }
                        E e5 = E.f5463a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // com.revenuecat.purchases.common.BillingAbstract.PurchasesUpdatedListener
            public void onPurchasesUpdated(List<StoreTransaction> purchases) {
                Pair productChangeCompletedCallbacks;
                r.f(purchases, "purchases");
                PurchasesOrchestrator purchasesOrchestrator = PurchasesOrchestrator.this;
                synchronized (purchasesOrchestrator) {
                    try {
                        productChangeCompletedCallbacks = purchasesOrchestrator.getState$purchases_defaultsRelease().getDeprecatedProductChangeCallback() != null ? purchasesOrchestrator.getProductChangeCompletedCallbacks(purchasesOrchestrator.getAndClearProductChangeCallback()) : purchasesOrchestrator.getPurchaseCompletedCallbacks();
                        E e4 = E.f5463a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                PurchasesOrchestrator.this.postTransactionWithProductDetailsHelper.postTransactions(purchases, PurchasesOrchestrator.this.getAllowSharingPlayStoreAccount(), PurchasesOrchestrator.this.getAppUserID(), PostReceiptInitiationSource.PURCHASE, (o) productChangeCompletedCallbacks.first, (o) productChangeCompletedCallbacks.second);
                PurchasesOrchestrator.this.flushPaywallEvents();
            }
        };
    }

    public static /* synthetic */ void logIn$default(PurchasesOrchestrator purchasesOrchestrator, String str, LogInCallback logInCallback, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            logInCallback = null;
        }
        purchasesOrchestrator.logIn(str, logInCallback);
    }

    public static /* synthetic */ void logOut$default(PurchasesOrchestrator purchasesOrchestrator, ReceiveCustomerInfoCallback receiveCustomerInfoCallback, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            receiveCustomerInfoCallback = null;
        }
        purchasesOrchestrator.logOut(receiveCustomerInfoCallback);
    }

    private final void replaceOldPurchaseWithNewProduct(PurchasingData purchasingData, String str, GoogleReplacementMode googleReplacementMode, Activity activity, String str2, PresentedOfferingContext presentedOfferingContext, Boolean bool, PurchaseErrorCallback purchaseErrorCallback) {
        ProductType productType = purchasingData.getProductType();
        ProductType productType2 = ProductType.SUBS;
        if (productType != productType2) {
            PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.PurchaseNotAllowedError, PurchaseStrings.UPGRADING_INVALID_TYPE);
            LogUtilsKt.errorLog(purchasesError);
            ProductChangeCallback andClearProductChangeCallback = getAndClearProductChangeCallback();
            if (andClearProductChangeCallback != null) {
                dispatch(andClearProductChangeCallback, purchasesError);
            }
            Iterator<T> it = getAndClearAllPurchaseCallbacks().iterator();
            while (it.hasNext()) {
                dispatch((PurchaseCallback) it.next(), purchasesError);
            }
            return;
        }
        F f4 = new F();
        f4.f13410a = str;
        if (AbstractC1753A.I(str, Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, false, 2, null)) {
            f4.f13410a = AbstractC1753A.E0(str, Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, null, 2, null);
            LogLevel logLevel = LogLevel.WARN;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.w("[Purchases] - " + logLevel.name(), "Using incorrect oldProductId: " + str + ". The productId should not contain the basePlanId. Using productId: " + ((String) f4.f13410a) + com.amazon.a.a.o.c.a.b.f8816a);
            }
        }
        this.billing.findPurchaseInPurchaseHistory(str2, productType2, (String) f4.f13410a, new C11193(activity, str2, purchasingData, googleReplacementMode, presentedOfferingContext, bool, f4), new C11204(purchaseErrorCallback));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean shouldRefreshCustomerInfo(boolean z4) {
        return !this.appConfig.getCustomEntitlementComputation() && (z4 || this.deviceCache.isCustomerInfoCacheStale(getAppUserID(), false));
    }

    private final void startProductChange(Activity activity, PurchasingData purchasingData, PresentedOfferingContext presentedOfferingContext, String str, GoogleReplacementMode googleReplacementMode, Boolean bool, PurchaseCallback purchaseCallback) {
        GoogleReplacementMode googleReplacementMode2;
        String currentAppUserID;
        E e4;
        LogHandler currentLogHandler;
        String str2;
        String str3;
        LogHandler currentLogHandler2;
        String str4;
        String str5;
        trackPurchaseStarted(purchasingData.getProductId(), purchasingData.getProductType());
        PurchaseCallback purchaseCallbackCreateCallbackWithDiagnosticsIfNeeded = createCallbackWithDiagnosticsIfNeeded(purchaseCallback, purchasingData, this.dateProvider.getNow());
        if (purchasingData.getProductType() != ProductType.SUBS) {
            PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.PurchaseNotAllowedError, PurchaseStrings.UPGRADING_INVALID_TYPE);
            LogUtilsKt.errorLog(purchasesError);
            dispatch(purchaseCallbackCreateCallbackWithDiagnosticsIfNeeded, purchasesError);
            return;
        }
        LogIntent logIntent = LogIntent.PURCHASE;
        PurchasesOrchestrator$startProductChange$$inlined$log$1 purchasesOrchestrator$startProductChange$$inlined$log$1 = new PurchasesOrchestrator$startProductChange$$inlined$log$1(logIntent, purchasingData, presentedOfferingContext, str, googleReplacementMode);
        int[] iArr = LogWrapperKt.WhenMappings.$EnumSwitchMapping$0;
        switch (iArr[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str4 = "[Purchases] - " + logLevel.name();
                    str5 = (String) purchasesOrchestrator$startProductChange$$inlined$log$1.invoke();
                    currentLogHandler2.d(str4, str5);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$startProductChange$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler3.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$startProductChange$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$startProductChange$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str4 = "[Purchases] - " + logLevel4.name();
                    str5 = (String) purchasesOrchestrator$startProductChange$$inlined$log$1.invoke();
                    currentLogHandler2.d(str4, str5);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$startProductChange$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler5.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$startProductChange$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str4 = "[Purchases] - " + logLevel6.name();
                    str5 = (String) purchasesOrchestrator$startProductChange$$inlined$log$1.invoke();
                    currentLogHandler2.d(str4, str5);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str4 = "[Purchases] - " + logLevel7.name();
                    str5 = (String) purchasesOrchestrator$startProductChange$$inlined$log$1.invoke();
                    currentLogHandler2.d(str4, str5);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$startProductChange$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler7.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$startProductChange$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$startProductChange$$inlined$log$1.invoke(), null);
                break;
        }
        synchronized (this) {
            try {
                if (!this.appConfig.getFinishTransactions()) {
                    LogIntent logIntent2 = LogIntent.WARNING;
                    PurchasesOrchestrator$startProductChange$lambda$80$$inlined$log$1 purchasesOrchestrator$startProductChange$lambda$80$$inlined$log$1 = new PurchasesOrchestrator$startProductChange$lambda$80$$inlined$log$1(logIntent2);
                    switch (iArr[logIntent2.ordinal()]) {
                        case 1:
                            LogLevel logLevel10 = LogLevel.DEBUG;
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                                str2 = "[Purchases] - " + logLevel10.name();
                                str3 = (String) purchasesOrchestrator$startProductChange$lambda$80$$inlined$log$1.invoke();
                                currentLogHandler.d(str2, str3);
                            }
                            break;
                        case 2:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$startProductChange$lambda$80$$inlined$log$1.invoke(), null);
                            break;
                        case 3:
                            LogLevel logLevel11 = LogLevel.WARN;
                            LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                                currentLogHandler8.w("[Purchases] - " + logLevel11.name(), (String) purchasesOrchestrator$startProductChange$lambda$80$$inlined$log$1.invoke());
                            }
                            break;
                        case 4:
                            LogLevel logLevel12 = LogLevel.INFO;
                            LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                                currentLogHandler9.i("[Purchases] - " + logLevel12.name(), (String) purchasesOrchestrator$startProductChange$lambda$80$$inlined$log$1.invoke());
                            }
                            break;
                        case 5:
                            LogLevel logLevel13 = LogLevel.DEBUG;
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                                str2 = "[Purchases] - " + logLevel13.name();
                                str3 = (String) purchasesOrchestrator$startProductChange$lambda$80$$inlined$log$1.invoke();
                                currentLogHandler.d(str2, str3);
                            }
                            break;
                        case 6:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$startProductChange$lambda$80$$inlined$log$1.invoke(), null);
                            break;
                        case 7:
                            LogLevel logLevel14 = LogLevel.INFO;
                            LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                                currentLogHandler10.i("[Purchases] - " + logLevel14.name(), (String) purchasesOrchestrator$startProductChange$lambda$80$$inlined$log$1.invoke());
                            }
                            break;
                        case 8:
                            LogLevel logLevel15 = LogLevel.DEBUG;
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                                str2 = "[Purchases] - " + logLevel15.name();
                                str3 = (String) purchasesOrchestrator$startProductChange$lambda$80$$inlined$log$1.invoke();
                                currentLogHandler.d(str2, str3);
                            }
                            break;
                        case 9:
                            LogLevel logLevel16 = LogLevel.DEBUG;
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                                str2 = "[Purchases] - " + logLevel16.name();
                                str3 = (String) purchasesOrchestrator$startProductChange$lambda$80$$inlined$log$1.invoke();
                                currentLogHandler.d(str2, str3);
                            }
                            break;
                        case 10:
                            LogLevel logLevel17 = LogLevel.WARN;
                            LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                                currentLogHandler11.w("[Purchases] - " + logLevel17.name(), (String) purchasesOrchestrator$startProductChange$lambda$80$$inlined$log$1.invoke());
                            }
                            break;
                        case 11:
                            LogLevel logLevel18 = LogLevel.WARN;
                            LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                                currentLogHandler12.w("[Purchases] - " + logLevel18.name(), (String) purchasesOrchestrator$startProductChange$lambda$80$$inlined$log$1.invoke());
                            }
                            break;
                        case 12:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$startProductChange$lambda$80$$inlined$log$1.invoke(), null);
                            break;
                    }
                }
                if (getState$purchases_defaultsRelease().getPurchaseCallbacksByProductId().containsKey(purchasingData.getProductId())) {
                    googleReplacementMode2 = googleReplacementMode;
                    currentAppUserID = null;
                } else {
                    googleReplacementMode2 = googleReplacementMode;
                    setState$purchases_defaultsRelease(PurchasesState.copy$default(getState$purchases_defaultsRelease(), null, L.k(getState$purchases_defaultsRelease().getPurchaseCallbacksByProductId(), K.c(t.a(googleReplacementMode2 == GoogleReplacementMode.DEFERRED ? str : purchasingData.getProductId(), purchaseCallbackCreateCallbackWithDiagnosticsIfNeeded))), null, false, false, 29, null));
                    currentAppUserID = this.identityManager.getCurrentAppUserID();
                }
                E e5 = E.f5463a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (currentAppUserID != null) {
            replaceOldPurchaseWithNewProduct(purchasingData, str, googleReplacementMode2, activity, currentAppUserID, presentedOfferingContext, bool, purchaseCallbackCreateCallbackWithDiagnosticsIfNeeded);
            e4 = E.f5463a;
        } else {
            e4 = null;
        }
        if (e4 == null) {
            PurchasesError purchasesError2 = new PurchasesError(PurchasesErrorCode.OperationAlreadyInProgressError, null, 2, null);
            LogUtilsKt.errorLog(purchasesError2);
            Iterator<T> it = getAndClearAllPurchaseCallbacks().iterator();
            while (it.hasNext()) {
                dispatch((PurchaseCallback) it.next(), purchasesError2);
            }
        }
    }

    private final void startPurchase(Activity activity, PurchasingData purchasingData, PresentedOfferingContext presentedOfferingContext, Boolean bool, PurchaseCallback purchaseCallback) {
        String currentAppUserID;
        E e4;
        LogHandler currentLogHandler;
        String str;
        String str2;
        LogHandler currentLogHandler2;
        String str3;
        String str4;
        LogIntent logIntent = LogIntent.PURCHASE;
        PurchasesOrchestrator$startPurchase$$inlined$log$1 purchasesOrchestrator$startPurchase$$inlined$log$1 = new PurchasesOrchestrator$startPurchase$$inlined$log$1(logIntent, purchasingData, presentedOfferingContext);
        int[] iArr = LogWrapperKt.WhenMappings.$EnumSwitchMapping$0;
        switch (iArr[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str3 = "[Purchases] - " + logLevel.name();
                    str4 = (String) purchasesOrchestrator$startPurchase$$inlined$log$1.invoke();
                    currentLogHandler2.d(str3, str4);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$startPurchase$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler3.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$startPurchase$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$startPurchase$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str3 = "[Purchases] - " + logLevel4.name();
                    str4 = (String) purchasesOrchestrator$startPurchase$$inlined$log$1.invoke();
                    currentLogHandler2.d(str3, str4);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$startPurchase$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler5.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$startPurchase$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str3 = "[Purchases] - " + logLevel6.name();
                    str4 = (String) purchasesOrchestrator$startPurchase$$inlined$log$1.invoke();
                    currentLogHandler2.d(str3, str4);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str3 = "[Purchases] - " + logLevel7.name();
                    str4 = (String) purchasesOrchestrator$startPurchase$$inlined$log$1.invoke();
                    currentLogHandler2.d(str3, str4);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$startPurchase$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler7.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$startPurchase$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$startPurchase$$inlined$log$1.invoke(), null);
                break;
        }
        trackPurchaseStarted(purchasingData.getProductId(), purchasingData.getProductType());
        PurchaseCallback purchaseCallbackCreateCallbackWithDiagnosticsIfNeeded = createCallbackWithDiagnosticsIfNeeded(purchaseCallback, purchasingData, this.dateProvider.getNow());
        synchronized (this) {
            try {
                if (!this.appConfig.getFinishTransactions()) {
                    LogIntent logIntent2 = LogIntent.WARNING;
                    PurchasesOrchestrator$startPurchase$lambda$72$$inlined$log$1 purchasesOrchestrator$startPurchase$lambda$72$$inlined$log$1 = new PurchasesOrchestrator$startPurchase$lambda$72$$inlined$log$1(logIntent2);
                    switch (iArr[logIntent2.ordinal()]) {
                        case 1:
                            LogLevel logLevel10 = LogLevel.DEBUG;
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                                str = "[Purchases] - " + logLevel10.name();
                                str2 = (String) purchasesOrchestrator$startPurchase$lambda$72$$inlined$log$1.invoke();
                                currentLogHandler.d(str, str2);
                            }
                            break;
                        case 2:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$startPurchase$lambda$72$$inlined$log$1.invoke(), null);
                            break;
                        case 3:
                            LogLevel logLevel11 = LogLevel.WARN;
                            LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                                currentLogHandler8.w("[Purchases] - " + logLevel11.name(), (String) purchasesOrchestrator$startPurchase$lambda$72$$inlined$log$1.invoke());
                            }
                            break;
                        case 4:
                            LogLevel logLevel12 = LogLevel.INFO;
                            LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                                currentLogHandler9.i("[Purchases] - " + logLevel12.name(), (String) purchasesOrchestrator$startPurchase$lambda$72$$inlined$log$1.invoke());
                            }
                            break;
                        case 5:
                            LogLevel logLevel13 = LogLevel.DEBUG;
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                                str = "[Purchases] - " + logLevel13.name();
                                str2 = (String) purchasesOrchestrator$startPurchase$lambda$72$$inlined$log$1.invoke();
                                currentLogHandler.d(str, str2);
                            }
                            break;
                        case 6:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$startPurchase$lambda$72$$inlined$log$1.invoke(), null);
                            break;
                        case 7:
                            LogLevel logLevel14 = LogLevel.INFO;
                            LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                                currentLogHandler10.i("[Purchases] - " + logLevel14.name(), (String) purchasesOrchestrator$startPurchase$lambda$72$$inlined$log$1.invoke());
                            }
                            break;
                        case 8:
                            LogLevel logLevel15 = LogLevel.DEBUG;
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                                str = "[Purchases] - " + logLevel15.name();
                                str2 = (String) purchasesOrchestrator$startPurchase$lambda$72$$inlined$log$1.invoke();
                                currentLogHandler.d(str, str2);
                            }
                            break;
                        case 9:
                            LogLevel logLevel16 = LogLevel.DEBUG;
                            currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                                str = "[Purchases] - " + logLevel16.name();
                                str2 = (String) purchasesOrchestrator$startPurchase$lambda$72$$inlined$log$1.invoke();
                                currentLogHandler.d(str, str2);
                            }
                            break;
                        case 10:
                            LogLevel logLevel17 = LogLevel.WARN;
                            LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                                currentLogHandler11.w("[Purchases] - " + logLevel17.name(), (String) purchasesOrchestrator$startPurchase$lambda$72$$inlined$log$1.invoke());
                            }
                            break;
                        case 11:
                            LogLevel logLevel18 = LogLevel.WARN;
                            LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                                currentLogHandler12.w("[Purchases] - " + logLevel18.name(), (String) purchasesOrchestrator$startPurchase$lambda$72$$inlined$log$1.invoke());
                            }
                            break;
                        case 12:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$startPurchase$lambda$72$$inlined$log$1.invoke(), null);
                            break;
                    }
                }
                if (getState$purchases_defaultsRelease().getPurchaseCallbacksByProductId().containsKey(purchasingData.getProductId())) {
                    currentAppUserID = null;
                } else {
                    setState$purchases_defaultsRelease(PurchasesState.copy$default(getState$purchases_defaultsRelease(), null, L.k(getState$purchases_defaultsRelease().getPurchaseCallbacksByProductId(), K.c(t.a(purchasingData.getProductId(), purchaseCallbackCreateCallbackWithDiagnosticsIfNeeded))), null, false, false, 29, null));
                    currentAppUserID = this.identityManager.getCurrentAppUserID();
                }
                E e5 = E.f5463a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (currentAppUserID != null) {
            this.billing.makePurchaseAsync(activity, currentAppUserID, purchasingData, null, presentedOfferingContext, bool);
            e4 = E.f5463a;
        } else {
            e4 = null;
        }
        if (e4 == null) {
            PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.OperationAlreadyInProgressError, null, 2, null);
            LogUtilsKt.errorLog(purchasesError);
            dispatch(purchaseCallbackCreateCallbackWithDiagnosticsIfNeeded, purchasesError);
        }
    }

    public static /* synthetic */ void syncPurchases$default(PurchasesOrchestrator purchasesOrchestrator, SyncPurchasesCallback syncPurchasesCallback, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            syncPurchasesCallback = null;
        }
        purchasesOrchestrator.syncPurchases(syncPurchasesCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void synchronizeSubscriberAttributesIfNeeded() {
        SubscriberAttributesManager.synchronizeSubscriberAttributesForAllUsers$default(this.subscriberAttributesManager, getAppUserID(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackGetProductsResult(Date date, Set<String> set, Set<String> set2, PurchasesError purchasesError) {
        PurchasesErrorCode code;
        if (this.diagnosticsTrackerIfEnabled == null) {
            return;
        }
        long jBetween = DurationExtensionsKt.between(C1779a.f14679b, date, this.dateProvider.getNow());
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        Integer numValueOf = null;
        String message = purchasesError != null ? purchasesError.getMessage() : null;
        if (purchasesError != null && (code = purchasesError.getCode()) != null) {
            numValueOf = Integer.valueOf(code.getCode());
        }
        diagnosticsTracker.m107trackGetProductsResult9VgGkz4(set, set2, message, numValueOf, jBetween);
    }

    private final void trackGetProductsStarted(Set<String> set) {
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker != null) {
            diagnosticsTracker.trackGetProductsStarted(set);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackPurchaseResultIfNeeded(PurchasingData purchasingData, PurchasesError purchasesError, Date date, VerificationResult verificationResult) {
        PurchasesErrorCode code;
        if (this.diagnosticsTrackerIfEnabled == null) {
            return;
        }
        this.diagnosticsTrackerIfEnabled.m112trackPurchaseResultmyKFqkg(purchasingData.getProductId(), purchasingData.getProductType(), (purchasesError == null || (code = purchasesError.getCode()) == null) ? null : Integer.valueOf(code.getCode()), purchasesError != null ? purchasesError.getMessage() : null, DurationExtensionsKt.between(C1779a.f14679b, date, this.dateProvider.getNow()), verificationResult);
    }

    private final void trackPurchaseStarted(String str, ProductType productType) {
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker != null) {
            diagnosticsTracker.trackPurchaseStarted(str, productType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateAllCaches(String str, ReceiveCustomerInfoCallback receiveCustomerInfoCallback) {
        boolean appInBackground = getState$purchases_defaultsRelease().getAppInBackground();
        CustomerInfoHelper.retrieveCustomerInfo$default(this.customerInfoHelper, str, CacheFetchPolicy.FETCH_CURRENT, appInBackground, getAllowSharingPlayStoreAccount(), false, receiveCustomerInfoCallback, 16, null);
        OfferingsManager.fetchAndCacheOfferings$default(this.offeringsManager, str, appInBackground, null, null, 12, null);
    }

    public static /* synthetic */ void updateAllCaches$default(PurchasesOrchestrator purchasesOrchestrator, String str, ReceiveCustomerInfoCallback receiveCustomerInfoCallback, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            receiveCustomerInfoCallback = null;
        }
        purchasesOrchestrator.updateAllCaches(str, receiveCustomerInfoCallback);
    }

    public final void close() {
        synchronized (this) {
            PurchasesState state$purchases_defaultsRelease = getState$purchases_defaultsRelease();
            Map map = Collections.EMPTY_MAP;
            r.e(map, "emptyMap()");
            setState$purchases_defaultsRelease(PurchasesState.copy$default(state$purchases_defaultsRelease, null, map, null, false, false, 29, null));
            E e4 = E.f5463a;
        }
        this.backend.close();
        this.billing.close();
        setUpdatedCustomerInfoListener(null);
        dispatch(new C11022());
    }

    public final void collectDeviceIdentifiers() {
        LogHandler currentLogHandler;
        String str;
        String str2;
        LogIntent logIntent = LogIntent.DEBUG;
        PurchasesOrchestrator$collectDeviceIdentifiers$$inlined$log$1 purchasesOrchestrator$collectDeviceIdentifiers$$inlined$log$1 = new PurchasesOrchestrator$collectDeviceIdentifiers$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    str2 = (String) purchasesOrchestrator$collectDeviceIdentifiers$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$collectDeviceIdentifiers$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$collectDeviceIdentifiers$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$collectDeviceIdentifiers$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    str2 = (String) purchasesOrchestrator$collectDeviceIdentifiers$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$collectDeviceIdentifiers$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$collectDeviceIdentifiers$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    str2 = (String) purchasesOrchestrator$collectDeviceIdentifiers$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    str2 = (String) purchasesOrchestrator$collectDeviceIdentifiers$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$collectDeviceIdentifiers$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$collectDeviceIdentifiers$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$collectDeviceIdentifiers$$inlined$log$1.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.collectDeviceIdentifiers(getAppUserID(), this.application);
    }

    public final synchronized boolean getAllowSharingPlayStoreAccount() {
        Boolean allowSharingPlayStoreAccount;
        try {
            allowSharingPlayStoreAccount = getState$purchases_defaultsRelease().getAllowSharingPlayStoreAccount();
        } catch (Throwable th) {
            throw th;
        }
        return allowSharingPlayStoreAccount != null ? allowSharingPlayStoreAccount.booleanValue() : this.identityManager.currentUserIsAnonymous();
    }

    public final void getAmazonLWAConsentStatus(GetAmazonLWAConsentStatusCallback callback) {
        r.f(callback, "callback");
        this.billing.getAmazonLWAConsentStatus(new C11061(callback), new C11072(callback));
    }

    public final AppConfig getAppConfig() {
        return this.appConfig;
    }

    public final synchronized String getAppUserID() {
        return this.identityManager.getCurrentAppUserID();
    }

    public final DownloadedFontFamily getCachedFontFamilyOrStartDownload(UiConfig.AppConfig.FontsConfig.FontInfo.Name fontInfo) {
        r.f(fontInfo, "fontInfo");
        return this.fontLoader.getCachedFontFamilyOrStartDownload(fontInfo);
    }

    public final VirtualCurrencies getCachedVirtualCurrencies() {
        return this.virtualCurrencyManager.cachedVirtualCurrencies();
    }

    public final PurchasesConfiguration getCurrentConfiguration() {
        return this.initialConfiguration.getAppUserID() == null ? this.initialConfiguration : PurchasesConfiguration.copy$purchases_defaultsRelease$default(this.initialConfiguration, getAppUserID(), null, 2, null);
    }

    public final void getCustomerCenterConfig(GetCustomerCenterConfigCallback callback) {
        r.f(callback, "callback");
        this.backend.getCustomerCenterConfig(this.identityManager.getCurrentAppUserID(), new C11081(callback), new C11092(callback));
    }

    public final synchronized CustomerCenterListener getCustomerCenterListener() {
        return this.customerCenterListener;
    }

    public final synchronized boolean getFinishTransactions() {
        return this.appConfig.getFinishTransactions();
    }

    public final void getOfferings(ReceiveOfferingsCallback listener, boolean z4) {
        r.f(listener, "listener");
        this.offeringsManager.getOfferings(this.identityManager.getCurrentAppUserID(), getState$purchases_defaultsRelease().getAppInBackground(), new C11101(listener), new C11112(listener), z4);
    }

    public final OfflineEntitlementsManager getOfflineEntitlementsManager() {
        return this.offlineEntitlementsManager;
    }

    public final String getPreferredUILocaleOverride() {
        return this._preferredUILocaleOverride;
    }

    public final Function0 getProcessLifecycleOwnerProvider() {
        return this.processLifecycleOwnerProvider;
    }

    public final void getProducts(List<String> productIds, ProductType productType, final GetStoreProductsCallback callback) {
        Set<? extends ProductType> setE;
        r.f(productIds, "productIds");
        r.f(callback, "callback");
        if (productType == null || (setE = P.a(productType)) == null) {
            setE = Q.e(ProductType.SUBS, ProductType.INAPP);
        }
        getProductsOfTypes(x.l0(productIds), setE, new GetStoreProductsCallback() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.getProducts.1
            @Override // com.revenuecat.purchases.interfaces.GetStoreProductsCallback
            public void onError(PurchasesError error) {
                r.f(error, "error");
                callback.onError(error);
            }

            @Override // com.revenuecat.purchases.interfaces.GetStoreProductsCallback
            public void onReceived(List<? extends StoreProduct> storeProducts) {
                r.f(storeProducts, "storeProducts");
                callback.onReceived(storeProducts);
            }
        });
    }

    public final PurchasesState getState$purchases_defaultsRelease() {
        return this.purchasesStateCache.getPurchasesState();
    }

    public final Store getStore() {
        return this.appConfig.getStore();
    }

    public final String getStorefrontCountryCode() {
        return this.storefrontCountryCode;
    }

    public final synchronized UpdatedCustomerInfoListener getUpdatedCustomerInfoListener() {
        return this.customerInfoUpdateHandler.getUpdatedCustomerInfoListener();
    }

    public final void getVirtualCurrencies(GetVirtualCurrenciesCallback callback) {
        r.f(callback, "callback");
        this.virtualCurrencyManager.virtualCurrencies(callback);
    }

    public final void invalidateCustomerInfoCache() {
        LogHandler currentLogHandler;
        String str;
        String str2;
        LogIntent logIntent = LogIntent.DEBUG;
        PurchasesOrchestrator$invalidateCustomerInfoCache$$inlined$log$1 purchasesOrchestrator$invalidateCustomerInfoCache$$inlined$log$1 = new PurchasesOrchestrator$invalidateCustomerInfoCache$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    str2 = (String) purchasesOrchestrator$invalidateCustomerInfoCache$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$invalidateCustomerInfoCache$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$invalidateCustomerInfoCache$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$invalidateCustomerInfoCache$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    str2 = (String) purchasesOrchestrator$invalidateCustomerInfoCache$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$invalidateCustomerInfoCache$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$invalidateCustomerInfoCache$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    str2 = (String) purchasesOrchestrator$invalidateCustomerInfoCache$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    str2 = (String) purchasesOrchestrator$invalidateCustomerInfoCache$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$invalidateCustomerInfoCache$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$invalidateCustomerInfoCache$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$invalidateCustomerInfoCache$$inlined$log$1.invoke(), null);
                break;
        }
        this.deviceCache.clearCustomerInfoCache(getAppUserID());
    }

    public final void invalidateVirtualCurrenciesCache() {
        this.virtualCurrencyManager.invalidateVirtualCurrenciesCache();
    }

    public final boolean isAnonymous() {
        return this.identityManager.currentUserIsAnonymous();
    }

    public final void logIn(String newAppUserID, LogInCallback logInCallback) {
        r.f(newAppUserID, "newAppUserID");
        String currentAppUserID = this.identityManager.getCurrentAppUserID();
        E e4 = null;
        if (r.b(currentAppUserID, newAppUserID)) {
            currentAppUserID = null;
        }
        if (currentAppUserID != null) {
            this.blockstoreHelper.clearUserIdBackupIfNeeded(new PurchasesOrchestrator$logIn$2$1(this, newAppUserID, logInCallback));
            e4 = E.f5463a;
        }
        if (e4 == null) {
            CustomerInfoHelper.retrieveCustomerInfo$default(this.customerInfoHelper, this.identityManager.getCurrentAppUserID(), CacheFetchPolicy.Companion.m41default(), getState$purchases_defaultsRelease().getAppInBackground(), getAllowSharingPlayStoreAccount(), false, ListenerConversionsCommonKt.receiveCustomerInfoCallback(new C11143(logInCallback), new C11154(logInCallback)), 16, null);
        }
    }

    public final void logOut(ReceiveCustomerInfoCallback receiveCustomerInfoCallback) {
        this.identityManager.logOut(new C11161(receiveCustomerInfoCallback, this));
    }

    @Override // com.revenuecat.purchases.utils.CustomActivityLifecycleHandler, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        r.f(activity, "activity");
        if (this.appConfig.getShowInAppMessagesAutomatically()) {
            showInAppMessagesIfNeeded(activity, AbstractC0765l.j0(InAppMessageType.values()));
        }
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public void onAppBackgrounded() {
        LogHandler currentLogHandler;
        String str;
        String str2;
        synchronized (this) {
            setState$purchases_defaultsRelease(PurchasesState.copy$default(getState$purchases_defaultsRelease(), null, null, null, true, false, 23, null));
            E e4 = E.f5463a;
        }
        LogIntent logIntent = LogIntent.DEBUG;
        PurchasesOrchestrator$onAppBackgrounded$$inlined$log$1 purchasesOrchestrator$onAppBackgrounded$$inlined$log$1 = new PurchasesOrchestrator$onAppBackgrounded$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    str2 = (String) purchasesOrchestrator$onAppBackgrounded$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$onAppBackgrounded$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$onAppBackgrounded$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$onAppBackgrounded$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    str2 = (String) purchasesOrchestrator$onAppBackgrounded$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$onAppBackgrounded$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$onAppBackgrounded$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    str2 = (String) purchasesOrchestrator$onAppBackgrounded$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    str2 = (String) purchasesOrchestrator$onAppBackgrounded$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$onAppBackgrounded$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$onAppBackgrounded$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$onAppBackgrounded$$inlined$log$1.invoke(), null);
                break;
        }
        this.appConfig.setAppBackgrounded(true);
        synchronizeSubscriberAttributesIfNeeded();
        flushPaywallEvents();
    }

    @Override // com.revenuecat.purchases.LifecycleDelegate
    public void onAppForegrounded() {
        LogHandler currentLogHandler;
        String str;
        String str2;
        D d4 = new D();
        synchronized (this) {
            d4.f13408a = getState$purchases_defaultsRelease().getFirstTimeInForeground();
            setState$purchases_defaultsRelease(PurchasesState.copy$default(getState$purchases_defaultsRelease(), null, null, null, false, false, 7, null));
            E e4 = E.f5463a;
        }
        LogIntent logIntent = LogIntent.DEBUG;
        PurchasesOrchestrator$onAppForegrounded$$inlined$log$1 purchasesOrchestrator$onAppForegrounded$$inlined$log$1 = new PurchasesOrchestrator$onAppForegrounded$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    str2 = (String) purchasesOrchestrator$onAppForegrounded$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$onAppForegrounded$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$onAppForegrounded$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$onAppForegrounded$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    str2 = (String) purchasesOrchestrator$onAppForegrounded$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$onAppForegrounded$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$onAppForegrounded$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    str2 = (String) purchasesOrchestrator$onAppForegrounded$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    str2 = (String) purchasesOrchestrator$onAppForegrounded$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$onAppForegrounded$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$onAppForegrounded$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$onAppForegrounded$$inlined$log$1.invoke(), null);
                break;
        }
        this.appConfig.setAppBackgrounded(false);
        enqueue(new C11173(d4));
    }

    public final boolean overridePreferredUILocale(String str) {
        if (r.b(this._preferredUILocaleOverride, str)) {
            LogLevel logLevel = LogLevel.DEBUG;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) > 0) {
                return false;
            }
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "Locale unchanged, no fresh fetch needed");
            return false;
        }
        synchronized (this) {
            this._preferredUILocaleOverride = str;
            this.localeProvider.setPreferredLocaleOverride(str);
            E e4 = E.f5463a;
        }
        LogLevel logLevel2 = LogLevel.DEBUG;
        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
            currentLogHandler2.d("[Purchases] - " + logLevel2.name(), "Locale changed, attempting to fetch fresh offerings");
        }
        return fetchOfferingsWithRateLimit(C11184.INSTANCE);
    }

    public final void purchase(PurchaseParams purchaseParams, PurchaseCallback callback) {
        E e4;
        r.f(purchaseParams, "purchaseParams");
        r.f(callback, "callback");
        String oldProductId = purchaseParams.getOldProductId();
        if (oldProductId != null) {
            startProductChange(purchaseParams.getActivity$purchases_defaultsRelease(), purchaseParams.getPurchasingData$purchases_defaultsRelease(), purchaseParams.getPresentedOfferingContext$purchases_defaultsRelease(), oldProductId, purchaseParams.getGoogleReplacementMode(), purchaseParams.isPersonalizedPrice(), callback);
            e4 = E.f5463a;
        } else {
            e4 = null;
        }
        if (e4 == null) {
            startPurchase(purchaseParams.getActivity$purchases_defaultsRelease(), purchaseParams.getPurchasingData$purchases_defaultsRelease(), purchaseParams.getPresentedOfferingContext$purchases_defaultsRelease(), purchaseParams.isPersonalizedPrice(), callback);
        }
    }

    public final void redeemWebPurchase(WebPurchaseRedemption webPurchaseRedemption, RedeemWebPurchaseListener listener) {
        r.f(webPurchaseRedemption, "webPurchaseRedemption");
        r.f(listener, "listener");
        this.webPurchaseRedemptionHelper.handleRedeemWebPurchase(webPurchaseRedemption, listener);
    }

    public final void removeUpdatedCustomerInfoListener() {
        setUpdatedCustomerInfoListener(null);
    }

    public final void restorePurchases(final ReceiveCustomerInfoCallback callback) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        r.f(callback, "callback");
        LogIntent logIntent = LogIntent.DEBUG;
        PurchasesOrchestrator$restorePurchases$$inlined$log$1 purchasesOrchestrator$restorePurchases$$inlined$log$1 = new PurchasesOrchestrator$restorePurchases$$inlined$log$1(logIntent);
        int[] iArr = LogWrapperKt.WhenMappings.$EnumSwitchMapping$0;
        switch (iArr[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    str2 = (String) purchasesOrchestrator$restorePurchases$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$restorePurchases$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$restorePurchases$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$restorePurchases$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    str2 = (String) purchasesOrchestrator$restorePurchases$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$restorePurchases$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$restorePurchases$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    str2 = (String) purchasesOrchestrator$restorePurchases$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    str2 = (String) purchasesOrchestrator$restorePurchases$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$restorePurchases$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$restorePurchases$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$restorePurchases$$inlined$log$1.invoke(), null);
                break;
        }
        if (!getAllowSharingPlayStoreAccount()) {
            LogIntent logIntent2 = LogIntent.WARNING;
            PurchasesOrchestrator$restorePurchases$$inlined$log$2 purchasesOrchestrator$restorePurchases$$inlined$log$2 = new PurchasesOrchestrator$restorePurchases$$inlined$log$2(logIntent2);
            switch (iArr[logIntent2.ordinal()]) {
                case 1:
                    LogLevel logLevel10 = LogLevel.DEBUG;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                        currentLogHandler7.d("[Purchases] - " + logLevel10.name(), (String) purchasesOrchestrator$restorePurchases$$inlined$log$2.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$restorePurchases$$inlined$log$2.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel11 = LogLevel.WARN;
                    LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                        currentLogHandler8.w("[Purchases] - " + logLevel11.name(), (String) purchasesOrchestrator$restorePurchases$$inlined$log$2.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel12 = LogLevel.INFO;
                    LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                        currentLogHandler9.i("[Purchases] - " + logLevel12.name(), (String) purchasesOrchestrator$restorePurchases$$inlined$log$2.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel13 = LogLevel.DEBUG;
                    LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                        currentLogHandler10.d("[Purchases] - " + logLevel13.name(), (String) purchasesOrchestrator$restorePurchases$$inlined$log$2.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$restorePurchases$$inlined$log$2.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel14 = LogLevel.INFO;
                    LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                        currentLogHandler11.i("[Purchases] - " + logLevel14.name(), (String) purchasesOrchestrator$restorePurchases$$inlined$log$2.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel15 = LogLevel.DEBUG;
                    LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                        currentLogHandler12.d("[Purchases] - " + logLevel15.name(), (String) purchasesOrchestrator$restorePurchases$$inlined$log$2.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel16 = LogLevel.DEBUG;
                    LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                        currentLogHandler13.d("[Purchases] - " + logLevel16.name(), (String) purchasesOrchestrator$restorePurchases$$inlined$log$2.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel17 = LogLevel.WARN;
                    LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                        currentLogHandler14.w("[Purchases] - " + logLevel17.name(), (String) purchasesOrchestrator$restorePurchases$$inlined$log$2.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel18 = LogLevel.WARN;
                    LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                        currentLogHandler15.w("[Purchases] - " + logLevel18.name(), (String) purchasesOrchestrator$restorePurchases$$inlined$log$2.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$restorePurchases$$inlined$log$2.invoke(), null);
                    break;
            }
        }
        if (!((Boolean) this.isSimulatedStoreEnabled.invoke()).booleanValue() || this.appConfig.getApiKeyValidationResult() != APIKeyValidator.ValidationResult.SIMULATED_STORE) {
            final Date now = this.dateProvider.getNow();
            DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
            if (diagnosticsTracker != null) {
                diagnosticsTracker.trackRestorePurchasesStarted();
            }
            String currentAppUserID = this.identityManager.getCurrentAppUserID();
            if (this.diagnosticsTrackerIfEnabled != null) {
                callback = new ReceiveCustomerInfoCallback() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$restorePurchases$callbackWithTracking$1
                    @Override // com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
                    public void onError(PurchasesError error) {
                        r.f(error, "error");
                        this.this$0.diagnosticsTrackerIfEnabled.m113trackRestorePurchasesResultSxA4cEA(Integer.valueOf(error.getCode().getCode()), error.getMessage(), DurationExtensionsKt.between(C1779a.f14679b, now, this.this$0.dateProvider.getNow()));
                        callback.onError(error);
                    }

                    @Override // com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
                    public void onReceived(CustomerInfo customerInfo) {
                        r.f(customerInfo, "customerInfo");
                        this.this$0.diagnosticsTrackerIfEnabled.m113trackRestorePurchasesResultSxA4cEA(null, null, DurationExtensionsKt.between(C1779a.f14679b, now, this.this$0.dateProvider.getNow()));
                        callback.onReceived(customerInfo);
                    }
                };
            }
            this.blockstoreHelper.aliasCurrentAndStoredUserIdsIfNeeded(new C11214(currentAppUserID, callback));
            return;
        }
        PurchasesOrchestrator$restorePurchases$$inlined$log$3 purchasesOrchestrator$restorePurchases$$inlined$log$3 = new PurchasesOrchestrator$restorePurchases$$inlined$log$3(logIntent);
        switch (iArr[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel19 = LogLevel.DEBUG;
                LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                    currentLogHandler16.d("[Purchases] - " + logLevel19.name(), (String) purchasesOrchestrator$restorePurchases$$inlined$log$3.invoke());
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$restorePurchases$$inlined$log$3.invoke(), null);
                break;
            case 3:
                LogLevel logLevel20 = LogLevel.WARN;
                LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                    currentLogHandler17.w("[Purchases] - " + logLevel20.name(), (String) purchasesOrchestrator$restorePurchases$$inlined$log$3.invoke());
                }
                break;
            case 4:
                LogLevel logLevel21 = LogLevel.INFO;
                LogHandler currentLogHandler18 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel21) <= 0) {
                    currentLogHandler18.i("[Purchases] - " + logLevel21.name(), (String) purchasesOrchestrator$restorePurchases$$inlined$log$3.invoke());
                }
                break;
            case 5:
                LogLevel logLevel22 = LogLevel.DEBUG;
                LogHandler currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel22) <= 0) {
                    currentLogHandler19.d("[Purchases] - " + logLevel22.name(), (String) purchasesOrchestrator$restorePurchases$$inlined$log$3.invoke());
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$restorePurchases$$inlined$log$3.invoke(), null);
                break;
            case 7:
                LogLevel logLevel23 = LogLevel.INFO;
                LogHandler currentLogHandler20 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel23) <= 0) {
                    currentLogHandler20.i("[Purchases] - " + logLevel23.name(), (String) purchasesOrchestrator$restorePurchases$$inlined$log$3.invoke());
                }
                break;
            case 8:
                LogLevel logLevel24 = LogLevel.DEBUG;
                LogHandler currentLogHandler21 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel24) <= 0) {
                    currentLogHandler21.d("[Purchases] - " + logLevel24.name(), (String) purchasesOrchestrator$restorePurchases$$inlined$log$3.invoke());
                }
                break;
            case 9:
                LogLevel logLevel25 = LogLevel.DEBUG;
                LogHandler currentLogHandler22 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel25) <= 0) {
                    currentLogHandler22.d("[Purchases] - " + logLevel25.name(), (String) purchasesOrchestrator$restorePurchases$$inlined$log$3.invoke());
                }
                break;
            case 10:
                LogLevel logLevel26 = LogLevel.WARN;
                LogHandler currentLogHandler23 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel26) <= 0) {
                    currentLogHandler23.w("[Purchases] - " + logLevel26.name(), (String) purchasesOrchestrator$restorePurchases$$inlined$log$3.invoke());
                }
                break;
            case 11:
                LogLevel logLevel27 = LogLevel.WARN;
                LogHandler currentLogHandler24 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel27) <= 0) {
                    currentLogHandler24.w("[Purchases] - " + logLevel27.name(), (String) purchasesOrchestrator$restorePurchases$$inlined$log$3.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$restorePurchases$$inlined$log$3.invoke(), null);
                break;
        }
        getCustomerInfo(callback);
    }

    public final void setAd(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        LogIntent logIntent = LogIntent.DEBUG;
        PurchasesOrchestrator$setAd$$inlined$log$1 purchasesOrchestrator$setAd$$inlined$log$1 = new PurchasesOrchestrator$setAd$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) purchasesOrchestrator$setAd$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setAd$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$setAd$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$setAd$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) purchasesOrchestrator$setAd$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setAd$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$setAd$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) purchasesOrchestrator$setAd$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) purchasesOrchestrator$setAd$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$setAd$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$setAd$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setAd$$inlined$log$1.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.Ad.INSTANCE, str, getAppUserID());
    }

    public final void setAdGroup(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        LogIntent logIntent = LogIntent.DEBUG;
        PurchasesOrchestrator$setAdGroup$$inlined$log$1 purchasesOrchestrator$setAdGroup$$inlined$log$1 = new PurchasesOrchestrator$setAdGroup$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) purchasesOrchestrator$setAdGroup$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setAdGroup$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$setAdGroup$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$setAdGroup$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) purchasesOrchestrator$setAdGroup$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setAdGroup$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$setAdGroup$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) purchasesOrchestrator$setAdGroup$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) purchasesOrchestrator$setAdGroup$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$setAdGroup$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$setAdGroup$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setAdGroup$$inlined$log$1.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.AdGroup.INSTANCE, str, getAppUserID());
    }

    public final void setAdjustID(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        LogIntent logIntent = LogIntent.DEBUG;
        PurchasesOrchestrator$setAdjustID$$inlined$log$1 purchasesOrchestrator$setAdjustID$$inlined$log$1 = new PurchasesOrchestrator$setAdjustID$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) purchasesOrchestrator$setAdjustID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setAdjustID$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$setAdjustID$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$setAdjustID$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) purchasesOrchestrator$setAdjustID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setAdjustID$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$setAdjustID$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) purchasesOrchestrator$setAdjustID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) purchasesOrchestrator$setAdjustID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$setAdjustID$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$setAdjustID$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setAdjustID$$inlined$log$1.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.Adjust.INSTANCE, str, getAppUserID(), this.application);
    }

    public final void setAirshipChannelID(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        LogIntent logIntent = LogIntent.DEBUG;
        PurchasesOrchestrator$setAirshipChannelID$$inlined$log$1 purchasesOrchestrator$setAirshipChannelID$$inlined$log$1 = new PurchasesOrchestrator$setAirshipChannelID$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) purchasesOrchestrator$setAirshipChannelID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setAirshipChannelID$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$setAirshipChannelID$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$setAirshipChannelID$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) purchasesOrchestrator$setAirshipChannelID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setAirshipChannelID$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$setAirshipChannelID$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) purchasesOrchestrator$setAirshipChannelID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) purchasesOrchestrator$setAirshipChannelID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$setAirshipChannelID$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$setAirshipChannelID$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setAirshipChannelID$$inlined$log$1.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.IntegrationIds.Airship.INSTANCE, str, getAppUserID());
    }

    public final synchronized void setAllowSharingPlayStoreAccount(boolean z4) {
        setState$purchases_defaultsRelease(PurchasesState.copy$default(getState$purchases_defaultsRelease(), Boolean.valueOf(z4), null, null, false, false, 30, null));
    }

    public final void setAppConfig(AppConfig appConfig) {
        r.f(appConfig, "<set-?>");
        this.appConfig = appConfig;
    }

    public final void setAppsflyerID(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        LogIntent logIntent = LogIntent.DEBUG;
        PurchasesOrchestrator$setAppsflyerID$$inlined$log$1 purchasesOrchestrator$setAppsflyerID$$inlined$log$1 = new PurchasesOrchestrator$setAppsflyerID$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) purchasesOrchestrator$setAppsflyerID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setAppsflyerID$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$setAppsflyerID$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$setAppsflyerID$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) purchasesOrchestrator$setAppsflyerID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setAppsflyerID$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$setAppsflyerID$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) purchasesOrchestrator$setAppsflyerID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) purchasesOrchestrator$setAppsflyerID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$setAppsflyerID$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$setAppsflyerID$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setAppsflyerID$$inlined$log$1.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.AppsFlyer.INSTANCE, str, getAppUserID(), this.application);
    }

    public final void setAttributes(Map<String, String> attributes) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        r.f(attributes, "attributes");
        LogIntent logIntent = LogIntent.DEBUG;
        PurchasesOrchestrator$setAttributes$$inlined$log$1 purchasesOrchestrator$setAttributes$$inlined$log$1 = new PurchasesOrchestrator$setAttributes$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    str2 = (String) purchasesOrchestrator$setAttributes$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setAttributes$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$setAttributes$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$setAttributes$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    str2 = (String) purchasesOrchestrator$setAttributes$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setAttributes$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$setAttributes$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    str2 = (String) purchasesOrchestrator$setAttributes$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    str2 = (String) purchasesOrchestrator$setAttributes$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$setAttributes$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$setAttributes$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setAttributes$$inlined$log$1.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttributes(attributes, getAppUserID());
    }

    public final void setCampaign(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        LogIntent logIntent = LogIntent.DEBUG;
        PurchasesOrchestrator$setCampaign$$inlined$log$1 purchasesOrchestrator$setCampaign$$inlined$log$1 = new PurchasesOrchestrator$setCampaign$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) purchasesOrchestrator$setCampaign$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setCampaign$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$setCampaign$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$setCampaign$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) purchasesOrchestrator$setCampaign$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setCampaign$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$setCampaign$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) purchasesOrchestrator$setCampaign$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) purchasesOrchestrator$setCampaign$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$setCampaign$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$setCampaign$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setCampaign$$inlined$log$1.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.Campaign.INSTANCE, str, getAppUserID());
    }

    public final void setCleverTapID(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        LogIntent logIntent = LogIntent.DEBUG;
        PurchasesOrchestrator$setCleverTapID$$inlined$log$1 purchasesOrchestrator$setCleverTapID$$inlined$log$1 = new PurchasesOrchestrator$setCleverTapID$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) purchasesOrchestrator$setCleverTapID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setCleverTapID$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$setCleverTapID$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$setCleverTapID$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) purchasesOrchestrator$setCleverTapID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setCleverTapID$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$setCleverTapID$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) purchasesOrchestrator$setCleverTapID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) purchasesOrchestrator$setCleverTapID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$setCleverTapID$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$setCleverTapID$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setCleverTapID$$inlined$log$1.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.CleverTap.INSTANCE, str, getAppUserID(), this.application);
    }

    public final void setCreative(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        LogIntent logIntent = LogIntent.DEBUG;
        PurchasesOrchestrator$setCreative$$inlined$log$1 purchasesOrchestrator$setCreative$$inlined$log$1 = new PurchasesOrchestrator$setCreative$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) purchasesOrchestrator$setCreative$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setCreative$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$setCreative$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$setCreative$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) purchasesOrchestrator$setCreative$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setCreative$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$setCreative$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) purchasesOrchestrator$setCreative$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) purchasesOrchestrator$setCreative$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$setCreative$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$setCreative$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setCreative$$inlined$log$1.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.Creative.INSTANCE, str, getAppUserID());
    }

    public final synchronized void setCustomerCenterListener(CustomerCenterListener customerCenterListener) {
        this.customerCenterListener = customerCenterListener;
    }

    public final void setDisplayName(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        LogIntent logIntent = LogIntent.DEBUG;
        PurchasesOrchestrator$setDisplayName$$inlined$log$1 purchasesOrchestrator$setDisplayName$$inlined$log$1 = new PurchasesOrchestrator$setDisplayName$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) purchasesOrchestrator$setDisplayName$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setDisplayName$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$setDisplayName$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$setDisplayName$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) purchasesOrchestrator$setDisplayName$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setDisplayName$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$setDisplayName$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) purchasesOrchestrator$setDisplayName$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) purchasesOrchestrator$setDisplayName$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$setDisplayName$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$setDisplayName$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setDisplayName$$inlined$log$1.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.DisplayName.INSTANCE, str, getAppUserID());
    }

    public final void setEmail(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        LogIntent logIntent = LogIntent.DEBUG;
        PurchasesOrchestrator$setEmail$$inlined$log$1 purchasesOrchestrator$setEmail$$inlined$log$1 = new PurchasesOrchestrator$setEmail$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) purchasesOrchestrator$setEmail$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setEmail$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$setEmail$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$setEmail$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) purchasesOrchestrator$setEmail$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setEmail$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$setEmail$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) purchasesOrchestrator$setEmail$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) purchasesOrchestrator$setEmail$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$setEmail$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$setEmail$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setEmail$$inlined$log$1.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.Email.INSTANCE, str, getAppUserID());
    }

    public final void setFBAnonymousID(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        LogIntent logIntent = LogIntent.DEBUG;
        PurchasesOrchestrator$setFBAnonymousID$$inlined$log$1 purchasesOrchestrator$setFBAnonymousID$$inlined$log$1 = new PurchasesOrchestrator$setFBAnonymousID$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) purchasesOrchestrator$setFBAnonymousID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setFBAnonymousID$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$setFBAnonymousID$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$setFBAnonymousID$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) purchasesOrchestrator$setFBAnonymousID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setFBAnonymousID$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$setFBAnonymousID$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) purchasesOrchestrator$setFBAnonymousID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) purchasesOrchestrator$setFBAnonymousID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$setFBAnonymousID$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$setFBAnonymousID$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setFBAnonymousID$$inlined$log$1.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.Facebook.INSTANCE, str, getAppUserID(), this.application);
    }

    public final synchronized void setFinishTransactions(boolean z4) {
        this.appConfig.setFinishTransactions(z4);
    }

    public final void setFirebaseAppInstanceID(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        LogIntent logIntent = LogIntent.DEBUG;
        PurchasesOrchestrator$setFirebaseAppInstanceID$$inlined$log$1 purchasesOrchestrator$setFirebaseAppInstanceID$$inlined$log$1 = new PurchasesOrchestrator$setFirebaseAppInstanceID$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) purchasesOrchestrator$setFirebaseAppInstanceID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setFirebaseAppInstanceID$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$setFirebaseAppInstanceID$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$setFirebaseAppInstanceID$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) purchasesOrchestrator$setFirebaseAppInstanceID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setFirebaseAppInstanceID$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$setFirebaseAppInstanceID$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) purchasesOrchestrator$setFirebaseAppInstanceID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) purchasesOrchestrator$setFirebaseAppInstanceID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$setFirebaseAppInstanceID$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$setFirebaseAppInstanceID$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setFirebaseAppInstanceID$$inlined$log$1.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.IntegrationIds.FirebaseAppInstanceId.INSTANCE, str, getAppUserID());
    }

    public final void setKeyword(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        LogIntent logIntent = LogIntent.DEBUG;
        PurchasesOrchestrator$setKeyword$$inlined$log$1 purchasesOrchestrator$setKeyword$$inlined$log$1 = new PurchasesOrchestrator$setKeyword$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) purchasesOrchestrator$setKeyword$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setKeyword$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$setKeyword$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$setKeyword$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) purchasesOrchestrator$setKeyword$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setKeyword$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$setKeyword$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) purchasesOrchestrator$setKeyword$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) purchasesOrchestrator$setKeyword$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$setKeyword$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$setKeyword$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setKeyword$$inlined$log$1.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.Keyword.INSTANCE, str, getAppUserID());
    }

    public final void setKochavaDeviceID(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        LogIntent logIntent = LogIntent.DEBUG;
        PurchasesOrchestrator$setKochavaDeviceID$$inlined$log$1 purchasesOrchestrator$setKochavaDeviceID$$inlined$log$1 = new PurchasesOrchestrator$setKochavaDeviceID$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) purchasesOrchestrator$setKochavaDeviceID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setKochavaDeviceID$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$setKochavaDeviceID$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$setKochavaDeviceID$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) purchasesOrchestrator$setKochavaDeviceID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setKochavaDeviceID$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$setKochavaDeviceID$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) purchasesOrchestrator$setKochavaDeviceID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) purchasesOrchestrator$setKochavaDeviceID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$setKochavaDeviceID$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$setKochavaDeviceID$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setKochavaDeviceID$$inlined$log$1.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.Kochava.INSTANCE, str, getAppUserID(), this.application);
    }

    public final void setMediaSource(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        LogIntent logIntent = LogIntent.DEBUG;
        PurchasesOrchestrator$setMediaSource$$inlined$log$1 purchasesOrchestrator$setMediaSource$$inlined$log$1 = new PurchasesOrchestrator$setMediaSource$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) purchasesOrchestrator$setMediaSource$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setMediaSource$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$setMediaSource$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$setMediaSource$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) purchasesOrchestrator$setMediaSource$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setMediaSource$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$setMediaSource$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) purchasesOrchestrator$setMediaSource$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) purchasesOrchestrator$setMediaSource$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$setMediaSource$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$setMediaSource$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setMediaSource$$inlined$log$1.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.CampaignParameters.MediaSource.INSTANCE, str, getAppUserID());
    }

    public final void setMixpanelDistinctID(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        LogIntent logIntent = LogIntent.DEBUG;
        PurchasesOrchestrator$setMixpanelDistinctID$$inlined$log$1 purchasesOrchestrator$setMixpanelDistinctID$$inlined$log$1 = new PurchasesOrchestrator$setMixpanelDistinctID$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) purchasesOrchestrator$setMixpanelDistinctID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setMixpanelDistinctID$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$setMixpanelDistinctID$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$setMixpanelDistinctID$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) purchasesOrchestrator$setMixpanelDistinctID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setMixpanelDistinctID$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$setMixpanelDistinctID$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) purchasesOrchestrator$setMixpanelDistinctID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) purchasesOrchestrator$setMixpanelDistinctID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$setMixpanelDistinctID$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$setMixpanelDistinctID$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setMixpanelDistinctID$$inlined$log$1.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.IntegrationIds.MixpanelDistinctId.INSTANCE, str, getAppUserID());
    }

    public final void setMparticleID(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        LogIntent logIntent = LogIntent.DEBUG;
        PurchasesOrchestrator$setMparticleID$$inlined$log$1 purchasesOrchestrator$setMparticleID$$inlined$log$1 = new PurchasesOrchestrator$setMparticleID$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) purchasesOrchestrator$setMparticleID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setMparticleID$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$setMparticleID$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$setMparticleID$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) purchasesOrchestrator$setMparticleID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setMparticleID$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$setMparticleID$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) purchasesOrchestrator$setMparticleID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) purchasesOrchestrator$setMparticleID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$setMparticleID$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$setMparticleID$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setMparticleID$$inlined$log$1.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttributionID(SubscriberAttributeKey.AttributionIds.Mparticle.INSTANCE, str, getAppUserID(), this.application);
    }

    public final void setOnesignalID(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        LogIntent logIntent = LogIntent.DEBUG;
        PurchasesOrchestrator$setOnesignalID$$inlined$log$1 purchasesOrchestrator$setOnesignalID$$inlined$log$1 = new PurchasesOrchestrator$setOnesignalID$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) purchasesOrchestrator$setOnesignalID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setOnesignalID$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$setOnesignalID$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$setOnesignalID$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) purchasesOrchestrator$setOnesignalID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setOnesignalID$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$setOnesignalID$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) purchasesOrchestrator$setOnesignalID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) purchasesOrchestrator$setOnesignalID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$setOnesignalID$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$setOnesignalID$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setOnesignalID$$inlined$log$1.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.IntegrationIds.OneSignal.INSTANCE, str, getAppUserID());
    }

    public final void setOnesignalUserID(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        LogIntent logIntent = LogIntent.DEBUG;
        PurchasesOrchestrator$setOnesignalUserID$$inlined$log$1 purchasesOrchestrator$setOnesignalUserID$$inlined$log$1 = new PurchasesOrchestrator$setOnesignalUserID$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) purchasesOrchestrator$setOnesignalUserID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setOnesignalUserID$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$setOnesignalUserID$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$setOnesignalUserID$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) purchasesOrchestrator$setOnesignalUserID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setOnesignalUserID$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$setOnesignalUserID$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) purchasesOrchestrator$setOnesignalUserID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) purchasesOrchestrator$setOnesignalUserID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$setOnesignalUserID$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$setOnesignalUserID$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setOnesignalUserID$$inlined$log$1.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.IntegrationIds.OneSignalUserId.INSTANCE, str, getAppUserID());
    }

    public final void setPhoneNumber(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        LogIntent logIntent = LogIntent.DEBUG;
        PurchasesOrchestrator$setPhoneNumber$$inlined$log$1 purchasesOrchestrator$setPhoneNumber$$inlined$log$1 = new PurchasesOrchestrator$setPhoneNumber$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) purchasesOrchestrator$setPhoneNumber$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setPhoneNumber$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$setPhoneNumber$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$setPhoneNumber$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) purchasesOrchestrator$setPhoneNumber$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setPhoneNumber$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$setPhoneNumber$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) purchasesOrchestrator$setPhoneNumber$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) purchasesOrchestrator$setPhoneNumber$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$setPhoneNumber$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$setPhoneNumber$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setPhoneNumber$$inlined$log$1.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.PhoneNumber.INSTANCE, str, getAppUserID());
    }

    public final void setPostHogUserId(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        LogIntent logIntent = LogIntent.DEBUG;
        PurchasesOrchestrator$setPostHogUserId$$inlined$log$1 purchasesOrchestrator$setPostHogUserId$$inlined$log$1 = new PurchasesOrchestrator$setPostHogUserId$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) purchasesOrchestrator$setPostHogUserId$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setPostHogUserId$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$setPostHogUserId$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$setPostHogUserId$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) purchasesOrchestrator$setPostHogUserId$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setPostHogUserId$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$setPostHogUserId$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) purchasesOrchestrator$setPostHogUserId$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) purchasesOrchestrator$setPostHogUserId$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$setPostHogUserId$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$setPostHogUserId$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setPostHogUserId$$inlined$log$1.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.IntegrationIds.PostHogUserId.INSTANCE, str, getAppUserID());
    }

    public final void setPushToken(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        LogIntent logIntent = LogIntent.DEBUG;
        PurchasesOrchestrator$setPushToken$$inlined$log$1 purchasesOrchestrator$setPushToken$$inlined$log$1 = new PurchasesOrchestrator$setPushToken$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) purchasesOrchestrator$setPushToken$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setPushToken$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$setPushToken$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$setPushToken$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) purchasesOrchestrator$setPushToken$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setPushToken$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$setPushToken$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) purchasesOrchestrator$setPushToken$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) purchasesOrchestrator$setPushToken$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$setPushToken$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$setPushToken$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setPushToken$$inlined$log$1.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.FCMTokens.INSTANCE, str, getAppUserID());
    }

    public final void setState$purchases_defaultsRelease(PurchasesState value) {
        r.f(value, "value");
        this.purchasesStateCache.setPurchasesState(value);
    }

    public final void setTenjinAnalyticsInstallationID(String str) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        LogIntent logIntent = LogIntent.DEBUG;
        PurchasesOrchestrator$setTenjinAnalyticsInstallationID$$inlined$log$1 purchasesOrchestrator$setTenjinAnalyticsInstallationID$$inlined$log$1 = new PurchasesOrchestrator$setTenjinAnalyticsInstallationID$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) purchasesOrchestrator$setTenjinAnalyticsInstallationID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setTenjinAnalyticsInstallationID$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$setTenjinAnalyticsInstallationID$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$setTenjinAnalyticsInstallationID$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) purchasesOrchestrator$setTenjinAnalyticsInstallationID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setTenjinAnalyticsInstallationID$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$setTenjinAnalyticsInstallationID$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) purchasesOrchestrator$setTenjinAnalyticsInstallationID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) purchasesOrchestrator$setTenjinAnalyticsInstallationID$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$setTenjinAnalyticsInstallationID$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$setTenjinAnalyticsInstallationID$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$setTenjinAnalyticsInstallationID$$inlined$log$1.invoke(), null);
                break;
        }
        this.subscriberAttributesManager.setAttribute(SubscriberAttributeKey.IntegrationIds.TenjinAnalyticsInstallationId.INSTANCE, str, getAppUserID());
    }

    public final synchronized void setUpdatedCustomerInfoListener(UpdatedCustomerInfoListener updatedCustomerInfoListener) {
        this.customerInfoUpdateHandler.setUpdatedCustomerInfoListener(updatedCustomerInfoListener);
    }

    public final void showInAppMessagesIfNeeded(Activity activity, List<? extends InAppMessageType> inAppMessageTypes) {
        r.f(activity, "activity");
        r.f(inAppMessageTypes, "inAppMessageTypes");
        this.billing.showInAppMessagesIfNeeded(activity, inAppMessageTypes, new C11221());
    }

    public final void switchUser(String newAppUserID) {
        r.f(newAppUserID, "newAppUserID");
        if (!r.b(this.identityManager.getCurrentAppUserID(), newAppUserID)) {
            this.identityManager.switchUser(newAppUserID);
            OfferingsManager.fetchAndCacheOfferings$default(this.offeringsManager, newAppUserID, getState$purchases_defaultsRelease().getAppInBackground(), null, null, 12, null);
            return;
        }
        LogLevel logLevel = LogLevel.WARN;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            String str = "[Purchases] - " + logLevel.name();
            String str2 = String.format(IdentityStrings.SWITCHING_USER_SAME_APP_USER_ID, Arrays.copyOf(new Object[]{newAppUserID}, 1));
            r.e(str2, "format(this, *args)");
            currentLogHandler.w(str, str2);
        }
    }

    public final void syncAmazonPurchase(String productID, String receiptID, String amazonUserID, String str, Double d4) {
        LogHandler currentLogHandler;
        String str2;
        String str3;
        r.f(productID, "productID");
        r.f(receiptID, "receiptID");
        r.f(amazonUserID, "amazonUserID");
        LogIntent logIntent = LogIntent.DEBUG;
        PurchasesOrchestrator$syncAmazonPurchase$$inlined$log$1 purchasesOrchestrator$syncAmazonPurchase$$inlined$log$1 = new PurchasesOrchestrator$syncAmazonPurchase$$inlined$log$1(logIntent, receiptID, amazonUserID);
        int[] iArr = LogWrapperKt.WhenMappings.$EnumSwitchMapping$0;
        switch (iArr[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str2 = "[Purchases] - " + logLevel.name();
                    str3 = (String) purchasesOrchestrator$syncAmazonPurchase$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$syncAmazonPurchase$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$syncAmazonPurchase$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$syncAmazonPurchase$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str2 = "[Purchases] - " + logLevel4.name();
                    str3 = (String) purchasesOrchestrator$syncAmazonPurchase$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$syncAmazonPurchase$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$syncAmazonPurchase$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str2 = "[Purchases] - " + logLevel6.name();
                    str3 = (String) purchasesOrchestrator$syncAmazonPurchase$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str2 = "[Purchases] - " + logLevel7.name();
                    str3 = (String) purchasesOrchestrator$syncAmazonPurchase$$inlined$log$1.invoke();
                    currentLogHandler.d(str2, str3);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$syncAmazonPurchase$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$syncAmazonPurchase$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$syncAmazonPurchase$$inlined$log$1.invoke(), null);
                break;
        }
        Set<String> previouslySentHashedTokens = this.deviceCache.getPreviouslySentHashedTokens();
        if (!previouslySentHashedTokens.contains(UtilsKt.sha1(receiptID))) {
            previouslySentHashedTokens = null;
        }
        if (previouslySentHashedTokens == null) {
            this.billing.normalizePurchaseData(productID, receiptID, amazonUserID, new C11234(d4, str, this, receiptID, amazonUserID, this.identityManager.getCurrentAppUserID()), new AnonymousClass5(receiptID, amazonUserID));
            return;
        }
        PurchasesOrchestrator$syncAmazonPurchase$lambda$12$$inlined$log$1 purchasesOrchestrator$syncAmazonPurchase$lambda$12$$inlined$log$1 = new PurchasesOrchestrator$syncAmazonPurchase$lambda$12$$inlined$log$1(logIntent, receiptID, amazonUserID);
        switch (iArr[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel10 = LogLevel.DEBUG;
                LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                    currentLogHandler7.d("[Purchases] - " + logLevel10.name(), (String) purchasesOrchestrator$syncAmazonPurchase$lambda$12$$inlined$log$1.invoke());
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$syncAmazonPurchase$lambda$12$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel11 = LogLevel.WARN;
                LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                    currentLogHandler8.w("[Purchases] - " + logLevel11.name(), (String) purchasesOrchestrator$syncAmazonPurchase$lambda$12$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel12 = LogLevel.INFO;
                LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                    currentLogHandler9.i("[Purchases] - " + logLevel12.name(), (String) purchasesOrchestrator$syncAmazonPurchase$lambda$12$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel13 = LogLevel.DEBUG;
                LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                    currentLogHandler10.d("[Purchases] - " + logLevel13.name(), (String) purchasesOrchestrator$syncAmazonPurchase$lambda$12$$inlined$log$1.invoke());
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$syncAmazonPurchase$lambda$12$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel14 = LogLevel.INFO;
                LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                    currentLogHandler11.i("[Purchases] - " + logLevel14.name(), (String) purchasesOrchestrator$syncAmazonPurchase$lambda$12$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel15 = LogLevel.DEBUG;
                LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                    currentLogHandler12.d("[Purchases] - " + logLevel15.name(), (String) purchasesOrchestrator$syncAmazonPurchase$lambda$12$$inlined$log$1.invoke());
                }
                break;
            case 9:
                LogLevel logLevel16 = LogLevel.DEBUG;
                LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                    currentLogHandler13.d("[Purchases] - " + logLevel16.name(), (String) purchasesOrchestrator$syncAmazonPurchase$lambda$12$$inlined$log$1.invoke());
                }
                break;
            case 10:
                LogLevel logLevel17 = LogLevel.WARN;
                LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                    currentLogHandler14.w("[Purchases] - " + logLevel17.name(), (String) purchasesOrchestrator$syncAmazonPurchase$lambda$12$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel18 = LogLevel.WARN;
                LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                    currentLogHandler15.w("[Purchases] - " + logLevel18.name(), (String) purchasesOrchestrator$syncAmazonPurchase$lambda$12$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$syncAmazonPurchase$lambda$12$$inlined$log$1.invoke(), null);
                break;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.revenuecat.purchases.PurchasesOrchestrator$syncAttributesAndOfferingsIfNeeded$receiveOfferingsCallback$1, com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback] */
    public final void syncAttributesAndOfferingsIfNeeded(final SyncAttributesAndOfferingsCallback callback) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        r.f(callback, "callback");
        ?? r02 = new ReceiveOfferingsCallback() { // from class: com.revenuecat.purchases.PurchasesOrchestrator$syncAttributesAndOfferingsIfNeeded$receiveOfferingsCallback$1
            @Override // com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback
            public void onError(PurchasesError error) {
                r.f(error, "error");
                callback.onError(error);
            }

            @Override // com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback
            public void onReceived(Offerings offerings) {
                r.f(offerings, "offerings");
                callback.onSuccess(offerings);
            }
        };
        if (this.lastSyncAttributesAndOfferingsRateLimiter.shouldProceed()) {
            this.subscriberAttributesManager.synchronizeSubscriberAttributesForAllUsers(getAppUserID(), new C11242(r02));
            return;
        }
        LogIntent logIntent = LogIntent.WARNING;
        PurchasesOrchestrator$syncAttributesAndOfferingsIfNeeded$$inlined$log$1 purchasesOrchestrator$syncAttributesAndOfferingsIfNeeded$$inlined$log$1 = new PurchasesOrchestrator$syncAttributesAndOfferingsIfNeeded$$inlined$log$1(logIntent, this);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    str2 = (String) purchasesOrchestrator$syncAttributesAndOfferingsIfNeeded$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$syncAttributesAndOfferingsIfNeeded$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$syncAttributesAndOfferingsIfNeeded$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$syncAttributesAndOfferingsIfNeeded$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    str2 = (String) purchasesOrchestrator$syncAttributesAndOfferingsIfNeeded$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$syncAttributesAndOfferingsIfNeeded$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$syncAttributesAndOfferingsIfNeeded$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    str2 = (String) purchasesOrchestrator$syncAttributesAndOfferingsIfNeeded$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    str2 = (String) purchasesOrchestrator$syncAttributesAndOfferingsIfNeeded$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$syncAttributesAndOfferingsIfNeeded$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$syncAttributesAndOfferingsIfNeeded$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$syncAttributesAndOfferingsIfNeeded$$inlined$log$1.invoke(), null);
                break;
        }
        getOfferings$default(this, r02, false, 2, null);
    }

    public final void syncPurchases(final SyncPurchasesCallback syncPurchasesCallback) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        if (!((Boolean) this.isSimulatedStoreEnabled.invoke()).booleanValue() || this.appConfig.getApiKeyValidationResult() != APIKeyValidator.ValidationResult.SIMULATED_STORE) {
            this.syncPurchasesHelper.syncPurchases(getAllowSharingPlayStoreAccount(), getState$purchases_defaultsRelease().getAppInBackground(), new C11263(syncPurchasesCallback), new C11274(syncPurchasesCallback));
            return;
        }
        LogIntent logIntent = LogIntent.DEBUG;
        PurchasesOrchestrator$syncPurchases$$inlined$log$1 purchasesOrchestrator$syncPurchases$$inlined$log$1 = new PurchasesOrchestrator$syncPurchases$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                LogLevel logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    str = "[Purchases] - " + logLevel.name();
                    str2 = (String) purchasesOrchestrator$syncPurchases$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 2:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$syncPurchases$$inlined$log$1.invoke(), null);
                break;
            case 3:
                LogLevel logLevel2 = LogLevel.WARN;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) purchasesOrchestrator$syncPurchases$$inlined$log$1.invoke());
                }
                break;
            case 4:
                LogLevel logLevel3 = LogLevel.INFO;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) purchasesOrchestrator$syncPurchases$$inlined$log$1.invoke());
                }
                break;
            case 5:
                LogLevel logLevel4 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                    str = "[Purchases] - " + logLevel4.name();
                    str2 = (String) purchasesOrchestrator$syncPurchases$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 6:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$syncPurchases$$inlined$log$1.invoke(), null);
                break;
            case 7:
                LogLevel logLevel5 = LogLevel.INFO;
                LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                    currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) purchasesOrchestrator$syncPurchases$$inlined$log$1.invoke());
                }
                break;
            case 8:
                LogLevel logLevel6 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                    str = "[Purchases] - " + logLevel6.name();
                    str2 = (String) purchasesOrchestrator$syncPurchases$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 9:
                LogLevel logLevel7 = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                    str = "[Purchases] - " + logLevel7.name();
                    str2 = (String) purchasesOrchestrator$syncPurchases$$inlined$log$1.invoke();
                    currentLogHandler.d(str, str2);
                }
                break;
            case 10:
                LogLevel logLevel8 = LogLevel.WARN;
                LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                    currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) purchasesOrchestrator$syncPurchases$$inlined$log$1.invoke());
                }
                break;
            case 11:
                LogLevel logLevel9 = LogLevel.WARN;
                LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                    currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) purchasesOrchestrator$syncPurchases$$inlined$log$1.invoke());
                }
                break;
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) purchasesOrchestrator$syncPurchases$$inlined$log$1.invoke(), null);
                break;
        }
        getCustomerInfo(new ReceiveCustomerInfoCallback() { // from class: com.revenuecat.purchases.PurchasesOrchestrator.syncPurchases.2
            @Override // com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
            public void onError(PurchasesError error) {
                r.f(error, "error");
                SyncPurchasesCallback syncPurchasesCallback2 = syncPurchasesCallback;
                if (syncPurchasesCallback2 != null) {
                    syncPurchasesCallback2.onError(error);
                }
            }

            @Override // com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
            public void onReceived(CustomerInfo customerInfo) {
                r.f(customerInfo, "customerInfo");
                SyncPurchasesCallback syncPurchasesCallback2 = syncPurchasesCallback;
                if (syncPurchasesCallback2 != null) {
                    syncPurchasesCallback2.onSuccess(customerInfo);
                }
            }
        });
    }

    public final void track(FeatureEvent event) {
        EventsManager eventsManager;
        r.f(event, "event");
        if (event instanceof PaywallEvent) {
            this.paywallPresentedCache.receiveEvent((PaywallEvent) event);
        }
        if (!AndroidVersionUtilsKt.isAndroidNOrNewer() || (eventsManager = this.eventsManager) == null) {
            return;
        }
        eventsManager.track(event);
    }

    public final void getCustomerInfo(CacheFetchPolicy fetchPolicy, boolean z4, ReceiveCustomerInfoCallback callback) {
        r.f(fetchPolicy, "fetchPolicy");
        r.f(callback, "callback");
        this.customerInfoHelper.retrieveCustomerInfo(this.identityManager.getCurrentAppUserID(), fetchPolicy, getState$purchases_defaultsRelease().getAppInBackground(), getAllowSharingPlayStoreAccount(), z4, callback);
    }

    public final void getStorefrontCountryCode(GetStorefrontCallback callback) {
        E e4;
        r.f(callback, "callback");
        String str = this.storefrontCountryCode;
        if (str != null) {
            callback.onReceived(str);
            e4 = E.f5463a;
        } else {
            e4 = null;
        }
        if (e4 == null) {
            this.billing.getStorefront(new PurchasesOrchestrator$getStorefrontCountryCode$2$1(this, callback), new PurchasesOrchestrator$getStorefrontCountryCode$2$2(callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatch(PurchaseErrorCallback purchaseErrorCallback, PurchasesError purchasesError) {
        dispatch(new C11041(purchaseErrorCallback, purchasesError));
    }

    public final void getProductsOfTypes(Set<String> productIds, Set<? extends ProductType> types, GetStoreProductsCallback callback) {
        r.f(productIds, "productIds");
        r.f(types, "types");
        r.f(callback, "callback");
        ArrayList arrayList = new ArrayList();
        for (Object obj : types) {
            if (((ProductType) obj) != ProductType.UNKNOWN) {
                arrayList.add(obj);
            }
        }
        getProductsOfTypes$default(this, productIds, x.l0(arrayList), AbstractC0769p.g(), null, callback, 8, null);
    }

    public /* synthetic */ PurchasesOrchestrator(Application application, String str, Backend backend, BillingAbstract billingAbstract, DeviceCache deviceCache, IdentityManager identityManager, SubscriberAttributesManager subscriberAttributesManager, AppConfig appConfig, CustomerInfoHelper customerInfoHelper, CustomerInfoUpdateHandler customerInfoUpdateHandler, DiagnosticsSynchronizer diagnosticsSynchronizer, DiagnosticsTracker diagnosticsTracker, DateProvider dateProvider, OfflineEntitlementsManager offlineEntitlementsManager, PostReceiptHelper postReceiptHelper, PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper, PostPendingTransactionsHelper postPendingTransactionsHelper, SyncPurchasesHelper syncPurchasesHelper, OfferingsManager offeringsManager, EventsManager eventsManager, PaywallPresentedCache paywallPresentedCache, PurchasesStateCache purchasesStateCache, Handler handler, Dispatcher dispatcher, PurchasesConfiguration purchasesConfiguration, FontLoader fontLoader, DefaultLocaleProvider defaultLocaleProvider, WebPurchaseRedemptionHelper webPurchaseRedemptionHelper, VirtualCurrencyManager virtualCurrencyManager, Function0 function0, Function0 function02, BlockstoreHelper blockstoreHelper, BackupManager backupManager, int i4, int i5, AbstractC1585j abstractC1585j) {
        Application application2;
        BackupManager backupManager2;
        DateProvider defaultDateProvider = (i4 & 4096) != 0 ? new DefaultDateProvider() : dateProvider;
        Handler handler2 = (4194304 & i4) != 0 ? new Handler(Looper.getMainLooper()) : handler;
        WebPurchaseRedemptionHelper webPurchaseRedemptionHelper2 = (134217728 & i4) != 0 ? new WebPurchaseRedemptionHelper(backend, identityManager, offlineEntitlementsManager, customerInfoUpdateHandler, null, 16, null) : webPurchaseRedemptionHelper;
        Function0 function03 = (536870912 & i4) != 0 ? AnonymousClass1.INSTANCE : function0;
        Function0 function04 = (1073741824 & i4) != 0 ? AnonymousClass2.INSTANCE : function02;
        BlockstoreHelper blockstoreHelper2 = (i4 & Integer.MIN_VALUE) != 0 ? new BlockstoreHelper(application, identityManager, null, null, null, 28, null) : blockstoreHelper;
        if ((i5 & 1) != 0) {
            backupManager2 = new BackupManager(application);
            application2 = application;
        } else {
            application2 = application;
            backupManager2 = backupManager;
        }
        this(application2, str, backend, billingAbstract, deviceCache, identityManager, subscriberAttributesManager, appConfig, customerInfoHelper, customerInfoUpdateHandler, diagnosticsSynchronizer, diagnosticsTracker, defaultDateProvider, offlineEntitlementsManager, postReceiptHelper, postTransactionWithProductDetailsHelper, postPendingTransactionsHelper, syncPurchasesHelper, offeringsManager, eventsManager, paywallPresentedCache, purchasesStateCache, handler2, dispatcher, purchasesConfiguration, fontLoader, defaultLocaleProvider, webPurchaseRedemptionHelper2, virtualCurrencyManager, function03, function04, blockstoreHelper2, backupManager2);
    }
}
