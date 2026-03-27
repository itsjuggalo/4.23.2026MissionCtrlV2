package com.revenuecat.purchases.virtualcurrencies;

import W2.E;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.identity.IdentityManager;
import com.revenuecat.purchases.interfaces.GetVirtualCurrenciesCallback;
import i3.k;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class VirtualCurrencyManager {
    private final AppConfig appConfig;
    private final Backend backend;
    private final DeviceCache deviceCache;
    private final IdentityManager identityManager;

    /* JADX INFO: renamed from: com.revenuecat.purchases.virtualcurrencies.VirtualCurrencyManager$fetchVirtualCurrenciesFromBackend$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements k {
        final /* synthetic */ GetVirtualCurrenciesCallback $callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(GetVirtualCurrenciesCallback getVirtualCurrenciesCallback) {
            super(1);
            this.$callback = getVirtualCurrenciesCallback;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((VirtualCurrencies) obj);
            return E.f5463a;
        }

        public final void invoke(VirtualCurrencies it) {
            r.f(it, "it");
            this.$callback.onReceived(it);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.virtualcurrencies.VirtualCurrencyManager$fetchVirtualCurrenciesFromBackend$2, reason: invalid class name */
    public static final class AnonymousClass2 extends s implements k {
        final /* synthetic */ GetVirtualCurrenciesCallback $callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(GetVirtualCurrenciesCallback getVirtualCurrenciesCallback) {
            super(1);
            this.$callback = getVirtualCurrenciesCallback;
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

    public VirtualCurrencyManager(IdentityManager identityManager, DeviceCache deviceCache, Backend backend, AppConfig appConfig) {
        r.f(identityManager, "identityManager");
        r.f(deviceCache, "deviceCache");
        r.f(backend, "backend");
        r.f(appConfig, "appConfig");
        this.identityManager = identityManager;
        this.deviceCache = deviceCache;
        this.backend = backend;
        this.appConfig = appConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cacheVirtualCurrencies(VirtualCurrencies virtualCurrencies, String str) {
        this.deviceCache.cacheVirtualCurrencies(str, virtualCurrencies);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final VirtualCurrencies fetchCachedVirtualCurrencies(String str, boolean z4, boolean z5) {
        if (!z5 && this.deviceCache.isVirtualCurrenciesCacheStale(str, z4)) {
            return null;
        }
        VirtualCurrencies cachedVirtualCurrencies = this.deviceCache.getCachedVirtualCurrencies(str);
        if (cachedVirtualCurrencies == null) {
            LogIntent logIntent = LogIntent.DEBUG;
            VirtualCurrencyManager$fetchCachedVirtualCurrencies$$inlined$log$1 virtualCurrencyManager$fetchCachedVirtualCurrencies$$inlined$log$1 = new VirtualCurrencyManager$fetchCachedVirtualCurrencies$$inlined$log$1(logIntent);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.d("[Purchases] - " + logLevel.name(), (String) virtualCurrencyManager$fetchCachedVirtualCurrencies$$inlined$log$1.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) virtualCurrencyManager$fetchCachedVirtualCurrencies$$inlined$log$1.invoke(), null);
                    return cachedVirtualCurrencies;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) virtualCurrencyManager$fetchCachedVirtualCurrencies$$inlined$log$1.invoke());
                        return cachedVirtualCurrencies;
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) virtualCurrencyManager$fetchCachedVirtualCurrencies$$inlined$log$1.invoke());
                        return cachedVirtualCurrencies;
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        currentLogHandler4.d("[Purchases] - " + logLevel4.name(), (String) virtualCurrencyManager$fetchCachedVirtualCurrencies$$inlined$log$1.invoke());
                        return cachedVirtualCurrencies;
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) virtualCurrencyManager$fetchCachedVirtualCurrencies$$inlined$log$1.invoke(), null);
                    return cachedVirtualCurrencies;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler5.i("[Purchases] - " + logLevel5.name(), (String) virtualCurrencyManager$fetchCachedVirtualCurrencies$$inlined$log$1.invoke());
                        return cachedVirtualCurrencies;
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        currentLogHandler6.d("[Purchases] - " + logLevel6.name(), (String) virtualCurrencyManager$fetchCachedVirtualCurrencies$$inlined$log$1.invoke());
                        return cachedVirtualCurrencies;
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        currentLogHandler7.d("[Purchases] - " + logLevel7.name(), (String) virtualCurrencyManager$fetchCachedVirtualCurrencies$$inlined$log$1.invoke());
                        return cachedVirtualCurrencies;
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler8.w("[Purchases] - " + logLevel8.name(), (String) virtualCurrencyManager$fetchCachedVirtualCurrencies$$inlined$log$1.invoke());
                        return cachedVirtualCurrencies;
                    }
                    break;
                case 11:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler9.w("[Purchases] - " + logLevel9.name(), (String) virtualCurrencyManager$fetchCachedVirtualCurrencies$$inlined$log$1.invoke());
                        return cachedVirtualCurrencies;
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) virtualCurrencyManager$fetchCachedVirtualCurrencies$$inlined$log$1.invoke(), null);
                    return cachedVirtualCurrencies;
            }
        }
        return cachedVirtualCurrencies;
    }

    private final void fetchVirtualCurrenciesFromBackend(String str, boolean z4, GetVirtualCurrenciesCallback getVirtualCurrenciesCallback) throws Throwable {
        this.backend.getVirtualCurrencies(str, z4, new AnonymousClass1(getVirtualCurrenciesCallback), new AnonymousClass2(getVirtualCurrenciesCallback));
    }

    private final GetVirtualCurrenciesCallback handleVirtualCurrenciesRequestResult(final GetVirtualCurrenciesCallback getVirtualCurrenciesCallback, final String str) {
        return new GetVirtualCurrenciesCallback() { // from class: com.revenuecat.purchases.virtualcurrencies.VirtualCurrencyManager.handleVirtualCurrenciesRequestResult.1
            @Override // com.revenuecat.purchases.interfaces.GetVirtualCurrenciesCallback
            public void onError(PurchasesError error) {
                LogHandler currentLogHandler;
                String str2;
                String str3;
                r.f(error, "error");
                LogIntent logIntent = LogIntent.RC_ERROR;
                VirtualCurrencyManager$handleVirtualCurrenciesRequestResult$1$onError$$inlined$log$1 virtualCurrencyManager$handleVirtualCurrenciesRequestResult$1$onError$$inlined$log$1 = new VirtualCurrencyManager$handleVirtualCurrenciesRequestResult$1$onError$$inlined$log$1(logIntent, error);
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                    case 1:
                        LogLevel logLevel = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            str2 = "[Purchases] - " + logLevel.name();
                            str3 = (String) virtualCurrencyManager$handleVirtualCurrenciesRequestResult$1$onError$$inlined$log$1.invoke();
                            currentLogHandler.d(str2, str3);
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) virtualCurrencyManager$handleVirtualCurrenciesRequestResult$1$onError$$inlined$log$1.invoke(), null);
                        break;
                    case 3:
                        LogLevel logLevel2 = LogLevel.WARN;
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) virtualCurrencyManager$handleVirtualCurrenciesRequestResult$1$onError$$inlined$log$1.invoke());
                        }
                        break;
                    case 4:
                        LogLevel logLevel3 = LogLevel.INFO;
                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) virtualCurrencyManager$handleVirtualCurrenciesRequestResult$1$onError$$inlined$log$1.invoke());
                        }
                        break;
                    case 5:
                        LogLevel logLevel4 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            str2 = "[Purchases] - " + logLevel4.name();
                            str3 = (String) virtualCurrencyManager$handleVirtualCurrenciesRequestResult$1$onError$$inlined$log$1.invoke();
                            currentLogHandler.d(str2, str3);
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) virtualCurrencyManager$handleVirtualCurrenciesRequestResult$1$onError$$inlined$log$1.invoke(), null);
                        break;
                    case 7:
                        LogLevel logLevel5 = LogLevel.INFO;
                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                            currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) virtualCurrencyManager$handleVirtualCurrenciesRequestResult$1$onError$$inlined$log$1.invoke());
                        }
                        break;
                    case 8:
                        LogLevel logLevel6 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                            str2 = "[Purchases] - " + logLevel6.name();
                            str3 = (String) virtualCurrencyManager$handleVirtualCurrenciesRequestResult$1$onError$$inlined$log$1.invoke();
                            currentLogHandler.d(str2, str3);
                        }
                        break;
                    case 9:
                        LogLevel logLevel7 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                            str2 = "[Purchases] - " + logLevel7.name();
                            str3 = (String) virtualCurrencyManager$handleVirtualCurrenciesRequestResult$1$onError$$inlined$log$1.invoke();
                            currentLogHandler.d(str2, str3);
                        }
                        break;
                    case 10:
                        LogLevel logLevel8 = LogLevel.WARN;
                        LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                            currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) virtualCurrencyManager$handleVirtualCurrenciesRequestResult$1$onError$$inlined$log$1.invoke());
                        }
                        break;
                    case 11:
                        LogLevel logLevel9 = LogLevel.WARN;
                        LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                            currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) virtualCurrencyManager$handleVirtualCurrenciesRequestResult$1$onError$$inlined$log$1.invoke());
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) virtualCurrencyManager$handleVirtualCurrenciesRequestResult$1$onError$$inlined$log$1.invoke(), null);
                        break;
                }
                getVirtualCurrenciesCallback.onError(error);
            }

            @Override // com.revenuecat.purchases.interfaces.GetVirtualCurrenciesCallback
            public void onReceived(VirtualCurrencies virtualCurrencies) {
                LogHandler currentLogHandler;
                String str2;
                String str3;
                r.f(virtualCurrencies, "virtualCurrencies");
                LogIntent logIntent = LogIntent.RC_SUCCESS;
                VirtualCurrencyManager$handleVirtualCurrenciesRequestResult$1$onReceived$$inlined$log$1 virtualCurrencyManager$handleVirtualCurrenciesRequestResult$1$onReceived$$inlined$log$1 = new VirtualCurrencyManager$handleVirtualCurrenciesRequestResult$1$onReceived$$inlined$log$1(logIntent);
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                    case 1:
                        LogLevel logLevel = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            str2 = "[Purchases] - " + logLevel.name();
                            str3 = (String) virtualCurrencyManager$handleVirtualCurrenciesRequestResult$1$onReceived$$inlined$log$1.invoke();
                            currentLogHandler.d(str2, str3);
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) virtualCurrencyManager$handleVirtualCurrenciesRequestResult$1$onReceived$$inlined$log$1.invoke(), null);
                        break;
                    case 3:
                        LogLevel logLevel2 = LogLevel.WARN;
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) virtualCurrencyManager$handleVirtualCurrenciesRequestResult$1$onReceived$$inlined$log$1.invoke());
                        }
                        break;
                    case 4:
                        LogLevel logLevel3 = LogLevel.INFO;
                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) virtualCurrencyManager$handleVirtualCurrenciesRequestResult$1$onReceived$$inlined$log$1.invoke());
                        }
                        break;
                    case 5:
                        LogLevel logLevel4 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            str2 = "[Purchases] - " + logLevel4.name();
                            str3 = (String) virtualCurrencyManager$handleVirtualCurrenciesRequestResult$1$onReceived$$inlined$log$1.invoke();
                            currentLogHandler.d(str2, str3);
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) virtualCurrencyManager$handleVirtualCurrenciesRequestResult$1$onReceived$$inlined$log$1.invoke(), null);
                        break;
                    case 7:
                        LogLevel logLevel5 = LogLevel.INFO;
                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                            currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) virtualCurrencyManager$handleVirtualCurrenciesRequestResult$1$onReceived$$inlined$log$1.invoke());
                        }
                        break;
                    case 8:
                        LogLevel logLevel6 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                            str2 = "[Purchases] - " + logLevel6.name();
                            str3 = (String) virtualCurrencyManager$handleVirtualCurrenciesRequestResult$1$onReceived$$inlined$log$1.invoke();
                            currentLogHandler.d(str2, str3);
                        }
                        break;
                    case 9:
                        LogLevel logLevel7 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                            str2 = "[Purchases] - " + logLevel7.name();
                            str3 = (String) virtualCurrencyManager$handleVirtualCurrenciesRequestResult$1$onReceived$$inlined$log$1.invoke();
                            currentLogHandler.d(str2, str3);
                        }
                        break;
                    case 10:
                        LogLevel logLevel8 = LogLevel.WARN;
                        LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                            currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) virtualCurrencyManager$handleVirtualCurrenciesRequestResult$1$onReceived$$inlined$log$1.invoke());
                        }
                        break;
                    case 11:
                        LogLevel logLevel9 = LogLevel.WARN;
                        LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                            currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) virtualCurrencyManager$handleVirtualCurrenciesRequestResult$1$onReceived$$inlined$log$1.invoke());
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) virtualCurrencyManager$handleVirtualCurrenciesRequestResult$1$onReceived$$inlined$log$1.invoke(), null);
                        break;
                }
                VirtualCurrencyManager.this.cacheVirtualCurrencies(virtualCurrencies, str);
                getVirtualCurrenciesCallback.onReceived(virtualCurrencies);
            }
        };
    }

    public final synchronized VirtualCurrencies cachedVirtualCurrencies() {
        LogHandler currentLogHandler;
        String str;
        String str2;
        try {
            VirtualCurrencies virtualCurrenciesFetchCachedVirtualCurrencies = fetchCachedVirtualCurrencies(this.identityManager.getCurrentAppUserID(), this.appConfig.isAppBackgrounded(), true);
            if (virtualCurrenciesFetchCachedVirtualCurrencies == null) {
                return null;
            }
            LogIntent logIntent = LogIntent.DEBUG;
            VirtualCurrencyManager$cachedVirtualCurrencies$$inlined$log$1 virtualCurrencyManager$cachedVirtualCurrencies$$inlined$log$1 = new VirtualCurrencyManager$cachedVirtualCurrencies$$inlined$log$1(logIntent);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        str = "[Purchases] - " + logLevel.name();
                        str2 = (String) virtualCurrencyManager$cachedVirtualCurrencies$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) virtualCurrencyManager$cachedVirtualCurrencies$$inlined$log$1.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) virtualCurrencyManager$cachedVirtualCurrencies$$inlined$log$1.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) virtualCurrencyManager$cachedVirtualCurrencies$$inlined$log$1.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        str = "[Purchases] - " + logLevel4.name();
                        str2 = (String) virtualCurrencyManager$cachedVirtualCurrencies$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) virtualCurrencyManager$cachedVirtualCurrencies$$inlined$log$1.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) virtualCurrencyManager$cachedVirtualCurrencies$$inlined$log$1.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        str = "[Purchases] - " + logLevel6.name();
                        str2 = (String) virtualCurrencyManager$cachedVirtualCurrencies$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        str = "[Purchases] - " + logLevel7.name();
                        str2 = (String) virtualCurrencyManager$cachedVirtualCurrencies$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) virtualCurrencyManager$cachedVirtualCurrencies$$inlined$log$1.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) virtualCurrencyManager$cachedVirtualCurrencies$$inlined$log$1.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) virtualCurrencyManager$cachedVirtualCurrencies$$inlined$log$1.invoke(), null);
                    break;
            }
            return virtualCurrenciesFetchCachedVirtualCurrencies;
        } finally {
        }
    }

    public final synchronized void invalidateVirtualCurrenciesCache() {
        LogHandler currentLogHandler;
        String str;
        String str2;
        try {
            String currentAppUserID = this.identityManager.getCurrentAppUserID();
            LogIntent logIntent = LogIntent.DEBUG;
            VirtualCurrencyManager$invalidateVirtualCurrenciesCache$$inlined$log$1 virtualCurrencyManager$invalidateVirtualCurrenciesCache$$inlined$log$1 = new VirtualCurrencyManager$invalidateVirtualCurrenciesCache$$inlined$log$1(logIntent);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        str = "[Purchases] - " + logLevel.name();
                        str2 = (String) virtualCurrencyManager$invalidateVirtualCurrenciesCache$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) virtualCurrencyManager$invalidateVirtualCurrenciesCache$$inlined$log$1.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) virtualCurrencyManager$invalidateVirtualCurrenciesCache$$inlined$log$1.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) virtualCurrencyManager$invalidateVirtualCurrenciesCache$$inlined$log$1.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        str = "[Purchases] - " + logLevel4.name();
                        str2 = (String) virtualCurrencyManager$invalidateVirtualCurrenciesCache$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) virtualCurrencyManager$invalidateVirtualCurrenciesCache$$inlined$log$1.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) virtualCurrencyManager$invalidateVirtualCurrenciesCache$$inlined$log$1.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        str = "[Purchases] - " + logLevel6.name();
                        str2 = (String) virtualCurrencyManager$invalidateVirtualCurrenciesCache$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        str = "[Purchases] - " + logLevel7.name();
                        str2 = (String) virtualCurrencyManager$invalidateVirtualCurrenciesCache$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) virtualCurrencyManager$invalidateVirtualCurrenciesCache$$inlined$log$1.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel9 = LogLevel.WARN;
                    LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) virtualCurrencyManager$invalidateVirtualCurrenciesCache$$inlined$log$1.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) virtualCurrencyManager$invalidateVirtualCurrenciesCache$$inlined$log$1.invoke(), null);
                    break;
            }
            this.deviceCache.clearVirtualCurrenciesCache(currentAppUserID);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void virtualCurrencies(GetVirtualCurrenciesCallback callback) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        try {
            r.f(callback, "callback");
            String currentAppUserID = this.identityManager.getCurrentAppUserID();
            boolean zIsAppBackgrounded = this.appConfig.isAppBackgrounded();
            VirtualCurrencies virtualCurrenciesFetchCachedVirtualCurrencies = fetchCachedVirtualCurrencies(currentAppUserID, zIsAppBackgrounded, false);
            if (virtualCurrenciesFetchCachedVirtualCurrencies == null) {
                LogIntent logIntent = LogIntent.DEBUG;
                VirtualCurrencyManager$virtualCurrencies$$inlined$log$2 virtualCurrencyManager$virtualCurrencies$$inlined$log$2 = new VirtualCurrencyManager$virtualCurrencies$$inlined$log$2(logIntent);
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                    case 1:
                        LogLevel logLevel = LogLevel.DEBUG;
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            currentLogHandler2.d("[Purchases] - " + logLevel.name(), (String) virtualCurrencyManager$virtualCurrencies$$inlined$log$2.invoke());
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) virtualCurrencyManager$virtualCurrencies$$inlined$log$2.invoke(), null);
                        break;
                    case 3:
                        LogLevel logLevel2 = LogLevel.WARN;
                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            currentLogHandler3.w("[Purchases] - " + logLevel2.name(), (String) virtualCurrencyManager$virtualCurrencies$$inlined$log$2.invoke());
                        }
                        break;
                    case 4:
                        LogLevel logLevel3 = LogLevel.INFO;
                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            currentLogHandler4.i("[Purchases] - " + logLevel3.name(), (String) virtualCurrencyManager$virtualCurrencies$$inlined$log$2.invoke());
                        }
                        break;
                    case 5:
                        LogLevel logLevel4 = LogLevel.DEBUG;
                        LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            currentLogHandler5.d("[Purchases] - " + logLevel4.name(), (String) virtualCurrencyManager$virtualCurrencies$$inlined$log$2.invoke());
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) virtualCurrencyManager$virtualCurrencies$$inlined$log$2.invoke(), null);
                        break;
                    case 7:
                        LogLevel logLevel5 = LogLevel.INFO;
                        LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                            currentLogHandler6.i("[Purchases] - " + logLevel5.name(), (String) virtualCurrencyManager$virtualCurrencies$$inlined$log$2.invoke());
                        }
                        break;
                    case 8:
                        LogLevel logLevel6 = LogLevel.DEBUG;
                        LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                            currentLogHandler7.d("[Purchases] - " + logLevel6.name(), (String) virtualCurrencyManager$virtualCurrencies$$inlined$log$2.invoke());
                        }
                        break;
                    case 9:
                        LogLevel logLevel7 = LogLevel.DEBUG;
                        LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                            currentLogHandler8.d("[Purchases] - " + logLevel7.name(), (String) virtualCurrencyManager$virtualCurrencies$$inlined$log$2.invoke());
                        }
                        break;
                    case 10:
                        LogLevel logLevel8 = LogLevel.WARN;
                        LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                            currentLogHandler9.w("[Purchases] - " + logLevel8.name(), (String) virtualCurrencyManager$virtualCurrencies$$inlined$log$2.invoke());
                        }
                        break;
                    case 11:
                        LogLevel logLevel9 = LogLevel.WARN;
                        LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                            currentLogHandler10.w("[Purchases] - " + logLevel9.name(), (String) virtualCurrencyManager$virtualCurrencies$$inlined$log$2.invoke());
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) virtualCurrencyManager$virtualCurrencies$$inlined$log$2.invoke(), null);
                        break;
                }
                fetchVirtualCurrenciesFromBackend(currentAppUserID, zIsAppBackgrounded, handleVirtualCurrenciesRequestResult(callback, currentAppUserID));
                return;
            }
            LogIntent logIntent2 = LogIntent.DEBUG;
            VirtualCurrencyManager$virtualCurrencies$$inlined$log$1 virtualCurrencyManager$virtualCurrencies$$inlined$log$1 = new VirtualCurrencyManager$virtualCurrencies$$inlined$log$1(logIntent2);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                case 1:
                    LogLevel logLevel10 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                        str = "[Purchases] - " + logLevel10.name();
                        str2 = (String) virtualCurrencyManager$virtualCurrencies$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) virtualCurrencyManager$virtualCurrencies$$inlined$log$1.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel11 = LogLevel.WARN;
                    LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                        currentLogHandler11.w("[Purchases] - " + logLevel11.name(), (String) virtualCurrencyManager$virtualCurrencies$$inlined$log$1.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel12 = LogLevel.INFO;
                    LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                        currentLogHandler12.i("[Purchases] - " + logLevel12.name(), (String) virtualCurrencyManager$virtualCurrencies$$inlined$log$1.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel13 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                        str = "[Purchases] - " + logLevel13.name();
                        str2 = (String) virtualCurrencyManager$virtualCurrencies$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) virtualCurrencyManager$virtualCurrencies$$inlined$log$1.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel14 = LogLevel.INFO;
                    LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                        currentLogHandler13.i("[Purchases] - " + logLevel14.name(), (String) virtualCurrencyManager$virtualCurrencies$$inlined$log$1.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel15 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                        str = "[Purchases] - " + logLevel15.name();
                        str2 = (String) virtualCurrencyManager$virtualCurrencies$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 9:
                    LogLevel logLevel16 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                        str = "[Purchases] - " + logLevel16.name();
                        str2 = (String) virtualCurrencyManager$virtualCurrencies$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 10:
                    LogLevel logLevel17 = LogLevel.WARN;
                    LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                        currentLogHandler14.w("[Purchases] - " + logLevel17.name(), (String) virtualCurrencyManager$virtualCurrencies$$inlined$log$1.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel18 = LogLevel.WARN;
                    LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                        currentLogHandler15.w("[Purchases] - " + logLevel18.name(), (String) virtualCurrencyManager$virtualCurrencies$$inlined$log$1.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) virtualCurrencyManager$virtualCurrencies$$inlined$log$1.invoke(), null);
                    break;
            }
            callback.onReceived(virtualCurrenciesFetchCachedVirtualCurrencies);
        } catch (Throwable th) {
            throw th;
        }
    }
}
