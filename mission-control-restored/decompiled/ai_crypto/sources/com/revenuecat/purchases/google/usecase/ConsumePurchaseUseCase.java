package com.revenuecat.purchases.google.usecase;

import E5.E;
import E5.m;
import Q5.k;
import Q5.o;
import Y0.C0723f;
import Y0.InterfaceC0725g;
import com.revenuecat.purchases.PostReceiptInitiationSource;
import com.revenuecat.purchases.google.usecase.ConsumePurchaseUseCase;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes2.dex */
public final class ConsumePurchaseUseCase extends BillingClientUseCase<String> {
    private final k onError;
    private final k onReceive;
    private final ConsumePurchaseUseCaseParams useCaseParams;
    private final k withConnectedClient;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PostReceiptInitiationSource.values().length];
            try {
                iArr[PostReceiptInitiationSource.RESTORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PostReceiptInitiationSource.PURCHASE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PostReceiptInitiationSource.UNSYNCED_ACTIVE_PURCHASES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.google.usecase.ConsumePurchaseUseCase$executeAsync$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements k {
        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(ConsumePurchaseUseCase this$0, com.android.billingclient.api.d billingResult, String purchaseToken) {
            r.f(this$0, "this$0");
            r.f(billingResult, "billingResult");
            r.f(purchaseToken, "purchaseToken");
            BillingClientUseCase.processResult$default(this$0, billingResult, purchaseToken, null, new ConsumePurchaseUseCase$executeAsync$1$1$1(this$0), 4, null);
        }

        @Override // Q5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((com.android.billingclient.api.a) obj);
            return E.f1657a;
        }

        public final void invoke(com.android.billingclient.api.a invoke) {
            r.f(invoke, "$this$invoke");
            C0723f c0723fA = C0723f.b().b(ConsumePurchaseUseCase.this.useCaseParams.getPurchaseToken()).a();
            r.e(c0723fA, "newBuilder()\n           …\n                .build()");
            final ConsumePurchaseUseCase consumePurchaseUseCase = ConsumePurchaseUseCase.this;
            invoke.b(c0723fA, new InterfaceC0725g() { // from class: com.revenuecat.purchases.google.usecase.b
                @Override // Y0.InterfaceC0725g
                public final void a(com.android.billingclient.api.d dVar, String str) {
                    ConsumePurchaseUseCase.AnonymousClass1.invoke$lambda$0(consumePurchaseUseCase, dVar, str);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumePurchaseUseCase(ConsumePurchaseUseCaseParams useCaseParams, k onReceive, k onError, k withConnectedClient, o executeRequestOnUIThread) {
        super(useCaseParams, onError, executeRequestOnUIThread);
        r.f(useCaseParams, "useCaseParams");
        r.f(onReceive, "onReceive");
        r.f(onError, "onError");
        r.f(withConnectedClient, "withConnectedClient");
        r.f(executeRequestOnUIThread, "executeRequestOnUIThread");
        this.useCaseParams = useCaseParams;
        this.onReceive = onReceive;
        this.onError = onError;
        this.withConnectedClient = withConnectedClient;
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public void executeAsync() {
        this.withConnectedClient.invoke(new AnonymousClass1());
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public boolean getBackoffForNetworkErrors() {
        int i7 = WhenMappings.$EnumSwitchMapping$0[this.useCaseParams.getInitiationSource().ordinal()];
        if (i7 == 1 || i7 == 2) {
            return false;
        }
        if (i7 == 3) {
            return true;
        }
        throw new m();
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public String getErrorMessage() {
        return "Error consuming purchase";
    }

    public final k getOnError() {
        return this.onError;
    }

    public final k getOnReceive() {
        return this.onReceive;
    }

    public final k getWithConnectedClient() {
        return this.withConnectedClient;
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public void onOk(String received) {
        r.f(received, "received");
        this.onReceive.invoke(received);
    }
}
