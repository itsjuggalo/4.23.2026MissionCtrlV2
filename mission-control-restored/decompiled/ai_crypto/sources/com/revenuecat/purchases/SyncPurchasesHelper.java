package com.revenuecat.purchases;

import E5.E;
import F5.v;
import Q5.k;
import a6.C0929a;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.DurationExtensionsKt;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
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
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class SyncPurchasesHelper {
    private final BillingAbstract billing;
    private final CustomerInfoHelper customerInfoHelper;
    private final DateProvider dateProvider;
    private final DiagnosticsTracker diagnosticsTrackerIfEnabled;
    private final IdentityManager identityManager;
    private final PostReceiptHelper postReceiptHelper;

    /* JADX INFO: renamed from: com.revenuecat.purchases.SyncPurchasesHelper$syncPurchases$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13031 extends s implements k {
        final /* synthetic */ boolean $appInBackground;
        final /* synthetic */ String $appUserID;
        final /* synthetic */ k $handleError;
        final /* synthetic */ k $handleSuccess;
        final /* synthetic */ boolean $isRestore;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13031(String str, boolean z7, boolean z8, k kVar, k kVar2) {
            super(1);
            this.$appUserID = str;
            this.$appInBackground = z7;
            this.$isRestore = z8;
            this.$handleSuccess = kVar;
            this.$handleError = kVar2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$handleLastPurchase(List<PurchasesError> list, SyncPurchasesHelper syncPurchasesHelper, String str, boolean z7, boolean z8, k kVar, k kVar2, StoreTransaction storeTransaction, StoreTransaction storeTransaction2) {
            if (r.b(storeTransaction, storeTransaction2)) {
                if (list.isEmpty()) {
                    LogUtilsKt.debugLog(PurchaseStrings.SYNCED_PURCHASES_SUCCESSFULLY);
                    syncPurchasesHelper.retrieveCustomerInfo(str, z7, z8, kVar, kVar2);
                } else {
                    String str2 = String.format(PurchaseStrings.SYNCING_PURCHASES_ERROR, Arrays.copyOf(new Object[]{list}, 1));
                    r.e(str2, "format(this, *args)");
                    LogUtilsKt.errorLog$default(str2, null, 2, null);
                    kVar2.invoke(v.I(list));
                }
            }
        }

        @Override // Q5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((List<StoreTransaction>) obj);
            return E.f1657a;
        }

        public final void invoke(List<StoreTransaction> allPurchases) {
            r.f(allPurchases, "allPurchases");
            if (allPurchases.isEmpty()) {
                SyncPurchasesHelper.this.retrieveCustomerInfo(this.$appUserID, this.$appInBackground, this.$isRestore, this.$handleSuccess, this.$handleError);
                return;
            }
            StoreTransaction storeTransaction = (StoreTransaction) v.S(allPurchases);
            ArrayList arrayList = new ArrayList();
            SyncPurchasesHelper syncPurchasesHelper = SyncPurchasesHelper.this;
            boolean z7 = this.$isRestore;
            String str = this.$appUserID;
            boolean z8 = this.$appInBackground;
            k kVar = this.$handleSuccess;
            k kVar2 = this.$handleError;
            for (StoreTransaction storeTransaction2 : allPurchases) {
                ReceiptInfo receiptInfo = new ReceiptInfo(storeTransaction2.getProductIds(), null, null, null, null, null, null, 126, null);
                k kVar3 = kVar2;
                boolean z9 = z8;
                syncPurchasesHelper.postReceiptHelper.postTokenWithoutConsuming(storeTransaction2.getPurchaseToken(), storeTransaction2.getStoreUserID(), receiptInfo, z7, str, storeTransaction2.getMarketplace(), PostReceiptInitiationSource.RESTORE, new SyncPurchasesHelper$syncPurchases$1$1$1(storeTransaction2, storeTransaction, arrayList, syncPurchasesHelper, str, z8, z7, kVar, kVar3), new SyncPurchasesHelper$syncPurchases$1$1$2(storeTransaction2, arrayList, storeTransaction, syncPurchasesHelper, str, z9, z7, kVar, kVar3));
                kVar2 = kVar3;
                kVar = kVar;
                z8 = z9;
            }
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.SyncPurchasesHelper$syncPurchases$2, reason: invalid class name */
    public static final class AnonymousClass2 extends s implements k {
        final /* synthetic */ k $handleError;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(k kVar) {
            super(1);
            this.$handleError = kVar;
        }

        @Override // Q5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return E.f1657a;
        }

        public final void invoke(PurchasesError it) {
            r.f(it, "it");
            LogIntent logIntent = LogIntent.RC_ERROR;
            String str = String.format(PurchaseStrings.SYNCING_PURCHASES_ERROR, Arrays.copyOf(new Object[]{it}, 1));
            r.e(str, "format(this, *args)");
            LogWrapperKt.log(logIntent, str);
            this.$handleError.invoke(it);
        }
    }

    public SyncPurchasesHelper(BillingAbstract billing, IdentityManager identityManager, CustomerInfoHelper customerInfoHelper, PostReceiptHelper postReceiptHelper, DiagnosticsTracker diagnosticsTracker, DateProvider dateProvider) {
        r.f(billing, "billing");
        r.f(identityManager, "identityManager");
        r.f(customerInfoHelper, "customerInfoHelper");
        r.f(postReceiptHelper, "postReceiptHelper");
        r.f(dateProvider, "dateProvider");
        this.billing = billing;
        this.identityManager = identityManager;
        this.customerInfoHelper = customerInfoHelper;
        this.postReceiptHelper = postReceiptHelper;
        this.diagnosticsTrackerIfEnabled = diagnosticsTracker;
        this.dateProvider = dateProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void retrieveCustomerInfo(String str, boolean z7, boolean z8, final k kVar, final k kVar2) {
        CustomerInfoHelper.retrieveCustomerInfo$default(this.customerInfoHelper, str, CacheFetchPolicy.CACHED_OR_FETCHED, z7, z8, false, new ReceiveCustomerInfoCallback() { // from class: com.revenuecat.purchases.SyncPurchasesHelper.retrieveCustomerInfo.1
            @Override // com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
            public void onError(PurchasesError error) {
                r.f(error, "error");
                kVar2.invoke(error);
            }

            @Override // com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
            public void onReceived(CustomerInfo customerInfo) {
                r.f(customerInfo, "customerInfo");
                kVar.invoke(customerInfo);
            }
        }, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackSyncPurchasesResultIfNeeded(PurchasesError purchasesError, Date date) {
        PurchasesErrorCode code;
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker != null) {
            diagnosticsTracker.m82trackSyncPurchasesResultSxA4cEA((purchasesError == null || (code = purchasesError.getCode()) == null) ? null : Integer.valueOf(code.getCode()), purchasesError != null ? purchasesError.getMessage() : null, DurationExtensionsKt.between(C0929a.f6400b, date, this.dateProvider.getNow()));
        }
    }

    public final void syncPurchases(boolean z7, boolean z8, k onSuccess, k onError) {
        r.f(onSuccess, "onSuccess");
        r.f(onError, "onError");
        LogWrapperKt.log(LogIntent.DEBUG, PurchaseStrings.SYNCING_PURCHASES);
        Date now = this.dateProvider.getNow();
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        if (diagnosticsTracker != null) {
            diagnosticsTracker.trackSyncPurchasesStarted();
        }
        String currentAppUserID = this.identityManager.getCurrentAppUserID();
        SyncPurchasesHelper$syncPurchases$handleSuccess$1 syncPurchasesHelper$syncPurchases$handleSuccess$1 = new SyncPurchasesHelper$syncPurchases$handleSuccess$1(this, now, onSuccess);
        SyncPurchasesHelper$syncPurchases$handleError$1 syncPurchasesHelper$syncPurchases$handleError$1 = new SyncPurchasesHelper$syncPurchases$handleError$1(this, now, onError);
        this.billing.queryAllPurchases(currentAppUserID, new C13031(currentAppUserID, z8, z7, syncPurchasesHelper$syncPurchases$handleSuccess$1, syncPurchasesHelper$syncPurchases$handleError$1), new AnonymousClass2(syncPurchasesHelper$syncPurchases$handleError$1));
    }

    public /* synthetic */ SyncPurchasesHelper(BillingAbstract billingAbstract, IdentityManager identityManager, CustomerInfoHelper customerInfoHelper, PostReceiptHelper postReceiptHelper, DiagnosticsTracker diagnosticsTracker, DateProvider dateProvider, int i7, AbstractC2148j abstractC2148j) {
        this(billingAbstract, identityManager, customerInfoHelper, postReceiptHelper, diagnosticsTracker, (i7 & 32) != 0 ? new DefaultDateProvider() : dateProvider);
    }
}
