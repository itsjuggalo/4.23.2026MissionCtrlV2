package com.revenuecat.purchases;

import B5.k;
import D3.m;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.DurationExtensionsKt;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.ReceiptInfo;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.identity.IdentityManager;
import com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.PurchaseStrings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;
import o5.C2470H;
import p5.z;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJO\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00152\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170\u0015H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010 \u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!JE\u0010\"\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00152\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170\u0015¢\u0006\u0004\b\"\u0010#R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010$R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010%R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010&R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010'R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010(R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010)¨\u0006*"}, d2 = {"Lcom/revenuecat/purchases/SyncPurchasesHelper;", "", "Lcom/revenuecat/purchases/common/BillingAbstract;", "billing", "Lcom/revenuecat/purchases/identity/IdentityManager;", "identityManager", "Lcom/revenuecat/purchases/CustomerInfoHelper;", "customerInfoHelper", "Lcom/revenuecat/purchases/PostReceiptHelper;", "postReceiptHelper", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;", "diagnosticsTrackerIfEnabled", "Lcom/revenuecat/purchases/common/DateProvider;", "dateProvider", "<init>", "(Lcom/revenuecat/purchases/common/BillingAbstract;Lcom/revenuecat/purchases/identity/IdentityManager;Lcom/revenuecat/purchases/CustomerInfoHelper;Lcom/revenuecat/purchases/PostReceiptHelper;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;Lcom/revenuecat/purchases/common/DateProvider;)V", "", "appUserID", "", "appInBackground", "isRestore", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/CustomerInfo;", "Lo5/H;", "onSuccess", "Lcom/revenuecat/purchases/PurchasesError;", "onError", "retrieveCustomerInfo", "(Ljava/lang/String;ZZLB5/k;LB5/k;)V", "error", "Ljava/util/Date;", "startTime", "trackSyncPurchasesResultIfNeeded", "(Lcom/revenuecat/purchases/PurchasesError;Ljava/util/Date;)V", "syncPurchases", "(ZZLB5/k;LB5/k;)V", "Lcom/revenuecat/purchases/common/BillingAbstract;", "Lcom/revenuecat/purchases/identity/IdentityManager;", "Lcom/revenuecat/purchases/CustomerInfoHelper;", "Lcom/revenuecat/purchases/PostReceiptHelper;", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;", "Lcom/revenuecat/purchases/common/DateProvider;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
public final class SyncPurchasesHelper {
    private final BillingAbstract billing;
    private final CustomerInfoHelper customerInfoHelper;
    private final DateProvider dateProvider;
    private final DiagnosticsTracker diagnosticsTrackerIfEnabled;
    private final IdentityManager identityManager;
    private final PostReceiptHelper postReceiptHelper;

    /* JADX INFO: renamed from: com.revenuecat.purchases.SyncPurchasesHelper$syncPurchases$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/revenuecat/purchases/models/StoreTransaction;", "allPurchases", "Lo5/H;", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    public static final class AnonymousClass2 extends AbstractC2306v implements k {
        final /* synthetic */ boolean $appInBackground;
        final /* synthetic */ String $appUserID;
        final /* synthetic */ k $handleError;
        final /* synthetic */ k $handleSuccess;
        final /* synthetic */ boolean $isRestore;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, boolean z7, boolean z8, k kVar, k kVar2) {
            super(1);
            this.$appUserID = str;
            this.$appInBackground = z7;
            this.$isRestore = z8;
            this.$handleSuccess = kVar;
            this.$handleError = kVar2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$handleLastPurchase(List<PurchasesError> list, SyncPurchasesHelper syncPurchasesHelper, String str, boolean z7, boolean z8, k kVar, k kVar2, StoreTransaction storeTransaction, StoreTransaction storeTransaction2) {
            if (AbstractC2304t.b(storeTransaction, storeTransaction2)) {
                if (!list.isEmpty()) {
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    String str2 = String.format(PurchaseStrings.SYNCING_PURCHASES_ERROR, Arrays.copyOf(new Object[]{list}, 1));
                    AbstractC2304t.e(str2, "format(...)");
                    currentLogHandler.e("[Purchases] - ERROR", str2, null);
                    kVar2.invoke(z.Y(list));
                    return;
                }
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler2.d("[Purchases] - " + logLevel.name(), PurchaseStrings.SYNCED_PURCHASES_SUCCESSFULLY);
                }
                syncPurchasesHelper.retrieveCustomerInfo(str, z7, z8, kVar, kVar2);
            }
        }

        @Override // B5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((List<StoreTransaction>) obj);
            return C2470H.f21956a;
        }

        public final void invoke(List<StoreTransaction> allPurchases) {
            AbstractC2304t.f(allPurchases, "allPurchases");
            if (!(!allPurchases.isEmpty())) {
                SyncPurchasesHelper.this.retrieveCustomerInfo(this.$appUserID, this.$appInBackground, this.$isRestore, this.$handleSuccess, this.$handleError);
                return;
            }
            StoreTransaction storeTransaction = (StoreTransaction) z.j0(allPurchases);
            ArrayList arrayList = new ArrayList();
            SyncPurchasesHelper syncPurchasesHelper = SyncPurchasesHelper.this;
            boolean z7 = this.$isRestore;
            String str = this.$appUserID;
            boolean z8 = this.$appInBackground;
            k kVar = this.$handleSuccess;
            k kVar2 = this.$handleError;
            for (StoreTransaction storeTransaction2 : allPurchases) {
                k kVar3 = kVar2;
                boolean z9 = z8;
                syncPurchasesHelper.postReceiptHelper.postTokenWithoutConsuming(storeTransaction2.getPurchaseToken(), storeTransaction2.getStoreUserID(), new ReceiptInfo(storeTransaction2.getProductIds(), null, null, null, null, null, null, 126, null), z7, str, storeTransaction2.getMarketplace(), PostReceiptInitiationSource.RESTORE, new SyncPurchasesHelper$syncPurchases$2$1$1(storeTransaction2, storeTransaction, arrayList, syncPurchasesHelper, str, z8, z7, kVar, kVar3), new SyncPurchasesHelper$syncPurchases$2$1$2(arrayList, storeTransaction2, storeTransaction, syncPurchasesHelper, str, z9, z7, kVar, kVar3));
                kVar2 = kVar3;
                kVar = kVar;
                z8 = z9;
            }
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.SyncPurchasesHelper$syncPurchases$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/revenuecat/purchases/PurchasesError;", "it", "Lo5/H;", "invoke", "(Lcom/revenuecat/purchases/PurchasesError;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    public static final class AnonymousClass3 extends AbstractC2306v implements k {
        final /* synthetic */ k $handleError;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(k kVar) {
            super(1);
            this.$handleError = kVar;
        }

        @Override // B5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return C2470H.f21956a;
        }

        public final void invoke(PurchasesError it) {
            LogLevel logLevel;
            LogHandler currentLogHandler;
            StringBuilder sb;
            LogLevel logLevel2;
            LogHandler currentLogHandler2;
            StringBuilder sb2;
            LogLevel logLevel3;
            LogHandler currentLogHandler3;
            StringBuilder sb3;
            AbstractC2304t.f(it, "it");
            LogIntent logIntent = LogIntent.RC_ERROR;
            SyncPurchasesHelper$syncPurchases$3$invoke$$inlined$log$1 syncPurchasesHelper$syncPurchases$3$invoke$$inlined$log$1 = new SyncPurchasesHelper$syncPurchases$3$invoke$$inlined$log$1(logIntent, it);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        sb = new StringBuilder();
                        sb.append("[Purchases] - ");
                        sb.append(logLevel.name());
                        currentLogHandler.d(sb.toString(), (String) syncPurchasesHelper$syncPurchases$3$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 2:
                case 6:
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) syncPurchasesHelper$syncPurchases$3$invoke$$inlined$log$1.invoke(), null);
                    break;
                case 3:
                    logLevel2 = LogLevel.WARN;
                    currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        sb2 = new StringBuilder();
                        sb2.append("[Purchases] - ");
                        sb2.append(logLevel2.name());
                        currentLogHandler2.w(sb2.toString(), (String) syncPurchasesHelper$syncPurchases$3$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 4:
                    logLevel3 = LogLevel.INFO;
                    currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        sb3 = new StringBuilder();
                        sb3.append("[Purchases] - ");
                        sb3.append(logLevel3.name());
                        currentLogHandler3.i(sb3.toString(), (String) syncPurchasesHelper$syncPurchases$3$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 5:
                    logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        sb = new StringBuilder();
                        sb.append("[Purchases] - ");
                        sb.append(logLevel.name());
                        currentLogHandler.d(sb.toString(), (String) syncPurchasesHelper$syncPurchases$3$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 7:
                    logLevel3 = LogLevel.INFO;
                    currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        sb3 = new StringBuilder();
                        sb3.append("[Purchases] - ");
                        sb3.append(logLevel3.name());
                        currentLogHandler3.i(sb3.toString(), (String) syncPurchasesHelper$syncPurchases$3$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 8:
                    logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        sb = new StringBuilder();
                        sb.append("[Purchases] - ");
                        sb.append(logLevel.name());
                        currentLogHandler.d(sb.toString(), (String) syncPurchasesHelper$syncPurchases$3$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 9:
                    logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        sb = new StringBuilder();
                        sb.append("[Purchases] - ");
                        sb.append(logLevel.name());
                        currentLogHandler.d(sb.toString(), (String) syncPurchasesHelper$syncPurchases$3$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case 10:
                    logLevel2 = LogLevel.WARN;
                    currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        sb2 = new StringBuilder();
                        sb2.append("[Purchases] - ");
                        sb2.append(logLevel2.name());
                        currentLogHandler2.w(sb2.toString(), (String) syncPurchasesHelper$syncPurchases$3$invoke$$inlined$log$1.invoke());
                    }
                    break;
                case m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                    logLevel2 = LogLevel.WARN;
                    currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        sb2 = new StringBuilder();
                        sb2.append("[Purchases] - ");
                        sb2.append(logLevel2.name());
                        currentLogHandler2.w(sb2.toString(), (String) syncPurchasesHelper$syncPurchases$3$invoke$$inlined$log$1.invoke());
                    }
                    break;
            }
            this.$handleError.invoke(it);
        }
    }

    public SyncPurchasesHelper(BillingAbstract billing, IdentityManager identityManager, CustomerInfoHelper customerInfoHelper, PostReceiptHelper postReceiptHelper, DiagnosticsTracker diagnosticsTracker, DateProvider dateProvider) {
        AbstractC2304t.f(billing, "billing");
        AbstractC2304t.f(identityManager, "identityManager");
        AbstractC2304t.f(customerInfoHelper, "customerInfoHelper");
        AbstractC2304t.f(postReceiptHelper, "postReceiptHelper");
        AbstractC2304t.f(dateProvider, "dateProvider");
        this.billing = billing;
        this.identityManager = identityManager;
        this.customerInfoHelper = customerInfoHelper;
        this.postReceiptHelper = postReceiptHelper;
        this.diagnosticsTrackerIfEnabled = diagnosticsTracker;
        this.dateProvider = dateProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void retrieveCustomerInfo(String appUserID, boolean appInBackground, boolean isRestore, final k onSuccess, final k onError) {
        CustomerInfoHelper.retrieveCustomerInfo$default(this.customerInfoHelper, appUserID, CacheFetchPolicy.CACHED_OR_FETCHED, appInBackground, isRestore, false, new ReceiveCustomerInfoCallback() { // from class: com.revenuecat.purchases.SyncPurchasesHelper.retrieveCustomerInfo.1
            @Override // com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
            public void onError(PurchasesError error) {
                AbstractC2304t.f(error, "error");
                onError.invoke(error);
            }

            @Override // com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
            public void onReceived(CustomerInfo customerInfo) {
                AbstractC2304t.f(customerInfo, "customerInfo");
                onSuccess.invoke(customerInfo);
            }
        }, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackSyncPurchasesResultIfNeeded(PurchasesError error, Date startTime) {
        PurchasesErrorCode code;
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker != null) {
            diagnosticsTracker.m78trackSyncPurchasesResultSxA4cEA((error == null || (code = error.getCode()) == null) ? null : Integer.valueOf(code.getCode()), error != null ? error.getMessage() : null, DurationExtensionsKt.between(W6.a.f9306b, startTime, this.dateProvider.getNow()));
        }
    }

    public final void syncPurchases(boolean isRestore, boolean appInBackground, k onSuccess, k onError) {
        LogLevel logLevel;
        LogHandler currentLogHandler;
        StringBuilder sb;
        LogLevel logLevel2;
        LogHandler currentLogHandler2;
        StringBuilder sb2;
        LogLevel logLevel3;
        LogHandler currentLogHandler3;
        StringBuilder sb3;
        AbstractC2304t.f(onSuccess, "onSuccess");
        AbstractC2304t.f(onError, "onError");
        LogIntent logIntent = LogIntent.DEBUG;
        SyncPurchasesHelper$syncPurchases$$inlined$log$1 syncPurchasesHelper$syncPurchases$$inlined$log$1 = new SyncPurchasesHelper$syncPurchases$$inlined$log$1(logIntent);
        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
            case 1:
                logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    sb = new StringBuilder();
                    sb.append("[Purchases] - ");
                    sb.append(logLevel.name());
                    currentLogHandler.d(sb.toString(), (String) syncPurchasesHelper$syncPurchases$$inlined$log$1.invoke());
                }
                break;
            case 2:
            case 6:
            case 12:
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) syncPurchasesHelper$syncPurchases$$inlined$log$1.invoke(), null);
                break;
            case 3:
                logLevel2 = LogLevel.WARN;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    sb2 = new StringBuilder();
                    sb2.append("[Purchases] - ");
                    sb2.append(logLevel2.name());
                    currentLogHandler2.w(sb2.toString(), (String) syncPurchasesHelper$syncPurchases$$inlined$log$1.invoke());
                }
                break;
            case 4:
                logLevel3 = LogLevel.INFO;
                currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    sb3 = new StringBuilder();
                    sb3.append("[Purchases] - ");
                    sb3.append(logLevel3.name());
                    currentLogHandler3.i(sb3.toString(), (String) syncPurchasesHelper$syncPurchases$$inlined$log$1.invoke());
                }
                break;
            case 5:
                logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    sb = new StringBuilder();
                    sb.append("[Purchases] - ");
                    sb.append(logLevel.name());
                    currentLogHandler.d(sb.toString(), (String) syncPurchasesHelper$syncPurchases$$inlined$log$1.invoke());
                }
                break;
            case 7:
                logLevel3 = LogLevel.INFO;
                currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    sb3 = new StringBuilder();
                    sb3.append("[Purchases] - ");
                    sb3.append(logLevel3.name());
                    currentLogHandler3.i(sb3.toString(), (String) syncPurchasesHelper$syncPurchases$$inlined$log$1.invoke());
                }
                break;
            case 8:
                logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    sb = new StringBuilder();
                    sb.append("[Purchases] - ");
                    sb.append(logLevel.name());
                    currentLogHandler.d(sb.toString(), (String) syncPurchasesHelper$syncPurchases$$inlined$log$1.invoke());
                }
                break;
            case 9:
                logLevel = LogLevel.DEBUG;
                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    sb = new StringBuilder();
                    sb.append("[Purchases] - ");
                    sb.append(logLevel.name());
                    currentLogHandler.d(sb.toString(), (String) syncPurchasesHelper$syncPurchases$$inlined$log$1.invoke());
                }
                break;
            case 10:
                logLevel2 = LogLevel.WARN;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    sb2 = new StringBuilder();
                    sb2.append("[Purchases] - ");
                    sb2.append(logLevel2.name());
                    currentLogHandler2.w(sb2.toString(), (String) syncPurchasesHelper$syncPurchases$$inlined$log$1.invoke());
                }
                break;
            case m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                logLevel2 = LogLevel.WARN;
                currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    sb2 = new StringBuilder();
                    sb2.append("[Purchases] - ");
                    sb2.append(logLevel2.name());
                    currentLogHandler2.w(sb2.toString(), (String) syncPurchasesHelper$syncPurchases$$inlined$log$1.invoke());
                }
                break;
        }
        Date now = this.dateProvider.getNow();
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker != null) {
            diagnosticsTracker.trackSyncPurchasesStarted();
        }
        String currentAppUserID = this.identityManager.getCurrentAppUserID();
        SyncPurchasesHelper$syncPurchases$handleSuccess$1 syncPurchasesHelper$syncPurchases$handleSuccess$1 = new SyncPurchasesHelper$syncPurchases$handleSuccess$1(this, now, onSuccess);
        SyncPurchasesHelper$syncPurchases$handleError$1 syncPurchasesHelper$syncPurchases$handleError$1 = new SyncPurchasesHelper$syncPurchases$handleError$1(this, now, onError);
        this.billing.queryAllPurchases(currentAppUserID, new AnonymousClass2(currentAppUserID, appInBackground, isRestore, syncPurchasesHelper$syncPurchases$handleSuccess$1, syncPurchasesHelper$syncPurchases$handleError$1), new AnonymousClass3(syncPurchasesHelper$syncPurchases$handleError$1));
    }

    public /* synthetic */ SyncPurchasesHelper(BillingAbstract billingAbstract, IdentityManager identityManager, CustomerInfoHelper customerInfoHelper, PostReceiptHelper postReceiptHelper, DiagnosticsTracker diagnosticsTracker, DateProvider dateProvider, int i8, AbstractC2296k abstractC2296k) {
        this(billingAbstract, identityManager, customerInfoHelper, postReceiptHelper, diagnosticsTracker, (i8 & 32) != 0 ? new DefaultDateProvider() : dateProvider);
    }
}
