package com.revenuecat.purchases;

import Y0.InterfaceC0717c;
import android.os.Handler;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.google.BillingResultExtensionsKt;
import com.revenuecat.purchases.interfaces.Callback;
import com.revenuecat.purchases.models.BillingFeature;
import com.revenuecat.purchases.strings.PurchaseStrings;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class PurchasesOrchestrator$Companion$canMakePayments$2$1 implements InterfaceC0717c {
    final /* synthetic */ com.android.billingclient.api.a $billingClient;
    final /* synthetic */ Callback<Boolean> $callback;
    final /* synthetic */ List<BillingFeature> $features;
    final /* synthetic */ AtomicBoolean $hasResponded;
    final /* synthetic */ Handler $mainHandler;

    /* JADX WARN: Multi-variable type inference failed */
    public PurchasesOrchestrator$Companion$canMakePayments$2$1(Handler handler, AtomicBoolean atomicBoolean, Callback<Boolean> callback, com.android.billingclient.api.a aVar, List<? extends BillingFeature> list) {
        this.$mainHandler = handler;
        this.$hasResponded = atomicBoolean;
        this.$callback = callback;
        this.$billingClient = aVar;
        this.$features = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void onBillingServiceDisconnected$lambda$2(com.android.billingclient.api.a r4, java.util.concurrent.atomic.AtomicBoolean r5, com.revenuecat.purchases.interfaces.Callback r6) {
        /*
            java.lang.String r0 = "Callback has already been called when checking if device can make payments."
            java.lang.String r1 = "$billingClient"
            kotlin.jvm.internal.r.f(r4, r1)
            java.lang.String r1 = "$hasResponded"
            kotlin.jvm.internal.r.f(r5, r1)
            java.lang.String r1 = "$callback"
            kotlin.jvm.internal.r.f(r6, r1)
            r1 = 1
            r4.c()     // Catch: java.lang.Throwable -> L27 java.lang.IllegalArgumentException -> L29
            boolean r4 = r5.getAndSet(r1)
            if (r4 == 0) goto L21
        L1b:
            com.revenuecat.purchases.common.LogIntent r4 = com.revenuecat.purchases.common.LogIntent.GOOGLE_ERROR
            com.revenuecat.purchases.common.LogWrapperKt.log(r4, r0)
            goto L4d
        L21:
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            r6.onReceived(r4)
            goto L4d
        L27:
            r4 = move-exception
            goto L4e
        L29:
            r4 = move-exception
            com.revenuecat.purchases.common.LogIntent r2 = com.revenuecat.purchases.common.LogIntent.GOOGLE_ERROR     // Catch: java.lang.Throwable -> L27
            java.lang.String r3 = "Exception received when checking if device can make payments: \n%s."
            java.lang.String r4 = r4.getLocalizedMessage()     // Catch: java.lang.Throwable -> L27
            java.lang.Object[] r4 = new java.lang.Object[]{r4}     // Catch: java.lang.Throwable -> L27
            java.lang.Object[] r4 = java.util.Arrays.copyOf(r4, r1)     // Catch: java.lang.Throwable -> L27
            java.lang.String r4 = java.lang.String.format(r3, r4)     // Catch: java.lang.Throwable -> L27
            java.lang.String r3 = "format(this, *args)"
            kotlin.jvm.internal.r.e(r4, r3)     // Catch: java.lang.Throwable -> L27
            com.revenuecat.purchases.common.LogWrapperKt.log(r2, r4)     // Catch: java.lang.Throwable -> L27
            boolean r4 = r5.getAndSet(r1)
            if (r4 == 0) goto L21
            goto L1b
        L4d:
            return
        L4e:
            boolean r5 = r5.getAndSet(r1)
            if (r5 == 0) goto L5a
            com.revenuecat.purchases.common.LogIntent r5 = com.revenuecat.purchases.common.LogIntent.GOOGLE_ERROR
            com.revenuecat.purchases.common.LogWrapperKt.log(r5, r0)
            goto L5f
        L5a:
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            r6.onReceived(r5)
        L5f:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.PurchasesOrchestrator$Companion$canMakePayments$2$1.onBillingServiceDisconnected$lambda$2(com.android.billingclient.api.a, java.util.concurrent.atomic.AtomicBoolean, com.revenuecat.purchases.interfaces.Callback):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBillingSetupFinished$lambda$1(AtomicBoolean hasResponded, com.android.billingclient.api.d billingResult, Callback callback, com.android.billingclient.api.a billingClient, List features) {
        boolean z7;
        r.f(hasResponded, "$hasResponded");
        r.f(billingResult, "$billingResult");
        r.f(callback, "$callback");
        r.f(billingClient, "$billingClient");
        r.f(features, "$features");
        if (hasResponded.getAndSet(true)) {
            LogIntent logIntent = LogIntent.GOOGLE_ERROR;
            String str = String.format(PurchaseStrings.EXTRA_CONNECTION_CANMAKEPAYMENTS, Arrays.copyOf(new Object[]{Integer.valueOf(billingResult.b())}, 1));
            r.e(str, "format(this, *args)");
            LogWrapperKt.log(logIntent, str);
            return;
        }
        try {
            if (!BillingResultExtensionsKt.isSuccessful(billingResult)) {
                callback.onReceived(Boolean.FALSE);
                billingClient.c();
                return;
            }
            if (features == null || !features.isEmpty()) {
                Iterator it = features.iterator();
                while (it.hasNext()) {
                    com.android.billingclient.api.d dVarE = billingClient.e(((BillingFeature) it.next()).getPlayBillingClientName());
                    r.e(dVarE, "billingClient.isFeatureS…it.playBillingClientName)");
                    if (!BillingResultExtensionsKt.isSuccessful(dVarE)) {
                        z7 = false;
                        break;
                    }
                }
                z7 = true;
            } else {
                z7 = true;
            }
            billingClient.c();
            callback.onReceived(Boolean.valueOf(z7));
        } catch (IllegalArgumentException e7) {
            LogIntent logIntent2 = LogIntent.GOOGLE_ERROR;
            String str2 = String.format(PurchaseStrings.EXCEPTION_CANMAKEPAYMENTS, Arrays.copyOf(new Object[]{e7.getLocalizedMessage()}, 1));
            r.e(str2, "format(this, *args)");
            LogWrapperKt.log(logIntent2, str2);
            callback.onReceived(Boolean.FALSE);
        }
    }

    @Override // Y0.InterfaceC0717c
    public void onBillingServiceDisconnected() {
        Handler handler = this.$mainHandler;
        final com.android.billingclient.api.a aVar = this.$billingClient;
        final AtomicBoolean atomicBoolean = this.$hasResponded;
        final Callback<Boolean> callback = this.$callback;
        handler.post(new Runnable() { // from class: com.revenuecat.purchases.h
            @Override // java.lang.Runnable
            public final void run() {
                PurchasesOrchestrator$Companion$canMakePayments$2$1.onBillingServiceDisconnected$lambda$2(aVar, atomicBoolean, callback);
            }
        });
    }

    @Override // Y0.InterfaceC0717c
    public void onBillingSetupFinished(final com.android.billingclient.api.d billingResult) {
        r.f(billingResult, "billingResult");
        Handler handler = this.$mainHandler;
        final AtomicBoolean atomicBoolean = this.$hasResponded;
        final Callback<Boolean> callback = this.$callback;
        final com.android.billingclient.api.a aVar = this.$billingClient;
        final List<BillingFeature> list = this.$features;
        handler.post(new Runnable() { // from class: com.revenuecat.purchases.i
            @Override // java.lang.Runnable
            public final void run() {
                PurchasesOrchestrator$Companion$canMakePayments$2$1.onBillingSetupFinished$lambda$1(atomicBoolean, billingResult, callback, aVar, list);
            }
        });
    }
}
