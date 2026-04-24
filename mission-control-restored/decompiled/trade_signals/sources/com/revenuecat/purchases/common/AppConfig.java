package com.revenuecat.purchases.common;

import D3.m;
import android.content.Context;
import com.revenuecat.purchases.DangerousSettings;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PurchasesAreCompletedBy;
import com.revenuecat.purchases.PurchasesAreCompletedByKt;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2594p;
import p5.AbstractC2595q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000 F2\u00020\u0001:\u0001FBg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007¢\u0006\u0002\u0010\u0014J\u0013\u0010A\u001a\u00020\u00072\b\u0010B\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010C\u001a\u00020DH\u0016J\b\u0010E\u001a\u000201H\u0016R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010(R\u001c\u0010\u0012\u001a\u00020\u00078FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010(R\u001c\u0010\u0013\u001a\u00020\u00078FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001c\"\u0004\b,\u0010(R$\u0010.\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b.\u0010\u001c\"\u0004\b/\u0010(R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001cR\u0011\u00100\u001a\u000201¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u00104\u001a\u000201¢\u0006\b\n\u0000\u001a\u0004\b5\u00103R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0013\u00108\u001a\u0004\u0018\u000101¢\u0006\b\n\u0000\u001a\u0004\b9\u00103R\u0013\u0010:\u001a\u0004\u0018\u000101¢\u0006\b\n\u0000\u001a\u0004\b;\u00103R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u001cR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010?\u001a\u000201¢\u0006\b\n\u0000\u001a\u0004\b@\u00103¨\u0006G"}, d2 = {"Lcom/revenuecat/purchases/common/AppConfig;", "", "context", "Landroid/content/Context;", "purchasesAreCompletedBy", "Lcom/revenuecat/purchases/PurchasesAreCompletedBy;", "showInAppMessagesAutomatically", "", "platformInfo", "Lcom/revenuecat/purchases/common/PlatformInfo;", "proxyURL", "Ljava/net/URL;", ProductResponseJsonKeys.STORE, "Lcom/revenuecat/purchases/Store;", "isDebugBuild", "dangerousSettings", "Lcom/revenuecat/purchases/DangerousSettings;", "runningTests", "forceServerErrors", "forceSigningErrors", "(Landroid/content/Context;Lcom/revenuecat/purchases/PurchasesAreCompletedBy;ZLcom/revenuecat/purchases/common/PlatformInfo;Ljava/net/URL;Lcom/revenuecat/purchases/Store;ZLcom/revenuecat/purchases/DangerousSettings;ZZZ)V", "_isAppBackgrounded", "Ljava/util/concurrent/atomic/AtomicBoolean;", "baseURL", "getBaseURL", "()Ljava/net/URL;", "customEntitlementComputation", "getCustomEntitlementComputation", "()Z", "getDangerousSettings", "()Lcom/revenuecat/purchases/DangerousSettings;", "enableOfflineEntitlements", "getEnableOfflineEntitlements", "fallbackBaseURLs", "", "getFallbackBaseURLs", "()Ljava/util/List;", "finishTransactions", "getFinishTransactions", "setFinishTransactions", "(Z)V", "getForceServerErrors", "setForceServerErrors", "getForceSigningErrors", "setForceSigningErrors", "value", "isAppBackgrounded", "setAppBackgrounded", "languageTag", "", "getLanguageTag", "()Ljava/lang/String;", "packageName", "getPackageName", "getPlatformInfo", "()Lcom/revenuecat/purchases/common/PlatformInfo;", "playServicesVersionName", "getPlayServicesVersionName", "playStoreVersionName", "getPlayStoreVersionName", "getShowInAppMessagesAutomatically", "getStore", "()Lcom/revenuecat/purchases/Store;", "versionName", "getVersionName", "equals", "other", "hashCode", "", "toString", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AppConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final URL diagnosticsURL = new URL("https://api-diagnostics.revenuecat.com/");
    private static final URL paywallEventsURL = new URL("https://api-paywalls.revenuecat.com/");
    private final AtomicBoolean _isAppBackgrounded;
    private final URL baseURL;
    private final DangerousSettings dangerousSettings;
    private final boolean enableOfflineEntitlements;
    private final List<URL> fallbackBaseURLs;
    private boolean finishTransactions;
    private boolean forceServerErrors;
    private boolean forceSigningErrors;
    private final boolean isDebugBuild;
    private final String languageTag;
    private final String packageName;
    private final PlatformInfo platformInfo;
    private final String playServicesVersionName;
    private final String playStoreVersionName;
    private final boolean runningTests;
    private final boolean showInAppMessagesAutomatically;
    private final Store store;
    private final String versionName;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/common/AppConfig$Companion;", "", "()V", "diagnosticsURL", "Ljava/net/URL;", "getDiagnosticsURL", "()Ljava/net/URL;", "paywallEventsURL", "getPaywallEventsURL", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final URL getDiagnosticsURL() {
            return AppConfig.diagnosticsURL;
        }

        public final URL getPaywallEventsURL() {
            return AppConfig.paywallEventsURL;
        }

        public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public AppConfig(Context context, PurchasesAreCompletedBy purchasesAreCompletedBy, boolean z7, PlatformInfo platformInfo, URL url, Store store, boolean z8, DangerousSettings dangerousSettings, boolean z9, boolean z10, boolean z11) {
        URL url2;
        LogLevel logLevel;
        LogHandler currentLogHandler;
        StringBuilder sb;
        LogLevel logLevel2;
        LogHandler currentLogHandler2;
        StringBuilder sb2;
        LogLevel logLevel3;
        LogHandler currentLogHandler3;
        StringBuilder sb3;
        AbstractC2304t.f(context, "context");
        AbstractC2304t.f(purchasesAreCompletedBy, "purchasesAreCompletedBy");
        AbstractC2304t.f(platformInfo, "platformInfo");
        AbstractC2304t.f(store, "store");
        AbstractC2304t.f(dangerousSettings, "dangerousSettings");
        this.showInAppMessagesAutomatically = z7;
        this.platformInfo = platformInfo;
        this.store = store;
        this.isDebugBuild = z8;
        this.dangerousSettings = dangerousSettings;
        this.runningTests = z9;
        this.forceServerErrors = z10;
        this.forceSigningErrors = z11;
        this._isAppBackgrounded = new AtomicBoolean(true);
        this.enableOfflineEntitlements = true;
        Locale locale = UtilsKt.getLocale(context);
        String languageTag = locale != null ? locale.toLanguageTag() : null;
        this.languageTag = languageTag == null ? "" : languageTag;
        String versionName = UtilsKt.getVersionName(context);
        this.versionName = versionName != null ? versionName : "";
        String packageName = context.getPackageName();
        AbstractC2304t.e(packageName, "context.packageName");
        this.packageName = packageName;
        this.finishTransactions = PurchasesAreCompletedByKt.getFinishTransactions(purchasesAreCompletedBy);
        if (url != null) {
            LogIntent logIntent = LogIntent.INFO;
            AppConfig$baseURL$lambda$1$$inlined$log$1 appConfig$baseURL$lambda$1$$inlined$log$1 = new AppConfig$baseURL$lambda$1$$inlined$log$1(logIntent);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        sb = new StringBuilder();
                        sb.append("[Purchases] - ");
                        sb.append(logLevel.name());
                        currentLogHandler.d(sb.toString(), (String) appConfig$baseURL$lambda$1$$inlined$log$1.invoke());
                    }
                    break;
                case 2:
                case 6:
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) appConfig$baseURL$lambda$1$$inlined$log$1.invoke(), null);
                    break;
                case 3:
                    logLevel2 = LogLevel.WARN;
                    currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        sb2 = new StringBuilder();
                        sb2.append("[Purchases] - ");
                        sb2.append(logLevel2.name());
                        currentLogHandler2.w(sb2.toString(), (String) appConfig$baseURL$lambda$1$$inlined$log$1.invoke());
                    }
                    break;
                case 4:
                    logLevel3 = LogLevel.INFO;
                    currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        sb3 = new StringBuilder();
                        sb3.append("[Purchases] - ");
                        sb3.append(logLevel3.name());
                        currentLogHandler3.i(sb3.toString(), (String) appConfig$baseURL$lambda$1$$inlined$log$1.invoke());
                    }
                    break;
                case 5:
                    logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        sb = new StringBuilder();
                        sb.append("[Purchases] - ");
                        sb.append(logLevel.name());
                        currentLogHandler.d(sb.toString(), (String) appConfig$baseURL$lambda$1$$inlined$log$1.invoke());
                    }
                    break;
                case 7:
                    logLevel3 = LogLevel.INFO;
                    currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        sb3 = new StringBuilder();
                        sb3.append("[Purchases] - ");
                        sb3.append(logLevel3.name());
                        currentLogHandler3.i(sb3.toString(), (String) appConfig$baseURL$lambda$1$$inlined$log$1.invoke());
                    }
                    break;
                case 8:
                    logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        sb = new StringBuilder();
                        sb.append("[Purchases] - ");
                        sb.append(logLevel.name());
                        currentLogHandler.d(sb.toString(), (String) appConfig$baseURL$lambda$1$$inlined$log$1.invoke());
                    }
                    break;
                case 9:
                    logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        sb = new StringBuilder();
                        sb.append("[Purchases] - ");
                        sb.append(logLevel.name());
                        currentLogHandler.d(sb.toString(), (String) appConfig$baseURL$lambda$1$$inlined$log$1.invoke());
                    }
                    break;
                case 10:
                    logLevel2 = LogLevel.WARN;
                    currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        sb2 = new StringBuilder();
                        sb2.append("[Purchases] - ");
                        sb2.append(logLevel2.name());
                        currentLogHandler2.w(sb2.toString(), (String) appConfig$baseURL$lambda$1$$inlined$log$1.invoke());
                    }
                    break;
                case m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                    logLevel2 = LogLevel.WARN;
                    currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        sb2 = new StringBuilder();
                        sb2.append("[Purchases] - ");
                        sb2.append(logLevel2.name());
                        currentLogHandler2.w(sb2.toString(), (String) appConfig$baseURL$lambda$1$$inlined$log$1.invoke());
                    }
                    break;
            }
            url2 = url;
        } else {
            url2 = new URL("https://api.revenuecat.com/");
        }
        this.baseURL = url2;
        this.fallbackBaseURLs = url != null ? AbstractC2595q.i() : AbstractC2594p.e(new URL("https://api-production.8-lives-cat.io/"));
        this.playStoreVersionName = UtilsKt.getPlayStoreVersionName(context);
        this.playServicesVersionName = UtilsKt.getPlayServicesVersionName(context);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!AbstractC2304t.b(AppConfig.class, other != null ? other.getClass() : null)) {
            return false;
        }
        AbstractC2304t.d(other, "null cannot be cast to non-null type com.revenuecat.purchases.common.AppConfig");
        AppConfig appConfig = (AppConfig) other;
        return AbstractC2304t.b(this.platformInfo, appConfig.platformInfo) && this.store == appConfig.store && this.isDebugBuild == appConfig.isDebugBuild && AbstractC2304t.b(this.dangerousSettings, appConfig.dangerousSettings) && AbstractC2304t.b(this.languageTag, appConfig.languageTag) && AbstractC2304t.b(this.versionName, appConfig.versionName) && AbstractC2304t.b(this.packageName, appConfig.packageName) && this.finishTransactions == appConfig.finishTransactions && getForceServerErrors() == appConfig.getForceServerErrors() && getForceSigningErrors() == appConfig.getForceSigningErrors() && AbstractC2304t.b(this.baseURL, appConfig.baseURL) && this.showInAppMessagesAutomatically == appConfig.showInAppMessagesAutomatically && isAppBackgrounded() == appConfig.isAppBackgrounded();
    }

    public final URL getBaseURL() {
        return this.baseURL;
    }

    public final boolean getCustomEntitlementComputation() {
        return this.dangerousSettings.getCustomEntitlementComputation();
    }

    public final DangerousSettings getDangerousSettings() {
        return this.dangerousSettings;
    }

    public final boolean getEnableOfflineEntitlements() {
        return this.enableOfflineEntitlements;
    }

    public final List<URL> getFallbackBaseURLs() {
        return this.fallbackBaseURLs;
    }

    public final boolean getFinishTransactions() {
        return this.finishTransactions;
    }

    public final boolean getForceServerErrors() {
        return this.runningTests && this.forceServerErrors;
    }

    public final boolean getForceSigningErrors() {
        return this.runningTests && this.forceSigningErrors;
    }

    public final String getLanguageTag() {
        return this.languageTag;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final PlatformInfo getPlatformInfo() {
        return this.platformInfo;
    }

    public final String getPlayServicesVersionName() {
        return this.playServicesVersionName;
    }

    public final String getPlayStoreVersionName() {
        return this.playStoreVersionName;
    }

    public final boolean getShowInAppMessagesAutomatically() {
        return this.showInAppMessagesAutomatically;
    }

    public final Store getStore() {
        return this.store;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.platformInfo.hashCode() * 31) + this.store.hashCode()) * 31) + Boolean.hashCode(this.isDebugBuild)) * 31) + this.dangerousSettings.hashCode()) * 31) + this.languageTag.hashCode()) * 31) + this.versionName.hashCode()) * 31) + this.packageName.hashCode()) * 31) + Boolean.hashCode(this.finishTransactions)) * 31) + Boolean.hashCode(getForceServerErrors())) * 31) + Boolean.hashCode(getForceSigningErrors())) * 31) + this.baseURL.hashCode()) * 31) + Boolean.hashCode(this.showInAppMessagesAutomatically)) * 31) + Boolean.hashCode(isAppBackgrounded());
    }

    public final boolean isAppBackgrounded() {
        return this._isAppBackgrounded.get();
    }

    /* JADX INFO: renamed from: isDebugBuild, reason: from getter */
    public final boolean getIsDebugBuild() {
        return this.isDebugBuild;
    }

    public final void setAppBackgrounded(boolean z7) {
        this._isAppBackgrounded.set(z7);
    }

    public final void setFinishTransactions(boolean z7) {
        this.finishTransactions = z7;
    }

    public final void setForceServerErrors(boolean z7) {
        this.forceServerErrors = z7;
    }

    public final void setForceSigningErrors(boolean z7) {
        this.forceSigningErrors = z7;
    }

    public String toString() {
        return "AppConfig(platformInfo=" + this.platformInfo + ", store=" + this.store + ", isDebugBuild=" + this.isDebugBuild + ", dangerousSettings=" + this.dangerousSettings + ", languageTag='" + this.languageTag + "', versionName='" + this.versionName + "', packageName='" + this.packageName + "', finishTransactions=" + this.finishTransactions + ", showInAppMessagesAutomatically=" + this.showInAppMessagesAutomatically + ", baseURL=" + this.baseURL + ')';
    }

    public /* synthetic */ AppConfig(Context context, PurchasesAreCompletedBy purchasesAreCompletedBy, boolean z7, PlatformInfo platformInfo, URL url, Store store, boolean z8, DangerousSettings dangerousSettings, boolean z9, boolean z10, boolean z11, int i8, AbstractC2296k abstractC2296k) {
        this(context, purchasesAreCompletedBy, z7, platformInfo, url, store, z8, (i8 & 128) != 0 ? new DangerousSettings(true) : dangerousSettings, (i8 & 256) != 0 ? false : z9, (i8 & 512) != 0 ? false : z10, (i8 & 1024) != 0 ? false : z11);
    }
}
